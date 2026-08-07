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
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
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

@objid ("fb9c7211-cb2b-41bf-8cf9-801f56125a95")
public class MeaningImpl extends MotivationElementImpl implements Meaning {
    @objid ("a4c22b0a-0207-4306-a9b6-df95c6a63990")
    @Override
    public String getName() {
        MObject ref = getEquivalentElement();
        if (ref != null) {
            return ref.getName();
        } else {
            return super.getName();
        }

    }

    @objid ("060954ca-aabf-4131-836b-caa42f2b4cfe")
    @Override
    public void setName(String value) {
        super.setName(value);

        MObject ref = getEquivalentElement();
        if (ref != null) {
            ref.setName(value);
        }

    }

    @objid ("ba29fa90-10f8-41b5-975a-f61b44c68154")
    private MObject getEquivalentElement() {
        try {
            return CoreSession.getSession(this).getModel().findByRef(new MRef(getEquivalentRef()));
        } catch (@SuppressWarnings("unused") IllegalArgumentException e) {
            // Ignore invalid ref, just return null
            return null;
        }

    }

    @objid ("d187e77c-f0a0-46ca-adbd-4251b246d23d")
    @Override
    public String getEquivalentRef() {
        return (String) getAttVal(((MeaningSmClass)getClassOf()).getEquivalentRefAtt());
    }

    @objid ("b463bb6e-5bf1-442a-ba89-ee6fad36ca28")
    @Override
    public void setEquivalentRef(String value) {
        setAttVal(((MeaningSmClass)getClassOf()).getEquivalentRefAtt(), value);
    }

    @objid ("f8dd6fdf-2f27-4956-96f3-f74745334538")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("a7097fd6-adac-453a-b66e-ee5958e473bd")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("afda749f-2e9c-405b-83d3-1d070798b01f")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitMeaning(this);
    }

}
