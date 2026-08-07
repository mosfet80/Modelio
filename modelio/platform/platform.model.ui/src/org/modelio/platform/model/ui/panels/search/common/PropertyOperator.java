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
package org.modelio.platform.model.ui.panels.search.common;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.model.ui.plugin.CoreUi;

@objid ("521193bd-4dcc-4375-849f-66b97ecb9bcd")
public enum PropertyOperator {
    @objid ("2d35e2e0-475c-4c3e-ba72-1a42b4267e96")
    EQUALS(CoreUi.I18N.getString("PropertyOperator.Equals"), "="),
    @objid ("92df640e-e75a-4678-b424-78e71cefa547")
    CONTAINS(CoreUi.I18N.getString("PropertyOperator.Contains"), "contains"),
    @objid ("2519eb25-8183-4b5f-9613-b282e03333b6")
    STARTS_WITH(CoreUi.I18N.getString("PropertyOperator.StartsWith"), "startsWith"),
    @objid ("f8802fa4-755a-42d0-a578-aba5eff01dc4")
    NOT_EQUALS(CoreUi.I18N.getString("PropertyOperator.NotEquals"), "!="),
    @objid ("ac0fd712-7d7f-46f0-9b90-fa38fbb83beb")
    GREATER_THAN(CoreUi.I18N.getString("PropertyOperator.GreaterThan"), ">"),
    @objid ("6f8612b9-f41e-4097-b525-fe0bac70d3e8")
    LESS_THAN(CoreUi.I18N.getString("PropertyOperator.LessThan"), "<"),
    @objid ("cd3da294-8e44-4cc1-9558-cd5a63546715")
    GREATER_THAN_OR_EQUALS(CoreUi.I18N.getString("PropertyOperator.GreaterThanOrEquals"), ">="),
    @objid ("ae916b46-1603-4a4a-b60c-bbc8f181cbf1")
    LESS_THAN_OR_EQUALS(CoreUi.I18N.getString("PropertyOperator.LessThanOrEquals"), "<=");

    @objid ("e4ee59c2-12e3-4412-8ce5-147ef3da1f90")
    public final String label;

    @objid ("1e09593c-6f8d-4f47-a6df-d6771893ac41")
    public final String expression;

    @objid ("517a9b04-7f4a-4bfb-a617-2cea36985dde")
    private PropertyOperator(String label, String expression) {
        this.label = label;
        this.expression = expression;
    }

}
