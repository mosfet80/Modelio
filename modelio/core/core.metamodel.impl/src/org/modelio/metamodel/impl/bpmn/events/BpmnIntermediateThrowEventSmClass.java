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
import org.modelio.metamodel.bpmn.events.BpmnIntermediateThrowEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1cc3ec74-19cc-4a07-b45c-7f1e553dc4da")
public class BpmnIntermediateThrowEventSmClass extends BpmnThrowEventSmClass {
    @objid ("73c6f01e-b8e1-4f93-a20c-02f75c51b012")
    public BpmnIntermediateThrowEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c4470f53-6166-4209-9bda-a8e9edbec8f3")
    @Override
    public String getName() {
        return "BpmnIntermediateThrowEvent";

    }

    @objid ("3b12b59a-6c85-4eb6-a1b7-ce122dffd9b7")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3cc89129-6ed0-409c-aeb4-422d1dd28a22")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnIntermediateThrowEvent.class;

    }

    @objid ("3c1a7eca-dd1a-4f3a-ac99-d39b4790a874")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("abb2b3c0-e140-490f-8d17-fe2fd7f96a67")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0f9b9b09-5f60-4e51-90ce-0fee4eb39936")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnThrowEvent.MQNAME);
        this.registerFactory(new BpmnIntermediateThrowEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("d2504228-b459-4e42-9913-7b85d41d67e7")
    private static class BpmnIntermediateThrowEventObjectFactory implements ISmObjectFactory {
        @objid ("1484f948-8f6d-4575-832f-4a1e318b3d8d")
        private BpmnIntermediateThrowEventSmClass smClass;

        @objid ("5e378dfc-56cf-4f92-ac39-6baa8e6a2ff0")
        public BpmnIntermediateThrowEventObjectFactory(BpmnIntermediateThrowEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("93afc27a-8448-45f7-9042-32bfb50fa85b")
        @Override
        public ISmObjectData createData() {
            return new BpmnIntermediateThrowEventData(this.smClass);
        }

        @objid ("b0b7de69-09bb-44d6-9dfe-4b504777c051")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnIntermediateThrowEventImpl();
        }

    }

}
