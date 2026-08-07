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
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Transaction individual action
 *
 * @since 5.5
 */
@objid ("7a1374f8-f11b-4d51-8680-4a0b30bc69c0")
public interface ISmAction {
    /**
     *
     * @return the model object modified by the action.
     */
    @objid ("763d34fc-5307-497c-b307-c7ce4c058434")
    MObject getRefered();

    /**
     * Run the visitor on this action.
     *
     * @param <T> the type of the object returned by the visitor
     * @param visitor the visitor
     * @return the object returned by the visitor
     */
    @objid ("2c014602-b840-41e9-b0ac-03ff6e987024")
    <T> T acceptSmActionVisitor(ISmActionVisitor<T> visitor);

}
