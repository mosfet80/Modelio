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
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.platform.model.ui.nattable.parts.data.INatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.single.DefaultStringNatValue;
import org.modelio.platform.model.ui.nattable.viewer.model.AbstractPropertyModel;

/**
 * <i>Event</i> data model.
 * <p>
 * This class provides the list of properties for the <i>Event</i> metaclass.
 * </p>
 */
@objid ("7094f235-fb32-4293-af8f-1d3ed91192df")
public class EventPropertyModel extends AbstractPropertyModel<Event> {
    /**
     * Properties to display for <i>Event</i>.
     * <p>
     * This array contains the first column values:
     * <ul>
     * <li>for the first row the value is the table header label (usually the
     * metaclass name)
     * <li>for otheEditedElement rows the values usually match the
     * meta-attributes and roles names of the metaclass
     * </ul>
     */
    @objid ("34e09fa5-5302-4778-b516-4277794a1a48")
    private static final String[] PROPERTIES = new String[] { AbstractPropertyModel.PROPERTY_ID, "Name", "Time" };

    /**
     * Create a new <i>Event</i> data model from an <i>Event</i>.
     *
     * @param theEditedElement the model to edit.
     */
    @objid ("f84548fe-6227-4183-b194-b2a60323858f")
    public EventPropertyModel(Event theEditedElement) {
        super(theEditedElement);
    }

    /**
     * The number of columns that the properties table must display.
     *
     * @return the number of columns
     */
    @objid ("1732f94e-31ac-4526-ad2a-8a80b97c2e79")
    @Override
    public int getColumnNumber() {
        return 2;
    }

    /**
     * The number of rows that the properties table must display.
     *
     * @return the number of rows
     */
    @objid ("9f4f19e3-957d-4b6b-ba80-ef1636c151a1")
    @Override
    public int getRowsNumber() {
        return EventPropertyModel.PROPERTIES.length;
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
    @objid ("7a32d14d-c018-4199-896c-6b195537ff5b")
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
            case 2:
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
    @objid ("f821bf18-a03e-4c21-b3eb-55a223e0c923")
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
            case 2:
                this.theEditedElement.setTime((String) value);
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
    @objid ("78c12698-c69e-4559-823c-41d07aa55f83")
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
            case 2:
                return this.theEditedElement.getTime();
            default:
                return null;
            }
        default:
            return null;
        }

    }

}
