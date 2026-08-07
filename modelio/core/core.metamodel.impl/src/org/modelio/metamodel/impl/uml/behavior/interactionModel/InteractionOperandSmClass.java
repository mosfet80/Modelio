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
import org.modelio.metamodel.uml.behavior.interactionModel.CombinedFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperand;
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

@objid ("c9d77df3-ebef-478b-a2d2-108d7bdf7579")
public class InteractionOperandSmClass extends InteractionFragmentSmClass {
    @objid ("50b12505-c45d-4f1b-a8bc-77133e93e9ae")
    private SmAttribute guardAtt;

    @objid ("27d1c06e-3d18-49b3-9f1e-ddbf2baf9411")
    private SmAttribute endLineNumberAtt;

    @objid ("250b80fe-3cee-4415-b93e-d589a80155f1")
    private SmDependency fragmentDep;

    @objid ("26c3dff4-2516-486f-bbbe-b41468175c81")
    private SmDependency ownerFragmentDep;

    @objid ("068ae074-977e-41e3-9d10-8318178807c8")
    public InteractionOperandSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("25cd1470-58fc-4353-bfac-4d4fc70de8aa")
    @Override
    public String getName() {
        return "InteractionOperand";

    }

    @objid ("a0e34ff3-3bcf-4c3c-9427-f17af37090de")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5aea5535-8487-4eb3-a610-f33e63c46122")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InteractionOperand.class;

    }

    @objid ("a74adcd1-9b63-4661-b16f-90f968421021")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ce1aee2c-a26f-4a27-8d70-b1f532a61cd6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ffbacc94-245e-4b55-aaac-ca89003175a4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InteractionFragment.MQNAME);
        this.registerFactory(new InteractionOperandObjectFactory(this));


        // Initialize and register the SmAttribute
        this.guardAtt = new GuardSmAttribute();
        this.guardAtt.init("Guard", this, String.class );
        registerAttribute(this.guardAtt);

        this.endLineNumberAtt = new EndLineNumberSmAttribute();
        this.endLineNumberAtt.init("EndLineNumber", this, Integer.class );
        registerAttribute(this.endLineNumberAtt);


        // Initialize and register the SmDependency
        this.fragmentDep = new FragmentSmDependency();
        this.fragmentDep.init("Fragment", this, metamodel.getMClass(InteractionFragment.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.fragmentDep);

        this.ownerFragmentDep = new OwnerFragmentSmDependency();
        this.ownerFragmentDep.init("OwnerFragment", this, metamodel.getMClass(CombinedFragment.MQNAME), 0, 1 );
        registerDependency(this.ownerFragmentDep);

    }

    @objid ("d2842905-2a46-4328-95de-79c5daa0ae8d")
    public SmAttribute getGuardAtt() {
        if (this.guardAtt == null) {
        	this.guardAtt = this.getAttributeDef("Guard");
        }
        return this.guardAtt;
    }

    @objid ("627aa34a-dcc2-4f5e-b009-406a181ef34a")
    public SmAttribute getEndLineNumberAtt() {
        if (this.endLineNumberAtt == null) {
        	this.endLineNumberAtt = this.getAttributeDef("EndLineNumber");
        }
        return this.endLineNumberAtt;
    }

    @objid ("50088ff4-65cb-4ffb-bd9a-1c354d2d6073")
    public SmDependency getFragmentDep() {
        if (this.fragmentDep == null) {
        	this.fragmentDep = this.getDependencyDef("Fragment");
        }
        return this.fragmentDep;
    }

    @objid ("280f5219-b6ea-4559-b275-ca206f8c118a")
    public SmDependency getOwnerFragmentDep() {
        if (this.ownerFragmentDep == null) {
        	this.ownerFragmentDep = this.getDependencyDef("OwnerFragment");
        }
        return this.ownerFragmentDep;
    }

    @objid ("6602b9fb-b65a-43b0-a102-69b7d31dc38b")
    private static class InteractionOperandObjectFactory implements ISmObjectFactory {
        @objid ("2938619d-f672-4a62-baa5-78dcba219d90")
        private InteractionOperandSmClass smClass;

        @objid ("72523928-834a-4be4-8736-1bc811432586")
        public InteractionOperandObjectFactory(InteractionOperandSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c322dd2f-db2d-4b4e-a134-252a7d1c49ec")
        @Override
        public ISmObjectData createData() {
            return new InteractionOperandData(this.smClass);
        }

        @objid ("217b6e38-6321-45e9-a2dc-d7d9454607a0")
        @Override
        public SmObjectImpl createImpl() {
            return new InteractionOperandImpl();
        }

    }

    @objid ("cc9934e5-c7f2-49ce-8c3f-8abe5343d31f")
    public static class GuardSmAttribute extends SmAttribute {
        @objid ("6cc31ba7-5c53-4d52-bc51-23e3747da478")
        public Object getValue(ISmObjectData data) {
            return ((InteractionOperandData) data).mGuard;
        }

        @objid ("fedc59b2-9740-4bff-9730-01fc2d91f848")
        public void setValue(ISmObjectData data, Object value) {
            ((InteractionOperandData) data).mGuard = value;
        }

    }

    @objid ("21ec3cbd-6668-4549-856e-5a4cef456587")
    public static class EndLineNumberSmAttribute extends SmAttribute {
        @objid ("66597df2-30d2-4580-a185-58d7f1cee45b")
        public Object getValue(ISmObjectData data) {
            return ((InteractionOperandData) data).mEndLineNumber;
        }

        @objid ("fa60d2c8-c492-48a7-8656-ce5369bba1c0")
        public void setValue(ISmObjectData data, Object value) {
            ((InteractionOperandData) data).mEndLineNumber = value;
        }

    }

    @objid ("0a3158ca-9a56-48c3-9115-1d2f065cbabc")
    public static class FragmentSmDependency extends SmMultipleDependency {
        @objid ("54a6752a-bb5c-4aaa-97a5-6394d53dfb3b")
        private SmDependency symetricDep;

        @objid ("cb3427d9-b50e-4b3f-9b7b-c8e366b63aa0")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InteractionOperandData)data).mFragment != null)? ((InteractionOperandData)data).mFragment:SmMultipleDependency.EMPTY;
        }

        @objid ("56166b59-29e5-4310-9e4f-56d70aecbd85")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InteractionOperandData) data).mFragment = values;

        }

        @objid ("49360c58-56e7-4bac-a315-626547de7ba6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionFragmentSmClass)this.getTarget()).getEnclosingOperandDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6d94f59c-3378-4ab7-a2f1-fd25ba5ba4ad")
    public static class OwnerFragmentSmDependency extends SmSingleDependency {
        @objid ("a00babbe-0d74-4efd-8a3c-3fd2d704e9cb")
        private SmDependency symetricDep;

        @objid ("b920441e-60a1-4387-a266-4f0c4387cfb0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InteractionOperandData) data).mOwnerFragment;
        }

        @objid ("312346a1-c7ae-4ba6-8afb-7fdc95167275")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InteractionOperandData) data).mOwnerFragment = value;
        }

        @objid ("6fe8bc03-6f18-457a-b350-e0202bc6fcec")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CombinedFragmentSmClass)this.getTarget()).getOperandDep();
            }
            return this.symetricDep;

        }

    }

}
