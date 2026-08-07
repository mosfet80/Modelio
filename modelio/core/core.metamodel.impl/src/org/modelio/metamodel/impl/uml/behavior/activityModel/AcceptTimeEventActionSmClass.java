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
import org.modelio.metamodel.uml.behavior.activityModel.AcceptTimeEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("8b1ab55a-2157-409c-a06d-4cc0df8ca847")
public class AcceptTimeEventActionSmClass extends ActivityActionSmClass {
    @objid ("6c90dae4-75be-4b42-98c3-adfa62a6bd55")
    private SmAttribute timeExpresionAtt;

    @objid ("a2ed2476-49de-468d-84b1-2e7b562c5e89")
    public AcceptTimeEventActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5dff42f1-06fb-4b8f-9c46-439e6c137cb5")
    @Override
    public String getName() {
        return "AcceptTimeEventAction";

    }

    @objid ("5ecbe511-d169-4c2e-97df-7697b985c126")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e5f67323-0f8a-462a-a4d8-7c4a315efe9b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AcceptTimeEventAction.class;

    }

    @objid ("fb4680c2-81cb-4235-9453-53741c05172f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("dbee8519-9c05-4903-a272-34be09c4b7f5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("3a2b5d51-1e24-410f-a02b-fc42d7514078")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new AcceptTimeEventActionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.timeExpresionAtt = new TimeExpresionSmAttribute();
        this.timeExpresionAtt.init("TimeExpresion", this, String.class );
        registerAttribute(this.timeExpresionAtt);


        // Initialize and register the SmDependency

    }

    @objid ("52499f38-8cdb-4118-953e-a1de1dc94aae")
    public SmAttribute getTimeExpresionAtt() {
        if (this.timeExpresionAtt == null) {
        	this.timeExpresionAtt = this.getAttributeDef("TimeExpresion");
        }
        return this.timeExpresionAtt;
    }

    @objid ("56dada45-3dc6-4d56-962b-9749f84b86b4")
    private static class AcceptTimeEventActionObjectFactory implements ISmObjectFactory {
        @objid ("89fa82be-a4d4-4f9b-b48d-b09c892f16bd")
        private AcceptTimeEventActionSmClass smClass;

        @objid ("c8edfaa7-b4f7-471b-b014-a57072e45fa7")
        public AcceptTimeEventActionObjectFactory(AcceptTimeEventActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("430aaed3-ee6a-40bb-aecf-f842a8f4e340")
        @Override
        public ISmObjectData createData() {
            return new AcceptTimeEventActionData(this.smClass);
        }

        @objid ("498377e6-f94b-4adb-9f47-fdc28da8a7af")
        @Override
        public SmObjectImpl createImpl() {
            return new AcceptTimeEventActionImpl();
        }

    }

    @objid ("b8697550-142a-40a1-9c1f-24989a4620fb")
    public static class TimeExpresionSmAttribute extends SmAttribute {
        @objid ("bca7b89a-7848-4d09-add5-276934bd4fdf")
        public Object getValue(ISmObjectData data) {
            return ((AcceptTimeEventActionData) data).mTimeExpresion;
        }

        @objid ("49df286a-333d-4e04-b032-d6b68c975f9d")
        public void setValue(ISmObjectData data, Object value) {
            ((AcceptTimeEventActionData) data).mTimeExpresion = value;
        }

    }

}
