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
import org.modelio.metamodel.uml.statik.ElementImport;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00083b94-c4bf-1fd8-97fe-001ec947cd2a")
public class ElementImportImpl extends UmlModelElementImpl implements ElementImport {
    @objid ("351db84a-c47c-4e3c-a54f-9516fcbdbcd0")
    @Override
    public VisibilityMode getVisibility() {
        return (VisibilityMode) getAttVal(((ElementImportSmClass)getClassOf()).getVisibilityAtt());
    }

    @objid ("2708097f-b376-4e1a-8bb4-560d2e1e1436")
    @Override
    public void setVisibility(VisibilityMode value) {
        setAttVal(((ElementImportSmClass)getClassOf()).getVisibilityAtt(), value);
    }

    @objid ("4bfa20b8-3dbb-40a8-91f1-c04c9f8af553")
    @Override
    public NameSpace getImportingNameSpace() {
        Object obj = getDepVal(((ElementImportSmClass)getClassOf()).getImportingNameSpaceDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("fdd7fa62-fc20-4d0a-acf7-1198f430eefb")
    @Override
    public void setImportingNameSpace(NameSpace value) {
        appendDepVal(((ElementImportSmClass)getClassOf()).getImportingNameSpaceDep(), (SmObjectImpl)value);
    }

    @objid ("2755211d-811c-42e7-baf9-ea17be63e84f")
    @Override
    public NameSpace getImportedElement() {
        Object obj = getDepVal(((ElementImportSmClass)getClassOf()).getImportedElementDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("0498c608-1323-42a7-92a7-5528e9c9aa65")
    @Override
    public void setImportedElement(NameSpace value) {
        appendDepVal(((ElementImportSmClass)getClassOf()).getImportedElementDep(), (SmObjectImpl)value);
    }

    @objid ("a7b73259-ed34-45b9-97cc-03235b502525")
    @Override
    public Operation getImportingOperation() {
        Object obj = getDepVal(((ElementImportSmClass)getClassOf()).getImportingOperationDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("59e99637-e868-4581-b2e0-24711c742387")
    @Override
    public void setImportingOperation(Operation value) {
        appendDepVal(((ElementImportSmClass)getClassOf()).getImportingOperationDep(), (SmObjectImpl)value);
    }

    @objid ("53e130c8-0d0b-4a5b-9b9c-9db0d6d0fd68")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ImportingNameSpace
        obj = (SmObjectImpl)this.getDepVal(((ElementImportSmClass)getClassOf()).getImportingNameSpaceDep());
        if (obj != null)
          return obj;
        // ImportingOperation
        obj = (SmObjectImpl)this.getDepVal(((ElementImportSmClass)getClassOf()).getImportingOperationDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("72e4dff8-c63a-4690-a1f5-b6005a17c3d1")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ImportingNameSpace
        dep = ((ElementImportSmClass)getClassOf()).getImportingNameSpaceDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // ImportingOperation
        dep = ((ElementImportSmClass)getClassOf()).getImportingOperationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("2611a17a-ff74-443e-a73f-1b6416d7f988")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitElementImport(this);
    }

}
