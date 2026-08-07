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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.commonBehaviors.ParameterEffectKind;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.uml.statik.PassingMode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00180e5c-c4bf-1fd8-97fe-001ec947cd2a")
public class ParameterImpl extends UmlModelElementImpl implements Parameter {
    @objid ("b94c5030-6f6b-41ab-babb-7271d8812dc0")
    @Override
    public PassingMode getParameterPassing() {
        return (PassingMode) getAttVal(((ParameterSmClass)getClassOf()).getParameterPassingAtt());
    }

    @objid ("5eeb6d77-df6d-415a-a537-44a70e74fd2c")
    @Override
    public void setParameterPassing(PassingMode value) {
        setAttVal(((ParameterSmClass)getClassOf()).getParameterPassingAtt(), value);
    }

    @objid ("8a099030-770b-45ef-a6b4-e327c3cf1153")
    @Override
    public String getMultiplicityMin() {
        return (String) getAttVal(((ParameterSmClass)getClassOf()).getMultiplicityMinAtt());
    }

    @objid ("8873b93e-38f5-4374-b0da-b64ef38034c0")
    @Override
    public void setMultiplicityMin(String value) {
        setAttVal(((ParameterSmClass)getClassOf()).getMultiplicityMinAtt(), value);
    }

    @objid ("ba7903c2-4b2d-44f3-91bd-a22d1adceb82")
    @Override
    public String getMultiplicityMax() {
        return (String) getAttVal(((ParameterSmClass)getClassOf()).getMultiplicityMaxAtt());
    }

    @objid ("ffeab85f-2a14-4a87-847b-0079afef11c6")
    @Override
    public void setMultiplicityMax(String value) {
        setAttVal(((ParameterSmClass)getClassOf()).getMultiplicityMaxAtt(), value);
    }

    @objid ("f4ac0f16-5315-44f2-9de9-2bcde92cded2")
    @Override
    public String getTypeConstraint() {
        return (String) getAttVal(((ParameterSmClass)getClassOf()).getTypeConstraintAtt());
    }

    @objid ("f1d9523c-70f5-4977-ae7a-22bcd8cad761")
    @Override
    public void setTypeConstraint(String value) {
        setAttVal(((ParameterSmClass)getClassOf()).getTypeConstraintAtt(), value);
    }

    @objid ("f146af37-3781-44c2-94d0-249bba3a049a")
    @Override
    public String getDefaultValue() {
        return (String) getAttVal(((ParameterSmClass)getClassOf()).getDefaultValueAtt());
    }

    @objid ("716ab53e-0c63-424b-b0f7-5522e4891ace")
    @Override
    public void setDefaultValue(String value) {
        setAttVal(((ParameterSmClass)getClassOf()).getDefaultValueAtt(), value);
    }

    @objid ("b80d3694-4e5b-46bd-b2f7-4f38ecea9a28")
    @Override
    public boolean isIsOrdered() {
        return (Boolean) getAttVal(((ParameterSmClass)getClassOf()).getIsOrderedAtt());
    }

    @objid ("c3d9edde-5bc2-4c30-881e-0f9a5d76771e")
    @Override
    public void setIsOrdered(boolean value) {
        setAttVal(((ParameterSmClass)getClassOf()).getIsOrderedAtt(), value);
    }

    @objid ("d04c32cb-0a8d-4324-8c9e-7052ac86f2f2")
    @Override
    public boolean isIsUnique() {
        return (Boolean) getAttVal(((ParameterSmClass)getClassOf()).getIsUniqueAtt());
    }

    @objid ("73ab77dd-2306-4db7-98d5-8002302645c9")
    @Override
    public void setIsUnique(boolean value) {
        setAttVal(((ParameterSmClass)getClassOf()).getIsUniqueAtt(), value);
    }

    @objid ("e33bf546-40b1-43d4-a049-25b25483d58f")
    @Override
    public boolean isIsException() {
        return (Boolean) getAttVal(((ParameterSmClass)getClassOf()).getIsExceptionAtt());
    }

    @objid ("1c6a4493-b28f-4bb1-8e3a-6d1b5f063541")
    @Override
    public void setIsException(boolean value) {
        setAttVal(((ParameterSmClass)getClassOf()).getIsExceptionAtt(), value);
    }

    @objid ("b5b176ef-76b5-4156-ae5e-2204b6125edf")
    @Override
    public boolean isIsStream() {
        return (Boolean) getAttVal(((ParameterSmClass)getClassOf()).getIsStreamAtt());
    }

    @objid ("e330c2f7-6502-4c70-956b-11a335cdf9d8")
    @Override
    public void setIsStream(boolean value) {
        setAttVal(((ParameterSmClass)getClassOf()).getIsStreamAtt(), value);
    }

    @objid ("ab87f807-966b-4817-a46e-b80ea93daa2f")
    @Override
    public ParameterEffectKind getEffect() {
        return (ParameterEffectKind) getAttVal(((ParameterSmClass)getClassOf()).getEffectAtt());
    }

    @objid ("73f40db4-c99c-4712-8ae5-ecf905f00322")
    @Override
    public void setEffect(ParameterEffectKind value) {
        setAttVal(((ParameterSmClass)getClassOf()).getEffectAtt(), value);
    }

    @objid ("bc0c542d-564f-49f1-9352-eb90bf35097e")
    @Override
    public GeneralClass getType() {
        Object obj = getDepVal(((ParameterSmClass)getClassOf()).getTypeDep());
        return (obj instanceof GeneralClass)? (GeneralClass)obj : null;
    }

    @objid ("ecfed9b0-f4ca-4429-a32d-f11eadbb5b1e")
    @Override
    public void setType(GeneralClass value) {
        appendDepVal(((ParameterSmClass)getClassOf()).getTypeDep(), (SmObjectImpl)value);
    }

    @objid ("caba2446-2824-4cd6-a357-d1b2c6f7e6d7")
    @Override
    public Operation getComposed() {
        Object obj = getDepVal(((ParameterSmClass)getClassOf()).getComposedDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("710e1d15-f562-45fc-9c97-2fd3bfa5c34d")
    @Override
    public void setComposed(Operation value) {
        appendDepVal(((ParameterSmClass)getClassOf()).getComposedDep(), (SmObjectImpl)value);
    }

    @objid ("cf6e332b-f3f7-4262-bc06-4cdac4205cae")
    @Override
    public EList<Pin> getMatching() {
        return new SmList<>(this, ((ParameterSmClass)getClassOf()).getMatchingDep());
    }

    @objid ("5733c994-24d6-4307-b975-321027fbe426")
    @Override
    public <T extends Pin> List<T> getMatching(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Pin element : getMatching()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a54ae265-ac92-4e67-bc8c-40264c949a5d")
    @Override
    public EList<Signal> getSRepresentation() {
        return new SmList<>(this, ((ParameterSmClass)getClassOf()).getSRepresentationDep());
    }

    @objid ("8a34a84b-eb1f-4f2c-9c25-768ebfa63162")
    @Override
    public <T extends Signal> List<T> getSRepresentation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Signal element : getSRepresentation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4d6385e5-3d6f-4d2d-a941-d9b8631e5252")
    @Override
    public Operation getReturned() {
        Object obj = getDepVal(((ParameterSmClass)getClassOf()).getReturnedDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("4dc342dd-5b10-47cd-a4e1-0c10167cc47e")
    @Override
    public void setReturned(Operation value) {
        appendDepVal(((ParameterSmClass)getClassOf()).getReturnedDep(), (SmObjectImpl)value);
    }

    @objid ("6992f234-2167-49f1-8699-61f24c75372c")
    @Override
    public EList<BehaviorParameter> getBehaviorParam() {
        return new SmList<>(this, ((ParameterSmClass)getClassOf()).getBehaviorParamDep());
    }

    @objid ("b4b8c80b-9f01-4da4-a7d8-4bd1f33bdafd")
    @Override
    public <T extends BehaviorParameter> List<T> getBehaviorParam(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BehaviorParameter element : getBehaviorParam()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f0f7d8aa-ca52-408d-b253-4c312558ed8a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Composed
        obj = (SmObjectImpl)this.getDepVal(((ParameterSmClass)getClassOf()).getComposedDep());
        if (obj != null)
          return obj;
        // Returned
        obj = (SmObjectImpl)this.getDepVal(((ParameterSmClass)getClassOf()).getReturnedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("6113a981-1192-4798-9ff6-771d4005130b")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Composed
        dep = ((ParameterSmClass)getClassOf()).getComposedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Returned
        dep = ((ParameterSmClass)getClassOf()).getReturnedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("89b696ab-c4c3-4f10-8730-d8c27b46d463")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitParameter(this);
    }

}
