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
import org.modelio.metamodel.uml.behavior.activityModel.AcceptChangeEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("8e431131-6ece-4a04-9e8c-d76c1e35d70f")
public class AcceptChangeEventActionSmClass extends ActivityActionSmClass {
    @objid ("7740aa30-b6f3-464d-91fb-af705f7d3af5")
    private SmAttribute changeExpresionAtt;

    @objid ("bfcc7b73-10f5-48be-adae-70eaeef3c1de")
    public AcceptChangeEventActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("78380f75-5da1-437b-a989-5b93105f7ed8")
    @Override
    public String getName() {
        return "AcceptChangeEventAction";

    }

    @objid ("88070388-c4ad-410d-a604-b2f39f4cca1c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("43af5090-0084-48c3-a6c1-adf7ed699b18")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AcceptChangeEventAction.class;

    }

    @objid ("2630819a-d56c-4d08-adf4-6e4529e62f34")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("4c7a4b26-7566-4132-9105-28b0675f7194")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f1e40975-25db-42c3-8269-03a4127d6c0b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new AcceptChangeEventActionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.changeExpresionAtt = new ChangeExpresionSmAttribute();
        this.changeExpresionAtt.init("ChangeExpresion", this, String.class );
        registerAttribute(this.changeExpresionAtt);


        // Initialize and register the SmDependency

    }

    @objid ("643c776e-4401-49fb-b422-09aac5709bb1")
    public SmAttribute getChangeExpresionAtt() {
        if (this.changeExpresionAtt == null) {
        	this.changeExpresionAtt = this.getAttributeDef("ChangeExpresion");
        }
        return this.changeExpresionAtt;
    }

    @objid ("13eff77b-8ae2-48eb-a40e-97fcc2abaf1a")
    private static class AcceptChangeEventActionObjectFactory implements ISmObjectFactory {
        @objid ("f1642d17-ca2e-432b-bf53-4fd06be1a18c")
        private AcceptChangeEventActionSmClass smClass;

        @objid ("9776111d-d779-4021-8659-8d09f8bf062a")
        public AcceptChangeEventActionObjectFactory(AcceptChangeEventActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e52c72c6-0d80-4b46-82c8-489fdc7f8e4b")
        @Override
        public ISmObjectData createData() {
            return new AcceptChangeEventActionData(this.smClass);
        }

        @objid ("c08e1cec-f7ec-4aaf-9925-936fd0595a4e")
        @Override
        public SmObjectImpl createImpl() {
            return new AcceptChangeEventActionImpl();
        }

    }

    @objid ("28d586c8-42e6-4b69-8d2e-5f738a02e89f")
    public static class ChangeExpresionSmAttribute extends SmAttribute {
        @objid ("f7488e1d-d286-4b0b-bb02-471184462a89")
        public Object getValue(ISmObjectData data) {
            return ((AcceptChangeEventActionData) data).mChangeExpresion;
        }

        @objid ("b4797914-632f-4f65-86ae-338921849b25")
        public void setValue(ISmObjectData data, Object value) {
            ((AcceptChangeEventActionData) data).mChangeExpresion = value;
        }

    }

}
