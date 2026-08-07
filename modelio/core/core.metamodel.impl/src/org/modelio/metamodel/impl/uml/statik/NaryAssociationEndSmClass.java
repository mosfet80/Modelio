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
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.uml.statik.StructuralFeature;
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

@objid ("8b52c6d8-b2a1-483b-9534-357edc70ea1e")
public class NaryAssociationEndSmClass extends StructuralFeatureSmClass {
    @objid ("a0934019-1e68-4978-8718-519e50d4ef75")
    private SmDependency naryAssociationDep;

    @objid ("2a057610-c78b-468a-94b4-c896f84afbe7")
    private SmDependency ownerDep;

    @objid ("abe1e033-e30e-474a-86ac-731227e63a29")
    public NaryAssociationEndSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c1d7a255-8e34-418a-8dff-2be8db3a2b81")
    @Override
    public String getName() {
        return "NaryAssociationEnd";

    }

    @objid ("a7ee79f3-0fbb-47ab-9ce1-ff20ade93b29")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("834515ab-c4d2-4c27-89f5-6dcc78cbdd6a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return NaryAssociationEnd.class;

    }

    @objid ("0cb1701f-cbd8-4398-b20f-d057e0f5a2f2")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("2b8909dd-7899-45e5-b176-34222f9867e4")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("42147772-8a1d-47e9-91c5-e359485d5885")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuralFeature.MQNAME);
        this.registerFactory(new NaryAssociationEndObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.naryAssociationDep = new NaryAssociationSmDependency();
        this.naryAssociationDep.init("NaryAssociation", this, metamodel.getMClass(NaryAssociation.MQNAME), 1, 1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.naryAssociationDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(Classifier.MQNAME), 1, 1 );
        registerDependency(this.ownerDep);

    }

    @objid ("4e979d6c-5f7b-44b3-b6e5-f25e70953d05")
    public SmDependency getNaryAssociationDep() {
        if (this.naryAssociationDep == null) {
        	this.naryAssociationDep = this.getDependencyDef("NaryAssociation");
        }
        return this.naryAssociationDep;
    }

    @objid ("f0629718-2065-4dfd-a79c-d74608ea57de")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("e6a43f06-7934-4bfb-92d3-ffab8fe431d3")
    private static class NaryAssociationEndObjectFactory implements ISmObjectFactory {
        @objid ("be3209a4-fe8f-4f0b-addc-e7bbde12f2e9")
        private NaryAssociationEndSmClass smClass;

        @objid ("41effea7-bc88-44fb-b3d0-188ed7dbb3ff")
        public NaryAssociationEndObjectFactory(NaryAssociationEndSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2e0a0ab3-509c-4829-abd4-d8b1589262a3")
        @Override
        public ISmObjectData createData() {
            return new NaryAssociationEndData(this.smClass);
        }

        @objid ("e0f11113-3d73-4321-a286-edac92fe8eb1")
        @Override
        public SmObjectImpl createImpl() {
            return new NaryAssociationEndImpl();
        }

    }

    @objid ("0e0baf00-9a7d-4293-8d1b-8fb714119cb5")
    public static class NaryAssociationSmDependency extends SmSingleDependency {
        @objid ("253372ce-bfa9-4e47-ad2f-fc0906b07fe1")
        private SmDependency symetricDep;

        @objid ("bb00fdb1-0575-4e34-b5a7-63af9e26f963")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryAssociationEndData) data).mNaryAssociation;
        }

        @objid ("b04802d8-5f1a-4982-ba2d-13894f3e50ef")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryAssociationEndData) data).mNaryAssociation = value;
        }

        @objid ("825156ab-a6ca-43d3-8b45-b70c4b3d9f79")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryAssociationSmClass)this.getTarget()).getNaryEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6f3e8882-8768-4454-916a-1bd701bd766a")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("dba6b3e1-ff04-4c59-b4ac-5b1e5eaf44f0")
        private SmDependency symetricDep;

        @objid ("308cf8d1-777f-4dbb-98b9-cbf66f0e7180")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryAssociationEndData) data).mOwner;
        }

        @objid ("a1ef3c09-1472-4117-ace6-3c55fc6dfbef")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryAssociationEndData) data).mOwner = value;
        }

        @objid ("db81d6d6-cffa-4c2e-a670-a0c86067eb95")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getOwnedNaryEndDep();
            }
            return this.symetricDep;

        }

    }

}
