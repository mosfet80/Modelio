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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Component;
import org.modelio.metamodel.uml.statik.ComponentRealization;
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

@objid ("e45e84a7-0dba-4cfb-b997-5a197cb308e9")
public class ComponentRealizationSmClass extends UmlModelElementSmClass {
    @objid ("2e8b6e6b-3a4c-43eb-a119-48812dba9b37")
    private SmDependency realizingClassifierDep;

    @objid ("93a775d8-2b9a-49c6-8426-a95c88ba07ba")
    private SmDependency abstractionDep;

    @objid ("8832b42e-84e5-4f21-91d7-a253586fa37d")
    public ComponentRealizationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c68a2cbb-98ce-47e2-8f3e-3b2428c927f5")
    @Override
    public String getName() {
        return "ComponentRealization";

    }

    @objid ("7bfc8274-b9fa-4aa6-a8c2-ae8901e57808")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("015dcfa0-752d-4b9a-8b15-75415a544ff1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ComponentRealization.class;

    }

    @objid ("4e7aced3-61a1-4292-a9e5-32ac6adf3098")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("65249862-cd69-4543-bb72-e5ff956707bd")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9d41bb4d-9630-4ca5-831c-6ffc5d6c0f41")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ComponentRealizationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.realizingClassifierDep = new RealizingClassifierSmDependency();
        this.realizingClassifierDep.init("RealizingClassifier", this, metamodel.getMClass(Classifier.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.realizingClassifierDep);

        this.abstractionDep = new AbstractionSmDependency();
        this.abstractionDep.init("Abstraction", this, metamodel.getMClass(Component.MQNAME), 1, 1 );
        registerDependency(this.abstractionDep);

    }

    @objid ("160651b7-9562-4ac6-a6ae-f0d5f1f61b79")
    public SmDependency getRealizingClassifierDep() {
        if (this.realizingClassifierDep == null) {
        	this.realizingClassifierDep = this.getDependencyDef("RealizingClassifier");
        }
        return this.realizingClassifierDep;
    }

    @objid ("9df01535-3767-4646-83a9-14ce00e8c840")
    public SmDependency getAbstractionDep() {
        if (this.abstractionDep == null) {
        	this.abstractionDep = this.getDependencyDef("Abstraction");
        }
        return this.abstractionDep;
    }

    @objid ("d9e6efc9-9b51-4ffc-9322-827ff520bcc0")
    private static class ComponentRealizationObjectFactory implements ISmObjectFactory {
        @objid ("488dd1e0-0bfd-40fe-93d7-fcd63f03f6be")
        private ComponentRealizationSmClass smClass;

        @objid ("67ef4b23-5725-4e6b-bef4-23a36524eec8")
        public ComponentRealizationObjectFactory(ComponentRealizationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6af8d8bf-e52e-47f5-bcaf-93beb62f2b8a")
        @Override
        public ISmObjectData createData() {
            return new ComponentRealizationData(this.smClass);
        }

        @objid ("ad616576-4a73-4ff0-b3a4-7916b54db520")
        @Override
        public SmObjectImpl createImpl() {
            return new ComponentRealizationImpl();
        }

    }

    @objid ("b45da4d2-7aa5-49ef-a3c9-249dc0474f2f")
    public static class RealizingClassifierSmDependency extends SmSingleDependency {
        @objid ("0f40a635-4d06-4ea9-9f8d-b581879dbfa0")
        private SmDependency symetricDep;

        @objid ("3a32e150-f3f9-4e25-846e-a3002b4ed793")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ComponentRealizationData) data).mRealizingClassifier;
        }

        @objid ("7bc8cad8-76ac-421b-9491-5adbd4c53b14")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ComponentRealizationData) data).mRealizingClassifier = value;
        }

        @objid ("80d21f3b-19d9-4424-9a96-20327843a582")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getRealizedComponentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9e6156fb-025e-4cb1-85b2-8b04c8ac8c60")
    public static class AbstractionSmDependency extends SmSingleDependency {
        @objid ("5f9db816-e431-4337-8aaf-dcd61f983c78")
        private SmDependency symetricDep;

        @objid ("767f90de-728d-4f6b-a9ea-edc8cc2dc96a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ComponentRealizationData) data).mAbstraction;
        }

        @objid ("60915850-cefd-4688-9d44-e039b6c60979")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ComponentRealizationData) data).mAbstraction = value;
        }

        @objid ("e36278d2-a403-4a1c-907f-eb6e82033352")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ComponentSmClass)this.getTarget()).getRealizationDep();
            }
            return this.symetricDep;

        }

    }

}
