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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.OpaqueAction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1c8993a9-2dca-4afe-afa1-3f3e38614e0e")
public class OpaqueActionSmClass extends ActivityActionSmClass {
    @objid ("c1f6e80e-ee10-4053-8ca2-301b4dee178a")
    private SmAttribute bodyAtt;

    @objid ("a9d8a5ba-4225-403b-bbe4-6dbdac357e59")
    public OpaqueActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("3e9fae1f-4915-4b75-ad8e-61780fa1fb26")
    @Override
    public String getName() {
        return "OpaqueAction";

    }

    @objid ("ee0c42e4-342c-46fe-9fa7-cdd977a312cb")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("bede2f34-9091-4551-8506-c862b2a73df5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return OpaqueAction.class;

    }

    @objid ("8d2b8caf-cb2e-4a69-9221-c20c26d0ea02")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("89f1be43-e3a6-44cf-9c52-6fd6d63a15c9")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("92fab885-9e48-4792-85c7-ccaea9c336cf")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new OpaqueActionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.bodyAtt = new BodySmAttribute();
        this.bodyAtt.init("Body", this, String.class );
        registerAttribute(this.bodyAtt);


        // Initialize and register the SmDependency

    }

    @objid ("37f621e1-16f3-4b96-b0a2-96f8885de3bd")
    public SmAttribute getBodyAtt() {
        if (this.bodyAtt == null) {
        	this.bodyAtt = this.getAttributeDef("Body");
        }
        return this.bodyAtt;
    }

    @objid ("4f2d3356-8615-4dc9-bf07-c569a3062e88")
    private static class OpaqueActionObjectFactory implements ISmObjectFactory {
        @objid ("fedafa6e-f8f5-40a9-84c5-f88949eff91a")
        private OpaqueActionSmClass smClass;

        @objid ("5ad2de92-da83-4012-99fe-7ec724265fd6")
        public OpaqueActionObjectFactory(OpaqueActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("286a55e3-36f6-469c-970b-241001a46af3")
        @Override
        public ISmObjectData createData() {
            return new OpaqueActionData(this.smClass);
        }

        @objid ("3987fa01-4a39-4312-bd6a-3f6fc44f757b")
        @Override
        public SmObjectImpl createImpl() {
            return new OpaqueActionImpl();
        }

    }

    @objid ("ec0decf0-e050-4620-ac73-25030b796fcb")
    public static class BodySmAttribute extends SmAttribute {
        @objid ("7081e5f2-7783-4857-9f9e-db173a1bc8fc")
        public Object getValue(ISmObjectData data) {
            return ((OpaqueActionData) data).mBody;
        }

        @objid ("3043e044-fb78-497f-83c7-463808e2e6d1")
        public void setValue(ISmObjectData data, Object value) {
            ((OpaqueActionData) data).mBody = value;
        }

    }

}
