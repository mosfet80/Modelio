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
package org.modelio.vcore.session.impl.handles;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.SmDependency;

/**
 * Interface for the metaobject helper handling the storage.
 * <p>
 * Should ensures that :
 * <ul>
 * <li>all the composition tree belongs to the same repository.
 * <li>a loading session is started
 * </ul>
 */
@objid ("0b6443ec-0f87-4885-bf86-a9b832205ff0")
public interface IRepositoryMoveHandle {
    /**
     * Called after an object relation is modified
     *
     * @param data The object data, to avoid calling {@link SmObjectImpl#getData()}.
     * @param obj An object
     * @param dep the modified metamodel relation
     * @param dep_val the added object
     */
    @objid ("b63de211-de0d-49fe-9b05-850fee30bae2")
    void appendObjDepVal(ISmObjectData data, SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val);

    /**
     * Called after an object relation is modified
     *
     * @param data The object data, to avoid calling {@link SmObjectImpl#getData()}.
     * @param obj An object
     * @param dep the modified metamodel relation
     * @param dep_val the added object
     */
    @objid ("1b4bb76f-c885-46df-b54b-adef90e713e4")
    void eraseObjDepVal(ISmObjectData data, SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val);

    /**
     * Called when an object relation modification is rollbacked.
     *
     * @param obj An object
     * @param dep the modified metamodel relation
     * @param dep_val the object to remove
     * @param oldValStore the repository where the removed object must belong after this operation.
     */
    @objid ("39749267-9d63-4a50-83f5-64eb7d54d4b9")
    void undoAppendDepVal(SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val, IRepositoryObject oldValStore);

    /**
     * Called when an object relation modification is rollbacked.
     *
     * @param oldValStore the repository where the removed object must belong after this operation.
     * @param obj An object
     * @param dep the modified metamodel relation
     * @param dep_val the object to remove
     */
    @objid ("b6a50b7f-4c09-4e21-8d80-3d5fd79f1b47")
    void undoEraseDepVal(SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val, IRepositoryObject previousRepo);

}
