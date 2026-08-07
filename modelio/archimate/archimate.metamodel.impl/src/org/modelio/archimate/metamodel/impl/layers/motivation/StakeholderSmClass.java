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
import org.modelio.archimate.metamodel.layers.motivation.Stakeholder;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f0e8b0cc-6c3c-402a-a5ff-f9a2d1596c95")
public class StakeholderSmClass extends MotivationElementSmClass {
    @objid ("b1f69c77-713f-49f6-917d-051c1b25be27")
    public StakeholderSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5e5f6c39-aa79-4cb6-ad7a-3259f9ab4a8b")
    @Override
    public String getName() {
        return "Stakeholder";

    }

    @objid ("67001a34-5b43-4e5d-929f-a8223d2f2e99")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("5b4fd0e6-346f-41b6-bc7d-cc3995046258")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Stakeholder.class;

    }

    @objid ("f2b7fd65-94a2-48b2-9121-f5095378172f")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("911d61d9-a4f8-41cf-8176-6955ed02093b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("168c2fe5-240d-4cde-a564-91a39efa30d9")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new StakeholderObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("9223c5a9-e475-41ff-91b3-ca6adaea5872")
    private static class StakeholderObjectFactory implements ISmObjectFactory {
        @objid ("551fdd11-d749-4351-8093-cf18a5661696")
        private StakeholderSmClass smClass;

        @objid ("db8e9fd8-0a82-4a27-9aee-7e4331d68aff")
        public StakeholderObjectFactory(StakeholderSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b35392db-efa7-437b-b11d-6d79d0d54040")
        @Override
        public ISmObjectData createData() {
            return new StakeholderData(this.smClass);
        }

        @objid ("ad10ac86-631e-43ca-b92c-0c2d77fc7389")
        @Override
        public SmObjectImpl createImpl() {
            return new StakeholderImpl();
        }

    }

}
