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
package org.modelio.archimate.metamodel.impl.layers.technology.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInteraction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f00d654d-78ab-4d08-909e-25c3127352f8")
public class TechnologyInteractionSmClass extends TechnologyInternalBehaviorElementSmClass {
    @objid ("d8b8fa20-4b5d-4365-8bfc-c5c9a91339df")
    public TechnologyInteractionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0162dbe8-43d4-4439-8c1b-1c10757af77b")
    @Override
    public String getName() {
        return "TechnologyInteraction";

    }

    @objid ("3f7fba0b-2a6a-4d55-b876-3c8fd27f2daa")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("029fb3b3-fc9d-4680-96d8-8c28ed626186")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyInteraction.class;

    }

    @objid ("1ef4fbfe-10a6-4706-bc94-78b542ce21e2")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("173fd390-a40f-4871-b317-468b27306e70")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a600205f-308a-4a7c-8600-e25b039d8d1b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyInternalBehaviorElement.MQNAME);
        this.registerFactory(new TechnologyInteractionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("5adbebf5-78c7-48da-b7fd-0a1add880a1a")
    private static class TechnologyInteractionObjectFactory implements ISmObjectFactory {
        @objid ("33f2d7d3-aee4-4c22-80ef-82f8d0b8b829")
        private TechnologyInteractionSmClass smClass;

        @objid ("e22f781a-1eaf-4bd0-b606-aa832ea6a523")
        public TechnologyInteractionObjectFactory(TechnologyInteractionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f33cfe06-dd54-4c97-8ccd-ab5652c2179a")
        @Override
        public ISmObjectData createData() {
            return new TechnologyInteractionData(this.smClass);
        }

        @objid ("e87885b6-e8cc-40fa-82a5-9399e159c967")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyInteractionImpl();
        }

    }

}
