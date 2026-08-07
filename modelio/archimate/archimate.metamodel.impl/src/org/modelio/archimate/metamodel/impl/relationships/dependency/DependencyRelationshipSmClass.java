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
/* WARNING: GENERATED FILE -  DO NOT EDIT
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.relationships.dependency;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.impl.core.RelationshipSmClass;
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("7324d6c3-4ede-42f8-a884-9c972454e830")
public class DependencyRelationshipSmClass extends RelationshipSmClass {
    @objid ("6793f086-d11f-4733-b2c5-16f75b6ac805")
    public DependencyRelationshipSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1f471e2a-75bf-4f08-9c0b-eac565b552fe")
    @Override
    public String getName() {
        return "DependencyRelationship";

    }

    @objid ("66e22b22-8c31-4fb9-a0cd-783d8fa40e0c")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("70c11afc-3741-4934-ae33-a55405ccdfdf")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DependencyRelationship.class;

    }

    @objid ("c967b166-d142-4c69-868b-c55807c207d5")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("62862eda-1dbf-4555-8d28-498bb9f1d724")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("76e679c9-c97c-403c-b27e-0b4a422de576")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Relationship.MQNAME);
        this.registerFactory(new DependencyRelationshipObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("92283fa3-cdc6-4b00-b4de-276638f0b729")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("2922e6d5-a269-467a-81f8-388e99587b33")
    private static class DependencyRelationshipObjectFactory implements ISmObjectFactory {
        @objid ("11bcb191-50ee-4bfa-8e24-82144c3e1bb1")
        private DependencyRelationshipSmClass smClass;

        @objid ("adcc3bd5-2017-4340-8c89-fc8e7afc6258")
        public DependencyRelationshipObjectFactory(DependencyRelationshipSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e3b52778-ef89-4fb1-abb0-e94792747aee")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("5b599d7d-08ef-40fd-b9ec-a05be57e5ee4")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
