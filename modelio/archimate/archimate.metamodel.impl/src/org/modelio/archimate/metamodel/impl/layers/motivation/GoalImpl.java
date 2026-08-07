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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.layers.motivation;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.impl.core.generic.motivation.MotivationElementImpl;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.session.impl.CoreSession;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("58617fb6-4d9e-4880-ad43-0cad3dbc2a4b")
public class GoalImpl extends MotivationElementImpl implements Goal {
    @objid ("ed01046b-0930-4e4f-be10-58799f08073a")
    @Override
    public String getName() {
        MObject ref = getEquivalentElement();
        if (ref != null) {
            return ref.getName();
        } else {
            return super.getName();
        }

    }

    @objid ("cbc8b95b-18c5-4375-896f-1f66fbc5355d")
    @Override
    public void setName(String value) {
        super.setName(value);

        MObject ref = getEquivalentElement();
        if (ref != null) {
            ref.setName(value);
        }

    }

    @objid ("450a7e08-7c0d-4171-b67d-c3c29cb587e1")
    private MObject getEquivalentElement() {
        try {
            return CoreSession.getSession(this).getModel().findByRef(new MRef(getEquivalentRef()));
        } catch (@SuppressWarnings("unused") IllegalArgumentException e) {
            // Ignore invalid ref, just return null
            return null;
        }

    }

    @objid ("efe30ea3-a414-4896-a1b7-d49bde8df7d2")
    @Override
    public String getEquivalentRef() {
        return (String) getAttVal(((GoalSmClass)getClassOf()).getEquivalentRefAtt());
    }

    @objid ("6c48d18a-99ab-46cb-a15c-2083c87715b3")
    @Override
    public void setEquivalentRef(String value) {
        setAttVal(((GoalSmClass)getClassOf()).getEquivalentRefAtt(), value);
    }

    @objid ("e9c108e5-32c0-40b3-a495-0775d666a024")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("d26cf6b5-f239-42b7-b774-19854dc80aee")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("131ab22b-8b85-497f-ac37-0e1d27e79f3d")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitGoal(this);
    }

}
