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
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c1b2286d-e337-4b9b-b057-6319bed82980")
public class CentralBufferNodeSmClass extends ObjectNodeSmClass {
    @objid ("479b38e7-a3c1-4969-96a1-c258a119dac9")
    public CentralBufferNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("de2dbcb3-7ea5-452c-a55d-9495bf895502")
    @Override
    public String getName() {
        return "CentralBufferNode";

    }

    @objid ("ffd8a4db-5765-4341-80a9-58b0414f37ad")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("25c3d8b6-b72f-4a04-97e9-0c998fa8b98e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CentralBufferNode.class;

    }

    @objid ("807e9f8e-4ee9-4a88-ac87-2d2476f60753")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("227fdaf8-afcc-4d7b-8c20-dd0f52d967f3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a9eef8f6-049c-4ba5-ba7d-9f2715377b3b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ObjectNode.MQNAME);
        this.registerFactory(new CentralBufferNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f98b7244-88fb-405b-ab02-e77ae3931c55")
    private static class CentralBufferNodeObjectFactory implements ISmObjectFactory {
        @objid ("2ab0a575-1a40-44cd-ae50-107a50a1ea92")
        private CentralBufferNodeSmClass smClass;

        @objid ("926d5f8b-5500-4b45-9833-851eceea6062")
        public CentralBufferNodeObjectFactory(CentralBufferNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("62b7b82d-7e73-46d6-8bd7-0bb826cd12b7")
        @Override
        public ISmObjectData createData() {
            return new CentralBufferNodeData(this.smClass);
        }

        @objid ("e36f312e-cdd3-4d06-ae66-48e0f7b6700f")
        @Override
        public SmObjectImpl createImpl() {
            return new CentralBufferNodeImpl();
        }

    }

}
