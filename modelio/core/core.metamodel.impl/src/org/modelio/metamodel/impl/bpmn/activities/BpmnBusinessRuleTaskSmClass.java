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
import org.modelio.metamodel.bpmn.activities.BpmnBusinessRuleTask;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("987f97c3-033b-4989-bec3-cb6d8b249f62")
public class BpmnBusinessRuleTaskSmClass extends BpmnTaskSmClass {
    @objid ("060990d5-0a87-44aa-a82c-5a2ffc32ab80")
    public BpmnBusinessRuleTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("3fb0deec-915d-4914-bcd0-d5ed9dfeb518")
    @Override
    public String getName() {
        return "BpmnBusinessRuleTask";

    }

    @objid ("6ee3a765-81b4-4791-bca5-83e3572f7586")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3120574e-e2bb-49c1-b501-21af84316299")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnBusinessRuleTask.class;

    }

    @objid ("ffb029a7-e53c-4d24-abfa-00daed26ed51")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("9fd16eb8-2781-4145-9263-aeb6024f291c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8572e0c2-e51f-4383-92ef-029bf73a02e6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnTask.MQNAME);
        this.registerFactory(new BpmnBusinessRuleTaskObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("df3af54f-0897-4d05-bb9f-8deef870a92c")
    private static class BpmnBusinessRuleTaskObjectFactory implements ISmObjectFactory {
        @objid ("579abd3d-9d33-42c8-b6e0-a66fb2abf917")
        private BpmnBusinessRuleTaskSmClass smClass;

        @objid ("26f470ed-4541-483c-b294-817a9e29afcb")
        public BpmnBusinessRuleTaskObjectFactory(BpmnBusinessRuleTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("13142a4c-3472-4440-870f-7a91a4e6d8f5")
        @Override
        public ISmObjectData createData() {
            return new BpmnBusinessRuleTaskData(this.smClass);
        }

        @objid ("953cb812-c463-478e-9079-6de0a9b3701d")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnBusinessRuleTaskImpl();
        }

    }

}
