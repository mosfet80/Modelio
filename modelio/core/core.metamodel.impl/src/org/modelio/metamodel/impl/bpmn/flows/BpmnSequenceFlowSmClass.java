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
package org.modelio.metamodel.impl.bpmn.flows;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.gateways.BpmnComplexGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnExclusiveGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnInclusiveGateway;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.activities.BpmnActivitySmClass;
import org.modelio.metamodel.impl.bpmn.gateways.BpmnComplexGatewaySmClass;
import org.modelio.metamodel.impl.bpmn.gateways.BpmnExclusiveGatewaySmClass;
import org.modelio.metamodel.impl.bpmn.gateways.BpmnInclusiveGatewaySmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnSequenceFlowDataAssociationSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowElementSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeSmClass;
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

@objid ("eaa10c45-5666-4efc-ac31-887820f6c9d1")
public class BpmnSequenceFlowSmClass extends BpmnFlowElementSmClass {
    @objid ("f0921dab-0fc5-457b-aaa3-97e1985f0c67")
    private SmAttribute isImmediateAtt;

    @objid ("bb0bb751-ba05-46ee-817f-2bdde1788c18")
    private SmAttribute conditionExpressionAtt;

    @objid ("0ebd5a1b-030b-4242-ac37-d53e1dc5cc0a")
    private SmDependency sourceRefDep;

    @objid ("742370a7-de8a-477e-a251-8731b6bd9f1f")
    private SmDependency targetRefDep;

    @objid ("dd120e91-a3d7-47a5-9979-e048a049ca4c")
    private SmDependency defaultOfInclusiveDep;

    @objid ("91baafd0-21a3-40e8-bd44-458e6f3c45e1")
    private SmDependency defaultFromDep;

    @objid ("7eb2b22c-cd21-42cf-929f-a45a66a0b357")
    private SmDependency defaultOfExclusiveDep;

    @objid ("dc093735-bbd6-424e-ba62-d350c5645610")
    private SmDependency connectorDep;

    @objid ("f246cdcd-648b-48e3-8e1c-f5db92c63098")
    private SmDependency defaultOfComplexDep;

    @objid ("856c5de8-0d11-4879-8669-aa65bdad1fe6")
    public BpmnSequenceFlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d88d4d3a-9be2-4039-94f4-af57841792ac")
    @Override
    public String getName() {
        return "BpmnSequenceFlow";

    }

    @objid ("97f106c4-530b-4a1d-beb0-f68c5947f679")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d9649749-a457-4875-a1bd-6741c8041935")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSequenceFlow.class;

    }

    @objid ("dbfb8810-f3ca-42cf-8718-e33e66ed1a62")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("91438998-8589-4a35-a6d9-5c12ea048543")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6ea0faa5-0a59-4e4d-9ad6-edd2e0c0b5d4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnFlowElement.MQNAME);
        this.registerFactory(new BpmnSequenceFlowObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isImmediateAtt = new IsImmediateSmAttribute();
        this.isImmediateAtt.init("IsImmediate", this, Boolean.class );
        registerAttribute(this.isImmediateAtt);

        this.conditionExpressionAtt = new ConditionExpressionSmAttribute();
        this.conditionExpressionAtt.init("ConditionExpression", this, String.class );
        registerAttribute(this.conditionExpressionAtt);


        // Initialize and register the SmDependency
        this.sourceRefDep = new SourceRefSmDependency();
        this.sourceRefDep.init("SourceRef", this, metamodel.getMClass(BpmnFlowNode.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE, SmDirective.SMCDPARTOF);
        registerDependency(this.sourceRefDep);

        this.targetRefDep = new TargetRefSmDependency();
        this.targetRefDep.init("TargetRef", this, metamodel.getMClass(BpmnFlowNode.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetRefDep);

        this.defaultOfInclusiveDep = new DefaultOfInclusiveSmDependency();
        this.defaultOfInclusiveDep.init("DefaultOfInclusive", this, metamodel.getMClass(BpmnInclusiveGateway.MQNAME), 0, 1 );
        registerDependency(this.defaultOfInclusiveDep);

        this.defaultFromDep = new DefaultFromSmDependency();
        this.defaultFromDep.init("DefaultFrom", this, metamodel.getMClass(BpmnActivity.MQNAME), 0, 1 );
        registerDependency(this.defaultFromDep);

        this.defaultOfExclusiveDep = new DefaultOfExclusiveSmDependency();
        this.defaultOfExclusiveDep.init("DefaultOfExclusive", this, metamodel.getMClass(BpmnExclusiveGateway.MQNAME), 0, 1 );
        registerDependency(this.defaultOfExclusiveDep);

        this.connectorDep = new ConnectorSmDependency();
        this.connectorDep.init("Connector", this, metamodel.getMClass(BpmnSequenceFlowDataAssociation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.connectorDep);

        this.defaultOfComplexDep = new DefaultOfComplexSmDependency();
        this.defaultOfComplexDep.init("DefaultOfComplex", this, metamodel.getMClass(BpmnComplexGateway.MQNAME), 0, 1 );
        registerDependency(this.defaultOfComplexDep);

    }

    @objid ("4310f82e-a293-47b9-9bc4-8024ea78b11b")
    public SmAttribute getIsImmediateAtt() {
        if (this.isImmediateAtt == null) {
        	this.isImmediateAtt = this.getAttributeDef("IsImmediate");
        }
        return this.isImmediateAtt;
    }

    @objid ("a12547ff-4a89-4ddb-9b85-890b90124bbc")
    public SmAttribute getConditionExpressionAtt() {
        if (this.conditionExpressionAtt == null) {
        	this.conditionExpressionAtt = this.getAttributeDef("ConditionExpression");
        }
        return this.conditionExpressionAtt;
    }

    @objid ("3caf26db-09d7-40bd-b43b-09f3e881294a")
    public SmDependency getSourceRefDep() {
        if (this.sourceRefDep == null) {
        	this.sourceRefDep = this.getDependencyDef("SourceRef");
        }
        return this.sourceRefDep;
    }

    @objid ("e5039bee-f7da-412e-b514-fed77cb2ef3f")
    public SmDependency getTargetRefDep() {
        if (this.targetRefDep == null) {
        	this.targetRefDep = this.getDependencyDef("TargetRef");
        }
        return this.targetRefDep;
    }

    @objid ("a581082f-4ebb-4e20-874f-41caf7d9399a")
    public SmDependency getDefaultOfInclusiveDep() {
        if (this.defaultOfInclusiveDep == null) {
        	this.defaultOfInclusiveDep = this.getDependencyDef("DefaultOfInclusive");
        }
        return this.defaultOfInclusiveDep;
    }

    @objid ("52f6e50b-953b-4a9a-8aaf-71621daab96f")
    public SmDependency getDefaultFromDep() {
        if (this.defaultFromDep == null) {
        	this.defaultFromDep = this.getDependencyDef("DefaultFrom");
        }
        return this.defaultFromDep;
    }

    @objid ("f5197db8-b41f-4611-b132-d911a3dc6ca7")
    public SmDependency getDefaultOfExclusiveDep() {
        if (this.defaultOfExclusiveDep == null) {
        	this.defaultOfExclusiveDep = this.getDependencyDef("DefaultOfExclusive");
        }
        return this.defaultOfExclusiveDep;
    }

    @objid ("fa365521-d06d-499c-8045-16fcaeac8d96")
    public SmDependency getConnectorDep() {
        if (this.connectorDep == null) {
        	this.connectorDep = this.getDependencyDef("Connector");
        }
        return this.connectorDep;
    }

    @objid ("539ff37a-0e29-4da8-879e-cbe3852cac4f")
    public SmDependency getDefaultOfComplexDep() {
        if (this.defaultOfComplexDep == null) {
        	this.defaultOfComplexDep = this.getDependencyDef("DefaultOfComplex");
        }
        return this.defaultOfComplexDep;
    }

    @objid ("bd70d5c8-fb0b-47e1-81ec-bd06d42d188c")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("da86b57c-768f-4f42-aebe-5d2f5c87fe2c")
    private static class BpmnSequenceFlowObjectFactory implements ISmObjectFactory {
        @objid ("5f90b504-60f0-4d1c-9ae7-289840d1fa85")
        private BpmnSequenceFlowSmClass smClass;

        @objid ("edbcb779-ebfc-4f26-9c7f-6efe3721d020")
        public BpmnSequenceFlowObjectFactory(BpmnSequenceFlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("00f46258-0655-4f72-bbb4-7de435b4be43")
        @Override
        public ISmObjectData createData() {
            return new BpmnSequenceFlowData(this.smClass);
        }

        @objid ("c76982c8-89a0-4cdd-a7f8-3b73a5d49a31")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnSequenceFlowImpl();
        }

    }

    @objid ("640509bd-c1a4-4617-89e8-da54855bef72")
    public static class IsImmediateSmAttribute extends SmAttribute {
        @objid ("d2ac7680-397e-4c55-acef-448ebc378b02")
        public Object getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mIsImmediate;
        }

        @objid ("969231d9-62b0-453b-a0a7-8e6ad14fe4c2")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnSequenceFlowData) data).mIsImmediate = value;
        }

    }

    @objid ("28e77bfe-b80f-47c5-8873-1acaaa061f88")
    public static class ConditionExpressionSmAttribute extends SmAttribute {
        @objid ("48378216-0009-4ec1-8207-d140df63ec89")
        public Object getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mConditionExpression;
        }

        @objid ("7f58d26b-6c6f-4cce-9ab4-61b1af5e4ffd")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnSequenceFlowData) data).mConditionExpression = value;
        }

    }

    @objid ("8a4037db-f1b5-4389-8421-495338e4b686")
    public static class SourceRefSmDependency extends SmSingleDependency {
        @objid ("8a4ef321-63b9-4087-8ea1-b74c28b11f8d")
        private SmDependency symetricDep;

        @objid ("8f90b6af-378f-430b-b934-5d84e2819f66")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mSourceRef;
        }

        @objid ("a4e7c369-7e03-415e-8427-bba90f8a9814")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSequenceFlowData) data).mSourceRef = value;
        }

        @objid ("49ab0af6-0229-499a-af48-a7384b3c3a91")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnFlowNodeSmClass)this.getTarget()).getOutgoingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1c75ba25-cc84-4dc7-a6e5-7f1e3858c9d2")
    public static class TargetRefSmDependency extends SmSingleDependency {
        @objid ("05bbbd9f-649f-4a14-b441-da4cdc1ff779")
        private SmDependency symetricDep;

        @objid ("5e6a4ead-fd83-4b53-b31e-1812d6c33499")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mTargetRef;
        }

        @objid ("f6a9d7a2-333f-4b5b-b317-f6b5aa46134a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSequenceFlowData) data).mTargetRef = value;
        }

        @objid ("3e6f2db7-c8ff-4689-8860-4ba8ab73bd9c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnFlowNodeSmClass)this.getTarget()).getIncomingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bfad618d-687c-4829-a2e5-e7af5ffe1768")
    public static class DefaultOfInclusiveSmDependency extends SmSingleDependency {
        @objid ("51017511-c3d6-4991-a3ce-1cc5d1401001")
        private SmDependency symetricDep;

        @objid ("4ff7fb65-aa16-4244-976e-6edff184dc87")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mDefaultOfInclusive;
        }

        @objid ("28d9866f-4354-4bdd-8732-1853cb39e36c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSequenceFlowData) data).mDefaultOfInclusive = value;
        }

        @objid ("979a7534-749c-445a-a33d-76df703a6bc3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnInclusiveGatewaySmClass)this.getTarget()).getDefaultFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4a7daf9c-1c38-46d0-b98e-9c729f088e3f")
    public static class DefaultFromSmDependency extends SmSingleDependency {
        @objid ("13212eb0-326d-4994-9e64-07a8b0067b64")
        private SmDependency symetricDep;

        @objid ("51f0b7f0-229c-49b9-933e-9e71dc7b2480")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mDefaultFrom;
        }

        @objid ("ce6947ea-289e-4d47-824e-8b75e12703d6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSequenceFlowData) data).mDefaultFrom = value;
        }

        @objid ("a16acdc6-3b42-4885-9b16-cdadd15e0fcd")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getDefaultFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("63f423c5-f26b-4a1f-b524-0a828d189bbf")
    public static class DefaultOfExclusiveSmDependency extends SmSingleDependency {
        @objid ("5e2c5a3a-9b95-4693-8965-a40743d96667")
        private SmDependency symetricDep;

        @objid ("7b4f7b98-675b-4423-a4d7-db4916dfc001")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mDefaultOfExclusive;
        }

        @objid ("7b73ded9-b000-4926-a109-c297628bd247")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSequenceFlowData) data).mDefaultOfExclusive = value;
        }

        @objid ("56333dbc-9eca-4aa5-94aa-747a1ea794db")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnExclusiveGatewaySmClass)this.getTarget()).getDefaultFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f42b4ddc-65af-43b6-9fec-1cd4ac02d69f")
    public static class ConnectorSmDependency extends SmMultipleDependency {
        @objid ("677e619f-1868-4bb1-9b50-4c4a5dd6b1a7")
        private SmDependency symetricDep;

        @objid ("81307362-39cf-487b-bb4e-c91d5af01a1f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnSequenceFlowData)data).mConnector != null)? ((BpmnSequenceFlowData)data).mConnector:SmMultipleDependency.EMPTY;
        }

        @objid ("325b84cf-d4e3-48bd-81e8-fdbbf7852f78")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnSequenceFlowData) data).mConnector = values;

        }

        @objid ("ccaf629f-12a0-427c-97d5-4d2632e339dd")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowDataAssociationSmClass)this.getTarget()).getConnectedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f6c795f9-47b0-4d42-a03b-be9c5414b9c8")
    public static class DefaultOfComplexSmDependency extends SmSingleDependency {
        @objid ("7c04fbca-3c84-4dce-9092-8e0babd2af77")
        private SmDependency symetricDep;

        @objid ("8ff88180-75a1-4580-8be9-082af64ad606")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSequenceFlowData) data).mDefaultOfComplex;
        }

        @objid ("43af8e4e-8955-42d4-bf77-f92692c3b7f0")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSequenceFlowData) data).mDefaultOfComplex = value;
        }

        @objid ("1f13ed4b-3862-4b45-9a4e-155f54274699")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnComplexGatewaySmClass)this.getTarget()).getDefaultFlowDep();
            }
            return this.symetricDep;

        }

    }

}
