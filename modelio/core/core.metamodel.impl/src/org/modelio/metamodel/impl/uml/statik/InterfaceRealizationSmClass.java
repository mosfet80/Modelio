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
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
import org.modelio.metamodel.uml.statik.NameSpace;
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

@objid ("af5d6ee8-f94d-4e95-84be-6bebc0cc3fdd")
public class InterfaceRealizationSmClass extends UmlModelElementSmClass {
    @objid ("c12b5857-93a6-459a-9c6e-3c4a9381a8b8")
    private SmDependency implementedDep;

    @objid ("db72360d-8b2e-47a9-a255-bd5e291d4d7c")
    private SmDependency implementerDep;

    @objid ("322834da-f242-4cb1-9840-09c91ef8facf")
    public InterfaceRealizationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("16928419-d9b4-4de7-98d9-2ca63247ef64")
    @Override
    public String getName() {
        return "InterfaceRealization";

    }

    @objid ("d529d211-41e1-4800-a5a2-1398d71dbaf7")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("74ded1ac-745e-4bd8-8c16-41fe3f7fdbf8")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InterfaceRealization.class;

    }

    @objid ("2e25d324-d89f-4ca3-8fa8-8c43a9929dee")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ee2d0999-3c0d-4ed9-8165-3ded52eccb85")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("cbb2ff8b-2c25-4615-a190-91819fd19eb5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new InterfaceRealizationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.implementedDep = new ImplementedSmDependency();
        this.implementedDep.init("Implemented", this, metamodel.getMClass(Interface.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.implementedDep);

        this.implementerDep = new ImplementerSmDependency();
        this.implementerDep.init("Implementer", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.implementerDep);

    }

    @objid ("17ba5772-49db-4cbd-bb25-c52094c9a536")
    public SmDependency getImplementedDep() {
        if (this.implementedDep == null) {
        	this.implementedDep = this.getDependencyDef("Implemented");
        }
        return this.implementedDep;
    }

    @objid ("16d03cff-42bd-477a-b027-727dbf8ca172")
    public SmDependency getImplementerDep() {
        if (this.implementerDep == null) {
        	this.implementerDep = this.getDependencyDef("Implementer");
        }
        return this.implementerDep;
    }

    @objid ("ae37038c-6e5a-41dd-882c-401e946a4220")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("90b653a6-2e0e-4edf-ae85-6fe1aa11da73")
    private static class InterfaceRealizationObjectFactory implements ISmObjectFactory {
        @objid ("cc7d9d59-0115-49f1-80a9-08f6a8be6a0c")
        private InterfaceRealizationSmClass smClass;

        @objid ("20429e3d-fbf0-41c1-aa09-a38ef60e17f3")
        public InterfaceRealizationObjectFactory(InterfaceRealizationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("181516d9-b3d2-4102-a69a-a81953622716")
        @Override
        public ISmObjectData createData() {
            return new InterfaceRealizationData(this.smClass);
        }

        @objid ("cb71fb23-e908-4968-b1e6-15cbfddd3f33")
        @Override
        public SmObjectImpl createImpl() {
            return new InterfaceRealizationImpl();
        }

    }

    @objid ("230d01cc-9694-480a-83eb-6ee4acaef4b0")
    public static class ImplementedSmDependency extends SmSingleDependency {
        @objid ("ec07184b-9e5c-47ea-9d74-bf3ab2211db3")
        private SmDependency symetricDep;

        @objid ("efbd16a2-80ee-433c-9f14-914702cfd1f9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InterfaceRealizationData) data).mImplemented;
        }

        @objid ("b8859f01-a96e-4dd9-8295-9744aba926ef")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InterfaceRealizationData) data).mImplemented = value;
        }

        @objid ("d935f67d-2edf-4e7f-8e52-5abb8a14e2fd")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InterfaceSmClass)this.getTarget()).getImplementedLinkDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a14f52f3-a855-4427-a79a-ec244d8d17b3")
    public static class ImplementerSmDependency extends SmSingleDependency {
        @objid ("0d2c2887-13cd-4df8-90e1-b27dd9a37c42")
        private SmDependency symetricDep;

        @objid ("9f7a0326-e5d8-4bcc-825b-f584ec6bc1cb")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InterfaceRealizationData) data).mImplementer;
        }

        @objid ("db14d107-45fd-4a3f-a7c7-b7688e492940")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InterfaceRealizationData) data).mImplementer = value;
        }

        @objid ("df462ae5-9e0e-4f73-b020-361532d2859a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getRealizedDep();
            }
            return this.symetricDep;

        }

    }

}
