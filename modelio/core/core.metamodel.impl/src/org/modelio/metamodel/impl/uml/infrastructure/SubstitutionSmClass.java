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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.ClassifierSmClass;
import org.modelio.metamodel.uml.infrastructure.Substitution;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Classifier;
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

@objid ("2023cbd9-0f99-421d-982c-f6ccede2a596")
public class SubstitutionSmClass extends UmlModelElementSmClass {
    @objid ("f462f9b4-e974-499f-ad4b-cbcfd9737c10")
    private SmDependency contractDep;

    @objid ("9712b045-aaf2-4f37-8ab1-ae6e74b66dbc")
    private SmDependency substitutingClassifierDep;

    @objid ("0cfec534-e17b-4a20-9a63-15738b3b456e")
    public SubstitutionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("befb884d-7ca3-4bf4-8766-295029847263")
    @Override
    public String getName() {
        return "Substitution";

    }

    @objid ("04cfa695-3b6d-46a9-93fc-344f50c19d8e")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("68f4f046-64da-43be-94ab-a9293da1d085")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Substitution.class;

    }

    @objid ("fd3cf556-55b2-4095-8b56-bd0941242fbc")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e78cb5be-3dc2-4a2e-bacc-22e003cb7178")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7d315a75-f4f0-4c80-accb-0041924d45bd")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new SubstitutionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.contractDep = new ContractSmDependency();
        this.contractDep.init("Contract", this, metamodel.getMClass(Classifier.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.contractDep);

        this.substitutingClassifierDep = new SubstitutingClassifierSmDependency();
        this.substitutingClassifierDep.init("SubstitutingClassifier", this, metamodel.getMClass(Classifier.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.substitutingClassifierDep);

    }

    @objid ("6b8a88b1-bb21-4808-a21a-53c695aff3d6")
    public SmDependency getContractDep() {
        if (this.contractDep == null) {
        	this.contractDep = this.getDependencyDef("Contract");
        }
        return this.contractDep;
    }

    @objid ("89404261-ee77-4579-b9f8-40dbcaab162a")
    public SmDependency getSubstitutingClassifierDep() {
        if (this.substitutingClassifierDep == null) {
        	this.substitutingClassifierDep = this.getDependencyDef("SubstitutingClassifier");
        }
        return this.substitutingClassifierDep;
    }

    @objid ("1f60bfe6-ce43-4c2d-b22f-cfa991fccb6f")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("936be856-0eee-482c-bf5f-0fd72c031c62")
    private static class SubstitutionObjectFactory implements ISmObjectFactory {
        @objid ("0ab68e30-b8e2-4350-bd0a-61e0087d9d94")
        private SubstitutionSmClass smClass;

        @objid ("e001bf06-816d-46e6-a7c5-0267f2415c0d")
        public SubstitutionObjectFactory(SubstitutionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b3ed03bb-f48c-49e3-8633-1051927c3723")
        @Override
        public ISmObjectData createData() {
            return new SubstitutionData(this.smClass);
        }

        @objid ("cc77e455-410a-4369-8a4d-07776ccacb3d")
        @Override
        public SmObjectImpl createImpl() {
            return new SubstitutionImpl();
        }

    }

    @objid ("8cad2aa0-2fce-4fb2-812f-28aa246331d3")
    public static class ContractSmDependency extends SmSingleDependency {
        @objid ("31077fc1-19e5-4c6a-a93e-7ea9ce7f9789")
        private SmDependency symetricDep;

        @objid ("7df39139-81b3-4732-8972-059000e3076d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((SubstitutionData) data).mContract;
        }

        @objid ("b7272e4c-d9a7-44e4-84be-b6a41b9226a1")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((SubstitutionData) data).mContract = value;
        }

        @objid ("7170c977-548f-4a4b-8d93-861d1e7539e6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getSubstitutingSubstitutionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("82d164de-0ed8-4c9c-9690-141bc7e27655")
    public static class SubstitutingClassifierSmDependency extends SmSingleDependency {
        @objid ("9d186a32-66be-4a97-8ef3-5a9eb3ea4980")
        private SmDependency symetricDep;

        @objid ("a43377bd-f56a-4654-b0ec-fae76da62951")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((SubstitutionData) data).mSubstitutingClassifier;
        }

        @objid ("6c028d28-30e8-4ed6-aab4-ea82172ff58a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((SubstitutionData) data).mSubstitutingClassifier = value;
        }

        @objid ("42ca2d03-256f-41fe-acfc-af33017695ae")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getSubstituedDep();
            }
            return this.symetricDep;

        }

    }

}
