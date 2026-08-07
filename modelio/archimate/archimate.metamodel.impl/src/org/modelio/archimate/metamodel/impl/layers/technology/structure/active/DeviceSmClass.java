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
package org.modelio.archimate.metamodel.impl.layers.technology.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("9cb92b08-c94b-4953-900f-0d34dd240e58")
public class DeviceSmClass extends NodeSmClass {
    @objid ("33255bcc-f2c7-47a2-b42a-3921ac21a8a0")
    public DeviceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a9873456-c9a1-4f6e-b7b3-119ae08e4ba1")
    @Override
    public String getName() {
        return "Device";

    }

    @objid ("f10e3447-2897-4b21-a160-69ef82f4722e")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("dcc416f3-7419-4edd-936b-778b3f50c0e5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Device.class;

    }

    @objid ("c5aace70-e2f2-4e73-91ae-11ee2b206a6e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("ee5b79cd-f69f-4da3-a2b5-c4ccc417720f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2bb7cc38-c302-46fe-95dc-4f3e2b89766b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Node.MQNAME);
        this.registerFactory(new DeviceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("0061cf87-27d4-4cda-907a-27cc54c7fca2")
    private static class DeviceObjectFactory implements ISmObjectFactory {
        @objid ("88fe6367-f7a5-480c-9a13-f952fba1b701")
        private DeviceSmClass smClass;

        @objid ("538fbff0-8de1-4a59-88d4-e6c7b1928d65")
        public DeviceObjectFactory(DeviceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5790ea7c-5420-4c48-8838-a5938ae5d1e4")
        @Override
        public ISmObjectData createData() {
            return new DeviceData(this.smClass);
        }

        @objid ("4eda6275-090b-4c39-abd3-c7ff7b9ff2d9")
        @Override
        public SmObjectImpl createImpl() {
            return new DeviceImpl();
        }

    }

}
