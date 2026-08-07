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
import org.modelio.metamodel.uml.behavior.activityModel.ForkJoinNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0033e794-c4bf-1fd8-97fe-001ec947cd2a")
public class ForkJoinNodeImpl extends ControlNodeImpl implements ForkJoinNode {
    @objid ("98580f5d-e946-4148-a4cb-b40723d9d579")
    @Override
    public boolean isIsCombineDuplicate() {
        return (Boolean) getAttVal(((ForkJoinNodeSmClass)getClassOf()).getIsCombineDuplicateAtt());
    }

    @objid ("bcc21416-c8ea-4fd9-8c9c-143d0ff8e99b")
    @Override
    public void setIsCombineDuplicate(boolean value) {
        setAttVal(((ForkJoinNodeSmClass)getClassOf()).getIsCombineDuplicateAtt(), value);
    }

    @objid ("f5f1a71c-b255-498a-a8c7-7ee2439c81f3")
    @Override
    public String getJoinSpec() {
        return (String) getAttVal(((ForkJoinNodeSmClass)getClassOf()).getJoinSpecAtt());
    }

    @objid ("52be9f5f-0daf-40ef-af39-fe34bbb0d2dc")
    @Override
    public void setJoinSpec(String value) {
        setAttVal(((ForkJoinNodeSmClass)getClassOf()).getJoinSpecAtt(), value);
    }

    @objid ("2db73cd1-ef88-48d2-a592-3b232d2b3e41")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("bdd47d8a-0083-4963-b79d-5a05f4d381e8")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("866cf0a9-ceb3-4b9c-8b71-6673bad30f6d")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitForkJoinNode(this);
    }

}
