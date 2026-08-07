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
package org.modelio.archimate.metamodel.impl.layers.technology.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("9fa18161-e64e-42c2-aa61-0a9ae289c539")
public class NodeSmClass extends TechnologyInternalActiveStructureElementSmClass {
    @objid ("3cdd927f-8c0b-4f67-9911-d0c3cd79ceee")
    public NodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e42c3064-b1f3-48f5-9952-2a4ac56ce449")
    @Override
    public String getName() {
        return "Node";

    }

    @objid ("69ee289c-4199-44f9-9e6f-fdb5e846431d")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("2e1ab1f2-8899-4ae8-b1c0-90cd0fba75bf")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Node.class;

    }

    @objid ("b5c4699c-fd29-4db3-a10f-cc5cf27ecf88")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("53087e8a-e7ce-478d-943a-1d7cda0bc721")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0e5d4773-03eb-42be-b83e-f5d44d078dff")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyInternalActiveStructureElement.MQNAME);
        this.registerFactory(new NodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("4aea4ffa-0ab9-4796-98a6-6aaa15e7fa80")
    private static class NodeObjectFactory implements ISmObjectFactory {
        @objid ("8ac84e04-c52d-4468-9fc1-2594cee67877")
        private NodeSmClass smClass;

        @objid ("2ae39268-6d32-46bf-9cb7-b57bce224240")
        public NodeObjectFactory(NodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b097f504-3d32-4903-8313-4308b51c2c08")
        @Override
        public ISmObjectData createData() {
            return new NodeData(this.smClass);
        }

        @objid ("88fdbd7e-d707-4a96-a328-2eb1f5f7cf9c")
        @Override
        public SmObjectImpl createImpl() {
            return new NodeImpl();
        }

    }

}
