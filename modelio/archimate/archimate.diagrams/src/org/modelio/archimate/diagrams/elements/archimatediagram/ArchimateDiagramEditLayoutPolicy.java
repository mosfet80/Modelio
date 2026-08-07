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
package org.modelio.archimate.diagrams.elements.archimatediagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
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
import org.modelio.diagram.elements.common.abstractdiagram.DiagramEditLayoutPolicy;
import org.modelio.diagram.elements.common.freezone.BpmnCloneFlowElementCommand;
import org.modelio.diagram.elements.core.commands.DefaultCloneElementCommand;
import org.modelio.diagram.elements.core.commands.DefaultCreateElementCommand;
import org.modelio.diagram.elements.core.commands.DefaultEditCreatedElementCommand;
import org.modelio.diagram.elements.core.commands.ModelioCreationContext;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Free zone layout edit policy used by the {@link ArchimateDiagramEditPart}.
 * <p>
 * Reparenting an Archimate {@link Element} to the diagram unmasks all {@link StructuralRelationship} from the old graphical owner to the reparented element.
 * </p>
 * <p>
 * Archimate {@link Element} creation in the diagram itself uses the diagram's model context (or the viewpoint's) rather than the diagram's composition owner like in standard UML diagrams. Also resolves the appropriate layer according to the Element's
 * metaclass.
 * </p>
 */
@objid ("b6761a4f-807f-4a1f-aa94-71b6a12c0a42")
public class ArchimateDiagramEditLayoutPolicy extends DiagramEditLayoutPolicy {
    @objid ("5cd3c5ff-8e5b-4260-8d21-9da420a3a10b")
    @Override
    protected Command createAddCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
        if (child.getModel() instanceof GmNodeModel) {
            GmNodeModel childModel = (GmNodeModel) child.getModel();
            return new AutoUnmaskRelationshipReparentCommand(getHostCompositeNode(), childModel, constraint);
        } else {
            return null;
        }

    }

    @objid ("a885734c-776f-46c3-ae90-e2b1d07b77cb")
    @Override
    protected Command getCreateCommand(CreateRequest request) {
        final ModelioCreationContext ctx = (ModelioCreationContext.lookRequest(request));
        if (ctx != null) {
            final MObject elementToUnmask = ctx.getElementToUnmask();
            final GmCompositeNode gmParentNode = getHostCompositeNode();
            final MObject hostElement = getLayerContainer(ctx.getMetaclass());
            if (elementToUnmask != null) {
                if (gmParentNode.canUnmask(elementToUnmask)) {
                    final Object requestConstraint = getConstraintFor(request);
                    return new DefaultEditCreatedElementCommand(new DefaultCreateElementCommand(hostElement, gmParentNode, ctx, requestConstraint),getHost().getRoot().getViewer().getEditPartRegistry());
                } else {
                    return null;
                }
            } else if (hostElement != null) {
                MClass metaclassToCreate = ctx.getMetaclass();

                if (gmParentNode.canCreate(metaclassToCreate.getJavaInterface())) {
                    MExpert expert = metaclassToCreate.getMetamodel().getMExpert();
                    if (expert.canCompose(hostElement.getMClass(), metaclassToCreate, ctx.getDependencyName())) {
                        final Object requestConstraint = getConstraintFor(request);
                        return new DefaultEditCreatedElementCommand(new DefaultCreateElementCommand(hostElement, gmParentNode, ctx, requestConstraint),getHost().getRoot().getViewer().getEditPartRegistry());
                    }
                }
            }
        }
        return null;
    }

    @objid ("137f7d6b-a0ec-4128-810a-030aa95eb9d6")
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
            return command.unwrap();
        }
        return null;
    }

    @objid ("185beadf-0d6e-4c6b-b3d5-01b59436cd25")
    @Override
    protected Model getHostElement() {
        // Use the diagram's context (or the viewpoint's) rather than the diagram's composition owner
        final ArchimateView diagram = (ArchimateView) getHostCompositeNode().getRelatedElement();
        if (diagram.getContext() != null) {
            return diagram.getContext();
        } else {
            ModelElement origin = diagram.getOrigin();
            if (origin instanceof ViewPoint) {
                return ((ViewPoint) origin).getContext();
            }
        }
        return null;
    }

    @objid ("dd7cefae-cd1e-44ec-97d2-426f59510b70")
    protected Folder getLayerContainer(MClass metaclass) {
        Model model = getHostElement();
        return model != null ? ArchimateLayerExpert.getLayerContainer(model, metaclass) : null;
    }

    @objid ("03de3c58-c540-4bfe-83d5-c708da05c905")
    @Override
    protected boolean canHandle(MClass metaclass, String dep) {
        // Any note or constraint figure may owned by the diagram figure.
        if (Note.class.isAssignableFrom(metaclass.getJavaInterface()) || Constraint.class.isAssignableFrom(metaclass.getJavaInterface())) {
            return true;
        }

        final MObject hostElement = getLayerContainer(metaclass);
        if (hostElement == null) {
            return false;
        }
        MMetamodel mm = hostElement.getMClass().getMetamodel();
        return mm.getMExpert().canCompose(hostElement.getMClass(), metaclass, dep);
    }

    @objid ("96b2c566-eed2-4767-a0ea-ed27508c5c8d")
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
     * Command that unmasks all Archimate {@link StructuralRelationship} from the old graphical owner when reparenting an Archimate {@link Element} to the diagram.
     */
    @objid ("86664a09-2b21-4367-985d-28b343d50abb")
    private class AutoUnmaskRelationshipReparentCommand extends Command {
        /**
         * The child that is being reparented.
         */
        @objid ("c1042b42-4070-432e-bbba-56f5a35b4115")
        private GmNodeModel reparentedChild;

        /**
         * The new layout data of the reparented child.
         */
        @objid ("e89e65fd-f03e-4a96-93b3-c0bb0baa72d2")
        private Object newLayoutData;

        /**
         * The new parent of the reparented child.
         */
        @objid ("3df2973a-44e3-453c-bc77-3c888accd8b6")
        private GmCompositeNode newParent;

        @objid ("684e3244-b1d0-4407-a5db-7e2d88b08ebd")
        public AutoUnmaskRelationshipReparentCommand(GmCompositeNode newParent, GmNodeModel reparentedChild, Object newLayoutData) {
            super();
            this.newParent = newParent;
            this.reparentedChild = reparentedChild;
            this.newLayoutData = newLayoutData;

        }

        @objid ("5483b34d-07c2-48e7-aad7-b4d0e37a47e5")
        @Override
        public void execute() {
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

        @objid ("47008c2e-0ebc-4d6a-ad5a-93daf36ab3cf")
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

        @objid ("a15940d8-90c4-4972-9a79-a7c749f54352")
        private void unmaskLink(Relationship link, Point location) {
            ModelElementDropRequest dropRequest = new ModelElementDropRequest();
            dropRequest.setDroppedElements(new MObject[] { link });
            dropRequest.setLocation(location);
            EditPart targetEditPart = getHost().getTargetEditPart(dropRequest);
            if (targetEditPart != null) {
                Command command = targetEditPart.getCommand(dropRequest);
                if (command != null && command.canExecute()) {
                    command.execute();
                }
            }

        }

        /**
         * When reparenting a node into the diagram, unmask the structural relationships existing from the old parent to this node.
         */
        @objid ("bf385ff7-b857-47df-b413-c7b8862e37f8")
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

    }

}
