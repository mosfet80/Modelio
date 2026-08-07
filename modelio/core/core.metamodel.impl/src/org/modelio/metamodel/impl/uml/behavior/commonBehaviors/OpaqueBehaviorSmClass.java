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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.OpaqueBehavior;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c5216376-c086-4856-b16c-700f39c41c4d")
public class OpaqueBehaviorSmClass extends BehaviorSmClass {
    @objid ("627667fe-8efa-4590-a498-fa83353da117")
    private SmAttribute bodyAtt;

    @objid ("b26a505f-8584-4fa4-85ec-fc5cc760e11a")
    public OpaqueBehaviorSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a9872da1-1eaa-48c3-b89d-88335e333e7d")
    @Override
    public String getName() {
        return "OpaqueBehavior";

    }

    @objid ("67501727-e81d-40bc-907f-873e8e5caba5")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("b3a46c03-4529-484e-973c-d11941c56180")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return OpaqueBehavior.class;

    }

    @objid ("4e640fe8-f6e6-40b3-b761-ce346fcdb1dd")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("ae8ca4c8-70fd-4878-b109-1431c15021b6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("43282813-a678-4e7b-9b16-7e8da4f13381")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new OpaqueBehaviorObjectFactory(this));


        // Initialize and register the SmAttribute
        this.bodyAtt = new BodySmAttribute();
        this.bodyAtt.init("Body", this, String.class );
        registerAttribute(this.bodyAtt);


        // Initialize and register the SmDependency

    }

    @objid ("9e75555c-2ad2-4b89-bf8b-3ebdd592c70f")
    public SmAttribute getBodyAtt() {
        if (this.bodyAtt == null) {
        	this.bodyAtt = this.getAttributeDef("Body");
        }
        return this.bodyAtt;
    }

    @objid ("83203c78-6bf1-4e46-9788-30356058fa98")
    private static class OpaqueBehaviorObjectFactory implements ISmObjectFactory {
        @objid ("fe5c5b9b-7c7b-4981-ad5c-f0ba8652e9fb")
        private OpaqueBehaviorSmClass smClass;

        @objid ("80e2df2d-2016-48a5-9503-f54e19af66ce")
        public OpaqueBehaviorObjectFactory(OpaqueBehaviorSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("aeb5f8b0-1404-41f4-9c7e-6e97e312613f")
        @Override
        public ISmObjectData createData() {
            return new OpaqueBehaviorData(this.smClass);
        }

        @objid ("647a48d2-ffdc-4297-bf80-b7490bc847e4")
        @Override
        public SmObjectImpl createImpl() {
            return new OpaqueBehaviorImpl();
        }

    }

    @objid ("a674c3fa-a3eb-4a60-a350-e2c86cb9b91a")
    public static class BodySmAttribute extends SmAttribute {
        @objid ("18d3d0b1-7b04-4a4a-afe0-b00f9b55ec3b")
        public Object getValue(ISmObjectData data) {
            return ((OpaqueBehaviorData) data).mBody;
        }

        @objid ("21dfb00a-7d17-472e-8fc3-f6893546c1c3")
        public void setValue(ISmObjectData data, Object value) {
            ((OpaqueBehaviorData) data).mBody = value;
        }

    }

}
