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
package org.modelio.vcore.session.impl.load;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.model.CompositionGetter;
import org.modelio.vcore.session.api.blob.IBlobSupport;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.session.api.repository.IRepositorySupport;
import org.modelio.vcore.session.impl.handles.IRepositoryMoveHandle;
import org.modelio.vcore.session.impl.transactions.smAction.IActionManager;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmLiveId;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("6042495d-b619-47c6-8213-08ab8bd9ad6a")
public class RepositoryMoveHandle implements IRepositoryMoveHandle {
    @objid ("ac4dad0e-563a-43fc-a5a5-b20bdc9c9148")
    private final IRepositorySupport repoSupport;

    @objid ("ea7ab8cc-470f-4afd-893a-391ededa910a")
    private final IBlobSupport blobSupport;

    @objid ("52fa96e3-8954-4d98-8dc5-72052a6bf8e7")
    private IRepository newBornRepo;

    @objid ("ff9e4f64-d990-4268-987c-b413e6de35ab")
    private final IActionManager actionManager;

    /**
     * initialize the storage helper.
     *
     * @param repoSupport a view of all connected repositories.
     * @param blobSupport <p>the BLOB support</p>
     * @param actionManager the transaction recorder
     */
    @objid ("63a75250-a0be-4c0e-9d7a-93965a4deed8")
    public RepositoryMoveHandle(IRepositorySupport repoSupport, IBlobSupport blobSupport, final IActionManager actionManager) {
        this.repoSupport = Objects.requireNonNull(repoSupport);
        this.blobSupport = Objects.requireNonNull(blobSupport);
        this.actionManager = Objects.requireNonNull(actionManager);
    }

    @objid ("4149cdf9-8c45-4c40-8fa7-ae76e25d250c")
    private IRepository getNewBornRepo() {
        if (this.newBornRepo == null)
            this.newBornRepo = Objects.requireNonNull(this.repoSupport.getRepository(IRepositorySupport.REPOSITORY_KEY_SCRATCH));
        return this.newBornRepo;
    }

    @objid ("afff90b9-2e7a-4b44-af26-39a11e646049")
    @Override
    public void appendObjDepVal(ISmObjectData data, SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val) {
        IRepositoryObject destRepo = data.getRepositoryObject();
        if (isRepositoryMove(dep, dep_val, destRepo)) {
            moveToRepository(dep_val, destRepo, true);
        }

        //done by StorageHandle: data.getRepositoryObject().depValAppended(obj, dep, dep_val);
    }

    @objid ("f5f215cf-aa48-4467-ad9d-e7e3c4902405")
    @Override
    public void eraseObjDepVal(ISmObjectData data, SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val) {
        if (!dep.isComposition() && !dep.isSharedComposition()) {
            return;
        }

        SmObjectImpl newOwner = dep_val.getCompositionOwner();
        if (newOwner == null)
            return;

        IRepositoryObject destRepo = newOwner.getRepositoryObject();
        if (destRepo.getRepositoryId() != data.getRepositoryObject().getRepositoryId()) {
            moveToRepository(dep_val, destRepo, true);
        }

        //done by StorageHandle: data.getRepositoryObject().depValErased(obj, dep, dep_val);
    }

    @objid ("75ebef2b-f051-41b5-af84-2a721c918feb")
    @Override
    public void undoAppendDepVal(SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val, IRepositoryObject previousRepo) {
        if (isRepositoryMove(dep, dep_val, previousRepo)) {
            moveToRepository(dep_val, previousRepo, false);
        }

        //done by StorageHandle: obj.getRepositoryObject().depValErased(obj, dep, dep_val);
    }

    @objid ("48fd2d58-92fd-421d-a5a5-b0668504c2ac")
    @Override
    public void undoEraseDepVal(SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val, IRepositoryObject previousRepo) {
        if (previousRepo.getRepositoryId() != dep_val.getRepositoryObject().getRepositoryId()) {
            moveToRepository(dep_val, previousRepo, false);
        }
    }

    /**
     * Fix the repository handler of 'obj' and its composition tree to be contained in 'destRepo' repository.
     *
     * @param toMove the object to fix
     * @param destRepoHandle the destination repository object.
     */
    @objid ("1fe29770-3a2d-11e2-bf6c-001ec947ccaf")
    private void moveToRepository(SmObjectImpl toMove, IRepositoryObject destRepoHandle, boolean recordInTransaction) {
        // First ensure the whole composition graph is loaded
        int n = CompositionGetter.getAllChildren(Collections.singleton(toMove)).size();

        // Process
        final HashSet<SmObjectImpl> moved = new HashSet<>((int)(n / 0.75));
        IRepository fromRepo = this.repoSupport.getRepository(toMove);
        doMoveToRepository(toMove, destRepoHandle, moved, fromRepo==getNewBornRepo(), recordInTransaction);

        // Move related blobs
        IRepository destRepo = this.repoSupport.getRepository(toMove);
        doMoveBlobs(moved, fromRepo, destRepo);
    }

    /**
     * Tells whether appending the given object to the given dependency means
     * moving the object to another IRepository.
     *
     * @param dep the dependency where the object will be appended
     * @param appended the appended object
     * @return <code>true</code> if it is a move across repositories else <code>false</code>.
     */
    @objid ("1fe29777-3a2d-11e2-bf6c-001ec947ccaf")
    private static boolean isRepositoryMove(SmDependency dep, SmObjectImpl appended, IRepositoryObject destRepoHandle) {
        if (isMove(dep, appended)) {
            IRepositoryObject oldRepoHandle = appended.getRepositoryObject();
            return (oldRepoHandle.getRepositoryId() != destRepoHandle.getRepositoryId());
        }
        return false;
    }

    /**
     * Tells whether removing the given object from the given dependency means
     * moving the object to another IRepository.
     *
     * @param dep the dependency where the object will be appended
     * @param removed the  object removed from the dependency
     * @return <code>true</code> if it is a move across repositories else <code>false</code>.
     */
    @objid ("2b44cf34-8712-492d-baf8-41d67b09ddc9")
    private static boolean isEraseARepositoryMove(SmDependency dep, SmObjectImpl removed, IRepositoryObject destRepoHandle) {
        if (dep.isComposition() || dep.isSharedComposition()) {
            IRepositoryObject oldRepoHandle = removed.getRepositoryObject();
            return (oldRepoHandle.getRepositoryId() != destRepoHandle.getRepositoryId());
        }
        return false;
    }

    /**
     * Tells whether appending the given object to the given dependency means
     * moving the object.
     *
     * @param dep the dependency where the object will be appended
     * @param appended the appended object
     * @return <code>true</code> if it is a move else <code>false</code>.
     */
    @objid ("deaf7d83-5d00-40da-ae57-5fdf198242c5")
    private static boolean isMove(SmDependency dep, SmObjectImpl appended) {
        if (dep.isComponent()) {
            return true;
        }

        if (!dep.isSharedComposition()) {
            return false;
        }

        // Shared composition: we need to know
        // if another composition relation is already defined.
        // Move repository if no other composition relation is defined
        // but this one.
        SmDepVal rel = appended.getCompositionRelation();
        if (rel == null) {
            return true;
        }

        if (rel.dep == dep.getSymetric()) {
            return true;
        }
        return false;
    }

    /**
     * To be called only by {@link #moveToRepository(SmObjectImpl, IRepositoryObject)}.
     * <p>
     * Fix the repository handler of 'obj' and its composition tree to be contained in 'destRepo' repository.
     *
     * @param toMove the object to fix
     * @param destRepoHandle the destination repository object.
     * @param moved will contain all objects moved by this method. Shield against composition cycles.
     * @param fromNewBorn whether objects are moved from the new born objects repository
     */
    @objid ("4ceae771-81db-477f-be01-3ecc22595dc3")
    private void doMoveToRepository(SmObjectImpl toMove, IRepositoryObject destRepoHandle, Collection<SmObjectImpl> moved, boolean fromNewBorn, boolean recordInTransaction) {
        // Composition graph cycle shield
        if (moved.contains(toMove)) {
            return ;
        }

        moved.add(toMove);

        // Get composition children when we can still load them
        List<SmObjectImpl> children = toMove.getCompositionChildren();

        // Move to repository if different
        IRepositoryObject oldRepoHandle = toMove.getRepositoryObject();
        byte destRepoId = destRepoHandle.getRepositoryId();
        if (oldRepoHandle.getRepositoryId() != destRepoId) {
            // Change repository
            oldRepoHandle.detach(toMove);

            if (recordInTransaction)
                this.actionManager.addObjectRemovedFromRepository(toMove);

            if (fromNewBorn) {
                destRepoHandle.attachCreatedObj(toMove);
            } else {
                destRepoHandle.attach(toMove);
            }

            assert (SmLiveId.getRid(toMove.getLiveId()) == destRepoId) : String.format("%s has wrong %d RID instead of %d, after move: \n\tfrom %s \n\tto %s", toMove, SmLiveId.getRid(toMove.getLiveId()), destRepoId, oldRepoHandle, destRepoHandle);

            if (recordInTransaction)
                this.actionManager.addObjectAddedToRepository(toMove);
        }

        // Recurse to children
        IRepositoryObject newRepoHandle = toMove.getRepositoryObject();
        for (SmObjectImpl child : children) {
            doMoveToRepository(child, newRepoHandle, moved, fromNewBorn, recordInTransaction);
        }
    }

    @objid ("11757475-befa-4133-828b-91cb7838201f")
    private void doMoveBlobs(Collection<SmObjectImpl> toMove, IRepository fromRepo, IRepository destRepo) {
        this.blobSupport.fireObjectsMoved(toMove, fromRepo, destRepo);
    }

}
