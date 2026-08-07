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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.GeneralOrdering;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.OccurrenceSpecification;
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

@objid ("aef59fb3-f2e2-4e01-85ed-20b1b90fb246")
public class OccurrenceSpecificationSmClass extends InteractionFragmentSmClass {
    @objid ("61afbb14-da06-4ab4-a461-ddcc87c4a452")
    private SmDependency toAfterDep;

    @objid ("1958c288-b910-4025-b54c-8c95485d4572")
    private SmDependency toBeforeDep;

    @objid ("a8aac2e5-f956-4192-abc5-a578036b53c3")
    public OccurrenceSpecificationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("2591ca10-0f94-43fd-b8f7-e77952587750")
    @Override
    public String getName() {
        return "OccurrenceSpecification";

    }

    @objid ("9ee09467-52c6-4006-8885-a1dfcd6ef152")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("501d4699-378f-46c6-b8e2-f642049ff499")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return OccurrenceSpecification.class;

    }

    @objid ("66c0389f-5f91-4e95-9dff-45c61a0687fb")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e35acb7e-d8aa-49ab-a625-75b088d2f59e")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("dfd0b102-760b-4257-91c8-a516fa3c5589")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InteractionFragment.MQNAME);
        this.registerFactory(new OccurrenceSpecificationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.toAfterDep = new ToAfterSmDependency();
        this.toAfterDep.init("ToAfter", this, metamodel.getMClass(GeneralOrdering.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.toAfterDep);

        this.toBeforeDep = new ToBeforeSmDependency();
        this.toBeforeDep.init("ToBefore", this, metamodel.getMClass(GeneralOrdering.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.toBeforeDep);

    }

    @objid ("ef694d51-c344-4dc4-b80a-5b20dd93d06d")
    public SmDependency getToAfterDep() {
        if (this.toAfterDep == null) {
        	this.toAfterDep = this.getDependencyDef("ToAfter");
        }
        return this.toAfterDep;
    }

    @objid ("d5d84443-7475-428e-9931-d1cc6c99a2f2")
    public SmDependency getToBeforeDep() {
        if (this.toBeforeDep == null) {
        	this.toBeforeDep = this.getDependencyDef("ToBefore");
        }
        return this.toBeforeDep;
    }

    @objid ("cac35ac1-7543-49f6-8a9e-c0f72869ad23")
    private static class OccurrenceSpecificationObjectFactory implements ISmObjectFactory {
        @objid ("265f42a1-6bb1-498a-b6f7-11287c6d48f7")
        private OccurrenceSpecificationSmClass smClass;

        @objid ("cd6e752b-8f55-4fb4-9ec3-b71f388f3adf")
        public OccurrenceSpecificationObjectFactory(OccurrenceSpecificationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("87cbff14-e7a2-42d8-a370-1f42184fbf24")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("b446ae15-1079-44d6-b50d-215b846071c9")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("4802ce7c-584b-4cf7-9c54-848745f93f81")
    public static class ToAfterSmDependency extends SmMultipleDependency {
        @objid ("78a43e80-05e0-4e6d-af13-f676e819780f")
        private SmDependency symetricDep;

        @objid ("51f0a8ff-ff90-4ff3-9698-4cb9f50b2d11")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OccurrenceSpecificationData)data).mToAfter != null)? ((OccurrenceSpecificationData)data).mToAfter:SmMultipleDependency.EMPTY;
        }

        @objid ("5dcac6a5-cdc3-4d23-bab5-2438808cc6c4")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OccurrenceSpecificationData) data).mToAfter = values;

        }

        @objid ("76c3245a-9922-42bf-9748-25e44c7afe2f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralOrderingSmClass)this.getTarget()).getBeforeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9e24ffb3-b175-4ee2-b916-0885c5633d0c")
    public static class ToBeforeSmDependency extends SmMultipleDependency {
        @objid ("fa6ec2df-4d26-423c-a52e-6dea7dfab96a")
        private SmDependency symetricDep;

        @objid ("b509eaa0-4de5-44a4-8b92-a35e21802510")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((OccurrenceSpecificationData)data).mToBefore != null)? ((OccurrenceSpecificationData)data).mToBefore:SmMultipleDependency.EMPTY;
        }

        @objid ("48412625-321f-4f14-adaa-f7d411e4ffe1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((OccurrenceSpecificationData) data).mToBefore = values;

        }

        @objid ("66b2e642-dce2-4753-8262-1e34510d190f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralOrderingSmClass)this.getTarget()).getAfterDep();
            }
            return this.symetricDep;

        }

    }

}
