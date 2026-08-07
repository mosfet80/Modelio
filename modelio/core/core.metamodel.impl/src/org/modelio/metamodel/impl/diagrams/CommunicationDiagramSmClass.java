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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.diagrams;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.diagrams.BehaviorDiagram;
import org.modelio.metamodel.diagrams.CommunicationDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("17789ac7-cdee-470b-bfec-fca419117bb1")
public class CommunicationDiagramSmClass extends BehaviorDiagramSmClass {
    @objid ("06479038-7873-495c-86f6-a7ddf4ec5073")
    public CommunicationDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("483e4b4d-b14a-4058-9d21-3642f2e41691")
    @Override
    public String getName() {
        return "CommunicationDiagram";

    }

    @objid ("e1a29725-00f1-4dba-86e0-7cffd2326e4b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f1476bb8-5af2-4cb0-8f0e-265147b77ca2")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CommunicationDiagram.class;

    }

    @objid ("46c9968a-2421-4f33-a41d-811c40388c94")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("9d70685c-eb4d-4d23-8c02-b567f3bd8bc6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("fb72bca5-ccce-47be-9652-7fe8c99a19e9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorDiagram.MQNAME);
        this.registerFactory(new CommunicationDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("87964011-b5f5-4194-a4db-22d7f5a953ba")
    private static class CommunicationDiagramObjectFactory implements ISmObjectFactory {
        @objid ("26ec528e-c615-4a4e-bd2e-ba368af4fcbc")
        private CommunicationDiagramSmClass smClass;

        @objid ("1757f949-b7a3-4fa6-b9b1-9afd3ff6be0c")
        public CommunicationDiagramObjectFactory(CommunicationDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("13976939-380e-4d35-89d5-f0f52012cce1")
        @Override
        public ISmObjectData createData() {
            return new CommunicationDiagramData(this.smClass);
        }

        @objid ("3562c1f7-8a18-483b-8491-6f4ae2f4c3c9")
        @Override
        public SmObjectImpl createImpl() {
            return new CommunicationDiagramImpl();
        }

    }

}
