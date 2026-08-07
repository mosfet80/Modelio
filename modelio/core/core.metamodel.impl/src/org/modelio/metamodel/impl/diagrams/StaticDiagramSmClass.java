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
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.metamodel.impl.diagrams.AbstractDiagramSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("cfdce8a3-a136-4b46-ab5e-4b3c7dea4698")
public class StaticDiagramSmClass extends AbstractDiagramSmClass {
    @objid ("3677669a-5e11-4abc-8955-f52010fb4fae")
    public StaticDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("aa0fb476-5d8f-4678-8ecd-c67aa918fbfb")
    @Override
    public String getName() {
        return "StaticDiagram";

    }

    @objid ("d9241ce0-5c55-43e1-92a7-747b44ef817c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("748d608d-0cb9-409d-ba93-7690b4977870")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StaticDiagram.class;

    }

    @objid ("dfaf9417-c847-472d-8478-1fec72486314")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("25a144d5-a1de-436f-acd4-2683ee28f542")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("4c41ddd1-c627-489f-bc6d-b5b4a2558b88")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractDiagram.MQNAME);
        this.registerFactory(new StaticDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("d761e3d8-2deb-4602-8c17-146ae1cce6fd")
    private static class StaticDiagramObjectFactory implements ISmObjectFactory {
        @objid ("422b38b7-c88b-4f55-b2bc-1033534532f0")
        private StaticDiagramSmClass smClass;

        @objid ("7f34149d-0bf0-4a75-a50c-e43c2b27e352")
        public StaticDiagramObjectFactory(StaticDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6966ae77-e6a5-401b-ad54-e71cb6e26cf8")
        @Override
        public ISmObjectData createData() {
            return new StaticDiagramData(this.smClass);
        }

        @objid ("15d2213f-c2b1-485c-a200-60599a5e630b")
        @Override
        public SmObjectImpl createImpl() {
            return new StaticDiagramImpl();
        }

    }

}
