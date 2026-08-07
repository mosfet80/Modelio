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
package org.modelio.platform.search.engine.searchers.query.internal.executor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.plugin.SearchEngine;

/**
 * Tracks execution budgets (item limit and wall-clock timeout) and signals truncation
 * when any budget is exhausted.
 * <p>
 * Budget counting is performed post-dedup at the terminal consumer: only unique accepted
 * items count toward the limit.
 * <p>
 * First-hit-wins: whichever budget fires first (timeout or limit) triggers truncation,
 * and subsequent calls to {@link #tryAccept()} return false immediately.
 * <p>
 * Thread-safety: NOT thread-safe. Designed for single-threaded push pipeline usage.
 */
@objid ("32419659-2898-41c0-b3d8-b21b3111c978")
public final class ExecutionBudget {
    @objid ("78b12937-f7d4-45e8-b3c7-a54262511197")
    private static final int DEFAULT_LIMIT = 1000;

    @objid ("b2189e0f-0d64-4160-9cf5-48bc8f34ea11")
    private static final int DEFAULT_TIMEOUT_MS = 60_000;

    @objid ("c3f30ad8-c5e6-46d6-8660-46546d7437cb")
    private final int limit;

    @objid ("bbeea1aa-8e34-4b33-9b13-cec4afdf850d")
    private final long timeoutNanos;

    @objid ("4b773d99-6aee-42d0-8b2e-ae771bf4d487")
    private final long startNanos;

    @objid ("74a1ef90-801e-46f1-a0ab-a584f3ff6c2a")
    private int itemCount;

    @objid ("7643bb54-345d-43ff-a0f3-f498a99556d1")
    private boolean exhausted;

    @objid ("6bbea31f-4bec-49fe-9747-b669c8028ff1")
    private String exhaustionCause;

    /**
     * Creates a new budget tracker.
     *
     * @param limit maximum number of unique items to accept; null uses the default (1000)
     * @param timeoutMs maximum wall-clock time in milliseconds; null uses the default (60000)
     */
    @objid ("df479209-caa4-407c-896d-d88c39450719")
    public ExecutionBudget(Integer limit, Long timeoutMs) {
        this.limit = (limit != null) ? limit : DEFAULT_LIMIT;
        long effectiveTimeoutMs = (timeoutMs != null) ? timeoutMs : DEFAULT_TIMEOUT_MS;
        this.timeoutNanos = effectiveTimeoutMs * 1_000_000L;
        this.startNanos = System.nanoTime();
        this.itemCount = 0;
        this.exhausted = false;
        this.exhaustionCause = null;
    }

    /**
     * Attempts to accept one more item within the budget.
     * <p>
     * Returns {@code true} if the item is within budget and should be processed.
     * Returns {@code false} if the budget is already exhausted — caller should stop.
     * On first exhaustion, sets the exhaustion cause message.
     *
     * @return true if the item is accepted; false if the budget is exhausted
     */
    @objid ("acf1dc90-f8c7-46f0-8532-e9321a843371")
    public boolean tryAccept() {
        if (this.exhausted) {
            return false;
        }
        // Check timeout first (first-hit-wins)
        long elapsed = System.nanoTime() - this.startNanos;
        if (elapsed >= this.timeoutNanos) {
            this.exhausted = true;
            long elapsedMs = elapsed / 1_000_000L;
            int configuredMs = (int) (this.timeoutNanos / 1_000_000L);
            this.exhaustionCause = SearchEngine.I18N.getMessage("MQL.executor.truncated.timeout", Long.valueOf(configuredMs), Long.valueOf(elapsedMs));
            return false;
        }
        // Check limit
        this.itemCount++;
        if (this.itemCount > this.limit) {
            this.exhausted = true;
            this.exhaustionCause = SearchEngine.I18N.getMessage("MQL.executor.truncated.limit", Integer.valueOf(this.limit));
            return false;
        }
        return true;
    }

    /**
     * Returns whether the budget has been exhausted (either timeout or limit fired).
     *
     * @return true if the budget is exhausted
     */
    @objid ("fbcc3366-c5a5-4015-8bff-317ec7845fc9")
    public boolean isExhausted() {
        return this.exhausted;
    }

    /**
     * Returns a human-readable description of why the budget was exhausted.
     * Returns null if the budget has not been exhausted yet.
     *
     * @return exhaustion cause message, or null if not yet exhausted
     */
    @objid ("56ed569e-f396-4126-97ed-f6013e888e02")
    public String getExhaustionCause() {
        return this.exhaustionCause;
    }

}
