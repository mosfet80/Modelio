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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.DataFlowSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.ModelTreeSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.ElementImport;
import org.modelio.metamodel.uml.statik.Generalization;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.VisibilityMode;
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
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("13b9e8d9-1cce-4eb0-886d-3ddd04faefcc")
public class NameSpaceSmClass extends ModelTreeSmClass {
    @objid ("f476d902-7cc2-4087-97d4-6f4ed70dd817")
    private SmAttribute isAbstractAtt;

    @objid ("dc785cbc-59a7-42f9-b92d-e0f5e83b236f")
    private SmAttribute isLeafAtt;

    @objid ("f47b7587-eb83-462e-ab91-7d3b5f26a684")
    private SmAttribute isRootAtt;

    @objid ("bb308b67-3159-4e0a-8869-24339568537d")
    private SmAttribute visibilityAtt;

    @objid ("f96fdbdf-51e4-4b50-946c-8c7670b1cfde")
    private SmDependency parentDep;

    @objid ("b1ba6fa1-43d6-4e26-891d-6b2a7f1c7486")
    private SmDependency templateInstanciationDep;

    @objid ("150c9b52-5018-425a-b406-a1f7188857f3")
    private SmDependency representingDep;

    @objid ("a7755359-d659-410d-8f00-d7924c65a878")
    private SmDependency ownedBehaviorDep;

    @objid ("b2719d7a-7fe9-49e8-b624-21cdad053cdc")
    private SmDependency receivedDep;

    @objid ("320ff463-dd1e-45a8-a252-02604c27a3d7")
    private SmDependency ownedInformationFlowDep;

    @objid ("766b3c8c-7e7a-4991-a9eb-40def73ebe56")
    private SmDependency importingDep;

    @objid ("83782022-a27d-4318-ac4e-8b7fbb276945")
    private SmDependency sentDep;

    @objid ("b8e042c0-60f1-4d35-8e4c-75fe07343c2d")
    private SmDependency ownedDataFlowDep;

    @objid ("110e08fa-79c3-4c42-a041-c01a357e073f")
    private SmDependency ownedCollaborationUseDep;

    @objid ("f2a726d4-25bb-4eb0-b618-430e03a33ec3")
    private SmDependency ownedPackageImportDep;

    @objid ("aa0371b4-f39a-4aaf-ba48-e5704e3b3fb5")
    private SmDependency templateDep;

    @objid ("9e5e768e-e6b6-47a5-9f90-b17421e3bffc")
    private SmDependency specializationDep;

    @objid ("eb0fe22b-c3a3-47ab-a759-79e3b7236573")
    private SmDependency realizedDep;

    @objid ("33cf0136-779d-4bf0-8fba-37da768eb4f2")
    private SmDependency declaredDep;

    @objid ("b484f356-5600-4e3b-9d0b-76a5611d868c")
    private SmDependency instanciatingBindingDep;

    @objid ("f977b0c1-d29e-4c1b-af98-b927db8a1221")
    private SmDependency ownedImportDep;

    @objid ("9c420465-e6db-49dc-8c7d-68b34cda1ab5")
    public NameSpaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1b3800d2-c728-42c1-a280-0df18c80e656")
    @Override
    public String getName() {
        return "NameSpace";

    }

    @objid ("c079a0fe-a823-4f88-a1c3-74b65c15a37e")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c1c096a0-ce8f-4e9a-b348-984ff9b9ed16")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return NameSpace.class;

    }

    @objid ("fa046fa0-e853-4138-8c31-fcb3b4bdf3a0")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5dc952d6-bde2-411e-be74-caa7f24aa397")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("4bb0bcc6-6d1c-483d-a82a-01d8e41625dc")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ModelTree.MQNAME);
        this.registerFactory(new NameSpaceObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isAbstractAtt = new IsAbstractSmAttribute();
        this.isAbstractAtt.init("IsAbstract", this, Boolean.class );
        registerAttribute(this.isAbstractAtt);

        this.isLeafAtt = new IsLeafSmAttribute();
        this.isLeafAtt.init("IsLeaf", this, Boolean.class );
        registerAttribute(this.isLeafAtt);

        this.isRootAtt = new IsRootSmAttribute();
        this.isRootAtt.init("IsRoot", this, Boolean.class );
        registerAttribute(this.isRootAtt);

        this.visibilityAtt = new VisibilitySmAttribute();
        this.visibilityAtt.init("Visibility", this, VisibilityMode.class );
        registerAttribute(this.visibilityAtt);


        // Initialize and register the SmDependency
        this.parentDep = new ParentSmDependency();
        this.parentDep.init("Parent", this, metamodel.getMClass(Generalization.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.parentDep);

        this.templateInstanciationDep = new TemplateInstanciationSmDependency();
        this.templateInstanciationDep.init("TemplateInstanciation", this, metamodel.getMClass(TemplateBinding.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.templateInstanciationDep);

        this.representingDep = new RepresentingSmDependency();
        this.representingDep.init("Representing", this, metamodel.getMClass(Instance.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC);
        registerDependency(this.representingDep);

        this.ownedBehaviorDep = new OwnedBehaviorSmDependency();
        this.ownedBehaviorDep.init("OwnedBehavior", this, metamodel.getMClass(Behavior.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedBehaviorDep);

        this.receivedDep = new ReceivedSmDependency();
        this.receivedDep.init("Received", this, metamodel.getMClass(DataFlow.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC);
        registerDependency(this.receivedDep);

        this.ownedInformationFlowDep = new OwnedInformationFlowSmDependency();
        this.ownedInformationFlowDep.init("OwnedInformationFlow", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedInformationFlowDep);

        this.importingDep = new ImportingSmDependency();
        this.importingDep.init("Importing", this, metamodel.getMClass(ElementImport.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.importingDep);

        this.sentDep = new SentSmDependency();
        this.sentDep.init("Sent", this, metamodel.getMClass(DataFlow.MQNAME), 0, -1 , SmDirective.SMCDPARTOF, SmDirective.SMCDTODELETE);
        registerDependency(this.sentDep);

        this.ownedDataFlowDep = new OwnedDataFlowSmDependency();
        this.ownedDataFlowDep.init("OwnedDataFlow", this, metamodel.getMClass(DataFlow.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedDataFlowDep);

        this.ownedCollaborationUseDep = new OwnedCollaborationUseSmDependency();
        this.ownedCollaborationUseDep.init("OwnedCollaborationUse", this, metamodel.getMClass(CollaborationUse.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedCollaborationUseDep);

        this.ownedPackageImportDep = new OwnedPackageImportSmDependency();
        this.ownedPackageImportDep.init("OwnedPackageImport", this, metamodel.getMClass(PackageImport.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedPackageImportDep);

        this.templateDep = new TemplateSmDependency();
        this.templateDep.init("Template", this, metamodel.getMClass(TemplateParameter.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.templateDep);

        this.specializationDep = new SpecializationSmDependency();
        this.specializationDep.init("Specialization", this, metamodel.getMClass(Generalization.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.specializationDep);

        this.realizedDep = new RealizedSmDependency();
        this.realizedDep.init("Realized", this, metamodel.getMClass(InterfaceRealization.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.realizedDep);

        this.declaredDep = new DeclaredSmDependency();
        this.declaredDep.init("Declared", this, metamodel.getMClass(Instance.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.declaredDep);

        this.instanciatingBindingDep = new InstanciatingBindingSmDependency();
        this.instanciatingBindingDep.init("InstanciatingBinding", this, metamodel.getMClass(TemplateBinding.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC);
        registerDependency(this.instanciatingBindingDep);

        this.ownedImportDep = new OwnedImportSmDependency();
        this.ownedImportDep.init("OwnedImport", this, metamodel.getMClass(ElementImport.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedImportDep);

    }

    @objid ("b1bc3c47-900b-4c55-a56f-afad786d80a6")
    public SmAttribute getIsAbstractAtt() {
        if (this.isAbstractAtt == null) {
        	this.isAbstractAtt = this.getAttributeDef("IsAbstract");
        }
        return this.isAbstractAtt;
    }

    @objid ("c404c52b-5818-49b9-a8c3-ba9fbc9f1b57")
    public SmAttribute getIsLeafAtt() {
        if (this.isLeafAtt == null) {
        	this.isLeafAtt = this.getAttributeDef("IsLeaf");
        }
        return this.isLeafAtt;
    }

    @objid ("45e0a348-e924-4907-a826-571c5691cfdb")
    public SmAttribute getIsRootAtt() {
        if (this.isRootAtt == null) {
        	this.isRootAtt = this.getAttributeDef("IsRoot");
        }
        return this.isRootAtt;
    }

    @objid ("56548124-6679-49a6-87a7-284d89f77ad4")
    public SmAttribute getVisibilityAtt() {
        if (this.visibilityAtt == null) {
        	this.visibilityAtt = this.getAttributeDef("Visibility");
        }
        return this.visibilityAtt;
    }

    @objid ("f2bf39ed-b119-4d9b-88ae-832f402065c5")
    public SmDependency getParentDep() {
        if (this.parentDep == null) {
        	this.parentDep = this.getDependencyDef("Parent");
        }
        return this.parentDep;
    }

    @objid ("9ce80e4c-ee9c-4406-b397-0ff317c2500d")
    public SmDependency getTemplateInstanciationDep() {
        if (this.templateInstanciationDep == null) {
        	this.templateInstanciationDep = this.getDependencyDef("TemplateInstanciation");
        }
        return this.templateInstanciationDep;
    }

    @objid ("8a5cd49d-2443-476d-86df-87c0c7046cce")
    public SmDependency getRepresentingDep() {
        if (this.representingDep == null) {
        	this.representingDep = this.getDependencyDef("Representing");
        }
        return this.representingDep;
    }

    @objid ("88e040dc-6d1b-486b-a8f9-40718252b5fd")
    public SmDependency getOwnedBehaviorDep() {
        if (this.ownedBehaviorDep == null) {
        	this.ownedBehaviorDep = this.getDependencyDef("OwnedBehavior");
        }
        return this.ownedBehaviorDep;
    }

    @objid ("9a978005-32b5-4993-b294-df05aa61408c")
    public SmDependency getReceivedDep() {
        if (this.receivedDep == null) {
        	this.receivedDep = this.getDependencyDef("Received");
        }
        return this.receivedDep;
    }

    @objid ("22d1ba3a-8426-4750-b583-da5a79247098")
    public SmDependency getOwnedInformationFlowDep() {
        if (this.ownedInformationFlowDep == null) {
        	this.ownedInformationFlowDep = this.getDependencyDef("OwnedInformationFlow");
        }
        return this.ownedInformationFlowDep;
    }

    @objid ("509a5d51-e4d8-4e5e-8fc9-376e523f6511")
    public SmDependency getImportingDep() {
        if (this.importingDep == null) {
        	this.importingDep = this.getDependencyDef("Importing");
        }
        return this.importingDep;
    }

    @objid ("2ad429f2-fa27-4ab2-9273-4b05ad253da0")
    public SmDependency getSentDep() {
        if (this.sentDep == null) {
        	this.sentDep = this.getDependencyDef("Sent");
        }
        return this.sentDep;
    }

    @objid ("c9f666cb-6089-4c45-9ad3-067b97abc1de")
    public SmDependency getOwnedDataFlowDep() {
        if (this.ownedDataFlowDep == null) {
        	this.ownedDataFlowDep = this.getDependencyDef("OwnedDataFlow");
        }
        return this.ownedDataFlowDep;
    }

    @objid ("7bbdc6a5-2ac4-4a34-afe5-793ee6dd4f0c")
    public SmDependency getOwnedCollaborationUseDep() {
        if (this.ownedCollaborationUseDep == null) {
        	this.ownedCollaborationUseDep = this.getDependencyDef("OwnedCollaborationUse");
        }
        return this.ownedCollaborationUseDep;
    }

    @objid ("15f990f6-4483-4449-a427-9a491516e470")
    public SmDependency getOwnedPackageImportDep() {
        if (this.ownedPackageImportDep == null) {
        	this.ownedPackageImportDep = this.getDependencyDef("OwnedPackageImport");
        }
        return this.ownedPackageImportDep;
    }

    @objid ("ad12e408-9f9b-4926-87e6-480b5410ab84")
    public SmDependency getTemplateDep() {
        if (this.templateDep == null) {
        	this.templateDep = this.getDependencyDef("Template");
        }
        return this.templateDep;
    }

    @objid ("3dc8616f-5903-426c-a26a-4254a4d99250")
    public SmDependency getSpecializationDep() {
        if (this.specializationDep == null) {
        	this.specializationDep = this.getDependencyDef("Specialization");
        }
        return this.specializationDep;
    }

    @objid ("6042e93a-d1a1-46cf-9e7c-19c29b50c9fb")
    public SmDependency getRealizedDep() {
        if (this.realizedDep == null) {
        	this.realizedDep = this.getDependencyDef("Realized");
        }
        return this.realizedDep;
    }

    @objid ("57b004fb-7abc-4f2a-8794-3b7e32415db7")
    public SmDependency getDeclaredDep() {
        if (this.declaredDep == null) {
        	this.declaredDep = this.getDependencyDef("Declared");
        }
        return this.declaredDep;
    }

    @objid ("71216e88-62cd-44b0-898a-8e88283d6804")
    public SmDependency getInstanciatingBindingDep() {
        if (this.instanciatingBindingDep == null) {
        	this.instanciatingBindingDep = this.getDependencyDef("InstanciatingBinding");
        }
        return this.instanciatingBindingDep;
    }

    @objid ("e9e424b2-4e2e-4748-83ce-9f1da401e962")
    public SmDependency getOwnedImportDep() {
        if (this.ownedImportDep == null) {
        	this.ownedImportDep = this.getDependencyDef("OwnedImport");
        }
        return this.ownedImportDep;
    }

    @objid ("0c2c93bd-97dc-4339-9b61-858238a53613")
    private static class NameSpaceObjectFactory implements ISmObjectFactory {
        @objid ("85d47f8c-f0f4-4310-9365-09f10ac9ac5d")
        private NameSpaceSmClass smClass;

        @objid ("058ca2de-7b1a-4085-b79f-9490ef3c4904")
        public NameSpaceObjectFactory(NameSpaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("69b4dc35-e1ef-4ad9-be16-f805decf7183")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("fc670666-e2e6-4a65-bd8c-26922c794c0d")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("e467ac03-2614-4bd1-b888-9e1d86a19212")
    public static class IsAbstractSmAttribute extends SmAttribute {
        @objid ("a438cafc-7b55-4bfb-9885-bf4d69c1aad7")
        public Object getValue(ISmObjectData data) {
            return ((NameSpaceData) data).mIsAbstract;
        }

        @objid ("f6569cf2-c00d-49fb-a25b-ebe955fd7538")
        public void setValue(ISmObjectData data, Object value) {
            ((NameSpaceData) data).mIsAbstract = value;
        }

    }

    @objid ("6699d79c-dbe6-4334-8053-a581c5134078")
    public static class IsLeafSmAttribute extends SmAttribute {
        @objid ("32531df2-78ab-4948-9e6e-c04afdaa727b")
        public Object getValue(ISmObjectData data) {
            return ((NameSpaceData) data).mIsLeaf;
        }

        @objid ("236c2d34-5d36-4071-96d6-7a9564742e71")
        public void setValue(ISmObjectData data, Object value) {
            ((NameSpaceData) data).mIsLeaf = value;
        }

    }

    @objid ("619c1ac4-a2cc-4f07-b976-420301036df0")
    public static class IsRootSmAttribute extends SmAttribute {
        @objid ("76756812-8b44-403f-a201-0eb975e76324")
        public Object getValue(ISmObjectData data) {
            return ((NameSpaceData) data).mIsRoot;
        }

        @objid ("6e482716-ac10-4c1d-9942-f0a093240fcb")
        public void setValue(ISmObjectData data, Object value) {
            ((NameSpaceData) data).mIsRoot = value;
        }

    }

    @objid ("873c7fa8-ff6e-49fc-b78f-faa1725dc77c")
    public static class VisibilitySmAttribute extends SmAttribute {
        @objid ("e1ac8bad-3863-47f7-89ed-93d98c7c54f2")
        public Object getValue(ISmObjectData data) {
            return ((NameSpaceData) data).mVisibility;
        }

        @objid ("feaf9046-4b91-468c-9725-4589f8231c2a")
        public void setValue(ISmObjectData data, Object value) {
            ((NameSpaceData) data).mVisibility = value;
        }

    }

    @objid ("ce9d691b-cbbb-4ddf-a343-1c5007dece6c")
    public static class ParentSmDependency extends SmMultipleDependency {
        @objid ("49e890d3-67d2-4df5-823f-c7c2c634b05c")
        private SmDependency symetricDep;

        @objid ("3956a232-4c29-48f4-90f0-4672c4bb91ff")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mParent != null)? ((NameSpaceData)data).mParent:SmMultipleDependency.EMPTY;
        }

        @objid ("15386e08-2093-4d7d-893b-f1f0cfd14896")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mParent = values;

        }

        @objid ("62650b5d-5d08-415f-9d83-5e7e208e6f4f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralizationSmClass)this.getTarget()).getSubTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1ee90518-fb64-4c52-8a70-fd10a1e6f5a6")
    public static class TemplateInstanciationSmDependency extends SmMultipleDependency {
        @objid ("d30fc34c-ad57-4acf-8487-03bdd6f6b900")
        private SmDependency symetricDep;

        @objid ("96e00602-0eeb-4b91-bd31-14267d74d231")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mTemplateInstanciation != null)? ((NameSpaceData)data).mTemplateInstanciation:SmMultipleDependency.EMPTY;
        }

        @objid ("b02ff878-32f4-4b26-be3b-4b6c0b439d00")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mTemplateInstanciation = values;

        }

        @objid ("dc17017a-a45b-47ea-9acf-5aa302256da2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateBindingSmClass)this.getTarget()).getBoundElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("34c20884-94c0-4e85-b18b-6a047025e976")
    public static class RepresentingSmDependency extends SmMultipleDependency {
        @objid ("13166e39-9eb0-4ed6-9ad7-0877c76e431f")
        private SmDependency symetricDep;

        @objid ("b6008ea0-9e41-4936-a2a4-8314abc0a30e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mRepresenting != null)? ((NameSpaceData)data).mRepresenting:SmMultipleDependency.EMPTY;
        }

        @objid ("c589344c-76d1-462d-9a74-d3cb7300ab6b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mRepresenting = values;

        }

        @objid ("3aaaafa2-7961-495e-a296-371723d35977")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getBaseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("309f4387-5f19-40d7-9a95-cec2ab8276c7")
    public static class OwnedBehaviorSmDependency extends SmMultipleDependency {
        @objid ("49a65409-121e-48dd-938b-17eaa40885d4")
        private SmDependency symetricDep;

        @objid ("2eaa3e8c-c192-4778-a612-1c5cc8cb43cd")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mOwnedBehavior != null)? ((NameSpaceData)data).mOwnedBehavior:SmMultipleDependency.EMPTY;
        }

        @objid ("641faa5a-1035-41b9-a44c-e500a8dda4e2")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mOwnedBehavior = values;

        }

        @objid ("5069eb78-ad21-4e2d-8da3-8a70f3fd8f38")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("505aafbb-5f5e-4c34-818d-f1c7c2c6acaf")
    public static class ReceivedSmDependency extends SmMultipleDependency {
        @objid ("491e5875-b0e5-4b57-b55e-b8c2bdfb3145")
        private SmDependency symetricDep;

        @objid ("53498c03-8942-4ff1-95ce-d9b808ebc2a8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mReceived != null)? ((NameSpaceData)data).mReceived:SmMultipleDependency.EMPTY;
        }

        @objid ("7d3fc254-27f3-4657-acb3-237789b6f08e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mReceived = values;

        }

        @objid ("6920265f-ed71-41ac-8f56-adedc9aeeaf1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((DataFlowSmClass)this.getTarget()).getDestinationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4c6cc3fd-b946-4bb1-9b12-8778ed028872")
    public static class OwnedInformationFlowSmDependency extends SmMultipleDependency {
        @objid ("4098f896-50de-4517-b699-6c1941dde07e")
        private SmDependency symetricDep;

        @objid ("a1dbefb7-b679-40b9-b254-36198166fb0c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mOwnedInformationFlow != null)? ((NameSpaceData)data).mOwnedInformationFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("f163862e-3d8c-4b8f-9d5a-ef3babbc232e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mOwnedInformationFlow = values;

        }

        @objid ("d68d4042-1bee-4c04-8ca5-e9bbd5826e69")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6d961059-4007-4424-ba72-327698591a92")
    public static class ImportingSmDependency extends SmMultipleDependency {
        @objid ("c413169a-1c1b-4fbd-a0d2-5e1ef1ed43c3")
        private SmDependency symetricDep;

        @objid ("1aaa0edc-4f0a-487c-bf43-802338bed23a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mImporting != null)? ((NameSpaceData)data).mImporting:SmMultipleDependency.EMPTY;
        }

        @objid ("8d84fef9-e02b-48d9-9653-aee50ce9c478")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mImporting = values;

        }

        @objid ("3234fd7e-682f-4271-9696-dde23a60db8b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ElementImportSmClass)this.getTarget()).getImportedElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d31f875f-f0ee-498f-8f6b-78fc04452915")
    public static class SentSmDependency extends SmMultipleDependency {
        @objid ("22f0cf35-b124-4bb1-a179-477226edf690")
        private SmDependency symetricDep;

        @objid ("52fd3e47-0e24-49a2-8373-37c2306d6df2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mSent != null)? ((NameSpaceData)data).mSent:SmMultipleDependency.EMPTY;
        }

        @objid ("b43e82db-81ea-4111-a2a4-43de883d4542")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mSent = values;

        }

        @objid ("276583c2-f5e5-47a3-89aa-bf65981f52e9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((DataFlowSmClass)this.getTarget()).getOriginDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("54693267-9025-4a35-bed9-dcbeb0d28494")
    public static class OwnedDataFlowSmDependency extends SmMultipleDependency {
        @objid ("aad41f3b-c13e-4694-a9fa-936a16cc1a20")
        private SmDependency symetricDep;

        @objid ("c504ff5e-e9d2-49fe-8cd1-1de1824c5680")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mOwnedDataFlow != null)? ((NameSpaceData)data).mOwnedDataFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("f42e778e-39db-48a1-b436-e24c0edec2c7")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mOwnedDataFlow = values;

        }

        @objid ("f2ce72d3-2538-4e9b-a765-2e907667a155")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((DataFlowSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9358538f-89a4-4944-8392-5a3ef2b78856")
    public static class OwnedCollaborationUseSmDependency extends SmMultipleDependency {
        @objid ("e7536cb0-fb4e-477c-b7d2-475e786d2883")
        private SmDependency symetricDep;

        @objid ("c9e7ccc1-5357-41d7-a754-08ff844ac2c1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mOwnedCollaborationUse != null)? ((NameSpaceData)data).mOwnedCollaborationUse:SmMultipleDependency.EMPTY;
        }

        @objid ("aadbb5ea-0471-4f2c-b8c2-a04cb05a835a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mOwnedCollaborationUse = values;

        }

        @objid ("99a63763-c889-4302-8e27-e5263e113ef5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CollaborationUseSmClass)this.getTarget()).getNRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("520aa15c-8309-4879-858e-8dce21c7ffa5")
    public static class OwnedPackageImportSmDependency extends SmMultipleDependency {
        @objid ("95d1c522-8495-499e-8260-71f2e9790615")
        private SmDependency symetricDep;

        @objid ("7c1b2b18-a1f2-4020-b3c2-5829477f8222")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mOwnedPackageImport != null)? ((NameSpaceData)data).mOwnedPackageImport:SmMultipleDependency.EMPTY;
        }

        @objid ("031f0c03-7e0a-480c-8da2-480df7b28585")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mOwnedPackageImport = values;

        }

        @objid ("140025ed-409b-4d8e-9d4e-f064dea95ce8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageImportSmClass)this.getTarget()).getImportingNameSpaceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a6e8b92e-78b2-4996-94cf-6e8208f369fd")
    public static class TemplateSmDependency extends SmMultipleDependency {
        @objid ("c0081c79-9ca2-4c71-baa8-666403dbce1f")
        private SmDependency symetricDep;

        @objid ("094a104b-ed60-4ad8-8fea-d0f43f9a0051")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mTemplate != null)? ((NameSpaceData)data).mTemplate:SmMultipleDependency.EMPTY;
        }

        @objid ("c4023c70-c5a7-47de-97fc-90e62f4bfe94")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mTemplate = values;

        }

        @objid ("cab93c9f-31d3-4a89-a5a3-3d2b155cbc91")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateParameterSmClass)this.getTarget()).getParameterizedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c4e526cb-be69-4b6a-899d-d38a476a66c5")
    public static class SpecializationSmDependency extends SmMultipleDependency {
        @objid ("050d1317-bbb0-4a0a-8835-24ce1dcb871d")
        private SmDependency symetricDep;

        @objid ("19bfe6f0-9002-4998-aa8e-e6f18206cefc")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mSpecialization != null)? ((NameSpaceData)data).mSpecialization:SmMultipleDependency.EMPTY;
        }

        @objid ("61a00940-8642-45c3-88a6-3a84311b6c45")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mSpecialization = values;

        }

        @objid ("e90a1879-9176-4478-a7bc-a7ec57e31071")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralizationSmClass)this.getTarget()).getSuperTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1dc657ab-2b7f-46e9-b7ef-83d713693a7c")
    public static class RealizedSmDependency extends SmMultipleDependency {
        @objid ("a5ccffda-c469-4225-a034-441e46601d82")
        private SmDependency symetricDep;

        @objid ("c185e854-7eb5-4aa6-8108-bb1f01f1f1a0")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mRealized != null)? ((NameSpaceData)data).mRealized:SmMultipleDependency.EMPTY;
        }

        @objid ("fa2766b1-97b4-4ecc-85b7-5eb693e6d072")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mRealized = values;

        }

        @objid ("21ce6536-61d1-4af1-bfc9-a550aef54856")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InterfaceRealizationSmClass)this.getTarget()).getImplementerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("08a7b20e-ca49-4b9b-b0f0-be219d10ae6f")
    public static class DeclaredSmDependency extends SmMultipleDependency {
        @objid ("bc80a6ca-6b80-48cb-a4d9-5d47de72ab77")
        private SmDependency symetricDep;

        @objid ("b651b119-6b21-4163-814d-f68b018ea12e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mDeclared != null)? ((NameSpaceData)data).mDeclared:SmMultipleDependency.EMPTY;
        }

        @objid ("2336d18e-9317-4ed6-ad4b-8a802908f050")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mDeclared = values;

        }

        @objid ("964c78cf-dd58-40cf-8bf8-d0399b58e604")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8fd88ea7-1062-44f8-b1b2-5a9f71e4739c")
    public static class InstanciatingBindingSmDependency extends SmMultipleDependency {
        @objid ("82831f6d-8151-4079-9940-1496ebf226d1")
        private SmDependency symetricDep;

        @objid ("dcb09c64-bb19-4775-a32b-695437deb0b1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mInstanciatingBinding != null)? ((NameSpaceData)data).mInstanciatingBinding:SmMultipleDependency.EMPTY;
        }

        @objid ("9e2858b5-e8a8-439b-9f05-e17967bc6b90")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mInstanciatingBinding = values;

        }

        @objid ("49cb9549-3626-4612-ad27-77452e23d636")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TemplateBindingSmClass)this.getTarget()).getInstanciatedTemplateDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("731ee4cd-c2a0-4d53-840a-ebd11dfa28d5")
    public static class OwnedImportSmDependency extends SmMultipleDependency {
        @objid ("01dc8a29-51da-4d5e-a42b-b9f7e5e8619f")
        private SmDependency symetricDep;

        @objid ("e29db114-0a96-4ab4-a5dc-c1fd4e49eaa2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NameSpaceData)data).mOwnedImport != null)? ((NameSpaceData)data).mOwnedImport:SmMultipleDependency.EMPTY;
        }

        @objid ("afa2c632-6ce5-4096-9157-86600f2a5289")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NameSpaceData) data).mOwnedImport = values;

        }

        @objid ("c4ac5594-f16a-44f9-ba62-6c060f0957d0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ElementImportSmClass)this.getTarget()).getImportingNameSpaceDep();
            }
            return this.symetricDep;

        }

    }

}
