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
package org.modelio.metamodel.impl.uml.behavior.communicationModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.InstanceSmClass;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationInteraction;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Instance;
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

@objid ("56558095-d704-48b2-8db0-7279fe43bfa4")
public class CommunicationNodeSmClass extends UmlModelElementSmClass {
    @objid ("4fbe59b8-9b0e-44c5-84e3-379887b9b305")
    private SmAttribute selectorAtt;

    @objid ("613603b7-1de0-4168-8a7e-4c767b591b3e")
    private SmDependency ownerDep;

    @objid ("bab110a4-db72-49f9-8e2d-0eb2c51da4fd")
    private SmDependency representedDep;

    @objid ("d3760767-d825-49ea-8ed3-f67104b057c2")
    private SmDependency startedDep;

    @objid ("9c5cd2c6-81dc-4fbf-aa08-ae0030462b46")
    private SmDependency endedDep;

    @objid ("ac5bac4c-8e9f-4544-8ee2-e7f1fb385687")
    public CommunicationNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("365a02be-4a42-4917-8bcb-993fd8e34798")
    @Override
    public String getName() {
        return "CommunicationNode";

    }

    @objid ("414aead4-7365-4651-b559-4fb2bb13c31f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("22a8609a-0779-411f-8cdd-4d873d4b8f29")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CommunicationNode.class;

    }

    @objid ("4ba4999f-de7d-4ad5-a0d5-9b41c2c76c09")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7cd453db-0f31-4ee4-87e2-e4e087fa8e6c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e1d41f9b-f47d-431a-a480-f2dba0de062a")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new CommunicationNodeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.selectorAtt = new SelectorSmAttribute();
        this.selectorAtt.init("Selector", this, String.class );
        registerAttribute(this.selectorAtt);


        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(CommunicationInteraction.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.representedDep = new RepresentedSmDependency();
        this.representedDep.init("Represented", this, metamodel.getMClass(Instance.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedDep);

        this.startedDep = new StartedSmDependency();
        this.startedDep.init("Started", this, metamodel.getMClass(CommunicationChannel.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT, SmDirective.SMCDTODELETE);
        registerDependency(this.startedDep);

        this.endedDep = new EndedSmDependency();
        this.endedDep.init("Ended", this, metamodel.getMClass(CommunicationChannel.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.endedDep);

    }

    @objid ("184c74bd-f19c-48d6-9f36-f600512f2e74")
    public SmAttribute getSelectorAtt() {
        if (this.selectorAtt == null) {
        	this.selectorAtt = this.getAttributeDef("Selector");
        }
        return this.selectorAtt;
    }

    @objid ("9173a9b4-dc08-4a69-9ccd-e860b26df55b")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("16c8d205-b67c-4873-8ae3-cfde121b901b")
    public SmDependency getRepresentedDep() {
        if (this.representedDep == null) {
        	this.representedDep = this.getDependencyDef("Represented");
        }
        return this.representedDep;
    }

    @objid ("43fafb73-fa0b-49fa-9c4c-ee588f5f42d5")
    public SmDependency getStartedDep() {
        if (this.startedDep == null) {
        	this.startedDep = this.getDependencyDef("Started");
        }
        return this.startedDep;
    }

    @objid ("47834db3-df60-447d-9fd3-7d8683f742d7")
    public SmDependency getEndedDep() {
        if (this.endedDep == null) {
        	this.endedDep = this.getDependencyDef("Ended");
        }
        return this.endedDep;
    }

    @objid ("c0884110-3fd3-4da7-86eb-f6b34fc8e63c")
    private static class CommunicationNodeObjectFactory implements ISmObjectFactory {
        @objid ("86ca550f-4c63-4850-91fb-e757b4d2bb58")
        private CommunicationNodeSmClass smClass;

        @objid ("52d3c0dd-cff1-4dbf-97ab-393fe4e75260")
        public CommunicationNodeObjectFactory(CommunicationNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("006f5238-3426-4ac5-b8e9-6b2ef053e81e")
        @Override
        public ISmObjectData createData() {
            return new CommunicationNodeData(this.smClass);
        }

        @objid ("7034a3e8-7544-4080-b1bc-904cb5cae167")
        @Override
        public SmObjectImpl createImpl() {
            return new CommunicationNodeImpl();
        }

    }

    @objid ("fee409d4-004c-49fd-8645-9e7778a471b3")
    public static class SelectorSmAttribute extends SmAttribute {
        @objid ("2e9d2fa7-e431-43b0-9210-95ba68246815")
        public Object getValue(ISmObjectData data) {
            return ((CommunicationNodeData) data).mSelector;
        }

        @objid ("b2580642-f532-4bde-b295-4b5948c55179")
        public void setValue(ISmObjectData data, Object value) {
            ((CommunicationNodeData) data).mSelector = value;
        }

    }

    @objid ("f3b5abb7-378a-4bdd-ae5c-a328e83f964d")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("ed6632b8-a5d7-4f9d-a721-4932c4284f99")
        private SmDependency symetricDep;

        @objid ("78992c3f-a302-41da-8742-f367b3caa0b7")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationNodeData) data).mOwner;
        }

        @objid ("d8a051c5-18a0-460a-a691-e356a208b597")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationNodeData) data).mOwner = value;
        }

        @objid ("a3f34178-ae20-4799-b47e-d9459ff1b645")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationInteractionSmClass)this.getTarget()).getOwnedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("20818289-f575-46b1-b85f-5135e82d0819")
    public static class RepresentedSmDependency extends SmSingleDependency {
        @objid ("3034d236-96e2-480e-aaa5-538a646434f1")
        private SmDependency symetricDep;

        @objid ("3f8ddb1e-167b-4079-9573-a639c1d44fd5")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationNodeData) data).mRepresented;
        }

        @objid ("fac51855-86f1-4589-8250-31817b01f905")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationNodeData) data).mRepresented = value;
        }

        @objid ("09eda9a9-ea7c-41fe-8540-6306e3bb2a71")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getRepresentedCommunicationNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8a197959-d3f1-407f-9794-3e565d155a07")
    public static class StartedSmDependency extends SmMultipleDependency {
        @objid ("6c3e50c4-c3c4-4507-b739-315cccac6d8a")
        private SmDependency symetricDep;

        @objid ("39840f1a-f0bd-4ad5-a9dd-932816788ecf")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CommunicationNodeData)data).mStarted != null)? ((CommunicationNodeData)data).mStarted:SmMultipleDependency.EMPTY;
        }

        @objid ("d3afac24-cc26-4bfc-88c0-2511c1e1c92a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CommunicationNodeData) data).mStarted = values;

        }

        @objid ("26b50fce-a61d-417f-8652-f7d3a86cef4a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationChannelSmClass)this.getTarget()).getStartDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8a240d7e-6b99-4f87-9e38-4bace844fe87")
    public static class EndedSmDependency extends SmMultipleDependency {
        @objid ("548a575b-6659-4049-a603-f0ed86eba15b")
        private SmDependency symetricDep;

        @objid ("7ac01f5c-bc90-4e6c-acbb-80ec6ddc40a5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CommunicationNodeData)data).mEnded != null)? ((CommunicationNodeData)data).mEnded:SmMultipleDependency.EMPTY;
        }

        @objid ("9cd4c3ec-2259-4bde-8443-ae6287a10033")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CommunicationNodeData) data).mEnded = values;

        }

        @objid ("125cf95f-19d9-4834-b52f-6e81e4b365bb")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationChannelSmClass)this.getTarget()).getEndDep();
            }
            return this.symetricDep;

        }

    }

}
