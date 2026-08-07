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
package org.modelio.vcore.session.api.transactions;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.api.ICoreSession;

/**
 * Error indicating a {@link ITransaction#rollback()} failed.
 * <p>
 * <b>This is a serious error because the model is not consistent anymore.</b>
 * The {@link ICoreSession} session should be closed immediately without saving to avoid damaging the data.
 * <p>
 * Use {@link #getCause()} to get the cause of the failure.
 *
 * @since 6.0.0
 */
@objid ("d51360bd-cc94-42bf-b3e5-ae9fbb6d652b")
public class TransactionRollbackFailedException extends TransactionException {
    @objid ("6f49a5b1-5341-43b7-942a-26bc42630cc3")
    private static final long serialVersionUID = 1L;

    @objid ("41ba3dc0-29c3-4e0c-aaab-d27423586ef7")
    private final ITransaction transaction;

    /**
     *
     * @param transaction the transaction whose rollback failed.
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method).
     */
    @objid ("daedeeb2-631b-4e78-a99e-a618e7216feb")
    public TransactionRollbackFailedException(ITransaction transaction, Throwable cause) {
        super("'"+transaction.getName()+"' transaction rollback failed: "+cause.getMessage()+". Model no more consistent. Close the session without saving!", cause);
        this.transaction = transaction;
    }

    /**
     *
     * @return the transaction whose rollback failed
     */
    @objid ("69456e26-b7ba-4f56-91ce-0b63ea7277a5")
    public ITransaction getTransaction() {
        return this.transaction;
    }

}
