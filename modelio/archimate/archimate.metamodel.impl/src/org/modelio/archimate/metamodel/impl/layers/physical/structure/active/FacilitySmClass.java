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
package org.modelio.archimate.metamodel.impl.layers.physical.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.NodeSmClass;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Facility;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("3b05a446-a72b-4579-ab2c-ed71a0658dd3")
public class FacilitySmClass extends NodeSmClass {
    @objid ("78abf278-65ae-49b9-83fe-bd51ae6cfaab")
    public FacilitySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("cb5b1de8-d17a-4346-b21b-ec02ec03df64")
    @Override
    public String getName() {
        return "Facility";

    }

    @objid ("0dff4b81-2c60-4d76-b75c-e1a3119c6ba1")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("8c34aa7c-f503-47e7-9249-cbe51a5d9552")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Facility.class;

    }

    @objid ("f23d8d6b-e020-4564-a551-1762febcf979")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("a2ac5bf9-8ef5-4472-8fdc-7d020b867c4e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6e9af148-050e-46d0-aae6-642b4f286aae")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Node.MQNAME);
        this.registerFactory(new FacilityObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f5bfa3ea-8f1e-4fe1-9e46-aa8e58267ae2")
    private static class FacilityObjectFactory implements ISmObjectFactory {
        @objid ("6ecc1ca6-b98c-4b3a-820b-7c0267db7d6f")
        private FacilitySmClass smClass;

        @objid ("bc340457-5d98-4303-ba3d-d895e3e8ef58")
        public FacilityObjectFactory(FacilitySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ab878bfb-93d7-4f5e-b4d6-ac71df47629d")
        @Override
        public ISmObjectData createData() {
            return new FacilityData(this.smClass);
        }

        @objid ("464a7600-ad6e-44a1-84df-9fbf5a8192eb")
        @Override
        public SmObjectImpl createImpl() {
            return new FacilityImpl();
        }

    }

}
