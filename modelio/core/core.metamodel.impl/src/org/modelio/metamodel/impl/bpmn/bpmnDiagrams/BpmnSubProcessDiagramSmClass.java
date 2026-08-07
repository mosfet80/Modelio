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
package org.modelio.metamodel.impl.bpmn.bpmnDiagrams;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnSubProcessDiagram;
import org.modelio.metamodel.diagrams.BehaviorDiagram;
import org.modelio.metamodel.impl.diagrams.BehaviorDiagramSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a7dbfe06-55c5-408b-acf6-07a470a082f9")
public class BpmnSubProcessDiagramSmClass extends BehaviorDiagramSmClass {
    @objid ("409888fe-8d0c-4fa5-8f78-ec59433b30a7")
    public BpmnSubProcessDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("571ec086-752a-446c-92df-15b854070832")
    @Override
    public String getName() {
        return "BpmnSubProcessDiagram";

    }

    @objid ("00ed063f-f0ea-4f7f-9906-b8e29d622005")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("db18d1e9-4e9f-4d9d-b5ea-c7a3f1b79a48")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSubProcessDiagram.class;

    }

    @objid ("dcefe49d-9e3e-48c8-bdf4-48bfb06411e3")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("1c90bcd5-a6f5-4869-9c66-a4d7cfca9fd7")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a8ed99f1-130b-4129-ae73-105f570688e9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorDiagram.MQNAME);
        this.registerFactory(new BpmnSubProcessDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("41592cc1-b0f6-46d7-9ca1-8c87985bc725")
    private static class BpmnSubProcessDiagramObjectFactory implements ISmObjectFactory {
        @objid ("1ad16a2a-83d0-4f1e-aff5-09bf2b52f35b")
        private BpmnSubProcessDiagramSmClass smClass;

        @objid ("13d951af-28ff-484c-945f-d1d461bbc042")
        public BpmnSubProcessDiagramObjectFactory(BpmnSubProcessDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("72745810-c9fb-4f48-a674-20e1daa4906c")
        @Override
        public ISmObjectData createData() {
            return new BpmnSubProcessDiagramData(this.smClass);
        }

        @objid ("a58d1d07-b385-4b01-87d8-ee9d6e9239c5")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnSubProcessDiagramImpl();
        }

    }

}
