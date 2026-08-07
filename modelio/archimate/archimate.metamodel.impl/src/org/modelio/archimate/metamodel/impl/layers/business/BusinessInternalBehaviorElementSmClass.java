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
package org.modelio.archimate.metamodel.impl.layers.business;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.InternalBehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.InternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("62c07212-83a6-4a0b-9fb0-34e3f1b3574f")
public class BusinessInternalBehaviorElementSmClass extends InternalBehaviorElementSmClass {
    @objid ("2fe25155-00ed-4573-a935-7d58d47ee5ca")
    public BusinessInternalBehaviorElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0944bc0a-8bec-44fd-9576-2b415db0285b")
    @Override
    public String getName() {
        return "BusinessInternalBehaviorElement";

    }

    @objid ("1b357c25-8e33-440c-9059-b42a8502a6bb")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("34883fe2-ebdd-4fba-8207-1296b87166cc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessInternalBehaviorElement.class;

    }

    @objid ("14802787-470d-4841-bd65-9850fb09c6de")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("548d52f4-7e0c-453f-97a6-79e1a576cfde")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("17a7d87f-b4d3-4c05-9eb0-e26a2485c851")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InternalBehaviorElement.MQNAME);
        this.registerFactory(new BusinessInternalBehaviorElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f7df6e6e-cbca-44d7-bcc4-f433252f6351")
    private static class BusinessInternalBehaviorElementObjectFactory implements ISmObjectFactory {
        @objid ("32cf67cb-4a18-4d3f-b906-6953038e1333")
        private BusinessInternalBehaviorElementSmClass smClass;

        @objid ("131d70f4-510f-4ded-9023-faf47502d01f")
        public BusinessInternalBehaviorElementObjectFactory(BusinessInternalBehaviorElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9123831e-8240-4f40-a934-9a68b8f32edd")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("68880b9a-77af-4572-823e-9ee7188df0bb")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
