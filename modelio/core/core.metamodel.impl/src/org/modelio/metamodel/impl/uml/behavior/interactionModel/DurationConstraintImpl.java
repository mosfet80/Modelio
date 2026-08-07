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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.ConstraintImpl;
import org.modelio.metamodel.uml.behavior.interactionModel.DurationConstraint;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0043f6ca-c4bf-1fd8-97fe-001ec947cd2a")
public class DurationConstraintImpl extends ConstraintImpl implements DurationConstraint {
    @objid ("1e2c2f0e-80bb-4e66-a352-df52720f8a24")
    @Override
    public String getDurationMin() {
        return (String) getAttVal(((DurationConstraintSmClass)getClassOf()).getDurationMinAtt());
    }

    @objid ("0d8319c2-fc90-4882-ab6e-88e7fb335a0c")
    @Override
    public void setDurationMin(String value) {
        setAttVal(((DurationConstraintSmClass)getClassOf()).getDurationMinAtt(), value);
    }

    @objid ("a979c2e6-0571-4deb-b39b-a7ec9723ba7c")
    @Override
    public String getDurationMax() {
        return (String) getAttVal(((DurationConstraintSmClass)getClassOf()).getDurationMaxAtt());
    }

    @objid ("bc32e039-caec-42a3-8141-35faee657368")
    @Override
    public void setDurationMax(String value) {
        setAttVal(((DurationConstraintSmClass)getClassOf()).getDurationMaxAtt(), value);
    }

    @objid ("e35c049a-ed07-497e-883e-8222fe6ef632")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("578674cb-1263-43d2-86ad-7961e6a439f7")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("4a39aaf4-7060-4419-889a-9919b7249708")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitDurationConstraint(this);
    }

}
