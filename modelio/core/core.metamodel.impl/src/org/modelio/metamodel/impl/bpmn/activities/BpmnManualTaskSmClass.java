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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnManualTask;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("46a6f085-4ff9-4de6-a623-b74277c418be")
public class BpmnManualTaskSmClass extends BpmnTaskSmClass {
    @objid ("d6d08f36-c938-4e41-b385-d129e69f94b1")
    public BpmnManualTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("ea77c048-2790-4af7-9094-98daf83f643e")
    @Override
    public String getName() {
        return "BpmnManualTask";

    }

    @objid ("dd5df162-245e-43a1-8b0e-4d438cdf82b9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("50800879-03c2-45e0-8b9e-587131e5bb86")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnManualTask.class;

    }

    @objid ("b1de4f21-0a3a-4cf2-850f-5da98b8cbc77")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5be530a1-486f-41ad-a14d-b8e44b504dea")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("76051e32-890d-4db0-98f6-7f8e1fb9eb6c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnTask.MQNAME);
        this.registerFactory(new BpmnManualTaskObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("8a4179bb-790d-4af2-91cf-a0883c96cb85")
    private static class BpmnManualTaskObjectFactory implements ISmObjectFactory {
        @objid ("200ebac1-3221-4040-9de0-afe7d8959c81")
        private BpmnManualTaskSmClass smClass;

        @objid ("edc3d563-948c-4c8b-a8a1-c85defc25dd4")
        public BpmnManualTaskObjectFactory(BpmnManualTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("bf4d2f56-68ab-4f71-9b48-be77ed278740")
        @Override
        public ISmObjectData createData() {
            return new BpmnManualTaskData(this.smClass);
        }

        @objid ("65635e02-4686-4674-abea-91fb4f308409")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnManualTaskImpl();
        }

    }

}
