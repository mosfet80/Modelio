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
import org.modelio.metamodel.uml.behavior.activityModel.CallAction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c5105486-1655-4f9c-9ff6-651e4276cbcc")
public class CallActionSmClass extends ActivityActionSmClass {
    @objid ("ceea81d6-4d18-40de-a546-26af3be503be")
    private SmAttribute isSynchronousAtt;

    @objid ("2fe62e8c-ced6-4d81-9684-c5f6d319b879")
    public CallActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9e1fa4f7-e588-423a-bf94-ec5cdadc5f29")
    @Override
    public String getName() {
        return "CallAction";

    }

    @objid ("68a94ed0-2cb9-4cdc-bc21-6ad4e6284e23")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("64cbd567-c2b9-4b80-9c7c-e36056ef63a8")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CallAction.class;

    }

    @objid ("82e79f12-d30f-4c82-9895-97baf084771c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("08bd2333-8aed-4231-959f-5f60fbda2525")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("16cb8806-b1dd-4251-af6d-f7854394c996")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new CallActionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isSynchronousAtt = new IsSynchronousSmAttribute();
        this.isSynchronousAtt.init("IsSynchronous", this, Boolean.class );
        registerAttribute(this.isSynchronousAtt);


        // Initialize and register the SmDependency

    }

    @objid ("01a44306-4a67-438d-82fd-8057ee935678")
    public SmAttribute getIsSynchronousAtt() {
        if (this.isSynchronousAtt == null) {
        	this.isSynchronousAtt = this.getAttributeDef("IsSynchronous");
        }
        return this.isSynchronousAtt;
    }

    @objid ("11bac29e-5b94-4385-b58e-58b327dd63a6")
    private static class CallActionObjectFactory implements ISmObjectFactory {
        @objid ("0c3ec145-cc35-4e47-826c-8ea458b6b1fe")
        private CallActionSmClass smClass;

        @objid ("868ca552-08db-4377-a087-29dd455bbe77")
        public CallActionObjectFactory(CallActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("68643ca1-50e4-4fc9-8485-27aaae49c4f4")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("af83602e-7f9b-4cf7-869c-782b9c492514")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("0c5c361c-572c-4100-810b-3dff13d1e7a0")
    public static class IsSynchronousSmAttribute extends SmAttribute {
        @objid ("e62e396d-ab46-47bd-9958-1df798dd74f3")
        public Object getValue(ISmObjectData data) {
            return ((CallActionData) data).mIsSynchronous;
        }

        @objid ("611a5be1-e7a2-43d3-b499-6754cdaa552d")
        public void setValue(ISmObjectData data, Object value) {
            ((CallActionData) data).mIsSynchronous = value;
        }

    }

}
