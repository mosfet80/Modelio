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
import org.modelio.metamodel.uml.statik.Feature;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000b3ab0-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class FeatureImpl extends UmlModelElementImpl implements Feature {
    @objid ("e79ec194-2c0b-45eb-916a-1690ae265c9b")
    @Override
    public VisibilityMode getVisibility() {
        return (VisibilityMode) getAttVal(((FeatureSmClass)getClassOf()).getVisibilityAtt());
    }

    @objid ("ba219158-402c-4bed-9838-652048267867")
    @Override
    public void setVisibility(VisibilityMode value) {
        setAttVal(((FeatureSmClass)getClassOf()).getVisibilityAtt(), value);
    }

    @objid ("d19c3950-f5d0-4f7c-96d5-7331bd4961d5")
    @Override
    public boolean isIsClass() {
        return (Boolean) getAttVal(((FeatureSmClass)getClassOf()).getIsClassAtt());
    }

    @objid ("4152d62e-6938-4906-800c-d8e20a3f4059")
    @Override
    public void setIsClass(boolean value) {
        setAttVal(((FeatureSmClass)getClassOf()).getIsClassAtt(), value);
    }

    @objid ("3534c43e-f550-42ca-b6a5-402385504c0b")
    @Override
    public boolean isIsAbstract() {
        return (Boolean) getAttVal(((FeatureSmClass)getClassOf()).getIsAbstractAtt());
    }

    @objid ("453d16ff-72de-45cf-8408-957dcb07c294")
    @Override
    public void setIsAbstract(boolean value) {
        setAttVal(((FeatureSmClass)getClassOf()).getIsAbstractAtt(), value);
    }

    @objid ("9fbf547b-5104-4a16-8ec0-15b415d70129")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("3d1f5ee9-bd15-4aab-bb78-a84b4a437073")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("7afeeaff-b38e-4c42-b876-dc08ad0517df")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitFeature(this);
    }

}
