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
package org.modelio.vcore.session.impl;

import java.util.HashMap;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.log.Log;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vcore.session.impl.storage.memory.MemoryRepository;
import org.modelio.vcore.smkernel.SmLiveId;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Recycled bean repository for deleted objects.
 * <p>
 * Objects are moved here when being deleted.
 * {@link #save(org.modelio.vbasic.progress.IModelioProgress)} will instead empty the repository.
 * <p>
 *
 * @deprecated Not used anymore, harmful for previous repository implementations that expect deleted objects to remain in same repository.
 */
@objid ("0195b2f1-9f63-40a3-b02d-aa6006ed4ff5")
@Deprecated(forRemoval = true, since = "05/01/2026 > 6.1.2")
class DeletedObjectsRepository extends MemoryRepository {
    /**
     * This repository key in {@link org.modelio.vcore.session.api.repository.IRepositorySupport#getRepository(String)}.
     */
    @objid ("036aa407-a02b-48b2-9b1b-135f5ed98465")
    public static final String REPO_KEY = "repo.key.deleted";

    @objid ("4d96501d-7530-47e5-ada1-94cb1ed72f99")
    private final Map<MObject, Byte> oldRepositoryIds = new HashMap<>();

    @objid ("7d1f0eaa-f743-4fa9-ab6e-9aec402c69e2")
    public DeletedObjectsRepository() {

    }

    @objid ("c8d65bd5-09fd-4e87-9fb7-433c8d6bdf5f")
    public byte getOldRepositoryId(MObject obj) {
        synchronized (this.oldRepositoryIds) {
            Byte oldId = this.oldRepositoryIds.get(obj);
            if (oldId == null) {
                throw new IllegalStateException( obj + " not found in deleted objects repository");
            }
            return oldId;
        }
    }

    @objid ("4c231653-31a8-45a7-9cb7-84e757f9f38e")
    @Override
    public void addObject(SmObjectImpl newObject) {
        throw new IllegalStateException(this+".addObject("+newObject+") : Non deleted objects not expected to be added to a "+getClass().getSimpleName());
    }

    @objid ("b86086a0-d512-4886-8ea6-2bb013e2fe31")
    public void addDeletedObject(SmObjectImpl obj, byte repositoryId) {
        if (repositoryId == getRepositoryId()) {
            // Object is already in the deleted objects repository.
            // Below is debugging code for a case that should not happen.
            if (isStored(obj)) {
                Log.trace(new IllegalArgumentException(obj+" already in deleted objects repository"));
            } else {
                throw new IllegalArgumentException(String.format("""
                        Trying to add object %1s deleted from deleted objects repository itself (%2d id)
                        to the deleted objects repository again.
                        But %1s (rid=%4s) does not exist in the deleted objects repository.
                        It is currently stored in %3s (rid=%5d)
                        """,
                        obj,
                        repositoryId,
                        obj.getRepositoryObject(),
                        obj.getRepositoryObject().getRepositoryId(),
                        SmLiveId.getRid(obj.getLiveId())));
            }
        }

        synchronized (this.oldRepositoryIds) {
            this.oldRepositoryIds.put(obj, repositoryId);
        }
        super.addObject(obj);
    }

    @objid ("a9dee2f7-226e-4e5a-95df-cd9171fa7dcc")
    @Override
    public void detach(SmObjectImpl obj) {
        super.detach(obj);

        synchronized (this.oldRepositoryIds) {
            if (this.oldRepositoryIds.remove(obj) == null) {
                Log.trace(new IllegalArgumentException(this+".detach("+obj+"): object id not found in this.oldRepositoryIds map during detach"));
            }
        }
    }

    @objid ("0cf7b62f-63d9-478b-a67a-db4ac184eba1")
    @Override
    public void addCreatedObject(SmObjectImpl newObject) {
        throw new IllegalStateException(this+".addCreatedobject("+newObject+") : New objects not expected to be added to a "+getClass().getSimpleName());
    }

    @objid ("9f4e2f41-a89f-4b65-8bb7-6526bea65e59")
    @Override
    public boolean isDirty() {
        return this.getAllObjects().iterator().hasNext();
    }

    @objid ("763af395-6edf-4294-8caa-859b9a6b0af6")
    @Override
    public boolean isDirty(SmObjectImpl obj) {
        return isStored(obj);
    }

    @objid ("693e422b-9f12-4ef2-ac74-decb0244ab28")
    @Override
    public void save(IModelioProgress monitor) {
        getAllLoadedObjects().clear();
        // Clear the old repository ids
        synchronized (this.oldRepositoryIds) {
            this.oldRepositoryIds.clear();
        }
        super.save(monitor);
    }

    @objid ("fff2def8-b70a-4d8c-b153-7bf10f58596e")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DeletedObjectsRepository [");
        builder.append(getAllLoadedObjects().size());
        builder.append(" objects, rid=");
        builder.append(getRepositoryId());
        builder.append("]");
        return builder.toString();
    }

}
