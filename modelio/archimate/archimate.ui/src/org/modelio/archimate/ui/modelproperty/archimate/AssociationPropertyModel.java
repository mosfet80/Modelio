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

import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.platform.model.ui.nattable.parts.data.INatValue;
import org.modelio.platform.model.ui.nattable.parts.data.bool.DefaultBooleanNatValue;
import org.modelio.platform.model.ui.nattable.parts.data.element.single.DefaultElementNatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.single.DefaultStringNatValue;
import org.modelio.platform.model.ui.nattable.viewer.model.AbstractPropertyModel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * <i>Association</i> data model.
 * <p>
 * This class provides the list of properties for the <i>Association</i> metaclass.
 * </p>
 */
@objid ("484fb1bd-ef06-4534-9abc-e94ad8911a31")
public class AssociationPropertyModel extends AbstractPropertyModel<Association> {
    /**
     * Properties to display for <i>Association</i>.
     * <p>
     * This array contains the first column values:
     * <ul>
     * <li>for the first row the value is the table header label (usually the
     * metaclass name)
     * <li>for otheEditedElement rows the values usually match the
     * meta-attributes and roles names of the metaclass
     * </ul>
     */
    @objid ("aa5805bf-59e8-4f57-b41e-bf5acab20358")
    private static final String[] PROPERTIES = new String[] { AbstractPropertyModel.PROPERTY_ID, "Name", "To", "Directed" };

    /**
     * The number of columns that the properties table must display.
     *
     * @return the number of columns
     */
    @objid ("a4acbe6a-8ee0-41ee-bff2-e2241d0a4cc8")
    @Override
    public int getColumnNumber() {
        return 2;
    }

    /**
     * The number of rows that the properties table must display.
     *
     * @return the number of rows
     */
    @objid ("177b5ad4-f9d3-4d22-a197-18e91cd48543")
    @Override
    public int getRowsNumber() {
        return AssociationPropertyModel.PROPERTIES.length;
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
    @objid ("dca73fdd-2311-48ef-b3c0-8b67f95b2b10")
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
                return new DefaultElementNatValue((MObject) getValue(row, col), false, Collections.singletonList(Concept.class));
            case 3:
                return new DefaultBooleanNatValue((Boolean) getValue(row, col));
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
    @objid ("45a8e728-6ad0-49fb-9a03-f3eb43529374")
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
                this.theEditedElement.setTo((Concept) value);
                break;
            case 3:
                this.theEditedElement.setDirected(((Boolean) value).booleanValue());
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
    @objid ("38c58b7a-7648-4f6e-998a-420fbf1c43fa")
    private Object getValue(int row, int col) {
        switch (col) {
        case 0: // col 0 is the property key
            return getPropertyI18n(AssociationPropertyModel.PROPERTIES[row]);
        case 1: // col 1 is the property value
            switch (row) {
            case 0: // Header
                return getPropertyI18n(AbstractPropertyModel.VALUE_ID);
            case 1:
                return this.theEditedElement.getName();
            case 2:
                return this.theEditedElement.getTo();
            case 3:
                return this.theEditedElement.isDirected();
            default:
                return null;
            }
        default:
            return null;
        }

    }

    /**
     * Create a new <i>Association</i> data model from an <i>Association</i>.
     *
     * @param theEditedElement the model to edit.
     */
    @objid ("b4c79be3-ed60-430e-96b1-d5021f4d68e4")
    public AssociationPropertyModel(Association theEditedElement) {
        super(theEditedElement);
    }

}
