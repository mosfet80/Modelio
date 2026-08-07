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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.stateMachineModel.InternalTransition;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
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

@objid ("e2239663-1b21-4104-82a3-0efc9a374bb3")
public class InternalTransitionSmClass extends TransitionSmClass {
    @objid ("e628bd22-b9ec-4071-b7be-b80123875563")
    private SmDependency sComposedDep;

    @objid ("0038370d-c8b3-43a9-abf3-686ab174ef52")
    public InternalTransitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("78178e36-65b8-4b02-98e2-98480eb00d78")
    @Override
    public String getName() {
        return "InternalTransition";

    }

    @objid ("dd5d067e-cf99-4df1-a8d4-3c602a204091")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("db8848a1-4928-43da-b9c5-6af0ed64a78f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InternalTransition.class;

    }

    @objid ("6009eea0-382c-448a-a6d6-6711d7a9f46c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("23c5829a-d521-4fa7-949a-6bd369d782ee")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("12eb2292-aabd-4c54-88d7-ce7b08510585")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Transition.MQNAME);
        this.registerFactory(new InternalTransitionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.sComposedDep = new SComposedSmDependency();
        this.sComposedDep.init("SComposed", this, metamodel.getMClass(State.MQNAME), 0, 1 );
        registerDependency(this.sComposedDep);

    }

    @objid ("208ff698-c586-4e0e-8afd-9dbf5f641e52")
    public SmDependency getSComposedDep() {
        if (this.sComposedDep == null) {
        	this.sComposedDep = this.getDependencyDef("SComposed");
        }
        return this.sComposedDep;
    }

    @objid ("46ff8e85-6472-4df9-83ad-0a8328b7ac84")
    private static class InternalTransitionObjectFactory implements ISmObjectFactory {
        @objid ("12410b6c-35ea-4cdb-baea-1ecfa518e2b5")
        private InternalTransitionSmClass smClass;

        @objid ("2042882d-df53-47d6-8b16-47574d396515")
        public InternalTransitionObjectFactory(InternalTransitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ea84ab9a-4e37-45c7-94e7-20cb73ca3efc")
        @Override
        public ISmObjectData createData() {
            return new InternalTransitionData(this.smClass);
        }

        @objid ("95920e16-4158-4d2d-8a5e-2416f17996ce")
        @Override
        public SmObjectImpl createImpl() {
            return new InternalTransitionImpl();
        }

    }

    @objid ("d1778794-d244-4c90-9346-d63caceb55a3")
    public static class SComposedSmDependency extends SmSingleDependency {
        @objid ("c7ab672c-5cef-44b8-9b9b-03f8865c946a")
        private SmDependency symetricDep;

        @objid ("58e40347-879d-4134-926f-79c1797ce661")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InternalTransitionData) data).mSComposed;
        }

        @objid ("5818ee6a-85f0-46f8-a113-45ccc59eacd9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InternalTransitionData) data).mSComposed = value;
        }

        @objid ("ffcdf6f2-5e2b-432e-98aa-94a5bf33cd0b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getInternalDep();
            }
            return this.symetricDep;

        }

    }

}
