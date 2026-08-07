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
package org.modelio.archimate.metamodel.impl.layers.application.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("9dc4a034-884c-441f-b4f1-2717346de2eb")
public class ApplicationServiceSmClass extends ExternalBehaviorElementSmClass {
    @objid ("fb82baf6-092f-40f4-a894-d42b80d45c40")
    public ApplicationServiceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("26aefa28-1aa3-49ee-b4bd-b57ab7cc8e1e")
    @Override
    public String getName() {
        return "ApplicationService";

    }

    @objid ("ba60c875-8810-408f-bd1d-73ec5883bb40")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("66b9f8bb-0efc-4b05-8fbf-73fb620a318c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationService.class;

    }

    @objid ("683965cf-d6e3-4bd9-8a59-018afb24d69b")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("99ecf53c-945b-4179-be1a-9cd308231183")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1ccdbd32-9ec8-4bcc-9658-1ed52402f366")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ExternalBehaviorElement.MQNAME);
        this.registerFactory(new ApplicationServiceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("194220eb-53ab-49f1-92f7-a400d8be998c")
    private static class ApplicationServiceObjectFactory implements ISmObjectFactory {
        @objid ("927599a2-963d-49ae-b05f-f6787dd0307f")
        private ApplicationServiceSmClass smClass;

        @objid ("646c1efa-5eed-49bc-bee8-71184ec6c414")
        public ApplicationServiceObjectFactory(ApplicationServiceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f36b4e52-46c4-4cdc-96ec-3cbd9afcb24e")
        @Override
        public ISmObjectData createData() {
            return new ApplicationServiceData(this.smClass);
        }

        @objid ("fafb30c0-d8fc-4a3b-ba36-9f828fc5e015")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationServiceImpl();
        }

    }

}
