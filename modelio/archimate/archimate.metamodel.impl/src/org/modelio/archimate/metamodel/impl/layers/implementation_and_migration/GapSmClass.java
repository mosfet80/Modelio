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
package org.modelio.archimate.metamodel.impl.layers.implementation_and_migration;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.PassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("fd1bb51e-be5b-487c-8556-bcbee63567cd")
public class GapSmClass extends PassiveStructureElementSmClass {
    @objid ("a035243f-e921-4952-86c9-c2fd0a017aee")
    public GapSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d4c298f9-f366-4f19-b46c-e33929d93c21")
    @Override
    public String getName() {
        return "Gap";

    }

    @objid ("95e6fc7c-c127-4b6a-ab58-6315637118bb")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("9915f55d-fad8-4e22-9191-257394efed9d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Gap.class;

    }

    @objid ("7f54e4f6-54d7-4f9c-b689-b3473b4dee3c")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("16d0a988-2f89-4a78-9b7d-c02c5d959ee5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("46fd976d-5dcb-4225-9a8c-bf107f18f66d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(PassiveStructureElement.MQNAME);
        this.registerFactory(new GapObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("234dd2a5-4db8-40dc-86b2-99198c68fbae")
    private static class GapObjectFactory implements ISmObjectFactory {
        @objid ("25492faa-9a9f-4434-862c-b5c0649bbac3")
        private GapSmClass smClass;

        @objid ("f575dd12-243d-4723-a74c-bb5dcccb3ac3")
        public GapObjectFactory(GapSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("bdb23abf-d2bb-4827-9c54-5510c2c33ae8")
        @Override
        public ISmObjectData createData() {
            return new GapData(this.smClass);
        }

        @objid ("6603d968-8d0e-45ea-8aa6-a9c4effb1ad2")
        @Override
        public SmObjectImpl createImpl() {
            return new GapImpl();
        }

    }

}
