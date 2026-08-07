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
import org.modelio.metamodel.bpmn.activities.BpmnScriptTask;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00822bd4-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnScriptTaskImpl extends BpmnTaskImpl implements BpmnScriptTask {
    @objid ("0894b65a-aef4-41d4-bf54-bc6ab479d4f6")
    @Override
    public String getScriptLanguage() {
        return (String) getAttVal(((BpmnScriptTaskSmClass)getClassOf()).getScriptLanguageAtt());
    }

    @objid ("7dbbd6bf-6697-490a-948a-08879f218a5e")
    @Override
    public void setScriptLanguage(String value) {
        setAttVal(((BpmnScriptTaskSmClass)getClassOf()).getScriptLanguageAtt(), value);
    }

    @objid ("18e92c6a-a170-4829-8bb3-0e25efc80108")
    @Override
    public String getScript() {
        return (String) getAttVal(((BpmnScriptTaskSmClass)getClassOf()).getScriptAtt());
    }

    @objid ("db5e3d88-804b-4c6f-bbc5-eb651324e531")
    @Override
    public void setScript(String value) {
        setAttVal(((BpmnScriptTaskSmClass)getClassOf()).getScriptAtt(), value);
    }

    @objid ("a0d05a18-27b9-43c8-b936-91c2fcd3d818")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("3579fe90-e957-4323-a006-7256c23d6999")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("18f5cfd7-b837-41a8-86a3-180e7968e350")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnScriptTask(this);
    }

}
