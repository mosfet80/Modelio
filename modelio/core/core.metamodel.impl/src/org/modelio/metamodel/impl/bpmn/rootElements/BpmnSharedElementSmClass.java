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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedDefinitions;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
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

@objid ("d5f4ebb4-3968-4aeb-aa18-51f916d1551c")
public class BpmnSharedElementSmClass extends BpmnBaseElementSmClass {
    @objid ("be847615-d322-4995-a5f9-6e9dba6d2e57")
    private SmDependency ownerDep;

    @objid ("88b209e7-11d7-4357-b410-a08b3d530b02")
    public BpmnSharedElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("adeffba6-5844-43b6-a071-faebec512d5d")
    @Override
    public String getName() {
        return "BpmnSharedElement";

    }

    @objid ("387e0d26-45b2-4cad-876d-957ccad5f2e3")
    @Override
    public Version getVersion() {
        return new Version("2.2.0");
    }

    @objid ("eaa49660-7f98-4bc7-847c-a996b8743e98")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSharedElement.class;

    }

    @objid ("b5a31b27-44a4-4bd0-98a7-cd446cf9b442")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("924c9bec-5220-47df-a28b-251a25010c6e")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("6858e927-1689-4bed-a2d6-7cdbba057258")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnSharedElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(BpmnSharedDefinitions.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

    }

    @objid ("f8f5babf-6c3a-4d7b-870c-dda8bdc07176")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("1b298ded-cb75-49f0-b31b-2827087b721b")
    private static class BpmnSharedElementObjectFactory implements ISmObjectFactory {
        @objid ("beb98c2f-2272-44b2-80c3-031c2a9c0936")
        private BpmnSharedElementSmClass smClass;

        @objid ("b9677a68-6616-4ebc-af7a-6e6e4845e294")
        public BpmnSharedElementObjectFactory(BpmnSharedElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b045beee-0e65-4bf7-9449-a6172799752f")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("a13d2f03-3e41-4efc-894f-63febd7ae2f7")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("1e92a3d4-7489-4834-8417-f938d95a746d")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("a1d76e97-2239-4d51-a05c-a8ef273e1a09")
        private SmDependency symetricDep;

        @objid ("d1f74d55-7942-4339-aaed-7ebc1abcaf65")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSharedElementData) data).mOwner;
        }

        @objid ("fccfd4ba-acfe-4621-aa04-c18a693fadfa")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSharedElementData) data).mOwner = value;
        }

        @objid ("42e1f65d-4c6d-42ad-8ac1-fad07e71dc7d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSharedDefinitionsSmClass)this.getTarget()).getRootElementDep();
            }
            return this.symetricDep;

        }

    }

}
