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
package org.modelio.bpmn.diagram.editor.wizard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.viewers.ISelection;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.ILinkPoint;
import org.modelio.api.modelio.diagram.ILinkRoute;
import org.modelio.api.modelio.diagram.InvalidLinkPathException;
import org.modelio.api.modelio.model.IModelingSession;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.api.modelio.model.IUmlModel;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessDesignDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnSubProcessDiagram;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnEndEvent;
import org.modelio.metamodel.bpmn.events.BpmnStartEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * This model transformer gathers every selected {@link BpmnFlowNode} into a {@link BpmnSubProcess}, keeping the link's layout between them.
 * <p>
 * Flows which source or target is not moved into the sub process are considered outside the scope and are rerouted to link the {@link BpmnSubProcess} itself instead.
 * </p>
 */
@objid ("8ca1f2b9-6dda-4366-958c-9247589724bf")
public class GroupAsSubProcessTransformer implements IModelTransformer {
    @objid ("6e614460-a404-470a-9038-2ec00fd3ec5a")
    private boolean wellformed = true;

    @objid ("cabe852a-3c47-40e7-b058-c86c0988d36c")
    private List<BpmnSequenceFlow> inLinks = new ArrayList<>();

    @objid ("2d1bd20a-f48c-446c-82ce-01cf8317df76")
    private List<BpmnSequenceFlow> outLinks = new ArrayList<>();

    @objid ("5789bdd6-de52-4159-b3c3-90504640f885")
    private Set<BpmnSequenceFlow> links = new HashSet<>();

    @objid ("c5d5cf7f-e52d-4a39-8602-cce79ad221b6")
    private List<BpmnDataAssociation> inDataLinks = new ArrayList<>();

    @objid ("d06f94ad-0dd6-44bc-9907-febda1a45963")
    private List<BpmnDataAssociation> outDataLinks = new ArrayList<>();

    @objid ("ef39f1bc-26f5-4574-873c-e687695b75c9")
    private List<BpmnSequenceFlow> newLinks = new ArrayList<>();

    @objid ("9483fc73-d9f7-4766-a7d3-79470ae93d6f")
    private Set<BpmnDataAssociation> dataLinks = new HashSet<>();

    @objid ("f03d102c-a5f6-4093-9f41-59e0accba0c6")
    private final Point defaultPosition = new Point(50, 50);

    @objid ("7b128e6e-8e88-4634-9218-5bb7f68a4446")
    private final Point defaultInterval = new Point(80, 0);

    @objid ("06e60948-542a-4b34-9548-ea40a473417a")
    private BpmnFlowNode startPoint;

    @objid ("47b883eb-884d-423a-9e8b-bf3a90d1920c")
    private BpmnFlowNode endPoint;

    @objid ("1aa87db2-f058-45ae-b45d-15c41e6564c5")
    private BpmnStartEvent startEvent;

    @objid ("ec21a284-7586-4975-9170-244e1cf6b105")
    private BpmnEndEvent endEvent;

    @objid ("0221badf-1558-497d-bd87-2d59697a257c")
    private Set<BpmnLane> lanes = new HashSet<>();

    @objid ("8cf6e259-004f-4483-86f4-16637b8431e1")
    private List<BpmnFlowNode> nodes = new ArrayList<>();

    @objid ("4203401f-6a29-434f-8dc7-2e1132957def")
    private List<BpmnItemAwareElement> dataNodes = new ArrayList<>();

    @objid ("0474bdfd-23ff-4833-9059-07f65718e0e4")
    @Inject
    private IModuleContext moduleContext;

    /**
     * Criteria:
     * <ul>
     * <li>process design diagram or subprocess diagram
     * <li>selection contains only flow nodes
     * </ul>
     *
     * @see IModelTransformer#isAvailable(AbstractDiagram, ISelection)
     */
    @objid ("1e2098b1-f3d8-4bf1-ade2-0519b17a40bb")
    @Override
    public boolean isAvailable(AbstractDiagram diagram, ISelection selection) {
        init();

        List<MObject> elements = SelectionHelper.toList(selection, MObject.class);
        if (!parse(elements)) {
        return false;
        }

        // In a BPMN diagram
        if (!(diagram instanceof BpmnSubProcessDiagram) && !(diagram instanceof BpmnProcessDesignDiagram)) {
        return false;
        }

        return true;
    }

    /**
     * Criteria:
     * <ul>
     * <li>process design diagram or subprocess diagram
     * <li>selection conforms to the processable selection scheme: only flow nodes, homogeneous incoming and outgoing links.
     * </ul>
     *
     * @see IModelTransformer#isAvailable(AbstractDiagram, ISelection)
     */
    @objid ("dbf0ed60-33df-4dd4-bdf9-fdaafc82d7e0")
    @Override
    public boolean canExecute(AbstractDiagram diagram, ISelection selection) {
        for (BpmnFlowNode fn : this.nodes) {
        if (fn instanceof BpmnStartEvent || fn instanceof BpmnEndEvent) {
        return false;
        }
        }

        if (this.inLinks.size() >= 1) {
        BpmnFlowNode ref = this.inLinks.get(0).getTargetRef();
        this.startPoint = ref;
        for (BpmnSequenceFlow il : this.inLinks) {
        if (!Objects.equals(ref, il.getTargetRef())) {
        // requires either exactly 0..1 input flow or several input flows to the same activity node
        return false;
        }
        }
        }

        if (this.outLinks.size() >= 1) {
        BpmnFlowNode ref = this.outLinks.get(0).getSourceRef();
        this.endPoint = ref;
        for (BpmnSequenceFlow ol : this.outLinks) {
        if (!Objects.equals(ref, ol.getSourceRef())) {
        // requires either exactly 0..1 output flow or several out flows from the same activity node
        return false;
        }
        }
        }

        return !this.nodes.isEmpty() && this.wellformed;
    }

    @objid ("0c9d58a2-8734-4d5a-8c5b-c109fd7a9e8c")
    private boolean parse(List<MObject> elements) {
        for (MObject elt : elements) {
        if (elt instanceof BpmnFlowNode) {
        BpmnFlowNode node = (BpmnFlowNode) elt;
        if (this.nodes.contains(node)) {
        continue;
        }
        parseBpmnFlowNode(elements, node);
        }

        if (elt instanceof BpmnItemAwareElement) {
        BpmnItemAwareElement node = (BpmnItemAwareElement) elt;
        if (this.dataNodes.contains(node)) {
        continue;
        }
        parseBpmnItem(elements, node);
        }
        }

        return !(this.nodes.isEmpty()) || !(this.dataNodes.isEmpty());
    }

    @objid ("1e70b822-3764-4241-ae53-04f6a835714f")
    private void init() {
        this.inLinks.clear();
        this.outLinks.clear();
        this.links.clear();

        this.inDataLinks.clear();
        this.outDataLinks.clear();
        this.dataLinks.clear();

        this.nodes.clear();
        this.dataNodes.clear();

        this.wellformed = true;
        this.startEvent = null;
        this.endEvent = null;
        this.startPoint = null;
        this.endPoint = null;

        this.newLinks = new ArrayList<BpmnSequenceFlow>();
    }

    @objid ("f4032518-12f5-4e97-b636-a23bfb2e26df")
    private void parseBpmnItem(List<MObject> elements, BpmnItemAwareElement node) {
        for (BpmnDataAssociation flow : node.getSourceOfDataAssociation()) {
        MObject target = getTarget(flow);
        if (elements.contains(target)) {
        // subprocess internal link
        this.dataLinks.add(flow);
        } else {
        // subprocess outgoing link
        if (target instanceof BpmnFlowNode) {
        this.wellformed = false;
        }else {
        this.outDataLinks.add(flow);
        }
        }
        }

        for (BpmnDataAssociation flow : node.getTargetOfDataAssociation()) {
        MObject source = getSource(flow);
        if (elements.contains(source)) {
        // subprocess internal link
        this.dataLinks.add(flow);
        } else {
        // subprocess ingoing link
        if (source instanceof BpmnFlowNode) {
        this.wellformed = false;
        }else {
        this.inDataLinks.add(flow);
        }
        }
        }

        this.dataNodes.add(node);
        this.lanes.addAll(node.getLane());
    }

    @objid ("d54482cf-8c17-4d5e-8212-a9fb9a299fb5")
    private void parseBpmnFlowNode(List<MObject> elements, BpmnFlowNode node) {
        //case of BpmnFlowNode
        for (BpmnSequenceFlow flow : node.getOutgoing()) {
        if (elements.contains(flow.getTargetRef())) {
        // subprocess internal link
        this.links.add(flow);
        } else {
        // subprocess outgoing link
        this.outLinks.add(flow);
        }
        }

        for (BpmnSequenceFlow flow : node.getIncoming()) {
        if (elements.contains(flow.getSourceRef())) {
        // subprocess internal link
        this.links.add(flow);
        } else {
        // subprocess incoming link
        this.inLinks.add(flow);
        }
        }

        //case of BpmnActivity
        if (node instanceof BpmnActivity) {
        BpmnActivity act = (BpmnActivity) node;

        for (BpmnDataAssociation flow : act.getDataInputAssociation()) {
        if (elements.contains(flow.getTargetRef())) {
        // subprocess internal link
        this.dataLinks.add(flow);
        } else {
        // subprocess outgoing link
        this.outDataLinks.add(flow);
        }
        }

        for (BpmnDataAssociation flow : act.getDataOutputAssociation()) {
        if (elements.contains(flow.getSourceRef().get(0))) {
        // subprocess internal link
        this.dataLinks.add(flow);
        } else {
        // subprocess ingoing link
        this.inDataLinks.add(flow);
        }
        }
        }

        //case of BpmnThrowEvent
        if (node instanceof BpmnThrowEvent) {
        BpmnThrowEvent throwEvent = (BpmnThrowEvent) node;

        for (BpmnDataAssociation flow : throwEvent.getDataInputAssociation()) {
        if (elements.contains(flow.getTargetRef())) {
        // subprocess internal link
        this.dataLinks.add(flow);
        } else {
        // subprocess outgoing link
        this.outDataLinks.add(flow);
        }
        }
        }

        //case of BpmnCatchEvent
        if (node instanceof BpmnCatchEvent) {
        BpmnCatchEvent catchEvent = (BpmnCatchEvent) node;

        for (BpmnDataAssociation flow : catchEvent.getDataOutputAssociation()) {
        if (elements.contains(flow.getSourceRef().get(0))) {
        // subprocess internal link
        this.dataLinks.add(flow);
        } else {
        // subprocess ingoing link
        this.inDataLinks.add(flow);
        }
        }
        }

        this.nodes.add(node);
        this.lanes.addAll(node.getLane());
    }

    @objid ("ab8b7bac-9dea-4f99-958d-7f9091389d3e")
    @Override
    public List<MObject> transform(AbstractDiagram diagram, ISelection selection) {
        BpmnSubProcess subprocess;

        try (ITransaction tr = this.moduleContext.getModelingSession().createTransaction("SubProcessLayout")) {
        setStartAndEndPoints();

        MObject owner = getCompositionOwner();

        Map<Object, Rectangle> nodeGeometry = getNodeGeometry(diagram);
        Map<MObject, ILinkRoute> linkGeometry = getLinkGeometry(diagram);
        BpmnProcess temporaryProcess = storeTemporaryElement(owner);
        subprocess = createSubprocess(owner, nodeGeometry, linkGeometry, diagram);

        temporaryProcess.delete();

        tr.commit();
        }

        return Arrays.asList(subprocess);
    }

    @objid ("387cdb6e-6989-44e1-9ac2-336d23151f76")
    private void setStartAndEndPoints() {
        if ((this.startPoint == null) || (this.endPoint == null)){
        for (BpmnFlowNode node : this.nodes) {
        if ((this.startPoint == null) && (node.getIncoming().size() == 0)) {
        this.startPoint = node;
        }

        if ( (this.endPoint == null) && (node.getOutgoing().size() == 0)) {
        this.endPoint = node;
        }
        }
        }
    }

    @objid ("4152a1e9-09d1-43d8-9b08-c9df6e9cd33d")
    private BpmnBaseElement getTarget(BpmnDataAssociation dataAssociation) {
        if (dataAssociation.getEndingActivity() != null) {
        return dataAssociation.getEndingActivity();
        }else if (dataAssociation.getEndingEvent() != null) {
        return dataAssociation.getEndingEvent();
        }

        return dataAssociation.getTargetRef();
    }

    @objid ("41ab1259-12a7-4392-84d5-99f13fd4bcc3")
    private BpmnBaseElement getSource(BpmnDataAssociation dataAssociation) {
        if (dataAssociation.getStartingActivity() != null) {
        return dataAssociation.getStartingActivity();
        }else if (dataAssociation.getStartingEvent() != null) {
        return dataAssociation.getStartingEvent();
        }

        if (!dataAssociation.getSourceRef().isEmpty())
        return dataAssociation.getSourceRef().get(0);

        return null;
    }

    @objid ("dc7a63ec-5c35-41b8-ac4e-b1f69534b8ef")
    private MObject getCompositionOwner() {
        if (!(this.nodes.isEmpty()))
        return this.nodes.get(0).getCompositionOwner();

        if (!(this.dataNodes.isEmpty()))
        return this.dataNodes.get(0).getCompositionOwner();

        return null;
    }

    @objid ("74a94d4f-78d3-4630-a1ff-f749b0f6d689")
    private void layoutSubProcess(AbstractDiagram diagram, BpmnSubProcess subprocess, Map<Object, Rectangle> nodeGeometry, Map<MObject, ILinkRoute> linkGeometry) {
        IDiagramService ds = this.moduleContext.getModelioServices().getDiagramService();

        try (IDiagramHandle dh = ds.getDiagramHandle(diagram)) {

        //Copy diagram properties
        IDiagramNode dg = (IDiagramNode) getDiagramGraphic(dh, subprocess);

        if (dg == null) {
        dg = (IDiagramNode) dh.unmask(subprocess, nodeGeometry.get("global").x, nodeGeometry.get("global").y).get(0);
        }

        if (dg != null) {
        dg.setBounds(nodeGeometry.get("global").getCopy());
        dg.setProperty("SUBPROCESS_SHOWCONTENT", "false");
        }

        //Mask and unmask external links and datalinks
        for (BpmnSequenceFlow f : this.inLinks) {
        IDiagramLink dg1 = (IDiagramLink) getDiagramGraphic(dh, f);
        if (dg1 != null) {
        dh.mask(dg1);
        }
        }

        for (BpmnSequenceFlow f : this.outLinks) {
        IDiagramLink dg1 = (IDiagramLink) getDiagramGraphic(dh, f);
        if (dg1 != null) {
        dh.mask(dg1);
        }
        }

        for (BpmnDataAssociation f : this.inDataLinks) {
        IDiagramLink dg1 = (IDiagramLink) getDiagramGraphic(dh, f);
        if (dg1 != null) {
        dh.mask(dg1);
        }
        }

        for (BpmnDataAssociation f : this.outDataLinks) {
        IDiagramLink dg1 = (IDiagramLink) getDiagramGraphic(dh, f);
        if (dg1 != null) {
        dh.mask(dg1);
        }
        }

        dh.save();
        }
    }

    @objid ("a7a4e31c-d730-48cb-8074-508d4378e669")
    private BpmnProcess storeTemporaryElement(MObject owner) {
        IModelingSession session = this.moduleContext.getModelingSession();

        while (!(owner instanceof NameSpace)) {
        owner = owner.getCompositionOwner();
        }

        BpmnProcess temporaryProcess = null;


        temporaryProcess = session.getModel().createBpmnProcess();
        temporaryProcess.setOwner((NameSpace) owner);

        for (BpmnFlowNode move : this.nodes) {
        move.setContainer(temporaryProcess);
        move.getLane().clear();
        }

        for (BpmnSequenceFlow move : this.links) {
        move.setContainer(temporaryProcess);
        move.getLane().clear();
        }

        for (BpmnItemAwareElement move : this.dataNodes) {
        move.setContainer(temporaryProcess);
        move.getLane().clear();
        }

        return temporaryProcess;
    }

    @objid ("70a9b126-3561-470d-a8e5-749015668e07")
    private void layoutSubprocessDiagram(IDiagramService ds, Map<Object, Rectangle> nodeGeometry, Map<MObject, ILinkRoute> linkGeometry, BpmnSubProcessDiagram spdiagram, Point translation) {
        try (IDiagramHandle dhsp = ds.getDiagramHandle(spdiagram)) {

        Point offset = new Point(translation);
        offset = offset.getTranslated(this.defaultInterval);
        offset = offset.getTranslated(this.defaultPosition);

        layoutNodes(dhsp, nodeGeometry, offset);

        layoutLinks(dhsp, linkGeometry, offset);

        dhsp.save();
        }
    }

    @objid ("443b730e-3b21-4af1-8329-29fc2b51a14f")
    private void layoutNodes(IDiagramHandle dhsp, Map<Object, Rectangle> nodeGeometry, final Point offset) {
        // Get nodes back in place
        for (BpmnFlowNode e : this.nodes) {
        Rectangle bounds = nodeGeometry.get(e).translate(offset);

        IDiagramNode dg1 = (IDiagramNode) getDiagramGraphic(dhsp, e);
        if (dg1 == null) {
        List<IDiagramGraphic> dgs = dhsp.unmask(e, bounds.x, bounds.y);
        dg1 = dgs.isEmpty() ? null : (IDiagramNode) dgs.get(0);
        }
        if (dg1 != null) {
        dg1.setBounds(bounds);
        }
        }


        for (BpmnItemAwareElement e : this.dataNodes) {
        Rectangle bounds = nodeGeometry.get(e).translate(offset);

        IDiagramNode dg1 = (IDiagramNode) getDiagramGraphic(dhsp, e);
        if (dg1 == null) {
        List<IDiagramGraphic> dgs = dhsp.unmask(e, bounds.x, bounds.y);
        dg1 = dgs.isEmpty() ? null : (IDiagramNode) dgs.get(0);
        }
        if (dg1 != null) {
        dg1.setBounds(bounds);
        }
        }

        //unmask starting point
        Rectangle startingBounds = new Rectangle(nodeGeometry.get(this.startPoint));
        startingBounds = startingBounds.getTranslated(this.defaultInterval.negate());

        List<IDiagramGraphic> dgs = dhsp.getDiagramGraphics(this.startEvent);
        IDiagramNode dg1 = dgs.isEmpty() ? null : (IDiagramNode) dgs.get(0);

        if (dg1 != null) {
        Rectangle actualBounds = dg1.getBounds();
        actualBounds.setX(startingBounds.x);
        actualBounds.setY(startingBounds.y + (startingBounds.height /2) - (actualBounds.height() /2) );
        dg1.setBounds(actualBounds);
        }

        //unmask ending point
        Rectangle endingBounds = new Rectangle(nodeGeometry.get(this.endPoint));
        endingBounds = endingBounds.getTranslated(this.defaultInterval.negate());

        dgs = dhsp.getDiagramGraphics(this.endEvent);
        dg1 = dgs.isEmpty() ? null : (IDiagramNode) dgs.get(0);

        if (dg1 != null) {
        Rectangle actualBounds = dg1.getBounds();
        actualBounds.setX(endingBounds.x + endingBounds.width());
        actualBounds.setY(endingBounds.y + (endingBounds.height/2) - (actualBounds.height()/2));
        dg1.setBounds(actualBounds);
        }
    }

    @objid ("5ad27bb7-a6d0-4968-b4b6-9096a3bdbf40")
    private void layoutLinks(IDiagramHandle dhsp, Map<MObject, ILinkRoute> linkGeometry, final Point offset) {
        // Now that nodes are placed, fix the link layout

        for (BpmnSequenceFlow link : this.links) {
        layoutLink(dhsp, linkGeometry, offset, link);
        }

        for (BpmnDataAssociation link : this.dataLinks) {
        layoutLink(dhsp, linkGeometry, offset, link);
        }

        for (BpmnSequenceFlow link : this.newLinks) {
        dhsp.unmask(link, 0, 0);
        }
    }

    @objid ("e2e641b2-2838-486b-b002-852f6e2fce37")
    private void layoutLink(IDiagramHandle dhsp, Map<MObject, ILinkRoute> linkGeometry, final Point offset, BpmnBaseElement link) {
        final Point tmp = new Point();
        ILinkRoute linkPath = linkGeometry.get(link);

        if (linkPath != null) {
        IDiagramLink dg1 = (IDiagramLink) getDiagramGraphic(dhsp, link);
        if (dg1 == null) {
        List<IDiagramGraphic> dgs = dhsp.unmask(link, 0, 0);
        dg1 = dgs.isEmpty() ? null : (IDiagramLink) dgs.get(0);
        }

        if (dg1 != null) {
        try {
        List<ILinkPoint> points = linkPath.getAllPoints();
        for (ILinkPoint p : points) {
        p.setLocation(p.getLocation(tmp).translate(offset));
        }
        dg1.setRoute(linkPath);
        } catch (@SuppressWarnings ("unused") InvalidLinkPathException e1) {
        // Invalid path, let the auto-unmask do its job
        dg1.mask();
        }
        }
        }
    }

    @objid ("ecc2cf3e-d303-40fa-828e-a991baa6e777")
    private IDiagramGraphic getDiagramGraphic(IDiagramHandle dh, MObject o) {
        List<IDiagramGraphic> dgs = dh.getDiagramGraphics(o);
        return dgs.isEmpty() ? null : dgs.get(0);
    }

    @objid ("ecec32bd-383b-4bb9-bca0-695de902ab88")
    private BpmnSubProcess createSubprocess(MObject owner, Map<Object, Rectangle> nodeGeometry, Map<MObject, ILinkRoute> linkGeometry, AbstractDiagram ownerDiagram) {
        IModelingSession session = this.moduleContext.getModelingSession();

        BpmnSubProcess newSubProcess = null;

        // Create a sub process
        newSubProcess = createSubProcess(owner, session);

        // Create a subprocess diagram
        BpmnSubProcessDiagram subProcessDiagram = createSubProcessDiagram(newSubProcess, session);

        //Attach nodes to created Sub Process
        attachNodes(newSubProcess, subProcessDiagram, ownerDiagram);

        //Attach links to created Sub Process
        attachLinks(newSubProcess, subProcessDiagram);

        //Layout nodes and links in new diagram
        layoutSubProcess(ownerDiagram, newSubProcess, nodeGeometry, linkGeometry);


        IDiagramService ds = this.moduleContext.getModelioServices().getDiagramService();

        // Mask Moved Elements
        maskNodes(ownerDiagram, ds);

        Point spTranslation = new Point(nodeGeometry.get("global").getTopLeft().negate());
        layoutSubprocessDiagram(ds, nodeGeometry, linkGeometry, subProcessDiagram, spTranslation);

        return newSubProcess;
    }

    @objid ("6a8ee96d-5588-46fc-a144-b9644876e2e8")
    private void maskNodes(AbstractDiagram ownerDiagram, IDiagramService ds) {
        // Mask Moved Elements
        try (IDiagramHandle dh = ds.getDiagramHandle(ownerDiagram)) {
        for (BpmnFlowNode e : this.nodes) {
        for(IDiagramGraphic sdg :dh.getDiagramGraphics(e) ) {
        dh.mask(sdg);
        }
        }
        dh.save();
        dh.close();
        }
    }

    @objid ("21881621-00ff-4f49-9abd-1b6ff436e3a0")
    private void attachLinks(BpmnSubProcess newSubProcess, BpmnSubProcessDiagram subProcessDiagram) {
        IUmlModel model = this.moduleContext.getModelingSession().getModel();
        for (BpmnSequenceFlow f : this.links) {
        setFlowElementParent(newSubProcess, f);
        }

        // Attach Sequence flow
        for (BpmnSequenceFlow incoming : this.inLinks) {
        BpmnSequenceFlow newFlow = model.createBpmnSequenceFlow();
        newFlow.setTargetRef(incoming.getTargetRef());
        newFlow.setSourceRef(this.startEvent);
        setFlowElementParent(newSubProcess, newFlow);
        this.newLinks.add(newFlow);
        incoming.setTargetRef(newSubProcess);
        }

        if (this.startEvent.getOutgoing().size() == 0) {
        BpmnSequenceFlow newFlow = model.createBpmnSequenceFlow();
        newFlow.setTargetRef(this.startPoint);
        newFlow.setSourceRef(this.startEvent);
        setFlowElementParent(newSubProcess, newFlow);
        this.newLinks.add(newFlow);
        }

        for (BpmnSequenceFlow outgoing : this.outLinks) {

        BpmnSequenceFlow newFlow = model.createBpmnSequenceFlow();
        newFlow.setSourceRef(outgoing.getSourceRef());
        newFlow.setTargetRef(this.endEvent);
        setFlowElementParent(newSubProcess, newFlow);
        this.newLinks.add(newFlow);
        outgoing.setSourceRef(newSubProcess);

        }

        if (this.endEvent.getIncoming().size() == 0) {
        BpmnSequenceFlow newFlow = model.createBpmnSequenceFlow();
        newFlow.setTargetRef(this.endEvent);
        newFlow.setSourceRef(this.endPoint);
        setFlowElementParent(newSubProcess, newFlow);
        this.newLinks.add(newFlow);
        }
    }

    @objid ("3c1881a4-984e-46df-b8b3-76c4cb730bfd")
    private void attachNodes(BpmnSubProcess newSubProcess, BpmnSubProcessDiagram subProcessDiagram, AbstractDiagram ownerDiagram) {
        for (BpmnFlowNode e : this.nodes) {
        setFlowElementParent(newSubProcess, e);
        }

        for (BpmnItemAwareElement e : this.dataNodes) {
        setFlowElementParent(newSubProcess, e);
        }
    }

    @objid ("a7005d73-1396-4abb-9261-930f559e44fc")
    private BpmnSubProcessDiagram createSubProcessDiagram(BpmnSubProcess newSubProcess, IModelingSession session) {
        BpmnSubProcessDiagram subProcessDiagram = session.getModel().createBpmnSubProcessDiagram();
        subProcessDiagram.setOrigin(newSubProcess);
        subProcessDiagram.setName("sub process diagram");

        return subProcessDiagram;
    }

    @objid ("0231c5d1-4476-48bb-9f96-6d1058be7db5")
    private BpmnSubProcess createSubProcess(MObject owner, IModelingSession session) {
        IUmlModel model = session.getModel();
        BpmnSubProcess newSubProcess = model.createBpmnSubProcess();
        setFlowElementParent(owner, newSubProcess);
        newSubProcess.setName("subprocess");

        for (BpmnLane lane : this.lanes) {
        lane.getFlowElementRef().add(newSubProcess);
        }

        this.startEvent = model.createBpmnStartEvent();
        setFlowElementParent(newSubProcess, this.startEvent);
        this.startEvent.setName("start");


        this.endEvent = model.createBpmnEndEvent();
        setFlowElementParent(newSubProcess, this.endEvent);
        this.endEvent.setName("end");

        return newSubProcess;
    }

    @objid ("ce404017-6624-4e51-b0ab-f1bfb5efc8d4")
    private void setFlowElementParent(MObject owner, BpmnFlowElement element) {
        if (owner instanceof BpmnSubProcess) {
        element.setContainer(null);
        element.setSubProcess((BpmnSubProcess) owner);
        } else if (owner instanceof BpmnProcess) {
        element.setSubProcess(null);
        element.setContainer((BpmnProcess) owner);
        }
    }

    @objid ("f0b3d746-0b6b-4b9c-98b1-410c39f125bd")
    private Map<Object, Rectangle> getNodeGeometry(AbstractDiagram diagram) {
        Map<Object, Rectangle> results = new HashMap<>();
        IDiagramService ds = this.moduleContext.getModelioServices().getDiagramService();
        try (IDiagramHandle dh = ds.getDiagramHandle(diagram)) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (MObject e : this.nodes) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramNode) {
        Rectangle bounds = ((IDiagramNode) dg).getBounds().getCopy();
        results.put(e, bounds);
        minX = Math.min(bounds.x(), minX);
        maxX = Math.max(bounds.x() + bounds.width(), maxX);
        minY = Math.min(bounds.y(), minY);
        maxY = Math.max(bounds.y() + bounds.height(), maxY);
        }
        }

        for (MObject e : this.dataNodes) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramNode) {
        Rectangle bounds = ((IDiagramNode) dg).getBounds().getCopy();
        results.put(e, bounds);
        minX = Math.min(bounds.x(), minX);
        maxX = Math.max(bounds.x() + bounds.width(), maxX);
        minY = Math.min(bounds.y(), minY);
        maxY = Math.max(bounds.y() + bounds.height(), maxY);
        }
        }

        results.put("global", new Rectangle(minX, minY, maxX - minX, maxY - minY));
        dh.save();
        }
        return results;
    }

    @objid ("e9c7673d-9e72-49c1-a43b-de84f7d4a8d2")
    private Map<MObject, ILinkRoute> getLinkGeometry(AbstractDiagram diagram) {
        Map<MObject, ILinkRoute> results = new HashMap<>();
        IDiagramService ds = this.moduleContext.getModelioServices().getDiagramService();

        try (IDiagramHandle dh = ds.getDiagramHandle(diagram)) {
        for (MObject e : this.links) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramLink) {
        ILinkRoute path = ((IDiagramLink) dg).getRoute();
        results.put(e, path);
        }
        }

        for (MObject e : this.inLinks) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramLink) {
        ILinkRoute path = ((IDiagramLink) dg).getRoute();
        results.put(e, path);
        }
        }

        for (MObject e : this.outLinks) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramLink) {
        ILinkRoute path = ((IDiagramLink) dg).getRoute();
        results.put(e, path);
        }
        }

        for (MObject e : this.dataLinks) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramLink) {
        ILinkRoute path = ((IDiagramLink) dg).getRoute();
        results.put(e, path);
        }
        }

        for (MObject e : this.inDataLinks) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramLink) {
        ILinkRoute path = ((IDiagramLink) dg).getRoute();
        results.put(e, path);
        }
        }

        for (MObject e : this.outDataLinks) {
        IDiagramGraphic dg = getDiagramGraphic(dh, e);
        if (dg instanceof IDiagramLink) {
        ILinkRoute path = ((IDiagramLink) dg).getRoute();
        results.put(e, path);
        }
        }

        dh.save();
        }
        return results;
    }

}
