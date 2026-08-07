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
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.platform.model.ui.nattable.parts.data.INatValue;
import org.modelio.platform.model.ui.nattable.parts.data.element.single.DefaultElementNatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.single.DefaultStringNatValue;
import org.modelio.platform.model.ui.nattable.viewer.model.AbstractPropertyModel;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * <i>Relationship</i> data model.
 * <p>
 * This class provides the list of properties for the <i>Relationship</i> metaclass.
 * </p>
 */
@objid ("d1e330a8-03a2-4c39-abd0-ed85e300b00d")
public class RelationshipPropertyModel extends AbstractPropertyModel<Relationship> {
    /**
     * Properties to display for <i>Relationship</i>.
     * <p>
     * This array contains the first column values:
     * <ul>
     * <li>for the first row the value is the table header label (usually the
     * metaclass name)
     * <li>for otheEditedElement rows the values usually match the
     * meta-attributes and roles names of the metaclass
     * </ul>
     */
    @objid ("30b243ef-9386-4a67-ae33-22612550f72b")
    private static final String[] PROPERTIES = new String[] { AbstractPropertyModel.PROPERTY_ID, "Name", "To" };

    /**
     * Create a new <i>Relationship</i> data model from an <i>Relationship</i>.
     *
     * @param theEditedElement the model to edit.
     */
    @objid ("9720f102-81f5-4295-9875-3a0116755d3d")
    public RelationshipPropertyModel(Relationship theEditedElement) {
        super(theEditedElement);
    }

    /**
     * The number of columns that the properties table must display.
     *
     * @return the number of columns
     */
    @objid ("db8ad021-e42e-4862-8199-9190350e90f4")
    @Override
    public int getColumnNumber() {
        return 2;
    }

    /**
     * The number of rows that the properties table must display.
     *
     * @return the number of rows
     */
    @objid ("c101f801-7f2b-4222-9564-4eeefa4af907")
    @Override
    public int getRowsNumber() {
        return RelationshipPropertyModel.PROPERTIES.length;
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
    @objid ("d3f6e5c5-dc8c-4d1d-b6e8-06ee57baea3c")
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
                final MExpert mExpert = this.theEditedElement.getMClass().getMetamodel().getMExpert();
                final MClass linkMClass = this.theEditedElement.getMClass();
                final Concept from = this.theEditedElement.getFrom();

                DefaultElementNatValue elementNatValue = new DefaultElementNatValue((MObject) getValue(row, col), false, Collections.singletonList(Concept.class));
                // Add a filter to forbid link targeting themselves...
                elementNatValue.setElementFilter(element -> {
                    return !element.equals(this.theEditedElement) && mExpert.canLink(linkMClass, from, element);
                });
                return elementNatValue;
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
    @objid ("c932d9f0-42a9-461f-bcf6-1297f191ef32")
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
    @objid ("2e127204-dbdb-48fe-b31b-dd77433de6ba")
    private Object getValue(int row, int col) {
        switch (col) {
        case 0: // col 0 is the property key
            return getPropertyI18n(RelationshipPropertyModel.PROPERTIES[row]);
        case 1: // col 1 is the property value
            switch (row) {
            case 0: // Header
                return getPropertyI18n(AbstractPropertyModel.VALUE_ID);
            case 1:
                return this.theEditedElement.getName();
            case 2:
                return this.theEditedElement.getTo();
            default:
                return null;
            }
        default:
            return null;
        }

    }

}
