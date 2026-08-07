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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.bpmnService.BpmnEndPoint;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.bpmnService.BpmnEndPointSmClass;
import org.modelio.metamodel.impl.bpmn.bpmnService.BpmnInterfaceSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
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

@objid ("5db43980-04e8-4f81-91a7-b9b3b1c4e86e")
public class BpmnParticipantSmClass extends BpmnBaseElementSmClass {
    @objid ("cacaba9d-4986-41b3-a607-1facb41b8a3b")
    private SmAttribute multiplicityMinAtt;

    @objid ("e8783508-e820-447e-bac8-4e888c835ce9")
    private SmAttribute multiplicityMaxAtt;

    @objid ("1bc4c104-8353-403b-8b20-7dfffc480071")
    private SmDependency processDep;

    @objid ("a39e8ebf-a846-4c0d-b8c6-f3d0aa8ef14b")
    private SmDependency containerDep;

    @objid ("d00ab89c-2741-4360-bebb-a2f95aef3435")
    private SmDependency endPointRefsDep;

    @objid ("231c177d-8808-41a0-b01c-af8d1b64cc84")
    private SmDependency interfaceRefsDep;

    @objid ("ed726dc4-cb4f-459d-8781-dfab3d8cac3e")
    public BpmnParticipantSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("34783234-4c10-4e8f-bd09-11b9ca841498")
    @Override
    public String getName() {
        return "BpmnParticipant";

    }

    @objid ("eae12bc8-cf03-4b59-89f4-0cb80773933a")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("8efaff48-44d6-44ec-aedb-be2c306d057c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnParticipant.class;

    }

    @objid ("dd633e0b-08d1-494c-aab9-033d6f3e8708")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ccb93503-72dc-4eea-9bb9-c5476d5675dc")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ba4e2c70-744b-4916-acab-10e8bbc498af")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnParticipantObjectFactory(this));


        // Initialize and register the SmAttribute
        this.multiplicityMinAtt = new MultiplicityMinSmAttribute();
        this.multiplicityMinAtt.init("MultiplicityMin", this, Integer.class );
        registerAttribute(this.multiplicityMinAtt);

        this.multiplicityMaxAtt = new MultiplicityMaxSmAttribute();
        this.multiplicityMaxAtt.init("MultiplicityMax", this, Integer.class );
        registerAttribute(this.multiplicityMaxAtt);


        // Initialize and register the SmDependency
        this.processDep = new ProcessSmDependency();
        this.processDep.init("Process", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.processDep);

        this.containerDep = new ContainerSmDependency();
        this.containerDep.init("Container", this, metamodel.getMClass(BpmnCollaboration.MQNAME), 1, 1 );
        registerDependency(this.containerDep);

        this.endPointRefsDep = new EndPointRefsSmDependency();
        this.endPointRefsDep.init("EndPointRefs", this, metamodel.getMClass(BpmnEndPoint.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.endPointRefsDep);

        this.interfaceRefsDep = new InterfaceRefsSmDependency();
        this.interfaceRefsDep.init("InterfaceRefs", this, metamodel.getMClass(BpmnInterface.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.interfaceRefsDep);

    }

    @objid ("7ccf1ec8-c858-4369-9d18-c634f253fd3b")
    public SmAttribute getMultiplicityMinAtt() {
        if (this.multiplicityMinAtt == null) {
        	this.multiplicityMinAtt = this.getAttributeDef("MultiplicityMin");
        }
        return this.multiplicityMinAtt;
    }

    @objid ("c652cc36-fe39-4ba5-a60f-e0b57597117f")
    public SmAttribute getMultiplicityMaxAtt() {
        if (this.multiplicityMaxAtt == null) {
        	this.multiplicityMaxAtt = this.getAttributeDef("MultiplicityMax");
        }
        return this.multiplicityMaxAtt;
    }

    @objid ("5b9cfbf1-0b42-45f9-85bc-0bf0fee8e449")
    public SmDependency getProcessDep() {
        if (this.processDep == null) {
        	this.processDep = this.getDependencyDef("Process");
        }
        return this.processDep;
    }

    @objid ("55216d34-ce34-4b79-94b2-289eefe09f46")
    public SmDependency getContainerDep() {
        if (this.containerDep == null) {
        	this.containerDep = this.getDependencyDef("Container");
        }
        return this.containerDep;
    }

    @objid ("eff584ba-42d4-4169-8934-25c8b596b085")
    public SmDependency getEndPointRefsDep() {
        if (this.endPointRefsDep == null) {
        	this.endPointRefsDep = this.getDependencyDef("EndPointRefs");
        }
        return this.endPointRefsDep;
    }

    @objid ("d133ad24-2dae-4622-bb8f-c60975c59b9a")
    public SmDependency getInterfaceRefsDep() {
        if (this.interfaceRefsDep == null) {
        	this.interfaceRefsDep = this.getDependencyDef("InterfaceRefs");
        }
        return this.interfaceRefsDep;
    }

    @objid ("96e52739-0fce-4616-b28f-845bdf84b0d8")
    private static class BpmnParticipantObjectFactory implements ISmObjectFactory {
        @objid ("0f10fae9-e677-4a8e-bbbd-6fce1ecd0bb8")
        private BpmnParticipantSmClass smClass;

        @objid ("645da181-98bc-413a-9e06-84e3bd53c2d6")
        public BpmnParticipantObjectFactory(BpmnParticipantSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("83ebe480-72bf-4246-bb09-2aff0c3ba18d")
        @Override
        public ISmObjectData createData() {
            return new BpmnParticipantData(this.smClass);
        }

        @objid ("4b3f954f-5982-4b2f-b459-453e13b51e41")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnParticipantImpl();
        }

    }

    @objid ("82e677ab-8a50-43e1-99dc-c05a62ebbb95")
    public static class MultiplicityMinSmAttribute extends SmAttribute {
        @objid ("c7dc1e33-cedc-40b8-bcff-8dff09f48040")
        public Object getValue(ISmObjectData data) {
            return ((BpmnParticipantData) data).mMultiplicityMin;
        }

        @objid ("f1664dac-3da8-45fe-bb02-922e13492db8")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnParticipantData) data).mMultiplicityMin = value;
        }

    }

    @objid ("e5c4d404-4447-4a93-8333-bf235646006e")
    public static class MultiplicityMaxSmAttribute extends SmAttribute {
        @objid ("a87d37fe-ce6f-4f76-a0fb-2eb6da611b9b")
        public Object getValue(ISmObjectData data) {
            return ((BpmnParticipantData) data).mMultiplicityMax;
        }

        @objid ("917cca12-7f16-485b-895a-4795a091c0d5")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnParticipantData) data).mMultiplicityMax = value;
        }

    }

    @objid ("cb487a13-2330-4bfb-a5a4-b368353d2c91")
    public static class ProcessSmDependency extends SmSingleDependency {
        @objid ("491e45a0-5413-4f9c-9576-3cfccfbfd987")
        private SmDependency symetricDep;

        @objid ("03e8b2c1-b6f8-4827-8679-6052c18b1b7b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnParticipantData) data).mProcess;
        }

        @objid ("7d36edf5-4c85-4ada-9ea8-2652b5019523")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnParticipantData) data).mProcess = value;
        }

        @objid ("f47c5368-db67-409c-a2c9-93caad9d3ca4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getParticipantDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("24aed84f-6a9a-48cf-a23c-4e3248756b6b")
    public static class ContainerSmDependency extends SmSingleDependency {
        @objid ("12bffbe9-394d-41ad-916a-5c73bc35029a")
        private SmDependency symetricDep;

        @objid ("1e5d3a2a-f363-4e4d-8696-60c32e258730")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnParticipantData) data).mContainer;
        }

        @objid ("d43a901d-dc49-4f37-898d-6fc6ebe98ca6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnParticipantData) data).mContainer = value;
        }

        @objid ("e8239edd-0fd3-4128-8ad1-51270c4ddf2e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCollaborationSmClass)this.getTarget()).getParticipantsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d9d75a79-b876-41e4-83d3-ed8abe4d2c46")
    public static class EndPointRefsSmDependency extends SmMultipleDependency {
        @objid ("8af1eded-33f7-4bf6-a4b7-e520e5956b48")
        private SmDependency symetricDep;

        @objid ("ef1fc46e-3964-4f42-b071-0a82324ebc3f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnParticipantData)data).mEndPointRefs != null)? ((BpmnParticipantData)data).mEndPointRefs:SmMultipleDependency.EMPTY;
        }

        @objid ("8ea749cb-e4c9-4505-9e4f-6e5eccb92bfd")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnParticipantData) data).mEndPointRefs = values;

        }

        @objid ("69d6f29e-5930-45dc-b4fa-66afc6a534fa")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnEndPointSmClass)this.getTarget()).getParticipantRefsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e034d505-0ef5-4259-8f8f-f6dbb0be0f6e")
    public static class InterfaceRefsSmDependency extends SmMultipleDependency {
        @objid ("205effc6-e0d5-4d3d-9aff-673ee3cad208")
        private SmDependency symetricDep;

        @objid ("9fe36fa4-f728-4f52-8203-763658f3daef")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnParticipantData)data).mInterfaceRefs != null)? ((BpmnParticipantData)data).mInterfaceRefs:SmMultipleDependency.EMPTY;
        }

        @objid ("a95a689b-63bc-4c54-8543-d5dcc4aec0fe")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnParticipantData) data).mInterfaceRefs = values;

        }

        @objid ("ad8ecea8-2103-4cb8-9e25-3ac216eb5aed")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnInterfaceSmClass)this.getTarget()).getParticipantRefDep();
            }
            return this.symetricDep;

        }

    }

}
