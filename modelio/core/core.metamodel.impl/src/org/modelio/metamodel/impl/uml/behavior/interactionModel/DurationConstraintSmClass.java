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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.ConstraintSmClass;
import org.modelio.metamodel.uml.behavior.interactionModel.DurationConstraint;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("95b81311-bc2f-4843-a5b2-3126a3d8120e")
public class DurationConstraintSmClass extends ConstraintSmClass {
    @objid ("b85c23ad-bfc9-4738-ab85-0075e2d14bb7")
    private SmAttribute durationMinAtt;

    @objid ("c1f81719-8c00-44f6-b5ed-2861183173da")
    private SmAttribute durationMaxAtt;

    @objid ("eb6d3ce2-c02f-4b98-94f5-c6b878a8d52b")
    public DurationConstraintSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("375b7ecc-5aa0-4614-89bb-8aa548a70a46")
    @Override
    public String getName() {
        return "DurationConstraint";

    }

    @objid ("3f1ba933-7d04-4921-bbca-0540baa2fe3c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("bb8af3ff-c120-4dc7-a5b6-487dce1ef1fd")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DurationConstraint.class;

    }

    @objid ("27fdb071-0858-4f8a-a38d-c942def83522")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("20996ab1-1933-4d33-a4e7-7fa5dc4aeb73")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1697038d-cd77-4dfd-ba99-45f1615df1ab")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Constraint.MQNAME);
        this.registerFactory(new DurationConstraintObjectFactory(this));


        // Initialize and register the SmAttribute
        this.durationMinAtt = new DurationMinSmAttribute();
        this.durationMinAtt.init("DurationMin", this, String.class );
        registerAttribute(this.durationMinAtt);

        this.durationMaxAtt = new DurationMaxSmAttribute();
        this.durationMaxAtt.init("DurationMax", this, String.class );
        registerAttribute(this.durationMaxAtt);


        // Initialize and register the SmDependency

    }

    @objid ("eaabffba-f8a1-40d9-a3c6-a2eee0c8c7e1")
    public SmAttribute getDurationMinAtt() {
        if (this.durationMinAtt == null) {
        	this.durationMinAtt = this.getAttributeDef("DurationMin");
        }
        return this.durationMinAtt;
    }

    @objid ("493a1379-34e2-4223-9a07-724aae192904")
    public SmAttribute getDurationMaxAtt() {
        if (this.durationMaxAtt == null) {
        	this.durationMaxAtt = this.getAttributeDef("DurationMax");
        }
        return this.durationMaxAtt;
    }

    @objid ("1cc61ded-ad57-40f8-9e34-07ba0c439ec8")
    private static class DurationConstraintObjectFactory implements ISmObjectFactory {
        @objid ("9064419d-abcd-4c18-a0e9-66002e704958")
        private DurationConstraintSmClass smClass;

        @objid ("4859d439-bc33-4108-9e36-9a696fc778c8")
        public DurationConstraintObjectFactory(DurationConstraintSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e5c35c99-dd1c-4ab0-9b59-e5524c1fa94d")
        @Override
        public ISmObjectData createData() {
            return new DurationConstraintData(this.smClass);
        }

        @objid ("154f4617-c36c-40d8-8e75-cb1fa0d1e11b")
        @Override
        public SmObjectImpl createImpl() {
            return new DurationConstraintImpl();
        }

    }

    @objid ("7fac19a6-667b-4914-82f7-86f3779f22ea")
    public static class DurationMinSmAttribute extends SmAttribute {
        @objid ("620c1da8-cd34-4ed0-96a6-de802923f610")
        public Object getValue(ISmObjectData data) {
            return ((DurationConstraintData) data).mDurationMin;
        }

        @objid ("5f18dcef-7114-4ac4-a6cf-e21e7686a111")
        public void setValue(ISmObjectData data, Object value) {
            ((DurationConstraintData) data).mDurationMin = value;
        }

    }

    @objid ("512e4abc-329a-4f19-bde5-036722d6c42d")
    public static class DurationMaxSmAttribute extends SmAttribute {
        @objid ("0ac352d0-91cb-40ef-a610-6f9dd942c5c1")
        public Object getValue(ISmObjectData data) {
            return ((DurationConstraintData) data).mDurationMax;
        }

        @objid ("de36390f-9eec-4630-9edb-af3961d0907f")
        public void setValue(ISmObjectData data, Object value) {
            ((DurationConstraintData) data).mDurationMax = value;
        }

    }

}
