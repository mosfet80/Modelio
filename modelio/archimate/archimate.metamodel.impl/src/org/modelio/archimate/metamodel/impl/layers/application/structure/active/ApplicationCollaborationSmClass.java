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
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("ffec4395-cbbc-4dbf-9d2f-f80352ed7181")
public class ApplicationCollaborationSmClass extends ApplicationInternalActiveStructureElementSmClass {
    @objid ("5e5bfedb-7132-4c74-9103-dac6bfc69d4e")
    public ApplicationCollaborationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f8a7a595-023a-4b2c-a436-b666ba13c83b")
    @Override
    public String getName() {
        return "ApplicationCollaboration";

    }

    @objid ("57aafeea-8156-45a8-981b-eb630e5d48b7")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("edf28c05-3f68-4a80-9a47-f2653ad9ac94")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationCollaboration.class;

    }

    @objid ("0c6d2837-f577-41cf-bd4a-7f8687123218")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("1a81e6f1-ed73-4ae2-b84e-8adcbe351277")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e1484089-edf3-4604-addd-6fded35f7c5d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ApplicationInternalActiveStructureElement.MQNAME);
        this.registerFactory(new ApplicationCollaborationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("cb24fb29-316f-4abe-baee-ce947e6b3836")
    private static class ApplicationCollaborationObjectFactory implements ISmObjectFactory {
        @objid ("184c2515-1a4d-4e52-b267-910cd86502ab")
        private ApplicationCollaborationSmClass smClass;

        @objid ("1bf2bfc6-2e03-445f-833a-6883c2528477")
        public ApplicationCollaborationObjectFactory(ApplicationCollaborationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("08a52aeb-cd54-47c2-b373-f5d915d0fb19")
        @Override
        public ISmObjectData createData() {
            return new ApplicationCollaborationData(this.smClass);
        }

        @objid ("54200929-9160-4dca-8835-3cbd326a41a1")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationCollaborationImpl();
        }

    }

}
