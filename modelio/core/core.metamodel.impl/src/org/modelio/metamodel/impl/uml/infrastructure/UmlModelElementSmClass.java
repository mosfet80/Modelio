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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.ActivityPartitionSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.ModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.BindableInstanceSmClass;
import org.modelio.metamodel.impl.uml.statik.BindingSmClass;
import org.modelio.metamodel.impl.uml.statik.ConnectorEndSmClass;
import org.modelio.metamodel.impl.uml.statik.ManifestationSmClass;
import org.modelio.metamodel.impl.uml.statik.NaryConnectorSmClass;
import org.modelio.metamodel.impl.uml.statik.TemplateParameterSmClass;
import org.modelio.metamodel.impl.uml.statik.TemplateParameterSubstitutionSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.metamodel.uml.statik.NaryConnector;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;
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

@objid ("dac456b2-2978-4c10-b927-63fc6d53a265")
public class UmlModelElementSmClass extends ModelElementSmClass {
    @objid ("bbb58984-80a6-4f4d-8979-52e9eda3fcdb")
    private SmDependency templateSubstitutionDep;

    @objid ("05e8a1fa-1db0-45b7-87b1-b2e97462cb9f")
    private SmDependency defaultParameteringDep;

    @objid ("46595eba-9b51-45b5-ab1a-d4bcaa2665a1")
    private SmDependency representsDep;

    @objid ("c7512228-c307-41ea-a236-bbcc69f8cf37")
    private SmDependency ownerTemplateParameterDep;

    @objid ("e0e432bc-c47c-426b-b8d1-b563d103aca1")
    private SmDependency representingEndDep;

    @objid ("29125920-8b7d-43d9-97e4-68dcac56fc9f")
    private SmDependency representingPartitionDep;

    @objid ("f4070ace-0a2a-46a4-a31d-90dfff916d7b")
    private SmDependency constraintDefinitionDep;

    @objid ("8fd1f77f-0174-4628-8358-06ffdc320e3b")
    private SmDependency typingParameterDep;

    @objid ("5ff51afc-1d2f-4e29-b13f-879774827c96")
    private SmDependency manifestingDep;

    @objid ("3049d230-01d1-4d21-9bf4-a987b3cd3b1e")
    private SmDependency representingInstanceDep;

    @objid ("a3695761-d1a0-4b68-b1d1-05179196cfde")
    private SmDependency receivedInfoDep;

    @objid ("a7155186-f3b0-4882-8f33-bf4713accdd0")
    private SmDependency sentInfoDep;

    @objid ("b9a11a5b-98a3-4d69-9279-c2b8f071669c")
    private SmDependency representingConnectorDep;

    @objid ("2dbb27b6-198b-4aec-9658-c1768e2bb5f0")
    public UmlModelElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("94b35bc2-f11d-4936-a57c-ec0741cca2e3")
    @Override
    public String getName() {
        return "UmlModelElement";

    }

    @objid ("31d495ab-7b04-44a3-93a0-e4b12a4f7842")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f147926d-3cab-402d-932f-9594423e6cda")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return UmlModelElement.class;

    }

    @objid ("291bff9f-ae9d-40b6-b775-a72002e68bef")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("c3353f7a-357e-4003-b781-6695bb1b42be")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("587e8914-38bf-4521-b384-c056718073a7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ModelElement.MQNAME);
        this.registerFactory(new UmlModelElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.templateSubstitutionDep = new TemplateSubstitutionSmDependency();
        this.templateSubstitutionDep.init("TemplateSubstitution", this, metamodel.getMClass(TemplateParameterSubstitution.MQNAME), 0, -1 );
        registerDependency(this.templateSubstitutionDep);

        this.defaultParameteringDep = new DefaultParameteringSmDependency();
        this.defaultParameteringDep.init("DefaultParametering", this, metamodel.getMClass(TemplateParameter.MQNAME), 0, -1 );
        registerDependency(this.defaultParameteringDep);

        this.representsDep = new RepresentsSmDependency();
        this.representsDep.init("Represents", this, metamodel.getMClass(Binding.MQNAME), 0, -1 );
        registerDependency(this.representsDep);

        this.ownerTemplateParameterDep = new OwnerTemplateParameterSmDependency();
        this.ownerTemplateParameterDep.init("OwnerTemplateParameter", this, metamodel.getMClass(TemplateParameter.MQNAME), 0, 1 );
        registerDependency(this.ownerTemplateParameterDep);

        this.representingEndDep = new RepresentingEndSmDependency();
        this.representingEndDep.init("RepresentingEnd", this, metamodel.getMClass(ConnectorEnd.MQNAME), 0, -1 );
        registerDependency(this.representingEndDep);

        this.representingPartitionDep = new RepresentingPartitionSmDependency();
        this.representingPartitionDep.init("RepresentingPartition", this, metamodel.getMClass(ActivityPartition.MQNAME), 0, -1 );
        registerDependency(this.representingPartitionDep);

        this.constraintDefinitionDep = new ConstraintDefinitionSmDependency();
        this.constraintDefinitionDep.init("ConstraintDefinition", this, metamodel.getMClass(Constraint.MQNAME), 0, -1 , SmDirective.SMCDSHAREDCOMPONENT, SmDirective.SMCDTODELETE);
        registerDependency(this.constraintDefinitionDep);

        this.typingParameterDep = new TypingParameterSmDependency();
        this.typingParameterDep.init("TypingParameter", this, metamodel.getMClass(TemplateParameter.MQNAME), 0, -1 );
        registerDependency(this.typingParameterDep);

        this.manifestingDep = new ManifestingSmDependency();
        this.manifestingDep.init("Manifesting", this, metamodel.getMClass(Manifestation.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.manifestingDep);

        this.representingInstanceDep = new RepresentingInstanceSmDependency();
        this.representingInstanceDep.init("RepresentingInstance", this, metamodel.getMClass(BindableInstance.MQNAME), 0, -1 );
        registerDependency(this.representingInstanceDep);

        this.receivedInfoDep = new ReceivedInfoSmDependency();
        this.receivedInfoDep.init("ReceivedInfo", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.receivedInfoDep);

        this.sentInfoDep = new SentInfoSmDependency();
        this.sentInfoDep.init("SentInfo", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.sentInfoDep);

        this.representingConnectorDep = new RepresentingConnectorSmDependency();
        this.representingConnectorDep.init("RepresentingConnector", this, metamodel.getMClass(NaryConnector.MQNAME), 0, -1 );
        registerDependency(this.representingConnectorDep);

    }

    @objid ("08cfe8e6-dcf0-4ef6-b3fd-a2104ff37573")
    public SmDependency getTemplateSubstitutionDep() {
        if (this.templateSubstitutionDep == null) {
        	this.templateSubstitutionDep = this.getDependencyDef("TemplateSubstitution");
        }
        return this.templateSubstitutionDep;
    }

    @objid ("b13c79cd-4591-4d56-8eec-78e31dbff25d")
    public SmDependency getDefaultParameteringDep() {
        if (this.defaultParameteringDep == null) {
        	this.defaultParameteringDep = this.getDependencyDef("DefaultParametering");
        }
        return this.defaultParameteringDep;
    }

    @objid ("a310aa3b-135e-4d4f-a265-940db0333d66")
    public SmDependency getRepresentsDep() {
        if (this.representsDep == null) {
        	this.representsDep = this.getDependencyDef("Represents");
        }
        return this.representsDep;
    }

    @objid ("579c394c-b6dd-4b66-bff2-5c891bdf9abd")
    public SmDependency getOwnerTemplateParameterDep() {
        if (this.ownerTemplateParameterDep == null) {
        	this.ownerTemplateParameterDep = this.getDependencyDef("OwnerTemplateParameter");
        }
        return this.ownerTemplateParameterDep;
    }

    @objid ("93c9dc5f-9ae1-447a-80e5-e17cd6640170")
    public SmDependency getRepresentingEndDep() {
        if (this.representingEndDep == null) {
        	this.representingEndDep = this.getDependencyDef("RepresentingEnd");
        }
        return this.representingEndDep;
    }

    @objid ("8233c235-d339-4110-8033-c79a17f16850")
    public SmDependency getRepresentingPartitionDep() {
        if (this.representingPartitionDep == null) {
        	this.representingPartitionDep = this.getDependencyDef("RepresentingPartition");
        }
        return this.representingPartitionDep;
    }

    @objid ("6e8b1dce-35c8-4584-a39f-94a7967461ad")
    public SmDependency getConstraintDefinitionDep() {
        if (this.constraintDefinitionDep == null) {
        	this.constraintDefinitionDep = this.getDependencyDef("ConstraintDefinition");
        }
        return this.constraintDefinitionDep;
    }

    @objid ("36d69eca-4bc1-4175-9d14-bf1da91ea7db")
    public SmDependency getTypingParameterDep() {
        if (this.typingParameterDep == null) {
        	this.typingParameterDep = this.getDependencyDef("TypingParameter");
        }
        return this.typingParameterDep;
    }

    @objid ("9400bdf5-6ca9-4c7f-aa4d-c5b653ed8c57")
    public SmDependency getManifestingDep() {
        if (this.manifestingDep == null) {
        	this.manifestingDep = this.getDependencyDef("Manifesting");
        }
        return this.manifestingDep;
    }

    @objid ("edfa9cdf-eee1-44f5-bc40-41a5dd138c06")
    public SmDependency getRepresentingInstanceDep() {
        if (this.representingInstanceDep == null) {
        	this.representingInstanceDep = this.getDependencyDef("RepresentingInstance");
        }
        return this.representingInstanceDep;
    }

    @objid ("9b59be98-6586-4dfc-9400-567ee7ef93fd")
    public SmDependency getReceivedInfoDep() {
        if (this.receivedInfoDep == null) {
        	this.receivedInfoDep = this.getDependencyDef("ReceivedInfo");
        }
        return this.receivedInfoDep;
    }

    @objid ("7d217837-d623-4886-9e4c-3f5c1f8d7043")
    public SmDependency getSentInfoDep() {
        if (this.sentInfoDep == null) {
        	this.sentInfoDep = this.getDependencyDef("SentInfo");
        }
        return this.sentInfoDep;
    }

    @objid ("cf2ab75a-3151-4d62-bbab-23c19a1303bb")
    public SmDependency getRepresentingConnectorDep() {
        if (this.representingConnectorDep == null) {
        	this.representingConnectorDep = this.getDependencyDef("RepresentingConnector");
        }
        return this.representingConnectorDep;
    }

    @objid ("4a3cb52e-f85b-46cc-8e7e-5ba166bd8908")
    private static class UmlModelElementObjectFactory implements ISmObjectFactory {
        @objid ("19b8d33c-7f29-43e6-ae2f-fb8d5f63f054")
        private UmlModelElementSmClass smClass;

        @objid ("bad0cde5-b42a-4428-be7c-ce3d7839da19")
        public UmlModelElementObjectFactory(UmlModelElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("16440cb3-2b3e-4d38-8422-52dff1ea3be2")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("ba9cd56e-7221-4537-9398-8e4dfa7d8bed")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("15f32f2d-f9d3-4bce-a514-4f465b7f88fb")
    public static class TemplateSubstitutionSmDependency extends SmMultipleDependency {
        @objid ("695acf9f-ed8f-46ca-8218-3ad1d238aa49")
        private SmDependency symetricDep;

        @objid ("fc0f5cdd-9300-4126-88bd-7bfdc3da25dd")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mTemplateSubstitution != null)? ((UmlModelElementData)data).mTemplateSubstitution:SmMultipleDependency.EMPTY;
        }

        @objid ("74642641-7807-41e8-8e74-7f4204a308f5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mTemplateSubstitution = values;

        }

        @objid ("0e1a846e-675b-40a5-ad4e-6f13cf7fdd6c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSubstitutionSmClass)this.getTarget()).getActualDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("193becd3-9601-4440-a204-ef1b4360b996")
    public static class DefaultParameteringSmDependency extends SmMultipleDependency {
        @objid ("a5d2c367-f684-4579-baaf-c09ace73c1f0")
        private SmDependency symetricDep;

        @objid ("fe61453c-1d8e-4091-9181-07428a4c380a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mDefaultParametering != null)? ((UmlModelElementData)data).mDefaultParametering:SmMultipleDependency.EMPTY;
        }

        @objid ("9c36ca3b-258c-4af0-89ea-bf45adcb4a8d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mDefaultParametering = values;

        }

        @objid ("646c36e3-57c1-408f-aa1f-fb0d8e58b7a9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSmClass)this.getTarget()).getDefaultTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d4751fbc-ecdf-4900-800c-c79bb72062c3")
    public static class RepresentsSmDependency extends SmMultipleDependency {
        @objid ("748d832c-328b-42ad-bcc5-93d526fe10e9")
        private SmDependency symetricDep;

        @objid ("0e11ef0e-b7cf-4eee-94fa-02d06ad59725")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mRepresents != null)? ((UmlModelElementData)data).mRepresents:SmMultipleDependency.EMPTY;
        }

        @objid ("75e71bb1-3583-4ddf-ae12-d32a300b54ad")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mRepresents = values;

        }

        @objid ("c5425dc6-4884-42a6-9e80-293e8a1e15d3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindingSmClass)this.getTarget()).getRepresentedFeatureDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("dffa69dc-3787-4667-b035-eac75be88c8a")
    public static class OwnerTemplateParameterSmDependency extends SmSingleDependency {
        @objid ("3b355633-1703-4efe-9e3b-279f01fe2955")
        private SmDependency symetricDep;

        @objid ("c0bb462d-fbb1-4642-adc0-c52c7b06105d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((UmlModelElementData) data).mOwnerTemplateParameter;
        }

        @objid ("34161164-ee5f-43dc-b0f0-10f9787230ba")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((UmlModelElementData) data).mOwnerTemplateParameter = value;
        }

        @objid ("71b719ee-3907-4d20-97bc-a986e9f6945c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSmClass)this.getTarget()).getOwnedParameterElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("40dbcade-1bff-4954-86fd-a4d40a52e021")
    public static class RepresentingEndSmDependency extends SmMultipleDependency {
        @objid ("ecee5995-7769-41f3-97f9-2cb019508be9")
        private SmDependency symetricDep;

        @objid ("308802ef-e14c-4462-884b-4a9e76731959")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mRepresentingEnd != null)? ((UmlModelElementData)data).mRepresentingEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("12a20c72-85bc-4e94-ab22-2c22a3cee64c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mRepresentingEnd = values;

        }

        @objid ("15c04e52-17c7-4e10-90fa-4ab333b05530")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConnectorEndSmClass)this.getTarget()).getRepresentedFeatureDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d38a7f4a-be92-4c06-b40e-a36e36a1d7c7")
    public static class RepresentingPartitionSmDependency extends SmMultipleDependency {
        @objid ("703bec90-1db5-4532-bef1-330542cc0ba5")
        private SmDependency symetricDep;

        @objid ("0c77baec-8774-4214-8efc-a38a2c07c173")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mRepresentingPartition != null)? ((UmlModelElementData)data).mRepresentingPartition:SmMultipleDependency.EMPTY;
        }

        @objid ("fa924c7e-e3eb-4aa9-9320-f9ba03ee3bae")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mRepresentingPartition = values;

        }

        @objid ("4dc6c95b-ea2a-496f-a760-b5234b20c52a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityPartitionSmClass)this.getTarget()).getRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("69c3a2fa-e958-441d-9f22-48342e4622f6")
    public static class ConstraintDefinitionSmDependency extends SmMultipleDependency {
        @objid ("565c9e6d-8479-46a1-bbd3-262ad714ab34")
        private SmDependency symetricDep;

        @objid ("e32a3735-8718-4cd2-a6b2-ecb8755f4ac4")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mConstraintDefinition != null)? ((UmlModelElementData)data).mConstraintDefinition:SmMultipleDependency.EMPTY;
        }

        @objid ("fe07a1ca-4b61-46c6-b500-a40ee910179a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mConstraintDefinition = values;

        }

        @objid ("94453863-3281-456c-a470-e0e862e3cdac")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConstraintSmClass)this.getTarget()).getConstrainedElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("20836ad0-a6e1-464e-b294-ffc6e2cb761b")
    public static class TypingParameterSmDependency extends SmMultipleDependency {
        @objid ("79eb349d-e2ea-4553-aea6-e065f8281c48")
        private SmDependency symetricDep;

        @objid ("7e0c4151-d4be-4afe-bd55-4ded2d080f3c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mTypingParameter != null)? ((UmlModelElementData)data).mTypingParameter:SmMultipleDependency.EMPTY;
        }

        @objid ("69d703dd-66d0-4626-b72f-c0a89cd1087b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mTypingParameter = values;

        }

        @objid ("2c81b8a1-0482-4e70-8940-2c77728e5af6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSmClass)this.getTarget()).getTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("84a34709-cabc-4d67-828e-67363b3b057f")
    public static class ManifestingSmDependency extends SmMultipleDependency {
        @objid ("593d73b0-03fb-4937-b7c3-d738bd8147e5")
        private SmDependency symetricDep;

        @objid ("fd1139d4-04c1-42b1-bb30-ec391fc85709")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mManifesting != null)? ((UmlModelElementData)data).mManifesting:SmMultipleDependency.EMPTY;
        }

        @objid ("8d5487d3-8c05-4bc7-a837-01efa8308904")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mManifesting = values;

        }

        @objid ("29f191d5-7f5b-4ddd-9e05-714f7168f149")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ManifestationSmClass)this.getTarget()).getUtilizedElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("328355f9-01c1-4ca3-875f-2c3a4557d0f1")
    public static class RepresentingInstanceSmDependency extends SmMultipleDependency {
        @objid ("ae278b4b-ffb4-49c3-be29-f5ba30d6d1bb")
        private SmDependency symetricDep;

        @objid ("80e280ff-dbe5-4bfa-948a-5b22f6396b84")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mRepresentingInstance != null)? ((UmlModelElementData)data).mRepresentingInstance:SmMultipleDependency.EMPTY;
        }

        @objid ("52fc3750-4363-421a-a1a5-60ffacc0f685")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mRepresentingInstance = values;

        }

        @objid ("257d1e19-e5d8-4248-87ac-ffbd6120e208")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindableInstanceSmClass)this.getTarget()).getRepresentedFeatureDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("de1c8ea7-8f0b-4074-9bf2-c20a44e45770")
    public static class ReceivedInfoSmDependency extends SmMultipleDependency {
        @objid ("80f29325-4605-4bed-935e-d38d8e2e1ab2")
        private SmDependency symetricDep;

        @objid ("5adf752b-d214-4a1d-aa3d-b0623677315b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mReceivedInfo != null)? ((UmlModelElementData)data).mReceivedInfo:SmMultipleDependency.EMPTY;
        }

        @objid ("b28933ad-906a-4a1a-8247-a0a00b6df1b8")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mReceivedInfo = values;

        }

        @objid ("9b3b264c-b10c-4201-8aba-23ee0e3fefc6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getInformationTargetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9810647b-3c94-4022-8505-8f9ef4c80a3e")
    public static class SentInfoSmDependency extends SmMultipleDependency {
        @objid ("e02d1b76-7771-4117-b74e-f4328dcfe631")
        private SmDependency symetricDep;

        @objid ("1bc8ba00-1ae8-4c4a-b34e-397ca50daaab")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mSentInfo != null)? ((UmlModelElementData)data).mSentInfo:SmMultipleDependency.EMPTY;
        }

        @objid ("aef3d71e-8265-476a-9bb8-f2e6f1443a94")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mSentInfo = values;

        }

        @objid ("d60cb7f1-0195-4b22-8bfd-856cceec34b1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getInformationSourceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a11e31d7-7a1c-445b-b5d9-4019913fef38")
    public static class RepresentingConnectorSmDependency extends SmMultipleDependency {
        @objid ("27c3b586-d123-4609-9a0e-59da4872fa6e")
        private SmDependency symetricDep;

        @objid ("b0688c50-6307-4085-8cd3-4ca123c77f86")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UmlModelElementData)data).mRepresentingConnector != null)? ((UmlModelElementData)data).mRepresentingConnector:SmMultipleDependency.EMPTY;
        }

        @objid ("fd38db4d-24af-4075-a2d2-6df2d5f1974e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UmlModelElementData) data).mRepresentingConnector = values;

        }

        @objid ("afaf83ee-2ba7-414c-aebc-fb4a32e6803e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryConnectorSmClass)this.getTarget()).getRepresentedFeatureDep();
            }
            return this.symetricDep;

        }

    }

}
