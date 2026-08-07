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
import org.modelio.archimate.metamodel.layers.physical.structure.active.Equipment;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("42eec5fe-e71a-411c-9879-e1ffcf27bec7")
public class EquipmentSmClass extends NodeSmClass {
    @objid ("e56896ac-dcf9-4042-841e-7e87cf062f1f")
    public EquipmentSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5af4a186-b62c-4ab0-a11c-78a5e81023de")
    @Override
    public String getName() {
        return "Equipment";

    }

    @objid ("28b0ff4b-dbcc-43fe-96ad-2294418b7ac4")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("63de3ba1-32c7-4f18-8ed6-43cd5cdd72b4")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Equipment.class;

    }

    @objid ("589be971-c268-4561-bfbf-3b23890d7de8")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("98afd8a6-994f-4f93-a868-366a3f169dc6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8f56ffd4-65ee-4d0c-9900-5e544dba1f8b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Node.MQNAME);
        this.registerFactory(new EquipmentObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c6f35a63-ce16-4622-acc0-cfb86987b57e")
    private static class EquipmentObjectFactory implements ISmObjectFactory {
        @objid ("5d2fe435-5d22-40e7-9807-bb968b0580c0")
        private EquipmentSmClass smClass;

        @objid ("d881b341-e470-48ab-af47-5818c5595030")
        public EquipmentObjectFactory(EquipmentSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("02c2bab8-553c-456f-acec-fee096368040")
        @Override
        public ISmObjectData createData() {
            return new EquipmentData(this.smClass);
        }

        @objid ("d0a3e84c-6b14-4739-95ff-091ffbac0218")
        @Override
        public SmObjectImpl createImpl() {
            return new EquipmentImpl();
        }

    }

}
