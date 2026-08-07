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
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.archimate.metamodel.impl.core.generic.EventSmClass;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1bd2fdbb-3f59-4765-ad58-b58a4615289a")
public class BusinessEventSmClass extends EventSmClass {
    @objid ("f20ebebf-8c47-4f02-a246-d0d4d1b69691")
    public BusinessEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("2de4a725-7796-4ec9-a0f3-465142a2584f")
    @Override
    public String getName() {
        return "BusinessEvent";

    }

    @objid ("87af3387-83fe-42bd-b36e-a72c8e9dce46")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("4bb4fd5c-6c13-483d-be4b-9d9a8c30142b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessEvent.class;

    }

    @objid ("bd710b72-c4fe-4b72-b312-9ae751df687e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("62ee354e-9902-4eba-a12e-593947fd6a03")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("95bb9ca9-c186-471b-a939-11349daa47cf")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Event.MQNAME);
        this.registerFactory(new BusinessEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c3132518-7cc7-4320-be3a-304117531eb1")
    private static class BusinessEventObjectFactory implements ISmObjectFactory {
        @objid ("8330c7f9-2c70-4b41-89e8-1285a2aef3a6")
        private BusinessEventSmClass smClass;

        @objid ("29c8547a-382a-43b8-a753-7dd1e85d4eb6")
        public BusinessEventObjectFactory(BusinessEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9234b6ae-5cba-456c-acf3-952ab5d95e66")
        @Override
        public ISmObjectData createData() {
            return new BusinessEventData(this.smClass);
        }

        @objid ("4c1e80b6-5ce5-4da6-a1dd-aef6a9e6f48b")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessEventImpl();
        }

    }

}
