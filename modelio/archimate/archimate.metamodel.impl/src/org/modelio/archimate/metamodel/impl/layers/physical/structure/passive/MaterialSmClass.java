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
package org.modelio.archimate.metamodel.impl.layers.physical.structure.passive;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.passive.TechnologyObjectSmClass;
import org.modelio.archimate.metamodel.layers.physical.structure.passive.Material;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.TechnologyObject;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1dfab178-c6c6-4d24-99f6-a58cda96f47a")
public class MaterialSmClass extends TechnologyObjectSmClass {
    @objid ("3c79adb4-ca9a-4084-ae50-eb3e47c366e2")
    public MaterialSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("545ff866-1cd1-4619-bd0c-df5848184df1")
    @Override
    public String getName() {
        return "Material";

    }

    @objid ("97a86671-bd2a-47a2-8a02-fd0c636e574d")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("4a1e142a-b022-4f82-8022-d043c7d7e8f7")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Material.class;

    }

    @objid ("81707f81-3be8-4fd7-a73f-aa0c948fe09e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("477f0c66-3082-4584-91e3-a49c1afb3eb2")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d6506a29-2789-4d9b-ac79-6ef58ad4ef32")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyObject.MQNAME);
        this.registerFactory(new MaterialObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f2e8fe7b-51bf-427f-b952-609f2e5e46cd")
    private static class MaterialObjectFactory implements ISmObjectFactory {
        @objid ("3b404b38-7574-47d9-89e7-88bb9123b32b")
        private MaterialSmClass smClass;

        @objid ("95b464ec-18f4-46cb-b17e-5e44e66680e3")
        public MaterialObjectFactory(MaterialSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e155531b-ec58-46aa-baf7-26dc5b7ccfcd")
        @Override
        public ISmObjectData createData() {
            return new MaterialData(this.smClass);
        }

        @objid ("e53176c1-35b2-4905-8ed7-34dd163d1693")
        @Override
        public SmObjectImpl createImpl() {
            return new MaterialImpl();
        }

    }

}
