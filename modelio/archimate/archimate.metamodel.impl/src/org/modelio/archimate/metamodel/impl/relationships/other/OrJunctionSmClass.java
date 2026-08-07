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
package org.modelio.archimate.metamodel.impl.relationships.other;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1622879e-01c1-4c57-ac6d-c21d942117a3")
public class OrJunctionSmClass extends JunctionSmClass {
    @objid ("1b09ef0b-d2ff-4a19-ac77-7a3aee2900e2")
    public OrJunctionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("83c44267-a316-4d33-8627-d98504e0bbbd")
    @Override
    public String getName() {
        return "OrJunction";

    }

    @objid ("50d88957-573d-47c9-a621-d73274d7911a")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("76cd769e-045e-49ca-a4c0-f1ed8d4fe7a4")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return OrJunction.class;

    }

    @objid ("e3d6dc0e-e91e-4ca7-8a2c-509e45893eb8")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3d200a65-6fbe-45c7-8eb2-1e4860c5d725")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("93489d6f-b68b-4b66-9e69-f456e6ba06a3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Junction.MQNAME);
        this.registerFactory(new OrJunctionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("ee662633-ffe8-4f2d-b562-be53de2863d2")
    private static class OrJunctionObjectFactory implements ISmObjectFactory {
        @objid ("76525314-c2da-4e45-ac58-d22e5b7bbdf2")
        private OrJunctionSmClass smClass;

        @objid ("820aa4eb-4d65-4022-ae8b-5ef3bb0203d4")
        public OrJunctionObjectFactory(OrJunctionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e1baa21c-73d3-4082-87cf-306ef20ea37e")
        @Override
        public ISmObjectData createData() {
            return new OrJunctionData(this.smClass);
        }

        @objid ("6d62726f-fec0-46c5-8c77-5e7159ae2f9a")
        @Override
        public SmObjectImpl createImpl() {
            return new OrJunctionImpl();
        }

    }

}
