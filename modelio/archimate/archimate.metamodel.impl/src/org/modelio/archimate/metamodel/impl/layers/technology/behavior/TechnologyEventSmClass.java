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
package org.modelio.archimate.metamodel.impl.layers.technology.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.archimate.metamodel.impl.core.generic.EventSmClass;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("5e2e7d19-4bf8-4ce2-8cc4-550abc9cd1b5")
public class TechnologyEventSmClass extends EventSmClass {
    @objid ("bd14a055-2150-409b-81b3-55285208c01e")
    public TechnologyEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("509649af-e1b5-4ee3-9b2d-267eb21c8b2b")
    @Override
    public String getName() {
        return "TechnologyEvent";

    }

    @objid ("a2be0478-765c-460c-b13e-33bd46a226d5")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("2f28dfb0-b896-44cf-b555-0dd6fe1a2444")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyEvent.class;

    }

    @objid ("a70ed4fb-4071-436f-9403-1a0862ed0d95")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("e28ca842-f521-4afb-8e62-870c817cbc19")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("522e1036-9833-43e0-b866-9002103a8fbc")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Event.MQNAME);
        this.registerFactory(new TechnologyEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("dcf5414c-21b3-403c-8ad4-af131bc4198d")
    private static class TechnologyEventObjectFactory implements ISmObjectFactory {
        @objid ("b6adcea7-2660-410c-a2dc-c67d4324d9dd")
        private TechnologyEventSmClass smClass;

        @objid ("3d1a3928-b144-4037-9930-f29ec3c2356c")
        public TechnologyEventObjectFactory(TechnologyEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ef1cef3b-fa29-43e6-b566-e938f6ec5f26")
        @Override
        public ISmObjectData createData() {
            return new TechnologyEventData(this.smClass);
        }

        @objid ("91ad8115-9d20-4f5f-9162-e5548c6fb866")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyEventImpl();
        }

    }

}
