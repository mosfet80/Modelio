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
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
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

@objid ("b944e8a4-151e-4e63-9efd-68d743305afe")
public class RequirementImpl extends MotivationElementImpl implements Requirement {
    @objid ("0820aa79-263f-4164-aeb3-eafbeb661b90")
    @Override
    public String getName() {
        MObject ref = getEquivalentElement();
        if (ref != null) {
            return ref.getName();
        } else {
            return super.getName();
        }

    }

    @objid ("49498b5f-adda-487c-8587-fbf46ed17566")
    @Override
    public void setName(String value) {
        super.setName(value);

        MObject ref = getEquivalentElement();
        if (ref != null) {
            ref.setName(value);
        }

    }

    @objid ("18873dba-ab9d-452f-8a13-38a7db501280")
    private MObject getEquivalentElement() {
        try {
            return CoreSession.getSession(this).getModel().findByRef(new MRef(getEquivalentRef()));
        } catch (@SuppressWarnings("unused") IllegalArgumentException e) {
            // Ignore invalid ref, just return null
            return null;
        }

    }

    @objid ("c00aff0c-954c-46be-a369-9d437a2346f9")
    @Override
    public String getEquivalentRef() {
        return (String) getAttVal(((RequirementSmClass)getClassOf()).getEquivalentRefAtt());
    }

    @objid ("f628bdc5-b62c-44db-825d-ca033ae768d6")
    @Override
    public void setEquivalentRef(String value) {
        setAttVal(((RequirementSmClass)getClassOf()).getEquivalentRefAtt(), value);
    }

    @objid ("59b55b20-18f5-4c39-9c03-0dc83210b3de")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("cede8a94-5c2f-4d81-a22f-d6cc455cb655")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("6778018c-d32a-4394-bca2-1c05e15cfc8d")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitRequirement(this);
    }

}
