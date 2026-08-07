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
 * Visitor pattern for {@link ISmAction} interface hierarchy.
 *
 * @param <T> the type of the object returned by all visit methods.
 * @since 5.5
 */
@objid ("405cd40b-e636-4300-b8e4-4d3a0010c200")
public interface ISmActionVisitor<T> {
    @objid ("66721334-4bde-4617-b599-3b5ebd13ed49")
    T visitSmAppendDepValAction(ISmAppendDepValAction action);

    @objid ("143f4d4a-13e2-47b2-b2d5-1b5807022a98")
    T visitSmCreateAction(ISmCreateAction action);

    @objid ("6a77432d-f255-4e56-adad-3156c72a4f3e")
    T visitSmDeleteAction(ISmDeleteAction action);

    @objid ("7a5263be-8502-4009-9dc9-db05473a3fce")
    T visitSmEraseDepValAction(ISmEraseDepValAction action);

    @objid ("9799774c-86b0-445f-a78e-3af0e5511783")
    T visitSmSetAttAction(ISmSetAttAction action);

    @objid ("979cdb64-9d97-44e4-9927-adaf4082ef93")
    T visitSmMoveDepValAction(ISmMoveDepValAction iSmMoveDepValAction);

}
