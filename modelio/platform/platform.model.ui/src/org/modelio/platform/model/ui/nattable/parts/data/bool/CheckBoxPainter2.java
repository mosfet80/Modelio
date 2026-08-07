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
package org.modelio.platform.model.ui.nattable.parts.data.bool;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.CheckBoxPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.swt.graphics.Image;

/**
 * This modified {@link CheckBoxPainter} can manage on-boolean values and non editable cells.
 * <p>
 * Non-boolean values make the standard CheckBoxPainter fail with an uncaught exception.
 * Uncaught exception in a NatTable results in a really ugly
 * displayed results. The CheckBoxPainter2 is therefore protected agains't non-boolean values.
 *
 * @author phv
 */
@objid ("bc68b1c9-ee92-4220-9dd9-25702dd901b0")
public class CheckBoxPainter2 extends CheckBoxPainter {
    @objid ("fa46e9ce-4334-4f0e-b4a5-563bf8cde918")
    private final Image checkedDisabled;

    @objid ("f02b0e50-1b91-424f-a77c-1fd1eabc9d4d")
    private final Image uncheckedDisabled;

    @objid ("63f35540-26f8-4775-b2a0-ab18e55460d4")
    public CheckBoxPainter2() {
        this.uncheckedDisabled = GUIHelper.getImage("unchecked_disabled");
        this.checkedDisabled = GUIHelper.getImage("checked_disabled");
    }

    /**
     * Redefined to handle values not convertible to boolean.
     * <p>
     * In this case it returns <i>null</i>.
     *
     * @return a Boolean or <i>null</i>.
     */
    @objid ("431282ae-585f-44e2-a8d3-153bf2d7b9f7")
    @Override
    protected Boolean convertDataType(ILayerCell cell, IConfigRegistry configRegistry) {
        if (cell.getDataValue() instanceof Boolean) {
            return (Boolean) cell.getDataValue();
        }

        IDisplayConverter displayConverter = configRegistry.getConfigAttribute(
                CellConfigAttributes.DISPLAY_CONVERTER,
                cell.getDisplayMode(),
                cell.getConfigLabels().getLabels());

        if (displayConverter != null) {
            Object o = displayConverter.canonicalToDisplayValue(cell, configRegistry, cell.getDataValue());
            if (o instanceof Boolean) {
                return (Boolean) o;
            }
        }
        return null;
    }

    @objid ("cea7ce17-2510-4784-a7f0-5d7b777d4d78")
    @Override
    protected Image getImage(ILayerCell cell, IConfigRegistry configRegistry) {
        Boolean b = convertDataType(cell, configRegistry);
        if (b != null) {
            IEditableRule editableRule = configRegistry.getConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE, DisplayMode.EDIT, cell.getConfigLabels().getLabels());
            if (editableRule.isEditable(cell, configRegistry)) {
                return super.getImage(cell, configRegistry);
            } else {
                return getNonEditableImage(b);
            }
        } else {
            return this.uncheckedDisabled;
        }
    }

    @objid ("09aa1771-950a-4a34-9153-6fb10750532e")
    protected Image getNonEditableImage(boolean checked) {
        if (checked) {
            return this.checkedDisabled;
        } else {
            return this.uncheckedDisabled;
        }
    }

}
