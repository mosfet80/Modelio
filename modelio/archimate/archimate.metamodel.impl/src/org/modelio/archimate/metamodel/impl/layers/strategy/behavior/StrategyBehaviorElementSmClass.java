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
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.BehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.strategy.behavior.StrategyBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0a782390-226e-4a20-af7d-66d683b2dab6")
public class StrategyBehaviorElementSmClass extends BehaviorElementSmClass {
    @objid ("c257aac5-68fb-4325-bcd0-dcd99b0c2aa8")
    public StrategyBehaviorElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("04c3184b-1223-4ddb-81a6-a29e5077fad0")
    @Override
    public String getName() {
        return "StrategyBehaviorElement";

    }

    @objid ("5a4029b5-8485-4d90-a760-d5cb65d4ea96")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("cfe72e03-669f-4147-b54c-5c11e66255da")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StrategyBehaviorElement.class;

    }

    @objid ("fac8bea7-78f0-4577-973e-4841926c0e2c")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("4a9dfc2a-d5c8-4224-8a8c-13ed02ff80e5")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("2723a166-868e-442e-9c6d-f2bc21a4e320")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorElement.MQNAME);
        this.registerFactory(new StrategyBehaviorElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f4926f89-e80d-443c-a4a6-034ccd25c33b")
    private static class StrategyBehaviorElementObjectFactory implements ISmObjectFactory {
        @objid ("78287343-a2e9-4683-af32-367461777014")
        private StrategyBehaviorElementSmClass smClass;

        @objid ("186a7148-190d-460d-b0f2-ccad3aa5fbe2")
        public StrategyBehaviorElementObjectFactory(StrategyBehaviorElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("74dd55d1-8dc6-45c9-b4ce-337bfab02eda")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("5a3549e4-6c58-48f3-bb87-74441831b3ae")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
