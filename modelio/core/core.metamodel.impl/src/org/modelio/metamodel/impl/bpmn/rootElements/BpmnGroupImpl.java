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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnGroup;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007a5ba2-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnGroupImpl extends BpmnArtifactImpl implements BpmnGroup {
    @objid ("07ffdb62-46ba-4585-a8ac-effe0f94c6c2")
    @Override
    public String getCategory() {
        return (String) getAttVal(((BpmnGroupSmClass)getClassOf()).getCategoryAtt());
    }

    @objid ("3b10346d-68d3-43fc-b18a-48076116b8fe")
    @Override
    public void setCategory(String value) {
        setAttVal(((BpmnGroupSmClass)getClassOf()).getCategoryAtt(), value);
    }

    @objid ("72fad1f1-29e2-4e9e-a3e0-bfd11ddeed3c")
    @Override
    public EList<BpmnFlowElement> getCategorized() {
        return new SmList<>(this, ((BpmnGroupSmClass)getClassOf()).getCategorizedDep());
    }

    @objid ("e46e7086-d574-4060-9bd5-b004c105e7ac")
    @Override
    public <T extends BpmnFlowElement> List<T> getCategorized(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnFlowElement element : getCategorized()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("59968158-4b6b-47e4-94de-646efecd28c0")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("bb48b186-4b11-4af5-b66e-22e79dd58f9c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("67118e69-aba7-4081-ab4b-3fb7c29ef509")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnGroup(this);
    }

}
