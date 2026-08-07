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
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlRequestConstants.StepType;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode.Location;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;

/**
 * Commands for adding/removing/reordering steps and managing union/repeat containers.
 */
@objid ("7168e55c-5758-4967-b440-4c8ee3761abe")
public final class MqlPipelineCommands {
    @objid ("ff3ca912-4721-494b-a2cd-af76ac70b513")
    private MqlPipelineCommands() {

    }

    @objid ("0d39cbb2-44e6-49a3-af67-942437bea09a")
    public static Step createDefaultStep(final MqlQueryModel model, final StepType type) {
        Objects.requireNonNull(type, "type");
        return switch (type) {
        case FILTER -> MqlStepCommands.createDefaultFilterStep(model,null);
        case TRAVERSE -> MqlStepCommands.createDefaultTraverseStep(model);
        case UNION -> MqlStepCommands.createDefaultUnionStep(model);
        case REPEAT -> MqlStepCommands.createDefaultRepeatStep(model);
        };
    }

    @objid ("dc819d33-0bed-46c7-be48-f844e374cf79")
    public static Command addTopLevelStepAtEnd(final MqlQueryModel model, final StepType type) {
        Objects.requireNonNull(model, "model");
        Step step = createDefaultStep(model, type);
        return new MqlStepCommands.InsertTopLevelStepCommand(model, model.getStepNodes().size(), step);
    }

    @objid ("fca3034f-1e3b-49af-b4e5-dfd31eb84d4f")
    public static Command addStepAfter(final MqlStepNode reference, final StepType type) {
        Objects.requireNonNull(reference, "reference");
        Objects.requireNonNull(type, "type");

        MqlQueryModel root = reference.getRoot();
        Step step = createDefaultStep(root, type);
        Location loc = reference.locate();

        return switch (loc.container()) {
        case TOP_LEVEL -> new MqlStepCommands.InsertTopLevelStepCommand(root, loc.index() + 1, step);
        case UNION_BRANCH -> new InsertUnionBranchStepCommand(loc.parentStep(), loc.branchIndex(), loc.index() + 1, step);
        case REPEAT_BODY -> new InsertRepeatBodyStepCommand(loc.parentStep(), loc.index() + 1, step);
        };
    }

    @objid ("1c7cdc4c-6212-4fa9-9d1e-e8183427ba82")
    public static Command deleteStep(final MqlStepNode target) {
        Objects.requireNonNull(target, "target");
        Location loc = target.locate();
        return switch (loc.container()) {
        case TOP_LEVEL -> new MqlStepCommands.RemoveTopLevelStepCommand(loc.root(), loc.index());
        case UNION_BRANCH -> new RemoveUnionBranchStepCommand(loc.parentStep(), loc.branchIndex(), loc.index());
        case REPEAT_BODY -> new RemoveRepeatBodyStepCommand(loc.parentStep(), loc.index());
        };
    }

    @objid ("56ed4113-d956-4c07-81ce-8581d01c0a9a")
    public static Command moveLeft(final MqlStepNode target) {
        Objects.requireNonNull(target, "target");
        Location loc = target.locate();
        if (loc.index() <= 0) {
            return null;
        }
        return switch (loc.container()) {
        case TOP_LEVEL -> new MqlStepCommands.MoveTopLevelStepCommand(loc.root(), loc.index(), loc.index() - 1);
        case UNION_BRANCH -> new MoveUnionBranchStepCommand(loc.parentStep(), loc.branchIndex(), loc.index(), loc.index() - 1);
        case REPEAT_BODY -> new MoveRepeatBodyStepCommand(loc.parentStep(), loc.index(), loc.index() - 1);
        };
    }

    @objid ("af78b511-094d-4df6-a1a4-824851d88c25")
    public static Command moveRight(final MqlStepNode target) {
        Objects.requireNonNull(target, "target");
        Location loc = target.locate();

        int maxIndex = switch (loc.container()) {
        case TOP_LEVEL -> loc.root().getStepNodes().size() - 1;
        case UNION_BRANCH -> loc.parentStep().getUnionBranches().get(loc.branchIndex()).size() - 1;
        case REPEAT_BODY -> loc.parentStep().getRepeatBody().size() - 1;
        };

        if (loc.index() >= maxIndex) {
            return null;
        }

        return switch (loc.container()) {
        case TOP_LEVEL -> new MqlStepCommands.MoveTopLevelStepCommand(loc.root(), loc.index(), loc.index() + 1);
        case UNION_BRANCH -> new MoveUnionBranchStepCommand(loc.parentStep(), loc.branchIndex(), loc.index(), loc.index() + 1);
        case REPEAT_BODY -> new MoveRepeatBodyStepCommand(loc.parentStep(), loc.index(), loc.index() + 1);
        };
    }

    @objid ("40d8146a-8b33-4c3f-a576-e1c140324abd")
    public static Command addUnionBranch(final MqlStepNode unionStep) {
        Objects.requireNonNull(unionStep, "unionStep");
        return new AddUnionBranchCommand(unionStep);
    }

    @objid ("42430010-dcc9-4c9f-920e-7ef66a6e56cf")
    public static Command removeUnionBranch(final MqlStepNode unionStep, final int branchIndex) {
        Objects.requireNonNull(unionStep, "unionStep");
        if (unionStep.getUnionBranches().size() <= 1) {
            return null;
        }
        return new RemoveUnionBranchCommand(unionStep, branchIndex);
    }

    @objid ("ac9f4974-c003-4c70-9a41-d320c8e1d3ca")
    public static Command addStepToUnionBranchEnd(final MqlStepNode unionStep, final int branchIndex, final StepType type) {
        Objects.requireNonNull(unionStep, "unionStep");
        Objects.requireNonNull(type, "type");

        MqlQueryModel root = unionStep.getRoot();
        Step step = createDefaultStep(root, type);
        int index = unionStep.getUnionBranches().get(branchIndex).size();
        return new InsertUnionBranchStepCommand(unionStep, branchIndex, index, step);
    }

    @objid ("00b78648-d2da-4a8d-9cb7-434d41881dea")
    public static Command addStepToRepeatBodyEnd(final MqlStepNode repeatStep, final StepType type) {
        Objects.requireNonNull(repeatStep, "repeatStep");
        Objects.requireNonNull(type, "type");

        MqlQueryModel root = repeatStep.getRoot();
        Step step = createDefaultStep(root, type);
        int index = repeatStep.getRepeatBody().size();
        return new InsertRepeatBodyStepCommand(repeatStep, index, step);
    }

    @objid ("dc46ab50-f180-4fda-a7af-3009e232037e")
    public static final class AddUnionBranchCommand extends Command {
        @objid ("f5c4c50b-15f8-40ce-8b9b-4eb19b826ba0")
        private final MqlStepNode unionNode;

        @objid ("cd9ef34d-dfbc-4df0-88a7-3925b022dab8")
        public AddUnionBranchCommand(final MqlStepNode unionNode) {
            this.unionNode = Objects.requireNonNull(unionNode, "unionNode");
        }

        @objid ("412166e3-273f-40bb-a8be-312ab7812a65")
        @Override
        public void execute() {
            this.unionNode.addUnionBranch();
        }

        @objid ("ed64f1aa-e46e-4a2e-80d8-dc61ff1262e7")
        @Override
        public void undo() {
            this.unionNode.removeUnionBranch(this.unionNode.getUnionBranches().size() - 1);
        }

    }

    @objid ("105f1594-80f4-4663-a5a5-746315aef6df")
    public static final class RemoveUnionBranchCommand extends Command {
        @objid ("cfcfa79e-fca7-4543-b561-be4ad6b24ec9")
        private final int index;

        @objid ("a88216ce-5cd3-413b-bb45-e75044a380aa")
        private final MqlStepNode unionNode;

        @objid ("620dc3a2-d382-45ac-b038-ba7a2907a08d")
        private List<org.modelio.platform.search.engine.searchers.query.api.model.query.Step> removed;

        @objid ("f35f34ca-a780-4fe3-99eb-ace343df412a")
        public RemoveUnionBranchCommand(final MqlStepNode unionNode, final int index) {
            this.unionNode = Objects.requireNonNull(unionNode, "unionNode");
            this.index = index;
        }

        @objid ("649f13d0-fe44-4754-8769-5470bdafbf9c")
        @Override
        public void execute() {
            this.removed = this.unionNode.removeUnionBranch(this.index);
        }

        @objid ("b6af5ad8-87cc-4540-8d0f-b02226c68e35")
        @Override
        public void undo() {
            if (this.removed != null) {
                this.unionNode.insertUnionBranch(this.index, this.removed);
            }
        }

    }

    @objid ("65dd8cbb-1218-47fc-97ea-5fbefa80f076")
    public static final class InsertUnionBranchStepCommand extends Command {
        @objid ("a33e1d13-edd2-4551-a4ae-ccef0e548b76")
        private final int branchIndex;

        @objid ("fe0c7716-82fa-407c-8a93-99491b856e71")
        private final int index;

        @objid ("8029a2e3-0e77-49c2-aec9-6db26dbf7f43")
        private final MqlStepNode unionNode;

        @objid ("651890da-c036-4f40-a4be-e5d578ceadc9")
        private final Step step;

        @objid ("e8ab0832-96f1-45fe-9643-6a0223e02cd4")
        public InsertUnionBranchStepCommand(final MqlStepNode unionNode, final int branchIndex, final int index, final Step step) {
            this.unionNode = Objects.requireNonNull(unionNode, "unionNode");
            this.branchIndex = branchIndex;
            this.index = index;
            this.step = Objects.requireNonNull(step, "step");
        }

        @objid ("df70f820-f4b5-45c3-838d-70e701a09814")
        @Override
        public void execute() {
            this.unionNode.insertUnionBranchStep(this.branchIndex, this.index, this.step);
        }

        @objid ("20b5bb40-1d59-40d7-a831-94f423ac0cb3")
        @Override
        public void undo() {
            this.unionNode.removeUnionBranchStep(this.branchIndex, this.index);
        }

    }

    @objid ("05f25089-3134-4920-855d-c571c0fd5139")
    public static final class RemoveUnionBranchStepCommand extends Command {
        @objid ("e03edb8c-f4f2-436d-bc98-6f78f0ce15d7")
        private final int branchIndex;

        @objid ("82a431eb-989a-4508-b246-54457a3384b9")
        private final int index;

        @objid ("8f15edd8-8864-4507-a4b3-b4b4227b1600")
        private final MqlStepNode unionNode;

        @objid ("f6532301-e86b-4af2-99c1-d1689fddf143")
        private Step removed;

        @objid ("11f7b852-d920-499e-bcfe-9faa7e7279f1")
        public RemoveUnionBranchStepCommand(final MqlStepNode unionNode, final int branchIndex, final int index) {
            this.unionNode = Objects.requireNonNull(unionNode, "unionNode");
            this.branchIndex = branchIndex;
            this.index = index;
        }

        @objid ("b7d7a939-32f4-42a6-ab00-4297be4d0094")
        @Override
        public void execute() {
            this.removed = this.unionNode.removeUnionBranchStep(this.branchIndex, this.index);
        }

        @objid ("276191ea-2616-43ca-935d-b1ee4b82ac14")
        @Override
        public void undo() {
            if (this.removed != null) {
                this.unionNode.insertUnionBranchStep(this.branchIndex, this.index, this.removed);
            }
        }

    }

    @objid ("9554abb5-b316-4393-bfbe-22929e250deb")
    public static final class MoveUnionBranchStepCommand extends Command {
        @objid ("d4288497-1f6a-4080-939e-d98323b16b8b")
        private final int branchIndex;

        @objid ("28be3da2-d963-4abe-bc8e-b88621dcf9e0")
        private final int fromIndex;

        @objid ("a57edc4b-3eb6-412d-9c95-beec6cd7b545")
        private final int toIndex;

        @objid ("02c7cac1-b9a5-4c0f-bff5-899a6cdde1e5")
        private final MqlStepNode unionNode;

        @objid ("fd9caee7-6d60-4785-883b-635707669705")
        public MoveUnionBranchStepCommand(final MqlStepNode unionNode, final int branchIndex, final int fromIndex, final int toIndex) {
            this.unionNode = Objects.requireNonNull(unionNode, "unionNode");
            this.branchIndex = branchIndex;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @objid ("13023dc3-4ae7-4759-bf83-6fb544bfa158")
        @Override
        public void execute() {
            this.unionNode.moveUnionBranchStep(this.branchIndex, this.fromIndex, this.toIndex);
        }

        @objid ("49884d50-97c3-4a81-855b-e20f8e1baa90")
        @Override
        public void undo() {
            this.unionNode.moveUnionBranchStep(this.branchIndex, this.toIndex, this.fromIndex);
        }

    }

    @objid ("6adbe642-4b7f-4f9a-9ce2-6301a5e61bc0")
    public static final class InsertRepeatBodyStepCommand extends Command {
        @objid ("afa8ae17-5ac5-4e8c-8561-826a7078c4e7")
        private final int index;

        @objid ("ce141772-422b-4a9b-9389-4da01a16c7a8")
        private final MqlStepNode repeatNode;

        @objid ("fc26a853-b88d-4a10-8f27-6e0a22dc3548")
        private final Step step;

        @objid ("d45f7339-c590-474f-8ade-94cb839a1ec9")
        public InsertRepeatBodyStepCommand(final MqlStepNode repeatNode, final int index, final Step step) {
            this.repeatNode = Objects.requireNonNull(repeatNode, "repeatNode");
            this.index = index;
            this.step = Objects.requireNonNull(step, "step");
        }

        @objid ("75f3e0dc-6d02-4d7b-9cf8-87f2774f851a")
        @Override
        public void execute() {
            this.repeatNode.insertRepeatBodyStep(this.index, this.step);
        }

        @objid ("6ed815af-5f9d-4886-8fe4-5091ffee6701")
        @Override
        public void undo() {
            this.repeatNode.removeRepeatBodyStep(this.index);
        }

    }

    @objid ("cb7c238a-46a1-4c27-804d-9545e84ad2c7")
    public static final class RemoveRepeatBodyStepCommand extends Command {
        @objid ("d825c7ad-9d83-4815-bd3a-e22adab7640b")
        private final int index;

        @objid ("abf67370-88d2-44fb-bed0-c06a60e8d34b")
        private final MqlStepNode repeatNode;

        @objid ("8cd18e71-c14f-43d5-869b-6c93fbef80f2")
        private Step removed;

        @objid ("6799c252-ed67-47a4-8913-93a0087b770e")
        public RemoveRepeatBodyStepCommand(final MqlStepNode repeatNode, final int index) {
            this.repeatNode = Objects.requireNonNull(repeatNode, "repeatNode");
            this.index = index;
        }

        @objid ("97e34e0a-88d8-4c75-aa38-bfdf91e80cc5")
        @Override
        public void execute() {
            this.removed = this.repeatNode.removeRepeatBodyStep(this.index);
        }

        @objid ("1e2be914-27e3-4722-aa04-e38684c51e44")
        @Override
        public void undo() {
            if (this.removed != null) {
                this.repeatNode.insertRepeatBodyStep(this.index, this.removed);
            }
        }

    }

    @objid ("8f88babe-4da6-4aa9-83b9-649a7ae8bcc6")
    public static final class MoveRepeatBodyStepCommand extends Command {
        @objid ("66d1dfba-2352-4703-ac76-7982547c71b0")
        private final int fromIndex;

        @objid ("310f4180-8782-4e2b-8b16-7849d4dad55a")
        private final int toIndex;

        @objid ("ed6f6db8-7571-464d-992c-217e8fd6db93")
        private final MqlStepNode repeatNode;

        @objid ("856f7561-cf6b-4c84-a277-b7f14c15e50d")
        public MoveRepeatBodyStepCommand(final MqlStepNode repeatNode, final int fromIndex, final int toIndex) {
            this.repeatNode = Objects.requireNonNull(repeatNode, "repeatNode");
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @objid ("02bc8464-e22c-4ade-9a26-732ea529c368")
        @Override
        public void execute() {
            this.repeatNode.moveRepeatBodyStep(this.fromIndex, this.toIndex);
        }

        @objid ("b3bc1264-cccf-4885-8288-1d7fa21769da")
        @Override
        public void undo() {
            this.repeatNode.moveRepeatBodyStep(this.toIndex, this.fromIndex);
        }

    }

}
