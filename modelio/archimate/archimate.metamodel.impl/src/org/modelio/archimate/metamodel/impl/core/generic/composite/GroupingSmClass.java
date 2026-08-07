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
package org.modelio.archimate.metamodel.impl.core.generic.composite;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("72463478-1e3f-4397-8a11-fe5136848b7e")
public class GroupingSmClass extends CompositeElementSmClass {
    @objid ("757a27bd-3217-457e-a945-7a9b28604fa1")
    public GroupingSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("85fbdbc8-9583-43ee-aa6f-d59bceeff671")
    @Override
    public String getName() {
        return "Grouping";

    }

    @objid ("b779fae1-66d1-4cd5-b423-3ea289c43286")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("3741252e-b7f4-4bbc-a640-57fd6be752fb")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Grouping.class;

    }

    @objid ("eb1ef66d-06df-441c-aea8-1df7a54902fe")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("07d9e3e9-d1e7-4787-983e-fd548d2c496f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e42f6f7b-aea5-439c-ae8c-34aef534fbb0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(CompositeElement.MQNAME);
        this.registerFactory(new GroupingObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("bb7c6fe4-def4-45b2-b1b8-99fc3e65d965")
    private static class GroupingObjectFactory implements ISmObjectFactory {
        @objid ("d7b1ec67-2c67-41b6-b0fd-bf1cc20f3048")
        private GroupingSmClass smClass;

        @objid ("037a6be1-6c5a-462b-a52e-ce19ae8316a2")
        public GroupingObjectFactory(GroupingSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a7bc17c2-d464-4e4e-853b-16d2f0097775")
        @Override
        public ISmObjectData createData() {
            return new GroupingData(this.smClass);
        }

        @objid ("908d0208-4e8a-457d-9c0f-f4cd6fd0b36a")
        @Override
        public SmObjectImpl createImpl() {
            return new GroupingImpl();
        }

    }

}
