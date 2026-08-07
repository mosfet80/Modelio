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
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenRepeatStep;

/**
 * Repeat step: represents recursive traversal.
 * <p>
 * The repeated body is executed starting from the current node stream,
 * then the output nodes are fed back as input to the next iteration,
 * until no new nodes are reached or a limit is hit (depth, time, etc.).
 * <p>
 * Repeat semantics:
 * <ul>
 * <li>A hard depth limit for all Repeat steps may be specified in LimitsSpec as maxDepth</li>
 * <li>A node that has already been reached is not revisited (guarantees termination)</li>
 * <li>The engine produces the first encountered path only</li>
 * <li>If a limit is hit, the engine stops and returns truncated=true</li>
 * </ul>
 * <p>
 * Cycle detection: A cycle is detected when a traversal returns to any node
 * already present in the currently explored path. The engine adds a warning diagnostic.
 */
@objid ("40c002b4-9db8-4ec9-a682-cf069ee580e9")
public final class RepeatStep implements Step {
    /**
     * Whether to emit nodes at every depth level (true) or only the deepest frontier nodes (false).
     */
    @objid ("a3adfab4-01b1-406e-b83c-48bbd15bb167")
    private boolean emitAllDepths = true;

    @objid ("84c8cda3-c390-44d4-977b-e03ec1a2ab73")
    private List<Step> body;

    /**
     * Constructor.
     *
     * @param body the sequence of steps to repeat
     * @throws IllegalArgumentException if body is null
     */
    @objid ("6d72bc29-c838-44ab-9dd7-b18060631bc8")
    public RepeatStep(List<Step> body) {
        if (body == null) {
            throw new IllegalArgumentException("body must not be null");
        }
        this.body = new ArrayList<>(body);
    }

    /**
     * Copy constructor.
     *
     * @param other the RepeatStep to copy
     * @throws IllegalArgumentException if other is null
     */
    @objid ("d93c5e66-ce17-43c2-bdef-03c39c0b764f")
    public RepeatStep(RepeatStep other) {
        if (other == null) {
            throw new IllegalArgumentException("other must not be null");
        }
        this.body = other.body.stream()
            .map(Step::deepCopy)
            .collect(ArrayList::new, List::add, List::addAll);
        this.emitAllDepths = other.emitAllDepths;
    }

    /**
     * Constructor from frozen (immutable) version.
     *
     * @param frozen the frozen RepeatStep
     * @throws IllegalArgumentException if frozen is null
     */
    @objid ("9a131eba-e104-4ae3-bba3-37c0eb639b32")
    public RepeatStep(FrozenRepeatStep frozen) {
        if (frozen == null) {
            throw new IllegalArgumentException("frozen must not be null");
        }
        this.body = Conversions.thawStepList(frozen.body());
        this.emitAllDepths = Boolean.TRUE.equals(frozen.emitAllDepths());
    }

    /**
     * Gets the body steps to be repeated.
     *
     * @return the list of steps in the repeat body
     */
    @objid ("0b27fbb8-b994-462f-b5ed-ad89444cc7e5")
    public List<Step> getBody() {
        return this.body;
    }

    /**
     * Sets the body steps.
     *
     * @param body the sequence of steps to repeat
     * @throws IllegalArgumentException if body is null
     */
    @objid ("dd3a402f-474e-47a6-9ce1-b5974b3af91d")
    public void setBody(List<Step> body) {
        if (body == null) {
            throw new IllegalArgumentException("body must not be null");
        }
        this.body = new ArrayList<>(body);
    }

    /**
     * Returns whether nodes are emitted at every depth level.
     *
     * @code true} (default) to emit at every depth; {@code false} to emit only frontier/deepest nodes
     */
    @objid ("6d223d28-92f2-4300-8900-b0b5ce49b381")
    public boolean isEmitAllDepths() {
        return this.emitAllDepths;
    }

    /**
     * Sets whether to emit nodes at every depth level.
     *
     * @param emitAllDepths {@code true} to emit at every depth (default); {@code false} to emit only frontier nodes
     */
    @objid ("8a983399-4dee-4397-b35c-04ea27c81be1")
    public void setEmitAllDepths(boolean emitAllDepths) {
        this.emitAllDepths = emitAllDepths;
    }

    /**
     * Adds a step to the repeat body.
     *
     * @param step the step to add
     */
    @objid ("9a9f3a31-d0c5-4cda-b6e0-081a1a2f1fa6")
    public void addStep(Step step) {
        this.body.add(step);
    }

    /**
     * Removes a step from the repeat body.
     *
     * @param index the index of the step to remove
     */
    @objid ("bf13462f-7cd0-454e-9eb5-9b0b3434ebc3")
    public void removeStep(int index) {
        this.body.remove(index);
    }

    /**
     * Convert to frozen (immutable) version.
     *
     * @return the frozen representation of this repeat step
     */
    @objid ("02815e7f-8674-464f-bfe7-77739b1a8c56")
    @Override
    public FrozenRepeatStep freeze() {
        return new FrozenRepeatStep(this.emitAllDepths, Conversions.freezeStepList(this.body));
    }

    @objid ("09d702c1-fecb-4ba6-bb7f-ad25b688b982")
    @Override
    public RepeatStep deepCopy() {
        return new RepeatStep(this);
    }

}
