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
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.impl.core.ElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("7d1e5853-63d0-4f4e-9293-e466714a5173")
public class BehaviorElementSmClass extends ElementSmClass {
    @objid ("6aa50627-21be-4450-8b6a-ed16b07a43c2")
    public BehaviorElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b50fa76d-a7ef-48ec-8ebc-d199ed87bf12")
    @Override
    public String getName() {
        return "BehaviorElement";

    }

    @objid ("44513e24-c870-494a-a828-352782cf334b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("7ded75b5-3254-48ee-99ac-7f945a5e4d0e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BehaviorElement.class;

    }

    @objid ("6651faa6-3768-4d8e-9c7d-7cb16838f884")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5f3b26aa-0155-4935-9c7b-0941ab8737ac")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("eee3ab76-140b-4e2e-9a7e-5801f11a83aa")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Element.MQNAME);
        this.registerFactory(new BehaviorElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("b0ab16b9-366c-4984-b272-427ccc487a1e")
    private static class BehaviorElementObjectFactory implements ISmObjectFactory {
        @objid ("dccbadff-82f5-4a2d-bf7c-bafe807634a5")
        private BehaviorElementSmClass smClass;

        @objid ("704d8a5d-3b00-429d-a6c0-b62c46d5fac5")
        public BehaviorElementObjectFactory(BehaviorElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5ab51fc8-f4da-4b80-9a19-774232229df3")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("68df68fd-aa44-49eb-b69e-bfee068d991c")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
