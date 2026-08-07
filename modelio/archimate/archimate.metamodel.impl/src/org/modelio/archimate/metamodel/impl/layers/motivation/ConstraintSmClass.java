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
package org.modelio.archimate.metamodel.impl.layers.motivation;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.motivation.Constraint;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("73c92a38-4c74-4979-a272-67b666dfa039")
public class ConstraintSmClass extends RequirementSmClass {
    @objid ("f42a749f-eb11-4bf5-8712-677a8f90bd6f")
    public ConstraintSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("727bb8dc-8367-4c91-b70b-aeb5b22c2ca4")
    @Override
    public String getName() {
        return "Constraint";

    }

    @objid ("544e0ebc-0260-4231-a309-12bace088fb9")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("1f290ea1-86c8-46a1-b998-6a5dee7f85ef")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Constraint.class;

    }

    @objid ("73d639fd-41c4-4d48-bd4a-2d98ea8d7fa7")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("ae5f2557-9e2d-464e-bff5-8df91532e5b3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9d995551-e4e6-43ef-b57d-2b7e38847c2f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Requirement.MQNAME);
        this.registerFactory(new ConstraintObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("1eab6050-0e33-4df9-9831-51c344cba6fd")
    private static class ConstraintObjectFactory implements ISmObjectFactory {
        @objid ("8c2d9475-a472-4555-874a-4e3887c46037")
        private ConstraintSmClass smClass;

        @objid ("86188bf2-f7f1-4017-a832-b8790d40b868")
        public ConstraintObjectFactory(ConstraintSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("58552810-37cd-4b09-ba79-711266e88290")
        @Override
        public ISmObjectData createData() {
            return new ConstraintData(this.smClass);
        }

        @objid ("fd39f873-0086-4208-8eba-d5b89c96f9e1")
        @Override
        public SmObjectImpl createImpl() {
            return new ConstraintImpl();
        }

    }

}
