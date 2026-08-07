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
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociation;
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

@objid ("0534b2ae-67e6-4bca-8aef-baaef28233e1")
public class ClassAssociationSmClass extends UmlModelElementSmClass {
    @objid ("4bc1f0b0-b9c9-4062-9682-8c4b8fa33abe")
    private SmDependency naryAssociationPartDep;

    @objid ("aa124bcd-1029-4eff-9be8-f2081ea52900")
    private SmDependency classPartDep;

    @objid ("f71768a3-28e4-4d2f-a479-d20a9abecc3c")
    private SmDependency associationPartDep;

    @objid ("107b878c-b65a-49af-88b5-6e57f8b098a4")
    public ClassAssociationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f4e3be0e-892f-4c31-96f3-50c632b73493")
    @Override
    public String getName() {
        return "ClassAssociation";

    }

    @objid ("8a81a517-a42d-4b46-bdd0-dd41d1e4212c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("b1ad1214-5348-4c02-ad49-be29131300a6")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ClassAssociation.class;

    }

    @objid ("3364afc4-9bd8-4ebc-8f70-5cb4ae16e40f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("8b1b68fa-8030-4e13-91e5-bcdbfccb6e4f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0826868f-7486-4234-a19f-0c4a993eef4f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ClassAssociationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.naryAssociationPartDep = new NaryAssociationPartSmDependency();
        this.naryAssociationPartDep.init("NaryAssociationPart", this, metamodel.getMClass(NaryAssociation.MQNAME), 0, 1 );
        registerDependency(this.naryAssociationPartDep);

        this.classPartDep = new ClassPartSmDependency();
        this.classPartDep.init("ClassPart", this, metamodel.getMClass(Class.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.classPartDep);

        this.associationPartDep = new AssociationPartSmDependency();
        this.associationPartDep.init("AssociationPart", this, metamodel.getMClass(Association.MQNAME), 0, 1 );
        registerDependency(this.associationPartDep);

    }

    @objid ("582befd7-519e-4eef-9081-0bfb1434d60b")
    public SmDependency getNaryAssociationPartDep() {
        if (this.naryAssociationPartDep == null) {
        	this.naryAssociationPartDep = this.getDependencyDef("NaryAssociationPart");
        }
        return this.naryAssociationPartDep;
    }

    @objid ("5e89eeaa-0330-47fc-b8f3-cb2868ea7bc1")
    public SmDependency getClassPartDep() {
        if (this.classPartDep == null) {
        	this.classPartDep = this.getDependencyDef("ClassPart");
        }
        return this.classPartDep;
    }

    @objid ("5a7f4b4a-1be8-416a-bdc6-2fe58b7dd72a")
    public SmDependency getAssociationPartDep() {
        if (this.associationPartDep == null) {
        	this.associationPartDep = this.getDependencyDef("AssociationPart");
        }
        return this.associationPartDep;
    }

    @objid ("fcdbfec2-c6d9-4b5b-a21c-509dcada5f94")
    private static class ClassAssociationObjectFactory implements ISmObjectFactory {
        @objid ("bd103bff-7f0c-41a6-be2e-634dc8d37d60")
        private ClassAssociationSmClass smClass;

        @objid ("851141c6-1e10-4182-b97b-7662d08c5630")
        public ClassAssociationObjectFactory(ClassAssociationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("eca67315-59dd-4f3c-9d2f-ab2d752b2f17")
        @Override
        public ISmObjectData createData() {
            return new ClassAssociationData(this.smClass);
        }

        @objid ("3839b937-e947-4345-b7e8-c420d0636004")
        @Override
        public SmObjectImpl createImpl() {
            return new ClassAssociationImpl();
        }

    }

    @objid ("09a56318-009a-4046-b7aa-b3d7d27e1070")
    public static class NaryAssociationPartSmDependency extends SmSingleDependency {
        @objid ("e47bd03c-5365-4bfb-acd8-b2e56d18b1c0")
        private SmDependency symetricDep;

        @objid ("72a3ca55-5aee-4612-87ee-5d5e37860bf5")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ClassAssociationData) data).mNaryAssociationPart;
        }

        @objid ("bcf7c134-8eae-4e90-992a-6b3427270e23")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ClassAssociationData) data).mNaryAssociationPart = value;
        }

        @objid ("f75b39c2-feb3-4eae-88df-7ac529b8b46c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryAssociationSmClass)this.getTarget()).getLinkToClassDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("db401142-043b-46ce-93f1-650f07f4cde8")
    public static class ClassPartSmDependency extends SmSingleDependency {
        @objid ("3d562350-7984-4818-9992-1678239f7b21")
        private SmDependency symetricDep;

        @objid ("10151ef2-b701-43c7-8db1-65884b8fb300")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ClassAssociationData) data).mClassPart;
        }

        @objid ("ad8f5674-10c0-4386-bdf0-cb153169f475")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ClassAssociationData) data).mClassPart = value;
        }

        @objid ("d7b9a024-8a6b-4e6c-9f53-5a340ff2c4d1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassSmClass)this.getTarget()).getLinkToAssociationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("df2b7335-0752-4be1-8743-9146a96beea4")
    public static class AssociationPartSmDependency extends SmSingleDependency {
        @objid ("61c90dba-a0ca-40d2-bd84-1bc98d74d18d")
        private SmDependency symetricDep;

        @objid ("a2d5daf9-101c-4e83-8166-4405d643ca7e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ClassAssociationData) data).mAssociationPart;
        }

        @objid ("ec900388-17d0-4854-a139-56e02c47c42c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ClassAssociationData) data).mAssociationPart = value;
        }

        @objid ("5c2c3200-c608-48b2-ac08-7f9121abfc57")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationSmClass)this.getTarget()).getLinkToClassDep();
            }
            return this.symetricDep;

        }

    }

}
