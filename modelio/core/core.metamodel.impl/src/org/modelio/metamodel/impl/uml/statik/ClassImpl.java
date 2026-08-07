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
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000247ca-c4bf-1fd8-97fe-001ec947cd2a")
public class ClassImpl extends GeneralClassImpl implements Class {
    @objid ("aa0e123b-38e5-41e9-bc3c-861ce345b8b9")
    @Override
    public boolean isIsActive() {
        return (Boolean) getAttVal(((ClassSmClass)getClassOf()).getIsActiveAtt());
    }

    @objid ("485ba370-8d3f-4841-b741-1f8549d8578c")
    @Override
    public void setIsActive(boolean value) {
        setAttVal(((ClassSmClass)getClassOf()).getIsActiveAtt(), value);
    }

    @objid ("f27edda6-9974-444a-bb9d-fe91393270e2")
    @Override
    public boolean isIsMain() {
        return (Boolean) getAttVal(((ClassSmClass)getClassOf()).getIsMainAtt());
    }

    @objid ("b8dc545d-08f9-4104-aa14-acac274de154")
    @Override
    public void setIsMain(boolean value) {
        setAttVal(((ClassSmClass)getClassOf()).getIsMainAtt(), value);
    }

    @objid ("b64fff95-646b-4f8f-bec3-0b6d283a3032")
    @Override
    public ClassAssociation getLinkToAssociation() {
        Object obj = getDepVal(((ClassSmClass)getClassOf()).getLinkToAssociationDep());
        return (obj instanceof ClassAssociation)? (ClassAssociation)obj : null;
    }

    @objid ("b80f08fe-8222-4fb7-badf-de83d826b106")
    @Override
    public void setLinkToAssociation(ClassAssociation value) {
        appendDepVal(((ClassSmClass)getClassOf()).getLinkToAssociationDep(), (SmObjectImpl)value);
    }

    @objid ("6b76510a-6733-4568-ac3e-e197653b0433")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("2a9b679c-a0a4-407b-b308-f551f18ae59a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("0c1d6809-d265-4869-91d3-ce49f0a79186")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitClass(this);
    }

}
