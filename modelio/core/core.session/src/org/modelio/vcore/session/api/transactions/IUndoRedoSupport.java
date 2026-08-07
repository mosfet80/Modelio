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

import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Interface defining Undo/Redo support.
 * <p>
 *
 * @since 6.0.0 : it was integrated before in {@link ITransactionSupport}.
 */
@objid ("e636f176-9d8a-4cd3-a161-65696bcd9af0")
public interface IUndoRedoSupport {
    /**
     * Return true if a 'redo' transaction is available.
     *
     * @return whether or not the 'redo' is active.
     */
    @objid ("896c7697-34bc-4c1b-8048-d25e0c546299")
    boolean hasRedo();

    /**
     * Returns true if an undo is currently possible. Conditions:
     * <ul>
     * <li>the active stack is not empty</li>
     * <li>the last recorder action is a closed transaction (no pending opened transaction) or the active transaction stack is empty
     * and the undo stack is not empty.</li>
     * </ul>
     *
     * @return <code>true</code> if 'undo' is possible.
     */
    @objid ("a3c88456-ea1b-4c6a-b2ae-4294a86f40fa")
    boolean hasUndo();

    /**
     * Undo the transaction available for undo if some.
     *
     * If there is an active transaction, undo its last transaction. If there is no active transaction, undo the top transaction of
     * the undo stack if some.
     *
     * The undone transaction is stacked on the redo stack.
     *
     * @throws UndoNoDoneTransactionException if there is no transaction to undo.
     * @throws UndoActiveTransactionException if no active transaction exists.
     */
    @objid ("335d0f9c-ff60-4895-aba2-fe1f32fc3a05")
    void undo() throws UndoNoDoneTransactionException, UndoActiveTransactionException;

    /**
     * Run a 'Redo' on the top transaction of the 'undone' stack. Remove it from the 'undone' stack.
     *
     * @throws RedoNoUndoneTransactionException if the undone stack is empty, or a transaction is in progress.
     */
    @objid ("5d7c7c19-f8fb-41d1-9526-c161e1b0e7c7")
    void redo() throws RedoNoUndoneTransactionException;

    /**
     * Get the name of each transaction in the "undo" stack.
     *
     * @return a stream of names, possibly empty.
     */
    @objid ("7341e90d-f521-4998-b602-08d4ca9c0714")
    Stream<String> streamUndoStack();

    /**
     * Get the name of each transaction in the "redo" stack.
     *
     * @return a stream of names, possibly empty.
     */
    @objid ("6fbd75cb-63c9-4381-b97a-b4c279881ac2")
    Stream<String> streamRedoStack();

}
