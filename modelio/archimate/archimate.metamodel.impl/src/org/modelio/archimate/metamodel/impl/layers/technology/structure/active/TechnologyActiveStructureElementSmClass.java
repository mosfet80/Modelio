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
package org.modelio.archimate.metamodel.impl.layers.technology.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ActiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.ActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c0a85974-845e-436d-a58c-a0f2b6cb47c7")
public class TechnologyActiveStructureElementSmClass extends ActiveStructureElementSmClass {
    @objid ("1f03fade-b866-4665-8da8-5ba54fae163c")
    public TechnologyActiveStructureElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e1ad6811-154e-4683-aa0f-fcd62b4ac2c7")
    @Override
    public String getName() {
        return "TechnologyActiveStructureElement";

    }

    @objid ("fafe70e6-09f0-4f0d-8d23-64b08bb7ddc4")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("cdeec995-f86a-4fc2-b38c-bf0bd6a48d87")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyActiveStructureElement.class;

    }

    @objid ("0628f9f8-fc4a-41a4-96e0-30ff5f0e9e1c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0e7bef99-c1ab-4e52-b4e8-6600270b1b0a")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("401174cf-7087-4a56-95b1-731dd65c6c54")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActiveStructureElement.MQNAME);
        this.registerFactory(new TechnologyActiveStructureElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("50e5df41-ac0b-469d-ba06-bea5a0fe55a4")
    private static class TechnologyActiveStructureElementObjectFactory implements ISmObjectFactory {
        @objid ("a6d22583-617b-445d-b19b-6dde6fa3bd81")
        private TechnologyActiveStructureElementSmClass smClass;

        @objid ("ef286cbb-4cf0-4659-9075-030d72b3ef8d")
        public TechnologyActiveStructureElementObjectFactory(TechnologyActiveStructureElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7a30b691-3e5f-4867-b442-71765bffda0a")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("78654db7-1070-4bb4-a5f9-9ff4a7c6dfde")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
