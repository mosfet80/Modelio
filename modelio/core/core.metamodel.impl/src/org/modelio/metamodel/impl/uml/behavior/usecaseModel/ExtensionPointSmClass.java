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
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("d143432c-5f40-490c-83b4-207d0eaa677e")
public class ExtensionPointSmClass extends UmlModelElementSmClass {
    @objid ("e6173973-acc4-45c5-9abf-6c24bf8f9a8a")
    private SmAttribute visibilityAtt;

    @objid ("21a7faac-5a90-4311-bde0-b40740d38c42")
    private SmDependency extendedDep;

    @objid ("c4768f09-ee2c-4e6b-ae7b-a2bcca037c88")
    private SmDependency ownerDep;

    @objid ("7515eb50-6c8f-4a5b-bf09-6b1bf0fb28d1")
    public ExtensionPointSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0d356030-cbb6-423e-beef-08513422331a")
    @Override
    public String getName() {
        return "ExtensionPoint";

    }

    @objid ("e270e4fc-e59f-40a6-b684-33affc5eab2f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("805bb73e-84ee-490b-96d7-6ac61bd34b25")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExtensionPoint.class;

    }

    @objid ("a3affd00-ef27-423c-b3a9-c31c49f0db16")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5955a851-bde8-4a70-8b4d-5d8a79d3f33f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ec858d46-b190-4d34-94e4-36a82aae77a6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ExtensionPointObjectFactory(this));


        // Initialize and register the SmAttribute
        this.visibilityAtt = new VisibilitySmAttribute();
        this.visibilityAtt.init("Visibility", this, VisibilityMode.class );
        registerAttribute(this.visibilityAtt);


        // Initialize and register the SmDependency
        this.extendedDep = new ExtendedSmDependency();
        this.extendedDep.init("Extended", this, metamodel.getMClass(UseCaseDependency.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC, SmDirective.SMCDTODELETE);
        registerDependency(this.extendedDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(UseCase.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

    }

    @objid ("d8d25b4c-bb46-481f-b6cd-473e15c1abd8")
    public SmAttribute getVisibilityAtt() {
        if (this.visibilityAtt == null) {
        	this.visibilityAtt = this.getAttributeDef("Visibility");
        }
        return this.visibilityAtt;
    }

    @objid ("c5ef56e1-6b81-4052-8048-49495f3d8490")
    public SmDependency getExtendedDep() {
        if (this.extendedDep == null) {
        	this.extendedDep = this.getDependencyDef("Extended");
        }
        return this.extendedDep;
    }

    @objid ("9720ad90-91ff-49e9-a3b4-20eefc50e494")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("5e728a90-f5ed-43a3-951c-b5541f190dfe")
    private static class ExtensionPointObjectFactory implements ISmObjectFactory {
        @objid ("090edc2c-1010-45b6-8c67-cd07650e12db")
        private ExtensionPointSmClass smClass;

        @objid ("459a0e07-1b54-4aad-94d5-bead92d21163")
        public ExtensionPointObjectFactory(ExtensionPointSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("50102bc0-250e-4d3e-89f3-d547d5fab87d")
        @Override
        public ISmObjectData createData() {
            return new ExtensionPointData(this.smClass);
        }

        @objid ("dc80b697-102e-48ea-bfce-33b3a6a86772")
        @Override
        public SmObjectImpl createImpl() {
            return new ExtensionPointImpl();
        }

    }

    @objid ("36c7ac66-dd43-458c-82a1-a44a3aaff364")
    public static class VisibilitySmAttribute extends SmAttribute {
        @objid ("d4741365-4d2f-4b31-bd83-0fc07f616f43")
        public Object getValue(ISmObjectData data) {
            return ((ExtensionPointData) data).mVisibility;
        }

        @objid ("1ba2b83e-4f41-4311-86ca-30d934c2dfa7")
        public void setValue(ISmObjectData data, Object value) {
            ((ExtensionPointData) data).mVisibility = value;
        }

    }

    @objid ("0af8e61b-0782-4b7c-b0c2-2044fbe050a7")
    public static class ExtendedSmDependency extends SmMultipleDependency {
        @objid ("45d04f77-f5a1-4ce4-84c3-4b067f158955")
        private SmDependency symetricDep;

        @objid ("5c796528-968c-45da-9950-4079aa7db2cb")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ExtensionPointData)data).mExtended != null)? ((ExtensionPointData)data).mExtended:SmMultipleDependency.EMPTY;
        }

        @objid ("d2a1fd99-6822-40b1-b30a-973c1d81175c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ExtensionPointData) data).mExtended = values;

        }

        @objid ("827cab6a-59a4-4219-a0f5-14e83cd3913a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UseCaseDependencySmClass)this.getTarget()).getExtensionLocationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7dc9e31b-4ffc-4779-ae31-d80f598cc538")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("6fce45e1-e2c7-43aa-88aa-ef8b15467820")
        private SmDependency symetricDep;

        @objid ("5380af79-6a2d-4ff0-b365-d1f303a3282f")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExtensionPointData) data).mOwner;
        }

        @objid ("ac43cc9c-2774-436d-9e82-5f74df7c2a66")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExtensionPointData) data).mOwner = value;
        }

        @objid ("baafd522-fef1-467e-ac70-5e2889254458")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UseCaseSmClass)this.getTarget()).getOwnedExtensionDep();
            }
            return this.symetricDep;

        }

    }

}
