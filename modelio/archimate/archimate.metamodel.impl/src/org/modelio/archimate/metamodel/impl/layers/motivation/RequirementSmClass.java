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
package org.modelio.archimate.metamodel.impl.layers.motivation;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;
import org.modelio.archimate.metamodel.impl.core.generic.motivation.MotivationElementSmClass;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("36a03a80-4bfe-4c13-834c-299d4dcae1e2")
public class RequirementSmClass extends MotivationElementSmClass {
    @objid ("78a0f5c5-0ca8-4513-9df1-1be33c3b6995")
    private SmAttribute equivalentRefAtt;

    @objid ("a50fd449-8937-4ac3-9c1a-537c201a290a")
    public RequirementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("864503d9-b96b-47da-89e9-4950890230c0")
    @Override
    public String getName() {
        return "Requirement";

    }

    @objid ("e0f17909-db1b-4dff-9a7e-5aee1f176f28")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("b206d355-7fd5-45d9-a592-17c666fe5771")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Requirement.class;

    }

    @objid ("3528fac2-fa28-418e-ab12-bb2a3ece6bcc")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("ec874dea-bf67-4002-a73e-236cc1245f61")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("30cb4d59-d31e-4c31-a4f6-efa7cb3917a4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new RequirementObjectFactory(this));


        // Initialize and register the SmAttribute
        this.equivalentRefAtt = new EquivalentRefSmAttribute();
        this.equivalentRefAtt.init("EquivalentRef", this, String.class );
        registerAttribute(this.equivalentRefAtt);


        // Initialize and register the SmDependency

    }

    @objid ("a62b87fd-583b-44fa-ae1b-5ddf5d9b7935")
    public SmAttribute getEquivalentRefAtt() {
        if (this.equivalentRefAtt == null) {
        	this.equivalentRefAtt = this.getAttributeDef("EquivalentRef");
        }
        return this.equivalentRefAtt;
    }

    @objid ("b0073c07-48d6-4971-a32a-1fa8ac8f56c4")
    private static class RequirementObjectFactory implements ISmObjectFactory {
        @objid ("11265b6e-c758-4176-975e-f6c7193f13e1")
        private RequirementSmClass smClass;

        @objid ("2a3f3cce-1458-4cda-aa22-b479e9769dc6")
        public RequirementObjectFactory(RequirementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f80027c8-8465-48b5-8071-681f30e809a1")
        @Override
        public ISmObjectData createData() {
            return new RequirementData(this.smClass);
        }

        @objid ("2cd7d4d6-4f55-4c7e-846f-5af66b2e0d21")
        @Override
        public SmObjectImpl createImpl() {
            return new RequirementImpl();
        }

    }

    @objid ("7a7f7ce9-95e6-4f1a-a5ec-546f7875e4e6")
    public static class EquivalentRefSmAttribute extends SmAttribute {
        @objid ("308866bd-aab6-4b37-a9e1-bb3100a53664")
        public Object getValue(ISmObjectData data) {
            return ((RequirementData) data).mEquivalentRef;
        }

        @objid ("f71f212e-876b-4fd4-b6ae-9ec5ee33bd45")
        public void setValue(ISmObjectData data, Object value) {
            ((RequirementData) data).mEquivalentRef = value;
        }

    }

}
