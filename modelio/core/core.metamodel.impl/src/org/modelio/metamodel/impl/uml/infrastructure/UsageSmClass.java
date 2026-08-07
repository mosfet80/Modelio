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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.DependencySmClass;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.Usage;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("902edc6d-6529-4c52-936a-32642a134d20")
public class UsageSmClass extends DependencySmClass {
    @objid ("5424b9e3-4fc9-4b17-9757-6ce674a296f3")
    public UsageSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c27e5ee1-ed2f-4f23-8034-d58d7d865abc")
    @Override
    public String getName() {
        return "Usage";

    }

    @objid ("1e2f0bc7-6445-43a5-92a5-64350d426ec6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d32d0eea-e92f-4ba8-b557-895039ff2771")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Usage.class;

    }

    @objid ("4f9bd4a5-e7d6-4a8d-b72c-af5c087a2427")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("4a95784b-52cb-4abd-b517-fc427dcf73a1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("45280d66-d9d5-49c6-9ede-b53d22ca9eca")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Dependency.MQNAME);
        this.registerFactory(new UsageObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("2ce7da79-ebcb-4c43-9ebe-56fa9115c147")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("182c8855-4230-4580-80e3-51d3dda86b87")
    private static class UsageObjectFactory implements ISmObjectFactory {
        @objid ("2bcda295-26b6-45a2-99e1-822d4c7b70ec")
        private UsageSmClass smClass;

        @objid ("5a60ef82-58c1-4729-a457-4220e49fdc0c")
        public UsageObjectFactory(UsageSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4b95343b-96e1-4597-9265-807ad4a67125")
        @Override
        public ISmObjectData createData() {
            return new UsageData(this.smClass);
        }

        @objid ("b7aafcd8-2d23-466b-9d64-be7e0f66b9e6")
        @Override
        public SmObjectImpl createImpl() {
            return new UsageImpl();
        }

    }

}
