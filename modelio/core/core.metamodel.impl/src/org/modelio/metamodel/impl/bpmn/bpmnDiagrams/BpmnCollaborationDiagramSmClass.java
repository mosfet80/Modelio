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
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnCollaborationDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessCollaborationDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("32f2f9cc-ecfb-41bc-a91c-4765f601994c")
public class BpmnCollaborationDiagramSmClass extends BpmnProcessCollaborationDiagramSmClass {
    @objid ("a5fb89b3-6aaa-4d92-a9da-fd8d022f24d6")
    public BpmnCollaborationDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9e55817b-2bbd-4357-b3ae-209fcf3b3e09")
    @Override
    public String getName() {
        return "BpmnCollaborationDiagram";

    }

    @objid ("9c5278e5-5680-4106-bb18-b142963b01c8")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0892337e-5eb4-4a59-a535-4ac0ca7886bb")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnCollaborationDiagram.class;

    }

    @objid ("d7b424d9-697a-4d4e-9273-341a011ba3ec")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("fb4a8489-3571-4e22-809e-8901cecdf3c6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("36df431b-f1d8-4ac9-994b-172d89066e7d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnProcessCollaborationDiagram.MQNAME);
        this.registerFactory(new BpmnCollaborationDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("bb6b345c-893a-4c6e-ac5c-9cf039e8871c")
    private static class BpmnCollaborationDiagramObjectFactory implements ISmObjectFactory {
        @objid ("71da02e2-abb0-47f6-9773-6693921f3bd9")
        private BpmnCollaborationDiagramSmClass smClass;

        @objid ("34d2842f-7238-46fc-8718-0fcfd166638b")
        public BpmnCollaborationDiagramObjectFactory(BpmnCollaborationDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("303670ab-2632-425b-8f83-d3e6958364ff")
        @Override
        public ISmObjectData createData() {
            return new BpmnCollaborationDiagramData(this.smClass);
        }

        @objid ("24e2b62f-f503-4b17-bec8-a716c337eb4d")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnCollaborationDiagramImpl();
        }

    }

}
