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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.flows.BpmnSequenceFlowSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1be2fce9-1ef8-4ede-bafa-7464c144738d")
public class BpmnSequenceFlowDataAssociationSmClass extends BpmnBaseElementSmClass {
    @objid ("75569201-cf5b-4e7b-bff9-1c6bc699cdc7")
    private SmDependency connectedDep;

    @objid ("96a7dbbb-2037-45d2-bca7-7064fb81b303")
    private SmDependency dataAssociationDep;

    @objid ("b29ba70f-58a4-4de1-994a-176fd3d19371")
    public BpmnSequenceFlowDataAssociationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b968afce-280f-471f-8dcb-6ab48f7dcc1f")
    @Override
    public String getName() {
        return "BpmnSequenceFlowDataAssociation";

    }

    @objid ("ad70b377-0ecf-4216-b80f-6e4eb799e055")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("81ee0373-747d-426d-8bd1-bedbc2f9439e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSequenceFlowDataAssociation.class;

    }

    @objid ("85849c54-7220-4b4b-82d9-5b851c2ef73e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("501c40cc-93f4-4314-876c-932a341e9ed0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("28f1d7f5-dc72-427d-87d8-be5cda731b8f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnSequenceFlowDataAssociationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.connectedDep = new ConnectedSmDependency();
        this.connectedDep.init("Connected", this, metamodel.getMClass(BpmnSequenceFlow.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.connectedDep);

        this.dataAssociationDep = new DataAssociationSmDependency();
        this.dataAssociationDep.init("DataAssociation", this, metamodel.getMClass(BpmnDataAssociation.MQNAME), 2, 2 , SmDirective.SMCDPARTOF);
        registerDependency(this.dataAssociationDep);

    }

    @objid ("9cecb694-9652-4bfd-b254-d1fbc9be9a01")
    public SmDependency getConnectedDep() {
        if (this.connectedDep == null) {
        	this.connectedDep = this.getDependencyDef("Connected");
        }
        return this.connectedDep;
    }

    @objid ("31019284-3e73-4947-9693-db09d395d8e8")
    public SmDependency getDataAssociationDep() {
        if (this.dataAssociationDep == null) {
        	this.dataAssociationDep = this.getDependencyDef("DataAssociation");
        }
        return this.dataAssociationDep;
    }

    @objid ("e669d70a-540f-43bc-b254-16ad5ee4b729")
    private static class BpmnSequenceFlowDataAssociationObjectFactory implements ISmObjectFactory {
        @objid ("e8be43cc-2c79-4135-ae5d-ac12aebf1059")
        private BpmnSequenceFlowDataAssociationSmClass smClass;

        @objid ("91f961f7-10cb-4891-a6b1-0ef07180025b")
        public BpmnSequenceFlowDataAssociationObjectFactory(BpmnSequenceFlowDataAssociationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("26666c11-ebd3-4c4e-906f-1b77d1daae53")
        @Override
        public ISmObjectData createData() {
            return new BpmnSequenceFlowDataAssociationData(this.smClass);
        }

        @objid ("7a81f025-cfbd-4303-96b2-e00dc7f11bb9")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnSequenceFlowDataAssociationImpl();
        }

    }

    @objid ("f1e4cf31-bfd3-4254-a6b9-b1ceae4d48a2")
    public static class ConnectedSmDependency extends SmSingleDependency {
        @objid ("714608b3-ef8d-4fbc-9dbd-8679c421cc9d")
        private SmDependency symetricDep;

        @objid ("a5f28a06-6c7e-4b02-b9fa-306f488abab2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowDataAssociationData) data).mConnected;
        }

        @objid ("f41a3b4e-478c-437e-80a6-97ce48515c04")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSequenceFlowDataAssociationData) data).mConnected = value;
        }

        @objid ("31d291db-46c0-44cb-8095-128e63e49d5c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowSmClass)this.getTarget()).getConnectorDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a21b9dd2-e68f-4e0b-8f02-50ca0d73a3d1")
    public static class DataAssociationSmDependency extends SmMultipleDependency {
        @objid ("024bd22c-35fc-4175-b5cf-7877f6f4b632")
        private SmDependency symetricDep;

        @objid ("97b2e585-04e3-45e5-89b5-05aed6ed0084")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnSequenceFlowDataAssociationData)data).mDataAssociation != null)? ((BpmnSequenceFlowDataAssociationData)data).mDataAssociation:SmMultipleDependency.EMPTY;
        }

        @objid ("79b315e4-309e-4d3e-b986-c33992dbd68c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnSequenceFlowDataAssociationData) data).mDataAssociation = values;

        }

        @objid ("a97461f1-2984-49ea-b9b7-25841ffed93b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataAssociationSmClass)this.getTarget()).getVisualShortCutDep();
            }
            return this.symetricDep;

        }

    }

}
