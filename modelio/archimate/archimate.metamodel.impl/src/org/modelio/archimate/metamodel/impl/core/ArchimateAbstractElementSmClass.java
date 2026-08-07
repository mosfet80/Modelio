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
package org.modelio.archimate.metamodel.impl.core;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.metamodel.impl.uml.infrastructure.ModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1417f06b-2fdc-43d7-aa51-24c2cd6ba0a9")
public class ArchimateAbstractElementSmClass extends ModelElementSmClass {
    @objid ("69a141f0-d78c-4400-b594-4911510406e1")
    public ArchimateAbstractElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e50acefd-489d-40ef-814b-ff6dafd34be1")
    @Override
    public String getName() {
        return "ArchimateAbstractElement";

    }

    @objid ("2c2be0a8-cd83-4ff7-81f4-65c34f90bc35")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("e2ffe4ec-e420-465f-8358-04d0a5a04ef4")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ArchimateAbstractElement.class;

    }

    @objid ("54b08732-f213-45ab-97df-0eb02fa919a3")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ea1419c3-e8da-4954-a89b-c775b95e3a40")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("1e6a6269-2d81-47ac-a72f-f02ea9880ba5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ModelElement.MQNAME);
        this.registerFactory(new ArchimateAbstractElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("696a21e5-cfd2-43c0-b339-037fe7bb303e")
    private static class ArchimateAbstractElementObjectFactory implements ISmObjectFactory {
        @objid ("1ac7d5d0-698d-49d9-9e5b-1f63c5989e45")
        private ArchimateAbstractElementSmClass smClass;

        @objid ("4f292e02-44cb-4e62-a084-3ba9285cbba1")
        public ArchimateAbstractElementObjectFactory(ArchimateAbstractElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a3429afe-d8dc-497c-9bfd-bfeb3062f3d6")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("0c033165-adb2-49ab-b061-2d9a8b748209")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
