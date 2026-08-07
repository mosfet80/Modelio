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
package org.modelio.archimate.metamodel.impl.relationships.structural;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f9576bfc-2c50-4ae3-8e2a-29122a232b03")
public class RealizationSmClass extends StructuralRelationshipSmClass {
    @objid ("25a298af-f621-436f-8f3c-f65204285977")
    public RealizationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b83b3682-096d-49cb-b4ac-1bef00e027bc")
    @Override
    public String getName() {
        return "Realization";

    }

    @objid ("d9c14a27-3b23-4fac-9004-877db32b8a31")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("5c85720a-2a15-477a-a00d-339c7e3ccecf")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Realization.class;

    }

    @objid ("daf040c6-e510-4fa6-a626-152e3ef6fe7a")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("72fc2e6a-c78e-4500-9fcc-e54d1c1f4f9b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f3860ffb-b5f6-4b0f-bea0-c4522eb0a120")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuralRelationship.MQNAME);
        this.registerFactory(new RealizationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("e6bff941-7e4b-4723-8880-410555d30df3")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("9915b799-5916-4e5c-af56-c2f3a82865d8")
    private static class RealizationObjectFactory implements ISmObjectFactory {
        @objid ("3bde0cbd-a58f-43f9-9c95-3d8b023d6bcf")
        private RealizationSmClass smClass;

        @objid ("81277c70-1593-416b-8ebf-adb090745fbe")
        public RealizationObjectFactory(RealizationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e45e6f20-9d37-4968-aaf1-8d2a303e2bbe")
        @Override
        public ISmObjectData createData() {
            return new RealizationData(this.smClass);
        }

        @objid ("e3a859ee-3a26-46d4-b75a-67fa2f66f528")
        @Override
        public SmObjectImpl createImpl() {
            return new RealizationImpl();
        }

    }

}
