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
package org.modelio.diagram.editor.layout.algorithme.elk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.core.IGraphLayoutEngine;
import org.eclipse.elk.core.RecursiveGraphLayoutEngine;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.PortConstraints;
import org.eclipse.elk.core.util.IElkProgressMonitor;
import org.eclipse.elk.core.util.NullElkProgressMonitor;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkGraphFactory;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.ICompositeLayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.elk.utils.ElkModelUtils;
import org.modelio.diagram.editor.plugin.DiagramEditor;
import org.modelio.metamodel.diagrams.AbstractDiagram;

@objid ("b868922c-4449-4800-a4d4-8cebec24ce0a")
public abstract class DefaultElkCompositeLayout implements ICompositeLayoutAlgorithme, IElkLayoutAlgorithme {
    @objid ("b8b3881c-137e-4698-8fbd-a60e6cbb6f51")
    private Map<IElkLayoutAlgorithme, ElkNode> subLayoutRootNodes = new HashMap<>();

    @objid ("598b85d4-d773-4aa9-a91a-2bcb8ae4d432")
    protected IElkLayoutAlgorithme mainLayout;

    @objid ("49f98c3f-e836-487f-862b-45d774f51d27")
    protected List<IElkLayoutAlgorithme> subLayoutAlgorithmes = new ArrayList<>();

    @objid ("c8b83572-c34d-40c6-b23e-cd1898ee29a1")
    protected Map<IDiagramNode, IElkLayoutAlgorithme> contenairMap = new HashMap<>();

    @objid ("ab37adbe-6b3a-4635-9252-792e8d5f3152")
    public DefaultElkCompositeLayout(DefaultElkLayout compositeLayout) {
        this.mainLayout = compositeLayout;
    }

    @objid ("de8c3162-89b0-48c7-9342-b603c247e5bc")
    public void configureLayout() {
        this.mainLayout.configureLayout();
        this.subLayoutAlgorithmes = new ArrayList<IElkLayoutAlgorithme>();
        getSubLayoutAlgorithmes().forEach(subLayout -> {
            if (!(subLayout instanceof IElkLayoutAlgorithme)) {
                throw new IllegalStateException("Sub layout must be an instance of DefaultElkLayout");
            }
            this.subLayoutAlgorithmes.add((IElkLayoutAlgorithme) subLayout);
        });
    }

    @objid ("a3365534-e6b1-4c76-bfe5-eb3abc43bb57")
    @Override
    public void runLayout() {
        configureLayout();

        if (this.subLayoutAlgorithmes.isEmpty()) {
            this.mainLayout.runLayout();
            return;
        }

        for (IElkLayoutAlgorithme layout : this.subLayoutAlgorithmes) {
            // Run Sub Layout
            layout.runLayout();
            //layout.compactDiagramBounds(0);
        }

        try (IDiagramHandle diagramHandle = this.mainLayout.getDiagramService().getDiagramHandle(this.mainLayout.getDiagram())) {

            buildElkModel(diagramHandle);

            // Apply the layout algorithm
            IGraphLayoutEngine engine = new RecursiveGraphLayoutEngine();
            IElkProgressMonitor monitor = new NullElkProgressMonitor();
            engine.layout(this.mainLayout.getElkRootNode(), monitor);

            diagramHandle.setBatchMode(true);
            applyLayoutToModel(diagramHandle);
            diagramHandle.setBatchMode(false);

            diagramHandle.save();
        } catch (Exception e) {
            DiagramEditor.LOG.error(e);
        }
    }

    @objid ("a6bee4b5-7fec-4087-bd36-2edc04c28e72")
    public void buildElkModel(IDiagramHandle diagramHandle) {
        List<IDiagramNode> outOfSelection = new ArrayList<>();

        // Build Selection
        this.subLayoutAlgorithmes.forEach(alog -> {
            outOfSelection.addAll(alog.getSelection());
        });
        this.mainLayout.withSelection(getAllNodes(diagramHandle.getDiagramNode(), outOfSelection));

        // Build Elk Model of main layout algo
        this.mainLayout.buildElkModel(diagramHandle);

        // Create Abstract node base on root node of sub layouts algo
        for (IElkLayoutAlgorithme subLayout : this.subLayoutAlgorithmes) {

            ElkNode rootNode = subLayout.getElkRootNode();

            ElkNode gnode = ElkGraphFactory.eINSTANCE.createElkNode();
            gnode.setIdentifier(UUID.randomUUID().toString());
            gnode.setProperty(CoreOptions.NODE_SIZE_FIXED_GRAPH_SIZE, true);
            gnode.setProperty(CoreOptions.PORT_CONSTRAINTS, PortConstraints.FIXED_POS);
            gnode.setDimensions(rootNode.getWidth(), rootNode.getHeight());

            // Add Abstract node to the Elk root node of main algo
            // Find Parent in main layout Elk model
            ElkNode parentNode = this.mainLayout.getClosedParent(diagramHandle, subLayout.getSelection().get(0));
            parentNode.getChildren().add(gnode);
            gnode.setParent(parentNode);

            this.mainLayout.getElkNodes().put(subLayout.getSelection().get(0), gnode);
            this.subLayoutRootNodes.put(subLayout, gnode);
        }

        // Create Abstract Links for link between element of the two sub layout or
        // element of the main layout
        for (IDiagramLink linkDg : diagramHandle.getDiagramNode().getLinks()) {

            if (!(linkDg.getFrom() instanceof IDiagramNode && linkDg.getTo() instanceof IDiagramNode)) {
                continue;
            }

            IElkLayoutAlgorithme sourceLayout = null;
            IElkLayoutAlgorithme targetLayout = null;

            if (this.mainLayout.getSelection().contains(linkDg.getFrom())) {
                sourceLayout = this.mainLayout;
            } else {
                for (IElkLayoutAlgorithme subLayout : this.subLayoutAlgorithmes) {
                    if (subLayout.getSelection().contains(linkDg.getFrom())) {
                        sourceLayout = (DefaultElkLayout) subLayout;
                        break;
                    }
                }
            }

            if (this.mainLayout.getSelection().contains(linkDg.getTo())) {
                targetLayout = this.mainLayout;
            } else {
                for (IElkLayoutAlgorithme subLayout : this.subLayoutAlgorithmes) {
                    if (subLayout.getSelection().contains(linkDg.getTo())) {
                        targetLayout = subLayout;
                        break;
                    }
                }
            }

            if (sourceLayout != null && targetLayout != null && !sourceLayout.equals(targetLayout)) {

                IDiagramNode sourceNode = (IDiagramNode) linkDg.getFrom();
                IDiagramNode targetNode = (IDiagramNode) linkDg.getTo();

                ElkEdge elkEdge = ElkGraphFactory.eINSTANCE.createElkEdge();
                elkEdge.setIdentifier(UUID.randomUUID().toString());

                if (sourceLayout.equals(this.mainLayout)) {
                    elkEdge.getSources().add(sourceLayout.getElkNodes().get(sourceNode));
                } else {
                    elkEdge.getSources().add(createFixedTargetPort(sourceNode, sourceLayout, linkDg));
                }

                if (targetLayout.equals(this.mainLayout)) {
                    elkEdge.getTargets().add(targetLayout.getElkNodes().get(targetNode));
                } else {
                    elkEdge.getTargets().add(createFixedTargetPort(targetNode, targetLayout, linkDg));
                }

                elkEdge.setContainingNode(this.mainLayout.getElkRootNode());
                this.mainLayout.getElKLinks().put(linkDg, Arrays.asList(elkEdge));
            }
        }
    }

    @objid ("b851d0aa-a180-42f2-8b06-1e3d43dcf535")
    private ElkConnectableShape createFixedTargetPort(IDiagramNode targetNodeDg, IElkLayoutAlgorithme subLayout, IDiagramLink linkDg) {
        ElkNode root = subLayoutRootNodes.get(subLayout);
        ElkPort gport = ElkGraphFactory.eINSTANCE.createElkPort();
        gport.setIdentifier(UUID.randomUUID().toString());
        gport.setProperty(CoreOptions.NODE_SIZE_FIXED_GRAPH_SIZE, true);
        gport.setParent(root);

        ElkConnectableShape subNode = subLayout.getElkNodes().get(targetNodeDg);

        if (subNode != null) {
            double leftBounds = subNode.getX() - root.getX();
            double rightBounds = root.getX() + root.getWidth() - subNode.getX() - subNode.getWidth();
            double topBounds = subNode.getY() - root.getY();
            double bottomBounds = root.getY() + root.getHeight() - subNode.getY() - subNode.getHeight();

            if (rightBounds == leftBounds) {
                if (linkDg.getFrom().equals(targetNodeDg)) {
                    gport.setX(root.getX() + root.getWidth());
                    gport.setY(subNode.getY());
                } else {
                    gport.setX(root.getX());
                    gport.setY(subNode.getY());
                }
            } else if (rightBounds <= leftBounds && rightBounds <= topBounds && rightBounds <= bottomBounds) {
                gport.setX(root.getX() + root.getWidth());
                gport.setY(subNode.getY() + subNode.getHeight() / 2);
            } else if (leftBounds <= rightBounds && leftBounds <= topBounds && leftBounds <= bottomBounds) {
                gport.setX(root.getX());
                gport.setY(subNode.getY() + subNode.getHeight() / 2);
            } else if (topBounds <= leftBounds && topBounds <= rightBounds && topBounds <= bottomBounds) {
                gport.setX(subNode.getX() + subNode.getWidth());
                gport.setY(root.getY());
            } else {
                gport.setX(subNode.getX() + subNode.getWidth());
                gport.setY(root.getY() + root.getHeight());
            }
            return gport;
        }

        return gport;
    }

    @objid ("20a21005-6a01-447b-a5ac-c7bb37cbc8a5")
    private List<IDiagramNode> getAllNodes(IDiagramNode node, List<IDiagramNode> outOfSelection) {
        List<IDiagramNode> result = new ArrayList<>();
        node.getNodes().forEach(n -> {
            if (!outOfSelection.stream().filter(dg -> dg.getElement() != null).map(dg -> dg.getElement()).anyMatch(dg -> dg.equals(n.getElement()))) {
                result.add(n);
                result.addAll(getAllNodes(n, outOfSelection));
            }
        });

        return result;
    }

    @objid ("7fc6ddf7-bc7f-4816-82db-b9563f03e15a")
    public void applyLayoutToModel(IDiagramHandle diagramHandle) {
        // Apply Current layout
        this.mainLayout.applyLayoutToModel(diagramHandle);

        // Transpose of element of sub layout based on the layout of the Sublayout root
        // node
        for (IElkLayoutAlgorithme layout : this.subLayoutAlgorithmes) {

            ElkConnectableShape rootNodePositionInMainLayout = this.mainLayout.getElkNodes().get(layout.getSelection().get(0));

            for (IDiagramNode node : layout.getSelection()) {
                layoutNodes(diagramHandle, layout, rootNodePositionInMainLayout, node);
            }

            for (IDiagramLink linkDg : diagramHandle.getDiagramNode().getLinks()) {
                if (layout.getSelection().contains(linkDg.getFrom()) && layout.getSelection().contains(linkDg.getTo())) {
                    // We search the ElkEdge for this link
                    DefaultElkLayout subLayout = (DefaultElkLayout) layout;
                    List<ElkEdge> edges = subLayout.getElKLinks().get(linkDg);
                    ILinkPath path = linkDg.getPath();
                    if (edges != null && path != null) {
                        ElkModelUtils.updateLinkPath(edges, path, new Point((int) rootNodePositionInMainLayout.getX(), (int) rootNodePositionInMainLayout.getY()));
                        linkDg.setPath(path);
                    }
                }
            }
        }
    }

    @objid ("7e40442a-334d-4080-8b32-93e6dba65b32")
    private void layoutNodes(IDiagramHandle diagramHandle, IElkLayoutAlgorithme layout, ElkConnectableShape rootNodePositionInMainLayout, IDiagramNode node) {
        DefaultElkLayout subLayout = (DefaultElkLayout) layout;
        ElkConnectableShape nodePositionInSubLayout = subLayout.getElkNodes().get(node);
        List<IDiagramGraphic> parent = diagramHandle.getDiagramGraphics(node.getElement().getCompositionOwner());
        if (nodePositionInSubLayout != null) {
            if (!parent.isEmpty() && parent.get(0) instanceof IDiagramNode) {
                Rectangle parentBounds = ((IDiagramNode) parent.get(0)).getBounds();
                int x = parentBounds.x + (int) nodePositionInSubLayout.getX() + (int) rootNodePositionInMainLayout.getX();
                int y = parentBounds.y + (int) nodePositionInSubLayout.getY() + (int) rootNodePositionInMainLayout.getY();
                node.setBounds(new Rectangle(x, y, (int) nodePositionInSubLayout.getWidth(), (int) nodePositionInSubLayout.getHeight()));
            } else {
                int x = (int) nodePositionInSubLayout.getX() + (int) rootNodePositionInMainLayout.getX();
                int y = (int) nodePositionInSubLayout.getY() + (int) rootNodePositionInMainLayout.getY();
                node.setBounds(new Rectangle(x, y, (int) nodePositionInSubLayout.getWidth(), (int) nodePositionInSubLayout.getHeight()));
            }
        }
    }

    @objid ("7a7b0fb9-1029-4540-9332-0e8f82708bc7")
    @Override
    public ILayoutAlgorithme withDiagram(AbstractDiagram diagram, IDiagramService diagramService) {
        this.mainLayout.withDiagram(diagram, diagramService);
        return this;
    }

    @objid ("bb5c5f9f-be13-4651-b7ae-eb6bb8521801")
    @Override
    public ILayoutAlgorithme withSelection(List<IDiagramNode> selection) {
        this.mainLayout.withSelection(selection);
        return this;
    }

    @objid ("aaef6ccd-68a7-422c-815c-f82c3e983164")
    @Override
    public List<IDiagramNode> getSelection() {
        return this.mainLayout.getSelection();
    }

    @objid ("ed7fdf61-2998-4d44-831f-dbc94a159a31")
    public AbstractDiagram getDiagram() {
        return this.mainLayout.getDiagram();
    }

    @objid ("30e8d818-b997-4770-a974-ba0a7681e3d8")
    public IDiagramService getDiagramService() {
        return this.mainLayout.getDiagramService();
    }

    @objid ("c79394e4-e05b-40b1-af74-4763499eb2c1")
    @Override
    public void compactDiagramBounds(int PADDING) {
        this.mainLayout.compactDiagramBounds(PADDING);
    }

    @objid ("966483e4-7644-4545-aaaf-e3bd8c94117c")
    public void postProcessing() {
        this.mainLayout.postProcessing();
        for (IElkLayoutAlgorithme layout : this.subLayoutAlgorithmes) {
            layout.postProcessing();
        }
    }

    @objid ("33ddb99f-bfd1-46e6-aa0f-0f12cb47b7b7")
    @Override
    public Map<IDiagramNode, ElkConnectableShape> getElkNodes() {
        return this.mainLayout.getElkNodes();
    }

    @objid ("ac5a7718-ba8b-4f64-bdea-b9f01f1afa6d")
    @Override
    public Map<IDiagramLink, List<ElkEdge>> getElKLinks() {
        return this.mainLayout.getElKLinks();
    }

    @objid ("596ea180-e478-4cba-92c7-c555b95db798")
    @Override
    public ElkNode getElkRootNode() {
        return this.mainLayout.getElkRootNode();
    }

    @objid ("3be14c0e-ca7e-4b72-9535-4e4cea85f581")
    @Override
    public ElkNode getClosedParent(IDiagramHandle diagramHandle, IDiagramNode iDiagramNode) {
        return this.mainLayout.getClosedParent(diagramHandle,iDiagramNode);
    }

}
