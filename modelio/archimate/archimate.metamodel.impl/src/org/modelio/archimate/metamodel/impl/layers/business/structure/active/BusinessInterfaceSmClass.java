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
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessInterface;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("e9a816d7-0235-4eb3-ae08-320c11279a3b")
public class BusinessInterfaceSmClass extends ExternalActiveStructureElementSmClass {
    @objid ("90995b13-3bc9-4951-8d42-4c69c0087b99")
    public BusinessInterfaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9e54e18e-7e83-472e-ab47-2e471120231f")
    @Override
    public String getName() {
        return "BusinessInterface";

    }

    @objid ("9fa5270a-ceca-4b17-ac87-d7f482c14d15")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("977f9619-c26a-4441-9e24-b3efd2df3881")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessInterface.class;

    }

    @objid ("83a546e6-40ef-4c8e-8097-e51a1f81d079")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("cbad624c-1cc5-48e5-958d-8eb4788233d3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("25ee5e51-9ba6-4821-a13c-c5ed86fb81d3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ExternalActiveStructureElement.MQNAME);
        this.registerFactory(new BusinessInterfaceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("6d1e7c29-a1e2-48db-9680-b44f33b81cae")
    private static class BusinessInterfaceObjectFactory implements ISmObjectFactory {
        @objid ("9925be9b-2198-4bce-b24b-cb4f1c7645ff")
        private BusinessInterfaceSmClass smClass;

        @objid ("95830de0-f91e-42ec-b158-8a81ff6cdb29")
        public BusinessInterfaceObjectFactory(BusinessInterfaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("db55624e-4e65-4ad8-8c16-546109240ddc")
        @Override
        public ISmObjectData createData() {
            return new BusinessInterfaceData(this.smClass);
        }

        @objid ("a2f65ed9-2b4e-4273-8f94-49cb32ee63f1")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessInterfaceImpl();
        }

    }

}
