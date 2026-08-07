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
import org.modelio.archimate.metamodel.core.generic.InternalBehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.InternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("6ca16fef-6320-431f-884d-76a859f62dae")
public class TechnologyInternalBehaviorElementSmClass extends InternalBehaviorElementSmClass {
    @objid ("3f34e1fd-7312-4f39-8d1e-3d5f66a8390c")
    public TechnologyInternalBehaviorElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("710724d9-0586-45c5-a365-3e8c831cff37")
    @Override
    public String getName() {
        return "TechnologyInternalBehaviorElement";

    }

    @objid ("82d0a835-17aa-45c3-aa2b-d38b910de2d9")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("3d790f6a-ae84-469d-82d1-61bbc5dfff1e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyInternalBehaviorElement.class;

    }

    @objid ("b69603a5-872c-4f9c-a744-0aa987d471d5")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("c60b85d7-e262-4b31-adb9-f536cd310d56")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("c1de5da8-5b1e-4fde-b4cc-ab1b974a68db")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InternalBehaviorElement.MQNAME);
        this.registerFactory(new TechnologyInternalBehaviorElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("2cd13deb-e843-49e2-993d-6696a9b61115")
    private static class TechnologyInternalBehaviorElementObjectFactory implements ISmObjectFactory {
        @objid ("28773608-8073-4f43-94da-a450c63c843a")
        private TechnologyInternalBehaviorElementSmClass smClass;

        @objid ("64381696-01dc-4988-97cf-3b292be20dba")
        public TechnologyInternalBehaviorElementObjectFactory(TechnologyInternalBehaviorElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ceec81bd-17e4-4456-b625-68e389fc8f52")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("be9d0141-06dc-4e4a-b986-b9600f4a22cc")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
