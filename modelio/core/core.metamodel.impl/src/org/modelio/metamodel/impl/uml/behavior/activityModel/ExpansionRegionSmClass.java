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
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionKind;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionNode;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionRegion;
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

@objid ("fa02fd4e-8957-4742-9fbc-785a02b815fc")
public class ExpansionRegionSmClass extends StructuredActivityNodeSmClass {
    @objid ("d2133e00-efd7-47dd-95c8-55e9a9b4d9cc")
    private SmAttribute modeAtt;

    @objid ("88c0dde5-d609-46f7-af98-2b056f59dc8b")
    private SmDependency outputElementDep;

    @objid ("9aa39e39-1e5e-4975-9dbf-a4370f021b9d")
    private SmDependency inputElementDep;

    @objid ("ac108720-d74b-40e9-8bf1-ba829f85eae9")
    public ExpansionRegionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b1367cae-521b-4a5d-b276-1463bf60a4cd")
    @Override
    public String getName() {
        return "ExpansionRegion";

    }

    @objid ("a5851e20-2ea6-4793-a6b2-bf30bc7f6177")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("597632a6-126f-4299-8360-f43bc53ddbcf")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExpansionRegion.class;

    }

    @objid ("9e770521-6d34-4015-b94b-4c8eca2bee8c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("47e009a4-7b9e-441f-b44f-a1bc845dc08b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0abaeea0-35a8-40d5-a8c2-637883415277")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuredActivityNode.MQNAME);
        this.registerFactory(new ExpansionRegionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.modeAtt = new ModeSmAttribute();
        this.modeAtt.init("Mode", this, ExpansionKind.class );
        registerAttribute(this.modeAtt);


        // Initialize and register the SmDependency
        this.outputElementDep = new OutputElementSmDependency();
        this.outputElementDep.init("OutputElement", this, metamodel.getMClass(ExpansionNode.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT, SmDirective.SMCDPARTOF);
        registerDependency(this.outputElementDep);

        this.inputElementDep = new InputElementSmDependency();
        this.inputElementDep.init("InputElement", this, metamodel.getMClass(ExpansionNode.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT, SmDirective.SMCDPARTOF);
        registerDependency(this.inputElementDep);

    }

    @objid ("551ab562-88bb-4c48-87f1-158abef5dce6")
    public SmAttribute getModeAtt() {
        if (this.modeAtt == null) {
        	this.modeAtt = this.getAttributeDef("Mode");
        }
        return this.modeAtt;
    }

    @objid ("49604e06-e2b8-4259-9691-ff5c0b614059")
    public SmDependency getOutputElementDep() {
        if (this.outputElementDep == null) {
        	this.outputElementDep = this.getDependencyDef("OutputElement");
        }
        return this.outputElementDep;
    }

    @objid ("9fa28282-ac97-4e0e-a0e9-50180b839d87")
    public SmDependency getInputElementDep() {
        if (this.inputElementDep == null) {
        	this.inputElementDep = this.getDependencyDef("InputElement");
        }
        return this.inputElementDep;
    }

    @objid ("f7b0e113-f5f1-4252-afe8-4e7b312ed313")
    private static class ExpansionRegionObjectFactory implements ISmObjectFactory {
        @objid ("af4bf8df-d42a-4a18-9641-a03518f0c92c")
        private ExpansionRegionSmClass smClass;

        @objid ("d50087fa-b48f-4041-ac2c-652a9b410c11")
        public ExpansionRegionObjectFactory(ExpansionRegionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("dc1e486c-fcc0-4e25-8389-02820c81e719")
        @Override
        public ISmObjectData createData() {
            return new ExpansionRegionData(this.smClass);
        }

        @objid ("e8d62d6c-3f06-420d-87e2-dc14863d0362")
        @Override
        public SmObjectImpl createImpl() {
            return new ExpansionRegionImpl();
        }

    }

    @objid ("039703f7-efea-4f29-b2f7-09ca540a2553")
    public static class ModeSmAttribute extends SmAttribute {
        @objid ("a0ce2fa8-9da9-4c4b-8de7-fccf8b4b953f")
        public Object getValue(ISmObjectData data) {
            return ((ExpansionRegionData) data).mMode;
        }

        @objid ("15f5430e-b047-4557-9dfe-2962ca10a8e8")
        public void setValue(ISmObjectData data, Object value) {
            ((ExpansionRegionData) data).mMode = value;
        }

    }

    @objid ("3cf4513f-71d6-4a15-b033-710b8fc27ba5")
    public static class OutputElementSmDependency extends SmMultipleDependency {
        @objid ("7f6bf71c-77a7-4853-b4f1-3d24fe4276d8")
        private SmDependency symetricDep;

        @objid ("37a504e5-b983-4aa7-bb4c-1b2355a59749")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ExpansionRegionData)data).mOutputElement != null)? ((ExpansionRegionData)data).mOutputElement:SmMultipleDependency.EMPTY;
        }

        @objid ("cf633ac9-d0c7-469d-abf3-b1f93d16935e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ExpansionRegionData) data).mOutputElement = values;

        }

        @objid ("ca4a1c45-ab8b-4600-a5c5-d56e62b8c527")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExpansionNodeSmClass)this.getTarget()).getRegionAsOutputDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e08eab8c-c2ef-43ff-88a0-b1f728b6f185")
    public static class InputElementSmDependency extends SmMultipleDependency {
        @objid ("3eb570af-acb8-48f3-8b6e-15b9e3b536e6")
        private SmDependency symetricDep;

        @objid ("7aceccf5-6da2-4440-b84b-08fcdea790ca")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ExpansionRegionData)data).mInputElement != null)? ((ExpansionRegionData)data).mInputElement:SmMultipleDependency.EMPTY;
        }

        @objid ("c9ed4c48-32e3-4990-9889-301b9abab38e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ExpansionRegionData) data).mInputElement = values;

        }

        @objid ("014fc598-0be4-474d-84f4-cdce57d4d45b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExpansionNodeSmClass)this.getTarget()).getRegionAsInputDep();
            }
            return this.symetricDep;

        }

    }

}
