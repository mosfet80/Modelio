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
import org.modelio.metamodel.uml.statik.Connector;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("d3b7192d-019b-42f0-81c8-5dc12c1e6414")
public class ConnectorSmClass extends LinkSmClass {
    @objid ("e559fe80-d46b-4c03-9451-f5d1fbc730f6")
    public ConnectorSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("623f3d32-14d6-4402-a6ba-79978ab1296b")
    @Override
    public String getName() {
        return "Connector";

    }

    @objid ("dcb0b44e-bf05-411b-bec5-cc5282f9fcf0")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("092f9c6c-054c-43b2-b745-40d8d3195a36")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Connector.class;

    }

    @objid ("6eeba224-9efa-4bed-af17-144a0a5a4171")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("32d27303-758f-4a93-875b-cba409f9c610")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f31260d7-fa26-4129-8c30-59fdcc96b233")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Link.MQNAME);
        this.registerFactory(new ConnectorObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("fcc985b9-ff83-41dd-9e4f-4f80ec9a7471")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("94ff6f0d-687c-4daf-9b09-d48d3786307d")
    private static class ConnectorObjectFactory implements ISmObjectFactory {
        @objid ("834d4245-0906-41f3-a226-af22ee832c4e")
        private ConnectorSmClass smClass;

        @objid ("baa6c3d4-80ff-4baf-a1ec-364868f85013")
        public ConnectorObjectFactory(ConnectorSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c9360010-7276-4e6b-9413-9b753aad3c40")
        @Override
        public ISmObjectData createData() {
            return new ConnectorData(this.smClass);
        }

        @objid ("090aa90d-5e0a-4ff7-a8dc-c70f653e86c9")
        @Override
        public SmObjectImpl createImpl() {
            return new ConnectorImpl();
        }

    }

}
