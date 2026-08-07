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
package org.modelio.archimate.metamodel.impl.layers.application.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("fd85c307-788f-42f2-ab25-2fbcfce4dea4")
public class ApplicationProcessSmClass extends ApplicationInternalBehaviorElementSmClass {
    @objid ("63188f71-0140-41b2-9b69-40c3485c4341")
    public ApplicationProcessSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0a67c126-5efa-46b1-b4ea-d133332597b0")
    @Override
    public String getName() {
        return "ApplicationProcess";

    }

    @objid ("1280878f-4099-41e9-a074-d8b27f2246e8")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("c7843082-c43b-4cbf-9cb8-b2d06a456b09")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationProcess.class;

    }

    @objid ("0d6a17d1-8a20-4a8e-baed-816f39ba6418")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("826b98dd-06b5-4567-a894-f9ad2b4dfdb1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("990d375c-5e0e-4cd2-8a4d-9ca532e5dc5f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ApplicationInternalBehaviorElement.MQNAME);
        this.registerFactory(new ApplicationProcessObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("4183d562-32f6-4c4c-87be-cf6ab788b82c")
    private static class ApplicationProcessObjectFactory implements ISmObjectFactory {
        @objid ("045c540c-1e2d-40f9-95d7-265c6d6e4aad")
        private ApplicationProcessSmClass smClass;

        @objid ("b3a74d6a-c8d6-4dd0-8f67-a207f9fa3c0f")
        public ApplicationProcessObjectFactory(ApplicationProcessSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d5a09573-fade-4f17-bda0-03a3437390be")
        @Override
        public ISmObjectData createData() {
            return new ApplicationProcessData(this.smClass);
        }

        @objid ("8d935d97-37e8-4ed7-adc4-d5ef5e205858")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationProcessImpl();
        }

    }

}
