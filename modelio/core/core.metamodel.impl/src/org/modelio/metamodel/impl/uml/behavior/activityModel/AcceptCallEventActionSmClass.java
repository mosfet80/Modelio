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
import org.modelio.metamodel.uml.behavior.activityModel.AcceptCallEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
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

@objid ("d745d283-1cfe-4a72-b6e7-c1e455ade573")
public class AcceptCallEventActionSmClass extends ActivityActionSmClass {
    @objid ("d064b8f9-9410-4e3b-be7d-cc69d35600a1")
    private SmDependency calledDep;

    @objid ("f933493f-151e-4214-96e9-f62a38aa5948")
    public AcceptCallEventActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("35f6f5b0-f129-47be-afd3-86928b6632b8")
    @Override
    public String getName() {
        return "AcceptCallEventAction";

    }

    @objid ("751351de-e216-488f-a7a7-34a413172f50")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c6b3d3e6-a708-495a-92c9-beb93efd3e5b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AcceptCallEventAction.class;

    }

    @objid ("8bc0a8df-f8cf-4b7f-8777-26a6c6e376a8")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1130fd68-241e-4086-9134-60ea15d6e05b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("aafb60c7-470b-4c82-aec4-04910f97c0ee")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new AcceptCallEventActionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.calledDep = new CalledSmDependency();
        this.calledDep.init("Called", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.calledDep);

    }

    @objid ("cbe74abf-10af-4972-9f84-f6eb08fac06c")
    public SmDependency getCalledDep() {
        if (this.calledDep == null) {
        	this.calledDep = this.getDependencyDef("Called");
        }
        return this.calledDep;
    }

    @objid ("2b607cea-df9d-43c5-b676-905053bd3f83")
    private static class AcceptCallEventActionObjectFactory implements ISmObjectFactory {
        @objid ("4ec57d5b-278f-4a8e-a319-80219a058e86")
        private AcceptCallEventActionSmClass smClass;

        @objid ("2882b549-63e2-416e-940e-c9103c08c33e")
        public AcceptCallEventActionObjectFactory(AcceptCallEventActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("746ad16b-ccee-4f34-96df-2da51d8080a7")
        @Override
        public ISmObjectData createData() {
            return new AcceptCallEventActionData(this.smClass);
        }

        @objid ("2c59c9f9-e054-4859-84fc-6119173be761")
        @Override
        public SmObjectImpl createImpl() {
            return new AcceptCallEventActionImpl();
        }

    }

    @objid ("404455ae-67dc-46e8-a845-e84a92f99d64")
    public static class CalledSmDependency extends SmSingleDependency {
        @objid ("ab35c4c7-d612-4fbd-bfc0-27d6a62c6191")
        private SmDependency symetricDep;

        @objid ("9de7753d-c832-4c18-be52-9642178c48c4")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AcceptCallEventActionData) data).mCalled;
        }

        @objid ("059ad64c-66a3-4c2f-b54a-c25ba74f8f2d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AcceptCallEventActionData) data).mCalled = value;
        }

        @objid ("864f6940-6209-4f2e-aa0b-ad23c0a89aa4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getEntryPointActionDep();
            }
            return this.symetricDep;

        }

    }

}
