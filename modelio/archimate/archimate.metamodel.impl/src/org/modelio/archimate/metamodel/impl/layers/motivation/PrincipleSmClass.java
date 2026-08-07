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
import org.modelio.archimate.metamodel.layers.motivation.Principle;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a223e194-a357-4ab6-8fb6-fa99aa457328")
public class PrincipleSmClass extends MotivationElementSmClass {
    @objid ("5806ee2a-209f-4b13-ab1d-586dd4e6ec0c")
    public PrincipleSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("66439254-8de6-427e-9cf3-eddc252eaa70")
    @Override
    public String getName() {
        return "Principle";

    }

    @objid ("d2b40f58-f78e-49c8-bce8-28c59fcd9a5b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("baabf10a-9226-49eb-a0d7-b343a6fb6c27")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Principle.class;

    }

    @objid ("f2a11be7-0c39-4539-9efe-e02e3e75eb54")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("a74f0c85-59d3-40ce-9cfb-d1bdd59fb970")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("fffa1fa0-9756-49a7-9aac-4a142abd50da")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new PrincipleObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("8cd2fc79-4186-4292-801a-e0f59d67fb25")
    private static class PrincipleObjectFactory implements ISmObjectFactory {
        @objid ("971af9ae-ba4e-4d1a-aa66-9adffb23ce2a")
        private PrincipleSmClass smClass;

        @objid ("51cf737b-7e7c-4864-9715-48483e76efd4")
        public PrincipleObjectFactory(PrincipleSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1932cfcd-c25d-4b4d-9164-7da50bb1691f")
        @Override
        public ISmObjectData createData() {
            return new PrincipleData(this.smClass);
        }

        @objid ("1a9beb39-f9c3-4807-bf7a-952e2ca57dd0")
        @Override
        public SmObjectImpl createImpl() {
            return new PrincipleImpl();
        }

    }

}
