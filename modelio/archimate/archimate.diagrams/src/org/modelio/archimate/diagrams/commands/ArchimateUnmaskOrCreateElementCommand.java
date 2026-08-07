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
package org.modelio.archimate.diagrams.commands;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.elements.core.commands.DefaultSelectElementCommand;
import org.modelio.diagram.elements.core.commands.ModelioCreationContext;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.elements.core.ui.ElementSelectionData;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * {@link GmNodeModel} creation command that:
 * <ul>
 * <li>allow to select an existing {@link MObject}
 * <li>creates the {@link GmNodeModel} and unmask it.
 * <li>optionaly, it allow also to creates and initialize the {@link MObject} if asked.
 * </ul>
 * according to the provided {@link ModelioCreationContext}.
 */
@objid ("435a4098-42ab-4d12-b390-2cb74e61c772")
public class ArchimateUnmaskOrCreateElementCommand extends DefaultSelectElementCommand {
    @objid ("97bc7867-cdbc-4f80-b823-a8be964ffc9b")
    public ArchimateUnmaskOrCreateElementCommand(GmCompositeNode parentNode, ModelioCreationContext context, Object constraint) {
        super(parentNode, context, constraint);
    }

    @objid ("24c75c7e-4ed1-470e-9c63-aa4ddff5d6bd")
    public ArchimateUnmaskOrCreateElementCommand(MObject hostElement, GmCompositeNode gmParentNode, ModelioCreationContext ctx, Object requestConstraint) {
        super(hostElement,gmParentNode, ctx, requestConstraint);
    }

    @objid ("16621494-09ba-4e01-99bf-5dff2bcdff4b")
    @Override
    public ElementSelectionData initSelectionDataModel() {
        ElementSelectionData data = new ElementSelectionData(this.context.getMetaclass());
        return data;
    }

}
