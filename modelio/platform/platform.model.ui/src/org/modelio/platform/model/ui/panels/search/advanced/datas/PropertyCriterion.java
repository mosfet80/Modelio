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
package org.modelio.platform.model.ui.panels.search.advanced.datas;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper.MPropertyInfo;
import org.modelio.platform.model.ui.panels.search.common.PropertyOperator;

@objid ("60de423a-4069-4b68-93fa-841f2c1742e0")
public class PropertyCriterion {
    @objid ("0728bd56-d518-4d4b-82ec-892095f21731")
    private String propertyName;

    @objid ("b6a1c158-e88c-4a5e-8064-0f2ed3761148")
    private PropertyOperator operator;

    @objid ("e4d35b0f-52cb-48e6-bb6d-10abd8aa19ba")
    private String value;

    @objid ("bdb6dd14-57c2-4850-82de-94758478df83")
    private MPropertyInfo type;

    @objid ("a997fc60-b144-4b24-b70c-2c21e7f7dfc0")
    public PropertyCriterion(String propertyName, PropertyOperator operator, String value, MPropertyInfo type) {
        this.propertyName = propertyName;
        this.operator = operator;
        this.value = value;
        this.type = type;
    }

    @objid ("1e30d358-244a-4106-a62a-4103653e6862")
    public String getPropertyName() {
        return this.propertyName;
    }

    @objid ("98892689-d6eb-435b-a4a5-a6e63ba3416b")
    public PropertyOperator getOperator() {
        return this.operator;
    }

    @objid ("bc2343c3-4878-449b-bbf9-fdc73fa4ecc0")
    public String getValue() {
        return this.value;
    }

    @objid ("ba06d4ce-0fd3-4fa7-8030-6e2b634a544a")
    public MPropertyInfo getType() {
        return this.type;
    }

}
