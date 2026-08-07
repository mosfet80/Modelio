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
 * Copyright 2013-2024 Docaposte
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
package org.modelio.vcore.session.api.repository;

import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmObjectImpl;

/**
 * Complex queries that must be implemented.
 *
 * @since 6.0.1 10/09/2024
 */
@objid ("b9bbf2d7-27af-4279-b056-52ebc90f4d66")
public interface IRepositoryQueryRunner extends AutoCloseable {
    /**
     * Load all model objects that reference the given ones, with the dependency used to reference them.
     * To be used to navigate many non navigable dependencies at once, avoiding plenty database queries.
     * <p>
     * After having called this method, call {@link SmDependency#getValueAsCollection(org.modelio.vcore.smkernel.ISmObjectData)}
     * to get the loaded values instead of calling standard getters.
     */
    @objid ("7bbc6104-ae5c-4511-b2f2-4f59e2916c3d")
    void loadAllReferencesTo(Collection<SmObjectImpl> objs);

    @objid ("467b12bf-94f4-419e-b8cb-374975ec2235")
    @Override
    void close();

}
