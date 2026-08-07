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
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Instance;
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

@objid ("929c1766-d895-4a01-9a64-35321250afcc")
public class BindableInstanceSmClass extends InstanceSmClass {
    @objid ("4c39d60a-9e21-4dfc-97e6-4cb185d643d5")
    private SmDependency clusterDep;

    @objid ("4547a9cd-9090-416d-b765-e3a849d9bbf0")
    private SmDependency internalOwnerDep;

    @objid ("1622af4e-4e66-4c94-b3c3-caa719874082")
    private SmDependency representationDep;

    @objid ("de68da61-f49e-4278-8670-30a31496b722")
    private SmDependency representedFeatureDep;

    @objid ("a08c64ea-131a-47b9-9087-f7e711e0e069")
    public BindableInstanceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("723fb831-2c4c-42f8-ab6b-1c0642672e99")
    @Override
    public String getName() {
        return "BindableInstance";

    }

    @objid ("494d2289-1813-47fb-9df4-971ea12c8e14")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3ad100d6-aecb-4f16-83c4-efaa2fd63461")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BindableInstance.class;

    }

    @objid ("05da1a1d-a4f2-4e1d-a2b4-cfcc97c60d49")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("142d8c3b-e459-4b96-8389-40e97800262e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("dd9d3d30-a78d-4e1d-80d9-2b63da48ef88")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Instance.MQNAME);
        this.registerFactory(new BindableInstanceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.clusterDep = new ClusterSmDependency();
        this.clusterDep.init("Cluster", this, metamodel.getMClass(Instance.MQNAME), 0, 1 );
        registerDependency(this.clusterDep);

        this.internalOwnerDep = new InternalOwnerSmDependency();
        this.internalOwnerDep.init("InternalOwner", this, metamodel.getMClass(Classifier.MQNAME), 0, 1 );
        registerDependency(this.internalOwnerDep);

        this.representationDep = new RepresentationSmDependency();
        this.representationDep.init("Representation", this, metamodel.getMClass(Binding.MQNAME), 0, -1 );
        registerDependency(this.representationDep);

        this.representedFeatureDep = new RepresentedFeatureSmDependency();
        this.representedFeatureDep.init("RepresentedFeature", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedFeatureDep);

    }

    @objid ("8bc069ca-2c1a-4a6c-928b-70c12b0ad20c")
    public SmDependency getClusterDep() {
        if (this.clusterDep == null) {
        	this.clusterDep = this.getDependencyDef("Cluster");
        }
        return this.clusterDep;
    }

    @objid ("be991f4a-31ac-4bee-8a1e-1f2306f26f9b")
    public SmDependency getInternalOwnerDep() {
        if (this.internalOwnerDep == null) {
        	this.internalOwnerDep = this.getDependencyDef("InternalOwner");
        }
        return this.internalOwnerDep;
    }

    @objid ("b14cea03-6ef7-4de5-b9e5-bb18d2c3e17a")
    public SmDependency getRepresentationDep() {
        if (this.representationDep == null) {
        	this.representationDep = this.getDependencyDef("Representation");
        }
        return this.representationDep;
    }

    @objid ("ddb18082-9394-491f-9af6-79b7fbb5c8f5")
    public SmDependency getRepresentedFeatureDep() {
        if (this.representedFeatureDep == null) {
        	this.representedFeatureDep = this.getDependencyDef("RepresentedFeature");
        }
        return this.representedFeatureDep;
    }

    @objid ("9cf26865-0d09-4dd3-a0e6-fd48a1f71a29")
    private static class BindableInstanceObjectFactory implements ISmObjectFactory {
        @objid ("8ead1365-02bc-4aeb-bfae-124e39e0df33")
        private BindableInstanceSmClass smClass;

        @objid ("e9cf7fda-91a0-4657-8c8a-77ef5fdb1a47")
        public BindableInstanceObjectFactory(BindableInstanceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e1fbae5a-1e6a-4261-9b2a-4695f988fa04")
        @Override
        public ISmObjectData createData() {
            return new BindableInstanceData(this.smClass);
        }

        @objid ("bf620a0e-2055-4491-917c-faa331e24fc8")
        @Override
        public SmObjectImpl createImpl() {
            return new BindableInstanceImpl();
        }

    }

    @objid ("8822c08a-5a58-4c7d-b551-2ada873d7b70")
    public static class ClusterSmDependency extends SmSingleDependency {
        @objid ("487eba48-9258-4b5b-a2d0-575a05947f9c")
        private SmDependency symetricDep;

        @objid ("ad517fb1-2555-4715-9ea6-74b068d7ee8b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindableInstanceData) data).mCluster;
        }

        @objid ("b1dd0d48-2a60-4b08-95ca-34cce8c97a9f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindableInstanceData) data).mCluster = value;
        }

        @objid ("79ecb9d5-2276-49b4-ae8d-95407da99857")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getPartDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("27ffb7fe-d71c-4f2e-b992-5f8c555f6e99")
    public static class InternalOwnerSmDependency extends SmSingleDependency {
        @objid ("e7afc655-0024-47df-9728-425e3dd9b312")
        private SmDependency symetricDep;

        @objid ("72b4dcc1-82d3-4d6a-a788-bd7f45b94f9c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindableInstanceData) data).mInternalOwner;
        }

        @objid ("774f1761-913f-47dc-a90c-fc6ca150d5e5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindableInstanceData) data).mInternalOwner = value;
        }

        @objid ("716ae828-8432-4c99-9a09-4c296f1ef1f8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getInternalStructureDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("eed184a9-9094-451a-afdb-0e6f898d5a3e")
    public static class RepresentationSmDependency extends SmMultipleDependency {
        @objid ("34fe411d-a8ad-44b7-bf59-60efb64030a0")
        private SmDependency symetricDep;

        @objid ("4b1d01a2-3e6c-40de-87c1-af4e17e95b6b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BindableInstanceData)data).mRepresentation != null)? ((BindableInstanceData)data).mRepresentation:SmMultipleDependency.EMPTY;
        }

        @objid ("169307c9-9485-45fd-91cf-43cfbd3e6dd1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BindableInstanceData) data).mRepresentation = values;

        }

        @objid ("0e643fcf-7dac-48fe-8bab-88dad4d77dd6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindingSmClass)this.getTarget()).getRoleDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9fb9688f-85fd-4811-9a44-5bada06fd5b9")
    public static class RepresentedFeatureSmDependency extends SmSingleDependency {
        @objid ("9a1877f9-7fb8-44fe-94d0-bd646eb7e0b6")
        private SmDependency symetricDep;

        @objid ("a0f707fd-0d08-4607-9a6d-c225d511e525")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindableInstanceData) data).mRepresentedFeature;
        }

        @objid ("5b675790-d120-4574-b5e3-c6c2b3b272f5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindableInstanceData) data).mRepresentedFeature = value;
        }

        @objid ("c954aad2-54b9-4843-ab6f-34d5310a1224")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getRepresentingInstanceDep();
            }
            return this.symetricDep;

        }

    }

}
