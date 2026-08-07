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
package org.modelio.archimate.exchange.service.utils;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.repository.IRepositorySupport;
import org.modelio.vcore.session.impl.CoreSession;
import org.modelio.vcore.session.impl.SmFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;

/**
 * Generic object factory.
 */
@objid ("9a1d86ba-96ae-4d83-985d-3b6910206b24")
public final class BaseFactory {
    @objid ("db9b5240-0277-46df-bb94-44287c91a325")
    private SmMetamodel metamodel;

    @objid ("cbb782b6-b635-4f4d-9e46-a1df6cde36cc")
    private IRepositorySupport repoSupport;

    @objid ("f0823aaa-6f44-4929-b71f-b3fbd00eb933")
    private SmFactory smFactory;

    @objid ("f23807e5-b09b-4c40-8fc2-423ef52c3c85")
    private ICoreSession session;

    /**
     * Initialize a generic factory.
     *
     * @param smFactory a core factory.
     * @param repoSupport a repository support.
     */
    @objid ("5039483d-9563-47b1-a49a-2ba14e79a4de")
    public BaseFactory(CoreSession session) {
        this.repoSupport = session.getRepositorySupport();
        this.smFactory = session.getSmFactory();
        this.metamodel = session.getMetamodel();
        this.session = session;

    }

    /**
     * Create an instance of 'metaclass' and define 'parent' as its composition owner using the dependency 'depName'.
     * The new object will belong to the same repository as the 'parent' object.
     *
     * @param metaclass a metamodel class java interface
     * @param parent the new element owner
     * @param depName the metamodel relation from the owner to the created element.
     * @return the created object
     */
    @objid ("a971cec8-8946-4712-a91c-251990e1248d")
    @SuppressWarnings("unchecked")
    public <T extends MObject> T createWithId(Class<T> metaclass, MObject parent, String depName, String id) {
        assert(id != null && !id.equals(""));

        MObject newObj = null;
        try{
          newObj = this.smFactory.createObject(this.metamodel.getMClass(metaclass), this.repoSupport.getRepository(parent),id);
        }catch(IllegalArgumentException e){
            MObject element = this.session.getModel().findById(metaclass,id);
            if(element != null && element.isDeleted() ){
                ((SmObjectImpl)element).getMetaOf().objUndeleted((SmObjectImpl)element);
                newObj = element;
            }else{
                newObj = this.smFactory.createObject(this.metamodel.getMClass(metaclass), this.repoSupport.getRepository(parent));
            }
        }

                ((SmObjectImpl) parent).appendDepVal((SmDependency) parent.getMClass().getDependency(depName), (SmObjectImpl) newObj);
        return (T) newObj;
    }

    /**
     * Create an instance of 'metaclass'. The new object will belong to the same repository as the 'referent' object. The 'referent'
     * object is NOT the composition owner of the created object.
     *
     * @param <T> the metaclass interface of the object to create.
     * @param metaclass the metaclass of the object to create.
     * @param referent the referent object
     * @
     * @return the created object
     */
    @objid ("a05fd6b6-2da8-4c08-a697-ff3f969e7e63")
    @SuppressWarnings("unchecked")
    public <T extends MObject> T createWithId(Class<T> metaclass, MObject referent, String id) {
        assert(id != null && !id.equals(""));

        MObject newObj = null;
        try{
            newObj = this.smFactory.createObject(this.metamodel.getMClass(metaclass), this.repoSupport.getRepository(referent),id);
          }catch(IllegalArgumentException e){
              MObject element = this.session.getModel().findById(metaclass,id);
              if(element != null && element.isDeleted() ){
                  ((SmObjectImpl)element).getMetaOf().objUndeleted((SmObjectImpl)element);
                  newObj = element;
              }else{
                 newObj = this.smFactory.createObject(this.metamodel.getMClass(metaclass), this.repoSupport.getRepository(referent));
             }
          }
        return (T) newObj;
    }

    /**
     * Create an instance of 'metaclass' and define 'parent' as its composition owner using the dependency 'depName'.
     * The new object will belong to the same repository as the 'parent' object.
     *
     * @param metaclass a metamodel class java interface
     * @param parent the new element owner
     * @param depName the metamodel relation from the owner to the created element.
     * @return the created object
     */
    @objid ("d3dfad3d-dc7c-4086-a543-ca9938dd1f93")
    @SuppressWarnings("unchecked")
    public <T extends MObject> T create(Class<T> metaclass, MObject parent, String depName) {
        MObject newObj = this.smFactory.createObject(this.metamodel.getMClass(metaclass), this.repoSupport.getRepository(parent));
        ((SmObjectImpl) parent).appendDepVal((SmDependency) parent.getMClass().getDependency(depName), (SmObjectImpl) newObj);
        return (T) newObj;
    }

    /**
     * Create an instance of 'metaclass'. The new object will belong to the same repository as the 'referent' object. The 'referent'
     * object is NOT the composition owner of the created object.
     *
     * @param <T> the metaclass interface of the object to create.
     * @param metaclass the metaclass of the object to create.
     * @param referent the referent object
     * @
     * @return the created object
     */
    @objid ("75c164f3-af0a-4ba5-8ce1-9f2a213df8c5")
    @SuppressWarnings("unchecked")
    public <T extends MObject> T create(Class<T> metaclass, MObject referent) {
        return (T) this.smFactory.createObject(this.metamodel.getMClass(metaclass), this.repoSupport.getRepository(referent));
    }

}
