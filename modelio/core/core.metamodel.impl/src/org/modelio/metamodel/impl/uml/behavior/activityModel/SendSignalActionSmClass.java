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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.SendSignalAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
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

@objid ("a68b21b3-a195-4b30-a47c-2032fc3d33f5")
public class SendSignalActionSmClass extends ActivityActionSmClass {
    @objid ("3436b89b-653f-4343-98a5-82aa3d810746")
    private SmDependency sentDep;

    @objid ("9b73714e-d572-4d53-a31f-d5f9ac16bfd2")
    public SendSignalActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("2b32b807-320d-4183-b53e-dcc71c581e84")
    @Override
    public String getName() {
        return "SendSignalAction";

    }

    @objid ("4070b1d2-1de6-47d5-80ae-dc24ba2dc514")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("922b0743-05ec-4fe4-980f-8399a3c3abcb")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return SendSignalAction.class;

    }

    @objid ("53259942-cb52-4a89-9580-be40efcad8b7")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f92e4d6b-2fa0-49e9-9d43-f7a8f399efbb")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d9f3ab5b-5757-435b-a14b-3101d657fa1d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new SendSignalActionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.sentDep = new SentSmDependency();
        this.sentDep.init("Sent", this, metamodel.getMClass(Signal.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.sentDep);

    }

    @objid ("2dc74812-a2bf-478b-b843-8b2c368a37d8")
    public SmDependency getSentDep() {
        if (this.sentDep == null) {
        	this.sentDep = this.getDependencyDef("Sent");
        }
        return this.sentDep;
    }

    @objid ("11a986af-450f-42bc-8607-d14629549aa0")
    private static class SendSignalActionObjectFactory implements ISmObjectFactory {
        @objid ("54ee1fe2-e72d-453e-80e7-2fb2c5104021")
        private SendSignalActionSmClass smClass;

        @objid ("71d0b247-6f9c-4f01-afd7-35e4f950710e")
        public SendSignalActionObjectFactory(SendSignalActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("8caf2342-254f-4f58-a03e-306bad5f8b52")
        @Override
        public ISmObjectData createData() {
            return new SendSignalActionData(this.smClass);
        }

        @objid ("e6e01586-51e0-4e3c-8f2a-dd0c844d4cd2")
        @Override
        public SmObjectImpl createImpl() {
            return new SendSignalActionImpl();
        }

    }

    @objid ("7131c85b-74ba-4f05-b9ff-6f4d27a7461a")
    public static class SentSmDependency extends SmSingleDependency {
        @objid ("2baa1f17-22da-4be6-b4e2-a1e4a8c5ae5a")
        private SmDependency symetricDep;

        @objid ("4b088f35-0f3f-4725-919f-48c442411847")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((SendSignalActionData) data).mSent;
        }

        @objid ("f1e8f3ef-2cc2-4b92-b4be-fcf636f46956")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((SendSignalActionData) data).mSent = value;
        }

        @objid ("29d17f39-ed9c-489c-a49b-3f57fddfcda9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getSenderDep();
            }
            return this.symetricDep;

        }

    }

}
