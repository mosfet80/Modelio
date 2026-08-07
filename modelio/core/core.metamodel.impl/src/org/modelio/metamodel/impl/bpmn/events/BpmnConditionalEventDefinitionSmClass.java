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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.events.BpmnConditionalEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("2b15ed8a-3d33-499c-91c7-4c52a79fdacd")
public class BpmnConditionalEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("18169032-b1d6-4b94-b649-84a6aa5e9227")
    private SmAttribute conditionAtt;

    @objid ("bbbed8b1-7ad6-49a6-9374-4e9cf13e46c0")
    public BpmnConditionalEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("934cde90-1593-42b1-b99b-c1ce54f28c3c")
    @Override
    public String getName() {
        return "BpmnConditionalEventDefinition";

    }

    @objid ("92f55640-b1af-4aae-b93b-35de6b6369bc")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("ef97f9b4-bde4-4763-9ca0-fc128ab77e23")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnConditionalEventDefinition.class;

    }

    @objid ("ab2f087b-7856-4eb3-a90b-9c713053a870")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("938403ce-67c3-4556-8268-be79058d3e8c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("3587505d-86c8-4d50-86ff-b271576f8591")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnConditionalEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.conditionAtt = new ConditionSmAttribute();
        this.conditionAtt.init("Condition", this, String.class );
        registerAttribute(this.conditionAtt);


        // Initialize and register the SmDependency

    }

    @objid ("2328ee83-a7b6-4f80-9860-216ba9b272b6")
    public SmAttribute getConditionAtt() {
        if (this.conditionAtt == null) {
        	this.conditionAtt = this.getAttributeDef("Condition");
        }
        return this.conditionAtt;
    }

    @objid ("eaeacb93-cfac-416f-903b-80e8fc16399e")
    private static class BpmnConditionalEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("3cfd8e5d-ff10-4590-9ac2-acf68f2a31c5")
        private BpmnConditionalEventDefinitionSmClass smClass;

        @objid ("a7b8485e-9f3f-47aa-9c00-ae9867ddaa77")
        public BpmnConditionalEventDefinitionObjectFactory(BpmnConditionalEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("192bb8c7-14c6-4f4d-9930-0825fdaa3f93")
        @Override
        public ISmObjectData createData() {
            return new BpmnConditionalEventDefinitionData(this.smClass);
        }

        @objid ("9ca59704-0b6c-40db-b3e5-1f7b71e5b267")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnConditionalEventDefinitionImpl();
        }

    }

    @objid ("2e301ae9-c151-4e66-ba9d-759ca7217a22")
    public static class ConditionSmAttribute extends SmAttribute {
        @objid ("a1244135-a4f4-44ac-a7df-456cfa3c2433")
        public Object getValue(ISmObjectData data) {
            return ((BpmnConditionalEventDefinitionData) data).mCondition;
        }

        @objid ("e858b920-5007-4a4e-9e6e-9f5dc04c101f")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnConditionalEventDefinitionData) data).mCondition = value;
        }

    }

}
