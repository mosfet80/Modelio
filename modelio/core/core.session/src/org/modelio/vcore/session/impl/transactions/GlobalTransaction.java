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

import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.api.transactions.EndTransactionBadIdException;
import org.modelio.vcore.session.impl.transactions.smAction.AppendDependencyAction;
import org.modelio.vcore.session.impl.transactions.smAction.CreateElementAction;
import org.modelio.vcore.session.impl.transactions.smAction.DeleteElementAction;
import org.modelio.vcore.session.impl.transactions.smAction.EraseDependencyAction;
import org.modelio.vcore.session.impl.transactions.smAction.IAction;
import org.modelio.vcore.session.impl.transactions.smAction.MoveDependencyAction;
import org.modelio.vcore.session.impl.transactions.smAction.SetAttributeAction;
import org.modelio.vcore.session.impl.transactions.smAction.smActionInteractions.IActionVisitor;
import org.modelio.vcore.session.plugin.VCoreSession;
import org.modelio.vcore.smkernel.transaction.ISmActionVisitor;
import org.modelio.vcore.smkernel.transaction.ISmGlobalTransaction;
import org.modelio.vcore.smkernel.transaction.ISmRemoteTransaction;
import org.modelio.vcore.smkernel.transaction.SmTransactionException;

@objid ("2948a3b2-8e63-4219-92b8-a0a5b8bc4dd3")
@SuppressWarnings("resource")
class GlobalTransaction implements ISmGlobalTransaction {
    @objid ("2451305d-30fc-4507-b7b1-37b531c95744")
    private final Collection<ISmRemoteTransaction> remoteTransactions;

    /**
     * <p>Stack implementation based on {@link Deque}.</p>
     */
    @objid ("006ec5ee-0d1e-1f20-85a5-001ec947cd2a")
    private final List<Transaction> activeTransactions;

    /**
     * Constructeur d'une transaction.
     */
    @objid ("24ae0699-2a4f-434a-8a71-bf2fa5d39519")
    GlobalTransaction(Transaction newTransaction) {
        this.remoteTransactions = new CopyOnWriteArrayList<>(); // we don't really expect more than one remote transaction
        this.activeTransactions = new CopyOnWriteArrayList<>();
        push(newTransaction);
    }

    @objid ("0c4e3749-1557-4db6-a892-f7ee799e241b")
    @Override
    public void attachTransaction(ISmRemoteTransaction remoteTransaction) throws SmTransactionException {
        if (remoteTransaction == null || this.remoteTransactions.contains(remoteTransaction))
            return;

        this.remoteTransactions.add(remoteTransaction);
    }

    /**
     *
     * @return the innermost transaction
     */
    @objid ("b9d2acf4-2b9c-4d26-a68b-e13860aef702")
    Transaction getCurrentTransaction() {
        if (this.activeTransactions.isEmpty())
            return null;
        return this.activeTransactions.get(this.activeTransactions.size()-1);
    }

    /**
     * Get the initial transaction of the stack.
     * <p>
     * It is the one that is used for undo/redo.
     *
     * @return the outer transaction
     */
    @objid ("603c87b8-15cd-49ce-b8ff-ee92b49c6521")
    Transaction getRootTransaction() {
        if (this.activeTransactions.isEmpty())
            return null;
        return this.activeTransactions.get(0);
    }

    @objid ("6f70889e-36e8-4012-8309-8816149f2d09")
    @Override
    public void accept(ISmActionVisitor<?> visitor) {
        Transaction rootTransaction = getRootTransaction();
        if( rootTransaction == null) {
            return;
        }

        rootTransaction.accept(new IActionVisitorAdapter(visitor));
    }

    /**
     * Pop the current transaction from the stack.
     * <p>
     * This method is not expected to be called to remove the {@link #getRootTransaction()} transaction.
     *
     * @return the removed transaction, not null.
     */
    @objid ("a6ba8913-566a-4485-8c1d-c40a9fd87b6e")
    Transaction pop() {
        assert (this.activeTransactions.size() > 1) : String.format("The transactions stack is %d elements only.", this.activeTransactions.size());
        return this.activeTransactions.remove(this.activeTransactions.size()-1);
    }

    @objid ("aed17606-9d51-497d-8019-f5c5f4edd7e7")
    void push(Transaction newTransaction) {
        this.activeTransactions.add(newTransaction);
    }

    @objid ("6535fc56-0c86-42b3-a1be-f81bb4077fa8")
    public String getName() {
        Transaction rootTransaction = getRootTransaction();

        String name = rootTransaction.getName();
        if (name != null && !name.isEmpty())
            return name;

        int n = rootTransaction.getActions().size();
        if (n==0) {
            return "Empty transaction";
        } else {
            return n + " actions";
        }
    }

    @objid ("0b8d991f-ab6d-4534-a7a6-a6b8edcd8d3b")
    void rollback(Transaction toRollback) {
        Transaction currentTransaction = getCurrentTransaction();
        if (currentTransaction != toRollback) {
            String message = VCoreSession.I18N.getMessage("RollbackTransactionWrongTransaction",toRollback.getName(), currentTransaction.getName());
            throw new EndTransactionBadIdException(message);
        }

        // undo the current transaction
        Transaction rollbackTransaction = this.activeTransactions.remove(this.activeTransactions.size()-1);
        rollbackTransaction.rollbackAction();

        // Notify model change listeners
        //fireAbortTransaction(rollbackTransaction, this.activeTransactions.isEmpty());

        // Si la liste des transaction courantes n'est pas vide on a affaire
        // a une transaction imbriquee.
        // il faut donc enlever de la liste des actions la derniere action cree.
        if (!this.activeTransactions.isEmpty()) {
            getCurrentTransaction().forgetLastAction();
        }
    }

    @objid ("c67a9bf8-9281-4efc-b878-a61d4d9aca63")
    int getTransactionsStackSize() {
        return this.activeTransactions.size();
    }

    @objid ("f5d54181-a336-4284-ab28-66453f439437")
    void clearAllSimpleActions() {
        if (!this.activeTransactions.isEmpty()) {
            this.activeTransactions.get(0).clearAllSimpleActions();
        }
    }

    @objid ("d8e9d9d6-79ec-45c1-b805-efaf0a4258db")
    public Collection<ISmRemoteTransaction> getRemoteTransactions() {
        return this.remoteTransactions;
    }

    @objid ("6cb1d4ff-a84b-415a-bd23-7631bb22fd21")
    @Override
    public String toString() {
        if (this.activeTransactions.isEmpty())
            return getClass().getSimpleName()+"[empty]";

        return String.format("%s [%s, %d nested transactions, %d remote transactions]",
                getClass().getSimpleName(),
                this.activeTransactions.get(0),
                this.activeTransactions.size(),
                this.remoteTransactions.size());
    }

    /**
     * Adapter to convert an ISmActionVisitor into an IActionVisitor.
     */
    @objid ("db0809f9-b0c2-4e34-86ce-aa300127c85d")
    private static final class IActionVisitorAdapter implements IActionVisitor {
        @objid ("6d82dd14-e14d-402f-95fc-83bbfe4e3915")
        private final ISmActionVisitor<?> visitor;

        @objid ("7e15287e-164c-4d0a-b4c5-25fa53f40afa")
        private IActionVisitorAdapter(ISmActionVisitor<?> visitor) {
            this.visitor = visitor;
        }

        @objid ("77695910-c433-4357-bdd2-ddeb6b3d4fb2")
        @Override
        public void visitTransaction(Transaction theTransaction) {
            for (IAction action : theTransaction.getActions()) {
                action.accept(this);
            }
        }

        @objid ("9ac99a10-a99c-416c-9a5a-a2a1720a648c")
        @Override
        public void visitSetAttributeAction(SetAttributeAction theSetAttributeAction) {
            this.visitor.visitSmSetAttAction(theSetAttributeAction);
        }

        @objid ("1f912bbb-3f16-4514-8178-805e4d34f1aa")
        @Override
        public void visitMoveDependencyAction(MoveDependencyAction theMoveDependencyAction) {
            this.visitor.visitSmMoveDepValAction(theMoveDependencyAction);
        }

        @objid ("1ced4812-c13f-4645-bb4f-fee646978e5e")
        @Override
        public void visitEraseDependencyAction(EraseDependencyAction theEraseDependencyAction) {
            this.visitor.visitSmEraseDepValAction(theEraseDependencyAction);
        }

        @objid ("c31eb364-62c6-4231-9b54-b2e1a905c7c0")
        @Override
        public void visitDeleteElementAction(DeleteElementAction theDeleteElementAction) {
            this.visitor.visitSmDeleteAction(theDeleteElementAction);
        }

        @objid ("35ee0607-6e2d-42b9-8bf4-11fed069bcc6")
        @Override
        public void visitCreateElementAction(CreateElementAction theCreateElementAction) {
            this.visitor.visitSmCreateAction(theCreateElementAction);
        }

        @objid ("cf10273e-c9df-4cc5-b419-5e490c8962eb")
        @Override
        public void visitAppendDependencyAction(AppendDependencyAction theAppendDependencyAction) {
            this.visitor.visitSmAppendDepValAction(theAppendDependencyAction);
        }

    }

}
