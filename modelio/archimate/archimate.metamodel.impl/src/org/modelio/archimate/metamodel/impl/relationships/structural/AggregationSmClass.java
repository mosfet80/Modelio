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
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0ceba5e7-3a67-4597-97b6-6555de0182d8")
public class AggregationSmClass extends StructuralRelationshipSmClass {
    @objid ("914ce934-3867-4772-9be6-fdd9fdd5d3a3")
    public AggregationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("90d9838f-e462-408a-bbe1-3f430008104e")
    @Override
    public String getName() {
        return "Aggregation";

    }

    @objid ("a35146cc-cf4d-4e9b-b637-a87612f66041")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("3a44a294-6a40-4f50-ae62-6bfa47c584a6")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Aggregation.class;

    }

    @objid ("d2f34fc3-a8fb-4113-bee4-03ef1a0e7b1e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("d3aed686-156d-48a9-855f-321a3bf28c1d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("700ae422-f8c0-44a8-b3cb-9b1a04cb7995")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuralRelationship.MQNAME);
        this.registerFactory(new AggregationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("490c728c-947d-457a-a1f2-001a8536cb2c")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("b4f350db-b902-453a-bd5b-3b455753e975")
    private static class AggregationObjectFactory implements ISmObjectFactory {
        @objid ("756d1753-e990-4c00-b2cc-6f9f6d2cfa12")
        private AggregationSmClass smClass;

        @objid ("1dfa3006-997e-40a7-bcda-735150b7f5b3")
        public AggregationObjectFactory(AggregationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("203059d4-6424-48a2-a4a9-acb629756116")
        @Override
        public ISmObjectData createData() {
            return new AggregationData(this.smClass);
        }

        @objid ("54b86c5d-962a-45ad-afb4-4d30ead36db6")
        @Override
        public SmObjectImpl createImpl() {
            return new AggregationImpl();
        }

    }

}
