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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameterBinding;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
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
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1b609f5e-944b-4853-9119-aa7754ed0e90")
public class BpmnResourceParameterBindingSmClass extends BpmnBaseElementSmClass {
    @objid ("6010ea5e-4edd-4bf7-bf52-5daadd8d9cc8")
    private SmAttribute expressionAtt;

    @objid ("c0585422-7cdf-4b9a-9dba-c980a6958e95")
    private SmDependency resourceRoleDep;

    @objid ("0f531e66-255b-47fc-8658-a0674aea1714")
    private SmDependency parameterRefDep;

    @objid ("5c28ae53-602d-45bc-b5cf-ee7b3263dd8f")
    public BpmnResourceParameterBindingSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5724bfa5-e726-43c4-b8b9-ffefcc45a350")
    @Override
    public String getName() {
        return "BpmnResourceParameterBinding";

    }

    @objid ("7aeab1cf-8172-4927-bf2f-8f8b1f73bd2f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0a164d85-770c-4908-9a84-8133c9a4c11c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnResourceParameterBinding.class;

    }

    @objid ("68cfe8ff-2ded-4d4f-9d3d-353d46644a44")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a488ff10-eb70-4726-9bc8-4c1fb350ad24")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e312cf3f-c61e-4589-9d10-f9d70f82cd3e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnResourceParameterBindingObjectFactory(this));


        // Initialize and register the SmAttribute
        this.expressionAtt = new ExpressionSmAttribute();
        this.expressionAtt.init("Expression", this, String.class );
        registerAttribute(this.expressionAtt);


        // Initialize and register the SmDependency
        this.resourceRoleDep = new ResourceRoleSmDependency();
        this.resourceRoleDep.init("ResourceRole", this, metamodel.getMClass(BpmnResourceRole.MQNAME), 1, 1 );
        registerDependency(this.resourceRoleDep);

        this.parameterRefDep = new ParameterRefSmDependency();
        this.parameterRefDep.init("ParameterRef", this, metamodel.getMClass(BpmnResourceParameter.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.parameterRefDep);

    }

    @objid ("954115df-d4ae-4843-9c75-66e6d4c3e4fa")
    public SmAttribute getExpressionAtt() {
        if (this.expressionAtt == null) {
        	this.expressionAtt = this.getAttributeDef("Expression");
        }
        return this.expressionAtt;
    }

    @objid ("1813f420-a6cb-4095-85b2-8e2c569e2386")
    public SmDependency getResourceRoleDep() {
        if (this.resourceRoleDep == null) {
        	this.resourceRoleDep = this.getDependencyDef("ResourceRole");
        }
        return this.resourceRoleDep;
    }

    @objid ("1b64f346-c9f3-4914-94dd-e0953d396e81")
    public SmDependency getParameterRefDep() {
        if (this.parameterRefDep == null) {
        	this.parameterRefDep = this.getDependencyDef("ParameterRef");
        }
        return this.parameterRefDep;
    }

    @objid ("216d62a9-7a81-4cf8-a192-126970663acf")
    private static class BpmnResourceParameterBindingObjectFactory implements ISmObjectFactory {
        @objid ("5f1d7045-91a7-4004-97fd-20b0eb869841")
        private BpmnResourceParameterBindingSmClass smClass;

        @objid ("98636a6d-3da8-4db4-99d6-f32568366311")
        public BpmnResourceParameterBindingObjectFactory(BpmnResourceParameterBindingSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("480476f9-0425-489a-8e07-5e76e978c610")
        @Override
        public ISmObjectData createData() {
            return new BpmnResourceParameterBindingData(this.smClass);
        }

        @objid ("6b31ca3a-899c-4ccf-88f3-6cbfa35bc1fc")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnResourceParameterBindingImpl();
        }

    }

    @objid ("c9eb623a-7a0e-4881-8824-86e747038b5c")
    public static class ExpressionSmAttribute extends SmAttribute {
        @objid ("4e269709-785c-470a-8722-ae2b6fc99e06")
        public Object getValue(ISmObjectData data) {
            return ((BpmnResourceParameterBindingData) data).mExpression;
        }

        @objid ("117d96a0-fad6-40c1-bd61-e4732a049cd7")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnResourceParameterBindingData) data).mExpression = value;
        }

    }

    @objid ("b55042d9-caff-4135-8634-45c56671fd03")
    public static class ResourceRoleSmDependency extends SmSingleDependency {
        @objid ("28ccdb95-d174-4f6e-aa78-ed7890bd4f97")
        private SmDependency symetricDep;

        @objid ("2e40d872-b70c-4d57-bfdc-2b6f34a30fb4")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnResourceParameterBindingData) data).mResourceRole;
        }

        @objid ("824298bd-292a-4680-ab6d-cad41f3adba1")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnResourceParameterBindingData) data).mResourceRole = value;
        }

        @objid ("5e211fa2-d6ac-4d68-ab37-5c9bb0a27351")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceRoleSmClass)this.getTarget()).getResourceParameterBindingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e43d9261-c6a0-46e2-9ca5-345e6f193d19")
    public static class ParameterRefSmDependency extends SmSingleDependency {
        @objid ("5ca6554e-af4c-46c1-bd34-d5f2a49675fb")
        private SmDependency symetricDep;

        @objid ("624b2e69-1b00-4920-8eb2-80462c04e3e2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnResourceParameterBindingData) data).mParameterRef;
        }

        @objid ("70a8bad4-82ae-40fa-be0a-fcd6a6964ab1")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnResourceParameterBindingData) data).mParameterRef = value;
        }

        @objid ("e09e0e12-6a1a-4bfb-afc0-772fe8e56da3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceParameterSmClass)this.getTarget()).getParameterBindingRefsDep();
            }
            return this.symetricDep;

        }

    }

}
