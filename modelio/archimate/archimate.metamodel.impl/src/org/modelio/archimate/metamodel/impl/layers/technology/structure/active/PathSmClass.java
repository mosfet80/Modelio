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
import org.modelio.archimate.metamodel.layers.technology.structure.active.Path;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("6267d7e1-d948-4e83-b6d9-7f74f6985bcb")
public class PathSmClass extends TechnologyActiveStructureElementSmClass {
    @objid ("0806e732-8748-4495-9bd8-a5aa72fb2ac3")
    public PathSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5cc61c83-c241-4438-bf72-12c8f6c38f50")
    @Override
    public String getName() {
        return "Path";

    }

    @objid ("3d5d8c0e-ee37-478c-b98c-3cf6388aa2d6")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("d798d1e3-e1a3-42eb-92fc-ebb2c2c8ec37")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Path.class;

    }

    @objid ("c5e1c34f-cf94-47d1-a647-f4aa320d7d71")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("f8f89542-0b46-47ac-b5ea-d3e1b0e8a357")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2d1e8c21-0cbb-4aa0-b51a-3a40a3b8b3f7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyActiveStructureElement.MQNAME);
        this.registerFactory(new PathObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("56fb5dc9-72bd-49a4-a9c6-72cd0da921ad")
    private static class PathObjectFactory implements ISmObjectFactory {
        @objid ("0f965d86-5971-4f36-80f7-2113492ee04d")
        private PathSmClass smClass;

        @objid ("1f77ccf2-1230-4b4e-aada-8340f359aac5")
        public PathObjectFactory(PathSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9633e335-9605-4046-b1ee-28f1e4c4468b")
        @Override
        public ISmObjectData createData() {
            return new PathData(this.smClass);
        }

        @objid ("ddd280af-1b75-4709-b5f0-e3d43a4d744a")
        @Override
        public SmObjectImpl createImpl() {
            return new PathImpl();
        }

    }

}
