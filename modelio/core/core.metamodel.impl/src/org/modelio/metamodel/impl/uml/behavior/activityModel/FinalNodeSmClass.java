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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ControlNode;
import org.modelio.metamodel.uml.behavior.activityModel.FinalNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("6972dd04-ccd1-4e3b-ae02-750fa545ddbb")
public class FinalNodeSmClass extends ControlNodeSmClass {
    @objid ("63320cf1-d39f-4dc0-be15-c5f05242f0d7")
    public FinalNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("651fd930-c7a5-4ff8-ab58-c779705494d2")
    @Override
    public String getName() {
        return "FinalNode";

    }

    @objid ("92e1903f-0ffc-483c-8287-99a3d16bf4a6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("7d50ee4e-c2a4-4d31-a4ed-95ef5b3556a9")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return FinalNode.class;

    }

    @objid ("5f489b83-9a87-4d7e-9b66-3d5adc7d213a")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7e06676e-ce01-487d-8406-10ae18b86f0f")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("fe83dd42-a532-46b5-a583-34fff0a4b847")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ControlNode.MQNAME);
        this.registerFactory(new FinalNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("79ac889c-53b9-4369-a293-0741bc21853e")
    private static class FinalNodeObjectFactory implements ISmObjectFactory {
        @objid ("55d50075-260f-4143-8201-7ed6db35a68f")
        private FinalNodeSmClass smClass;

        @objid ("5c72dfb7-47be-4e3f-b826-dfe7333dd5f5")
        public FinalNodeObjectFactory(FinalNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("0631e3fb-354a-482e-b3ec-513367c9c1d0")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("624a8836-6681-4ca4-84cb-c3732c2c811f")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
