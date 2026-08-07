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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderSmClass;
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

@objid ("078ea81c-1428-45c7-8afb-aca99d11dffe")
public class ConceptSmClass extends ArchimateAbstractElementSmClass {
    @objid ("2ece46e7-6636-48cd-88f0-f0c46a640bae")
    private SmDependency relatedFromDep;

    @objid ("a6aedbe9-cab7-4bb8-a9d2-d6f01f48f00c")
    private SmDependency relatedToDep;

    @objid ("1747633a-fe08-490a-82e7-18f08666a9a9")
    private SmDependency ownerFolderDep;

    @objid ("26d81e89-5d9f-465d-8c9e-ba6c02a46dd1")
    public ConceptSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("37a3fb5b-af02-4899-8209-c76be61561e9")
    @Override
    public String getName() {
        return "Concept";

    }

    @objid ("45e9a720-829b-4fbe-92bf-4c0cf2e12920")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("55bd3463-e82d-4932-88f5-3afde3a68209")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Concept.class;

    }

    @objid ("e306ec65-d948-4ee3-a9f4-a7ae3439db15")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7eb25438-c5bc-45a9-8206-aff981c82340")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("2ff4510c-9967-4fc7-b64c-563b8ec24119")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ArchimateAbstractElement.MQNAME);
        this.registerFactory(new ConceptObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.relatedFromDep = new RelatedFromSmDependency();
        this.relatedFromDep.init("relatedFrom", this, metamodel.getMClass(Relationship.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.relatedFromDep);

        this.relatedToDep = new RelatedToSmDependency();
        this.relatedToDep.init("relatedTo", this, metamodel.getMClass(Relationship.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.relatedToDep);

        this.ownerFolderDep = new OwnerFolderSmDependency();
        this.ownerFolderDep.init("ownerFolder", this, metamodel.getMClass(Folder.MQNAME), 1, 1 );
        registerDependency(this.ownerFolderDep);

    }

    @objid ("9722e868-ff29-4f31-8c0b-5c7e454a7a53")
    public SmDependency getRelatedFromDep() {
        if (this.relatedFromDep == null) {
        	this.relatedFromDep = this.getDependencyDef("relatedFrom");
        }
        return this.relatedFromDep;
    }

    @objid ("52fb3c0a-d7e8-41bc-851c-e6ddf23d5477")
    public SmDependency getRelatedToDep() {
        if (this.relatedToDep == null) {
        	this.relatedToDep = this.getDependencyDef("relatedTo");
        }
        return this.relatedToDep;
    }

    @objid ("8ca4103d-bab5-41af-8194-806cd9f50a5e")
    public SmDependency getOwnerFolderDep() {
        if (this.ownerFolderDep == null) {
        	this.ownerFolderDep = this.getDependencyDef("ownerFolder");
        }
        return this.ownerFolderDep;
    }

    @objid ("831fe457-22ae-4817-9292-919019e2a175")
    private static class ConceptObjectFactory implements ISmObjectFactory {
        @objid ("0faa7c61-7560-4174-913b-0beb4846b147")
        private ConceptSmClass smClass;

        @objid ("574fe075-00ca-442c-be16-79f32b4bba92")
        public ConceptObjectFactory(ConceptSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("20941d90-c548-4d7b-9742-434af9e9b168")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("5e0dd79a-a86a-494d-8dfe-495db7903cd5")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("d5b83e6e-9e98-42c0-855b-ede8428833b8")
    public static class RelatedFromSmDependency extends SmMultipleDependency {
        @objid ("65eaeb6a-3c24-4d9c-a2a9-f29632e337b3")
        private SmDependency symetricDep;

        @objid ("abeed2f0-d25d-43d0-815e-8d7e09cc9361")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ConceptData)data).mRelatedFrom != null)? ((ConceptData)data).mRelatedFrom:SmMultipleDependency.EMPTY;
        }

        @objid ("0fc6f343-a9e6-4428-b173-7f7c18ec2ae5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ConceptData) data).mRelatedFrom = values;

        }

        @objid ("3a12e7a8-af79-43aa-8d33-73459addf7b0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RelationshipSmClass)this.getTarget()).getToDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c076f8c6-0428-4e79-bca5-849d63b67f98")
    public static class RelatedToSmDependency extends SmMultipleDependency {
        @objid ("7975f44a-4ab1-432f-977a-e96a80306945")
        private SmDependency symetricDep;

        @objid ("871db403-67b3-45da-8a04-2ac2412b88a6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ConceptData)data).mRelatedTo != null)? ((ConceptData)data).mRelatedTo:SmMultipleDependency.EMPTY;
        }

        @objid ("5496c0c2-4bee-4da7-896a-6ddb0e7a35aa")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ConceptData) data).mRelatedTo = values;

        }

        @objid ("04deb1d7-060e-4087-8880-1c2271925635")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RelationshipSmClass)this.getTarget()).getFromDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("abf2bde7-3c43-4809-9ca8-96b811be5e30")
    public static class OwnerFolderSmDependency extends SmSingleDependency {
        @objid ("a25e2ac9-a62d-4caf-a518-75ee14b6465a")
        private SmDependency symetricDep;

        @objid ("f9026469-5bb8-479c-80a0-f2c2882ecd04")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ConceptData) data).mOwnerFolder;
        }

        @objid ("31d1c5e7-bfd1-4422-b496-2c95fe7d3a8c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ConceptData) data).mOwnerFolder = value;
        }

        @objid ("27c79685-6833-4b93-b1f2-b947971f5773")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((FolderSmClass)this.getTarget()).getContentDep();
            }
            return this.symetricDep;

        }

    }

}
