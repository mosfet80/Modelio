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
import org.modelio.archimate.metamodel.layers.motivation.Outcome;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("fcf3ffa1-5ecf-4a3e-9321-504d92614988")
public class OutcomeSmClass extends MotivationElementSmClass {
    @objid ("d8e3421d-49a6-43ae-ba75-74e916adc60c")
    public OutcomeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("30f47b2e-0a02-4af2-a233-7c3ef518207b")
    @Override
    public String getName() {
        return "Outcome";

    }

    @objid ("15a715af-df9c-4407-a19f-33651381d605")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("7a692173-52d0-4477-9f28-847c3a0124ca")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Outcome.class;

    }

    @objid ("b45e7b65-edc4-44a6-a6f0-4e97abffc4f2")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("a40511ab-07a6-4d46-bd94-1cd25d45483d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e88b60da-341d-4a19-ae06-ab07139fe5ed")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new OutcomeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c620e4ea-1d05-4330-86ef-55ad0b22d14a")
    private static class OutcomeObjectFactory implements ISmObjectFactory {
        @objid ("bccf7de9-6357-4c88-920c-79a3d682cdde")
        private OutcomeSmClass smClass;

        @objid ("1b114398-4c91-42c7-a3ae-86fae427eab1")
        public OutcomeObjectFactory(OutcomeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a96e5172-ae38-40c1-9cd5-15ab388494cf")
        @Override
        public ISmObjectData createData() {
            return new OutcomeData(this.smClass);
        }

        @objid ("913e1fc7-5fa6-4121-8bd8-7cfb067bcdcb")
        @Override
        public SmObjectImpl createImpl() {
            return new OutcomeImpl();
        }

    }

}
