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
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a2520d09-e669-4e2f-b2f6-17ce0d385ff0")
public class ElementSmClass extends ConceptSmClass {
    @objid ("045b88bc-b9ac-410d-b9f8-ceb5720ac7a2")
    public ElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("dcafafe8-b887-4a1e-b274-15c713f2ec85")
    @Override
    public String getName() {
        return "Element";

    }

    @objid ("3974bd29-25de-4ceb-84d2-2e5eb7fcc4c6")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("de8f3da5-4ad7-4461-8b28-f40c0878bd2a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Element.class;

    }

    @objid ("5bf93346-c056-41b7-b003-8f061e09058e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("76a9f914-6a6b-4656-beb2-9409f70406ee")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("b1842a05-4d18-43fb-a0f4-718338d19574")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Concept.MQNAME);
        this.registerFactory(new ElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("3ac64f55-b121-41c9-913d-b253f9924af4")
    private static class ElementObjectFactory implements ISmObjectFactory {
        @objid ("72d0d182-b968-4239-861c-43120d3d9c56")
        private ElementSmClass smClass;

        @objid ("22f60db2-9ec4-46df-880f-d32e4f669d28")
        public ElementObjectFactory(ElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("59b9eab2-e8ff-432c-a5bc-f3112acc5349")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("4ac6b706-ee22-47ff-9ea5-0e8c4d52fc5c")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
