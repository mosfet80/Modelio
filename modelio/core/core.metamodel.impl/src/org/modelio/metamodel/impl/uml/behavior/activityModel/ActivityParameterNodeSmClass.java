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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityParameterNode;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b0385a6c-1cd1-4e16-a2d8-4b18d6303053")
public class ActivityParameterNodeSmClass extends ObjectNodeSmClass {
    @objid ("18b3a943-f15e-4cfb-9832-8656f9caff8e")
    public ActivityParameterNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("4a1bac3d-e477-44ea-a6ee-1f3d466c3043")
    @Override
    public String getName() {
        return "ActivityParameterNode";

    }

    @objid ("514703dc-0753-4ffe-bd38-c4a99fbba6bd")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("bf157172-155b-4635-8c12-33a0d67e09bc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityParameterNode.class;

    }

    @objid ("0acfc4f1-3d91-4dba-9673-b21a9530686f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("d7ad3bab-c382-4535-830e-9cd2e929a49e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7eefdad6-8cf1-46ef-bc65-5637a1ba4d7d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ObjectNode.MQNAME);
        this.registerFactory(new ActivityParameterNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("9eec084b-0001-4717-98c8-17dee8a26c2b")
    private static class ActivityParameterNodeObjectFactory implements ISmObjectFactory {
        @objid ("549655c5-3428-4b57-a1e6-944d5cd87c88")
        private ActivityParameterNodeSmClass smClass;

        @objid ("3566ece0-d31e-4220-8f05-13b6ba5f4453")
        public ActivityParameterNodeObjectFactory(ActivityParameterNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2dea2e5e-543b-49cf-a62b-2ff6ebff2acb")
        @Override
        public ISmObjectData createData() {
            return new ActivityParameterNodeData(this.smClass);
        }

        @objid ("84e914da-1267-4f95-af80-0038a932d077")
        @Override
        public SmObjectImpl createImpl() {
            return new ActivityParameterNodeImpl();
        }

    }

}
