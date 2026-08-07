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
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;
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

@objid ("c59234f4-eed7-4a54-9c04-69ac1b210ba1")
public class InterfaceSmClass extends GeneralClassSmClass {
    @objid ("0e60e9b2-40f6-43a2-a61f-09ef731f1a74")
    private SmDependency requiringDep;

    @objid ("07dfed85-4698-4c3b-9117-3826b0df0491")
    private SmDependency implementedLinkDep;

    @objid ("39b17e61-ed46-4b6c-a1e3-0610848a3f2f")
    private SmDependency providingDep;

    @objid ("057fe5cc-5792-49fd-8877-d55f474130af")
    public InterfaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f0cccd63-3cc7-45ea-9856-814efbe72a69")
    @Override
    public String getName() {
        return "Interface";

    }

    @objid ("0b0c5757-f53d-49b7-91e0-5c1c09adc06c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("138d7df5-80df-40d3-99eb-b1978fc45682")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Interface.class;

    }

    @objid ("4b562d76-d1b4-4c0b-af89-234d78288049")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("6cc6dc23-b75b-46c7-857a-bba295ebd003")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("06c447c4-ff82-4445-9e4f-7ec35dce2853")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new InterfaceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.requiringDep = new RequiringSmDependency();
        this.requiringDep.init("Requiring", this, metamodel.getMClass(RequiredInterface.MQNAME), 0, -1 );
        registerDependency(this.requiringDep);

        this.implementedLinkDep = new ImplementedLinkSmDependency();
        this.implementedLinkDep.init("ImplementedLink", this, metamodel.getMClass(InterfaceRealization.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC, SmDirective.SMCDTODELETE);
        registerDependency(this.implementedLinkDep);

        this.providingDep = new ProvidingSmDependency();
        this.providingDep.init("Providing", this, metamodel.getMClass(ProvidedInterface.MQNAME), 0, -1 );
        registerDependency(this.providingDep);

    }

    @objid ("339e5667-2e1b-4fe9-9c63-6793c50e4b10")
    public SmDependency getRequiringDep() {
        if (this.requiringDep == null) {
        	this.requiringDep = this.getDependencyDef("Requiring");
        }
        return this.requiringDep;
    }

    @objid ("8ccb3712-6c49-4c4a-aa96-1bfd1852c20f")
    public SmDependency getImplementedLinkDep() {
        if (this.implementedLinkDep == null) {
        	this.implementedLinkDep = this.getDependencyDef("ImplementedLink");
        }
        return this.implementedLinkDep;
    }

    @objid ("962c0c7d-6208-4306-a624-1eb5f797ff26")
    public SmDependency getProvidingDep() {
        if (this.providingDep == null) {
        	this.providingDep = this.getDependencyDef("Providing");
        }
        return this.providingDep;
    }

    @objid ("5737f9de-e044-43b4-8260-a09bb190d9e9")
    private static class InterfaceObjectFactory implements ISmObjectFactory {
        @objid ("5c5b0ba4-8986-4eed-92dd-559a03d62fc2")
        private InterfaceSmClass smClass;

        @objid ("46cadf31-5de1-4e96-9c82-8e30e691b127")
        public InterfaceObjectFactory(InterfaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("76186cff-8520-47b9-b888-5bff6d24bd8d")
        @Override
        public ISmObjectData createData() {
            return new InterfaceData(this.smClass);
        }

        @objid ("1b313af0-615b-40c0-9dc4-56dea0d7156a")
        @Override
        public SmObjectImpl createImpl() {
            return new InterfaceImpl();
        }

    }

    @objid ("25c9524a-8ac7-48ca-975f-c27cd35fa98b")
    public static class RequiringSmDependency extends SmMultipleDependency {
        @objid ("4cb9c8a4-8f77-4f26-84ad-e15e7d90b874")
        private SmDependency symetricDep;

        @objid ("20487c1c-4993-45e0-bbdd-ad0d49c880de")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InterfaceData)data).mRequiring != null)? ((InterfaceData)data).mRequiring:SmMultipleDependency.EMPTY;
        }

        @objid ("3c44a0c4-21d0-40bd-a0fa-f59923de767d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InterfaceData) data).mRequiring = values;

        }

        @objid ("bec91a04-171b-4e1d-87c4-5d59effa1d3c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RequiredInterfaceSmClass)this.getTarget()).getRequiredElementDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c552d7fc-203f-4643-9ed5-68ccc7735479")
    public static class ImplementedLinkSmDependency extends SmMultipleDependency {
        @objid ("67c9705f-e8a5-444e-8cbd-68f7563ea33b")
        private SmDependency symetricDep;

        @objid ("a2a8f911-8baa-4ee7-9da3-625c44018782")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InterfaceData)data).mImplementedLink != null)? ((InterfaceData)data).mImplementedLink:SmMultipleDependency.EMPTY;
        }

        @objid ("3a4ccc3a-b230-433b-9874-c07051cfb0a9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InterfaceData) data).mImplementedLink = values;

        }

        @objid ("706f8188-8c4b-4b1f-9a98-fbb7cf816514")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InterfaceRealizationSmClass)this.getTarget()).getImplementedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("436f9b52-892f-4bf6-89da-0ce987609b0e")
    public static class ProvidingSmDependency extends SmMultipleDependency {
        @objid ("b4649472-d13e-4de0-aae8-365bc6a051b2")
        private SmDependency symetricDep;

        @objid ("12835766-8fad-413f-bf43-40f559c8752b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InterfaceData)data).mProviding != null)? ((InterfaceData)data).mProviding:SmMultipleDependency.EMPTY;
        }

        @objid ("b08b444e-b0a8-44fb-9daf-7d86c712cc95")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InterfaceData) data).mProviding = values;

        }

        @objid ("bdd4a38d-0a7e-4364-82fd-e118704a5ce8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ProvidedInterfaceSmClass)this.getTarget()).getProvidedElementDep();
            }
            return this.symetricDep;

        }

    }

}
