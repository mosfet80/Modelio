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
package org.modelio.metamodel.impl.uml.behavior.communicationModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.OperationSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageSort;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Operation;
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

@objid ("38d34116-8316-413f-93d4-e2b72097ff42")
public class CommunicationMessageSmClass extends UmlModelElementSmClass {
    @objid ("27775262-82ec-4fc6-93bc-2f8f07d6efc2")
    private SmAttribute argumentAtt;

    @objid ("37a6aa33-bec7-488a-a014-701c67b3dd7d")
    private SmAttribute sequenceAtt;

    @objid ("296dd791-d248-428d-873f-f549fc082145")
    private SmAttribute sortOfMessageAtt;

    @objid ("5c551ba5-552c-4456-8a12-9b48b60ddef5")
    private SmDependency realizedInformationFlowDep;

    @objid ("3ca269d7-ab82-4d75-a5bd-df0527702714")
    private SmDependency channelDep;

    @objid ("c4cb75e2-1142-4a26-b564-648f3476074e")
    private SmDependency invertedChannelDep;

    @objid ("81b9ddf9-858b-4769-838c-d7000c8ad770")
    private SmDependency invokedDep;

    @objid ("ccce05cb-10d2-41ff-89e7-89ea477f342a")
    private SmDependency signalSignatureDep;

    @objid ("2d8f066c-e3ad-4fe2-a682-00d7f6898ebf")
    public CommunicationMessageSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("01d1e6a5-0afe-4d4c-a167-b361baacaeb9")
    @Override
    public String getName() {
        return "CommunicationMessage";

    }

    @objid ("6a9162c3-90af-41b7-b25e-df2d61c768e5")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("df91f0f8-cac4-449b-a274-11c1f273f06e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CommunicationMessage.class;

    }

    @objid ("d0f95845-a33e-4668-aa20-2ec9c20a9276")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("204de171-6e5e-44b3-9dbc-a7141811ee5e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("3761d6f7-f279-4df7-9f1b-59b908c4545e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new CommunicationMessageObjectFactory(this));


        // Initialize and register the SmAttribute
        this.argumentAtt = new ArgumentSmAttribute();
        this.argumentAtt.init("Argument", this, String.class );
        registerAttribute(this.argumentAtt);

        this.sequenceAtt = new SequenceSmAttribute();
        this.sequenceAtt.init("Sequence", this, String.class );
        registerAttribute(this.sequenceAtt);

        this.sortOfMessageAtt = new SortOfMessageSmAttribute();
        this.sortOfMessageAtt.init("SortOfMessage", this, MessageSort.class );
        registerAttribute(this.sortOfMessageAtt);


        // Initialize and register the SmDependency
        this.realizedInformationFlowDep = new RealizedInformationFlowSmDependency();
        this.realizedInformationFlowDep.init("RealizedInformationFlow", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.realizedInformationFlowDep);

        this.channelDep = new ChannelSmDependency();
        this.channelDep.init("Channel", this, metamodel.getMClass(CommunicationChannel.MQNAME), 0, 1 );
        registerDependency(this.channelDep);

        this.invertedChannelDep = new InvertedChannelSmDependency();
        this.invertedChannelDep.init("InvertedChannel", this, metamodel.getMClass(CommunicationChannel.MQNAME), 0, 1 );
        registerDependency(this.invertedChannelDep);

        this.invokedDep = new InvokedSmDependency();
        this.invokedDep.init("Invoked", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.invokedDep);

        this.signalSignatureDep = new SignalSignatureSmDependency();
        this.signalSignatureDep.init("SignalSignature", this, metamodel.getMClass(Signal.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.signalSignatureDep);

    }

    @objid ("acdc1ac1-5958-4a4c-b9aa-6344a166f7fa")
    public SmAttribute getArgumentAtt() {
        if (this.argumentAtt == null) {
        	this.argumentAtt = this.getAttributeDef("Argument");
        }
        return this.argumentAtt;
    }

    @objid ("a89941d5-ee11-4053-94df-6d3b24694d5f")
    public SmAttribute getSequenceAtt() {
        if (this.sequenceAtt == null) {
        	this.sequenceAtt = this.getAttributeDef("Sequence");
        }
        return this.sequenceAtt;
    }

    @objid ("26dd3753-e678-4564-b497-d24aa4605bdc")
    public SmAttribute getSortOfMessageAtt() {
        if (this.sortOfMessageAtt == null) {
        	this.sortOfMessageAtt = this.getAttributeDef("SortOfMessage");
        }
        return this.sortOfMessageAtt;
    }

    @objid ("51be65f8-50a6-4ce1-8587-8060bc68244d")
    public SmDependency getRealizedInformationFlowDep() {
        if (this.realizedInformationFlowDep == null) {
        	this.realizedInformationFlowDep = this.getDependencyDef("RealizedInformationFlow");
        }
        return this.realizedInformationFlowDep;
    }

    @objid ("5bdfdefc-7477-48e4-a9e5-386d6eb5ea22")
    public SmDependency getChannelDep() {
        if (this.channelDep == null) {
        	this.channelDep = this.getDependencyDef("Channel");
        }
        return this.channelDep;
    }

    @objid ("2974cb1f-35d7-48a5-afb7-3b35b29f034e")
    public SmDependency getInvertedChannelDep() {
        if (this.invertedChannelDep == null) {
        	this.invertedChannelDep = this.getDependencyDef("InvertedChannel");
        }
        return this.invertedChannelDep;
    }

    @objid ("001975b6-7028-40c7-8e0d-172cfe0ca47b")
    public SmDependency getInvokedDep() {
        if (this.invokedDep == null) {
        	this.invokedDep = this.getDependencyDef("Invoked");
        }
        return this.invokedDep;
    }

    @objid ("9a9874b1-6d39-4d71-81db-eb16fffe7dfb")
    public SmDependency getSignalSignatureDep() {
        if (this.signalSignatureDep == null) {
        	this.signalSignatureDep = this.getDependencyDef("SignalSignature");
        }
        return this.signalSignatureDep;
    }

    @objid ("57f7bece-681e-41bc-b876-0564537dd246")
    private static class CommunicationMessageObjectFactory implements ISmObjectFactory {
        @objid ("b4106e80-bbdb-4c29-9214-9d023ebade02")
        private CommunicationMessageSmClass smClass;

        @objid ("87074f26-2937-4382-bc72-e1b356e5e29a")
        public CommunicationMessageObjectFactory(CommunicationMessageSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6e192c17-9484-4e85-a804-4990e5afcf04")
        @Override
        public ISmObjectData createData() {
            return new CommunicationMessageData(this.smClass);
        }

        @objid ("b8f1969c-3e93-4d6e-9f51-b4cdff5bf887")
        @Override
        public SmObjectImpl createImpl() {
            return new CommunicationMessageImpl();
        }

    }

    @objid ("7a493fae-8188-4599-87c1-5638dabc6e0e")
    public static class ArgumentSmAttribute extends SmAttribute {
        @objid ("9cc85e82-51fa-432c-8561-a23cb67288c0")
        public Object getValue(ISmObjectData data) {
            return ((CommunicationMessageData) data).mArgument;
        }

        @objid ("35ad8ad3-7135-4271-a9b7-46069a413337")
        public void setValue(ISmObjectData data, Object value) {
            ((CommunicationMessageData) data).mArgument = value;
        }

    }

    @objid ("805fda18-72b8-4703-8616-0504f363d254")
    public static class SequenceSmAttribute extends SmAttribute {
        @objid ("4d198009-1967-4668-ad66-5314e5adebdf")
        public Object getValue(ISmObjectData data) {
            return ((CommunicationMessageData) data).mSequence;
        }

        @objid ("c5d50346-85bc-44bb-8039-cc0413769300")
        public void setValue(ISmObjectData data, Object value) {
            ((CommunicationMessageData) data).mSequence = value;
        }

    }

    @objid ("935b7300-9a10-4e44-b0ae-446688441128")
    public static class SortOfMessageSmAttribute extends SmAttribute {
        @objid ("223a8b50-7351-4b2a-b08a-c764c86e8df3")
        public Object getValue(ISmObjectData data) {
            return ((CommunicationMessageData) data).mSortOfMessage;
        }

        @objid ("40ff1d9f-10ab-40f4-90ef-134fb9de7d7d")
        public void setValue(ISmObjectData data, Object value) {
            ((CommunicationMessageData) data).mSortOfMessage = value;
        }

    }

    @objid ("41ad14ba-1fca-4cf5-9d0c-13ee9b774cc7")
    public static class RealizedInformationFlowSmDependency extends SmMultipleDependency {
        @objid ("c4a8807f-cc81-4c00-b9e4-f3357136c4e6")
        private SmDependency symetricDep;

        @objid ("a6871b31-9bd4-4305-a262-fb7bd447596c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CommunicationMessageData)data).mRealizedInformationFlow != null)? ((CommunicationMessageData)data).mRealizedInformationFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("101fa7fb-52f0-42c7-a6e3-920d5df62d07")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CommunicationMessageData) data).mRealizedInformationFlow = values;

        }

        @objid ("7bb39f3b-d26b-4ef0-a893-1254ac76099b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getRealizingCommunicationMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("409b728a-22e6-4d2f-9154-cdef287e381d")
    public static class ChannelSmDependency extends SmSingleDependency {
        @objid ("f126c000-eff8-4ccb-a913-3b526f0ad77e")
        private SmDependency symetricDep;

        @objid ("7fd57619-7f73-4452-b72c-66dc8b24205d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationMessageData) data).mChannel;
        }

        @objid ("88d06391-5633-4d21-8fef-1ea7ea1e2245")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationMessageData) data).mChannel = value;
        }

        @objid ("a3885d55-b224-457a-9e19-bff42e80520b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationChannelSmClass)this.getTarget()).getStartToEndMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e8244301-fd46-4ee8-95a5-de98d148b929")
    public static class InvertedChannelSmDependency extends SmSingleDependency {
        @objid ("760690aa-5dda-4d1a-a794-093871262d5e")
        private SmDependency symetricDep;

        @objid ("2b27b8e1-1749-4a64-9153-eb78af7a2ab6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationMessageData) data).mInvertedChannel;
        }

        @objid ("48c32ca9-5376-4d3b-93ee-841cef185f48")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationMessageData) data).mInvertedChannel = value;
        }

        @objid ("70485307-dfb3-47ea-b4c7-c154c3c4e5ed")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationChannelSmClass)this.getTarget()).getEndToStartMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("fda57ca2-39dc-4474-bafe-6e771c441114")
    public static class InvokedSmDependency extends SmSingleDependency {
        @objid ("f0ebfbc7-174e-4672-bd53-51e4cf7a6346")
        private SmDependency symetricDep;

        @objid ("24c225d5-0f94-45d8-a425-6fba4baf5680")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationMessageData) data).mInvoked;
        }

        @objid ("8ec7be41-bc83-4ee0-9c97-e51ce2451105")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationMessageData) data).mInvoked = value;
        }

        @objid ("2f17820b-09f5-42bc-a133-b03ae174d867")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getCommunicationUsageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a36f5a35-7ca7-435b-a8e0-718e6c553bf0")
    public static class SignalSignatureSmDependency extends SmSingleDependency {
        @objid ("42e095dd-ece1-4453-b18a-597306c21209")
        private SmDependency symetricDep;

        @objid ("472f2c51-03dc-4b98-b887-66934b206b06")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationMessageData) data).mSignalSignature;
        }

        @objid ("b5fa7466-1ff3-4422-a701-0a2e492a71f4")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationMessageData) data).mSignalSignature = value;
        }

        @objid ("ec537d49-e2a5-489c-b25d-2c78b6704a40")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getCommunicationUsageDep();
            }
            return this.symetricDep;

        }

    }

}
