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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.Clause;
import org.modelio.metamodel.uml.behavior.activityModel.ConditionalNode;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("915a23ae-4b3c-45d1-84e8-f84a3c43f56e")
public class ClauseSmClass extends UmlModelElementSmClass {
    @objid ("2d9244d3-30b6-4a19-b7c9-ab598959308d")
    private SmAttribute testAtt;

    @objid ("e042491a-9dc2-412d-9d97-1c52937cc41d")
    private SmDependency bodyDep;

    @objid ("91d87d80-0ec6-4f6e-b8d7-09a257e3ba10")
    private SmDependency ownerDep;

    @objid ("86adef3c-fef1-4f43-8d60-6cbf8c5b86d4")
    public ClauseSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("46b8ac5e-ad44-4acd-b78c-3d56fcb9af6a")
    @Override
    public String getName() {
        return "Clause";

    }

    @objid ("d8cae2c5-e878-4330-9adc-c2b7850e18f7")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("1e0cbaef-2104-4e7d-8bc6-28be65217efb")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Clause.class;

    }

    @objid ("238c5a23-dcb4-44c9-bbdc-57cd79e31733")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("fe3d58b7-5e42-4dcd-acab-f2a6d7912586")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("68fb8084-b606-42d2-9310-93437f5ffb25")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ClauseObjectFactory(this));


        // Initialize and register the SmAttribute
        this.testAtt = new TestSmAttribute();
        this.testAtt.init("Test", this, String.class );
        registerAttribute(this.testAtt);


        // Initialize and register the SmDependency
        this.bodyDep = new BodySmDependency();
        this.bodyDep.init("Body", this, metamodel.getMClass(ActivityNode.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.bodyDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(ConditionalNode.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

    }

    @objid ("948e01c9-c751-4363-b8f0-8ab7ef67d9a3")
    public SmAttribute getTestAtt() {
        if (this.testAtt == null) {
        	this.testAtt = this.getAttributeDef("Test");
        }
        return this.testAtt;
    }

    @objid ("9e26c4a6-fe8f-42a5-a7a6-8c0a556fedcb")
    public SmDependency getBodyDep() {
        if (this.bodyDep == null) {
        	this.bodyDep = this.getDependencyDef("Body");
        }
        return this.bodyDep;
    }

    @objid ("d4f388ca-0191-41bf-beb5-b3a14f658503")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("fee041f9-8e20-4daf-842e-f02a7d10fbd4")
    private static class ClauseObjectFactory implements ISmObjectFactory {
        @objid ("91da4230-e8a3-4804-b70b-526226e9a26d")
        private ClauseSmClass smClass;

        @objid ("4185472d-eee9-4e53-9edf-8e33ffd89441")
        public ClauseObjectFactory(ClauseSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("77a396c9-c1b9-4c7b-ac99-92dac6dc8ce3")
        @Override
        public ISmObjectData createData() {
            return new ClauseData(this.smClass);
        }

        @objid ("7fd5caad-03d1-4256-a3f2-27912b143c53")
        @Override
        public SmObjectImpl createImpl() {
            return new ClauseImpl();
        }

    }

    @objid ("935c9bc1-149c-4123-908c-33b008660d2e")
    public static class TestSmAttribute extends SmAttribute {
        @objid ("3bff9aae-7d3a-46cd-9bcf-88d8cbc898be")
        public Object getValue(ISmObjectData data) {
            return ((ClauseData) data).mTest;
        }

        @objid ("b0b9868b-5503-454d-8765-d5ecffe2b75f")
        public void setValue(ISmObjectData data, Object value) {
            ((ClauseData) data).mTest = value;
        }

    }

    @objid ("c4f323e0-8f2c-43f5-8860-f28a0e95d768")
    public static class BodySmDependency extends SmMultipleDependency {
        @objid ("6d7dd86f-4693-4323-90c2-715fe5581064")
        private SmDependency symetricDep;

        @objid ("747a27ea-5daf-4250-8ef8-f275d9da1b3d")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ClauseData)data).mBody != null)? ((ClauseData)data).mBody:SmMultipleDependency.EMPTY;
        }

        @objid ("b87e7a29-00a2-47d6-bbed-4bd9b5952da2")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ClauseData) data).mBody = values;

        }

        @objid ("a8374ae3-6cb3-43e9-b4a2-9a0ec0ce5f41")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityNodeSmClass)this.getTarget()).getOwnerClauseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("65e5794c-d6f6-45ab-9b29-05d84ed06178")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("ac097d93-20ef-4cf6-bed6-b6e94337790b")
        private SmDependency symetricDep;

        @objid ("55f492f7-1f5b-4cc5-a3ba-33bb4dcb738c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ClauseData) data).mOwner;
        }

        @objid ("0041d052-2804-44c0-bf20-0f7b0ff2e873")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ClauseData) data).mOwner = value;
        }

        @objid ("8bedbd6a-5229-480d-89d9-cc40803c7e17")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConditionalNodeSmClass)this.getTarget()).getOwnedClauseDep();
            }
            return this.symetricDep;

        }

    }

}
