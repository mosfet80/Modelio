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
package org.modelio.vcore.session.impl.transactions.smAction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

/**
 * This interface is used to record modifications done to the model,
 * so that they can be rollbacked in case of error.
 */
@objid ("006e7896-0d1e-1f20-85a5-001ec947cd2a")
public interface IActionManager {
    /**
     * Add the given action to this action manager.
     *
     * @param action the action to add
     * @throws AddActionNoActiveTransactionException if no transaction is open.
     */
    @objid ("006e9c68-0d1e-1f20-85a5-001ec947cd2a")
    void addAction(final IAction action) throws AddActionNoActiveTransactionException;

    /**
     * Tells whether a transaction is open.
     *
     * @return <code>true</code> if a transaction is open else false.
     */
    @objid ("f1cc6452-b8f8-4681-8ddb-d7acb530d90c")
    boolean hasCurrentTransaction();

    /**
     * Inform the repository the given object has been moved into the repository.
     * <p>
     * Used by real time conference repositories to record the object with all its properties,
     * that are not included in the transaction.
     *
     * @param obj the added object
     * @throws AddActionNoActiveTransactionException if no transaction is open.
     * @since 5.5
     */
    @objid ("650ed3c2-135a-4043-b93e-1448430025fc")
    void addObjectAddedToRepository(final SmObjectImpl obj) throws AddActionNoActiveTransactionException;

    /**
     * Inform the repository the given object has been removed from the repository.
     * <p>
     * Used by real time conference repositories to delete the object,
     * its deletion is not included in the transaction.
     *
     * @param obj the removed object
     * @throws AddActionNoActiveTransactionException if no transaction is open.
     * @since 5.5
     */
    @objid ("5d4e3949-a0f6-4d27-b273-d9581fb4745e")
    void addObjectRemovedFromRepository(final SmObjectImpl obj) throws AddActionNoActiveTransactionException;

}
