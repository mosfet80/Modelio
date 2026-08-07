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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.uml.behavior.usecaseModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.GeneralClassSmClass;
import org.modelio.metamodel.uml.behavior.usecaseModel.Actor;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("75ac7365-5024-4e1f-a996-4d7ea2b787c3")
public class ActorSmClass extends GeneralClassSmClass {
    @objid ("08ece71a-a9c5-4745-872e-619bd7dccc4c")
    public ActorSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("efdcc6da-f52e-4ecc-93ac-a3f7da710fba")
    @Override
    public String getName() {
        return "Actor";

    }

    @objid ("fb340c64-10ec-4d29-8dd3-36c7aa462fb4")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c9b6858b-af8a-41aa-a185-c82da78007c0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Actor.class;

    }

    @objid ("9136956f-e9d4-4b1e-9ce1-c3a0654bb99d")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("a74ead10-580c-4090-b044-5037b27cf210")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d022e221-73e7-4756-81f3-4d30c40e4563")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new ActorObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("78e4c876-bf88-47ec-8145-c5d5111b3b6b")
    private static class ActorObjectFactory implements ISmObjectFactory {
        @objid ("ac510491-eb11-4170-88e1-b148558d0937")
        private ActorSmClass smClass;

        @objid ("a09a6807-66d5-4b3b-8a5b-a0245667ee6a")
        public ActorObjectFactory(ActorSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f34079be-13e6-4003-b98a-7fa017b98ab4")
        @Override
        public ISmObjectData createData() {
            return new ActorData(this.smClass);
        }

        @objid ("b3cc9318-3d24-4687-9991-c317fc73bf5f")
        @Override
        public SmObjectImpl createImpl() {
            return new ActorImpl();
        }

    }

}
