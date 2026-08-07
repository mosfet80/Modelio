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
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("01170c7c-f6f1-4d69-b50e-5f5e0b067212")
public class LinkImpl extends UmlModelElementImpl implements Link {
    @objid ("8a613814-6158-4adc-a1ab-5dac81598ce7")
    @Override
    public SmObjectImpl getCompositionOwner() {
        for (SmObjectImpl obj : this.getDepValList(((LinkSmClass) getClassOf()).getLinkEndDep())) {
            return obj;
        }
        return super.getCompositionOwner();
    }

    @objid ("4fb95fb2-6b47-4648-9ee9-8381d233fe17")
    @Override
    public SmDepVal getCompositionRelation() {
        for (SmObjectImpl obj : this.getDepValList(((LinkSmClass) getClassOf()).getLinkEndDep())) {
            return new SmDepVal(((LinkSmClass) getClassOf()).getLinkEndDep(), obj);
        }
        return super.getCompositionRelation();
    }

    @objid ("6cbc1f79-5110-4b7d-84fa-4a4317a2bf2b")
    @Override
    public Association getModel() {
        Object obj = getDepVal(((LinkSmClass)getClassOf()).getModelDep());
        return (obj instanceof Association)? (Association)obj : null;
    }

    @objid ("2ead42eb-8ff8-4317-aca3-b067e01a8efc")
    @Override
    public void setModel(Association value) {
        appendDepVal(((LinkSmClass)getClassOf()).getModelDep(), (SmObjectImpl)value);
    }

    @objid ("dc40936b-a976-4c4c-8f85-51626c17b031")
    @Override
    public EList<LinkEnd> getLinkEnd() {
        return new SmList<>(this, ((LinkSmClass)getClassOf()).getLinkEndDep());
    }

    @objid ("5501b091-96f1-4584-8545-b56ae9a9fd6b")
    @Override
    public <T extends LinkEnd> List<T> getLinkEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final LinkEnd element : getLinkEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("21658dbb-b5a7-43fb-8d25-723e441b7b91")
    @Override
    public CommunicationChannel getSent() {
        Object obj = getDepVal(((LinkSmClass)getClassOf()).getSentDep());
        return (obj instanceof CommunicationChannel)? (CommunicationChannel)obj : null;
    }

    @objid ("87241b83-564e-4d4c-95ed-1092b902f1a2")
    @Override
    public void setSent(CommunicationChannel value) {
        appendDepVal(((LinkSmClass)getClassOf()).getSentDep(), (SmObjectImpl)value);
    }

    @objid ("1f3798d2-ac88-4c7c-aa09-187581e0cb97")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitLink(this);
    }

}
