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
package org.modelio.metamodel.impl.diagrams;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.diagrams.BehaviorDiagram;
import org.modelio.metamodel.diagrams.SequenceDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f758ab36-5b8b-41ca-b5d8-d649b4b16796")
public class SequenceDiagramSmClass extends BehaviorDiagramSmClass {
    @objid ("01422b5f-6a26-4ff7-9960-c516f3642785")
    public SequenceDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("bf5d7fbd-5747-4b7f-ba12-45d1f78d0f12")
    @Override
    public String getName() {
        return "SequenceDiagram";

    }

    @objid ("0e53ff23-060c-4b78-9390-cc968607f326")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5b279f32-d601-482e-a8b0-0003c37867cb")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return SequenceDiagram.class;

    }

    @objid ("8502f078-61bc-4dbd-b7b6-920c5656c86b")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("554069d9-b108-4a5c-8943-3f7b715c3bdb")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("690a1824-85a2-474c-8181-da340ca743f5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorDiagram.MQNAME);
        this.registerFactory(new SequenceDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("6a7a94c1-4dcd-40aa-9651-dd43ba08ddf0")
    private static class SequenceDiagramObjectFactory implements ISmObjectFactory {
        @objid ("536f1ae9-9a2e-413d-8c13-ed7884c72bd7")
        private SequenceDiagramSmClass smClass;

        @objid ("365c40c2-cbf0-4292-b965-4c6392e675c4")
        public SequenceDiagramObjectFactory(SequenceDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("883927bf-1cf1-46fc-888f-1255ed565955")
        @Override
        public ISmObjectData createData() {
            return new SequenceDiagramData(this.smClass);
        }

        @objid ("03f13323-06ad-4f52-8287-3afb6968ba35")
        @Override
        public SmObjectImpl createImpl() {
            return new SequenceDiagramImpl();
        }

    }

}
