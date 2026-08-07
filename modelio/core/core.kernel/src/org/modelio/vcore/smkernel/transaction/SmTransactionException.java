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
package org.modelio.vcore.smkernel.transaction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Indicates the repository refused the transaction.
 *
 * @since 5.5
 */
@objid ("99326afd-b8ae-4540-ac73-4d10430ebb04")
public class SmTransactionException extends RuntimeException {
    @objid ("a5a28c2e-6dff-4ecb-bf0d-ce25024dbb0b")
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     * by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause()} method).  (A {@code null} value is
     * permitted, and indicates that the cause is nonexistent or
     * unknown.)
     */
    @objid ("2464a965-685c-44bf-a417-3a1e4483c3f6")
    public SmTransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     * later retrieval by the {@link #getMessage()} method.
     */
    @objid ("78880c53-77ea-4021-b268-55464a66e44b")
    public SmTransactionException(String message) {
        super(message);
    }

}
