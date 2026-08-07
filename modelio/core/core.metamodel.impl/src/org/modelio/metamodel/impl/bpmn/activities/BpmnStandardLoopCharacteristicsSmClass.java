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
import org.modelio.metamodel.bpmn.activities.BpmnLoopCharacteristics;
import org.modelio.metamodel.bpmn.activities.BpmnStandardLoopCharacteristics;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c015d3f2-1b6d-4184-822a-251f1714a2c3")
public class BpmnStandardLoopCharacteristicsSmClass extends BpmnLoopCharacteristicsSmClass {
    @objid ("474afdce-75b1-4191-b694-6503ce1765a2")
    private SmAttribute testBeforeAtt;

    @objid ("6fd09dcd-a922-4286-b5fc-1dccfd7f2390")
    private SmAttribute loopConditionAtt;

    @objid ("4fef0080-c52b-48cd-aa54-27829a7a7d13")
    private SmAttribute loopMaximumAtt;

    @objid ("7dcd2f4f-35ea-4400-8ad5-551fdc8a7f23")
    public BpmnStandardLoopCharacteristicsSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("129f4733-fe1c-4dc2-ad9f-f42aa4d86ff9")
    @Override
    public String getName() {
        return "BpmnStandardLoopCharacteristics";

    }

    @objid ("071de3af-0220-450c-8f17-1f7466986498")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("715102ef-0b95-4c14-917f-f1c3f29595d9")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnStandardLoopCharacteristics.class;

    }

    @objid ("b95c8be0-cb17-4058-ab4d-33ce0664f44f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("39e0e39c-de7e-40fc-8b15-bf92d5a576b8")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("c4ccd84b-2dec-4812-aacb-491a9b7dd265")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnLoopCharacteristics.MQNAME);
        this.registerFactory(new BpmnStandardLoopCharacteristicsObjectFactory(this));


        // Initialize and register the SmAttribute
        this.testBeforeAtt = new TestBeforeSmAttribute();
        this.testBeforeAtt.init("TestBefore", this, Boolean.class );
        registerAttribute(this.testBeforeAtt);

        this.loopConditionAtt = new LoopConditionSmAttribute();
        this.loopConditionAtt.init("LoopCondition", this, String.class );
        registerAttribute(this.loopConditionAtt);

        this.loopMaximumAtt = new LoopMaximumSmAttribute();
        this.loopMaximumAtt.init("LoopMaximum", this, String.class );
        registerAttribute(this.loopMaximumAtt);


        // Initialize and register the SmDependency

    }

    @objid ("794df29f-1fd3-40b8-84b5-efd50f366b72")
    public SmAttribute getTestBeforeAtt() {
        if (this.testBeforeAtt == null) {
        	this.testBeforeAtt = this.getAttributeDef("TestBefore");
        }
        return this.testBeforeAtt;
    }

    @objid ("1e082fda-ae51-4f25-9bd5-51aa09456526")
    public SmAttribute getLoopConditionAtt() {
        if (this.loopConditionAtt == null) {
        	this.loopConditionAtt = this.getAttributeDef("LoopCondition");
        }
        return this.loopConditionAtt;
    }

    @objid ("97376113-27c9-480b-996f-c0da96f060fa")
    public SmAttribute getLoopMaximumAtt() {
        if (this.loopMaximumAtt == null) {
        	this.loopMaximumAtt = this.getAttributeDef("LoopMaximum");
        }
        return this.loopMaximumAtt;
    }

    @objid ("20a4cab4-7885-49a5-bc69-58cca6c0ad1e")
    private static class BpmnStandardLoopCharacteristicsObjectFactory implements ISmObjectFactory {
        @objid ("842ca34b-049a-4667-978d-3483e6f2fe24")
        private BpmnStandardLoopCharacteristicsSmClass smClass;

        @objid ("12fee9ae-aa26-48b8-a450-77771484df36")
        public BpmnStandardLoopCharacteristicsObjectFactory(BpmnStandardLoopCharacteristicsSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("aca3f478-948b-4dbf-8c56-97a203774ff7")
        @Override
        public ISmObjectData createData() {
            return new BpmnStandardLoopCharacteristicsData(this.smClass);
        }

        @objid ("ba930ebf-fc1a-4108-b8a2-339e07be0b29")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnStandardLoopCharacteristicsImpl();
        }

    }

    @objid ("dff0729e-80ac-4e9f-bf7a-ee8df85166d3")
    public static class TestBeforeSmAttribute extends SmAttribute {
        @objid ("b592b0dd-732c-4191-962f-d5966f8a8ea1")
        public Object getValue(ISmObjectData data) {
            return ((BpmnStandardLoopCharacteristicsData) data).mTestBefore;
        }

        @objid ("3a912387-61ae-4552-af2a-317ce5df71d9")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnStandardLoopCharacteristicsData) data).mTestBefore = value;
        }

    }

    @objid ("e647ab43-f6c1-4ebf-9fb5-ccbb0910e2b8")
    public static class LoopConditionSmAttribute extends SmAttribute {
        @objid ("2c064826-4573-452b-8168-fc14ab9aac16")
        public Object getValue(ISmObjectData data) {
            return ((BpmnStandardLoopCharacteristicsData) data).mLoopCondition;
        }

        @objid ("552a1083-250c-4088-adb8-529a34da70ca")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnStandardLoopCharacteristicsData) data).mLoopCondition = value;
        }

    }

    @objid ("8b25c9cd-bc4c-4af2-be39-e7a3fbcf1676")
    public static class LoopMaximumSmAttribute extends SmAttribute {
        @objid ("95d9ebd2-b0c6-449e-afdc-a4b5d465c419")
        public Object getValue(ISmObjectData data) {
            return ((BpmnStandardLoopCharacteristicsData) data).mLoopMaximum;
        }

        @objid ("6590a873-b794-48d6-8e58-6abea578c4a8")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnStandardLoopCharacteristicsData) data).mLoopMaximum = value;
        }

    }

}
