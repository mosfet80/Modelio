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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.objects.BpmnDataObject;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00037546-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataObjectImpl extends BpmnItemAwareElementImpl implements BpmnDataObject {
    @objid ("90e769e7-d23c-43b9-99b7-11a0ab0fa88b")
    @Override
    public boolean isIsCollection() {
        return (Boolean) getAttVal(((BpmnDataObjectSmClass)getClassOf()).getIsCollectionAtt());
    }

    @objid ("78767f0b-7877-41b8-bee2-c8bbce782595")
    @Override
    public void setIsCollection(boolean value) {
        setAttVal(((BpmnDataObjectSmClass)getClassOf()).getIsCollectionAtt(), value);
    }

    @objid ("bd221803-080a-4c58-9151-b5e8c74c4567")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("61985c9e-df59-4fc1-b078-16bdc7526200")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("8c123193-97cd-419e-921f-00a07659f240")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnDataObject(this);
    }

}
