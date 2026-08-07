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
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.archimate.metamodel.impl.core.generic.EventSmClass;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("238cfbd4-fb99-4a53-8c1f-709a3f9afc13")
public class ApplicationEventSmClass extends EventSmClass {
    @objid ("362500a0-b061-4209-b442-e06c200d9ade")
    public ApplicationEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1f5193a5-3dad-4d4d-94f4-4aab7063c3fb")
    @Override
    public String getName() {
        return "ApplicationEvent";

    }

    @objid ("e3afd8de-03e2-47c1-9cc4-abb277ea57da")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("344f9ded-5163-49f3-9f17-cdd84b2c1a48")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationEvent.class;

    }

    @objid ("0586c344-112d-433a-b58d-0d93e673738b")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("cbb5197f-02c5-4888-8fc7-30f398532d45")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d7b8e984-e1ee-4e33-811c-8614d3a96336")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Event.MQNAME);
        this.registerFactory(new ApplicationEventObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("6339954b-254a-42d1-a1df-83d3a8e6a213")
    private static class ApplicationEventObjectFactory implements ISmObjectFactory {
        @objid ("af079d2e-dd6e-4ee2-99ec-dad4cff96002")
        private ApplicationEventSmClass smClass;

        @objid ("895febad-f97a-4fc2-b68c-1d99aab0715d")
        public ApplicationEventObjectFactory(ApplicationEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d633be9b-8f61-422c-ab6c-42f0835535fa")
        @Override
        public ISmObjectData createData() {
            return new ApplicationEventData(this.smClass);
        }

        @objid ("ab9effdb-391a-45b4-9fa5-31beed0a7147")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationEventImpl();
        }

    }

}
