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
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00164f7c-c4bf-1fd8-97fe-001ec947cd2a")
public class PackageImportImpl extends UmlModelElementImpl implements PackageImport {
    @objid ("ccd0267e-9df7-44c0-a5bf-3b21bc94cca5")
    @Override
    public VisibilityMode getVisibility() {
        return (VisibilityMode) getAttVal(((PackageImportSmClass)getClassOf()).getVisibilityAtt());
    }

    @objid ("6778157b-5277-430f-8d2a-ad64d007881f")
    @Override
    public void setVisibility(VisibilityMode value) {
        setAttVal(((PackageImportSmClass)getClassOf()).getVisibilityAtt(), value);
    }

    @objid ("1350b3da-9219-4b17-a564-2efdeadcea39")
    @Override
    public Operation getImportingOperation() {
        Object obj = getDepVal(((PackageImportSmClass)getClassOf()).getImportingOperationDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("f34640b7-1973-4ccf-b83f-8563d3ac37de")
    @Override
    public void setImportingOperation(Operation value) {
        appendDepVal(((PackageImportSmClass)getClassOf()).getImportingOperationDep(), (SmObjectImpl)value);
    }

    @objid ("636a06f5-dcc9-4e24-a6ec-1f205cba6bda")
    @Override
    public NameSpace getImportingNameSpace() {
        Object obj = getDepVal(((PackageImportSmClass)getClassOf()).getImportingNameSpaceDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("880fd164-8117-4ddf-a226-1d8e1734e375")
    @Override
    public void setImportingNameSpace(NameSpace value) {
        appendDepVal(((PackageImportSmClass)getClassOf()).getImportingNameSpaceDep(), (SmObjectImpl)value);
    }

    @objid ("d7b7ebff-870c-456c-8da4-dd8d7699ffc4")
    @Override
    public Package getImportedPackage() {
        Object obj = getDepVal(((PackageImportSmClass)getClassOf()).getImportedPackageDep());
        return (obj instanceof Package)? (Package)obj : null;
    }

    @objid ("3e53e590-1d49-4223-ad02-4b041eb718f4")
    @Override
    public void setImportedPackage(Package value) {
        appendDepVal(((PackageImportSmClass)getClassOf()).getImportedPackageDep(), (SmObjectImpl)value);
    }

    @objid ("3c9a80d4-ad95-4972-a00b-98328da68dd9")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ImportingOperation
        obj = (SmObjectImpl)this.getDepVal(((PackageImportSmClass)getClassOf()).getImportingOperationDep());
        if (obj != null)
          return obj;
        // ImportingNameSpace
        obj = (SmObjectImpl)this.getDepVal(((PackageImportSmClass)getClassOf()).getImportingNameSpaceDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("81fb27ed-2666-49ea-9dd5-e558d37f56d2")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ImportingOperation
        dep = ((PackageImportSmClass)getClassOf()).getImportingOperationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // ImportingNameSpace
        dep = ((PackageImportSmClass)getClassOf()).getImportingNameSpaceDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("5ad4896a-3e90-48b8-b58b-965d4ca37c6e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitPackageImport(this);
    }

}
