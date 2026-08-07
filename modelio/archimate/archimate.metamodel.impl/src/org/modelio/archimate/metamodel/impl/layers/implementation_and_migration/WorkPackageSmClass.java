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
package org.modelio.archimate.metamodel.impl.layers.implementation_and_migration;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.BehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("89d47da3-2122-408e-aebc-fa4b6d07e833")
public class WorkPackageSmClass extends BehaviorElementSmClass {
    @objid ("ed0a31c7-3aca-4b57-b575-cda0f16f611f")
    public WorkPackageSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9fd6b7ce-27d7-44e2-9f9e-20b158040e9e")
    @Override
    public String getName() {
        return "WorkPackage";

    }

    @objid ("ab7adfa7-d9eb-4e52-b1a6-719587d2ca70")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("4ad1dbdf-a2e1-4abe-a444-e7af1abdc7fa")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return WorkPackage.class;

    }

    @objid ("78a708ee-3bbf-4d92-a76d-9d9e20326e40")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("70640d83-0d6e-41b9-b4a0-e464f8ba98e5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("230fe86a-49b8-4b0a-bee2-9d11ad526b8d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorElement.MQNAME);
        this.registerFactory(new WorkPackageObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("cb0d9c5d-5bf1-4211-854f-52b772b6a23e")
    private static class WorkPackageObjectFactory implements ISmObjectFactory {
        @objid ("2de10413-bd65-4a72-9329-ab8cba4294d7")
        private WorkPackageSmClass smClass;

        @objid ("3f776329-9572-4a84-a448-c23949379e91")
        public WorkPackageObjectFactory(WorkPackageSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c4f8e5ca-678c-4237-bebb-b967a2700403")
        @Override
        public ISmObjectData createData() {
            return new WorkPackageData(this.smClass);
        }

        @objid ("a514b51b-42d6-4c38-b3ff-43a9602523af")
        @Override
        public SmObjectImpl createImpl() {
            return new WorkPackageImpl();
        }

    }

}
