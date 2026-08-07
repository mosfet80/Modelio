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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ControlFlow;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("bcf8c7a8-f5f2-4aa2-8d40-afaac0e29e40")
public class ControlFlowSmClass extends ActivityEdgeSmClass {
    @objid ("a20fe076-ba04-489d-b96c-a4997df0a8e4")
    public ControlFlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("73868e72-57b2-4c85-afc7-cfbed8465f5a")
    @Override
    public String getName() {
        return "ControlFlow";

    }

    @objid ("42ec431d-0c32-443f-8555-539a9c3277dd")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("686e3cfa-1922-4c1c-b0cb-01f68447b296")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ControlFlow.class;

    }

    @objid ("6d3bbbc3-5f50-4481-9c9c-f6ea839243cc")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e08bc0f2-8aae-46e7-b195-ad32b760d7b1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9ab379fb-550a-40bd-aed4-c18d2858614e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityEdge.MQNAME);
        this.registerFactory(new ControlFlowObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("4c5e521d-0d79-4039-a2b2-dfb38402e7bd")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("63f8d176-7c1a-43d6-b93d-bfb1902e73d0")
    private static class ControlFlowObjectFactory implements ISmObjectFactory {
        @objid ("3df020e4-70f3-43ad-8ed4-e529c222b4d0")
        private ControlFlowSmClass smClass;

        @objid ("f9ff01c6-5fb4-4582-a248-8d4eae4ca2ff")
        public ControlFlowObjectFactory(ControlFlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("95b64dd7-8033-45f2-8bbc-0e9b773f67da")
        @Override
        public ISmObjectData createData() {
            return new ControlFlowData(this.smClass);
        }

        @objid ("e3e55b86-d701-4d05-a598-964c96f8044b")
        @Override
        public SmObjectImpl createImpl() {
            return new ControlFlowImpl();
        }

    }

}
