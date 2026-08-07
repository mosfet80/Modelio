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
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("99c51c9b-249f-4d5e-ae33-b0cd26a0c94e")
public class SystemSoftwareSmClass extends NodeSmClass {
    @objid ("fd4eb101-1867-4463-927e-4b6147158bfb")
    public SystemSoftwareSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("ea28adc1-df72-4b96-abd6-b39dc7f8d415")
    @Override
    public String getName() {
        return "SystemSoftware";

    }

    @objid ("33d9ef8b-aec6-4f29-b8b2-acb587838d6d")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("4cae5868-eaeb-4da3-bb21-1bd03a119276")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return SystemSoftware.class;

    }

    @objid ("f8b7d26c-d67b-440c-8acf-0bec26c0413e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("81fc0049-1c44-437c-b1e5-7a1ff6870d13")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2570528f-c14f-4beb-b157-db1b9a4583c6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Node.MQNAME);
        this.registerFactory(new SystemSoftwareObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("5cbfeb54-d787-43ff-961d-bcbccebf38f5")
    private static class SystemSoftwareObjectFactory implements ISmObjectFactory {
        @objid ("1dfaed04-b0fc-4be8-9775-b4475eba6a39")
        private SystemSoftwareSmClass smClass;

        @objid ("eab0c752-1ccb-4cec-a3ba-184d850b6a25")
        public SystemSoftwareObjectFactory(SystemSoftwareSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3812579a-02e2-499b-9db9-08bad8f14709")
        @Override
        public ISmObjectData createData() {
            return new SystemSoftwareData(this.smClass);
        }

        @objid ("7d4e3d3e-878e-4cd5-8eb5-1219d3cef78d")
        @Override
        public SmObjectImpl createImpl() {
            return new SystemSoftwareImpl();
        }

    }

}
