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
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("ed90eefc-81b4-495d-babc-babfec9c1aa0")
public class TechnologyInterfaceSmClass extends ExternalActiveStructureElementSmClass {
    @objid ("81401aed-94fd-4bc9-b02f-17e86ef61b64")
    public TechnologyInterfaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("db49abe8-dfc2-40d8-b1fe-f10c18366520")
    @Override
    public String getName() {
        return "TechnologyInterface";

    }

    @objid ("bdfd0bdc-8e5a-4cc8-93f8-5b5439ccbf35")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("9191a6dc-5768-49df-97a0-5e4f181b7cbf")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyInterface.class;

    }

    @objid ("36213119-0b53-46ad-9d68-fa3b2aade919")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("4a062223-33f9-4c6a-88b1-ccee055d65e5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("48a61dcd-bc10-4146-bfdc-64a57fecc500")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ExternalActiveStructureElement.MQNAME);
        this.registerFactory(new TechnologyInterfaceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("732d9a83-6cb3-4ccb-a824-a7d27ef958c2")
    private static class TechnologyInterfaceObjectFactory implements ISmObjectFactory {
        @objid ("542aad55-e99f-42fb-adcf-6112e0521234")
        private TechnologyInterfaceSmClass smClass;

        @objid ("1c426963-9d7f-4119-8ad3-e19a6f78f6dd")
        public TechnologyInterfaceObjectFactory(TechnologyInterfaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("07257780-cbdb-456b-a115-90dca3a0c97a")
        @Override
        public ISmObjectData createData() {
            return new TechnologyInterfaceData(this.smClass);
        }

        @objid ("73b45885-9e67-467d-a552-91af8a037f18")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyInterfaceImpl();
        }

    }

}
