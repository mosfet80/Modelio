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
import org.modelio.metamodel.uml.statik.NaryConnectorEnd;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0658041f-9f8e-4044-a285-d0ab1d710f53")
public class NaryConnectorEndSmClass extends NaryLinkEndSmClass {
    @objid ("852e1776-6d20-46fa-bb18-47a18ade7fb7")
    public NaryConnectorEndSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6be86f4a-36d6-4efb-85fa-654c7634f697")
    @Override
    public String getName() {
        return "NaryConnectorEnd";

    }

    @objid ("9ce6caaf-8868-45d6-a96b-58f3a060da0c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("b2c07fa4-befd-4be4-bbf1-b593400f34df")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return NaryConnectorEnd.class;

    }

    @objid ("8507f03f-0f10-4c95-a978-6e8b97fe525f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3357221c-ec10-49f8-a3bc-937e7afbcfb7")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5436a635-bb54-44d8-bfe9-7eb17004f6d1")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(NaryLinkEnd.MQNAME);
        this.registerFactory(new NaryConnectorEndObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("acff590e-f662-4755-bae5-d65d69062fe8")
    private static class NaryConnectorEndObjectFactory implements ISmObjectFactory {
        @objid ("0cfab39a-070c-4cfb-b15c-2936aac1a718")
        private NaryConnectorEndSmClass smClass;

        @objid ("c37cf4e8-802c-409c-ad9c-82f12ce395c5")
        public NaryConnectorEndObjectFactory(NaryConnectorEndSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f6270bc6-9a33-4b5c-a382-452c11f11e05")
        @Override
        public ISmObjectData createData() {
            return new NaryConnectorEndData(this.smClass);
        }

        @objid ("cdd22d1a-3382-4e0c-bf7a-1864ac4f43ac")
        @Override
        public SmObjectImpl createImpl() {
            return new NaryConnectorEndImpl();
        }

    }

}
