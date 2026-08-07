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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("aacebf16-44ba-45c9-b3f5-a9fd972dba6f")
public class ConstraintSmClass extends UmlModelElementSmClass {
    @objid ("fb7f14ec-0ff8-4faf-a6b4-85942c455e57")
    private SmAttribute baseClassAtt;

    @objid ("bd7921ac-5019-49d4-840c-5a407667ea5a")
    private SmAttribute bodyAtt;

    @objid ("05c18179-a875-495c-b724-edf54a95af12")
    private SmAttribute languageAtt;

    @objid ("154a3379-97b1-4c1e-9eee-19481d922fc1")
    private SmDependency constrainedElementDep;

    @objid ("6885755b-b413-4dfc-b8a7-2a5754806384")
    public ConstraintSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("82011d67-d879-4c6d-a652-775ee10f9ea7")
    @Override
    public String getName() {
        return "Constraint";

    }

    @objid ("838072a8-0c6c-434a-a594-4ea722868eac")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("4f3de59c-6100-4143-83c5-8631bfd45f21")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Constraint.class;

    }

    @objid ("7256100b-b364-4267-a5f2-403fb10f7b79")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("753811fd-3e9b-470f-b630-90f52cfe46c4")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("34aa6956-7a06-4cf8-8fcb-523a939483e2")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ConstraintObjectFactory(this));


        // Initialize and register the SmAttribute
        this.baseClassAtt = new BaseClassSmAttribute();
        this.baseClassAtt.init("BaseClass", this, String.class );
        registerAttribute(this.baseClassAtt);

        this.bodyAtt = new BodySmAttribute();
        this.bodyAtt.init("Body", this, String.class );
        registerAttribute(this.bodyAtt);

        this.languageAtt = new LanguageSmAttribute();
        this.languageAtt.init("Language", this, String.class );
        registerAttribute(this.languageAtt);


        // Initialize and register the SmDependency
        this.constrainedElementDep = new ConstrainedElementSmDependency();
        this.constrainedElementDep.init("ConstrainedElement", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.constrainedElementDep);

    }

    @objid ("5ea7faea-3a43-46f3-80bc-2b1c6b461382")
    public SmAttribute getBaseClassAtt() {
        if (this.baseClassAtt == null) {
        	this.baseClassAtt = this.getAttributeDef("BaseClass");
        }
        return this.baseClassAtt;
    }

    @objid ("5c987028-c8da-46c0-b1d6-2247748310a1")
    public SmAttribute getBodyAtt() {
        if (this.bodyAtt == null) {
        	this.bodyAtt = this.getAttributeDef("Body");
        }
        return this.bodyAtt;
    }

    @objid ("a49d5fc0-62ac-4edd-a9fb-4adc8e8e5363")
    public SmAttribute getLanguageAtt() {
        if (this.languageAtt == null) {
        	this.languageAtt = this.getAttributeDef("Language");
        }
        return this.languageAtt;
    }

    @objid ("7de210e3-a852-40f7-96e4-17e11a657cb1")
    public SmDependency getConstrainedElementDep() {
        if (this.constrainedElementDep == null) {
        	this.constrainedElementDep = this.getDependencyDef("ConstrainedElement");
        }
        return this.constrainedElementDep;
    }

    @objid ("72c513e4-ec83-4c95-96bc-3942b7bed3e6")
    private static class ConstraintObjectFactory implements ISmObjectFactory {
        @objid ("2a7349d8-93c8-4f83-ae71-45e8f82d33f0")
        private ConstraintSmClass smClass;

        @objid ("cccb59fc-1740-43f9-a25c-bda006d5245e")
        public ConstraintObjectFactory(ConstraintSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("86a7e2a4-f274-461b-9a46-fc3afe927979")
        @Override
        public ISmObjectData createData() {
            return new ConstraintData(this.smClass);
        }

        @objid ("1453dcf4-633f-4452-9e01-546353507b2c")
        @Override
        public SmObjectImpl createImpl() {
            return new ConstraintImpl();
        }

    }

    @objid ("0e4e0a11-8676-4f76-b989-d2044060e69a")
    public static class BaseClassSmAttribute extends SmAttribute {
        @objid ("ca435fba-00b3-4ad2-9c88-5344c14e4402")
        public Object getValue(ISmObjectData data) {
            return ((ConstraintData) data).mBaseClass;
        }

        @objid ("bfda8723-fe60-4cf0-b480-facf6e9a1b26")
        public void setValue(ISmObjectData data, Object value) {
            ((ConstraintData) data).mBaseClass = value;
        }

    }

    @objid ("972c98a9-69cd-42e7-ace3-64d6004c616b")
    public static class BodySmAttribute extends SmAttribute {
        @objid ("3d5455c7-641f-4fa5-b16a-a63515392d35")
        public Object getValue(ISmObjectData data) {
            return ((ConstraintData) data).mBody;
        }

        @objid ("38ad7f12-ad62-4235-950f-25f1ed204aff")
        public void setValue(ISmObjectData data, Object value) {
            ((ConstraintData) data).mBody = value;
        }

    }

    @objid ("71973d15-d883-4d44-a764-5b961e8afe7e")
    public static class LanguageSmAttribute extends SmAttribute {
        @objid ("8b9d8b9d-390c-4506-adc0-1f32696d2a66")
        public Object getValue(ISmObjectData data) {
            return ((ConstraintData) data).mLanguage;
        }

        @objid ("9de1ffc3-fa87-4bc4-ad75-f7c26286a74d")
        public void setValue(ISmObjectData data, Object value) {
            ((ConstraintData) data).mLanguage = value;
        }

    }

    @objid ("a1efa7f4-6240-485c-b7e3-cb1d1c2f3473")
    public static class ConstrainedElementSmDependency extends SmMultipleDependency {
        @objid ("a37efde0-fabb-49b0-b49a-dede25f6e7c9")
        private SmDependency symetricDep;

        @objid ("d9871503-fcae-4cfd-944c-de25bb1181aa")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ConstraintData)data).mConstrainedElement != null)? ((ConstraintData)data).mConstrainedElement:SmMultipleDependency.EMPTY;
        }

        @objid ("80f574b8-150d-4f3b-b940-7a58ca97d8d1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ConstraintData) data).mConstrainedElement = values;

        }

        @objid ("a6385b88-af55-4808-8983-acc8b124857d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getConstraintDefinitionDep();
            }
            return this.symetricDep;

        }

    }

}
