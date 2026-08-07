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

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Stream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.session.api.repository.IRepositorySupport;
import org.modelio.vcore.session.impl.storage.IModelLoader;
import org.modelio.vcore.session.impl.storage.memory.MemoryRepository;
import org.modelio.vcore.smkernel.IRepositoryObject;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

/**
 * Repository for objects that are not yet loaded.
 * <p>
 * Triggers object loading as soon as the object is accessed.
 * {@link IModelLoader} implementation is then expected to move the object to its real repository.
 * <p>
 * This repository officially stores nobody and all findXxx(...) methods will return no result.
 */
@objid ("6d22d61a-e244-4200-8a05-a13b75ec92e5")
class LazyLoadingRepository extends MemoryRepository {
    @objid ("77502223-548e-460c-8486-e98104d2dc58")
    private final IRepository shellRepository;

    @objid ("0f2048a4-790c-4bfc-86cd-817f9f439d0d")
    private final IRepositorySupport support;

    @objid ("2fb66315-34e4-41e1-9695-6168d6d63c16")
    public LazyLoadingRepository(IRepositorySupport support, IRepository shellRepository) {
        this.support = Objects.requireNonNull(support) ;
        this.shellRepository = Objects.requireNonNull(shellRepository);
    }

    @objid ("6caa4575-1bfe-4ced-99c9-58ea0c8ee0c5")
    @Override
    public void attModified(SmObjectImpl obj, SmAttribute att, Object oldVal) {
        triggerLoading(obj).attModified(obj, att, oldVal);
    }

    @objid ("b29207a8-c798-44a8-aac8-f44731517e7a")
    protected IRepositoryObject triggerLoading(final SmObjectImpl obj) {
        // this is expected to move the object to its owning repository.
        for (IRepository repository : this.support.getRepositories()) {
            if (repository==this)
                continue;

            SmObjectImpl found = repository.findById(obj.getClassOf(), obj.getUuid());
            if (found != null) {
                assert (found == obj) : String.format("%s Loaded a new %s (data=%s)\n\t instead of taking possession of %s (data=%s)", repository,found, found.getData(), obj, obj.getData());
                break;
            }
        }

        if (obj.getRepositoryObject() == this) {
            // Object not found, assign it to shell repository
            this.detach(obj);
            this.shellRepository.addObject(obj);
        }

        return obj.getRepositoryObject();
    }

    @objid ("784e5941-b639-4ea7-88a4-7182e108a2d5")
    @Override
    public void depValMoved(final SmObjectImpl obj, final SmDependency dep, final SmObjectImpl val) {
        triggerLoading(obj).depValMoved(obj, dep, val);
    }

    @objid ("2f48ad41-d020-4a32-abc9-8c1a40f01a5b")
    @Override
    public void addCreatedObject(SmObjectImpl newObject) {
        super.addCreatedObject(newObject);
        throw new IllegalStateException("New objects not expected to be added to this");
    }

    @objid ("9df36fbf-cd84-4c1f-83b6-6f1f387f2291")
    @Override
    public void depValAppended(SmObjectImpl obj, SmDependency dep, SmObjectImpl val) {
        triggerLoading(obj).depValAppended(obj, dep, val);
    }

    @objid ("6faa8f68-de48-4058-9aef-18657845aaba")
    @Override
    public void depValErased(SmObjectImpl obj, SmDependency dep, SmObjectImpl val) {
        triggerLoading(obj).depValErased(obj, dep, val);
    }

    @objid ("dd48d532-429c-46e9-9e10-2d88e62621e4")
    @Override
    public Stream<? extends MObject> streamByClass(SmClass cls, boolean withSubClasses) {
        return Stream.empty();
    }

    @objid ("e83e0386-7c6f-48c6-af23-7be6442e6bc3")
    @Override
    public Stream<? extends MObject> streamByAtt(SmClass cls, boolean withSubClasses, String att, Object val) {
        return Stream.empty();
    }

    @objid ("b4e3f5c4-3aa3-468b-a898-9af0cc6310d8")
    @Override
    public Stream<? extends MObject> streamByName(SmClass cls, boolean withSubClasses, String name) {
        return Stream.empty();
    }

    @objid ("94ed7c3b-cab8-42b6-a732-3a93176a17b0")
    @Override
    public boolean isStatusFullyLoaded(SmObjectImpl obj) {
        return triggerLoading(obj).isStatusFullyLoaded(obj);
    }

    @objid ("b163f9cb-599c-4e3e-9a66-dc04e41928bf")
    @Override
    public Collection<MObject> findByClass(SmClass cls, boolean withSubClasses) {
        return Collections.emptySet();
    }

    @objid ("94f3be8a-6c40-45ce-8ee9-94fccc038c58")
    @Override
    public boolean isAttLoaded(SmObjectImpl obj, SmAttribute att) {
        return false;
    }

    @objid ("b075f363-d7d0-4332-b352-ee2ff45b6802")
    @Override
    public boolean isDepLoaded(SmObjectImpl obj, SmDependency dep) {
        return false;
    }

    @objid ("b451abd2-5c1f-47b5-83c3-975c3adbd30d")
    @Override
    public boolean isDirty() {
        return false;
    }

    @objid ("0dfd344b-bc7e-4a7b-a707-f8db40f15eb4")
    @Override
    public boolean isDirty(SmObjectImpl obj) {
        return false;
    }

    @objid ("ae843cb2-63c1-47ed-b6b1-5dc182d66bed")
    @Override
    public void loadAtt(SmObjectImpl obj, SmAttribute att) {
        triggerLoading(obj).loadAtt(obj, att);
    }

    @objid ("b25b202a-41dc-408d-9f87-f32bf7032bd4")
    @Override
    public void loadDep(SmObjectImpl obj, SmDependency dep) {
        triggerLoading(obj).loadDep(obj, dep);
    }

    @objid ("4c28f1d0-1662-490b-a0cc-039caf633a01")
    @Override
    public boolean isStored(SmObjectImpl val) {
        return false;
    }

}
