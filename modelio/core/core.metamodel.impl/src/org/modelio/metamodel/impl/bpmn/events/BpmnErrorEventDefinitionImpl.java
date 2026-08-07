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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.events.BpmnErrorEventDefinition;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("008b71e4-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnErrorEventDefinitionImpl extends BpmnEventDefinitionImpl implements BpmnErrorEventDefinition {
    @objid ("810f3ac4-1651-419d-bf77-f3169ad72425")
    @Override
    public String getErrorCode() {
        return (String) getAttVal(((BpmnErrorEventDefinitionSmClass)getClassOf()).getErrorCodeAtt());
    }

    @objid ("3ce02940-7493-43a8-bb3a-2761b5364e37")
    @Override
    public void setErrorCode(String value) {
        setAttVal(((BpmnErrorEventDefinitionSmClass)getClassOf()).getErrorCodeAtt(), value);
    }

    @objid ("8d41a0e4-2ede-4414-8cbc-6dd3ed19e884")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("5d8f7032-e34e-418b-85e7-88c5af49a3c0")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("59b53336-4828-49ce-b5de-841a03a6b406")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnErrorEventDefinition(this);
    }

}
