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
package org.modelio.archimate.metamodel.impl.layers.technology.structure.passive;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.PassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.TechnologyObject;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f6495e61-ed68-4b30-85db-a676d5d95bd2")
public class TechnologyObjectSmClass extends PassiveStructureElementSmClass {
    @objid ("9b7e6781-ccc5-44e0-bc93-16b66f6db10c")
    public TechnologyObjectSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("86265cf1-e4eb-4d45-9eef-119600f7b062")
    @Override
    public String getName() {
        return "TechnologyObject";

    }

    @objid ("a390fa42-61ed-450e-ab94-f4a0036b7d3b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("1ffabdfa-932d-4110-9798-049555e084c0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyObject.class;

    }

    @objid ("3d1565d2-8bdf-404a-b3d0-381af981eee2")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("14b2687f-9b78-4800-a039-79ed520f0480")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("a57d0a7e-33a9-4202-a447-f727724a7711")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(PassiveStructureElement.MQNAME);
        this.registerFactory(new TechnologyObjectObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a0e65925-9044-40c8-b921-a8d0189a462e")
    private static class TechnologyObjectObjectFactory implements ISmObjectFactory {
        @objid ("7ca6788c-60c4-4f08-a54c-d13fcac3d4f5")
        private TechnologyObjectSmClass smClass;

        @objid ("7d3d20b0-5b17-4c32-84e2-6942a602e3b8")
        public TechnologyObjectObjectFactory(TechnologyObjectSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5ad3b4b2-5531-40e9-9cf5-f2da303fa544")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("3c2b46bf-4917-4eb1-80bd-0f3db938e0c9")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
