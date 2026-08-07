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
import org.modelio.metamodel.diagrams.DeploymentDiagram;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("102f51de-ac14-432f-9fbf-c09f03c0fdb2")
public class DeploymentDiagramSmClass extends StaticDiagramSmClass {
    @objid ("6f92030c-1e58-499c-8867-e26e8ec67732")
    public DeploymentDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("bde24337-abb2-453a-b119-f773562c87b8")
    @Override
    public String getName() {
        return "DeploymentDiagram";

    }

    @objid ("46475980-a34e-45aa-b589-af1bc4532eb7")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("6343eaad-72e1-48c2-8915-9c2896daa9bc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DeploymentDiagram.class;

    }

    @objid ("4d9a5199-c78f-4415-bfeb-3fb3308d4a54")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("0ba40e2a-5a85-4ca6-9bc7-b76414a8e21f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("61f24fb9-8f7f-47d1-bb59-234901931c5f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StaticDiagram.MQNAME);
        this.registerFactory(new DeploymentDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("b183f986-d5d8-4505-9f87-8cd50f540b93")
    private static class DeploymentDiagramObjectFactory implements ISmObjectFactory {
        @objid ("7fd7a02e-bf69-4650-aef9-12d1777235cd")
        private DeploymentDiagramSmClass smClass;

        @objid ("cb74d102-bfeb-4eb7-8788-795f0803e772")
        public DeploymentDiagramObjectFactory(DeploymentDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("99d3cb6b-4322-4042-89b6-ce17b384eb17")
        @Override
        public ISmObjectData createData() {
            return new DeploymentDiagramData(this.smClass);
        }

        @objid ("03fc0aa7-9015-450d-89dd-373cef5bea7b")
        @Override
        public SmObjectImpl createImpl() {
            return new DeploymentDiagramImpl();
        }

    }

}
