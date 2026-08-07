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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.OccurrenceSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.StateInvariant;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("fcdddd87-663f-4ea8-99c7-5a84503dc557")
public class StateInvariantSmClass extends OccurrenceSpecificationSmClass {
    @objid ("d5793a13-c36c-48da-8004-274025885c51")
    private SmAttribute bodyAtt;

    @objid ("21d87d35-6d29-4444-8cbd-164fcf08a9d6")
    private SmAttribute endLineNumberAtt;

    @objid ("c2534cec-ac1c-404e-9b8c-70edf606e820")
    public StateInvariantSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("26975ddd-ce74-46ed-98de-1b52d329fdee")
    @Override
    public String getName() {
        return "StateInvariant";

    }

    @objid ("22fecb37-13d2-431f-b667-64aed29d0735")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("b5d995cd-1565-4c74-98dd-ee205cbe561d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StateInvariant.class;

    }

    @objid ("2854ee02-c209-43fb-90d4-f14f4c3a918a")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b99b2f56-f890-4a0f-98b9-66abb8009293")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d5dfe6b3-d1a8-45ce-8475-3a882f21f68d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(OccurrenceSpecification.MQNAME);
        this.registerFactory(new StateInvariantObjectFactory(this));


        // Initialize and register the SmAttribute
        this.bodyAtt = new BodySmAttribute();
        this.bodyAtt.init("Body", this, String.class );
        registerAttribute(this.bodyAtt);

        this.endLineNumberAtt = new EndLineNumberSmAttribute();
        this.endLineNumberAtt.init("EndLineNumber", this, Integer.class );
        registerAttribute(this.endLineNumberAtt);


        // Initialize and register the SmDependency

    }

    @objid ("dd983f42-6849-4de9-bded-95c2e1a4f2a7")
    public SmAttribute getBodyAtt() {
        if (this.bodyAtt == null) {
        	this.bodyAtt = this.getAttributeDef("Body");
        }
        return this.bodyAtt;
    }

    @objid ("5dc75d67-cb8e-47b3-af5d-b27164857da6")
    public SmAttribute getEndLineNumberAtt() {
        if (this.endLineNumberAtt == null) {
        	this.endLineNumberAtt = this.getAttributeDef("EndLineNumber");
        }
        return this.endLineNumberAtt;
    }

    @objid ("8d293fe4-7306-4b52-8df2-b120276158ca")
    private static class StateInvariantObjectFactory implements ISmObjectFactory {
        @objid ("5fd610b4-9ed1-4ef7-8444-70d31b1a7ec6")
        private StateInvariantSmClass smClass;

        @objid ("8a3ae03c-0c32-4eef-a0fc-771cd8f6fa88")
        public StateInvariantObjectFactory(StateInvariantSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("46e9ea3c-fe41-40a6-9bfa-dc7ca3f537b5")
        @Override
        public ISmObjectData createData() {
            return new StateInvariantData(this.smClass);
        }

        @objid ("49911a93-9de3-4033-b01f-49e6426fa800")
        @Override
        public SmObjectImpl createImpl() {
            return new StateInvariantImpl();
        }

    }

    @objid ("c1694ce8-f72b-4392-887b-7ad883a8aadf")
    public static class BodySmAttribute extends SmAttribute {
        @objid ("943f6e41-728d-4cfd-bf9e-2421ae2fd7a1")
        public Object getValue(ISmObjectData data) {
            return ((StateInvariantData) data).mBody;
        }

        @objid ("84ac4786-5f20-4bca-8085-972096d1ca43")
        public void setValue(ISmObjectData data, Object value) {
            ((StateInvariantData) data).mBody = value;
        }

    }

    @objid ("5b668db3-c0ce-4d3d-9317-e74f74576591")
    public static class EndLineNumberSmAttribute extends SmAttribute {
        @objid ("987fc296-3665-4d28-8a60-df04d334777b")
        public Object getValue(ISmObjectData data) {
            return ((StateInvariantData) data).mEndLineNumber;
        }

        @objid ("02197672-a54c-4b3e-803a-4e55028dc088")
        public void setValue(ISmObjectData data, Object value) {
            ((StateInvariantData) data).mEndLineNumber = value;
        }

    }

}
