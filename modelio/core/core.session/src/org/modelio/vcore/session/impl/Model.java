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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.UnknownMetaclassException;
import org.modelio.vcore.session.api.model.IMObjectFilter;
import org.modelio.vcore.session.api.model.IModel;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.session.api.repository.IRepositorySupport;
import org.modelio.vcore.session.impl.cache.CacheManager;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vcore.smkernel.meta.SmClass;

/**
 * Implementation of {@link IModel}.
 */
@objid ("008c5258-5f00-10c8-842f-001ec947cd2a")
public class Model implements IModel {
    @objid ("008c5c1c-5f00-10c8-842f-001ec947cd2a")
    private GenericFactory genericFactory;

    @objid ("008c706c-5f00-10c8-842f-001ec947cd2a")
    private final CacheManager cacheManager;

    @objid ("008c8052-5f00-10c8-842f-001ec947cd2a")
    private final IRepositorySupport repositorySupport;

    @objid ("feaf1ad9-3ecf-457d-9f9f-f1e7a08f0f3d")
    private MMetamodel metamodel;

    @objid ("008c8f7a-5f00-10c8-842f-001ec947cd2a")
    Model(CacheManager cacheManager, IRepositorySupport repositorySupport, MMetamodel metamodel) {
        this.cacheManager = cacheManager;
        this.repositorySupport = repositorySupport;
        this.metamodel = metamodel;
    }

    @objid ("003a9062-61a6-10c8-842f-001ec947cd2a")
    @SuppressWarnings("unchecked")
    @Override
    public <T extends MObject> Collection<T> findByAtt(Class<T> metaclass, final String att, Object val) {
        MClass cls = this.metamodel.getMClass(metaclass);
        return (Collection<T>) findByAtt(cls, att, val);
    }

    @objid ("008d50c2-5f00-10c8-842f-001ec947cd2a")
    @Override
    public Collection<? extends MObject> findByAtt(MClass cls, final String att, Object val) {
        return findByAtt(cls, true, att, val);
    }

    @objid ("003a3cb6-61a6-10c8-842f-001ec947cd2a")
    @Override
    public <T extends MObject> Collection<T> findByClass(Class<T> metaclass) {
        return findByClass(metaclass, true);
    }

    @objid ("008d9f50-5f00-10c8-842f-001ec947cd2a")
    @Override
    public Collection<? extends MObject> findByClass(MClass cls, boolean withSubClasses) {
        Set<MObject> results = new HashSet<>();

        SmClass smCls = (SmClass) cls;
        for (IRepository base : this.repositorySupport.getRepositories()) {
            results.addAll(base.findByClass(smCls, withSubClasses));
        }

        // Exclude deleted objects
        results.removeAll(this.cacheManager.getDeletedObjects());
        return results;
    }

    /**
     * Get all the model objects of a given class, with the subclasses if requested.
     * Uses the Java 9 Stream API.
     * The method may returns immediately depending on the implementation.
     * <p>
     * The returned stream must be closed and should be used in a try-with-resource statement.
     *
     * @param metaclass a metamodel class.
     * @param withSubClasses if true include sub classes hierarchy
     * @return a Stream with the model objects .
     * @deprecated Beta stage, may change or disappear without warning .
     * @since 6.0.1 04/07/2024
     */
    @objid ("2630433a-9ded-48ea-8e18-55a3ad5bf4b5")
    @Deprecated(since = "6.0.1")
    public <T extends MObject> Stream<T> streamByClass(Class<T> metaclass, boolean withSubClasses) {
        MClass cls = this.metamodel.getMClass(metaclass);
        @SuppressWarnings ("unchecked")
        Stream<T> ret = (Stream<T>) streamByClass(cls, withSubClasses);
        return ret;
    }

    /**
     * Get all the model objects of a given class, with the subclasses if requested.
     * Uses the Java 9 Stream API.
     * The method may returns immediately depending on the implementation.
     * <p>
     * The returned stream must be closed and should be used in a try-with-resource statement.
     *
     * @param metaclass a metamodel class.
     * @param withSubClasses if true include sub classes hierarchy
     * @return a Stream with the model objects .
     * @deprecated Beta stage, may change or disappear without warning .
     * @since 6.0.1 04/07/2024
     */
    @objid ("0f9f23de-2a4d-41f1-a1d6-0a80477bb092")
    @Deprecated(since = "6.0.1")
    public Stream<? extends MObject> streamByClass(MClass metaclass, boolean withSubClasses) {
        SmClass smCls = (SmClass) metaclass;

        return this.repositorySupport.getRepositories()
        .stream()
        .flatMap(base -> base.streamByClass(smCls, withSubClasses)
                .filter(o -> !this.cacheManager.getDeletedObjects().contains(o) /* Exclude deleted objects */)
                );
    }

    @objid ("f2266edb-0fbb-40ad-aff0-13b50c4d7355")
    @SuppressWarnings("unchecked")
    @Override
    public <T extends MObject> Stream<T> streamByName(Class<T> metaclass, boolean withSubClasses, String name) {
        MClass cls = this.metamodel.getMClass(metaclass);
        return (Stream<T>) streamByName(cls, withSubClasses, name);
    }

    @objid ("504ae478-6df6-4f52-8341-0ef8bf536e7a")
    @Override
    public Stream<? extends MObject> streamByName(MClass metaclass, boolean withSubClasses, String name) {
        SmClass smCls = (SmClass) metaclass;

        return this.repositorySupport.getRepositories()
        .stream()
        .flatMap(base -> base.streamByName(smCls, withSubClasses, name)
                .filter(o -> !this.cacheManager.getDeletedObjects().contains(o) /* Exclude deleted objects */)
                );
    }

    @objid ("654bf94c-a430-4383-be55-cd077daf2b4e")
    @Override
    public <T extends MObject> Collection<T> findByName(Class<T> metaclass, boolean withSubClasses, String name) {
        try (Stream<T> stream = streamByName(metaclass, withSubClasses, name)) {
            return stream.toList();
        }
    }

    @objid ("b73dcbb4-98fb-4c60-a24c-5c672c37f65c")
    @Override
    public Collection<? extends MObject> findByName(MClass metaclass, boolean withSubClasses, String name) {
        try (Stream<? extends MObject> stream = streamByName(metaclass, withSubClasses, name)) {
            return stream.toList();
        }
    }

    @objid ("003afa84-61a6-10c8-842f-001ec947cd2a")
    @SuppressWarnings("unchecked")
    @Override
    public <T extends MObject> T findById(Class<T> metaclass, final String siteIdentifier) {
        MClass cls = this.metamodel.getMClass(metaclass);
        return (T) findById(cls, siteIdentifier);
    }

    @objid ("008dd3f8-5f00-10c8-842f-001ec947cd2a")
    @Override
    public SmObjectImpl findById(MClass cls, final String siteIdentifier) {
        // 1) First look in the cache
        SmObjectImpl ret = this.cacheManager.findById(cls, siteIdentifier);
        if (ret != null)
            return ret;

        // 2) Look for cache record telling it is absent
        if (this.cacheManager.hasNotFound(cls, siteIdentifier))
            return null;

        // 3) Search in all repositories
        SmClass smCls = (SmClass) cls;
        for (IRepository base : this.repositorySupport.getRepositories()) {
            ret = base.findById(smCls, siteIdentifier);
            if (ret != null && ret.isValid()) {
                return ret;
            }
        }

        // 4) Not found : register it as "not found" in the cache and return null.
        this.cacheManager.addNotFound(cls, siteIdentifier);

        return null;
    }

    @objid ("008e0a44-5f00-10c8-842f-001ec947cd2a")
    @Override
    public MObject findByRef(MRef ref) throws UnknownMetaclassException {
        MClass cls = this.metamodel.getMClass(ref.mc);
        if (cls == null) {
            throw new UnknownMetaclassException(ref.mc);
        }
        return findById(cls, ref.uuid);
    }

    @objid ("008e33a2-5f00-10c8-842f-001ec947cd2a")
    @Override
    public GenericFactory getGenericFactory() {
        // Automatically generated method. Please delete this comment before
        // entering specific code.
        return this.genericFactory;
    }

    @objid ("8e68d369-4469-11e2-91c9-001ec947ccaf")
    void setGenericFactory(GenericFactory genericFactory) {
        this.genericFactory = genericFactory;
    }

    @objid ("503ce30f-7c5a-4241-a177-a244eb315258")
    @Override
    public Collection<? extends MObject> findByAtt(MClass cls, String att, Object val, IMObjectFilter filter) {
        final Collection<? extends MObject> rawResults = findByAtt(cls, true, att, val);
        if (filter != null) {
            List<MObject> filteredResults = new ArrayList<>(rawResults.size());
            for (MObject obj : rawResults) {
                if (filter.accept(obj)) {
                    filteredResults.add(obj);
                }
            }
            return filteredResults;
        } else {
            return rawResults;
        }
    }

    @objid ("b82ef254-b434-40a2-a065-444a89a3ee76")
    @Override
    public Collection<? extends MObject> findByClass(MClass cls, IMObjectFilter filter) {
        final Collection<? extends MObject> rawResults = findByClass(cls, true);
        if (filter != null) {
            List<MObject> filteredResults = new ArrayList<>(rawResults.size());
            for (MObject obj : rawResults) {
                if (filter.accept(obj)) {
                    filteredResults.add(obj);
                }
            }
            return filteredResults;
        } else {
            return rawResults;
        }
    }

    @objid ("3f9628df-81bd-4c13-858f-b851846ffe91")
    @Override
    public MObject findById(MClass cls, String siteIdentifier, IMObjectFilter filter) {
        final MObject rawResult = findById(cls, siteIdentifier);
        if (rawResult != null) {
            return (filter == null) || filter.accept(rawResult) ? rawResult : null;
        }
        return rawResult;
    }

    @objid ("6cc8a793-b6e1-4456-8230-1d7c3123a03a")
    @Override
    public MObject findByRef(MRef ref, IMObjectFilter filter) throws UnknownMetaclassException {
        final MObject rawResult = findByRef(ref);
        return (filter == null) || filter.accept(rawResult) ? rawResult : null;
    }

    @objid ("e463195f-4c87-448a-b49c-962c2f94ab67")
    @Override
    public <T extends MObject> Collection<T> findByClass(Class<T> metaclass, IMObjectFilter filter) {
        final Collection<T> rawResults = findByClass(metaclass);
        if (filter != null) {
            List<T> filteredResults = new ArrayList<>(rawResults.size());
            for (T obj : rawResults) {
                if (filter.accept(obj)) {
                    filteredResults.add(obj);
                }
            }
            return filteredResults;
        } else {
            return rawResults;
        }
    }

    @objid ("6a8bfb6a-3ea1-4529-84d4-d905bffb07a9")
    @Override
    public <T extends MObject> Collection<T> findByAtt(Class<T> metaclass, String att, Object val, IMObjectFilter filter) {
        final Collection<T> rawResults = findByAtt(metaclass, att, val);
        if (filter != null) {
            List<T> filteredResults = new ArrayList<>(rawResults.size());
            for (T obj : rawResults) {
                if (filter.accept(obj)) {
                    filteredResults.add(obj);
                }
            }
            return filteredResults;
        } else {
            return rawResults;
        }
    }

    @objid ("9d88f704-17c0-4089-8c16-3c8b5a09e91c")
    @Override
    public <T extends MObject> T findById(Class<T> metaclass, String siteIdentifier, IMObjectFilter filter) {
        final T rawResult = findById(metaclass, siteIdentifier);
        if (rawResult != null) {
            return (filter == null) || filter.accept(rawResult) ? rawResult : null;
        }
        return rawResult;
    }

    @objid ("d77d671d-a596-453d-bc4b-6cfe72a6dca8")
    @Override
    @Deprecated
    public Collection<? extends MObject> findByAtt(MClass cls, boolean withSubClasses, String att, Object val) {
        try (Stream<? extends MObject> stream = streamByAtt(cls, withSubClasses, att, val)) {
        return stream.collect(Collectors.toSet());
        }
    }

    @objid ("a0130b39-c450-4032-8d07-6ac6947437e7")
    @Override
    public Stream<? extends MObject> streamByAtt(MClass cls, boolean withSubClasses, String att, Object val) {
        SmClass smCls = (SmClass) cls;

        return this.repositorySupport.getRepositories().stream()
        .flatMap(base -> base.streamByAtt(smCls, withSubClasses, att, val))
        .filter(o -> ! this.cacheManager.getDeletedObjects().contains(o)) // Exclude deleted objects
        ;
    }

    @objid ("eabe376f-7803-4657-8f0c-2c444cc34a6b")
    @Override
    @SuppressWarnings("unchecked")
    public <T extends MObject> Collection<T> findByClass(Class<T> metaclass, boolean withSubClasses) {
        MClass cls = this.metamodel.getMClass(metaclass);
        return (Collection<T>) findByClass(cls, withSubClasses);
    }

    @objid ("83727aa5-acfe-4a64-85b1-71d2f1664d19")
    @Override
    public Collection<? extends MObject> findByClass(MClass cls) {
        return findByClass(cls, true);
    }

}
