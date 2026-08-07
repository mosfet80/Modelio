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
package org.modelio.archimate.metamodel.impl.layers.application.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.InternalActiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.InternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("aa9d938f-e4d5-4e0e-a700-963b59cc8ce4")
public class ApplicationInternalActiveStructureElementSmClass extends InternalActiveStructureElementSmClass {
    @objid ("b10d1c8f-e47a-4ed8-819a-1d66aa1ea35d")
    public ApplicationInternalActiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9aa2ec49-6a11-4728-b30b-143eeb6c5f6a")
    @Override
    public String getName() {
        return "ApplicationInternalActiveStructureElement";

    }

    @objid ("c473591d-7fed-480b-ab0b-e63d459f2eb5")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("5cb0b059-2e48-49cc-b6d1-e8b78889b0ef")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationInternalActiveStructureElement.class;

    }

    @objid ("a9a36447-531d-4229-9de9-ea34a2bbae13")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6e9db384-8f6c-4716-bd00-1ed67029c9fc")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("b99f0da3-6bde-4668-8665-d230b7029edb")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InternalActiveStructureElement.MQNAME);
        this.registerFactory(new ApplicationInternalActiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("7b59e229-638a-4647-9d87-cfea485129d4")
    private static class ApplicationInternalActiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("f023fee6-b171-45c0-88dd-a87dc902d08c")
        private ApplicationInternalActiveStructureElementSmClass smClass;

        @objid ("4119d482-2be3-4ed7-8865-f8fc0ab04630")
        public ApplicationInternalActiveStructureElementObjectFactory(ApplicationInternalActiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2c904673-ce90-4a10-9a7b-b8fb013ac26b")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("cefc5006-62ba-4a2f-8f58-ce8d2891055e")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
