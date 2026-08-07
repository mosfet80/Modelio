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
package org.modelio.archimate.metamodel.impl.layers.business.structure.passive;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessPassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessPassiveStructureElement;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Representation;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("28d60206-d2e2-43bc-9d05-9954f65d2acb")
public class RepresentationSmClass extends BusinessPassiveStructureElementSmClass {
    @objid ("301e503d-7cb8-4b02-a14b-8621b4ca0dd6")
    public RepresentationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5826e1d2-f704-40f0-82fe-f68f992bb9df")
    @Override
    public String getName() {
        return "Representation";

    }

    @objid ("9eac43f4-f6a4-4cd8-be01-153a5ff4e6b3")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("ecfc1815-0bb9-44a1-9ca4-f699b0fcec84")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Representation.class;

    }

    @objid ("af511743-e86a-4a7d-a952-5c28520513af")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("3a69f097-a6d9-4964-9b74-eb8cad87e4b7")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a2efa7a1-5f8d-4ca5-8cfb-7af5ff0c19ac")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessPassiveStructureElement.MQNAME);
        this.registerFactory(new RepresentationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("1a93874b-39fe-4a9c-b3a6-70646e8a54d3")
    private static class RepresentationObjectFactory implements ISmObjectFactory {
        @objid ("f53abc25-61ea-4aed-bd81-2fce5859ef33")
        private RepresentationSmClass smClass;

        @objid ("1d912e0d-1f48-46a3-b524-8d0fe2c4a10a")
        public RepresentationObjectFactory(RepresentationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1657324f-5008-44c3-ae83-ae8736c22d29")
        @Override
        public ISmObjectData createData() {
            return new RepresentationData(this.smClass);
        }

        @objid ("cbe63d54-0c22-4cb6-9869-13bd06a52409")
        @Override
        public SmObjectImpl createImpl() {
            return new RepresentationImpl();
        }

    }

}
