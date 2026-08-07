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
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
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

@objid ("cc151a74-505a-48b1-a76f-acbe1981f23b")
public class InteractionUseSmClass extends InteractionFragmentSmClass {
    @objid ("486ad564-2e25-41f8-9ab5-f99d10ac098c")
    private SmAttribute endLineNumberAtt;

    @objid ("076cb97a-cd72-4e40-85b0-bf56657e733f")
    private SmDependency actualGateDep;

    @objid ("557be138-0a46-422f-b2c0-375bb439b07c")
    private SmDependency refersToDep;

    @objid ("6847a097-02b3-4baf-a4c0-b286cfe23f7c")
    public InteractionUseSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("09ff31f6-4ee8-41fb-9779-90f8045195ec")
    @Override
    public String getName() {
        return "InteractionUse";

    }

    @objid ("60f4ec86-c7fc-4ac0-affe-426ffc5fe47b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("fb3bd9cf-582a-4f09-a55b-fda1b41abeec")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InteractionUse.class;

    }

    @objid ("1f80ceb9-6672-4127-af7a-61f82913a34f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a4293099-2d7c-40a8-ac02-fc1be3f6fd4d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("eb5874e8-cd8c-472f-a05b-f5e29bcecae0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InteractionFragment.MQNAME);
        this.registerFactory(new InteractionUseObjectFactory(this));


        // Initialize and register the SmAttribute
        this.endLineNumberAtt = new EndLineNumberSmAttribute();
        this.endLineNumberAtt.init("EndLineNumber", this, Integer.class );
        registerAttribute(this.endLineNumberAtt);


        // Initialize and register the SmDependency
        this.actualGateDep = new ActualGateSmDependency();
        this.actualGateDep.init("ActualGate", this, metamodel.getMClass(Gate.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.actualGateDep);

        this.refersToDep = new RefersToSmDependency();
        this.refersToDep.init("RefersTo", this, metamodel.getMClass(Interaction.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.refersToDep);

    }

    @objid ("1626afc3-2944-4025-b8ab-13e0cbf60df7")
    public SmAttribute getEndLineNumberAtt() {
        if (this.endLineNumberAtt == null) {
        	this.endLineNumberAtt = this.getAttributeDef("EndLineNumber");
        }
        return this.endLineNumberAtt;
    }

    @objid ("470a4080-db0a-47d0-bd91-71697e1ff080")
    public SmDependency getActualGateDep() {
        if (this.actualGateDep == null) {
        	this.actualGateDep = this.getDependencyDef("ActualGate");
        }
        return this.actualGateDep;
    }

    @objid ("e1acd62e-b71f-4764-949d-5331b9512bb9")
    public SmDependency getRefersToDep() {
        if (this.refersToDep == null) {
        	this.refersToDep = this.getDependencyDef("RefersTo");
        }
        return this.refersToDep;
    }

    @objid ("9c714291-628e-495d-a223-1a9050bef7e0")
    private static class InteractionUseObjectFactory implements ISmObjectFactory {
        @objid ("a7e1648b-39b4-4ef9-b32f-c104a5d44528")
        private InteractionUseSmClass smClass;

        @objid ("820507ff-840b-43b5-96e1-61fd865f1556")
        public InteractionUseObjectFactory(InteractionUseSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("098ceb00-e6b6-4f69-bfd4-6ce383fefa2b")
        @Override
        public ISmObjectData createData() {
            return new InteractionUseData(this.smClass);
        }

        @objid ("97fb0622-dc9a-4f38-81e4-4cf24a0dabe8")
        @Override
        public SmObjectImpl createImpl() {
            return new InteractionUseImpl();
        }

    }

    @objid ("403d7957-db67-495f-b44f-09eb2d72f808")
    public static class EndLineNumberSmAttribute extends SmAttribute {
        @objid ("da88d7a1-091e-42c8-a534-e4b0478cc463")
        public Object getValue(ISmObjectData data) {
            return ((InteractionUseData) data).mEndLineNumber;
        }

        @objid ("1be3ca75-c760-466d-9dd1-080d03f47fc9")
        public void setValue(ISmObjectData data, Object value) {
            ((InteractionUseData) data).mEndLineNumber = value;
        }

    }

    @objid ("4bf53c80-60ea-4450-b729-8a8138be8a2a")
    public static class ActualGateSmDependency extends SmMultipleDependency {
        @objid ("7f2240ce-8c56-495a-a3b8-bd47c6d85623")
        private SmDependency symetricDep;

        @objid ("65724913-96bf-410a-90e1-2cd94cc96858")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InteractionUseData)data).mActualGate != null)? ((InteractionUseData)data).mActualGate:SmMultipleDependency.EMPTY;
        }

        @objid ("add99bcc-d553-4924-aae0-de3f98c54a12")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InteractionUseData) data).mActualGate = values;

        }

        @objid ("aa16f750-0b49-43d8-8a7c-beab194333b6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GateSmClass)this.getTarget()).getOwnerUseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("eeab4f67-e9af-47ff-a002-5385e7ad5e2f")
    public static class RefersToSmDependency extends SmSingleDependency {
        @objid ("0b2b9e99-903e-4da6-a506-c8be74393885")
        private SmDependency symetricDep;

        @objid ("514e1d58-fc1c-43df-8199-6f70700ab992")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InteractionUseData) data).mRefersTo;
        }

        @objid ("eb6ecbda-b6cc-47cf-aa3b-fc14124b7f40")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InteractionUseData) data).mRefersTo = value;
        }

        @objid ("0e55256e-cc0c-4942-8c40-083441bc5fa4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionSmClass)this.getTarget()).getReferedUseDep();
            }
            return this.symetricDep;

        }

    }

}
