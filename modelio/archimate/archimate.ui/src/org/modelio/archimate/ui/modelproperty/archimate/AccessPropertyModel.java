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
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.AccessMode;
import org.modelio.platform.model.ui.nattable.parts.data.INatValue;
import org.modelio.platform.model.ui.nattable.parts.data.element.single.DefaultElementNatValue;
import org.modelio.platform.model.ui.nattable.parts.data.javaenum.DefaultJavaEnumNatValue;
import org.modelio.platform.model.ui.nattable.parts.data.string.single.DefaultStringNatValue;
import org.modelio.platform.model.ui.nattable.viewer.model.AbstractPropertyModel;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * <i>Access</i> data model.
 * <p>
 * This class provides the list of properties for the <i>Access</i> metaclass.
 * </p>
 */
@objid ("d5cf574e-9eae-42c5-8748-a1f9e17d7703")
public class AccessPropertyModel extends AbstractPropertyModel<Access> {
    /**
     * Properties to display for <i>Access</i>.
     * <p>
     * This array contains the first column values:
     * <ul>
     * <li>for the first row the value is the table header label (usually the
     * metaclass name)
     * <li>for otheEditedElement rows the values usually match the
     * meta-attributes and roles names of the metaclass
     * </ul>
     */
    @objid ("4072ae9c-2128-4fda-9de0-2fce400a0384")
    private static final String[] PROPERTIES = new String[] { AbstractPropertyModel.PROPERTY_ID, "Name", "To", "Mode" };

    /**
     * Create a new <i>Access</i> data model from an <i>Access</i>.
     *
     * @param theEditedElement the model to edit.
     */
    @objid ("332a0123-86df-4f99-a577-e6e004cc3bf8")
    public AccessPropertyModel(Access theEditedElement) {
        super(theEditedElement);
    }

    /**
     * The number of columns that the properties table must display.
     *
     * @return the number of columns
     */
    @objid ("a3c4a025-f81e-461f-b4e9-b73cc4810e5a")
    @Override
    public int getColumnNumber() {
        return 2;
    }

    /**
     * The number of rows that the properties table must display.
     *
     * @return the number of rows
     */
    @objid ("97a8cd82-a6f1-4347-91c6-8b5e1e1daec8")
    @Override
    public int getRowsNumber() {
        return AccessPropertyModel.PROPERTIES.length;
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
    @objid ("1a1efaf9-ca75-4fee-bc22-4023ce10d0f2")
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
                return new DefaultJavaEnumNatValue((Enum<?>) getValue(row, col), AccessMode.class);
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
    @objid ("96440642-c2e5-4bd2-98c2-5fc321d635ce")
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
                this.theEditedElement.setMode((AccessMode) value);
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
    @objid ("fe604159-2615-485d-915a-b57e67675f0e")
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
                return this.theEditedElement.getTo();
            case 3:
                return this.theEditedElement.getMode();
            default:
                return null;
            }
        default:
            return null;
        }

    }

}
