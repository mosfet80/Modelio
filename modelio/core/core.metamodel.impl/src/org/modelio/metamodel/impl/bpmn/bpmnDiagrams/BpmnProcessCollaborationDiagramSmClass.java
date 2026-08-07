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

@objid ("226a58ba-6af0-42d1-8b64-93f2d9615af2")
public class BpmnProcessCollaborationDiagramSmClass extends BehaviorDiagramSmClass {
    @objid ("d99b9ee1-98c7-4d91-8a54-132009c7ce8b")
    public BpmnProcessCollaborationDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6ca955dd-cccb-408c-b342-7caee9ab1b42")
    @Override
    public String getName() {
        return "BpmnProcessCollaborationDiagram";

    }

    @objid ("00c4fccb-0694-43d9-99cc-a089c7d1ef1b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("52bce4ca-4118-4009-b13c-25fcf4519bc2")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnProcessCollaborationDiagram.class;

    }

    @objid ("e53e4224-7662-4962-82f5-809edca0a02e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("db4fe7ba-1530-4afa-9fba-509310be649a")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("0a5ab93f-3b13-4e84-88f8-c6007449e13e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorDiagram.MQNAME);
        this.registerFactory(new BpmnProcessCollaborationDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("02cfe52b-cf34-43d5-a6f9-967260fe7dc7")
    private static class BpmnProcessCollaborationDiagramObjectFactory implements ISmObjectFactory {
        @objid ("9721d387-9cc1-488f-8711-c78d26877e7f")
        private BpmnProcessCollaborationDiagramSmClass smClass;

        @objid ("2b96458a-ffb0-462e-8c62-5d0df4601143")
        public BpmnProcessCollaborationDiagramObjectFactory(BpmnProcessCollaborationDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("391e3ceb-b89c-44ef-b505-d8a29a25332a")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("6bd1eff9-81b9-4d02-bd43-ee253dbde285")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
