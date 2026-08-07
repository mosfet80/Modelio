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
 * Same as {@link Runnable} but can throw a {@link SQLException}.
 * <p>
 * The function must be idempotent : it may be run many times in case of SQL connection loss.
 */
@objid ("c95db744-3c41-4f9d-9f39-37d35b3684a0")
interface SqlOperation<T> {
    @objid ("b2e37ee6-eae5-4b2c-92de-c6e27e5329ad")
    void run(T arg) throws SQLException;

}
