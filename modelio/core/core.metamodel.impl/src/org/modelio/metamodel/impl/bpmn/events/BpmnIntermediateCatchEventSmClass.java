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
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnIntermediateCatchEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("98fae2f8-e4cc-4296-8be0-a8346788e6bd")
public class BpmnIntermediateCatchEventSmClass extends BpmnCatchEventSmClass {
    @objid ("0b173218-fa81-4dea-8f37-fb4edc8e4a54")
    public BpmnIntermediateCatchEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1cf69042-e95f-4bdd-85ec-75040dab5447")
    @Override
    public String getName() {
        return "BpmnIntermediateCatchEvent";

    }

    @objid ("1d361283-2a2c-4154-8eb2-86f0f239aaa9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("bc9e4942-9284-4a8e-b885-ce509ba1464a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnIntermediateCatchEvent.class;

    }

    @objid ("6d764da0-c344-42eb-a1b4-0cfda045da27")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("eb55ee87-1c61-4fcb-be4e-1fed682daa53")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d42ca9e7-5da9-40dd-abe5-77f252d244c1")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnCatchEvent.MQNAME);
        this.registerFactory(new BpmnIntermediateCatchEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("faf2d465-3ce2-45fb-b523-b13488382e11")
    private static class BpmnIntermediateCatchEventObjectFactory implements ISmObjectFactory {
        @objid ("caa2c431-de46-4378-8320-3498b91c725d")
        private BpmnIntermediateCatchEventSmClass smClass;

        @objid ("51ff128e-8c7d-4959-b00e-891e23d9fa5b")
        public BpmnIntermediateCatchEventObjectFactory(BpmnIntermediateCatchEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a8c8d389-88ae-413f-9b50-8575eb32793b")
        @Override
        public ISmObjectData createData() {
            return new BpmnIntermediateCatchEventData(this.smClass);
        }

        @objid ("e31daaa1-8082-4d01-82e4-f7a6aa5ebbd9")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnIntermediateCatchEventImpl();
        }

    }

}
