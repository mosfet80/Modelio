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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ControlNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("3cdd22d4-0911-4788-b3a1-dd23e0f8fe44")
public class ControlNodeSmClass extends ActivityNodeSmClass {
    @objid ("7831f66d-0ec2-4e32-aa4b-158f9fa1a50c")
    public ControlNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e7e9b617-be67-4c28-9f21-2699072039d4")
    @Override
    public String getName() {
        return "ControlNode";

    }

    @objid ("53947387-4e2a-480f-993b-55a44ba52a30")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f6f44f42-ba20-4095-8e7f-1d09f5a57fc0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ControlNode.class;

    }

    @objid ("5db7df6d-614f-4703-bd8b-a7762864c181")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e0318883-610e-475b-8716-c3565e0c6636")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("dcfb63bc-dc1a-4643-acb0-6f5f5f0dede7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityNode.MQNAME);
        this.registerFactory(new ControlNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("b723b072-98d6-4e30-af94-e7eb61a2fff9")
    private static class ControlNodeObjectFactory implements ISmObjectFactory {
        @objid ("e381ac99-7edf-45b2-87ea-b9853b4364b7")
        private ControlNodeSmClass smClass;

        @objid ("0a803daf-abe8-405f-984c-645a2c270d77")
        public ControlNodeObjectFactory(ControlNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9881417c-2f63-4b88-8e37-ff94d4e78785")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("e4e26cd5-2f25-4e9e-ba80-19c2b9e73532")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
