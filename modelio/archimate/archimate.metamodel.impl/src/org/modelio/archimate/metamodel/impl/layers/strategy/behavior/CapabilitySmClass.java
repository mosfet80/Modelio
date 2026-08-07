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
import org.modelio.archimate.metamodel.layers.strategy.behavior.Capability;
import org.modelio.archimate.metamodel.layers.strategy.behavior.StrategyBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("13682fd2-ce1b-47a4-be31-bf32e065ac5d")
public class CapabilitySmClass extends StrategyBehaviorElementSmClass {
    @objid ("d5ebf35a-c842-400f-876d-376dea14cd8e")
    public CapabilitySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("86355a5d-777d-4fef-9fc5-3af377bf2245")
    @Override
    public String getName() {
        return "Capability";

    }

    @objid ("6bb87795-21ae-48ba-864a-a69f29727f37")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("cd822d29-a306-470b-ab59-afaa22bbdf83")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Capability.class;

    }

    @objid ("62541c96-be18-4f62-a0ab-350a929db8c5")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("dddde1ee-b66c-4af5-95fb-becd0190dd2b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8f304f1c-54d7-48ed-8fbe-f0bca9009947")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StrategyBehaviorElement.MQNAME);
        this.registerFactory(new CapabilityObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("5123493a-78f1-4397-944c-2b870c147a79")
    private static class CapabilityObjectFactory implements ISmObjectFactory {
        @objid ("0d48eca0-f253-496c-8936-ae3968fa222e")
        private CapabilitySmClass smClass;

        @objid ("f8014fbb-8c0d-4650-bfb1-94541c07d1b0")
        public CapabilityObjectFactory(CapabilitySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5ff44cb9-7458-464d-aeb0-dba96c2ddd9a")
        @Override
        public ISmObjectData createData() {
            return new CapabilityData(this.smClass);
        }

        @objid ("a11b4ee1-d6e6-4f5c-ae9d-7a31e22b866a")
        @Override
        public SmObjectImpl createImpl() {
            return new CapabilityImpl();
        }

    }

}
