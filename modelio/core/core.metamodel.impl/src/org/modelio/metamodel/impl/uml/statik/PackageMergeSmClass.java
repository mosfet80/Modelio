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
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.PackageMerge;
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

@objid ("ac032bd6-64d6-4ff8-bc0b-7bcf311eb66c")
public class PackageMergeSmClass extends UmlModelElementSmClass {
    @objid ("c08c137e-0b3e-4338-9d28-b0bac12226b9")
    private SmDependency mergedPackageDep;

    @objid ("c6da388b-33bf-4c7c-b24a-ce263bea4d93")
    private SmDependency receivingPackageDep;

    @objid ("b71411a2-3cdc-47f5-9177-3ba048f51c36")
    public PackageMergeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9ee33fa8-bfb1-419f-bbaf-dd2c2d7a5c37")
    @Override
    public String getName() {
        return "PackageMerge";

    }

    @objid ("a3bcc1e0-9d2a-4313-a7f2-82b3f9c2e73c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5911b0a7-70e6-40fc-87fb-8f7a532fffdb")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return PackageMerge.class;

    }

    @objid ("d7c71c32-a076-44cd-997b-a7cb76fdc7e6")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a9d12d2e-37a4-4731-af22-0ea773acb68e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("fe086f37-a967-4bde-897c-f95e70516045")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new PackageMergeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.mergedPackageDep = new MergedPackageSmDependency();
        this.mergedPackageDep.init("MergedPackage", this, metamodel.getMClass(Package.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.mergedPackageDep);

        this.receivingPackageDep = new ReceivingPackageSmDependency();
        this.receivingPackageDep.init("ReceivingPackage", this, metamodel.getMClass(Package.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.receivingPackageDep);

    }

    @objid ("a16fdf52-d840-4498-be69-5e827fc71c3b")
    public SmDependency getMergedPackageDep() {
        if (this.mergedPackageDep == null) {
        	this.mergedPackageDep = this.getDependencyDef("MergedPackage");
        }
        return this.mergedPackageDep;
    }

    @objid ("10428748-42fb-47cf-823f-7102be8f6e6d")
    public SmDependency getReceivingPackageDep() {
        if (this.receivingPackageDep == null) {
        	this.receivingPackageDep = this.getDependencyDef("ReceivingPackage");
        }
        return this.receivingPackageDep;
    }

    @objid ("5be5acc7-5532-4e78-9bd3-e964f3b44f13")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("2add88da-cc1c-463c-af98-45d1d6876f43")
    private static class PackageMergeObjectFactory implements ISmObjectFactory {
        @objid ("e3cdb51d-7a00-42f8-9f3c-680fc486e8ed")
        private PackageMergeSmClass smClass;

        @objid ("f6b4a672-91f3-4591-95d1-9d6dce47921c")
        public PackageMergeObjectFactory(PackageMergeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4acde156-2fb6-414b-9ef3-319b0badb619")
        @Override
        public ISmObjectData createData() {
            return new PackageMergeData(this.smClass);
        }

        @objid ("9595060d-7a71-4a2f-9d76-2f8bd587e1cf")
        @Override
        public SmObjectImpl createImpl() {
            return new PackageMergeImpl();
        }

    }

    @objid ("3af300fd-a34d-4ddf-ab6d-f75bb6bfa7ef")
    public static class MergedPackageSmDependency extends SmSingleDependency {
        @objid ("1384b846-c231-4e86-b797-656f9e89fbdc")
        private SmDependency symetricDep;

        @objid ("3861bebe-7247-46a8-b8b2-aebe7170cba9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PackageMergeData) data).mMergedPackage;
        }

        @objid ("eb6a2451-ea87-4ae9-8f4a-b594c1672a20")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PackageMergeData) data).mMergedPackage = value;
        }

        @objid ("fe9cffd0-aa8a-4abf-94d6-d7321a06c6f3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageSmClass)this.getTarget()).getReceivingMergeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f5f08777-496f-4b33-ac72-b11a8ed79cf8")
    public static class ReceivingPackageSmDependency extends SmSingleDependency {
        @objid ("2e7f44d0-b193-44a0-a4e9-31c277c6d7e5")
        private SmDependency symetricDep;

        @objid ("76e85e5d-f4ae-411a-89fb-153db6066d24")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PackageMergeData) data).mReceivingPackage;
        }

        @objid ("6ef57424-51e4-4f3d-bfff-5ea92d9404d8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PackageMergeData) data).mReceivingPackage = value;
        }

        @objid ("6baf49a9-ff66-41c2-ad02-d4cf46995a75")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageSmClass)this.getTarget()).getMergeDep();
            }
            return this.symetricDep;

        }

    }

}
