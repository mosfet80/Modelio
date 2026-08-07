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
import org.modelio.archimate.metamodel.impl.layers.business.BusinessInternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a8d9469d-cfc0-40e4-8a9c-b4e5675e8775")
public class BusinessProcessSmClass extends BusinessInternalBehaviorElementSmClass {
    @objid ("7088335c-84f4-4dd0-9a11-54054e0fdf88")
    public BusinessProcessSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("198225ff-e86c-4b22-90d6-d93a24472b17")
    @Override
    public String getName() {
        return "BusinessProcess";

    }

    @objid ("3963c5ff-829c-438b-91cd-98bab2b9e706")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("c8511d06-0e01-4388-8a60-831ee98dc53c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessProcess.class;

    }

    @objid ("d1692841-6612-4fc5-95ad-921165658bdf")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("01d11ad2-d3d9-4d1b-8cb8-4a457353e583")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("86d19726-805a-466b-9f98-990e1142af99")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessInternalBehaviorElement.MQNAME);
        this.registerFactory(new BusinessProcessObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("367b9ba6-682d-43f3-84b3-29126d0923e5")
    private static class BusinessProcessObjectFactory implements ISmObjectFactory {
        @objid ("81ebb7fb-d344-4391-842f-1788a17ed727")
        private BusinessProcessSmClass smClass;

        @objid ("46bb3ddc-9ec0-45dc-8da1-16bb1769147e")
        public BusinessProcessObjectFactory(BusinessProcessSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ad8c3754-b265-4f06-81d1-3305e7e1bffc")
        @Override
        public ISmObjectData createData() {
            return new BusinessProcessData(this.smClass);
        }

        @objid ("24589b24-a087-4939-bee8-39c5d75e0fc0")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessProcessImpl();
        }

    }

}
