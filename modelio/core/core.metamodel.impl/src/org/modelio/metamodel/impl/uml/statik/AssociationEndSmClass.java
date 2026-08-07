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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.ObjectNodeSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.AggregationKind;
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.StructuralFeature;
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

@objid ("b262271d-e4c3-46de-a5e0-480accedf845")
public class AssociationEndSmClass extends StructuralFeatureSmClass {
    @objid ("acecb5ed-740a-49c6-99d0-ed56dcd43c40")
    private SmAttribute aggregationAtt;

    @objid ("fbee2dae-12ec-463c-abb5-41886969a38d")
    private SmAttribute isChangeableAtt;

    @objid ("eb5ad33e-ac65-469e-b212-3a88125a70ba")
    private SmDependency targetDep;

    @objid ("c5fea7f0-516f-49d9-aa08-2038bfbbca2b")
    private SmDependency oppositeOwnerDep;

    @objid ("1c255583-cb35-415e-a5dc-f0ea1c99b585")
    private SmDependency sourceDep;

    @objid ("c6f0c799-0303-44a0-9489-6637d2efe10b")
    private SmDependency occurenceDep;

    @objid ("1dd7f497-c73c-47ec-a840-dbae4ec2dd59")
    private SmDependency sentDep;

    @objid ("a4dfaf2b-e46c-4141-ba68-eb23b05ee9e6")
    private SmDependency qualifierDep;

    @objid ("11574579-62ac-41a4-8feb-fbfa62723a63")
    private SmDependency oppositeDep;

    @objid ("0fe4fd03-eb76-42b0-ac83-30374ae646d2")
    private SmDependency representingObjectNodeDep;

    @objid ("9eeba828-7918-4f97-af63-f85e89040290")
    private SmDependency associationDep;

    @objid ("5df7847a-01bb-4900-839a-9c2683f4988c")
    public AssociationEndSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("cf0f974b-a0dc-4477-be90-1fe5f45f843a")
    @Override
    public String getName() {
        return "AssociationEnd";

    }

    @objid ("3edde155-8ce3-44b4-a345-c936a43e8ced")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("694094a6-e587-4729-b5bf-deeb38c0d6e6")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AssociationEnd.class;

    }

    @objid ("fcc1e8dd-6a6d-4e56-8696-dbb15798ef61")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f6348313-b963-4419-81ac-d6961c73fcec")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1debc996-217a-4fd5-bc72-84b6a2faab53")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuralFeature.MQNAME);
        this.registerFactory(new AssociationEndObjectFactory(this));


        // Initialize and register the SmAttribute
        this.aggregationAtt = new AggregationSmAttribute();
        this.aggregationAtt.init("Aggregation", this, AggregationKind.class );
        registerAttribute(this.aggregationAtt);

        this.isChangeableAtt = new IsChangeableSmAttribute();
        this.isChangeableAtt.init("IsChangeable", this, Boolean.class );
        registerAttribute(this.isChangeableAtt);


        // Initialize and register the SmDependency
        this.targetDep = new TargetSmDependency();
        this.targetDep.init("Target", this, metamodel.getMClass(Classifier.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetDep);

        this.oppositeOwnerDep = new OppositeOwnerSmDependency();
        this.oppositeOwnerDep.init("OppositeOwner", this, metamodel.getMClass(AssociationEnd.MQNAME), 1, 1 );
        registerDependency(this.oppositeOwnerDep);

        this.sourceDep = new SourceSmDependency();
        this.sourceDep.init("Source", this, metamodel.getMClass(Classifier.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE, SmDirective.SMCDPARTOF);
        registerDependency(this.sourceDep);

        this.occurenceDep = new OccurenceSmDependency();
        this.occurenceDep.init("Occurence", this, metamodel.getMClass(LinkEnd.MQNAME), 0, -1 );
        registerDependency(this.occurenceDep);

        this.sentDep = new SentSmDependency();
        this.sentDep.init("Sent", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.sentDep);

        this.qualifierDep = new QualifierSmDependency();
        this.qualifierDep.init("Qualifier", this, metamodel.getMClass(Attribute.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.qualifierDep);

        this.oppositeDep = new OppositeSmDependency();
        this.oppositeDep.init("Opposite", this, metamodel.getMClass(AssociationEnd.MQNAME), 1, 1 , SmDirective.SMCDSHAREDCOMPONENT, SmDirective.SMCDPARTOF);
        registerDependency(this.oppositeDep);

        this.representingObjectNodeDep = new RepresentingObjectNodeSmDependency();
        this.representingObjectNodeDep.init("RepresentingObjectNode", this, metamodel.getMClass(ObjectNode.MQNAME), 0, -1 );
        registerDependency(this.representingObjectNodeDep);

        this.associationDep = new AssociationSmDependency();
        this.associationDep.init("Association", this, metamodel.getMClass(Association.MQNAME), 0, 1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.associationDep);

    }

    @objid ("ea454411-ed0a-466e-a597-e29dfe9ffbbf")
    public SmAttribute getAggregationAtt() {
        if (this.aggregationAtt == null) {
        	this.aggregationAtt = this.getAttributeDef("Aggregation");
        }
        return this.aggregationAtt;
    }

    @objid ("452a476e-b1a5-40a5-a90e-9ba4e6e5b1b2")
    public SmAttribute getIsChangeableAtt() {
        if (this.isChangeableAtt == null) {
        	this.isChangeableAtt = this.getAttributeDef("IsChangeable");
        }
        return this.isChangeableAtt;
    }

    @objid ("33f4bd7c-21c0-4292-9e15-7e3850a0e416")
    public SmDependency getTargetDep() {
        if (this.targetDep == null) {
        	this.targetDep = this.getDependencyDef("Target");
        }
        return this.targetDep;
    }

    @objid ("a4a9f29b-6e70-432e-935f-3fe22932d8fb")
    public SmDependency getOppositeOwnerDep() {
        if (this.oppositeOwnerDep == null) {
        	this.oppositeOwnerDep = this.getDependencyDef("OppositeOwner");
        }
        return this.oppositeOwnerDep;
    }

    @objid ("353cf7ed-f170-4166-957f-fd7bf6ebd221")
    public SmDependency getSourceDep() {
        if (this.sourceDep == null) {
        	this.sourceDep = this.getDependencyDef("Source");
        }
        return this.sourceDep;
    }

    @objid ("0c073f26-32c3-4bd4-bd1c-8d6c2e628aaa")
    public SmDependency getOccurenceDep() {
        if (this.occurenceDep == null) {
        	this.occurenceDep = this.getDependencyDef("Occurence");
        }
        return this.occurenceDep;
    }

    @objid ("eb9395a5-e74c-4870-9a2a-26eb172a2c5c")
    public SmDependency getSentDep() {
        if (this.sentDep == null) {
        	this.sentDep = this.getDependencyDef("Sent");
        }
        return this.sentDep;
    }

    @objid ("c20469e1-0bd9-474a-acb1-c85ad0d4684a")
    public SmDependency getQualifierDep() {
        if (this.qualifierDep == null) {
        	this.qualifierDep = this.getDependencyDef("Qualifier");
        }
        return this.qualifierDep;
    }

    @objid ("ec292a2f-eea9-432a-b3da-d8c91a979c48")
    public SmDependency getOppositeDep() {
        if (this.oppositeDep == null) {
        	this.oppositeDep = this.getDependencyDef("Opposite");
        }
        return this.oppositeDep;
    }

    @objid ("2f1dbe39-d1dd-4e60-b6a2-eb82463b8a31")
    public SmDependency getRepresentingObjectNodeDep() {
        if (this.representingObjectNodeDep == null) {
        	this.representingObjectNodeDep = this.getDependencyDef("RepresentingObjectNode");
        }
        return this.representingObjectNodeDep;
    }

    @objid ("4e128147-8e34-4241-af52-b88344c6b26b")
    public SmDependency getAssociationDep() {
        if (this.associationDep == null) {
        	this.associationDep = this.getDependencyDef("Association");
        }
        return this.associationDep;
    }

    @objid ("02bcbba7-01d0-412f-8746-be0ae3a7b9f0")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("c755cf6a-9176-4b3e-84ee-ce0e6653cee0")
    private static class AssociationEndObjectFactory implements ISmObjectFactory {
        @objid ("c2c5910c-1c77-49b8-8385-e924bcb5b7df")
        private AssociationEndSmClass smClass;

        @objid ("ee2b7b95-2590-4898-baa5-2fbcf948982e")
        public AssociationEndObjectFactory(AssociationEndSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("728028a2-7dab-4bea-ac30-536ddc4da69f")
        @Override
        public ISmObjectData createData() {
            return new AssociationEndData(this.smClass);
        }

        @objid ("b729d092-fdca-4bc3-995f-e90169683f7a")
        @Override
        public SmObjectImpl createImpl() {
            return new AssociationEndImpl();
        }

    }

    @objid ("e22b9317-a200-4003-a22b-ac84fe9b529d")
    public static class AggregationSmAttribute extends SmAttribute {
        @objid ("17add2bb-2198-4480-b7bf-7561a3d78f60")
        public Object getValue(ISmObjectData data) {
            return ((AssociationEndData) data).mAggregation;
        }

        @objid ("18e122e3-05bc-44af-a0d0-b57a1ce1959a")
        public void setValue(ISmObjectData data, Object value) {
            ((AssociationEndData) data).mAggregation = value;
        }

    }

    @objid ("85827985-6af9-4831-8c50-97c044471d81")
    public static class IsChangeableSmAttribute extends SmAttribute {
        @objid ("161e55eb-915c-4259-9a67-9a872ee76bfe")
        public Object getValue(ISmObjectData data) {
            return ((AssociationEndData) data).mIsChangeable;
        }

        @objid ("ca45ad86-d751-4b66-87a2-914b682d7f29")
        public void setValue(ISmObjectData data, Object value) {
            ((AssociationEndData) data).mIsChangeable = value;
        }

    }

    @objid ("a808be23-d37a-4bd8-bc63-467f3365b1f2")
    public static class TargetSmDependency extends SmSingleDependency {
        @objid ("7a5af7fe-2d9b-4be1-b6d4-18ebff67a253")
        private SmDependency symetricDep;

        @objid ("6d0bf521-6ccb-48e2-9d94-a1621d33981c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AssociationEndData) data).mTarget;
        }

        @objid ("965360e1-d2d4-44ed-9904-8e5a7d431972")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AssociationEndData) data).mTarget = value;
        }

        @objid ("de05e3bf-865a-4c60-9221-5cda4fc84c95")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getTargetingEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("29ec0581-183b-4158-9042-6cc1b1e92245")
    public static class OppositeOwnerSmDependency extends SmSingleDependency {
        @objid ("7fcbc937-de17-433f-89c0-d12ff998b5d3")
        private SmDependency symetricDep;

        @objid ("8d150914-b3d1-4ce0-8575-a9fbee9858f1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AssociationEndData) data).mOppositeOwner;
        }

        @objid ("ca7a48af-19ef-4b81-9592-e0587432c312")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AssociationEndData) data).mOppositeOwner = value;
        }

        @objid ("5e40cd9b-58b1-4052-92b3-b388e992ed49")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getOppositeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c357fa21-8b52-42d1-a3b4-f8a5c1315418")
    public static class SourceSmDependency extends SmSingleDependency {
        @objid ("20666aba-53f6-4406-a19d-6088b2a46287")
        private SmDependency symetricDep;

        @objid ("91d49a7c-c12c-47d6-a04e-e8889ba89f9d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AssociationEndData) data).mSource;
        }

        @objid ("4975b3a4-be57-4c8e-8a12-7acdffbd138b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AssociationEndData) data).mSource = value;
        }

        @objid ("ccc35f83-97e9-4b6d-9a26-b0d9d343feba")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getOwnedEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("26b7b734-c54b-4bde-8f7b-e3ac58833ffe")
    public static class OccurenceSmDependency extends SmMultipleDependency {
        @objid ("6b4fe96a-dae0-4dd6-95af-d93eb7039fe5")
        private SmDependency symetricDep;

        @objid ("cea3e713-cb3c-4cfe-a034-adc359f72590")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AssociationEndData)data).mOccurence != null)? ((AssociationEndData)data).mOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("9ad41a4a-3cd7-4a4f-93bd-151a6cbf3fb5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AssociationEndData) data).mOccurence = values;

        }

        @objid ("e142c833-8568-443c-895d-1d59f71112b4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getModelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9ed8e04f-12fa-4bfa-ba44-0bef5a276229")
    public static class SentSmDependency extends SmMultipleDependency {
        @objid ("45d7cacd-8193-440b-a8f5-7ab5dff34a66")
        private SmDependency symetricDep;

        @objid ("87907e04-bbea-4d88-b99b-cebf2beca0eb")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AssociationEndData)data).mSent != null)? ((AssociationEndData)data).mSent:SmMultipleDependency.EMPTY;
        }

        @objid ("25873851-161b-4636-a519-ac5210414100")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AssociationEndData) data).mSent = values;

        }

        @objid ("506225ef-35c7-4dfa-ba5d-b39e93f97d86")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getChannelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9b8e6644-4d3d-4dd2-b0aa-9d17fa9c0ec6")
    public static class QualifierSmDependency extends SmMultipleDependency {
        @objid ("58717ec1-49ce-4241-8dfa-116cc29b36ea")
        private SmDependency symetricDep;

        @objid ("12a2c5e9-0673-4c2c-b9ae-7439715d911a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AssociationEndData)data).mQualifier != null)? ((AssociationEndData)data).mQualifier:SmMultipleDependency.EMPTY;
        }

        @objid ("dc82302d-a35d-4769-be05-b68c9fc988f8")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AssociationEndData) data).mQualifier = values;

        }

        @objid ("874e2a43-419b-4869-a1f2-298bb2ba9d1c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AttributeSmClass)this.getTarget()).getQualifiedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f8e98a0d-6a7c-4187-8ca7-42ab46974e22")
    public static class OppositeSmDependency extends SmSingleDependency {
        @objid ("fdc8bd5c-fb7c-4898-af7e-7e9bf619f393")
        private SmDependency symetricDep;

        @objid ("168c0b07-e481-4043-8c78-456a94ba5ca9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AssociationEndData) data).mOpposite;
        }

        @objid ("56b12eab-235c-49e2-97c3-440ea35daeac")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AssociationEndData) data).mOpposite = value;
        }

        @objid ("d24a5093-5928-4575-be17-61bbf6352086")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getOppositeOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2eea3770-c667-49c7-9f8e-16d470bef17e")
    public static class RepresentingObjectNodeSmDependency extends SmMultipleDependency {
        @objid ("22d79485-a2d7-42ed-8a3b-8d40c533f4de")
        private SmDependency symetricDep;

        @objid ("c721ca4c-0a37-408e-8af4-8a50ebfba496")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AssociationEndData)data).mRepresentingObjectNode != null)? ((AssociationEndData)data).mRepresentingObjectNode:SmMultipleDependency.EMPTY;
        }

        @objid ("06e2b7fd-7fc0-4963-a99e-484a17afe079")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AssociationEndData) data).mRepresentingObjectNode = values;

        }

        @objid ("0c1c8ab9-fdbb-499d-b09a-3ccf0244295a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ObjectNodeSmClass)this.getTarget()).getRepresentedRoleDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ea8bef16-1dc9-46ac-a473-bf81ef42a1e1")
    public static class AssociationSmDependency extends SmSingleDependency {
        @objid ("5d016ea9-209a-4285-ae99-0e6a2a17d045")
        private SmDependency symetricDep;

        @objid ("3c77195a-4e4d-447d-b8ae-52944a1984a1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AssociationEndData) data).mAssociation;
        }

        @objid ("06380aca-15ef-48b2-a315-58d892f166be")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AssociationEndData) data).mAssociation = value;
        }

        @objid ("4fa9e818-f92e-46f4-a0f9-b690a27327c0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationSmClass)this.getTarget()).getEndDep();
            }
            return this.symetricDep;

        }

    }

}
