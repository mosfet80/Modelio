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
package org.modelio.diagram.elements.core.policies;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.modelio.diagram.elements.core.commands.TextEditCommand;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.elements.core.model.IEditableText;
import org.modelio.diagram.elements.plugin.DiagramElements;

/**
 * This policy processes the {@link DirectEditRequest}. It returns a universal {@link TextEditCommand} that simply
 * renames the ModelElement using the string provided by the figure editor.
 *
 * @see DirectEditPolicy
 */
@objid ("80bbb764-1dec-11e2-8cad-001ec947c8cc")
public class DefaultElementDirectEditPolicy extends DirectEditPolicy {
    @objid ("80bbb76a-1dec-11e2-8cad-001ec947c8cc")
    @Override
    protected Command getDirectEditCommand(DirectEditRequest edit) {
        IEditableText editableText = ((GmModel) getHost().getModel()).getEditableText();
        String newName = String.valueOf(edit.getCellEditor().getValue());

        TextEditCommand textEditCommand = new TextEditCommand(editableText, newName);
        textEditCommand.setLabel(DiagramElements.I18N.getMessage("DefaultElementDirectEditPolicy.command.label", editableText.getText(), newName));
        return textEditCommand;
    }

    @objid ("80bbb774-1dec-11e2-8cad-001ec947c8cc")
    @Override
    protected void showCurrentEditValue(DirectEditRequest request) {

    }

}
