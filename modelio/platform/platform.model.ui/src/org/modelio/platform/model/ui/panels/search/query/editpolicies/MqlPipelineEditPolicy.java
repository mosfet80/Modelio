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
package org.modelio.platform.model.ui.panels.search.query.editpolicies;

import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.commands.MqlPipelineCommands;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlRequestConstants.StepType;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;

/**
 * Edit policy that maps high-level "non-technical" editing requests
 * (add/move/delete/branch management) to GEF commands.
 */
@objid ("162a280f-3a8d-45a0-b6f4-87e345e0e85f")
public class MqlPipelineEditPolicy extends AbstractEditPolicy {
    @objid ("e00c24c3-ea16-45b4-adc3-f2bc33ee1c15")
    @Override
    public Command getCommand(final Request request) {
        if (request == null) {
            return null;
        }

        Object hostModel = getHost().getModel();
        Object type = request.getType();

        if (MqlRequestConstants.REQ_ADD_STEP_END.equals(type) && hostModel instanceof MqlQueryModel query) {
            StepType stepType = stepType(request.getExtendedData());
            return stepType != null ? MqlPipelineCommands.addTopLevelStepAtEnd(query, stepType) : null;
        }

        if (MqlRequestConstants.REQ_ADD_STEP_AFTER.equals(type) && hostModel instanceof MqlStepNode node) {
            StepType stepType = stepType(request.getExtendedData());
            return stepType != null ? MqlPipelineCommands.addStepAfter(node, stepType) : null;
        }

        if (MqlRequestConstants.REQ_UNION_BRANCH_ADD_STEP_END.equals(type) && hostModel instanceof List<?>) {
            StepType stepType = stepType(request.getExtendedData());
            Integer branchIndex = branchIndex(request.getExtendedData());
            if (stepType == null || branchIndex == null) {
                return null;
            }

            EditPart parent = getHost().getParent();
            Object parentModel = parent != null ? parent.getModel() : null;
            if (parentModel instanceof MqlStepNode unionNode && unionNode.isUnion()) {
                return MqlPipelineCommands.addStepToUnionBranchEnd(unionNode, branchIndex.intValue(), stepType);
            }
        }

        if (MqlRequestConstants.REQ_REPEAT_BODY_ADD_STEP_END.equals(type) && hostModel instanceof MqlStepNode node) {
            StepType stepType = stepType(request.getExtendedData());
            return (stepType != null && node.isRepeat()) ? MqlPipelineCommands.addStepToRepeatBodyEnd(node, stepType) : null;
        }

        if (MqlRequestConstants.REQ_MOVE_LEFT.equals(type) && hostModel instanceof MqlStepNode node) {
            return MqlPipelineCommands.moveLeft(node);
        }

        if (MqlRequestConstants.REQ_MOVE_RIGHT.equals(type) && hostModel instanceof MqlStepNode node) {
            return MqlPipelineCommands.moveRight(node);
        }

        if (MqlRequestConstants.REQ_UNION_ADD_BRANCH.equals(type) && hostModel instanceof MqlStepNode node) {
            return node.isUnion() ? MqlPipelineCommands.addUnionBranch(node) : null;
        }

        if (MqlRequestConstants.REQ_UNION_REMOVE_BRANCH.equals(type)) {
            Integer branchIndex = branchIndex(request.getExtendedData());
            if (branchIndex == null) {
                return null;
            }

            if (hostModel instanceof MqlStepNode node) {
                return node.isUnion() ? MqlPipelineCommands.removeUnionBranch(node, branchIndex.intValue()) : null;
            }

            if (hostModel instanceof List<?>) {
                EditPart parent = getHost().getParent();
                Object parentModel = parent != null ? parent.getModel() : null;
                if (parentModel instanceof MqlStepNode unionNode && unionNode.isUnion()) {
                    return MqlPipelineCommands.removeUnionBranch(unionNode, branchIndex.intValue());
                }
            }
        }

        if (RequestConstants.REQ_DELETE.equals(type) && hostModel instanceof MqlStepNode node) {
            return MqlPipelineCommands.deleteStep(node);
        }

        return null;
    }

    @objid ("bc559a1b-e0cc-42ae-b0a9-f0f712df06c1")
    private static StepType stepType(final Map<?, ?> data) {
        if (data == null) {
            return null;
        }
        Object value = data.get(MqlRequestConstants.KEY_STEP_TYPE);
        if (value instanceof StepType t) {
            return t;
        }
        return null;
    }

    @objid ("9a7a0ea1-dd27-472a-8f98-d0ee21013dfa")
    private static Integer branchIndex(final Map<?, ?> data) {
        if (data == null) {
            return null;
        }
        Object value = data.get(MqlRequestConstants.KEY_BRANCH_INDEX);
        if (value instanceof Integer i) {
            return i;
        }
        return null;
    }

}
