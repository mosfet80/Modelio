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
import org.modelio.archimate.metamodel.layers.strategy.behavior.CourseOfAction;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("00a8b31b-bcc1-423c-98f9-e50626959edf")
public class CourseOfActionSmClass extends BehaviorElementSmClass {
    @objid ("2d943eeb-fd8a-4c5d-808d-b7b1c8306abd")
    public CourseOfActionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("551b7f48-ac4a-4d51-ba3c-796c8beff20f")
    @Override
    public String getName() {
        return "CourseOfAction";

    }

    @objid ("6f5bdb4d-688a-4fca-96d2-e3def926bc86")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("08dcca0a-6f0d-4b58-a87e-77f4892bcac3")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CourseOfAction.class;

    }

    @objid ("a354cd0c-9650-4236-92a8-635302be7b0b")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("70b29557-b6d5-446d-9e0a-a309432732c6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("57e3cc77-e7b8-417f-806c-f94247529a6d")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorElement.MQNAME);
        this.registerFactory(new CourseOfActionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a5b04592-deb9-4163-860a-a40559c4acb4")
    private static class CourseOfActionObjectFactory implements ISmObjectFactory {
        @objid ("e7430f26-bc51-43ae-9ab2-819845cddea3")
        private CourseOfActionSmClass smClass;

        @objid ("505ff1b8-75a5-4162-8871-53f36ce8bc42")
        public CourseOfActionObjectFactory(CourseOfActionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("846ef0ce-1e88-4243-8126-78e8d5c13799")
        @Override
        public ISmObjectData createData() {
            return new CourseOfActionData(this.smClass);
        }

        @objid ("7ffb2a29-0a50-497f-b06c-dd5931932d6a")
        @Override
        public SmObjectImpl createImpl() {
            return new CourseOfActionImpl();
        }

    }

}
