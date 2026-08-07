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
import org.modelio.metamodel.uml.statik.ElementImport;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f1131a92-11a8-41a4-baeb-56e593167c82")
public class ElementImportSmClass extends UmlModelElementSmClass {
    @objid ("fef862f4-cfea-4122-b572-755ef123d91d")
    private SmAttribute visibilityAtt;

    @objid ("8c616c9e-8e2f-4c66-a179-c8841e425827")
    private SmDependency importingNameSpaceDep;

    @objid ("6e86c2e1-941a-479e-9b50-471753405735")
    private SmDependency importedElementDep;

    @objid ("e521a203-ae4b-4e9c-80db-6eadb5d8888b")
    private SmDependency importingOperationDep;

    @objid ("2e49d192-63c4-42f1-98b4-fbcf6a6b0b33")
    public ElementImportSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("3269d5d5-a56b-4f95-a904-6765bc712bc5")
    @Override
    public String getName() {
        return "ElementImport";

    }

    @objid ("9e31ab01-6c78-4502-a18e-824906584351")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("84a7a3e4-4e72-46d4-bb3e-e8b4851dda5d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ElementImport.class;

    }

    @objid ("f7cc2a11-c4fc-41cb-b842-ee52523f16ab")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("4144d2c9-1744-4e01-a698-e54e2a9a37ef")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5f3250a8-31ba-4766-9aaa-344dc3caa921")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ElementImportObjectFactory(this));


        // Initialize and register the SmAttribute
        this.visibilityAtt = new VisibilitySmAttribute();
        this.visibilityAtt.init("Visibility", this, VisibilityMode.class );
        registerAttribute(this.visibilityAtt);


        // Initialize and register the SmDependency
        this.importingNameSpaceDep = new ImportingNameSpaceSmDependency();
        this.importingNameSpaceDep.init("ImportingNameSpace", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.importingNameSpaceDep);

        this.importedElementDep = new ImportedElementSmDependency();
        this.importedElementDep.init("ImportedElement", this, metamodel.getMClass(NameSpace.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.importedElementDep);

        this.importingOperationDep = new ImportingOperationSmDependency();
        this.importingOperationDep.init("ImportingOperation", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.importingOperationDep);

    }

    @objid ("d8fe86b9-f446-4a57-a308-988becb7b9fb")
    public SmAttribute getVisibilityAtt() {
        if (this.visibilityAtt == null) {
        	this.visibilityAtt = this.getAttributeDef("Visibility");
        }
        return this.visibilityAtt;
    }

    @objid ("a81fc923-d513-4ab6-96bf-de6e683079dc")
    public SmDependency getImportingNameSpaceDep() {
        if (this.importingNameSpaceDep == null) {
        	this.importingNameSpaceDep = this.getDependencyDef("ImportingNameSpace");
        }
        return this.importingNameSpaceDep;
    }

    @objid ("7b3de6e6-42b2-417c-b1e7-ac017c2cdff6")
    public SmDependency getImportedElementDep() {
        if (this.importedElementDep == null) {
        	this.importedElementDep = this.getDependencyDef("ImportedElement");
        }
        return this.importedElementDep;
    }

    @objid ("013018b2-8a1a-47a0-bdae-3cc90b50645d")
    public SmDependency getImportingOperationDep() {
        if (this.importingOperationDep == null) {
        	this.importingOperationDep = this.getDependencyDef("ImportingOperation");
        }
        return this.importingOperationDep;
    }

    @objid ("13ce0ae5-27dc-46ec-b5d4-df290167170c")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("32e190a7-c510-4e4e-84e5-434396425161")
    private static class ElementImportObjectFactory implements ISmObjectFactory {
        @objid ("1172c0dc-77b4-4392-9e06-435973d53f1d")
        private ElementImportSmClass smClass;

        @objid ("099bebb6-868e-47af-847b-08376e4fa655")
        public ElementImportObjectFactory(ElementImportSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e8afe5f7-fd00-4c46-a1da-acb328f19e83")
        @Override
        public ISmObjectData createData() {
            return new ElementImportData(this.smClass);
        }

        @objid ("0edb41ed-63cc-4371-99fc-74d23efa5c04")
        @Override
        public SmObjectImpl createImpl() {
            return new ElementImportImpl();
        }

    }

    @objid ("53804d09-1d36-4a67-9b87-4b3591b09ae6")
    public static class VisibilitySmAttribute extends SmAttribute {
        @objid ("ca9c963d-e5d1-4f07-a270-f3f546e2716d")
        public Object getValue(ISmObjectData data) {
            return ((ElementImportData) data).mVisibility;
        }

        @objid ("56ebb498-a236-49c1-98c4-e92584b9b790")
        public void setValue(ISmObjectData data, Object value) {
            ((ElementImportData) data).mVisibility = value;
        }

    }

    @objid ("333334bd-a9b3-4991-905a-443ccd99346f")
    public static class ImportingNameSpaceSmDependency extends SmSingleDependency {
        @objid ("d830f256-6504-4d09-8ee7-d53eac32962e")
        private SmDependency symetricDep;

        @objid ("4e248f54-5820-47fd-958b-7e0f5694322e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ElementImportData) data).mImportingNameSpace;
        }

        @objid ("b2edf585-7ed4-4de3-9f0f-150182bdcbe3")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ElementImportData) data).mImportingNameSpace = value;
        }

        @objid ("78cfb4f9-7880-49be-ae12-2083703b843c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getOwnedImportDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b457ab0b-1943-4217-8dd1-a78a7572abe3")
    public static class ImportedElementSmDependency extends SmSingleDependency {
        @objid ("438996d6-ef1a-4c67-b1fe-185d08994eea")
        private SmDependency symetricDep;

        @objid ("01912abe-407d-4e70-a768-f8bb9637f49d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ElementImportData) data).mImportedElement;
        }

        @objid ("d949d1df-7432-4138-927e-17d0def4fad2")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ElementImportData) data).mImportedElement = value;
        }

        @objid ("af7127b7-3f00-4807-aac7-b389782f2796")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getImportingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3e7a5220-d668-4ab8-9f5a-fb4178f24910")
    public static class ImportingOperationSmDependency extends SmSingleDependency {
        @objid ("d40db0cb-a6a4-4e71-8049-3ff0e6cc0b6d")
        private SmDependency symetricDep;

        @objid ("5c79fd8e-7d6e-437b-9baf-3bfa8669982d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ElementImportData) data).mImportingOperation;
        }

        @objid ("98fa2e33-668c-4190-b681-063772dcca3c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ElementImportData) data).mImportingOperation = value;
        }

        @objid ("90a30b88-c3e7-4a42-abd6-88208cfcb964")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getOwnedImportDep();
            }
            return this.symetricDep;

        }

    }

}
