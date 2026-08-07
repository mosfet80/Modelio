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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationInteraction;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
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

@objid ("b5a7bf17-d917-40f6-beec-b07d085a45c0")
public class CommunicationInteractionSmClass extends BehaviorSmClass {
    @objid ("d8a7de7a-559a-4221-bef7-9e84479d1aff")
    private SmDependency ownedDep;

    @objid ("753a3182-fce8-4eed-a174-e4680fa43a23")
    public CommunicationInteractionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("93c03c3a-fc15-46f7-9b7c-33b19832d6cf")
    @Override
    public String getName() {
        return "CommunicationInteraction";

    }

    @objid ("3e4f2837-a609-4da8-87fe-54839cda6854")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("39f820ab-70e8-401a-9396-585546aa2e9b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CommunicationInteraction.class;

    }

    @objid ("6412e3ad-019a-4c46-b661-22b6afeede6c")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("47daab14-5de9-4974-bb7b-b8d7d73314df")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("b6c6caa2-ada1-40ee-a0fb-f453ab4b1977")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new CommunicationInteractionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownedDep = new OwnedSmDependency();
        this.ownedDep.init("Owned", this, metamodel.getMClass(CommunicationNode.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedDep);

    }

    @objid ("69f7abf9-fce2-4c79-b1a8-bc3311a27e81")
    public SmDependency getOwnedDep() {
        if (this.ownedDep == null) {
        	this.ownedDep = this.getDependencyDef("Owned");
        }
        return this.ownedDep;
    }

    @objid ("9ee9419c-c416-4517-a292-26e577e67f71")
    private static class CommunicationInteractionObjectFactory implements ISmObjectFactory {
        @objid ("62a8086a-3b7c-4997-8b87-63a86879caa4")
        private CommunicationInteractionSmClass smClass;

        @objid ("dae1b3e4-ae2a-4bed-80c8-aac9439505e6")
        public CommunicationInteractionObjectFactory(CommunicationInteractionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("eed60ca4-7d05-4e9d-9032-eadc33ac6a61")
        @Override
        public ISmObjectData createData() {
            return new CommunicationInteractionData(this.smClass);
        }

        @objid ("f97d725d-9778-4ee3-9102-7d3a59dbc781")
        @Override
        public SmObjectImpl createImpl() {
            return new CommunicationInteractionImpl();
        }

    }

    @objid ("9e8f1996-862a-4285-9347-cf4e68505c06")
    public static class OwnedSmDependency extends SmMultipleDependency {
        @objid ("31288711-67bc-4af3-950e-f82f74fe272d")
        private SmDependency symetricDep;

        @objid ("47e5e2ba-4927-4678-a376-2808b62f8524")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CommunicationInteractionData)data).mOwned != null)? ((CommunicationInteractionData)data).mOwned:SmMultipleDependency.EMPTY;
        }

        @objid ("08fb16b8-b011-480c-b1ac-e35ef853e811")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CommunicationInteractionData) data).mOwned = values;

        }

        @objid ("06382596-6ef4-48c5-8dae-5dafcd75042d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationNodeSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
