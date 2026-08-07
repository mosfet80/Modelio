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
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.GeneralClass;
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

@objid ("06b8d248-fc77-499d-a7d8-11fed357827c")
public class ClassSmClass extends GeneralClassSmClass {
    @objid ("48cc2e81-2bf1-4f12-8f7e-e85d847293e8")
    private SmAttribute isActiveAtt;

    @objid ("fca0a583-b7d9-405c-9e5a-5f52d15121c0")
    private SmAttribute isMainAtt;

    @objid ("614dc243-454e-457b-9a4b-0364fe657a2e")
    private SmDependency linkToAssociationDep;

    @objid ("089d5f05-4308-4fac-a506-90280c529e8c")
    public ClassSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("3d7cbfcc-21e7-494f-8a0f-9f00fd9e3cdd")
    @Override
    public String getName() {
        return "Class";

    }

    @objid ("61d57c27-c40e-42c8-a785-2413df10ab97")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0f1aeac5-aa32-44ed-bd10-669d9ff4a5e7")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Class.class;

    }

    @objid ("8b088480-72a4-420b-960c-65684f209c34")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("0490b2d8-cb75-4204-94f9-9e08fc43182b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0bd8ce6e-35b6-4248-af96-d8232751eb2c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new ClassObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isActiveAtt = new IsActiveSmAttribute();
        this.isActiveAtt.init("IsActive", this, Boolean.class );
        registerAttribute(this.isActiveAtt);

        this.isMainAtt = new IsMainSmAttribute();
        this.isMainAtt.init("IsMain", this, Boolean.class );
        registerAttribute(this.isMainAtt);


        // Initialize and register the SmDependency
        this.linkToAssociationDep = new LinkToAssociationSmDependency();
        this.linkToAssociationDep.init("LinkToAssociation", this, metamodel.getMClass(ClassAssociation.MQNAME), 0, 1 , SmDirective.SMCDTODELETE);
        registerDependency(this.linkToAssociationDep);

    }

    @objid ("3b60550c-ac34-44ee-9e7b-8563866c549a")
    public SmAttribute getIsActiveAtt() {
        if (this.isActiveAtt == null) {
        	this.isActiveAtt = this.getAttributeDef("IsActive");
        }
        return this.isActiveAtt;
    }

    @objid ("b0e40548-fcb1-4779-970b-23a3e49b6d09")
    public SmAttribute getIsMainAtt() {
        if (this.isMainAtt == null) {
        	this.isMainAtt = this.getAttributeDef("IsMain");
        }
        return this.isMainAtt;
    }

    @objid ("9421f232-fef7-4f97-acf4-e79f5ccdb32d")
    public SmDependency getLinkToAssociationDep() {
        if (this.linkToAssociationDep == null) {
        	this.linkToAssociationDep = this.getDependencyDef("LinkToAssociation");
        }
        return this.linkToAssociationDep;
    }

    @objid ("f7fc0235-b412-49fe-94fd-ee66ca3d024f")
    private static class ClassObjectFactory implements ISmObjectFactory {
        @objid ("f04470b2-7e4b-428c-81ba-d60fd5c2173f")
        private ClassSmClass smClass;

        @objid ("a7d66c1d-97a8-4881-a730-d2d1b06ed26b")
        public ClassObjectFactory(ClassSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ad12de45-c008-4a2c-a4ef-2a941d426d1d")
        @Override
        public ISmObjectData createData() {
            return new ClassData(this.smClass);
        }

        @objid ("be1fcf49-af56-40b5-9d7b-cf8182213ec4")
        @Override
        public SmObjectImpl createImpl() {
            return new ClassImpl();
        }

    }

    @objid ("4feef9f9-689e-4286-8c99-f7e188ca3ed1")
    public static class IsActiveSmAttribute extends SmAttribute {
        @objid ("fd12c8b9-7f54-4f57-a5e6-4b70fa7fa135")
        public Object getValue(ISmObjectData data) {
            return ((ClassData) data).mIsActive;
        }

        @objid ("6fb48e2c-812a-4b34-abfc-af3c88778ab3")
        public void setValue(ISmObjectData data, Object value) {
            ((ClassData) data).mIsActive = value;
        }

    }

    @objid ("5e111d48-f336-48c7-ad25-55e5b7752e73")
    public static class IsMainSmAttribute extends SmAttribute {
        @objid ("d4f90e88-e412-4cde-89e4-5a9c0ab8f42f")
        public Object getValue(ISmObjectData data) {
            return ((ClassData) data).mIsMain;
        }

        @objid ("d15c0fc8-29b4-4814-9868-41c75ea66ccc")
        public void setValue(ISmObjectData data, Object value) {
            ((ClassData) data).mIsMain = value;
        }

    }

    @objid ("a0a8a5d1-dca9-4c85-b146-52b422e659a5")
    public static class LinkToAssociationSmDependency extends SmSingleDependency {
        @objid ("bc974244-6cfc-43e1-8018-0fb5c26caffd")
        private SmDependency symetricDep;

        @objid ("d858dbfe-322e-4fd7-a7f6-97fb5671b3a6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ClassData) data).mLinkToAssociation;
        }

        @objid ("cef336fb-bb8b-4f24-9ce0-572e21562ac2")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ClassData) data).mLinkToAssociation = value;
        }

        @objid ("47095974-564e-4f77-95ef-1b90cf3d0fd3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassAssociationSmClass)this.getTarget()).getClassPartDep();
            }
            return this.symetricDep;

        }

    }

}
