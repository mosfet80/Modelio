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
package org.modelio.archimate.metamodel.impl.layers.business.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessInternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalActiveStructureElement;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("9a5c34d1-a6fb-473a-9cb9-f8d70cae6352")
public class BusinessRoleSmClass extends BusinessInternalActiveStructureElementSmClass {
    @objid ("44a30519-09b6-498d-ba76-d74be532ceef")
    public BusinessRoleSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("546fb286-1072-4242-bb23-9cc312cb24c5")
    @Override
    public String getName() {
        return "BusinessRole";

    }

    @objid ("864a2693-48b8-4d7b-bc07-b24da2321916")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("ff260fe7-a80d-4aaa-b2ab-70f8e9e26bb1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessRole.class;

    }

    @objid ("bad11efb-fc95-4472-aa57-79f8af5bb5b1")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("8c4b5c5a-31db-4bd4-a2bf-5fc60bb89171")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("c24eda5a-94ac-4c34-bcff-24078a29a3c7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessInternalActiveStructureElement.MQNAME);
        this.registerFactory(new BusinessRoleObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("9619bac9-2ffe-437b-8570-5cbc5f9f131a")
    private static class BusinessRoleObjectFactory implements ISmObjectFactory {
        @objid ("0fc614af-1297-4ff3-b496-38f3fd736869")
        private BusinessRoleSmClass smClass;

        @objid ("6003126f-d09f-40e6-9ad7-98a9838b3c24")
        public BusinessRoleObjectFactory(BusinessRoleSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d37dd8ae-c084-493d-935e-1cca0b9a8603")
        @Override
        public ISmObjectData createData() {
            return new BusinessRoleData(this.smClass);
        }

        @objid ("b831731f-a548-4729-acf3-c1d287eefb4d")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessRoleImpl();
        }

    }

}
