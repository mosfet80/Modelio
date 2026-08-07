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
import org.modelio.metamodel.impl.uml.behavior.communicationModel.CommunicationChannelSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.LinkEnd;
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

@objid ("d2454b12-e12b-41af-b5aa-cc2f011ab2ab")
public class LinkSmClass extends UmlModelElementSmClass {
    @objid ("2bb9ca21-25cf-41d1-bc74-cefb97702aa9")
    private SmDependency modelDep;

    @objid ("f0ea3d91-f385-48c4-9820-51688b3f7e2e")
    private SmDependency linkEndDep;

    @objid ("df009595-bdff-4e83-937b-0506b4f64b02")
    private SmDependency sentDep;

    @objid ("f34c30ff-e589-4594-b330-2d4e4cbb1241")
    public LinkSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("43289594-feed-4632-88e6-80bdb5cbb388")
    @Override
    public String getName() {
        return "Link";

    }

    @objid ("5f6d8ba0-9dbf-4dec-9951-99fd022977dd")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d5e5c321-1a99-4e0e-8438-c4eea202823a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Link.class;

    }

    @objid ("9d87dae3-0074-47fe-a6c7-6edfa8fd3cdd")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("89071b58-4f99-4611-bece-76f57ace7559")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1e55aa31-a19e-42bd-8dd7-621bdf8a0778")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new LinkObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.modelDep = new ModelSmDependency();
        this.modelDep.init("Model", this, metamodel.getMClass(Association.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.modelDep);

        this.linkEndDep = new LinkEndSmDependency();
        this.linkEndDep.init("LinkEnd", this, metamodel.getMClass(LinkEnd.MQNAME), 2, 2 );
        registerDependency(this.linkEndDep);

        this.sentDep = new SentSmDependency();
        this.sentDep.init("Sent", this, metamodel.getMClass(CommunicationChannel.MQNAME), 0, 1 );
        registerDependency(this.sentDep);

    }

    @objid ("1280096e-b855-46b6-bfa6-b74078d595c6")
    public SmDependency getModelDep() {
        if (this.modelDep == null) {
        	this.modelDep = this.getDependencyDef("Model");
        }
        return this.modelDep;
    }

    @objid ("d5c8d2c7-f240-48f7-916d-705a63d85428")
    public SmDependency getLinkEndDep() {
        if (this.linkEndDep == null) {
        	this.linkEndDep = this.getDependencyDef("LinkEnd");
        }
        return this.linkEndDep;
    }

    @objid ("add6d366-75c2-4c77-ab87-60fc23855411")
    public SmDependency getSentDep() {
        if (this.sentDep == null) {
        	this.sentDep = this.getDependencyDef("Sent");
        }
        return this.sentDep;
    }

    @objid ("a2b2c62c-fbf9-4bd1-a112-0aeda472b084")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("1833ca8a-f3f5-4b15-8f0b-2734bb6afd57")
    private static class LinkObjectFactory implements ISmObjectFactory {
        @objid ("3d73b5cd-c02e-42d1-8990-ba9d38c3e6ee")
        private LinkSmClass smClass;

        @objid ("7a228ee1-d496-44bc-9737-42fe2b5c5ec3")
        public LinkObjectFactory(LinkSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("bc743a9c-4ee6-4c8b-8e7a-e73eb1b9f817")
        @Override
        public ISmObjectData createData() {
            return new LinkData(this.smClass);
        }

        @objid ("5db3e6fc-16ca-4b41-a600-61e9c369d324")
        @Override
        public SmObjectImpl createImpl() {
            return new LinkImpl();
        }

    }

    @objid ("ec54e2b2-6109-4168-91a0-5eefd848bcd5")
    public static class ModelSmDependency extends SmSingleDependency {
        @objid ("0c98052b-100c-4e74-916e-df9f87974d6f")
        private SmDependency symetricDep;

        @objid ("d20d28a1-53be-404c-9db4-6f756113354e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkData) data).mModel;
        }

        @objid ("ed1c7f02-5d01-47a9-b183-4fba3ce93572")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkData) data).mModel = value;
        }

        @objid ("d4fc40df-3f52-4e8d-b6ab-86e0fb8bd5b1")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationSmClass)this.getTarget()).getOccurenceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5403eb98-43c7-459d-9dbe-56dcf6991d37")
    public static class LinkEndSmDependency extends SmMultipleDependency {
        @objid ("ab734319-d53a-440d-9152-fbac5b2581fd")
        private SmDependency symetricDep;

        @objid ("f665bff4-57be-4c85-956d-dd35a59d99d6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((LinkData)data).mLinkEnd != null)? ((LinkData)data).mLinkEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("3d3a388a-5876-4907-a81c-2e3dde661170")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((LinkData) data).mLinkEnd = values;

        }

        @objid ("7e31fbcb-a77d-4116-841d-c3906c1c50f4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getLinkDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c74a8f11-fb0e-48ed-a6d6-af99d808d2a5")
    public static class SentSmDependency extends SmSingleDependency {
        @objid ("49b52518-a07d-4a96-959b-0c8dc4896976")
        private SmDependency symetricDep;

        @objid ("00e96b31-5e42-44c1-9d14-6af0a0d84575")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkData) data).mSent;
        }

        @objid ("16542497-78ed-4baf-8409-25ba817a3f56")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkData) data).mSent = value;
        }

        @objid ("803c43bb-30a2-4465-a235-62a93a37b190")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationChannelSmClass)this.getTarget()).getChannelDep();
            }
            return this.symetricDep;

        }

    }

}
