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

@objid ("9f59b203-1204-4610-8213-d8e361417669")
public interface ISmGlobalTransaction {
    /**
     * Add an action that modifies a {@link ISmAction#getRefered() model object} stored in the repository.
     *
     * @param transaction an action that modifies a model object stored in the repository
     * @throws SmTransactionException if the repository refuses to modify this object
     */
    @objid ("476fe9e9-af1e-45c7-8f2f-2903585fc9ff")
    void attachTransaction(ISmRemoteTransaction transaction) throws SmTransactionException;

    /**
     * Accept a visitor on all actions stored in this global transaction.
     *
     * @param visitor the visitor to accept
     * @since > 6.1.2 05/01/2026
     */
    @objid ("55127f3b-0254-4118-9f21-9c264cea202c")
    void accept(ISmActionVisitor<?> visitor);

}
