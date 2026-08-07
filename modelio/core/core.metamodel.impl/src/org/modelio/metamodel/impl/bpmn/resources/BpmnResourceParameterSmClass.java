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
package org.modelio.metamodel.impl.bpmn.resources;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.resources.BpmnResource;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameterBinding;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.objects.BpmnItemDefinitionSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
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

@objid ("5a6847cb-a94a-4380-b40b-1c6bd8001307")
public class BpmnResourceParameterSmClass extends BpmnBaseElementSmClass {
    @objid ("e6915dfd-c00e-441d-a327-591db6f9dab8")
    private SmAttribute isRequiredAtt;

    @objid ("841f6a6c-5b12-4a1b-ae2c-93c5e4f60329")
    private SmDependency resourceDep;

    @objid ("01372e16-811a-42b2-a17e-3c6412a7fe54")
    private SmDependency typeDep;

    @objid ("36f0493c-28d6-4218-a2c9-b396e0c7af32")
    private SmDependency parameterBindingRefsDep;

    @objid ("6707d534-0acb-4842-a7c2-b51f12b581d5")
    public BpmnResourceParameterSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5089eed4-d132-423f-9455-c509dfb72bb3")
    @Override
    public String getName() {
        return "BpmnResourceParameter";

    }

    @objid ("174e5b76-5482-4329-9ee2-147cbab535d8")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5334dc7b-3016-41a8-b2eb-44d5834974f1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnResourceParameter.class;

    }

    @objid ("cae3259a-a001-4f8f-9315-496dac7b744d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6340103c-8449-442c-b16f-f33209684f98")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6acd5853-1c31-4720-84fe-bf065455b866")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnResourceParameterObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isRequiredAtt = new IsRequiredSmAttribute();
        this.isRequiredAtt.init("IsRequired", this, Boolean.class );
        registerAttribute(this.isRequiredAtt);


        // Initialize and register the SmDependency
        this.resourceDep = new ResourceSmDependency();
        this.resourceDep.init("Resource", this, metamodel.getMClass(BpmnResource.MQNAME), 1, 1 );
        registerDependency(this.resourceDep);

        this.typeDep = new TypeSmDependency();
        this.typeDep.init("Type", this, metamodel.getMClass(BpmnItemDefinition.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.typeDep);

        this.parameterBindingRefsDep = new ParameterBindingRefsSmDependency();
        this.parameterBindingRefsDep.init("ParameterBindingRefs", this, metamodel.getMClass(BpmnResourceParameterBinding.MQNAME), 0, -1 );
        registerDependency(this.parameterBindingRefsDep);

    }

    @objid ("90668351-8c1c-436a-afb4-53601312bc5d")
    public SmAttribute getIsRequiredAtt() {
        if (this.isRequiredAtt == null) {
        	this.isRequiredAtt = this.getAttributeDef("IsRequired");
        }
        return this.isRequiredAtt;
    }

    @objid ("632c33d4-1252-4b25-ac44-dcf74c36ae5a")
    public SmDependency getResourceDep() {
        if (this.resourceDep == null) {
        	this.resourceDep = this.getDependencyDef("Resource");
        }
        return this.resourceDep;
    }

    @objid ("f0aa5a2b-a054-4de3-85d3-3d28c1c78bde")
    public SmDependency getTypeDep() {
        if (this.typeDep == null) {
        	this.typeDep = this.getDependencyDef("Type");
        }
        return this.typeDep;
    }

    @objid ("0f0399f4-44c4-4095-9726-d5af1ed6fbf2")
    public SmDependency getParameterBindingRefsDep() {
        if (this.parameterBindingRefsDep == null) {
        	this.parameterBindingRefsDep = this.getDependencyDef("ParameterBindingRefs");
        }
        return this.parameterBindingRefsDep;
    }

    @objid ("fd2e4392-3eb8-4918-b347-ff8e674b3066")
    private static class BpmnResourceParameterObjectFactory implements ISmObjectFactory {
        @objid ("7db621dc-cab8-44f9-96c1-a5d0a17c3aab")
        private BpmnResourceParameterSmClass smClass;

        @objid ("e27cabbc-9088-4cdb-9b01-7bffd545aa97")
        public BpmnResourceParameterObjectFactory(BpmnResourceParameterSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d63cfc2d-740d-4379-8652-9eadc25a2f45")
        @Override
        public ISmObjectData createData() {
            return new BpmnResourceParameterData(this.smClass);
        }

        @objid ("e8e358dc-8e53-4d2f-a326-784bca6885f9")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnResourceParameterImpl();
        }

    }

    @objid ("d34da7f2-beed-4b00-b135-97bf8ce930d8")
    public static class IsRequiredSmAttribute extends SmAttribute {
        @objid ("86b2f401-8e1a-42aa-a371-82984d3973e8")
        public Object getValue(ISmObjectData data) {
            return ((BpmnResourceParameterData) data).mIsRequired;
        }

        @objid ("bf2845e3-69de-473c-b943-3dfa1bcddb78")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnResourceParameterData) data).mIsRequired = value;
        }

    }

    @objid ("6c839190-49c1-4992-b384-a98004a26245")
    public static class ResourceSmDependency extends SmSingleDependency {
        @objid ("a95c5242-5390-4c31-9c91-a166d0ae83c7")
        private SmDependency symetricDep;

        @objid ("c200f027-0dfd-4a3e-b401-42c7ccf38ff7")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnResourceParameterData) data).mResource;
        }

        @objid ("2e59f0a8-ef51-4f47-8c8d-1a362bc2131d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnResourceParameterData) data).mResource = value;
        }

        @objid ("300f87cb-6af1-42df-81f4-1c5a7cc4262a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceSmClass)this.getTarget()).getParameterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("db898e57-b3f6-47c1-a65e-5a27906c6b6c")
    public static class TypeSmDependency extends SmSingleDependency {
        @objid ("d38ab5d1-d4e0-4552-b1c4-c4c54110a763")
        private SmDependency symetricDep;

        @objid ("b7561b68-1822-49c5-9645-e2de79a465de")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnResourceParameterData) data).mType;
        }

        @objid ("dc0aac7f-e9b0-45bf-9d47-cd046bd78394")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnResourceParameterData) data).mType = value;
        }

        @objid ("d2cb8fef-8c4d-4ce2-9702-b84c67dfea12")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnItemDefinitionSmClass)this.getTarget()).getTypedResourceParameterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c29f324b-ea03-4794-a792-a4e42d0fd264")
    public static class ParameterBindingRefsSmDependency extends SmMultipleDependency {
        @objid ("4c80ab7a-b833-4c75-ac55-e89eb29f89df")
        private SmDependency symetricDep;

        @objid ("c69db183-99ad-45fe-a5f7-6af77449711c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnResourceParameterData)data).mParameterBindingRefs != null)? ((BpmnResourceParameterData)data).mParameterBindingRefs:SmMultipleDependency.EMPTY;
        }

        @objid ("6d69a6f4-0b9d-4bcf-abfe-2a6cb9e3025f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnResourceParameterData) data).mParameterBindingRefs = values;

        }

        @objid ("05f444b2-0b26-47ed-af71-1d510cd263c4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceParameterBindingSmClass)this.getTarget()).getParameterRefDep();
            }
            return this.symetricDep;

        }

    }

}
