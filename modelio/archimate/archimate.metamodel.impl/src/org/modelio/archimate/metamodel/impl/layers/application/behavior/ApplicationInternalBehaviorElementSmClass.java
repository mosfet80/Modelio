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
import org.modelio.archimate.metamodel.core.generic.InternalBehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.InternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("3174dad7-3b6c-4e16-adce-e367ce601923")
public class ApplicationInternalBehaviorElementSmClass extends InternalBehaviorElementSmClass {
    @objid ("f84e987f-9d15-4bd3-b224-8b24027dae04")
    public ApplicationInternalBehaviorElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("82c08ee4-62ac-4c68-846c-2a5cb678429f")
    @Override
    public String getName() {
        return "ApplicationInternalBehaviorElement";

    }

    @objid ("f38d84e2-46d0-4114-9792-1f28ddcd3e3d")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("bcf3e0f4-3b22-4fb7-b3e1-42a352d918e0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationInternalBehaviorElement.class;

    }

    @objid ("876b9aef-852c-4a1b-a2f4-04fba467d0da")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("1e0904dc-9360-47c7-b14a-d70a955cacec")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("c716c5da-6079-4a28-ab83-cd0a29a413cb")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InternalBehaviorElement.MQNAME);
        this.registerFactory(new ApplicationInternalBehaviorElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("2d12853f-1634-4263-8404-ba18d58a0a10")
    private static class ApplicationInternalBehaviorElementObjectFactory implements ISmObjectFactory {
        @objid ("832c935b-a07c-4fbb-a533-e7d8ac3f2d1c")
        private ApplicationInternalBehaviorElementSmClass smClass;

        @objid ("e916981f-2496-4ded-bee4-b49010ae486b")
        public ApplicationInternalBehaviorElementObjectFactory(ApplicationInternalBehaviorElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4274e71c-1e35-490a-967a-c176bebb390e")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("97ee0cb9-2ab8-40b8-8853-021ba0653907")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
