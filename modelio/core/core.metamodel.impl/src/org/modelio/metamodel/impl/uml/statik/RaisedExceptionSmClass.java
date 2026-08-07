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
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.RaisedException;
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

@objid ("b960d404-5093-4b35-8dd7-972452bceb08")
public class RaisedExceptionSmClass extends UmlModelElementSmClass {
    @objid ("715f26b0-1677-4bef-a121-9d5ead81b9cf")
    private SmDependency thrownTypeDep;

    @objid ("c4e9e0f3-cfb4-4876-940f-e0f1bf4380f7")
    private SmDependency throwerDep;

    @objid ("dec900f6-ab6b-4459-834d-4aea3116f746")
    public RaisedExceptionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5dfa9f96-a94c-4c03-a9f7-9f1e571ce7ae")
    @Override
    public String getName() {
        return "RaisedException";

    }

    @objid ("212a5372-6132-4d1d-88b8-1a31297480de")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f298e9e5-852b-4228-ad38-83f4ef6f251f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return RaisedException.class;

    }

    @objid ("5873a679-eb1f-424a-a6de-b8b45ddd17df")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b08822e1-db64-4d74-9e56-2a6fa9797823")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0fd21526-27df-45a9-a08f-7304cf494720")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new RaisedExceptionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.thrownTypeDep = new ThrownTypeSmDependency();
        this.thrownTypeDep.init("ThrownType", this, metamodel.getMClass(Classifier.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.thrownTypeDep);

        this.throwerDep = new ThrowerSmDependency();
        this.throwerDep.init("Thrower", this, metamodel.getMClass(Operation.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.throwerDep);

    }

    @objid ("cf713505-1cf0-4576-a481-09e8b6eb2687")
    public SmDependency getThrownTypeDep() {
        if (this.thrownTypeDep == null) {
        	this.thrownTypeDep = this.getDependencyDef("ThrownType");
        }
        return this.thrownTypeDep;
    }

    @objid ("0c5da780-8565-4ad8-82a7-efa31c19dbc7")
    public SmDependency getThrowerDep() {
        if (this.throwerDep == null) {
        	this.throwerDep = this.getDependencyDef("Thrower");
        }
        return this.throwerDep;
    }

    @objid ("b0975ca7-5d9e-4f5d-828a-a035e0461e8e")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("a29b4053-1a60-414c-8a97-d3201ced8c80")
    private static class RaisedExceptionObjectFactory implements ISmObjectFactory {
        @objid ("fe8bbf44-4917-451e-962a-03567cb2ef6c")
        private RaisedExceptionSmClass smClass;

        @objid ("d9476e39-4657-4a8a-9a99-576fc198a34a")
        public RaisedExceptionObjectFactory(RaisedExceptionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f857db14-d631-4f1b-b689-219cf1e1d9d5")
        @Override
        public ISmObjectData createData() {
            return new RaisedExceptionData(this.smClass);
        }

        @objid ("66244349-b4ab-4639-9acf-1a5dd7f7a2f8")
        @Override
        public SmObjectImpl createImpl() {
            return new RaisedExceptionImpl();
        }

    }

    @objid ("2ea0cdbb-972a-4dab-81e9-97d06903bd26")
    public static class ThrownTypeSmDependency extends SmSingleDependency {
        @objid ("52eaa344-c1b7-42bd-8185-6c7f0f0107b2")
        private SmDependency symetricDep;

        @objid ("14d33629-496e-4a1c-af55-131990b78805")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((RaisedExceptionData) data).mThrownType;
        }

        @objid ("c4fc12c9-a561-4721-8686-5a882223b264")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((RaisedExceptionData) data).mThrownType = value;
        }

        @objid ("cc4b9cf5-b1f6-43fa-afaf-5ebe237a3e5c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getThrowingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d215c73f-da99-4bcf-a6e7-44f99511556c")
    public static class ThrowerSmDependency extends SmSingleDependency {
        @objid ("ed1cc437-2cca-4a1c-8bc6-771b35a7a223")
        private SmDependency symetricDep;

        @objid ("606b74fe-17a5-42a2-8eb2-9d179960ff34")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((RaisedExceptionData) data).mThrower;
        }

        @objid ("7c98b570-4fb2-47ec-aedb-6d68df0fb21f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((RaisedExceptionData) data).mThrower = value;
        }

        @objid ("27fdab13-d168-4b46-8e1e-32fdc9a56fc4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getThrownDep();
            }
            return this.symetricDep;

        }

    }

}
