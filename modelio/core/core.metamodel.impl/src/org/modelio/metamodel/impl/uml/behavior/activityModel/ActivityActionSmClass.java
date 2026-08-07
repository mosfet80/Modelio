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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.InputPin;
import org.modelio.metamodel.uml.behavior.activityModel.OutputPin;
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

@objid ("90f6045c-3241-4b56-a0d9-fb3745c723b3")
public class ActivityActionSmClass extends ActivityNodeSmClass {
    @objid ("01b42f90-8aae-49e7-ba34-89955e251496")
    private SmAttribute isMultipleInstanceAtt;

    @objid ("61838476-f067-4256-8395-2aa3897d76c6")
    private SmAttribute isCompensationAtt;

    @objid ("2dd04bf2-66b6-4af9-a38e-fcca362be3a4")
    private SmDependency outputDep;

    @objid ("2221e842-8971-44dc-b453-159b9c551ed4")
    private SmDependency inputDep;

    @objid ("9c457c38-b000-4ec8-a6f9-41e895434da0")
    private SmDependency handlerDep;

    @objid ("b30ed9cb-9ca3-46c5-88ce-7cbac6fc48db")
    public ActivityActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("bc51851b-745a-4339-9585-10027285c4f7")
    @Override
    public String getName() {
        return "ActivityAction";

    }

    @objid ("97ebc554-22cc-40f1-a1c0-86e41f08bf80")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0d7397d9-a971-4fe3-80b2-f5de91402025")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityAction.class;

    }

    @objid ("42e23735-27da-4914-b0dc-22bd1fa174c4")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5841d749-67ac-4c17-8a60-1384732fef17")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("80079c30-8d76-4476-bc25-a0af15b764fa")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityNode.MQNAME);
        this.registerFactory(new ActivityActionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isMultipleInstanceAtt = new IsMultipleInstanceSmAttribute();
        this.isMultipleInstanceAtt.init("IsMultipleInstance", this, Boolean.class );
        registerAttribute(this.isMultipleInstanceAtt);

        this.isCompensationAtt = new IsCompensationSmAttribute();
        this.isCompensationAtt.init("IsCompensation", this, Boolean.class );
        registerAttribute(this.isCompensationAtt);


        // Initialize and register the SmDependency
        this.outputDep = new OutputSmDependency();
        this.outputDep.init("Output", this, metamodel.getMClass(OutputPin.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.outputDep);

        this.inputDep = new InputSmDependency();
        this.inputDep.init("Input", this, metamodel.getMClass(InputPin.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.inputDep);

        this.handlerDep = new HandlerSmDependency();
        this.handlerDep.init("Handler", this, metamodel.getMClass(ExceptionHandler.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.handlerDep);

    }

    @objid ("f1e4ab80-9d0a-47c7-9e89-c8e7b64bfd99")
    public SmAttribute getIsMultipleInstanceAtt() {
        if (this.isMultipleInstanceAtt == null) {
        	this.isMultipleInstanceAtt = this.getAttributeDef("IsMultipleInstance");
        }
        return this.isMultipleInstanceAtt;
    }

    @objid ("9413b82d-9d6f-44fd-ba41-cc610f1f3ade")
    public SmAttribute getIsCompensationAtt() {
        if (this.isCompensationAtt == null) {
        	this.isCompensationAtt = this.getAttributeDef("IsCompensation");
        }
        return this.isCompensationAtt;
    }

    @objid ("45f27442-a889-4389-8b48-251fb509d179")
    public SmDependency getOutputDep() {
        if (this.outputDep == null) {
        	this.outputDep = this.getDependencyDef("Output");
        }
        return this.outputDep;
    }

    @objid ("8c34e87e-752b-467e-97d1-3fe80b459aa7")
    public SmDependency getInputDep() {
        if (this.inputDep == null) {
        	this.inputDep = this.getDependencyDef("Input");
        }
        return this.inputDep;
    }

    @objid ("feedf032-4d76-4234-a07f-71a287b50cbe")
    public SmDependency getHandlerDep() {
        if (this.handlerDep == null) {
        	this.handlerDep = this.getDependencyDef("Handler");
        }
        return this.handlerDep;
    }

    @objid ("0b15066a-7027-4041-8cef-9d41da804c05")
    private static class ActivityActionObjectFactory implements ISmObjectFactory {
        @objid ("897f6569-e166-48ee-9398-8dcce6ef12e2")
        private ActivityActionSmClass smClass;

        @objid ("7da20101-74a6-4f2f-8074-caea8245b0d1")
        public ActivityActionObjectFactory(ActivityActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7c48cc26-42b1-4822-b992-d2ae90c0a4bb")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("3b0a223d-893e-4ab0-bb8c-edcf7c5bd7f8")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("fbf2895e-e719-4e88-89be-aee1cda4e4a4")
    public static class IsMultipleInstanceSmAttribute extends SmAttribute {
        @objid ("928a8854-837e-436a-a53e-5ebfb4e85c2a")
        public Object getValue(ISmObjectData data) {
            return ((ActivityActionData) data).mIsMultipleInstance;
        }

        @objid ("bece0363-b8c8-4bc9-892c-e989559fd03f")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityActionData) data).mIsMultipleInstance = value;
        }

    }

    @objid ("8be3a40f-714d-4574-bd58-9b84f2c6dfb1")
    public static class IsCompensationSmAttribute extends SmAttribute {
        @objid ("aab3076d-6651-48e9-b6e6-255017ff1c56")
        public Object getValue(ISmObjectData data) {
            return ((ActivityActionData) data).mIsCompensation;
        }

        @objid ("6ed93e1e-bef2-40f0-8bf7-bda7076fa039")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityActionData) data).mIsCompensation = value;
        }

    }

    @objid ("99711a5b-758f-4497-850d-0d9b30a2e8e1")
    public static class OutputSmDependency extends SmMultipleDependency {
        @objid ("4ab484fe-e4a7-48b9-8b4a-32f53018b0b7")
        private SmDependency symetricDep;

        @objid ("b301a8de-c0d7-4266-aa0c-2d5270ad727d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityActionData)data).mOutput != null)? ((ActivityActionData)data).mOutput:SmMultipleDependency.EMPTY;
        }

        @objid ("c06b8640-7492-4131-b065-aee75df0d662")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityActionData) data).mOutput = values;

        }

        @objid ("53d2e23b-ee3f-48c0-ad59-209cf4c7e785")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OutputPinSmClass)this.getTarget()).getOutputingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("aee183a3-affe-42f3-a82b-0ece36e323ca")
    public static class InputSmDependency extends SmMultipleDependency {
        @objid ("dc956607-2e82-46de-b44d-42b5c7df4c63")
        private SmDependency symetricDep;

        @objid ("376a43eb-ffb6-42da-a934-0e83dc5e2400")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityActionData)data).mInput != null)? ((ActivityActionData)data).mInput:SmMultipleDependency.EMPTY;
        }

        @objid ("4d3375fa-eac4-4f0f-9f57-c5da8dce86bc")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityActionData) data).mInput = values;

        }

        @objid ("fdab19c4-3ffc-47c9-8c37-0e182750b114")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InputPinSmClass)this.getTarget()).getInputingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("30db67f5-d2f6-44ef-b8a6-df2904c4eb4d")
    public static class HandlerSmDependency extends SmMultipleDependency {
        @objid ("0476ce4b-1fe0-4fb3-827b-9debebd7243b")
        private SmDependency symetricDep;

        @objid ("9f48e6ee-3c52-46e8-ac82-cfff3c5d0270")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityActionData)data).mHandler != null)? ((ActivityActionData)data).mHandler:SmMultipleDependency.EMPTY;
        }

        @objid ("70ee2edf-7f0d-4332-85ff-bacf6394a4e9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityActionData) data).mHandler = values;

        }

        @objid ("93cae9e1-8058-485d-a1f3-aa04387d1dbe")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExceptionHandlerSmClass)this.getTarget()).getProtectedNodeDep();
            }
            return this.symetricDep;

        }

    }

}
