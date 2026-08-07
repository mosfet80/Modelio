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
package org.modelio.vcore.session.impl.load;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.api.blob.IBlobSupport;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.session.api.repository.IRepositorySupport;
import org.modelio.vcore.session.impl.handles.IRepositoryMoveHandle;
import org.modelio.vcore.session.impl.handles.IStorageHandle;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;

/**
 * Helper class for storage.
 * <p>
 * Ensures that :
 * <ul>
 * <li>all the composition tree belongs to the same repository.
 * <li>a loading session is started
 */
@objid ("99e0d633-3a25-11e2-bf6c-001ec947ccaf")
public class StorageHandle implements IStorageHandle {
    @objid ("645fb5db-2b13-43f2-be7f-6c76846384ae")
    private final IRepositorySupport repoSupport;

    @objid ("9009e657-a172-4231-9d42-223ae42d0c5a")
    private final IRepositoryMoveHandle repoMoveHandle;

    /**
     * initialize the storage helper.
     *
     * @param repoSupport a view of all connected repositories.
     * @param blobSupport the BLOB support
     * @param repoMoveHandle the BLOB support
     */
    @objid ("1fe03503-3a2d-11e2-bf6c-001ec947ccaf")
    public StorageHandle(IRepositorySupport repoSupport, IBlobSupport blobSupport, IRepositoryMoveHandle repoMoveHandle) {
        this.repoSupport = repoSupport;
        this.repoMoveHandle = repoMoveHandle;
    }

    @objid ("1fe03509-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public void loadAtt(SmObjectImpl obj, SmAttribute att, ISmObjectData data) {
        if (!data.getRepositoryObject().isAttLoaded(obj, att)) {
            data.getRepositoryObject().loadAtt(obj, att);
        }
    }

    @objid ("1fe03510-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public void forceLoadDep(SmObjectImpl obj, SmDependency dep, ISmObjectData data) {
        data.getRepositoryObject().loadDep(obj, dep);
    }

    @objid ("dc24d776-8fb5-11e1-81e9-001ec947ccaf")
    private void loadNonStoredDep(final SmObjectImpl obj, final SmDependency dep) {
        IRepositoryObject repositoryHandle = obj.getRepositoryObject();
        byte objRepositoryId = repositoryHandle.getRepositoryId();

        // Ask the own repository to load the dynamic dep as a normal dep.
        // note: This is a questionable optimization that can make loadDep() implementation more complex.
        repositoryHandle.loadDep(obj, dep);

        // Query other repositories for the dep
        for (IRepository r : this.repoSupport.getRepositories()) {
            if (r.isOpen() && r.getRepositoryId() != objRepositoryId) {
                r.loadDynamicDep(obj, dep);
            }
        }
    }

    @objid ("1fe2974f-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public void loadDep(final SmObjectImpl obj, final ISmObjectData data, final SmDependency dep) {
        if (isStored(dep)) {
            // The dependency is stored for sure
            if (!data.getRepositoryObject().isDepLoaded(obj, dep)) {
                forceLoadDep(obj, dep, data);
            }
        } else {
            // The repository may be unable to store it because of extern
            // references.
            // Ask all repositories.
            loadNonStoredDep(obj, dep);
        }
    }

    @objid ("1fe29759-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public int loadDepIndexOf(SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val, ISmObjectData data) {
        int oldIndex;
        if (dep.isMultiple()) {
            SmMultipleDependency mdep = (SmMultipleDependency) dep;
            oldIndex = mdep.getValueList(data).indexOf(dep_val);
            if (oldIndex == -1 && isStored(dep)) {
                // This is a stored not loaded multiple dependency
                forceLoadDep(obj, dep, data);
                oldIndex = mdep.getValueList(data).indexOf(dep_val);
            }
        } else {
            oldIndex = 0;
            if (dep.getValue(data) == null) {
                forceLoadDep(obj, dep, data);
            }
        }
        return oldIndex;
    }

    @objid ("1fe29762-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public void appendObjDepVal(ISmObjectData data, SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val) {
        this.repoMoveHandle.appendObjDepVal(data, obj, dep, dep_val);

        data.getRepositoryObject().depValAppended(obj, dep, dep_val);
    }

    @objid ("1d9f7bbb-c992-427b-a630-e512941b9661")
    @Override
    public void eraseObjDepVal(ISmObjectData data, SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val) {
        this.repoMoveHandle.eraseObjDepVal(data, obj, dep, dep_val);

        data.getRepositoryObject().depValErased(obj, dep, dep_val);
    }

    @objid ("7ef399f6-c53d-49b4-af2d-eda8e892b9b9")
    @Override
    public void undoEraseObjDepVal(SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val, IRepositoryObject previousRepo) {
        this.repoMoveHandle.undoEraseDepVal(obj, dep, dep_val, previousRepo);

        obj.getRepositoryObject().depValAppended(obj, dep, dep_val);
    }

    @objid ("1fe29769-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public void undoAppendDepVal(SmObjectImpl obj, SmDependency dep, SmObjectImpl dep_val, IRepositoryObject previousRepo) {
        this.repoMoveHandle.undoAppendDepVal(obj, dep, dep_val, previousRepo);

        obj.getRepositoryObject().depValErased(obj, dep, dep_val);
    }

    /**
     * Tells whether any IRepository should store the given {@link SmDependency}.
     *
     * @param dep a dependency
     * @return <code>true</code> if the dependency is stored for sure, else <code>false</code>.
     */
    @objid ("1fe2977d-3a2d-11e2-bf6c-001ec947ccaf")
    @Override
    public boolean isStored(SmDependency dep) {
        if (dep.isPartOf() || dep.isComponent() || dep.isSharedComposition()) {
            return true;
        }

        // Composition inverse are stored for sure
        SmDependency sym = dep.getSymetric();
        if (dep.getMax() == 1 && (sym.isComponent() || sym.isSharedComposition())) {
            return true;
        }
        return false;
    }

    /**
     * Ensure the given dependency is loaded for the given object.
     *
     * @param obj An object
     */
    @objid ("e54ca208-f68d-4385-a89e-27294b6a9544")
    @Override
    public void objDeleted(ISmObjectData data, SmObjectImpl obj) {
        data.getRepositoryObject().objDeleted(obj);
    }

    /**
     * Ensure the given dependency is loaded for the given object.
     *
     * @param obj An object
     */
    @objid ("85c76f61-a4e3-4fde-9cb9-968f3b5ba27e")
    @Override
    public void objUndeleted(ISmObjectData data, SmObjectImpl obj) {
        data.getRepositoryObject().objUnDeleted(obj);
    }

}
