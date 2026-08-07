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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.NaryConnector;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c774246a-dc30-43bf-bb73-ffd464368bca")
public class NaryConnectorSmClass extends NaryLinkSmClass {
    @objid ("1fff5db3-8b7c-4ad0-9400-8ce51c3b1a11")
    private SmDependency representationDep;

    @objid ("4ef9397f-1894-4eb6-a589-c29e2403000e")
    private SmDependency representedFeatureDep;

    @objid ("29cf2876-6fd3-4bcb-8108-e2054e999f56")
    public NaryConnectorSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("687b8f67-64c7-4529-82b8-2a950b932633")
    @Override
    public String getName() {
        return "NaryConnector";

    }

    @objid ("16e44ede-7b50-424f-92d2-ddb0f5eb8b1d")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("07806a94-ca5a-41df-87f5-0fc8589cbdb1")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return NaryConnector.class;

    }

    @objid ("0fb580f2-3a82-42c1-ab15-4a416c8245d7")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3fd39cdf-fc35-4af0-94b1-3e68814d57a8")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("c2552697-9dba-41a9-94eb-d4e196cfe71f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(NaryLink.MQNAME);
        this.registerFactory(new NaryConnectorObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.representationDep = new RepresentationSmDependency();
        this.representationDep.init("Representation", this, metamodel.getMClass(Binding.MQNAME), 0, -1 );
        registerDependency(this.representationDep);

        this.representedFeatureDep = new RepresentedFeatureSmDependency();
        this.representedFeatureDep.init("RepresentedFeature", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedFeatureDep);

    }

    @objid ("aac56249-50f8-4ef3-b8e9-e4ce46795064")
    public SmDependency getRepresentationDep() {
        if (this.representationDep == null) {
        	this.representationDep = this.getDependencyDef("Representation");
        }
        return this.representationDep;
    }

    @objid ("d5dcb7ee-d6a8-4831-a744-29dfac749c4d")
    public SmDependency getRepresentedFeatureDep() {
        if (this.representedFeatureDep == null) {
        	this.representedFeatureDep = this.getDependencyDef("RepresentedFeature");
        }
        return this.representedFeatureDep;
    }

    @objid ("279b029b-6dea-4464-8974-75d2d7b0f5fa")
    private static class NaryConnectorObjectFactory implements ISmObjectFactory {
        @objid ("aff42a41-29ef-4a46-bfda-70cb67bbdbe2")
        private NaryConnectorSmClass smClass;

        @objid ("fbf6be62-c377-433f-9e7c-9066112478ae")
        public NaryConnectorObjectFactory(NaryConnectorSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("db23f63a-3aac-44e7-8067-02062c5aac15")
        @Override
        public ISmObjectData createData() {
            return new NaryConnectorData(this.smClass);
        }

        @objid ("89006111-6ae6-4cfd-8b13-5e3590d67d0e")
        @Override
        public SmObjectImpl createImpl() {
            return new NaryConnectorImpl();
        }

    }

    @objid ("47c210d6-d671-41c8-a036-5cf535433629")
    public static class RepresentationSmDependency extends SmMultipleDependency {
        @objid ("269f22a3-7fd9-4462-8b8a-d519b7b5e093")
        private SmDependency symetricDep;

        @objid ("8a1ae2c6-2bef-42d7-b881-b1b5dcd4b980")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NaryConnectorData)data).mRepresentation != null)? ((NaryConnectorData)data).mRepresentation:SmMultipleDependency.EMPTY;
        }

        @objid ("94ecd069-ef99-4f04-bd28-cbfd24683e97")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NaryConnectorData) data).mRepresentation = values;

        }

        @objid ("39bd517c-e531-4b15-9e2e-ef0604ee4595")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindingSmClass)this.getTarget()).getConnectorRoleDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5ea9c401-e886-451e-8990-b6da0dac5611")
    public static class RepresentedFeatureSmDependency extends SmSingleDependency {
        @objid ("29fe916d-6ba8-4a63-903b-b94ede23fb6d")
        private SmDependency symetricDep;

        @objid ("89b029ce-cc9e-475e-8b31-5fa3f407d608")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryConnectorData) data).mRepresentedFeature;
        }

        @objid ("77b28995-bc7b-435f-a7e0-41193bf13016")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryConnectorData) data).mRepresentedFeature = value;
        }

        @objid ("8d76604e-f3ce-424a-a23a-fba392c737c0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getRepresentingConnectorDep();
            }
            return this.symetricDep;

        }

    }

}
