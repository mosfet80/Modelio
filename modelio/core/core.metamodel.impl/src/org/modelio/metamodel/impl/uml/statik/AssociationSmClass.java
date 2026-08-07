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
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.Link;
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

@objid ("cd569d79-73f0-4df0-b323-377f6551adad")
public class AssociationSmClass extends UmlModelElementSmClass {
    @objid ("51ba1911-8027-4528-9e3f-62037327f25f")
    private SmDependency occurenceDep;

    @objid ("ba50053a-e046-4b55-9e97-9b9a383b5f8a")
    private SmDependency endDep;

    @objid ("bdfa37f1-b4a6-42c0-b952-b2a14a29a79b")
    private SmDependency linkToClassDep;

    @objid ("8d822d15-b1f5-4281-9ca8-d4e289ba8a0e")
    public AssociationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("ca67095b-d2d6-4321-a227-a7f7a0e0c7ee")
    @Override
    public String getName() {
        return "Association";

    }

    @objid ("ea6871d0-b759-4c2d-8f7f-7abc9e1ff130")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("16e61499-29c3-49dc-8316-d4e2ff35f2d2")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Association.class;

    }

    @objid ("c47000bb-f3ee-45fe-a709-f1a15bfcbafd")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5a289db7-bd40-4b60-9444-8071b4248c28")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6edf1344-2fb3-4ad6-a0b0-bca3773489cb")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new AssociationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.occurenceDep = new OccurenceSmDependency();
        this.occurenceDep.init("Occurence", this, metamodel.getMClass(Link.MQNAME), 0, -1 );
        registerDependency(this.occurenceDep);

        this.endDep = new EndSmDependency();
        this.endDep.init("End", this, metamodel.getMClass(AssociationEnd.MQNAME), 2, 2 );
        registerDependency(this.endDep);

        this.linkToClassDep = new LinkToClassSmDependency();
        this.linkToClassDep.init("LinkToClass", this, metamodel.getMClass(ClassAssociation.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.linkToClassDep);

    }

    @objid ("3899c687-80d5-4fc9-aa1c-f5564c2d1684")
    public SmDependency getOccurenceDep() {
        if (this.occurenceDep == null) {
        	this.occurenceDep = this.getDependencyDef("Occurence");
        }
        return this.occurenceDep;
    }

    @objid ("b74513bb-c286-4e6c-96c6-95f258e75771")
    public SmDependency getEndDep() {
        if (this.endDep == null) {
        	this.endDep = this.getDependencyDef("End");
        }
        return this.endDep;
    }

    @objid ("ebe0d28b-1181-4f41-85b3-6b0a2bafa4c3")
    public SmDependency getLinkToClassDep() {
        if (this.linkToClassDep == null) {
        	this.linkToClassDep = this.getDependencyDef("LinkToClass");
        }
        return this.linkToClassDep;
    }

    @objid ("8cf23ce3-6c9f-4bec-8e37-e4e6ff005030")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("7102af6c-113d-4629-b612-fd6aba8da06f")
    private static class AssociationObjectFactory implements ISmObjectFactory {
        @objid ("47a0d621-20eb-426f-8955-c61db78015b5")
        private AssociationSmClass smClass;

        @objid ("4fd50c8d-f3fb-4729-b5c0-aa3b27399465")
        public AssociationObjectFactory(AssociationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("fe452c92-a75b-4369-83b7-bb9c545da892")
        @Override
        public ISmObjectData createData() {
            return new AssociationData(this.smClass);
        }

        @objid ("7d3d9e87-8d02-4ecf-8a39-006feb7e5193")
        @Override
        public SmObjectImpl createImpl() {
            return new AssociationImpl();
        }

    }

    @objid ("4645ffe5-1385-4058-873e-1a048daa0cf0")
    public static class OccurenceSmDependency extends SmMultipleDependency {
        @objid ("1db58e1d-c8bb-48c5-b104-0d9b87d6597a")
        private SmDependency symetricDep;

        @objid ("b4af147f-59fb-4a70-9f4d-852bae19162f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AssociationData)data).mOccurence != null)? ((AssociationData)data).mOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("5abcdaf2-c7f7-4593-9429-2dcc9e3af65e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AssociationData) data).mOccurence = values;

        }

        @objid ("b1a28e86-a52a-484a-9fc0-a872db4b4858")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkSmClass)this.getTarget()).getModelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6e9d0267-4ef6-4ae7-a541-2de9afa08ee8")
    public static class EndSmDependency extends SmMultipleDependency {
        @objid ("dc7f3e5d-c962-41ad-b754-53d679ff8ffb")
        private SmDependency symetricDep;

        @objid ("5c00e5c8-1426-471d-b261-9fa1f204d826")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((AssociationData)data).mEnd != null)? ((AssociationData)data).mEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("55fd22ae-24cd-4844-914a-a16c8ea9f54e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((AssociationData) data).mEnd = values;

        }

        @objid ("7ba44c14-58f3-4283-85b9-9803a219f508")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8cf76135-8885-4813-bcfe-edb480a992a5")
    public static class LinkToClassSmDependency extends SmSingleDependency {
        @objid ("8826c6ba-23d0-4bb4-98df-611838a7418e")
        private SmDependency symetricDep;

        @objid ("6c6504bd-d750-4712-877a-9fedb95cf7dd")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AssociationData) data).mLinkToClass;
        }

        @objid ("50b20825-ae03-4b69-ae2f-761f7d8bd417")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AssociationData) data).mLinkToClass = value;
        }

        @objid ("511ff24b-df9b-4a81-b1aa-56557c58e312")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassAssociationSmClass)this.getTarget()).getAssociationPartDep();
            }
            return this.symetricDep;

        }

    }

}
