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
package org.modelio.archimate.metamodel.impl.layers.strategy.structure;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.StructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.StructureElementSmClass;
import org.modelio.archimate.metamodel.layers.strategy.structure.Resource;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c01eb536-ec0c-4a94-866f-22a595303959")
public class ResourceSmClass extends StructureElementSmClass {
    @objid ("1e258f5e-b6bd-4869-ad2d-939c4da97ed5")
    public ResourceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("2466fe29-3e6d-41ce-aad8-ed8383f92836")
    @Override
    public String getName() {
        return "Resource";

    }

    @objid ("3ed6f9de-67e7-420a-ae5c-c959375683de")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("eb2cd989-8617-4048-a8ef-e26848da7547")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Resource.class;

    }

    @objid ("a5f0a996-6c77-4454-bfe9-83bc1105f3e3")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("f412bc85-2262-4b5f-84fb-093c91732e85")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("650959a6-b768-4e3e-8a43-7c78a79e24fe")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructureElement.MQNAME);
        this.registerFactory(new ResourceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("71b95e01-b1e1-4dfe-a5b8-605b3a529971")
    private static class ResourceObjectFactory implements ISmObjectFactory {
        @objid ("49680457-9b60-4f6d-bafd-eb682efd0c03")
        private ResourceSmClass smClass;

        @objid ("3d1c4e45-10f3-4341-b99a-4a9656401676")
        public ResourceObjectFactory(ResourceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f2a94a74-465b-4d37-a445-96f0ae55483d")
        @Override
        public ISmObjectData createData() {
            return new ResourceData(this.smClass);
        }

        @objid ("02e9a363-7af3-465c-966e-74abf7c8e95f")
        @Override
        public SmObjectImpl createImpl() {
            return new ResourceImpl();
        }

    }

}
