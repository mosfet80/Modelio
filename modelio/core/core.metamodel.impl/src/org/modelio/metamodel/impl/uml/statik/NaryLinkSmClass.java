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
import org.modelio.metamodel.impl.uml.behavior.communicationModel.CommunicationChannelSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
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

@objid ("56a1be66-9aa3-4aee-a7a1-458bda97db4a")
public class NaryLinkSmClass extends UmlModelElementSmClass {
    @objid ("e806a4ac-5f6c-49ce-99b8-a1aaeb006425")
    private SmDependency naryLinkEndDep;

    @objid ("5eabb8f6-cfb2-4bbd-9c00-02970af51c44")
    private SmDependency modelDep;

    @objid ("11292912-ad7f-4e06-88a8-04a98b2e5ad7")
    private SmDependency realizedInformationFlowDep;

    @objid ("b0da499e-63ca-4692-9d5a-e6773b524172")
    private SmDependency sentDep;

    @objid ("8526a1b2-f1cb-4678-a03b-6b749da06937")
    public NaryLinkSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e43ac3a8-cd9a-4842-8fc7-65ef29159232")
    @Override
    public String getName() {
        return "NaryLink";

    }

    @objid ("00c70a4a-b590-4d76-8cca-2819f9cae9e2")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("b6fe235d-2acd-424f-95a4-178189715b4b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return NaryLink.class;

    }

    @objid ("5781b588-ca92-4519-bba2-ce62887cf608")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("64d6cd40-51f7-4947-89d6-821c24b4a6f5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("4febb065-62b5-4eeb-9b00-dad5288cce10")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new NaryLinkObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.naryLinkEndDep = new NaryLinkEndSmDependency();
        this.naryLinkEndDep.init("NaryLinkEnd", this, metamodel.getMClass(NaryLinkEnd.MQNAME), 0, -1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.naryLinkEndDep);

        this.modelDep = new ModelSmDependency();
        this.modelDep.init("Model", this, metamodel.getMClass(NaryAssociation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.modelDep);

        this.realizedInformationFlowDep = new RealizedInformationFlowSmDependency();
        this.realizedInformationFlowDep.init("RealizedInformationFlow", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.realizedInformationFlowDep);

        this.sentDep = new SentSmDependency();
        this.sentDep.init("Sent", this, metamodel.getMClass(CommunicationChannel.MQNAME), 0, -1 );
        registerDependency(this.sentDep);

    }

    @objid ("568e5fe6-3d0f-46d0-9d20-4eabf9d2436a")
    public SmDependency getNaryLinkEndDep() {
        if (this.naryLinkEndDep == null) {
        	this.naryLinkEndDep = this.getDependencyDef("NaryLinkEnd");
        }
        return this.naryLinkEndDep;
    }

    @objid ("19397347-2b6c-4fa9-91bb-31b55113f875")
    public SmDependency getModelDep() {
        if (this.modelDep == null) {
        	this.modelDep = this.getDependencyDef("Model");
        }
        return this.modelDep;
    }

    @objid ("713491dc-2b7b-4d71-93f4-fec4594ff01a")
    public SmDependency getRealizedInformationFlowDep() {
        if (this.realizedInformationFlowDep == null) {
        	this.realizedInformationFlowDep = this.getDependencyDef("RealizedInformationFlow");
        }
        return this.realizedInformationFlowDep;
    }

    @objid ("74c4aa9d-1992-4968-9c60-5024ce6a5539")
    public SmDependency getSentDep() {
        if (this.sentDep == null) {
        	this.sentDep = this.getDependencyDef("Sent");
        }
        return this.sentDep;
    }

    @objid ("daf5d772-4002-46a2-9e0e-903989292865")
    private static class NaryLinkObjectFactory implements ISmObjectFactory {
        @objid ("c115ff41-184f-4173-95cc-a67cadbffbbf")
        private NaryLinkSmClass smClass;

        @objid ("7a66748b-0ff7-4b4c-814f-ef2f4d8aa341")
        public NaryLinkObjectFactory(NaryLinkSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("fafd7366-73b8-4812-b398-ff9cb2b302e8")
        @Override
        public ISmObjectData createData() {
            return new NaryLinkData(this.smClass);
        }

        @objid ("77bde7f4-c12e-4e51-b8d7-761caa020117")
        @Override
        public SmObjectImpl createImpl() {
            return new NaryLinkImpl();
        }

    }

    @objid ("ed377a92-b085-4726-9ee9-5f7082a7b6c3")
    public static class NaryLinkEndSmDependency extends SmMultipleDependency {
        @objid ("835c8ca9-58ff-44e6-8813-9743bfad6a67")
        private SmDependency symetricDep;

        @objid ("ca7a7737-69c7-4009-803f-1403bef98813")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NaryLinkData)data).mNaryLinkEnd != null)? ((NaryLinkData)data).mNaryLinkEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("19cd1533-7163-4817-84d9-3dcc45fad46c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NaryLinkData) data).mNaryLinkEnd = values;

        }

        @objid ("bd377b46-bc4f-4f2c-9b3b-33985b86c1b5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkEndSmClass)this.getTarget()).getNaryLinkDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("02cdd21a-e5eb-496d-af4d-438db75f8b8c")
    public static class ModelSmDependency extends SmSingleDependency {
        @objid ("2be3e86d-18d4-4229-afee-dacd34aa0fde")
        private SmDependency symetricDep;

        @objid ("a13d6bab-5338-4848-a7f6-6781c5c6d7a5")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((NaryLinkData) data).mModel;
        }

        @objid ("19af7016-5cdf-4464-87de-9c85b27663d2")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((NaryLinkData) data).mModel = value;
        }

        @objid ("c46fd004-f480-44be-8b07-bdceb9026b27")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryAssociationSmClass)this.getTarget()).getOccurenceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e2f938e8-923b-43dd-9575-dbfef4105318")
    public static class RealizedInformationFlowSmDependency extends SmMultipleDependency {
        @objid ("4dccd1be-aafb-48c4-96fc-b20ddb6e1972")
        private SmDependency symetricDep;

        @objid ("75d23349-c0e5-4bfc-8514-f11bcbd1e67d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NaryLinkData)data).mRealizedInformationFlow != null)? ((NaryLinkData)data).mRealizedInformationFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("144f5ee0-9e6b-49b1-81a1-3ffed0fd1036")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NaryLinkData) data).mRealizedInformationFlow = values;

        }

        @objid ("fea070f2-90f5-46b6-9c30-8e3ca33fe909")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getRealizingNaryLinkDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("91d3602e-5aae-4cde-8a76-4a1b5c9d3551")
    public static class SentSmDependency extends SmMultipleDependency {
        @objid ("124e0e84-556d-4952-8d20-b8207fc0a3f0")
        private SmDependency symetricDep;

        @objid ("68872903-3f87-41ce-a2a0-b104b40435c1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((NaryLinkData)data).mSent != null)? ((NaryLinkData)data).mSent:SmMultipleDependency.EMPTY;
        }

        @objid ("448db596-fd4d-4d09-88da-4a9467615ac9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((NaryLinkData) data).mSent = values;

        }

        @objid ("3d40015b-cf7c-41b4-b9e0-6c8d34648450")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationChannelSmClass)this.getTarget()).getNaryChannelDep();
            }
            return this.symetricDep;

        }

    }

}
