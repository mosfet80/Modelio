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
import org.modelio.metamodel.impl.uml.statik.OperationSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.CallAction;
import org.modelio.metamodel.uml.behavior.activityModel.CallOperationAction;
import org.modelio.metamodel.uml.statik.Operation;
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

@objid ("173bd08a-e974-4c88-8f4b-06b784f080b2")
public class CallOperationActionSmClass extends CallActionSmClass {
    @objid ("b6ba6c18-8670-4d57-960d-85926c0d3fcd")
    private SmDependency calledDep;

    @objid ("56637cbd-b956-4e49-8bf2-3ce394a9af76")
    public CallOperationActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5a112271-34a6-4558-8bac-9eb4de73319a")
    @Override
    public String getName() {
        return "CallOperationAction";

    }

    @objid ("268ee22b-46c0-4178-9a5b-c10ca750a24f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("1028e8ec-f487-4264-953b-517092541132")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CallOperationAction.class;

    }

    @objid ("23bc2f8e-d441-4e18-89b9-46821d57131b")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e05e79a8-325e-4719-aceb-f942e3b1d666")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ac3511b2-aa6b-4091-9669-b82cd0edf8cf")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(CallAction.MQNAME);
        this.registerFactory(new CallOperationActionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.calledDep = new CalledSmDependency();
        this.calledDep.init("Called", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.calledDep);

    }

    @objid ("578069d9-6a5a-478d-9d00-fd95b40d5258")
    public SmDependency getCalledDep() {
        if (this.calledDep == null) {
        	this.calledDep = this.getDependencyDef("Called");
        }
        return this.calledDep;
    }

    @objid ("eb16de6c-34a6-493f-b939-aaafef78e9f8")
    private static class CallOperationActionObjectFactory implements ISmObjectFactory {
        @objid ("c9241cda-96df-416d-90f3-5515ba10039d")
        private CallOperationActionSmClass smClass;

        @objid ("0bc0d61e-d89a-4077-8d43-927d9d717f3a")
        public CallOperationActionObjectFactory(CallOperationActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("380b733c-2e4c-41e1-a269-87fb1a2d34fa")
        @Override
        public ISmObjectData createData() {
            return new CallOperationActionData(this.smClass);
        }

        @objid ("deafb384-a459-4b4e-87a6-28eb5a5bb836")
        @Override
        public SmObjectImpl createImpl() {
            return new CallOperationActionImpl();
        }

    }

    @objid ("058f71fd-ad1c-412e-ad7f-cc1438245f20")
    public static class CalledSmDependency extends SmSingleDependency {
        @objid ("adb23d5c-c8f6-498e-b6d2-dfe41dcdb14d")
        private SmDependency symetricDep;

        @objid ("f4d1dad7-fc2d-456d-a10c-34843deaf93d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CallOperationActionData) data).mCalled;
        }

        @objid ("49b286f3-ef7b-4ff4-bc0c-282802605d3a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CallOperationActionData) data).mCalled = value;
        }

        @objid ("42c75f66-0815-43e1-9b50-576107a4d91e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getCallingActionDep();
            }
            return this.symetricDep;

        }

    }

}
