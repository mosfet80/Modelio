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
import org.modelio.metamodel.uml.infrastructure.Abstraction;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("71cbc9ba-e43d-4661-b852-efce11af5417")
public class AbstractionSmClass extends DependencySmClass {
    @objid ("56384dc8-eab5-4151-a4a7-1197440fdb14")
    private SmAttribute mappingAtt;

    @objid ("d1c47cfa-c21e-4121-a26d-8b6a45c205bd")
    public AbstractionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8c3bd2b1-c858-40b4-be83-2b60d406c684")
    @Override
    public String getName() {
        return "Abstraction";

    }

    @objid ("70eafbf7-339d-48ce-887c-cd29325ee2dd")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("42691abb-8bf9-4d6e-8fe4-5c3519404e1d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Abstraction.class;

    }

    @objid ("bedac840-e618-4750-8af3-b2e752f4c6e4")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("b3b8fbdb-5238-4ee2-bf32-0cc6643bb02c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("069ce264-9986-4b88-a007-60bb07ef4763")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Dependency.MQNAME);
        this.registerFactory(new AbstractionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.mappingAtt = new MappingSmAttribute();
        this.mappingAtt.init("Mapping", this, String.class );
        registerAttribute(this.mappingAtt);


        // Initialize and register the SmDependency

    }

    @objid ("d313270c-0c93-4865-9abe-c38e915b53e4")
    public SmAttribute getMappingAtt() {
        if (this.mappingAtt == null) {
        	this.mappingAtt = this.getAttributeDef("Mapping");
        }
        return this.mappingAtt;
    }

    @objid ("4172e4ad-05f7-44c6-ac60-7dde1201d4c3")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("158ccc0a-cc32-4135-a4b1-275229311823")
    private static class AbstractionObjectFactory implements ISmObjectFactory {
        @objid ("f07c9a20-cddd-4e86-bf2a-d718e2cd3d41")
        private AbstractionSmClass smClass;

        @objid ("4a5bd160-1a39-48d1-a5cc-97d732eb01d1")
        public AbstractionObjectFactory(AbstractionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9e4d93fa-6fa5-452e-8721-defc09b37765")
        @Override
        public ISmObjectData createData() {
            return new AbstractionData(this.smClass);
        }

        @objid ("f59705f8-6381-43e4-b02b-ad69f23165ef")
        @Override
        public SmObjectImpl createImpl() {
            return new AbstractionImpl();
        }

    }

    @objid ("f6bd0962-901c-496c-8d6d-e46a3a5a02a6")
    public static class MappingSmAttribute extends SmAttribute {
        @objid ("320db7b5-bf57-4361-9e00-e0d3e564c316")
        public Object getValue(ISmObjectData data) {
            return ((AbstractionData) data).mMapping;
        }

        @objid ("401467ac-bd30-41b9-b649-b4fc16ee1b79")
        public void setValue(ISmObjectData data, Object value) {
            ((AbstractionData) data).mMapping = value;
        }

    }

}
