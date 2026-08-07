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
package org.modelio.archimate.metamodel.impl.relationships.other;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.relationships.dependency.DependencyRelationshipSmClass;
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("53e1a2bd-7adb-451f-b9d9-52e9a006f5c4")
public class AssociationSmClass extends DependencyRelationshipSmClass {
    @objid ("e136614c-3dd8-41ab-b73b-0caadcc924b4")
    private SmAttribute directedAtt;

    @objid ("7b8ea235-5336-4781-acc6-f25cd6c6d215")
    public AssociationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1bed155a-2ea3-4683-b014-9d398602084c")
    @Override
    public String getName() {
        return "Association";

    }

    @objid ("ddfa7838-cd42-45b3-844a-30378698e80a")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("07d1f81d-1c17-4383-abbc-f42da44a755e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Association.class;

    }

    @objid ("ae865ec0-29da-4271-881a-11607cb1ce9f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("4d57e460-5a34-49c7-9ac7-890a8fd839a3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6e909371-9e74-4434-a3cd-e6a26378ad95")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(DependencyRelationship.MQNAME);
        this.registerFactory(new AssociationObjectFactory(this));


        // Initialize and register the SmAttribute
        this.directedAtt = new DirectedSmAttribute();
        this.directedAtt.init("Directed", this, Boolean.class );
        registerAttribute(this.directedAtt);


        // Initialize and register the SmDependency

    }

    @objid ("8bb45205-9c09-4e6c-b7c9-e86ed20dbef9")
    public SmAttribute getDirectedAtt() {
        if (this.directedAtt == null) {
        	this.directedAtt = this.getAttributeDef("Directed");
        }
        return this.directedAtt;
    }

    @objid ("a8bef7e5-b66f-41db-97a6-3571eca08ec3")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("948e1029-336e-4807-b2bc-dcd17ca12895")
    private static class AssociationObjectFactory implements ISmObjectFactory {
        @objid ("876a30e1-cd9b-4aca-b8b2-e6941cdcfa30")
        private AssociationSmClass smClass;

        @objid ("2ab62509-df99-4fa6-8bec-cae1ed2b506b")
        public AssociationObjectFactory(AssociationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1aa28605-ae81-4b50-8a02-8b220f257369")
        @Override
        public ISmObjectData createData() {
            return new AssociationData(this.smClass);
        }

        @objid ("7e6954f4-7f81-4387-9863-d764d833d74f")
        @Override
        public SmObjectImpl createImpl() {
            return new AssociationImpl();
        }

    }

    @objid ("60dc5a24-a98d-4a21-af65-ffe8348859d7")
    public static class DirectedSmAttribute extends SmAttribute {
        @objid ("1f83b5a3-bf2d-4a29-8e94-0d0bae8fab58")
        public Object getValue(ISmObjectData data) {
            return ((AssociationData) data).mDirected;
        }

        @objid ("6fb309d3-b613-458f-8c69-15a0489fe6f6")
        public void setValue(ISmObjectData data, Object value) {
            ((AssociationData) data).mDirected = value;
        }

    }

}
