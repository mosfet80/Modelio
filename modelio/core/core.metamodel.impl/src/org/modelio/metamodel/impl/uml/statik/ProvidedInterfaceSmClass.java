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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.uml.statik.Port;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f116ca1f-783f-4238-a733-e36b905a594b")
public class ProvidedInterfaceSmClass extends UmlModelElementSmClass {
    @objid ("43755f34-2389-43c0-b29c-aef852794243")
    private SmDependency providedElementDep;

    @objid ("22b1e808-b2da-4349-a891-475b9e2ebecf")
    private SmDependency providingDep;

    @objid ("c3b0a842-fa26-4c81-8e41-90a9fe703d04")
    private SmDependency consumerDep;

    @objid ("cc627581-2b4c-4440-8727-f5d26fc88d6c")
    private SmDependency naryConsumerDep;

    @objid ("f51ecf4c-eb85-4d84-991b-5ae29fb591b1")
    public ProvidedInterfaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b92026c6-b807-4e20-bca8-15d6631f44ff")
    @Override
    public String getName() {
        return "ProvidedInterface";

    }

    @objid ("b31ffa26-9eaa-4ba3-b4fe-c32e6149edba")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0c13885b-f491-453f-a1d9-ebf96bb9937c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ProvidedInterface.class;

    }

    @objid ("e3c1dfac-307a-42a1-8f64-b50ebdfc5a05")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("4db57c13-57df-4273-b3cf-05262c03d6e1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f8bac402-30a6-4ea8-8e2a-a6d4a3734c85")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ProvidedInterfaceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.providedElementDep = new ProvidedElementSmDependency();
        this.providedElementDep.init("ProvidedElement", this, metamodel.getMClass(Interface.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.providedElementDep);

        this.providingDep = new ProvidingSmDependency();
        this.providingDep.init("Providing", this, metamodel.getMClass(Port.MQNAME), 1, 1 );
        registerDependency(this.providingDep);

        this.consumerDep = new ConsumerSmDependency();
        this.consumerDep.init("Consumer", this, metamodel.getMClass(LinkEnd.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.consumerDep);

        this.naryConsumerDep = new NaryConsumerSmDependency();
        this.naryConsumerDep.init("NaryConsumer", this, metamodel.getMClass(NaryLinkEnd.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.naryConsumerDep);

    }

    @objid ("2123fbf3-8eda-45ea-aa49-dc216b543338")
    public SmDependency getProvidedElementDep() {
        if (this.providedElementDep == null) {
        	this.providedElementDep = this.getDependencyDef("ProvidedElement");
        }
        return this.providedElementDep;
    }

    @objid ("1248b0d2-2f0c-46d2-8ea9-427e8cf66239")
    public SmDependency getProvidingDep() {
        if (this.providingDep == null) {
        	this.providingDep = this.getDependencyDef("Providing");
        }
        return this.providingDep;
    }

    @objid ("3ef9218d-a077-4ac8-8bf3-3ffb2ac2452e")
    public SmDependency getConsumerDep() {
        if (this.consumerDep == null) {
        	this.consumerDep = this.getDependencyDef("Consumer");
        }
        return this.consumerDep;
    }

    @objid ("ab3a9163-a8b6-489b-af6d-000a15474b7e")
    public SmDependency getNaryConsumerDep() {
        if (this.naryConsumerDep == null) {
        	this.naryConsumerDep = this.getDependencyDef("NaryConsumer");
        }
        return this.naryConsumerDep;
    }

    @objid ("d16cd277-142c-45b1-966d-7bbf104a39a1")
    private static class ProvidedInterfaceObjectFactory implements ISmObjectFactory {
        @objid ("31d00c0f-f4d8-474a-bba7-a806552176e6")
        private ProvidedInterfaceSmClass smClass;

        @objid ("78e93558-dce3-48e8-ab41-0d548a619397")
        public ProvidedInterfaceObjectFactory(ProvidedInterfaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("738515ff-bdc4-4276-8f8a-2f3d336243f6")
        @Override
        public ISmObjectData createData() {
            return new ProvidedInterfaceData(this.smClass);
        }

        @objid ("ae962a0b-5337-44b7-84f7-f0386f047c62")
        @Override
        public SmObjectImpl createImpl() {
            return new ProvidedInterfaceImpl();
        }

    }

    @objid ("c30e375c-cec6-456c-8a82-0326071a3891")
    public static class ProvidedElementSmDependency extends SmMultipleDependency {
        @objid ("3bc22004-3707-4242-bc41-d64e4872f147")
        private SmDependency symetricDep;

        @objid ("d2e68c5b-c7f4-4c56-8400-dd8e9f12f44d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ProvidedInterfaceData)data).mProvidedElement != null)? ((ProvidedInterfaceData)data).mProvidedElement:SmMultipleDependency.EMPTY;
        }

        @objid ("6a5781cb-9295-4de3-9554-2697bd9171dd")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ProvidedInterfaceData) data).mProvidedElement = values;

        }

        @objid ("74ac6cbe-af18-431e-a981-fa71ce5aa650")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InterfaceSmClass)this.getTarget()).getProvidingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("11724740-e012-47e2-9281-726b68c6ce1d")
    public static class ProvidingSmDependency extends SmSingleDependency {
        @objid ("ded1b25d-14bb-44c7-b13e-7dc47112b47a")
        private SmDependency symetricDep;

        @objid ("f03c08d5-31d0-477c-b5cf-c99ffacdb59d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ProvidedInterfaceData) data).mProviding;
        }

        @objid ("2405f910-5a21-47ae-8fa9-5ffd9d8e7097")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ProvidedInterfaceData) data).mProviding = value;
        }

        @objid ("5ae0c389-737c-4dab-a930-f2ba389f2608")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PortSmClass)this.getTarget()).getProvidedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("95978565-5834-4061-b9f7-9958d1de3f12")
    public static class ConsumerSmDependency extends SmMultipleDependency {
        @objid ("926c2953-4914-45a2-8c26-232ddd5b4a8d")
        private SmDependency symetricDep;

        @objid ("5a1f49c3-81da-470b-b9d0-755f34540861")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ProvidedInterfaceData)data).mConsumer != null)? ((ProvidedInterfaceData)data).mConsumer:SmMultipleDependency.EMPTY;
        }

        @objid ("7c2467d1-2fad-4c17-b7cc-fbcc8db916b4")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ProvidedInterfaceData) data).mConsumer = values;

        }

        @objid ("d949240b-6320-45b9-9758-5d8a3a82cd71")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getProviderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1e73fefa-9135-4b84-95c5-b8f2690a0755")
    public static class NaryConsumerSmDependency extends SmMultipleDependency {
        @objid ("d781a470-ef34-41e1-acf6-91f38631eaf5")
        private SmDependency symetricDep;

        @objid ("3ade278d-a897-4664-9dda-f16af549c09c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ProvidedInterfaceData)data).mNaryConsumer != null)? ((ProvidedInterfaceData)data).mNaryConsumer:SmMultipleDependency.EMPTY;
        }

        @objid ("04262e50-35a6-42d0-bca0-070c6fb943b3")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ProvidedInterfaceData) data).mNaryConsumer = values;

        }

        @objid ("b013d49e-b42a-4ee3-b434-b226ebd16f9d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkEndSmClass)this.getTarget()).getProviderDep();
            }
            return this.symetricDep;

        }

    }

}
