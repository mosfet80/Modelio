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
package org.modelio.platform.search.engine.searchers.query.internal.executor;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedAndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedCompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedIsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedNotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedOrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedPropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedValueExpr.LiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedValueExpr.UnsupportedValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.result.PathOutput;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Recursively evaluates a {@link ResolvedExpr} predicate against an {@link MObject}.
 * <p>
 * Uses switch pattern matching on the sealed {@link ResolvedExpr} hierarchy.
 * Property absence (null) in comparisons causes the element to be excluded (returns false).
 */
@objid ("b3afdc5a-a140-47e9-b296-462cfe81fbf9")
public final class ExpressionEvaluator {
    @objid ("8b44aaf4-3a32-41e5-89d7-32f7ce4caefe")
    private ExpressionEvaluator() {
        // utility class
    }

    /**
     * Evaluates the given expression against the given element.
     *
     * @param expr the resolved expression to evaluate (must not be null)
     * @param element the model element to test (must not be null)
     * @param session the core session (must not be null)
     * @code true} if the element satisfies the expression, {@code false} otherwise
     */
    @objid ("12a8d203-92d6-430d-8ea2-0f56bef2ace1")
    public static boolean evaluate(ResolvedExpr expr, MObject element, ICoreSession session) {
        return switch (expr) {
            case ResolvedAndExpr and -> {
                for (ResolvedExpr operand : and.exprs()) {
                    if (!evaluate(operand, element, session)) {
                        yield false;
                    }
                }
                yield true; // empty list → true
            }
            case ResolvedOrExpr or -> {
                for (ResolvedExpr operand : or.exprs()) {
                    if (evaluate(operand, element, session)) {
                        yield true;
                    }
                }
                yield false; // empty list → false
            }
            case ResolvedNotExpr not -> !evaluate(not.expr(), element, session);
            case ResolvedIsExpr is -> KindMatcher.matches(element, is.kind());
            case ResolvedCompareExpr cmp -> evaluateCompare(cmp, element, session);
            case ResolvedExistsExpr ex -> evaluateExists(ex, element, session);
            case ResolvedExpr.UnsupportedExpr u -> false;
        };
    }

    /**
     * Evaluates a binary comparison expression.
     */
    @objid ("8cf69c2a-f405-43d0-b3bb-03ad9fd3f39f")
    private static boolean evaluateCompare(ResolvedCompareExpr cmp, MObject element, ICoreSession session) {
        Object left = resolveValue(cmp.left(), element, session);
        Object right = resolveValue(cmp.right(), element, session);

        // Null on either side → exclude element
        if (left == null || right == null) {
            return false;
        }

        String leftStr = String.valueOf(left);
        String rightStr = String.valueOf(right);

        return switch (cmp.op().toLowerCase()) {
            case "=", "eq" -> leftStr.equalsIgnoreCase(rightStr);
            case "!=", "neq" -> !leftStr.equalsIgnoreCase(rightStr);
            case "<", "lt" -> compareOrdered(leftStr, rightStr) < 0;
            case ">", "gt" -> compareOrdered(leftStr, rightStr) > 0;
            case "<=", "lte" -> compareOrdered(leftStr, rightStr) <= 0;
            case ">=", "gte" -> compareOrdered(leftStr, rightStr) >= 0;
            case "contains" -> leftStr.toLowerCase().contains(rightStr.toLowerCase());
            case "startswith", "starts_with" -> leftStr.toLowerCase().startsWith(rightStr.toLowerCase());
            default -> false; // Unknown operator
        };
    }

    /**
     * Resolves a value expression to its runtime value.
     */
    @objid ("28eab880-77ae-48e8-94f1-61a8934045ea")
    private static Object resolveValue(ResolvedValueExpr valueExpr, MObject element, ICoreSession session) {
        return switch (valueExpr) {
            case ResolvedPropertyValueExpr pvExpr -> PropertyValueReader.readValue(element, pvExpr.key());
            case LiteralValueExpr literal -> literal.value();
            case UnsupportedValueExpr unsupported -> null;
        };
    }

    /**
     * Compares two string values: attempts numeric comparison first, falls back to lexicographic.
     */
    @objid ("3476ebdc-a8bc-4827-9dc3-367f26c56971")
    private static int compareOrdered(String left, String right) {
        try {
            double leftNum = Double.parseDouble(left);
            double rightNum = Double.parseDouble(right);
            return Double.compare(leftNum, rightNum);
        } catch (NumberFormatException e) {
            return left.compareToIgnoreCase(right);
        }
    }

    /**
     * Evaluates an EXISTS expression.
     * <p>
     * Creates a singleton input from the current element, runs the sub-steps pipeline,
     * optionally filters with the WHERE clause, and returns true if any results remain.
     */
    @objid ("c7ee2e27-a8de-469f-bc98-7248c3e9ed69")
    private static boolean evaluateExists(ResolvedExistsExpr ex, MObject element, ICoreSession session) {
        List<TraversalItem> singletonInput = List.of(
                new TraversalItem(element, new PathOutput(List.of(element), List.of())));

        List<TraversalItem> subResults = StepPipelineExecutor.executeToList(ex.in(), singletonInput, session);

        if (ex.where() != null) {
            subResults = subResults.stream()
                    .filter(item -> evaluate(ex.where(), item.node(), session))
                    .toList();
        }

        return !subResults.isEmpty();
    }

}
