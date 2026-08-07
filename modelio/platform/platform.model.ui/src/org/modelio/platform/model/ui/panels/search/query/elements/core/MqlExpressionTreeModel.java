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
package org.modelio.platform.model.ui.panels.search.query.elements.core;

import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.model.ui.panels.search.query.summary.MqlSummaryRenderer;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.NotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.PropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.query.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueExpr;

/**
 * Small helper model for editing an {@link Expr} tree against a selected step.
 * <p>
 * This is intentionally UI-agnostic: it provides a stable target for the
 * expression panel and a single place to apply changes to the underlying AST.
 */
@objid ("266d136b-6469-4f0c-b9a3-29c97799a205")
public final class MqlExpressionTreeModel {
    @objid ("aa016be0-5f8b-419e-96f9-0e52560f2f97")
    private final Target target;

    @objid ("822ec92e-8f9e-4797-b552-32e8596b67e1")
    private final MqlQueryModel rootModel;

    @objid ("f249dca6-ca54-4574-9185-03b497dc9e40")
    private final MqlStepNode stepNode;

    @objid ("f15e82c3-ad4e-4d40-ad17-0621ead3a9ee")
    public MqlExpressionTreeModel(final MqlQueryModel rootModel, final MqlStepNode stepNode, final Target target) {
        this.rootModel = Objects.requireNonNull(rootModel, "rootModel");
        this.stepNode = Objects.requireNonNull(stepNode, "stepNode");
        this.target = Objects.requireNonNull(target, "target");
    }

    @objid ("837efa79-d012-442f-a2a0-39f9cb59b12c")
    public MqlQueryModel getRootModel() {
        return this.rootModel;
    }

    @objid ("8088d6e5-9933-47fb-b533-b8fd83961ef1")
    public MqlStepNode getStepNode() {
        return this.stepNode;
    }

    @objid ("758f585a-a17f-44e2-bd34-e6e9266abb8e")
    public Target getTarget() {
        return this.target;
    }

    @objid ("2a05410b-698b-4ca2-998a-5b50707dc183")
    public boolean isNullable() {
        return this.target == Target.TRAVERSE_EDGE_FILTER;
    }

    @objid ("603bcf12-eb7a-4fbb-ae9f-291f09e3c7b9")
    public Expr getExpr() {
        if (this.target == Target.FILTER_WHERE) {
            if (!(this.stepNode.getAst() instanceof FilterStep filter)) {
                return null;
            }
            return filter.getWhere();
        }

        if (this.target == Target.TRAVERSE_EDGE_FILTER) {
            if (!(this.stepNode.getAst() instanceof TraverseStep traverse)) {
                return null;
            }
            return traverse.getEdgeFilter();
        }

        return null;
    }

    @objid ("87609ec1-f463-4269-8126-d16c0c2f7195")
    public void setExpr(final Expr expr) {
        if (expr == null) {
            if (isNullable()) {
                this.stepNode.setEdgeFilter(null);
            } else {
                this.stepNode.setWhere(createDefaultExpr(this.rootModel));
            }
            return;
        }

        if (this.target == Target.FILTER_WHERE) {
            this.stepNode.setWhere(expr);
        } else if (this.target == Target.TRAVERSE_EDGE_FILTER) {
            this.stepNode.setEdgeFilter(expr);
        }
    }

    @objid ("724ab5d4-0d89-4812-aeb5-40ed85765306")
    public String getExprSummary() {
        return MqlSummaryRenderer.renderExprSummary(getExpr());
    }

    @objid ("79318a99-0477-456f-9088-32c83c10bb8a")
    public void notifyAstMutated() {
        this.stepNode.notifyChanged();
    }

    @objid ("be737537-ff4b-4611-b95e-2f543b701a32")
    public static Expr createDefaultExpr(final MqlQueryModel rootModel) {
        return new IsExpr(defaultKindRef(rootModel));
    }

    @objid ("a44c652d-df88-4500-92ea-dcaeb2b368c1")
    public static AndExpr createDefaultAndExpr(final MqlQueryModel rootModel) {
        return new AndExpr(List.of(createDefaultExpr(rootModel)));
    }

    @objid ("844a1a1d-28e9-4b4c-b13e-3cbc3430d1df")
    public static OrExpr createDefaultOrExpr(final MqlQueryModel rootModel) {
        return new OrExpr(List.of(createDefaultExpr(rootModel)));
    }

    @objid ("27fb9081-698d-4ba1-a79b-0b3e944b9e17")
    public static NotExpr createDefaultNotExpr(final MqlQueryModel rootModel) {
        return new NotExpr(createDefaultExpr(rootModel));
    }

    @objid ("d7505aca-ba94-4b80-b510-a3fea7588e57")
    public static CompareExpr createDefaultCompareExpr() {
        return new CompareExpr("=", new PropertyValueExpr("Name"), LiteralValueExpr.ofString(""));
    }

    @objid ("24c8cdc8-2b85-408f-b00d-1177bfb07e13")
    public static IsExpr createDefaultIsExpr(final MqlQueryModel rootModel) {
        return new IsExpr(defaultKindRef(rootModel));
    }

    @objid ("ed73afad-5ad2-4361-95b4-d8980338f3b0")
    public static ExistsExpr createDefaultExistsExpr() {
        // Existence checks are optional in v1; keep a tiny default with one traverse step.
        Step step = new TraverseStep("Parent", null, Direction.FORWARD);
        return new ExistsExpr(List.of(step));
    }

    @objid ("95848bbc-3862-4e50-9027-df898a67fdbc")
    public static ValueExpr createDefaultPropertyValueExpr() {
        return new PropertyValueExpr("Name");
    }

    @objid ("500eb1b7-9505-434e-944a-ca3a5e2ffa8e")
    public static ValueExpr createDefaultLiteralValueExpr() {
        return LiteralValueExpr.ofString("");
    }

    @objid ("444d454d-0cf6-47f1-8c9d-97a76cb158b3")
    private static String defaultKindRef(final MqlQueryModel rootModel) {
        if (rootModel == null || rootModel.getSourceNode() == null) {
            return "Infrastructure.ModelElement";
        }
        String kind = rootModel.getSourceNode().getAllKindRef();
        if (kind != null && !kind.isBlank()) {
            return kind;
        }
        return "Infrastructure.ModelElement";
    }

    @objid ("b9be3ff1-5720-4c79-846b-4fca8cba4ba8")
    public enum Target {
        @objid ("71db7302-d372-4e1e-9717-1c48872c1edf")
        FILTER_WHERE,
        @objid ("67c5bc75-ed20-489d-bf84-eeef95071b76")
        TRAVERSE_EDGE_FILTER;

    }

}
