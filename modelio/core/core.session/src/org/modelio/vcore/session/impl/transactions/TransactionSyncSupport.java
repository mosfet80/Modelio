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
package org.modelio.vcore.session.impl.transactions;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;
import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;

/**
 * Synchronization support for the transaction manager.
 * <p>
 * Use this class instead using 'synchronized' on TransactionManager methods:
 * <pre>
 * this.sync.lock();
 *
 * try {
 * ...
 * } finally {
 * this.sync.unlock();
 * }
 * </pre>
 *
 * This class has the same functionality as {@link Lock} but also
 * maintains a list of deferred actions to run when no transaction is open anymore.
 */
@objid ("3efa82ff-1b5b-4e2e-874f-2c9dede1ed60")
class TransactionSyncSupport extends ReentrantLock {
    @objid ("0d57ff2a-ac57-4298-89e2-570c4e7de4be")
    private static final long serialVersionUID = 1L;


    @mdl.prop
    @objid ("006ee100-0d1e-1f20-85a5-001ec947cd2a")
    private volatile boolean transactionsForbidden = false;

    @mdl.propgetter
    public boolean isTransactionsForbidden() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.transactionsForbidden;
    }

    @mdl.propsetter
    void setTransactionsForbidden(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.transactionsForbidden = value;
    }

    @objid ("a44c8ab6-52ec-4bc5-9d53-c9387b698fa5")
    private final BooleanSupplier hasCurrentTransaction;

    /**
     * Actions to run on next {@link #unlock()}
     */
    @objid ("9f9d172f-8c1b-45b8-8f5e-a3b81bcc8a24")
    private final Queue<Runnable> deffered = new ConcurrentLinkedQueue<>();

    @objid ("98cb80a1-061c-4d28-8fe6-93bdece4d781")
    public boolean hasCurrentTransaction() {
        assert this.isHeldByCurrentThread() : getOwner();
        return this.hasCurrentTransaction.getAsBoolean();
    }

    @objid ("b693f00b-414e-4405-bea6-09e7d7f1c062")
    public TransactionSyncSupport(BooleanSupplier hasCurrentTransaction) {
        this.hasCurrentTransaction = hasCurrentTransaction;
    }

    /**
     * Extends inherited behavior by running differed actions if no transaction is open anymore.
     */
    @objid ("4dd5e331-ff96-428c-9a14-569dd8896cfd")
    @Override
    public void unlock() {
        assert isHeldByCurrentThread() : this;

        if (!this.hasCurrentTransaction.getAsBoolean()) {
            runDefferedActions();
        }

        super.unlock();
    }

    @objid ("40d409a4-753f-46c4-b797-f849c84bfe3d")
    private void runDefferedActions() {
        setTransactionsForbidden(true);

        Runnable r = this.deffered.poll();
        while (r != null) {
            try {
                r.run();
            } catch (RuntimeException e) {
                Log.warning(e);
            }
            r = this.deffered.poll();
        }

        setTransactionsForbidden(false);
    }

    /**
     * Execute the given runnable as soon as no transaction is open.
     * <p>
     * No transaction will be open until the runnable has finished execution.
     * The given runnable should execute as quickly as possible in order to not lock Modelio.
     *
     * @param runnable a runnable
     */
    @objid ("d8bfc9a8-5e52-4c6b-9f14-3eec54eb6ebf")
    public void asyncExec(Runnable runnable) {
        if (super.tryLock()) {
            try {
                if (!this.hasCurrentTransaction.getAsBoolean()) {
                    runnable.run();
                    return;
                }
            } finally {
                // This Drains any deferred actions added by other threads while we were running.
                // Without this, items added to the deferred queue during runnable.run()
                // would be stranded because super.unlock() does not drain deferred.
                unlock();
            }
        }

        // If we reach this statement, add the action to the deferred ones
        this.deffered.add(runnable);

        // Re-check: the lock holder may have released between our tryLock and add,
        // leaving the deferred task stranded. Try to drain now if possible.
        if (super.tryLock()) {
            unlock();
        }
    }

    /**
     * Same as {@link #unlock()} but does not run deferred actions.
     * <p>
     * Directly calls super {@link ReentrantLock#unlock()}.
     */
    @objid ("2818d732-69a0-4839-a7df-4771eaaf2191")
    public void fastUnlock() {
        assert isHeldByCurrentThread() : this;
        super.unlock();
    }

}
