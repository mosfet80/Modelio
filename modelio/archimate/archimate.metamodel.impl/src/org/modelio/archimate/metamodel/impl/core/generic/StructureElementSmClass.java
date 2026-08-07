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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core.generic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.generic.StructureElement;
import org.modelio.archimate.metamodel.impl.core.ElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("eadc1903-0aee-49c3-be6c-81ee7e7e83b1")
public class StructureElementSmClass extends ElementSmClass {
    @objid ("66de5eca-831a-4cab-9972-8234052c3c0d")
    public StructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1881a9ee-4fae-40ec-9b62-0a8bbe849a3d")
    @Override
    public String getName() {
        return "StructureElement";

    }

    @objid ("808a8fd7-22af-45d6-bc68-0ea72286eb0e")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("c2ae3bfa-5da8-46a8-b163-c8c6cb539923")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StructureElement.class;

    }

    @objid ("3531bcdf-d966-4fc5-a21d-c206bc7811a2")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("28184341-f842-4810-b592-fbb5fabd485a")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("780e918b-d75b-4d4a-ab09-a6a30ec222a9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Element.MQNAME);
        this.registerFactory(new StructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("880df79f-4826-4ef4-b09c-65a42b7897d2")
    private static class StructureElementObjectFactory implements ISmObjectFactory {
        @objid ("d1a6605c-692c-495e-808e-7bc17a74fc9c")
        private StructureElementSmClass smClass;

        @objid ("ea0d7222-a326-4af1-8976-f1412ae1bf10")
        public StructureElementObjectFactory(StructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("eab81894-d1da-4c1c-b1b4-ae1dabedba9f")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("ab604882-ef44-4f19-be00-ce747842a4b9")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
