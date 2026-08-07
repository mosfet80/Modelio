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
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.archimate.metamodel.impl.core.generic.EventSmClass;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.ImplementationEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f12a8f5b-4378-469a-8318-806d4ab6f38c")
public class ImplementationEventSmClass extends EventSmClass {
    @objid ("86d77d8e-05d4-4d8b-9254-f6ba86d56f44")
    public ImplementationEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8dd1174b-14a9-475b-8236-d7d22614f0c8")
    @Override
    public String getName() {
        return "ImplementationEvent";

    }

    @objid ("a50cca4c-d304-43d1-9b51-74dbbfcd7d87")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("148bef92-9581-4561-afd3-fc11f3ddf322")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ImplementationEvent.class;

    }

    @objid ("78919b8e-4d37-425a-9b6d-2024c41da3b4")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("b28b6a9a-ff83-4480-ad05-e50a95e0a4d2")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("bf707ca5-787d-40f0-b0b0-91bb51a3c8b3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Event.MQNAME);
        this.registerFactory(new ImplementationEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("0d7a8c43-151c-4256-b3a7-d4b46c07cfc3")
    private static class ImplementationEventObjectFactory implements ISmObjectFactory {
        @objid ("80ffab03-fb9a-4ba7-ae0a-c30073462810")
        private ImplementationEventSmClass smClass;

        @objid ("03273dc7-4834-408a-aadb-9db0bbc7e423")
        public ImplementationEventObjectFactory(ImplementationEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("212e4a26-f704-41c9-b352-c9822d7dccdd")
        @Override
        public ISmObjectData createData() {
            return new ImplementationEventData(this.smClass);
        }

        @objid ("ef9ce204-f8b6-4645-bec4-27a13af41a5a")
        @Override
        public SmObjectImpl createImpl() {
            return new ImplementationEventImpl();
        }

    }

}
