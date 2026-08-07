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

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.debug.ThreadDumper;
import org.modelio.vbasic.log.Log;
import org.modelio.vcore.session.api.model.change.IModelChangeEvent;
import org.modelio.vcore.session.api.model.change.IModelChangeHandler;
import org.modelio.vcore.session.api.model.change.IPersistentViewModelChangeListener;
import org.modelio.vcore.session.api.model.change.IStatusChangeEvent;
import org.modelio.vcore.session.api.transactions.ConcurrentTransactionException;
import org.modelio.vcore.session.api.transactions.EndTransactionBadIdException;
import org.modelio.vcore.session.api.transactions.EndTransactionNoActiveTransactionException;
import org.modelio.vcore.session.api.transactions.ITransaction;
import org.modelio.vcore.session.api.transactions.ITransactionClosureHandler;
import org.modelio.vcore.session.api.transactions.ITransactionSupport;
import org.modelio.vcore.session.api.transactions.ITransactionValidator;
import org.modelio.vcore.session.api.transactions.IUndoRedoSupport;
import org.modelio.vcore.session.api.transactions.RedoNoUndoneTransactionException;
import org.modelio.vcore.session.api.transactions.TransactionCreationException;
import org.modelio.vcore.session.api.transactions.TransactionException;
import org.modelio.vcore.session.api.transactions.TransactionForbiddenException;
import org.modelio.vcore.session.api.transactions.TransactionRollbackFailedException;
import org.modelio.vcore.session.api.transactions.UndoActiveTransactionException;
import org.modelio.vcore.session.api.transactions.UndoNoDoneTransactionException;
import org.modelio.vcore.session.impl.transactions.events.EventFactory;
import org.modelio.vcore.session.impl.transactions.events.ModelChangeSupport;
import org.modelio.vcore.session.impl.transactions.smAction.AddActionNoActiveTransactionException;
import org.modelio.vcore.session.impl.transactions.smAction.IAction;
import org.modelio.vcore.session.impl.transactions.smAction.IActionManager;
import org.modelio.vcore.session.impl.transactions.smAction.SimpleAction;
import org.modelio.vcore.session.plugin.VCoreSession;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.transaction.ISmAction;

/**
 * This class manages transactions stacks ("undone", "active" and "done").
 *
 * It allows to open and close a transaction, as well as activate the undo/redo mechanism.
 * It is also possible to rollback a transaction and empty the transaction stacks (usually after saving the model).
 */
@objid ("006f848e-0d1e-1f20-85a5-001ec947cd2a")
@SuppressWarnings("resource")
public class TransactionManager implements IActionManager, ITransactionSupport {
    @objid ("006edd4a-0d1e-1f20-85a5-001ec947cd2a")
    private final ActionHandle actionHandle;

    @objid ("7da7c6ec-1c43-11e2-8eb9-001ec947ccaf")
    private final ModelChangeSupport changeSupport;

    /**
     * Synchronization support for the transaction manager transactions stacks.
     * <p>
     * Use this class instead using 'synchronized' on TransactionManager methods.
     */
    @objid ("ead0b194-99c9-4e07-b4e3-756ab21f1407")
    private final TransactionSyncSupport sync = new TransactionSyncSupport(this::hasCurrentTransaction);

    @objid ("de8e47bc-dcdb-432f-a266-75af9fc76297")
    private ITransactionClosureHandler transactionClosureHandler;

    /**
     * Lock that prevent many threads to open concurrent transactions
     */
    @objid ("6ebac3ae-99a8-41f9-85b6-627a2c2b350d")
    private final ReentrantLock transactionOwnerLock = new ReentrantLock();

    @objid ("00458bf2-8400-1033-9188-001ec947cd2a")
    private ITransactionValidator transactionValidator;

    @objid ("fa8b820c-75c3-462f-a4ae-5adf17c6fca6")
    private volatile GlobalTransaction currentGlobalTransaction;

    /**
     * Undo/redo service.
     */
    @objid ("b018cac3-d214-42cd-8264-08b8b8936297")
    private final UndoRedoManager undoRedoManager;

    /**
     * Constructor for the transaction manager.
     *
     * @param changeSupport the model change support.
     */
    @objid ("006ec4b8-0d1e-1f20-85a5-001ec947cd2a")
    public TransactionManager(ModelChangeSupport changeSupport) {
        this.actionHandle = new ActionHandle(this);
        this.changeSupport = changeSupport;
        this.undoRedoManager = new UndoRedoManager(this, this.sync);
    }

    /**
     * Add an action to the active transaction. The 'undone' stack is also emptied. Action creation is triggered by methods on
     * 'semantic' objects such as "set_", "append_" and "erase_").
     *
     * @throws AddActionNoActiveTransactionException when no active transaction exists.
     */
    @objid ("006ecce2-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public void addAction(final IAction action) throws AddActionNoActiveTransactionException {
        GlobalTransaction myCurrentGlobalTransaction = this.currentGlobalTransaction;
        if (myCurrentGlobalTransaction == null) {
            String msg = VCoreSession.I18N.getMessage("NoActiveTransactionException", action);
            throw new AddActionNoActiveTransactionException(msg);
        }

        Transaction currentTransaction = myCurrentGlobalTransaction.getCurrentTransaction();

        // Record ourself the action
        currentTransaction.addAction(action);

        // Add the action to the potential remote transaction manager
        if (action instanceof SimpleAction sa) {
            boolean ok = false;
            try {
                sa.getRefered().getRepositoryObject().getTransactionManager().addAction(myCurrentGlobalTransaction, (ISmAction) action);
                ok = true;
            } finally {
                if (! ok) {
                    currentTransaction.forgetLastAction();
                }
            }
        }
    }

    @objid ("9f4bec20-09ef-4729-b001-4f80f6c865a8")
    @Override
    public void addObjectAddedToRepository(final SmObjectImpl obj) throws AddActionNoActiveTransactionException {
        GlobalTransaction myCurrentGlobalTransaction = this.currentGlobalTransaction;
        if (myCurrentGlobalTransaction != null) {
            // Empty the 'undone' pile
            //this.undoRedoManager.clearRedo();

            // Add the action to the potential remote transaction manager
            obj.getRepositoryObject().getTransactionManager().addObjectAddedToRepository(myCurrentGlobalTransaction, obj);

            // Record ourself the action
            //currentTransaction.addAction(action);
        } else {
            String msg = VCoreSession.I18N.getMessage("NoActiveTransactionException", obj);
            throw new AddActionNoActiveTransactionException(msg);
        }
    }

    @objid ("3e1f15b4-bdeb-44a3-a3bf-113a946e1964")
    @Override
    public void addObjectRemovedFromRepository(final SmObjectImpl obj) throws AddActionNoActiveTransactionException {
        GlobalTransaction myCurrentGlobalTransaction = this.currentGlobalTransaction;
        if (myCurrentGlobalTransaction != null) {
            // Empty the 'undone' pile
            //this.undoRedoManager.clearRedo();

            // Add the action to the potential remote transaction manager
            obj.getRepositoryObject().getTransactionManager().addObjectRemovedFromRepository(myCurrentGlobalTransaction, obj);

            // Record ourself the action
            //currentTransaction.addAction(action);
        } else {
            String msg = VCoreSession.I18N.getMessage("NoActiveTransactionException", obj);
            throw new AddActionNoActiveTransactionException(msg);
        }
    }

    @objid ("94625045-bced-42f2-8942-aa2387f56d96")
    @Override
    public IUndoRedoSupport getUndoRedoSupport() {
        return this.undoRedoManager;
    }

    @objid ("910ca9fd-137d-4748-8a2b-f057fa668828")
    @Override
    public void asyncExec(Runnable runnable) {
        this.sync.asyncExec(runnable);
    }

    /**
     * Commit a transaction.
     * <p>
     * If the active stack is empty, we are closing and committing an 'undo' block,
     * therefore let stack the closed transaction in
     * the "undo" stack (only if it is 'undoable' otherwise just delete it).
     * <p>
     *
     * @param toCommit the transaction to commit.
     * @throws EndTransactionBadIdException if the transaction being committed is not the currently active one (Sequence error)
     * @throws EndTransactionNoActiveTransactionException if there is no currently active transaction.
     */
    @objid ("006ed0d4-0d1e-1f20-85a5-001ec947cd2a")
    public void commit(final Transaction toCommit) throws EndTransactionBadIdException, EndTransactionNoActiveTransactionException {
        this.sync.lock();

        try {
            // commit when no active transaction => error
            if (this.currentGlobalTransaction == null) {
                String msg = VCoreSession.I18N.getMessage("NoActiveTransactionException", toCommit.getName());

                throw new EndTransactionNoActiveTransactionException(msg);
            }

            // if committing a transaction which is not the current top => Error
            Transaction currentTransaction = this.currentGlobalTransaction.getCurrentTransaction();
            if (currentTransaction != toCommit) {
                String msg = VCoreSession.I18N.getMessage("EndTransactionBadIdException", toCommit.getName(), currentTransaction.getName());
                throw new EndTransactionBadIdException(msg);
            }


            boolean isSession = (this.currentGlobalTransaction.getTransactionsStackSize() == 1);

            if (toCommit.isEmpty()) {
                // Empty transactions are worth no effort
                if (isSession) {
                    // Forget the session transaction
                    this.currentGlobalTransaction = null;
                } else {
                    // If it is an empty inner transaction, discard it.
                    this.currentGlobalTransaction.pop();
                    Transaction owner = this.currentGlobalTransaction.getCurrentTransaction();
                    if (owner != null) {
                        owner.forgetLastAction();
                    }
                }
                this.transactionOwnerLock.unlock();

                return;
            } else {
                // At this stage we are committing a non empty transaction.
                // If the transaction is session level,
                if (isSession) {
                    commitGlobalTransaction();
                } else {
                    // Just pop the top active transaction
                    this.currentGlobalTransaction.pop();
                }
            }

            this.transactionOwnerLock.unlock();
        } finally {
            this.sync.unlock();
        }
    }

    @objid ("90bcc161-7cf3-4e7b-bbb2-da8bfa7d2c5d")
    private void commitGlobalTransaction() {
        GlobalTransaction globalTransactiontoCommit = this.currentGlobalTransaction;
        final Transaction toCommit = globalTransactiontoCommit.getRootTransaction();

        Log.trace("TransactionManager: committing '%s' %sglobal transaction...", globalTransactiontoCommit.getName(), toCommit.isUndoable()?"":"non undoable ");

        // Manage the session handlers for top level transactions
        EventFactory evFact = EventFactory.createCommitEvent(toCommit);

        // Notify model change handlers.
        // They may modify the model, create new transactions and
        // throw exceptions. In the last case the transaction will be rollbacked by the
        // try with resources that the caller MUST use.
        fireModelChangeHandlers(toCommit, evFact);

        // Check it using the transaction validator. (ModelShield)
        if (this.transactionValidator != null) {
            this.transactionValidator.validate(toCommit);
            // the validator will throw an exception if the core audit fails.
            // the transaction will be rollbacked by the try with resources
            // that the caller MUST use.
        }

        // Call the transaction model closure handler who is responsible for adjusting some model elements based on the transaction contents
        if (this.transactionClosureHandler != null) {
            this.transactionClosureHandler.commit(toCommit);
            evFact.updateCommitEvent(toCommit);
        }

        // Notify persistent view model change listeners.
        // They may modify the model, but should make only non structural modifications.
        // They should not create new transactions.
        // They may throw exceptions. In this case the transaction will be rollbacked by the
        // try-with-resources that the caller MUST have used to open the transaction.
        firePersistentViewModelChangeListeners(evFact.getEvent());

        // Now commit remote transactions. @since 5.5
        // Note : this may fail with exception
        RemoteTransactionsManager.commit(globalTransactiontoCommit.getRemoteTransactions());

        // Put non empty undoable sessions in the undo/redo stack,
        // and discards the others.
        if (toCommit.isUndoable()) {
            this.undoRedoManager.addUndoable(globalTransactiontoCommit);
        }

        // Pop the top active session
        this.currentGlobalTransaction = null;

        // Notify model change listeners.
        fireChangeListeners(evFact);

        Log.trace("  TransactionManager: committed %2$s'%1$s' global transaction.", globalTransactiontoCommit.getName(),toCommit.isUndoable()?"undoable ":"and forget ");
    }

    @objid ("006ed048-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public ITransaction createTransaction(final String idName) throws TransactionForbiddenException, ConcurrentTransactionException, TransactionCreationException {
        return createTransaction(idName, 2, TimeUnit.SECONDS);
    }

    @objid ("458edfa6-5353-4a23-97ce-fb91e36b827e")
    @Override
    public ITransaction createTransaction(final String trName, long timeout, TimeUnit unit) throws TransactionForbiddenException, ConcurrentTransactionException, TransactionCreationException {
        tryGetSyncLock(trName, timeout, unit);

        try {
            Transaction newTransaction = null;

            if (this.sync.isTransactionsForbidden()) {
                String message = VCoreSession.I18N.getMessage("TransactionForbiddenException");
                throw new TransactionForbiddenException(message);
            }

            newTransaction = new Transaction(trName, this);

            this.sync.fastUnlock(); // Avoid potential dead locks because we take 2 locks.
            try {
                // Check the transaction is created in the same thread as the parent one,
                // Forbids other threads to create transaction as long as this one will be open.
                tryGetLock(this.transactionOwnerLock, trName, timeout, unit);
            } finally {
                tryGetSyncLock(trName, timeout, unit);
            }

            // Make the new transaction a child of the currently active one
            GlobalTransaction lCurrentGlobalTransaction = this.currentGlobalTransaction;
            if (lCurrentGlobalTransaction != null) {
                Transaction lastTransaction = lCurrentGlobalTransaction.getCurrentTransaction();
                lastTransaction.addAction(newTransaction);

                // Make the new transaction the currently active one
                lCurrentGlobalTransaction.push(newTransaction);
            } else {
                // Create a global transaction
                this.currentGlobalTransaction = new GlobalTransaction(newTransaction);
            }

            return newTransaction;
        } finally {
            if (this.sync.isHeldByCurrentThread()) {
                this.sync.unlock();
            }
        }
    }

    /**
     *
     * @return the action handle created by this transaction manager.
     */
    @objid ("006ed26e-0d1e-1f20-85a5-001ec947cd2a")
    public ActionHandle getActionHandle() {
        return this.actionHandle;
    }

    /**
     * Get the currently opened transaction.
     *
     * @return a transaction. Might be <code>null</code>.
     */
    @objid ("006ed318-0d1e-1f20-85a5-001ec947cd2a")
    public Transaction getCurrentTransaction() {
        GlobalTransaction gct = this.currentGlobalTransaction;
        if (gct == null)
            return null;
        return gct.getCurrentTransaction();
    }

    /**
     * Return <code>true</code> if there is a transaction currently active.
     *
     * @return whether or not a transaction is active.
     */
    @objid ("006ed5a2-0d1e-1f20-85a5-001ec947cd2a")
    @Override
    public boolean hasCurrentTransaction() {
        return this.currentGlobalTransaction != null;
    }

    /**
     * Empty the undo/redo stacks.
     */
    @objid ("006eda5c-0d1e-1f20-85a5-001ec947cd2a")
    public void reset() {
        this.sync.lock();
        try {
            if (this.currentGlobalTransaction != null)
                this.currentGlobalTransaction.clearAllSimpleActions();
            this.undoRedoManager.clearUndo();
            this.undoRedoManager.clearRedo();
        } finally {
            this.sync.unlock();
        }
    }

    /**
     * Rollback the currently active transaction.
     * <p>
     * The actions of the currently active transaction are undo and the transaction removed from he active stack
     *
     * @param toRollback whether or not this transaction can be undone.
     * @throws EndTransactionBadIdException the transaction to rollback is not the currently active one
     * @throws EndTransactionNoActiveTransactionException if there is no active transaction
     * @throws TransactionRollbackFailedException if the rollback unexpectedly failed. In this case the model is not consistent anymore and the session should be closed without saving.
     */
    @objid ("006edaf2-0d1e-1f20-85a5-001ec947cd2a")
    public void rollback(final Transaction toRollback) throws EndTransactionBadIdException, EndTransactionNoActiveTransactionException, TransactionRollbackFailedException {
        this.sync.lock();
        try {
            if (this.currentGlobalTransaction == null) {
                String message = VCoreSession.I18N.getMessage("RollbackTransactionNoActiveTransaction",toRollback.getName());
                throw new EndTransactionNoActiveTransactionException(message);
            }

            this.actionHandle.runWithoutActionRecording(() -> {
                this.currentGlobalTransaction.rollback(toRollback);
            });

            if (this.currentGlobalTransaction.getCurrentTransaction() == null)
                this.currentGlobalTransaction = null;

            this.transactionOwnerLock.unlock();
        } catch (TransactionException e) {
            throw e;
        } catch (IllegalMonitorStateException e) {
            Log.error("%s while rollbacking %s transaction !", e, toRollback);
            Log.error("  this.transactionOwnerLock = %s", this.transactionOwnerLock);
            Log.error("  this.sync = %s", this.sync);

            ThreadDumper.get().getAllThreads(true).addAsSupressed(e);
            throw new TransactionRollbackFailedException(toRollback, e);
        } catch (RuntimeException e) {
            throw new TransactionRollbackFailedException(toRollback, e);
        } finally {
            this.sync.unlock();
        }
    }

    @objid ("976fd806-aef4-427c-8603-fa1cfd0ba507")
    @Override
    public void setClosureHandler(ITransactionClosureHandler transactionClosureHandler) {
        this.transactionClosureHandler = transactionClosureHandler;
    }

    /**
     * Set a {@link ITransactionValidator} to check transaction contents before committing.
     *
     * @param value the transaction validator.
     */
    @objid ("009408cc-841a-1033-9188-001ec947cd2a")
    @Override
    public void setTransactionValidator(final ITransactionValidator value) {
        this.sync.lock();
        try {
            this.transactionValidator = value;
        } finally {
            this.sync.unlock();
        }
    }

    /**
     * Fires model and status change listeners.
     * <p>
     * Transactions are forbidden for model change listeners, ie model change listeners are not allowed to modify the model
     *
     * @param evFact the factory to use to create the model change events.
     */
    @objid ("00938c12-702b-1f21-85a5-001ec947cd2a")
    private void fireChangeListeners(final EventFactory evFact) {
        this.sync.setTransactionsForbidden(true);
        try {
            this.changeSupport.fireModelChangeListeners(evFact.getEvent());

            IStatusChangeEvent statusEvent = evFact.getStatusEvent();
            if (! statusEvent.isEmpty()) {
                this.changeSupport.fireStatusChangeListeners(statusEvent);
            }
        } finally {
            this.sync.setTransactionsForbidden(false);
        }
    }

    /**
     * Fires model change handlers. Handler can modify the model
     */
    @objid ("ab39bf97-32ef-4356-b448-78912919ed53")
    private void fireModelChangeHandlers(Transaction toCommit, EventFactory evFact) {
        for (IModelChangeHandler it : this.changeSupport.getModelChangeHandlers()) {
            it.handleModelChange(evFact.getEvent());
            evFact.updateCommitEvent(toCommit);
        }
    }

    /**
     * Fires model change handlers. Handler can modify the model
     */
    @objid ("6a8c3a63-b124-413a-a9d3-dec1a0331db0")
    private void firePersistentViewModelChangeListeners(IModelChangeEvent event) {
        for (IPersistentViewModelChangeListener it : this.changeSupport.getPersistentViewChangeListeners()) {
            it.updateView(event);
        }
    }

    /**
     * Get the latest started running transaction.
     *
     * @return the last transaction, null if no transaction is open.
     */
    @objid ("c9ef1f45-30ed-4368-a146-070a797074de")
    private Transaction getLastTransaction() {
        GlobalTransaction t = this.currentGlobalTransaction;
        if (t==null)
            return null;
        return t.getCurrentTransaction();
    }

    @objid ("f57b2d26-f1a3-4fdb-9d0c-41f353f0c1a0")
    private void tryGetLock(Lock lock, final String trName, long timeout, TimeUnit unit) throws ConcurrentTransactionException, TransactionCreationException {
        Transaction lastTransaction = getLastTransaction();
        try {
            if (!lock.tryLock(timeout, unit)) {
                if (lastTransaction != null) {
                    throw new ConcurrentTransactionException(trName, lastTransaction, lastTransaction.getCreatorThread(), lastTransaction.getCreationTrace(), timeout, unit);
                } else {
                    // This case should not occur
                    String msg = VCoreSession.I18N.getMessage("TransactionManager.locked.noTransaction",
                            trName,
                            timeout,
                            unit,
                            lock);

                    throw ThreadDumper.get()
                    .getDeadLocks()
                    .addAsSupressed(new TransactionCreationException(msg));
                }
            }
        } catch (InterruptedException e) {
            TransactionCreationException e2;
            if (lastTransaction != null) {
                e2 =  new ConcurrentTransactionException(trName, lastTransaction, lastTransaction.getCreatorThread(), lastTransaction.getCreationTrace(), timeout, unit);
            } else {
                // This case should not occur
                String msg = VCoreSession.I18N.getMessage("TransactionManager.locked.noTransaction.interrupted",
                        trName,
                        timeout,
                        unit,
                        lock);

                e2 = ThreadDumper.get()
                .getDeadLocks()
                .addAsSupressed(new TransactionCreationException(msg));
            }

            e2.initCause(e);

            throw e2;
        }
    }

    @objid ("123cbcc0-0652-4756-816a-e6fb737f0e22")
    private void tryGetSyncLock(final String trName, long timeout, TimeUnit unit) throws ConcurrentTransactionException, IllegalStateException, TransactionCreationException {
        try {
            Transaction lastTransaction = getLastTransaction();
            if (!this.sync.tryLock(timeout, unit)) {
                if (lastTransaction != null) {
                    throw new ConcurrentTransactionException(trName, lastTransaction, lastTransaction.getCreatorThread(), lastTransaction.getCreationTrace(), timeout, unit);
                } else {
                    String msg = VCoreSession.I18N.getMessage("TransactionManager.locked.global",
                            trName,
                            timeout,
                            unit,
                            this.sync);

                    throw ThreadDumper.get()
                    .getDeadLocks()
                    .addAsSupressed(new TransactionCreationException(msg));
                }
            }
        } catch (InterruptedException e) {
            String msg = VCoreSession.I18N.getMessage("TransactionManager.locked.global.interrupted",
                    trName,
                    timeout,
                    unit,
                    this.sync);
            throw new TransactionCreationException(msg, e);
        }
    }

    @objid ("d7c9748a-8ec4-4e49-b365-42de1f663724")
    @Override
    public boolean hasRedo() {
        return getUndoRedoSupport().hasRedo();
    }

    @objid ("4794734a-1e87-4704-a2f5-bf9c57caa829")
    @Override
    public boolean hasUndo() {
        return getUndoRedoSupport().hasUndo();
    }

    @objid ("ccbcad99-c78a-475c-b068-8dce568e4656")
    @Override
    public void undo() throws UndoNoDoneTransactionException, UndoActiveTransactionException {
        getUndoRedoSupport().undo();
    }

    @objid ("b2d34c07-0176-4f8f-8f77-8584494f5648")
    @Override
    public void redo() throws RedoNoUndoneTransactionException {
        getUndoRedoSupport().redo();
    }

}
