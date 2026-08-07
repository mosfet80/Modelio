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
 * This file is part of the LibreOffice project.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * This file incorporates work covered by the following license notice:
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements. See the NOTICE file distributed
 *   with this work for additional information regarding copyright
 *   ownership. The ASF licenses this file to you under the Apache
 *   License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of
 *   the License at http://www.apache.org/licenses/LICENSE-2.0 .
 */
package com.sun.star.lib.loader;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * WinRegKeyException is a checked exception.
 */
@objid ("943b8222-f835-4c38-be80-1769bda8690c")
final class WinRegKeyException extends java.lang.Exception {
    @objid ("394c3a10-07fe-4c1f-b210-e256e27739dd")
    private static final long serialVersionUID = 1L;

    @objid ("3dddc885-dc0d-4102-85e7-8b07a832416a")
    public WinRegKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a <code>WinRegKeyException</code>.
     *
     * @param cause the exception cause
     */
    @objid ("83006bd9-bd9c-4971-bbea-a06fa31d9d42")
    public WinRegKeyException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a <code>WinRegKeyException</code> with the specified
     * detail message.
     *
     * @param message the detail message
     */
    @objid ("cf3a2773-9914-4613-878e-206fec5b037e")
    public WinRegKeyException(String message) {
        super( message );
    }

}
