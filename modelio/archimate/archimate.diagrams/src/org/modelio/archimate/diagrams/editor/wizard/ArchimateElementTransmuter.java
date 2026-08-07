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
package org.modelio.archimate.diagrams.editor.wizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.viewers.ISelection;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.api.modelio.diagram.dg.IDiagramDG;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.archimate.diagrams.plugin.ArchiDiagrams;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.folder.ApplicationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.BusinessFolder;
import org.modelio.archimate.metamodel.core.structure.folder.ImplementationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.MotivationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.PhysicalFolder;
import org.modelio.archimate.metamodel.core.structure.folder.StrategyFolder;
import org.modelio.archimate.metamodel.core.structure.folder.TechnologyFolder;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.mmextensions.standard.factory.IStandardModelFactory;
import org.modelio.metamodel.mmextensions.standard.services.IMModelServices;
import org.modelio.metamodel.mmextensions.standard.services.MModelServices;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.metamodel.uml.infrastructure.NoteType;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.vcore.session.impl.CoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * <p>Transmuter implementation for {@link Archimate} elements.</p>
 */
@objid ("ec4224fe-dc58-49bf-9d51-da55ec5a17cb")
public class ArchimateElementTransmuter implements IModelTransformer {
    @objid ("be290f31-ff5e-4f19-aa62-5d0b55d90edb")
    private final String targetMetaclass;

    @objid ("02be6b47-940f-4285-b59a-78467033aa11")
    @Inject
    private IModuleContext moduleContext;

    @objid ("24e7f4dd-2991-4d84-809f-5ff291ed6242")
    private Map<Relationship, Association> toBeTransformed = new HashMap<>();

    @objid ("e86b78f5-2af8-4cd2-a5af-9a2b582abb78")
    public ArchimateElementTransmuter(final String targetMetaclass) {
        this.targetMetaclass = targetMetaclass;
    }

    @objid ("b8a481eb-7912-4122-8794-d5eb28dba2b9")
    @Override
    public boolean transform(ISelection selection) {
        MObject elementToBeTransmuted = SelectionHelper.getFirst(selection, MObject.class);

        // First, replace the element itself
        MModelServices mmService = new MModelServices(CoreSession.getSession(elementToBeTransmuted));
        boolean done = transmuteElement(elementToBeTransmuted, mmService);

        // Delete old element
        if (done) {
            elementToBeTransmuted.delete();
        }

        return done;
    }

    @objid ("75815e49-81b7-47d6-82eb-f2f59b9eb78f")
    public boolean canExecute(AbstractDiagram diagram, ISelection selection) {
        MObject elt = SelectionHelper.getFirst(selection, MObject.class);
        if (elt instanceof Concept) {
            return true;
        }
        return false;
    }

    @objid ("06b88c7e-4d55-4bba-96db-8a0a853f34a4")
    private boolean transmuteElement(MObject elementToBeTransmuted, IMModelServices modelServices) {
        if (!(elementToBeTransmuted instanceof Concept)) {
            return false;
        }

        Concept oldArchiElement = (Concept) elementToBeTransmuted;

        Map<AbstractDiagram, ElementLinkInfo> oldElementLinks = saveLinkPropertiesInAllViews(oldArchiElement);
        Map<AbstractDiagram, ElementNoteInfo> oldElementNotes = saveNotePropertiesInAllViews(oldArchiElement);
        Map<AbstractDiagram, List<NodeVisualProperties>> oldElementNodes = maskInAllViews(oldArchiElement);


        MObject owner = elementToBeTransmuted.getCompositionOwner();
        MExpert mExpert = owner.getMClass().getMetamodel().getMExpert();

        final IStandardModelFactory modelFactory = modelServices.getModelFactory().getFactory(IStandardModelFactory.class);
        Concept newArchiElement = (Concept) modelFactory.createElement(this.targetMetaclass);

        MDependency effectiveDependency = mExpert.getDefaultCompositionDep(owner, newArchiElement);

        try {
            owner.mGet(effectiveDependency).add(newArchiElement);
        } catch (@SuppressWarnings ("unused") Exception e) {
            // The dependency indicated in the context cannot be used: try to find a valid one!
            MDependency compositionDep = mExpert.getDefaultCompositionDep(owner, newArchiElement);
            if (compositionDep != null) {
                owner.mGet(compositionDep).add(newArchiElement);
            } else {
                newArchiElement.delete();
                return false;
            }
        }

        newArchiElement.setName(oldArchiElement.getName());

        updateLinks(mExpert, modelFactory, newArchiElement, oldArchiElement);

        updateDep(newArchiElement, oldArchiElement);

        updateOwner(newArchiElement, oldArchiElement);

        updateNotes(modelServices, oldArchiElement, newArchiElement);

        replaceInAllViews(oldArchiElement, newArchiElement, oldElementNodes);
        replaceLinkPropertiesInAllViews(oldElementLinks, newArchiElement);
        replaceNotePropertiesInAllViews(oldElementNotes, newArchiElement);

        return true;
    }

    @objid ("ef40f784-c2fb-4d5c-af36-0f611ad99dd0")
    private void replaceNotePropertiesInAllViews(Map<AbstractDiagram, ElementNoteInfo> oldElementNotes, Concept newElement) {
        try {
            for (Map.Entry<AbstractDiagram, ElementNoteInfo> entry : oldElementNotes.entrySet()) {
                restoreNotePropertiesInDiagram(entry.getKey(), entry.getValue(), newElement);
            }
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("88700dc0-efa7-4d14-a96d-d5c035bbd73e")
    private void restoreNotePropertiesInDiagram(AbstractDiagram diagram, ElementNoteInfo elementNoteInfo, Concept newElement) {
        try {
            IDiagramHandle diagramHandle = moduleContext.getModelioServices().getDiagramService().getDiagramHandle(diagram);
            for (NoteInfo noteInfo : elementNoteInfo.attachedNotes) {
                newElement.getDescriptor().add(noteInfo.noteElement);
                restoreNoteInDiagram(diagramHandle, noteInfo, newElement);
            }

            diagramHandle.save();
            diagramHandle.close();
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("0d525356-79f9-4239-9cf6-d6f021d2d839")
    private void restoreNoteInDiagram(IDiagramHandle diagramHandle, NoteInfo noteInfo, Concept newElement) {
        try {

            List<IDiagramGraphic> newGraphics = diagramHandle.unmask(noteInfo.noteElement,noteInfo.properties.bounds.x,noteInfo.properties.bounds.y);

            for (IDiagramGraphic newGraphic : newGraphics) {
                if (newGraphic instanceof IDiagramNode) {
                    IDiagramNode noteNode = (IDiagramNode) newGraphic;
                    applyNoteVisualProperties(noteNode, noteInfo.properties);
                    break;
                }
            }

        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("92fe8bdd-880c-4996-b4db-e20cfd141eba")
    private void applyNoteVisualProperties(IDiagramNode noteNode, NoteVisualProperties props) {
        try {
            noteNode.setBounds(props.bounds);

            if (props.textColor != null) {
                noteNode.setTextColor(props.textColor);
            }

            if (props.font != null) {
                noteNode.setFont(props.font);
            }

            if (props.fillColor != null) {
                noteNode.setFillColor(props.fillColor);
            }

            if (props.lineColor != null) {
                noteNode.setLineColor(props.lineColor);
            }

        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("659b878f-133d-41bb-9e8d-3f30627202af")
    private Map<AbstractDiagram, ElementNoteInfo> saveNotePropertiesInAllViews(Concept oldElement) {
        Map<AbstractDiagram, ElementNoteInfo> allDiagramNotes = new HashMap<>();

        try {
            for (AbstractDiagram diagram : oldElement.getDiagramElement()) {
                allDiagramNotes.put(diagram, saveNotePropertiesInDiagram(diagram, oldElement));
            }
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }

        return allDiagramNotes;
    }

    @objid ("64eb0f2f-4db6-488c-a902-81ec9bb0b5bb")
    private ElementNoteInfo saveNotePropertiesInDiagram(AbstractDiagram diagram, Concept oldElement) {
        ElementNoteInfo elementNoteInfo = new ElementNoteInfo();

        try {
            IDiagramHandle diagramHandle = moduleContext.getModelioServices().getDiagramService().getDiagramHandle(diagram);
            List<IDiagramGraphic> allGraphics = getAllDiagramGraphics(diagramHandle);

            for (IDiagramGraphic graphic : allGraphics) {
                if (graphic instanceof IDiagramNode) {
                    IDiagramNode node = (IDiagramNode) graphic;
                    MObject element = node.getElement();

                    if (element instanceof Note && isNoteAttachedToElement((Note) element, oldElement)) {
                        NoteInfo noteInfo = new NoteInfo();
                        noteInfo.noteElement = (Note) element;

                        NoteVisualProperties props = new NoteVisualProperties();
                        props.bounds = node.getBounds();
                        props.textColor = node.getTextColor();
                        props.font = node.getFont();
                        props.fillColor = node.getFillColor();
                        props.lineColor = node.getLineColor();

                        noteInfo.properties = props;
                        elementNoteInfo.attachedNotes.add(noteInfo);
                    }
                }
            }

            diagramHandle.close();
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }

        return elementNoteInfo;
    }

    @objid ("0defd53b-52dd-4e92-89a2-c2a624f63802")
    private boolean isNoteAttachedToElement(Note note, Concept element) {
        try {
            return element.getDescriptor().contains(note);
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
            return false;
        }
    }

    @objid ("6a1fa527-bdb7-4ed0-8a66-da61143d1f2e")
    private void updateNotes(IMModelServices modelServices, Concept oldArchiElement, Concept newArchiElement) {
        if (oldArchiElement.getDescriptor().size() > 0) {
            List<NoteType> noteTypes = modelServices.findNoteTypes(".*", ".*", ".*", newArchiElement.getMClass());
            for (Note note : new ArrayList<>(oldArchiElement.getDescriptor())) {
                NoteType noteType = note.getModel();
                if (noteType != null && noteTypes.contains(noteType)) {
                    newArchiElement.getDescriptor().add(note);
                }
            }
        }
    }

    @objid ("d8d24973-b84e-4544-bd62-3d6ac9db76e3")
    private void replaceLinkPropertiesInAllViews(Map<AbstractDiagram, ElementLinkInfo> oldElementLinks, Concept newElement) {
        try {
            for (Map.Entry<AbstractDiagram, ElementLinkInfo> entry : oldElementLinks.entrySet()) {
                replaceLinkPropertiesInDiagram(entry.getKey(), entry.getValue(), newElement);
            }
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("0e0eda15-f20e-4cb7-a141-94c5c20629bf")
    private void replaceLinkPropertiesInDiagram(AbstractDiagram diagram, ElementLinkInfo elementLinkInfo, Concept newElement) {
        try {
            IDiagramHandle diagramHandle = moduleContext.getModelioServices().getDiagramService().getDiagramHandle(diagram);
            List<IDiagramGraphic> allGraphics = getAllDiagramGraphics(diagramHandle);

            for (LinkInfo linkInfo : elementLinkInfo.incomingLinks) {
                restoreLinkProperties(diagramHandle, allGraphics, linkInfo, newElement);
            }

            for (LinkInfo linkInfo : elementLinkInfo.outgoingLinks) {
                restoreLinkProperties(diagramHandle, allGraphics, linkInfo, newElement);
            }
            diagramHandle.save();
            diagramHandle.close();
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("92a9d89a-ab0c-48e4-a3e5-ad58df2a36ca")
    private void restoreLinkProperties(IDiagramHandle diagramHandle, List<IDiagramGraphic> allGraphics, LinkInfo linkInfo, Concept newElement) {
        MObject targetLinkElement = linkInfo.linkElement;
        if (toBeTransformed.containsKey(linkInfo.linkElement)) {
            targetLinkElement = toBeTransformed.get(linkInfo.linkElement);
        }
        List<IDiagramGraphic> newGraphics = diagramHandle.unmask(targetLinkElement, 0,0);

        for (IDiagramGraphic graphic : newGraphics) {
            if (graphic instanceof IDiagramLink) {
                IDiagramLink link = (IDiagramLink) graphic;

                applyLinkVisualProperties(link, linkInfo.properties);
                break;

            }
        }
    }

    @objid ("133af45a-1379-48bf-ac2f-bcc172bbd220")
    private void applyLinkVisualProperties(IDiagramLink link, LinkVisualProperties props) {
        try {

            if (props.lineColor != null) {
                link.setLineColor(props.lineColor);
            }
            link.setLineWidth(props.lineWidth);
            link.setLinePattern(props.linePattern);

            if (props.routerKind != null) {
                link.setRouterKind(props.routerKind);
            }

            if (props.path != null) {
                link.setPath(props.path);
            }

            if (props.textColor != null) {
                link.setTextColor(props.textColor);
            }

            if (props.font != null) {
                link.setFont(props.font);
            }

            link.setLineRadius(props.lineRadius);
            link.setDrawLineBridges(props.drawLineBridges);

        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("ae653a92-6543-4387-8025-ca12d8fd0aae")
    private Map<AbstractDiagram, ElementLinkInfo> saveLinkPropertiesInAllViews(Concept oldElement) {
        Map<AbstractDiagram, ElementLinkInfo> allDiagramLinks = new HashMap<>();

        try {
            for (AbstractDiagram diagram : oldElement.getDiagramElement()) {
                allDiagramLinks.put(diagram, saveLinkPropertiesInDiagram(diagram, oldElement));
            }
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }

        return allDiagramLinks;
    }

    @objid ("189f5567-d4e1-4dc3-b4f8-fa5e2e36d113")
    private ElementLinkInfo saveLinkPropertiesInDiagram(AbstractDiagram diagram, Concept oldElement) {
        ElementLinkInfo elementLinkInfo = new ElementLinkInfo();
        elementLinkInfo.incomingLinks = new ArrayList<>();
        elementLinkInfo.outgoingLinks = new ArrayList<>();
        try {
            IDiagramHandle diagramHandle = moduleContext.getModelioServices().getDiagramService().getDiagramHandle(diagram);
            List<IDiagramGraphic> allGraphics = getAllDiagramGraphics(diagramHandle);

            for (IDiagramGraphic graphic : allGraphics) {
                if (graphic instanceof IDiagramLink) {
                    IDiagramLink link = (IDiagramLink) graphic;
                    MObject linkElement = link.getElement();

                    if (linkElement != null && isLinkConnectedToElement(link, oldElement)) {
                        LinkInfo linkInfo = new LinkInfo();
                        linkInfo.linkElement = linkElement;

                        LinkVisualProperties props = new LinkVisualProperties();
                        props.lineColor = link.getLineColor();
                        props.lineWidth = link.getLineWidth();
                        props.linePattern = link.getLinePattern();
                        props.routerKind = link.getRouterKind();
                        props.path = link.getPath();
                        props.textColor = link.getTextColor();
                        props.font = link.getFont();
                        props.lineRadius = link.getLineRadius();
                        props.drawLineBridges = link.isDrawLineBridges();

                        linkInfo.properties = props;
                        if (oldElement.equals(link.getTo().getElement())) {
                            elementLinkInfo.incomingLinks.add(linkInfo);
                        } else if (oldElement.equals(link.getFrom().getElement())) {
                            elementLinkInfo.outgoingLinks.add(linkInfo);
                        }                    }
                }
            }

            diagramHandle.close();
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }

        return elementLinkInfo;
    }

    @objid ("9f175380-cbd2-4be4-8712-f83a9426a6ad")
    private boolean isLinkConnectedToElement(IDiagramLink link, Concept oldElement) {
        try {
            IDiagramGraphic fromGraphic = link.getFrom();
            IDiagramGraphic toGraphic = link.getTo();

            return ( oldElement.equals(fromGraphic.getElement())) ||
                    ( oldElement.equals(toGraphic.getElement()));
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
            return false;
        }
    }

    @objid ("1bc2710e-4b1f-4f82-98b4-68b177f28596")
    private Map<AbstractDiagram, List<NodeVisualProperties>> maskInAllViews(Concept oldElement) {
        Map<AbstractDiagram,List<NodeVisualProperties>> oldElementNodes = new HashMap<>();
        try {
            List<AbstractDiagram> diagrams = oldElement.getDiagramElement();
            List<AbstractDiagram> newDiagrams = new ArrayList<>();
            newDiagrams.addAll(diagrams);
            for (AbstractDiagram diagram : newDiagrams) {
                oldElementNodes.put(diagram, maskElementInDiagram(diagram, oldElement));
            }
        }
        catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
        return oldElementNodes;
    }

    @objid ("d567158f-acbb-4b3b-ba1f-59e0c8de0b2c")
    private List<NodeVisualProperties> maskElementInDiagram(AbstractDiagram diagram, Concept oldElement) {
        List<NodeVisualProperties> oldElementNodes = new ArrayList<>();
        try {
            IDiagramHandle diagramHandle = moduleContext.getModelioServices().getDiagramService().getDiagramHandle(diagram);

            List<IDiagramGraphic> allGraphics = getAllDiagramGraphics(diagramHandle);

            for (IDiagramGraphic graphic : allGraphics) {
                if (graphic instanceof IDiagramNode) {
                    IDiagramNode node = (IDiagramNode) graphic;
                    if (oldElement.equals(node.getElement())) {

                        NodeVisualProperties props = new NodeVisualProperties();
                        props.bounds = node.getBounds();

                        oldElementNodes.add(props);
                        diagramHandle.mask(node);
                    }
                }
            }

            diagramHandle.save();
            diagramHandle.close();
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
        return oldElementNodes;
    }

    /**
     * Replace the old element with the new one in all ArchiMate views
     */
    @objid ("ff2cf8df-643e-447c-9896-4e0879620d14")
    private void replaceInAllViews(Concept oldElement, Concept newElement, Map<AbstractDiagram, List<NodeVisualProperties>> oldElementNodes) {
        try {
            for (AbstractDiagram diagram : oldElementNodes.keySet()) {
                replaceElementInDiagram(diagram, oldElement, newElement, oldElementNodes.get(diagram));
            }
        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("a8dc718c-6eca-4a8f-bfc9-36fba9ec964f")
    private void replaceElementInDiagram(AbstractDiagram diagram, Concept oldElement, Concept newElement, List<NodeVisualProperties> oldElementNodes) {
        try {
            IDiagramHandle diagramHandle = moduleContext.getModelioServices().getDiagramService().getDiagramHandle(diagram);
            for (NodeVisualProperties props : oldElementNodes) {
                replaceNodeInDiagram(diagramHandle, props, newElement);
            }
            diagramHandle.save();
            diagramHandle.close();


        }catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    @objid ("84913b7b-fde0-438f-82cd-64bf0340ca9b")
    private void replaceNodeInDiagram(IDiagramHandle diagramHandle, NodeVisualProperties props, Concept newElement) {
        try {
            newElement.getDiagramElement().add(diagramHandle.getDiagram());
            List<IDiagramGraphic> newGraphics = diagramHandle.unmask(newElement, props.bounds.x, props.bounds.y);

            for (IDiagramGraphic newGraphic : newGraphics) {
                if (newGraphic instanceof IDiagramNode) {
                    IDiagramNode newNode = (IDiagramNode) newGraphic;
                    newNode.setBounds(props.bounds);
                }
            }

        } catch (Exception e) {
            ArchiDiagrams.LOG.error(e);
        }
    }

    /**
     * Get all diagram graphics from a diagram handle
     */
    @objid ("31d581a5-b220-4198-9ea9-d187525551a9")
    private List<IDiagramGraphic> getAllDiagramGraphics(IDiagramHandle diagramHandle) {
        List<IDiagramGraphic> allGraphics = new ArrayList<>();

        try {
            IDiagramDG diagramNode = diagramHandle.getDiagramNode();
            collectGraphicsRecursively(diagramNode, allGraphics);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allGraphics;
    }

    /**
     * Recursively collect all diagram graphics
     */
    @objid ("4d31a501-c323-4a37-a5ec-ae557e5ed20a")
    private void collectGraphicsRecursively(IDiagramGraphic graphic, List<IDiagramGraphic> allGraphics) {
        if (graphic == null) return;

        allGraphics.add(graphic);

        if (graphic instanceof IDiagramNode) {
            IDiagramNode node = (IDiagramNode) graphic;

            // Collect child nodes recursively
            for (IDiagramNode child : node.getNodes()) {
                collectGraphicsRecursively(child, allGraphics);
            }

            //  collect links from this node
            for (IDiagramLink link : node.getFromLinks()) {
                if (!allGraphics.contains(link)) {
                    allGraphics.add(link);
                }
            }

            for (IDiagramLink link : node.getToLinks()) {
                if (!allGraphics.contains(link)) {
                    allGraphics.add(link);
                }
            }
        }
    }

    @objid ("e8b54fac-b670-4ec1-ac6a-cdf0b2f004a8")
    private void updateOwner(Concept newArchiElement, Concept oldArchiElement) {
        Model model = getModel(oldArchiElement);
        if (model != null) {
            Folder folder = getOwnerFolder(newArchiElement, model);
            newArchiElement.setOwnerFolder(folder);
        }
    }

    @objid ("ec788455-6d83-4810-8ec7-e1c38f2fc452")
    private void updateLinks(MExpert mExpert, final IStandardModelFactory modelFactory, Concept newArchiElement, Concept oldArchiElement) {
        //Association
        for (Association association : new ArrayList<>(oldArchiElement.getRelatedTo(Association.class))) {
            newArchiElement.getRelatedTo().add(association);
        }

        for (Association association : new ArrayList<>(oldArchiElement.getRelatedFrom(Association.class))) {
            newArchiElement.getRelatedFrom().add(association);
        }

        //Composition
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Composition.class);

        //Aggregation
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Aggregation.class);

        //Assignment
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Assignment.class);

        //Realization
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Realization.class);

        //Influence
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Influence.class);

        //Access
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Access.class);

        //Serving
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Serving.class);

        //Triggering
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Triggering.class);

        //Flow
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Flow.class);

        //Specialization
        updateArchiLink(mExpert, modelFactory, newArchiElement, oldArchiElement, Specialization.class);
    }

    @objid ("14b0922b-d987-43cd-bcef-dfd402b6a768")
    private <T extends Relationship> void updateArchiLink(MExpert mExpert, final IStandardModelFactory modelFactory, Concept newArchiElement, Concept oldArchiElement, Class<T> filterdClass) {
        for (Relationship relationship : new ArrayList<>(oldArchiElement.getRelatedTo(filterdClass))) {
            MClass source = newArchiElement.getMClass();
            MClass target = relationship.getFrom().getMClass();
            if (mExpert.canLink(relationship.getMClass(), source, target)) {
                newArchiElement.getRelatedTo().add(relationship);
            }else {
                Association association = (Association) modelFactory.createElement(Association.MQNAME);
                association.setTo(relationship.getTo());
                association.setFrom(newArchiElement);
                toBeTransformed.put(relationship, association);
            }
        }

        for (Relationship relationship : new ArrayList<>(oldArchiElement.getRelatedFrom(filterdClass))) {
            MClass source = relationship.getTo().getMClass();
            MClass target = newArchiElement.getMClass() ;
            if (mExpert.canLink(relationship.getMClass(), source, target)) {
                newArchiElement.getRelatedFrom().add(relationship);
            }else {
                //Recursive link case
                if (this.toBeTransformed.containsKey(relationship)) {
                    Relationship updatedRelationship = this.toBeTransformed.get(relationship);
                    updatedRelationship.setTo(newArchiElement);
                }else {
                    Association association = (Association) modelFactory.createElement(Association.MQNAME);
                    association.setTo(newArchiElement);
                    association.setFrom(relationship.getFrom());
                    this.toBeTransformed.put(relationship, association);
                }
            }
        }
    }

    @objid ("60909c19-c7ca-474b-a4ae-3596b249c08e")
    private void updateDep(Concept newArchiElement, Concept oldArchiElement) {
        List<Dependency> toBeUpdated = new ArrayList<>();
        toBeUpdated.addAll(oldArchiElement.getDependsOnDependency());
        for (Dependency dep :toBeUpdated ) {
            dep.setImpacted(newArchiElement);
        }

        toBeUpdated = new ArrayList<>();
        toBeUpdated.addAll(oldArchiElement.getImpactedDependency());
        for (Dependency dep : toBeUpdated) {
            dep.setDependsOn(newArchiElement);
        }
    }

    @objid ("e8e2db39-12e0-41d1-b633-4b269d67c45f")
    private Model getModel(ArchimateAbstractElement concept) {
        if (concept != null) {
            MObject owner = concept.getCompositionOwner();
            if (owner instanceof Model) {
                return (Model) owner;
            } else if (owner != null) {
                return getModel((ArchimateAbstractElement) owner);
            }
        }
        return null;
    }

    @objid ("d477f497-e9ef-47df-8627-388fa8786f02")
    private Folder getOwnerFolder(Concept concept, Model model) {
        Folder businessLayer = null;
        Folder applicatinoLayer = null;
        Folder technologyLayer = null;
        Folder motivationLayer = null;
        Folder implementationLayer = null;
        Folder physicalLayer = null;
        Folder strategyLayer = null;


        for (Folder folder : model.getFolder()) {
            if (folder instanceof BusinessFolder) {
                businessLayer = folder;
            } else if (folder instanceof ApplicationFolder) {
                applicatinoLayer = folder;
            } else if (folder instanceof TechnologyFolder) {
                technologyLayer = folder;
            } else if (folder instanceof MotivationFolder) {
                motivationLayer = folder;
            } else if (folder instanceof ImplementationFolder) {
                implementationLayer = folder;
            } else if (folder instanceof PhysicalFolder) {
                physicalLayer = folder;
            } else if (folder instanceof StrategyFolder) {
                strategyLayer = folder;
            }
        }

        if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.application.")) {
            return applicatinoLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.technology.")) {
            return technologyLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.motivation.")) {
            return motivationLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.business.")) {
            return businessLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.strategy.")) {
            return strategyLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.physical.")) {
            return physicalLayer;
        } else if (concept.getClass().getName()
                .startsWith("org.modelio.archimate.metamodel.impl.layers.implementation_and_migration.")) {
            return implementationLayer;
        }
        return model;
    }

    @objid ("07b38373-ea8c-4ad9-a55d-94f459a8da2e")
    @Override
    public boolean isAvailable(AbstractDiagram diagram, ISelection selection) {
        MObject elt = SelectionHelper.getFirst(selection, MObject.class);
        if (elt == null)
            return false;

        // One selected element only
        if (!(SelectionHelper.containsOnly(selection, ArchimateAbstractElement.class))) {
            return false;
        }

        // In an Archimate View
        //        if (!(diagram instanceof ArchimateView ) ) {
        //            return false;
        //        }

        return true;
    }

    @objid ("64796a45-7aef-4c52-8545-31db8b409893")
    @Override
    public String getTargetMetaclassName() {
        return this.targetMetaclass;
    }

    /**
     * <Enter note text here>
     */
    @objid ("5126bade-064e-4d7e-aa98-05495f0df457")
    private static class NodeVisualProperties {
        //        @objid ("3d419efa-0ce3-4ce5-990b-0348b400d029")
        //        String fillColor;
        //
        //        @objid ("35b35255-6ef9-4789-b8d4-e9af24087d4a")
        //        String lineColor;
        //
        //        @objid ("e6501aae-175f-4f23-92fe-d53bdc662906")
        //        String textColor;
        //
        //        @objid ("775f3295-6e89-4f02-af29-7c970cb85364")
        //        String font;
        //
        //        @objid ("73b5e27c-9ffa-4707-b499-1de903d989fa")
        //        int fillMode;
        //
        //        @objid ("1ff55b40-c379-4cc5-be30-ed3708f5f56c")
        //        int lineWidth;
        //
        //        @objid ("d7e62d9e-2b4a-45fe-ab18-6bf518e3f5d2")
        //        int representationMode;
        @objid ("7eee8303-7aae-4062-9811-712cb414aeab")
        Rectangle bounds;

    }

    @objid ("f5110edb-214f-4f0d-9e64-69e40c0fc4ee")
    private static class LinkVisualProperties {
        @objid ("f0469fb0-f040-4661-a457-dfe5da95824b")
        String lineColor;

        @objid ("f23580ee-1869-45d4-89b0-7401a17701b9")
        int lineWidth;

        @objid ("90b1d6a3-7ba1-464e-8ed2-b47c28be45c9")
        int linePattern;

        @objid ("f3feac8a-a315-42d0-bf2e-7b3cd455ad44")
        org.modelio.api.modelio.diagram.IDiagramLink.LinkRouterKind routerKind;

        @objid ("e3f33e52-56d7-4e4b-b39d-f33a1bbb4020")
        String textColor;

        @objid ("ef78184d-878f-4556-8cc2-ba0f3e78348a")
        String font;

        @objid ("223fffe0-4684-4918-8852-4a6b104bae35")
        int lineRadius;

        @objid ("7b3cd53c-2397-48fa-bb5d-ab728b0fdff8")
        boolean drawLineBridges;

        @objid ("63119e1c-7522-401e-b948-ee9dc095aaac")
        ILinkPath path;

    }

    @objid ("92edf5e4-8a25-4bba-895b-0a733e7e6a53")
    private static class ElementLinkInfo {
        @objid ("13d4d51e-7dfe-435c-ad5b-fd3db766ef4a")
        List<LinkInfo> incomingLinks;

        @objid ("5d8e4356-d76d-47ea-8641-c95ef63bfbf8")
        List<LinkInfo> outgoingLinks;

    }

    @objid ("4412b6d1-a2f0-4c44-947d-665811c3e79b")
    private static class LinkInfo {
        @objid ("0446df53-62aa-4451-a327-557fbb63d032")
        MObject linkElement;

        @objid ("fd0a420d-ca86-48a9-8730-83e55e65f198")
        LinkVisualProperties properties;

    }

    @objid ("2a965683-cb5b-4a23-abb5-404817b526e3")
    private static class NoteVisualProperties {
        @objid ("8f4773fd-e28a-4245-8a65-e6181f19bebc")
        String textColor;

        @objid ("83fc6b2d-e1b9-4826-b800-38d49cfe148c")
        String font;

        @objid ("93a10e06-8e42-446d-89b1-050574181082")
        String fillColor;

        @objid ("fe8f0f08-0afa-478b-94d7-b56bf494e423")
        String lineColor;

        @objid ("6bd1d332-3ea5-4a58-bbbe-f53fe3977768")
        Rectangle bounds;

    }

    @objid ("8c21a973-76c5-450f-ae51-f653722c0835")
    private static class NoteInfo {
        @objid ("7c2405ae-0b62-4ce3-9e76-37058a6ee0a1")
        Note noteElement;

        @objid ("9fafe24b-9528-447e-a440-7d756d430da7")
        NoteVisualProperties properties;

    }

    @objid ("cb1171e7-cc3b-4ad9-82d4-b90ccd58a7bd")
    private static class ElementNoteInfo {
        @objid ("5f0a1652-01e6-4f4f-afd9-e1ab73da5309")
        List<NoteInfo> attachedNotes;

        @objid ("6851c7f9-6268-4c31-9e99-7dce80602ff4")
        public ElementNoteInfo() {
            this.attachedNotes = new ArrayList<>();
        }

    }

}
