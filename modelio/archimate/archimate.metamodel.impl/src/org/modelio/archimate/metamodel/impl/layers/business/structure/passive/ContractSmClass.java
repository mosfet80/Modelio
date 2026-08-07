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
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Contract;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("25d719a3-aca8-4d85-8eb4-d10f2d36406e")
public class ContractSmClass extends BusinessObjectSmClass {
    @objid ("5aa471e4-c901-4431-a204-d2d3e0ecd6ea")
    public ContractSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f19e7ef3-ead6-4768-b2b1-1e8a58efbd72")
    @Override
    public String getName() {
        return "Contract";

    }

    @objid ("ad56feee-aba5-4bdf-8285-b2a307ee2cf5")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("666ceb12-66f3-4173-b31d-05bb7b67fd35")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Contract.class;

    }

    @objid ("a247ce44-b6c3-4010-85cf-56c92625d56a")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("c821ba58-f1f9-45fc-adbb-0b0cb534caf8")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d323f8d8-d2ef-484a-ad5f-fb6f08f8682c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessObject.MQNAME);
        this.registerFactory(new ContractObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("00514b5b-6409-4820-87c7-21c44c5c01ec")
    private static class ContractObjectFactory implements ISmObjectFactory {
        @objid ("44ef9cbb-75d0-4c20-9f4b-e3608d56c791")
        private ContractSmClass smClass;

        @objid ("2abad85e-352e-4256-9ce8-dedc21d00fe8")
        public ContractObjectFactory(ContractSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("af537a37-ec38-4d8e-9373-44af970da6e1")
        @Override
        public ISmObjectData createData() {
            return new ContractData(this.smClass);
        }

        @objid ("4be3dd06-1bfa-4fed-9fac-ef7a36677d85")
        @Override
        public SmObjectImpl createImpl() {
            return new ContractImpl();
        }

    }

}
