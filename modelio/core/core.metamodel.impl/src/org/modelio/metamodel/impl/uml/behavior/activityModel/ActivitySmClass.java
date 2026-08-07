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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityGroup;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
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

@objid ("0cf56662-cbd9-4437-9a92-9d3cc49f704a")
public class ActivitySmClass extends BehaviorSmClass {
    @objid ("556adda5-502b-4847-b512-680bf1929250")
    private SmAttribute isSingleExecutionAtt;

    @objid ("c21b91fa-8835-460e-b3be-baa85b604836")
    private SmAttribute isReadOnlyAtt;

    @objid ("6d5d0abe-87bd-4f3a-8cdc-e61893973b61")
    private SmDependency ownedGroupDep;

    @objid ("ce5af8af-01dd-41a2-8e3b-7abe257b8558")
    private SmDependency ownedNodeDep;

    @objid ("cd40049e-a83a-4845-8bcc-80612bb4a9fc")
    public ActivitySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b722d46d-7eac-4063-8aac-5bfbe83d8577")
    @Override
    public String getName() {
        return "Activity";

    }

    @objid ("f1a36f2f-6216-4cc2-b980-4245a485e463")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("972708e2-34c8-42db-bd87-e1cb33c84455")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Activity.class;

    }

    @objid ("d4c4dc15-7121-415e-91fb-b3691ac6a344")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("156eef52-c6ca-4adc-bcbc-0ebc3e6f87d8")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("41362c4e-b59c-4eeb-b813-21bd752a78d6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new ActivityObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isSingleExecutionAtt = new IsSingleExecutionSmAttribute();
        this.isSingleExecutionAtt.init("IsSingleExecution", this, Boolean.class );
        registerAttribute(this.isSingleExecutionAtt);

        this.isReadOnlyAtt = new IsReadOnlySmAttribute();
        this.isReadOnlyAtt.init("IsReadOnly", this, Boolean.class );
        registerAttribute(this.isReadOnlyAtt);


        // Initialize and register the SmDependency
        this.ownedGroupDep = new OwnedGroupSmDependency();
        this.ownedGroupDep.init("OwnedGroup", this, metamodel.getMClass(ActivityGroup.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedGroupDep);

        this.ownedNodeDep = new OwnedNodeSmDependency();
        this.ownedNodeDep.init("OwnedNode", this, metamodel.getMClass(ActivityNode.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedNodeDep);

    }

    @objid ("757c2c79-88af-4fb6-af98-5395eb13432a")
    public SmAttribute getIsSingleExecutionAtt() {
        if (this.isSingleExecutionAtt == null) {
        	this.isSingleExecutionAtt = this.getAttributeDef("IsSingleExecution");
        }
        return this.isSingleExecutionAtt;
    }

    @objid ("699b63c0-5bcf-4e0d-9dad-cb5e0241878b")
    public SmAttribute getIsReadOnlyAtt() {
        if (this.isReadOnlyAtt == null) {
        	this.isReadOnlyAtt = this.getAttributeDef("IsReadOnly");
        }
        return this.isReadOnlyAtt;
    }

    @objid ("8e92d09c-4b11-4b36-ac33-4145e553940a")
    public SmDependency getOwnedGroupDep() {
        if (this.ownedGroupDep == null) {
        	this.ownedGroupDep = this.getDependencyDef("OwnedGroup");
        }
        return this.ownedGroupDep;
    }

    @objid ("acaaf51f-4aae-4389-aaaf-0eb46d16b8ec")
    public SmDependency getOwnedNodeDep() {
        if (this.ownedNodeDep == null) {
        	this.ownedNodeDep = this.getDependencyDef("OwnedNode");
        }
        return this.ownedNodeDep;
    }

    @objid ("e28eb2b1-04af-464e-be5c-5b2950a14f3a")
    private static class ActivityObjectFactory implements ISmObjectFactory {
        @objid ("566eec82-7390-4ceb-8744-f7785118033f")
        private ActivitySmClass smClass;

        @objid ("eb3aa666-0903-4414-9d48-20550f6dfde8")
        public ActivityObjectFactory(ActivitySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4fd2a445-c5f5-4667-b875-73d52e4375b6")
        @Override
        public ISmObjectData createData() {
            return new ActivityData(this.smClass);
        }

        @objid ("e5ad21ad-5410-43cc-b933-0bee0148f9f4")
        @Override
        public SmObjectImpl createImpl() {
            return new ActivityImpl();
        }

    }

    @objid ("568bc5b9-f4f2-4db5-9368-e6bbd8d910cf")
    public static class IsSingleExecutionSmAttribute extends SmAttribute {
        @objid ("547d927d-b414-42e3-a735-6b5b05e31e44")
        public Object getValue(ISmObjectData data) {
            return ((ActivityData) data).mIsSingleExecution;
        }

        @objid ("d68c446a-e98b-4f3a-9fc0-7d77596fce0d")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityData) data).mIsSingleExecution = value;
        }

    }

    @objid ("48dc53c8-d2e5-4fc8-bbf2-6f396f936d3c")
    public static class IsReadOnlySmAttribute extends SmAttribute {
        @objid ("88233e1e-2afc-4808-b9f2-1648ca94c54d")
        public Object getValue(ISmObjectData data) {
            return ((ActivityData) data).mIsReadOnly;
        }

        @objid ("6b88e14f-8464-4263-b870-f246cef4a2a0")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityData) data).mIsReadOnly = value;
        }

    }

    @objid ("335b7190-22b4-493a-b96e-05b9574782c5")
    public static class OwnedGroupSmDependency extends SmMultipleDependency {
        @objid ("b986dfef-d969-4135-97ae-812c42751333")
        private SmDependency symetricDep;

        @objid ("6bbba306-d751-4a05-ab5d-aef8fa0e61c1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityData)data).mOwnedGroup != null)? ((ActivityData)data).mOwnedGroup:SmMultipleDependency.EMPTY;
        }

        @objid ("00ec18ea-ac42-4fe7-9a5b-f94c2e8a6480")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityData) data).mOwnedGroup = values;

        }

        @objid ("40ef9760-1d3c-42d3-bd0d-221d79cac3ef")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityGroupSmClass)this.getTarget()).getInActivityDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("403b7a2f-2812-4e66-8d26-86db91fb65db")
    public static class OwnedNodeSmDependency extends SmMultipleDependency {
        @objid ("5f8e9377-bc4d-42fc-abef-c2d555505402")
        private SmDependency symetricDep;

        @objid ("276b9acc-e39f-4ca4-bccc-4a7d65eae082")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityData)data).mOwnedNode != null)? ((ActivityData)data).mOwnedNode:SmMultipleDependency.EMPTY;
        }

        @objid ("b6b73312-e681-4535-994b-215485d30d64")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityData) data).mOwnedNode = values;

        }

        @objid ("d12b07bc-6d19-44ed-9721-082a3c2533ab")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityNodeSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
