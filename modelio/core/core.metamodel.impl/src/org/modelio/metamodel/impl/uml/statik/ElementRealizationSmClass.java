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
import org.modelio.metamodel.impl.uml.infrastructure.AbstractionSmClass;
import org.modelio.metamodel.uml.infrastructure.Abstraction;
import org.modelio.metamodel.uml.statik.ElementRealization;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("5a66d517-b555-404b-b7f5-fbb06071a8be")
public class ElementRealizationSmClass extends AbstractionSmClass {
    @objid ("ff03def0-881e-4973-b536-35660aaf6044")
    public ElementRealizationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("4b498bff-abbf-469c-93f9-d4e1ed8e6d23")
    @Override
    public String getName() {
        return "ElementRealization";

    }

    @objid ("363e4449-d502-4a57-95b7-2b0817500947")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3d54f6a0-acb0-4f5f-9ead-2780872738de")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ElementRealization.class;

    }

    @objid ("d8bed6d8-4c3f-4f25-94b3-e51e369ed9cc")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("956e4720-573e-4616-8336-2b33c102692a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("328236a6-c32a-43b1-acb7-6126eea10dc5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Abstraction.MQNAME);
        this.registerFactory(new ElementRealizationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("6928ec0e-c03d-46e6-9fe4-e5c63599c40b")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("c5da83fd-5c94-4f55-bbd5-3050c0ee1fd9")
    private static class ElementRealizationObjectFactory implements ISmObjectFactory {
        @objid ("de3e4ca5-159c-4947-a17a-d74945f8cb8f")
        private ElementRealizationSmClass smClass;

        @objid ("42741e24-f2bc-4fa7-865b-15df6ee6a936")
        public ElementRealizationObjectFactory(ElementRealizationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("917f7040-abb2-4026-8bf3-3dff2fea4fd2")
        @Override
        public ISmObjectData createData() {
            return new ElementRealizationData(this.smClass);
        }

        @objid ("9e303757-1941-4060-a366-ecd7f2398cef")
        @Override
        public SmObjectImpl createImpl() {
            return new ElementRealizationImpl();
        }

    }

}
