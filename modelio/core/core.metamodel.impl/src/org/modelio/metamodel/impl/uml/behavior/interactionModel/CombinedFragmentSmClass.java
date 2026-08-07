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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.CombinedFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperand;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperator;
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

@objid ("3f397821-349f-4e2d-ae6b-17b4abaddfb2")
public class CombinedFragmentSmClass extends InteractionFragmentSmClass {
    @objid ("a330f307-dc24-4929-b144-1719c242c68e")
    private SmAttribute operatorAtt;

    @objid ("236f10fc-5dca-4046-a25d-d1cd98e5e28c")
    private SmDependency operandDep;

    @objid ("50d2e456-89fa-4c41-b1ee-6408ec3fa843")
    private SmDependency fragmentGateDep;

    @objid ("4abec1f3-2916-4530-94c7-737f22cd4982")
    public CombinedFragmentSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("150150a1-cfeb-4380-a394-cf825f93725f")
    @Override
    public String getName() {
        return "CombinedFragment";

    }

    @objid ("552c5ae3-2401-4352-8257-3f148d4a01cf")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("1c49abb6-3b64-45a9-a05c-85659fbba802")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CombinedFragment.class;

    }

    @objid ("d25c322c-1d11-4f3c-9c8e-448f23f99680")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b64de3fb-3eb2-4d90-ae59-58e1d7e7dc2d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("68f1d1a7-d2f2-4259-8275-fc2bf668e9c7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InteractionFragment.MQNAME);
        this.registerFactory(new CombinedFragmentObjectFactory(this));


        // Initialize and register the SmAttribute
        this.operatorAtt = new OperatorSmAttribute();
        this.operatorAtt.init("Operator", this, InteractionOperator.class );
        registerAttribute(this.operatorAtt);


        // Initialize and register the SmDependency
        this.operandDep = new OperandSmDependency();
        this.operandDep.init("Operand", this, metamodel.getMClass(InteractionOperand.MQNAME), 1, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.operandDep);

        this.fragmentGateDep = new FragmentGateSmDependency();
        this.fragmentGateDep.init("FragmentGate", this, metamodel.getMClass(Gate.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.fragmentGateDep);

    }

    @objid ("2eee436d-c1d2-420c-9e30-751f0d88d561")
    public SmAttribute getOperatorAtt() {
        if (this.operatorAtt == null) {
        	this.operatorAtt = this.getAttributeDef("Operator");
        }
        return this.operatorAtt;
    }

    @objid ("dc75165f-666d-4462-98ce-54e176e0ca15")
    public SmDependency getOperandDep() {
        if (this.operandDep == null) {
        	this.operandDep = this.getDependencyDef("Operand");
        }
        return this.operandDep;
    }

    @objid ("7be6fdbf-df59-485e-bb0c-8751781ac676")
    public SmDependency getFragmentGateDep() {
        if (this.fragmentGateDep == null) {
        	this.fragmentGateDep = this.getDependencyDef("FragmentGate");
        }
        return this.fragmentGateDep;
    }

    @objid ("a705b73e-bb5e-4df9-b0d4-5104286fbb26")
    private static class CombinedFragmentObjectFactory implements ISmObjectFactory {
        @objid ("6d064bd5-0d42-4b09-9cc4-13f531b826ae")
        private CombinedFragmentSmClass smClass;

        @objid ("868f69ff-cbf3-492b-932c-9f4ea699f540")
        public CombinedFragmentObjectFactory(CombinedFragmentSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("8f04cbd5-bf6c-49e6-8cd8-f41d3f72aea7")
        @Override
        public ISmObjectData createData() {
            return new CombinedFragmentData(this.smClass);
        }

        @objid ("8fc4a46b-f635-4d08-badd-c348e85db438")
        @Override
        public SmObjectImpl createImpl() {
            return new CombinedFragmentImpl();
        }

    }

    @objid ("519873df-52ec-4c8a-926e-4e3924c2dae6")
    public static class OperatorSmAttribute extends SmAttribute {
        @objid ("c58e48e5-fda8-490c-bc93-61d7830f2533")
        public Object getValue(ISmObjectData data) {
            return ((CombinedFragmentData) data).mOperator;
        }

        @objid ("08f421f0-d3cf-4285-a7e5-2dbdef100314")
        public void setValue(ISmObjectData data, Object value) {
            ((CombinedFragmentData) data).mOperator = value;
        }

    }

    @objid ("8369428b-cf2f-4140-aa8c-cdfddaf3e661")
    public static class OperandSmDependency extends SmMultipleDependency {
        @objid ("3e87efc0-1b3e-4279-9b9b-3eccd94aa0b3")
        private SmDependency symetricDep;

        @objid ("bdc93d14-898a-4810-8d77-61cde2ec75fc")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CombinedFragmentData)data).mOperand != null)? ((CombinedFragmentData)data).mOperand:SmMultipleDependency.EMPTY;
        }

        @objid ("1d7e536f-85d0-4681-8783-b21bc8d71bac")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CombinedFragmentData) data).mOperand = values;

        }

        @objid ("4454192c-2054-4501-a7b3-c126e4893afc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionOperandSmClass)this.getTarget()).getOwnerFragmentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c9b572c2-a77b-45a9-abe3-945e1e2ef941")
    public static class FragmentGateSmDependency extends SmMultipleDependency {
        @objid ("f45b335f-eea8-4e54-b789-c6e2c7b49ad1")
        private SmDependency symetricDep;

        @objid ("1f3b34c2-c7d5-411a-a43b-1c306138a3f3")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CombinedFragmentData)data).mFragmentGate != null)? ((CombinedFragmentData)data).mFragmentGate:SmMultipleDependency.EMPTY;
        }

        @objid ("8794c9b8-9737-4914-9d2e-18162496b91b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CombinedFragmentData) data).mFragmentGate = values;

        }

        @objid ("16d25467-a153-4806-8719-24c505049325")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GateSmClass)this.getTarget()).getOwnerFragmentDep();
            }
            return this.symetricDep;

        }

    }

}
