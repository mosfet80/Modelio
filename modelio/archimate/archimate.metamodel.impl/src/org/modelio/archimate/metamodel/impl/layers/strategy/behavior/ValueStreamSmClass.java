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
package org.modelio.archimate.metamodel.impl.layers.strategy.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.strategy.behavior.StrategyBehaviorElement;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f9793670-15b2-4933-a0c8-5a00aafdfd21")
public class ValueStreamSmClass extends StrategyBehaviorElementSmClass {
    @objid ("877ed4c6-5cac-4995-b5da-ae979368cb73")
    public ValueStreamSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("166212e7-8136-4580-a95f-4b4cd4d4df64")
    @Override
    public String getName() {
        return "ValueStream";

    }

    @objid ("7f9ef212-01f9-4c28-a540-b74da3699cc5")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("534df7e4-1e7e-4b88-8bd4-a4d680f54d0e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ValueStream.class;

    }

    @objid ("393951db-3fbf-4687-adf9-c240022656de")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("e85d44e8-3e72-4bc3-8d41-1c9baa27492e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("035abb21-8a49-4c83-bdf5-d9b76ece9ec6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StrategyBehaviorElement.MQNAME);
        this.registerFactory(new ValueStreamObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("74f6dac1-f246-430a-b337-fb3efbc45b69")
    private static class ValueStreamObjectFactory implements ISmObjectFactory {
        @objid ("6bde9548-110b-4502-b050-65eb06d00799")
        private ValueStreamSmClass smClass;

        @objid ("80930f07-643c-405c-b3f4-70fe59ce9452")
        public ValueStreamObjectFactory(ValueStreamSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("cbfa59f8-c7fe-43b4-b429-5d1515802aed")
        @Override
        public ISmObjectData createData() {
            return new ValueStreamData(this.smClass);
        }

        @objid ("d6709311-7c92-40eb-8dfd-ca916d03d648")
        @Override
        public SmObjectImpl createImpl() {
            return new ValueStreamImpl();
        }

    }

}
