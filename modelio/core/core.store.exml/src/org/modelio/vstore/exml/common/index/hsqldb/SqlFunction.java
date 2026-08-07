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
package org.modelio.vstore.exml.common.index.hsqldb;

import java.sql.SQLException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Same as {@link java.util.function.Function} but can throw {@link SQLException}.
 * <p>
 * The function must be idempotent : it may be run many times in case of SQL connection loss.
 */
@objid ("e6d89291-72c7-4525-a76d-73b860a47bd6")
interface SqlFunction<T, U> {
    @objid ("1275d1bb-b2f0-49fe-9716-311860fd1790")
    U run(T arg) throws SQLException;

}
