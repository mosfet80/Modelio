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
package org.modelio.archimate.metamodel.impl.layers.technology.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.structure.active.CommunicationNetwork;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("46680e11-7224-428b-8a8c-5326f86efa9e")
public class CommunicationNetworkSmClass extends TechnologyActiveStructureElementSmClass {
    @objid ("47ce61fd-3497-4939-9d82-199c078b5f6f")
    public CommunicationNetworkSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b0ce7cc5-ad36-49da-b2ae-81bf062f8900")
    @Override
    public String getName() {
        return "CommunicationNetwork";

    }

    @objid ("096f799d-0718-4027-8d0d-9ba080e9f25b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("6e7fb7bf-28a4-4fa9-bb24-4a3ed6449788")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CommunicationNetwork.class;

    }

    @objid ("fcadf86c-df98-4ece-8d1b-132f7ffb2f23")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("4aa7d7a0-820d-486c-af90-c8966f32eb2c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("23ab891e-14e9-4800-bc52-b79565940ef4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyActiveStructureElement.MQNAME);
        this.registerFactory(new CommunicationNetworkObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("fd5432b5-064f-44f6-810b-a70b317cfae7")
    private static class CommunicationNetworkObjectFactory implements ISmObjectFactory {
        @objid ("4e65cd61-81f3-499e-831d-6f93d40cade8")
        private CommunicationNetworkSmClass smClass;

        @objid ("abb60a68-d9c5-49de-82b2-f709df6f09b6")
        public CommunicationNetworkObjectFactory(CommunicationNetworkSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("018712b3-9896-48a8-814a-a137e2c809f6")
        @Override
        public ISmObjectData createData() {
            return new CommunicationNetworkData(this.smClass);
        }

        @objid ("38414ec2-2c12-4639-bce5-943b6d9e834d")
        @Override
        public SmObjectImpl createImpl() {
            return new CommunicationNetworkImpl();
        }

    }

}
