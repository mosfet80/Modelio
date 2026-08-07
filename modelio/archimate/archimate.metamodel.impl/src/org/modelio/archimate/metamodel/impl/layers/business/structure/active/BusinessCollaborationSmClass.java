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
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessCollaboration;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("2cd8712b-60b3-40f0-90ac-7267d9f7e4d9")
public class BusinessCollaborationSmClass extends BusinessInternalActiveStructureElementSmClass {
    @objid ("9a52dfc7-9ae3-4a79-abb8-f64a60664387")
    public BusinessCollaborationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("494de433-191d-4110-8dbc-c63194772df5")
    @Override
    public String getName() {
        return "BusinessCollaboration";

    }

    @objid ("50762057-6e25-4c0d-9f67-55eb46e1047a")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("854622ef-e45c-411b-b9bb-208fb287cc17")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessCollaboration.class;

    }

    @objid ("c236bbcf-955a-4625-ae00-34fa4766330c")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("bb03d447-285e-434e-b5b8-f0cd6dfc6f93")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("b33f5d05-e16a-47eb-9c9a-3eb191749547")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessInternalActiveStructureElement.MQNAME);
        this.registerFactory(new BusinessCollaborationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("56b98cac-9b7c-40d1-bc2f-3838864da2e4")
    private static class BusinessCollaborationObjectFactory implements ISmObjectFactory {
        @objid ("b6ab8a22-32c5-4ece-966f-b9c2749d1ae5")
        private BusinessCollaborationSmClass smClass;

        @objid ("91425bdd-ce1e-41eb-a749-caf04460e479")
        public BusinessCollaborationObjectFactory(BusinessCollaborationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("fea320c6-dd41-4a06-b6ee-ebe601ba5177")
        @Override
        public ISmObjectData createData() {
            return new BusinessCollaborationData(this.smClass);
        }

        @objid ("69065bb1-8950-4d20-aee5-0ef68c534bdf")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessCollaborationImpl();
        }

    }

}
