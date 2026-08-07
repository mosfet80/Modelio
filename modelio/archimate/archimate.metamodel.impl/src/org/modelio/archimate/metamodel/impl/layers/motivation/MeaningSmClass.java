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
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b6f23fa1-caa4-4f66-8934-cfd101231985")
public class MeaningSmClass extends MotivationElementSmClass {
    @objid ("d6dbd1ba-6a36-4930-a2db-f860ec4cda67")
    private SmAttribute equivalentRefAtt;

    @objid ("4d3bf413-9d07-4653-a028-6c4d4d39383a")
    public MeaningSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("62bfa129-7538-4824-94b6-1ba34396247d")
    @Override
    public String getName() {
        return "Meaning";

    }

    @objid ("cab4a77e-03b5-46ba-8b23-59cbc675245a")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("ba3f86e4-1801-40f0-8a0c-b6a8bceea9c4")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Meaning.class;

    }

    @objid ("00c47d47-794f-41cc-a928-116918ede6b5")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("2c17d794-a362-40fc-9ec0-4fa0758f3578")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ddba8022-6c47-4323-aa85-2a08b82cc3cf")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new MeaningObjectFactory(this));


        // Initialize and register the SmAttribute
        this.equivalentRefAtt = new EquivalentRefSmAttribute();
        this.equivalentRefAtt.init("EquivalentRef", this, String.class );
        registerAttribute(this.equivalentRefAtt);


        // Initialize and register the SmDependency

    }

    @objid ("c6a363ad-2b6e-46d8-ac6f-5ef99efc3b88")
    public SmAttribute getEquivalentRefAtt() {
        if (this.equivalentRefAtt == null) {
        	this.equivalentRefAtt = this.getAttributeDef("EquivalentRef");
        }
        return this.equivalentRefAtt;
    }

    @objid ("0740163b-9546-4113-ae6d-8562deae519c")
    private static class MeaningObjectFactory implements ISmObjectFactory {
        @objid ("9713b145-5831-4ac6-9089-9712762f452e")
        private MeaningSmClass smClass;

        @objid ("01ee9e96-85bb-4dbd-883e-406b46a9a3b0")
        public MeaningObjectFactory(MeaningSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9d39e126-4742-42de-be18-7f5791c94e69")
        @Override
        public ISmObjectData createData() {
            return new MeaningData(this.smClass);
        }

        @objid ("f26d845b-32af-4b28-8ebc-f7e6466d332d")
        @Override
        public SmObjectImpl createImpl() {
            return new MeaningImpl();
        }

    }

    @objid ("34947386-182c-4ee1-b7a9-c189837e060f")
    public static class EquivalentRefSmAttribute extends SmAttribute {
        @objid ("3eafdb71-7460-4466-a474-fa677a80ba30")
        public Object getValue(ISmObjectData data) {
            return ((MeaningData) data).mEquivalentRef;
        }

        @objid ("9dc2876c-e714-4b8f-ba1f-398d3f66af06")
        public void setValue(ISmObjectData data, Object value) {
            ((MeaningData) data).mEquivalentRef = value;
        }

    }

}
