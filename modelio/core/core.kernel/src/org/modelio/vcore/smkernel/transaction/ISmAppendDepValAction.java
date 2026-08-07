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

@objid ("d0a09254-c896-4596-8fc4-4a952b89d67e")
public interface ISmAppendDepValAction extends ISmDependencyAction {
    @objid ("a5cbe61f-7f6a-4aff-9377-48e517bf58d5")
    @Override
    default <T> T acceptSmActionVisitor(ISmActionVisitor<T> visitor) {
        return visitor.visitSmAppendDepValAction(this);
    }

}
