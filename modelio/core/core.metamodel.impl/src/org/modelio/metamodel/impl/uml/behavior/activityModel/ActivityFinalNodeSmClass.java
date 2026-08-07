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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityFinalNode;
import org.modelio.metamodel.uml.behavior.activityModel.FinalNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0e2fb08a-7baa-443b-b80d-f9ba53347a78")
public class ActivityFinalNodeSmClass extends FinalNodeSmClass {
    @objid ("c9907e00-b737-4161-8ee2-a1bd93e81130")
    public ActivityFinalNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d074ea6a-8cac-4678-a3e7-c22874c8178b")
    @Override
    public String getName() {
        return "ActivityFinalNode";

    }

    @objid ("08ac81c2-a0ab-4395-98d8-65815c387cad")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f0265e3f-d0d9-4386-a88d-518874ec5001")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityFinalNode.class;

    }

    @objid ("f4b753ba-30bd-4fc9-acab-ec3dfcd7951d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f20d3c7a-8208-45da-9d22-6109fd3d82e4")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("493e3aad-1dbb-4aae-b8f3-50ea42732929")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(FinalNode.MQNAME);
        this.registerFactory(new ActivityFinalNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("64be6c38-208f-4d34-862e-12df73372e9b")
    private static class ActivityFinalNodeObjectFactory implements ISmObjectFactory {
        @objid ("9e60743f-e98e-4296-a248-6eb2ef902b32")
        private ActivityFinalNodeSmClass smClass;

        @objid ("560afb1f-32eb-4be0-b8bb-71e603411300")
        public ActivityFinalNodeObjectFactory(ActivityFinalNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4fb2c924-9f3f-44b3-a79e-9d23eb2db8ef")
        @Override
        public ISmObjectData createData() {
            return new ActivityFinalNodeData(this.smClass);
        }

        @objid ("a8792539-a61b-42a4-a9a4-e95b324dc5f3")
        @Override
        public SmObjectImpl createImpl() {
            return new ActivityFinalNodeImpl();
        }

    }

}
