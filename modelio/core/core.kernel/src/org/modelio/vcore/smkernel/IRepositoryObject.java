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
package org.modelio.vcore.smkernel;

import java.util.concurrent.CompletableFuture;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.ecore.resource.Resource;
import org.modelio.vcore.smkernel.mapi.MStatus;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.transaction.IRemoteTransactionManager;

/**
 * <p>Repository object interface.</p><p>Called by the meta object ({@link IMetaOf}) to load parts of a {@link SmObjectImpl} when required.<br />
 * Notified for each {@link SmObjectImpl} modification.</p>
 */
@objid ("00766e16-10dd-1f20-85a5-001ec947cd2a")
public interface IRepositoryObject {
    /**
     * Called when a model object attribute value is modified.
     * <p>
     * The attribute value is already set to the new value.
     * <h2>History</h2>
     * <ul>
     * <li>before 6.0.1 : there was only 2 parameters
     * <li>since 6.0.1+ 06/11/2024 : added oldVal parameter
     * </ul>
     *
     * @param obj the modified object.
     * @param att the modified attribute.
     * @param oldVal the attribute previous value
     */
    @objid ("0a620ce2-08e8-4af2-bd80-d8b0f3b6e83f")
    void attModified(SmObjectImpl obj, SmAttribute att, Object oldVal);

    /**
     * Attach the object to the repository.
     * <p>
     * The object is likely coming from another repository.
     * It may also be moving back in this repository.
     * Implementations are advised to be careful about these use cases.
     *
     * @param obj the object to attach.
     */
    @objid ("002746ce-3ddf-1ffc-8433-001ec947cd2a")
    void attach(SmObjectImpl obj);

    /**
     * Same as {@link #attach(SmObjectImpl)} but the object is guaranteed to be a fresh
     * new object in the whole world/universe .
     * <p>
     * Implementations may either call {@link #attach(SmObjectImpl)} or do some optimizations
     * avoiding to look whether the object already existed.
     *
     * @param obj the new born object.
     */
    @objid ("92764ccc-df2e-4879-a697-4d2e76a3282c")
    void attachCreatedObj(SmObjectImpl obj);

    /**
     *
     * @param obj the modified object.
     * @param dep the modified dependency.
     * @param val the added value.
     */
    @objid ("00766768-10dd-1f20-85a5-001ec947cd2a")
    void depValAppended(SmObjectImpl obj, SmDependency dep, SmObjectImpl val);

    /**
     *
     * @param obj the modified object.
     * @param dep the modified dependency.
     * @param val the removed value.
     */
    @objid ("00766812-10dd-1f20-85a5-001ec947cd2a")
    void depValErased(SmObjectImpl obj, SmDependency dep, SmObjectImpl val);

    /**
     * Called when the dependency content of a model object is reordered.
     *
     * @param obj the modified model object.
     * @param dep the reordered dependency.
     * @param val the moved dependency value.
     */
    @objid ("007668bc-10dd-1f20-85a5-001ec947cd2a")
    void depValMoved(SmObjectImpl obj, SmDependency dep, SmObjectImpl val);

    /**
     * Detach the object from this repository.
     *
     * @param obj the object to detach.
     */
    @objid ("00273512-3ddf-1ffc-8433-001ec947cd2a")
    void detach(SmObjectImpl obj);

    /**
     * Get the EMF Resource object mapping this repository object.
     *
     * @return the EMF Resource.
     */
    @objid ("17bcf492-c064-11e1-b511-001ec947ccaf")
    Resource getEmfResource();

    /**
     * The repository id is attributed by the <code>IRepository</code>.
     *
     * @return the repository id.
     */
    @objid ("008478bc-eb1b-1f22-8c06-001ec947cd2a")
    byte getRepositoryId();

    /**
     *
     * @param obj the object to load.
     * @param att the attribute to test.
     * @return <code>true</code> if the attribute value is already loaded, else <code>false</code>.
     */
    @objid ("00766ab0-10dd-1f20-85a5-001ec947cd2a")
    boolean isAttLoaded(SmObjectImpl obj, SmAttribute att);

    /**
     *
     * @param obj the object to load.
     * @param dep the dependency to test.
     * @return <code>true</code> if the dependency value is already loaded, else <code>false</code>.
     */
    @objid ("00766966-10dd-1f20-85a5-001ec947cd2a")
    boolean isDepLoaded(SmObjectImpl obj, SmDependency dep);

    /**
     *
     * @param obj a model object.
     * @return whether the object needs saving.
     */
    @objid ("dc274961-4868-11e2-91c9-001ec947ccaf")
    boolean isDirty(SmObjectImpl obj);

    /**
     * Tells whether the given SmDependency is stored in the database.
     *
     * The answer should be the same for any element in the database, but it is not required.
     *
     * @param dep a metamodel dependency.
     * @return <code>true</code> if stored, else <code>false</code>.
     */
    @objid ("00766a06-10dd-1f20-85a5-001ec947cd2a")
    boolean isPersistent(SmDependency dep);

    /**
     * Load the attribute value if not already done.
     *
     * @param obj the object to load.
     * @param att the attribute to load.
     */
    @objid ("00766c04-10dd-1f20-85a5-001ec947cd2a")
    void loadAtt(SmObjectImpl obj, SmAttribute att);

    /**
     * Load all status flags of the object if not already done.
     *
     * @param obj the object to load.
     */
    @objid ("14a4a74a-cf3d-48fa-a7e9-8c48e0446278")
    void loadStatus(SmObjectImpl obj);

    /**
     * Load an object dependency content if not already done.
     * <p>
     * Should do nothing if the dependency is already loaded.
     *
     * @param obj the object to load.
     * @param dep the dependency to load.
     */
    @objid ("00766b5a-10dd-1f20-85a5-001ec947cd2a")
    void loadDep(SmObjectImpl obj, SmDependency dep);

    /**
     * Remove the object from all caches.
     * <p>
     * Called when an object is removed from memory.
     * <p>
     * The repository object must unload only the passed object.
     *
     * @param obj the object to unload.
     */
    @objid ("c66aaf03-0884-11e2-b33c-001ec947ccaf")
    void unload(SmObjectImpl obj);

    /**
     * Set the given object as to be reloaded on next access.
     *
     * @param obj the object to reload.
     */
    @objid ("4e2fcaea-71c8-4474-a0db-5f21f1db31b0")
    void setToReload(SmObjectImpl obj);

    /**
     * Get the repository transaction manager, if any.
     * <p>
     * Used by distributed remote server fragments to implement distributed transactions.
     *
     * @return the repository transaction manager or {@link IRemoteTransactionManager#NONE}.
     * @since 5.5 - 01/02/2024
     */
    @objid ("5c3b8778-d466-495c-810e-35cf98966c46")
    default IRemoteTransactionManager getTransactionManager() {
        return IRemoteTransactionManager.NONE;
    }

    /**
     * Tells whether all CMS status flags are fully loaded.
     * <p>
     * CMS status flags loading is a long operation and is done asynchronously since Modelio 6.0.0.
     * As for other methods, the returned value won't reflect status changes after the {@link MStatus} instantiation.
     *
     * @param obj the object to load status.
     * @return <code>true</code> if the CMS flags are fully loaded.
     * @since 6.0.0
     */
    @objid ("e71dcae7-432c-40a8-9544-1b3c0cf681b8")
    default boolean isStatusFullyLoaded(SmObjectImpl obj) {
        return true;
    }

    /**
     * Tells when all CMS status flags are fully loaded.
     * <p>
     * CMS status flags loading is a long operation and is done asynchronously since Modelio 6.0.0.
     * <p>
     * This method returns a future that is completed when all status flags are loaded.
     *
     * @param obj the object to load status.
     * @return a future that is completed once all status flags are loaded, or the loading failed.
     * @since 6.0.0
     */
    @objid ("3b061b68-1c3b-4ac4-a40f-943010a42e8a")
    default CompletableFuture<Void> whenStatusFullyLoaded(SmObjectImpl obj) {
        return CompletableFuture.completedFuture(null);
    }

    /**
     * <p>Called when an object is undeleted</p>
     *
     * @param obj An object
     * @since > 6.1.2 22/12/2025
     */
    @objid ("5a3ca8e8-270e-426b-a841-cf93777cfe14")
    default void objUnDeleted(final SmObjectImpl obj) {
        return; // workaround JavaArchitect reverse bug
    }

    /**
     * <p>Called when an object is deleted.</p>
     *
     * <p>The implementation is expected to keep the deleted object available in memory and discoverable until the repository is saved.</p>
     *
     * @param obj An object
     * @since > 6.1.2 22/12/2025
     */
    @objid ("a7283f7e-e0fc-40ab-aba6-bd203cc6b542")
    default void objDeleted(final SmObjectImpl obj) {
        return; // dummy implementation needed to workaround JavaArchitect reverse bug
    }

}
