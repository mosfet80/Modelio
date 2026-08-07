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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.LoopNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00376270-c4bf-1fd8-97fe-001ec947cd2a")
public class LoopNodeImpl extends StructuredActivityNodeImpl implements LoopNode {
    @objid ("5bd98c83-8896-4f89-be89-baf533af4570")
    @Override
    public boolean isIsTestedFirst() {
        return (Boolean) getAttVal(((LoopNodeSmClass)getClassOf()).getIsTestedFirstAtt());
    }

    @objid ("85f4d70c-486d-4536-9e57-f98e7813b09d")
    @Override
    public void setIsTestedFirst(boolean value) {
        setAttVal(((LoopNodeSmClass)getClassOf()).getIsTestedFirstAtt(), value);
    }

    @objid ("efd68d53-4e7f-4d3a-b8cc-e65bfb26de98")
    @Override
    public String getSetup() {
        return (String) getAttVal(((LoopNodeSmClass)getClassOf()).getSetupAtt());
    }

    @objid ("ca0a2939-76c9-43df-8178-7b89526293a0")
    @Override
    public void setSetup(String value) {
        setAttVal(((LoopNodeSmClass)getClassOf()).getSetupAtt(), value);
    }

    @objid ("40563472-a6b8-40ce-ba37-d41fe1018027")
    @Override
    public String getTest() {
        return (String) getAttVal(((LoopNodeSmClass)getClassOf()).getTestAtt());
    }

    @objid ("fd6421a2-c0ed-4d3b-8711-953e57a3edc1")
    @Override
    public void setTest(String value) {
        setAttVal(((LoopNodeSmClass)getClassOf()).getTestAtt(), value);
    }

    @objid ("18f57af9-3e9c-4e2e-9340-1caff03f1646")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("95c1e396-7bd5-4cb3-a8b8-0e59c174ae8a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("4a1ded13-4f7c-4fea-b8ad-1b9eb90b8d2a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitLoopNode(this);
    }

}
