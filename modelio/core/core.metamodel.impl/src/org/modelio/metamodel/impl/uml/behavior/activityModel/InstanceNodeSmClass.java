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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.InstanceNode;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("862cba32-9690-4ed1-9234-5f4f1162a549")
public class InstanceNodeSmClass extends ObjectNodeSmClass {
    @objid ("38cfc4ae-eee4-4273-ad83-bc606cb4a49d")
    public InstanceNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("513c25a2-e3d2-4a1c-8393-792e1f088e1d")
    @Override
    public String getName() {
        return "InstanceNode";

    }

    @objid ("ffe5199b-3a78-463d-b505-b010dcc23338")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("cd8f7702-7560-4c38-b85b-d18faf7b1690")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InstanceNode.class;

    }

    @objid ("3d825f9e-931d-4fbc-971d-fe69680835a6")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("67c4b30b-a02b-45ab-bd80-cdbfb15fb2d9")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0328ca48-8be3-40fa-8290-ba062483f7ba")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ObjectNode.MQNAME);
        this.registerFactory(new InstanceNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("75e3ae5c-0c46-4af1-a783-7d9df7c9caad")
    private static class InstanceNodeObjectFactory implements ISmObjectFactory {
        @objid ("209e3bda-9325-42ce-8143-2ce3309165be")
        private InstanceNodeSmClass smClass;

        @objid ("61fc4da2-9d1c-4e60-beb5-13659c94b6ab")
        public InstanceNodeObjectFactory(InstanceNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4cc8257b-5eb8-4ea4-9073-3cc050671010")
        @Override
        public ISmObjectData createData() {
            return new InstanceNodeData(this.smClass);
        }

        @objid ("73d7ac37-c2f5-4897-9570-5a6a777b761e")
        @Override
        public SmObjectImpl createImpl() {
            return new InstanceNodeImpl();
        }

    }

}
