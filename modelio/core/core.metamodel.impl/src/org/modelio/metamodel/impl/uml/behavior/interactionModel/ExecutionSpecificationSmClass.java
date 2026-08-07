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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionOccurenceSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
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

@objid ("c7dca441-9d72-4635-ad32-c686fc16d434")
public class ExecutionSpecificationSmClass extends InteractionFragmentSmClass {
    @objid ("a76307d0-25ad-41e2-b92c-c0650422144e")
    private SmDependency finishDep;

    @objid ("5126fbd5-ed78-464f-aa95-b6c15e9642d5")
    private SmDependency startDep;

    @objid ("128ae09f-d2f2-4d1c-b32a-e92ce428c5cf")
    public ExecutionSpecificationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("51b0d09a-2192-463a-a777-9041660861fb")
    @Override
    public String getName() {
        return "ExecutionSpecification";

    }

    @objid ("b03cf5de-27bd-4e0d-8c37-4c75f9082fb0")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f9ec40b9-08d8-49f7-b758-a29f6f692c8b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExecutionSpecification.class;

    }

    @objid ("165ce575-0017-49e9-abce-25913e9141ad")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("90a3b685-1e25-481d-a541-b47f36b19f8b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e1951676-33cb-4ec6-bb0a-53f1e24be3ac")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InteractionFragment.MQNAME);
        this.registerFactory(new ExecutionSpecificationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.finishDep = new FinishSmDependency();
        this.finishDep.init("Finish", this, metamodel.getMClass(ExecutionOccurenceSpecification.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.finishDep);

        this.startDep = new StartSmDependency();
        this.startDep.init("Start", this, metamodel.getMClass(ExecutionOccurenceSpecification.MQNAME), 1, 1 );
        registerDependency(this.startDep);

    }

    @objid ("3ccc3359-b201-4fd3-8ace-3974cff36d27")
    public SmDependency getFinishDep() {
        if (this.finishDep == null) {
        	this.finishDep = this.getDependencyDef("Finish");
        }
        return this.finishDep;
    }

    @objid ("59c68028-d40d-42c9-a566-9e698f1172c3")
    public SmDependency getStartDep() {
        if (this.startDep == null) {
        	this.startDep = this.getDependencyDef("Start");
        }
        return this.startDep;
    }

    @objid ("0bef207a-3a94-4188-9f6a-4e2f02022edc")
    private static class ExecutionSpecificationObjectFactory implements ISmObjectFactory {
        @objid ("3a2360ce-9865-4ed4-a6c6-609ff60d3436")
        private ExecutionSpecificationSmClass smClass;

        @objid ("13387c2a-dc53-4b1b-9bcc-9c4a5a1b9b1e")
        public ExecutionSpecificationObjectFactory(ExecutionSpecificationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("20e74506-40f7-44cb-9205-cdb92cb6dda6")
        @Override
        public ISmObjectData createData() {
            return new ExecutionSpecificationData(this.smClass);
        }

        @objid ("46038104-b10a-4208-b8ee-b8442c284317")
        @Override
        public SmObjectImpl createImpl() {
            return new ExecutionSpecificationImpl();
        }

    }

    @objid ("b04a97f6-056e-4d0a-914c-c0e067947fb4")
    public static class FinishSmDependency extends SmSingleDependency {
        @objid ("32f67f2b-fa5b-433d-a22f-b0956d8ee793")
        private SmDependency symetricDep;

        @objid ("3fd495f7-844b-45f8-a896-cf4efbd7bc9d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExecutionSpecificationData) data).mFinish;
        }

        @objid ("9185592f-b8ba-43aa-aee2-fce5efc939db")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExecutionSpecificationData) data).mFinish = value;
        }

        @objid ("e437d39b-4f71-4c7a-a2ca-6499971dd0cc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExecutionOccurenceSpecificationSmClass)this.getTarget()).getFinishedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("819a5304-77f4-4377-abab-a132aacc1b34")
    public static class StartSmDependency extends SmSingleDependency {
        @objid ("b2e03a5b-0b06-40d3-9662-7e7671ecc8ae")
        private SmDependency symetricDep;

        @objid ("c86492a8-a958-493f-9f76-39ae6ff8034c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExecutionSpecificationData) data).mStart;
        }

        @objid ("fbdde4b4-2d1e-4d7d-9b48-f02d05ba75dc")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExecutionSpecificationData) data).mStart = value;
        }

        @objid ("c35b654b-b31a-4caa-919e-e216dc38ebfe")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExecutionOccurenceSpecificationSmClass)this.getTarget()).getStartedDep();
            }
            return this.symetricDep;

        }

    }

}
