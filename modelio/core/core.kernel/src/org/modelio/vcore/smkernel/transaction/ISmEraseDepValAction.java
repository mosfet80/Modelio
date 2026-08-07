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

@objid ("15add5ad-de51-4499-af34-e3a8f8166b0e")
public interface ISmEraseDepValAction extends ISmDependencyAction {
    @objid ("a4827ee9-0d33-4cfb-aef4-0eca6e49d8be")
    @Override
    default <T> T acceptSmActionVisitor(ISmActionVisitor<T> visitor) {
        return visitor.visitSmEraseDepValAction(this);
    }

}
