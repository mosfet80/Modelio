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
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f5b77ef0-cb1f-4ba4-8f21-d48635ea9924")
public class TechnologyFunctionSmClass extends TechnologyInternalBehaviorElementSmClass {
    @objid ("926a49ac-34a6-4711-88ef-91ff374212b1")
    public TechnologyFunctionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("d70403d4-eee6-49c0-85f0-70801e769e50")
    @Override
    public String getName() {
        return "TechnologyFunction";

    }

    @objid ("5eb2ac2d-21ba-45c4-b086-b5a15b4c7aa7")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("bec20921-10f6-4ec5-ac5f-db48ed1d54db")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyFunction.class;

    }

    @objid ("13143722-c64d-4774-93a0-26d2faaadc65")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("be89d239-271f-4622-8222-a2cd2f78bfd9")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e5822b64-b6c3-4fa2-bde0-3d876c875416")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyInternalBehaviorElement.MQNAME);
        this.registerFactory(new TechnologyFunctionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("f573894c-6be7-4e1c-8ab5-b40dc8668b4f")
    private static class TechnologyFunctionObjectFactory implements ISmObjectFactory {
        @objid ("b3a73ee0-d137-44de-b6ac-db52c149b4ad")
        private TechnologyFunctionSmClass smClass;

        @objid ("3dea790a-5ff7-4a9d-86a7-1922292125ed")
        public TechnologyFunctionObjectFactory(TechnologyFunctionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("81f36b8c-a319-40c3-836c-669917c129ef")
        @Override
        public ISmObjectData createData() {
            return new TechnologyFunctionData(this.smClass);
        }

        @objid ("e676136f-5eee-459d-b720-ae3e9b60146e")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyFunctionImpl();
        }

    }

}
