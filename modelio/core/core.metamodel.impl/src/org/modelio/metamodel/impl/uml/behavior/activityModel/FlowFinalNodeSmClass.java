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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.FinalNode;
import org.modelio.metamodel.uml.behavior.activityModel.FlowFinalNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("245b4da0-6037-452b-8cc7-3a353155b4f3")
public class FlowFinalNodeSmClass extends FinalNodeSmClass {
    @objid ("2297aa0f-df74-4a14-9f74-a2a9592cf74c")
    public FlowFinalNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1ca37036-f46d-4b88-abcd-70e84f07cbb7")
    @Override
    public String getName() {
        return "FlowFinalNode";

    }

    @objid ("8f2e33c2-2641-4985-93ca-6d7c1e178d77")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("34df9101-ea52-4911-91c4-4d1521a89ffb")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return FlowFinalNode.class;

    }

    @objid ("a18c0361-0317-4e84-87ec-559acc75aa2d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("2b61dc99-4ddd-433a-a19f-40de3cd1c98f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("c6f1e1c1-1dd1-4521-b2e1-1273cce7a54e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(FinalNode.MQNAME);
        this.registerFactory(new FlowFinalNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("d5afa96e-6488-4ff7-a60d-2afc0630bec1")
    private static class FlowFinalNodeObjectFactory implements ISmObjectFactory {
        @objid ("bd3b5379-4657-413a-b114-487ed505b0a7")
        private FlowFinalNodeSmClass smClass;

        @objid ("890618af-675f-43ea-8bd9-f603337a9065")
        public FlowFinalNodeObjectFactory(FlowFinalNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c1e1beba-ae59-45d7-9e42-769fab2080e0")
        @Override
        public ISmObjectData createData() {
            return new FlowFinalNodeData(this.smClass);
        }

        @objid ("f6559192-0712-4f3d-b59b-59bbeec383fd")
        @Override
        public SmObjectImpl createImpl() {
            return new FlowFinalNodeImpl();
        }

    }

}
