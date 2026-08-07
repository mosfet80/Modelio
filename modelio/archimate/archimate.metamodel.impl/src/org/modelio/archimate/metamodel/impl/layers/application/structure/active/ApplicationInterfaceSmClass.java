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
package org.modelio.archimate.metamodel.impl.layers.application.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1112c9a2-3986-48c6-9cf5-d3125c84b4b1")
public class ApplicationInterfaceSmClass extends ExternalActiveStructureElementSmClass {
    @objid ("5953c8f2-1897-4f03-957f-ed19a2621e63")
    public ApplicationInterfaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1bbb080d-4c62-4216-9d2a-fd5de2b51d01")
    @Override
    public String getName() {
        return "ApplicationInterface";

    }

    @objid ("92a1d56d-295b-45d9-b90f-117bae02953e")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("1b5a5aa9-cc5c-47a8-a02e-8475990b7d29")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationInterface.class;

    }

    @objid ("2c455563-99b8-4842-aa32-3bf2be55474d")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("6bee9bf0-f028-4914-b069-4c30db6fc4bb")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("84893c63-0f8c-46d6-b64c-e1e39585b297")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ExternalActiveStructureElement.MQNAME);
        this.registerFactory(new ApplicationInterfaceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("3226c6a1-2ead-4cf9-b94e-2dc2d7bea244")
    private static class ApplicationInterfaceObjectFactory implements ISmObjectFactory {
        @objid ("1aa392aa-7198-408d-9373-0fdc5aa4e216")
        private ApplicationInterfaceSmClass smClass;

        @objid ("00427da2-8be1-440b-9f4a-44a6f3428940")
        public ApplicationInterfaceObjectFactory(ApplicationInterfaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2c7568cb-af6d-4c3d-b4e0-040518b28cd4")
        @Override
        public ISmObjectData createData() {
            return new ApplicationInterfaceData(this.smClass);
        }

        @objid ("aa70ca73-d744-4114-a348-0d8e529e1e9c")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationInterfaceImpl();
        }

    }

}
