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
package org.modelio.platform.model.ui.panels.search.query.commands;

import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.commands.Command;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlExpressionTreeModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.query.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.UnionStep;

/**
 * Command helpers for manipulating the step pipeline.
 */
@objid ("db69a9a5-a8d8-46d4-a93e-febf0c22068c")
public final class MqlStepCommands {
    @objid ("206a2669-1d08-4cd8-837b-0ff48d96fb2e")
    private MqlStepCommands() {

    }

    @objid ("39c4dac9-371e-4f40-9adb-4e05ff096945")
    public static Step createDefaultFilterStep(final MqlQueryModel model, org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep.FilerStepKind kind) {
        switch (kind) {
        case PROPERTY:
            return new FilterStep( MqlExpressionTreeModel.createDefaultCompareExpr());
        case KIND:
            return new FilterStep( MqlExpressionTreeModel.createDefaultIsExpr(model));
        case COMPOSITE :
            return new FilterStep(MqlExpressionTreeModel.createDefaultAndExpr(model));
        default:
            return new FilterStep(new IsExpr(defaultKindRef(model)));
        }
    }

    @objid ("af9ae38d-de81-4dcd-8c7e-6301cd0e5146")
    public static Step createDefaultTraverseStep(final MqlQueryModel model) {
        return new TraverseStep("");
    }

    @objid ("df374277-9cc2-4b48-9b15-453024d2ecde")
    public static Step createDefaultUnionStep(final MqlQueryModel model) {
        // Start with 2 empty branches so the user can fill them.
        return new UnionStep(List.of(List.of(), List.of()));
    }

    @objid ("f330939f-1d5f-4172-83cb-3fada9d6fe06")
    public static Step createDefaultRepeatStep(final MqlQueryModel model) {
        return new RepeatStep(List.of());
    }

    @objid ("a4df73c1-2eb4-4125-8919-b1df22eae382")
    private static String defaultKindRef(final MqlQueryModel model) {
        if (model == null || model.getSourceNode() == null) {
            return "Infrastructure.ModelElement";
        }
        Source src = model.getSourceNode().getAst();
        if (src != null) {
            String s = model.getSourceNode().getAllKindRef();
            if (s != null && !s.isBlank()) {
                return s;
            }
        }
        return "Infrastructure.ModelElement";
    }

    @objid ("ab61ca6d-4e2c-4b71-9d0d-dc65c922e24b")
    public static final class InsertTopLevelStepCommand extends Command {
        @objid ("dac34e03-1b15-4784-ac0c-21a8dfc461ff")
        private final int index;

        @objid ("fb1ffbd8-fa69-49ef-8d15-a0b80727653e")
        private final MqlQueryModel model;

        @objid ("6525f71d-0f31-4a0b-9824-578008318f07")
        private final Step step;

        @objid ("137a9629-98c7-4845-8d68-b82ff3f075f4")
        public InsertTopLevelStepCommand(final MqlQueryModel model, final int index, final Step step) {
            this.model = Objects.requireNonNull(model, "model");
            this.index = index;
            this.step = Objects.requireNonNull(step, "step");
        }

        @objid ("64b39978-1b4b-40de-992c-93addd62199c")
        @Override
        public void execute() {
            this.model.insertStep(this.index, this.step);
        }

        @objid ("e2f170c0-e82e-4039-b243-3cf10f98dea0")
        @Override
        public void undo() {
            this.model.removeStep(this.index);
        }

    }

    @objid ("7eb16a89-04e5-49f1-87b6-02c331cc0cec")
    public static final class RemoveTopLevelStepCommand extends Command {
        @objid ("a14e3069-eaeb-4be5-b3b3-823b11033246")
        private final int index;

        @objid ("e53442c0-0152-4e0d-9104-7ae84452d737")
        private final MqlQueryModel model;

        @objid ("f219d67e-2c5a-41a4-84a9-579e6edf22ed")
        private Step removed;

        @objid ("78411351-4022-4450-abe0-aed5a99f4066")
        public RemoveTopLevelStepCommand(final MqlQueryModel model, final int index) {
            this.model = Objects.requireNonNull(model, "model");
            this.index = index;
        }

        @objid ("b6d60589-71ee-47a2-abaf-237c697348da")
        @Override
        public void execute() {
            this.removed = this.model.getQueryAst().getSteps().get(this.index);
            this.model.removeStep(this.index);
        }

        @objid ("3bf3617b-e879-43e1-ae0a-adf194b7b465")
        @Override
        public void undo() {
            if (this.removed != null) {
                this.model.insertStep(this.index, this.removed);
            }
        }

    }

    @objid ("7449e6ea-a27d-4357-a465-0c02dfee72d6")
    public static final class MoveTopLevelStepCommand extends Command {
        @objid ("b85aed4d-0429-4073-bbef-bcacf117a156")
        private final int fromIndex;

        @objid ("31fb39a9-036d-4dbf-a871-5b8c04bf0a76")
        private final int toIndex;

        @objid ("d6c3bbee-06c2-4245-9a93-71a3a4f547ee")
        private final MqlQueryModel model;

        @objid ("eb948c0e-135d-4aa4-b72e-85f7f58f30d5")
        public MoveTopLevelStepCommand(final MqlQueryModel model, final int fromIndex, final int toIndex) {
            this.model = Objects.requireNonNull(model, "model");
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @objid ("506e979f-0ffa-4cd5-960a-97257246188a")
        @Override
        public void execute() {
            this.model.moveStep(this.fromIndex, this.toIndex);
        }

        @objid ("1887899e-50b8-4c7e-a5bc-fc60a32a25ee")
        @Override
        public void undo() {
            this.model.moveStep(this.toIndex, this.fromIndex);
        }

    }

}
