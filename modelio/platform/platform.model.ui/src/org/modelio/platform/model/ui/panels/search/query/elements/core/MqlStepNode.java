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
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.query.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.UnionStep;

/**
 * Editor model node for a {@link Step}.
 */
@objid ("be3ee76b-d1ee-47dc-85b6-63f243a2cf57")
public class MqlStepNode extends AbstractMqlNode {
    @objid ("09b6a8e9-9613-4549-95e0-bb3136d86851")
    public static final String PROP_CHANGED = "mql.step.changed";

    @objid ("e7fa71b3-7b37-4a2c-892f-b51fe3b6bfac")
    private final Step step;

    @objid ("3c21e6b7-396f-4baa-a192-9003fe3a2a24")
    private MqlExprNode where;

    @objid ("b3701aaa-476e-4b49-9e86-f6e0245845a7")
    private MqlExprNode edgeFilter;

    @objid ("f322a905-2e0e-4242-8652-b815d84d51ea")
    private final List<List<MqlStepNode>> unionBranches = new ArrayList<>();

    @objid ("3ac5c98a-bd76-4f1a-b3a7-78ab9d5b3aa0")
    private final List<MqlStepNode> repeatBody = new ArrayList<>();

    @objid ("09088fce-f891-4eda-a432-4062fcc9794a")
    MqlStepNode(final AbstractMqlNode parent, final Step step) {
        super(parent);
        this.step = Objects.requireNonNull(step, "step");
        rebuildChildrenFromAst();
    }

    @objid ("7fe01bc3-fabc-4990-8692-05eacb148d81")
    public Step getAst() {
        return this.step;
    }

    @objid ("06f84ade-29f9-431e-8e5a-3b57245c8e5c")
    public MqlQueryModel getRoot() {
        return getRootModel();
    }

    @objid ("d7b6c99f-7259-449e-8ac3-56fc8a99f384")
    public Location locate() {
        AbstractMqlNode parent = getParent();
        if (parent instanceof MqlQueryModel root) {
            int index = root.getStepNodes().indexOf(this);
            if (index < 0) {
                throw new IllegalStateException("Step not found in root model");
            }
            return new Location(root, Container.TOP_LEVEL, null, -1, index);
        }

        if (parent instanceof MqlStepNode parentStep) {
            MqlQueryModel root = getRootModel();
            if (root == null) {
                throw new IllegalStateException("Root model not found");
            }

            if (parentStep.isUnion()) {
                for (int b = 0; b < parentStep.unionBranches.size(); b++) {
                    List<MqlStepNode> branch = parentStep.unionBranches.get(b);
                    int index = branch.indexOf(this);
                    if (index >= 0) {
                        return new Location(root, Container.UNION_BRANCH, parentStep, b, index);
                    }
                }
                throw new IllegalStateException("Step not found in union branches");
            }

            if (parentStep.isRepeat()) {
                int index = parentStep.repeatBody.indexOf(this);
                if (index < 0) {
                    throw new IllegalStateException("Step not found in repeat body");
                }
                return new Location(root, Container.REPEAT_BODY, parentStep, -1, index);
            }

            throw new IllegalStateException("Unsupported parent step container: " + parentStep.getAst().getClass().getSimpleName());
        }

        throw new IllegalStateException("Step has no supported parent container");
    }

    @objid ("fe82b179-c3a3-47df-9b30-d7334479a5fd")
    public boolean isFilter() {
        return this.step instanceof FilterStep;
    }

    @objid ("4a15176a-5e87-4828-be9b-d88ceb2fdf68")
    public boolean isTraverse() {
        return this.step instanceof TraverseStep;
    }

    @objid ("6a627973-f0de-4b23-b73d-49ab930ac606")
    public boolean isUnion() {
        return this.step instanceof UnionStep;
    }

    @objid ("e30f3fa9-a4fe-4a98-8b4d-b3e7c977e205")
    public boolean isRepeat() {
        return this.step instanceof RepeatStep;
    }

    @objid ("2c1901c4-8051-4fc9-9948-176713e83a91")
    public MqlExprNode getWhere() {
        return this.where;
    }

    @objid ("c7c8940d-dedf-4ea7-867c-c5ada19169f9")
    public void setWhere(final Expr expr) {
        Objects.requireNonNull(expr, "expr");
        if (!(this.step instanceof FilterStep filter)) {
            throw new IllegalStateException("Not a FilterStep");
        }
        Expr old = filter.getWhere();
        filter.setWhere(expr);
        this.where = new MqlExprNode(this, expr);
        firePropertyChange(PROP_CHANGED, old, expr);
        fireChanged();
    }

    @objid ("2e27c285-25f4-47b9-a5bd-7b98b23cb393")
    public String getTraverseEdge() {
        if (this.step instanceof TraverseStep traverse) {
            return traverse.getEdge();
        }
        return "";
    }

    @objid ("ced2401d-e872-41ee-a6a3-0213a7c395b5")
    public void setTraverseEdge(final String edgeRef) {
        if (!(this.step instanceof TraverseStep traverse)) {
            throw new IllegalStateException("Not a TraverseStep");
        }
        String old = traverse.getEdge();
        traverse.setEdge(edgeRef);
        firePropertyChange(PROP_CHANGED, old, edgeRef);
        fireChanged();
    }

    @objid ("79fbf9a6-f958-427e-9471-f36c6a7b00e9")
    public Direction getTraverseDirection() {
        if (this.step instanceof TraverseStep traverse) {
            Direction dir = traverse.getDirection();
            return dir != null ? dir : Direction.FORWARD;
        }
        return Direction.FORWARD;
    }

    @objid ("8426be55-8dd2-4c53-ba6c-2d16070d428d")
    public void setTraverseDirection(final Direction direction) {
        Objects.requireNonNull(direction, "direction");
        if (!(this.step instanceof TraverseStep traverse)) {
            throw new IllegalStateException("Not a TraverseStep");
        }
        Direction old = traverse.getDirection();
        traverse.setDirection(direction);
        firePropertyChange(PROP_CHANGED, old, direction);
        fireChanged();
    }

    @objid ("38d47eac-1df8-40e5-a5df-235c34f083de")
    public MqlExprNode getEdgeFilter() {
        return this.edgeFilter;
    }

    @objid ("869a3b95-713a-4566-9ece-a6026c46bd67")
    public void setEdgeFilter(final Expr expr) {
        if (!(this.step instanceof TraverseStep traverse)) {
            throw new IllegalStateException("Not a TraverseStep");
        }
        Expr old = traverse.getEdgeFilter();
        traverse.setEdgeFilter(expr);
        this.edgeFilter = expr != null ? new MqlExprNode(this, expr) : null;
        firePropertyChange(PROP_CHANGED, old, expr);
        fireChanged();
    }

    @objid ("b0e6b8e1-0fe6-4799-892b-fa979790a195")
    public void notifyChanged() {
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
    }

    @objid ("b63a65af-c848-4764-87bb-5054ecca6dae")
    public List<List<MqlStepNode>> getUnionBranches() {
        if (!(this.step instanceof UnionStep)) {
            return List.of();
        }
        return Collections.unmodifiableList(this.unionBranches);
    }

    @objid ("c1df8db6-5a3d-4e3b-95a8-5c08f18a7aa2")
    public void addUnionBranch() {
        if (!(this.step instanceof UnionStep union)) {
            throw new IllegalStateException("Not a UnionStep");
        }
        union.addBranch(List.of());
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
    }

    @objid ("3c6bd7cb-00f4-4ddc-a68e-34433458a048")
    public List<Step> removeUnionBranch(final int index) {
        if (!(this.step instanceof UnionStep union)) {
            throw new IllegalStateException("Not a UnionStep");
        }
        List<Step> removed = new ArrayList<>(union.getBranches().get(index));
        union.removeBranch(index);
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
        return removed;
    }

    @objid ("4476be5f-b002-454c-bce8-c14f8be2cac4")
    public void insertUnionBranch(final int index, final List<Step> branch) {
        Objects.requireNonNull(branch, "branch");
        if (!(this.step instanceof UnionStep union)) {
            throw new IllegalStateException("Not a UnionStep");
        }
        union.getBranches().add(index, new ArrayList<>(branch));
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
    }

    @objid ("87e30fcf-1304-48f2-bdfb-752ff8c52f28")
    public void insertUnionBranchStep(final int branchIndex, final int index, final Step step) {
        Objects.requireNonNull(step, "step");
        if (!(this.step instanceof UnionStep union)) {
            throw new IllegalStateException("Not a UnionStep");
        }
        union.getBranches().get(branchIndex).add(index, step);
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
    }

    @objid ("d4053a74-79a3-4cb0-a7cf-a129de8e3540")
    public Step removeUnionBranchStep(final int branchIndex, final int index) {
        if (!(this.step instanceof UnionStep union)) {
            throw new IllegalStateException("Not a UnionStep");
        }
        Step removed = union.getBranches().get(branchIndex).remove(index);
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
        return removed;
    }

    @objid ("38208af6-9a26-45e2-ab0d-5967778c820e")
    public void moveUnionBranchStep(final int branchIndex, final int fromIndex, final int toIndex) {
        if (!(this.step instanceof UnionStep union)) {
            throw new IllegalStateException("Not a UnionStep");
        }
        if (fromIndex == toIndex) {
            return;
        }
        List<Step> branch = union.getBranches().get(branchIndex);
        Step step = branch.remove(fromIndex);
        branch.add(toIndex, step);
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, fromIndex, toIndex);
        fireChanged();
    }

    @objid ("4f4daf67-aeca-4827-b206-21a7dc58fec7")
    public List<MqlStepNode> getRepeatBody() {
        if (!(this.step instanceof RepeatStep)) {
            return List.of();
        }
        return Collections.unmodifiableList(this.repeatBody);
    }

    @objid ("c6786ace-5ed5-44f2-9680-d7ca56d85fea")
    public void insertRepeatBodyStep(final int index, final Step step) {
        Objects.requireNonNull(step, "step");
        if (!(this.step instanceof RepeatStep repeat)) {
            throw new IllegalStateException("Not a RepeatStep");
        }
        repeat.getBody().add(index, step);
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
    }

    @objid ("e83ad359-c63b-4db1-b254-cfc419e694d2")
    public Step removeRepeatBodyStep(final int index) {
        if (!(this.step instanceof RepeatStep repeat)) {
            throw new IllegalStateException("Not a RepeatStep");
        }
        Step removed = repeat.getBody().remove(index);
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, null, null);
        fireChanged();
        return removed;
    }

    @objid ("2a788c54-5e35-4656-8a00-3dfdbe2879db")
    public void moveRepeatBodyStep(final int fromIndex, final int toIndex) {
        if (!(this.step instanceof RepeatStep repeat)) {
            throw new IllegalStateException("Not a RepeatStep");
        }
        if (fromIndex == toIndex) {
            return;
        }
        List<Step> body = repeat.getBody();
        Step step = body.remove(fromIndex);
        body.add(toIndex, step);
        rebuildChildrenFromAst();
        firePropertyChange(PROP_CHANGED, fromIndex, toIndex);
        fireChanged();
    }

    @objid ("c5db5d16-8d00-4547-9fd3-ef1b247b8546")
    public Integer getGlobalMaxDepth() {
        MqlQueryModel root = getRootModel();
        if (root == null || root.getLimits() == null) {
            return null;
        }
        return root.getLimits().getMaxDepth();
    }

    @objid ("9a135cfb-30aa-4be0-9508-7364d8c60162")
    void rebuildChildrenFromAst() {
        this.where = null;
        this.edgeFilter = null;

        if (this.step instanceof FilterStep filter) {
            this.unionBranches.clear();
            this.repeatBody.clear();
            this.where = new MqlExprNode(this, filter.getWhere());
        } else if (this.step instanceof TraverseStep traverse) {
            this.unionBranches.clear();
            this.repeatBody.clear();
            Expr filter = traverse.getEdgeFilter();
            this.edgeFilter = filter != null ? new MqlExprNode(this, filter) : null;
        } else if (this.step instanceof UnionStep union) {
            this.repeatBody.clear();
            // Preserve existing list identities so GEF can match model objects
            List<List<Step>> astBranches = union.getBranches();
            while (this.unionBranches.size() > astBranches.size()) {
                this.unionBranches.remove(this.unionBranches.size() - 1);
            }
            while (this.unionBranches.size() < astBranches.size()) {
                this.unionBranches.add(new IdentityList<>());
            }
            for (int i = 0; i < astBranches.size(); i++) {
                List<MqlStepNode> branchNodes = this.unionBranches.get(i);
                branchNodes.clear();
                for (Step s : astBranches.get(i)) {
                    branchNodes.add(new MqlStepNode(this, s));
                }
            }
        } else if (this.step instanceof RepeatStep repeat) {
            this.unionBranches.clear();
            this.repeatBody.clear();
            for (Step s : repeat.getBody()) {
                this.repeatBody.add(new MqlStepNode(this, s));
            }
        } else {
            this.unionBranches.clear();
            this.repeatBody.clear();
        }
    }

    @objid ("a182889d-a737-4a95-80dc-140205382a15")
    public enum Container {
        @objid ("aa266216-d460-4e35-ac5c-f1d952607e72")
        TOP_LEVEL,
        @objid ("51351ab6-3abe-4d36-aaf5-4a9727dc35af")
        UNION_BRANCH,
        @objid ("9828e1d1-90a8-4f53-a42e-d6953b6860a1")
        REPEAT_BODY;

    }

    /**
     * Stable location of this node in its parent container.
     */
    @objid ("53c02193-d358-451b-9382-b3c7f51253d7")
    public record Location ( Container container,
            int branchIndex,
            int index,
MqlQueryModel root,
MqlStepNode parentStep )  {
        @objid ("2fd3dd81-7825-46d8-bff6-5a839b0dc9a6")
        public Location {
            Objects.requireNonNull(root, "root");
            Objects.requireNonNull(container, "container");
        }

        /**
         * Legacy constructor for backward compatibility. Use the canonical constructor instead.
         */
        @objid ("5e9b055f-d5ec-40be-ae2a-aa8f618f7710")
        @Deprecated
        public Location(MqlQueryModel root2, Container container, MqlStepNode parentStep, int branchIndex, int index) {
            this(container, branchIndex, index, root2, parentStep);
        }

    }

    /**
     * ArrayList subclass that uses identity-based {@code equals}/{@code hashCode}
     * instead of content-based. This is required because GEF uses a HashMap keyed
     * on model objects, and two branch lists with identical content must not be
     * considered equal.
     */
    @objid ("fef3bd3e-b9ca-4d59-a827-c86b51b22592")
    static final class IdentityList<E> extends ArrayList<E> {
        @objid ("e5328653-07b2-41e6-948a-5a5dc19a126a")
        private static final long serialVersionUID = 1L;

        @objid ("27d7d0cf-20e6-44e5-b569-5d081b1b0fa7")
        @Override
        public boolean equals(final Object o) {
            return this == o;
        }

        @objid ("ccc3b73a-4f8b-45c4-8fbc-960291928086")
        @Override
        public int hashCode() {
            return System.identityHashCode(this);
        }

    }

}
