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
import org.modelio.metamodel.uml.behavior.activityModel.Clause;
import org.modelio.metamodel.uml.behavior.activityModel.ConditionalNode;
import org.modelio.metamodel.uml.behavior.activityModel.StructuredActivityNode;
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
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("d1292d23-82a1-4c79-bd74-1817c49e9708")
public class ConditionalNodeSmClass extends StructuredActivityNodeSmClass {
    @objid ("7319066e-cd91-4d38-9ad8-ed0fdc72b78c")
    private SmAttribute isDeterminateAtt;

    @objid ("b8265e18-88a8-43d0-92a1-a7a541ef29d9")
    private SmAttribute isAssuredAtt;

    @objid ("0bbeb93f-99cd-4692-8341-c8d1449de3ff")
    private SmDependency ownedClauseDep;

    @objid ("1fe88836-8377-48be-a6e8-3ca481b44a8c")
    public ConditionalNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5c14f5cd-b895-494c-9eb6-fec34c566577")
    @Override
    public String getName() {
        return "ConditionalNode";

    }

    @objid ("441bc204-029b-4d8f-be0b-971ad34ac48b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("ff14d2a5-0a31-4339-a878-e77250f5dc87")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ConditionalNode.class;

    }

    @objid ("957eb652-8929-49b9-9281-3ae00d909b81")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("40fd5c64-6596-4ed5-94d6-75ce4625fc0f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("526e2805-6573-4839-af2f-b0349f6d1e26")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuredActivityNode.MQNAME);
        this.registerFactory(new ConditionalNodeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isDeterminateAtt = new IsDeterminateSmAttribute();
        this.isDeterminateAtt.init("IsDeterminate", this, Boolean.class );
        registerAttribute(this.isDeterminateAtt);

        this.isAssuredAtt = new IsAssuredSmAttribute();
        this.isAssuredAtt.init("IsAssured", this, Boolean.class );
        registerAttribute(this.isAssuredAtt);


        // Initialize and register the SmDependency
        this.ownedClauseDep = new OwnedClauseSmDependency();
        this.ownedClauseDep.init("OwnedClause", this, metamodel.getMClass(Clause.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedClauseDep);

    }

    @objid ("b6ee215c-86ad-49a2-87e3-723aeee03e76")
    public SmAttribute getIsDeterminateAtt() {
        if (this.isDeterminateAtt == null) {
        	this.isDeterminateAtt = this.getAttributeDef("IsDeterminate");
        }
        return this.isDeterminateAtt;
    }

    @objid ("fa2f28ba-a3f5-47a2-b5fc-ec614d58ecdd")
    public SmAttribute getIsAssuredAtt() {
        if (this.isAssuredAtt == null) {
        	this.isAssuredAtt = this.getAttributeDef("IsAssured");
        }
        return this.isAssuredAtt;
    }

    @objid ("5f9bcde6-3cb3-40d6-9648-3d0f3ca5d8f0")
    public SmDependency getOwnedClauseDep() {
        if (this.ownedClauseDep == null) {
        	this.ownedClauseDep = this.getDependencyDef("OwnedClause");
        }
        return this.ownedClauseDep;
    }

    @objid ("185b454e-d285-4032-9bda-5e8ec751211b")
    private static class ConditionalNodeObjectFactory implements ISmObjectFactory {
        @objid ("f9bae232-a1eb-4171-ba46-937f9e3c2005")
        private ConditionalNodeSmClass smClass;

        @objid ("bc5aa3f0-81b7-4707-bf6d-fa6467655cfb")
        public ConditionalNodeObjectFactory(ConditionalNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("0436c1c9-88bb-43d3-b49c-e0347778b4f3")
        @Override
        public ISmObjectData createData() {
            return new ConditionalNodeData(this.smClass);
        }

        @objid ("34080d93-2cde-47e3-a27c-47d9ed8f6590")
        @Override
        public SmObjectImpl createImpl() {
            return new ConditionalNodeImpl();
        }

    }

    @objid ("3b3923a1-6bc9-476d-9338-34d0dcdf3f95")
    public static class IsDeterminateSmAttribute extends SmAttribute {
        @objid ("d4744da7-d57b-44c2-8923-3bd2e113f33f")
        public Object getValue(ISmObjectData data) {
            return ((ConditionalNodeData) data).mIsDeterminate;
        }

        @objid ("cc74106b-3140-4869-9cd4-acac282d9fbf")
        public void setValue(ISmObjectData data, Object value) {
            ((ConditionalNodeData) data).mIsDeterminate = value;
        }

    }

    @objid ("428fa9b7-d1aa-469a-aa1e-27669eb37407")
    public static class IsAssuredSmAttribute extends SmAttribute {
        @objid ("a291d3f5-f958-490a-9de1-b204bb6da255")
        public Object getValue(ISmObjectData data) {
            return ((ConditionalNodeData) data).mIsAssured;
        }

        @objid ("65cdc51b-5ad7-49a1-beee-e5b9d590ded5")
        public void setValue(ISmObjectData data, Object value) {
            ((ConditionalNodeData) data).mIsAssured = value;
        }

    }

    @objid ("69eaf755-9839-4775-85c3-bbc038c347de")
    public static class OwnedClauseSmDependency extends SmMultipleDependency {
        @objid ("96692d4e-602c-41bb-b6c7-e5883c1ed0ce")
        private SmDependency symetricDep;

        @objid ("6a577f76-0da6-4e75-bd65-461a117197dd")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ConditionalNodeData)data).mOwnedClause != null)? ((ConditionalNodeData)data).mOwnedClause:SmMultipleDependency.EMPTY;
        }

        @objid ("33c7aac5-b915-4d2f-93e8-0f75ad6008ad")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ConditionalNodeData) data).mOwnedClause = values;

        }

        @objid ("bc173a0f-8adc-409c-b938-f76dd86036c5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClauseSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
