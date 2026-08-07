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
import org.modelio.metamodel.impl.uml.behavior.activityModel.ExceptionHandlerSmClass;
import org.modelio.metamodel.impl.uml.behavior.activityModel.ObjectNodeSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Parameter;
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

@objid ("68b143c4-1f67-48f8-9d81-057416dd3db1")
public class GeneralClassSmClass extends ClassifierSmClass {
    @objid ("6750a095-c866-47b0-bf70-1fa154d31ff5")
    private SmAttribute isElementaryAtt;

    @objid ("c91538b7-fe88-4fdd-8c1c-ab3cff3501ae")
    private SmDependency occurenceDep;

    @objid ("420cae0f-b491-4ebb-97a5-3d94be989659")
    private SmDependency exceptionInputDep;

    @objid ("9b8d09fa-20d9-4ab5-a203-f35e285b83ce")
    private SmDependency objectDep;

    @objid ("42054edf-2195-4f2f-878e-b68304244996")
    private SmDependency sRepresentationDep;

    @objid ("028b1d4d-e4ab-4a91-87ae-307575f5690c")
    private SmDependency occurenceObjectNodeDep;

    @objid ("9b41098b-d50d-4819-ae9a-5d7ab689fff1")
    public GeneralClassSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6042c770-fb98-4415-8d6a-b36096ada9ba")
    @Override
    public String getName() {
        return "GeneralClass";

    }

    @objid ("0072e8d1-3516-423f-bfa3-bf5df1dece28")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0eecec46-a977-4bb0-bcff-8581f1ef8941")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return GeneralClass.class;

    }

    @objid ("008ece51-ff17-49cf-9e1d-87c9304289cc")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("bec5c1ae-b898-48bc-8337-159be92d8a60")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("fcae4670-44c0-4a95-9ece-72031257cdce")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Classifier.MQNAME);
        this.registerFactory(new GeneralClassObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isElementaryAtt = new IsElementarySmAttribute();
        this.isElementaryAtt.init("IsElementary", this, Boolean.class );
        registerAttribute(this.isElementaryAtt);


        // Initialize and register the SmDependency
        this.occurenceDep = new OccurenceSmDependency();
        this.occurenceDep.init("Occurence", this, metamodel.getMClass(Parameter.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC);
        registerDependency(this.occurenceDep);

        this.exceptionInputDep = new ExceptionInputSmDependency();
        this.exceptionInputDep.init("ExceptionInput", this, metamodel.getMClass(ExceptionHandler.MQNAME), 1, 1 );
        registerDependency(this.exceptionInputDep);

        this.objectDep = new ObjectSmDependency();
        this.objectDep.init("Object", this, metamodel.getMClass(Attribute.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC);
        registerDependency(this.objectDep);

        this.sRepresentationDep = new SRepresentationSmDependency();
        this.sRepresentationDep.init("SRepresentation", this, metamodel.getMClass(Signal.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC);
        registerDependency(this.sRepresentationDep);

        this.occurenceObjectNodeDep = new OccurenceObjectNodeSmDependency();
        this.occurenceObjectNodeDep.init("OccurenceObjectNode", this, metamodel.getMClass(ObjectNode.MQNAME), 0, -1 , SmDirective.SMCDDYNAMIC);
        registerDependency(this.occurenceObjectNodeDep);

    }

    @objid ("3a489c2c-ba4b-4d27-8dbd-54720567a1e4")
    public SmAttribute getIsElementaryAtt() {
        if (this.isElementaryAtt == null) {
        	this.isElementaryAtt = this.getAttributeDef("IsElementary");
        }
        return this.isElementaryAtt;
    }

    @objid ("f233ad19-8cbc-4568-8b07-86f776d51a86")
    public SmDependency getOccurenceDep() {
        if (this.occurenceDep == null) {
        	this.occurenceDep = this.getDependencyDef("Occurence");
        }
        return this.occurenceDep;
    }

    @objid ("3c859087-309e-467e-9852-49282df015c4")
    public SmDependency getExceptionInputDep() {
        if (this.exceptionInputDep == null) {
        	this.exceptionInputDep = this.getDependencyDef("ExceptionInput");
        }
        return this.exceptionInputDep;
    }

    @objid ("79e2bfa4-0deb-48fd-ab49-190fef497266")
    public SmDependency getObjectDep() {
        if (this.objectDep == null) {
        	this.objectDep = this.getDependencyDef("Object");
        }
        return this.objectDep;
    }

    @objid ("d6ca82d6-af90-44e0-bbfa-610afbb8c128")
    public SmDependency getSRepresentationDep() {
        if (this.sRepresentationDep == null) {
        	this.sRepresentationDep = this.getDependencyDef("SRepresentation");
        }
        return this.sRepresentationDep;
    }

    @objid ("24d8f0f3-1cba-4243-bedc-47d020067d03")
    public SmDependency getOccurenceObjectNodeDep() {
        if (this.occurenceObjectNodeDep == null) {
        	this.occurenceObjectNodeDep = this.getDependencyDef("OccurenceObjectNode");
        }
        return this.occurenceObjectNodeDep;
    }

    @objid ("a11c283b-d830-4958-897b-6a0b5c598402")
    private static class GeneralClassObjectFactory implements ISmObjectFactory {
        @objid ("e3812dc5-0d21-4b9e-a986-78dd4a3e3d06")
        private GeneralClassSmClass smClass;

        @objid ("22bc11c2-daac-462e-bc69-3f284fb95774")
        public GeneralClassObjectFactory(GeneralClassSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7e6e09cd-7612-4485-81db-03f42aa9218a")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("27fd0781-232e-4a3a-be90-7d2f632b59c7")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("10f28c33-f4e9-4615-8275-d645bde9897a")
    public static class IsElementarySmAttribute extends SmAttribute {
        @objid ("b3c3b15c-a8d6-4e40-b37c-cd06b9d8d34f")
        public Object getValue(ISmObjectData data) {
            return ((GeneralClassData) data).mIsElementary;
        }

        @objid ("449aca07-dcba-4cd3-a793-6bff9201d120")
        public void setValue(ISmObjectData data, Object value) {
            ((GeneralClassData) data).mIsElementary = value;
        }

    }

    @objid ("93566c25-d2f9-4da6-b1b8-f48f70dc5f60")
    public static class OccurenceSmDependency extends SmMultipleDependency {
        @objid ("a0e2a51a-7973-43da-94fa-08dc3a8f10c7")
        private SmDependency symetricDep;

        @objid ("5054555b-9ac2-44dd-b864-5207c699f26f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((GeneralClassData)data).mOccurence != null)? ((GeneralClassData)data).mOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("e679f857-adec-4811-8324-e9e5ba7ddda1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((GeneralClassData) data).mOccurence = values;

        }

        @objid ("4f6716e9-382f-4c91-9474-1546946bc276")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ParameterSmClass)this.getTarget()).getTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("212a8494-f590-4db3-a653-edc8568c3320")
    public static class ExceptionInputSmDependency extends SmSingleDependency {
        @objid ("35fcf98c-65af-4bf8-bb0f-7a21692cd2fe")
        private SmDependency symetricDep;

        @objid ("bbd94dc5-bba5-42a1-9557-16ae018e2523")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GeneralClassData) data).mExceptionInput;
        }

        @objid ("bce046f7-ef6c-4783-929c-e5a17af82186")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GeneralClassData) data).mExceptionInput = value;
        }

        @objid ("13903a3b-4516-4d0f-a9d9-b7aaa57360f2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExceptionHandlerSmClass)this.getTarget()).getExceptionTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f2a2b418-22ae-42ed-a08e-ffdac8153dab")
    public static class ObjectSmDependency extends SmMultipleDependency {
        @objid ("25720add-61a9-44a6-9c87-69910ee624c5")
        private SmDependency symetricDep;

        @objid ("d369846d-b411-4933-9798-ccd9fb32d9ae")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((GeneralClassData)data).mObject != null)? ((GeneralClassData)data).mObject:SmMultipleDependency.EMPTY;
        }

        @objid ("ae64fcba-58f5-4780-8f01-a459969a4220")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((GeneralClassData) data).mObject = values;

        }

        @objid ("4b190a91-c25c-48c2-8134-6e16f090ecd5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AttributeSmClass)this.getTarget()).getTypeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("25bdde2b-3763-4477-a05c-e1dc912cf5c3")
    public static class SRepresentationSmDependency extends SmMultipleDependency {
        @objid ("89064616-8d88-4444-b9c2-5e9af5eb1dd8")
        private SmDependency symetricDep;

        @objid ("024d38a8-a98c-4192-9a70-b40c96402af0")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((GeneralClassData)data).mSRepresentation != null)? ((GeneralClassData)data).mSRepresentation:SmMultipleDependency.EMPTY;
        }

        @objid ("d75778e6-2968-438c-ab0d-ac905838dc54")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((GeneralClassData) data).mSRepresentation = values;

        }

        @objid ("d1b1376d-cb0b-4e77-a19c-4ff2f06eff5c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getBaseDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("56b6af7a-3f00-406b-87c5-05724138b775")
    public static class OccurenceObjectNodeSmDependency extends SmMultipleDependency {
        @objid ("d105de57-b64f-4329-a856-6ebc10954faa")
        private SmDependency symetricDep;

        @objid ("aca2a3f5-48d0-4e5c-91cf-14506a305e67")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((GeneralClassData)data).mOccurenceObjectNode != null)? ((GeneralClassData)data).mOccurenceObjectNode:SmMultipleDependency.EMPTY;
        }

        @objid ("3768849b-7eea-4ff8-8347-62b8cd6c939f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((GeneralClassData) data).mOccurenceObjectNode = values;

        }

        @objid ("ae6c257a-664e-42bf-a172-45184b25ad77")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ObjectNodeSmClass)this.getTarget()).getTypeDep();
            }
            return this.symetricDep;

        }

    }

}
