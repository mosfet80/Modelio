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
package org.modelio.platform.search.engine.searchers.query.api.model.query;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenAllSource;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenAndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenCompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenFilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenIsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenLiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenNotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenOrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenPropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenProvidedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenRepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenSource;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenStep;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenTraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenUnionStep;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenValueExpr;

/**
 * Utility class for converting between mutable and frozen (immutable) Query representations.
 */
@objid ("65e7f3c9-14ce-4e72-a793-92587ad22db7")
public class Conversions {
    // === Conversions: Frozen → Mutable ===
    @objid ("c0fc5cb5-36cd-4852-a8ae-a2b481f9c438")
    public static Source toMutable(FrozenSource frozen) {
        if (frozen instanceof FrozenAllSource fas) {
            return new AllSource(fas);
        } else if (frozen instanceof FrozenProvidedSource fps) {
            return new ProvidedSource(fps);
        }
        throw new IllegalArgumentException("Unknown FrozenSource type: " + frozen.getClass());
    }

    @objid ("13c2b551-ba9d-4cbc-b245-1ebf986f0f0d")
    public static Step toMutable(FrozenStep frozen) {
        if (frozen instanceof FrozenFilterStep ffs) {
            return new FilterStep(ffs);
        } else if (frozen instanceof FrozenTraverseStep fts) {
            return new TraverseStep(fts);
        } else if (frozen instanceof FrozenRepeatStep frs) {
            return new RepeatStep(frs);
        } else if (frozen instanceof FrozenUnionStep fus) {
            return new UnionStep(fus);
        }
        throw new IllegalArgumentException("Unknown FrozenStep type: " + frozen.getClass());
    }

    @objid ("719b2776-262a-4f56-a6e2-ae7bcc90be4b")
    public static Expr toMutable(FrozenExpr frozen) {
        if (frozen instanceof FrozenAndExpr fae) {
            return new AndExpr(fae);
        } else if (frozen instanceof FrozenOrExpr foe) {
            return new OrExpr(foe);
        } else if (frozen instanceof FrozenNotExpr fne) {
            return new NotExpr(fne);
        } else if (frozen instanceof FrozenCompareExpr fce) {
            return new CompareExpr(fce);
        } else if (frozen instanceof FrozenIsExpr fie) {
            return new IsExpr(fie);
        } else if (frozen instanceof FrozenExistsExpr fee) {
            return new ExistsExpr(fee);
        }
        throw new IllegalArgumentException("Unknown FrozenExpr type: " + frozen.getClass());
    }

    @objid ("c3e04397-b98d-47ce-9317-696aa07bcbfe")
    public static ValueExpr toMutable(FrozenValueExpr frozen) {
        if (frozen instanceof FrozenPropertyValueExpr fpve) {
            return new PropertyValueExpr(fpve);
        } else if (frozen instanceof FrozenLiteralValueExpr flve) {
            return new LiteralValueExpr(flve);
        }
        throw new IllegalArgumentException("Unknown FrozenValueExpr type: " + frozen.getClass());
    }

    // === Conversions: Mutable → Frozen ===
    @objid ("235d8fe4-04fb-478a-a282-e7ff53723cef")
    public static FrozenSource toFrozen(Source mutable) {
        if (mutable instanceof AllSource as) {
            return as.freeze();
        } else if (mutable instanceof ProvidedSource ps) {
            return ps.freeze();
        }
        throw new IllegalArgumentException("Unknown Source type: " + mutable.getClass());
    }

    // === List conversions ===
    @objid ("b3e6954b-5804-4c45-afc3-359a6c46206f")
    public static List<FrozenExpr> freezeExprList(List<Expr> exprs) {
        List<FrozenExpr> result = new ArrayList<>(exprs.size());
        for (Expr expr : exprs) {
            result.add(expr.freeze());
        }
        return result;
    }

    @objid ("25dcd1fb-9d6e-4313-a11d-283ca680ef8b")
    public static List<Expr> thawExprList(List<FrozenExpr> frozen) {
        List<Expr> result = new ArrayList<>(frozen.size());
        for (FrozenExpr expr : frozen) {
            result.add(toMutable(expr));
        }
        return result;
    }

    @objid ("d596c24d-987f-46d1-bbee-55ff680b4689")
    public static List<Step> thawStepList(List<FrozenStep> frozen) {
        List<Step> result = new ArrayList<>(frozen.size());
        for (FrozenStep step : frozen) {
            result.add(toMutable(step));
        }
        return result;
    }

    @objid ("3f69bf89-6726-4784-ade4-fb61e51abcb8")
    static List<FrozenStep> freezeStepList(List<Step> branch) {
        List<FrozenStep> result = new ArrayList<>(branch.size());
        for (Step step : branch) {
            result.add(step.freeze());
        }
        return result;
    }

    @objid ("3422a683-b186-43a9-943e-d17be7ab1737")
    public static List<List<Step>> thawStepListOfLists(List<List<FrozenStep>> frozen) {
        List<List<Step>> result = new ArrayList<>(frozen.size());
        for (List<FrozenStep> branch : frozen) {
            result.add(thawStepList(branch));
        }
        return result;
    }

}
