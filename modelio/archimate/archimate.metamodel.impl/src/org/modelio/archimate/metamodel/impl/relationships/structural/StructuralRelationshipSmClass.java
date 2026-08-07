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
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.impl.core.RelationshipSmClass;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("dffe67bf-953d-4230-ad99-bb29258b8d90")
public class StructuralRelationshipSmClass extends RelationshipSmClass {
    @objid ("d385d4d1-9112-45d0-9f53-e63afd8cb990")
    public StructuralRelationshipSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("4789adf7-de13-4120-a173-f3f7a0b39c2e")
    @Override
    public String getName() {
        return "StructuralRelationship";

    }

    @objid ("56d1185a-7cf0-4556-a3d2-d7eb13610171")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("93adfa54-57f7-4ef5-9649-0fe92da62927")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StructuralRelationship.class;

    }

    @objid ("d69b5251-dc20-4129-be27-f10010785008")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("817e76a3-e2b3-4554-a31e-11ce6ea0f3c9")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("e13043f2-4546-4043-9793-18ad744f8699")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Relationship.MQNAME);
        this.registerFactory(new StructuralRelationshipObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a98a7d2e-7be5-4bf2-a390-0a2072061e31")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("0a6abeca-5bff-4394-b3e0-613e6e3c8ef1")
    private static class StructuralRelationshipObjectFactory implements ISmObjectFactory {
        @objid ("4f23c02e-6228-44d2-84d3-28be05094083")
        private StructuralRelationshipSmClass smClass;

        @objid ("0197bc15-5b8d-4d84-a602-f794b1bb9ead")
        public StructuralRelationshipObjectFactory(StructuralRelationshipSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4e005c60-749c-401a-96dc-e7dc6c34e306")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("48e4921e-29d1-4c4d-8475-83d92709a6c3")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
