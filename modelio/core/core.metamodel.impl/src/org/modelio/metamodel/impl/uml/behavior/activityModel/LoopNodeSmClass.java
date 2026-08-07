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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.LoopNode;
import org.modelio.metamodel.uml.behavior.activityModel.StructuredActivityNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("205ae75c-6818-4c12-8295-cb1fb852bc5d")
public class LoopNodeSmClass extends StructuredActivityNodeSmClass {
    @objid ("54768f3d-cd5f-4147-888d-1c340c543113")
    private SmAttribute isTestedFirstAtt;

    @objid ("d245e182-c54b-46aa-b83d-1f0ae2dce222")
    private SmAttribute setupAtt;

    @objid ("2edc9ce3-4f67-4775-adaa-fbaccae2a1d3")
    private SmAttribute testAtt;

    @objid ("0ac52647-1780-41eb-a2c7-04cb39906dc2")
    public LoopNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1d41f88e-f0b5-4f7a-92fb-5b398db033b0")
    @Override
    public String getName() {
        return "LoopNode";

    }

    @objid ("a027ca61-75cc-463b-bc9e-da38eff594f1")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e59f5b02-ea23-46dd-abb7-150cd7b4b818")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return LoopNode.class;

    }

    @objid ("571287b5-9853-4cff-86a9-ccc5b08dcd6c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("8bfc4c57-f10c-4293-831f-3c8b34541e65")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("2d605896-b4c1-4464-a4f6-96db549c08c1")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructuredActivityNode.MQNAME);
        this.registerFactory(new LoopNodeObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isTestedFirstAtt = new IsTestedFirstSmAttribute();
        this.isTestedFirstAtt.init("IsTestedFirst", this, Boolean.class );
        registerAttribute(this.isTestedFirstAtt);

        this.setupAtt = new SetupSmAttribute();
        this.setupAtt.init("Setup", this, String.class );
        registerAttribute(this.setupAtt);

        this.testAtt = new TestSmAttribute();
        this.testAtt.init("Test", this, String.class );
        registerAttribute(this.testAtt);


        // Initialize and register the SmDependency

    }

    @objid ("21d3b09e-6a87-4edd-acc3-5ff07dfe2c7d")
    public SmAttribute getIsTestedFirstAtt() {
        if (this.isTestedFirstAtt == null) {
        	this.isTestedFirstAtt = this.getAttributeDef("IsTestedFirst");
        }
        return this.isTestedFirstAtt;
    }

    @objid ("0ad3496e-cb52-4521-8e9e-90f19ffc5d96")
    public SmAttribute getSetupAtt() {
        if (this.setupAtt == null) {
        	this.setupAtt = this.getAttributeDef("Setup");
        }
        return this.setupAtt;
    }

    @objid ("38f91f9e-b1d5-4de0-895a-a312674f3f21")
    public SmAttribute getTestAtt() {
        if (this.testAtt == null) {
        	this.testAtt = this.getAttributeDef("Test");
        }
        return this.testAtt;
    }

    @objid ("c1deb14a-a81d-4cab-ac88-af00c6f18538")
    private static class LoopNodeObjectFactory implements ISmObjectFactory {
        @objid ("6dae30ca-0a0f-45cc-aed3-469f2bd78cb3")
        private LoopNodeSmClass smClass;

        @objid ("d99d1449-113f-4520-9499-4a26a0e49183")
        public LoopNodeObjectFactory(LoopNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f2561e47-cd60-4b40-9304-e87a2f01d2c0")
        @Override
        public ISmObjectData createData() {
            return new LoopNodeData(this.smClass);
        }

        @objid ("f4521425-c1a8-429e-afd2-7ab8015c9c93")
        @Override
        public SmObjectImpl createImpl() {
            return new LoopNodeImpl();
        }

    }

    @objid ("d0bcfdb7-4db6-4f37-9745-fe95e3e9196d")
    public static class IsTestedFirstSmAttribute extends SmAttribute {
        @objid ("cb417e13-f311-48a3-8516-f1f39e6db237")
        public Object getValue(ISmObjectData data) {
            return ((LoopNodeData) data).mIsTestedFirst;
        }

        @objid ("31a092f5-f3ee-4930-bb97-cea727eded1c")
        public void setValue(ISmObjectData data, Object value) {
            ((LoopNodeData) data).mIsTestedFirst = value;
        }

    }

    @objid ("413a3bbf-da89-43a1-9828-7e7ca1870863")
    public static class SetupSmAttribute extends SmAttribute {
        @objid ("8646de48-e458-4844-a1cb-41a2a1acad13")
        public Object getValue(ISmObjectData data) {
            return ((LoopNodeData) data).mSetup;
        }

        @objid ("78343ff1-e5e5-4ad8-83d1-17b0c72fe389")
        public void setValue(ISmObjectData data, Object value) {
            ((LoopNodeData) data).mSetup = value;
        }

    }

    @objid ("52b73810-03f5-4351-b8da-79f353d40cc2")
    public static class TestSmAttribute extends SmAttribute {
        @objid ("90951421-b258-47bc-adbe-096a2dc0be39")
        public Object getValue(ISmObjectData data) {
            return ((LoopNodeData) data).mTest;
        }

        @objid ("5f404b64-e5a7-4d5c-8a8c-b1875fd80cd3")
        public void setValue(ISmObjectData data, Object value) {
            ((LoopNodeData) data).mTest = value;
        }

    }

}
