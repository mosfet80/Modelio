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
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("87f9a8c2-b114-43fb-8218-55fc2360e5d3")
public class AndJunctionSmClass extends JunctionSmClass {
    @objid ("8c6db5ef-4fe6-4ad8-a09a-657d3895518a")
    public AndJunctionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("15dd4e90-c5ba-480b-9904-8d83b35aec84")
    @Override
    public String getName() {
        return "AndJunction";

    }

    @objid ("c319d6c0-0285-4425-ad25-bb9fd832c1c5")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("c6a0456a-008c-406a-9cb9-5f9c9551be8a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AndJunction.class;

    }

    @objid ("2acf55e9-9a8e-4179-8ac5-1e74e1969599")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e70d7410-c67e-46b3-914e-aab8acfe5e98")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9b5d9fac-b4f2-4c79-b011-4edc672785e2")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Junction.MQNAME);
        this.registerFactory(new AndJunctionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("51dc57d1-4554-4768-9afc-cf6ec4ae7036")
    private static class AndJunctionObjectFactory implements ISmObjectFactory {
        @objid ("ffeebfad-6160-419a-bcd9-6b10868d716d")
        private AndJunctionSmClass smClass;

        @objid ("1cf39750-5ca1-46af-8f23-a0a6f2654321")
        public AndJunctionObjectFactory(AndJunctionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("482f205e-1655-412e-8a06-b9d59d01cf5e")
        @Override
        public ISmObjectData createData() {
            return new AndJunctionData(this.smClass);
        }

        @objid ("9da277d4-506c-44b2-ba4b-1877d1ccc28e")
        @Override
        public SmObjectImpl createImpl() {
            return new AndJunctionImpl();
        }

    }

}
