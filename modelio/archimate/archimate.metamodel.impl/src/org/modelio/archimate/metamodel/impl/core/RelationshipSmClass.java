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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f1323911-f618-4386-9d28-0654cf35463d")
public class RelationshipSmClass extends ConceptSmClass {
    @objid ("00b84eba-fa32-4aae-b58c-237d84628c65")
    private SmDependency toDep;

    @objid ("7679e8f5-1ad8-4ba7-a41f-3df0b9115c25")
    private SmDependency fromDep;

    @objid ("af85d5b4-857f-4868-8702-651b4a5d899f")
    public RelationshipSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("505c3c8d-afc4-4eaf-ac0d-fe9679bee42c")
    @Override
    public String getName() {
        return "Relationship";

    }

    @objid ("2ec619f2-8be4-45f9-8f0c-cb1f046ed3d0")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("264088e6-c336-4a57-a2b8-04ec98403246")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Relationship.class;

    }

    @objid ("aee3e394-38ed-4690-93ff-0dfe2bfa6618")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0c5e2ad2-c303-42a2-98ae-1b092acd661d")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("67843f7a-78f9-4c7e-8c69-2f26de15f6cb")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Concept.MQNAME);
        this.registerFactory(new RelationshipObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.toDep = new ToSmDependency();
        this.toDep.init("to", this, metamodel.getMClass(Concept.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.toDep);

        this.fromDep = new FromSmDependency();
        this.fromDep.init("from", this, metamodel.getMClass(Concept.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.fromDep);

    }

    @objid ("1c247ab7-4bd5-44c3-bf33-1da1e5b64178")
    public SmDependency getToDep() {
        if (this.toDep == null) {
        	this.toDep = this.getDependencyDef("to");
        }
        return this.toDep;
    }

    @objid ("a0505e57-1485-43e4-a892-cd8cb1ecbde6")
    public SmDependency getFromDep() {
        if (this.fromDep == null) {
        	this.fromDep = this.getDependencyDef("from");
        }
        return this.fromDep;
    }

    @objid ("10418d0d-5563-41f4-b148-f208427d75cc")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("e6b6367d-1d71-467a-a1a5-cdc5c3f84755")
    private static class RelationshipObjectFactory implements ISmObjectFactory {
        @objid ("4bf9ac5b-a816-45bc-8282-d7ec96d074f3")
        private RelationshipSmClass smClass;

        @objid ("b96d8c59-e808-420a-b23c-cb760143fae0")
        public RelationshipObjectFactory(RelationshipSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("73f30d8d-b66e-4598-8c1b-3762a113522f")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("d8b59f76-33c3-40b8-83e3-5be18dd69257")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("7e3e321d-4b08-4f18-9c40-bb53edaee27b")
    public static class ToSmDependency extends SmSingleDependency {
        @objid ("a7aaf046-afc9-4715-86b3-2fd1b215d4ed")
        private SmDependency symetricDep;

        @objid ("3081ead0-71ef-46b1-a753-150d2d834b6a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((RelationshipData) data).mTo;
        }

        @objid ("ed486d2c-61fe-4cb0-96b9-a0f28f3af149")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((RelationshipData) data).mTo = value;
        }

        @objid ("2653b32d-312f-4f28-8bcb-46402f9b4281")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConceptSmClass)this.getTarget()).getRelatedFromDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("562e0116-2de8-4bc6-a72c-d4d6e0ce8917")
    public static class FromSmDependency extends SmSingleDependency {
        @objid ("ddc25b37-4dfa-4dae-b70b-4807e5b910ee")
        private SmDependency symetricDep;

        @objid ("e504a1ca-269f-4372-b741-92a12a9f139b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((RelationshipData) data).mFrom;
        }

        @objid ("7b37bece-6592-47d8-9552-b386404937a0")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((RelationshipData) data).mFrom = value;
        }

        @objid ("ceee5e29-4b18-4633-b53c-090599cc5a7b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConceptSmClass)this.getTarget()).getRelatedToDep();
            }
            return this.symetricDep;

        }

    }

}
