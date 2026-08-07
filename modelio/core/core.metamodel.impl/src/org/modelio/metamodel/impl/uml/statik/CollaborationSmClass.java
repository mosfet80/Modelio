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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("35b0920b-939c-4bb9-8b77-434d6f784cd3")
public class CollaborationSmClass extends NameSpaceSmClass {
    @objid ("da607ab8-739c-4c65-8d8c-25a716dfd625")
    private SmAttribute isConcurrentAtt;

    @objid ("a33a1763-e504-46cf-932d-22c037bda27f")
    private SmDependency oRepresentedDep;

    @objid ("f1191eaa-d998-4b51-9930-fcbede17e7cd")
    private SmDependency bRepresentedDep;

    @objid ("38703ccb-d53e-4c59-9bd1-59ffbd1766ad")
    private SmDependency occurrenceDep;

    @objid ("8408a0a8-92ab-4f0f-b07e-3d6cb743c984")
    public CollaborationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("21c96045-7482-4164-b073-43734265706d")
    @Override
    public String getName() {
        return "Collaboration";

    }

    @objid ("eef76e61-8ea7-448d-8db1-66076193ca2b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("116b11aa-d051-4c66-8aef-eb81de3613d6")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Collaboration.class;

    }

    @objid ("625eae7f-4aa2-429f-8534-d7a3230b2c9a")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("39e2acb4-6ae4-4e99-a6dc-6fbcd86cff60")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("50c5e01e-be12-4d17-91e7-033e4b3e8310")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(NameSpace.MQNAME);
        this.registerFactory(new CollaborationObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isConcurrentAtt = new IsConcurrentSmAttribute();
        this.isConcurrentAtt.init("IsConcurrent", this, Boolean.class );
        registerAttribute(this.isConcurrentAtt);


        // Initialize and register the SmDependency
        this.oRepresentedDep = new ORepresentedSmDependency();
        this.oRepresentedDep.init("ORepresented", this, metamodel.getMClass(Operation.MQNAME), 0, 1 );
        registerDependency(this.oRepresentedDep);

        this.bRepresentedDep = new BRepresentedSmDependency();
        this.bRepresentedDep.init("BRepresented", this, metamodel.getMClass(Behavior.MQNAME), 0, 1 );
        registerDependency(this.bRepresentedDep);

        this.occurrenceDep = new OccurrenceSmDependency();
        this.occurrenceDep.init("Occurrence", this, metamodel.getMClass(CollaborationUse.MQNAME), 0, -1 );
        registerDependency(this.occurrenceDep);

    }

    @objid ("e1832c69-540e-4377-b8c2-910a057ba17e")
    public SmAttribute getIsConcurrentAtt() {
        if (this.isConcurrentAtt == null) {
        	this.isConcurrentAtt = this.getAttributeDef("IsConcurrent");
        }
        return this.isConcurrentAtt;
    }

    @objid ("62d7b716-ccf5-410e-b253-bb65b94991ca")
    public SmDependency getORepresentedDep() {
        if (this.oRepresentedDep == null) {
        	this.oRepresentedDep = this.getDependencyDef("ORepresented");
        }
        return this.oRepresentedDep;
    }

    @objid ("d7cb6617-fee1-408e-83ea-c356edc27f5e")
    public SmDependency getBRepresentedDep() {
        if (this.bRepresentedDep == null) {
        	this.bRepresentedDep = this.getDependencyDef("BRepresented");
        }
        return this.bRepresentedDep;
    }

    @objid ("d8a3f4ae-26a6-4983-bdd7-565e5a97ec7c")
    public SmDependency getOccurrenceDep() {
        if (this.occurrenceDep == null) {
        	this.occurrenceDep = this.getDependencyDef("Occurrence");
        }
        return this.occurrenceDep;
    }

    @objid ("841371e0-8682-4003-840d-1837ff1d5030")
    private static class CollaborationObjectFactory implements ISmObjectFactory {
        @objid ("118b0f56-24ef-4a36-ab1a-fea5e8e5584e")
        private CollaborationSmClass smClass;

        @objid ("d7733efd-821d-4284-bb7c-e59134c44514")
        public CollaborationObjectFactory(CollaborationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e0d7ec20-4248-45c9-b361-e50d19d8dcf3")
        @Override
        public ISmObjectData createData() {
            return new CollaborationData(this.smClass);
        }

        @objid ("1cb71374-8585-4469-9c13-8cd34d2b2894")
        @Override
        public SmObjectImpl createImpl() {
            return new CollaborationImpl();
        }

    }

    @objid ("951f9368-f01b-4cfd-9f28-56eb5ff67bdf")
    public static class IsConcurrentSmAttribute extends SmAttribute {
        @objid ("511075e0-1a6d-4541-9b79-353e04b901ce")
        public Object getValue(ISmObjectData data) {
            return ((CollaborationData) data).mIsConcurrent;
        }

        @objid ("9fed8f10-96f7-41e4-a7af-518095c1e56f")
        public void setValue(ISmObjectData data, Object value) {
            ((CollaborationData) data).mIsConcurrent = value;
        }

    }

    @objid ("a39a68ea-d105-4aee-a773-c2d874812a80")
    public static class ORepresentedSmDependency extends SmSingleDependency {
        @objid ("ca7c7e32-13c4-4ec1-b70d-6be5ee7f4408")
        private SmDependency symetricDep;

        @objid ("5ce3feb2-d15e-47f1-ba9e-cf2550b60b6c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CollaborationData) data).mORepresented;
        }

        @objid ("bf448a22-f868-4f1e-9958-9fcf9fe31412")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CollaborationData) data).mORepresented = value;
        }

        @objid ("dc6171ad-cd69-46ec-9f9f-7cf6e1fb0db9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getExampleDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("52616a8f-1eb6-4840-b617-859c01c1f3ad")
    public static class BRepresentedSmDependency extends SmSingleDependency {
        @objid ("a25ecd8e-81a4-45f8-83f6-54ed79b8ef91")
        private SmDependency symetricDep;

        @objid ("bb813840-3f0b-45da-9da2-81db388dda5e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CollaborationData) data).mBRepresented;
        }

        @objid ("a73f8bcf-5ce6-48fc-a7e8-4a821338b488")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CollaborationData) data).mBRepresented = value;
        }

        @objid ("8dbe14df-e6c2-4b10-860e-cd875c56441d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorSmClass)this.getTarget()).getOwnedCollaborationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0bb9cfbf-38ea-4215-94d0-0c62861db73a")
    public static class OccurrenceSmDependency extends SmMultipleDependency {
        @objid ("d8cf059d-54c9-4cf1-b4d8-d4dd61b03448")
        private SmDependency symetricDep;

        @objid ("47624614-97ef-456f-b2da-f5c2c88fc7be")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CollaborationData)data).mOccurrence != null)? ((CollaborationData)data).mOccurrence:SmMultipleDependency.EMPTY;
        }

        @objid ("011fa07d-839f-441e-94d3-dc20b5825ac4")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CollaborationData) data).mOccurrence = values;

        }

        @objid ("cf72dece-3d86-4dcf-9fcc-15df0a77f2aa")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CollaborationUseSmClass)this.getTarget()).getTypeDep();
            }
            return this.symetricDep;

        }

    }

}
