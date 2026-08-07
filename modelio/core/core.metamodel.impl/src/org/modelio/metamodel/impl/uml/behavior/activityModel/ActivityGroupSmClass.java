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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityGroup;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("22b4d7a0-d812-413f-9aa3-c308aab80b35")
public class ActivityGroupSmClass extends UmlModelElementSmClass {
    @objid ("986e1a8b-0595-4dc0-b2f0-1a087f59db0a")
    private SmDependency inActivityDep;

    @objid ("dddc106c-1921-44cf-8775-ab21b028daa7")
    public ActivityGroupSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("79feb485-e262-46f5-a099-e5c7fbd10959")
    @Override
    public String getName() {
        return "ActivityGroup";

    }

    @objid ("8ed49a9a-615a-4275-8a5d-abf6f20758f6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3844cd80-a110-441b-aed4-2d31011784b4")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityGroup.class;

    }

    @objid ("a1be63db-f94a-4664-9358-7b6ef81f1f0d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("14869a8f-1ad1-433c-be3a-fcc84cab2b96")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("6175c887-fe4b-45cb-9a08-c867f820b3b4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ActivityGroupObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.inActivityDep = new InActivitySmDependency();
        this.inActivityDep.init("InActivity", this, metamodel.getMClass(Activity.MQNAME), 0, 1 );
        registerDependency(this.inActivityDep);

    }

    @objid ("bbd70a3d-4d4e-4dea-8132-b3d4e9e1a135")
    public SmDependency getInActivityDep() {
        if (this.inActivityDep == null) {
        	this.inActivityDep = this.getDependencyDef("InActivity");
        }
        return this.inActivityDep;
    }

    @objid ("29092251-e120-4984-8fe8-954de5a2d621")
    private static class ActivityGroupObjectFactory implements ISmObjectFactory {
        @objid ("7122afe3-78a2-4d1d-9872-e66d5c36785f")
        private ActivityGroupSmClass smClass;

        @objid ("e4fdbb83-f4a2-4cb7-9723-1c5271f91e94")
        public ActivityGroupObjectFactory(ActivityGroupSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4da6ab7c-b4f2-4ec1-8679-ad3baca5acb2")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("845dbcb9-88a9-4df2-86f1-ceda90cb60a2")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("a6db40ef-10ad-4e36-ae6a-5b4e34b0bc23")
    public static class InActivitySmDependency extends SmSingleDependency {
        @objid ("435843b7-d96b-4097-b731-86ac841ecb25")
        private SmDependency symetricDep;

        @objid ("d0eb2101-cc04-4774-8e1b-c1c0f09eba65")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityGroupData) data).mInActivity;
        }

        @objid ("1f4d453f-333b-4d67-92c4-65cceaeeff8c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityGroupData) data).mInActivity = value;
        }

        @objid ("10f1eb6c-11d5-4e49-ab2c-fb0a6b442c4d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivitySmClass)this.getTarget()).getOwnedGroupDep();
            }
            return this.symetricDep;

        }

    }

}
