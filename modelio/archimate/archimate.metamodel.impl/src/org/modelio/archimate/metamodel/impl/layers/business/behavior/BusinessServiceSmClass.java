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
package org.modelio.archimate.metamodel.impl.layers.business.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessService;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a26072bb-271b-4775-ad59-dfa9bea886e5")
public class BusinessServiceSmClass extends ExternalBehaviorElementSmClass {
    @objid ("0e311711-17ea-4c8c-ae14-552eacd0e1ed")
    public BusinessServiceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("31f5abe7-34cb-4e41-81a7-cb938d49183e")
    @Override
    public String getName() {
        return "BusinessService";

    }

    @objid ("a1c0d071-00d1-469a-9e61-9238d511589b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("45e968fb-14f4-4355-9bb8-b34a16c6d80e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessService.class;

    }

    @objid ("d5ab16cd-17c5-46e9-b76e-90d25e8ea924")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("d17c7b20-db7b-46ea-8f62-9862ea1df1d7")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("4d3c4aeb-2b89-4425-ad79-4f159349863e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ExternalBehaviorElement.MQNAME);
        this.registerFactory(new BusinessServiceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("9e2a671e-b118-4c05-b097-82452e723c6e")
    private static class BusinessServiceObjectFactory implements ISmObjectFactory {
        @objid ("bf0d349e-7a88-47fa-af9c-f62410175d06")
        private BusinessServiceSmClass smClass;

        @objid ("003903b1-4c34-4357-a2a0-edb258f0690e")
        public BusinessServiceObjectFactory(BusinessServiceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3fe0dd60-445f-4e87-a514-70abbc22416a")
        @Override
        public ISmObjectData createData() {
            return new BusinessServiceData(this.smClass);
        }

        @objid ("a0131a34-3fa5-471a-881a-81191b23fd00")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessServiceImpl();
        }

    }

}
