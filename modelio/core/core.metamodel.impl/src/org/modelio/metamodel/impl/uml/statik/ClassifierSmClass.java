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
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.InformationItemSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.SubstitutionSmClass;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.informationFlow.InformationItem;
import org.modelio.metamodel.uml.infrastructure.Substitution;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.ComponentRealization;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.RaisedException;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c6d08e12-abc9-48e2-9aad-856b7d6bec01")
public class ClassifierSmClass extends NameSpaceSmClass {
    @objid ("ebb671c5-72e6-47c9-bf88-939507d180b8")
    private SmDependency ownedOperationDep;

    @objid ("98365b9f-ba1a-43b9-9c1d-e1b646a86fe2")
    private SmDependency representationDep;

    @objid ("b5d73255-b007-4628-82b7-b337c8afca98")
    private SmDependency substituedDep;

    @objid ("db2a0db0-fd3c-4bf0-a5e5-31cf441db79d")
    private SmDependency ownedAttributeDep;

    @objid ("eb474d9d-1699-4e09-a25d-0418071cec51")
    private SmDependency ownedNaryEndDep;

    @objid ("fc42f684-8194-4ca1-8dd2-57a97fd96b00")
    private SmDependency conveyerDep;

    @objid ("d3287733-f28a-4783-96b2-18938f88b813")
    private SmDependency substitutingSubstitutionDep;

    @objid ("c4833a9b-4db6-4e0d-9d4f-e321d9d57b25")
    private SmDependency targetingEndDep;

    @objid ("c8f112e5-234e-4ca4-a12b-5b0d884e8f49")
    private SmDependency ownedEndDep;

    @objid ("ec3fada8-d036-42d4-b8bf-338cde15ae47")
    private SmDependency throwingDep;

    @objid ("6196e3b0-1978-4a06-8ae5-ff34356c975f")
    private SmDependency internalStructureDep;

    @objid ("36d1371b-c940-4387-a32c-7b55e2d4478e")
    private SmDependency realizedComponentDep;

    @objid ("f490c774-92b1-4ef3-aae2-cff5ca8d9d9e")
    public ClassifierSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("78ce0040-5ac1-422f-adf3-470e7f24ebfb")
    @Override
    public String getName() {
        return "Classifier";

    }

    @objid ("617bdc8b-ba3f-44e4-99f3-b5b2568ec158")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e7a2228c-584b-4206-9a5c-3a38b7da64e8")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Classifier.class;

    }

    @objid ("7e610297-a9f8-4a72-a4a8-2aa5b548edc4")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("92c03b8e-d888-4375-9784-120e73c71958")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("ca674b48-1d21-4cf4-a117-edd135d7aea5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(NameSpace.MQNAME);
        this.registerFactory(new ClassifierObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownedOperationDep = new OwnedOperationSmDependency();
        this.ownedOperationDep.init("OwnedOperation", this, metamodel.getMClass(Operation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedOperationDep);

        this.representationDep = new RepresentationSmDependency();
        this.representationDep.init("Representation", this, metamodel.getMClass(InformationItem.MQNAME), 0, -1 );
        registerDependency(this.representationDep);

        this.substituedDep = new SubstituedSmDependency();
        this.substituedDep.init("Substitued", this, metamodel.getMClass(Substitution.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.substituedDep);

        this.ownedAttributeDep = new OwnedAttributeSmDependency();
        this.ownedAttributeDep.init("OwnedAttribute", this, metamodel.getMClass(Attribute.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedAttributeDep);

        this.ownedNaryEndDep = new OwnedNaryEndSmDependency();
        this.ownedNaryEndDep.init("OwnedNaryEnd", this, metamodel.getMClass(NaryAssociationEnd.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedNaryEndDep);

        this.conveyerDep = new ConveyerSmDependency();
        this.conveyerDep.init("Conveyer", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.conveyerDep);

        this.substitutingSubstitutionDep = new SubstitutingSubstitutionSmDependency();
        this.substitutingSubstitutionDep.init("SubstitutingSubstitution", this, metamodel.getMClass(Substitution.MQNAME), 0, -1 );
        registerDependency(this.substitutingSubstitutionDep);

        this.targetingEndDep = new TargetingEndSmDependency();
        this.targetingEndDep.init("TargetingEnd", this, metamodel.getMClass(AssociationEnd.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.targetingEndDep);

        this.ownedEndDep = new OwnedEndSmDependency();
        this.ownedEndDep.init("OwnedEnd", this, metamodel.getMClass(AssociationEnd.MQNAME), 0, -1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.ownedEndDep);

        this.throwingDep = new ThrowingSmDependency();
        this.throwingDep.init("Throwing", this, metamodel.getMClass(RaisedException.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.throwingDep);

        this.internalStructureDep = new InternalStructureSmDependency();
        this.internalStructureDep.init("InternalStructure", this, metamodel.getMClass(BindableInstance.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.internalStructureDep);

        this.realizedComponentDep = new RealizedComponentSmDependency();
        this.realizedComponentDep.init("RealizedComponent", this, metamodel.getMClass(ComponentRealization.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.realizedComponentDep);

    }

    @objid ("fbd75bf2-fff2-4233-a3ac-304bf52e1e55")
    public SmDependency getOwnedOperationDep() {
        if (this.ownedOperationDep == null) {
        	this.ownedOperationDep = this.getDependencyDef("OwnedOperation");
        }
        return this.ownedOperationDep;
    }

    @objid ("3effa6d0-d139-4538-966e-1d00625c6fef")
    public SmDependency getRepresentationDep() {
        if (this.representationDep == null) {
        	this.representationDep = this.getDependencyDef("Representation");
        }
        return this.representationDep;
    }

    @objid ("76520a01-fd35-4944-bf91-c04be4245e8d")
    public SmDependency getSubstituedDep() {
        if (this.substituedDep == null) {
        	this.substituedDep = this.getDependencyDef("Substitued");
        }
        return this.substituedDep;
    }

    @objid ("cde5f713-fbfd-4d05-b6f2-1692c8679a15")
    public SmDependency getOwnedAttributeDep() {
        if (this.ownedAttributeDep == null) {
        	this.ownedAttributeDep = this.getDependencyDef("OwnedAttribute");
        }
        return this.ownedAttributeDep;
    }

    @objid ("40ae086b-991f-4e27-84e5-9473a9f0dc37")
    public SmDependency getOwnedNaryEndDep() {
        if (this.ownedNaryEndDep == null) {
        	this.ownedNaryEndDep = this.getDependencyDef("OwnedNaryEnd");
        }
        return this.ownedNaryEndDep;
    }

    @objid ("b316d6f1-daa0-4f05-b961-5b226a599c7c")
    public SmDependency getConveyerDep() {
        if (this.conveyerDep == null) {
        	this.conveyerDep = this.getDependencyDef("Conveyer");
        }
        return this.conveyerDep;
    }

    @objid ("23576bd2-01ee-4cdb-a695-c2505b47e115")
    public SmDependency getSubstitutingSubstitutionDep() {
        if (this.substitutingSubstitutionDep == null) {
        	this.substitutingSubstitutionDep = this.getDependencyDef("SubstitutingSubstitution");
        }
        return this.substitutingSubstitutionDep;
    }

    @objid ("0535acec-1f68-4a3c-9f62-605b91658794")
    public SmDependency getTargetingEndDep() {
        if (this.targetingEndDep == null) {
        	this.targetingEndDep = this.getDependencyDef("TargetingEnd");
        }
        return this.targetingEndDep;
    }

    @objid ("a2c101e1-e823-4044-8eab-e9e1854ef9ec")
    public SmDependency getOwnedEndDep() {
        if (this.ownedEndDep == null) {
        	this.ownedEndDep = this.getDependencyDef("OwnedEnd");
        }
        return this.ownedEndDep;
    }

    @objid ("2f2902f0-f639-492a-b852-273845ee23b2")
    public SmDependency getThrowingDep() {
        if (this.throwingDep == null) {
        	this.throwingDep = this.getDependencyDef("Throwing");
        }
        return this.throwingDep;
    }

    @objid ("cd3bb7c4-79d4-45d6-8854-9ab52f90c472")
    public SmDependency getInternalStructureDep() {
        if (this.internalStructureDep == null) {
        	this.internalStructureDep = this.getDependencyDef("InternalStructure");
        }
        return this.internalStructureDep;
    }

    @objid ("c5617b12-7cb6-4ae6-a00b-d12305174ae2")
    public SmDependency getRealizedComponentDep() {
        if (this.realizedComponentDep == null) {
        	this.realizedComponentDep = this.getDependencyDef("RealizedComponent");
        }
        return this.realizedComponentDep;
    }

    @objid ("685c54f1-2371-4e8d-bed2-df269cfb7b47")
    private static class ClassifierObjectFactory implements ISmObjectFactory {
        @objid ("59551af2-a9a9-44e0-8e2e-e476437587f7")
        private ClassifierSmClass smClass;

        @objid ("6f3b3d07-a6e8-4e9a-9ac3-565be2fd4b21")
        public ClassifierObjectFactory(ClassifierSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("95d8ede9-2c53-48b8-83cf-82b445fe908b")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("ec9f313a-7e1a-4713-808f-8b4f3c4301d3")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("ef1083a1-245d-4a28-bc2d-02cac01e6333")
    public static class OwnedOperationSmDependency extends SmMultipleDependency {
        @objid ("e7e15d68-4628-40b9-9fa8-d2880375e163")
        private SmDependency symetricDep;

        @objid ("12fc76f5-62e8-498c-97a2-34b283621b13")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mOwnedOperation != null)? ((ClassifierData)data).mOwnedOperation:SmMultipleDependency.EMPTY;
        }

        @objid ("3e4b3ef0-eb2b-4930-88c5-54d651c064af")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mOwnedOperation = values;

        }

        @objid ("e03276b6-da88-46f2-bcba-381d5f974b93")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1dba1f3a-1542-4f02-862f-e25814682565")
    public static class RepresentationSmDependency extends SmMultipleDependency {
        @objid ("044f3e5e-856d-4cd4-a568-60d08af3f3a8")
        private SmDependency symetricDep;

        @objid ("16506d29-b1c7-4bee-9df1-83ba29c11825")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mRepresentation != null)? ((ClassifierData)data).mRepresentation:SmMultipleDependency.EMPTY;
        }

        @objid ("77e671cc-4e08-4f67-8ffa-d472a5332850")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mRepresentation = values;

        }

        @objid ("8c09ab4d-0581-488d-98ef-13ab11863371")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationItemSmClass)this.getTarget()).getRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2a64a01a-a561-4e14-a820-bb6cbf9fe7c4")
    public static class SubstituedSmDependency extends SmMultipleDependency {
        @objid ("11c97b08-8a6d-41dd-90d0-09b147d31f89")
        private SmDependency symetricDep;

        @objid ("a425429f-59f3-417b-9c52-7a6d1db0f8f2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mSubstitued != null)? ((ClassifierData)data).mSubstitued:SmMultipleDependency.EMPTY;
        }

        @objid ("ac00ab66-7694-4cda-af9b-da443d991520")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mSubstitued = values;

        }

        @objid ("d44a27cb-8342-42e8-9efd-c6e1abcb5b28")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SubstitutionSmClass)this.getTarget()).getSubstitutingClassifierDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0e1896c2-4d72-482e-9f36-9a60625c795b")
    public static class OwnedAttributeSmDependency extends SmMultipleDependency {
        @objid ("ae1504ae-7ed4-4ee4-8da3-72001339458d")
        private SmDependency symetricDep;

        @objid ("1feeb5ea-5660-4a7f-8939-bc60a511a149")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mOwnedAttribute != null)? ((ClassifierData)data).mOwnedAttribute:SmMultipleDependency.EMPTY;
        }

        @objid ("6bd9731f-b07e-45fd-944a-e77d51f54b93")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mOwnedAttribute = values;

        }

        @objid ("1bfe0437-bbfc-4770-b286-d20107b905d7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AttributeSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("00ed1591-25bb-45a0-852d-763512aaea5a")
    public static class OwnedNaryEndSmDependency extends SmMultipleDependency {
        @objid ("718b02dd-afb7-4015-83ec-c9642887d170")
        private SmDependency symetricDep;

        @objid ("e04cb5fa-454f-47cd-b6b5-4102f0e60d84")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mOwnedNaryEnd != null)? ((ClassifierData)data).mOwnedNaryEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("9da37ca9-f5ef-44ce-9c98-f4b7ab9bac61")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mOwnedNaryEnd = values;

        }

        @objid ("461d9ad7-5ff3-4c68-8ef2-15341a5d31ef")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryAssociationEndSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("766999c8-5745-4b32-b382-58d9c73c3614")
    public static class ConveyerSmDependency extends SmMultipleDependency {
        @objid ("75a45815-9eea-4c0b-8d13-e9c9ec5bb3ae")
        private SmDependency symetricDep;

        @objid ("746b64aa-f5d8-4350-ae59-b5c9ee2006a6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mConveyer != null)? ((ClassifierData)data).mConveyer:SmMultipleDependency.EMPTY;
        }

        @objid ("727b3750-98b2-4e3f-a475-1a4653f461d1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mConveyer = values;

        }

        @objid ("5d07fd51-b0dd-4ee4-b602-0fe7265fec39")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getConveyedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e506e0ae-fa8b-4e43-9a0d-0ca173d0a686")
    public static class SubstitutingSubstitutionSmDependency extends SmMultipleDependency {
        @objid ("f9afa9c4-4185-499f-98e8-a347dde32d72")
        private SmDependency symetricDep;

        @objid ("8d6c33df-5f35-4467-bf0e-3c38d32a7602")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mSubstitutingSubstitution != null)? ((ClassifierData)data).mSubstitutingSubstitution:SmMultipleDependency.EMPTY;
        }

        @objid ("52799cf2-1e8f-48e3-a415-9adfca2850ce")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mSubstitutingSubstitution = values;

        }

        @objid ("37521034-fc4c-467b-80dd-c8dc992cfe2f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SubstitutionSmClass)this.getTarget()).getContractDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("383f66b0-471b-4db6-9219-dc17487c2aad")
    public static class TargetingEndSmDependency extends SmMultipleDependency {
        @objid ("a4ad88c1-c46c-420e-b35c-c2f6a8656248")
        private SmDependency symetricDep;

        @objid ("4ed637ed-2cca-4593-a3ac-7c4f74f4e77f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mTargetingEnd != null)? ((ClassifierData)data).mTargetingEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("25e67abd-0fe6-4f7a-aaf2-3ba6427fe7bb")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mTargetingEnd = values;

        }

        @objid ("05f925ff-b00f-48c0-a51f-41552d54d091")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getTargetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4cd4a23f-4e3b-40d7-afbc-3982ebb7d722")
    public static class OwnedEndSmDependency extends SmMultipleDependency {
        @objid ("04519387-0fdb-44c4-ba87-5769f71147a4")
        private SmDependency symetricDep;

        @objid ("d98eb280-3929-4eca-8a6b-7263e59e4d85")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mOwnedEnd != null)? ((ClassifierData)data).mOwnedEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("96ebcbe2-4205-4537-b20e-f584b924094f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mOwnedEnd = values;

        }

        @objid ("9fa0ae7a-79a7-4104-ad75-c5089a1afd37")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getSourceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("434128d1-5af0-4052-92e0-d7327252d3c5")
    public static class ThrowingSmDependency extends SmMultipleDependency {
        @objid ("8880819f-975c-49d3-ab52-ef287dc5b5d4")
        private SmDependency symetricDep;

        @objid ("972ebc5c-0951-4b0a-a909-61c0b203995c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mThrowing != null)? ((ClassifierData)data).mThrowing:SmMultipleDependency.EMPTY;
        }

        @objid ("ea4b0094-a8d3-4d3e-9093-f92ec8eedfae")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mThrowing = values;

        }

        @objid ("be586bd5-1e29-42f1-af5e-a1b2c0cf72e2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RaisedExceptionSmClass)this.getTarget()).getThrownTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b847a639-1e06-4ff5-8224-df0b693d2b8e")
    public static class InternalStructureSmDependency extends SmMultipleDependency {
        @objid ("076f37aa-0fc0-42ea-b524-004a94b56fd2")
        private SmDependency symetricDep;

        @objid ("144422f7-1867-49cc-90b9-969c8fc68efa")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mInternalStructure != null)? ((ClassifierData)data).mInternalStructure:SmMultipleDependency.EMPTY;
        }

        @objid ("0bef6dc7-0025-4876-9298-849563d9e101")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mInternalStructure = values;

        }

        @objid ("5ff31dd2-f9fc-4808-b575-5a642990f42a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindableInstanceSmClass)this.getTarget()).getInternalOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("81c54bea-7d1a-41e3-a29d-def781c5a6d8")
    public static class RealizedComponentSmDependency extends SmMultipleDependency {
        @objid ("a93f2d41-d6dd-4209-b66a-5bf232075697")
        private SmDependency symetricDep;

        @objid ("9e2cafdb-4b0d-41a9-a182-ef447382cb7f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClassifierData)data).mRealizedComponent != null)? ((ClassifierData)data).mRealizedComponent:SmMultipleDependency.EMPTY;
        }

        @objid ("757835d2-6659-4747-a06b-4e19cd225489")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClassifierData) data).mRealizedComponent = values;

        }

        @objid ("47afb652-c1a1-43c4-90c5-d9a3a95deb89")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ComponentRealizationSmClass)this.getTarget()).getRealizingClassifierDep();
            }
            return this.symetricDep;

        }

    }

}
