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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.usecaseModel.ExtensionPoint;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCase;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCaseDependency;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("c0c422fc-6fa7-44af-bc45-b6db86732826")
public class UseCaseDependencySmClass extends UmlModelElementSmClass {
    @objid ("866a2f56-e7b8-40ce-8649-84aa3e18601c")
    private SmDependency originDep;

    @objid ("ee938084-3332-4df3-a693-7151d02a434b")
    private SmDependency extensionLocationDep;

    @objid ("7b539b68-bdf3-435f-8621-397a40bc8ccc")
    private SmDependency targetDep;

    @objid ("1ed22609-51b1-4f7c-96a5-59008276db1c")
    public UseCaseDependencySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b5748aa6-e2c5-4255-81ec-e5a15acd1256")
    @Override
    public String getName() {
        return "UseCaseDependency";

    }

    @objid ("430cf1ea-aa22-4b41-8783-2d0742a780b5")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("b19a20f1-a55a-45ab-bba0-de56b9013141")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return UseCaseDependency.class;

    }

    @objid ("8c853429-823b-4ec5-9f0b-b4d7a75ca4fb")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("78550802-7d00-4e12-96d7-c42a7db42344")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("88754884-f4e7-4a34-99c9-de8d086d4604")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new UseCaseDependencyObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.originDep = new OriginSmDependency();
        this.originDep.init("Origin", this, metamodel.getMClass(UseCase.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.originDep);

        this.extensionLocationDep = new ExtensionLocationSmDependency();
        this.extensionLocationDep.init("ExtensionLocation", this, metamodel.getMClass(ExtensionPoint.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.extensionLocationDep);

        this.targetDep = new TargetSmDependency();
        this.targetDep.init("Target", this, metamodel.getMClass(UseCase.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetDep);

    }

    @objid ("1aa4a912-8266-41c7-9ffb-a1e988e60e48")
    public SmDependency getOriginDep() {
        if (this.originDep == null) {
        	this.originDep = this.getDependencyDef("Origin");
        }
        return this.originDep;
    }

    @objid ("54729094-9854-4f80-89ca-9cc316e83a10")
    public SmDependency getExtensionLocationDep() {
        if (this.extensionLocationDep == null) {
        	this.extensionLocationDep = this.getDependencyDef("ExtensionLocation");
        }
        return this.extensionLocationDep;
    }

    @objid ("7c3f2e10-9dd3-4888-b94d-dcb9a1b1f68d")
    public SmDependency getTargetDep() {
        if (this.targetDep == null) {
        	this.targetDep = this.getDependencyDef("Target");
        }
        return this.targetDep;
    }

    @objid ("536baab1-dae7-46db-9b35-74dcabb23354")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("e795a442-7b92-4e69-b212-79986facf6aa")
    private static class UseCaseDependencyObjectFactory implements ISmObjectFactory {
        @objid ("1953d15c-b58b-47bf-b8fa-ddeb581ceb5e")
        private UseCaseDependencySmClass smClass;

        @objid ("db6ccfd6-67f6-40c1-802d-235f749c26b0")
        public UseCaseDependencyObjectFactory(UseCaseDependencySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("0e5b2d4a-e929-4a61-9cb6-212975ad5925")
        @Override
        public ISmObjectData createData() {
            return new UseCaseDependencyData(this.smClass);
        }

        @objid ("f962933d-ef66-4ee9-88b5-dbc2d1b2d0cf")
        @Override
        public SmObjectImpl createImpl() {
            return new UseCaseDependencyImpl();
        }

    }

    @objid ("c6404859-d9a0-4e98-b3ca-8bc4f656db68")
    public static class OriginSmDependency extends SmSingleDependency {
        @objid ("0b51ca9c-7903-4b04-a76e-6ffc659f175d")
        private SmDependency symetricDep;

        @objid ("f4aa8b09-6d94-489c-bf17-7223902adf70")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((UseCaseDependencyData) data).mOrigin;
        }

        @objid ("20e0ef95-41f5-415e-b9c7-891305221874")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((UseCaseDependencyData) data).mOrigin = value;
        }

        @objid ("18ba0929-fc6a-44c7-91d1-79b1d023e62d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UseCaseSmClass)this.getTarget()).getUsedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("aa39cc73-77c4-449e-aa30-cfb993b2c60b")
    public static class ExtensionLocationSmDependency extends SmMultipleDependency {
        @objid ("0f24ccd3-32a6-479b-95ff-b480334da504")
        private SmDependency symetricDep;

        @objid ("8946d8d7-596a-4294-858c-8dfd3d88446d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((UseCaseDependencyData)data).mExtensionLocation != null)? ((UseCaseDependencyData)data).mExtensionLocation:SmMultipleDependency.EMPTY;
        }

        @objid ("537ae90d-3317-40e2-9b5a-baae991d8817")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((UseCaseDependencyData) data).mExtensionLocation = values;

        }

        @objid ("98d478fd-8500-4a42-802e-89eb09cd5816")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExtensionPointSmClass)this.getTarget()).getExtendedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("92a1bca4-bf13-4346-b01d-0d2ef036f44b")
    public static class TargetSmDependency extends SmSingleDependency {
        @objid ("295781da-1e01-4c31-87c3-525e92c0d6f4")
        private SmDependency symetricDep;

        @objid ("29877075-44b6-43fa-a39a-e5c19f07986c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((UseCaseDependencyData) data).mTarget;
        }

        @objid ("33bfde3a-c663-42d4-8ae0-c477be73ba02")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((UseCaseDependencyData) data).mTarget = value;
        }

        @objid ("0e8ef09d-535b-4af2-b53a-cd8d1e709d56")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UseCaseSmClass)this.getTarget()).getUserDep();
            }
            return this.symetricDep;

        }

    }

}
