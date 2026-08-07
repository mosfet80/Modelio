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
import org.modelio.vcore.session.impl.transactions.smAction.smActionInteractions.IActionVisitor;

/**
 * Base interface for a transaction action.
 */
@objid ("006b243e-0d1e-1f20-85a5-001ec947cd2a")
public interface IAction {
    /**
     * Visitor pattern
     *
     * @param v a visitor
     */
    @objid ("006bd1f4-0d1e-1f20-85a5-001ec947cd2a")
    void accept(final IActionVisitor v);

    /**
     *
     * @return whether this action is a transaction.
     */
    @objid ("006bd352-0d1e-1f20-85a5-001ec947cd2a")
    boolean isTransaction();

    /**
     * Execute le redo de l'action
     */
    @objid ("006b1d36-0d1e-1f20-85a5-001ec947cd2a")
    void redoAction();

    /**
     * Permet de positionner toutes les transactions contenue dans la transaction a non annulable.
     */
    @objid ("006b1e6c-0d1e-1f20-85a5-001ec947cd2a")
    void disableUndo();

    /**
     * Annulle l'execution de l'action
     */
    @objid ("006b1f98-0d1e-1f20-85a5-001ec947cd2a")
    default void undoAction() {
        rollbackAction();
    }

    /**
     * Undo the action, even if {@link #disableUndo()} has been called before.
     *
     * @since 6.0.0
     */
    @objid ("9ed34418-002f-465b-b873-804f7fa20212")
    void rollbackAction();

}
