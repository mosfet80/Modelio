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
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a6152c29-8f11-4ba2-a901-2cb4ba53b9a7")
public class CompositionSmClass extends StructuralRelationshipSmClass {
    @objid ("8483403b-1754-40ac-8116-9a5ebb224d00")
    public CompositionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f2c1c88b-963c-40f6-942b-0c59eab15837")
    @Override
    public String getName() {
        return "Composition";

    }

    @objid ("5018c146-88b3-4ccf-8d04-d4499e46dc12")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("1383581d-ce05-4fd2-9fd7-d6356c07ea50")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Composition.class;

    }

    @objid ("c4e7b581-85ce-4ce9-a53b-fc34b8d64eef")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("9d281a77-8f11-4d7e-a1b6-5a8d257244fc")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9f8e3927-d9e5-4f31-bb71-9e12a739e4d9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuralRelationship.MQNAME);
        this.registerFactory(new CompositionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a66847ad-c2f1-4844-8de3-b05ac042f984")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("1ff1aabe-61ee-46b9-a409-7e96263881a2")
    private static class CompositionObjectFactory implements ISmObjectFactory {
        @objid ("c1d29bcd-f9e5-4724-9a74-e63841d45955")
        private CompositionSmClass smClass;

        @objid ("65c6dbda-7e86-49e6-b1e6-e06e77f3f516")
        public CompositionObjectFactory(CompositionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2d9f7b2c-0020-4ce0-ba86-044bbcca76ab")
        @Override
        public ISmObjectData createData() {
            return new CompositionData(this.smClass);
        }

        @objid ("c114f274-700e-44f0-bae9-3db3bfdff0b3")
        @Override
        public SmObjectImpl createImpl() {
            return new CompositionImpl();
        }

    }

}
