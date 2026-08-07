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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Component;
import org.modelio.metamodel.uml.statik.ComponentRealization;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("be561684-0faa-4b90-a406-2ee10bd255a4")
public class ComponentSmClass extends ClassSmClass {
    @objid ("d32e54e2-284b-4e20-8ce7-81a8c96472b9")
    private SmDependency realizationDep;

    @objid ("98ff5aa5-9a41-4003-830d-5fb0f418d5ad")
    public ComponentSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("281b7815-3231-4f67-bed1-5f993224a3d4")
    @Override
    public String getName() {
        return "Component";

    }

    @objid ("984b8cc7-bf9f-444e-a12e-c75552f8b4a6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f1eef7b4-95b5-4f92-8194-e87a394de84c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Component.class;

    }

    @objid ("d1abbd74-3b53-4a28-a24c-670d13ef30f2")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("9cfd7179-732f-419f-a249-9591270f28e1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5f075601-4546-44d6-b915-3155de085c93")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Class.MQNAME);
        this.registerFactory(new ComponentObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.realizationDep = new RealizationSmDependency();
        this.realizationDep.init("Realization", this, metamodel.getMClass(ComponentRealization.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.realizationDep);

    }

    @objid ("259b8b19-266d-40a9-9136-bdda8a427220")
    public SmDependency getRealizationDep() {
        if (this.realizationDep == null) {
        	this.realizationDep = this.getDependencyDef("Realization");
        }
        return this.realizationDep;
    }

    @objid ("1e6bcde6-6801-4d29-a18c-8c4b87018862")
    private static class ComponentObjectFactory implements ISmObjectFactory {
        @objid ("ed2d5dcf-1cd1-46c1-9de4-de12c7be4d20")
        private ComponentSmClass smClass;

        @objid ("4ef0f1f9-31b6-44f0-a7d9-b5ef344c9af4")
        public ComponentObjectFactory(ComponentSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e7a800c6-a269-4161-a6a0-36fcc4cb4a2a")
        @Override
        public ISmObjectData createData() {
            return new ComponentData(this.smClass);
        }

        @objid ("0f00c8ff-1ef8-49fe-9e81-1c1a0b271fa6")
        @Override
        public SmObjectImpl createImpl() {
            return new ComponentImpl();
        }

    }

    @objid ("0a4c68d9-139d-4814-9c65-022298ad3cb6")
    public static class RealizationSmDependency extends SmMultipleDependency {
        @objid ("3999a5c4-72ac-4711-bf37-269bc5779208")
        private SmDependency symetricDep;

        @objid ("4f1567aa-bdb2-449a-903c-ea3bdd9782db")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ComponentData)data).mRealization != null)? ((ComponentData)data).mRealization:SmMultipleDependency.EMPTY;
        }

        @objid ("91261fba-49d9-48f9-94f0-36855aface7b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ComponentData) data).mRealization = values;

        }

        @objid ("da41c3fa-b558-4080-9bb6-19ba2abe7608")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ComponentRealizationSmClass)this.getTarget()).getAbstractionDep();
            }
            return this.symetricDep;

        }

    }

}
