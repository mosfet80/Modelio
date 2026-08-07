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
package org.modelio.archimate.metamodel.impl.layers.business.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessInternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessInteraction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("eda1463a-a256-49e5-9e23-f9fd1586ceee")
public class BusinessInteractionSmClass extends BusinessInternalBehaviorElementSmClass {
    @objid ("ee914cf4-6cfb-4a62-949b-955cfe48ccf7")
    public BusinessInteractionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d402852d-b721-41c7-9e14-4cb14ffa959a")
    @Override
    public String getName() {
        return "BusinessInteraction";

    }

    @objid ("bb108eaf-b212-4075-9f1f-5e98b2f73c45")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("4b8e3d75-8da0-4a30-9b2f-2a84824cf602")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessInteraction.class;

    }

    @objid ("ed2adb65-5155-4fce-b87a-143ea0b14451")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("9455a1d0-8176-48bd-9c39-33455426883b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7406e874-a742-498a-9945-f9c45125fec0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessInternalBehaviorElement.MQNAME);
        this.registerFactory(new BusinessInteractionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("9e6316b9-fbd0-413f-9baf-7bc0af9a8125")
    private static class BusinessInteractionObjectFactory implements ISmObjectFactory {
        @objid ("cc1b60df-680c-48a4-a140-595222432495")
        private BusinessInteractionSmClass smClass;

        @objid ("0e9f1947-b566-4d0d-8071-1bcabd6a8af7")
        public BusinessInteractionObjectFactory(BusinessInteractionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("40ff68fd-5ca5-4820-9980-d72a5cd4951a")
        @Override
        public ISmObjectData createData() {
            return new BusinessInteractionData(this.smClass);
        }

        @objid ("8dc48e8f-001d-45e4-bcc7-2000bf951c56")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessInteractionImpl();
        }

    }

}
