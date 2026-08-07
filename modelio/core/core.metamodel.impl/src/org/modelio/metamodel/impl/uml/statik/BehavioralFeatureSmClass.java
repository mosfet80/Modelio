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
import org.modelio.metamodel.uml.statik.BehavioralFeature;
import org.modelio.metamodel.uml.statik.Feature;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("91104596-96f5-4349-af9b-a9f073e341b1")
public class BehavioralFeatureSmClass extends FeatureSmClass {
    @objid ("59ab7c76-8358-4c8e-b1f6-1302194a4f60")
    public BehavioralFeatureSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6c6f8a18-b4ca-4b0c-9af2-d8a7a9d411ce")
    @Override
    public String getName() {
        return "BehavioralFeature";

    }

    @objid ("3d7b5f82-4f06-446b-83c3-5b97274ad5b6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f3235b19-c457-4e9d-967c-e28448296c4a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BehavioralFeature.class;

    }

    @objid ("29a67ce1-da9c-45fd-8256-41ab7111071f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6e74d827-5f6c-4909-8003-1813ae252994")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("768aa701-e225-4fe9-9284-e2a13782c175")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Feature.MQNAME);
        this.registerFactory(new BehavioralFeatureObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a50b7489-6d70-4547-a4a7-7c314167f60d")
    private static class BehavioralFeatureObjectFactory implements ISmObjectFactory {
        @objid ("675c1ee5-c547-4597-a36f-43828a24e068")
        private BehavioralFeatureSmClass smClass;

        @objid ("7572d6a6-f089-4fce-a3d0-c803bcbe4d12")
        public BehavioralFeatureObjectFactory(BehavioralFeatureSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c4c9a898-7129-4671-a809-ccac0af000ef")
        @Override
        public ISmObjectData createData() {
            return new BehavioralFeatureData(this.smClass);
        }

        @objid ("32add297-0cc4-43ba-84c2-2ff8a57f1113")
        @Override
        public SmObjectImpl createImpl() {
            return new BehavioralFeatureImpl();
        }

    }

}
