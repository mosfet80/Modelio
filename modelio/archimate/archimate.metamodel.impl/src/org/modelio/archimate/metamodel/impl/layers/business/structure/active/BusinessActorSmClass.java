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
package org.modelio.archimate.metamodel.impl.layers.business.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessInternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalActiveStructureElement;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessActor;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("061bc587-b764-4bc7-a403-03bcb912e7dc")
public class BusinessActorSmClass extends BusinessInternalActiveStructureElementSmClass {
    @objid ("e7ade566-ffd7-4bf3-8458-53bb212caa75")
    public BusinessActorSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("50b5178f-ff97-4f47-9603-123834715942")
    @Override
    public String getName() {
        return "BusinessActor";

    }

    @objid ("d711b592-3f73-4c35-9e81-b2d7a3094839")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("771ae37a-e348-420d-8fc1-278eda910e42")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessActor.class;

    }

    @objid ("29f357b0-2aa7-4fac-ac6d-21922696b6d5")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("68c716e2-89ba-4e69-9953-5ab6beb53497")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7f44c2cb-e10e-4b4d-82bc-68234a01bfff")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessInternalActiveStructureElement.MQNAME);
        this.registerFactory(new BusinessActorObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("17da207a-b0b9-4605-af09-4d5d56ce017a")
    private static class BusinessActorObjectFactory implements ISmObjectFactory {
        @objid ("aeae7427-d86e-4438-9a1b-8ca0d659059a")
        private BusinessActorSmClass smClass;

        @objid ("e15880e4-e257-4c10-a02a-56386dd25796")
        public BusinessActorObjectFactory(BusinessActorSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("dd2c04ec-f3ca-4221-8d96-1c41043b7429")
        @Override
        public ISmObjectData createData() {
            return new BusinessActorData(this.smClass);
        }

        @objid ("df467787-126d-48d8-a4b0-a57b044569c4")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessActorImpl();
        }

    }

}
