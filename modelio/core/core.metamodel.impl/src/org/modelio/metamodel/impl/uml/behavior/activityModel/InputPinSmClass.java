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
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.InputPin;
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
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
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("116cae41-1412-4845-aca2-dc7851e2ae73")
public class InputPinSmClass extends PinSmClass {
    @objid ("2aef95cb-6534-47ae-8c1a-d1c4e887a2f2")
    private SmAttribute isSelfAtt;

    @objid ("b980f416-107c-470d-ac5e-47305a8898b2")
    private SmDependency handlerDep;

    @objid ("f7e8e269-6bc8-400b-97e5-e252a879068c")
    private SmDependency inputingDep;

    @objid ("9a76149f-7ed7-4630-b25a-e124aff01db6")
    public InputPinSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("cfd64f0b-119d-472e-b988-99caaaf0c11c")
    @Override
    public String getName() {
        return "InputPin";

    }

    @objid ("d0edb220-e800-44a8-9098-33b57043c7e4")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("629756f7-0134-4adb-8250-e1995555bf38")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InputPin.class;

    }

    @objid ("4ae4cba4-555a-48cc-8c3b-2e57a8a9a6c1")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("fe5b8614-3d40-4da8-b65b-1f65d196564c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1f026946-3c8d-4e5e-84f8-c71d7658d1e7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Pin.MQNAME);
        this.registerFactory(new InputPinObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isSelfAtt = new IsSelfSmAttribute();
        this.isSelfAtt.init("IsSelf", this, Boolean.class );
        registerAttribute(this.isSelfAtt);


        // Initialize and register the SmDependency
        this.handlerDep = new HandlerSmDependency();
        this.handlerDep.init("Handler", this, metamodel.getMClass(ExceptionHandler.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.handlerDep);

        this.inputingDep = new InputingSmDependency();
        this.inputingDep.init("Inputing", this, metamodel.getMClass(ActivityAction.MQNAME), 0, 1 );
        registerDependency(this.inputingDep);

    }

    @objid ("f4504431-2195-4949-93d1-f8213d9621ec")
    public SmAttribute getIsSelfAtt() {
        if (this.isSelfAtt == null) {
        	this.isSelfAtt = this.getAttributeDef("IsSelf");
        }
        return this.isSelfAtt;
    }

    @objid ("86a1fc49-9828-4f6c-a679-ea8845f04517")
    public SmDependency getHandlerDep() {
        if (this.handlerDep == null) {
        	this.handlerDep = this.getDependencyDef("Handler");
        }
        return this.handlerDep;
    }

    @objid ("5ffd2adb-b3b9-46c1-b526-5eee4f63d60e")
    public SmDependency getInputingDep() {
        if (this.inputingDep == null) {
        	this.inputingDep = this.getDependencyDef("Inputing");
        }
        return this.inputingDep;
    }

    @objid ("ffc93042-6d75-4aac-98a7-3dcf1353b6cd")
    private static class InputPinObjectFactory implements ISmObjectFactory {
        @objid ("ddc47296-ff8a-4d54-870d-242b6ed580dd")
        private InputPinSmClass smClass;

        @objid ("8621c509-1394-4636-85c8-880572d31696")
        public InputPinObjectFactory(InputPinSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e4019adf-f0ac-47c9-a587-46ed7ee91fad")
        @Override
        public ISmObjectData createData() {
            return new InputPinData(this.smClass);
        }

        @objid ("cace1f9f-cd1b-460f-b9b1-8944cd75e035")
        @Override
        public SmObjectImpl createImpl() {
            return new InputPinImpl();
        }

    }

    @objid ("fd28bf73-188d-4e33-9552-f5c1cd7f7413")
    public static class IsSelfSmAttribute extends SmAttribute {
        @objid ("dd86d065-e84d-410e-8a9f-e0ce33598f53")
        public Object getValue(ISmObjectData data) {
            return ((InputPinData) data).mIsSelf;
        }

        @objid ("53a86be0-d109-42d2-a5f1-e7c6373deb1f")
        public void setValue(ISmObjectData data, Object value) {
            ((InputPinData) data).mIsSelf = value;
        }

    }

    @objid ("25d22883-9110-4e78-8e86-84c118071dcb")
    public static class HandlerSmDependency extends SmMultipleDependency {
        @objid ("56f42efb-e25f-4b17-9358-edfa5d6a1906")
        private SmDependency symetricDep;

        @objid ("c9694512-b925-4578-9444-41210ef02f38")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InputPinData)data).mHandler != null)? ((InputPinData)data).mHandler:SmMultipleDependency.EMPTY;
        }

        @objid ("28eae02f-4e1a-4842-b39c-3ee514876a6d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InputPinData) data).mHandler = values;

        }

        @objid ("018d7b64-3799-4bbe-8109-dbfc69287e9d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExceptionHandlerSmClass)this.getTarget()).getExceptionInputDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("aaa8907c-be03-4f4e-bc76-3fa5492a3554")
    public static class InputingSmDependency extends SmSingleDependency {
        @objid ("0c4147b8-deeb-4d22-94ea-c1e55e3ecbe0")
        private SmDependency symetricDep;

        @objid ("064b5d34-7f20-4d2e-9cb7-a5ebbef9d446")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InputPinData) data).mInputing;
        }

        @objid ("61699d36-43c6-43e5-b4da-de5508297eb8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InputPinData) data).mInputing = value;
        }

        @objid ("3effd3f0-5069-4fc1-ba72-baff6341049e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityActionSmClass)this.getTarget()).getInputDep();
            }
            return this.symetricDep;

        }

    }

}
