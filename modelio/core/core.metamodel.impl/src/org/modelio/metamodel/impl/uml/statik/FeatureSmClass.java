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
import org.modelio.metamodel.uml.statik.Feature;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("13761dd9-9bc8-4c3f-a387-24f38b54c85e")
public class FeatureSmClass extends UmlModelElementSmClass {
    @objid ("4c1fbb49-49ea-4af0-b2c0-002742b8f30a")
    private SmAttribute visibilityAtt;

    @objid ("7354491d-678a-4acf-ae30-7e5091fea5e8")
    private SmAttribute isClassAtt;

    @objid ("869e86c1-135e-4527-a720-4b0daaadfe73")
    private SmAttribute isAbstractAtt;

    @objid ("358aa7f5-a8ee-4208-bca7-c4d363a7afe3")
    public FeatureSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6b4ea864-ae40-4fb9-bfd9-75859b5b6c67")
    @Override
    public String getName() {
        return "Feature";

    }

    @objid ("52b75dcd-4dac-424c-8538-70980d5af108")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("98c42445-c41b-4a9f-9426-d5b354234d88")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Feature.class;

    }

    @objid ("b0777148-acdf-4160-9717-a2852cd7029a")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("fe3ca43e-0efa-43a9-82b9-a06445865914")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("8c997680-bd2b-4628-ab2e-ea9bf82ab269")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new FeatureObjectFactory(this));


        // Initialize and register the SmAttribute
        this.visibilityAtt = new VisibilitySmAttribute();
        this.visibilityAtt.init("Visibility", this, VisibilityMode.class );
        registerAttribute(this.visibilityAtt);

        this.isClassAtt = new IsClassSmAttribute();
        this.isClassAtt.init("IsClass", this, Boolean.class );
        registerAttribute(this.isClassAtt);

        this.isAbstractAtt = new IsAbstractSmAttribute();
        this.isAbstractAtt.init("IsAbstract", this, Boolean.class );
        registerAttribute(this.isAbstractAtt);


        // Initialize and register the SmDependency

    }

    @objid ("a9c19a9a-5bc7-4c82-a8a6-bba9e3ddd9ba")
    public SmAttribute getVisibilityAtt() {
        if (this.visibilityAtt == null) {
        	this.visibilityAtt = this.getAttributeDef("Visibility");
        }
        return this.visibilityAtt;
    }

    @objid ("c2b1a2c7-7f67-4635-b3fa-d15ba7a259f2")
    public SmAttribute getIsClassAtt() {
        if (this.isClassAtt == null) {
        	this.isClassAtt = this.getAttributeDef("IsClass");
        }
        return this.isClassAtt;
    }

    @objid ("58f732a9-9fd1-494e-9d3f-2ad3d1c79f04")
    public SmAttribute getIsAbstractAtt() {
        if (this.isAbstractAtt == null) {
        	this.isAbstractAtt = this.getAttributeDef("IsAbstract");
        }
        return this.isAbstractAtt;
    }

    @objid ("b13141e1-fccc-40b7-82c4-9dedd2b9e651")
    private static class FeatureObjectFactory implements ISmObjectFactory {
        @objid ("d9e42bbf-687d-4d3c-8366-09a93dbef463")
        private FeatureSmClass smClass;

        @objid ("cac1082c-4593-4156-8e2f-3de2e3b5a505")
        public FeatureObjectFactory(FeatureSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3b9157bb-0491-4eb5-aace-a42440e30a8f")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("214ea29d-9261-4799-b410-ea7e2219c4bc")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("460bdf9f-498e-4579-b162-13a69df27b38")
    public static class VisibilitySmAttribute extends SmAttribute {
        @objid ("6e2adb5d-5a8d-40cc-b7b6-435d410966a0")
        public Object getValue(ISmObjectData data) {
            return ((FeatureData) data).mVisibility;
        }

        @objid ("7699f769-723f-4fec-bc5e-3dda9b1246e6")
        public void setValue(ISmObjectData data, Object value) {
            ((FeatureData) data).mVisibility = value;
        }

    }

    @objid ("2b9d64a2-d96d-41ae-8445-51ba590746bb")
    public static class IsClassSmAttribute extends SmAttribute {
        @objid ("7fa2a0b0-a90f-4b08-8642-2d88f8ef3d9b")
        public Object getValue(ISmObjectData data) {
            return ((FeatureData) data).mIsClass;
        }

        @objid ("65f168f5-012a-4a70-9cc6-24ac84546871")
        public void setValue(ISmObjectData data, Object value) {
            ((FeatureData) data).mIsClass = value;
        }

    }

    @objid ("2f8a2ec0-bab3-43cb-a646-6702d5ab16f3")
    public static class IsAbstractSmAttribute extends SmAttribute {
        @objid ("b7315494-be7c-4ad3-b9ba-79c14d389af3")
        public Object getValue(ISmObjectData data) {
            return ((FeatureData) data).mIsAbstract;
        }

        @objid ("a10ce933-be92-4779-abaf-ad410cc64fad")
        public void setValue(ISmObjectData data, Object value) {
            ((FeatureData) data).mIsAbstract = value;
        }

    }

}
