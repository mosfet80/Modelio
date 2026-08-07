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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.CallAction;
import org.modelio.metamodel.uml.behavior.activityModel.CallBehaviorAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
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

@objid ("352b8b30-069d-4357-94ed-0f8b4e7fd2a7")
public class CallBehaviorActionSmClass extends CallActionSmClass {
    @objid ("20c3b41a-bc5a-4db5-a916-237e9d703998")
    private SmDependency calledDep;

    @objid ("1e4c4ba4-acce-4928-9240-75ccff9fdf5c")
    public CallBehaviorActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8ab5e1f1-dec2-4b17-bd28-834b10844405")
    @Override
    public String getName() {
        return "CallBehaviorAction";

    }

    @objid ("2f42ae79-f5fb-48f9-89e1-8efd53f0bb68")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f0f6b636-ab89-4b19-b25e-c828475f9df1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CallBehaviorAction.class;

    }

    @objid ("5c53424c-9e81-484d-973b-910d927f342f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0631eede-697f-4947-ac64-e580d2d81b50")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1ec985e1-527b-4ae9-ad12-ef6b42d152df")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(CallAction.MQNAME);
        this.registerFactory(new CallBehaviorActionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.calledDep = new CalledSmDependency();
        this.calledDep.init("Called", this, metamodel.getMClass(Behavior.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.calledDep);

    }

    @objid ("751107b0-5cdf-4d59-bbc8-a34237b69b45")
    public SmDependency getCalledDep() {
        if (this.calledDep == null) {
        	this.calledDep = this.getDependencyDef("Called");
        }
        return this.calledDep;
    }

    @objid ("dc60546a-9c1c-43c7-9b3e-e61f528cb641")
    private static class CallBehaviorActionObjectFactory implements ISmObjectFactory {
        @objid ("0190403e-8876-474b-ba67-8fa61f8628ae")
        private CallBehaviorActionSmClass smClass;

        @objid ("e58425f7-fb26-4881-90f9-0078a1f2b2d8")
        public CallBehaviorActionObjectFactory(CallBehaviorActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e0f28558-4995-4a96-8e2f-55ec7b14022c")
        @Override
        public ISmObjectData createData() {
            return new CallBehaviorActionData(this.smClass);
        }

        @objid ("20427e33-9dcb-4ae5-8183-678cdfc8bc27")
        @Override
        public SmObjectImpl createImpl() {
            return new CallBehaviorActionImpl();
        }

    }

    @objid ("c9960fbb-9345-47ab-bfbe-1fd8e4272486")
    public static class CalledSmDependency extends SmSingleDependency {
        @objid ("35acb075-8fa7-44d6-8e30-9a9818ffb457")
        private SmDependency symetricDep;

        @objid ("87a42402-4b98-466b-ae63-64a22cbb5ba7")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CallBehaviorActionData) data).mCalled;
        }

        @objid ("a8394808-6048-4b3d-a49a-5f1eaa7ca361")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CallBehaviorActionData) data).mCalled = value;
        }

        @objid ("f5c1b69d-877a-4ccc-8c15-d6dfeaa7d6d5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorSmClass)this.getTarget()).getCallerDep();
            }
            return this.symetricDep;

        }

    }

}
