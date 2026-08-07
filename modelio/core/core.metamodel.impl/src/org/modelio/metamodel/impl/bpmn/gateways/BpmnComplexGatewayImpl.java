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
import org.modelio.metamodel.bpmn.gateways.BpmnComplexGateway;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00976e68-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnComplexGatewayImpl extends BpmnGatewayImpl implements BpmnComplexGateway {
    @objid ("5098f0be-17c0-479c-b575-75894e1982a5")
    @Override
    public String getActivationExpression() {
        return (String) getAttVal(((BpmnComplexGatewaySmClass)getClassOf()).getActivationExpressionAtt());
    }

    @objid ("c1a104bf-7046-4776-8048-9842f2156917")
    @Override
    public void setActivationExpression(String value) {
        setAttVal(((BpmnComplexGatewaySmClass)getClassOf()).getActivationExpressionAtt(), value);
    }

    @objid ("11b3bbf6-d040-4aef-a7a4-e2cdf3a3d19a")
    @Override
    public BpmnSequenceFlow getDefaultFlow() {
        Object obj = getDepVal(((BpmnComplexGatewaySmClass)getClassOf()).getDefaultFlowDep());
        return (obj instanceof BpmnSequenceFlow)? (BpmnSequenceFlow)obj : null;
    }

    @objid ("eebd1610-fd36-4cae-a1e5-6ef5a88cf186")
    @Override
    public void setDefaultFlow(BpmnSequenceFlow value) {
        appendDepVal(((BpmnComplexGatewaySmClass)getClassOf()).getDefaultFlowDep(), (SmObjectImpl)value);
    }

    @objid ("9ea1c2f7-3463-47c2-82e8-999ce8a8f32b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("71221a35-896c-4068-b2bb-4b77ed48db15")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("02580c9b-9a5a-4b11-a170-a5e6a88f6216")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnComplexGateway(this);
    }

}
