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
package org.modelio.metamodel.impl.bpmn.bpmnService;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.bpmnService.BpmnEndPoint;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnParticipantSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("cda66a80-ee68-4580-a0eb-53130d952aaa")
public class BpmnEndPointSmClass extends BpmnSharedElementSmClass {
    @objid ("24e77548-a484-4604-ad9f-b87ff399d32b")
    private SmDependency participantRefsDep;

    @objid ("560fbee6-c909-407c-8a5f-4e5b5e8beac7")
    public BpmnEndPointSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8a36daf1-37f1-4617-95ee-507925d751e8")
    @Override
    public String getName() {
        return "BpmnEndPoint";

    }

    @objid ("9f3d76a2-9317-4401-9c27-b6f4ac7d8da6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f1810ca9-e424-4983-9d4c-e8733229fc73")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnEndPoint.class;

    }

    @objid ("5b682807-e458-4b8c-925f-84d63ef2086c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("03b49de0-0833-4c12-89f9-6d02332cd287")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("259d5e6f-c344-4941-9cf8-90880447deca")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnSharedElement.MQNAME);
        this.registerFactory(new BpmnEndPointObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.participantRefsDep = new ParticipantRefsSmDependency();
        this.participantRefsDep.init("ParticipantRefs", this, metamodel.getMClass(BpmnParticipant.MQNAME), 0, -1 );
        registerDependency(this.participantRefsDep);

    }

    @objid ("c60c8d54-856e-4328-ad35-b7698c3eedc8")
    public SmDependency getParticipantRefsDep() {
        if (this.participantRefsDep == null) {
        	this.participantRefsDep = this.getDependencyDef("ParticipantRefs");
        }
        return this.participantRefsDep;
    }

    @objid ("8be21d69-8110-467a-ac71-3b08dba110cb")
    private static class BpmnEndPointObjectFactory implements ISmObjectFactory {
        @objid ("6beb1fb3-a6ec-46ff-9add-65bb0d23bc34")
        private BpmnEndPointSmClass smClass;

        @objid ("4a21f322-4b57-4113-aa0e-7b7a0a923a73")
        public BpmnEndPointObjectFactory(BpmnEndPointSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("27aa238f-bdaf-4c09-b7f4-b72d8a4de93b")
        @Override
        public ISmObjectData createData() {
            return new BpmnEndPointData(this.smClass);
        }

        @objid ("a9148faf-200f-4d6a-a6ef-bfd459ea4e49")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnEndPointImpl();
        }

    }

    @objid ("6ca99cb5-deea-40a1-b498-23fac4c28177")
    public static class ParticipantRefsSmDependency extends SmMultipleDependency {
        @objid ("593fa23d-ea06-4102-b950-a8fef9df181e")
        private SmDependency symetricDep;

        @objid ("6d26d219-9dbb-4bb5-b910-f166e63d62e3")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnEndPointData)data).mParticipantRefs != null)? ((BpmnEndPointData)data).mParticipantRefs:SmMultipleDependency.EMPTY;
        }

        @objid ("c62ea111-e885-4ae5-9f0c-d8b0eb2e20b2")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnEndPointData) data).mParticipantRefs = values;

        }

        @objid ("fb1ca531-b023-453b-b3d2-86fbb7e52026")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnParticipantSmClass)this.getTarget()).getEndPointRefsDep();
            }
            return this.symetricDep;

        }

    }

}
