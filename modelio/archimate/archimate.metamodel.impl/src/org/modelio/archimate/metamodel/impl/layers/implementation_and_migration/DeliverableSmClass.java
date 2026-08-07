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
package org.modelio.archimate.metamodel.impl.layers.implementation_and_migration;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.PassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("acca713a-a5b6-4d24-aa41-bb0909226b37")
public class DeliverableSmClass extends PassiveStructureElementSmClass {
    @objid ("7112a891-0330-482e-a7d2-70d085243791")
    public DeliverableSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("61cc1ed6-b859-48b3-b71c-f371f478bfef")
    @Override
    public String getName() {
        return "Deliverable";

    }

    @objid ("d9079814-513d-4a73-a880-8d063e5892f8")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("7c720144-db72-4b86-9fee-0cb424c6e49c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Deliverable.class;

    }

    @objid ("40282c36-611e-458b-a451-d90cd563e4f3")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("78fac824-2444-4af3-860e-33da6a32cdc8")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1dd75f74-698b-4507-919f-968425cf4361")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(PassiveStructureElement.MQNAME);
        this.registerFactory(new DeliverableObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("12b62b9c-8633-4b19-a832-c80a9b8ed47d")
    private static class DeliverableObjectFactory implements ISmObjectFactory {
        @objid ("f9e174aa-298d-41a4-8919-a3a02f812ab9")
        private DeliverableSmClass smClass;

        @objid ("3f18eda7-6fb2-44b9-955a-ff41d768a515")
        public DeliverableObjectFactory(DeliverableSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a0aa15ef-9233-4b3d-af62-1bfa575869bd")
        @Override
        public ISmObjectData createData() {
            return new DeliverableData(this.smClass);
        }

        @objid ("2aa74469-e328-4e32-a316-5b3d24dc90f1")
        @Override
        public SmObjectImpl createImpl() {
            return new DeliverableImpl();
        }

    }

}
