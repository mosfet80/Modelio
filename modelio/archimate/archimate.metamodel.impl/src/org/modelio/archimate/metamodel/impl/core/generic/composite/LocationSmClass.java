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
package org.modelio.archimate.metamodel.impl.core.generic.composite;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0fe3bad8-36bd-4e64-b005-db9cd866967c")
public class LocationSmClass extends CompositeElementSmClass {
    @objid ("e7ca0701-51e8-477b-af1d-e32180399ac9")
    public LocationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("342e9b28-aab9-488e-9381-c43199e0bae7")
    @Override
    public String getName() {
        return "Location";

    }

    @objid ("13ea4dd2-8566-4924-8d43-b61102f153eb")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("5912d1c5-d39a-4510-a29e-3eaaafe94da7")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Location.class;

    }

    @objid ("07f7814e-62be-4036-8fb8-49e21238605a")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("4fcedfb1-b46d-4e41-9e00-7895919f4669")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6a5fdb53-fa6d-40a0-b1d1-85ef13831529")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(CompositeElement.MQNAME);
        this.registerFactory(new LocationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("e17fce1c-9b6b-4400-bd4e-091a76243426")
    private static class LocationObjectFactory implements ISmObjectFactory {
        @objid ("12b54352-bab2-4f53-81a9-17740e30d3a5")
        private LocationSmClass smClass;

        @objid ("6ea6bb85-a3d7-40dc-88d2-717110d0d50e")
        public LocationObjectFactory(LocationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7b46992b-e264-44fe-a006-a2c483757fe3")
        @Override
        public ISmObjectData createData() {
            return new LocationData(this.smClass);
        }

        @objid ("bb402124-d5e6-4ec6-aed1-27c6633fed6d")
        @Override
        public SmObjectImpl createImpl() {
            return new LocationImpl();
        }

    }

}
