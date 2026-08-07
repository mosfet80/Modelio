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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.behavior.interactionModel.PartDecomposition;
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

@objid ("82b10d49-a5cd-435e-b05c-423ff2ffd4c4")
public class PartDecompositionSmClass extends InteractionUseSmClass {
    @objid ("94b81e2c-cb85-44f9-a025-ccc66de456b0")
    private SmDependency decomposedDep;

    @objid ("92c3f2fb-4724-49c4-8576-1f8109d16109")
    public PartDecompositionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f0a02631-e0f4-4887-8be4-763caa06e5af")
    @Override
    public String getName() {
        return "PartDecomposition";

    }

    @objid ("881c329a-e2cb-484b-9511-6260005e7359")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("05089d5c-1f42-489d-b887-df8948eb324e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return PartDecomposition.class;

    }

    @objid ("cd61147b-49b7-4d5d-8e41-91e723243dc1")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3a892148-e866-4b57-bb4f-4d6acc3e2d0d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("70fbc217-f38b-4b75-8169-2a919ffd0ed2")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(InteractionUse.MQNAME);
        this.registerFactory(new PartDecompositionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.decomposedDep = new DecomposedSmDependency();
        this.decomposedDep.init("Decomposed", this, metamodel.getMClass(Lifeline.MQNAME), 1, 1 );
        registerDependency(this.decomposedDep);

    }

    @objid ("c8488f0a-81e9-4cc4-8af3-c5b7b9e48818")
    public SmDependency getDecomposedDep() {
        if (this.decomposedDep == null) {
        	this.decomposedDep = this.getDependencyDef("Decomposed");
        }
        return this.decomposedDep;
    }

    @objid ("304b5079-bf70-44e9-81df-cad4e700a117")
    private static class PartDecompositionObjectFactory implements ISmObjectFactory {
        @objid ("250493b0-0576-4c14-ba61-60aed7eb48c9")
        private PartDecompositionSmClass smClass;

        @objid ("311ad011-db41-4de6-880d-916795bc4ce6")
        public PartDecompositionObjectFactory(PartDecompositionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("8c450063-6a16-456c-bd6a-596fbe122c82")
        @Override
        public ISmObjectData createData() {
            return new PartDecompositionData(this.smClass);
        }

        @objid ("04e8261c-6017-452f-a0e4-17ae32182a4a")
        @Override
        public SmObjectImpl createImpl() {
            return new PartDecompositionImpl();
        }

    }

    @objid ("60e78d47-1b29-473a-8fa4-473792cee9aa")
    public static class DecomposedSmDependency extends SmSingleDependency {
        @objid ("f2c9cc27-b877-4517-97da-8fe015a354cc")
        private SmDependency symetricDep;

        @objid ("43f434eb-359d-4be5-ad6e-3e793d0ff058")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PartDecompositionData) data).mDecomposed;
        }

        @objid ("c1f6dc6e-0520-47d2-8e5b-02302bdcb012")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PartDecompositionData) data).mDecomposed = value;
        }

        @objid ("c1ace444-4141-4925-a8cd-f97a6b8a7adb")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LifelineSmClass)this.getTarget()).getDecomposedAsDep();
            }
            return this.symetricDep;

        }

    }

}
