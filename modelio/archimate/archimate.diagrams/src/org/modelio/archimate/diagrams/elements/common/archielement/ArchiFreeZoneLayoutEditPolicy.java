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
package org.modelio.archimate.diagrams.elements.common.archielement;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.modelio.archimate.diagrams.commands.ArchimateUnmaskOrCreateElementCommand;
import org.modelio.archimate.diagrams.elements.common.utils.RelationshipHelper;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.mmextensions.archimate.ArchimateLayerExpert;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.diagram.editor.DiagramCommandStack;
import org.modelio.diagram.elements.common.freezone.BpmnCloneFlowElementCommand;
import org.modelio.diagram.elements.common.freezone.DefaultFreeZoneLayoutEditPolicy;
import org.modelio.diagram.elements.core.commands.DefaultCloneElementCommand;
import org.modelio.diagram.elements.core.commands.DefaultCreateElementCommand;
import org.modelio.diagram.elements.core.commands.DefaultEditCreatedElementCommand;
import org.modelio.diagram.elements.core.commands.ModelioCreationContext;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.IGmDiagram.IModelManager;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Free zone layout edit policy used by the {@link ArchiFreeZoneEditPart}.
 * <p>
 * Creating, unmasking or reparenting an Archimate {@link Element} optionally adds a {@link StructuralRelationship} from the graphical owner.
 * </p>
 */
@objid ("7c2a9edf-f71d-49de-9343-f5a5596ac828")
public class ArchiFreeZoneLayoutEditPolicy extends DefaultFreeZoneLayoutEditPolicy {
    @objid ("4da03ce4-33d9-4dff-82e5-4e472abd2727")
    @Override
    protected Command createAddCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        if (child.getModel() instanceof GmNodeModel) {
            return new RelationshipReparentCommand(getHostCompositeNode(), (GmNodeModel) child.getModel(), constraint);
        } else {
            return null;
        }

    }

    @objid ("9630f704-9d6a-4d45-ac6d-d047c8aea0b1")
    @Override
    protected Command getCreateCommand(CreateRequest request) {
        final ModelioCreationContext ctx = (ModelioCreationContext.lookRequest(request));
        if (ctx != null) {
            final MObject elementToUnmask = ctx.getElementToUnmask();
            final GmCompositeNode gmParentNode = getHostCompositeNode();
            final MObject hostElement = getLayerContainer(ctx.getMetaclass());
            if (elementToUnmask != null) {
                if (gmParentNode.canUnmask(elementToUnmask)) {
                    return new DefaultEditCreatedElementCommand(new RelationshipCreationCommand(hostElement, gmParentNode, ctx, getConstraintFor(request)),getHost().getRoot().getViewer().getEditPartRegistry());
                } else {
                    return null;
                }
            } else if (hostElement != null) {
                MClass metaclassToCreate = ctx.getMetaclass();

                if (gmParentNode.canCreate(metaclassToCreate.getJavaInterface())) {
                    MExpert expert = metaclassToCreate.getMetamodel().getMExpert();
                    if (expert.canCompose(hostElement.getMClass(), metaclassToCreate, ctx.getDependencyName())) {
                        return new DefaultEditCreatedElementCommand(new RelationshipCreationCommand(hostElement, gmParentNode, ctx, getConstraintFor(request)),getHost().getRoot().getViewer().getEditPartRegistry());
                    }
                }
            }
        }
        return null;
    }

    @objid ("b142f5bb-36a6-4247-8866-a05f179502dd")
    @Override
    protected Model getHostElement() {
        // Use the diagram's context (or the viewpoint's) rather than the diagram's composition owner
        final ArchimateView diagram = (ArchimateView) getHostCompositeNode().getDiagram().getRelatedElement();
        return getArchimateModel(diagram);
    }

    @objid ("6bfe76b2-c0e3-46f9-a435-0010ad2a33b8")
    @Override
    protected Command getCloneCommand(ChangeBoundsRequest request) {
        if (getHost().getModel() instanceof GmCompositeNode) {
            final GmCompositeNode hostModel = getHostCompositeNode();
            final CompoundCommand command = new CompoundCommand();
            for (final Object editPartObj : request.getEditParts()) {
                final GraphicalEditPart copiedEPart = (GraphicalEditPart) editPartObj;
                if (copiedEPart.getModel() instanceof GmModel) {
                    final GmModel copiedGmModel = (GmModel) copiedEPart.getModel();
                    final MObject copiedElement = copiedGmModel.getRelatedElement();
                    MObject targetElement = getLayerContainer(copiedElement.getMClass());
                    if (targetElement != null) { // When the copied element is not part of Archimate, it has no corresponding layer
                        MExpert metaUtils = targetElement.getMClass().getMetamodel().getMExpert();
                        if (targetElement instanceof BpmnLane && copiedElement instanceof BpmnFlowElement) {
                            final Object requestConstraint = translateToModelConstraint(getConstraintFor(request, copiedEPart));
                            command.add(new BpmnCloneFlowElementCommand(hostModel, (BpmnLane) targetElement, (BpmnFlowElement) copiedElement,
                                    requestConstraint));
                        } else if (metaUtils.canCompose(targetElement, copiedElement, null)) {
                            final Object requestConstraint = translateToModelConstraint(getConstraintFor(request, copiedEPart));
                            command.add(new DefaultCloneElementCommand(hostModel, targetElement, copiedElement,
                                    requestConstraint));
                        }
                    }
                }
            }
            return command.unwrap();
        }
        return null;
    }

    @objid ("bd30d267-aa79-4ab8-8784-38e5962bf366")
    protected Folder getLayerContainer(MClass metaclass) {
        Model model = getHostElement();
        return model != null ? ArchimateLayerExpert.getLayerContainer(model, metaclass) : null;
    }

    @objid ("d2fbe7b9-bdb2-4cf8-af7a-b523cd02b24d")
    @Override
    protected boolean canHandle(MClass metaclass, String dep) {
        final MObject hostElement = getLayerContainer(metaclass);
        if (hostElement == null) {
            return false;
        }
        MMetamodel mm = hostElement.getMClass().getMetamodel();
        return mm.getMExpert().canCompose(hostElement.getMClass(), metaclass, dep);
    }

    @objid ("013b37a5-5d91-4b1d-b888-517a1ee49a19")
    private Model getArchimateModel(ModelElement elt) {
        if (elt instanceof ArchimateView) {
            ArchimateView diagram = (ArchimateView) elt;
            if (diagram.getContext() != null) {
                return diagram.getContext();
            } else {
                return getArchimateModel(diagram.getOrigin());
            }
        } else if (elt instanceof ViewPoint) {
            ViewPoint vp = (ViewPoint) elt;
            if (vp.getContext() != null) {
                return vp.getContext();
            } else {
                return getArchimateModel(vp.getParent());
            }
        } else {
            return null;
        }

    }

    @objid ("19be4af0-5bba-44e1-8bc1-d4bec031277f")
    @Override
    protected Command getUnamskOrCreateCommand(CreateRequest request) {
        final ModelioCreationContext ctx = (ModelioCreationContext.lookRequest(request));
        if (ctx != null) {
            final MObject elementToUnmask = ctx.getElementToUnmask();
            final GmCompositeNode gmParentNode = getHostCompositeNode();
            final MObject hostElement = getLayerContainer(ctx.getMetaclass());
            if (elementToUnmask != null) {
                if (gmParentNode.canUnmask(elementToUnmask)) {
                    final Object requestConstraint = getConstraintFor(request);
                    return new ArchimateUnmaskOrCreateElementCommand(hostElement, gmParentNode, ctx, requestConstraint);
                } else {
                    return null;
                }
            } else if (hostElement != null) {
                MClass metaclassToCreate = ctx.getMetaclass();

                if (gmParentNode.canCreate(metaclassToCreate.getJavaInterface())) {
                    MExpert expert = metaclassToCreate.getMetamodel().getMExpert();
                    if (expert.canCompose(hostElement.getMClass(), metaclassToCreate, ctx.getDependencyName())) {
                        final Object requestConstraint = getConstraintFor(request);
                        return new ArchimateUnmaskOrCreateElementCommand(hostElement, gmParentNode, ctx, requestConstraint);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Command that creates and unmask an Archimate {@link Element} and optionally adds a {@link StructuralRelationship} from the graphical owner. Said relationship's metaclass is chosen according to the metamodel expertise.
     */
    @objid ("bb727c71-ba80-4922-adf4-272b4a20ead0")
    private class RelationshipCreationCommand extends DefaultCreateElementCommand {
        @objid ("6683e42e-f891-4903-a84a-038451d9c018")
        public RelationshipCreationCommand(GmCompositeNode parentNode, ModelioCreationContext context, Object constraint) {
            super(parentNode, context, constraint);
        }

        @objid ("eb523ae4-7ca4-4509-b528-3bb5b8133049")
        public RelationshipCreationCommand(MObject parentElement, GmCompositeNode parentNode, ModelioCreationContext context, Object constraint) {
            super(parentElement, parentNode, context, constraint);
        }

        @objid ("a1c39303-e451-4bfb-a6ac-c56a697f43c9")
        @Override
        protected void beforeUnmask(MObject newElement) {
            super.beforeUnmask(newElement);

            GmCompositeNode parent = getParentNode();
            IModelManager modelManager = parent.getDiagram().getModelManager();
            MObject from = parent.getRelatedElement();
            MObject to = newElement;

            if (from instanceof Element && to instanceof Element) {
                CommandStack commandStack = getHost().getViewer().getEditDomain().getCommandStack();
                if (commandStack instanceof DiagramCommandStack) {
                    if (!((DiagramCommandStack) commandStack).isBatchMode()) {
                        RelationshipHelper.createStructuralRelationship(modelManager, (Element) from, (Element) to);
                    }
                }
            }

        }

    }

    /**
     * Command that reparents an Archimate {@link Element} and optionally adds a {@link StructuralRelationship} from the new graphical owner. Said relationship's metaclass is chosen according to the metamodel expertise.
     */
    @objid ("624dd418-830c-492d-9ad4-62da8544eb6f")
    private class RelationshipReparentCommand extends Command {
        /**
         * The new parent of the reparented child.
         */
        @objid ("47d22e46-bc44-43f2-b498-0a91d31dd6d5")
        private GmCompositeNode newParent;

        /**
         * The child that is being reparented.
         */
        @objid ("71d4679e-b50e-438f-8198-3386b0f2cac8")
        private GmNodeModel reparentedChild;

        /**
         * The new layout data of the reparented child.
         */
        @objid ("47ef82e4-0991-4227-b345-2c06e391f78a")
        private Object newLayoutData;

        @objid ("9f81442c-44f5-4ae3-b086-f10c910df02c")
        public RelationshipReparentCommand(GmCompositeNode newParent, GmNodeModel reparentedChild, Object newLayoutData) {
            super();
            this.newParent = newParent;
            this.reparentedChild = reparentedChild;
            this.newLayoutData = newLayoutData;

        }

        @objid ("ad3f175c-ca50-49b9-ac62-087fb5cdd305")
        @Override
        public void execute() {
            updateStructuralRelationships();

            // Orphan the {@link GmNodeModel node} from its previous owner.
            final GmModel oldParentModel = this.reparentedChild.getParent();
            final GmCompositeNode oldParent = (GmCompositeNode) oldParentModel;
            oldParent.removeChild(this.reparentedChild);

            this.reparentedChild.setLayoutData(this.newLayoutData);

            if (this.newParent.canContain(this.reparentedChild.getClass())) {
                // Finally attach the {@link GmNodeModel node} to its new owner.
                this.newParent.addChild(this.reparentedChild);
            } else {
                // The new parent does not support the node.
                // Ask the diagram to create a new node.
                if (this.newLayoutData instanceof Rectangle) {
                    // reset the rectangle dimensions
                    final Rectangle r = (Rectangle) this.newLayoutData;
                    this.newLayoutData = new Rectangle(r.x, r.y, -1, -1);
                }

                this.newParent.getDiagram().unmask(this.newParent, this.reparentedChild.getRelatedElement(), this.newLayoutData);

                // Delete the now unused child
                this.reparentedChild.delete();
            }

            updateStructuralRelationships(oldParent);

        }

        /**
         * Mask each existing unmasked link.
         */
        @objid ("e49b3297-1fa2-423e-a3b5-d33e417f33cf")
        private void maskLinks(List<IGmLink> existingLinks) {
            for (IGmLink link : existingLinks) {
                link.delete();
            }

        }

        @objid ("876e474b-cb2c-4cfd-82d9-708de25c2a66")
        @Override
        public boolean canExecute() {
            final MObject childElement = this.reparentedChild.getRelatedElement();
            final MObject newParentElement = this.newParent.getRelatedElement();
            if (newParentElement == null || childElement == null) {
                return false;
            }

            if (newParentElement.equals(childElement)) {
                return false;
            }

            // The diagram must be valid and modifiable.
            IGmDiagram diagram = this.reparentedChild.getDiagram();
            if (diagram == null || !MTools.getAuthTool().canModify(diagram.getRelatedElement())) {
                return false;
            }

            // The new parent must be modifiable.
            return newParentElement.getStatus().isModifiable();
        }

        /**
         * Before reparenting a node into a new parent:
         * <ul>
         * <li>If no structural relationship exists between them, ask the user if he wants to create one.</li>
         * <li>Existing structural relationship between them are masked.</li>
         * </ul>
         */
        @objid ("0a720c4a-4ef2-4428-9768-dbd9aa040122")
        private void updateStructuralRelationships() {
            GmNodeModel fromNode = this.newParent;
            while (fromNode != null && fromNode.getRepresentedElement() == null) {
                fromNode = fromNode.getParentNode();
            }

            if (fromNode != null) {
                MObject from = fromNode.getRelatedElement();
                MObject to = this.reparentedChild.getRelatedElement();
                if (from instanceof Element && to instanceof Element) {
                    List<IGmLink> existingLinks = RelationshipHelper.getUnmaskedStructuralRelationships(fromNode, this.reparentedChild);
                    if (existingLinks.isEmpty()) {
                        CommandStack commandStack = getHost().getViewer().getEditDomain().getCommandStack();
                        if (commandStack instanceof DiagramCommandStack) {
                            if (!((DiagramCommandStack) commandStack).isBatchMode()) {
                                RelationshipHelper.createStructuralRelationship(this.newParent.getDiagram().getModelManager(), (Element) from, (Element) to);
                            }
                        }
                    } else {
                        maskLinks(existingLinks);
                    }
                }
            }

        }

        /**
         * After reparenting a node into another, unmask the structural relationships existing from the old parent to this node.
         */
        @objid ("59a890c4-3fc0-4c15-9841-6625409a2da5")
        private void updateStructuralRelationships(GmCompositeNode oldParent) {
            GmCompositeNode parent = oldParent;
            while (parent != null && parent.getRepresentedElement() == null) {
                parent = parent.getParentNode();
            }

            GmCompositeNode fromNode = parent;
            if (fromNode != null) {
                MObject from = fromNode.getRelatedElement();
                MObject to = this.reparentedChild.getRelatedElement();

                if (from instanceof Element && to instanceof Element) {
                    int cpt = 0;
                    for (StructuralRelationship link : RelationshipHelper.getStructuralRelationships(fromNode.getDiagram().getModelManager(), (Element) from, (Element) to, StructuralRelationship.class)) {
                        // FIXME compute a smart unmask location between 'fromNode' and 'toNode'
                        Point location = new Point(0, 100 + (cpt++ * 20));
                        unmaskLink(link, location);
                    }
                }
            }

        }

        @objid ("5151ea09-15ea-48b8-baa6-d38a2a0ddb38")
        private void unmaskLink(Relationship link, Point location) {
            ModelElementDropRequest dropRequest = new ModelElementDropRequest();
            dropRequest.setDroppedElements(new MObject[] { link });
            dropRequest.setLocation(location);

            EditPart editPart = getHost();
            while (editPart != null) {
                EditPart targetEditPart = editPart.getTargetEditPart(dropRequest);
                if (targetEditPart != null) {
                    Command command = targetEditPart.getCommand(dropRequest);
                    if (command != null && command.canExecute()) {
                        command.execute();
                    }
                    break;
                }
                editPart = editPart.getParent();
            }

        }

    }

}
