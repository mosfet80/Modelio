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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionNode;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionRegion;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00314c5a-c4bf-1fd8-97fe-001ec947cd2a")
public class ExpansionNodeImpl extends ObjectNodeImpl implements ExpansionNode {
    @objid ("0a86cd81-7e2e-4cdc-aca0-2975e11ccfe9")
    @Override
    public ExpansionRegion getRegionAsOutput() {
        Object obj = getDepVal(((ExpansionNodeSmClass)getClassOf()).getRegionAsOutputDep());
        return (obj instanceof ExpansionRegion)? (ExpansionRegion)obj : null;
    }

    @objid ("d6305c53-5ab0-4e8b-ae9d-b05a401eed9a")
    @Override
    public void setRegionAsOutput(ExpansionRegion value) {
        appendDepVal(((ExpansionNodeSmClass)getClassOf()).getRegionAsOutputDep(), (SmObjectImpl)value);
    }

    @objid ("1d412f95-af8b-4a7b-93f4-ade5b776ba41")
    @Override
    public ExpansionRegion getRegionAsInput() {
        Object obj = getDepVal(((ExpansionNodeSmClass)getClassOf()).getRegionAsInputDep());
        return (obj instanceof ExpansionRegion)? (ExpansionRegion)obj : null;
    }

    @objid ("3677579f-57a0-4fd5-9cf7-cacf83815625")
    @Override
    public void setRegionAsInput(ExpansionRegion value) {
        appendDepVal(((ExpansionNodeSmClass)getClassOf()).getRegionAsInputDep(), (SmObjectImpl)value);
    }

    @objid ("4e03ad99-531c-45e0-9dbc-568ec7d9373b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // RegionAsOutput
        obj = (SmObjectImpl)this.getDepVal(((ExpansionNodeSmClass)getClassOf()).getRegionAsOutputDep());
        if (obj != null)
          return obj;
        // RegionAsInput
        obj = (SmObjectImpl)this.getDepVal(((ExpansionNodeSmClass)getClassOf()).getRegionAsInputDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("84a158c9-c7d0-4f78-bf5d-f9002e856bb3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // RegionAsOutput
        dep = ((ExpansionNodeSmClass)getClassOf()).getRegionAsOutputDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // RegionAsInput
        dep = ((ExpansionNodeSmClass)getClassOf()).getRegionAsInputDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("f430e1c1-0849-4143-9744-bc748a33d4bb")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitExpansionNode(this);
    }

}
