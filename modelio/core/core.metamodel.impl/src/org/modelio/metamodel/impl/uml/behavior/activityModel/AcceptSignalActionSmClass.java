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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptSignalAction;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
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

@objid ("bc768fdd-89d5-45c3-badd-085d29c274f9")
public class AcceptSignalActionSmClass extends ActivityActionSmClass {
    @objid ("02992333-49d6-464e-bbb1-c3d17514de7e")
    private SmDependency acceptedDep;

    @objid ("f53c123e-76d6-4aac-b015-3ecef88b4717")
    public AcceptSignalActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d60e5abc-4d2f-48c0-8e50-fad58a25132c")
    @Override
    public String getName() {
        return "AcceptSignalAction";

    }

    @objid ("fde74b3f-6542-4129-b24d-88acf27050c0")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("60edcc97-5bb0-43c3-b117-3d3c4b62bfe9")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AcceptSignalAction.class;

    }

    @objid ("12aa89c0-edd1-43c7-b0ce-1faeb1d64d17")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("d4ed028c-01dc-4578-aad7-4da61e2af46b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7c807f9a-2596-4dff-bf58-4365b4425ca0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new AcceptSignalActionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.acceptedDep = new AcceptedSmDependency();
        this.acceptedDep.init("Accepted", this, metamodel.getMClass(Signal.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.acceptedDep);

    }

    @objid ("b2acc30b-ee86-46c4-b1ba-c63272a0fbc7")
    public SmDependency getAcceptedDep() {
        if (this.acceptedDep == null) {
        	this.acceptedDep = this.getDependencyDef("Accepted");
        }
        return this.acceptedDep;
    }

    @objid ("2b013664-ec04-4712-9064-0075d0bcab51")
    private static class AcceptSignalActionObjectFactory implements ISmObjectFactory {
        @objid ("1505f5bf-565a-4509-a94a-933669f8138b")
        private AcceptSignalActionSmClass smClass;

        @objid ("58e58a01-47db-4180-823b-cc0e5095fe3f")
        public AcceptSignalActionObjectFactory(AcceptSignalActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("43844ff9-b9d0-4a84-8c88-85a06718af38")
        @Override
        public ISmObjectData createData() {
            return new AcceptSignalActionData(this.smClass);
        }

        @objid ("94756565-8cb1-4a7b-86f4-ee3d61774b7c")
        @Override
        public SmObjectImpl createImpl() {
            return new AcceptSignalActionImpl();
        }

    }

    @objid ("13f32ee6-91d4-4ff1-8b40-72f43d424349")
    public static class AcceptedSmDependency extends SmMultipleDependency {
        @objid ("915d2bdc-b20c-4c61-9ce8-74e32fe50707")
        private SmDependency symetricDep;

        @objid ("e2d2fc67-0338-4c0d-8024-4b0318e88398")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AcceptSignalActionData)data).mAccepted != null)? ((AcceptSignalActionData)data).mAccepted:SmMultipleDependency.EMPTY;
        }

        @objid ("581c5948-b0f4-4b15-8da2-81a96f63ebb2")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AcceptSignalActionData) data).mAccepted = values;

        }

        @objid ("bd61088f-440f-424e-b319-fac0ee05229d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getReceiverDep();
            }
            return this.symetricDep;

        }

    }

}
