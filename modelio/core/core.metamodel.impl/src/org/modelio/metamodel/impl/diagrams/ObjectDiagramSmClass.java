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
import org.modelio.metamodel.diagrams.ObjectDiagram;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("8ed0684b-53ee-4f59-8535-e31ca2634c95")
public class ObjectDiagramSmClass extends StaticDiagramSmClass {
    @objid ("a833c19d-375d-4bc7-a37b-ea3f5edfd4ae")
    public ObjectDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a37d30df-8f04-4c43-9872-602fc3e04f2c")
    @Override
    public String getName() {
        return "ObjectDiagram";

    }

    @objid ("3262a267-09ee-420f-954d-e3a830df2f53")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d3a82486-09bd-49d3-972f-888a2c872614")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ObjectDiagram.class;

    }

    @objid ("ee957f2b-4d98-4e45-ace4-230d559fb948")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("2854205e-fb9a-4988-b2c4-8e6564bded64")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e2cdac0a-2da7-4df1-a895-1c99d1463810")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StaticDiagram.MQNAME);
        this.registerFactory(new ObjectDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("6942dd2f-8762-43fc-9c13-06f024a09aef")
    private static class ObjectDiagramObjectFactory implements ISmObjectFactory {
        @objid ("1e96d913-ec14-490e-b0ef-764822daf487")
        private ObjectDiagramSmClass smClass;

        @objid ("c3abda3b-9213-4205-badc-88f24f6b379a")
        public ObjectDiagramObjectFactory(ObjectDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4adc3f56-88e4-433d-b207-ce8037017382")
        @Override
        public ISmObjectData createData() {
            return new ObjectDiagramData(this.smClass);
        }

        @objid ("7436bfd1-5052-47c6-86c4-7a34669d8a93")
        @Override
        public SmObjectImpl createImpl() {
            return new ObjectDiagramImpl();
        }

    }

}
