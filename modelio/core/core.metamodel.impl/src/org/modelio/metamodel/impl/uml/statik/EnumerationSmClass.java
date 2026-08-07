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
import org.modelio.metamodel.uml.statik.Enumeration;
import org.modelio.metamodel.uml.statik.EnumerationLiteral;
import org.modelio.metamodel.uml.statik.GeneralClass;
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

@objid ("49bcd7f8-1b5e-4962-82fc-c54ac6966058")
public class EnumerationSmClass extends GeneralClassSmClass {
    @objid ("2000d593-95ca-4c0e-9833-5d95b20bab02")
    private SmDependency valueDep;

    @objid ("0b0bf003-dc6f-4e22-a167-3f46264ffbb1")
    public EnumerationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("82251b01-aa06-4ad4-896f-c798013396fd")
    @Override
    public String getName() {
        return "Enumeration";

    }

    @objid ("b701a464-e6de-4c85-9c5c-e50c288aef6f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("30b6e53f-444b-49e9-8b7d-dd49e16d20e3")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Enumeration.class;

    }

    @objid ("738f933d-2a90-4515-a4af-92b465c62cda")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7a881be0-74c1-4d01-8d83-97652ffcdc39")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("cd879596-8c9d-46bb-8838-e86e939e50f0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new EnumerationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.valueDep = new ValueSmDependency();
        this.valueDep.init("Value", this, metamodel.getMClass(EnumerationLiteral.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.valueDep);

    }

    @objid ("6846da9e-e4da-4e06-a193-1d444a1b48d7")
    public SmDependency getValueDep() {
        if (this.valueDep == null) {
        	this.valueDep = this.getDependencyDef("Value");
        }
        return this.valueDep;
    }

    @objid ("23dfb1da-9abd-48db-9481-a9dc0db3df98")
    private static class EnumerationObjectFactory implements ISmObjectFactory {
        @objid ("b00a3ac6-0a1f-4145-829d-013966429e74")
        private EnumerationSmClass smClass;

        @objid ("c50b5526-8e88-4737-9fb9-c3e83469fab4")
        public EnumerationObjectFactory(EnumerationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d0f7d16a-851a-4392-b7b1-a9e91929c0eb")
        @Override
        public ISmObjectData createData() {
            return new EnumerationData(this.smClass);
        }

        @objid ("a8f5e94b-00c6-40b8-bd46-25616fe31f5a")
        @Override
        public SmObjectImpl createImpl() {
            return new EnumerationImpl();
        }

    }

    @objid ("ec134b37-d414-4471-9fc0-690c7b03b561")
    public static class ValueSmDependency extends SmMultipleDependency {
        @objid ("18528803-b755-4a65-a4f4-3cfb2c16d47f")
        private SmDependency symetricDep;

        @objid ("8aaf311f-8b56-44f1-9293-7812f5f0277d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((EnumerationData)data).mValue != null)? ((EnumerationData)data).mValue:SmMultipleDependency.EMPTY;
        }

        @objid ("a172d4ca-9f95-47d8-a3fd-092754609c70")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((EnumerationData) data).mValue = values;

        }

        @objid ("f5da3770-c96f-4368-a1fd-41eea70ff872")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EnumerationLiteralSmClass)this.getTarget()).getValuatedDep();
            }
            return this.symetricDep;

        }

    }

}
