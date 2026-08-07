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
package org.modelio.archimate.metamodel.impl.layers.business.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessInternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b86b7d79-f65c-4b6d-b7fc-2fd334e60747")
public class BusinessFunctionSmClass extends BusinessInternalBehaviorElementSmClass {
    @objid ("51db78b1-c5b2-48d5-b60f-073b3ec3ca2f")
    public BusinessFunctionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("fe692289-2289-4d36-af4f-461083b70b5a")
    @Override
    public String getName() {
        return "BusinessFunction";

    }

    @objid ("50d141dd-a00f-400e-baa2-dfc9f96929a3")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("c89a8676-0817-4ac9-a1d8-79729379e432")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessFunction.class;

    }

    @objid ("52c2d742-569e-4c90-9442-f90d15de1f4a")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("dda6a948-c183-44df-81e1-586b4827ba6d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0d9ae4eb-12d0-4903-9ad3-93e0b04f3ae3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessInternalBehaviorElement.MQNAME);
        this.registerFactory(new BusinessFunctionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a7bc8ab2-eb06-46e2-864a-415bed43d20a")
    private static class BusinessFunctionObjectFactory implements ISmObjectFactory {
        @objid ("c6c0b2ef-1dc8-4fce-8ac1-5d0bd7e1677e")
        private BusinessFunctionSmClass smClass;

        @objid ("7acc637c-6647-4ce0-9695-5c235539b194")
        public BusinessFunctionObjectFactory(BusinessFunctionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("0770514c-1954-4c3a-b1a4-a1249f3375a8")
        @Override
        public ISmObjectData createData() {
            return new BusinessFunctionData(this.smClass);
        }

        @objid ("a2fc43d6-8ec7-4536-8eae-90981ef9ac16")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessFunctionImpl();
        }

    }

}
