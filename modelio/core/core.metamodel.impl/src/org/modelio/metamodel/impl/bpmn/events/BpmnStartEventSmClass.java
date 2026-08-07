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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnStartEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("d8593693-2159-4274-8e12-551d7ff986fd")
public class BpmnStartEventSmClass extends BpmnCatchEventSmClass {
    @objid ("094111be-80ab-438c-91e1-2a3edc2ebc2f")
    private SmAttribute isInterruptingAtt;

    @objid ("a3cc38ff-9010-4d88-9041-628a309499da")
    public BpmnStartEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("78cb6cf3-eb47-441e-89c0-21021b22d0a9")
    @Override
    public String getName() {
        return "BpmnStartEvent";

    }

    @objid ("cdc45ed7-20c4-4765-b73a-f6ba4ed2e186")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("007d1202-16f8-4922-8177-805ef191ad5b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnStartEvent.class;

    }

    @objid ("e43bc76e-253c-445e-955a-053a0f12545c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0a86c064-5838-454e-a02d-2ad6a0cce57a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("49206376-5ce4-469c-a44f-a3d2f3942917")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnCatchEvent.MQNAME);
        this.registerFactory(new BpmnStartEventObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isInterruptingAtt = new IsInterruptingSmAttribute();
        this.isInterruptingAtt.init("IsInterrupting", this, Boolean.class );
        registerAttribute(this.isInterruptingAtt);


        // Initialize and register the SmDependency

    }

    @objid ("5d49bb32-3aac-4fe6-b8d3-e5e808b69b47")
    public SmAttribute getIsInterruptingAtt() {
        if (this.isInterruptingAtt == null) {
        	this.isInterruptingAtt = this.getAttributeDef("IsInterrupting");
        }
        return this.isInterruptingAtt;
    }

    @objid ("b7ca2912-1096-4a2c-9a5c-4915b415019c")
    private static class BpmnStartEventObjectFactory implements ISmObjectFactory {
        @objid ("f220ff6c-da48-4252-9f28-e40535a08168")
        private BpmnStartEventSmClass smClass;

        @objid ("4efe95b0-5763-43e8-908f-deb584b474f5")
        public BpmnStartEventObjectFactory(BpmnStartEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b6e59138-1de0-4e72-ad6f-be42c43ce6b0")
        @Override
        public ISmObjectData createData() {
            return new BpmnStartEventData(this.smClass);
        }

        @objid ("6306795e-a289-42cd-99d9-68dc51fb6fdd")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnStartEventImpl();
        }

    }

    @objid ("7572cc1d-4472-4920-88fe-292e3552e75f")
    public static class IsInterruptingSmAttribute extends SmAttribute {
        @objid ("fc33d455-72d7-42a5-91f1-3b551d5c88bd")
        public Object getValue(ISmObjectData data) {
            return ((BpmnStartEventData) data).mIsInterrupting;
        }

        @objid ("c1bceb19-8b80-44cd-bcd1-a4bb4f18cc16")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnStartEventData) data).mIsInterrupting = value;
        }

    }

}
