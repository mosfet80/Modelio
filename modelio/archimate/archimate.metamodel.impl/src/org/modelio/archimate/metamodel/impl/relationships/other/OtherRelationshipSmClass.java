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
package org.modelio.archimate.metamodel.impl.relationships.other;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.impl.core.RelationshipSmClass;
import org.modelio.archimate.metamodel.relationships.other.OtherRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("50ffe022-d7ce-41e4-b629-e8734f64e0ec")
public class OtherRelationshipSmClass extends RelationshipSmClass {
    @objid ("7ef5e081-dfb3-4c10-8309-3cd73647f4d8")
    public OtherRelationshipSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8b8134a0-1e83-4f67-8c94-7527802cb88c")
    @Override
    public String getName() {
        return "OtherRelationship";

    }

    @objid ("742dee92-fb19-4946-b1a2-8c94c208dcc4")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("6ef80b6f-5596-4a17-970a-fc0458e98451")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return OtherRelationship.class;

    }

    @objid ("041fdb47-bae5-4075-b3dd-6d141a6a16b4")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ee1525dc-84cf-42c8-8ea2-551e914d72fd")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("6d551ba5-dd7d-459f-88c4-f9b1c722c0f9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Relationship.MQNAME);
        this.registerFactory(new OtherRelationshipObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("89d19cbd-02cb-4433-90db-239bce6e75e3")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("e8df9c85-ed7e-42f8-aa45-b8580b36dfa8")
    private static class OtherRelationshipObjectFactory implements ISmObjectFactory {
        @objid ("e7fe8556-ba9c-4da9-bfe1-e5df346b2b64")
        private OtherRelationshipSmClass smClass;

        @objid ("504bf844-bf51-484b-8c8d-de9a7dab41a2")
        public OtherRelationshipObjectFactory(OtherRelationshipSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("cf9ded79-c461-4b81-b7cf-14c5f6d0afd8")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("4c3c585f-793a-4d4d-b0df-9d90b3869981")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
