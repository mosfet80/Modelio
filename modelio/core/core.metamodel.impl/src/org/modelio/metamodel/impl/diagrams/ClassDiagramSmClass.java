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
import org.modelio.metamodel.diagrams.ClassDiagram;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("9c163ab9-ebb8-4cba-afa9-cc99ba5c68b0")
public class ClassDiagramSmClass extends StaticDiagramSmClass {
    @objid ("43394fca-5705-45cb-b7f6-edf80776497b")
    public ClassDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("60c0971b-349e-4f69-a970-35e477d76765")
    @Override
    public String getName() {
        return "ClassDiagram";

    }

    @objid ("d486050f-7ac6-43d6-bf2c-6695f8759cad")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0a583a76-198c-4c6e-a7c6-0e56a7b8abad")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ClassDiagram.class;

    }

    @objid ("3c4c8066-576c-463c-b773-d89d49d25998")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("363da52a-17c9-4f36-9e4f-ac28f105bb08")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2f32f153-652b-4691-88b1-cf10a70bcaa3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StaticDiagram.MQNAME);
        this.registerFactory(new ClassDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("ba3a511c-6d1f-4a6c-acc5-a3f8cad06792")
    private static class ClassDiagramObjectFactory implements ISmObjectFactory {
        @objid ("1a06d88e-ef71-453a-ad9f-5032f420bfb7")
        private ClassDiagramSmClass smClass;

        @objid ("058b8e32-0222-48f2-9990-d6ccff0978b1")
        public ClassDiagramObjectFactory(ClassDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b6248d88-c7cd-425e-893a-588e05c4eadd")
        @Override
        public ISmObjectData createData() {
            return new ClassDiagramData(this.smClass);
        }

        @objid ("036239a7-0434-4188-b3a2-41c5be2fd553")
        @Override
        public SmObjectImpl createImpl() {
            return new ClassDiagramImpl();
        }

    }

}
