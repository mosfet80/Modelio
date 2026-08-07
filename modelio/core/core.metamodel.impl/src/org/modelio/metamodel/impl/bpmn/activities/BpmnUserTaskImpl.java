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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnUserTask;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0086559c-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnUserTaskImpl extends BpmnTaskImpl implements BpmnUserTask {
    @objid ("62a56e17-79f0-46a6-b100-555475cdaef4")
    @Override
    public String getImplementation() {
        return (String) getAttVal(((BpmnUserTaskSmClass)getClassOf()).getImplementationAtt());
    }

    @objid ("a185df27-bbb7-4bf5-a2b5-c4ea384be743")
    @Override
    public void setImplementation(String value) {
        setAttVal(((BpmnUserTaskSmClass)getClassOf()).getImplementationAtt(), value);
    }

    @objid ("992a1d87-592e-483a-8757-da8a1489367c")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("9fecacc6-29a9-402a-96f1-84bbb6073720")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("33c8d30d-d5f1-49c8-9d96-61f729e4a6ab")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnUserTask(this);
    }

}
