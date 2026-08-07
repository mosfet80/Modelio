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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionNode;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionRegion;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
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

@objid ("ce238240-a882-429d-80cd-99a484941658")
public class ExpansionNodeSmClass extends ObjectNodeSmClass {
    @objid ("57b36776-5553-4bec-a06c-90e6c7ee3462")
    private SmDependency regionAsOutputDep;

    @objid ("c95b30fe-a5c4-4d05-8c93-d4d89cd2caa4")
    private SmDependency regionAsInputDep;

    @objid ("e30dfcb6-1302-4d3d-a52a-2f1be754c6a1")
    public ExpansionNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("475c2fc5-aab5-47d5-8216-695980d5a4b1")
    @Override
    public String getName() {
        return "ExpansionNode";

    }

    @objid ("7de691a4-97c5-4d09-b572-ca56edab820e")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("435b0b68-060c-4e0c-b1b4-695b9b20461c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExpansionNode.class;

    }

    @objid ("6620949a-1155-42db-b717-3f4b4af61a45")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e522aaed-c8e6-4620-a773-dcb4bd3e7326")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("3a136978-455a-4981-9dd0-b370269877c5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ObjectNode.MQNAME);
        this.registerFactory(new ExpansionNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.regionAsOutputDep = new RegionAsOutputSmDependency();
        this.regionAsOutputDep.init("RegionAsOutput", this, metamodel.getMClass(ExpansionRegion.MQNAME), 0, 1 );
        registerDependency(this.regionAsOutputDep);

        this.regionAsInputDep = new RegionAsInputSmDependency();
        this.regionAsInputDep.init("RegionAsInput", this, metamodel.getMClass(ExpansionRegion.MQNAME), 0, 1 );
        registerDependency(this.regionAsInputDep);

    }

    @objid ("a3ec179a-b3ca-4917-9a5c-f60e4b5c2dce")
    public SmDependency getRegionAsOutputDep() {
        if (this.regionAsOutputDep == null) {
        	this.regionAsOutputDep = this.getDependencyDef("RegionAsOutput");
        }
        return this.regionAsOutputDep;
    }

    @objid ("ec326adc-acf4-47ec-bb74-a6676f4ead42")
    public SmDependency getRegionAsInputDep() {
        if (this.regionAsInputDep == null) {
        	this.regionAsInputDep = this.getDependencyDef("RegionAsInput");
        }
        return this.regionAsInputDep;
    }

    @objid ("d8485453-317c-4e8b-afb8-aacbf602cc68")
    private static class ExpansionNodeObjectFactory implements ISmObjectFactory {
        @objid ("bec35474-a4fb-4cb8-8d8e-f566045f36bd")
        private ExpansionNodeSmClass smClass;

        @objid ("1fa25fc0-9303-4778-a299-24fcf120299d")
        public ExpansionNodeObjectFactory(ExpansionNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("323c50b8-27bc-43e0-8ca7-61a7089019f3")
        @Override
        public ISmObjectData createData() {
            return new ExpansionNodeData(this.smClass);
        }

        @objid ("76a5880b-f967-47d8-b324-d91254ddc54d")
        @Override
        public SmObjectImpl createImpl() {
            return new ExpansionNodeImpl();
        }

    }

    @objid ("b628fe1b-7f4e-4964-95a2-9e94e41fd395")
    public static class RegionAsOutputSmDependency extends SmSingleDependency {
        @objid ("48257ecd-37b3-4d67-a2d7-2a05cf350e9d")
        private SmDependency symetricDep;

        @objid ("4c59ee4f-f83c-4535-aac9-2e4f6068fd93")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExpansionNodeData) data).mRegionAsOutput;
        }

        @objid ("c8fd76f9-e9d9-431d-ba80-1bcf5493381b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExpansionNodeData) data).mRegionAsOutput = value;
        }

        @objid ("ccb68e0e-80b9-4bfc-9aa6-47d39b08a2c4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExpansionRegionSmClass)this.getTarget()).getOutputElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ed1b8992-4d0b-4992-92a0-2322b7290def")
    public static class RegionAsInputSmDependency extends SmSingleDependency {
        @objid ("8e674174-64b3-4863-804a-f3113f4c17a1")
        private SmDependency symetricDep;

        @objid ("282809f6-46c8-4db5-af94-ae2eb96d9ac3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExpansionNodeData) data).mRegionAsInput;
        }

        @objid ("50015a7a-2379-47e1-9be3-8a07ba1c1d8d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExpansionNodeData) data).mRegionAsInput = value;
        }

        @objid ("74e707c6-49f7-46ae-91c2-c74a5c87375f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExpansionRegionSmClass)this.getTarget()).getInputElementDep();
            }
            return this.symetricDep;

        }

    }

}
