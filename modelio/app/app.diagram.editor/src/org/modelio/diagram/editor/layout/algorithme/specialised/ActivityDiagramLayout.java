/*
 * Copyright 2013-2025 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.modelio.diagram.editor.layout.algorithme.specialised;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkNode;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.ICompositeLayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.elk.IElkLayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.elk.utils.ElkModelUtils;
import org.modelio.diagram.editor.layout.algorithme.standard.LayeredLayout;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.diagrams.ActivityDiagram;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * ActivityDiagramLayout is a specialized layout algorithm for activity
 * diagrams. It extends the ICompositeLayoutAlgorithme to provide specific
 * configurations for activity diagrams.
 */
@objid ("78a3c795-81e7-4199-bb70-f6e7074403da")
public class ActivityDiagramLayout implements ICompositeLayoutAlgorithme {
    /**
     * The simple layered layout used when there are no lanes in the activity
     * diagram.
     */
    @objid ("160e186c-5f5f-48e9-a202-01947d0d9e6b")
    protected IElkLayoutAlgorithme simpleLayeredLayout;

    /**
     * A map that holds the sub-layout data for each ActivityPartition in the
     * diagram.
     */
    @objid ("d99d82f5-c5ba-4da2-8044-8f7592d00e7c")
    protected Map<ActivityPartition, SubLayoutData> sublayoutMap = new HashMap<>();

    /**
     * The activity diagram to be laid out.
     */
    @objid ("159e7fb8-e9bd-4bab-a94b-156637da2a0d")
    protected ActivityDiagram diagram;

    /**
     * The diagram service used to handle diagram operations.
     */
    @objid ("39e1466a-5d36-4e1c-a0e4-e4f824aee4ff")
    protected IDiagramService diagramService;

    /**
     * The selection of diagram nodes to be considered for layout.
     */
    @objid ("e8ac1603-bd8e-411d-87cd-e2dcd2478668")
    protected List<IDiagramNode> selection = null;

    @objid ("6fed0337-f502-4ccf-b6f6-6aff57eb70c8")
    public ActivityDiagramLayout() {

    }

    @objid ("a729b1c1-f9c1-46c4-8a2e-879f81bd4aef")
    @Override
    public ILayoutAlgorithme withDiagram(AbstractDiagram diagram, IDiagramService diagramService) {
        if (!(diagram instanceof ActivityDiagram)) {
            throw new IllegalArgumentException("The diagram must be an instance of ActivityDiagram.");
        }

        this.diagram = (ActivityDiagram) diagram;
        this.diagramService = diagramService;
        return this;
    }

    @objid ("554c6c9d-d32a-4f74-9de6-69fb37ad0e7f")
    @Override
    public ILayoutAlgorithme withSelection(List<IDiagramNode> selection) {
        this.selection = selection;
        return this;
    }

    @objid ("d708b30c-14b3-4bea-9819-5d2c8db5d29e")
    @Override
    public void runLayout() {
        // If the is no lane , apply the simple layered layout
        List<ILayoutAlgorithme> subLayoutAlgorithmes = getSubLayoutAlgorithmes();
        if (subLayoutAlgorithmes.isEmpty()) {
            this.simpleLayeredLayout = (IElkLayoutAlgorithme) new LayeredLayout().withDiagram(this.diagram, this.diagramService);
            this.simpleLayeredLayout.runLayout();
            return;
        }

        // Execute sub layouts on each lane
        int minDimension = 800;
        for (SubLayoutData layoutData : sublayoutMap.values()) {
            layoutData.layoutAlgorithme.runLayout();
            layoutData.layoutAlgorithme.compactDiagramBounds(50);

            // Calculate the minimum size of the lanes
            ElkNode elkRootNode = ((LayeredLayout) layoutData.layoutAlgorithme).getElkRootNode();
            if (elkRootNode.getWidth() > minDimension) {
                minDimension = (int) elkRootNode.getWidth() + 100;
            }

            // Associate the Elk Nodes and links to ModelElements
            ((LayeredLayout) layoutData.layoutAlgorithme).getElkNodes().forEach((key, value) -> {
                layoutData.elementByElkElement.put(value, key.getElement());
            });

            ((LayeredLayout) layoutData.layoutAlgorithme).getElKLinks().forEach((key, value) -> {
                layoutData.compositeElkEdgeMap.put(value.get(0), value);
                layoutData.linkByElkEdge.put(value.get(0), key.getElement());
            });
        }

        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {

            List<MObject> allLinks = new ArrayList<>();
            allLinks.addAll(handle.getDiagramNode().getLinks().stream().map(link -> link.getElement()).toList());

            // Mask Elements except ActivityPartitions
            maskAll(handle, handle.getDiagramNode());

            // Layout the lanes
            setLaneContainerHiererchyBounds(handle.getDiagramNode(), minDimension);

            // Unmask and layout the content of each lane
            sublayoutMap.entrySet().forEach(subLayoutData -> {
                unmaskLaneContent(handle, subLayoutData.getKey(), subLayoutData.getValue());
            });

            // Unmask Inter Lanes Links

            allLinks.stream().filter(link -> handle.getDiagramGraphics(link).isEmpty()).forEach(link -> {
                handle.unmask(link, 0, 0);
            });

            handle.save();
        }

        for (SubLayoutData layoutData : sublayoutMap.values()) {
            layoutData.layoutAlgorithme.postProcessing();
        }
    }

    /**
     * Mask all nodes in the diagram, except for ActivityPartitions. This is used to
     * prepare the diagram for layout by hiding all elements initially.
     *
     * @param handle The diagram handle used to manipulate the diagram.
     * @param diagramDg The diagram node containing the elements to be masked.
     */
    @objid ("512826c6-b86d-40b1-8be9-08270cb8502c")
    private void maskAll(IDiagramHandle handle, IDiagramNode diagramDg) {
        diagramDg.getNodes().forEach(node -> {
            maskAll(handle, node);
        });

        if (!(diagramDg.getElement() instanceof ActivityPartition)) {
            diagramDg.mask();
        }
    }

    /**
     * Unmask the content of a lane in the activity diagram. This method retrieves
     * the lane from the partition and applies the layout to its content.
     *
     * @param handle The diagram handle used to manipulate the diagram.
     * @param partition The ActivityPartition representing the lane.
     * @param subLayoutData The layout data containing the algorithm and mappings
     * for elements and links.
     */
    @objid ("af7d7b4f-135a-420c-b492-f01108cb3d87")
    private void unmaskLaneContent(IDiagramHandle handle, ActivityPartition partition, SubLayoutData subLayoutData) {
        // Get the lane from the partition
        List<IDiagramGraphic> graphs = handle.getDiagramGraphics(partition);
        if (graphs.isEmpty() || !(graphs.get(0) instanceof IDiagramNode)) {
            return; // No lane found for this partition
        }
        IDiagramNode lane = (IDiagramNode) graphs.get(0);

        // Calculate a Rectangle base on the bounds of the elk root note in the middle
        // of the lane
        // The goals is to identify a sub bouds on the middle of the lane
        int elkContainerHeight = (int) subLayoutData.layoutAlgorithme.getElkRootNode().getHeight();
        int elkContainerWidth = (int) subLayoutData.layoutAlgorithme.getElkRootNode().getWidth();

        Point translation = new Point(lane.getBounds().x + (lane.getBounds().width - elkContainerWidth) / 2, lane.getBounds().y + (lane.getBounds().height - elkContainerHeight) / 2);

        unmaskElementsRecursivly(handle, subLayoutData.layoutAlgorithme.getElkRootNode(), subLayoutData, translation);
        unmaskLinksRecursivly(handle, subLayoutData.layoutAlgorithme.getElkRootNode(), subLayoutData, translation);
    }

    /**
     * Unmask elements recursively in the diagram, starting from the given ElkNode.
     * This method unmask nodes and sets their bounds based on the translation
     * point.
     *
     * @param handle The diagram handle used to manipulate the diagram.
     * @param elkNode The ElkNode from which to start unmasking elements.
     * @param subLayoutData The layout data containing the mappings for elements and
     * links.
     * @param translation The translation point to apply to the bounds of the
     * unmasked elements.
     */
    @objid ("01e7e493-6347-4409-800c-afd0014f5cd1")
    private void unmaskElementsRecursivly(IDiagramHandle handle, ElkNode elkNode, SubLayoutData subLayoutData, Point translation) {
        elkNode.getChildren().forEach(elkChildren -> {
            if (elkChildren instanceof ElkConnectableShape) {

                // Unmask the node and set its bounds
                MObject element = subLayoutData.elementByElkElement.get(elkChildren);
                List<IDiagramGraphic> nodesDg = handle.unmask(element, translation.x, translation.y);
                if (!nodesDg.isEmpty() && nodesDg.get(0) instanceof IDiagramNode) {
                    ((IDiagramNode) nodesDg.get(0)).setBounds(translateToBounds(translation, elkChildren));
                }

                // Unmask childrens Recursively
                if (!elkChildren.getChildren().isEmpty()) {
                    Point newTranslation = new Point(translation.x + (int) elkChildren.getX(), translation.y + (int) elkChildren.getY());
                    unmaskElementsRecursivly(handle, elkChildren, subLayoutData, newTranslation);
                }
            }
        });
    }

    /**
     * Unmask links recursively in the diagram, starting from the given ElkNode.
     * This method unmask links and updates their paths based on the translation
     * point.
     *
     * @param handle The diagram handle used to manipulate the diagram.
     * @param elkNode The ElkNode from which to start unmasking links.
     * @param subLayoutData The layout data containing the mappings for elements and
     * links.
     * @param translation The translation point to apply to the paths of the
     * unmasked links.
     */
    @objid ("3e6d792c-4f83-47b1-aa1e-75567d3cd1fb")
    private void unmaskLinksRecursivly(IDiagramHandle handle, ElkNode elkNode, SubLayoutData subLayoutData, Point translation) {
        elkNode.getChildren().forEach(elkChildren -> {
            if (elkChildren instanceof ElkConnectableShape) {

                for (ElkEdge inEdge : elkChildren.getIncomingEdges()) {
                    MObject link = subLayoutData.linkByElkEdge.get(inEdge);
                    List<IDiagramGraphic> linksDg = handle.unmask(link, translation.x, translation.y);
                    if (!linksDg.isEmpty() && linksDg.get(0) instanceof IDiagramLink) {
                        ILinkPath path = ((IDiagramLink) linksDg.get(0)).getPath();
                        ElkModelUtils.updateLinkPath(subLayoutData.compositeElkEdgeMap.get(inEdge), path, translation);
                        ((IDiagramLink) linksDg.get(0)).setPath(path);
                    }
                }

                for (ElkEdge outEdge : elkChildren.getOutgoingEdges()) {
                    MObject link = subLayoutData.linkByElkEdge.get(outEdge);
                    List<IDiagramGraphic> linksDg = handle.unmask(link, translation.x, translation.y);
                    if (!linksDg.isEmpty() && linksDg.get(0) instanceof IDiagramLink) {
                        ILinkPath path = ((IDiagramLink) linksDg.get(0)).getPath();
                        ElkModelUtils.updateLinkPath(subLayoutData.compositeElkEdgeMap.get(outEdge), path, translation);
                        ((IDiagramLink) linksDg.get(0)).setPath(path);
                    }
                }

                // Unmask childrens Recursively
                if (!elkChildren.getChildren().isEmpty()) {
                    // Point newTranslation = new Point(translation.x + (int) elkChildren.getX(),
                    // translation.y + (int) elkChildren.getY());
                    unmaskLinksRecursivly(handle, elkChildren, subLayoutData, translation);
                }
            }

        });
    }

    /**
     * Translate the ElkConnectableShape bounds to a Rectangle using the translation
     * point. This is used to set the bounds of the unmasked nodes in the diagram.
     *
     * @param transltation The translation point to apply to the ElkConnectableShape
     * bounds.
     * @param elkNode The ElkConnectableShape whose bounds are to be
     * translated.
     * @return A Rectangle representing the translated bounds of the
     * ElkConnectableShape.
     */
    @objid ("3d919f57-8d9e-4c91-8231-e57153d4a573")
    private Rectangle translateToBounds(Point transltation, ElkConnectableShape elkNode) {
        int x = (int) (transltation.x + elkNode.getX());
        int y = (int) (transltation.y + elkNode.getY());
        int width = (int) elkNode.getWidth();
        int height = (int) elkNode.getHeight();
        return new Rectangle(x, y, width, height);
    }

    @objid ("01b14db5-741b-4789-aded-e9ff994e7a6c")
    @Override
    public void postProcessing() {
        if (this.simpleLayeredLayout != null) {
            this.simpleLayeredLayout.postProcessing();
        }

        // Layout Links Between 2 Lanes
        int deltaT = 1;
        int deltaB = 1;
        // Layout Links Between 2 Lanes
        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {
            for (IDiagramLink link : handle.getDiagramNode().getLinks()) {
                if (link.getFrom().getElement() instanceof ActivityNode && link.getTo().getElement() instanceof ActivityNode) {

                    IDiagramNode fromNodeDg = (IDiagramNode) link.getFrom();
                    IDiagramNode toNodeDg = (IDiagramNode) link.getTo();

                    IDiagramNode topNodeDg = fromNodeDg.getBounds().y < toNodeDg.getBounds().y ? fromNodeDg : toNodeDg;
                    IDiagramNode bottomNodeDg = fromNodeDg.getBounds().y < toNodeDg.getBounds().y ? toNodeDg : fromNodeDg;
                    IDiagramNode leftNodeDg = fromNodeDg.getBounds().x < toNodeDg.getBounds().x ? fromNodeDg : toNodeDg;

                    ActivityPartition topPartition = getActivityPartition((ActivityNode)topNodeDg.getElement());
                    ActivityPartition bottomPartition = getActivityPartition((ActivityNode)bottomNodeDg.getElement());

                    if (topPartition == null || bottomPartition == null || topPartition.equals(bottomPartition)) {
                        // If the link is between 2 elements in the same lane, we do not need to layout
                        // it
                        continue;
                    }


                    // Find Partition Border Y
                    List<IDiagramGraphic> fromNodePartition = handle.getDiagramGraphics(topPartition);
                    IDiagramNode fromNodePartitionDg = (IDiagramNode) fromNodePartition.get(0);
                    int partitionBorderY = fromNodePartitionDg.getBounds().y + fromNodePartitionDg.getBounds().height;


                    // First Point
                    List<Point> newPath = new ArrayList<>();
                    if (topNodeDg.equals(fromNodeDg)) {
                        if (leftNodeDg.equals(fromNodeDg)) {
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), fromNodeDg.getBounds().y + fromNodeDg.getBounds().height));
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), partitionBorderY - (deltaT * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), partitionBorderY - (deltaT * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), fromNodeDg.getBounds().y));
                        } else {
                            newPath.add(new Point(fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25, (int) (fromNodeDg.getBounds().y + fromNodeDg.getBounds().height)));
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), partitionBorderY - (deltaT * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), partitionBorderY - (deltaT * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), fromNodeDg.getBounds().y));
                        }
                        deltaT++;
                    } else {
                        if (leftNodeDg.equals(fromNodeDg)) {
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), fromNodeDg.getBounds().y));
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), partitionBorderY + (deltaB * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), partitionBorderY + (deltaB * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), fromNodeDg.getBounds().y + fromNodeDg.getBounds().height));
                        } else {
                            newPath.add(new Point(fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25, (int) (fromNodeDg.getBounds().y)));
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), partitionBorderY + (deltaB * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), partitionBorderY + (deltaB * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), fromNodeDg.getBounds().y + fromNodeDg.getBounds().height));
                        }
                        deltaB++;

                    }
                    link.setPath(newPath);

                }
            }
            handle.save();
        }
    }

    @objid ("4a2314f0-7998-4a4a-bc98-172c6c05e04a")
    private ActivityPartition getActivityPartition(ActivityNode fromNode) {
        if(fromNode.getOwnerPartition() != null) {
            return  fromNode.getOwnerPartition();
        }

        if(fromNode.getOwnerNode() != null) {
            return getActivityPartition(fromNode.getOwnerNode());
        }

        return null;
    }

    @objid ("a5cb9cd0-fd84-4842-b43f-209ab9df29e5")
    @Override
    public void compactDiagramBounds(int PADDING) {
        if (this.simpleLayeredLayout != null) {
            this.simpleLayeredLayout.compactDiagramBounds(PADDING);
            return;
        }
    }

    @objid ("ad54e1cd-84a2-47b9-b2b8-ce54bee8ccf5")
    @Override
    public List<IDiagramNode> getSelection() {
        return this.selection;
    }

    @objid ("66742149-7100-411f-b689-0d81ca41b2fc")
    @Override
    public List<ILayoutAlgorithme> getSubLayoutAlgorithmes() {
        if (this.diagram == null || this.diagramService == null) {
            throw new IllegalStateException("Diagram and DiagramService must be set before running layout.");
        }

        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {

            List<IDiagramNode> lanes = new ArrayList<>();
            handle.getDiagramNode().getNodes().forEach(node -> {
                lanes.addAll(getLanes(handle.getDiagramNode()));
            });

            lanes.forEach(lane -> {
                LayeredLayout subLayout = new LayeredLayout() {
                    @Override
                    public void applyLayoutToModel(IDiagramHandle diagramHandle) {
                        // Nothing to do here, the layout is already applied to the model
                    }
                };
                subLayout.withDiagram(this.diagram, this.diagramService).withSelection(getAllChildren(lane));
                this.sublayoutMap.put((ActivityPartition) lane.getElement(), new SubLayoutData(subLayout));
            });
        }
        return new ArrayList<>(this.sublayoutMap.values().stream().map(data -> data.layoutAlgorithme).toList());
    }

    @objid ("e9851616-adab-48cb-8fd2-3879ec487e20")
    private List<IDiagramNode> getAllChildren(IDiagramNode lane) {
        List<IDiagramNode> allChildren = new ArrayList<>();
        for (IDiagramNode node : lane.getNodes()) {
            allChildren.add(node);
            allChildren.addAll(getAllChildren(node));
        }
        return allChildren;
    }

    /**
     * Set the bounds of the lane container hierarchy. This method recursively sets
     * the bounds of each lane container based on the dimensions of its child nodes.
     * If the node is an ActivityPartition, it sets the bounds to a minimum
     * dimension or the height of the Elk root node.
     *
     * @param diagramNode The diagram node representing the lane container.
     * @param minDimension The minimum dimension to set for the lane container.
     * @return The cumulative height of the lane container hierarchy.
     */
    @objid ("5bca0854-9bc4-4d8e-ac92-5be6e7bf89d7")
    public Integer setLaneContainerHiererchyBounds(IDiagramNode diagramNode, int minDimension) {
        if (diagramNode.getClass().getName().equals("org.modelio.uml.ui.dg.activity.DiagramPartitionContainerDG")) {
            int cumulatedDims = 0; // Set the bounds of the lane container to the bounds of the first child node
            for (IDiagramNode node : diagramNode.getNodes()) {
                cumulatedDims = cumulatedDims + setLaneContainerHiererchyBounds(node, minDimension);
            }
            diagramNode.setBounds(new Rectangle(diagramNode.getBounds().x, diagramNode.getBounds().y, minDimension, cumulatedDims));
            return cumulatedDims;
        } else if (diagramNode.getElement() instanceof ActivityPartition) {
            // Set the bounds of the lane container to the bounds of the first child node
            SubLayoutData subLayout = sublayoutMap.get(diagramNode.getElement());
            if (subLayout != null) {
                int vardim = Math.max((int) subLayout.layoutAlgorithme.getElkRootNode().getHeight(), 200);
                diagramNode.setBounds(new Rectangle(diagramNode.getBounds().x, diagramNode.getBounds().y, minDimension, vardim));
                return vardim;
            } else {
                int cumulatedDims = 0;
                for (IDiagramNode node : diagramNode.getNodes()) {
                    cumulatedDims = cumulatedDims + setLaneContainerHiererchyBounds(node, minDimension);
                }
                diagramNode.setBounds(new Rectangle(diagramNode.getBounds().x, diagramNode.getBounds().y, minDimension, cumulatedDims));
                return cumulatedDims;
            }
        } else {
            int cumulatedDims = 0;
            for (IDiagramNode node : diagramNode.getNodes()) {
                cumulatedDims = cumulatedDims + setLaneContainerHiererchyBounds(node, minDimension);
            }
            return cumulatedDims;
        }
    }

    /**
     * Get all lanes in the diagram node. This method recursively retrieves all
     * lanes (ActivityPartitions) in the diagram node.
     *
     * @param diagramNode The diagram node to search for lanes.
     * @return A list of IDiagramNode representing the lanes in the diagram node.
     */
    @objid ("60de48fc-5a8a-4217-a632-7bc9b60e035b")
    public List<IDiagramNode> getLanes(IDiagramNode diagramNode) {
        List<IDiagramNode> lanes = new ArrayList<>();
        if (diagramNode.getElement() instanceof ActivityPartition) {
            if (diagramNode.getNodes().size() == 0 || !(diagramNode.getNodes().get(0).getElement() instanceof ActivityPartition)) {
                lanes.add(diagramNode);
            }
        }
        diagramNode.getNodes().forEach(node -> {
            lanes.addAll(getLanes(node));
        });
        return lanes;
    }

    @objid ("c0a92e66-c7ef-4b26-a82f-4960712f65f7")
    private class SubLayoutData {
        @objid ("4292549d-c926-4c9b-a5f1-4c3cfa451b27")
        public Map<ElkEdge, List<ElkEdge>> compositeElkEdgeMap = new HashMap<>();

        @objid ("021945fb-6e50-4448-a678-2070da6fdf14")
        public LayeredLayout layoutAlgorithme;

        @objid ("a5e20ecc-42db-4451-be97-65f7344eadba")
        public Map<Object, MObject> elementByElkElement = new HashMap<>();

        @objid ("201ea901-8d12-47b4-b166-4dc99baeea65")
        public Map<Object, MObject> linkByElkEdge = new HashMap<>();

        @objid ("496ad23c-a4fa-4126-a586-eefb33ed6572")
        public SubLayoutData(LayeredLayout layoutAlgorithme) {
            this.layoutAlgorithme = layoutAlgorithme;
        }

    }

}
