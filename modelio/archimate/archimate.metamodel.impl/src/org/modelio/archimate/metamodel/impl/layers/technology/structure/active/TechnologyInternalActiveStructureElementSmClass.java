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
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0b6501a9-1ed0-480a-bad0-fbf1bd743aae")
public class TechnologyInternalActiveStructureElementSmClass extends TechnologyActiveStructureElementSmClass {
    @objid ("e40e6bd6-ebc1-47ea-ad05-0659ac6460b6")
    public TechnologyInternalActiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("29ea48ae-64c9-4a2d-a311-71aac9676682")
    @Override
    public String getName() {
        return "TechnologyInternalActiveStructureElement";

    }

    @objid ("6b6f1575-f4a7-462b-b27e-76703574868b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("baa825d5-41c1-4aa3-a52f-b7b519f17fe6")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyInternalActiveStructureElement.class;

    }

    @objid ("5967b18f-75d9-48ff-84f5-8e0172b96173")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0cf36133-d812-4eaf-8483-0bcb5eec0f1d")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("a88c25b6-4182-4913-89d7-f16880ef1ebe")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyActiveStructureElement.MQNAME);
        this.registerFactory(new TechnologyInternalActiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("24a70f55-a8dc-42ea-a711-6649c8cca109")
    private static class TechnologyInternalActiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("0e0cea78-eaee-4db2-9ded-192e9f80b3b7")
        private TechnologyInternalActiveStructureElementSmClass smClass;

        @objid ("0e211032-9ae6-4145-a8d9-752e26675e11")
        public TechnologyInternalActiveStructureElementObjectFactory(TechnologyInternalActiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5b2fbf6c-2935-41bc-bf71-23d9c26a9c19")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("d99a5a8f-379b-4aaf-9779-cdab4c9ab83e")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
