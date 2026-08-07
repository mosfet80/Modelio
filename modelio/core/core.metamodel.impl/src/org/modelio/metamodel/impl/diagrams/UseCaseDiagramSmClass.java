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
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.metamodel.diagrams.UseCaseDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1ec2bda1-fb94-4a5c-a85c-452bd832a8fc")
public class UseCaseDiagramSmClass extends StaticDiagramSmClass {
    @objid ("448f5cd6-07a6-4cb1-8b37-60a2c5d3a456")
    public UseCaseDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("56e3d406-5fda-495f-b028-424010972d5a")
    @Override
    public String getName() {
        return "UseCaseDiagram";

    }

    @objid ("a1270b24-de4a-4a92-bc34-5d152f67c355")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("bcb8ab5e-e574-47cf-ad38-96f95e9cf7d5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return UseCaseDiagram.class;

    }

    @objid ("6b47f79c-9abc-46de-a428-c5d530528232")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("1ca30b08-40f0-4b2e-9513-8d60c0ca0663")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ecc191bc-e765-4134-8bf0-fccfc6bb7897")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StaticDiagram.MQNAME);
        this.registerFactory(new UseCaseDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("bfceb265-d6f8-4aea-b23f-30f227a71eef")
    private static class UseCaseDiagramObjectFactory implements ISmObjectFactory {
        @objid ("80af3e2a-5848-44b8-ae39-424e9017fbbe")
        private UseCaseDiagramSmClass smClass;

        @objid ("4012239a-328c-441a-aa3d-bf31e3b53f2d")
        public UseCaseDiagramObjectFactory(UseCaseDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d18ca523-c4b8-4141-949d-ca57ff76642c")
        @Override
        public ISmObjectData createData() {
            return new UseCaseDiagramData(this.smClass);
        }

        @objid ("b21a64de-fa03-42fc-9bc1-33be188b8047")
        @Override
        public SmObjectImpl createImpl() {
            return new UseCaseDiagramImpl();
        }

    }

}
