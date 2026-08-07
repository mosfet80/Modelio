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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.statik.GeneralClassImpl;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptSignalAction;
import org.modelio.metamodel.uml.behavior.activityModel.SendSignalAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0042379a-c4bf-1fd8-97fe-001ec947cd2a")
public class SignalImpl extends GeneralClassImpl implements Signal {
    @objid ("d1b7e9a2-3605-4263-87e1-e238e5c45aa2")
    @Override
    public boolean isIsEvent() {
        return (Boolean) getAttVal(((SignalSmClass)getClassOf()).getIsEventAtt());
    }

    @objid ("1a1b0da4-6cef-44c5-9f6f-3dffc807a21d")
    @Override
    public void setIsEvent(boolean value) {
        setAttVal(((SignalSmClass)getClassOf()).getIsEventAtt(), value);
    }

    @objid ("daf488fb-789e-4b2d-8d0c-d1c6d7563df7")
    @Override
    public boolean isIsException() {
        return (Boolean) getAttVal(((SignalSmClass)getClassOf()).getIsExceptionAtt());
    }

    @objid ("aafd66fe-b2a2-4297-9274-bbdc7951b548")
    @Override
    public void setIsException(boolean value) {
        setAttVal(((SignalSmClass)getClassOf()).getIsExceptionAtt(), value);
    }

    @objid ("af27aa38-2798-4ce9-9377-15ed5613194b")
    @Override
    public EList<SendSignalAction> getSender() {
        return new SmList<>(this, ((SignalSmClass)getClassOf()).getSenderDep());
    }

    @objid ("c238c1cc-98ab-402f-93ed-1bbaeb4a681d")
    @Override
    public <T extends SendSignalAction> List<T> getSender(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final SendSignalAction element : getSender()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9933d768-c9de-4901-a0a0-30655b57fc33")
    @Override
    public EList<Message> getUsage() {
        return new SmList<>(this, ((SignalSmClass)getClassOf()).getUsageDep());
    }

    @objid ("d2186c30-3e1c-4340-ae1a-fa5889946aac")
    @Override
    public <T extends Message> List<T> getUsage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Message element : getUsage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("fcbfb3db-e7a5-4b56-a9f8-091a074c4a3e")
    @Override
    public EList<Transition> getSends() {
        return new SmList<>(this, ((SignalSmClass)getClassOf()).getSendsDep());
    }

    @objid ("4fe0c440-6606-4b2b-af41-cf58099cb2c6")
    @Override
    public <T extends Transition> List<T> getSends(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Transition element : getSends()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ab68b9fd-770e-49d7-a904-429ba47310cd")
    @Override
    public Parameter getPBase() {
        Object obj = getDepVal(((SignalSmClass)getClassOf()).getPBaseDep());
        return (obj instanceof Parameter)? (Parameter)obj : null;
    }

    @objid ("0c3332e0-1aed-4c25-b261-107a278f9268")
    @Override
    public void setPBase(Parameter value) {
        appendDepVal(((SignalSmClass)getClassOf()).getPBaseDep(), (SmObjectImpl)value);
    }

    @objid ("c073e19b-b460-419b-af40-cb8a7082b177")
    @Override
    public Operation getOBase() {
        Object obj = getDepVal(((SignalSmClass)getClassOf()).getOBaseDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("516ce1fb-7f46-4194-9616-5cc4b91a827d")
    @Override
    public void setOBase(Operation value) {
        appendDepVal(((SignalSmClass)getClassOf()).getOBaseDep(), (SmObjectImpl)value);
    }

    @objid ("33263e32-8b7f-4d8f-8d8a-ecd2516e0e70")
    @Override
    public EList<CommunicationMessage> getCommunicationUsage() {
        return new SmList<>(this, ((SignalSmClass)getClassOf()).getCommunicationUsageDep());
    }

    @objid ("caba4bc9-57e2-474b-90d4-9ca51338a07d")
    @Override
    public <T extends CommunicationMessage> List<T> getCommunicationUsage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationMessage element : getCommunicationUsage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("09f0a23e-52cd-4fb9-974e-276184d96595")
    @Override
    public EList<DataFlow> getDOccurence() {
        return new SmList<>(this, ((SignalSmClass)getClassOf()).getDOccurenceDep());
    }

    @objid ("17cd039e-b6be-443f-b93e-ac8ab0463bcd")
    @Override
    public <T extends DataFlow> List<T> getDOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final DataFlow element : getDOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ec332565-f568-400a-a66d-56511b98be5a")
    @Override
    public EList<Event> getEOccurence() {
        return new SmList<>(this, ((SignalSmClass)getClassOf()).getEOccurenceDep());
    }

    @objid ("d2ccf5b3-bacf-4dd3-8a15-3bcbd4dd40bc")
    @Override
    public <T extends Event> List<T> getEOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Event element : getEOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a48331bc-3a21-4dca-bc21-9d396c738e78")
    @Override
    public GeneralClass getBase() {
        Object obj = getDepVal(((SignalSmClass)getClassOf()).getBaseDep());
        return (obj instanceof GeneralClass)? (GeneralClass)obj : null;
    }

    @objid ("55f3c6a6-e2e7-4979-8dcc-957728749cf3")
    @Override
    public void setBase(GeneralClass value) {
        appendDepVal(((SignalSmClass)getClassOf()).getBaseDep(), (SmObjectImpl)value);
    }

    @objid ("0490f8bb-ed07-456d-9b7c-d170997cc17e")
    @Override
    public EList<AcceptSignalAction> getReceiver() {
        return new SmList<>(this, ((SignalSmClass)getClassOf()).getReceiverDep());
    }

    @objid ("e21d1baf-23d0-451a-aef4-2831b0e2247b")
    @Override
    public <T extends AcceptSignalAction> List<T> getReceiver(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final AcceptSignalAction element : getReceiver()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c809c8b4-e995-4922-ba77-4a36f3a2a10b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("4a3a7f3a-fc97-4a1b-ab16-6fb244dcc449")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("a0d38868-3ecd-4eb0-9a67-b7fac8c26efb")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitSignal(this);
    }

}
