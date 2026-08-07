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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityGroup;
import org.modelio.metamodel.uml.behavior.activityModel.InterruptibleActivityRegion;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("cb39a5fc-03ec-4547-aa99-c2186f242602")
public class InterruptibleActivityRegionSmClass extends ActivityGroupSmClass {
    @objid ("d0b31601-135e-4308-9ba5-d8fc13961ce3")
    private SmDependency interruptingEdgeDep;

    @objid ("f5ac7851-c3ee-4af9-837d-b850dd17bdad")
    public InterruptibleActivityRegionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("12bada48-e6fd-44b8-bb40-00bbd5c51768")
    @Override
    public String getName() {
        return "InterruptibleActivityRegion";

    }

    @objid ("a3840537-d789-4c3e-8b94-758841033f1c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("2f888024-9752-4a9d-8842-09d25f108d2f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InterruptibleActivityRegion.class;

    }

    @objid ("6dc107a7-88e2-45fd-97c7-4d255abd41bf")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f76cedf3-b10c-49b6-9613-f019161bdfc0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d6192d09-5616-4d6c-8476-166f426de71a")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityGroup.MQNAME);
        this.registerFactory(new InterruptibleActivityRegionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.interruptingEdgeDep = new InterruptingEdgeSmDependency();
        this.interruptingEdgeDep.init("InterruptingEdge", this, metamodel.getMClass(ActivityEdge.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.interruptingEdgeDep);

    }

    @objid ("ac115f1a-4b7e-4036-8103-4d9339cc728b")
    public SmDependency getInterruptingEdgeDep() {
        if (this.interruptingEdgeDep == null) {
        	this.interruptingEdgeDep = this.getDependencyDef("InterruptingEdge");
        }
        return this.interruptingEdgeDep;
    }

    @objid ("46d710f4-8ddb-43f0-b3b1-6c9f5d5ea253")
    private static class InterruptibleActivityRegionObjectFactory implements ISmObjectFactory {
        @objid ("a62939be-d9ce-4e3f-bcdf-5e9bd073146c")
        private InterruptibleActivityRegionSmClass smClass;

        @objid ("5dd6265d-e9ed-4cff-b6e0-7c05ef7d83f0")
        public InterruptibleActivityRegionObjectFactory(InterruptibleActivityRegionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2d27187b-e628-4e66-b88f-48f54886a2fa")
        @Override
        public ISmObjectData createData() {
            return new InterruptibleActivityRegionData(this.smClass);
        }

        @objid ("dd3bb2ca-7962-4900-8902-42a2a3bbc8b7")
        @Override
        public SmObjectImpl createImpl() {
            return new InterruptibleActivityRegionImpl();
        }

    }

    @objid ("d82bf19d-0bad-4273-9d60-3eabf18f55ae")
    public static class InterruptingEdgeSmDependency extends SmMultipleDependency {
        @objid ("43624aac-22df-466c-8390-92f7588a35e8")
        private SmDependency symetricDep;

        @objid ("cddc5561-79a2-4a7c-8799-be9c2c252009")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InterruptibleActivityRegionData)data).mInterruptingEdge != null)? ((InterruptibleActivityRegionData)data).mInterruptingEdge:SmMultipleDependency.EMPTY;
        }

        @objid ("74e09720-36e0-4ee5-97aa-fcab97b9fca5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InterruptibleActivityRegionData) data).mInterruptingEdge = values;

        }

        @objid ("60b22d7e-5cd9-4986-b8bc-4128f49d3248")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityEdgeSmClass)this.getTarget()).getInterruptsDep();
            }
            return this.symetricDep;

        }

    }

}
