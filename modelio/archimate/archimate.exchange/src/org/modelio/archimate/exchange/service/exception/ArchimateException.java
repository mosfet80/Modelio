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
package org.modelio.archimate.exchange.service.exception;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d049c9d1-3568-4b6f-9b90-ac360872d8a6")
public class ArchimateException extends Exception {
    @objid ("4d59e6d5-dd7e-462c-8af7-4d967d483418")
    public ArchimateException(Throwable e) {
        super(e);
    }

    @objid ("68d8a78d-515d-42e7-9036-e141b1659b89")
    public ArchimateException(String message, Exception e) {
        super(message, e);
    }

    @objid ("da40116f-9f71-4888-b52e-f165efb7772d")
    public ArchimateException(String message) {
        super(message);
    }

}
