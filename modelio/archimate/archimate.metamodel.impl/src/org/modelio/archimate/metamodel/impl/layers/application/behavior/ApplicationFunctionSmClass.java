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
package org.modelio.archimate.metamodel.impl.layers.application.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("90a32b0d-2034-4691-a218-e68d1b967f6a")
public class ApplicationFunctionSmClass extends ApplicationInternalBehaviorElementSmClass {
    @objid ("0d3771b8-3b64-44c7-a737-06b27efe6df3")
    public ApplicationFunctionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("37b4e1b6-acb6-4a53-ade9-0787854389c9")
    @Override
    public String getName() {
        return "ApplicationFunction";

    }

    @objid ("d3ba18c7-e49a-4c4a-bf09-b85ab7bf2b71")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("27fd4b8c-7964-40e1-b065-ea0b619ced22")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationFunction.class;

    }

    @objid ("68d64f95-5bdb-41be-940f-426deaefa76a")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("985409c4-bd89-4d0c-87ab-40dc4792de26")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("cc3d32fb-2e8c-4f1f-9df3-52f5dde0ea15")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ApplicationInternalBehaviorElement.MQNAME);
        this.registerFactory(new ApplicationFunctionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("934bac1c-e409-4143-afb8-a1c0ee81bafb")
    private static class ApplicationFunctionObjectFactory implements ISmObjectFactory {
        @objid ("832b9154-2375-4234-9091-ceac5dafbb74")
        private ApplicationFunctionSmClass smClass;

        @objid ("248f80e3-6c27-4e2b-b589-3fed7207f4d6")
        public ApplicationFunctionObjectFactory(ApplicationFunctionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a9ce8d24-f320-44a5-bc1b-4fb2c4053bd5")
        @Override
        public ISmObjectData createData() {
            return new ApplicationFunctionData(this.smClass);
        }

        @objid ("b221a46d-40c4-4b74-91e6-871c0ab5d875")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationFunctionImpl();
        }

    }

}
