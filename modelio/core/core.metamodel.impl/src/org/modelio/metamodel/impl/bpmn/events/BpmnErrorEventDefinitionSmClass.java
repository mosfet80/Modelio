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
import org.modelio.metamodel.bpmn.events.BpmnErrorEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("2f63a229-7bed-4137-91ae-8558d497558a")
public class BpmnErrorEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("4fefdf5c-3cde-4c79-ae86-677d7988f191")
    private SmAttribute errorCodeAtt;

    @objid ("bfacd644-87a0-4a59-9435-e81ccd54c7b7")
    public BpmnErrorEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("4fe3cd3b-f6f6-4058-8910-4b75cc10ccfa")
    @Override
    public String getName() {
        return "BpmnErrorEventDefinition";

    }

    @objid ("762c6501-3ae5-4038-8283-4c8087b003be")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("90474582-228e-4760-8925-903b156decfa")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnErrorEventDefinition.class;

    }

    @objid ("51e7f0c1-e5bd-45ec-a68c-08163456cc71")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("fa564bd9-c16b-4949-8412-42a281b78d20")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("34331bf4-09a5-4077-ac63-83b55d4351da")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnErrorEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.errorCodeAtt = new ErrorCodeSmAttribute();
        this.errorCodeAtt.init("ErrorCode", this, String.class );
        registerAttribute(this.errorCodeAtt);


        // Initialize and register the SmDependency

    }

    @objid ("0e15ece6-2a18-4f49-b81a-ad0401baf4cb")
    public SmAttribute getErrorCodeAtt() {
        if (this.errorCodeAtt == null) {
        	this.errorCodeAtt = this.getAttributeDef("ErrorCode");
        }
        return this.errorCodeAtt;
    }

    @objid ("30273785-3c93-46d1-b582-70446a9ef8f2")
    private static class BpmnErrorEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("b262177f-7436-43e2-8018-3b7c7f98605e")
        private BpmnErrorEventDefinitionSmClass smClass;

        @objid ("92610a73-631c-4688-8c4d-ccc83c7b5abe")
        public BpmnErrorEventDefinitionObjectFactory(BpmnErrorEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6323f4cf-1a2f-4dc5-93ee-21d9cc1af46a")
        @Override
        public ISmObjectData createData() {
            return new BpmnErrorEventDefinitionData(this.smClass);
        }

        @objid ("04a1e88f-fee4-4370-a76b-00b60ede80ec")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnErrorEventDefinitionImpl();
        }

    }

    @objid ("7407a3bd-92c2-4c46-acc9-168f4a9175ff")
    public static class ErrorCodeSmAttribute extends SmAttribute {
        @objid ("e43de630-78b1-4b26-8111-1a065f5b6535")
        public Object getValue(ISmObjectData data) {
            return ((BpmnErrorEventDefinitionData) data).mErrorCode;
        }

        @objid ("b630a60a-f9d9-409c-8d21-210ccd8762c1")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnErrorEventDefinitionData) data).mErrorCode = value;
        }

    }

}
