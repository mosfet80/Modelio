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
package org.modelio.platform.model.ui.panels.search.query.summary;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AllSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LimitsSpec;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.NotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.PropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ProvidedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.query.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.query.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.UnionStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueExpr;

/**
 * Render a non-editable, pseudo-syntax summary for a query.
 * <p>
 * The summary is intended to help non-technical users validate what they built
 * without ever showing JSON.
 */
@objid ("a55830e1-f601-4a2e-849f-6ed91654d844")
public final class MqlSummaryRenderer {
    @objid ("1b1b9850-8a7d-42c3-b4af-7fa79d0257f6")
    public static String renderExprSummary(final Expr expr) {
        return renderExpr(expr);
    }

    @objid ("db6ed969-abc7-4347-8657-acaeb1c01f80")
    public static String renderStepSummary(final Step step) {
        return renderStep(step, "");
    }

    @objid ("7fe64cf1-02da-46a2-b655-08520ee6e9a4")
    public String render(final MqlQueryModel model) {
        Objects.requireNonNull(model, "model");
        return render(model.getQueryAst());
    }

    @objid ("1e85c2bd-38f6-448f-845e-c62e28862084")
    public String render(final Query query) {
        Objects.requireNonNull(query, "query");

        StringBuilder sb = new StringBuilder();
        sb.append(renderSource(query.getSource())).append('\n');

        List<Step> steps = query.getSteps();
        if (steps.isEmpty()) {
            sb.append("");
        } else {
            // sb.append("STEPS:\n");
            renderStepList(sb, steps);
        }

        sb.append(renderLimits(query.getLimits())).append('\n');
        return sb.toString();
    }

    @objid ("abdcc81e-4cad-44f8-9b29-aaa01e836880")
    private StringBuilder renderStepList(StringBuilder sb, List<Step> steps) {
        for (int i = 0; i < steps.size(); i++) {
            sb.append(renderStep(steps.get(i), "")).append('\n');
        }
        return sb;
    }

    @objid ("7adc75e3-88dd-4cd6-a04d-caf19c52b286")
    private static String renderSource(final Source source) {
        if (source instanceof AllSource all) {
            return "FROM ALL " + all.getKindName() + "";
        } else if (source instanceof ProvidedSource provided) {
            return "FROM PROVIDED SELECTION ";
        }
        return "FROM (unknown)";
    }

    @objid ("556e3ac5-1a79-4729-9bff-018465a3896f")
    private static String renderLimits(final LimitsSpec limits) {
        if (limits == null || (limits.getLimit() == null && limits.getMaxDepth() == null && limits.getTimeoutMs() == null)) {
            return "";
        }

        StringJoiner joiner = new StringJoiner(", ", " LIMITS ", "");
        joiner.add("maxDepth " + valueOrDefault(limits.getMaxDepth(), "default"));
        joiner.add("limit " + valueOrDefault(limits.getLimit(), "default"));
        joiner.add("timeout " + valueOrDefault(limits.getTimeoutMs(), "default"));
        return joiner.toString();
    }

    @objid ("8bfbf459-2368-470d-aa34-5f2681ad3ff9")
    private static String valueOrDefault(final Object value, final String defaultLabel) {
        return value != null ? String.valueOf(value) : defaultLabel;
    }

    @objid ("c6250126-f64a-4b5b-96cb-363ba6891340")
    private static String renderStep(final Step step, String marging) {
        if (step instanceof FilterStep filter) {

            return marging + "WHERE " + renderExpr(filter.getWhere());
        }
        if (step instanceof TraverseStep traverse) {
            StringBuilder sb = new StringBuilder();
            sb.append(marging);
            sb.append("NAVIGATE TO ").append(traverse.getEdge());
            if (traverse.getDirection() == Direction.BACKWARD) {
                sb.append(" ").append(traverse.getDirection());
            }
            if (traverse.getEdgeFilter() != null) {
                sb.append(" WHERE ").append(renderExpr(traverse.getEdgeFilter()));
            }
            return sb.toString();
        }
        if (step instanceof UnionStep union) {
            StringBuilder sb = new StringBuilder();
            sb.append(marging);
            sb.append("UNION (").append("\n");
            for (List<Step> branche : union.getBranches()) {
                for (Step subStep : branche) {
                    sb.append(renderStep(subStep, marging + "        "));
                    if(!subStep.equals(branche.get(branche.size() - 1))) {
                        sb.append("\n");
                    }else {
                        if (!branche.equals(union.getBranches().get(union.getBranches().size() - 1))) {
                            sb.append(" ,\n");
                        }else {
                            sb.append("\n");
                        }
                    }

                }
            }
            sb.append(marging + ")");
            return sb.toString();
        }
        if (step instanceof RepeatStep repeat) {
            StringBuilder sb = new StringBuilder();
            sb.append(marging + "REPEAT (").append("\n");
            for (Step subStep : repeat.getBody()) {
                sb.append(renderStep(subStep, marging + "        ")).append("\n");
            }
            sb.append(marging + ")");
            return sb.toString();
        }
        return step.getClass().getSimpleName();
    }

    @objid ("2db919b8-52d1-49c5-97a4-fef280d42302")
    private static String renderExpr(final Expr expr) {
        if (expr == null) {
            return "(none)";
        }
        if (expr instanceof AndExpr and) {
            return joinExprs("AND", and.getExprs());
        }
        if (expr instanceof OrExpr or) {
            return joinExprs("OR", or.getExprs());
        }
        if (expr instanceof NotExpr not) {
            return "NOT( " + renderExpr(not.getExpr()) + " )";
        }
        if (expr instanceof CompareExpr cmp) {
            return renderValue(cmp.getLeft()) + " " + cmp.getOp() + " " + renderValue(cmp.getRight());
        }
        if (expr instanceof IsExpr is) {
            return "IS ( " + is.getOfQualifiedName() + " )";
        }
        if (expr instanceof ExistsExpr ex) {
            String where = ex.getWhere() != null ? (" WHERE " + renderExpr(ex.getWhere())) : "";
            return "EXIST ( " + ex.getIn().size() + " steps" + where + " ) ";
        }
        return expr.getClass().getSimpleName();
    }

    @objid ("a8672bed-e820-44c0-a547-1d43d3b98dd7")
    private static String joinExprs(final String op, final List<Expr> exprs) {
        if (exprs == null || exprs.isEmpty()) {
            return op + "(none)";
        }
        StringJoiner sj = new StringJoiner(" " + op + " ");
        for (Expr e : exprs) {
            sj.add("(" + renderExpr(e) + ")");
        }
        return sj.toString();
    }

    @objid ("b3646cd5-ff05-49b3-b6eb-c6af823220b2")
    private static String renderValue(final ValueExpr valueExpr) {
        if (valueExpr instanceof PropertyValueExpr prop) {
            return prop.getProperty();
        }
        if (valueExpr instanceof LiteralValueExpr lit) {
            Object value = lit.getValue();
            return value != null ? String.valueOf(value) : "null";
        }
        return String.valueOf(valueExpr);
    }

}
