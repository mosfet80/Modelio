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
import org.modelio.metamodel.impl.uml.behavior.activityModel.PinSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorParameterSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.commonBehaviors.ParameterEffectKind;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.uml.statik.PassingMode;
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

@objid ("6b9384d1-347f-4630-884c-d89cf3f86843")
public class ParameterSmClass extends UmlModelElementSmClass {
    @objid ("fe2c2cf2-d124-4f33-8296-1169ee133ab5")
    private SmAttribute parameterPassingAtt;

    @objid ("bfcf010d-f6eb-4970-bb02-36d7abba1e9e")
    private SmAttribute multiplicityMinAtt;

    @objid ("4d0eec5f-bf6d-420f-89cd-f98458d96298")
    private SmAttribute multiplicityMaxAtt;

    @objid ("262ec152-77ba-415f-9907-0520c17ac04e")
    private SmAttribute typeConstraintAtt;

    @objid ("1de80daa-c8a0-4e93-aea6-01571d07ee69")
    private SmAttribute defaultValueAtt;

    @objid ("b261a827-b3ff-40ba-951f-aa3f4b3b57ef")
    private SmAttribute isOrderedAtt;

    @objid ("dcfa7168-51dc-47cd-9bb7-5bb373b98bf6")
    private SmAttribute isUniqueAtt;

    @objid ("3ca1659a-d5ba-44c5-a6b3-72d4cb2da7c4")
    private SmAttribute isExceptionAtt;

    @objid ("4d89448d-cdcb-4ab8-bbea-4413da3f4474")
    private SmAttribute isStreamAtt;

    @objid ("edf3310d-71ce-41aa-a02f-d18d49a474e8")
    private SmAttribute effectAtt;

    @objid ("0fd6cf07-1f63-40ed-acf7-cfb574b07b33")
    private SmDependency typeDep;

    @objid ("630d7fcf-4b22-4f0b-9f0c-b32ed28d7619")
    private SmDependency composedDep;

    @objid ("60ea7de9-bb3b-4793-b0d0-87414aa36105")
    private SmDependency matchingDep;

    @objid ("fde87b26-d0a4-419d-b9b3-0552a0221fae")
    private SmDependency sRepresentationDep;

    @objid ("7c1e544b-24eb-458a-b99d-4bd76a6bbadd")
    private SmDependency returnedDep;

    @objid ("ebe121b9-528b-47af-8f95-a111fac11fb7")
    private SmDependency behaviorParamDep;

    @objid ("8da60906-094f-40bb-a50c-41ec02137141")
    public ParameterSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6531b689-ecb5-4e58-8566-cb07c54a426e")
    @Override
    public String getName() {
        return "Parameter";

    }

    @objid ("2918b2bd-a9bc-4fb2-ad10-052d2c66d270")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("a99c3357-537d-4602-8c6c-9cc714b2fc86")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Parameter.class;

    }

    @objid ("933ca8e1-2021-4d8e-b7b1-bcedfd2573e7")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("bcf50c0a-b580-4989-b422-d9bcd6484af6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2522751c-4710-488a-b76e-65cf366f7eb4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ParameterObjectFactory(this));


        // Initialize and register the SmAttribute
        this.parameterPassingAtt = new ParameterPassingSmAttribute();
        this.parameterPassingAtt.init("ParameterPassing", this, PassingMode.class );
        registerAttribute(this.parameterPassingAtt);

        this.multiplicityMinAtt = new MultiplicityMinSmAttribute();
        this.multiplicityMinAtt.init("MultiplicityMin", this, String.class );
        registerAttribute(this.multiplicityMinAtt);

        this.multiplicityMaxAtt = new MultiplicityMaxSmAttribute();
        this.multiplicityMaxAtt.init("MultiplicityMax", this, String.class );
        registerAttribute(this.multiplicityMaxAtt);

        this.typeConstraintAtt = new TypeConstraintSmAttribute();
        this.typeConstraintAtt.init("TypeConstraint", this, String.class );
        registerAttribute(this.typeConstraintAtt);

        this.defaultValueAtt = new DefaultValueSmAttribute();
        this.defaultValueAtt.init("DefaultValue", this, String.class );
        registerAttribute(this.defaultValueAtt);

        this.isOrderedAtt = new IsOrderedSmAttribute();
        this.isOrderedAtt.init("IsOrdered", this, Boolean.class );
        registerAttribute(this.isOrderedAtt);

        this.isUniqueAtt = new IsUniqueSmAttribute();
        this.isUniqueAtt.init("IsUnique", this, Boolean.class );
        registerAttribute(this.isUniqueAtt);

        this.isExceptionAtt = new IsExceptionSmAttribute();
        this.isExceptionAtt.init("IsException", this, Boolean.class );
        registerAttribute(this.isExceptionAtt);

        this.isStreamAtt = new IsStreamSmAttribute();
        this.isStreamAtt.init("IsStream", this, Boolean.class );
        registerAttribute(this.isStreamAtt);

        this.effectAtt = new EffectSmAttribute();
        this.effectAtt.init("Effect", this, ParameterEffectKind.class );
        registerAttribute(this.effectAtt);


        // Initialize and register the SmDependency
        this.typeDep = new TypeSmDependency();
        this.typeDep.init("Type", this, metamodel.getMClass(GeneralClass.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.typeDep);

        this.composedDep = new ComposedSmDependency();
        this.composedDep.init("Composed", this, metamodel.getMClass(Operation.MQNAME), 0, 1 );
        registerDependency(this.composedDep);

        this.matchingDep = new MatchingSmDependency();
        this.matchingDep.init("Matching", this, metamodel.getMClass(Pin.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.matchingDep);

        this.sRepresentationDep = new SRepresentationSmDependency();
        this.sRepresentationDep.init("SRepresentation", this, metamodel.getMClass(Signal.MQNAME), 0, -1 );
        registerDependency(this.sRepresentationDep);

        this.returnedDep = new ReturnedSmDependency();
        this.returnedDep.init("Returned", this, metamodel.getMClass(Operation.MQNAME), 0, 1 );
        registerDependency(this.returnedDep);

        this.behaviorParamDep = new BehaviorParamSmDependency();
        this.behaviorParamDep.init("BehaviorParam", this, metamodel.getMClass(BehaviorParameter.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.behaviorParamDep);

    }

    @objid ("a94baa24-cb8f-42be-8409-9427543b5247")
    public SmAttribute getParameterPassingAtt() {
        if (this.parameterPassingAtt == null) {
        	this.parameterPassingAtt = this.getAttributeDef("ParameterPassing");
        }
        return this.parameterPassingAtt;
    }

    @objid ("d4c95807-7e32-417c-8cfd-7d8b2bccfbef")
    public SmAttribute getMultiplicityMinAtt() {
        if (this.multiplicityMinAtt == null) {
        	this.multiplicityMinAtt = this.getAttributeDef("MultiplicityMin");
        }
        return this.multiplicityMinAtt;
    }

    @objid ("d86fd458-03e5-4dc1-a8bf-486ee27837af")
    public SmAttribute getMultiplicityMaxAtt() {
        if (this.multiplicityMaxAtt == null) {
        	this.multiplicityMaxAtt = this.getAttributeDef("MultiplicityMax");
        }
        return this.multiplicityMaxAtt;
    }

    @objid ("d38f1468-b825-4782-90d9-25ea1dbfe2fe")
    public SmAttribute getTypeConstraintAtt() {
        if (this.typeConstraintAtt == null) {
        	this.typeConstraintAtt = this.getAttributeDef("TypeConstraint");
        }
        return this.typeConstraintAtt;
    }

    @objid ("c75c2f2b-6a76-4c50-850d-6153d04eb62b")
    public SmAttribute getDefaultValueAtt() {
        if (this.defaultValueAtt == null) {
        	this.defaultValueAtt = this.getAttributeDef("DefaultValue");
        }
        return this.defaultValueAtt;
    }

    @objid ("676c9e32-40b5-477e-8cba-84afd81e0360")
    public SmAttribute getIsOrderedAtt() {
        if (this.isOrderedAtt == null) {
        	this.isOrderedAtt = this.getAttributeDef("IsOrdered");
        }
        return this.isOrderedAtt;
    }

    @objid ("653bed5c-9d9d-455d-a67a-160a9c94ec91")
    public SmAttribute getIsUniqueAtt() {
        if (this.isUniqueAtt == null) {
        	this.isUniqueAtt = this.getAttributeDef("IsUnique");
        }
        return this.isUniqueAtt;
    }

    @objid ("19edc1f4-b7dd-4ae2-8416-66968b94ef8f")
    public SmAttribute getIsExceptionAtt() {
        if (this.isExceptionAtt == null) {
        	this.isExceptionAtt = this.getAttributeDef("IsException");
        }
        return this.isExceptionAtt;
    }

    @objid ("1fa2b88f-b42c-48c5-83dd-63db4f75a93a")
    public SmAttribute getIsStreamAtt() {
        if (this.isStreamAtt == null) {
        	this.isStreamAtt = this.getAttributeDef("IsStream");
        }
        return this.isStreamAtt;
    }

    @objid ("fac555b6-6979-4cbb-a43c-d0c83a4637af")
    public SmAttribute getEffectAtt() {
        if (this.effectAtt == null) {
        	this.effectAtt = this.getAttributeDef("Effect");
        }
        return this.effectAtt;
    }

    @objid ("02410106-0048-41ba-b6f5-e65d42dffb18")
    public SmDependency getTypeDep() {
        if (this.typeDep == null) {
        	this.typeDep = this.getDependencyDef("Type");
        }
        return this.typeDep;
    }

    @objid ("d84e0213-6cd7-4486-bdf5-fd17928eec4f")
    public SmDependency getComposedDep() {
        if (this.composedDep == null) {
        	this.composedDep = this.getDependencyDef("Composed");
        }
        return this.composedDep;
    }

    @objid ("54047a23-0cb5-42e0-9fc1-fd31da0cb916")
    public SmDependency getMatchingDep() {
        if (this.matchingDep == null) {
        	this.matchingDep = this.getDependencyDef("Matching");
        }
        return this.matchingDep;
    }

    @objid ("3736858b-02af-4320-b321-bd34e31eb8ad")
    public SmDependency getSRepresentationDep() {
        if (this.sRepresentationDep == null) {
        	this.sRepresentationDep = this.getDependencyDef("SRepresentation");
        }
        return this.sRepresentationDep;
    }

    @objid ("30db6a4b-9394-4e55-9a3a-e3304ba919d6")
    public SmDependency getReturnedDep() {
        if (this.returnedDep == null) {
        	this.returnedDep = this.getDependencyDef("Returned");
        }
        return this.returnedDep;
    }

    @objid ("a4a40615-e34f-4c4c-88c2-da3035031908")
    public SmDependency getBehaviorParamDep() {
        if (this.behaviorParamDep == null) {
        	this.behaviorParamDep = this.getDependencyDef("BehaviorParam");
        }
        return this.behaviorParamDep;
    }

    @objid ("4f764e34-2f72-4218-981e-766619279c27")
    private static class ParameterObjectFactory implements ISmObjectFactory {
        @objid ("f1dac136-684a-4060-9cf4-0d1fce8af830")
        private ParameterSmClass smClass;

        @objid ("55831147-84ce-49eb-b792-87759596442d")
        public ParameterObjectFactory(ParameterSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f49be230-9f40-4191-be8a-6bec284eab1d")
        @Override
        public ISmObjectData createData() {
            return new ParameterData(this.smClass);
        }

        @objid ("650b8a53-6550-4253-a286-e5d05a32f68b")
        @Override
        public SmObjectImpl createImpl() {
            return new ParameterImpl();
        }

    }

    @objid ("226fb67c-925c-4e6c-a409-0c8129e7db77")
    public static class ParameterPassingSmAttribute extends SmAttribute {
        @objid ("82082863-8489-4444-8ed6-7fe44154f886")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mParameterPassing;
        }

        @objid ("9850386c-1af5-4c0d-8f03-7a6cdb0c366e")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mParameterPassing = value;
        }

    }

    @objid ("195eec08-b8e2-4640-ad72-91ab20e6416d")
    public static class MultiplicityMinSmAttribute extends SmAttribute {
        @objid ("0d786f29-436e-4efc-9313-462a033d9ae1")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mMultiplicityMin;
        }

        @objid ("2bd91f6c-e017-4534-8a65-0bd84bba5b0e")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mMultiplicityMin = value;
        }

    }

    @objid ("01240101-26dc-44b4-926c-d54df911aa2b")
    public static class MultiplicityMaxSmAttribute extends SmAttribute {
        @objid ("919b9631-191c-4627-a668-cc5dc32e28c2")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mMultiplicityMax;
        }

        @objid ("a8817ab8-e072-49cc-a815-a6357f060f0d")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mMultiplicityMax = value;
        }

    }

    @objid ("b75a7fb1-02f7-4d0d-8bab-b0cc6a0c1b3c")
    public static class TypeConstraintSmAttribute extends SmAttribute {
        @objid ("c013f4f2-3752-4b61-ab8e-e26bcac61da8")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mTypeConstraint;
        }

        @objid ("167d4b16-7e69-414a-9f63-93dbb7d4bf60")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mTypeConstraint = value;
        }

    }

    @objid ("d2432244-d40a-401d-af04-f774c18c14c7")
    public static class DefaultValueSmAttribute extends SmAttribute {
        @objid ("e480552d-76af-43b2-89bb-65390d296076")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mDefaultValue;
        }

        @objid ("7b6aad97-6e8e-49a2-81f0-70e3b138f014")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mDefaultValue = value;
        }

    }

    @objid ("5033defb-4c46-4a68-bfd9-eb517d881103")
    public static class IsOrderedSmAttribute extends SmAttribute {
        @objid ("40a467f0-de57-4584-a7e7-04649ac33bbe")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mIsOrdered;
        }

        @objid ("67966f4a-6967-4b82-a05b-52104bebb3ea")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mIsOrdered = value;
        }

    }

    @objid ("0224cef2-ca3b-4f44-aed2-ff5b012eb417")
    public static class IsUniqueSmAttribute extends SmAttribute {
        @objid ("e87f7eb3-c312-456e-9718-da59c354a2f6")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mIsUnique;
        }

        @objid ("f73aa3b7-b87f-41bf-a4ef-3797d1383416")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mIsUnique = value;
        }

    }

    @objid ("15b580d6-8ccc-47b9-990b-4cec266fbffe")
    public static class IsExceptionSmAttribute extends SmAttribute {
        @objid ("3238ce38-6062-4d4e-9648-386377ab4cb1")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mIsException;
        }

        @objid ("b412df80-5aef-4949-9eff-584a66be9b6e")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mIsException = value;
        }

    }

    @objid ("7d96d865-ce2d-435a-8c78-5143d853cddb")
    public static class IsStreamSmAttribute extends SmAttribute {
        @objid ("d57c3705-cc42-498e-890a-c81e02cf1c6b")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mIsStream;
        }

        @objid ("718994fb-c904-4983-8425-18a2d3be4223")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mIsStream = value;
        }

    }

    @objid ("bd4f1b2d-fde0-4432-afc3-38b9a46a0d7f")
    public static class EffectSmAttribute extends SmAttribute {
        @objid ("df7bde7b-922d-4106-8f24-b949e431643a")
        public Object getValue(ISmObjectData data) {
            return ((ParameterData) data).mEffect;
        }

        @objid ("44471b93-2614-4ad6-8af6-a2a56d616ce1")
        public void setValue(ISmObjectData data, Object value) {
            ((ParameterData) data).mEffect = value;
        }

    }

    @objid ("b5842096-45be-4169-9c26-d8fe1ec5ac3a")
    public static class TypeSmDependency extends SmSingleDependency {
        @objid ("7c5c8432-562b-4059-a3e7-a838ff6a81fc")
        private SmDependency symetricDep;

        @objid ("4e8a92bf-67a1-4ee7-ad5e-391462a837a2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ParameterData) data).mType;
        }

        @objid ("6ba314b4-2304-403c-8239-0c1b0b0a7b93")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ParameterData) data).mType = value;
        }

        @objid ("322af571-3b6c-41a4-930a-2da778449fbe")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralClassSmClass)this.getTarget()).getOccurenceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("10d3bf71-4912-49d3-8186-770fef43b0a6")
    public static class ComposedSmDependency extends SmSingleDependency {
        @objid ("c39cdd24-0420-41ef-ae7d-9e104abaf717")
        private SmDependency symetricDep;

        @objid ("73c4c8a2-afec-4c31-bf35-a6e6019817a8")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ParameterData) data).mComposed;
        }

        @objid ("1de326a3-5369-4154-bc19-0ae42b537d99")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ParameterData) data).mComposed = value;
        }

        @objid ("6e139533-852a-4f1e-8d03-a723d2515f1e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getIODep();
            }
            return this.symetricDep;

        }

    }

    @objid ("85d00038-2c30-47a7-80e1-9b2488ede377")
    public static class MatchingSmDependency extends SmMultipleDependency {
        @objid ("69a9698e-a7ec-4651-ba5a-4de1c0c1c4d5")
        private SmDependency symetricDep;

        @objid ("0d994d7a-107b-45e9-ad94-25cb2f608671")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ParameterData)data).mMatching != null)? ((ParameterData)data).mMatching:SmMultipleDependency.EMPTY;
        }

        @objid ("9fe68591-a7c6-4a19-a1ab-6440e429b226")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ParameterData) data).mMatching = values;

        }

        @objid ("a365f3db-7cca-4db2-858f-ce5340e8de5d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PinSmClass)this.getTarget()).getMatchedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c286f89d-b450-4870-a970-02c281221d79")
    public static class SRepresentationSmDependency extends SmMultipleDependency {
        @objid ("0816c845-34de-4e8e-88e7-4625b172457f")
        private SmDependency symetricDep;

        @objid ("bebe5aba-c03e-4f1f-93f7-6065ffd9023f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ParameterData)data).mSRepresentation != null)? ((ParameterData)data).mSRepresentation:SmMultipleDependency.EMPTY;
        }

        @objid ("d9ad9699-b9f1-4c14-904c-a347e39f041b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ParameterData) data).mSRepresentation = values;

        }

        @objid ("41740495-431c-4d22-b92e-8db92417ed63")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getPBaseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6bc0f096-22c2-4710-936f-128a5a697503")
    public static class ReturnedSmDependency extends SmSingleDependency {
        @objid ("365b90d6-21ef-4ef0-93b6-ade72d16e257")
        private SmDependency symetricDep;

        @objid ("e93f1f24-1b7f-469b-9143-6264ff33376d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ParameterData) data).mReturned;
        }

        @objid ("b22b98df-41ee-41b2-a0b9-b6000011037f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ParameterData) data).mReturned = value;
        }

        @objid ("1a9216e1-f6aa-475b-aac9-4ac24929d61a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getReturnDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0325a71f-914e-46c6-bd80-aa7fd2c222c9")
    public static class BehaviorParamSmDependency extends SmMultipleDependency {
        @objid ("9f7ec0b9-5ce1-46e1-8dc1-eea44f74ac62")
        private SmDependency symetricDep;

        @objid ("0ee2982b-c57c-4a62-b765-b55737330cfe")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ParameterData)data).mBehaviorParam != null)? ((ParameterData)data).mBehaviorParam:SmMultipleDependency.EMPTY;
        }

        @objid ("338ded0b-a479-4b8a-a2fc-abac544d0b52")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ParameterData) data).mBehaviorParam = values;

        }

        @objid ("2a56824e-bbfa-4b26-be1f-73d060c200e4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorParameterSmClass)this.getTarget()).getMappedDep();
            }
            return this.symetricDep;

        }

    }

}
