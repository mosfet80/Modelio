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
package org.modelio.archimate.metamodel.impl.layers.motivation;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;
import org.modelio.archimate.metamodel.impl.core.generic.motivation.MotivationElementSmClass;
import org.modelio.archimate.metamodel.layers.motivation.Driver;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("84047200-ca7f-40bd-b12a-e5e8d1585554")
public class DriverSmClass extends MotivationElementSmClass {
    @objid ("f4706460-bed2-435d-ad6e-b567e2036921")
    public DriverSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("39d962c9-3f65-4fa3-8f75-1df3cccb651f")
    @Override
    public String getName() {
        return "Driver";

    }

    @objid ("cb749bcd-60e4-4359-887e-dc49eb600722")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("fd0c9ec0-76b9-4481-b829-f2ee150bd334")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Driver.class;

    }

    @objid ("d14191be-0059-422b-a28b-a92751ab42e2")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("64d9bb63-2b16-47d0-ad0f-2670b4e654c0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("44329d96-6477-4d2c-8b12-f87d11ee8093")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new DriverObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f0787a53-e3a6-4aa8-a5d7-14e734948da8")
    private static class DriverObjectFactory implements ISmObjectFactory {
        @objid ("95104778-2a4a-4641-bee5-78ffeea55ccf")
        private DriverSmClass smClass;

        @objid ("7a43d1d4-eeb6-446e-9024-3bc5fec1fb0c")
        public DriverObjectFactory(DriverSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("14e80295-e17c-46dc-85be-74dfbb6b7ac4")
        @Override
        public ISmObjectData createData() {
            return new DriverData(this.smClass);
        }

        @objid ("3a8cc01c-7e31-48b4-ad9b-445a725f9b05")
        @Override
        public SmObjectImpl createImpl() {
            return new DriverImpl();
        }

    }

}
