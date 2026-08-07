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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1b1f068e-525b-4f7a-9473-ef168b604540")
public class InteractionSmClass extends BehaviorSmClass {
    @objid ("09a87cd0-5249-4915-9ee7-114cd8c2109d")
    private SmDependency formalGateDep;

    @objid ("46c45e60-6d1f-47fc-b67a-82b5616ab6fd")
    private SmDependency fragmentDep;

    @objid ("a81d53eb-a8ce-46e3-8120-b46bff579c3d")
    private SmDependency ownedLineDep;

    @objid ("a48445e8-95d0-4d8a-bda1-e8dcc94d7860")
    private SmDependency referedUseDep;

    @objid ("3f7612c2-ccb9-4d71-ae0e-e6c3c8952d83")
    public InteractionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("cc206f2d-cd4d-41ca-ba5a-aa9ea2174311")
    @Override
    public String getName() {
        return "Interaction";

    }

    @objid ("35633a0f-dd59-42b5-a375-1f774a0d766b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3b8e3f70-4a1a-4c84-8a51-efd5ef27dff1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Interaction.class;

    }

    @objid ("f092328f-cc8e-443c-9f96-0b935f3e7f9a")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("0c1beed1-8e1b-4eb6-843d-2a7c149c32ec")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("c434b0a0-2ef6-46e5-8cc5-9a9c484e50b6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new InteractionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.formalGateDep = new FormalGateSmDependency();
        this.formalGateDep.init("FormalGate", this, metamodel.getMClass(Gate.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.formalGateDep);

        this.fragmentDep = new FragmentSmDependency();
        this.fragmentDep.init("Fragment", this, metamodel.getMClass(InteractionFragment.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.fragmentDep);

        this.ownedLineDep = new OwnedLineSmDependency();
        this.ownedLineDep.init("OwnedLine", this, metamodel.getMClass(Lifeline.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedLineDep);

        this.referedUseDep = new ReferedUseSmDependency();
        this.referedUseDep.init("ReferedUse", this, metamodel.getMClass(InteractionUse.MQNAME), 0, -1 );
        registerDependency(this.referedUseDep);

    }

    @objid ("91648d83-7df8-487e-9fb8-a89e4d435247")
    public SmDependency getFormalGateDep() {
        if (this.formalGateDep == null) {
        	this.formalGateDep = this.getDependencyDef("FormalGate");
        }
        return this.formalGateDep;
    }

    @objid ("c307eca7-bb21-454f-ae8e-f313b255326f")
    public SmDependency getFragmentDep() {
        if (this.fragmentDep == null) {
        	this.fragmentDep = this.getDependencyDef("Fragment");
        }
        return this.fragmentDep;
    }

    @objid ("be5efb08-20ee-41b4-85e9-e954256d9c92")
    public SmDependency getOwnedLineDep() {
        if (this.ownedLineDep == null) {
        	this.ownedLineDep = this.getDependencyDef("OwnedLine");
        }
        return this.ownedLineDep;
    }

    @objid ("8bbbcd39-76e7-413f-a1f1-2f78f81a124e")
    public SmDependency getReferedUseDep() {
        if (this.referedUseDep == null) {
        	this.referedUseDep = this.getDependencyDef("ReferedUse");
        }
        return this.referedUseDep;
    }

    @objid ("9b2b5ab7-c549-4f7b-9019-297665a5779b")
    private static class InteractionObjectFactory implements ISmObjectFactory {
        @objid ("e5a159b5-04d8-4072-81c6-b3a0022c146a")
        private InteractionSmClass smClass;

        @objid ("68a02de0-3b9a-4675-bb07-f9dcb79712f7")
        public InteractionObjectFactory(InteractionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("71aaf2c5-6ef7-4bd5-b5bc-66619c903f6b")
        @Override
        public ISmObjectData createData() {
            return new InteractionData(this.smClass);
        }

        @objid ("fdd7ba34-aad5-4264-af07-4d6c154cd92a")
        @Override
        public SmObjectImpl createImpl() {
            return new InteractionImpl();
        }

    }

    @objid ("a8410462-4edd-4ef7-8f5a-02f6e7514255")
    public static class FormalGateSmDependency extends SmMultipleDependency {
        @objid ("9a2d212a-c791-48db-bfc4-7e9786fb0f29")
        private SmDependency symetricDep;

        @objid ("cff21beb-5bb8-485c-a27b-0ba8eca939ea")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InteractionData)data).mFormalGate != null)? ((InteractionData)data).mFormalGate:SmMultipleDependency.EMPTY;
        }

        @objid ("8df1c719-511b-41f0-aa29-f34dbb216540")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InteractionData) data).mFormalGate = values;

        }

        @objid ("61789af0-99d9-47bf-aef2-c0ea6d9a4575")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GateSmClass)this.getTarget()).getOwnerInteractionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6080babd-9847-43f9-8c35-fb1ca46234a3")
    public static class FragmentSmDependency extends SmMultipleDependency {
        @objid ("dd8ac507-16c9-4e10-9d6d-4bd453ee2347")
        private SmDependency symetricDep;

        @objid ("1ed9ffa4-bae1-4a49-9f00-6cf5174c1b33")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InteractionData)data).mFragment != null)? ((InteractionData)data).mFragment:SmMultipleDependency.EMPTY;
        }

        @objid ("b93bf120-46c5-4513-85f4-89597adef456")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InteractionData) data).mFragment = values;

        }

        @objid ("635c581a-ded0-4413-bd39-74f6d2af6892")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionFragmentSmClass)this.getTarget()).getEnclosingInteractionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c0389a7c-b00a-43fd-bf0f-b6bc24249dfa")
    public static class OwnedLineSmDependency extends SmMultipleDependency {
        @objid ("e3a4aebb-0d9a-45ca-9325-c489d2f98661")
        private SmDependency symetricDep;

        @objid ("c10b4e55-0e22-4290-8fc8-93c0198df72a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InteractionData)data).mOwnedLine != null)? ((InteractionData)data).mOwnedLine:SmMultipleDependency.EMPTY;
        }

        @objid ("0e68448f-a5ea-4c9f-815a-9745d731ff2f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InteractionData) data).mOwnedLine = values;

        }

        @objid ("a83bd2be-7365-481e-a2f1-c4de782ca3b4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LifelineSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0c845625-3e90-4f59-af96-6827d23be178")
    public static class ReferedUseSmDependency extends SmMultipleDependency {
        @objid ("55fb3c94-f188-4916-a92a-0c13f21650d5")
        private SmDependency symetricDep;

        @objid ("496bc2ff-d044-4464-90c6-06e8ab53340f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InteractionData)data).mReferedUse != null)? ((InteractionData)data).mReferedUse:SmMultipleDependency.EMPTY;
        }

        @objid ("e25b0fd9-3a50-4d96-93db-7af9db22385c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InteractionData) data).mReferedUse = values;

        }

        @objid ("489f8b99-06ce-4ed0-a9c2-4ea2e7073aa1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionUseSmClass)this.getTarget()).getRefersToDep();
            }
            return this.symetricDep;

        }

    }

}
