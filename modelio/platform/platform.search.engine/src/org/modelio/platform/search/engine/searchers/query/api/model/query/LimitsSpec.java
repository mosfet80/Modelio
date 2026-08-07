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

import java.time.Duration;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenLimitsSpec;

/**
 * Execution limits for MQL query execution.
 * <p>
 * These limits apply to the entire query execution and control:
 * <ul>
 * <li><b>maxDepth</b>: Maximum recursion depth for all Repeat steps. If not specified, infinite depth is allowed.</li>
 * <li><b>limit</b>: Maximum number of items returned in the response. If not specified, defaults to 1000.</li>
 * <li><b>timeoutMs</b>: Maximum execution time in milliseconds (hard wall time). If not specified, defaults to 1 minute.</li>
 * </ul>
 * <p>
 * The engine enforces these limits and returns {@code truncated: true} in the response if any limit is hit.
 * A diagnostic may be added indicating which limit caused truncation.
 * <p>
 * All limit values are optional (nullable). The execution engine applies default values
 * when limits are not specified.
 */
@objid ("a2b7e243-2dc4-4dfe-b7bf-ca9084138c27")
public class LimitsSpec {
    @objid ("4d0a1c26-e3ba-4827-a92c-b9357a2b229b")
    private Integer maxDepth;

    @objid ("3919e8fd-c5b7-4e70-9a3a-77c20007478d")
    private Integer limit;

    @objid ("c38f9964-0a9c-4dc9-abaa-86dc04ee8f85")
    private Long timeoutMs;

    /**
     * Constructor with all fields.
     */
    @objid ("bb48b54f-96c1-456a-bede-98a4d10f68db")
    public LimitsSpec(Integer maxDepth, Integer limit, Long timeoutMs) {
        this.maxDepth = maxDepth;
        this.limit = limit;
        this.timeoutMs = timeoutMs;
    }

    @objid ("20c4c76e-f7a6-48df-a508-9b1f7e896b59")
    public LimitsSpec(Integer maxDepth, Integer limit, int timeoutMs) {
        this.maxDepth = maxDepth;
        this.limit = limit;
        this.timeoutMs = (long) timeoutMs;
    }

    @objid ("61647b2f-02ac-40a4-97b0-6399db046033")
    public static LimitsSpec of(Integer maxDepth, Integer limit, Duration timeout) {
        return new LimitsSpec(maxDepth, limit, timeout != null ? timeout.toMillis() : null);
    }

    /**
     * Default constructor.
     */
    @objid ("b3e43844-18dc-4d9e-a9fa-7c0cdc28e7b8")
    public LimitsSpec() {
        this(null, null, (Long) null);
    }

    /**
     * Copy constructor.
     */
    @objid ("915b0cdc-e89c-40bd-9f71-7da63e109213")
    public LimitsSpec(LimitsSpec other) {
        this.maxDepth = other.maxDepth;
        this.limit = other.limit;
        this.timeoutMs = other.timeoutMs;
    }

    /**
     * Constructor from frozen.
     */
    @objid ("02f47c3b-3d4a-46f4-8cfd-822d8d9518b0")
    public LimitsSpec(FrozenLimitsSpec frozen) {
        this.maxDepth = frozen.maxDepth();
        this.limit = frozen.limit();
        this.timeoutMs = frozen.timeoutMs();
    }

    /**
     * Gets the maximum recursion depth for all Repeat steps.
     * <p>
     * Controls how many times Repeat steps can iterate.
     * A value of null means infinite depth (limited only by cycle detection).
     *
     * @return maximum depth, or null for infinite
     */
    @objid ("82d91384-c158-4441-854d-239d598ebefc")
    public Integer getMaxDepth() {
        return this.maxDepth;
    }

    /**
     * Sets the maximum recursion depth for all Repeat steps.
     *
     * @param maxDepth maximum depth, or null for infinite
     */
    @objid ("f04cd9ae-cccd-4b8a-9627-52474f00601a")
    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

    /**
     * Gets the maximum number of items to return in the response.
     * <p>
     * Limits the size of the result set. If not specified (null),
     * the engine defaults to 1000 items.
     *
     * @return maximum result count, or null for default (1000)
     */
    @objid ("0abb8de5-35f5-4ee9-8e1c-e00bc5ef99ae")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Sets the maximum number of items to return.
     *
     * @param limit maximum result count, or null for default (1000)
     */
    @objid ("71d61ff6-0cad-43e1-882b-27a85a3fcda5")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Gets the maximum execution time in milliseconds.
     * <p>
     * This is a hard wall time limit. If not specified (null),
     * the engine defaults to 60000ms (1 minute).
     *
     * @return timeout in milliseconds, or null for default (1 minute)
     */
    @objid ("685d5b4c-8648-452a-92a1-0746ccbafc3a")
    public Long getTimeoutMs() {
        return this.timeoutMs;
    }

    /**
     * Sets the maximum execution time in milliseconds.
     *
     * @param timeoutMs timeout in milliseconds, or null for default (1 minute)
     */
    @objid ("b869df95-a3fb-4c7e-a6cf-119dc50610a6")
    public void setTimeoutMs(Long timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    /**
     * Convert to frozen (immutable) version.
     */
    @objid ("73aa0d26-4d1d-4cad-a430-7611719b7462")
    public FrozenLimitsSpec freeze() {
        return new FrozenLimitsSpec(this.maxDepth, this.limit, this.timeoutMs);
    }

    @objid ("aac7c878-134b-421d-b06f-e6b1c271d28d")
    public LimitsSpec deepCopy() {
        return new LimitsSpec(this);
    }

}
