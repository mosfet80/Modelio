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

@objid ("23777e36-3568-4b42-b873-ea6587399d60")
public interface ISmMoveDepValAction extends ISmDependencyAction {
    @objid ("efdd65ff-0b43-4675-a0e5-174b4e15ab66")
    @Override
    default <T> T acceptSmActionVisitor(ISmActionVisitor<T> visitor) {
        return visitor.visitSmMoveDepValAction(this);
    }

}
