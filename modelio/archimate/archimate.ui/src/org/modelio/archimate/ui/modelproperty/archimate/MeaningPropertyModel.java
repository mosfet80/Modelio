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
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.platform.model.ui.nattable.parts.data.INatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.single.DefaultStringNatValue;
import org.modelio.platform.model.ui.nattable.viewer.model.AbstractPropertyModel;

/**
 * <i>Meaning</i> data model.
 * <p>
 * This class provides the list of properties for the <i>Meaning</i> metaclass.
 * </p>
 */
@objid ("11301abb-8095-4646-8c27-80bfe588cd42")
public class MeaningPropertyModel extends AbstractPropertyModel<Meaning> {
    /**
     * Properties to display for <i>Meaning</i>.
     * <p>
     * This array contains the first column values:
     * <ul>
     * <li>for the first row the value is the table header label (usually the
     * metaclass name)
     * <li>for otheEditedElement rows the values usually match the
     * meta-attributes and roles names of the metaclass
     * </ul>
     */
    @objid ("dd50c955-fbd1-46fe-a8d0-7f9340e455ba")
    private static final String[] PROPERTIES = new String[] { AbstractPropertyModel.PROPERTY_ID, "Name" };

    /**
     * Create a new <i>Meaning</i> data model from an <i>Meaning</i>.
     *
     * @param theEditedElement the model to edit.
     */
    @objid ("ea7f75ea-4f46-4e49-924c-5a713e75e17d")
    public MeaningPropertyModel(Meaning theEditedElement) {
        super(theEditedElement);
    }

    /**
     * The number of columns that the properties table must display.
     *
     * @return the number of columns
     */
    @objid ("9a7591b1-2a17-4dbd-a8f3-977600b1678d")
    @Override
    public int getColumnNumber() {
        return 2;
    }

    /**
     * The number of rows that the properties table must display.
     *
     * @return the number of rows
     */
    @objid ("794a14d1-9747-4c1b-9a7a-f07d8e665022")
    @Override
    public int getRowsNumber() {
        return MeaningPropertyModel.PROPERTIES.length;
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
    @objid ("7a796c07-0298-47ef-89ad-e2ecf826c920")
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
    @objid ("79361856-b9a0-49f0-99f4-3504c4c5f529")
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
    @objid ("4d430a85-0345-4726-b265-9689762c0e66")
    private Object getValue(int row, int col) {
        switch (col) {
        case 0: // col 0 is the property key
            return getPropertyI18n(MeaningPropertyModel.PROPERTIES[row]);
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
