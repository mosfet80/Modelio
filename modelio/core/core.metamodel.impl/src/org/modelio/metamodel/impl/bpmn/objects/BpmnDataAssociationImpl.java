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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0004abfa-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataAssociationImpl extends BpmnBaseElementImpl implements BpmnDataAssociation {
    @objid ("1ee383e7-b453-4a25-bcbe-0ee5ab02c906")
    @Override
    public String getAssignment() {
        return (String) getAttVal(((BpmnDataAssociationSmClass)getClassOf()).getAssignmentAtt());
    }

    @objid ("35f3ae7c-1695-49a9-bc68-ce4551e0d643")
    @Override
    public void setAssignment(String value) {
        setAttVal(((BpmnDataAssociationSmClass)getClassOf()).getAssignmentAtt(), value);
    }

    @objid ("a2b4ff2d-1d56-4df5-bc59-65f24ddaf6c1")
    @Override
    public String getTransfomation() {
        return (String) getAttVal(((BpmnDataAssociationSmClass)getClassOf()).getTransfomationAtt());
    }

    @objid ("665b51a5-84d7-436c-a60f-21ac452c9479")
    @Override
    public void setTransfomation(String value) {
        setAttVal(((BpmnDataAssociationSmClass)getClassOf()).getTransfomationAtt(), value);
    }

    @objid ("016e967c-e48f-4b61-8f79-43fedb29fa85")
    @Override
    public String getLanguage() {
        return (String) getAttVal(((BpmnDataAssociationSmClass)getClassOf()).getLanguageAtt());
    }

    @objid ("1281b09b-7f6b-4bb1-89eb-ec1a3bb4e5ce")
    @Override
    public void setLanguage(String value) {
        setAttVal(((BpmnDataAssociationSmClass)getClassOf()).getLanguageAtt(), value);
    }

    @objid ("d518d0c0-a055-4a4c-b4fc-9c69102f6eba")
    @Override
    public EList<BpmnItemAwareElement> getSourceRef() {
        return new SmList<>(this, ((BpmnDataAssociationSmClass)getClassOf()).getSourceRefDep());
    }

    @objid ("c0af5510-6b7b-4670-afc9-838c970468ad")
    @Override
    public <T extends BpmnItemAwareElement> List<T> getSourceRef(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnItemAwareElement element : getSourceRef()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("10eac623-1f2e-4cc3-b54d-1a82cae5cf24")
    @Override
    public BpmnItemAwareElement getTargetRef() {
        Object obj = getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getTargetRefDep());
        return (obj instanceof BpmnItemAwareElement)? (BpmnItemAwareElement)obj : null;
    }

    @objid ("6d94f626-1cd1-440c-87a5-3db185e7a7cd")
    @Override
    public void setTargetRef(BpmnItemAwareElement value) {
        appendDepVal(((BpmnDataAssociationSmClass)getClassOf()).getTargetRefDep(), (SmObjectImpl)value);
    }

    @objid ("e5deff29-3bd9-4a77-8e5d-e003f6909d06")
    @Override
    public BpmnActivity getEndingActivity() {
        Object obj = getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getEndingActivityDep());
        return (obj instanceof BpmnActivity)? (BpmnActivity)obj : null;
    }

    @objid ("2ffd2756-4d35-4a8e-90a5-427eda5b3ab4")
    @Override
    public void setEndingActivity(BpmnActivity value) {
        appendDepVal(((BpmnDataAssociationSmClass)getClassOf()).getEndingActivityDep(), (SmObjectImpl)value);
    }

    @objid ("71a78561-b2ea-4da2-bdb0-07db15f2068f")
    @Override
    public BpmnActivity getStartingActivity() {
        Object obj = getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getStartingActivityDep());
        return (obj instanceof BpmnActivity)? (BpmnActivity)obj : null;
    }

    @objid ("119846e3-f8dc-495f-b6e2-bb83acd30e58")
    @Override
    public void setStartingActivity(BpmnActivity value) {
        appendDepVal(((BpmnDataAssociationSmClass)getClassOf()).getStartingActivityDep(), (SmObjectImpl)value);
    }

    @objid ("e3130b95-9d37-4b74-9ee5-5361c0206955")
    @Override
    public BpmnThrowEvent getStartingEvent() {
        Object obj = getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getStartingEventDep());
        return (obj instanceof BpmnThrowEvent)? (BpmnThrowEvent)obj : null;
    }

    @objid ("f27f9b9e-e342-4643-b076-b5ed27f7b18b")
    @Override
    public void setStartingEvent(BpmnThrowEvent value) {
        appendDepVal(((BpmnDataAssociationSmClass)getClassOf()).getStartingEventDep(), (SmObjectImpl)value);
    }

    @objid ("b0382101-35a6-42d6-9c1a-dac078a42146")
    @Override
    public EList<BpmnSequenceFlowDataAssociation> getVisualShortCut() {
        return new SmList<>(this, ((BpmnDataAssociationSmClass)getClassOf()).getVisualShortCutDep());
    }

    @objid ("7c91edf2-4338-40b5-bdfb-a899b641ca59")
    @Override
    public <T extends BpmnSequenceFlowDataAssociation> List<T> getVisualShortCut(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnSequenceFlowDataAssociation element : getVisualShortCut()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("36c3e876-1e12-483d-af16-4f6501ebd9f0")
    @Override
    public BpmnCatchEvent getEndingEvent() {
        Object obj = getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getEndingEventDep());
        return (obj instanceof BpmnCatchEvent)? (BpmnCatchEvent)obj : null;
    }

    @objid ("9b902fc3-c7fa-4340-bd5f-682d4abfa954")
    @Override
    public void setEndingEvent(BpmnCatchEvent value) {
        appendDepVal(((BpmnDataAssociationSmClass)getClassOf()).getEndingEventDep(), (SmObjectImpl)value);
    }

    @objid ("0eb673e5-6d0c-4c2e-86e9-a29ed5d93f40")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // EndingActivity
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getEndingActivityDep());
        if (obj != null)
          return obj;
        // StartingActivity
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getStartingActivityDep());
        if (obj != null)
          return obj;
        // StartingEvent
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getStartingEventDep());
        if (obj != null)
          return obj;
        // EndingEvent
        obj = (SmObjectImpl)this.getDepVal(((BpmnDataAssociationSmClass)getClassOf()).getEndingEventDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("907a9c10-bcaa-4b0c-86d1-f0c47fa5a19d")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // EndingActivity
        dep = ((BpmnDataAssociationSmClass)getClassOf()).getEndingActivityDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // StartingActivity
        dep = ((BpmnDataAssociationSmClass)getClassOf()).getStartingActivityDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // StartingEvent
        dep = ((BpmnDataAssociationSmClass)getClassOf()).getStartingEventDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // EndingEvent
        dep = ((BpmnDataAssociationSmClass)getClassOf()).getEndingEventDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("3c25bd3b-2ba2-4148-a426-811ec716f871")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnDataAssociation(this);
    }

}
