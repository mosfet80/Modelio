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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnGroup;
import org.modelio.metamodel.impl.bpmn.activities.BpmnSubProcessSmClass;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnLaneSmClass;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnProcessSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0fb485f4-fbfb-45e4-abbf-71abd33d6804")
public class BpmnFlowElementSmClass extends BpmnBaseElementSmClass {
    @objid ("5e776672-81c0-407a-b735-6424d6ba213b")
    private SmAttribute triggeredByEventAtt;

    @objid ("cc813187-7165-49a6-a656-2e333f0b6710")
    private SmDependency groupsDep;

    @objid ("c8f8a111-0849-4cd8-b9b6-be4fce60461d")
    private SmDependency subProcessDep;

    @objid ("7efcc39c-6718-4989-a1e7-5324d5d9bcc0")
    private SmDependency laneDep;

    @objid ("07af6ddc-49fc-4660-8008-d62abbce77c2")
    private SmDependency containerDep;

    @objid ("8afff140-5413-4410-90f3-ddfd2ddad382")
    public BpmnFlowElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("60c7b878-b068-44ce-b56a-8370b6ddbcba")
    @Override
    public String getName() {
        return "BpmnFlowElement";

    }

    @objid ("ea02e858-7162-4ebb-9e00-40d796c1a641")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("bfdc9e8e-405a-43bc-b721-d47c9a4d4822")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnFlowElement.class;

    }

    @objid ("23dcabf4-a8b9-414c-8d58-c6427952be43")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("31807bf8-fc45-4670-934e-881db7b0f7ed")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("88b19fc0-9655-46fb-be3f-64132aab88d3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnFlowElementObjectFactory(this));


        // Initialize and register the SmAttribute
        this.triggeredByEventAtt = new TriggeredByEventSmAttribute();
        this.triggeredByEventAtt.init("TriggeredByEvent", this, Boolean.class );
        registerAttribute(this.triggeredByEventAtt);


        // Initialize and register the SmDependency
        this.groupsDep = new GroupsSmDependency();
        this.groupsDep.init("Groups", this, metamodel.getMClass(BpmnGroup.MQNAME), 0, -1 );
        registerDependency(this.groupsDep);

        this.subProcessDep = new SubProcessSmDependency();
        this.subProcessDep.init("SubProcess", this, metamodel.getMClass(BpmnSubProcess.MQNAME), 0, 1 );
        registerDependency(this.subProcessDep);

        this.laneDep = new LaneSmDependency();
        this.laneDep.init("Lane", this, metamodel.getMClass(BpmnLane.MQNAME), 0, -1 );
        registerDependency(this.laneDep);

        this.containerDep = new ContainerSmDependency();
        this.containerDep.init("Container", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, 1 );
        registerDependency(this.containerDep);

    }

    @objid ("80fd12a0-f81a-425e-992c-44004494b0b3")
    public SmAttribute getTriggeredByEventAtt() {
        if (this.triggeredByEventAtt == null) {
        	this.triggeredByEventAtt = this.getAttributeDef("TriggeredByEvent");
        }
        return this.triggeredByEventAtt;
    }

    @objid ("9169f6bf-0532-405c-8c64-64991d2be938")
    public SmDependency getGroupsDep() {
        if (this.groupsDep == null) {
        	this.groupsDep = this.getDependencyDef("Groups");
        }
        return this.groupsDep;
    }

    @objid ("a91b91bf-c4c2-4498-845a-729441c70d3f")
    public SmDependency getSubProcessDep() {
        if (this.subProcessDep == null) {
        	this.subProcessDep = this.getDependencyDef("SubProcess");
        }
        return this.subProcessDep;
    }

    @objid ("ae96ab43-261b-47c5-a3f4-cdfe5c23f207")
    public SmDependency getLaneDep() {
        if (this.laneDep == null) {
        	this.laneDep = this.getDependencyDef("Lane");
        }
        return this.laneDep;
    }

    @objid ("11b26899-d4a2-47e5-bd4e-90d0e39cd46e")
    public SmDependency getContainerDep() {
        if (this.containerDep == null) {
        	this.containerDep = this.getDependencyDef("Container");
        }
        return this.containerDep;
    }

    @objid ("af315101-89f4-4ee2-9609-6b9f5e6e9a54")
    private static class BpmnFlowElementObjectFactory implements ISmObjectFactory {
        @objid ("7c0c46a3-6644-435c-9946-720f171f3d6c")
        private BpmnFlowElementSmClass smClass;

        @objid ("8f84ebf3-95ba-4cf8-bada-1bfa95f107bd")
        public BpmnFlowElementObjectFactory(BpmnFlowElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c7e311e5-600d-454d-9ecd-df1c67f842ab")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("8fe9ca92-ddba-480a-a15a-4fd59ab4d6c4")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("3a7066d0-6810-4166-9f75-5f92d9484ea1")
    public static class TriggeredByEventSmAttribute extends SmAttribute {
        @objid ("6e21f3bf-e27c-46c2-9b19-3e842e5a4ed3")
        public Object getValue(ISmObjectData data) {
            return ((BpmnFlowElementData) data).mTriggeredByEvent;
        }

        @objid ("6556222d-1d31-4a74-a30c-b03c17ec604e")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnFlowElementData) data).mTriggeredByEvent = value;
        }

    }

    @objid ("3356a559-baec-426c-8366-a9c0ae050653")
    public static class GroupsSmDependency extends SmMultipleDependency {
        @objid ("9fe59e72-85aa-4427-bf59-d0ee0b71e1af")
        private SmDependency symetricDep;

        @objid ("2acacc4e-8e45-405b-b57e-820208125ab6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnFlowElementData)data).mGroups != null)? ((BpmnFlowElementData)data).mGroups:SmMultipleDependency.EMPTY;
        }

        @objid ("3634df1b-6b33-4b25-9021-8104a8ce3b45")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnFlowElementData) data).mGroups = values;

        }

        @objid ("29f85b66-9375-4e5b-a45d-1bd737b4387f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnGroupSmClass)this.getTarget()).getCategorizedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2a991d88-6f27-46a6-8d2c-1836d487a5af")
    public static class SubProcessSmDependency extends SmSingleDependency {
        @objid ("911cec05-9e0e-4ea0-839e-6f7fc1a2029a")
        private SmDependency symetricDep;

        @objid ("9eea4733-71d0-4cfa-9eaf-cc0705b6bf3c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnFlowElementData) data).mSubProcess;
        }

        @objid ("b4ca78d4-10b2-4427-aaf1-b31780c24168")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnFlowElementData) data).mSubProcess = value;
        }

        @objid ("f3ef1fb1-e28c-47fe-84a5-4189c3955640")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSubProcessSmClass)this.getTarget()).getFlowElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("edd357b3-cc7b-45b7-a202-1b864a579f0b")
    public static class LaneSmDependency extends SmMultipleDependency {
        @objid ("895d7efa-0beb-44cc-a6e0-fda80662a2c2")
        private SmDependency symetricDep;

        @objid ("c06a98af-d011-4896-9e68-0ca8b31ff0b1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnFlowElementData)data).mLane != null)? ((BpmnFlowElementData)data).mLane:SmMultipleDependency.EMPTY;
        }

        @objid ("feeb41ea-ab35-452e-af1b-14f91304b830")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnFlowElementData) data).mLane = values;

        }

        @objid ("f83a9bcb-403f-4400-88e3-b596fe7caec3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSmClass)this.getTarget()).getFlowElementRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("eb7e90e0-01b3-4b2e-bdba-73e1021ac005")
    public static class ContainerSmDependency extends SmSingleDependency {
        @objid ("2ee86b01-7fbf-44b4-8553-ec22fb2ffd28")
        private SmDependency symetricDep;

        @objid ("e5e8e3c3-75e1-4f24-ba86-52b56ffff426")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnFlowElementData) data).mContainer;
        }

        @objid ("ac045d77-b90b-418d-a2c0-f519f5464124")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnFlowElementData) data).mContainer = value;
        }

        @objid ("a63a5a6a-97eb-4caf-90bd-2ebb653da0c2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getFlowElementDep();
            }
            return this.symetricDep;

        }

    }

}
