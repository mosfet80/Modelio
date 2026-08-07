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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectFlow;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectFlowEffectKind;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("06e1a3c5-78c9-42ca-8c42-4aa06fd6eeb3")
public class ObjectFlowSmClass extends ActivityEdgeSmClass {
    @objid ("6b0952e7-1b35-4830-9c57-0f4f3da5265b")
    private SmAttribute transformationBehaviorAtt;

    @objid ("e3b3e772-1d9c-4852-aa2f-47b4553e3112")
    private SmAttribute selectionBehaviorAtt;

    @objid ("9b6185a8-2da3-4ca4-a7ba-a46e54df4a0d")
    private SmAttribute isMultiCastAtt;

    @objid ("a2b108fc-d079-4724-acd5-c493ab19c5fe")
    private SmAttribute isMultiReceiveAtt;

    @objid ("4298436f-5433-40af-96a6-d1f9d2075fe5")
    private SmAttribute effectAtt;

    @objid ("ebb3709b-1cef-4460-a726-916c269010a2")
    public ObjectFlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("beb0aad6-7338-47d5-931f-84bb32406292")
    @Override
    public String getName() {
        return "ObjectFlow";

    }

    @objid ("5bf7110b-e5c4-4a82-9325-663f42ea97cc")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("6c051f1d-f2cb-49a8-a119-ebd3e9161582")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ObjectFlow.class;

    }

    @objid ("07e97f95-5896-4936-8a98-7d7fe9993dfc")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("605678af-e2c4-49b3-8067-6511854a0999")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("08cdf9a0-6f74-457d-861e-30188a52e823")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityEdge.MQNAME);
        this.registerFactory(new ObjectFlowObjectFactory(this));


        // Initialize and register the SmAttribute
        this.transformationBehaviorAtt = new TransformationBehaviorSmAttribute();
        this.transformationBehaviorAtt.init("TransformationBehavior", this, String.class );
        registerAttribute(this.transformationBehaviorAtt);

        this.selectionBehaviorAtt = new SelectionBehaviorSmAttribute();
        this.selectionBehaviorAtt.init("SelectionBehavior", this, String.class );
        registerAttribute(this.selectionBehaviorAtt);

        this.isMultiCastAtt = new IsMultiCastSmAttribute();
        this.isMultiCastAtt.init("IsMultiCast", this, Boolean.class );
        registerAttribute(this.isMultiCastAtt);

        this.isMultiReceiveAtt = new IsMultiReceiveSmAttribute();
        this.isMultiReceiveAtt.init("IsMultiReceive", this, Boolean.class );
        registerAttribute(this.isMultiReceiveAtt);

        this.effectAtt = new EffectSmAttribute();
        this.effectAtt.init("Effect", this, ObjectFlowEffectKind.class );
        registerAttribute(this.effectAtt);


        // Initialize and register the SmDependency

    }

    @objid ("0c76e64a-b3b2-49a8-bc9a-4c9a1d4d7baf")
    public SmAttribute getTransformationBehaviorAtt() {
        if (this.transformationBehaviorAtt == null) {
        	this.transformationBehaviorAtt = this.getAttributeDef("TransformationBehavior");
        }
        return this.transformationBehaviorAtt;
    }

    @objid ("0c9846d1-3f7e-489d-9492-bfa5425c98ec")
    public SmAttribute getSelectionBehaviorAtt() {
        if (this.selectionBehaviorAtt == null) {
        	this.selectionBehaviorAtt = this.getAttributeDef("SelectionBehavior");
        }
        return this.selectionBehaviorAtt;
    }

    @objid ("fa1d0433-3907-4ce2-8dab-dda59ac992d9")
    public SmAttribute getIsMultiCastAtt() {
        if (this.isMultiCastAtt == null) {
        	this.isMultiCastAtt = this.getAttributeDef("IsMultiCast");
        }
        return this.isMultiCastAtt;
    }

    @objid ("a953219f-40a4-4450-bcf4-155e844aef68")
    public SmAttribute getIsMultiReceiveAtt() {
        if (this.isMultiReceiveAtt == null) {
        	this.isMultiReceiveAtt = this.getAttributeDef("IsMultiReceive");
        }
        return this.isMultiReceiveAtt;
    }

    @objid ("c7b5880d-7953-4252-a1c8-90205af199ff")
    public SmAttribute getEffectAtt() {
        if (this.effectAtt == null) {
        	this.effectAtt = this.getAttributeDef("Effect");
        }
        return this.effectAtt;
    }

    @objid ("ed3d163b-7d6b-48a6-bdf5-fff9b1d5707d")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("696306de-fafe-4647-992c-136c5db8e194")
    private static class ObjectFlowObjectFactory implements ISmObjectFactory {
        @objid ("63b91e09-be13-4f75-8e89-03f2586ee542")
        private ObjectFlowSmClass smClass;

        @objid ("018ff17d-b585-44c4-9e5f-648a11a986c8")
        public ObjectFlowObjectFactory(ObjectFlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("8019a3dc-79b8-48a8-bd9a-aec8b42688de")
        @Override
        public ISmObjectData createData() {
            return new ObjectFlowData(this.smClass);
        }

        @objid ("4fcd78b0-d2a6-4704-8f7f-01572d882d16")
        @Override
        public SmObjectImpl createImpl() {
            return new ObjectFlowImpl();
        }

    }

    @objid ("94c320b7-0696-4e2c-a323-18e9a65428df")
    public static class TransformationBehaviorSmAttribute extends SmAttribute {
        @objid ("52884c76-1c03-46b5-9d62-58625f0bfb2e")
        public Object getValue(ISmObjectData data) {
            return ((ObjectFlowData) data).mTransformationBehavior;
        }

        @objid ("9397a540-94d9-49d6-9d78-5ea9a0fab671")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectFlowData) data).mTransformationBehavior = value;
        }

    }

    @objid ("b6ce9977-d511-4525-a8f7-ab4a9e502c15")
    public static class SelectionBehaviorSmAttribute extends SmAttribute {
        @objid ("af3e89a4-fa32-494f-960d-84ee0f5e5f08")
        public Object getValue(ISmObjectData data) {
            return ((ObjectFlowData) data).mSelectionBehavior;
        }

        @objid ("3f0b6648-bb4e-4338-8789-9f285141237c")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectFlowData) data).mSelectionBehavior = value;
        }

    }

    @objid ("5584c319-d2a2-45be-b5fc-051fd27b5ed0")
    public static class IsMultiCastSmAttribute extends SmAttribute {
        @objid ("3e5464b5-b094-4021-8212-cc8af70ad292")
        public Object getValue(ISmObjectData data) {
            return ((ObjectFlowData) data).mIsMultiCast;
        }

        @objid ("8bead034-06a9-4774-b02f-2484778ff963")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectFlowData) data).mIsMultiCast = value;
        }

    }

    @objid ("86d90f7e-1994-4034-a291-0d4766c80c3d")
    public static class IsMultiReceiveSmAttribute extends SmAttribute {
        @objid ("9f98aec4-3cc9-4347-88dc-720c30e67907")
        public Object getValue(ISmObjectData data) {
            return ((ObjectFlowData) data).mIsMultiReceive;
        }

        @objid ("f392d999-4fe3-4d98-8971-58ae1d3cc092")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectFlowData) data).mIsMultiReceive = value;
        }

    }

    @objid ("1988f857-bd2a-4d55-9c05-d75f971fe031")
    public static class EffectSmAttribute extends SmAttribute {
        @objid ("20704305-cdff-46f5-aa9b-49bd9a889e15")
        public Object getValue(ISmObjectData data) {
            return ((ObjectFlowData) data).mEffect;
        }

        @objid ("97fa1d2b-f831-4659-a456-1e3eb0e4ef88")
        public void setValue(ISmObjectData data, Object value) {
            ((ObjectFlowData) data).mEffect = value;
        }

    }

}
