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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociationDirection;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("2fa1359f-9d07-4dd6-a0c4-8956cffbb1a4")
public class BpmnAssociationSmClass extends BpmnArtifactSmClass {
    @objid ("3356df66-7b06-40ff-b785-ac2828838152")
    private SmAttribute associationDirectionAtt;

    @objid ("87a35628-530b-4812-be56-00b4e0dac58e")
    private SmDependency targetRefDep;

    @objid ("97a95659-5180-4e35-a170-fc5bf08b8e23")
    private SmDependency sourceRefDep;

    @objid ("3ed3e082-de7b-45aa-8a3d-f29eaef47fe8")
    public BpmnAssociationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0577d7e6-0c1a-44bd-827f-38f25f1a637d")
    @Override
    public String getName() {
        return "BpmnAssociation";

    }

    @objid ("62d03fb9-2de3-435b-a89b-42bfc367cbbd")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("846f0a5d-db3f-47d6-82b1-808d64f01ed9")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnAssociation.class;

    }

    @objid ("e75c9137-ebdc-40e2-8c84-51a5b81eb1c0")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("efd16d0b-93ff-4ac0-a9f7-7b42aeac2e92")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("20ab65f0-a649-40bf-ba90-b6a14f82bd99")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnArtifact.MQNAME);
        this.registerFactory(new BpmnAssociationObjectFactory(this));


        // Initialize and register the SmAttribute
        this.associationDirectionAtt = new AssociationDirectionSmAttribute();
        this.associationDirectionAtt.init("AssociationDirection", this, BpmnAssociationDirection.class );
        registerAttribute(this.associationDirectionAtt);


        // Initialize and register the SmDependency
        this.targetRefDep = new TargetRefSmDependency();
        this.targetRefDep.init("TargetRef", this, metamodel.getMClass(BpmnBaseElement.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.targetRefDep);

        this.sourceRefDep = new SourceRefSmDependency();
        this.sourceRefDep.init("SourceRef", this, metamodel.getMClass(BpmnBaseElement.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.sourceRefDep);

    }

    @objid ("f780ba92-36f3-4da4-bf3d-bc66b8557bde")
    public SmAttribute getAssociationDirectionAtt() {
        if (this.associationDirectionAtt == null) {
        	this.associationDirectionAtt = this.getAttributeDef("AssociationDirection");
        }
        return this.associationDirectionAtt;
    }

    @objid ("d2bd9372-4b40-41ab-8f93-3f3b639969ac")
    public SmDependency getTargetRefDep() {
        if (this.targetRefDep == null) {
        	this.targetRefDep = this.getDependencyDef("TargetRef");
        }
        return this.targetRefDep;
    }

    @objid ("f80f68c5-6c0f-4ba7-b858-ad700c560b85")
    public SmDependency getSourceRefDep() {
        if (this.sourceRefDep == null) {
        	this.sourceRefDep = this.getDependencyDef("SourceRef");
        }
        return this.sourceRefDep;
    }

    @objid ("f1ff0ff0-819f-431d-a230-fc286958391b")
    private static class BpmnAssociationObjectFactory implements ISmObjectFactory {
        @objid ("ecc2941b-ca71-45b9-9bd1-5153d23750fa")
        private BpmnAssociationSmClass smClass;

        @objid ("105cd8c1-0f45-4980-bcc5-474e18cd153f")
        public BpmnAssociationObjectFactory(BpmnAssociationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("371a119b-f7a7-4709-ad56-417b131d30ba")
        @Override
        public ISmObjectData createData() {
            return new BpmnAssociationData(this.smClass);
        }

        @objid ("cec6bdaa-4989-4167-b516-0ce2738be0fe")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnAssociationImpl();
        }

    }

    @objid ("ccc9f970-f8d8-4ce4-a906-8b5b72d02bbb")
    public static class AssociationDirectionSmAttribute extends SmAttribute {
        @objid ("1bd34440-8532-4e20-9062-b05892bf823f")
        public Object getValue(ISmObjectData data) {
            return ((BpmnAssociationData) data).mAssociationDirection;
        }

        @objid ("ef952862-c80f-4823-ae87-a4e5b644e268")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnAssociationData) data).mAssociationDirection = value;
        }

    }

    @objid ("27e9cbc3-6187-466d-b4c6-f1f94c98d6cc")
    public static class TargetRefSmDependency extends SmSingleDependency {
        @objid ("37a2b094-d9c0-421a-9c9f-bbda5faebadd")
        private SmDependency symetricDep;

        @objid ("d57d117e-d691-4dfb-9a8d-51652e3f9692")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnAssociationData) data).mTargetRef;
        }

        @objid ("3fede919-4794-4392-93f8-61a4774c6c55")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnAssociationData) data).mTargetRef = value;
        }

        @objid ("7f6f2aba-ece4-44bc-8958-a9707ba92990")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnBaseElementSmClass)this.getTarget()).getIncomingAssocDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("91f9340a-0288-4689-a572-9303899ca09e")
    public static class SourceRefSmDependency extends SmSingleDependency {
        @objid ("351c3a23-1e6d-4218-9ea6-3c106c8b6c6a")
        private SmDependency symetricDep;

        @objid ("ed968d06-0568-438f-bafb-86c8092179dc")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnAssociationData) data).mSourceRef;
        }

        @objid ("fff8cb53-f787-4386-a209-0331cf3b4fc6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnAssociationData) data).mSourceRef = value;
        }

        @objid ("5e9d99e7-b696-4f3b-a54b-60474f735082")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnBaseElementSmClass)this.getTarget()).getOutgoingAssocDep();
            }
            return this.symetricDep;

        }

    }

}
