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
package org.modelio.archimate.metamodel.impl.core;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.RelationshipConnector;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a7db0262-1a8b-4be8-92be-56003fa18b63")
public class RelationshipConnectorSmClass extends ConceptSmClass {
    @objid ("2f885ffb-b805-4038-9a9e-cc82367e6e9a")
    public RelationshipConnectorSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e4724396-6289-42fe-b300-5308cb56bc6a")
    @Override
    public String getName() {
        return "RelationshipConnector";

    }

    @objid ("05969065-d0c4-4017-9c39-fc929eb66c45")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("ebf70f27-7a0a-4eee-93a2-14a0d9c54b5c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return RelationshipConnector.class;

    }

    @objid ("66e90536-0cc2-484b-9413-a4985046a1ec")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("20e06e6f-a82c-4ed0-875a-dd8b64e3f450")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("8dc7f020-a18c-456d-a0fa-7c5b30f29caa")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Concept.MQNAME);
        this.registerFactory(new RelationshipConnectorObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("dddf1ae6-c83b-4ab4-854c-013dc77fd652")
    private static class RelationshipConnectorObjectFactory implements ISmObjectFactory {
        @objid ("7522f440-2cd8-43e7-b43a-ac4edf2354bc")
        private RelationshipConnectorSmClass smClass;

        @objid ("448a8f97-e5fc-4958-b8af-716c10c85470")
        public RelationshipConnectorObjectFactory(RelationshipConnectorSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("25f66c4f-17c8-4e88-a51b-e24dc08756da")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("fbfa63a1-6fff-4d75-bf99-02804799ceb4")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
