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
import java.util.Map.Entry;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramNode.Role;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.dg.IDiagramDG;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.ICompositeLayoutAlgorithme;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessDesignDiagram;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * BpmnDiagramLayout is a specialized layout algorithm for BPMN process design
 * diagrams. In theory, its role is simple: apply the BpmnProcess Layout to each
 * lane and then adjust the size of the lane to the layout content of the lane.
 * Unfortunately, the side effects when manipulating elements in lanes are such
 * that it is necessary to implement an overly complex strategy. 1 - Apply the
 * layout to each lane. 2 - Save the position of each laid-out element (relative
 * to the lane). 3 - Calculate the theoretical size of each lane and set its
 * size. 4 - Replace the elements of each lane according to their saved
 * positions.
 */
@objid ("af90f460-5c07-4306-b162-512f71cdb4f8")
public class BPMNProcessDesignDiagramLayout implements ICompositeLayoutAlgorithme {
    @objid ("5fed3b11-a51b-4f86-bb99-014bdf2ae703")
    protected ILayoutAlgorithme simpleLayeredLayout;

    @objid ("b6827ac7-c93b-4cbd-855f-fcadbe8e3ecb")
    protected Map<BpmnLane, SubLayoutData> sublayoutMap = new HashMap<>();

    @objid ("45f5ee8b-427c-4777-b774-ce94a21b03f4")
    protected BpmnProcessDesignDiagram diagram;

    @objid ("575fa399-a519-4961-ae07-4a86cf0c3729")
    protected IDiagramService diagramService;

    @objid ("fffa7566-edea-42f7-9483-6dfb60a3afe7")
    protected List<IDiagramNode> selection = null;

    @objid ("6381a84d-0665-4faf-9aaf-2c49454bd986")
    public BPMNProcessDesignDiagramLayout() {

    }

    @objid ("16431218-a821-4854-9ced-831b77c370d5")
    @Override
    public ILayoutAlgorithme withDiagram(AbstractDiagram diagram, IDiagramService diagramService) {
        if (!(diagram instanceof BpmnProcessDesignDiagram)) {
            throw new IllegalArgumentException("The diagram must be an instance of BpmnProcessDesignDiagram.");
        }

        this.diagram = (BpmnProcessDesignDiagram) diagram;
        this.diagramService = diagramService;
        return this;
    }

    @objid ("b93f1006-5940-446d-bab1-a73a50c515c9")
    @Override
    public ILayoutAlgorithme withSelection(List<IDiagramNode> selection) {
        this.selection = selection;
        return this;
    }

    @objid ("8e8e1a98-2848-4194-a6a5-7c59a7b5dbd3")
    @Override
    public List<ILayoutAlgorithme> getSubLayoutAlgorithmes() {
        if (this.diagram == null || this.diagramService == null) {
            throw new IllegalStateException("Diagram and DiagramService must be set before running layout.");
        }

        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {

            // Perform Specific algo for each Lane
            List<IDiagramNode> lanes = getLanes(handle.getDiagramNode());
            lanes.forEach(lane -> {
                BPMNProcessDiagramLayout subLayout = new BPMNProcessDiagramLayout();
                subLayout.withDiagram(this.diagram, this.diagramService).withSelection(getAllChildren(lane));
                this.sublayoutMap.put((BpmnLane) lane.getElement(), new SubLayoutData(subLayout));
            });

        }
        return new ArrayList<>(this.sublayoutMap.values().stream().map(data -> data.layoutAlgorithme).toList());
    }

    @objid ("cb83aef2-2d0d-40ba-a754-ab09468e40ef")
    @Override
    public void runLayout() {
        // If the is no lane , apply the simple layered layout
        List<ILayoutAlgorithme> subLayoutAlgorithmes = getSubLayoutAlgorithmes();
        if (subLayoutAlgorithmes.isEmpty()) {
            this.simpleLayeredLayout = new BPMNProcessDiagramLayout().withDiagram(this.diagram, this.diagramService);
            this.simpleLayeredLayout.runLayout();
            return;
        }

        // Run the sub layouts
        for (ILayoutAlgorithme subLayout : subLayoutAlgorithmes) {
            subLayout.runLayout();
        }

        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {
            handle.setBatchMode(true);

            for (Entry<BpmnLane, SubLayoutData> entry : this.sublayoutMap.entrySet()) {
                BpmnLane lane = entry.getKey();
                SubLayoutData layoutData = entry.getValue();

                // Save the position of the lane
                saveRelativeLayoutedElementBoundary((IDiagramNode) handle.getDiagramGraphics(lane).get(0), layoutData);
            }

            // Set Lanes Bounds : FIrst calculate the bounds of each lane and next apply
            // them hierarchically ( if we apply the bounds at calculation time, results are
            // invalidate by LanSet auto layout policies)
            Map<IDiagramNode, Point> nodeDimensionMap = new HashMap<>();
            calculateLanesBondsDeepFirst(handle.getDiagramNode(), 500, nodeDimensionMap);
            applyLanesBoundHeirarchicly(handle.getDiagramNode(), nodeDimensionMap);

            // Reapply the relative position of each elements
            applySavedLayoutOnNodes(handle);
            applySavedLayoutOnLinks(handle);

            handle.setBatchMode(false);
            handle.save();
        }

        for (SubLayoutData layoutData : sublayoutMap.values()) {
            layoutData.layoutAlgorithme.postProcessing();
        }
    }

    @objid ("ec66da14-ed93-4ed3-99ad-f7283bf13953")
    private void applySavedLayoutOnLinks(IDiagramHandle handle) {
        for (Entry<BpmnLane, SubLayoutData> entry : this.sublayoutMap.entrySet()) {
            BpmnLane lane = entry.getKey();
            SubLayoutData layoutData = entry.getValue();

            IDiagramNode laneNode = (IDiagramNode) handle.getDiagramGraphics(lane).get(0);
            Point translation = new Point(laneNode.getBounds().x + (laneNode.getBounds().width - layoutData.dimention.x) / 2, laneNode.getBounds().y + (laneNode.getBounds().height - layoutData.dimention.y) / 2);
            layoutData.relativePaths.forEach((element, relativePath) -> {
                List<IDiagramGraphic> crNodeDg = handle.getDiagramGraphics(element);

                if (crNodeDg.isEmpty()) {
                    Point dropBouds = new Point(relativePath.get(0));
                    dropBouds.translate(translation);
                    crNodeDg = handle.unmask(element, dropBouds.x, dropBouds.y);
                }

                if (!crNodeDg.isEmpty() && crNodeDg.get(0) instanceof IDiagramLink) {
                    IDiagramLink diagramLink = (IDiagramLink) crNodeDg.get(0);
                    // Set the path of the link
                    diagramLink.setPath(relativePath.stream().map(p -> p.translate(translation)).toList());
                }
            });
        }
    }

    @objid ("bf1f8c96-fd06-416c-989b-69ea6a17aa50")
    private void applySavedLayoutOnNodes(IDiagramHandle handle) {
        for (Entry<BpmnLane, SubLayoutData> entry : this.sublayoutMap.entrySet()) {
            BpmnLane lane = entry.getKey();
            SubLayoutData layoutData = entry.getValue();

            IDiagramNode laneNode = (IDiagramNode) handle.getDiagramGraphics(lane).get(0);
            Point translation = new Point(laneNode.getBounds().x + (laneNode.getBounds().width - layoutData.dimention.x) / 2, laneNode.getBounds().y + (laneNode.getBounds().height - layoutData.dimention.y) / 2);

            // Reapply the relative position of each elements
            layoutData.relativeBoundary.forEach((element, relativeBounds) -> {

                List<IDiagramGraphic> crNodeDg = handle.getDiagramGraphics(element);

                // Calculate a Rectangle base on the bounds of the elk root note in the middle
                // of the lane
                // The goals is to identify a sub bouds on the middle of the lane
                Rectangle finalBounds = relativeBounds.translate(translation);

                if (crNodeDg.isEmpty()) {
                    crNodeDg = handle.unmask(element, finalBounds.x, finalBounds.y);
                }

                if (!crNodeDg.isEmpty()) {
                    IDiagramNode rootNode = (IDiagramNode) crNodeDg.get(0);
                    rootNode.setBounds(finalBounds);
                }
            });
        }
    }

    @objid ("f4af246c-2c86-4f69-acc2-bc741794b83d")
    private Point calculateLanesBondsDeepFirst(IDiagramNode diagramNode, int minWidth, Map<IDiagramNode, Point> nodeDimensionMap) {
        if (diagramNode.getElement() instanceof BpmnLaneSet) {
            Point cumulatedDim = new Point(0, 0);
            // Set the bounds of the lane container to the bounds of the first child node
            for (IDiagramNode node : diagramNode.getNodes()) {
                Point nodeDim = calculateLanesBondsDeepFirst(node, minWidth, nodeDimensionMap);
                cumulatedDim.setX(Math.max(nodeDim.x, cumulatedDim.x));
                cumulatedDim.setY(cumulatedDim.y + nodeDim.y);
            }
            nodeDimensionMap.put(diagramNode, cumulatedDim);
            return cumulatedDim;
        } else if (diagramNode.getElement() instanceof BpmnLane && diagramNode.getNodes().stream().noneMatch(elt -> elt.getElement() instanceof BpmnLaneSet)) {
            Point landContentDimention = this.sublayoutMap.get(diagramNode.getElement()).dimention;
            Point laneFinalBounds = new Point(Math.max(minWidth, landContentDimention.x + 150), Math.max(landContentDimention.y + 100, 200));
            nodeDimensionMap.put(diagramNode, laneFinalBounds);
            return laneFinalBounds;

        } else {
            Point cumulatedDim = new Point(0, 0);
            for (IDiagramNode node : diagramNode.getNodes()) {
                Point nodeDim = calculateLanesBondsDeepFirst(node, minWidth, nodeDimensionMap);
                cumulatedDim.setX(Math.max(nodeDim.x, cumulatedDim.x));
                cumulatedDim.setY(cumulatedDim.y + nodeDim.y);
            }
            return cumulatedDim;
        }
    }

    @objid ("8c7ef0d5-8baf-4d65-b9d5-dd07b265d49c")
    private void applyLanesBoundHeirarchicly(IDiagramNode diagramNode, Map<IDiagramNode, Point> nodeDimensionMap) {
        if (diagramNode.getElement() instanceof BpmnLaneSet) {
            Point dimension = nodeDimensionMap.get(diagramNode);
            diagramNode.setBounds(new Rectangle(diagramNode.getBounds().x, diagramNode.getBounds().y, dimension.x, dimension.y));
            for (IDiagramNode node : diagramNode.getNodes()) {
                applyLanesBoundHeirarchicly(node, nodeDimensionMap);
            }
        } else if (diagramNode.getElement() instanceof BpmnLane && diagramNode.getNodes().stream().noneMatch(elt -> elt.getElement() instanceof BpmnLaneSet)) {
            Point dimension = nodeDimensionMap.get(diagramNode);
            diagramNode.setBounds(new Rectangle(diagramNode.getBounds().x, diagramNode.getBounds().y, dimension.x, dimension.y));
        } else {
            for (IDiagramNode node : diagramNode.getNodes()) {
                applyLanesBoundHeirarchicly(node, nodeDimensionMap);
            }
        }
    }

    @objid ("8883a9c6-0ee1-442b-91dc-3184b7aa6f3e")
    private void saveRelativeLayoutedElementBoundary(IDiagramNode lane, SubLayoutData layoutData) {
        // calculate the point of the layout closer to (0,0).
        Point delta = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        lane.getNodes().forEach(children -> {
            if (children instanceof IDiagramNode) {
                IDiagramNode childrenNode = (IDiagramNode) children;
                delta.setLocation(Math.min(delta.x, childrenNode.getBounds().x), Math.min(delta.y, childrenNode.getBounds().y));
            }
        });

        Point maxPoint = new Point(0, 0);
        // Save the relative position of each elements base on this point and mask the
        // element
        Map<MObject, Rectangle> relativeBoundary = new HashMap<>();
        Map<MObject, List<Point>> relativePaths = new HashMap<>();
        getAllChildrenNodes(lane).forEach(node -> {
            if (node.getElement() != null) {
                Rectangle bounds = node.getBounds();
                Rectangle relativeBounds = new Rectangle(bounds.x - delta.x, bounds.y - delta.y, bounds.width, bounds.height);
                relativeBoundary.put(node.getElement(), relativeBounds);
                maxPoint.setLocation(Math.max(maxPoint.x, relativeBounds.x + relativeBounds.width), Math.max(maxPoint.y, relativeBounds.y + relativeBounds.height));

                // Save the relative path of each links
                node.getFromLinks().forEach(link -> {
                    List<Point> relativePath = new ArrayList<>();
                    // Calculate the relative path of the link
                    for (Point point : link.getPath().getPoints()) {
                        relativePath.add(new Point(point.x - delta.x, point.y - delta.y));
                    }
                    relativePaths.put(link.getElement(), relativePath);

                });
            }
        });

        getAllChildrenNodes(lane).forEach(node -> {
            if (node.getElement() != null) {
                node.setBounds(new Rectangle(lane.getBounds().x + 20, lane.getBounds().y + 20, node.getBounds().width, node.getBounds().height));
            }
        });

        lane.fitToContent();

        layoutData.setRelativeBoundary(relativeBoundary);
        layoutData.setRelativePoints(relativePaths);
        layoutData.setDimention(maxPoint);
    }

    @objid ("ab3cbbcf-3f9f-46cf-b79c-dda62ae7c0d4")
    List<IDiagramNode> getAllChildrenNodes(IDiagramNode diagramNode) {
        List<IDiagramNode> allChildren = new ArrayList<>();
        if (diagramNode != null) {
            for (IDiagramNode child : diagramNode.getNodes(Role.INNER)) {
                allChildren.add(child);
                allChildren.addAll(getAllChildrenNodes(child));
            }
            for (IDiagramNode child : diagramNode.getNodes(Role.PORT)) {
                allChildren.add(child);
                allChildren.addAll(getAllChildrenNodes(child));
            }
        }
        return allChildren;
    }

    @objid ("0176c1f3-5076-41ac-b8ae-9dc99aa87b48")
    private List<IDiagramNode> getLanes(IDiagramNode diagramNode) {
        List<IDiagramNode> lanes = new ArrayList<>();
        if (diagramNode.getElement() instanceof BpmnLane) {
            if (diagramNode.getNodes().size() == 0 || !(diagramNode.getNodes().get(0).getElement() instanceof BpmnLaneSet)) {
                lanes.add(diagramNode);
            }
        }
        diagramNode.getNodes().forEach(node -> {
            lanes.addAll(getLanes(node));
        });
        return lanes;
    }

    @objid ("b5ae4d06-fcba-44eb-b16f-560cd1138948")
    private List<IDiagramNode> getAllChildren(IDiagramNode lane) {
        List<IDiagramNode> allChildren = new ArrayList<>();
        for (IDiagramNode node : lane.getNodes()) {
            allChildren.add(node);
            allChildren.addAll(getAllChildren(node));
        }
        return allChildren;
    }

    @objid ("1b8d2e69-2b90-43b7-8876-3b70803e6927")
    @Override
    public void postProcessing() {
        // Layout Links Between 2 Lanes
        int deltaT = 1;
        int deltaB = 1;
        // Layout Links Between 2 Lanes
        try (IDiagramHandle handle = this.diagramService.getDiagramHandle(diagram)) {
            for (IDiagramLink link : handle.getDiagramNode().getLinks()) {
                if (link.getFrom().getElement() instanceof BpmnFlowNode && link.getTo().getElement() instanceof BpmnFlowNode) {

                    IDiagramNode fromNodeDg = (IDiagramNode) link.getFrom();
                    IDiagramNode toNodeDg = (IDiagramNode) link.getTo();
                    BpmnFlowNode fromNode = (BpmnFlowNode) link.getFrom().getElement();
                    BpmnFlowNode toNode = (BpmnFlowNode) link.getTo().getElement();

                    if (fromNode.getLane().isEmpty()   || toNode.getLane().isEmpty() || fromNode.getLane().stream().anyMatch(lane -> toNode.getLane().contains(lane))) {
                        // If the link is between 2 elements in the same lane, we do not need to layout it
                        continue;
                    }


                    BpmnLane topLane = fromNode.getLane().stream().findFirst().orElse(null);
                    List<IDiagramGraphic> fromNodePartition = handle.getDiagramGraphics(topLane);
                    IDiagramNode fromNodePartitionDg = (IDiagramNode) fromNodePartition.get(0);
                    int partitionBorderY = fromNodePartitionDg.getBounds().y + fromNodePartitionDg.getBounds().height;

                    // If the link is between 2 elements in different lanes, we need to layout it
                    IDiagramNode topNodeDg = fromNodeDg.getBounds().y < toNodeDg.getBounds().y ? fromNodeDg : toNodeDg;
                    IDiagramNode leftNodeDg = fromNodeDg.getBounds().x < toNodeDg.getBounds().x ? fromNodeDg : toNodeDg;

                    // First Point
                    List<Point> newPath = new ArrayList<>();
                    if (topNodeDg.equals(fromNodeDg)) {
                        if (leftNodeDg.equals(fromNodeDg)) {
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), fromNodeDg.getBounds().y + fromNodeDg.getBounds().height));
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), partitionBorderY- (deltaT * 5)));
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
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), partitionBorderY + (deltaT * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), partitionBorderY + (deltaT * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), fromNodeDg.getBounds().y + fromNodeDg.getBounds().height));
                        } else {
                            newPath.add(new Point(fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25, (int) (fromNodeDg.getBounds().y)));
                            newPath.add(new Point((int) (fromNodeDg.getBounds().x + fromNodeDg.getBounds().width / 1.25), partitionBorderY + (deltaT * 5)));
                            newPath.add(new Point((int) (toNodeDg.getBounds().x + toNodeDg.getBounds().width / 4), partitionBorderY + (deltaT * 5)));
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

    @objid ("bde0628d-3ee6-4368-acac-7f9a17873e7a")
    public void compactDiagramBounds(int PADDING) {
        if (this.diagram == null || this.diagramService == null) {
            throw new IllegalStateException("Diagram and DiagramService must be set before running layout.");
        }

        try (IDiagramHandle diagramHandle = this.diagramService.getDiagramHandle(this.diagram)) {
            // Calculate Translation
            IDiagramDG diagramDg = diagramHandle.getDiagramNode();

            Point translation = new Point(-diagramDg.getBounds().x + PADDING, -diagramDg.getBounds().y + PADDING);

            diagramHandle.setBatchMode(true);
            translate(diagramHandle, translation);
            diagramDg.fitToContent();
            diagramHandle.setBatchMode(false);

            diagramHandle.save();
        }
    }

    @objid ("761bbe2d-748c-470f-b498-f0c3545393db")
    protected void translate(IDiagramHandle diagramHandle, Point translation) {
        IDiagramDG diagramDg = diagramHandle.getDiagramNode();

        // Translate LansSetContainers

        diagramDg.getNodes(Role.INNER).forEach(node -> {
            if (node.getElement() instanceof BpmnLaneSet) {
                Rectangle bounds = node.getBounds();
                Rectangle newBounds = bounds.getTranslated(translation);
                node.setBounds(newBounds);
            }
        });

        // When LaneSet is translated, nodes inside are translated but links are not.
        getLanes(diagramDg).forEach(lane -> {
            for (IDiagramNode nodeDg : lane.getNodes(Role.INNER)) {
                nodeDg.getFromLinks().forEach(link -> {
                    List<Point> newPath = new ArrayList<>();
                    for (Point point : link.getPath().getPoints()) {
                        newPath.add(point.getTranslated(translation));
                    }
                    link.setPath(newPath);

                });
                for (IDiagramNode ports : nodeDg.getNodes(Role.PORT)) {
                    ports.getFromLinks().forEach(link -> {
                        List<Point> newPath = new ArrayList<>();
                        for (Point point : link.getPath().getPoints()) {
                            newPath.add(point.getTranslated(translation));
                        }
                        link.setPath(newPath);
                    });
                }
            }
        });
    }

    @objid ("8b27145a-595e-4545-a4a0-49d94b9678ad")
    @Override
    public List<IDiagramNode> getSelection() {
        // TODO Auto-generated method stub
        return null;
    }

    @objid ("a7edc12a-4823-41ba-a4a2-6c4324a0e9b8")
    private class SubLayoutData {
        @objid ("4bcd9439-42db-436d-9346-5e59c47dede7")
        public Map<MObject, Rectangle> relativeBoundary = new HashMap<>();

        @objid ("c2d59b8a-55ff-4040-9598-471db341fcf2")
        public Map<MObject, List<Point>> relativePaths = new HashMap<>();

        @objid ("4bd6863d-92b0-4b0a-b133-0c8aa354b8f4")
        public Point dimention = new Point(0, 0);

        @objid ("cf0a12d3-e746-4092-8fe6-00f2b2f74243")
        public BPMNProcessDiagramLayout layoutAlgorithme;

        @objid ("2f8b0003-3446-4a58-8b2e-eea29503df02")
        public SubLayoutData(BPMNProcessDiagramLayout layoutAlgorithme) {
            this.layoutAlgorithme = layoutAlgorithme;
        }

        @objid ("cd6acc27-9771-4345-bd89-37c70cb670e7")
        public void setDimention(Point dimention) {
            this.dimention = dimention;
        }

        @objid ("2ee6ec95-cbe0-4c7d-b168-3b7281eb83f6")
        public void setRelativeBoundary(Map<MObject, Rectangle> relativeBoundary) {
            this.relativeBoundary = relativeBoundary;
        }

        @objid ("5441eb31-d751-4616-8dd8-c60cb0aa5081")
        public void setRelativePoints(Map<MObject, List<Point>> relativePaths) {
            this.relativePaths = relativePaths;
        }

    }

}
