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
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessCollaborationDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessDesignDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("d6b8d28d-7300-4fd1-85aa-087ef09e54d6")
public class BpmnProcessDesignDiagramSmClass extends BpmnProcessCollaborationDiagramSmClass {
    @objid ("40325d05-22dd-4271-ae85-1c03d2568bfc")
    public BpmnProcessDesignDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f3709f57-779a-4b1c-bbbc-ba760d5d0373")
    @Override
    public String getName() {
        return "BpmnProcessDesignDiagram";

    }

    @objid ("4d1bdbf6-aee4-4eff-993e-a08b929f8948")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("7c23c645-efb1-4aa5-a252-727d97bbb976")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnProcessDesignDiagram.class;

    }

    @objid ("d1ffdf99-44cc-44a9-9983-ff43a9438750")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("5994a3e4-4f2e-4fee-a67c-13e9602263aa")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("201f3001-92a4-4f2d-adfb-9cf40f2d11ba")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnProcessCollaborationDiagram.MQNAME);
        this.registerFactory(new BpmnProcessDesignDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a15c2251-15c5-44de-8f45-19b4ae42e0f0")
    private static class BpmnProcessDesignDiagramObjectFactory implements ISmObjectFactory {
        @objid ("854b73c6-1d89-415f-904e-23b01795c19f")
        private BpmnProcessDesignDiagramSmClass smClass;

        @objid ("940d8978-b495-4ab9-ab76-b8bc46dbcf75")
        public BpmnProcessDesignDiagramObjectFactory(BpmnProcessDesignDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c49d8892-2627-44ba-8a0b-7e6c0460b29c")
        @Override
        public ISmObjectData createData() {
            return new BpmnProcessDesignDiagramData(this.smClass);
        }

        @objid ("409735f1-2ebb-45fd-b984-f0a97409ce1f")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnProcessDesignDiagramImpl();
        }

    }

}
