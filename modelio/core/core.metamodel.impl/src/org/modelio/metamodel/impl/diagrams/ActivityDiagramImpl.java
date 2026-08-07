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
package org.modelio.metamodel.impl.diagrams;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.diagrams.ActivityDiagram;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0067fa70-c4bf-1fd8-97fe-001ec947cd2a")
public class ActivityDiagramImpl extends BehaviorDiagramImpl implements ActivityDiagram {
    @objid ("fc19777f-2b60-4e47-a9d5-33e91659fb87")
    @Override
    public boolean isIsVertical() {
        return (Boolean) getAttVal(((ActivityDiagramSmClass)getClassOf()).getIsVerticalAtt());
    }

    @objid ("8fe36514-abcb-47c8-bb10-0cd7a5174345")
    @Override
    public void setIsVertical(boolean value) {
        setAttVal(((ActivityDiagramSmClass)getClassOf()).getIsVerticalAtt(), value);
    }

    @objid ("119b3ae3-fe3f-4539-87f5-4a0e5a0a208b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("794c7b31-d1f9-4659-b572-8c185888ca1c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("2dd7faf1-ba3a-41b3-981b-87edf8e42625")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitActivityDiagram(this);
    }

}
