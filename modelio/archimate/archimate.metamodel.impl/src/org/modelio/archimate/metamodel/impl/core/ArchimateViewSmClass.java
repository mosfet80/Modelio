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
package org.modelio.archimate.metamodel.impl.core;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.impl.core.structure.ModelSmClass;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.impl.diagrams.AbstractDiagramSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1b97e43f-0821-4f7a-a4db-27a2f32f252d")
public class ArchimateViewSmClass extends AbstractDiagramSmClass {
    @objid ("947c0033-c760-4877-a487-152bf4b1593f")
    private SmDependency contextDep;

    @objid ("496ea342-ea21-40c7-be78-8daa6af2cf19")
    public ArchimateViewSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6759b6e0-af76-4424-ba2a-63e2c18cff7a")
    @Override
    public String getName() {
        return "ArchimateView";

    }

    @objid ("665adc0a-853d-4e84-8f5e-3b1aeb30db9b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("a7657d46-ac61-4ede-82ab-bea6acb55a0b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ArchimateView.class;

    }

    @objid ("bc8c1bf7-8144-4623-b38d-e75f3401865c")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("aee502f3-ae29-470b-a04d-00150f8d283a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("b9011a3f-912e-4fb6-b68d-6a5169c9fde6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractDiagram.MQNAME);
        this.registerFactory(new ArchimateViewObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.contextDep = new ContextSmDependency();
        this.contextDep.init("context", this, metamodel.getMClass(Model.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.contextDep);

    }

    @objid ("819d999b-be7e-4f44-b81f-964bcf6f6ad8")
    public SmDependency getContextDep() {
        if (this.contextDep == null) {
        	this.contextDep = this.getDependencyDef("context");
        }
        return this.contextDep;
    }

    @objid ("9180a487-7960-436c-bf1a-4430b114c2fa")
    private static class ArchimateViewObjectFactory implements ISmObjectFactory {
        @objid ("fae1edc9-7000-408f-ae4a-7d68978d8839")
        private ArchimateViewSmClass smClass;

        @objid ("3b196b74-366c-46f3-b43a-92c6df8dc39e")
        public ArchimateViewObjectFactory(ArchimateViewSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("bb8b639d-e8ed-46ed-881b-6fc219e39697")
        @Override
        public ISmObjectData createData() {
            return new ArchimateViewData(this.smClass);
        }

        @objid ("0245519b-e9a0-418d-b31f-def270fde12a")
        @Override
        public SmObjectImpl createImpl() {
            return new ArchimateViewImpl();
        }

    }

    @objid ("eaba7d04-6050-4a84-8f89-84bc5ef19649")
    public static class ContextSmDependency extends SmSingleDependency {
        @objid ("8bebab52-14a6-48a8-9ab4-3e7f6a487473")
        private SmDependency symetricDep;

        @objid ("5ef2ff8b-3536-472f-acca-829314e81bc9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ArchimateViewData) data).mContext;
        }

        @objid ("a8bd61fb-ef6f-41ad-9f16-14b22a162602")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ArchimateViewData) data).mContext = value;
        }

        @objid ("c637a29b-fc59-49af-8b23-ec2010f2f5d0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ModelSmClass)this.getTarget()).getReferencedByViewDep();
            }
            return this.symetricDep;

        }

    }

}
