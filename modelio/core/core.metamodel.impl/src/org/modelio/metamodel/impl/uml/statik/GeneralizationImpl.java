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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.statik.Generalization;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000cb930-c4bf-1fd8-97fe-001ec947cd2a")
public class GeneralizationImpl extends UmlModelElementImpl implements Generalization {
    @objid ("10310f9e-437a-4f86-8b3c-4cb72f948ab3")
    @Override
    public String getDiscriminator() {
        return (String) getAttVal(((GeneralizationSmClass)getClassOf()).getDiscriminatorAtt());
    }

    @objid ("7bd926ae-575b-4ff9-820e-0007e12e0c87")
    @Override
    public void setDiscriminator(String value) {
        setAttVal(((GeneralizationSmClass)getClassOf()).getDiscriminatorAtt(), value);
    }

    @objid ("f82dc87f-7a59-46eb-8da0-c2f910126557")
    @Override
    public NameSpace getSuperType() {
        Object obj = getDepVal(((GeneralizationSmClass)getClassOf()).getSuperTypeDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("2f34782b-2eb7-4ac6-9862-d606c38f6170")
    @Override
    public void setSuperType(NameSpace value) {
        appendDepVal(((GeneralizationSmClass)getClassOf()).getSuperTypeDep(), (SmObjectImpl)value);
    }

    @objid ("46cc0eb8-76de-4bd8-823a-5c20d6d6b148")
    @Override
    public NameSpace getSubType() {
        Object obj = getDepVal(((GeneralizationSmClass)getClassOf()).getSubTypeDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("5a8843d1-02be-49d9-b949-395fd594fd68")
    @Override
    public void setSubType(NameSpace value) {
        appendDepVal(((GeneralizationSmClass)getClassOf()).getSubTypeDep(), (SmObjectImpl)value);
    }

    @objid ("bf5b99e2-01c7-4525-ad36-7bd147d910da")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // SubType
        obj = (SmObjectImpl)this.getDepVal(((GeneralizationSmClass)getClassOf()).getSubTypeDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("b8f48f8e-a57e-46c9-afd7-ef75b927b6f4")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // SubType
        dep = ((GeneralizationSmClass)getClassOf()).getSubTypeDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("4822ed8d-709c-4b4e-8061-2e8eea56a9e6")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitGeneralization(this);
    }

}
