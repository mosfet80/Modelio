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
package org.modelio.metamodel.impl.uml.behavior.usecaseModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.GeneralClassSmClass;
import org.modelio.metamodel.uml.behavior.usecaseModel.ExtensionPoint;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCase;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCaseDependency;
import org.modelio.metamodel.uml.statik.GeneralClass;
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

@objid ("a769982c-8238-414b-a66c-83aaf9c76b10")
public class UseCaseSmClass extends GeneralClassSmClass {
    @objid ("d7d82135-7952-4253-8a1c-18a20376f098")
    private SmDependency usedDep;

    @objid ("2b5ce790-be75-40fc-be38-6445b44501b6")
    private SmDependency ownedExtensionDep;

    @objid ("26136815-41bd-4e35-a54b-6381ebd966bd")
    private SmDependency userDep;

    @objid ("173e8f94-2a0b-4acb-9785-b54e57824810")
    public UseCaseSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("3307758a-ef4d-4aae-aba9-b33ae5270e85")
    @Override
    public String getName() {
        return "UseCase";

    }

    @objid ("e6556ea4-dbfa-4259-8ae7-658136ffb27c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3f2c9dc5-5db1-4f0d-be5a-f692aafa4a67")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return UseCase.class;

    }

    @objid ("45347ea2-c3ad-4c73-af6e-890d1a446037")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("ecbcf461-a80a-45da-85a2-8a87b5798b61")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("583a8759-3da9-4d61-bc32-68df74f4f8cd")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new UseCaseObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.usedDep = new UsedSmDependency();
        this.usedDep.init("Used", this, metamodel.getMClass(UseCaseDependency.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.usedDep);

        this.ownedExtensionDep = new OwnedExtensionSmDependency();
        this.ownedExtensionDep.init("OwnedExtension", this, metamodel.getMClass(ExtensionPoint.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedExtensionDep);

        this.userDep = new UserSmDependency();
        this.userDep.init("User", this, metamodel.getMClass(UseCaseDependency.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC, SmDirective.SMCDTODELETE);
        registerDependency(this.userDep);

    }

    @objid ("f0db056a-c313-4a84-9eda-5caa7d738115")
    public SmDependency getUsedDep() {
        if (this.usedDep == null) {
        	this.usedDep = this.getDependencyDef("Used");
        }
        return this.usedDep;
    }

    @objid ("9e3c7c94-0ea9-4b74-8367-4e4cda44441d")
    public SmDependency getOwnedExtensionDep() {
        if (this.ownedExtensionDep == null) {
        	this.ownedExtensionDep = this.getDependencyDef("OwnedExtension");
        }
        return this.ownedExtensionDep;
    }

    @objid ("bba62498-3281-44bd-96b4-5db06e3de301")
    public SmDependency getUserDep() {
        if (this.userDep == null) {
        	this.userDep = this.getDependencyDef("User");
        }
        return this.userDep;
    }

    @objid ("bbaf5205-c9d3-4355-b740-68f5e7f65041")
    private static class UseCaseObjectFactory implements ISmObjectFactory {
        @objid ("8e22b338-7582-4bb8-8994-dc42c9a4895e")
        private UseCaseSmClass smClass;

        @objid ("255558ca-d1e8-4b42-88d0-4c60870b892f")
        public UseCaseObjectFactory(UseCaseSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("10e876d4-01f0-4473-8f3a-5323593def86")
        @Override
        public ISmObjectData createData() {
            return new UseCaseData(this.smClass);
        }

        @objid ("3ad63fec-09a7-42c5-ba9e-bb2184c152cf")
        @Override
        public SmObjectImpl createImpl() {
            return new UseCaseImpl();
        }

    }

    @objid ("aab89479-ee17-4c7f-b3fa-35803af99c53")
    public static class UsedSmDependency extends SmMultipleDependency {
        @objid ("55176226-92f4-49c5-a40a-99eaedf93da3")
        private SmDependency symetricDep;

        @objid ("b82d0de4-abfa-4990-a29e-df0afb7955e6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UseCaseData)data).mUsed != null)? ((UseCaseData)data).mUsed:SmMultipleDependency.EMPTY;
        }

        @objid ("99348acf-eb06-414d-b6b1-a1a030070ec2")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UseCaseData) data).mUsed = values;

        }

        @objid ("37b5ecb7-d150-4821-85b1-c1b51e01f49e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UseCaseDependencySmClass)this.getTarget()).getOriginDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e4594661-ee4f-4f5d-9d8a-04f9b1127282")
    public static class OwnedExtensionSmDependency extends SmMultipleDependency {
        @objid ("52c6a18a-09af-4693-b3ee-b75514f9d909")
        private SmDependency symetricDep;

        @objid ("9888ccd6-cc07-483b-8713-2f7c9487c91f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UseCaseData)data).mOwnedExtension != null)? ((UseCaseData)data).mOwnedExtension:SmMultipleDependency.EMPTY;
        }

        @objid ("a471aa68-4ddc-4fa6-9cd3-19aa81bc4fb2")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UseCaseData) data).mOwnedExtension = values;

        }

        @objid ("eaa2b8f9-4ecd-4ebb-ab61-4a1b061e23d4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExtensionPointSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("59efd104-7076-40e7-949d-610410211462")
    public static class UserSmDependency extends SmMultipleDependency {
        @objid ("85d1dea2-97b9-4bbe-bcfb-82fa409b597d")
        private SmDependency symetricDep;

        @objid ("95dacdea-8edb-4b71-93ce-61052733d2b7")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UseCaseData)data).mUser != null)? ((UseCaseData)data).mUser:SmMultipleDependency.EMPTY;
        }

        @objid ("345df10b-f87c-4207-8932-cf73f1ff8764")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UseCaseData) data).mUser = values;

        }

        @objid ("b3a54b57-acc5-414c-aa25-1566f274a517")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UseCaseDependencySmClass)this.getTarget()).getTargetDep();
            }
            return this.symetricDep;

        }

    }

}
