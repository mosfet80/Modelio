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
package org.modelio.archimate.metamodel.impl.layers.application.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c2eef6d1-e5ad-425d-bc79-474923a5f3da")
public class ApplicationComponentSmClass extends ApplicationInternalActiveStructureElementSmClass {
    @objid ("3ed5e61a-7ae3-45db-a2ff-0bb6d7ce4034")
    public ApplicationComponentSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("dd63e65d-e410-4850-9656-45254518d081")
    @Override
    public String getName() {
        return "ApplicationComponent";

    }

    @objid ("dad2ce75-a3c3-4aec-bf2d-d851503fbb71")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("6faecc17-a681-425a-884a-c251f0caea38")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationComponent.class;

    }

    @objid ("1f9e3ec2-3559-4f37-bf61-fc3fb337d29f")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("d2581af0-7cb2-4169-8f1d-0599cb802cfb")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7f86867c-fdb9-4249-9f59-37dbae6b123e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ApplicationInternalActiveStructureElement.MQNAME);
        this.registerFactory(new ApplicationComponentObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f0878a59-ea3c-410f-a012-432c2d5b91d7")
    private static class ApplicationComponentObjectFactory implements ISmObjectFactory {
        @objid ("aa9b4801-6afe-46e9-a15d-40672a9443e6")
        private ApplicationComponentSmClass smClass;

        @objid ("0ea0e39c-f7d5-46b5-a535-18486583ac55")
        public ApplicationComponentObjectFactory(ApplicationComponentSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("785bc9d2-c0cf-43d9-8637-b2ad25aeba24")
        @Override
        public ISmObjectData createData() {
            return new ApplicationComponentData(this.smClass);
        }

        @objid ("a5e05706-dc2c-4992-96bd-8f985c725a17")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationComponentImpl();
        }

    }

}
