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
import org.modelio.metamodel.impl.uml.infrastructure.ElementSmClass;
import org.modelio.metamodel.uml.behavior.interactionModel.GeneralOrdering;
import org.modelio.metamodel.uml.behavior.interactionModel.OccurrenceSpecification;
import org.modelio.metamodel.uml.infrastructure.Element;
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

@objid ("23872769-b62e-47ff-875f-f283aa96d3a6")
public class GeneralOrderingSmClass extends ElementSmClass {
    @objid ("4e08cf6e-c280-4698-a2f1-57e9447d0af8")
    private SmDependency beforeDep;

    @objid ("bf3d8a5a-f634-405d-9823-25e571abb9f6")
    private SmDependency afterDep;

    @objid ("945c7db0-fa49-4c45-b8c5-2c2e0b0ac8d7")
    public GeneralOrderingSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("7ac79520-757f-4d4e-a01a-f2febe3c6072")
    @Override
    public String getName() {
        return "GeneralOrdering";

    }

    @objid ("d0feccae-b487-409a-8890-b67f66bbed31")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("67ba0460-12cf-4d6c-a5f5-7c26f5756141")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return GeneralOrdering.class;

    }

    @objid ("f8163bfe-0458-4818-8605-5f729868064c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("abc08a17-faae-4853-859d-a668646f7f06")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9ef94a5b-e0a1-43c3-bde1-9573acc9aa1e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Element.MQNAME);
        this.registerFactory(new GeneralOrderingObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.beforeDep = new BeforeSmDependency();
        this.beforeDep.init("Before", this, metamodel.getMClass(OccurrenceSpecification.MQNAME), 1, 1 );
        registerDependency(this.beforeDep);

        this.afterDep = new AfterSmDependency();
        this.afterDep.init("After", this, metamodel.getMClass(OccurrenceSpecification.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.afterDep);

    }

    @objid ("d75769a7-74ee-40f6-9e2c-c9014cddb8cb")
    public SmDependency getBeforeDep() {
        if (this.beforeDep == null) {
        	this.beforeDep = this.getDependencyDef("Before");
        }
        return this.beforeDep;
    }

    @objid ("7c239670-3de4-46d5-9e22-e1fafc8b40cb")
    public SmDependency getAfterDep() {
        if (this.afterDep == null) {
        	this.afterDep = this.getDependencyDef("After");
        }
        return this.afterDep;
    }

    @objid ("14dafb05-cf10-4fad-9b1e-ea6c7d3e666b")
    private static class GeneralOrderingObjectFactory implements ISmObjectFactory {
        @objid ("75cfa7f1-5865-4050-a447-bb8c9df1d18c")
        private GeneralOrderingSmClass smClass;

        @objid ("611a7986-7f81-410e-b201-a12d9b502c11")
        public GeneralOrderingObjectFactory(GeneralOrderingSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9e7f62b2-dfa3-40d8-a378-5ec65ceef292")
        @Override
        public ISmObjectData createData() {
            return new GeneralOrderingData(this.smClass);
        }

        @objid ("10d391d7-130d-4da8-8597-99b404914747")
        @Override
        public SmObjectImpl createImpl() {
            return new GeneralOrderingImpl();
        }

    }

    @objid ("825b707d-030f-4611-bb16-c6622d4a5334")
    public static class BeforeSmDependency extends SmSingleDependency {
        @objid ("35541d6a-46a5-4337-bda1-a94be3985022")
        private SmDependency symetricDep;

        @objid ("e199873a-a25a-4ccb-b4a4-14c721efe3cf")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GeneralOrderingData) data).mBefore;
        }

        @objid ("b9059ad6-0f9f-47fd-a679-e19f8dce3028")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GeneralOrderingData) data).mBefore = value;
        }

        @objid ("3f99e93e-4257-4cd1-bbfe-0776a9e37cd7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OccurrenceSpecificationSmClass)this.getTarget()).getToAfterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3f6218ef-28e8-403c-93d0-17d2063e9e4d")
    public static class AfterSmDependency extends SmSingleDependency {
        @objid ("708790f0-d1bd-4759-8767-52cc015ddcef")
        private SmDependency symetricDep;

        @objid ("dcf7c1fa-5955-4f2c-9b48-e2c04910bad4")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GeneralOrderingData) data).mAfter;
        }

        @objid ("3b6b2845-96bd-4185-940e-18cc36edf629")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GeneralOrderingData) data).mAfter = value;
        }

        @objid ("3c45a011-2834-4153-83a1-42b769e33b35")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OccurrenceSpecificationSmClass)this.getTarget()).getToBeforeDep();
            }
            return this.symetricDep;

        }

    }

}
