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
import org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGatewayType;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("009813cc-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnEventBasedGatewayImpl extends BpmnGatewayImpl implements BpmnEventBasedGateway {
    @objid ("8cd63a34-c925-41b4-b09c-34fe6bb3b5de")
    @Override
    public boolean isInstanciate() {
        return (Boolean) getAttVal(((BpmnEventBasedGatewaySmClass)getClassOf()).getInstanciateAtt());
    }

    @objid ("3ea4e17a-f972-4579-874d-1846eea758c7")
    @Override
    public void setInstanciate(boolean value) {
        setAttVal(((BpmnEventBasedGatewaySmClass)getClassOf()).getInstanciateAtt(), value);
    }

    @objid ("7c2e34ce-f77e-40e2-9245-992e4641aebc")
    @Override
    public BpmnEventBasedGatewayType getEventGatewayType() {
        return (BpmnEventBasedGatewayType) getAttVal(((BpmnEventBasedGatewaySmClass)getClassOf()).getEventGatewayTypeAtt());
    }

    @objid ("0de9445a-550b-4b1c-8818-b91e9ec0a4a2")
    @Override
    public void setEventGatewayType(BpmnEventBasedGatewayType value) {
        setAttVal(((BpmnEventBasedGatewaySmClass)getClassOf()).getEventGatewayTypeAtt(), value);
    }

    @objid ("716a437b-f6d7-4dd7-9157-e1b93da272ce")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("055733fc-a81a-4546-ab40-fc3ae1646ac6")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("600da5d1-dadc-4cb5-8185-5f1cf9698ad9")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnEventBasedGateway(this);
    }

}
