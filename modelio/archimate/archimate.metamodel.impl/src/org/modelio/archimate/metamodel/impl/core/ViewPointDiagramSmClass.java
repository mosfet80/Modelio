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
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.impl.diagrams.AbstractDiagramSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("4456292e-6469-43cf-87b5-159020928bb5")
public class ViewPointDiagramSmClass extends AbstractDiagramSmClass {
    @objid ("84b309ac-56a9-40ec-8c21-7486d44a930a")
    public ViewPointDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("43ffc33e-9792-450e-ab77-98dc9eb64d3e")
    @Override
    public String getName() {
        return "ViewPointDiagram";

    }

    @objid ("c8f64816-2947-4e6a-a7c6-5359fae66cce")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("e1f08cfa-b583-49f4-bf76-7f3ce924acaa")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ViewPointDiagram.class;

    }

    @objid ("0b9e552b-781e-4164-9cc9-a33719b842f2")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("7b628653-da70-4c80-8b75-88607f27912c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f57b7790-4c2a-4a27-a555-30e163bf6494")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractDiagram.MQNAME);
        this.registerFactory(new ViewPointDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("eb6530c6-3cfa-4824-aa70-ffdbe8b3590c")
    private static class ViewPointDiagramObjectFactory implements ISmObjectFactory {
        @objid ("cc3ae424-61a3-45f6-960e-f521d10bb79c")
        private ViewPointDiagramSmClass smClass;

        @objid ("eceaeb7d-a1d7-4842-99b1-c086bf063443")
        public ViewPointDiagramObjectFactory(ViewPointDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9343a39a-7b94-468b-a3b3-3177c2e3e3a8")
        @Override
        public ISmObjectData createData() {
            return new ViewPointDiagramData(this.smClass);
        }

        @objid ("a72b1be2-c446-4755-b06a-8667d6c38d07")
        @Override
        public SmObjectImpl createImpl() {
            return new ViewPointDiagramImpl();
        }

    }

}
