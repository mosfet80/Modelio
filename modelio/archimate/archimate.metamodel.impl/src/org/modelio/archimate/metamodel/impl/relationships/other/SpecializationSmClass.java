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
package org.modelio.archimate.metamodel.impl.relationships.other;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.other.OtherRelationship;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("42dd2792-6bc2-4123-9de4-efdeea8e140e")
public class SpecializationSmClass extends OtherRelationshipSmClass {
    @objid ("0d788538-4b5d-42e2-ae14-13a489ee48a7")
    public SpecializationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("54947399-fca1-47b8-a4b8-e50e894bb51d")
    @Override
    public String getName() {
        return "Specialization";

    }

    @objid ("6ed7a576-69fb-4818-afb0-c57421112f62")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("93fc2d32-fc95-4f26-b47f-6dca717a0cea")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Specialization.class;

    }

    @objid ("c85c6c30-66f3-4855-8a41-b6cf422e147a")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("9b270a1e-0d1a-42e9-b3b1-50020fdd34f3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8de2881d-56c1-4fab-ac29-0905b9a8d773")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(OtherRelationship.MQNAME);
        this.registerFactory(new SpecializationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("9f8ad74d-290d-44e8-93e1-af4f13a0f97f")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("75506124-1ae8-4ffa-9402-10cb1ced1dc6")
    private static class SpecializationObjectFactory implements ISmObjectFactory {
        @objid ("21989184-d90e-490b-ad99-855bde53dcf1")
        private SpecializationSmClass smClass;

        @objid ("ff43295b-3413-4ca1-89a9-e419aebb43b2")
        public SpecializationObjectFactory(SpecializationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e6370d12-26c2-4c23-aeef-aa239264d5ff")
        @Override
        public ISmObjectData createData() {
            return new SpecializationData(this.smClass);
        }

        @objid ("093277f4-50c5-4eb0-b293-db3f94f3abf6")
        @Override
        public SmObjectImpl createImpl() {
            return new SpecializationImpl();
        }

    }

}
