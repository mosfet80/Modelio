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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperand;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("a59b98cb-268c-4bfd-b2e2-971cbd7c6ee9")
public class InteractionFragmentSmClass extends UmlModelElementSmClass {
    @objid ("ce769553-6e3a-4737-a27f-6c67df4ecdf4")
    private SmAttribute lineNumberAtt;

    @objid ("87db5ff8-d556-4d73-b7dd-95470f9eb8ce")
    private SmDependency enclosingOperandDep;

    @objid ("0f29d735-b49d-4618-8f31-d2b433ac36ad")
    private SmDependency enclosingInteractionDep;

    @objid ("d463fbbc-7bbb-498e-a2d9-4735f9c2cd35")
    private SmDependency coveredDep;

    @objid ("734d880c-9fff-4f89-b6e9-c7afba7af589")
    public InteractionFragmentSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("7dc88f05-26d9-4c8d-b73b-c1c26f3814ac")
    @Override
    public String getName() {
        return "InteractionFragment";

    }

    @objid ("f3a5707e-7892-4613-8bc8-556235d65096")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("01e68cda-8089-4eb5-ad63-3da876d455d0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InteractionFragment.class;

    }

    @objid ("7df56be8-4d0f-4672-a866-400556d8ab53")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("69ffcca5-fae0-4593-9110-2386d8b070d5")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("d20968a6-3268-455c-9334-a13061fa8fdc")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new InteractionFragmentObjectFactory(this));


        // Initialize and register the SmAttribute
        this.lineNumberAtt = new LineNumberSmAttribute();
        this.lineNumberAtt.init("LineNumber", this, Integer.class );
        registerAttribute(this.lineNumberAtt);


        // Initialize and register the SmDependency
        this.enclosingOperandDep = new EnclosingOperandSmDependency();
        this.enclosingOperandDep.init("EnclosingOperand", this, metamodel.getMClass(InteractionOperand.MQNAME), 0, 1 );
        registerDependency(this.enclosingOperandDep);

        this.enclosingInteractionDep = new EnclosingInteractionSmDependency();
        this.enclosingInteractionDep.init("EnclosingInteraction", this, metamodel.getMClass(Interaction.MQNAME), 0, 1 );
        registerDependency(this.enclosingInteractionDep);

        this.coveredDep = new CoveredSmDependency();
        this.coveredDep.init("Covered", this, metamodel.getMClass(Lifeline.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.coveredDep);

    }

    @objid ("c57cf0d0-6244-4fc4-8cc9-cd5fe1768062")
    public SmAttribute getLineNumberAtt() {
        if (this.lineNumberAtt == null) {
        	this.lineNumberAtt = this.getAttributeDef("LineNumber");
        }
        return this.lineNumberAtt;
    }

    @objid ("476ee2ea-8805-4838-8964-917bfccd5597")
    public SmDependency getEnclosingOperandDep() {
        if (this.enclosingOperandDep == null) {
        	this.enclosingOperandDep = this.getDependencyDef("EnclosingOperand");
        }
        return this.enclosingOperandDep;
    }

    @objid ("7676c81f-03fa-44ca-9c90-0064f9fd0d0b")
    public SmDependency getEnclosingInteractionDep() {
        if (this.enclosingInteractionDep == null) {
        	this.enclosingInteractionDep = this.getDependencyDef("EnclosingInteraction");
        }
        return this.enclosingInteractionDep;
    }

    @objid ("9976cc76-5c6e-4e55-89f4-625b5beaed6f")
    public SmDependency getCoveredDep() {
        if (this.coveredDep == null) {
        	this.coveredDep = this.getDependencyDef("Covered");
        }
        return this.coveredDep;
    }

    @objid ("945e0f69-a69d-4df7-b43e-9cd093a35d8e")
    private static class InteractionFragmentObjectFactory implements ISmObjectFactory {
        @objid ("4359e9ea-8cb1-479d-8616-65f119b0e019")
        private InteractionFragmentSmClass smClass;

        @objid ("d23b9ce8-5fbd-4f89-a6ef-61dfe2f43df6")
        public InteractionFragmentObjectFactory(InteractionFragmentSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4b86a1b5-549c-4ade-8feb-48d5e88371f6")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("8ca343fe-caae-4b02-ac70-eb9fa8894cf3")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("b6881009-6027-4428-84d6-012e8b2e12d5")
    public static class LineNumberSmAttribute extends SmAttribute {
        @objid ("2e5c0844-9d1f-4483-bcb3-45fef9831d4e")
        public Object getValue(ISmObjectData data) {
            return ((InteractionFragmentData) data).mLineNumber;
        }

        @objid ("559b4604-b442-4cbc-a638-6bf01764a8cc")
        public void setValue(ISmObjectData data, Object value) {
            ((InteractionFragmentData) data).mLineNumber = value;
        }

    }

    @objid ("f8f351cd-fa19-4f14-86d4-26339b4d6f80")
    public static class EnclosingOperandSmDependency extends SmSingleDependency {
        @objid ("ee8bf512-0974-41ab-89f5-d19c09ee6c7e")
        private SmDependency symetricDep;

        @objid ("d97233a1-6a62-4e08-bdb5-0ce529482482")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InteractionFragmentData) data).mEnclosingOperand;
        }

        @objid ("35eb78e3-071a-422a-9045-101227faac02")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InteractionFragmentData) data).mEnclosingOperand = value;
        }

        @objid ("a40b2ed2-3a85-42a2-8f3a-b42991f7132d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionOperandSmClass)this.getTarget()).getFragmentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a10a20df-502b-4293-b8ed-abf8e24776d5")
    public static class EnclosingInteractionSmDependency extends SmSingleDependency {
        @objid ("c77c55ba-d514-43fc-ac1e-28087d34fd64")
        private SmDependency symetricDep;

        @objid ("32f7441a-623a-454a-a3c3-ed4956894826")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InteractionFragmentData) data).mEnclosingInteraction;
        }

        @objid ("04a88c96-3687-4fe6-82ed-4d584be43804")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InteractionFragmentData) data).mEnclosingInteraction = value;
        }

        @objid ("f4518f58-a4c3-4529-8114-42b44803263c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionSmClass)this.getTarget()).getFragmentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0673a414-36c7-4793-9a42-192482d7cb76")
    public static class CoveredSmDependency extends SmMultipleDependency {
        @objid ("9fa3365b-b660-47fe-bec5-a9338a177e5f")
        private SmDependency symetricDep;

        @objid ("caf7ee42-3751-48c2-8b9a-87bd99ea63c7")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InteractionFragmentData)data).mCovered != null)? ((InteractionFragmentData)data).mCovered:SmMultipleDependency.EMPTY;
        }

        @objid ("40ab0684-7cbf-41ce-b4e9-22fa71be7800")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InteractionFragmentData) data).mCovered = values;

        }

        @objid ("562f927f-bc6e-4b9c-b3f1-850c6ab1edc1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LifelineSmClass)this.getTarget()).getCoveredByDep();
            }
            return this.symetricDep;

        }

    }

}
