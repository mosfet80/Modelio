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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00227a86-c4bf-1fd8-97fe-001ec947cd2a")
public class NaryLinkImpl extends UmlModelElementImpl implements NaryLink {
    @objid ("892a19eb-169c-4d68-bdb7-aada6bad2672")
    @Override
    public SmObjectImpl getCompositionOwner() {
        for (SmObjectImpl obj : this.getDepValList(((NaryLinkSmClass) getClassOf()).getNaryLinkEndDep())) {
            // Avoid infinite composition loops
            SmObjectImpl objOwner = obj.getCompositionOwner();
            if (objOwner != this && objOwner != null) {
                return obj;
            }

        }
        return super.getCompositionOwner();
    }

    @objid ("154596a6-bea0-4b8c-b421-c4f78eeb540c")
    @Override
    public SmDepVal getCompositionRelation() {
        for (SmObjectImpl obj : this.getDepValList(((NaryLinkSmClass) getClassOf()).getNaryLinkEndDep())) {
            // Avoid infinite composition loops
            SmObjectImpl objOwner = obj.getCompositionOwner();
            if (objOwner != this && objOwner != null) {
                return new SmDepVal(((NaryLinkSmClass) getClassOf()).getNaryLinkEndDep(), obj);
            }
        }
        return super.getCompositionRelation();
    }

    @objid ("9d635ed3-8666-4eaa-be31-8cde824199c0")
    @Override
    public void afterEraseDepVal(SmDependency dep, SmObjectImpl value) {
        if (dep == ((NaryLinkSmClass) getClassOf()).getNaryLinkEndDep()) {
            // Workaround bug where the storage handle is not updated
            EList<NaryLinkEnd> remainingOwners = getNaryLinkEnd();
            if (!remainingOwners.isEmpty()) {
                // Remove and add again the first remaining owner.
                // Note : this will trigger recursively the removal & addition of all other owners.
                NaryLinkEnd r = remainingOwners.get(0);
                r.setNaryLink(null);
                r.setNaryLink(this);
            }
        }

        super.afterEraseDepVal(dep, value);

    }

    @objid ("7dd2fa82-0f06-48e2-9c3a-d029d7bf7945")
    @Override
    public EList<NaryLinkEnd> getNaryLinkEnd() {
        return new SmList<>(this, ((NaryLinkSmClass)getClassOf()).getNaryLinkEndDep());
    }

    @objid ("467066b9-d35e-4525-837b-f7395f07f6d4")
    @Override
    public <T extends NaryLinkEnd> List<T> getNaryLinkEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryLinkEnd element : getNaryLinkEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("82b88639-370d-44bb-a23e-7438adadef0a")
    @Override
    public NaryAssociation getModel() {
        Object obj = getDepVal(((NaryLinkSmClass)getClassOf()).getModelDep());
        return (obj instanceof NaryAssociation)? (NaryAssociation)obj : null;
    }

    @objid ("10e38250-55cf-4b8d-8743-0ebd34ebdf80")
    @Override
    public void setModel(NaryAssociation value) {
        appendDepVal(((NaryLinkSmClass)getClassOf()).getModelDep(), (SmObjectImpl)value);
    }

    @objid ("e68c4511-e447-4ca2-950d-c207d31b67a9")
    @Override
    public EList<InformationFlow> getRealizedInformationFlow() {
        return new SmList<>(this, ((NaryLinkSmClass)getClassOf()).getRealizedInformationFlowDep());
    }

    @objid ("6d81e00d-a7ee-499f-ac94-19b4388c9e94")
    @Override
    public <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getRealizedInformationFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("75a38a17-e0ee-4db6-a0c0-bf055e9e159c")
    @Override
    public EList<CommunicationChannel> getSent() {
        return new SmList<>(this, ((NaryLinkSmClass)getClassOf()).getSentDep());
    }

    @objid ("efb49957-2ca2-4d87-ba9a-e12a75178c95")
    @Override
    public <T extends CommunicationChannel> List<T> getSent(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationChannel element : getSent()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("35bbe805-0f77-4c07-a17f-efcf2318d196")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitNaryLink(this);
    }

}
