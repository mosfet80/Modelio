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
package org.modelio.archimate.diagrams.elements.viewpointdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.modelio.diagram.elements.common.abstractdiagram.DiagramEditLayoutPolicy;
import org.modelio.diagram.elements.core.commands.DefaultEditCreatedElementCommand;
import org.modelio.diagram.elements.core.commands.ModelioCreationContext;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * This policy allow to redefine the DefaultCreateElementCommand in order to provide specfique command for ViewPoint
 */
@objid ("d025b3a7-e92b-40e8-a60c-77cd74ae68d1")
public class ViewPointDiagramEditLayoutPolicy extends DiagramEditLayoutPolicy {
    @objid ("8edfb7da-4aed-4e88-b649-bd014ecc605e")
    @Override
    protected Command getCreateCommand(CreateRequest request) {
        final MObject hostElement = getHostElement();
        final ModelioCreationContext ctx = (ModelioCreationContext.lookRequest(request));
        if (ctx != null) {
            final MObject elementToUnmask = ctx.getElementToUnmask();
            final GmCompositeNode gmParentNode = getHostCompositeNode();
            if (elementToUnmask != null) {
                if (gmParentNode.canUnmask(elementToUnmask)) {
                    final Object requestConstraint = getConstraintFor(request);
                    return new DefaultEditCreatedElementCommand(new ViewPointCreateElementCommand(hostElement, gmParentNode, ctx, requestConstraint),getHost().getRoot().getViewer().getEditPartRegistry());
                } else {
                    return null;
                }
            } else if (hostElement != null) {
                MClass metaclassToCreate = ctx.getMetaclass();

                if (gmParentNode.canCreate(metaclassToCreate.getJavaInterface())) {
                    MExpert expert = metaclassToCreate.getMetamodel().getMExpert();
                    if (expert.canCompose(hostElement.getMClass(), metaclassToCreate, ctx.getDependencyName())) {
                        final Object requestConstraint = getConstraintFor(request);
                        return new DefaultEditCreatedElementCommand(new ViewPointCreateElementCommand(hostElement, gmParentNode, ctx, requestConstraint),getHost().getRoot().getViewer().getEditPartRegistry());
                    }
                }
            }
        }
        return null;
    }

}
