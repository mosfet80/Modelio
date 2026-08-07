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
package org.modelio.archimate.metamodel.impl.layers.business;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.InternalActiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.InternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("9dc1fbd0-44b0-4511-b3db-b1999cb50b07")
public class BusinessInternalActiveStructureElementSmClass extends InternalActiveStructureElementSmClass {
    @objid ("1bd133bc-8cab-4b9a-a1d5-7d26bbb37d4e")
    public BusinessInternalActiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b697e812-eec2-4638-b6be-b875a0bd45d3")
    @Override
    public String getName() {
        return "BusinessInternalActiveStructureElement";

    }

    @objid ("333dfc78-5ab4-46f8-be82-d96c0a015ae7")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("654b44e7-8786-44d7-bf49-7100831a80f0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessInternalActiveStructureElement.class;

    }

    @objid ("b0dc47a5-33b2-406a-b82c-b224f3de3ab1")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("e1667abe-d0eb-4a3b-9e74-f7f218773fca")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("34bc29f3-4e21-4e02-b093-4a9eff5c2c46")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InternalActiveStructureElement.MQNAME);
        this.registerFactory(new BusinessInternalActiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("6e90228f-3ba2-4051-bcc2-8d73881fc7e3")
    private static class BusinessInternalActiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("156a438a-3522-4a62-ba44-66d5abaf7364")
        private BusinessInternalActiveStructureElementSmClass smClass;

        @objid ("9e8690f0-0a04-47a7-82bf-593c571e7f57")
        public BusinessInternalActiveStructureElementObjectFactory(BusinessInternalActiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("563bd2c2-825c-49de-a34e-a5228389e537")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("591b09ab-89fe-4374-80f5-2916eba891d8")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
