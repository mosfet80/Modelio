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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenStep;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenUnionStep;

/**
 * Union step: represents alternatives (A | B | ...).
 * <p>
 * The output stream is the concatenation of each branch result,
 * then subject to downstream steps.
 * <p>
 * Union semantics:
 * <ul>
 * <li>Union ALWAYS implies automatic deduplication by itself</li>
 * <li>If multiple branches reach the same node at the same depth,
 * the kept provenance is the first discovered one in stream order</li>
 * <li>Useful inside Repeat for exploring multiple traversal paths</li>
 * </ul>
 */
@objid ("9b45dc97-227d-4824-97c7-2864aad6a99e")
public final class UnionStep implements Step {
    @objid ("be4b3810-47f5-4d79-8606-7fb27be24a5a")
    private List<List<Step>> branches;

    /**
     * Union step constructor.
     *
     * @param branches the alternative branch sequences
     * @throws IllegalArgumentException if branches is null
     */
    @objid ("44a02623-a63a-4596-860a-045ab85732d0")
    public UnionStep(List<List<Step>> branches) {
        if (branches == null) {
            throw new IllegalArgumentException("branches must not be null");
        }
        this.branches = new ArrayList<>();
        for (List<Step> branch : branches) {
            this.branches.add(new ArrayList<>(branch));
        }
    }

    /**
     * Copy constructor.
     *
     * @param other the UnionStep to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("51eac723-bec9-41fe-9a5a-acf91ff12cc4")
    public UnionStep(UnionStep other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.branches = new ArrayList<>();
        for (List<Step> branch : other.branches) {
            List<Step> copiedBranch = branch.stream()
                .map(Step::deepCopy)
                .collect(ArrayList::new, List::add, List::addAll);
            this.branches.add(copiedBranch);
        }
    }

    /**
     * Union step constructor from frozen (immutable) version.
     *
     * @param frozen the frozen UnionStep
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("ff060b87-0355-4bda-a105-f287c149688d")
    public UnionStep(FrozenUnionStep frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.branches = new ArrayList<>();
        for (List<FrozenStep> frozenBranch : frozen.branches()) {
            this.branches.add(Conversions.thawStepList(frozenBranch));
        }
    }

    /**
     * Gets the union branches.
     *
     * @return the list of alternative branch sequences
     */
    @objid ("84988c65-44c7-4d50-9733-398924753110")
    public List<List<Step>> getBranches() {
        return this.branches;
    }

    /**
     * Sets the union branches.
     *
     * @param branches the alternative branch sequences
     * @throws IllegalArgumentException if branches is null
     */
    @objid ("06679b7c-84d7-43af-9b1e-041c7498887e")
    public void setBranches(List<List<Step>> branches) {
        if (branches == null) {
            throw new IllegalArgumentException("branches must not be null");
        }
        this.branches = new ArrayList<>();
        for (List<Step> branch : branches) {
            this.branches.add(new ArrayList<>(branch));
        }
    }

    /**
     * Adds a branch to the union.
     *
     * @param branch the sequence of steps for this branch
     */
    @objid ("0371bf14-7718-4cc1-9e1c-8ce35d9b2395")
    public void addBranch(List<Step> branch) {
        this.branches.add(new ArrayList<>(branch));
    }

    /**
     * Removes a branch from the union.
     *
     * @param index the index of the branch to remove
     */
    @objid ("e92fb9b7-87f5-48a9-bb60-445e66df037d")
    public void removeBranch(int index) {
        this.branches.remove(index);
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this union step
     */
    @objid ("6684ea1d-be20-40ee-a0fd-a39a9d3d064b")
    @Override
    public FrozenUnionStep freeze() {
        List<List<FrozenStep>> frozenBranches = new ArrayList<>();
        for (List<Step> branch : this.branches) {
            frozenBranches.add(Conversions.freezeStepList(branch));
        }
        return new FrozenUnionStep(frozenBranches);
    }

    @objid ("aebf8dd4-070c-4372-8d2d-d010d05e307b")
    @Override
    public UnionStep deepCopy() {
        return new UnionStep(this);
    }

}
