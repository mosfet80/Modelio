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
import org.modelio.metamodel.diagrams.CompositeStructureDiagram;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("96f7f998-24f2-4040-be32-3fdb756e6161")
public class CompositeStructureDiagramSmClass extends StaticDiagramSmClass {
    @objid ("70e4a975-c18a-44a5-b5a3-6ee361adb950")
    public CompositeStructureDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6fe0641a-00d8-41a5-8ce9-edee0727e09c")
    @Override
    public String getName() {
        return "CompositeStructureDiagram";

    }

    @objid ("35f70c54-9ef1-45f3-9050-bde3509ed69c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("07b9822e-cb9e-49b1-8bb5-dd3bcd78c731")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CompositeStructureDiagram.class;

    }

    @objid ("16289206-76ff-4b50-b4cd-435210e68468")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("808d8521-b888-4e0a-88b5-dd250e6d6b24")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a6b410d3-7471-412a-a8bf-a20ee8e678c6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StaticDiagram.MQNAME);
        this.registerFactory(new CompositeStructureDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("065f73d9-72bb-46f3-89f0-776ee02e152a")
    private static class CompositeStructureDiagramObjectFactory implements ISmObjectFactory {
        @objid ("42edbac6-d3f8-4a12-9a25-2b679645b6c6")
        private CompositeStructureDiagramSmClass smClass;

        @objid ("ecd5f8e0-95f6-43a3-962a-47af1e9348b6")
        public CompositeStructureDiagramObjectFactory(CompositeStructureDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("85347ce9-c892-48f8-996f-51e28d653dac")
        @Override
        public ISmObjectData createData() {
            return new CompositeStructureDiagramData(this.smClass);
        }

        @objid ("91ce6703-d1c5-4ea0-96bb-e11454053cf2")
        @Override
        public SmObjectImpl createImpl() {
            return new CompositeStructureDiagramImpl();
        }

    }

}
