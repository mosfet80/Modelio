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
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.events.BpmnCompensateEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.impl.bpmn.activities.BpmnActivitySmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("dae9bc16-62d9-4710-8180-d149139425f7")
public class BpmnCompensateEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("01655c63-aa64-4ee3-9f7c-1e47d0199e35")
    private SmAttribute waitForCompletionAtt;

    @objid ("25793909-943d-4890-a602-750c9ec248b6")
    private SmDependency activityRefDep;

    @objid ("2e017abc-f236-4ef2-9488-d4c6c1711deb")
    public BpmnCompensateEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c3c23ea2-78f4-4f71-a0d8-c873c680a543")
    @Override
    public String getName() {
        return "BpmnCompensateEventDefinition";

    }

    @objid ("5788ab40-7668-4712-8c2a-8967848be357")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("374ce5f5-efbc-439c-9ab0-1243f4a03cd9")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnCompensateEventDefinition.class;

    }

    @objid ("cefab2ab-ee27-488c-8f33-3861ea180a40")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("c6578848-a707-489f-a372-bd203c96a891")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1e6c626b-2b76-4ef2-a199-c601595273fb")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnCompensateEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.waitForCompletionAtt = new WaitForCompletionSmAttribute();
        this.waitForCompletionAtt.init("WaitForCompletion", this, String.class );
        registerAttribute(this.waitForCompletionAtt);


        // Initialize and register the SmDependency
        this.activityRefDep = new ActivityRefSmDependency();
        this.activityRefDep.init("ActivityRef", this, metamodel.getMClass(BpmnActivity.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.activityRefDep);

    }

    @objid ("ed3ba45c-fb7d-4da3-ab48-19932218d2ec")
    public SmAttribute getWaitForCompletionAtt() {
        if (this.waitForCompletionAtt == null) {
        	this.waitForCompletionAtt = this.getAttributeDef("WaitForCompletion");
        }
        return this.waitForCompletionAtt;
    }

    @objid ("fb71eafa-544c-469d-8404-93dd3f85fd4d")
    public SmDependency getActivityRefDep() {
        if (this.activityRefDep == null) {
        	this.activityRefDep = this.getDependencyDef("ActivityRef");
        }
        return this.activityRefDep;
    }

    @objid ("3b31e472-bf20-4dff-bfc3-72aec4c5ad4a")
    private static class BpmnCompensateEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("8591f500-ff75-4d35-8aec-837b273dc797")
        private BpmnCompensateEventDefinitionSmClass smClass;

        @objid ("121c8446-9ec0-42a4-9cec-e59bf9eb8c0c")
        public BpmnCompensateEventDefinitionObjectFactory(BpmnCompensateEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("0d7223a3-4197-4167-9456-77ae37dc0425")
        @Override
        public ISmObjectData createData() {
            return new BpmnCompensateEventDefinitionData(this.smClass);
        }

        @objid ("35faa020-d106-441b-8722-f1c44ace9678")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnCompensateEventDefinitionImpl();
        }

    }

    @objid ("c82c2808-d596-4185-89f9-a5c7ef08a1c2")
    public static class WaitForCompletionSmAttribute extends SmAttribute {
        @objid ("67443cbd-9aff-4826-96d8-ffa51c1954d5")
        public Object getValue(ISmObjectData data) {
            return ((BpmnCompensateEventDefinitionData) data).mWaitForCompletion;
        }

        @objid ("e9ad2483-120b-463b-9cbc-0f2754e36812")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnCompensateEventDefinitionData) data).mWaitForCompletion = value;
        }

    }

    @objid ("6fccd917-6aa9-4fdc-940c-bb582422afcd")
    public static class ActivityRefSmDependency extends SmSingleDependency {
        @objid ("93c477f7-6eab-42c2-9dc1-0c4036a3658d")
        private SmDependency symetricDep;

        @objid ("1ee4a468-39b1-43d7-a730-a3cdf14aea98")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnCompensateEventDefinitionData) data).mActivityRef;
        }

        @objid ("877e07d2-68ce-4385-8cdf-625ab2e8b998")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnCompensateEventDefinitionData) data).mActivityRef = value;
        }

        @objid ("46e248c9-05b9-4b4c-8cef-1d4105f8f6db")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getCompensateEventDefinitionsDep();
            }
            return this.symetricDep;

        }

    }

}
