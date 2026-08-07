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
package org.modelio.platform.model.ui.panels.search.query.elements.filter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlPipelineEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlExprNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.summary.MqlSummaryRenderer;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep.FilerStepKind;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;

/**
 * Edit part for {@link org.modelio.platform.query.api.model.query.FilterStep}.
 */
@objid ("bda584fe-a45a-454f-8a37-6d39516db5dd")
public class MqlFilterStepEditPart extends MqlStepEditPart {
    @objid ("5fa82ebc-db7a-4155-83e0-1a940002b22c")
    @Override
    protected IFigure createFigure() {
        return new MqlFilterFigure();
    }

    @objid ("5c01dee5-805d-4a9a-80ec-327e3635e901")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new MqlPipelineEditPolicy());
    }

    @objid ("b4607e2d-ebe9-46d4-b46f-c066c78e6f47")
    @Override
    protected void refreshVisuals() {
        MqlStepNode node = (MqlStepNode) getMqlNode();
        MqlFilterFigure fig = (MqlFilterFigure) getFigure();

        MqlExprNode where = node.getWhere();
        String summary = MqlSummaryRenderer.renderExprSummary(where != null ? where.getAst() : null);

        if(where.getAst() != null) {
            if(where.getAst() instanceof IsExpr || where.getAst() instanceof ExistsExpr) {
                fig.setFilterKind(FilerStepKind.KIND);
            }else if(where.getAst() instanceof CompareExpr) {
                fig.setFilterKind(FilerStepKind.PROPERTY);
            }else if(where.getAst() instanceof AndExpr || where.getAst() instanceof OrExpr) {
                fig.setFilterKind(FilerStepKind.COMPOSITE);
              }
        }

        fig.setPredicateSummary(summary);
    }

}
