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
package org.modelio.archimate.metamodel.impl.core.generic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b7235174-cdd9-4298-9563-c25777ec91b1")
public class ExternalActiveStructureElementSmClass extends ActiveStructureElementSmClass {
    @objid ("557c425b-a343-482b-afa8-065519cbe354")
    public ExternalActiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("05a7c70a-faa5-43cf-889b-c4c69bf74a8f")
    @Override
    public String getName() {
        return "ExternalActiveStructureElement";

    }

    @objid ("15d3ebe9-2d77-4221-ab0c-88a0b921625c")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("ffe8d4b3-2f11-427e-8f12-c3f75db8ef7d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExternalActiveStructureElement.class;

    }

    @objid ("9aff5402-8647-4b2c-bd0b-6e8bbf4e66ef")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f7fa27ae-d068-48cc-b127-928888aa2ca4")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("7b69e903-87d5-4461-9e9a-cc418d0c80f0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActiveStructureElement.MQNAME);
        this.registerFactory(new ExternalActiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("02983671-4936-4e0b-bd5c-c411a43d96ee")
    private static class ExternalActiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("784b999b-ccd3-414d-8fa1-ba9ba90ae52c")
        private ExternalActiveStructureElementSmClass smClass;

        @objid ("7401099d-fa63-4af7-abba-9cdac29b846a")
        public ExternalActiveStructureElementObjectFactory(ExternalActiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b0e7ca04-8feb-4ebf-a094-01eb1c54ee0a")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("6dd0cc62-7a10-4060-87b5-16752e065702")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
