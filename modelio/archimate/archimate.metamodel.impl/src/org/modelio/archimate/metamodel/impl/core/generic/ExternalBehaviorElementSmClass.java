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
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("89e21ccc-40de-45e9-98fb-e97c5f6a5228")
public class ExternalBehaviorElementSmClass extends BehaviorElementSmClass {
    @objid ("7a9b8dd2-00a9-40ac-940d-de4b3f488a47")
    public ExternalBehaviorElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("dca9cea8-3cd6-4f99-b56d-cbf0684018aa")
    @Override
    public String getName() {
        return "ExternalBehaviorElement";

    }

    @objid ("4bd6e0e4-56a1-40c2-85a7-f1d957044db2")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("2bee9dfd-9380-4fdf-8c9c-b3b74ce4a078")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExternalBehaviorElement.class;

    }

    @objid ("aaf1d6a3-0633-462b-81c7-7b60802e98d2")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b29d80c4-d647-47fe-9316-f6e9cdc763aa")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("496ba0c4-b8a6-4d61-a01b-0b841157bb69")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorElement.MQNAME);
        this.registerFactory(new ExternalBehaviorElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("7f78750e-6d7f-40a0-a61d-31b4dafaad41")
    private static class ExternalBehaviorElementObjectFactory implements ISmObjectFactory {
        @objid ("89490cb9-7ac0-4148-98b7-04acf2190655")
        private ExternalBehaviorElementSmClass smClass;

        @objid ("dd85768d-608a-4ef3-96b6-7de2cbc3b7b1")
        public ExternalBehaviorElementObjectFactory(ExternalBehaviorElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6d209b9a-54ab-4cfc-9830-2fbd779d22dc")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("592d16fc-018d-4046-8d41-f19bb5cce617")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
