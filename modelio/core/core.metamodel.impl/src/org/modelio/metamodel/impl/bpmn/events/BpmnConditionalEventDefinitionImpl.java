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
import org.modelio.metamodel.bpmn.events.BpmnConditionalEventDefinition;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("008a1e34-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnConditionalEventDefinitionImpl extends BpmnEventDefinitionImpl implements BpmnConditionalEventDefinition {
    @objid ("2fdc6e83-1387-4dfe-9f07-ca7dd477fff4")
    @Override
    public String getCondition() {
        return (String) getAttVal(((BpmnConditionalEventDefinitionSmClass)getClassOf()).getConditionAtt());
    }

    @objid ("de42fb5d-e586-4b9f-a5ab-d1a6d3f64316")
    @Override
    public void setCondition(String value) {
        setAttVal(((BpmnConditionalEventDefinitionSmClass)getClassOf()).getConditionAtt(), value);
    }

    @objid ("aabf6943-7f02-4173-81d8-d204daf068ee")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("e138c569-52bd-4661-aa2b-bdc57e9a0dc3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("0579fa27-b9f9-4fb0-b18d-bda2f70a9626")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnConditionalEventDefinition(this);
    }

}
