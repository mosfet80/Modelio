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
package org.modelio.archimate.metamodel.impl.relationships.dependency;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.AccessMode;
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("466f5a0c-6dad-4ec0-b243-f98493655c13")
public class AccessSmClass extends DependencyRelationshipSmClass {
    @objid ("07056362-5679-4f9a-b9f1-e656a8ea24fa")
    private SmAttribute modeAtt;

    @objid ("272e3da4-c815-4bb8-9121-019bfb0dd7db")
    public AccessSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c68a1c74-cb6e-4bc4-936c-092dc5c114f3")
    @Override
    public String getName() {
        return "Access";

    }

    @objid ("4a9c30e4-d8ee-4ae1-8ee4-0dbd99e6eaff")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("98da27ad-2e9f-439c-9f47-3cc2cc73086c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Access.class;

    }

    @objid ("2abcd06e-9734-4829-b4d4-0959b20d7ec8")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("348f2151-67f5-46fe-98b9-784334c5d68a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1594eedf-9390-4eec-af38-4764802cf637")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(DependencyRelationship.MQNAME);
        this.registerFactory(new AccessObjectFactory(this));


        // Initialize and register the SmAttribute
        this.modeAtt = new ModeSmAttribute();
        this.modeAtt.init("Mode", this, AccessMode.class );
        registerAttribute(this.modeAtt);


        // Initialize and register the SmDependency

    }

    @objid ("8245b079-e373-4897-98a5-314c82342070")
    public SmAttribute getModeAtt() {
        if (this.modeAtt == null) {
        	this.modeAtt = this.getAttributeDef("Mode");
        }
        return this.modeAtt;
    }

    @objid ("a88d8188-7c40-4b30-b663-31b3fbeca6e2")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("692593e7-1b5b-458d-808c-70299954de60")
    private static class AccessObjectFactory implements ISmObjectFactory {
        @objid ("2d17a18a-8cef-4b17-bcfd-3cbc264569b5")
        private AccessSmClass smClass;

        @objid ("c47395d4-1f43-471d-89c0-b1124ca82cf3")
        public AccessObjectFactory(AccessSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3fbb5ef3-27a9-4998-863c-05578af23666")
        @Override
        public ISmObjectData createData() {
            return new AccessData(this.smClass);
        }

        @objid ("de4ec61c-953d-43ac-b197-98c42b1984b1")
        @Override
        public SmObjectImpl createImpl() {
            return new AccessImpl();
        }

    }

    @objid ("80dbed1f-3898-48a6-aa54-faf5c663a051")
    public static class ModeSmAttribute extends SmAttribute {
        @objid ("d5cb038a-b90e-4bc5-8f5a-ed1ad4904132")
        public Object getValue(ISmObjectData data) {
            return ((AccessData) data).mMode;
        }

        @objid ("72e96e1c-98ef-41d8-bac3-0ff0e2f59dba")
        public void setValue(ISmObjectData data, Object value) {
            ((AccessData) data).mMode = value;
        }

    }

}
