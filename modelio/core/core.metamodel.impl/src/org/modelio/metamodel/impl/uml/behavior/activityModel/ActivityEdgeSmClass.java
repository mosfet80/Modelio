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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.InterruptibleActivityRegion;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
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

@objid ("8cf09d5a-5b45-402b-9ebd-b7d23239cb63")
public class ActivityEdgeSmClass extends UmlModelElementSmClass {
    @objid ("21139c7c-0008-49f1-87e9-4aa6b1b0764a")
    private SmAttribute guardAtt;

    @objid ("9bd58612-2f23-4f82-8a9a-7cbd8070a97b")
    private SmAttribute weightAtt;

    @objid ("6b1be238-d8a3-4c28-9bdd-23dfbbcebfe2")
    private SmDependency targetDep;

    @objid ("fc500125-8a3e-4cff-8f11-498381f2b63d")
    private SmDependency sourceDep;

    @objid ("140d3eca-9376-4554-85d7-ce718e45d433")
    private SmDependency interruptsDep;

    @objid ("cb1e6814-a45c-4a77-9247-21c1b4e7a985")
    private SmDependency realizedInformationFlowDep;

    @objid ("a623ddbd-c410-4237-90f4-f051f657b56f")
    public ActivityEdgeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("90d28b6f-a2da-4432-8c8f-9742d1d5bccd")
    @Override
    public String getName() {
        return "ActivityEdge";

    }

    @objid ("b71dc6cc-f924-43bc-a547-d72b16c2291e")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("544fd8e4-a539-4396-a29b-2b156e431089")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityEdge.class;

    }

    @objid ("3989fb25-7e29-4902-aa6f-786b2093532d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("750cda41-e4e5-4e86-bb4f-eb4ce6d7e7e9")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("9464390f-1453-4e01-8320-4535d6483508")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ActivityEdgeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.guardAtt = new GuardSmAttribute();
        this.guardAtt.init("Guard", this, String.class );
        registerAttribute(this.guardAtt);

        this.weightAtt = new WeightSmAttribute();
        this.weightAtt.init("Weight", this, String.class );
        registerAttribute(this.weightAtt);


        // Initialize and register the SmDependency
        this.targetDep = new TargetSmDependency();
        this.targetDep.init("Target", this, metamodel.getMClass(ActivityNode.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetDep);

        this.sourceDep = new SourceSmDependency();
        this.sourceDep.init("Source", this, metamodel.getMClass(ActivityNode.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.sourceDep);

        this.interruptsDep = new InterruptsSmDependency();
        this.interruptsDep.init("Interrupts", this, metamodel.getMClass(InterruptibleActivityRegion.MQNAME), 0, 1 );
        registerDependency(this.interruptsDep);

        this.realizedInformationFlowDep = new RealizedInformationFlowSmDependency();
        this.realizedInformationFlowDep.init("RealizedInformationFlow", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.realizedInformationFlowDep);

    }

    @objid ("2f4853fe-1457-4cbf-91d7-d4640453612f")
    public SmAttribute getGuardAtt() {
        if (this.guardAtt == null) {
        	this.guardAtt = this.getAttributeDef("Guard");
        }
        return this.guardAtt;
    }

    @objid ("21208daf-8ef5-4373-9821-615b66fb41d1")
    public SmAttribute getWeightAtt() {
        if (this.weightAtt == null) {
        	this.weightAtt = this.getAttributeDef("Weight");
        }
        return this.weightAtt;
    }

    @objid ("e6f53596-b307-4691-ac4b-8b4a63ea3208")
    public SmDependency getTargetDep() {
        if (this.targetDep == null) {
        	this.targetDep = this.getDependencyDef("Target");
        }
        return this.targetDep;
    }

    @objid ("af14e1d3-5309-47a5-b6ee-6a0d9ff59277")
    public SmDependency getSourceDep() {
        if (this.sourceDep == null) {
        	this.sourceDep = this.getDependencyDef("Source");
        }
        return this.sourceDep;
    }

    @objid ("5b2bd157-2c83-4074-b5d5-8ac376058f12")
    public SmDependency getInterruptsDep() {
        if (this.interruptsDep == null) {
        	this.interruptsDep = this.getDependencyDef("Interrupts");
        }
        return this.interruptsDep;
    }

    @objid ("7c9fc5e0-5237-4e6a-b4d1-641444d76e89")
    public SmDependency getRealizedInformationFlowDep() {
        if (this.realizedInformationFlowDep == null) {
        	this.realizedInformationFlowDep = this.getDependencyDef("RealizedInformationFlow");
        }
        return this.realizedInformationFlowDep;
    }

    @objid ("96e12e2c-339d-4f51-9b51-b9357d176fe1")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("fabbc42a-95dc-4161-9ee3-3256d9f69cd1")
    private static class ActivityEdgeObjectFactory implements ISmObjectFactory {
        @objid ("75f65a30-c0ab-4a0e-8fb8-18e62eb2bc5a")
        private ActivityEdgeSmClass smClass;

        @objid ("6762bf25-f3e1-4484-98fa-ff55f3324df1")
        public ActivityEdgeObjectFactory(ActivityEdgeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("873eeccb-29f0-4703-a79d-24992609fbef")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("5a01afa8-8ccc-460d-8578-f657623f9cbc")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("da7c0da1-83a9-4f5c-963a-04645cbe2890")
    public static class GuardSmAttribute extends SmAttribute {
        @objid ("ac5f2c6b-1dec-4a41-b911-21d4f8d870b3")
        public Object getValue(ISmObjectData data) {
            return ((ActivityEdgeData) data).mGuard;
        }

        @objid ("6fa9032f-359f-418d-89ed-105517595b15")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityEdgeData) data).mGuard = value;
        }

    }

    @objid ("f0e617b3-212c-45c1-a785-8fd0b92df9dc")
    public static class WeightSmAttribute extends SmAttribute {
        @objid ("2fc8e9b5-28a1-43c7-a78c-514339679ea4")
        public Object getValue(ISmObjectData data) {
            return ((ActivityEdgeData) data).mWeight;
        }

        @objid ("3c41c329-8fa8-4fd5-8d9a-7bb177a87cd1")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityEdgeData) data).mWeight = value;
        }

    }

    @objid ("b9ee5417-26c6-4ec7-a768-4189a264f245")
    public static class TargetSmDependency extends SmSingleDependency {
        @objid ("913626cf-2047-472d-a7e0-5914c27368a1")
        private SmDependency symetricDep;

        @objid ("e3607b59-f7e5-4480-9429-9d7d4f01e474")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityEdgeData) data).mTarget;
        }

        @objid ("001f0d5b-938d-4f03-8160-350252b1cd0c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityEdgeData) data).mTarget = value;
        }

        @objid ("4fc6b93e-e53a-4f8a-a9d9-c185200a1936")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityNodeSmClass)this.getTarget()).getIncomingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a3bb85c2-43dc-475e-810c-c7c5973266cb")
    public static class SourceSmDependency extends SmSingleDependency {
        @objid ("0ef5253e-5881-484b-8bfb-243b306a9bb2")
        private SmDependency symetricDep;

        @objid ("1fe3209a-ec63-4cf7-be89-ae8be5d63ba7")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityEdgeData) data).mSource;
        }

        @objid ("4e2c26ba-e45b-4da8-91de-477a807cf7bd")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityEdgeData) data).mSource = value;
        }

        @objid ("e269fcc6-4f7a-4de3-8124-a74cd07c53ac")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityNodeSmClass)this.getTarget()).getOutgoingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c8ad2b22-923f-4570-9b1e-0ddebbbf87ad")
    public static class InterruptsSmDependency extends SmSingleDependency {
        @objid ("83862f21-5b58-4378-b043-d41fe82517c3")
        private SmDependency symetricDep;

        @objid ("7315e167-a247-40ea-9fbb-f5b68bda966a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityEdgeData) data).mInterrupts;
        }

        @objid ("9a49ff33-a889-4fde-9588-41553211f58c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityEdgeData) data).mInterrupts = value;
        }

        @objid ("a7845fe3-60dc-4a96-9c8e-d4d879ece23a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InterruptibleActivityRegionSmClass)this.getTarget()).getInterruptingEdgeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0b0a84e7-5b62-4ed3-8c38-bb34a7c66dc2")
    public static class RealizedInformationFlowSmDependency extends SmMultipleDependency {
        @objid ("dcdf9554-d112-42a2-82eb-7855db443f6c")
        private SmDependency symetricDep;

        @objid ("705798bd-5e51-4d80-bbe0-e541ff54eca9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityEdgeData)data).mRealizedInformationFlow != null)? ((ActivityEdgeData)data).mRealizedInformationFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("40b63363-8c78-4984-8d8e-dd83fce97c82")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityEdgeData) data).mRealizedInformationFlow = values;

        }

        @objid ("1ffd950e-d912-4e22-878b-74437539e055")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getRealizingActivityEdgeDep();
            }
            return this.symetricDep;

        }

    }

}
