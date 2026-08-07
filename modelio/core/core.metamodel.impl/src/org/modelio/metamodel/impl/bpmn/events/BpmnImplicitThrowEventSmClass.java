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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;
import org.modelio.metamodel.bpmn.events.BpmnImplicitThrowEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.impl.bpmn.activities.BpmnComplexBehaviorDefinitionSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0c7e2bb3-5654-4514-8de6-3b68a364fb8f")
public class BpmnImplicitThrowEventSmClass extends BpmnThrowEventSmClass {
    @objid ("af1dc569-c057-4606-8d09-d2c160f1bb35")
    private SmDependency ownerDep;

    @objid ("98ad7a91-f4f1-4607-a5bb-3e9a789a8393")
    public BpmnImplicitThrowEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a10e131c-51de-421d-8f91-d70065de2030")
    @Override
    public String getName() {
        return "BpmnImplicitThrowEvent";

    }

    @objid ("0c04ec95-99ad-4cdc-9911-c9fdda45cfd2")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("a6876b43-d0a6-4481-87af-5b03b9246030")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnImplicitThrowEvent.class;

    }

    @objid ("7d2b3224-51db-4197-9e5c-9a5ec1120a89")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("d41a36b6-5159-4d80-845c-91ac377f3580")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a5ea7390-875e-4d0b-888c-f1a30f8e60ce")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnThrowEvent.MQNAME);
        this.registerFactory(new BpmnImplicitThrowEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(BpmnComplexBehaviorDefinition.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

    }

    @objid ("01d5c1ba-76fa-4274-a453-4a91a974a49b")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("b508cbda-c8df-47c2-8745-ac80c6be966e")
    private static class BpmnImplicitThrowEventObjectFactory implements ISmObjectFactory {
        @objid ("cd02046e-de5a-4373-b4a5-d9a865ef4cf5")
        private BpmnImplicitThrowEventSmClass smClass;

        @objid ("087fb99e-6423-458a-8d85-9e6dff60b7c8")
        public BpmnImplicitThrowEventObjectFactory(BpmnImplicitThrowEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("8adab571-35bb-42ba-b5bd-3a67d8f27377")
        @Override
        public ISmObjectData createData() {
            return new BpmnImplicitThrowEventData(this.smClass);
        }

        @objid ("05fe1f68-2d78-46c4-93c8-556551925988")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnImplicitThrowEventImpl();
        }

    }

    @objid ("80713db7-121d-4952-b5cd-052c3ae89fb1")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("753a207a-e94e-4c9e-afa8-9c0d882c4133")
        private SmDependency symetricDep;

        @objid ("ec2b5a99-706a-4cf2-a1ec-43f1176eb426")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnImplicitThrowEventData) data).mOwner;
        }

        @objid ("ac53914c-0ab4-470a-a6e7-fe02d98a57c0")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnImplicitThrowEventData) data).mOwner = value;
        }

        @objid ("946f2aca-bf23-45cd-8257-e36b410c86d5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnComplexBehaviorDefinitionSmClass)this.getTarget()).getEventDep();
            }
            return this.symetricDep;

        }

    }

}
