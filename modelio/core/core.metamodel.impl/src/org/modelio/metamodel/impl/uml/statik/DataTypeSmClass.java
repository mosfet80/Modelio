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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.statik.DataType;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1648b8b3-570e-4f03-92ab-6e61b22d1b02")
public class DataTypeSmClass extends GeneralClassSmClass {
    @objid ("4af54ddc-bd5a-432e-84fb-7b1ba9357fb7")
    public DataTypeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b82c86a7-dc18-40df-bd1a-c8f5a0aa9877")
    @Override
    public String getName() {
        return "DataType";

    }

    @objid ("f441b2e4-018e-495f-a659-5e41cb49417a")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("98bb66fd-5725-438a-a716-a331a447c38d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DataType.class;

    }

    @objid ("b80e8315-1f49-4d0b-b310-a0cde9ee053e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("b11bf732-856c-4e43-99a7-c7e5a5bfad03")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d0eeda94-c36e-4ce4-ad54-8659302cc946")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new DataTypeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("ff678c24-3df3-4959-91c5-f18f480c12ba")
    private static class DataTypeObjectFactory implements ISmObjectFactory {
        @objid ("906a59a8-af96-4387-846d-c7a5de905946")
        private DataTypeSmClass smClass;

        @objid ("e762024d-aa29-4048-8529-fedd4239aef8")
        public DataTypeObjectFactory(DataTypeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b0ab6269-604f-4107-b779-cc05077043f2")
        @Override
        public ISmObjectData createData() {
            return new DataTypeData(this.smClass);
        }

        @objid ("c4d4fa7d-f6ec-4a08-a104-5fc66955ac86")
        @Override
        public SmObjectImpl createImpl() {
            return new DataTypeImpl();
        }

    }

}
