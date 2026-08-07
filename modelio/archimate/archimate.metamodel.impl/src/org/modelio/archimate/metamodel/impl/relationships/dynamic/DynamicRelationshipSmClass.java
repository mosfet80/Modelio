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
package org.modelio.archimate.metamodel.impl.relationships.dynamic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.impl.core.RelationshipSmClass;
import org.modelio.archimate.metamodel.relationships.dynamic.DynamicRelationship;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("4f48911f-d256-43d1-89eb-c586922c23ad")
public class DynamicRelationshipSmClass extends RelationshipSmClass {
    @objid ("9d5a66a4-7a19-4a4e-a199-82430ecbf26a")
    public DynamicRelationshipSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a3bbfbe8-2e30-4e23-98b7-0906157933e8")
    @Override
    public String getName() {
        return "DynamicRelationship";

    }

    @objid ("c535335e-3729-4cf5-b849-71bf98cdae01")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("22bf15c4-a683-4407-8fde-6553caaf563f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DynamicRelationship.class;

    }

    @objid ("10906560-d0c3-47d7-9a33-268036096fba")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("2770733c-2e56-4f0e-aba6-14ac264a17ed")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("4e74225e-a856-4725-8d5d-b33da152a45e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Relationship.MQNAME);
        this.registerFactory(new DynamicRelationshipObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("8d9f0916-8ea4-4c20-aaa6-5fea7c9b7ea6")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("d59a33cf-3efe-47a1-8b77-5a0808881e1d")
    private static class DynamicRelationshipObjectFactory implements ISmObjectFactory {
        @objid ("212e947e-2eb7-4538-88b2-9863c82c9def")
        private DynamicRelationshipSmClass smClass;

        @objid ("646dfdfd-a64a-43ef-9952-37db177b9eaf")
        public DynamicRelationshipObjectFactory(DynamicRelationshipSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("932f3da3-ee4d-4d45-bfe6-576f348063fd")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("b110379a-d99b-4958-87c3-633f75861620")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
