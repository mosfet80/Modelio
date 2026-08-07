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
package org.modelio.metamodel.impl.uml.informationFlow;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.ClassifierSmClass;
import org.modelio.metamodel.uml.informationFlow.InformationItem;
import org.modelio.metamodel.uml.statik.Classifier;
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

@objid ("1314c071-1b9e-4f70-9275-ed8a40148625")
public class InformationItemSmClass extends ClassifierSmClass {
    @objid ("75645cb0-635c-47eb-a55a-66e58864b862")
    private SmDependency representedDep;

    @objid ("af0be756-2a6d-41cc-95ca-8066b4749b05")
    public InformationItemSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a238e30c-a30b-4d55-9838-b6db3d70dae8")
    @Override
    public String getName() {
        return "InformationItem";

    }

    @objid ("d3a290dc-6ed7-4cce-8fdf-311269199aab")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("666c34cf-1fa5-4e07-87d3-6243462e4817")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InformationItem.class;

    }

    @objid ("a8043417-a83e-4e58-9422-1b36b63a6175")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("74e6e1d4-d0d1-4580-9b81-a6487635c79c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("4dd01344-91c1-465d-9668-f31ba52b0e34")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Classifier.MQNAME);
        this.registerFactory(new InformationItemObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.representedDep = new RepresentedSmDependency();
        this.representedDep.init("Represented", this, metamodel.getMClass(Classifier.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedDep);

    }

    @objid ("2ec5f82b-bfd8-4017-ad82-34c401681a4d")
    public SmDependency getRepresentedDep() {
        if (this.representedDep == null) {
        	this.representedDep = this.getDependencyDef("Represented");
        }
        return this.representedDep;
    }

    @objid ("0a65d0c1-0403-4c20-9530-8b89e08ebdd4")
    private static class InformationItemObjectFactory implements ISmObjectFactory {
        @objid ("8b1e83c2-717f-4838-b78a-bb309724297d")
        private InformationItemSmClass smClass;

        @objid ("4b0939a2-b85a-4de2-814e-91b813fde5d0")
        public InformationItemObjectFactory(InformationItemSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d604722a-3a3e-4385-8706-2e2dbd44f35b")
        @Override
        public ISmObjectData createData() {
            return new InformationItemData(this.smClass);
        }

        @objid ("a7f7741f-7f0f-41d2-9b36-b2b8497f8338")
        @Override
        public SmObjectImpl createImpl() {
            return new InformationItemImpl();
        }

    }

    @objid ("f75d045a-9977-46f7-bc70-5b43d2b35976")
    public static class RepresentedSmDependency extends SmMultipleDependency {
        @objid ("bd246fac-22f4-45af-b36e-6222737e7a0b")
        private SmDependency symetricDep;

        @objid ("a2dc09b4-4a09-4c3d-a4a5-e1fb1eb48686")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationItemData)data).mRepresented != null)? ((InformationItemData)data).mRepresented:SmMultipleDependency.EMPTY;
        }

        @objid ("cb6ca6d2-a249-4a01-9f08-3c163fa51fd7")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationItemData) data).mRepresented = values;

        }

        @objid ("dfe8167f-21b0-44e8-afe8-5205e5c3f97b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getRepresentationDep();
            }
            return this.symetricDep;

        }

    }

}
