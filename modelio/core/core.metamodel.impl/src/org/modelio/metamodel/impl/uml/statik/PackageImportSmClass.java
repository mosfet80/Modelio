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
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.PackageImport;
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

@objid ("2b5a751d-bf5a-4826-8664-010d1d624c31")
public class PackageImportSmClass extends UmlModelElementSmClass {
    @objid ("ebf9c232-db79-4848-960f-054038452ddc")
    private SmAttribute visibilityAtt;

    @objid ("458867b7-a666-41c1-9dd2-6d2ca2dadf01")
    private SmDependency importingOperationDep;

    @objid ("f91fb36c-1dd4-4c09-945f-6d94001c5360")
    private SmDependency importingNameSpaceDep;

    @objid ("0a999a22-8174-4269-ab51-99d2d94f9bd3")
    private SmDependency importedPackageDep;

    @objid ("98f158a9-0d79-464b-8106-e7663c8bf30a")
    public PackageImportSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e350b818-3174-4aee-8249-5b5fe9a69a10")
    @Override
    public String getName() {
        return "PackageImport";

    }

    @objid ("96f1c2d0-c424-4da1-be4e-6aaf8b1b215d")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("06409b18-e6e9-4097-bab1-2cba83d1eaa9")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return PackageImport.class;

    }

    @objid ("d18ae9a9-41bf-42f1-802d-8a48ad94022e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0a216826-c6ed-4c19-beef-c4bee39090f0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a6c98bf2-8d5b-4cdb-9484-f3144d61b998")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new PackageImportObjectFactory(this));


        // Initialize and register the SmAttribute
        this.visibilityAtt = new VisibilitySmAttribute();
        this.visibilityAtt.init("Visibility", this, VisibilityMode.class );
        registerAttribute(this.visibilityAtt);


        // Initialize and register the SmDependency
        this.importingOperationDep = new ImportingOperationSmDependency();
        this.importingOperationDep.init("ImportingOperation", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.importingOperationDep);

        this.importingNameSpaceDep = new ImportingNameSpaceSmDependency();
        this.importingNameSpaceDep.init("ImportingNameSpace", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.importingNameSpaceDep);

        this.importedPackageDep = new ImportedPackageSmDependency();
        this.importedPackageDep.init("ImportedPackage", this, metamodel.getMClass(Package.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.importedPackageDep);

    }

    @objid ("09aa1317-0776-4688-b0ab-e704051097b2")
    public SmAttribute getVisibilityAtt() {
        if (this.visibilityAtt == null) {
        	this.visibilityAtt = this.getAttributeDef("Visibility");
        }
        return this.visibilityAtt;
    }

    @objid ("2f4623d6-0576-4488-86b8-b73e3e9a20a7")
    public SmDependency getImportingOperationDep() {
        if (this.importingOperationDep == null) {
        	this.importingOperationDep = this.getDependencyDef("ImportingOperation");
        }
        return this.importingOperationDep;
    }

    @objid ("c472ce83-b7fd-42ab-a38c-13067a316e47")
    public SmDependency getImportingNameSpaceDep() {
        if (this.importingNameSpaceDep == null) {
        	this.importingNameSpaceDep = this.getDependencyDef("ImportingNameSpace");
        }
        return this.importingNameSpaceDep;
    }

    @objid ("2b796f39-f424-4ee0-9486-7c486bd0f5a3")
    public SmDependency getImportedPackageDep() {
        if (this.importedPackageDep == null) {
        	this.importedPackageDep = this.getDependencyDef("ImportedPackage");
        }
        return this.importedPackageDep;
    }

    @objid ("507347f9-e2d1-478c-88d2-fbba05c474d2")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("92dc484c-0da9-4e9b-a07b-19a4e20d5190")
    private static class PackageImportObjectFactory implements ISmObjectFactory {
        @objid ("7ddc766f-56d7-4c14-97c2-12c94cd09123")
        private PackageImportSmClass smClass;

        @objid ("0772a7b4-adff-455e-8188-d8981c9f7918")
        public PackageImportObjectFactory(PackageImportSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5b440f69-00d0-4c16-b9e0-f1355e650fa0")
        @Override
        public ISmObjectData createData() {
            return new PackageImportData(this.smClass);
        }

        @objid ("370eb3b4-1804-49b9-9be1-0540bb6f8558")
        @Override
        public SmObjectImpl createImpl() {
            return new PackageImportImpl();
        }

    }

    @objid ("63081d34-6f56-4337-9c49-584697c76772")
    public static class VisibilitySmAttribute extends SmAttribute {
        @objid ("9e83fa1b-966d-4a6c-b5b1-d31d71e05f40")
        public Object getValue(ISmObjectData data) {
            return ((PackageImportData) data).mVisibility;
        }

        @objid ("4e5632d6-8379-4548-aaaf-1c5eecfa7bcc")
        public void setValue(ISmObjectData data, Object value) {
            ((PackageImportData) data).mVisibility = value;
        }

    }

    @objid ("98ecc494-2818-4b25-86ae-76dcac30b090")
    public static class ImportingOperationSmDependency extends SmSingleDependency {
        @objid ("ce05faf8-21e4-4f09-bc69-679d3dc34b71")
        private SmDependency symetricDep;

        @objid ("6ddb62ae-69b4-4df7-92bc-730e60d4949e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PackageImportData) data).mImportingOperation;
        }

        @objid ("418096c0-bb5a-49a3-9682-f81ff956e170")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PackageImportData) data).mImportingOperation = value;
        }

        @objid ("fc887200-a3b6-424d-814c-9f633e9f27c4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getOwnedPackageImportDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("de844e8b-f8ce-4598-bb8e-48f29c549527")
    public static class ImportingNameSpaceSmDependency extends SmSingleDependency {
        @objid ("50ac3727-af6c-497c-b259-19d04272a97b")
        private SmDependency symetricDep;

        @objid ("a043c300-a067-4ccd-b005-9fcad48783a5")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PackageImportData) data).mImportingNameSpace;
        }

        @objid ("4d251bcc-72ca-419f-9dce-5c3f4e5be19a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PackageImportData) data).mImportingNameSpace = value;
        }

        @objid ("7407f08b-e398-4f7f-8926-e98b5eb66786")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getOwnedPackageImportDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("13db9bac-5932-46e3-a454-20bab0d87e80")
    public static class ImportedPackageSmDependency extends SmSingleDependency {
        @objid ("564e8124-394d-466f-8979-18d2e45b5103")
        private SmDependency symetricDep;

        @objid ("760251fd-58ba-4997-85a5-7120fc5a6025")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PackageImportData) data).mImportedPackage;
        }

        @objid ("58c45f26-6474-492a-9d61-be3624d76173")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PackageImportData) data).mImportedPackage = value;
        }

        @objid ("f94164f5-2df8-44b1-8a84-dc59a935d650")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageSmClass)this.getTarget()).getPackageImportingDep();
            }
            return this.symetricDep;

        }

    }

}
