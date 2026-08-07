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
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.metamodel.bpmn.activities.BpmnUserTask;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("cafae0b5-d001-4ebb-8240-c405612f41d7")
public class BpmnUserTaskSmClass extends BpmnTaskSmClass {
    @objid ("3c1d29e2-8b51-451c-8e7d-41743441a183")
    private SmAttribute implementationAtt;

    @objid ("1adfe6f6-4932-42d6-ae9f-63b09021460e")
    public BpmnUserTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0ef82a16-dcb2-440c-99c2-3093fc43f97a")
    @Override
    public String getName() {
        return "BpmnUserTask";

    }

    @objid ("95a1db24-b425-4478-8239-a10c8dfc7489")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5b19ef02-7771-47ef-9d9c-e139ecf730f1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnUserTask.class;

    }

    @objid ("e3841c9e-7592-4204-9e4e-d0036c62614e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("33b6434e-6241-4430-8f55-03d69b3edd60")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("59ddbb70-cc00-43a3-bf0d-d8448228471f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnTask.MQNAME);
        this.registerFactory(new BpmnUserTaskObjectFactory(this));


        // Initialize and register the SmAttribute
        this.implementationAtt = new ImplementationSmAttribute();
        this.implementationAtt.init("Implementation", this, String.class );
        registerAttribute(this.implementationAtt);


        // Initialize and register the SmDependency

    }

    @objid ("ab7a4052-8574-4dfe-b947-15cea60cf88c")
    public SmAttribute getImplementationAtt() {
        if (this.implementationAtt == null) {
        	this.implementationAtt = this.getAttributeDef("Implementation");
        }
        return this.implementationAtt;
    }

    @objid ("0483cc8e-a109-4931-801c-83c5250b9ecb")
    private static class BpmnUserTaskObjectFactory implements ISmObjectFactory {
        @objid ("89edb84b-5903-4b1b-8619-5cc47860d228")
        private BpmnUserTaskSmClass smClass;

        @objid ("152f9b6f-0146-496b-a42f-e156c33143ad")
        public BpmnUserTaskObjectFactory(BpmnUserTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("497177b0-3d96-4727-8b80-739aedd2b2a1")
        @Override
        public ISmObjectData createData() {
            return new BpmnUserTaskData(this.smClass);
        }

        @objid ("5d9cc615-f4b6-450f-bfaa-695a66985ade")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnUserTaskImpl();
        }

    }

    @objid ("e94826de-7be1-4e2b-9929-7555651c3778")
    public static class ImplementationSmAttribute extends SmAttribute {
        @objid ("0089259f-aa47-4e3b-aefa-f50432f76f9c")
        public Object getValue(ISmObjectData data) {
            return ((BpmnUserTaskData) data).mImplementation;
        }

        @objid ("8249068e-01a1-4a5c-bba8-3caa3ed01fbe")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnUserTaskData) data).mImplementation = value;
        }

    }

}
