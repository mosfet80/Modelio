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
import org.modelio.metamodel.bpmn.events.BpmnEndEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("26197e71-813e-4e29-85ae-553ffa4bcfed")
public class BpmnEndEventSmClass extends BpmnThrowEventSmClass {
    @objid ("dd461ecf-7f3e-42be-b302-3094a83597ff")
    public BpmnEndEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6720c659-2e72-42cc-9103-8c30c6fb5e3e")
    @Override
    public String getName() {
        return "BpmnEndEvent";

    }

    @objid ("a50de963-7d65-4ed7-b22e-6d5570b85c78")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("35659a14-5e65-49ea-96f6-93e3f048b4bc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnEndEvent.class;

    }

    @objid ("e3da2c86-3cfd-416e-8fe0-fe6093ec8c4b")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a8bdc7ab-5e49-482d-adbd-096b52d1e248")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1ad26aa6-00ea-4e5d-97a3-9f05d7a13e3c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnThrowEvent.MQNAME);
        this.registerFactory(new BpmnEndEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("75605232-2271-4387-a9a8-b9b7f44426a8")
    private static class BpmnEndEventObjectFactory implements ISmObjectFactory {
        @objid ("2a80ff8e-7eee-45d8-96d3-fa609fdf9dbb")
        private BpmnEndEventSmClass smClass;

        @objid ("ca3228c0-1da7-4393-8f18-8891f3a4a4c6")
        public BpmnEndEventObjectFactory(BpmnEndEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("684a4caf-7d51-4381-b0cb-c33643b8120d")
        @Override
        public ISmObjectData createData() {
            return new BpmnEndEventData(this.smClass);
        }

        @objid ("6013fcac-2058-479d-a040-ba0cde4d5176")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnEndEventImpl();
        }

    }

}
