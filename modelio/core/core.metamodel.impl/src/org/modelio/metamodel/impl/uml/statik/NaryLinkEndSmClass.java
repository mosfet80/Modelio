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
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a91d81a7-d547-490d-82a6-9d566149073e")
public class NaryLinkEndSmClass extends UmlModelElementSmClass {
    @objid ("5a1c029f-109f-4328-801a-4a78550ef879")
    private SmAttribute isOrderedAtt;

    @objid ("29581c87-6f94-48c9-97e1-0fcc6427af6f")
    private SmAttribute isUniqueAtt;

    @objid ("e6ff5a17-85bd-4415-ae98-2792884a1cfc")
    private SmAttribute multiplicityMaxAtt;

    @objid ("8aa37474-8823-4b8f-9d4d-5e582a0c12ef")
    private SmAttribute multiplicityMinAtt;

    @objid ("41cd37fe-745a-4d5a-8c1d-f2d12094e60c")
    private SmDependency sourceDep;

    @objid ("06abe5df-60de-44f8-9ad6-851dfae6db6a")
    private SmDependency naryLinkDep;

    @objid ("8580690f-ebd8-4440-a874-3a9838d69ed9")
    private SmDependency consumerDep;

    @objid ("3561cb5f-04e0-444c-946a-dce84a962299")
    private SmDependency providerDep;

    @objid ("20d2a033-3b44-4300-9d49-0ca267de4bc7")
    public NaryLinkEndSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c739b0f5-a035-4d97-b6b8-3d9d1128ecf5")
    @Override
    public String getName() {
        return "NaryLinkEnd";

    }

    @objid ("a43c748f-d261-4528-9363-fe9ec31eb0d9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("73454e50-ae69-4c1b-8168-ee99f3fd6360")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return NaryLinkEnd.class;

    }

    @objid ("d439300f-06cc-4139-ad80-bd510e125bb6")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f5a643f5-fe99-4fca-b889-c3976ab117db")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e5644c96-bbea-4736-a7a0-60b9a3b993b0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new NaryLinkEndObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isOrderedAtt = new IsOrderedSmAttribute();
        this.isOrderedAtt.init("IsOrdered", this, Boolean.class );
        registerAttribute(this.isOrderedAtt);

        this.isUniqueAtt = new IsUniqueSmAttribute();
        this.isUniqueAtt.init("IsUnique", this, Boolean.class );
        registerAttribute(this.isUniqueAtt);

        this.multiplicityMaxAtt = new MultiplicityMaxSmAttribute();
        this.multiplicityMaxAtt.init("MultiplicityMax", this, String.class );
        registerAttribute(this.multiplicityMaxAtt);

        this.multiplicityMinAtt = new MultiplicityMinSmAttribute();
        this.multiplicityMinAtt.init("MultiplicityMin", this, String.class );
        registerAttribute(this.multiplicityMinAtt);


        // Initialize and register the SmDependency
        this.sourceDep = new SourceSmDependency();
        this.sourceDep.init("Source", this, metamodel.getMClass(Instance.MQNAME), 1, 1 );
        registerDependency(this.sourceDep);

        this.naryLinkDep = new NaryLinkSmDependency();
        this.naryLinkDep.init("NaryLink", this, metamodel.getMClass(NaryLink.MQNAME), 0, 1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.naryLinkDep);

        this.consumerDep = new ConsumerSmDependency();
        this.consumerDep.init("Consumer", this, metamodel.getMClass(RequiredInterface.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.consumerDep);

        this.providerDep = new ProviderSmDependency();
        this.providerDep.init("Provider", this, metamodel.getMClass(ProvidedInterface.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.providerDep);

    }

    @objid ("28686cec-9835-4c41-994e-6f2a75b73016")
    public SmAttribute getIsOrderedAtt() {
        if (this.isOrderedAtt == null) {
        	this.isOrderedAtt = this.getAttributeDef("IsOrdered");
        }
        return this.isOrderedAtt;
    }

    @objid ("a972adca-a911-45d3-84d3-25116fbc6d7d")
    public SmAttribute getIsUniqueAtt() {
        if (this.isUniqueAtt == null) {
        	this.isUniqueAtt = this.getAttributeDef("IsUnique");
        }
        return this.isUniqueAtt;
    }

    @objid ("1d8a4a52-c2ca-4f2c-8a4c-fde4375f7b0d")
    public SmAttribute getMultiplicityMaxAtt() {
        if (this.multiplicityMaxAtt == null) {
        	this.multiplicityMaxAtt = this.getAttributeDef("MultiplicityMax");
        }
        return this.multiplicityMaxAtt;
    }

    @objid ("e629db94-248e-431c-a51d-081c1aeda341")
    public SmAttribute getMultiplicityMinAtt() {
        if (this.multiplicityMinAtt == null) {
        	this.multiplicityMinAtt = this.getAttributeDef("MultiplicityMin");
        }
        return this.multiplicityMinAtt;
    }

    @objid ("a2e378f5-d157-4be5-bb08-af6657bf9647")
    public SmDependency getSourceDep() {
        if (this.sourceDep == null) {
        	this.sourceDep = this.getDependencyDef("Source");
        }
        return this.sourceDep;
    }

    @objid ("82664568-baea-4647-80e7-999c01eedbc2")
    public SmDependency getNaryLinkDep() {
        if (this.naryLinkDep == null) {
        	this.naryLinkDep = this.getDependencyDef("NaryLink");
        }
        return this.naryLinkDep;
    }

    @objid ("af7dd25e-9f18-49ab-aacb-e6ad52f56c57")
    public SmDependency getConsumerDep() {
        if (this.consumerDep == null) {
        	this.consumerDep = this.getDependencyDef("Consumer");
        }
        return this.consumerDep;
    }

    @objid ("0803640b-79be-443e-a6f1-424450ea1322")
    public SmDependency getProviderDep() {
        if (this.providerDep == null) {
        	this.providerDep = this.getDependencyDef("Provider");
        }
        return this.providerDep;
    }

    @objid ("5cecdcf9-803e-4063-b40a-d93d8d90db40")
    private static class NaryLinkEndObjectFactory implements ISmObjectFactory {
        @objid ("f1d3c349-0950-450b-b6c2-26206db3a49d")
        private NaryLinkEndSmClass smClass;

        @objid ("3dd0b03c-e818-4b0d-82eb-2d39e45a9736")
        public NaryLinkEndObjectFactory(NaryLinkEndSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a273e035-362e-4d64-afdd-75ba9270bb5c")
        @Override
        public ISmObjectData createData() {
            return new NaryLinkEndData(this.smClass);
        }

        @objid ("c28d6653-b9d6-4297-9ae4-1e3d7e54247e")
        @Override
        public SmObjectImpl createImpl() {
            return new NaryLinkEndImpl();
        }

    }

    @objid ("e023008b-2c85-4550-8bd7-0d95e7c9784e")
    public static class IsOrderedSmAttribute extends SmAttribute {
        @objid ("02f42838-d6f6-4958-bcae-4578544fdb38")
        public Object getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mIsOrdered;
        }

        @objid ("07736135-832f-49cc-89d1-399a2263e868")
        public void setValue(ISmObjectData data, Object value) {
            ((NaryLinkEndData) data).mIsOrdered = value;
        }

    }

    @objid ("5983ecc6-5889-42d5-ae1b-2532bed2d6ff")
    public static class IsUniqueSmAttribute extends SmAttribute {
        @objid ("8c833d11-1229-428c-84d9-c914df05009b")
        public Object getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mIsUnique;
        }

        @objid ("80fb9b5d-a627-40f5-abd7-5c633a890b6f")
        public void setValue(ISmObjectData data, Object value) {
            ((NaryLinkEndData) data).mIsUnique = value;
        }

    }

    @objid ("996078f2-408a-4ca3-974e-863a898cbee1")
    public static class MultiplicityMaxSmAttribute extends SmAttribute {
        @objid ("f0b59c8f-8bdf-459f-8f5d-f6cad5a58743")
        public Object getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mMultiplicityMax;
        }

        @objid ("af0b3610-9677-4f86-8e2e-9a13479f8cc9")
        public void setValue(ISmObjectData data, Object value) {
            ((NaryLinkEndData) data).mMultiplicityMax = value;
        }

    }

    @objid ("43ad4289-bd48-4028-b9e2-7da2ad5e031c")
    public static class MultiplicityMinSmAttribute extends SmAttribute {
        @objid ("d33c1283-c7cd-46c1-b49f-4de76cdfc943")
        public Object getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mMultiplicityMin;
        }

        @objid ("4b3159c0-f0e8-456d-b772-0cec2afb2ec9")
        public void setValue(ISmObjectData data, Object value) {
            ((NaryLinkEndData) data).mMultiplicityMin = value;
        }

    }

    @objid ("f693c9a5-5e7f-4b89-961d-6a3a548d92b4")
    public static class SourceSmDependency extends SmSingleDependency {
        @objid ("bbff8149-d4d0-44f4-a53b-9d6f0702e344")
        private SmDependency symetricDep;

        @objid ("21da1ce1-0f66-4e05-881f-9893ec873379")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mSource;
        }

        @objid ("1e7ba114-8d81-4260-a015-e03b4319488c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryLinkEndData) data).mSource = value;
        }

        @objid ("82251de1-52cb-474c-9d6b-c7529ec5931a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getOwnedNaryEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2b084fa9-bdbf-4d4c-9477-d5e080d85418")
    public static class NaryLinkSmDependency extends SmSingleDependency {
        @objid ("ec4a03bd-bca2-4b78-a279-3ee5d3ff53a4")
        private SmDependency symetricDep;

        @objid ("2289035a-3b26-49cb-afa9-c4f33f0c3e36")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mNaryLink;
        }

        @objid ("3a6a5318-6078-481d-a950-579c745bc255")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryLinkEndData) data).mNaryLink = value;
        }

        @objid ("5c6b87d4-d7d2-4f95-a9f3-a5bf5ad920e7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkSmClass)this.getTarget()).getNaryLinkEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a0aa2aa6-7219-4e73-878c-db2edf33bb2f")
    public static class ConsumerSmDependency extends SmSingleDependency {
        @objid ("d33a01f5-8545-410a-a783-2631bf2a13ef")
        private SmDependency symetricDep;

        @objid ("4343fbf2-db00-4b63-b2c9-2dad867ab485")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mConsumer;
        }

        @objid ("0c9cb45c-2d97-498f-bc4e-8fb01af824fb")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryLinkEndData) data).mConsumer = value;
        }

        @objid ("604b1ec9-5f62-4752-b9be-e1f46d43b7cc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RequiredInterfaceSmClass)this.getTarget()).getNaryProviderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("01bc6c3f-362d-4558-a279-3e58ac0f80af")
    public static class ProviderSmDependency extends SmSingleDependency {
        @objid ("b4ec5733-1991-4aaa-a1b6-e67de8a2822c")
        private SmDependency symetricDep;

        @objid ("ff57079c-4b8f-4040-884a-af9ce167951b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryLinkEndData) data).mProvider;
        }

        @objid ("09f225c4-4e59-44cc-a06e-51b1ab060e26")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryLinkEndData) data).mProvider = value;
        }

        @objid ("19ce42e8-a64b-478b-8c24-4cc5faf91df1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ProvidedInterfaceSmClass)this.getTarget()).getNaryConsumerDep();
            }
            return this.symetricDep;

        }

    }

}
