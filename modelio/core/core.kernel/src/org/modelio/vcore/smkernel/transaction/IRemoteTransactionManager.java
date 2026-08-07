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
package org.modelio.vcore.smkernel.transaction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.SmObjectImpl;

/**
 * {@link IRepositoryObject} remote transaction manager returned by {@link IRepositoryObject#getTransactionManager()}.
 * <p>
 * Remote modifiable repositories should implement this interface to support distributed transactions.
 *
 * @author cmarin
 * @since 5.5
 */
@objid ("ea5aad5c-d994-4131-8d6e-a9f224ccf303")
public interface IRemoteTransactionManager {
    /**
     * Singleton instance returned by default by {@link IRepositoryObject#getTransactionManager()},
     * for local repositories that are not interested in remote transaction.
     *
     * Implements the Null object pattern.
     */
    @objid ("3505330f-9e39-46c6-8349-b62acfdefdb8")
    public static final IRemoteTransactionManager NONE = new None();

    /**
     * Add an action that modifies a {@link ISmAction#getRefered() model object} stored in the repository.
     * <p>
     * If the repository wants to be involved in the global transaction,
     * it has to call once {@link ISmGlobalTransaction#attachTransaction(ISmRemoteTransaction)}
     * with its own implementation of {@link ISmRemoteTransaction}.
     *
     * @param globalTransaction The current Modelio global transaction.
     * @param action an action that modifies a model object stored in the repository
     * @throws SmTransactionException if the repository refuses to modify this object
     */
    @objid ("b8fae9cd-3d62-4585-bfa9-bb616ea67301")
    void addAction(ISmGlobalTransaction globalTransaction, ISmAction action) throws SmTransactionException;

    /**
     * Inform the repository the given object has been moved into the repository.
     * <p>
     * Used by real time conference repositories to record the object with all its properties,
     * that are not included in the transaction.
     *
     * @param globalTransaction The current Modelio global transaction.
     * @param obj the added object
     * @throws SmTransactionException if the repository refuses to add this object
     */
    @objid ("5a737edb-a3c7-44cc-b085-a0a895b33c8a")
    void addObjectAddedToRepository(ISmGlobalTransaction globalTransaction, SmObjectImpl obj) throws SmTransactionException;

    /**
     * Inform the repository the given object has been removed from the repository.
     * <p>
     * Used by real time conference repositories to delete the object,
     * its deletion is not included in the transaction.
     *
     * @param globalTransaction The current Modelio global transaction.
     * @param obj the removed object
     * @since 5.5
     * @throws SmTransactionException if the repository refuses to remove this object
     */
    @objid ("1ad08b8f-6b6f-457e-9af0-df8cc0d5766d")
    void addObjectRemovedFromRepository(ISmGlobalTransaction globalTransaction, SmObjectImpl obj) throws SmTransactionException;

    /**
     * Null object pattern for {@link IRemoteTransactionManager}.
     * <p>
     * All methods are no-op .
     */
    @objid ("b02c20c7-43e4-456d-a28d-d8ea403bf375")
    static final class None implements IRemoteTransactionManager {
        @objid ("a6daa11a-3f24-4461-be63-34d2383886cd")
        @Override
        public void addAction(ISmGlobalTransaction globalTransaction, ISmAction action) {

        }

        @objid ("ecb92289-7a78-49b3-b665-a7ffb973a424")
        @Override
        public void addObjectAddedToRepository(ISmGlobalTransaction globalTransaction, SmObjectImpl obj) throws SmTransactionException {

        }

        @objid ("06f67cf5-c687-41df-a27b-2483d7791c46")
        @Override
        public void addObjectRemovedFromRepository(ISmGlobalTransaction globalTransaction, SmObjectImpl obj) throws SmTransactionException {

        }

    }

}
