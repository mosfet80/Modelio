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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.InputPin;
import org.modelio.metamodel.uml.behavior.activityModel.ValuePin;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("98107046-2d5a-42a3-b331-c129a966ac08")
public class ValuePinSmClass extends InputPinSmClass {
    @objid ("ed5afbc7-91cf-4dbb-acec-ad5a5165a5fe")
    private SmAttribute valueAtt;

    @objid ("81c7a882-3e1b-499c-af3e-01b6a9207cf3")
    public ValuePinSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("90be5c01-3bff-4ca8-83a6-f9983b88aed2")
    @Override
    public String getName() {
        return "ValuePin";

    }

    @objid ("fbc81eca-bb54-4fe7-8d3a-725adfa5cd65")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("9fedab29-908a-4f4a-ab4c-35e1eefb5654")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ValuePin.class;

    }

    @objid ("913906ae-2600-44b8-bdad-5ce3c3e73616")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("285dc85b-4e0f-4a2f-9250-b19656300eab")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e587b7f2-0623-4f12-b10b-b981e62df652")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InputPin.MQNAME);
        this.registerFactory(new ValuePinObjectFactory(this));


        // Initialize and register the SmAttribute
        this.valueAtt = new ValueSmAttribute();
        this.valueAtt.init("Value", this, String.class );
        registerAttribute(this.valueAtt);


        // Initialize and register the SmDependency

    }

    @objid ("d22f1279-0089-428f-890c-dcca486d47bf")
    public SmAttribute getValueAtt() {
        if (this.valueAtt == null) {
        	this.valueAtt = this.getAttributeDef("Value");
        }
        return this.valueAtt;
    }

    @objid ("7430f22a-c585-4726-b32d-6f1a6e36d27d")
    private static class ValuePinObjectFactory implements ISmObjectFactory {
        @objid ("78ce6632-1d47-41da-ab04-fdb220bb751e")
        private ValuePinSmClass smClass;

        @objid ("e944db54-4801-4f47-98bc-caba20356b39")
        public ValuePinObjectFactory(ValuePinSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ef27a8d3-4734-428e-a117-174b2b700efd")
        @Override
        public ISmObjectData createData() {
            return new ValuePinData(this.smClass);
        }

        @objid ("addeed39-6b89-4da5-8e0f-c20e9d1376b4")
        @Override
        public SmObjectImpl createImpl() {
            return new ValuePinImpl();
        }

    }

    @objid ("7d66b098-9f50-470d-b899-feb171527565")
    public static class ValueSmAttribute extends SmAttribute {
        @objid ("6941a0d8-a6f0-48c5-ba39-f1554d819f1c")
        public Object getValue(ISmObjectData data) {
            return ((ValuePinData) data).mValue;
        }

        @objid ("2d453059-0554-46f8-b0bd-0fa05f3ca15f")
        public void setValue(ISmObjectData data, Object value) {
            ((ValuePinData) data).mValue = value;
        }

    }

}
