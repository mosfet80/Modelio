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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.IGraphLayoutEngine;
import org.eclipse.elk.core.RecursiveGraphLayoutEngine;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.math.KVector;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.PortSide;
import org.eclipse.elk.core.util.IElkProgressMonitor;
import org.eclipse.elk.core.util.NullElkProgressMonitor;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkGraphFactory;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.elk.graph.util.ElkGraphUtil;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramNode.Role;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.api.modelio.diagram.dg.IDiagramDG;
import org.modelio.diagram.editor.layout.ILayoutAlgorithme;
import org.modelio.diagram.editor.layout.algorithme.elk.utils.ElkLibraryLoader;
import org.modelio.diagram.editor.layout.algorithme.elk.utils.ElkModelUtils;
import org.modelio.diagram.editor.plugin.DiagramEditor;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;

@objid ("042903ce-e84e-4237-8d74-77aed6b5f141")
public abstract class DefaultElkLayout implements IElkLayoutAlgorithme {
    @objid ("bef53213-4c44-495e-841e-c6e87bd5c024")
    protected ElkNode graph;

    @objid ("7a4ba1d4-c2cc-435c-b879-6aa2f0e7dfb1")
    private Map<IDiagramLink, List<ElkEdge>> elkLinks = new HashMap<>();

    @objid ("1e6d6aa8-3549-4d4c-9ec0-9445cd05ca0b")
    private Map<IDiagramNode, ElkConnectableShape> elkNodes = new HashMap<>();

    @objid ("98e61c1f-50d2-435b-80a5-85a05e7098d9")
    private AbstractDiagram diagram;

    @objid ("c862c6ac-b037-4cd6-97a2-c4d1535044d0")
    private IDiagramService diagramService;

    @objid ("4f5c181d-f26e-4486-87d9-5ccf44895000")
    protected List<IDiagramNode> selection = null;

    @objid ("1dde1006-8166-4750-a605-bb0d967079ae")
    public DefaultElkLayout() {
        ElkLibraryLoader.loadElk();
        this.graph = ElkGraphFactory.eINSTANCE.createElkNode();
    }

    @objid ("a480a33f-82f5-494a-bdfd-f5e3ec207185")
    public final ILayoutAlgorithme withDiagram(AbstractDiagram diagram, IDiagramService diagramService) {
        this.diagram = diagram;
        this.diagramService = diagramService;
        return this;
    }

    @objid ("955346b0-9ed6-4837-8be9-dc71040dad4d")
    public final ILayoutAlgorithme withSelection(List<IDiagramNode> selection) {
        this.selection = selection;
        return this;
    }

    @objid ("df0d1e57-867e-46a3-ab81-e52e547e6a20")
    public void configureLayout() {
        this.graph.setProperty(CoreOptions.DEBUG_MODE, true);
        this.graph.setProperty(CoreOptions.NODE_SIZE_MINIMUM, new KVector(30, 30));
        this.graph.setProperty(CoreOptions.SPACING_EDGE_NODE, 60.0);
        this.graph.setProperty(CoreOptions.SPACING_EDGE_EDGE, 20.0);
        this.graph.setProperty(CoreOptions.SPACING_NODE_NODE, 60.0);
        this.graph.setProperty(CoreOptions.DEBUG_MODE, true);
        this.graph.setProperty(CoreOptions.NODE_SIZE_MINIMUM, new KVector(30, 30));
        this.graph.setProperty(CoreOptions.PORT_SIDE, PortSide.NORTH);
    }

    @objid ("8d8ad415-f3c1-4e08-b738-02f29d3d0b72")
    public void runLayout() {
        if (this.diagram == null || this.diagramService == null) {
            throw new IllegalStateException("Diagram and DiagramService must be set before running layout.");
        }

        try (IDiagramHandle diagramHandle = this.diagramService.getDiagramHandle(this.diagram)) {

            configureLayout();

            buildElkModel(diagramHandle);

            // Apply the layout algorithm
            IGraphLayoutEngine engine = new RecursiveGraphLayoutEngine();
            IElkProgressMonitor monitor = new NullElkProgressMonitor();
            engine.layout(this.graph, monitor);


            diagramHandle.setBatchMode(true);
            applyLayoutToModel(diagramHandle);
            diagramHandle.setBatchMode(false);
            diagramHandle.save();
        } catch (Exception e) {
            DiagramEditor.LOG.error(e);
        }
    }

    @objid ("da737fdd-9707-4fab-8e4f-d351af5ad910")
    public void buildElkModel(IDiagramHandle diagramHandle) {
        IDiagramDG diagramDg = diagramHandle.getDiagramNode();

        createElkNodes(diagramHandle, diagramDg);

        createElkLinks(diagramDg);

        createElkAbstractLink(diagramHandle, diagramDg);
    }

    @objid ("6889a921-395c-46d2-9dd0-b9373745cf75")
    private void createElkAbstractLink(IDiagramHandle diagramHandle, IDiagramDG diagramDg) {
        // Create abstract links for Notes, Constraints and Embedded Diagrams
        for (IDiagramNode nodeDg : diagramDg.getNodes()) {
            if (nodeDg.getElement() instanceof Note || nodeDg.getElement() instanceof Constraint) {
                List<IDiagramGraphic> sourceDg = diagramHandle.getDiagramGraphics(nodeDg.getElement().getCompositionOwner());
                if (!sourceDg.isEmpty() && sourceDg.get(0) instanceof IDiagramNode) {
                    createAbstractEdge((IDiagramNode) sourceDg.get(0), nodeDg);
                }
            } else if (nodeDg.getElement() instanceof AbstractDiagram) {
                AbstractDiagram embededDiagram = (AbstractDiagram) nodeDg.getElement();
                List<IDiagramGraphic> sourceDg = getEmbdedDiagramSourceDg(embededDiagram, diagramHandle);
                if (!sourceDg.isEmpty() && sourceDg.get(0) instanceof IDiagramNode) {
                    createAbstractEdge((IDiagramNode) sourceDg.get(0), nodeDg);
                }
            }
        }
    }

    @objid ("cedeb389-ad3e-4bde-8e26-2196d94b9c95")
    protected void createElkLinks(IDiagramDG diagramDg) {
        for (IDiagramLink linkDg : ElkModelUtils.getAllLinks(diagramDg)) {
            if (linkDg.getElement() instanceof ProvidedInterface || linkDg.getElement() instanceof RequiredInterface) {
                // Do not layout ProvidedInterface and RequiredInterface links
                continue;
            }

            IDiagramGraphic source = linkDg.getFrom();
            IDiagramGraphic target = linkDg.getTo();

            if (selection == null || (inInSelection(this.selection, source) && inInSelection(this.selection, target))) {
                this.elkLinks.put(linkDg, this.createElkLinks(linkDg));
            }
        }
    }

    @objid ("6888211e-c154-4658-8dda-67a0f2e65231")
    protected void createElkNodes(IDiagramHandle handle, IDiagramNode ownerDg) {
        for (IDiagramNode nodeDg : ownerDg.getNodes(Role.INNER)) {
            if (inInSelection(this.selection, nodeDg)) {
                ElkNode currentNode = this.createElkNode(handle, nodeDg);
                this.elkNodes.put(nodeDg, currentNode);
                createElkNodes(handle, nodeDg);
            } else {
                createElkNodes(handle, nodeDg);
            }
        }
    }

    @objid ("e52a8f34-49d3-46fb-9317-c7a88d3e38f6")
    private boolean inInSelection(List<IDiagramNode> selection, IDiagramGraphic nodeDg) {
        if (this.selection == null) {
            return true;
        }
        return this.selection.stream().map(dg -> dg.getElement()).anyMatch(nodeDg.getElement()::equals);
    }

    @objid ("b602bb94-a89c-471e-8ee0-f473d1a37665")
    private List<IDiagramGraphic> getEmbdedDiagramSourceDg(AbstractDiagram diag, IDiagramHandle diagramHandle) {
        for (Dependency dep : diag.getImpactedDependency()) {
            if (dep.getExtension().size() > 0 && dep.getExtension().get(0).getName().equals("related_diagram")) {
                return diagramHandle.getDiagramGraphics(dep.getImpacted());
            }
        }
        return new ArrayList<>();
    }

    @objid ("f867c066-88a0-45a9-bf9e-c782e2f55fcd")
    protected ElkNode createElkNode(IDiagramHandle handle, IDiagramNode nodeDg) {
        ElkNode gnode = ElkGraphFactory.eINSTANCE.createElkNode();

        ElkNode parent = getClosedParent(handle, nodeDg);

        gnode.setProperty(CoreOptions.PADDING, new ElkPadding(40.0));
        parent.setProperty(LayeredOptions.SPACING_BASE_VALUE, 80.0);
        parent.setProperty(CoreOptions.SPACING_NODE_NODE, 60.0);
        parent.setProperty(CoreOptions.SPACING_COMPONENT_COMPONENT, 60.0);
        parent.setProperty(CoreOptions.SPACING_EDGE_NODE, 60.0);
        parent.setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 80.0);
        parent.setProperty(CoreOptions.PORT_SIDE, PortSide.NORTH);

        gnode.setIdentifier(nodeDg.getElement().getUuid());
        gnode.setDimensions(nodeDg.getBounds().width, nodeDg.getBounds().height);
        parent.getChildren().add(gnode);

        // Port
        Collection<IDiagramNode> dgPorts = nodeDg.getNodes(Role.PORT);
        for (IDiagramNode childPort : dgPorts) {
            ElkPort elkPort = createElkPort(handle, childPort);
            elkPort.setParent(gnode);
            gnode.getPorts().add(elkPort);
            this.elkNodes.put(childPort, elkPort);
        }

        return gnode;
    }

    @objid ("faf3be91-fd88-4ebb-98de-fc696a84ab36")
    public ElkNode getClosedParent(IDiagramHandle handle, IDiagramNode nodeDg) {
        IDiagramNode currentDg = nodeDg;
        ElkConnectableShape result = null;

        while ((result == null) && (currentDg != null)) {

            IDiagramGraphic parentDg = currentDg.getParent();
            if (parentDg == null) {
                parentDg = handle.getDiagramGraphics(nodeDg.getElement().getCompositionOwner()).get(0);
            }

            if (parentDg.getElement() instanceof AbstractDiagram) {
                result = this.graph;
                currentDg = (IDiagramNode) parentDg;
            } else if (parentDg instanceof IDiagramNode) {
                result = this.elkNodes.get(parentDg);
                currentDg = (IDiagramNode) parentDg;
            }
        }

        if ((result != null) && (result instanceof ElkNode)) {
            return (ElkNode) result;
        } else {
            return this.graph;
        }
    }

    @objid ("dbb266a9-4bd4-4f8a-8e96-7b0bb72b817b")
    protected ElkPort createElkPort(IDiagramHandle handle, IDiagramNode portDg) {
        ElkNode parent = getClosedParent(handle, portDg);
        ElkPort gport = ElkGraphFactory.eINSTANCE.createElkPort();
        gport.setWidth(portDg.getBounds().width);
        gport.setHeight(portDg.getBounds().height);
        gport.setProperty(CoreOptions.NODE_SIZE_FIXED_GRAPH_SIZE, true);
        parent.getPorts().add(gport);
        gport.setIdentifier(portDg.getElement().getUuid());
        return gport;
    }

    @objid ("8b9c267a-ceb5-47c3-876f-ae360f42ca70")
    protected List<ElkEdge> createElkLinks(IDiagramLink dgLink) {
        IDiagramGraphic dgSrc = dgLink.getFrom();
        IDiagramGraphic dgTarget = dgLink.getTo();

        ElkConnectableShape graphSrc = this.elkNodes.get(dgSrc);
        ElkConnectableShape graphTarget = this.elkNodes.get(dgTarget);

        if ((graphSrc != null) && (graphTarget != null)) {
            String uuid = dgLink.getElement().getUuid();
            return createEdges(dgSrc, dgTarget, uuid);
        } else {
            DiagramEditor.LOG.error("Link " + dgLink.getElement().getName() + " has no source or target");
            return null;
        }
    }

    @objid ("9fdc9f96-6f35-4ce3-875c-5384f9145862")
    private List<IDiagramNode> getParents(IDiagramNode node, boolean isIncluded) {
        List<IDiagramNode> parents = new ArrayList<>();

        if (isIncluded) {
            parents.add(node);
        }

        IDiagramGraphic parent = node.getParent();

        while (parent != null) {
            if (parent instanceof IDiagramNode) {
                IDiagramNode parentNode = (IDiagramNode) parent;
                parents.add(0, parentNode);
                parent = parentNode.getParent();
            } else {
                parent = null;
            }
        }

        return parents;
    }

    @objid ("21182e71-e2f5-4987-8f23-3535d55e8b92")
    private List<IDiagramNode> getSmallCommunParent(List<IDiagramNode> srcs, List<IDiagramNode> trgts) {
        List<IDiagramNode> result = new ArrayList<>();
        List<IDiagramNode> commun = new ArrayList<>();

        for (IDiagramNode src : srcs) {
            if (trgts.contains(src)) {
                commun.add(src);
            } else {
                result.add(0, src);
            }
        }

        trgts.removeAll(commun);
        result.addAll(trgts);

        return result;
    }

    @objid ("87c3478b-20ce-442c-9468-70424b4fc48e")
    protected List<ElkEdge> createEdges(IDiagramGraphic dgSrc, IDiagramGraphic dgTarget, String uuid) {
        List<ElkEdge> result = new ArrayList<ElkEdge>();

        ElkConnectableShape graphSrc = this.elkNodes.get(dgSrc);
        ElkConnectableShape graphTarget = this.elkNodes.get(dgTarget);

        if (graphSrc instanceof ElkPort) {
            final ElkConnectableShape graphSrcCoppy = graphSrc;
            // If the source is a port, we need to get the parent node
            dgSrc = this.elkNodes.entrySet().stream().filter(entry -> entry.getValue().equals(((ElkPort) graphSrcCoppy).getParent())).map(Map.Entry::getKey).findFirst().orElse(null);
        }

        if (dgTarget instanceof ElkPort) {
            final ElkConnectableShape graphTargetCoppy = graphTarget;
            // If the source is a port, we need to get the parent node
            dgTarget = this.elkNodes.entrySet().stream().filter(entry -> entry.getValue().equals(((ElkPort) graphTargetCoppy).getParent())).map(Map.Entry::getKey).findFirst().orElse(null);
        }

        List<IDiagramNode> scps = getSmallCommunParent(getParents((IDiagramNode) dgSrc, false), getParents((IDiagramNode) dgTarget, false));

        for (IDiagramNode scp : scps) {
            ElkConnectableShape target = this.elkNodes.get(scp);
            ElkPort portTrgt = ElkGraphUtil.createPort((ElkNode) target);
            portTrgt.setIdentifier(UUID.randomUUID().toString());
            portTrgt.setParent((ElkNode) target);

            ElkEdge edge = createEdge(graphSrc, portTrgt, UUID.randomUUID().toString());

            result.add(edge);
            graphSrc = portTrgt;
        }

        result.add(createEdge(graphSrc, graphTarget, uuid));
        return result;
    }

    @objid ("c5281532-32db-4c3e-9870-798f043cf7f6")
    private ElkEdge createEdge(ElkConnectableShape graphSrc, ElkConnectableShape graphTarget, String uuid) {
        ElkEdge edge = ElkGraphUtil.createSimpleEdge(graphSrc, graphTarget);
        edge.setProperty(LayeredOptions.PRIORITY_DIRECTION, 10);
        edge.setIdentifier(uuid);
        return edge;
    }

    @objid ("36edbbb3-7b55-4460-a3f4-10b29a7b42bc")
    protected ElkEdge createAbstractEdge(IDiagramNode source, IDiagramNode target) {
        ElkConnectableShape graphSrc = this.elkNodes.get(source);
        ElkConnectableShape graphTarget = this.elkNodes.get(target);
        if ((graphSrc != null) && (graphTarget != null)) {
            ElkEdge edge = ElkGraphUtil.createSimpleEdge(graphSrc, graphTarget);
            edge.setProperty(LayeredOptions.PRIORITY_DIRECTION, 0);
            edge.setIdentifier("ABSTRACT");
            return edge;
        } else {
            DiagramEditor.LOG.error("Abstract Link to " + target.getElement().getName() + " has no source or target");
            return null;
        }
    }

    @objid ("c2b8baba-647a-4006-a9bf-9cdfb32632e7")
    public void applyLayoutToModel(IDiagramHandle diagramHandle) {
        updateNodeDGModel(diagramHandle.getDiagramNode(), null);

        updateLinkDGModel(diagramHandle.getDiagramNode());
    }

    @objid ("10d65ea6-a03f-4242-8e04-dfb15dc04a32")
    private void updateNodeDGModel(IDiagramNode nodeDg, IDiagramNode parentDg) {
        if (this.selection == null || inInSelection(this.selection, nodeDg)) {
            if (!(nodeDg.getElement() instanceof AbstractDiagram)) {
                ElkConnectableShape shape = this.elkNodes.get(nodeDg);

                if (shape != null) {
                    Point delta = new Point(0, 0);
                    if (!inInSelection(this.selection, parentDg) && !(parentDg.getElement() instanceof AbstractDiagram)) {
                        delta = new Point(parentDg.getBounds().x, parentDg.getBounds().y);
                    } else {
                        delta = ElkModelUtils.getAbsDelta(shape, nodeDg);
                    }
                    ElkModelUtils.setBounds(shape, nodeDg, delta);


                }

            }
        }
        for (IDiagramNode childrenNode : nodeDg.getNodes()) {
            updateNodeDGModel(childrenNode, nodeDg);
        }
    }

    @objid ("ffdbaf29-2b0d-48cf-a7af-b201d8368e2c")
    protected void updateLinkDGModel(IDiagramDG diagramDg) {
        for (IDiagramLink linkDg : ElkModelUtils.getAllLinks(diagramDg)) {

            Point delta = new Point(0, 0);
            IDiagramNode  sourceDg = (IDiagramNode)linkDg.getFrom();
            ElkConnectableShape sourceShape = this.elkNodes.get(sourceDg);
            if(sourceShape != null) {
                delta = new Point((int)sourceDg.getBounds().x -sourceShape.getX() ,(int) sourceDg.getBounds().y -sourceShape.getY());
            }


            List<ElkEdge> edges = this.elkLinks.get(linkDg);
            ILinkPath path = linkDg.getPath();
            linkDg.setRouterKind(IDiagramLink.LinkRouterKind.ORTHOGONAL);
            if (edges != null && path != null) {
                ElkModelUtils.updateLinkPath(edges, path, delta);
                linkDg.setPath(path);
            }
        }
    }

    @objid ("a4432e0f-fce9-4950-9b10-5d4c692dfc94")
    protected void translate(IDiagramHandle diagramHandle, Point translation) {
        IDiagramDG diagramDg = diagramHandle.getDiagramNode();
        for (IDiagramNode nodeDg : diagramDg.getNodes()) {
            Rectangle bounds = nodeDg.getBounds();
            Rectangle newBounds = bounds.getTranslated(translation);
            nodeDg.setBounds(newBounds);
        }

        for (IDiagramLink linkDg : ElkModelUtils.getAllLinks(diagramDg)) {
            List<ElkEdge> edges = this.elkLinks.get(linkDg);
            ILinkPath path = linkDg.getPath();
            if (edges != null && path != null) {
                ElkModelUtils.updateLinkPath(edges, path, translation);
                linkDg.setPath(path);
            }
        }
    }

    @objid ("d37c7069-d1cc-4263-b211-f06385c0055a")
    protected ElkNode getElkModel() {
        return this.graph;
    }

    @objid ("2c73e998-9f30-4014-b84e-2c16d2a94f0e")
    public List<IDiagramNode> getSelection() {
        return this.selection;
    }

    /**
     * Compact the diagram bounds by translating all nodes to the top-left corner.
     * This will remove empty space around the diagram and set a new size for the
     * diagram.
     */
    @objid ("4fcb3d5e-deb5-4ba9-a856-de42b5348b08")
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

            // Aligne Elk dimensions with the new bounds
            //this.graph.setWidth(diagramDg.getBounds().width);
            //this.graph.setHeight(diagramDg.getBounds().height);

            diagramHandle.save();

        }
    }

    @objid ("945ecf44-c0e4-4b14-a435-3e1b9e52f86e")
    public void postProcessing() {
        // Nothing to do by default
    }

    @objid ("2faae772-8c87-4994-a3d6-366b22841bf2")
    public ElkNode getElkRootNode() {
        return this.graph;
    }

    @objid ("25f460c1-5f70-4d18-a96f-bd58e33a1c04")
    public AbstractDiagram getDiagram() {
        return this.diagram;
    }

    @objid ("051cd846-542c-4e33-a729-52f95af89aaa")
    public IDiagramService getDiagramService() {
        return this.diagramService;
    }

    @objid ("a80319c8-2e42-49cf-a35a-36febe872ae6")
    public Map<IDiagramNode, ElkConnectableShape> getElkNodes() {
        return this.elkNodes;
    }

    @objid ("622994b6-cd8a-49fd-ac78-cf86ccd64c51")
    public Map<IDiagramLink, List<ElkEdge>> getElKLinks() {
        return this.elkLinks;
    }

}
