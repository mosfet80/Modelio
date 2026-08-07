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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnScriptTask;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("498e9253-4950-4494-b75b-60929dff9589")
public class BpmnScriptTaskSmClass extends BpmnTaskSmClass {
    @objid ("b19549e5-4bb7-4d48-b368-5c86dd2553f5")
    private SmAttribute scriptLanguageAtt;

    @objid ("a130e290-f31c-43f7-a6ca-10d59e97c6b7")
    private SmAttribute scriptAtt;

    @objid ("53780133-da9d-4376-b725-06b9226344e3")
    public BpmnScriptTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a6c1f0ff-bd31-4e33-aec8-68198fefac1e")
    @Override
    public String getName() {
        return "BpmnScriptTask";

    }

    @objid ("95c4c82f-5ad5-4fdd-8fea-1867ae5b5e18")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("27908a2a-5431-4ec4-8e67-1cceafb3d975")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnScriptTask.class;

    }

    @objid ("4c7faf92-0bfb-4dfd-b47f-9408d10e68cd")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5c336821-505c-48bf-bc5c-5ed6ea970f2a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a3a3894a-cafa-4bcb-9c71-53cfc5b4a6e8")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnTask.MQNAME);
        this.registerFactory(new BpmnScriptTaskObjectFactory(this));


        // Initialize and register the SmAttribute
        this.scriptLanguageAtt = new ScriptLanguageSmAttribute();
        this.scriptLanguageAtt.init("ScriptLanguage", this, String.class );
        registerAttribute(this.scriptLanguageAtt);

        this.scriptAtt = new ScriptSmAttribute();
        this.scriptAtt.init("Script", this, String.class );
        registerAttribute(this.scriptAtt);


        // Initialize and register the SmDependency

    }

    @objid ("fb393a06-ed14-42c9-b334-7b5c392dc477")
    public SmAttribute getScriptLanguageAtt() {
        if (this.scriptLanguageAtt == null) {
        	this.scriptLanguageAtt = this.getAttributeDef("ScriptLanguage");
        }
        return this.scriptLanguageAtt;
    }

    @objid ("c686e141-7d3f-41fc-81ef-ada2a8a8ebab")
    public SmAttribute getScriptAtt() {
        if (this.scriptAtt == null) {
        	this.scriptAtt = this.getAttributeDef("Script");
        }
        return this.scriptAtt;
    }

    @objid ("a9e12faf-bba4-4161-a92f-7336efc0fbed")
    private static class BpmnScriptTaskObjectFactory implements ISmObjectFactory {
        @objid ("366d6b8b-4915-437c-8f23-fe15f945542c")
        private BpmnScriptTaskSmClass smClass;

        @objid ("b3dd8527-0a4d-4a3a-be74-14c0d435ebd2")
        public BpmnScriptTaskObjectFactory(BpmnScriptTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2d230d2e-a172-4a51-91d7-b21b767259e9")
        @Override
        public ISmObjectData createData() {
            return new BpmnScriptTaskData(this.smClass);
        }

        @objid ("67ad8ff2-fa24-43cb-9e50-c3db86998f3a")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnScriptTaskImpl();
        }

    }

    @objid ("37461fd6-6dcd-44a7-96c4-e344098c8f5e")
    public static class ScriptLanguageSmAttribute extends SmAttribute {
        @objid ("ff6af3e7-e340-4e60-80ca-137760db6cc9")
        public Object getValue(ISmObjectData data) {
            return ((BpmnScriptTaskData) data).mScriptLanguage;
        }

        @objid ("3cd000c9-5ddd-4d92-943f-f442ec318195")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnScriptTaskData) data).mScriptLanguage = value;
        }

    }

    @objid ("4adcfbd3-d236-45db-9b08-f2f0bd755f15")
    public static class ScriptSmAttribute extends SmAttribute {
        @objid ("7d8b6397-ac38-4a62-aef5-0dce711f8291")
        public Object getValue(ISmObjectData data) {
            return ((BpmnScriptTaskData) data).mScript;
        }

        @objid ("f224b16e-fa77-4957-82d5-48bf1709f253")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnScriptTaskData) data).mScript = value;
        }

    }

}
