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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.OutputPin;
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
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

@objid ("afb90f81-def5-4f04-bd0f-5ff0db63e929")
public class OutputPinSmClass extends PinSmClass {
    @objid ("a61c22ac-0367-4ad8-8549-028f6e531d7c")
    private SmDependency outputingDep;

    @objid ("f96d51e2-86cb-4f96-9797-7e4786c7dc67")
    public OutputPinSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a4cc0d3f-2ab9-4757-91ba-2f52a288ebdc")
    @Override
    public String getName() {
        return "OutputPin";

    }

    @objid ("bcec0764-8196-4dd6-b2fd-5c849eafd9f5")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("bf255ebc-be42-42ee-8862-410be9daec3a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return OutputPin.class;

    }

    @objid ("7ad04d38-838b-4f49-bfae-6d26b8fcd038")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e0bcd560-d412-4379-865e-693e24b5d49e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6614ea67-09ea-4fe9-b724-81292c2b77ee")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Pin.MQNAME);
        this.registerFactory(new OutputPinObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.outputingDep = new OutputingSmDependency();
        this.outputingDep.init("Outputing", this, metamodel.getMClass(ActivityAction.MQNAME), 0, 1 );
        registerDependency(this.outputingDep);

    }

    @objid ("bf6049b3-fcbb-4295-9c4a-2ded6f551441")
    public SmDependency getOutputingDep() {
        if (this.outputingDep == null) {
        	this.outputingDep = this.getDependencyDef("Outputing");
        }
        return this.outputingDep;
    }

    @objid ("d8975d2f-24ec-473f-b9a4-d4964e0bba79")
    private static class OutputPinObjectFactory implements ISmObjectFactory {
        @objid ("4ee22bfd-db2a-4b92-a13a-10c4bbd47476")
        private OutputPinSmClass smClass;

        @objid ("c03344fb-68a4-40c1-abae-c2ae92e9fb53")
        public OutputPinObjectFactory(OutputPinSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e99186cb-53c6-48d9-bf42-38e68460c8ef")
        @Override
        public ISmObjectData createData() {
            return new OutputPinData(this.smClass);
        }

        @objid ("bba48764-4e80-4aba-b907-f2ddaf8de40c")
        @Override
        public SmObjectImpl createImpl() {
            return new OutputPinImpl();
        }

    }

    @objid ("19d0964d-48a9-4afa-a867-cb29e1baf945")
    public static class OutputingSmDependency extends SmSingleDependency {
        @objid ("2451e8d3-a354-4774-9861-046d5087479c")
        private SmDependency symetricDep;

        @objid ("694ed1a6-191a-487c-9eef-303ca70756c1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((OutputPinData) data).mOutputing;
        }

        @objid ("e64b8ecb-10db-4b8d-b082-42e633a8f692")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((OutputPinData) data).mOutputing = value;
        }

        @objid ("f23d4996-6699-4a18-a923-f0cc398e50c3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityActionSmClass)this.getTarget()).getOutputDep();
            }
            return this.symetricDep;

        }

    }

}
