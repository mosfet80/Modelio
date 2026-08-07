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
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("7fa2a06c-6d48-4c5f-9234-0d556a29c8bb")
public class InfluenceSmClass extends DependencyRelationshipSmClass {
    @objid ("3fecabeb-5042-456c-a987-409ffdc37254")
    private SmAttribute strengthAtt;

    @objid ("5985c87c-9123-4c5e-8155-add157c0d5aa")
    public InfluenceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("186a4357-b630-44d1-8a47-b024ecfd7c92")
    @Override
    public String getName() {
        return "Influence";

    }

    @objid ("9be7807d-a4d4-46ca-b161-9f297458bd92")
    @Override
    public Version getVersion() {
        return new Version("1.0.3");
    }

    @objid ("af86dcb9-aa1d-401b-814e-0c23bee79237")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Influence.class;

    }

    @objid ("9b788467-73ed-4166-b358-a606e222652f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("2f8c96e3-9cdb-47b1-9a20-03bb591e937c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ac7ab798-7e72-408a-b74a-c852e1657488")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(DependencyRelationship.MQNAME);
        this.registerFactory(new InfluenceObjectFactory(this));


        // Initialize and register the SmAttribute
        this.strengthAtt = new StrengthSmAttribute();
        this.strengthAtt.init("Strength", this, String.class );
        registerAttribute(this.strengthAtt);


        // Initialize and register the SmDependency

    }

    @objid ("79910260-5e9a-496e-aa33-f25116675f37")
    public SmAttribute getStrengthAtt() {
        if (this.strengthAtt == null) {
        	this.strengthAtt = this.getAttributeDef("Strength");
        }
        return this.strengthAtt;
    }

    @objid ("232e0277-2217-41dc-a375-78ecb3bd2792")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("f2e29ab8-7407-4392-858d-ca3ed7393c7e")
    private static class InfluenceObjectFactory implements ISmObjectFactory {
        @objid ("eada4d9b-b3ac-4ab5-82ea-9859f0239d3d")
        private InfluenceSmClass smClass;

        @objid ("e559fb9c-3b1f-4bfe-8bbe-a04a819c96a0")
        public InfluenceObjectFactory(InfluenceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("26d59743-b512-41f0-aa50-b3a8980b2ca3")
        @Override
        public ISmObjectData createData() {
            return new InfluenceData(this.smClass);
        }

        @objid ("59200813-d39c-4250-86ed-5032a2649c66")
        @Override
        public SmObjectImpl createImpl() {
            return new InfluenceImpl();
        }

    }

    @objid ("2c2797c5-becb-4eda-9344-fae0637a5d08")
    public static class StrengthSmAttribute extends SmAttribute {
        @objid ("f49fa9b3-0cb0-42f9-8ead-ce8da4fd0f23")
        public Object getValue(ISmObjectData data) {
            return ((InfluenceData) data).mStrength;
        }

        @objid ("31194113-8e38-49c9-b66f-e33c7c1e133a")
        public void setValue(ISmObjectData data, Object value) {
            ((InfluenceData) data).mStrength = value;
        }

    }

}
