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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.CentralBufferNode;
import org.modelio.metamodel.uml.behavior.activityModel.DataStoreNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("be9410e9-9e10-4db8-b745-4ffd5e050416")
public class DataStoreNodeSmClass extends CentralBufferNodeSmClass {
    @objid ("352fb8fe-2ab8-4aac-8dbd-252ef534e85c")
    public DataStoreNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("55462f9b-308e-4bb0-8929-ec4624bed749")
    @Override
    public String getName() {
        return "DataStoreNode";

    }

    @objid ("e2f7915d-7de3-40e2-a802-457d3f250fac")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("83254f0e-96a1-49a3-b50e-f270efad8413")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DataStoreNode.class;

    }

    @objid ("bd2bd18e-edd2-4c71-b326-d8b996b0ada7")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("090dc724-ff44-4e2e-8a26-29a4dc5e6e04")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5c1664db-786a-4d6a-8cd0-6f8e79140468")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(CentralBufferNode.MQNAME);
        this.registerFactory(new DataStoreNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("5cb68af6-7da1-445f-bb41-2a46f32ee128")
    private static class DataStoreNodeObjectFactory implements ISmObjectFactory {
        @objid ("b97f09aa-3e3f-47df-b3c5-645d9cf7f2e6")
        private DataStoreNodeSmClass smClass;

        @objid ("6df0a0b8-82e8-419d-80ab-85f58737aacf")
        public DataStoreNodeObjectFactory(DataStoreNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("bb4f8409-2644-49c8-b2d9-416a948a6cd1")
        @Override
        public ISmObjectData createData() {
            return new DataStoreNodeData(this.smClass);
        }

        @objid ("5e8e4437-0381-4332-a479-55d5ab50108a")
        @Override
        public SmObjectImpl createImpl() {
            return new DataStoreNodeImpl();
        }

    }

}
