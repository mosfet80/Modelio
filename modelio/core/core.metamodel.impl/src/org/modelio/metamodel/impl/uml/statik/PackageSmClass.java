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
import org.modelio.metamodel.impl.mda.ProjectSmClass;
import org.modelio.metamodel.mda.Project;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.PackageMerge;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a668a077-8567-41a2-ba8a-f0ce875e4f05")
public class PackageSmClass extends NameSpaceSmClass {
    @objid ("08e779d3-0487-407e-b0ab-326c688a2e0b")
    private SmAttribute isInstantiableAtt;

    @objid ("75737909-2aa0-4bf1-8d0b-db0c994105cc")
    private SmDependency receivingMergeDep;

    @objid ("3a93e1dc-1cb9-4ed0-b532-9b0edf430541")
    private SmDependency representedDep;

    @objid ("7193a858-35d1-4873-ac08-e8532452b9f9")
    private SmDependency mergeDep;

    @objid ("5b18ba03-1855-4aa9-b268-5a90d34aeb65")
    private SmDependency packageImportingDep;

    @objid ("f1426e63-e9e6-4e60-8592-993c8a290946")
    public PackageSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5bf2130f-37e0-4eb3-946b-68ed86aea62b")
    @Override
    public String getName() {
        return "Package";

    }

    @objid ("df8ca91e-4e34-43a0-bb44-f561747a9d7c")
    @Override
    public Version getVersion() {
        return new Version("1.1.1");
    }

    @objid ("da4ca28d-8b31-4221-af31-8725f43943df")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Package.class;

    }

    @objid ("6bdfa74e-cace-482a-9831-0f74ffc1cec0")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("14421535-1849-49bf-b8b1-3131746bbd1b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("deb31e75-f589-4f5a-8cc5-4014f5cf04b4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(NameSpace.MQNAME);
        this.registerFactory(new PackageObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isInstantiableAtt = new IsInstantiableSmAttribute();
        this.isInstantiableAtt.init("IsInstantiable", this, Boolean.class );
        registerAttribute(this.isInstantiableAtt);


        // Initialize and register the SmDependency
        this.receivingMergeDep = new ReceivingMergeSmDependency();
        this.receivingMergeDep.init("ReceivingMerge", this, metamodel.getMClass(PackageMerge.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.receivingMergeDep);

        this.representedDep = new RepresentedSmDependency();
        this.representedDep.init("Represented", this, metamodel.getMClass(Project.MQNAME), 0, 1 );
        registerDependency(this.representedDep);

        this.mergeDep = new MergeSmDependency();
        this.mergeDep.init("Merge", this, metamodel.getMClass(PackageMerge.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.mergeDep);

        this.packageImportingDep = new PackageImportingSmDependency();
        this.packageImportingDep.init("PackageImporting", this, metamodel.getMClass(PackageImport.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.packageImportingDep);

    }

    @objid ("36cbab69-dc51-47e0-a794-de650d13bd42")
    public SmAttribute getIsInstantiableAtt() {
        if (this.isInstantiableAtt == null) {
        	this.isInstantiableAtt = this.getAttributeDef("IsInstantiable");
        }
        return this.isInstantiableAtt;
    }

    @objid ("fa380ec8-1934-49da-b33f-1456c5cc78bc")
    public SmDependency getReceivingMergeDep() {
        if (this.receivingMergeDep == null) {
        	this.receivingMergeDep = this.getDependencyDef("ReceivingMerge");
        }
        return this.receivingMergeDep;
    }

    @objid ("8320b6d0-847f-4e36-800b-09e4153983dd")
    public SmDependency getRepresentedDep() {
        if (this.representedDep == null) {
        	this.representedDep = this.getDependencyDef("Represented");
        }
        return this.representedDep;
    }

    @objid ("c0252b02-9560-464a-bacd-6442450b6e7b")
    public SmDependency getMergeDep() {
        if (this.mergeDep == null) {
        	this.mergeDep = this.getDependencyDef("Merge");
        }
        return this.mergeDep;
    }

    @objid ("743dc3c2-5cfa-4d34-a141-8dd67542f430")
    public SmDependency getPackageImportingDep() {
        if (this.packageImportingDep == null) {
        	this.packageImportingDep = this.getDependencyDef("PackageImporting");
        }
        return this.packageImportingDep;
    }

    @objid ("daae0695-3574-4c5c-8bd5-0f5846e75449")
    private static class PackageObjectFactory implements ISmObjectFactory {
        @objid ("becf71a0-1bae-4d3d-8e2f-782c391ff705")
        private PackageSmClass smClass;

        @objid ("9fb97909-4aca-4a08-8777-2c7cb117fa51")
        public PackageObjectFactory(PackageSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b280488a-51a9-4503-92f9-fda81047cb1a")
        @Override
        public ISmObjectData createData() {
            return new PackageData(this.smClass);
        }

        @objid ("94724da2-9496-49d6-890e-ff28aa650a7a")
        @Override
        public SmObjectImpl createImpl() {
            return new PackageImpl();
        }

    }

    @objid ("335473bd-2e36-454e-b26a-f23269a039b7")
    public static class IsInstantiableSmAttribute extends SmAttribute {
        @objid ("5e44df5b-f4fb-4dfe-b8a2-4605c4217e1e")
        public Object getValue(ISmObjectData data) {
            return ((PackageData) data).mIsInstantiable;
        }

        @objid ("13516a4b-4fb4-461c-b1bc-a9f9055510f7")
        public void setValue(ISmObjectData data, Object value) {
            ((PackageData) data).mIsInstantiable = value;
        }

    }

    @objid ("51c6ffb4-02eb-4e71-a82e-7e25fb9ed891")
    public static class ReceivingMergeSmDependency extends SmMultipleDependency {
        @objid ("27879f02-9e77-48e0-a74a-6de3daa3d62c")
        private SmDependency symetricDep;

        @objid ("21cdf6eb-cc31-4212-bc6c-cc44b1a07312")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((PackageData)data).mReceivingMerge != null)? ((PackageData)data).mReceivingMerge:SmMultipleDependency.EMPTY;
        }

        @objid ("9061a5ac-85b6-4b12-86bd-47bda25d87ab")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((PackageData) data).mReceivingMerge = values;

        }

        @objid ("dabf1619-35e0-485c-8d81-a2beab331b50")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageMergeSmClass)this.getTarget()).getMergedPackageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c86ae0a9-e287-4f2e-ae7d-4d47532aed62")
    public static class RepresentedSmDependency extends SmSingleDependency {
        @objid ("f9dfcd55-8ccc-4fc7-a945-739c54caed4c")
        private SmDependency symetricDep;

        @objid ("9a951097-2b3b-47e1-9831-9b279534bb2b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PackageData) data).mRepresented;
        }

        @objid ("dedc1e8b-6ba6-4b20-a833-428ecdb409d0")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PackageData) data).mRepresented = value;
        }

        @objid ("401bca40-e35f-4509-baa5-9681c370e362")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ProjectSmClass)this.getTarget()).getModelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("36c6ac49-d1d9-4fd5-a6f1-e76525bae749")
    public static class MergeSmDependency extends SmMultipleDependency {
        @objid ("f9c3eaca-8002-4c09-802d-0c21a20fa1e0")
        private SmDependency symetricDep;

        @objid ("3d6f3e26-93d4-4074-af0e-6da102072b04")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((PackageData)data).mMerge != null)? ((PackageData)data).mMerge:SmMultipleDependency.EMPTY;
        }

        @objid ("3bb8cd5d-549a-4b80-85ef-66ab35a77d5e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((PackageData) data).mMerge = values;

        }

        @objid ("8d28e3d2-da15-4fd7-9245-4e98b44aec36")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageMergeSmClass)this.getTarget()).getReceivingPackageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1761709a-f0f3-442b-a756-da6715c8fe44")
    public static class PackageImportingSmDependency extends SmMultipleDependency {
        @objid ("5a5f71e8-4ad4-4f01-8441-48e7c9842fcf")
        private SmDependency symetricDep;

        @objid ("c36f7d1d-02e5-45d5-b3ef-69709d98f57f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((PackageData)data).mPackageImporting != null)? ((PackageData)data).mPackageImporting:SmMultipleDependency.EMPTY;
        }

        @objid ("1440267e-a84b-4907-ab16-ce8746723d27")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((PackageData) data).mPackageImporting = values;

        }

        @objid ("7ba58494-0564-4bfb-8ad7-8035c16cf3d3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PackageImportSmClass)this.getTarget()).getImportedPackageDep();
            }
            return this.symetricDep;

        }

    }

}
