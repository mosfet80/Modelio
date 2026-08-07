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
/*
 * Copyright 2013-2024 Docaposte
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

import java.util.ArrayDeque;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.session.api.transactions.ITransactionSupport;
import org.modelio.vcore.session.api.transactions.IUndoRedoSupport;
import org.modelio.vcore.session.api.transactions.RedoNoUndoneTransactionException;
import org.modelio.vcore.session.api.transactions.UndoActiveTransactionException;
import org.modelio.vcore.session.api.transactions.UndoNoDoneTransactionException;
import org.modelio.vcore.session.plugin.VCoreSession;

@objid ("07131a0c-dc90-4d67-b94d-8640cbb97039")
class UndoRedoManager implements IUndoRedoSupport {
    /**
     * Flag that disables {@link #clearRedo()} actions.
     *
     * @see #clearRedo()
     */
    @objid ("1540b294-c312-4461-a95d-c246930ee4c4")
    private AtomicBoolean runningUndoRedo = new AtomicBoolean(false);

    @objid ("006ecaee-0d1e-1f20-85a5-001ec947cd2a")
    private final Deque<GlobalTransaction> doneTransactions = new ArrayDeque<>();

    @objid ("006ecbe8-0d1e-1f20-85a5-001ec947cd2a")
    private final Deque<GlobalTransaction> undoneTransactions = new ArrayDeque<>();

    /**
     * Synchronization support for the transaction manager transactions stacks.
     * <p>
     * Use this class instead using 'synchronized' on TransactionManager methods.
     */
    @objid ("728cd3e5-d3d8-4e40-a4a1-3110a1174a40")
    private final ITransactionSupport transactionManager;

    /**
     * Synchronization support for the transaction manager transactions stacks.
     * <p>
     * Use this class instead using 'synchronized' on TransactionManager methods.
     */
    @objid ("b9c27425-0a60-4b37-9d6b-b268508653b7")
    private final TransactionSyncSupport sync;

    @objid ("9b3adb96-6ef8-480f-9585-b988f03d75f6")
    public UndoRedoManager(ITransactionSupport transactionManager, TransactionSyncSupport sync) {
        this.transactionManager = transactionManager;
        this.sync = sync;
    }

    /**
     * Return <code>true</code> if a 'redo' transaction is available.
     *
     * @return whether or not the 'redo' is active.
     */
    @objid ("006ed64c-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public boolean hasRedo() {
        return (!this.undoneTransactions.isEmpty());
    }

    /**
     * Returns <code>true</code> if an undo is currently possible.
     * <p>
     * Conditions: <ul>
     * <li>the active stack is not empty</li>
     * <li>the last recorded action is a closed transaction (no pending opened transaction) or the active transaction stack is empty
     * and the undo stack is not empty.</li>
     * </ul>
     *
     * @return <code>true</code> if 'undo' is possible.
     */
    @objid ("006ed6e2-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public boolean hasUndo() {
        return (!this.doneTransactions.isEmpty());
    }

    /**
     * Run a 'Redo' on the top transaction of the 'undone' stack.
     * <p>
     * Remove it from the 'undone' stack.
     *
     * @throws RedoNoUndoneTransactionException if the undone stack is empty, or a transaction is in progress.
     */
    @objid ("006ed80e-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void redo() throws RedoNoUndoneTransactionException {
        this.sync.lock();

        try {
            if (this.undoneTransactions.isEmpty()) {
                String message = VCoreSession.I18N.getMessage("RedoNoUndoneTransactionException");
                throw new RedoNoUndoneTransactionException(message);
            }

            if (this.sync.hasCurrentTransaction()) {
                String message = VCoreSession.I18N.getMessage("RedoWhileInTransactionException");
                throw new RedoNoUndoneTransactionException(message);
            }

            if (! this.runningUndoRedo.compareAndSet(false, true))
                throw new ConcurrentModificationException("Undo or redo already in progress");

            GlobalTransaction undoneTransaction = this.undoneTransactions.peek();

            Log.trace("Redo '"+ undoneTransaction.getName()+"'");

            // Create a non-undoable transaction to replay the undone transaction
            try (ITransaction t = this.transactionManager.createTransaction("Redo '"+ undoneTransaction.getName()+"'");) {
                t.disableUndo();

                @SuppressWarnings ("resource")
                Transaction rootTransaction = undoneTransaction.getRootTransaction();
                rootTransaction.redoAction();
                //rootTransaction.accept(new RedoActionVisitor());

                t.commit();

                // Move transaction from undone to done only once it is committed.
                // NOTE: (we could push 't' instead of 'undoneTransaction')
                this.undoneTransactions.pop();
                this.doneTransactions.push(undoneTransaction);
            }


        } finally {
            this.runningUndoRedo.set(false);
            this.sync.unlock();
        }
    }

    /**
     * Undo the transaction available for undo if some.
     * <p>
     * If there is an active transaction, undo its last transaction. If there is no active transaction, undo the top transaction of
     * the undo stack if some.
     * <p>
     * The undone transaction is stacked on the redo stack.
     *
     * @throws UndoNoDoneTransactionException if there is no transaction to undo.
     * @throws UndoActiveTransactionException if no active transaction exists.
     */
    @objid ("006edcb4-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void undo() throws UndoNoDoneTransactionException, UndoActiveTransactionException {
        this.sync.lock();
        try {
            if (this.sync.hasCurrentTransaction()) {
                String message = VCoreSession.I18N.getMessage("UndoActiveTransactionException");
                throw new UndoActiveTransactionException(message);
            }

            if (this.doneTransactions.isEmpty()) {
                String message = VCoreSession.I18N.getMessage("UndoNoDoneTransactionException");
                throw new UndoNoDoneTransactionException(message);
            }

            if (! this.runningUndoRedo.compareAndSet(false, true))
                throw new ConcurrentModificationException("Undo or redo already in progress");

            GlobalTransaction doneTransaction = this.doneTransactions.peek();

            Log.trace("Undoing '"+ doneTransaction.getName()+"'");

            // Create a non-undoable transaction to replay the undone transaction

            try (ITransaction t = this.transactionManager.createTransaction("Undo '"+ doneTransaction.getName()+"'");) {
                t.disableUndo();

                @SuppressWarnings ("resource")
                Transaction rootTransaction = doneTransaction.getRootTransaction();

                rootTransaction.undoAction();

                t.commit();

                assert this.doneTransactions.peek() == doneTransaction;

                // Move transaction from done to undone only once it is undone.
                // NOTE: (we could push 't' instead of 'doneTransaction')
                this.doneTransactions.pop();
                this.undoneTransactions.push(doneTransaction);
            }


        } finally {
            this.runningUndoRedo.set(false);
            this.sync.unlock();
        }
    }

    @objid ("4fea54e1-cbc1-4141-b744-8df65cd752d0")
    @Override
    public Stream<String> streamUndoStack() {
        if (this.doneTransactions.isEmpty())
            return Stream.empty();

        return this.doneTransactions.stream().map(GlobalTransaction::getName);
    }

    @objid ("2dfc6537-1766-4b80-80c0-a5ed92b06cd3")
    @Override
    public Stream<String> streamRedoStack() {
        if (this.undoneTransactions.isEmpty())
            return Stream.empty();

        return this.undoneTransactions.stream().map(GlobalTransaction::getName);
    }

    @objid ("bd2a1fdc-1a99-46e7-bf0e-16340395023a")
    void clearRedo() {
        if (false) {
            // This method is called each time an action is added to the current transaction.
            // It is also called when an undo/redo transaction is being built.
            // We don't want to clear undo/redo stack when a transaction is being undone/redone.
            if (this.runningUndoRedo.get())
                return;
        }
        if (this.runningUndoRedo.get())
            throw new ConcurrentModificationException("Undo or redo in progress.");

        if (!this.undoneTransactions.isEmpty())
            this.undoneTransactions.clear();
    }

    @objid ("3d9f9e15-a984-4e30-bf76-56673c5c884a")
    void clearUndo() {
        if (this.runningUndoRedo.get())
            throw new ConcurrentModificationException("Undo or redo in progress.");

        if (! this.doneTransactions.isEmpty())
            this.doneTransactions.clear();
    }

    @objid ("57377823-b652-4e56-acdd-181f223b3c66")
    void addUndoable(GlobalTransaction currentGlobalTransaction) {
        if (this.runningUndoRedo.get())
            throw new ConcurrentModificationException("Undo or redo in progress.");

        this.doneTransactions.push(currentGlobalTransaction);
        clearRedo();
    }

}
