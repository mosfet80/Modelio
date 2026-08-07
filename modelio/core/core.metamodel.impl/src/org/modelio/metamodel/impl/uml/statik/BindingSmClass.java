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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.uml.statik.NaryConnector;
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

@objid ("3652073c-5639-419d-bc73-dfae88421d53")
public class BindingSmClass extends UmlModelElementSmClass {
    @objid ("492ec371-08cd-4932-b2fb-1643e2310bf0")
    private SmDependency connectorEndRoleDep;

    @objid ("1ff42924-eafd-44ff-b9e8-d962c0d27da3")
    private SmDependency connectorRoleDep;

    @objid ("e0092b2b-17b3-4426-9797-9d700bd12971")
    private SmDependency roleDep;

    @objid ("91c9b989-5b87-4e03-ade8-6e2f1e6c864b")
    private SmDependency representedFeatureDep;

    @objid ("7b8e87a7-8604-4dc9-b580-39126f6477c9")
    private SmDependency ownerDep;

    @objid ("eb3e94d2-21ce-4864-a09a-ba1902f642a6")
    public BindingSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b8fc704e-d968-46fa-9309-01363242b0f4")
    @Override
    public String getName() {
        return "Binding";

    }

    @objid ("7cb720f0-7125-40f5-80bd-9c6ff73546ba")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f9fceb48-9478-4efb-94a7-71cb35540f47")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Binding.class;

    }

    @objid ("1c8f9ab8-b359-46f4-83e0-b5b4e7b695e1")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a33ca426-3e0c-4aa7-b06b-aa107cdf17ed")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ce1a3c57-50fc-4f3f-a017-c21be68358ab")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new BindingObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.connectorEndRoleDep = new ConnectorEndRoleSmDependency();
        this.connectorEndRoleDep.init("ConnectorEndRole", this, metamodel.getMClass(ConnectorEnd.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.connectorEndRoleDep);

        this.connectorRoleDep = new ConnectorRoleSmDependency();
        this.connectorRoleDep.init("ConnectorRole", this, metamodel.getMClass(NaryConnector.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.connectorRoleDep);

        this.roleDep = new RoleSmDependency();
        this.roleDep.init("Role", this, metamodel.getMClass(BindableInstance.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.roleDep);

        this.representedFeatureDep = new RepresentedFeatureSmDependency();
        this.representedFeatureDep.init("RepresentedFeature", this, metamodel.getMClass(UmlModelElement.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedFeatureDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(CollaborationUse.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

    }

    @objid ("ec508ef4-6812-4911-b4ea-08fb743d172a")
    public SmDependency getConnectorEndRoleDep() {
        if (this.connectorEndRoleDep == null) {
        	this.connectorEndRoleDep = this.getDependencyDef("ConnectorEndRole");
        }
        return this.connectorEndRoleDep;
    }

    @objid ("396e255b-f4dc-438e-af04-d5151085d2d8")
    public SmDependency getConnectorRoleDep() {
        if (this.connectorRoleDep == null) {
        	this.connectorRoleDep = this.getDependencyDef("ConnectorRole");
        }
        return this.connectorRoleDep;
    }

    @objid ("70ca6749-0f6f-4433-8949-2e7c0153002a")
    public SmDependency getRoleDep() {
        if (this.roleDep == null) {
        	this.roleDep = this.getDependencyDef("Role");
        }
        return this.roleDep;
    }

    @objid ("3f69348f-cb71-414d-9fd4-7f1b94c0fdea")
    public SmDependency getRepresentedFeatureDep() {
        if (this.representedFeatureDep == null) {
        	this.representedFeatureDep = this.getDependencyDef("RepresentedFeature");
        }
        return this.representedFeatureDep;
    }

    @objid ("3b566e8d-889b-4feb-b8b3-b3acf5dda26d")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("7c2e7ba9-5331-44fb-a2d1-6aeb7bd0af8c")
    private static class BindingObjectFactory implements ISmObjectFactory {
        @objid ("4fd8f6ed-eab0-4856-bbbb-adf89ddcafbb")
        private BindingSmClass smClass;

        @objid ("1cee7a25-7452-45c3-9ba5-103ec333197b")
        public BindingObjectFactory(BindingSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2b932fef-9311-4c03-bf8b-a441b77f73be")
        @Override
        public ISmObjectData createData() {
            return new BindingData(this.smClass);
        }

        @objid ("cba97a0f-de78-45f3-9d33-65b418b017b5")
        @Override
        public SmObjectImpl createImpl() {
            return new BindingImpl();
        }

    }

    @objid ("176837b3-990c-4ae3-bce8-e11914227802")
    public static class ConnectorEndRoleSmDependency extends SmSingleDependency {
        @objid ("fb07c53f-ea6c-447f-ac76-3041326e9fc4")
        private SmDependency symetricDep;

        @objid ("097c2852-1ee3-472b-b293-d1aa931343e0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindingData) data).mConnectorEndRole;
        }

        @objid ("a26ea430-3d4a-48b5-bdee-2b66e42340b8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindingData) data).mConnectorEndRole = value;
        }

        @objid ("61050aa2-2c28-4a79-b318-006979716c8e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConnectorEndSmClass)this.getTarget()).getRepresentationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("10ab29c3-3873-4e2b-a0a1-84ed0df4d76a")
    public static class ConnectorRoleSmDependency extends SmSingleDependency {
        @objid ("af631ffc-af71-47ff-ae4d-887c1fe66b07")
        private SmDependency symetricDep;

        @objid ("a4b88a99-6285-49e9-9985-ecbd2e3e862c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindingData) data).mConnectorRole;
        }

        @objid ("4e8613b5-45d8-4cfa-a530-b4513bbd0f34")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindingData) data).mConnectorRole = value;
        }

        @objid ("e23eb537-72bb-4b05-b2bc-a89760179f1d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryConnectorSmClass)this.getTarget()).getRepresentationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5cd327e7-5172-4142-9e97-3d461a164432")
    public static class RoleSmDependency extends SmSingleDependency {
        @objid ("5d71ddd0-451c-4433-97f1-c4887b1f0d55")
        private SmDependency symetricDep;

        @objid ("3e7c8b26-adb5-4eca-9d6b-c0eed2fcd5bc")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindingData) data).mRole;
        }

        @objid ("82e821cf-d7b4-4e01-b13c-406e59645431")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindingData) data).mRole = value;
        }

        @objid ("c518932a-106c-4372-a921-8904f63a8e52")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindableInstanceSmClass)this.getTarget()).getRepresentationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("cccad6aa-a50c-4203-b53d-43693557ab87")
    public static class RepresentedFeatureSmDependency extends SmSingleDependency {
        @objid ("a4f413aa-9501-4622-baf8-a94f9c8c6c75")
        private SmDependency symetricDep;

        @objid ("9541c17d-8726-43e3-ae3b-e399ada443da")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindingData) data).mRepresentedFeature;
        }

        @objid ("240bbbc7-5965-439e-ae66-b1158869279f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindingData) data).mRepresentedFeature = value;
        }

        @objid ("d1137499-1a8c-4819-bddb-66a8c82edd76")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getRepresentsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0e1cb824-4a4f-4b23-8a9f-34b475747f70")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("93b46575-c8a9-49ed-9e5b-e0e526cda2c4")
        private SmDependency symetricDep;

        @objid ("54119a3c-6401-4d58-a366-85e9fc5559ed")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BindingData) data).mOwner;
        }

        @objid ("da862200-ea89-4f49-908d-57b53ff7634f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BindingData) data).mOwner = value;
        }

        @objid ("ede95f59-8b4d-40cd-a104-ae6eee9e6472")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CollaborationUseSmClass)this.getTarget()).getRoleBindingDep();
            }
            return this.symetricDep;

        }

    }

}
