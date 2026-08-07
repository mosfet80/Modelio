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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.InfluenceStrength;
import org.modelio.platform.model.ui.MetamodelLabels;
import org.modelio.platform.model.ui.nattable.parts.data.INatValue;
import org.modelio.platform.model.ui.nattable.parts.data.element.single.DefaultElementNatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.choice.DefaultStringChoiceNatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.single.DefaultStringNatValue;
import org.modelio.platform.model.ui.nattable.viewer.model.AbstractPropertyModel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * <i>Influence</i> data model.
 * <p>
 * This class provides the list of properties for the <i>Influence</i> metaclass.
 * </p>
 */
@objid ("da732dd2-8fd6-4103-a4fa-a9182a98a153")
public class InfluencePropertyModel extends AbstractPropertyModel<Influence> {
    /**
     * Properties to display for <i>Influence</i>.
     * <p>
     * This array contains the first column values:
     * <ul>
     * <li>for the first row the value is the table header label (usually the
     * metaclass name)
     * <li>for otheEditedElement rows the values usually match the
     * meta-attributes and roles names of the metaclass
     * </ul>
     */
    @objid ("9f37943c-0334-46e2-8cfa-4f6012bb90cc")
    private static final String[] PROPERTIES = new String[] { AbstractPropertyModel.PROPERTY_ID, "Name", "To", "Strength" };

    /**
     * Create a new <i>Influence</i> data model from an <i>Influence</i>.
     *
     * @param theEditedElement the model to edit.
     */
    @objid ("235f92ac-7dff-47fd-b5a0-248013e52bd4")
    public InfluencePropertyModel(Influence theEditedElement) {
        super(theEditedElement);
    }

    /**
     * The number of columns that the properties table must display.
     *
     * @return the number of columns
     */
    @objid ("ee6dcec1-1cba-4d0d-9c81-900fd2d620ec")
    @Override
    public int getColumnNumber() {
        return 2;
    }

    /**
     * The number of rows that the properties table must display.
     *
     * @return the number of rows
     */
    @objid ("ae984e5d-223e-4e78-864b-961f8a23ffc3")
    @Override
    public int getRowsNumber() {
        return InfluencePropertyModel.PROPERTIES.length;
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
    @objid ("3edbf9e0-a0b6-4754-876e-0e19ad9c1a71")
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
                List<String> defaultValues = new ArrayList<>();
                for (InfluenceStrength value : InfluenceStrength.values()) {
                    defaultValues.add(MetamodelLabels.getString(value.toString()));
                }
                return new DefaultStringChoiceNatValue((String) getValue(row, col), true, defaultValues, true);
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
    @objid ("d9d1c588-bdf3-4fb6-896a-26f22b5a0de9")
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
                String strengthValue = (String) value;
                for (InfluenceStrength v : InfluenceStrength.values()) {
                    if (strengthValue.equals(MetamodelLabels.getString(v.toString()))) {
                        strengthValue = v.name();
                        break;
                    }
                }
                this.theEditedElement.setStrength(strengthValue);
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
    @objid ("45b8401d-f52e-4fe8-b5c9-251d0204ddbb")
    private Object getValue(int row, int col) {
        switch (col) {
        case 0: // col 0 is the property key
            return getPropertyI18n(InfluencePropertyModel.PROPERTIES[row]);
        case 1: // col 1 is the property value
            switch (row) {
            case 0: // Header
                return getPropertyI18n(AbstractPropertyModel.VALUE_ID);
            case 1:
                return this.theEditedElement.getName();
            case 2:
                return this.theEditedElement.getTo();
            case 3:
                try {
                    return MetamodelLabels.getString(this.theEditedElement.getStrength());
                } catch (@SuppressWarnings("unused") IllegalArgumentException e) {
                    return InfluenceStrength.UNDEFINED.name();
                }

            default:
                return null;
            }
        default:
            return null;
        }

    }

}
