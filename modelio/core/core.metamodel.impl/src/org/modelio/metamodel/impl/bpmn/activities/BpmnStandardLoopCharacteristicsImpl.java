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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnStandardLoopCharacteristics;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0083ce8a-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnStandardLoopCharacteristicsImpl extends BpmnLoopCharacteristicsImpl implements BpmnStandardLoopCharacteristics {
    @objid ("68513e41-a3e0-4359-bce2-a430800bcca9")
    @Override
    public boolean isTestBefore() {
        return (Boolean) getAttVal(((BpmnStandardLoopCharacteristicsSmClass)getClassOf()).getTestBeforeAtt());
    }

    @objid ("c4b5dcc4-dd9a-4c73-b3c3-e9b6376f794f")
    @Override
    public void setTestBefore(boolean value) {
        setAttVal(((BpmnStandardLoopCharacteristicsSmClass)getClassOf()).getTestBeforeAtt(), value);
    }

    @objid ("cf933701-9f59-4ed5-ae75-7ca4daf95ca6")
    @Override
    public String getLoopCondition() {
        return (String) getAttVal(((BpmnStandardLoopCharacteristicsSmClass)getClassOf()).getLoopConditionAtt());
    }

    @objid ("6f4fbfb2-390d-41fa-9cd6-d8d6133d930f")
    @Override
    public void setLoopCondition(String value) {
        setAttVal(((BpmnStandardLoopCharacteristicsSmClass)getClassOf()).getLoopConditionAtt(), value);
    }

    @objid ("7c9c3a1a-8fa4-4c2e-bdfb-c8d632f1376f")
    @Override
    public String getLoopMaximum() {
        return (String) getAttVal(((BpmnStandardLoopCharacteristicsSmClass)getClassOf()).getLoopMaximumAtt());
    }

    @objid ("50e697d1-e481-45f5-afc4-092d17b3dd75")
    @Override
    public void setLoopMaximum(String value) {
        setAttVal(((BpmnStandardLoopCharacteristicsSmClass)getClassOf()).getLoopMaximumAtt(), value);
    }

    @objid ("05483501-3995-4b97-b0a1-4b48c3429063")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("c3c409d8-4ef5-455b-a4bc-e80451176c45")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("3e59f877-dac6-4c2a-8c34-0c14406d1e11")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnStandardLoopCharacteristics(this);
    }

}
