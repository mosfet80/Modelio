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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core.generic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.core.generic.InternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("7bdbfe0e-79a9-48c7-b986-7dd70f53d383")
public class InternalBehaviorElementSmClass extends BehaviorElementSmClass {
    @objid ("a01bfdf8-4f87-4734-af46-c4a9a42cb42b")
    public InternalBehaviorElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8d7b6749-5dfa-4a02-a3fa-479c513dd3dd")
    @Override
    public String getName() {
        return "InternalBehaviorElement";

    }

    @objid ("9de6c53d-f276-4ae7-bd28-1ca8247ba00c")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("aab941de-ae85-4439-967f-4a8c9ef80d67")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InternalBehaviorElement.class;

    }

    @objid ("461771f2-a2bf-4ec6-93d0-1bb06e9aa7da")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("bf357af1-c923-495b-9bbc-85692b15e0f1")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("c6cad352-0094-4242-bcff-7647aac5cdef")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorElement.MQNAME);
        this.registerFactory(new InternalBehaviorElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("daa0b559-c7c1-4231-a368-6eb882804cb9")
    private static class InternalBehaviorElementObjectFactory implements ISmObjectFactory {
        @objid ("8f3b6e25-ff81-45f6-92fb-b0d0788e5c24")
        private InternalBehaviorElementSmClass smClass;

        @objid ("f6f8c128-ddcc-44fc-bede-dc1c67425d52")
        public InternalBehaviorElementObjectFactory(InternalBehaviorElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("195e2962-97c3-461e-b684-c914df859f6d")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("6ab87af9-ae89-462f-8866-96cffed62718")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
