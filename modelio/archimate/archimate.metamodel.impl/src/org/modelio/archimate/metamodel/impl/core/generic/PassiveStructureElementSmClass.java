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
package org.modelio.archimate.metamodel.impl.core.generic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.StructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("6b4a10bb-16fe-480c-ba50-984b6ccfa0ae")
public class PassiveStructureElementSmClass extends StructureElementSmClass {
    @objid ("ad4134ef-b3eb-4cdb-bd9b-c24271304b92")
    public PassiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("aa9a9540-d886-448a-9bfa-4d2d5f055054")
    @Override
    public String getName() {
        return "PassiveStructureElement";

    }

    @objid ("2d09feb5-218c-4025-863b-9baccfcc49af")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("d881c88b-8521-4a83-9c9a-693c7376895c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return PassiveStructureElement.class;

    }

    @objid ("bdb1348d-9c5c-4871-90ee-32d67d874d10")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("107daec7-abd2-4632-aad2-ed0fb7ce7f28")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("b9e74e08-806e-4180-bcb2-1e0fce6a02ed")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StructureElement.MQNAME);
        this.registerFactory(new PassiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("3b179f71-bac3-4a23-96b0-d7bb7634f0a4")
    private static class PassiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("cdd7cd7c-9473-44b4-a045-f59bf1b2e90a")
        private PassiveStructureElementSmClass smClass;

        @objid ("78ed6056-8c4c-4b70-b615-d58662eed278")
        public PassiveStructureElementObjectFactory(PassiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2b149313-5a4b-46d4-9207-2bb318bb0caf")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("3d6df40f-5b90-4952-97d8-7efecdc602b9")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
