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
package org.modelio.archimate.ui.modelproperty.archimate;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.platform.model.ui.nattable.parts.data.INatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.single.DefaultStringNatValue;
import org.modelio.platform.model.ui.nattable.viewer.model.AbstractPropertyModel;

/**
 * <i>ArchimateProject</i> data model.
 * <p>
 * This class provides the list of properties for the <i>ArchimateProject</i> metaclass.
 * </p>
 */
@objid ("ce855e59-d838-4d27-98f4-9ed09676a38d")
public class ArchimateProjectPropertyModel extends AbstractPropertyModel<ArchimateProject> {
    /**
     * Properties to display for <i>ArchimateProject</i>.
     * <p>
     * This array contains the first column values:
     * <ul>
     * <li>for the first row the value is the table header label (usually the
     * metaclass name)
     * <li>for otheEditedElement rows the values usually match the
     * meta-attributes and roles names of the metaclass
     * </ul>
     */
    @objid ("ebe3572c-be6b-4368-b8e0-8a44f48b6547")
    private static final String[] PROPERTIES = new String[] { AbstractPropertyModel.PROPERTY_ID, "Name" };

    /**
     * Create a new <i>ArchimateProject</i> data model from an <i>ArchimateProject</i>.
     *
     * @param theEditedElement the model to edit.
     */
    @objid ("dff9635c-1788-4b38-b61c-5457522784e1")
    public ArchimateProjectPropertyModel(ArchimateProject theEditedElement) {
        super(theEditedElement);
    }

    /**
     * The number of columns that the properties table must display.
     *
     * @return the number of columns
     */
    @objid ("f64e358d-b528-4ff1-a48a-4c027a4c4d1e")
    @Override
    public int getColumnNumber() {
        return 2;
    }

    /**
     * The number of rows that the properties table must display.
     *
     * @return the number of rows
     */
    @objid ("b523dec7-ccdf-4d4b-8dd4-c7f343d50346")
    @Override
    public int getRowsNumber() {
        return ArchimateProjectPropertyModel.PROPERTIES.length;
    }

    /**
     * Return the type of the element displayed at the specified row and column.
     * <p>
     * This type will be used to choose an editor and a renderer for each cell
     * of the properties table.
     * <p>
     * The first column contains the properties names.
     *
     * @param row the row number
     * @param col the column number
     * @return the type of the element corresponding to the row and column
     */
    @objid ("386feabb-ef70-4475-9dbc-414a8db6f823")
    @Override
    public INatValue getValueAt(int row, int col) {
        switch (col) {
        case 0: // col 0 is the property key type
            return new DefaultStringNatValue((String) getValue(row, col), false);
        case 1: // col 1 is the property value type
            switch (row) {
            case 0: // Header
                return new DefaultStringNatValue((String) getValue(row, col), false);
            case 1:
                return new DefaultStringNatValue((String) getValue(row, col), false);
            default:
                return null;
            }
        default:
            return null;
        }

    }

    /**
     * Set value in the model for the specified row and column.
     * <p>
     * The first column contains the properties names.
     *
     * @param row the row number.
     * @param col the column number.
     * @param value the value specified by the user.
     */
    @objid ("4b6405e1-569f-4b3b-b93f-686e940d39b9")
    @Override
    public void setValueAt(int row, int col, Object value) {
        switch (col) {
        case 0: // Keys cannot be modified
            return;
        case 1: // col 1 is the property value
            switch (row) {
            case 0:
                return; // Header cannot be modified
            case 1:
                this.theEditedElement.setName((String) value);
                break;
            default:
                return;
            }
            break;
        default:
            return;
        }

    }

    /**
     * Return the value that will be displayed at the specified row and column.
     * <p>
     * The first column contains the properties names.
     *
     * @param row the row number
     * @param col the column number
     * @return the value corresponding to the row and column
     */
    @objid ("85876955-8191-47a4-a2d6-a2a3f11c559c")
    private Object getValue(int row, int col) {
        switch (col) {
        case 0: // col 0 is the property key
            return getPropertyI18n(PROPERTIES[row]);
        case 1: // col 1 is the property value
            switch (row) {
            case 0: // Header
                return getPropertyI18n(AbstractPropertyModel.VALUE_ID);
            case 1:
                return this.theEditedElement.getName();
            default:
                return null;
            }
        default:
            return null;
        }

    }

}
