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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("8713ac34-9f32-4ab4-b3ee-79e367ec168e")
public class NaryAssociationSmClass extends UmlModelElementSmClass {
    @objid ("2e5acf40-fbc5-4e11-9abc-272069d1aa08")
    private SmDependency occurenceDep;

    @objid ("f20e7b7c-44ab-4893-8872-e578e0d88215")
    private SmDependency naryEndDep;

    @objid ("b790d1f0-dedb-4300-9784-c4151ebd06cc")
    private SmDependency linkToClassDep;

    @objid ("8725d1bb-2f95-4b8a-9317-bae3a4cb6cc4")
    public NaryAssociationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8f243aed-2bd2-4ec6-8d92-4fa5d9c4154b")
    @Override
    public String getName() {
        return "NaryAssociation";

    }

    @objid ("389270cb-111d-4f80-8e51-7b11c223273f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d37230d5-0b86-40c0-9ea8-22570b07aca1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return NaryAssociation.class;

    }

    @objid ("af81bee2-16dd-4fc6-9c09-c6870520d8ea")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3d9cc21f-a52c-4299-8ed0-92c03f13a07f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("74e5f51d-4ac6-466e-9604-c412daf5ac75")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new NaryAssociationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.occurenceDep = new OccurenceSmDependency();
        this.occurenceDep.init("Occurence", this, metamodel.getMClass(NaryLink.MQNAME), 0, -1 );
        registerDependency(this.occurenceDep);

        this.naryEndDep = new NaryEndSmDependency();
        this.naryEndDep.init("NaryEnd", this, metamodel.getMClass(NaryAssociationEnd.MQNAME), 0, -1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.naryEndDep);

        this.linkToClassDep = new LinkToClassSmDependency();
        this.linkToClassDep.init("LinkToClass", this, metamodel.getMClass(ClassAssociation.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.linkToClassDep);

    }

    @objid ("bfe9ccb5-6e40-4454-8d40-5c06074f2624")
    public SmDependency getOccurenceDep() {
        if (this.occurenceDep == null) {
        	this.occurenceDep = this.getDependencyDef("Occurence");
        }
        return this.occurenceDep;
    }

    @objid ("2f8cd92d-929f-42c8-88e3-6943de16c8c1")
    public SmDependency getNaryEndDep() {
        if (this.naryEndDep == null) {
        	this.naryEndDep = this.getDependencyDef("NaryEnd");
        }
        return this.naryEndDep;
    }

    @objid ("0c504bcc-d072-4794-b2ae-68999510aa0b")
    public SmDependency getLinkToClassDep() {
        if (this.linkToClassDep == null) {
        	this.linkToClassDep = this.getDependencyDef("LinkToClass");
        }
        return this.linkToClassDep;
    }

    @objid ("07a7ebf0-e4a2-4098-8a35-d64d29d1bef0")
    private static class NaryAssociationObjectFactory implements ISmObjectFactory {
        @objid ("074110dc-e56a-4bba-aafe-cf30d2dfb758")
        private NaryAssociationSmClass smClass;

        @objid ("df2da157-feb1-415a-ac92-8a270451df9a")
        public NaryAssociationObjectFactory(NaryAssociationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("994cbda3-8519-4ca1-bbb7-e2958faee29f")
        @Override
        public ISmObjectData createData() {
            return new NaryAssociationData(this.smClass);
        }

        @objid ("31311d74-7397-4ee2-aa34-b9b2656bb1ef")
        @Override
        public SmObjectImpl createImpl() {
            return new NaryAssociationImpl();
        }

    }

    @objid ("977c7483-29bb-4c40-acb2-131e77617136")
    public static class OccurenceSmDependency extends SmMultipleDependency {
        @objid ("ff27d9a3-2611-49ff-98b3-fce7d6247d19")
        private SmDependency symetricDep;

        @objid ("eb338646-d10f-414a-9071-16aec9b9fdc8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NaryAssociationData)data).mOccurence != null)? ((NaryAssociationData)data).mOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("88076e30-0361-4eca-96f0-772f356f7c7d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NaryAssociationData) data).mOccurence = values;

        }

        @objid ("8ff16b7f-462b-4c93-afbd-c46441eea83f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkSmClass)this.getTarget()).getModelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("68560b36-0366-4916-bcdd-ee85105f6914")
    public static class NaryEndSmDependency extends SmMultipleDependency {
        @objid ("476496c0-ca7d-48c1-842c-bbfa4e45f9e3")
        private SmDependency symetricDep;

        @objid ("5c0c2331-574f-40ef-9a50-7a9ad24a6d91")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NaryAssociationData)data).mNaryEnd != null)? ((NaryAssociationData)data).mNaryEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("49c7756d-b4b5-4e16-8d99-2c328ad5dab5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NaryAssociationData) data).mNaryEnd = values;

        }

        @objid ("b4cd1861-da77-4136-9445-b520c686ffe1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryAssociationEndSmClass)this.getTarget()).getNaryAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("670b99f0-4a6d-44bf-922f-06dab5a87012")
    public static class LinkToClassSmDependency extends SmSingleDependency {
        @objid ("9dc4153f-722f-438d-adbd-b7eed0ab3bd3")
        private SmDependency symetricDep;

        @objid ("68fe29ec-7d8f-4458-807b-214c34d83417")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryAssociationData) data).mLinkToClass;
        }

        @objid ("e4a859fc-d4f3-4146-a77f-74a195ff346b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryAssociationData) data).mLinkToClass = value;
        }

        @objid ("fdd73d41-f192-4aa8-8b1c-2dc2375ed123")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassAssociationSmClass)this.getTarget()).getNaryAssociationPartDep();
            }
            return this.symetricDep;

        }

    }

}
