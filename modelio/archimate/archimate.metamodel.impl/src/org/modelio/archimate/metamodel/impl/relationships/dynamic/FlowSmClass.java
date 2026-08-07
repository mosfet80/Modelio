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
package org.modelio.archimate.metamodel.impl.relationships.dynamic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.dynamic.DynamicRelationship;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("9d805085-c894-4aee-9f47-6374d68434d8")
public class FlowSmClass extends DynamicRelationshipSmClass {
    @objid ("b5d663f5-72a7-46d8-855f-ed4991effa5b")
    public FlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("36070911-a61f-4d63-a58b-f3534a93ed49")
    @Override
    public String getName() {
        return "Flow";

    }

    @objid ("75c67c11-d55e-4d83-9c21-5cd90fdfdf41")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("cb382bc7-8bb0-499e-b3f7-648bc43c75e5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Flow.class;

    }

    @objid ("4b40f7b9-9082-4015-9535-8b54b15e02f6")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("74a6fd1b-7436-452f-8f7e-4c8b2c8dddd0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("101cea12-ed28-4ad9-8bb5-b340614d6f1b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(DynamicRelationship.MQNAME);
        this.registerFactory(new FlowObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("35823c4f-ddeb-4d4e-8ecb-5b4c8fd906df")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("bf4846e4-26df-4663-9cfd-d3e2e4d5cc99")
    private static class FlowObjectFactory implements ISmObjectFactory {
        @objid ("bedde8e4-ce34-45f9-9055-994725e36288")
        private FlowSmClass smClass;

        @objid ("473c94ae-d7cb-44e2-994e-29c68b5982da")
        public FlowObjectFactory(FlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1c42d9cc-ff83-4d12-88c7-f867d13d02c6")
        @Override
        public ISmObjectData createData() {
            return new FlowData(this.smClass);
        }

        @objid ("32989283-959f-4705-acc3-a1106598969c")
        @Override
        public SmObjectImpl createImpl() {
            return new FlowImpl();
        }

    }

}
