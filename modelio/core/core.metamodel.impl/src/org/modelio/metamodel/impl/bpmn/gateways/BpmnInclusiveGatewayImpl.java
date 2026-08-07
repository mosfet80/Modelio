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
import org.modelio.metamodel.bpmn.gateways.BpmnInclusiveGateway;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0001d7d6-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnInclusiveGatewayImpl extends BpmnGatewayImpl implements BpmnInclusiveGateway {
    @objid ("927bc411-104d-4845-a79e-033c4a5d18cd")
    @Override
    public BpmnSequenceFlow getDefaultFlow() {
        Object obj = getDepVal(((BpmnInclusiveGatewaySmClass)getClassOf()).getDefaultFlowDep());
        return (obj instanceof BpmnSequenceFlow)? (BpmnSequenceFlow)obj : null;
    }

    @objid ("bb25ed9b-9fd5-4f3f-a1e5-c630f3d2ce1d")
    @Override
    public void setDefaultFlow(BpmnSequenceFlow value) {
        appendDepVal(((BpmnInclusiveGatewaySmClass)getClassOf()).getDefaultFlowDep(), (SmObjectImpl)value);
    }

    @objid ("e629c7f7-e28d-4ad8-9c11-5a811f3c2125")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("aefe65ea-dd05-42e6-8e18-3d9ba4faa945")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("ef9d1418-fe20-456b-9a4d-d21815ce88cd")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnInclusiveGateway(this);
    }

}
