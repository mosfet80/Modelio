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
package org.modelio.archimate.metamodel.impl.layers.implementation_and_migration;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;
import org.modelio.archimate.metamodel.impl.core.generic.composite.CompositeElementSmClass;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("2e777d5f-ec0c-4788-8681-fb46b298c959")
public class PlateauSmClass extends CompositeElementSmClass {
    @objid ("5e91bef0-32a1-4d4d-a5a9-aeb6bc48d757")
    public PlateauSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("313a07bb-dd0f-4975-9f51-f59f7c3353e2")
    @Override
    public String getName() {
        return "Plateau";

    }

    @objid ("d258762b-41b9-47b4-9c87-394617b406c4")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("0a220301-87b5-49e6-b656-4acbed88e85b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Plateau.class;

    }

    @objid ("a5e2d23d-d2db-405e-949a-996c3d13448b")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("8c87a940-47d5-43d6-aee1-52724dba8624")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a36d01d6-83d6-4fc8-9c2b-0e45d710130b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(CompositeElement.MQNAME);
        this.registerFactory(new PlateauObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("02c29b6f-2b2e-46d9-9694-0efca0b692cd")
    private static class PlateauObjectFactory implements ISmObjectFactory {
        @objid ("675a56a7-2118-4ab1-91bc-52204a109891")
        private PlateauSmClass smClass;

        @objid ("8e85d845-6a44-411e-b539-650afb53ef65")
        public PlateauObjectFactory(PlateauSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("49788db6-5ffc-4d4e-91fb-60e86bb4ab0f")
        @Override
        public ISmObjectData createData() {
            return new PlateauData(this.smClass);
        }

        @objid ("11af1ad8-b599-4eb6-8253-dcd6adab249f")
        @Override
        public SmObjectImpl createImpl() {
            return new PlateauImpl();
        }

    }

}
