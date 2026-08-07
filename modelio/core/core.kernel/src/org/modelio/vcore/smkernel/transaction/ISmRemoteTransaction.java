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

import java.time.Duration;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Represents a remote transaction involved in a {@link ISmGlobalTransaction}.
 *
 * @since 5.5
 */
@objid ("027c7507-c225-4215-83db-9073c041cae3")
public interface ISmRemoteTransaction {
    /**
     * Prepare the commit the transaction in the remote repository.
     * <p>
     * This is the 1st phase of the 2 phases commit.
     *
     * @throws SmTransactionException if the remote repository refuses the transaction.
     */
    @objid ("c7456004-40bf-41de-8e89-86c79b17e45f")
    void prepareCommit() throws SmTransactionException;

    /**
     * Commit the transaction in the remote repository
     * <p>
     * This is the 2nd phase of the 2 phases commit.
     *
     * @throws SmTransactionException if the remote repository refuses the transaction.
     */
    @objid ("d7a5f5a3-0646-4ddd-b32a-3e53584d780d")
    void commit() throws SmTransactionException;

    /**
     * Rollback the transaction in the remote repository
     *
     * @throws SmTransactionException if the remote repository refuses the rollback (we are very bad then ...) .
     */
    @objid ("af738824-16b2-4b2d-b980-c9f1e7c008a0")
    void rollback() throws SmTransactionException;

    /**
     * Get the estimated maximum time the server will need to process the transaction.
     * <p>
     * The caller may use it to setup a time out for the commit.
     * The returned time may depend on the transaction content.
     *
     * @return the estimated maximum time the server will need to process the transaction.
     */
    @objid ("9ff66b8a-3036-4616-850c-2aaf907e8872")
    Duration getCommitExpectedMaxDuration();

}
