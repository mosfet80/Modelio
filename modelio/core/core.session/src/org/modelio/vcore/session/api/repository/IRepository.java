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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.progress.IModelioProgress;
import org.modelio.vcore.session.api.blob.IBlobInfo;
import org.modelio.vcore.session.impl.storage.IModelLoaderProvider;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MAttribute;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.descriptor.MetamodelDescriptor;

/**
 * Represents a repository where the model is stored.
 * <p>
 * May be a database, an EXML repository or anything else.
 */
@objid ("0039a4b8-eb1c-1f22-8c06-001ec947cd2a")
public interface IRepository {
    /**
     * Add a fresh new object to this repository.
     * <p>
     * The object is guaranteed to be new in the whole world/universe.
     * <p>
     * Should have a behavior similar to {@link #addObject(SmObjectImpl)}.
     * Many implementations should simply call {@link #addObject(SmObjectImpl)}.
     *
     * @param newObject the fresh new object to add.
     * @see #addObject(SmObjectImpl)
     */
    @objid ("272e52df-73d4-4c28-ba91-1426dea16c9c")
    void addCreatedObject(final SmObjectImpl newObject);

    /**
     * Add an object to this repository.
     * <p>
     * Also set the given element repository object.
     * with {@link SmObjectImpl#setRepositoryObject(IRepositoryObject)}.
     * <p>
     * If the object was owned by another repository,
     * it is up to the caller to remove it from the previous repository before calling this method.
     *
     * @param newObject the object to add
     */
    @objid ("00409bc4-eb1c-1f22-8c06-001ec947cd2a")
    void addObject(final SmObjectImpl newObject);

    /**
     * Close the repository.
     * <p>
     * All objects owned by the repository are then invalid and should not be used anymore.
     */
    @objid ("00755da0-fd1a-1f27-a7da-001ec947cd2a")
    void close();

    /**
     * Find model objects by attribute.
     * <p>
     * Look into the given model class and its subclasses.
     *
     * @param cls a model class
     * @param withSubClasses if true look into  sub metaclasses hierarchy
     * @param att a model attribute
     * @param val the attribute value to find
     * @return the found model object that have the given attribute value.
     * @since 3.6 : Collection<MObject> was streamByAtt(final SmClass cls, boolean withSubClasses, final String att, final Object val)
     * @since 6.0.1 : changed to streamByAtt(...) : Stream<? extends MObject>
     * @deprecated Implementations usually load all the objects in memory, it may take hours in the worst case !
     * To look for element by name use {@link #streamByName(SmClass, boolean, String)} that is usually optimized.
     */
    @objid ("211c485a-6de6-4538-ad28-423a23cc9084")
    @Deprecated(forRemoval = true, since = "6.0.1")
    default Stream<? extends MObject> streamByAtt(final SmClass cls, boolean withSubClasses, final String att, final Object val) {
        MAttribute smAtt = cls.getAttribute(att);
        return findByClass(cls, withSubClasses)
                .stream()
                .filter(o -> Objects.equals(o.mGet(smAtt), val));
    }

    /**
     * Get all the model objects of a given class, with the subclasses.
     *
     * @param cls a metamodel class.
     * @param withSubClasses if true include sub classes hierarchy
     * @return the found model objects.
     * @since 3.6
     */
    @objid ("0040edd6-eb1c-1f22-8c06-001ec947cd2a")
    Collection<MObject> findByClass(final SmClass cls, boolean withSubClasses);

    /**
     * Get all the model objects of a given class, with the subclasses.
     *
     * @param cls a metamodel class.
     * @return the found model objects.
     * @deprecated since 3.6 use {@link #findByClass(SmClass, boolean)}
     */
    @objid ("01591f05-020a-4946-a290-c76e59c48748")
    @Deprecated
    default Collection<MObject> findByClass(final SmClass cls) {
        return findByClass(cls, true);
    }

    /**
     * Get all the model objects of a given class, with the subclasses if requested.
     * Uses the Java 9 Stream API.
     * The method may returns immediately depending on the implementation.
     * <p>
     * The returned stream may hold resources.
     * It must be closed and should be used in a try-with-resource statement.
     *
     * @param cls a metamodel class.
     * @param withSubClasses if true include sub classes hierarchy
     * @return a Stream with the model objects .
     * @deprecated Alpha stage, experimental, may change or disappear without warning.
     * @since 6.0.1
     */
    @objid ("58c5c22b-f87a-4c6b-8546-dfbebb97dd2b")
    @Deprecated(since = "6.0.1")
    default Stream<? extends MObject> streamByClass(final SmClass cls, boolean withSubClasses) {
        return findByClass(cls, withSubClasses).stream();
    }

    /**
     * Find a model object by identifier.
     *
     * @param cls a model class.
     * @param siteIdentifier the object unique String.
     * @return the found model object or <code>null</code>.
     */
    @objid ("00410a8c-eb1c-1f22-8c06-001ec947cd2a")
    SmObjectImpl findById(final SmClass cls, final String siteIdentifier);

    /**
     * Find model objects by name.
     * <p>
     * Look into the given model class and its subclasses if requested.
     *
     * @param cls a metamodel class
     * @param withSubClasses if true look into sub metaclasses hierarchy
     * @param name the searched element name
     * @return the found model objects that have the given name.
     * @since 6.0.1 01/07/2024
     */
    @objid ("bd0b5c67-7a52-4d62-88a7-a2f412bb150b")
    default Stream<? extends MObject> streamByName(final SmClass cls, boolean withSubClasses, final String name) {
        return streamByAtt(cls, withSubClasses, cls.getNameAttribute().getName(), name);
    }

    /**
     * Get an access to all the objects already loaded by the repository.
     *
     * @return all the repository content.
     */
    @objid ("75438db1-0884-11e2-b33c-001ec947ccaf")
    Collection<SmObjectImpl> getAllLoadedObjects();

    /**
     * Get an access to all the objects stored in the repository.
     *
     * @return all the repository content.
     */
    @objid ("bd9dd483-92d7-11e1-81e9-001ec947ccaf")
    Iterable<SmObjectImpl> getAllObjects();

    /**
     * Get the helper used to handle error reporting.
     * <p>
     * This support is used to add/remove error handlers and to fire them
     * when a storage error occurs.
     *
     * @return the error support.
     */
    @objid ("0d225406-d66d-11e1-adbb-001ec947ccaf")
    StorageErrorSupport getErrorSupport();

    /**
     *
     * @return the repository live id.
     */
    @objid ("00750cc4-fd1a-1f27-a7da-001ec947cd2a")
    byte getRepositoryId();

    /**
     * Initialize the repository.
     * <p>
     * This method is called by the session before calling {@link #open(IModelLoaderProvider, IModelioProgress)}.
     *
     * @param rid this repository live id
     */
    @objid ("00752182-fd1a-1f27-a7da-001ec947cd2a")
    void init(final byte rid);

    /**
     * Tells whether the repository needs to be saved.
     *
     * @return <code>true</code> if the repository needs to be saved, <code>false</code> if no element was modified.
     */
    @objid ("effa34c2-f802-4b49-82a4-30854f48355c")
    boolean isDirty();

    /**
     *
     * @return <code>true</code> if the repository is open.
     */
    @objid ("0040ae52-eb1c-1f22-8c06-001ec947cd2a")
    boolean isOpen();

    /**
     * Tells whether the given object is owned by this repository.
     *
     * @param val an object
     * @return true if handled by this repository, else false.
     */
    @objid ("dc18ebc6-8fb5-11e1-81e9-001ec947ccaf")
    boolean isStored(final SmObjectImpl val);

    /**
     * Load the given object dependency.
     * <p>
     * The dependency is usually not stored in this way in the repository
     * and a whole repository scan is expected.
     * The object may belong to another repository.
     *
     * @param obj The object to load
     * @param dep The dependency to load.
     */
    @objid ("dc18ebc2-8fb5-11e1-81e9-001ec947ccaf")
    void loadDynamicDep(final SmObjectImpl obj, final SmDependency dep);

    /**
     * Find and load the object data of the given reference.
     * <p>
     * Return <code>null</code> if there is no object with the given references.
     *
     * @param obj the model object to restore
     * @return the loaded data or <code>null</code>.
     */
    @objid ("007540a4-fd1a-1f27-a7da-001ec947cd2a")
    ISmObjectData loadObjectData(final SmObjectImpl obj);

    /**
     * Open the repository.
     * <p>
     * The given model loader provider must be used to instantiate
     * and load the requested repository model objects.
     *
     * @param modelLoader a model loader provider to use
     * @param monitor a progress monitor
     * @throws IOException in case of failure.
     */
    @objid ("0040b58c-eb1c-1f22-8c06-001ec947cd2a")
    void open(final IModelLoaderProvider modelLoader, IModelioProgress monitor) throws IOException;

    /**
     * Read a blob
     * <p>
     * Returns <code>null</code> if there is no blob with such key.
     *
     * @param key a blob key
     * @return the blob content or <code>null</code>.
     * @throws IOException in case of I/O error
     */
    @objid ("9825e3f6-0f4f-47d3-9067-acd01885cb75")
    InputStream readBlob(String key) throws IOException;

    /**
     * Read a blob informations.
     * <p>
     * Returns <code>null</code> if there is no blob with such key.
     *
     * @param key a blob key
     * @return the blob informations or <code>null</code>.
     * @throws IOException in case of I/O error
     */
    @objid ("a86ac8a0-f22f-42ce-aec4-70cc8b200d2d")
    IBlobInfo readBlobInfo(String key) throws IOException;

    /**
     * Remove a blob from the repository.
     * <p>
     * The implementation may choose to defer the actual removal on next save
     * or CMS commit for example.
     *
     * @param key the blob to remove key
     * @throws IOException in case of failure
     */
    @objid ("dc1f4698-4400-46e6-b508-e93e41d6fad5")
    void removeBlob(String key) throws IOException;

    /**
     * Save the repository.
     *
     * @param monitor a progress monitor
     * @throws IOException in case of failure
     */
    @objid ("0040a98e-eb1c-1f22-8c06-001ec947cd2a")
    void save(IModelioProgress monitor) throws IOException;

    /**
     * Write a blob.
     *
     * @param info the blob informations. The main field is the blob key.
     * @return a stream to write the blob content to.
     * @throws IOException in case of copy failure.
     */
    @objid ("505c5af9-17bf-4568-9463-50ae89e03385")
    OutputStream writeBlob(IBlobInfo info) throws IOException;

    /**
     * Get the stored metamodel descriptor if available.
     * <p>
     * The implementation is highly recommended to store a metamodel descriptor on saving.
     * As the metamodel descriptor exist only since Modelio 3.6, repository created before
     * this version may have no metamodel descriptor.
     *
     * @return the stored metamodel descriptor if available.
     * @since 3.6
     */
    @objid ("63f22129-706b-4e42-bbf9-0d7a8c8634f2")
    Optional<MetamodelDescriptor> getMetamodelDescriptor();

    /**
     * Get a query runner used to make more complex queries on the repository.
     * <p>
     * The implementation must always return a new instance.
     * <p>
     * The caller must close the returned instance when it isn't needed anymore.
     *
     * @return the query
     * @since 6.0.1 10/09/2024
     */
    @objid ("aa540d68-81ca-4c50-b519-2cda5c19d367")
    IRepositoryQueryRunner query();

}
