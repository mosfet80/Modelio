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
import org.modelio.archimate.metamodel.core.generic.InternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("effe1330-4dc9-4c71-83fb-fbc314f89559")
public class InternalActiveStructureElementSmClass extends ActiveStructureElementSmClass {
    @objid ("ad11c837-abfa-4523-adbc-83bb696b3f61")
    public InternalActiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e994171e-63d4-45df-a33e-4f8f0feec80b")
    @Override
    public String getName() {
        return "InternalActiveStructureElement";

    }

    @objid ("5d2b760a-1449-4998-a12f-297cecfcb207")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("33eb249d-e113-4564-b99d-278b5678bb9b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InternalActiveStructureElement.class;

    }

    @objid ("5a8cac1e-afb8-4614-8feb-d870915c2386")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3adbf2fe-befa-4f76-9da8-02da28d38eff")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("38d93ec1-d6ab-4c3d-968b-f0631f5bbddc")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActiveStructureElement.MQNAME);
        this.registerFactory(new InternalActiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("cf8d351d-5a96-4d9d-b9cd-d33e07bd4057")
    private static class InternalActiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("9369935e-4651-49a0-8083-eebda5c71db8")
        private InternalActiveStructureElementSmClass smClass;

        @objid ("f0706a8a-85c9-45b0-9b3d-84b7a1c7817a")
        public InternalActiveStructureElementObjectFactory(InternalActiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("91da1f32-910f-4245-aa28-380a785029a0")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("d6c88a73-8826-4577-a56a-83c370d7c976")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
