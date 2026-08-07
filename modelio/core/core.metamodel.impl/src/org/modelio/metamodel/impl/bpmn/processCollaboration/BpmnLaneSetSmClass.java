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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnSubProcessSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
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

@objid ("bb3e2389-913f-45ac-a54e-c1807ef28bc2")
public class BpmnLaneSetSmClass extends BpmnBaseElementSmClass {
    @objid ("1bf55c55-a722-4261-a31d-f4ae137a2051")
    private SmDependency laneDep;

    @objid ("a3a73486-6596-491b-bdf3-259a923bc007")
    private SmDependency processDep;

    @objid ("448f49ca-c847-4d45-b333-03120871eecf")
    private SmDependency parentLaneDep;

    @objid ("b9a9ec7f-f749-4ffb-b134-b35aa49019c0")
    private SmDependency subProcessDep;

    @objid ("c7fd224f-1f53-4e40-acae-94ec261e4636")
    public BpmnLaneSetSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("16e96a12-c802-4186-ba38-c4e56db79d41")
    @Override
    public String getName() {
        return "BpmnLaneSet";

    }

    @objid ("091dfa3e-761e-48ea-9c68-3aae6a7f440b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("925317fd-c147-4b1c-a5cd-f7918beca9ab")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnLaneSet.class;

    }

    @objid ("9f8f00fa-a976-4551-bb1e-f017aff9a253")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6ff801ec-5c9e-4824-b680-fea83bc464ef")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e458ea2c-fb22-414f-a7fb-2c7dfecc3293")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnLaneSetObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.laneDep = new LaneSmDependency();
        this.laneDep.init("Lane", this, metamodel.getMClass(BpmnLane.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.laneDep);

        this.processDep = new ProcessSmDependency();
        this.processDep.init("Process", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, 1 );
        registerDependency(this.processDep);

        this.parentLaneDep = new ParentLaneSmDependency();
        this.parentLaneDep.init("ParentLane", this, metamodel.getMClass(BpmnLane.MQNAME), 0, 1 );
        registerDependency(this.parentLaneDep);

        this.subProcessDep = new SubProcessSmDependency();
        this.subProcessDep.init("SubProcess", this, metamodel.getMClass(BpmnSubProcess.MQNAME), 0, 1 );
        registerDependency(this.subProcessDep);

    }

    @objid ("7ff96972-0235-47b8-bffd-a5a890c589fb")
    public SmDependency getLaneDep() {
        if (this.laneDep == null) {
        	this.laneDep = this.getDependencyDef("Lane");
        }
        return this.laneDep;
    }

    @objid ("73dfe43e-fd2d-4780-8627-4d7d60ddc293")
    public SmDependency getProcessDep() {
        if (this.processDep == null) {
        	this.processDep = this.getDependencyDef("Process");
        }
        return this.processDep;
    }

    @objid ("3fd7c909-0770-4409-87f1-02e116f8ca62")
    public SmDependency getParentLaneDep() {
        if (this.parentLaneDep == null) {
        	this.parentLaneDep = this.getDependencyDef("ParentLane");
        }
        return this.parentLaneDep;
    }

    @objid ("b932133b-ba7e-4e87-9b67-8c2ff48e2fc9")
    public SmDependency getSubProcessDep() {
        if (this.subProcessDep == null) {
        	this.subProcessDep = this.getDependencyDef("SubProcess");
        }
        return this.subProcessDep;
    }

    @objid ("ebd59f07-a1aa-4901-80bc-271cfc95a012")
    private static class BpmnLaneSetObjectFactory implements ISmObjectFactory {
        @objid ("a0e2bbe7-b5de-44da-a970-b6331db773e2")
        private BpmnLaneSetSmClass smClass;

        @objid ("283542fb-4ef9-4dde-a919-5634a6614408")
        public BpmnLaneSetObjectFactory(BpmnLaneSetSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a9691665-4c57-4023-9453-f7cf7f4a775f")
        @Override
        public ISmObjectData createData() {
            return new BpmnLaneSetData(this.smClass);
        }

        @objid ("c59fb197-58b4-4d75-9fb7-785d3ffeebbe")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnLaneSetImpl();
        }

    }

    @objid ("3638b885-f77c-414d-b8d8-d114ef53ac15")
    public static class LaneSmDependency extends SmMultipleDependency {
        @objid ("e8df34ce-7143-4b73-98bf-89f40cea5795")
        private SmDependency symetricDep;

        @objid ("23cf96cc-8ad6-4bae-9045-ff01ef0b6c96")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnLaneSetData)data).mLane != null)? ((BpmnLaneSetData)data).mLane:SmMultipleDependency.EMPTY;
        }

        @objid ("422ff0ba-58f3-464e-a2e1-1291bc8da669")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnLaneSetData) data).mLane = values;

        }

        @objid ("81bf2f12-e0f8-43e8-af56-201ec56c953e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSmClass)this.getTarget()).getLaneSetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1a185663-686d-41ee-bdae-c49e8cad3dc9")
    public static class ProcessSmDependency extends SmSingleDependency {
        @objid ("db99b804-b45b-4f05-8d06-1b3c3269d5bb")
        private SmDependency symetricDep;

        @objid ("2f867141-c97c-4e31-ac26-6404b7523625")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLaneSetData) data).mProcess;
        }

        @objid ("5a7c7da7-ff08-4368-a893-9b8f1588b50c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLaneSetData) data).mProcess = value;
        }

        @objid ("06882e5d-cf27-4995-92fa-f32d097e3a41")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getLaneSetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("33acc953-cd9e-435d-8c29-5ece2ff5acd4")
    public static class ParentLaneSmDependency extends SmSingleDependency {
        @objid ("528ea8b6-5cd2-43ab-8532-ec610c5b3262")
        private SmDependency symetricDep;

        @objid ("fe42f387-b5f3-4e65-bd97-3d1d809b4d8c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLaneSetData) data).mParentLane;
        }

        @objid ("90b5f6be-5f0a-4ec1-b578-0aabf89366c6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLaneSetData) data).mParentLane = value;
        }

        @objid ("8ead421a-5176-4439-8c52-51f943fc4b34")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSmClass)this.getTarget()).getChildLaneSetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("cc41134f-5015-4fa6-aafd-66699b6648e8")
    public static class SubProcessSmDependency extends SmSingleDependency {
        @objid ("e0e98304-4790-4a9f-9efc-23a9f996df6a")
        private SmDependency symetricDep;

        @objid ("3f94bd21-003c-411b-ac1a-72713fd2de76")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLaneSetData) data).mSubProcess;
        }

        @objid ("421bc760-09d6-4459-8f59-ef3cbf31a4b4")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLaneSetData) data).mSubProcess = value;
        }

        @objid ("460dcce4-caa7-4b82-a48f-d46ab04279da")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSubProcessSmClass)this.getTarget()).getLaneSetDep();
            }
            return this.symetricDep;

        }

    }

}
