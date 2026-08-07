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
import org.modelio.metamodel.uml.behavior.activityModel.ControlNode;
import org.modelio.metamodel.uml.behavior.activityModel.DecisionMergeNode;
import org.modelio.metamodel.uml.behavior.activityModel.DecisionNodeKind;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b33d2d1d-69c9-448e-8262-d8d45c47add2")
public class DecisionMergeNodeSmClass extends ControlNodeSmClass {
    @objid ("cb89c87a-ef16-4b7c-8ffc-8fb5f88b0274")
    private SmAttribute decisionKindAtt;

    @objid ("4b7efc37-6e2f-4626-928a-3b4e8c862f7f")
    private SmAttribute decisionInputBehaviorAtt;

    @objid ("2e4496c5-a9eb-4331-9499-0c84933704d8")
    public DecisionMergeNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("4df327ea-12de-42c8-bf1d-d160d7b57a1f")
    @Override
    public String getName() {
        return "DecisionMergeNode";

    }

    @objid ("3521e4c6-1ab2-405a-a831-e5a745d1f18f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("04fa3671-3c12-45f2-a361-0515dd982773")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DecisionMergeNode.class;

    }

    @objid ("d0e4094d-b654-4533-9ff7-bc5a0e84feea")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ba23d2a5-5185-44ee-9ec8-82c8bc24a29b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("105e36b1-ec14-4bea-90a0-1192f63595dd")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ControlNode.MQNAME);
        this.registerFactory(new DecisionMergeNodeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.decisionKindAtt = new DecisionKindSmAttribute();
        this.decisionKindAtt.init("DecisionKind", this, DecisionNodeKind.class );
        registerAttribute(this.decisionKindAtt);

        this.decisionInputBehaviorAtt = new DecisionInputBehaviorSmAttribute();
        this.decisionInputBehaviorAtt.init("DecisionInputBehavior", this, String.class );
        registerAttribute(this.decisionInputBehaviorAtt);


        // Initialize and register the SmDependency

    }

    @objid ("a114b9c1-e5ef-4f11-8af2-7e0045ccf913")
    public SmAttribute getDecisionKindAtt() {
        if (this.decisionKindAtt == null) {
        	this.decisionKindAtt = this.getAttributeDef("DecisionKind");
        }
        return this.decisionKindAtt;
    }

    @objid ("b293053f-99d4-40ea-a8c8-1da7ccabf083")
    public SmAttribute getDecisionInputBehaviorAtt() {
        if (this.decisionInputBehaviorAtt == null) {
        	this.decisionInputBehaviorAtt = this.getAttributeDef("DecisionInputBehavior");
        }
        return this.decisionInputBehaviorAtt;
    }

    @objid ("73b76e3e-fb5e-42f4-a963-5795cab1a183")
    private static class DecisionMergeNodeObjectFactory implements ISmObjectFactory {
        @objid ("49a600a0-f94b-461f-9402-0a1107165f00")
        private DecisionMergeNodeSmClass smClass;

        @objid ("acda8ef3-bef3-4eac-a328-13aec10336b4")
        public DecisionMergeNodeObjectFactory(DecisionMergeNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f967888c-5e04-4e41-aedb-88c0f4c31c6a")
        @Override
        public ISmObjectData createData() {
            return new DecisionMergeNodeData(this.smClass);
        }

        @objid ("5187594d-9277-45d7-9f50-1011d7582ad6")
        @Override
        public SmObjectImpl createImpl() {
            return new DecisionMergeNodeImpl();
        }

    }

    @objid ("ec8e855f-ab11-4edb-ba23-3c066b712050")
    public static class DecisionKindSmAttribute extends SmAttribute {
        @objid ("b49395b9-5c7b-4a03-90c3-ccd3c9faf939")
        public Object getValue(ISmObjectData data) {
            return ((DecisionMergeNodeData) data).mDecisionKind;
        }

        @objid ("88965fc7-11e8-4a35-aced-42683ed86e43")
        public void setValue(ISmObjectData data, Object value) {
            ((DecisionMergeNodeData) data).mDecisionKind = value;
        }

    }

    @objid ("a661a402-f69d-4681-b7db-254bd48d4e38")
    public static class DecisionInputBehaviorSmAttribute extends SmAttribute {
        @objid ("6e9c8f5e-ef0c-4d6c-a4ef-ba5f4b9484d5")
        public Object getValue(ISmObjectData data) {
            return ((DecisionMergeNodeData) data).mDecisionInputBehavior;
        }

        @objid ("682052a6-f14f-4ae4-b414-34347ba1d5d7")
        public void setValue(ISmObjectData data, Object value) {
            ((DecisionMergeNodeData) data).mDecisionInputBehavior = value;
        }

    }

}
