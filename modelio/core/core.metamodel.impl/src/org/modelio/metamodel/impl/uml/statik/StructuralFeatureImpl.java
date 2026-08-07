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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.KindOfAccess;
import org.modelio.metamodel.uml.statik.StructuralFeature;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("001f3344-c4bf-1fd8-97fe-001ec947cd2a")
public class StructuralFeatureImpl extends FeatureImpl implements StructuralFeature {
    @objid ("e3f50316-3dfa-49e4-9171-ea435f7f3943")
    @Override
    public KindOfAccess getChangeable() {
        return (KindOfAccess) getAttVal(((StructuralFeatureSmClass)getClassOf()).getChangeableAtt());
    }

    @objid ("6d8fb34d-3788-4cb6-95c1-060ecb22136a")
    @Override
    public void setChangeable(KindOfAccess value) {
        setAttVal(((StructuralFeatureSmClass)getClassOf()).getChangeableAtt(), value);
    }

    @objid ("97ded5dd-ebda-4a73-96f3-9189e63a3581")
    @Override
    public boolean isIsDerived() {
        return (Boolean) getAttVal(((StructuralFeatureSmClass)getClassOf()).getIsDerivedAtt());
    }

    @objid ("60d4500e-b32b-4d9a-885c-df4780a0ef13")
    @Override
    public void setIsDerived(boolean value) {
        setAttVal(((StructuralFeatureSmClass)getClassOf()).getIsDerivedAtt(), value);
    }

    @objid ("e0fb9469-f428-430c-8363-a16fe26a93d2")
    @Override
    public boolean isIsOrdered() {
        return (Boolean) getAttVal(((StructuralFeatureSmClass)getClassOf()).getIsOrderedAtt());
    }

    @objid ("38d874db-81ec-40f3-a11e-fbfef9c372a4")
    @Override
    public void setIsOrdered(boolean value) {
        setAttVal(((StructuralFeatureSmClass)getClassOf()).getIsOrderedAtt(), value);
    }

    @objid ("22f74af6-b6c3-4cab-9ac8-8cd248b62dc1")
    @Override
    public boolean isIsUnique() {
        return (Boolean) getAttVal(((StructuralFeatureSmClass)getClassOf()).getIsUniqueAtt());
    }

    @objid ("f26f0c81-5f7e-43cc-808f-f9da75c7e07e")
    @Override
    public void setIsUnique(boolean value) {
        setAttVal(((StructuralFeatureSmClass)getClassOf()).getIsUniqueAtt(), value);
    }

    @objid ("4d314828-4df1-40df-80aa-ec807cec8575")
    @Override
    public String getMultiplicityMin() {
        return (String) getAttVal(((StructuralFeatureSmClass)getClassOf()).getMultiplicityMinAtt());
    }

    @objid ("41959853-68ae-4349-97d5-7cfe29d3eccf")
    @Override
    public void setMultiplicityMin(String value) {
        setAttVal(((StructuralFeatureSmClass)getClassOf()).getMultiplicityMinAtt(), value);
    }

    @objid ("939c520b-c6d5-4f01-815e-0cc1a600dbc5")
    @Override
    public String getMultiplicityMax() {
        return (String) getAttVal(((StructuralFeatureSmClass)getClassOf()).getMultiplicityMaxAtt());
    }

    @objid ("dc49473d-6add-47be-828d-680db05e0325")
    @Override
    public void setMultiplicityMax(String value) {
        setAttVal(((StructuralFeatureSmClass)getClassOf()).getMultiplicityMaxAtt(), value);
    }

    @objid ("7d97d6f2-f068-4362-a59a-c44d13906319")
    @Override
    public EList<InformationFlow> getRealizedInformationFlow() {
        return new SmList<>(this, ((StructuralFeatureSmClass)getClassOf()).getRealizedInformationFlowDep());
    }

    @objid ("9d2855a6-1e4b-4453-96ff-8971b88cb0d4")
    @Override
    public <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getRealizedInformationFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("dd6aafc7-2d55-4fed-8e11-72489a84be70")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("7a00b5a4-f613-4ccc-b413-b3fff02a4cac")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("1663652d-e74b-4515-bf65-e09619bdc043")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitStructuralFeature(this);
    }

}
