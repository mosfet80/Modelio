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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociationDirection;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00775b3c-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnAssociationImpl extends BpmnArtifactImpl implements BpmnAssociation {
    @objid ("91040f5c-183a-49b0-9a87-56e702570241")
    @Override
    public BpmnAssociationDirection getAssociationDirection() {
        return (BpmnAssociationDirection) getAttVal(((BpmnAssociationSmClass)getClassOf()).getAssociationDirectionAtt());
    }

    @objid ("4feca8be-e107-4a1a-bf0e-d9e4ae1c3b8c")
    @Override
    public void setAssociationDirection(BpmnAssociationDirection value) {
        setAttVal(((BpmnAssociationSmClass)getClassOf()).getAssociationDirectionAtt(), value);
    }

    @objid ("cb931b88-93b4-4529-b1f0-f734bba7aebe")
    @Override
    public BpmnBaseElement getTargetRef() {
        Object obj = getDepVal(((BpmnAssociationSmClass)getClassOf()).getTargetRefDep());
        return (obj instanceof BpmnBaseElement)? (BpmnBaseElement)obj : null;
    }

    @objid ("afc53e1f-4961-4363-8d68-73d851c4c4b4")
    @Override
    public void setTargetRef(BpmnBaseElement value) {
        appendDepVal(((BpmnAssociationSmClass)getClassOf()).getTargetRefDep(), (SmObjectImpl)value);
    }

    @objid ("9c1e2b11-2425-4f44-942f-d7f1bf101859")
    @Override
    public BpmnBaseElement getSourceRef() {
        Object obj = getDepVal(((BpmnAssociationSmClass)getClassOf()).getSourceRefDep());
        return (obj instanceof BpmnBaseElement)? (BpmnBaseElement)obj : null;
    }

    @objid ("764d0947-83f9-46cc-a843-aa2e8ada4bb7")
    @Override
    public void setSourceRef(BpmnBaseElement value) {
        appendDepVal(((BpmnAssociationSmClass)getClassOf()).getSourceRefDep(), (SmObjectImpl)value);
    }

    @objid ("fc8fe3e5-1045-4d8f-ad19-16c67020fcdf")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("a61dfb31-880e-450e-86b6-398d15269693")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("8d9c66ea-9b5a-46c6-8e68-2f69d040e07c")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnAssociation(this);
    }

}
