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
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("5c9c2e99-20aa-449c-b271-b7ff7cabc588")
public class GoalSmClass extends MotivationElementSmClass {
    @objid ("8f01c317-dec6-45c0-9dc4-91b50c71b899")
    private SmAttribute equivalentRefAtt;

    @objid ("aee63501-6bea-4507-8a7c-b0e1ff23948f")
    public GoalSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1e43db1a-18b0-4f33-9519-6de1f26ff6cf")
    @Override
    public String getName() {
        return "Goal";

    }

    @objid ("6f3bac6a-4406-4a00-823c-c9444227f82e")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("f825a9d6-6679-493d-8c95-300cdf193f2a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Goal.class;

    }

    @objid ("6c436bd1-323a-403e-9122-4ab5f816dbcf")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("b84502ea-4f6a-4556-ad98-f81a6a6518d3")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("93285305-508d-45ff-a758-263ee7278070")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new GoalObjectFactory(this));


        // Initialize and register the SmAttribute
        this.equivalentRefAtt = new EquivalentRefSmAttribute();
        this.equivalentRefAtt.init("EquivalentRef", this, String.class );
        registerAttribute(this.equivalentRefAtt);


        // Initialize and register the SmDependency

    }

    @objid ("e024abe6-4dc3-4c00-8e7c-ac96d1fc73f8")
    public SmAttribute getEquivalentRefAtt() {
        if (this.equivalentRefAtt == null) {
        	this.equivalentRefAtt = this.getAttributeDef("EquivalentRef");
        }
        return this.equivalentRefAtt;
    }

    @objid ("bde03476-9bac-431e-8d67-aea8ce767464")
    private static class GoalObjectFactory implements ISmObjectFactory {
        @objid ("6918d0b2-524a-4f3d-aca4-4edd8edc4fcd")
        private GoalSmClass smClass;

        @objid ("6a12ee1b-cf49-4f3e-986e-75da7ab28d75")
        public GoalObjectFactory(GoalSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("21e56f64-0b3d-477f-86d6-5ffb1e6838f0")
        @Override
        public ISmObjectData createData() {
            return new GoalData(this.smClass);
        }

        @objid ("b210f2a6-10d9-48de-b0cc-cff9789227f7")
        @Override
        public SmObjectImpl createImpl() {
            return new GoalImpl();
        }

    }

    @objid ("49ddbb06-0448-49b6-b433-a9d039c35512")
    public static class EquivalentRefSmAttribute extends SmAttribute {
        @objid ("411daeb5-5076-4ab1-8d18-145c98419b45")
        public Object getValue(ISmObjectData data) {
            return ((GoalData) data).mEquivalentRef;
        }

        @objid ("423176d8-748c-485c-a746-956b360d164f")
        public void setValue(ISmObjectData data, Object value) {
            ((GoalData) data).mEquivalentRef = value;
        }

    }

}
