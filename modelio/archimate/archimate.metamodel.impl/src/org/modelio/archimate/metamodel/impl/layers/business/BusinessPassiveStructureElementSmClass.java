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
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.PassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessPassiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a776145e-2f66-49bf-b49f-a6ba797ed168")
public class BusinessPassiveStructureElementSmClass extends PassiveStructureElementSmClass {
    @objid ("ac53e701-3b66-4ef9-bbc7-0f49ea8a8357")
    public BusinessPassiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("07f6adda-ee9c-424e-b049-347e7ddc3c57")
    @Override
    public String getName() {
        return "BusinessPassiveStructureElement";

    }

    @objid ("1941c3a8-0002-4b44-8533-8f3a9075e7b1")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("e2d73cae-39d5-47e6-88c4-15e0978e1d82")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessPassiveStructureElement.class;

    }

    @objid ("080631a7-bb40-4c89-84b0-285ac6f5af88")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("848ee864-d8b3-4e78-a026-4efc0f8db2b9")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("058d2cd2-cdaf-406d-bdf5-f149ed2a393f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(PassiveStructureElement.MQNAME);
        this.registerFactory(new BusinessPassiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("11ac968d-bc0f-4c2d-8d93-4d0a030cb633")
    private static class BusinessPassiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("ff3638eb-5d5a-453b-80de-f4f2ec55fad7")
        private BusinessPassiveStructureElementSmClass smClass;

        @objid ("bbd7245e-1bbf-413d-a02b-de2a87dd3c40")
        public BusinessPassiveStructureElementObjectFactory(BusinessPassiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("46a97478-5272-40b7-b072-24e83e55c6a8")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("861726a6-d1db-4ec2-baa1-396a0c18e830")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
