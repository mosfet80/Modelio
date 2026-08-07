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
package org.modelio.platform.model.ui.panels.search.advanced;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.panels.search.advanced.datas.NameMatchMode;
import org.modelio.platform.model.ui.panels.search.advanced.datas.PropertyCriterion;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AllSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LimitsSpec;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.PropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.vcore.smkernel.mapi.MClass;

@objid ("4f22a5d2-e7dd-4848-a40b-b023ee999ec8")
public class QueryConverter {
    @objid ("84d8076c-9537-49f9-b6e8-b540289ee4a4")
    private String name;

    @objid ("9270cfe4-399a-4d0b-b06c-88f0cf969057")
    private NameMatchMode nameConstraint;

    @objid ("d0cc954d-06f3-43e8-88f4-5a053d3d34ad")
    private static QueryConverter instance;

    @objid ("54853afd-138b-4ea5-9bf6-2065701e03e1")
    private MClass selectedMetaclass;

    @objid ("080c0133-ef91-4af7-96b1-2aefd512ab7f")
    private List<PropertyCriterion> propertyCriteria;

    @objid ("24ec15dc-41d1-4204-b1d5-54bfc02cef7a")
    private ModuleComponent selectedModule;

    @objid ("4d0d8709-f0c4-45bb-8216-3cf778fb7cd6")
    private Stereotype selectedStereotype;

    @objid ("00172737-686f-4907-b108-30009eeba643")
    public static QueryConverter instance() {
        if(instance == null) {
            instance = new QueryConverter();
        }
        return instance;
    }

    @objid ("128ad85b-b3ab-4f8f-a662-4b76e09aea0e")
    public QueryConverter setMetaclass(MClass selectedMetaclass) {
        this.selectedMetaclass = selectedMetaclass;
        return this;
    }

    @objid ("7dd01ff4-c297-4f91-a8ee-ddcbdb553215")
    public QueryConverter setName(String name, NameMatchMode contains) {
        this.name = name;
        this.nameConstraint = contains;
        return this;
    }

    @objid ("11d039f1-5c31-465a-afc8-cabba5e2f15b")
    public QueryConverter setProperty(List<PropertyCriterion> propertyCriteria) {
        this.propertyCriteria = propertyCriteria;
        return this;
    }

    @objid ("b2bc1980-507f-44fd-b7d9-272231a4c481")
    public QueryConverter setModuleComponent(ModuleComponent selectedModule) {
        this.selectedModule = selectedModule;
        return this;
    }

    @objid ("81d90e87-1521-43a1-a21b-aaad3cd8ebe2")
    public QueryConverter setStereotype(Stereotype selectedStereotype) {
        this.selectedStereotype = selectedStereotype;
        return this;
    }

    @objid ("60596cbe-3263-4158-a459-04115366161e")
    public Query convert() {
        if (this.selectedMetaclass == null && this.selectedStereotype == null) {
            throw new IllegalArgumentException("No metaclass selected");
        }
        String sourceToken;
        Stereotype stereotype = this.selectedStereotype;
        if (stereotype != null) {
            sourceToken = stereotype.getName();
        } else {
            sourceToken = this.selectedMetaclass.getQualifiedName();
        }

        Source source = new AllSource(sourceToken);

        List<Step> steps = new ArrayList<>();

        if (this.name != null && !this.name.isEmpty()) {
            steps.add(new FilterStep(createNameFilter(this.name, this.nameConstraint)));
        }

        for (PropertyCriterion propCrit : this.propertyCriteria) {
            if (!propCrit.getPropertyName().startsWith("[Tag] ")) {
                steps.add(new FilterStep(createPropertyFilter(propCrit)));
            }
        }

        LimitsSpec limits = new LimitsSpec();
        limits.setLimit(1000);
        limits.setTimeoutMs(60000L);

        return new Query(source, steps, limits);
    }

    @objid ("335e3482-61d3-45ab-8aa8-a5301e83a56b")
    private Expr createNameFilter(String name, NameMatchMode matchMode) {
        PropertyValueExpr nameProperty = new PropertyValueExpr("Name");
        LiteralValueExpr searchValue = LiteralValueExpr.ofString(name);

        String operator = switch (matchMode) {
            case EXACT -> "=";
            case CONTAINS -> "contains";
            case STARTS_WITH -> "startsWith";
            case ENDS_WITH -> "endsWith";
            default -> "=";
        };

        return new CompareExpr(operator, nameProperty, searchValue);
    }

    @objid ("a657fc80-1f4d-4537-9a0d-068bdadfe0d1")
    private static Expr createPropertyFilter(PropertyCriterion criterion) {
        String propertyName = criterion.getPropertyName();

        if (propertyName.startsWith("[Tag] ")) {
            propertyName = propertyName.substring(6);
        }

        PropertyValueExpr propertyExpr = new PropertyValueExpr(propertyName);
        LiteralValueExpr valueExpr = LiteralValueExpr.ofString(criterion.getValue());


        return new CompareExpr(criterion.getOperator().expression, propertyExpr, valueExpr);
    }

}
