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
package org.modelio.metamodel.impl.bpmn.gateways;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.gateways.BpmnComplexGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnGateway;
import org.modelio.metamodel.impl.bpmn.flows.BpmnSequenceFlowSmClass;
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

@objid ("17ab5785-d5f9-4c2d-992a-883ea789b18b")
public class BpmnComplexGatewaySmClass extends BpmnGatewaySmClass {
    @objid ("4a527ad3-3dda-4037-b7e8-d6cbad13a047")
    private SmAttribute activationExpressionAtt;

    @objid ("68426495-bca1-4aa8-87ce-89c3c3d450eb")
    private SmDependency defaultFlowDep;

    @objid ("ac889919-cae9-4867-81e8-3a86cdf582ad")
    public BpmnComplexGatewaySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d276c65c-fb17-4462-bbcf-b194afca5624")
    @Override
    public String getName() {
        return "BpmnComplexGateway";

    }

    @objid ("745fbd3d-6e3d-4805-a2b4-5a17fd0bb68f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0103506a-c8e1-4888-8c82-f5c18eec5c22")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnComplexGateway.class;

    }

    @objid ("d0e75848-db7c-47b4-97ab-09de281c11ea")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1b5ca014-7cbe-41c4-b503-bf3634605870")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2e656e39-05d4-453c-8982-71647ed832ab")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnGateway.MQNAME);
        this.registerFactory(new BpmnComplexGatewayObjectFactory(this));


        // Initialize and register the SmAttribute
        this.activationExpressionAtt = new ActivationExpressionSmAttribute();
        this.activationExpressionAtt.init("ActivationExpression", this, String.class );
        registerAttribute(this.activationExpressionAtt);


        // Initialize and register the SmDependency
        this.defaultFlowDep = new DefaultFlowSmDependency();
        this.defaultFlowDep.init("DefaultFlow", this, metamodel.getMClass(BpmnSequenceFlow.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.defaultFlowDep);

    }

    @objid ("06a2eeca-5c37-4249-b79c-c04ea2ec2dc6")
    public SmAttribute getActivationExpressionAtt() {
        if (this.activationExpressionAtt == null) {
        	this.activationExpressionAtt = this.getAttributeDef("ActivationExpression");
        }
        return this.activationExpressionAtt;
    }

    @objid ("3f9c3db1-c7f8-4f57-b2a9-d595940c3404")
    public SmDependency getDefaultFlowDep() {
        if (this.defaultFlowDep == null) {
        	this.defaultFlowDep = this.getDependencyDef("DefaultFlow");
        }
        return this.defaultFlowDep;
    }

    @objid ("13f57164-1a35-4ad0-8e85-bb9e5cf60411")
    private static class BpmnComplexGatewayObjectFactory implements ISmObjectFactory {
        @objid ("e7606495-1664-483f-b589-606a17081a60")
        private BpmnComplexGatewaySmClass smClass;

        @objid ("46a08485-68d5-40fe-8c86-74c87432ac4b")
        public BpmnComplexGatewayObjectFactory(BpmnComplexGatewaySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4ef0bd88-8e25-4599-8f85-ad3d9370c659")
        @Override
        public ISmObjectData createData() {
            return new BpmnComplexGatewayData(this.smClass);
        }

        @objid ("50ec0e33-d1c3-4643-a761-2ed87ae6be65")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnComplexGatewayImpl();
        }

    }

    @objid ("f074a2a1-aa33-4f91-b924-992724171b8f")
    public static class ActivationExpressionSmAttribute extends SmAttribute {
        @objid ("e87e357f-bf5a-455e-bf34-665e71091709")
        public Object getValue(ISmObjectData data) {
            return ((BpmnComplexGatewayData) data).mActivationExpression;
        }

        @objid ("6a343109-9258-496a-b0bf-e4cfa732b376")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnComplexGatewayData) data).mActivationExpression = value;
        }

    }

    @objid ("d67bb597-b6ad-4969-8c19-6a7e23d60bb7")
    public static class DefaultFlowSmDependency extends SmSingleDependency {
        @objid ("df3fc2e1-8b3e-423a-9fe1-9725760b5d5e")
        private SmDependency symetricDep;

        @objid ("2a9a1815-9b20-4709-bef5-e36574a55e19")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnComplexGatewayData) data).mDefaultFlow;
        }

        @objid ("a49c0948-a076-4156-8eca-4ac92f16216c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnComplexGatewayData) data).mDefaultFlow = value;
        }

        @objid ("62925331-3db8-438a-b879-8b88eb0cf8d8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowSmClass)this.getTarget()).getDefaultOfComplexDep();
            }
            return this.symetricDep;

        }

    }

}
