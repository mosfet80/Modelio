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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateMachine;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a16e3d3b-8dda-4d6c-be75-819b122d2f99")
public class RegionSmClass extends UmlModelElementSmClass {
    @objid ("fc682809-b2d8-4e08-9959-3655032fc80b")
    private SmDependency parentDep;

    @objid ("bdec635b-b111-482b-99c5-dd9c68870997")
    private SmDependency representedDep;

    @objid ("8ec85644-2c25-4f53-a81a-9792b99a5720")
    private SmDependency subDep;

    @objid ("a58254d1-ccb8-4e84-8a73-5e41ae3d4127")
    public RegionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c5747191-719a-4865-91f1-a480b1d1a08a")
    @Override
    public String getName() {
        return "Region";

    }

    @objid ("7f2f7f71-9152-426a-a819-d73522d751b8")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("69b46625-407b-4d38-abd6-cad98ceff946")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Region.class;

    }

    @objid ("b4177a0d-63d8-4fa9-94bc-562c0bee2664")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("27993281-366a-4663-9bee-dca580217203")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e867e97d-d2d7-4805-8471-da9cc44d336f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new RegionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.parentDep = new ParentSmDependency();
        this.parentDep.init("Parent", this, metamodel.getMClass(State.MQNAME), 0, 1 );
        registerDependency(this.parentDep);

        this.representedDep = new RepresentedSmDependency();
        this.representedDep.init("Represented", this, metamodel.getMClass(StateMachine.MQNAME), 0, 1 );
        registerDependency(this.representedDep);

        this.subDep = new SubSmDependency();
        this.subDep.init("Sub", this, metamodel.getMClass(StateVertex.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.subDep);

    }

    @objid ("681467ba-cd98-4a83-bfe3-c8d2a9918e7d")
    public SmDependency getParentDep() {
        if (this.parentDep == null) {
        	this.parentDep = this.getDependencyDef("Parent");
        }
        return this.parentDep;
    }

    @objid ("4510ebaa-fe0c-4655-a03d-9304a98e0ad6")
    public SmDependency getRepresentedDep() {
        if (this.representedDep == null) {
        	this.representedDep = this.getDependencyDef("Represented");
        }
        return this.representedDep;
    }

    @objid ("b28f4438-2db3-4659-a4c1-8675b132cc86")
    public SmDependency getSubDep() {
        if (this.subDep == null) {
        	this.subDep = this.getDependencyDef("Sub");
        }
        return this.subDep;
    }

    @objid ("2e21f7ac-30e9-4716-ab21-db670bffc831")
    private static class RegionObjectFactory implements ISmObjectFactory {
        @objid ("1762391a-00d2-4633-b943-543652dd9e74")
        private RegionSmClass smClass;

        @objid ("0151d102-53b9-4ed7-9196-f2034f5bb052")
        public RegionObjectFactory(RegionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("76a67d15-d322-47d4-ba4c-bef35d5148db")
        @Override
        public ISmObjectData createData() {
            return new RegionData(this.smClass);
        }

        @objid ("71ae5571-7d77-4086-95c9-1e24e954b782")
        @Override
        public SmObjectImpl createImpl() {
            return new RegionImpl();
        }

    }

    @objid ("13ba5fdd-175a-4474-8e5d-4c54addd0c42")
    public static class ParentSmDependency extends SmSingleDependency {
        @objid ("5a624522-3e7b-46a2-9eae-9ac80273c0a3")
        private SmDependency symetricDep;

        @objid ("0a635e41-133c-4945-9286-ef8a92a7c550")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((RegionData) data).mParent;
        }

        @objid ("2bf19584-a4bc-4346-ab69-414f3d13a431")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((RegionData) data).mParent = value;
        }

        @objid ("9f624b90-ce95-4523-a23f-7f63d18f5169")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getOwnedRegionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c2e349ec-e394-4f5c-bb80-4f07b3535102")
    public static class RepresentedSmDependency extends SmSingleDependency {
        @objid ("7a2e49c6-dfd2-4553-8b1e-06d3ed298553")
        private SmDependency symetricDep;

        @objid ("5c852841-df69-4a65-bafb-80b7062d184a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((RegionData) data).mRepresented;
        }

        @objid ("61e91378-1ab2-4460-89b9-3dc0c75192a9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((RegionData) data).mRepresented = value;
        }

        @objid ("5eab2415-cb4f-4d6a-9cec-06c6c6089b84")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateMachineSmClass)this.getTarget()).getTopDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("27ad0f58-5236-4ffe-8749-8bd4e98b0317")
    public static class SubSmDependency extends SmMultipleDependency {
        @objid ("d52637e4-58bc-4659-bc4c-ade184a6b2d6")
        private SmDependency symetricDep;

        @objid ("447fe8f4-1b29-4d98-a10c-84e0044815e3")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((RegionData)data).mSub != null)? ((RegionData)data).mSub:SmMultipleDependency.EMPTY;
        }

        @objid ("be6d9046-2c2f-400e-b741-d85362fae86c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((RegionData) data).mSub = values;

        }

        @objid ("8f42a7d7-ec2e-4f41-b86a-39f367f20144")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateVertexSmClass)this.getTarget()).getParentDep();
            }
            return this.symetricDep;

        }

    }

}
