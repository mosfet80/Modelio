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
import org.modelio.metamodel.impl.uml.behavior.activityModel.AcceptCallEventActionSmClass;
import org.modelio.metamodel.impl.uml.behavior.activityModel.CallOperationActionSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.EventSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.impl.uml.behavior.communicationModel.CommunicationMessageSmClass;
import org.modelio.metamodel.impl.uml.behavior.interactionModel.MessageSmClass;
import org.modelio.metamodel.impl.uml.behavior.stateMachineModel.TransitionSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptCallEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.CallOperationAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.statik.BehavioralFeature;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.ElementImport;
import org.modelio.metamodel.uml.statik.MethodPassingMode;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.uml.statik.RaisedException;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameter;
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

@objid ("77952079-f367-4e69-ac13-e2a961f78214")
public class OperationSmClass extends BehavioralFeatureSmClass {
    @objid ("5a5241b4-f31e-48e6-b477-4a2cb3a4d568")
    private SmAttribute concurrencyAtt;

    @objid ("276c6621-9c49-4fef-b7b8-05c7088e2d35")
    private SmAttribute finalAtt;

    @objid ("36d207c7-ee04-4451-89f4-a05a36cdb57b")
    private SmAttribute passingAtt;

    @objid ("2f9c7a01-fd29-4073-9a8b-173828fb794d")
    private SmDependency ownedImportDep;

    @objid ("a291efff-535f-4974-8e34-9795887451e3")
    private SmDependency thrownDep;

    @objid ("b50838bf-624e-4dc0-b4f3-c45c78d5bdab")
    private SmDependency redefinitionDep;

    @objid ("22823007-2cbc-4a9f-be4b-bc9698d40f31")
    private SmDependency exampleDep;

    @objid ("0e0a3628-bb01-46fa-9db2-2899ae0f1b46")
    private SmDependency sRepresentationDep;

    @objid ("1c07e0cd-9a2b-4ddd-9469-59bfbdd94b07")
    private SmDependency ownedBehaviorDep;

    @objid ("4d6a036c-d230-48d5-9cc4-c2edd239aad2")
    private SmDependency iODep;

    @objid ("89333ece-74b5-4d4e-a32c-c900b387ceef")
    private SmDependency templateInstanciationDep;

    @objid ("7307e30e-6a47-41e4-ba9c-e78e6baca5c5")
    private SmDependency ownerDep;

    @objid ("650e8495-a364-442a-9cff-6aa5fff5bcc3")
    private SmDependency ownedPackageImportDep;

    @objid ("d1d145d4-16f1-488b-a99c-e1bd4c87f8d0")
    private SmDependency returnDep;

    @objid ("35038af2-9578-49ec-96b2-ee7cb00c818b")
    private SmDependency instanciatingBindingDep;

    @objid ("6e8cffa6-3622-4a43-b2d3-8be0009a4028")
    private SmDependency usageDep;

    @objid ("57af2184-be85-4924-94d0-b5dacbf055ea")
    private SmDependency templateDep;

    @objid ("dc84d480-9551-4b04-9b93-b707b0544be2")
    private SmDependency occurenceDep;

    @objid ("bd5b8194-cadf-45a6-be96-c2dcaf1fcd41")
    private SmDependency invokerDep;

    @objid ("3a3ba708-b49d-4255-ac76-df0add2894ed")
    private SmDependency communicationUsageDep;

    @objid ("f6b604ae-fa92-4eef-8fac-86dc506e1a42")
    private SmDependency ownedCollaborationUseDep;

    @objid ("cb299e26-10d7-44b8-8e20-e05a9b7444b6")
    private SmDependency redefinesDep;

    @objid ("96ee1440-e42c-4175-bebe-ec17462687d5")
    private SmDependency callingActionDep;

    @objid ("ce7dbc76-7cfa-45b2-a4b0-40b8891afed4")
    private SmDependency entryPointActionDep;

    @objid ("78eb8189-3692-40cc-a3f5-b561625ab92c")
    public OperationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("31e70e78-a00c-45c8-bf94-fa0cc1ffe7d4")
    @Override
    public String getName() {
        return "Operation";

    }

    @objid ("de0dc737-eacd-490d-bc46-fbe13c77a11d")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("b8c1d845-05ed-4db5-836d-be24d7cebdff")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Operation.class;

    }

    @objid ("ce93c006-5e08-491c-9c0f-7d90367c420e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("00bd1a6e-34e3-4ab6-85c7-61f7274f378e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d9a501c3-42d3-472b-94f1-99d325fe88a5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehavioralFeature.MQNAME);
        this.registerFactory(new OperationObjectFactory(this));


        // Initialize and register the SmAttribute
        this.concurrencyAtt = new ConcurrencySmAttribute();
        this.concurrencyAtt.init("Concurrency", this, Boolean.class );
        registerAttribute(this.concurrencyAtt);

        this.finalAtt = new FinalSmAttribute();
        this.finalAtt.init("Final", this, Boolean.class );
        registerAttribute(this.finalAtt);

        this.passingAtt = new PassingSmAttribute();
        this.passingAtt.init("Passing", this, MethodPassingMode.class );
        registerAttribute(this.passingAtt);


        // Initialize and register the SmDependency
        this.ownedImportDep = new OwnedImportSmDependency();
        this.ownedImportDep.init("OwnedImport", this, metamodel.getMClass(ElementImport.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedImportDep);

        this.thrownDep = new ThrownSmDependency();
        this.thrownDep.init("Thrown", this, metamodel.getMClass(RaisedException.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.thrownDep);

        this.redefinitionDep = new RedefinitionSmDependency();
        this.redefinitionDep.init("Redefinition", this, metamodel.getMClass(Operation.MQNAME), 0, -1 );
        registerDependency(this.redefinitionDep);

        this.exampleDep = new ExampleSmDependency();
        this.exampleDep.init("Example", this, metamodel.getMClass(Collaboration.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.exampleDep);

        this.sRepresentationDep = new SRepresentationSmDependency();
        this.sRepresentationDep.init("SRepresentation", this, metamodel.getMClass(Signal.MQNAME), 0, -1 );
        registerDependency(this.sRepresentationDep);

        this.ownedBehaviorDep = new OwnedBehaviorSmDependency();
        this.ownedBehaviorDep.init("OwnedBehavior", this, metamodel.getMClass(Behavior.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedBehaviorDep);

        this.iODep = new IOSmDependency();
        this.iODep.init("IO", this, metamodel.getMClass(Parameter.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.iODep);

        this.templateInstanciationDep = new TemplateInstanciationSmDependency();
        this.templateInstanciationDep.init("TemplateInstanciation", this, metamodel.getMClass(TemplateBinding.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.templateInstanciationDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(Classifier.MQNAME), 1, 1 );
        registerDependency(this.ownerDep);

        this.ownedPackageImportDep = new OwnedPackageImportSmDependency();
        this.ownedPackageImportDep.init("OwnedPackageImport", this, metamodel.getMClass(PackageImport.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedPackageImportDep);

        this.returnDep = new ReturnSmDependency();
        this.returnDep.init("Return", this, metamodel.getMClass(Parameter.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.returnDep);

        this.instanciatingBindingDep = new InstanciatingBindingSmDependency();
        this.instanciatingBindingDep.init("InstanciatingBinding", this, metamodel.getMClass(TemplateBinding.MQNAME), 0, -1 );
        registerDependency(this.instanciatingBindingDep);

        this.usageDep = new UsageSmDependency();
        this.usageDep.init("Usage", this, metamodel.getMClass(Message.MQNAME), 0, -1 );
        registerDependency(this.usageDep);

        this.templateDep = new TemplateSmDependency();
        this.templateDep.init("Template", this, metamodel.getMClass(TemplateParameter.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.templateDep);

        this.occurenceDep = new OccurenceSmDependency();
        this.occurenceDep.init("Occurence", this, metamodel.getMClass(Event.MQNAME), 0, -1 );
        registerDependency(this.occurenceDep);

        this.invokerDep = new InvokerSmDependency();
        this.invokerDep.init("Invoker", this, metamodel.getMClass(Transition.MQNAME), 0, -1 );
        registerDependency(this.invokerDep);

        this.communicationUsageDep = new CommunicationUsageSmDependency();
        this.communicationUsageDep.init("CommunicationUsage", this, metamodel.getMClass(CommunicationMessage.MQNAME), 0, -1 );
        registerDependency(this.communicationUsageDep);

        this.ownedCollaborationUseDep = new OwnedCollaborationUseSmDependency();
        this.ownedCollaborationUseDep.init("OwnedCollaborationUse", this, metamodel.getMClass(CollaborationUse.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedCollaborationUseDep);

        this.redefinesDep = new RedefinesSmDependency();
        this.redefinesDep.init("Redefines", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.redefinesDep);

        this.callingActionDep = new CallingActionSmDependency();
        this.callingActionDep.init("CallingAction", this, metamodel.getMClass(CallOperationAction.MQNAME), 0, -1 );
        registerDependency(this.callingActionDep);

        this.entryPointActionDep = new EntryPointActionSmDependency();
        this.entryPointActionDep.init("EntryPointAction", this, metamodel.getMClass(AcceptCallEventAction.MQNAME), 0, -1 );
        registerDependency(this.entryPointActionDep);

    }

    @objid ("e7f1b29a-d412-49fa-a23b-934666a39973")
    public SmAttribute getConcurrencyAtt() {
        if (this.concurrencyAtt == null) {
        	this.concurrencyAtt = this.getAttributeDef("Concurrency");
        }
        return this.concurrencyAtt;
    }

    @objid ("45438c5a-f172-4312-9c7a-0eaea5695524")
    public SmAttribute getFinalAtt() {
        if (this.finalAtt == null) {
        	this.finalAtt = this.getAttributeDef("Final");
        }
        return this.finalAtt;
    }

    @objid ("31d57ebf-990b-444c-82cc-60900814f724")
    public SmAttribute getPassingAtt() {
        if (this.passingAtt == null) {
        	this.passingAtt = this.getAttributeDef("Passing");
        }
        return this.passingAtt;
    }

    @objid ("323e1f6a-f4aa-4fc4-9f93-c2d53fe13231")
    public SmDependency getOwnedImportDep() {
        if (this.ownedImportDep == null) {
        	this.ownedImportDep = this.getDependencyDef("OwnedImport");
        }
        return this.ownedImportDep;
    }

    @objid ("f1f9b17d-0798-40c0-b772-63e7fadcdb8f")
    public SmDependency getThrownDep() {
        if (this.thrownDep == null) {
        	this.thrownDep = this.getDependencyDef("Thrown");
        }
        return this.thrownDep;
    }

    @objid ("7833a805-298f-426e-bc7e-7dbd3634464e")
    public SmDependency getRedefinitionDep() {
        if (this.redefinitionDep == null) {
        	this.redefinitionDep = this.getDependencyDef("Redefinition");
        }
        return this.redefinitionDep;
    }

    @objid ("ba9fecd8-061f-4d8a-a34d-d741eeaf45b1")
    public SmDependency getExampleDep() {
        if (this.exampleDep == null) {
        	this.exampleDep = this.getDependencyDef("Example");
        }
        return this.exampleDep;
    }

    @objid ("34c91980-14af-43d0-9c43-4c5078b4878c")
    public SmDependency getSRepresentationDep() {
        if (this.sRepresentationDep == null) {
        	this.sRepresentationDep = this.getDependencyDef("SRepresentation");
        }
        return this.sRepresentationDep;
    }

    @objid ("28811d2e-da44-46f0-9e52-171edee6ee4f")
    public SmDependency getOwnedBehaviorDep() {
        if (this.ownedBehaviorDep == null) {
        	this.ownedBehaviorDep = this.getDependencyDef("OwnedBehavior");
        }
        return this.ownedBehaviorDep;
    }

    @objid ("78920199-9379-45aa-9b28-97f1b821658d")
    public SmDependency getIODep() {
        if (this.iODep == null) {
        	this.iODep = this.getDependencyDef("IO");
        }
        return this.iODep;
    }

    @objid ("48e0a78d-d1d3-4ecf-918a-9d94643b967f")
    public SmDependency getTemplateInstanciationDep() {
        if (this.templateInstanciationDep == null) {
        	this.templateInstanciationDep = this.getDependencyDef("TemplateInstanciation");
        }
        return this.templateInstanciationDep;
    }

    @objid ("beea392c-d4fe-49cf-83ad-f0f298441c15")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("9c14e66c-ccbb-4b6f-b8a8-9fb87a175d68")
    public SmDependency getOwnedPackageImportDep() {
        if (this.ownedPackageImportDep == null) {
        	this.ownedPackageImportDep = this.getDependencyDef("OwnedPackageImport");
        }
        return this.ownedPackageImportDep;
    }

    @objid ("0e1c93d4-55cf-4785-abbb-7fbbf37517c9")
    public SmDependency getReturnDep() {
        if (this.returnDep == null) {
        	this.returnDep = this.getDependencyDef("Return");
        }
        return this.returnDep;
    }

    @objid ("022d91e1-b6d5-417d-ad02-84dfa8d57b8b")
    public SmDependency getInstanciatingBindingDep() {
        if (this.instanciatingBindingDep == null) {
        	this.instanciatingBindingDep = this.getDependencyDef("InstanciatingBinding");
        }
        return this.instanciatingBindingDep;
    }

    @objid ("a1d81f63-8d02-49eb-906d-b21a5937e506")
    public SmDependency getUsageDep() {
        if (this.usageDep == null) {
        	this.usageDep = this.getDependencyDef("Usage");
        }
        return this.usageDep;
    }

    @objid ("2367f7ec-c8d1-4827-96fe-d57c9d998b89")
    public SmDependency getTemplateDep() {
        if (this.templateDep == null) {
        	this.templateDep = this.getDependencyDef("Template");
        }
        return this.templateDep;
    }

    @objid ("25f7cd0f-7645-40da-828e-1800d74e892b")
    public SmDependency getOccurenceDep() {
        if (this.occurenceDep == null) {
        	this.occurenceDep = this.getDependencyDef("Occurence");
        }
        return this.occurenceDep;
    }

    @objid ("b64ef839-e088-44fc-9a51-96a31b0892d3")
    public SmDependency getInvokerDep() {
        if (this.invokerDep == null) {
        	this.invokerDep = this.getDependencyDef("Invoker");
        }
        return this.invokerDep;
    }

    @objid ("a34df8ae-b4cb-4078-b0c3-5e112d0fea53")
    public SmDependency getCommunicationUsageDep() {
        if (this.communicationUsageDep == null) {
        	this.communicationUsageDep = this.getDependencyDef("CommunicationUsage");
        }
        return this.communicationUsageDep;
    }

    @objid ("233f932d-f3f1-4b9a-85ff-efcc9ef81d5e")
    public SmDependency getOwnedCollaborationUseDep() {
        if (this.ownedCollaborationUseDep == null) {
        	this.ownedCollaborationUseDep = this.getDependencyDef("OwnedCollaborationUse");
        }
        return this.ownedCollaborationUseDep;
    }

    @objid ("bf7cc99f-caeb-4880-a760-91fa3678f1ce")
    public SmDependency getRedefinesDep() {
        if (this.redefinesDep == null) {
        	this.redefinesDep = this.getDependencyDef("Redefines");
        }
        return this.redefinesDep;
    }

    @objid ("42e6fb37-43de-4dab-816d-ca663d875041")
    public SmDependency getCallingActionDep() {
        if (this.callingActionDep == null) {
        	this.callingActionDep = this.getDependencyDef("CallingAction");
        }
        return this.callingActionDep;
    }

    @objid ("d231fb28-407d-40fd-82a8-d9302805c843")
    public SmDependency getEntryPointActionDep() {
        if (this.entryPointActionDep == null) {
        	this.entryPointActionDep = this.getDependencyDef("EntryPointAction");
        }
        return this.entryPointActionDep;
    }

    @objid ("76c379d0-e15b-4821-8ccd-974572eb27ea")
    private static class OperationObjectFactory implements ISmObjectFactory {
        @objid ("4b28b2dc-d0ba-4e77-97a6-e1325b5db059")
        private OperationSmClass smClass;

        @objid ("71d5befb-3be1-435b-8de0-969a437a50f7")
        public OperationObjectFactory(OperationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("34317003-cd14-40fc-b49b-491f47c1f81f")
        @Override
        public ISmObjectData createData() {
            return new OperationData(this.smClass);
        }

        @objid ("03e4b4d7-112a-4d3d-8513-15267f3eccbb")
        @Override
        public SmObjectImpl createImpl() {
            return new OperationImpl();
        }

    }

    @objid ("254abfff-54ad-4592-95e5-7605e9dae0a5")
    public static class ConcurrencySmAttribute extends SmAttribute {
        @objid ("00eb52b8-01b2-4860-8591-609a6351d134")
        public Object getValue(ISmObjectData data) {
            return ((OperationData) data).mConcurrency;
        }

        @objid ("6128bb13-e282-4049-b379-6266e9d5120f")
        public void setValue(ISmObjectData data, Object value) {
            ((OperationData) data).mConcurrency = value;
        }

    }

    @objid ("479fde10-969e-44d1-ba1d-d2bbef38b95e")
    public static class FinalSmAttribute extends SmAttribute {
        @objid ("2a7bacbf-1be9-495d-9f33-c7a7617a4c78")
        public Object getValue(ISmObjectData data) {
            return ((OperationData) data).mFinal;
        }

        @objid ("f82949f3-51c5-4d92-8d45-c41a17bbd39c")
        public void setValue(ISmObjectData data, Object value) {
            ((OperationData) data).mFinal = value;
        }

    }

    @objid ("ca3b3684-ceb7-4ee8-aef2-9165cc5c5a16")
    public static class PassingSmAttribute extends SmAttribute {
        @objid ("d6c91509-b68b-4ae9-a1fc-8f7b392468f2")
        public Object getValue(ISmObjectData data) {
            return ((OperationData) data).mPassing;
        }

        @objid ("3feb518f-9616-4c92-ac40-46230df0eeb7")
        public void setValue(ISmObjectData data, Object value) {
            ((OperationData) data).mPassing = value;
        }

    }

    @objid ("2ace98de-3193-4aef-ac7c-7df813947b13")
    public static class OwnedImportSmDependency extends SmMultipleDependency {
        @objid ("847c7c35-70ce-4518-b582-e48d78ddf2cf")
        private SmDependency symetricDep;

        @objid ("e142e3c2-e1d1-48ce-9027-2d0360c73c7a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mOwnedImport != null)? ((OperationData)data).mOwnedImport:SmMultipleDependency.EMPTY;
        }

        @objid ("7c71b56c-606e-4ca9-9fdb-c7fe56b8e042")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mOwnedImport = values;

        }

        @objid ("5c10f75a-338b-4bb5-9aa8-7afceea5bd16")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ElementImportSmClass)this.getTarget()).getImportingOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ab875c73-915b-46bf-beb3-2152915d67e3")
    public static class ThrownSmDependency extends SmMultipleDependency {
        @objid ("4bac8ff4-5172-4d94-9d1c-ff56c5e999b5")
        private SmDependency symetricDep;

        @objid ("d8552d5b-19bb-48ea-80c3-594c22f5206e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mThrown != null)? ((OperationData)data).mThrown:SmMultipleDependency.EMPTY;
        }

        @objid ("fa6d82ad-4471-495d-b1c1-0f581db20db7")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mThrown = values;

        }

        @objid ("bff2f4b1-01fb-4120-a9ea-28ffea5a5822")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RaisedExceptionSmClass)this.getTarget()).getThrowerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0a834e8c-f893-44ef-bdce-4fc91425a58b")
    public static class RedefinitionSmDependency extends SmMultipleDependency {
        @objid ("b6c4f92a-e498-42a9-9358-f5fcc61cfc39")
        private SmDependency symetricDep;

        @objid ("3a9cb42b-5245-41c6-a16f-a30a2590dca9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mRedefinition != null)? ((OperationData)data).mRedefinition:SmMultipleDependency.EMPTY;
        }

        @objid ("952b0906-254a-4bfe-a230-98ca2363d0fe")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mRedefinition = values;

        }

        @objid ("c4f93ebd-cfa6-4dd8-9057-212c90d6f35f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getRedefinesDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("60915d0a-8116-4a27-b704-43bb4a9d9ed0")
    public static class ExampleSmDependency extends SmMultipleDependency {
        @objid ("4407a870-dd75-4393-bd98-d795bc84b3ed")
        private SmDependency symetricDep;

        @objid ("5b3aec60-7b88-4c6d-91be-a568d68e05e9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mExample != null)? ((OperationData)data).mExample:SmMultipleDependency.EMPTY;
        }

        @objid ("5901e1af-dd90-45ec-b9e7-c7dcb334ce78")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mExample = values;

        }

        @objid ("ff76611b-3333-465e-9bfb-fb629b6507ed")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CollaborationSmClass)this.getTarget()).getORepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4a8de98c-99d5-44b5-9b86-ad6207628d43")
    public static class SRepresentationSmDependency extends SmMultipleDependency {
        @objid ("c5986e3a-b18f-41b9-a2f8-481911a14195")
        private SmDependency symetricDep;

        @objid ("a214ed98-bdd2-42fb-95c6-3e2b766e7910")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mSRepresentation != null)? ((OperationData)data).mSRepresentation:SmMultipleDependency.EMPTY;
        }

        @objid ("35f66b13-608b-4dfc-9414-a73b4515eb8a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mSRepresentation = values;

        }

        @objid ("026b7500-5b03-4880-bcd1-92badae5e212")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getOBaseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e29cea00-7756-4e46-b1a3-86c6623aa618")
    public static class OwnedBehaviorSmDependency extends SmMultipleDependency {
        @objid ("46021c30-c7a7-4694-8669-d9b7f24f5052")
        private SmDependency symetricDep;

        @objid ("7500628e-2d15-4a57-8839-30f9f3b7d44d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mOwnedBehavior != null)? ((OperationData)data).mOwnedBehavior:SmMultipleDependency.EMPTY;
        }

        @objid ("0080ff6e-1a16-4fc7-9fea-6d076dace6fd")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mOwnedBehavior = values;

        }

        @objid ("c507f0e9-9861-4391-904b-3f3b115ad581")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorSmClass)this.getTarget()).getOwnerOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3b718d45-779d-4646-ab3e-3c4994d65f48")
    public static class IOSmDependency extends SmMultipleDependency {
        @objid ("08830769-ec7b-4af5-9e1d-272fd03963f7")
        private SmDependency symetricDep;

        @objid ("ffdd858c-42e0-4e1a-a5fd-4dec0a42eb90")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mIO != null)? ((OperationData)data).mIO:SmMultipleDependency.EMPTY;
        }

        @objid ("6c194c18-6387-45a4-a897-c9900a79ef4f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mIO = values;

        }

        @objid ("b7c68bd3-2d0e-4e21-9e37-e31cafb27812")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ParameterSmClass)this.getTarget()).getComposedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("76bd60b7-dda2-4ba3-9844-66c17157bce6")
    public static class TemplateInstanciationSmDependency extends SmMultipleDependency {
        @objid ("37582495-b463-492f-bd16-c1ca57563afd")
        private SmDependency symetricDep;

        @objid ("9f82c67b-b97f-4712-8e85-72d93d1c639b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mTemplateInstanciation != null)? ((OperationData)data).mTemplateInstanciation:SmMultipleDependency.EMPTY;
        }

        @objid ("b64e5264-ef7d-420e-8e3d-46932299e809")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mTemplateInstanciation = values;

        }

        @objid ("97fd7941-00c8-4e88-ae7b-62f2e053e27f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateBindingSmClass)this.getTarget()).getBoundOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("04963292-b6ff-4ff5-9a9f-3f186b3bfd5e")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("3a76d471-0e27-4df2-9670-f80e51abc883")
        private SmDependency symetricDep;

        @objid ("6950b110-a782-405e-bc7f-2a72dc4fe1fe")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((OperationData) data).mOwner;
        }

        @objid ("d4e243ec-d64b-411e-b3da-fff6653b451f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((OperationData) data).mOwner = value;
        }

        @objid ("4f582f46-c573-4187-a7aa-df4c02167112")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getOwnedOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3429a6f5-ec0a-41bc-9dd2-c2c3469a7d88")
    public static class OwnedPackageImportSmDependency extends SmMultipleDependency {
        @objid ("9a81ef42-c27e-409e-a2a6-21a8bcc81bd2")
        private SmDependency symetricDep;

        @objid ("94afb04f-3cb4-41d3-8142-0df609302230")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mOwnedPackageImport != null)? ((OperationData)data).mOwnedPackageImport:SmMultipleDependency.EMPTY;
        }

        @objid ("d72b635a-ed8f-4956-bd46-44565198f0aa")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mOwnedPackageImport = values;

        }

        @objid ("585c7dc2-0a80-4cf3-9a32-8b744d892166")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageImportSmClass)this.getTarget()).getImportingOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ca88d1b4-db75-4ced-ad12-48c9947f2cd6")
    public static class ReturnSmDependency extends SmSingleDependency {
        @objid ("b929519d-acfb-4459-a411-c5d1ef5cc463")
        private SmDependency symetricDep;

        @objid ("2082157d-52e7-4162-8059-d3592fd8e139")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((OperationData) data).mReturn;
        }

        @objid ("7796ec9c-974a-4984-8007-1a42dfd0b9ee")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((OperationData) data).mReturn = value;
        }

        @objid ("6cc4c1e6-4d1f-4ace-995e-28f5d877cb29")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ParameterSmClass)this.getTarget()).getReturnedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1554b2bd-e156-49d0-8545-4062a1bb73fa")
    public static class InstanciatingBindingSmDependency extends SmMultipleDependency {
        @objid ("cf73dfd2-a865-4750-8206-19112ca2a1bb")
        private SmDependency symetricDep;

        @objid ("4c641719-68ba-4f6c-bce7-ac0a5db72aa2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mInstanciatingBinding != null)? ((OperationData)data).mInstanciatingBinding:SmMultipleDependency.EMPTY;
        }

        @objid ("b42c58ec-8077-41dd-8fe2-4a2d37f88995")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mInstanciatingBinding = values;

        }

        @objid ("8120d1e1-6446-4c0f-be5a-7a8a7ac611d8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateBindingSmClass)this.getTarget()).getInstanciatedTemplateOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0c4c1b2f-aa4f-49c8-a27e-4b85f3e987b8")
    public static class UsageSmDependency extends SmMultipleDependency {
        @objid ("1d9a63b7-d50e-4574-a726-dd003309b06d")
        private SmDependency symetricDep;

        @objid ("b7bf6ea9-58dc-40fd-b149-c8d50e28794b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mUsage != null)? ((OperationData)data).mUsage:SmMultipleDependency.EMPTY;
        }

        @objid ("5261d136-5343-4cf1-ad06-4750c1f96a92")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mUsage = values;

        }

        @objid ("38da9ef9-86db-4c8f-9888-c76cdda7ca0c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageSmClass)this.getTarget()).getInvokedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c4f3b18b-8f70-4bf9-99f4-00f832451fff")
    public static class TemplateSmDependency extends SmMultipleDependency {
        @objid ("29e6ac11-96e4-47bc-a61a-85f7d5a24eda")
        private SmDependency symetricDep;

        @objid ("afecd6f2-57ff-4351-a64a-7742e4cf71c5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mTemplate != null)? ((OperationData)data).mTemplate:SmMultipleDependency.EMPTY;
        }

        @objid ("92cda4c1-8001-465b-9ff0-100543dc3515")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mTemplate = values;

        }

        @objid ("21c35127-1f84-4452-87a9-683025d61a38")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSmClass)this.getTarget()).getParameterizedOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6e716761-7481-4f11-9d31-6e66884488ae")
    public static class OccurenceSmDependency extends SmMultipleDependency {
        @objid ("f780f193-ebf6-4ef4-a6e0-ef6fe9a6a4d4")
        private SmDependency symetricDep;

        @objid ("8e1e62fb-097d-45e3-9875-205a087fee61")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mOccurence != null)? ((OperationData)data).mOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("ebded321-070e-483a-9b5e-09347896ad21")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mOccurence = values;

        }

        @objid ("a270a0d8-3ac9-4a59-af66-55f56ab01aa7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EventSmClass)this.getTarget()).getCalledDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5e106519-07f7-4957-afa2-be9f96b77191")
    public static class InvokerSmDependency extends SmMultipleDependency {
        @objid ("83e5f310-7149-4aa6-a5c3-65124bf9c398")
        private SmDependency symetricDep;

        @objid ("f82fda6d-9d6e-46af-b3ab-9a5138f2c043")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mInvoker != null)? ((OperationData)data).mInvoker:SmMultipleDependency.EMPTY;
        }

        @objid ("336bda44-0fec-4a1c-8fa8-7fb7fc6c48a9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mInvoker = values;

        }

        @objid ("b286d9a0-9f16-45b3-ad47-4d2fe0496370")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TransitionSmClass)this.getTarget()).getProcessedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ac03716b-0820-413e-9a0f-f210c825ab9a")
    public static class CommunicationUsageSmDependency extends SmMultipleDependency {
        @objid ("c7eb3bea-5ede-4413-9a02-fe0af9bdba0b")
        private SmDependency symetricDep;

        @objid ("0a3192e2-e139-4c8f-ac32-5a3001007c16")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mCommunicationUsage != null)? ((OperationData)data).mCommunicationUsage:SmMultipleDependency.EMPTY;
        }

        @objid ("ce891644-32d7-4755-a2e6-92a23d10e350")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mCommunicationUsage = values;

        }

        @objid ("dc4f9a6c-5ce1-4636-844b-478620b74af3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationMessageSmClass)this.getTarget()).getInvokedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b1217edd-f868-48d4-b6e8-c5798c6a7e35")
    public static class OwnedCollaborationUseSmDependency extends SmMultipleDependency {
        @objid ("66e4388a-4170-4acf-b270-72a02bc9bfc8")
        private SmDependency symetricDep;

        @objid ("03972683-6d59-4f90-9fac-810599e2c383")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mOwnedCollaborationUse != null)? ((OperationData)data).mOwnedCollaborationUse:SmMultipleDependency.EMPTY;
        }

        @objid ("d14e7674-29c1-4d24-865e-01c003936742")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mOwnedCollaborationUse = values;

        }

        @objid ("0075ce59-f754-4406-bf08-9a534788b650")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CollaborationUseSmClass)this.getTarget()).getORepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6010358c-fa56-4d8f-a3f5-08a92433bf2d")
    public static class RedefinesSmDependency extends SmSingleDependency {
        @objid ("a7a729e8-1c33-41a1-823e-6b37d56b8705")
        private SmDependency symetricDep;

        @objid ("2e1b4e9e-b84e-44ca-8d96-2f0f9a8b7694")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((OperationData) data).mRedefines;
        }

        @objid ("c12c7c93-ab07-420a-b5dd-f6bd1ba2e465")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((OperationData) data).mRedefines = value;
        }

        @objid ("0587ddc3-d8cf-4111-935b-1b889dbf3da7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getRedefinitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a246685e-73bf-444f-85a6-3273229fc2a1")
    public static class CallingActionSmDependency extends SmMultipleDependency {
        @objid ("6ba4aefa-d817-4e09-ae60-3084efb60c3a")
        private SmDependency symetricDep;

        @objid ("0704b76a-2adf-4c26-a716-6e0885e974f6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mCallingAction != null)? ((OperationData)data).mCallingAction:SmMultipleDependency.EMPTY;
        }

        @objid ("f9814fb5-c56d-48d2-b5c8-84873242e120")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mCallingAction = values;

        }

        @objid ("10a497b4-d152-45f4-bcd3-8d4999e93f98")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CallOperationActionSmClass)this.getTarget()).getCalledDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3ad28c8c-9723-4e2f-b10a-1da36dda3d4e")
    public static class EntryPointActionSmDependency extends SmMultipleDependency {
        @objid ("e540b3e3-19dd-4cd3-b539-64c88effe7cd")
        private SmDependency symetricDep;

        @objid ("afe0fdb2-063c-4ea2-ba36-05af041493dc")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OperationData)data).mEntryPointAction != null)? ((OperationData)data).mEntryPointAction:SmMultipleDependency.EMPTY;
        }

        @objid ("e1f4e219-2f44-4a8a-ae03-e939f463a382")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OperationData) data).mEntryPointAction = values;

        }

        @objid ("76f5ae4e-8a66-45a0-8476-d5bcad325d2c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AcceptCallEventActionSmClass)this.getTarget()).getCalledDep();
            }
            return this.symetricDep;

        }

    }

}
