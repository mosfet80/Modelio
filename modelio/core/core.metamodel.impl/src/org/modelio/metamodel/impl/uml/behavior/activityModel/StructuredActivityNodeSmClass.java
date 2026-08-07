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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
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

@objid ("5c8fac83-8d4d-4440-9e52-317a1ecc923d")
public class StructuredActivityNodeSmClass extends ActivityActionSmClass {
    @objid ("7e8a048b-3083-405a-8f65-2811fc1b7171")
    private SmAttribute mustIsolateAtt;

    @objid ("8d16cef7-4379-46f0-9dad-039e72b7e51a")
    private SmDependency bodyDep;

    @objid ("25c1d9cc-24ca-41cd-8b08-d6966a28ffe7")
    public StructuredActivityNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("16f50dbd-b578-421f-afb8-dbd5f618441d")
    @Override
    public String getName() {
        return "StructuredActivityNode";

    }

    @objid ("34b3ad07-6b04-4358-95e2-02d0ae18a352")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("191d7011-e741-4f60-bbac-86f63bbfeb8c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StructuredActivityNode.class;

    }

    @objid ("2bafd762-d71b-450b-b70f-5b35f7cb2eb9")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5ba563b5-e92c-4029-9f8e-db708fdd88f3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("fc5c5d31-8092-4c70-8b34-c1521da18a33")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityAction.MQNAME);
        this.registerFactory(new StructuredActivityNodeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.mustIsolateAtt = new MustIsolateSmAttribute();
        this.mustIsolateAtt.init("MustIsolate", this, Boolean.class );
        registerAttribute(this.mustIsolateAtt);


        // Initialize and register the SmDependency
        this.bodyDep = new BodySmDependency();
        this.bodyDep.init("Body", this, metamodel.getMClass(ActivityNode.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.bodyDep);

    }

    @objid ("eca3d68e-01e4-4eab-b38f-0eb2e3738e3d")
    public SmAttribute getMustIsolateAtt() {
        if (this.mustIsolateAtt == null) {
        	this.mustIsolateAtt = this.getAttributeDef("MustIsolate");
        }
        return this.mustIsolateAtt;
    }

    @objid ("0d875852-61cc-445a-a576-dbcec528772d")
    public SmDependency getBodyDep() {
        if (this.bodyDep == null) {
        	this.bodyDep = this.getDependencyDef("Body");
        }
        return this.bodyDep;
    }

    @objid ("5c15601c-2ac1-411e-b0db-ded967586412")
    private static class StructuredActivityNodeObjectFactory implements ISmObjectFactory {
        @objid ("166590b4-8f88-4c4f-9bda-aab1d8530668")
        private StructuredActivityNodeSmClass smClass;

        @objid ("f0ae7ed7-d66b-4b1f-b900-496480710ccf")
        public StructuredActivityNodeObjectFactory(StructuredActivityNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("31550c67-c888-4463-b235-958e0166d333")
        @Override
        public ISmObjectData createData() {
            return new StructuredActivityNodeData(this.smClass);
        }

        @objid ("98229a3e-013a-4510-9e8d-5d073fbd701d")
        @Override
        public SmObjectImpl createImpl() {
            return new StructuredActivityNodeImpl();
        }

    }

    @objid ("e454e4c6-6768-4433-aff9-c680503c2b1f")
    public static class MustIsolateSmAttribute extends SmAttribute {
        @objid ("3ef06115-ddeb-41db-9ae9-8d4f14aea313")
        public Object getValue(ISmObjectData data) {
            return ((StructuredActivityNodeData) data).mMustIsolate;
        }

        @objid ("4c791321-b628-4cfd-8721-74d1a398a524")
        public void setValue(ISmObjectData data, Object value) {
            ((StructuredActivityNodeData) data).mMustIsolate = value;
        }

    }

    @objid ("a79feadb-a6fd-4a94-909d-668700f3b076")
    public static class BodySmDependency extends SmMultipleDependency {
        @objid ("35d3961e-5722-424f-83a5-2e0684129de4")
        private SmDependency symetricDep;

        @objid ("f75ae9e5-e61c-493a-a8ec-b3f740259594")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StructuredActivityNodeData)data).mBody != null)? ((StructuredActivityNodeData)data).mBody:SmMultipleDependency.EMPTY;
        }

        @objid ("f2a8bcd6-ed98-40d7-8d51-cbc47d40340d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StructuredActivityNodeData) data).mBody = values;

        }

        @objid ("5249e441-979c-4d5f-afec-99fa00fd2516")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityNodeSmClass)this.getTarget()).getOwnerNodeDep();
            }
            return this.symetricDep;

        }

    }

}
