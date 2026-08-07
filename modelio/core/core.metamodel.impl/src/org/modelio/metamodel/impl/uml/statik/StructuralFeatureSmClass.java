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
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.Feature;
import org.modelio.metamodel.uml.statik.KindOfAccess;
import org.modelio.metamodel.uml.statik.StructuralFeature;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("cabc3fc3-c50a-4f12-8364-eadf0fa37a73")
public class StructuralFeatureSmClass extends FeatureSmClass {
    @objid ("e832752a-1e30-4043-b481-f601b66162e8")
    private SmAttribute changeableAtt;

    @objid ("2ca07c76-b6f5-44b0-926b-5837a42177b9")
    private SmAttribute isDerivedAtt;

    @objid ("24dbded6-a4dc-4a3d-8caf-9c435ad52229")
    private SmAttribute isOrderedAtt;

    @objid ("737ec8e1-21d4-44f9-a5db-69d1024dcfd3")
    private SmAttribute isUniqueAtt;

    @objid ("20e06f63-752d-47d4-9f93-415b3d70eb12")
    private SmAttribute multiplicityMinAtt;

    @objid ("3a25634e-d78b-47bf-8a17-0bf71e9c4566")
    private SmAttribute multiplicityMaxAtt;

    @objid ("cc15b408-e7ba-48c4-a980-073becff97d8")
    private SmDependency realizedInformationFlowDep;

    @objid ("3480cceb-9ecb-4a97-a2da-45c7df5f7799")
    public StructuralFeatureSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("63f88dda-5fa2-40ff-9039-cae6b5f87907")
    @Override
    public String getName() {
        return "StructuralFeature";

    }

    @objid ("dede53a8-2e2f-4c5c-bdeb-53d375c276fb")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5c015545-108c-48ec-93d0-bba635c74092")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StructuralFeature.class;

    }

    @objid ("67bee9a5-2f92-40a9-8a0b-2eb9063bd751")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1e12cf63-54de-4ed3-b99b-76be4f3ac930")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("26ba0fa0-bf81-4e4a-869a-864b2a28d7cd")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Feature.MQNAME);
        this.registerFactory(new StructuralFeatureObjectFactory(this));


        // Initialize and register the SmAttribute
        this.changeableAtt = new ChangeableSmAttribute();
        this.changeableAtt.init("Changeable", this, KindOfAccess.class );
        registerAttribute(this.changeableAtt);

        this.isDerivedAtt = new IsDerivedSmAttribute();
        this.isDerivedAtt.init("IsDerived", this, Boolean.class );
        registerAttribute(this.isDerivedAtt);

        this.isOrderedAtt = new IsOrderedSmAttribute();
        this.isOrderedAtt.init("IsOrdered", this, Boolean.class );
        registerAttribute(this.isOrderedAtt);

        this.isUniqueAtt = new IsUniqueSmAttribute();
        this.isUniqueAtt.init("IsUnique", this, Boolean.class );
        registerAttribute(this.isUniqueAtt);

        this.multiplicityMinAtt = new MultiplicityMinSmAttribute();
        this.multiplicityMinAtt.init("MultiplicityMin", this, String.class );
        registerAttribute(this.multiplicityMinAtt);

        this.multiplicityMaxAtt = new MultiplicityMaxSmAttribute();
        this.multiplicityMaxAtt.init("MultiplicityMax", this, String.class );
        registerAttribute(this.multiplicityMaxAtt);


        // Initialize and register the SmDependency
        this.realizedInformationFlowDep = new RealizedInformationFlowSmDependency();
        this.realizedInformationFlowDep.init("RealizedInformationFlow", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.realizedInformationFlowDep);

    }

    @objid ("8d425731-7763-41b2-9dee-1803bc358435")
    public SmAttribute getChangeableAtt() {
        if (this.changeableAtt == null) {
        	this.changeableAtt = this.getAttributeDef("Changeable");
        }
        return this.changeableAtt;
    }

    @objid ("81748204-c556-4d55-9e23-097773d64ec6")
    public SmAttribute getIsDerivedAtt() {
        if (this.isDerivedAtt == null) {
        	this.isDerivedAtt = this.getAttributeDef("IsDerived");
        }
        return this.isDerivedAtt;
    }

    @objid ("c4a23a59-c2e7-46d1-a24e-06723e224898")
    public SmAttribute getIsOrderedAtt() {
        if (this.isOrderedAtt == null) {
        	this.isOrderedAtt = this.getAttributeDef("IsOrdered");
        }
        return this.isOrderedAtt;
    }

    @objid ("c65e9880-4138-46b4-8a91-bd8cd2a80cd3")
    public SmAttribute getIsUniqueAtt() {
        if (this.isUniqueAtt == null) {
        	this.isUniqueAtt = this.getAttributeDef("IsUnique");
        }
        return this.isUniqueAtt;
    }

    @objid ("7b4d47c8-8295-4f1c-89ef-89171a99ea40")
    public SmAttribute getMultiplicityMinAtt() {
        if (this.multiplicityMinAtt == null) {
        	this.multiplicityMinAtt = this.getAttributeDef("MultiplicityMin");
        }
        return this.multiplicityMinAtt;
    }

    @objid ("b95602ed-4d16-4684-8092-56407b2455bb")
    public SmAttribute getMultiplicityMaxAtt() {
        if (this.multiplicityMaxAtt == null) {
        	this.multiplicityMaxAtt = this.getAttributeDef("MultiplicityMax");
        }
        return this.multiplicityMaxAtt;
    }

    @objid ("a262b9bf-a265-480a-9706-62a65e5bba5b")
    public SmDependency getRealizedInformationFlowDep() {
        if (this.realizedInformationFlowDep == null) {
        	this.realizedInformationFlowDep = this.getDependencyDef("RealizedInformationFlow");
        }
        return this.realizedInformationFlowDep;
    }

    @objid ("8a607818-28f3-40e3-a3db-c0369243d685")
    private static class StructuralFeatureObjectFactory implements ISmObjectFactory {
        @objid ("ff109dd0-545d-435b-bc94-b70f4d1c4fbb")
        private StructuralFeatureSmClass smClass;

        @objid ("cbf48ab5-9578-4e51-9984-af2d475db215")
        public StructuralFeatureObjectFactory(StructuralFeatureSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("24fc220a-d12a-40d7-9253-730a6ead58db")
        @Override
        public ISmObjectData createData() {
            return new StructuralFeatureData(this.smClass);
        }

        @objid ("4933d311-68fa-4aa8-b5df-f5ad2f4574c0")
        @Override
        public SmObjectImpl createImpl() {
            return new StructuralFeatureImpl();
        }

    }

    @objid ("bc58f30a-9fd4-4ffd-a582-ea3cf433c56a")
    public static class ChangeableSmAttribute extends SmAttribute {
        @objid ("1420131e-7f8e-4520-b850-3db153afd68a")
        public Object getValue(ISmObjectData data) {
            return ((StructuralFeatureData) data).mChangeable;
        }

        @objid ("b6ee2ca6-03bb-4f82-8f3c-8d2a09b2c71d")
        public void setValue(ISmObjectData data, Object value) {
            ((StructuralFeatureData) data).mChangeable = value;
        }

    }

    @objid ("07135451-fe1f-443e-9431-5cdbf690246a")
    public static class IsDerivedSmAttribute extends SmAttribute {
        @objid ("cadeda1d-cce8-4543-82b0-d4a9b65220c7")
        public Object getValue(ISmObjectData data) {
            return ((StructuralFeatureData) data).mIsDerived;
        }

        @objid ("f9ddf563-5e55-46de-9adb-235139b453df")
        public void setValue(ISmObjectData data, Object value) {
            ((StructuralFeatureData) data).mIsDerived = value;
        }

    }

    @objid ("246bdcc0-318e-4885-a9e9-692e8f2d6665")
    public static class IsOrderedSmAttribute extends SmAttribute {
        @objid ("ea51159e-9d91-4ea5-bfb1-dd90c51ab00a")
        public Object getValue(ISmObjectData data) {
            return ((StructuralFeatureData) data).mIsOrdered;
        }

        @objid ("222623b3-9bbf-423f-ad63-75fd041e54c3")
        public void setValue(ISmObjectData data, Object value) {
            ((StructuralFeatureData) data).mIsOrdered = value;
        }

    }

    @objid ("947c4cc3-0be8-4ec7-a026-29a54b235e0d")
    public static class IsUniqueSmAttribute extends SmAttribute {
        @objid ("90c761a3-68f4-467a-941a-4ef6f8a0f2f1")
        public Object getValue(ISmObjectData data) {
            return ((StructuralFeatureData) data).mIsUnique;
        }

        @objid ("7a09d54c-9c7c-4b16-b694-5064ddacc2c6")
        public void setValue(ISmObjectData data, Object value) {
            ((StructuralFeatureData) data).mIsUnique = value;
        }

    }

    @objid ("0d3c7616-841a-45eb-9316-cef4ecc8066a")
    public static class MultiplicityMinSmAttribute extends SmAttribute {
        @objid ("6fde19f1-5ceb-43e0-bb1d-018bc0df84d7")
        public Object getValue(ISmObjectData data) {
            return ((StructuralFeatureData) data).mMultiplicityMin;
        }

        @objid ("9b4ce9cb-0589-4d28-8064-9b802362b1bd")
        public void setValue(ISmObjectData data, Object value) {
            ((StructuralFeatureData) data).mMultiplicityMin = value;
        }

    }

    @objid ("70ec2a7c-c59b-412d-831a-88addeb38d8d")
    public static class MultiplicityMaxSmAttribute extends SmAttribute {
        @objid ("8c0fde26-f765-423f-98ec-58b8e348dd65")
        public Object getValue(ISmObjectData data) {
            return ((StructuralFeatureData) data).mMultiplicityMax;
        }

        @objid ("752e0c17-e1a9-4eef-bb1b-04e1e02b67c9")
        public void setValue(ISmObjectData data, Object value) {
            ((StructuralFeatureData) data).mMultiplicityMax = value;
        }

    }

    @objid ("bc01aa95-32c3-457c-bfc7-c73ea25cb330")
    public static class RealizedInformationFlowSmDependency extends SmMultipleDependency {
        @objid ("94d5cf4a-1630-4156-b264-ca53d2666aeb")
        private SmDependency symetricDep;

        @objid ("ca38eaaf-68f6-41a0-af8c-42e6fcf6fe37")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StructuralFeatureData)data).mRealizedInformationFlow != null)? ((StructuralFeatureData)data).mRealizedInformationFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("b69354dc-ab37-4e6d-8aec-6a330ec4cfac")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StructuralFeatureData) data).mRealizedInformationFlow = values;

        }

        @objid ("4f4a457c-6bce-4e92-8e95-f10b38e01231")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getRealizingFeatureDep();
            }
            return this.symetricDep;

        }

    }

}
