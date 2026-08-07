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
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.gateways.BpmnExclusiveGateway;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00003f2a-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnExclusiveGatewayImpl extends BpmnGatewayImpl implements BpmnExclusiveGateway {
    @objid ("2752a1ce-ebf1-4082-9f7a-4dd60328e1db")
    @Override
    public BpmnSequenceFlow getDefaultFlow() {
        Object obj = getDepVal(((BpmnExclusiveGatewaySmClass)getClassOf()).getDefaultFlowDep());
        return (obj instanceof BpmnSequenceFlow)? (BpmnSequenceFlow)obj : null;
    }

    @objid ("01ec6174-854c-4951-81e0-f94c26627491")
    @Override
    public void setDefaultFlow(BpmnSequenceFlow value) {
        appendDepVal(((BpmnExclusiveGatewaySmClass)getClassOf()).getDefaultFlowDep(), (SmObjectImpl)value);
    }

    @objid ("5ae53e60-a1b6-47ba-a0bf-ff660f73137f")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("c1536390-59ed-4262-ab59-e0fba241b200")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("987df92d-c0f9-4fa2-8975-26e2eef4abee")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnExclusiveGateway(this);
    }

}
