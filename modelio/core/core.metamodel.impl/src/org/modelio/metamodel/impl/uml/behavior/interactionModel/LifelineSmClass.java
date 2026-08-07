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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.InstanceSmClass;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.behavior.interactionModel.PartDecomposition;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Instance;
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
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("21ee1855-80e2-44cf-9070-e41222bd7696")
public class LifelineSmClass extends UmlModelElementSmClass {
    @objid ("0dab04db-b6a6-49d3-9a2a-17c475cfbd1d")
    private SmAttribute selectorAtt;

    @objid ("c7b2b4f2-35f2-46d1-b031-4a26bc57938b")
    private SmDependency coveredByDep;

    @objid ("0bb709a3-d035-4aba-8048-094014512f8e")
    private SmDependency decomposedAsDep;

    @objid ("cac5d811-446c-45ff-88a3-88fb6c4ae720")
    private SmDependency ownerDep;

    @objid ("585bdcf1-2ca9-4e24-90df-82bebe010341")
    private SmDependency representedDep;

    @objid ("c1c68eea-1182-4ac0-9355-f29219c49374")
    public LifelineSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("42d09f21-9124-49f3-96c9-ce62988df337")
    @Override
    public String getName() {
        return "Lifeline";

    }

    @objid ("e4d74a4f-c197-44ff-a960-299d04eb6320")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("96fefeca-6d2f-4922-ad7c-bf99cbede964")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Lifeline.class;

    }

    @objid ("39d5b82a-ea7f-40e1-9808-935f4fb0f445")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("10d10878-cfb0-4081-b6a4-d2f5fa99c6d1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f3db4079-dffa-4340-bcf5-e4d3ba91d746")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new LifelineObjectFactory(this));


        // Initialize and register the SmAttribute
        this.selectorAtt = new SelectorSmAttribute();
        this.selectorAtt.init("Selector", this, String.class );
        registerAttribute(this.selectorAtt);


        // Initialize and register the SmDependency
        this.coveredByDep = new CoveredBySmDependency();
        this.coveredByDep.init("CoveredBy", this, metamodel.getMClass(InteractionFragment.MQNAME), 0, -1 );
        registerDependency(this.coveredByDep);

        this.decomposedAsDep = new DecomposedAsSmDependency();
        this.decomposedAsDep.init("DecomposedAs", this, metamodel.getMClass(PartDecomposition.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.decomposedAsDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(Interaction.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.representedDep = new RepresentedSmDependency();
        this.representedDep.init("Represented", this, metamodel.getMClass(Instance.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedDep);

    }

    @objid ("8a4086ca-5681-4c0d-9838-c6faa86fb919")
    public SmAttribute getSelectorAtt() {
        if (this.selectorAtt == null) {
        	this.selectorAtt = this.getAttributeDef("Selector");
        }
        return this.selectorAtt;
    }

    @objid ("b43ab145-e8be-435d-8442-87477d81abff")
    public SmDependency getCoveredByDep() {
        if (this.coveredByDep == null) {
        	this.coveredByDep = this.getDependencyDef("CoveredBy");
        }
        return this.coveredByDep;
    }

    @objid ("b44d431d-99c7-4e32-9f85-746008f7f225")
    public SmDependency getDecomposedAsDep() {
        if (this.decomposedAsDep == null) {
        	this.decomposedAsDep = this.getDependencyDef("DecomposedAs");
        }
        return this.decomposedAsDep;
    }

    @objid ("2e50d8a7-2f49-413c-ac76-f578f844e087")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("f34db15b-5e3f-4d3a-b69e-86da3fb01171")
    public SmDependency getRepresentedDep() {
        if (this.representedDep == null) {
        	this.representedDep = this.getDependencyDef("Represented");
        }
        return this.representedDep;
    }

    @objid ("5847d495-0182-45e5-a2b9-c469242b1b96")
    private static class LifelineObjectFactory implements ISmObjectFactory {
        @objid ("68a916f0-ea8a-46cf-8607-cd4262a9cc92")
        private LifelineSmClass smClass;

        @objid ("a0a9b52b-85a0-4114-a90a-2fdfbd2307ec")
        public LifelineObjectFactory(LifelineSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d33ed59c-19d5-4d59-8f35-c079ecbc5cf5")
        @Override
        public ISmObjectData createData() {
            return new LifelineData(this.smClass);
        }

        @objid ("50a60872-541e-45db-bb9d-f9ab610b1d00")
        @Override
        public SmObjectImpl createImpl() {
            return new LifelineImpl();
        }

    }

    @objid ("a6d61419-08a9-4393-b021-a7257d0cb5bd")
    public static class SelectorSmAttribute extends SmAttribute {
        @objid ("4c48e3fd-9c5e-44ea-901c-f5f8db745b33")
        public Object getValue(ISmObjectData data) {
            return ((LifelineData) data).mSelector;
        }

        @objid ("43581f7d-de42-4615-92cb-0e15c9d4b5c1")
        public void setValue(ISmObjectData data, Object value) {
            ((LifelineData) data).mSelector = value;
        }

    }

    @objid ("f8c4616d-c0da-47f8-a81e-3932461da420")
    public static class CoveredBySmDependency extends SmMultipleDependency {
        @objid ("77bb2714-46c2-491f-9a4e-b3de4b8be129")
        private SmDependency symetricDep;

        @objid ("a3f3461b-1f75-4f11-bda0-18b6dd3e8656")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((LifelineData)data).mCoveredBy != null)? ((LifelineData)data).mCoveredBy:SmMultipleDependency.EMPTY;
        }

        @objid ("004ac65d-4171-47e5-b986-f5fad021c6b5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((LifelineData) data).mCoveredBy = values;

        }

        @objid ("e25e5508-ec87-4289-838b-e109e03217df")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionFragmentSmClass)this.getTarget()).getCoveredDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bf0e6bbd-8786-4d3d-86a4-24924239eac3")
    public static class DecomposedAsSmDependency extends SmSingleDependency {
        @objid ("99bdfd35-c9f7-4f79-a629-98a03f5a86de")
        private SmDependency symetricDep;

        @objid ("8eefd9b3-13b1-42c6-87b7-2b5ad520fb4a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LifelineData) data).mDecomposedAs;
        }

        @objid ("20ee2afa-cfcf-4a1b-8a42-fb684735f0b7")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LifelineData) data).mDecomposedAs = value;
        }

        @objid ("9cec7bd1-d180-4c47-a99c-b958ece2ad9f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PartDecompositionSmClass)this.getTarget()).getDecomposedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9b0a748c-0559-45fc-b4dc-d8688addc020")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("bd52b077-5740-4aa4-9e66-be33ddfa83ec")
        private SmDependency symetricDep;

        @objid ("321c5615-291c-4756-aa64-044e1d3272fe")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LifelineData) data).mOwner;
        }

        @objid ("9dcd9796-5d8e-4703-a53f-86cba9f51647")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LifelineData) data).mOwner = value;
        }

        @objid ("4930fd23-344e-48e1-aeec-597f995c2960")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionSmClass)this.getTarget()).getOwnedLineDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("184334fc-86a6-4cb0-895e-28f7dbb393c9")
    public static class RepresentedSmDependency extends SmSingleDependency {
        @objid ("2af553d3-8c61-4302-862c-81062881df2b")
        private SmDependency symetricDep;

        @objid ("51165873-0dae-4da4-901b-6e74ff1360ab")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LifelineData) data).mRepresented;
        }

        @objid ("4e509b81-52c0-4c8d-9c39-c0358edead1d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LifelineData) data).mRepresented = value;
        }

        @objid ("f44952df-d86e-4d92-a4a9-d0c3fda192bc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getRepresentedLifeLineDep();
            }
            return this.symetricDep;

        }

    }

}
