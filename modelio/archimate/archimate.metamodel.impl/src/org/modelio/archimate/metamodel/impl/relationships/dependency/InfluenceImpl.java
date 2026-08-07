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
package org.modelio.archimate.metamodel.impl.relationships.dependency;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("250fadfc-ab7d-4d0a-9b95-125bbb3f353c")
public class InfluenceImpl extends DependencyRelationshipImpl implements Influence {
    @objid ("daf3c4f1-aa27-48f0-9ec0-37bf14dc0711")
    @Override
    public String getStrength() {
        return (String) getAttVal(((InfluenceSmClass)getClassOf()).getStrengthAtt());
    }

    @objid ("9bdddfe2-dbe3-4539-9654-6affbfc68ebd")
    @Override
    public void setStrength(String value) {
        setAttVal(((InfluenceSmClass)getClassOf()).getStrengthAtt(), value);
    }

    @objid ("beee77ec-ecb4-4df7-8ef4-c82f9bb991c9")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("ad56093b-7c6e-400c-9c21-010196fc585c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("b2c4aac2-5e6e-480b-b4c6-5382adb2a5d4")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitInfluence(this);
    }

}
