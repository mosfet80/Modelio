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

@objid ("6b30bbbb-861b-4063-86f7-534e486c7dfd")
public class MarshalingException extends ArchimateException {
    @objid ("9b0435da-c97e-44a7-a6bc-a0217ef0b8f6")
    public MarshalingException(Throwable e) {
        super(e);
    }

    @objid ("abf1f12f-3acf-419f-afc1-300a0bf03ecf")
    public MarshalingException(String message, Exception e) {
        super(message, e);
    }

    @objid ("0e962d81-a337-471d-bc61-a7efedb54d82")
    public MarshalingException(String message) {
        super(message);
    }

}
