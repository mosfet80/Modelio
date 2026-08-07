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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Enumeration;
import org.modelio.metamodel.uml.statik.EnumerationLiteral;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("d14877d6-45e4-49f7-92c5-6db955704cf5")
public class EnumerationLiteralSmClass extends UmlModelElementSmClass {
    @objid ("1f285328-8090-4603-9056-c8eae93c12ce")
    private SmDependency valuatedDep;

    @objid ("944ec109-b75d-4126-9c34-59187260e3d4")
    public EnumerationLiteralSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0f3e085f-7f6b-4184-b50d-097e81969573")
    @Override
    public String getName() {
        return "EnumerationLiteral";

    }

    @objid ("66c0f580-2647-438b-8066-a148f27438ed")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3bc3c4ad-f989-4332-9e16-e75ff67781f5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return EnumerationLiteral.class;

    }

    @objid ("0f2add9e-df1f-4d69-99d6-40f0518b3df0")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6e42f89a-1c74-4921-be3e-fb668d3f2e95")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("c00b79e5-1278-4e82-9b8c-3ad582406854")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new EnumerationLiteralObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.valuatedDep = new ValuatedSmDependency();
        this.valuatedDep.init("Valuated", this, metamodel.getMClass(Enumeration.MQNAME), 1, 1 );
        registerDependency(this.valuatedDep);

    }

    @objid ("ce0a3bd5-e2b0-4cb1-a74b-164afead3baf")
    public SmDependency getValuatedDep() {
        if (this.valuatedDep == null) {
        	this.valuatedDep = this.getDependencyDef("Valuated");
        }
        return this.valuatedDep;
    }

    @objid ("76402487-664a-4d9e-ac9f-90efe26e0dfb")
    private static class EnumerationLiteralObjectFactory implements ISmObjectFactory {
        @objid ("5bd802d3-d7eb-4d4e-ba31-a7a7ef6a9344")
        private EnumerationLiteralSmClass smClass;

        @objid ("a761b4a4-183d-46b0-b4a6-d09328664ad0")
        public EnumerationLiteralObjectFactory(EnumerationLiteralSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("229927c8-069f-4799-818b-4c915190c637")
        @Override
        public ISmObjectData createData() {
            return new EnumerationLiteralData(this.smClass);
        }

        @objid ("512eba58-98a3-4182-9a26-d1d6fa6992f1")
        @Override
        public SmObjectImpl createImpl() {
            return new EnumerationLiteralImpl();
        }

    }

    @objid ("243e7d39-af71-4b90-a709-2534be80e17b")
    public static class ValuatedSmDependency extends SmSingleDependency {
        @objid ("70aa6e99-bd24-46aa-87d1-3d9ddae3c94a")
        private SmDependency symetricDep;

        @objid ("b2ebe1a8-2b1e-40e5-b30a-51247f5b0643")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((EnumerationLiteralData) data).mValuated;
        }

        @objid ("3eea3ab0-561e-4509-8d7c-25c71e2f991d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((EnumerationLiteralData) data).mValuated = value;
        }

        @objid ("1fc70930-83d2-4326-a8cd-9e615ca2e4be")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EnumerationSmClass)this.getTarget()).getValueDep();
            }
            return this.symetricDep;

        }

    }

}
