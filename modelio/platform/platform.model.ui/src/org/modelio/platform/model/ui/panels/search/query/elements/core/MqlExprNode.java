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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.NotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.PropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueExpr;

/**
 * Editor model node for {@link Expr} trees.
 */
@objid ("467273f0-8cd9-4c33-896b-437df0eeb6c2")
public final class MqlExprNode extends AbstractMqlNode {
    @objid ("5f3f76e0-75d5-454e-b5f8-87a705db4983")
    public static final String PROP_CHANGED = "mql.expr.changed";

    @objid ("d82bad2a-8f83-4968-a5b1-1c199dfbc535")
    private final Expr expr;

    @objid ("98597c79-0402-4cf3-ae99-d40f371f808c")
    private final List<MqlExprNode> children = new ArrayList<>();

    @objid ("2f5752e0-7bb0-460e-b2dc-1f936a2c6932")
    private MqlExprNode unaryChild;

    @objid ("d403bf40-32ae-44b9-a602-101e466767df")
    private MqlValueExprNode compareLeft;

    @objid ("bcb16f44-fde1-47e3-ab08-af3a2e9c25bc")
    private MqlValueExprNode compareRight;

    @objid ("b0142888-85f2-49ae-bc35-a64d09210045")
    private final List<MqlStepNode> existsInSteps = new ArrayList<>();

    @objid ("b2a55f6d-62ad-4c0f-aae3-46e12da21a91")
    private MqlExprNode existsWhere;

    @objid ("4f2e4bdf-8b5e-4936-81e1-64438b733487")
    MqlExprNode(final AbstractMqlNode parent, final Expr expr) {
        super(parent);
        this.expr = Objects.requireNonNull(expr, "expr");
        rebuildChildrenFromAst();
    }

    @objid ("5408352b-821a-4ed5-a25a-205681556e3b")
    public Expr getAst() {
        return this.expr;
    }

    @objid ("46314475-8f3b-4f5d-b46b-bf28ffb84d0c")
    public List<MqlExprNode> getChildren() {
        if (this.expr instanceof AndExpr || this.expr instanceof OrExpr) {
            return Collections.unmodifiableList(this.children);
        }
        return List.of();
    }

    @objid ("0c5eb18b-4ca8-4d4f-981d-82cbe311ce82")
    public MqlExprNode getUnaryChild() {
        if (this.expr instanceof NotExpr) {
            return this.unaryChild;
        }
        return null;
    }

    @objid ("83fdb1ff-20d6-41e2-b8da-59fc4129955a")
    public MqlValueExprNode getCompareLeft() {
        if (this.expr instanceof CompareExpr) {
            return this.compareLeft;
        }
        return null;
    }

    @objid ("2097f962-e4ae-4481-b272-bfe764805d29")
    public MqlValueExprNode getCompareRight() {
        if (this.expr instanceof CompareExpr) {
            return this.compareRight;
        }
        return null;
    }

    @objid ("99e87aa1-4fa4-4db1-ade0-cca40bc17364")
    public String getIsKindRef() {
        if (this.expr instanceof IsExpr is) {
            // TODO: Update with correct API method when available
            return "";
        }
        return "";
    }

    @objid ("0e1d45cf-00e0-47df-8804-ccedea6bd11f")
    public List<MqlStepNode> getExistsInSteps() {
        if (this.expr instanceof ExistsExpr) {
            return Collections.unmodifiableList(this.existsInSteps);
        }
        return List.of();
    }

    @objid ("f2a6928a-2078-417c-b84c-7979ec826f30")
    public MqlExprNode getExistsWhere() {
        if (this.expr instanceof ExistsExpr) {
            return this.existsWhere;
        }
        return null;
    }

    @objid ("5be4cfe1-68c2-420c-9838-f2f5b982f0da")
    void rebuildChildrenFromAst() {
        this.children.clear();
        this.unaryChild = null;
        this.compareLeft = null;
        this.compareRight = null;
        this.existsInSteps.clear();
        this.existsWhere = null;

        if (this.expr instanceof AndExpr and) {
            for (Expr e : and.getExprs()) {
                this.children.add(new MqlExprNode(this, e));
            }
        } else if (this.expr instanceof OrExpr or) {
            for (Expr e : or.getExprs()) {
                this.children.add(new MqlExprNode(this, e));
            }
        } else if (this.expr instanceof NotExpr not) {
            this.unaryChild = new MqlExprNode(this, not.getExpr());
        } else if (this.expr instanceof CompareExpr compare) {
            this.compareLeft = new MqlValueExprNode(this, compare.getLeft());
            this.compareRight = new MqlValueExprNode(this, compare.getRight());
        } else if (this.expr instanceof ExistsExpr exists) {
            for (Step s : exists.getIn()) {
                this.existsInSteps.add(new MqlStepNode(this, s));
            }
            Expr where = exists.getWhere();
            this.existsWhere = where != null ? new MqlExprNode(this, where) : null;
        }
    }

    /**
     * Editor model node for {@link ValueExpr} leaves.
     */
    @objid ("13d2b0f0-f0f8-4b1f-bbc9-f0cc26c661d8")
    public static final class MqlValueExprNode extends AbstractMqlNode {
        @objid ("89defa3c-1bf1-442c-af1a-8a4de23bde46")
        private final ValueExpr valueExpr;

        @objid ("a8211c25-b29a-401a-b256-b315b107a33a")
        MqlValueExprNode(final AbstractMqlNode parent, final ValueExpr valueExpr) {
            super(parent);
            this.valueExpr = Objects.requireNonNull(valueExpr, "valueExpr");
        }

        @objid ("dddbbed8-88b6-40da-a1ae-7b8af9406d79")
        public ValueExpr getAst() {
            return this.valueExpr;
        }

        @objid ("3faa559d-56fa-4448-8783-84661ca1ca05")
        public boolean isProperty() {
            return this.valueExpr instanceof PropertyValueExpr;
        }

        @objid ("6957a2bc-7235-4ec0-b680-d4a2cd585399")
        public boolean isLiteral() {
            return this.valueExpr instanceof LiteralValueExpr;
        }

        @objid ("d0218ea7-ea5e-46ec-b7a8-248db566623d")
        public String getPropertyKey() {
            if (this.valueExpr instanceof PropertyValueExpr p) {
                // TODO: Update with correct API method when available
                return "";
            }
            return "";
        }

        @objid ("02598f41-9391-41c1-9689-144dd6def498")
        public Object getLiteralValue() {
            if (this.valueExpr instanceof LiteralValueExpr lit) {
                return lit.getValue();
            }
            return null;
        }

    }

}
