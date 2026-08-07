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
import org.modelio.archimate.metamodel.core.generic.ActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.StructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("18d0a128-ecf4-4f78-80d2-1319b5a04f90")
public class ActiveStructureElementSmClass extends StructureElementSmClass {
    @objid ("22152ac9-a602-4ff1-96f3-6c13221e1720")
    public ActiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("bc23cbcb-0a2c-44f0-9eb5-666c67038d38")
    @Override
    public String getName() {
        return "ActiveStructureElement";

    }

    @objid ("72b281ad-9782-460f-af90-0f21eb29e016")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("9fbd6d54-db3c-4c13-a287-8fbb0b87115e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActiveStructureElement.class;

    }

    @objid ("34f763f0-c73d-4d92-92ad-d4bf0d0528a2")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("cbf4e57e-d8e2-40e1-b1af-8ebf46e7653b")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("eb2b81ea-099c-4319-a0bf-4e36d81dcd08")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructureElement.MQNAME);
        this.registerFactory(new ActiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("09921044-2da9-42cc-8e51-919e2e0f7817")
    private static class ActiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("1f9594be-67bc-49ab-a4c9-0531bc11ab57")
        private ActiveStructureElementSmClass smClass;

        @objid ("fcd33306-ca69-421a-ad43-72bf209cff17")
        public ActiveStructureElementObjectFactory(ActiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d3cd2753-23c4-490c-8d6e-295d68598e39")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("b1ed0ff5-52e7-4ea8-b5ca-90047beaa7e8")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
