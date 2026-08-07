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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.behavior.interactionModel.PartDecomposition;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0048dfe6-c4bf-1fd8-97fe-001ec947cd2a")
public class LifelineImpl extends UmlModelElementImpl implements Lifeline {
    @objid ("431dd641-a528-4852-859c-c4e5ac246186")
    @Override
    public String getSelector() {
        return (String) getAttVal(((LifelineSmClass)getClassOf()).getSelectorAtt());
    }

    @objid ("fcf8155f-462a-42f7-8112-2598a707d7ae")
    @Override
    public void setSelector(String value) {
        setAttVal(((LifelineSmClass)getClassOf()).getSelectorAtt(), value);
    }

    @objid ("59b379f8-b339-461e-8dd0-9bc5a1714053")
    @Override
    public EList<InteractionFragment> getCoveredBy() {
        return new SmList<>(this, ((LifelineSmClass)getClassOf()).getCoveredByDep());
    }

    @objid ("7e8a23d3-88e2-46df-8df3-f3950c4d9d46")
    @Override
    public <T extends InteractionFragment> List<T> getCoveredBy(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InteractionFragment element : getCoveredBy()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("580f9444-32a7-4919-b36c-2fcc140bf74d")
    @Override
    public PartDecomposition getDecomposedAs() {
        Object obj = getDepVal(((LifelineSmClass)getClassOf()).getDecomposedAsDep());
        return (obj instanceof PartDecomposition)? (PartDecomposition)obj : null;
    }

    @objid ("7d236dcc-e2e9-407a-a45b-f3f43ab4f02b")
    @Override
    public void setDecomposedAs(PartDecomposition value) {
        appendDepVal(((LifelineSmClass)getClassOf()).getDecomposedAsDep(), (SmObjectImpl)value);
    }

    @objid ("a67b3a33-1d9a-45d8-aced-23384beea9a6")
    @Override
    public Interaction getOwner() {
        Object obj = getDepVal(((LifelineSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Interaction)? (Interaction)obj : null;
    }

    @objid ("c088a4c9-95e4-45ce-8f23-6458b2c62a78")
    @Override
    public void setOwner(Interaction value) {
        appendDepVal(((LifelineSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("cfb24b8c-c1a5-48d4-bc53-c3fd68d7119f")
    @Override
    public Instance getRepresented() {
        Object obj = getDepVal(((LifelineSmClass)getClassOf()).getRepresentedDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("2f8bddc4-8e0e-4405-8310-996426576cb9")
    @Override
    public void setRepresented(Instance value) {
        appendDepVal(((LifelineSmClass)getClassOf()).getRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("e1ad5582-f209-420b-a8b2-84a91343b373")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((LifelineSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("42b48eb3-8eb1-4a80-adf2-c60935d95443")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((LifelineSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("2610b348-920a-4660-92b5-cd192b987796")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitLifeline(this);
    }

}
