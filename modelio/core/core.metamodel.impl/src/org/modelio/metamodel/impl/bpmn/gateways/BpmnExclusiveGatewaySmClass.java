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
package org.modelio.metamodel.impl.bpmn.gateways;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.gateways.BpmnExclusiveGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnGateway;
import org.modelio.metamodel.impl.bpmn.flows.BpmnSequenceFlowSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("74ebbbc4-d063-450d-bcd0-a747eb364dff")
public class BpmnExclusiveGatewaySmClass extends BpmnGatewaySmClass {
    @objid ("247e7fb0-5902-4186-a50f-ab00625aa958")
    private SmDependency defaultFlowDep;

    @objid ("94f059fd-57c2-48e1-a97b-f2d1d24c01e1")
    public BpmnExclusiveGatewaySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c7a99426-2a98-480c-b5c5-f842132e5329")
    @Override
    public String getName() {
        return "BpmnExclusiveGateway";

    }

    @objid ("91a926be-f1d2-4159-818e-1c22f2771add")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("71a8f5f9-89d2-40e7-8c1d-676a5ef8be25")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnExclusiveGateway.class;

    }

    @objid ("b0fdb737-e024-4694-89d1-d2bde7177c4e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6e5bdfb1-42f7-4546-9d47-1531f1b1b440")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d93a88e9-e49b-437c-a20a-9e04cf0fcb2b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnGateway.MQNAME);
        this.registerFactory(new BpmnExclusiveGatewayObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.defaultFlowDep = new DefaultFlowSmDependency();
        this.defaultFlowDep.init("DefaultFlow", this, metamodel.getMClass(BpmnSequenceFlow.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.defaultFlowDep);

    }

    @objid ("01ea2ab2-0584-40c9-b380-0704b55439cc")
    public SmDependency getDefaultFlowDep() {
        if (this.defaultFlowDep == null) {
        	this.defaultFlowDep = this.getDependencyDef("DefaultFlow");
        }
        return this.defaultFlowDep;
    }

    @objid ("e6a587e3-8edf-4642-8015-e2f247f7992f")
    private static class BpmnExclusiveGatewayObjectFactory implements ISmObjectFactory {
        @objid ("d78792ff-80d6-46fb-abc7-4b75dfd53f11")
        private BpmnExclusiveGatewaySmClass smClass;

        @objid ("4a1f2d0a-3822-472a-950e-ad8e35cdd287")
        public BpmnExclusiveGatewayObjectFactory(BpmnExclusiveGatewaySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("0e8d45cf-530a-44c8-acbd-d3b6f5b64473")
        @Override
        public ISmObjectData createData() {
            return new BpmnExclusiveGatewayData(this.smClass);
        }

        @objid ("b671a227-66dc-42b5-933c-29f53ffc8729")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnExclusiveGatewayImpl();
        }

    }

    @objid ("c5cd96c6-3d50-4b4e-9b6b-acfe846d724b")
    public static class DefaultFlowSmDependency extends SmSingleDependency {
        @objid ("e84cd4a2-519f-4169-80ec-34fd6d34f23c")
        private SmDependency symetricDep;

        @objid ("625e66fd-363c-4301-b88a-57716c3d5ce8")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnExclusiveGatewayData) data).mDefaultFlow;
        }

        @objid ("953da432-4bd6-4f14-90c9-327c9dead2c9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnExclusiveGatewayData) data).mDefaultFlow = value;
        }

        @objid ("78eb201d-2e57-47c4-a411-c29adcfac763")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowSmClass)this.getTarget()).getDefaultOfExclusiveDep();
            }
            return this.symetricDep;

        }

    }

}
