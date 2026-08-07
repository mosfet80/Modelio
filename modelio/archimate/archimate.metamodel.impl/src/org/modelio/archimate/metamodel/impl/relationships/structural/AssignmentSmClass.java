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
package org.modelio.archimate.metamodel.impl.relationships.structural;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("6ae37b53-aa2a-4fdb-b2cd-86e18f1bdee4")
public class AssignmentSmClass extends StructuralRelationshipSmClass {
    @objid ("6fa6873f-048f-42e7-b6b1-0994d5cc8894")
    public AssignmentSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e5aadd2d-d3e5-4ad9-a5a9-8c85be740e13")
    @Override
    public String getName() {
        return "Assignment";

    }

    @objid ("3600e96d-2c3e-4367-9914-e38eb292706e")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("3312eedb-cf59-464c-9538-87c9cd1d2a6a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Assignment.class;

    }

    @objid ("1dc77125-6898-4922-b63f-54b917d5c0be")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("59f86221-3c46-4a21-bc69-32c64540818c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("fcb5e63d-0320-40ea-917f-f945cb3409d9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuralRelationship.MQNAME);
        this.registerFactory(new AssignmentObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("d94c4d36-3250-43fb-8364-d7e4d86c3a80")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("b9211b2b-5c42-4fa8-a915-163e2b2f8d3e")
    private static class AssignmentObjectFactory implements ISmObjectFactory {
        @objid ("5d1c8498-cc4b-4ee8-ba0f-30a74ca7671b")
        private AssignmentSmClass smClass;

        @objid ("08d9a88f-06c1-4d0b-a82f-d0130b814350")
        public AssignmentObjectFactory(AssignmentSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("226adc3b-3f52-4c92-afea-fea003bc39df")
        @Override
        public ISmObjectData createData() {
            return new AssignmentData(this.smClass);
        }

        @objid ("3021155c-bcca-4923-a918-78dba39515da")
        @Override
        public SmObjectImpl createImpl() {
            return new AssignmentImpl();
        }

    }

}
