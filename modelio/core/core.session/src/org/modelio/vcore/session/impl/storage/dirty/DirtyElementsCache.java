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
package org.modelio.vcore.session.impl.storage.dirty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vbasic.collections.MultiHashMap;
import org.modelio.vcore.model.DuplicateObjectException;
import org.modelio.vcore.model.MObjectCache;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MAttribute;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmMetamodel;

/**
 * Cache for dirty elements to be used by {@link IRepository} implementations.
 */
@objid ("fd3bd8d5-bac2-459e-b53c-1ca655493e5e")
public class DirtyElementsCache {
    @objid ("ebad1f5a-64dd-4e49-b72f-96f96252082d")
    private Set<String> cacheById;

    @objid ("f7ab9085-0a11-4178-bf22-9005701f3182")
    private final SmMetamodel metamodel;

    @objid ("d8c15373-ea1e-4e30-b083-2055e9d54726")
    private Map<String, Set<MObject>> cacheByName;

    @objid ("ff68fb4c-b7a1-4f90-8de1-ada68018bcd4")
    public DirtyElementsCache(SmMetamodel metamodel) {
        this.metamodel = metamodel;
        this.cacheByName = new ConcurrentHashMap<>();
        this.cacheById = new ConcurrentHashMap<String, Boolean>().keySet(true);
    }

    /**
     * Add an object to this cache.
     *
     * @param newObject the object to add
     */
    @objid ("5522d6f3-02c5-4e74-9254-951899bfeeb9")
    public boolean addObject(final SmObjectImpl newObject) {
        // Skip metaclasses that don't have name
        if (newObject.getMClass().getNameAttribute() != null) {
            if (!this.cacheById.add(newObject.getUuid()))
                return false;

            writeNameCache(newObject.getName()).add(newObject);
            return true;
        }

        return false;
    }

    @objid ("175439fd-69c8-4bdc-91d1-9c4c8225331c")
    private Set<MObject> writeNameCache(final String name) {
        return this.cacheByName.computeIfAbsent(name, k -> new ConcurrentHashMap<MObject, Boolean>().keySet(true));
    }

    @objid ("7e66bc19-a4ec-4c9d-88dd-637d0231f8ff")
    private Set<MObject> readNameCache(final String name) {
        return this.cacheByName.getOrDefault(name, Set.of());
    }

    /**
     * Update the cache when an object attribute value changes.
     * <p>
     * Updates the name cache if the changed attribute is a name attribute.
     *
     * @param obj the modified object
     * @param att the modified attribute
     * @param oldVal the previous value
     */
    @objid ("eb78591a-1217-4cd7-8d54-bcbbfac46599")
    public void addModified(SmObjectImpl obj, SmAttribute att, Object oldVal) {
        if (addObject(obj)) {
            // The object was not yet in the cache, nothing more to do.
            return;
        }

        if (att.isNameAtt()) {
            if (oldVal != null) {
                writeNameCache((String)oldVal).remove(obj);
            }

            String newName = obj.getName();
            if (newName != null) {
                writeNameCache(newName).add(obj);
            }
        }
    }

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
    @objid ("146e5a34-5022-42c1-a99e-8ae4c618f1fe")
    public void removeObject(final SmObjectImpl newObject) {
        //this.cache.removeFromCache(newObject);
        this.cacheById.remove(newObject.getUuid());
        writeNameCache(newObject.getName()).remove(newObject);
    }

    @objid ("36dfc1b3-8117-4ded-a3d3-f4698ccacf2e")
    public void clear() {
        //this.cache = new MObjectCache(this.metamodel);
        this.cacheById = new ConcurrentHashMap<String, Boolean>().keySet(true);
        this.cacheByName = new ConcurrentHashMap<String, Set<MObject>>();
    }

    /**
     * Find model objects by name.
     * <p>
     * Look into the given model class and its subclasses if requested.
     *
     * @param cls a metamodel class
     * @param withSubClasses if true look into sub metaclasses hierarchy
     * @param name the searched element name
     * @return the found model objects that have the given name.
     */
    @objid ("90c37f6a-34a6-4f2d-8d14-282707b8245e")
    public Stream<? extends MObject> streamByName(final MClass cls, boolean withSubClasses, final String name) {
        Set<MObject> foundList = readNameCache(name);

        if (foundList==null || foundList.isEmpty())
            return Stream.empty();

        if (withSubClasses) {
            return foundList.stream().filter(o -> o.getMClass().hasBase(cls));
        } else {
            return foundList.stream().filter(o -> o.getMClass().equals(cls));
        }
    }

    @objid ("c8072f10-5246-442f-a0c9-5152798054e5")
    public boolean contains(MObject o) {
        return this.cacheById.contains(o.getUuid());
    }

}
