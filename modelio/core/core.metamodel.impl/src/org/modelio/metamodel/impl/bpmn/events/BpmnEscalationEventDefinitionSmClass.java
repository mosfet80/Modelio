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
import org.modelio.metamodel.bpmn.events.BpmnEscalationEventDefinition;
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

@objid ("b033b513-64ec-4756-a171-630a637d92e6")
public class BpmnEscalationEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("dd8fa746-d05a-44ae-8788-c06505e8e92a")
    private SmAttribute escalationCodeAtt;

    @objid ("ac4e17a5-7287-408a-90f8-f279d52560fd")
    public BpmnEscalationEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("42bedd71-e982-412e-a0a9-835c446d2b4d")
    @Override
    public String getName() {
        return "BpmnEscalationEventDefinition";

    }

    @objid ("15416739-62db-42e7-8644-26ca83289c85")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e211bcbb-497c-4c41-bb23-341381fc3b40")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnEscalationEventDefinition.class;

    }

    @objid ("b7c26341-1e47-4a6b-86db-6c5dd4652021")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("848f1f52-9002-4e76-8531-58ef87655489")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5bfa7559-db14-4a78-9d2e-de273b5ab4e1")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnEscalationEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.escalationCodeAtt = new EscalationCodeSmAttribute();
        this.escalationCodeAtt.init("EscalationCode", this, String.class );
        registerAttribute(this.escalationCodeAtt);


        // Initialize and register the SmDependency

    }

    @objid ("407738fd-4cd3-4727-bdb5-6a694c7cac87")
    public SmAttribute getEscalationCodeAtt() {
        if (this.escalationCodeAtt == null) {
        	this.escalationCodeAtt = this.getAttributeDef("EscalationCode");
        }
        return this.escalationCodeAtt;
    }

    @objid ("8e715810-1930-4ea8-9f7c-1e4c31f247b4")
    private static class BpmnEscalationEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("c145a5e6-0706-453d-a556-a00a5ca2dfa6")
        private BpmnEscalationEventDefinitionSmClass smClass;

        @objid ("86bfcff8-518a-4dcd-a28e-8d265e4e15c5")
        public BpmnEscalationEventDefinitionObjectFactory(BpmnEscalationEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("43069174-44e4-4a64-9f69-d5ff94a91d90")
        @Override
        public ISmObjectData createData() {
            return new BpmnEscalationEventDefinitionData(this.smClass);
        }

        @objid ("72a69e6c-5ca9-40ba-8f86-b6ce4c6ef451")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnEscalationEventDefinitionImpl();
        }

    }

    @objid ("df6c8e9c-c38c-4144-be62-54b9aeb500af")
    public static class EscalationCodeSmAttribute extends SmAttribute {
        @objid ("5229eb4d-cd32-4741-aebf-f4d3341917e3")
        public Object getValue(ISmObjectData data) {
            return ((BpmnEscalationEventDefinitionData) data).mEscalationCode;
        }

        @objid ("a2da5899-b56f-4c2b-a73f-0bcdb79dc6bf")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnEscalationEventDefinitionData) data).mEscalationCode = value;
        }

    }

}
