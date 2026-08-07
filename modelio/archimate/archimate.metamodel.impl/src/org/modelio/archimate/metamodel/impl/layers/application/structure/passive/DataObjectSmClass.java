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
package org.modelio.archimate.metamodel.impl.layers.application.structure.passive;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.PassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("bef638ec-dd01-4625-9522-2eea93d0b9ef")
public class DataObjectSmClass extends PassiveStructureElementSmClass {
    @objid ("b556d30c-3237-4512-9cdf-e2e544c738c3")
    public DataObjectSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("52518f9f-70f5-46a1-b8ec-a15445d66d11")
    @Override
    public String getName() {
        return "DataObject";

    }

    @objid ("030a7139-b276-4967-985b-b082d76bf3eb")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("cd10fccc-977f-4aba-a379-21a7999c3e9e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DataObject.class;

    }

    @objid ("72499cc5-5f0a-4ade-8fb3-82efd1d0aa3d")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("6c1489e0-c6c6-4a02-af50-0eb614dd0779")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("99277b36-5853-413b-8b4e-711c06dea4d3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(PassiveStructureElement.MQNAME);
        this.registerFactory(new DataObjectObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("df79b247-76b8-475c-babd-98b102a2c5bd")
    private static class DataObjectObjectFactory implements ISmObjectFactory {
        @objid ("087b44af-80e5-4a7b-8842-954a44d3a768")
        private DataObjectSmClass smClass;

        @objid ("e9d560c8-8e31-47ea-95da-8099111f9edf")
        public DataObjectObjectFactory(DataObjectSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9f7db21f-2870-486b-83a7-b6980510d794")
        @Override
        public ISmObjectData createData() {
            return new DataObjectData(this.smClass);
        }

        @objid ("f3c52d39-7595-4bea-b1f0-1ed9ca453645")
        @Override
        public SmObjectImpl createImpl() {
            return new DataObjectImpl();
        }

    }

}
