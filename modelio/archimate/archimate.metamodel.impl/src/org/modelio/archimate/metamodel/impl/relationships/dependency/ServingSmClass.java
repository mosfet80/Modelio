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
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f0c9dbca-86c2-439b-b733-f92f58bf7d81")
public class ServingSmClass extends DependencyRelationshipSmClass {
    @objid ("6fd2a209-097b-4a44-a489-5b9c0342d1b1")
    public ServingSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("56e6809a-b377-47d5-92a2-267083b7ea68")
    @Override
    public String getName() {
        return "Serving";

    }

    @objid ("bf49492e-6c08-4985-baff-ceec290791d8")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("d2d46457-8d74-4b18-8292-e1794a3edc00")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Serving.class;

    }

    @objid ("66d85234-3b77-4546-8017-2f8487b6cc6d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("adb49f73-f376-4af2-817a-4fcf3744074f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("46974a30-0cb0-46b1-9b8e-8a143ce89dc4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(DependencyRelationship.MQNAME);
        this.registerFactory(new ServingObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("82d16909-d1a8-4825-a0f2-3af9f3e3dcfa")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("fb23baee-5316-4d34-9439-eebb9705743c")
    private static class ServingObjectFactory implements ISmObjectFactory {
        @objid ("7b9f8373-b029-47a4-88d1-f4a056e23332")
        private ServingSmClass smClass;

        @objid ("02a1a39c-8244-4d0f-854b-3831cdb52b4b")
        public ServingObjectFactory(ServingSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("eacaddf5-2ba9-4ed7-944a-17aef4a1c44a")
        @Override
        public ISmObjectData createData() {
            return new ServingData(this.smClass);
        }

        @objid ("c95d44d6-68b1-42b2-b1a2-c6cd1f925da9")
        @Override
        public SmObjectImpl createImpl() {
            return new ServingImpl();
        }

    }

}
