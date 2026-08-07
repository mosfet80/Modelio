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
package org.modelio.archimate.metamodel.impl.layers.technology.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyProcess;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("40fdcf4d-e3c3-44dc-9f53-13039b934b01")
public class TechnologyProcessSmClass extends TechnologyInternalBehaviorElementSmClass {
    @objid ("ae8e958b-c050-4384-a27a-a4f28e834226")
    public TechnologyProcessSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f3ed5efc-6212-45c9-b369-b4fc7eae694f")
    @Override
    public String getName() {
        return "TechnologyProcess";

    }

    @objid ("2f4cf447-40c9-4712-9ebd-a2adca3a8b5a")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("5fb018dd-957e-4fd2-8f44-b5b1cbc13b17")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyProcess.class;

    }

    @objid ("a41b6757-15bc-41d5-93d5-f89e4b2bdd07")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("7301b26a-e2a9-4da1-ad42-dec14b5a0ac0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("bac7d241-f8ee-4962-bf8c-ecfda99a5e7b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyInternalBehaviorElement.MQNAME);
        this.registerFactory(new TechnologyProcessObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("e1ecc807-c4c7-4c9f-889a-960eec21cad8")
    private static class TechnologyProcessObjectFactory implements ISmObjectFactory {
        @objid ("3b05d725-3a81-4461-8835-09ee23a8ca4e")
        private TechnologyProcessSmClass smClass;

        @objid ("c82629e0-8e76-42d9-8ecf-12277f633472")
        public TechnologyProcessObjectFactory(TechnologyProcessSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("46ab915f-bb3f-460a-bd89-60896ad21d51")
        @Override
        public ISmObjectData createData() {
            return new TechnologyProcessData(this.smClass);
        }

        @objid ("d37a8f17-c6c1-4a9d-b0d0-84854ecf847e")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyProcessImpl();
        }

    }

}
