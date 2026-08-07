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
package org.modelio.archimate.metamodel.impl.core.structure;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.impl.core.ArchimateAbstractElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("4e8ab30e-3c9d-4c5b-ae6f-87c44ddf86a4")
public class ViewPointSmClass extends ArchimateAbstractElementSmClass {
    @objid ("332a2c02-27b0-409c-bc85-fa7f009deb8a")
    private SmDependency childDep;

    @objid ("427b426b-85af-4980-9ddb-f1a3c6996f8c")
    private SmDependency projectDep;

    @objid ("294fce08-1c41-4d8e-8d9b-b96929121367")
    private SmDependency parentDep;

    @objid ("ef5c3f09-a83f-4892-93bf-2e32594d934e")
    private SmDependency contextDep;

    @objid ("e7556c6e-d54d-4c1d-9f97-3a128826dae9")
    public ViewPointSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8ab202ed-733a-461d-9641-1dcfe71fe8f7")
    @Override
    public String getName() {
        return "ViewPoint";

    }

    @objid ("915fac2b-ad48-4cc8-8505-293c5ec726f2")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("b8274161-dcfd-4ddf-ad02-56dbe4da9832")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ViewPoint.class;

    }

    @objid ("2ae615c7-23ad-4b74-ad76-5e460a758858")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("fa48e3b8-d6c3-4bda-b5d6-2a81ad554ec9")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8073159b-5350-4c72-a8c7-60b649ac6215")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ArchimateAbstractElement.MQNAME);
        this.registerFactory(new ViewPointObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.childDep = new ChildSmDependency();
        this.childDep.init("child", this, metamodel.getMClass(ViewPoint.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.childDep);

        this.projectDep = new ProjectSmDependency();
        this.projectDep.init("project", this, metamodel.getMClass(ArchimateProject.MQNAME), 0, 1 );
        registerDependency(this.projectDep);

        this.parentDep = new ParentSmDependency();
        this.parentDep.init("parent", this, metamodel.getMClass(ViewPoint.MQNAME), 0, 1 );
        registerDependency(this.parentDep);

        this.contextDep = new ContextSmDependency();
        this.contextDep.init("context", this, metamodel.getMClass(Model.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.contextDep);

    }

    @objid ("caa9939a-00f5-49fa-b3a8-825892c30232")
    public SmDependency getChildDep() {
        if (this.childDep == null) {
        	this.childDep = this.getDependencyDef("child");
        }
        return this.childDep;
    }

    @objid ("6dd7b7ad-4ae4-4af4-8176-b2160a5ac7a3")
    public SmDependency getProjectDep() {
        if (this.projectDep == null) {
        	this.projectDep = this.getDependencyDef("project");
        }
        return this.projectDep;
    }

    @objid ("b763ea19-8a3f-4ebd-a874-3ef19a9bf4ff")
    public SmDependency getParentDep() {
        if (this.parentDep == null) {
        	this.parentDep = this.getDependencyDef("parent");
        }
        return this.parentDep;
    }

    @objid ("d53b5457-29f4-42d0-987e-c1c0fa913ebd")
    public SmDependency getContextDep() {
        if (this.contextDep == null) {
        	this.contextDep = this.getDependencyDef("context");
        }
        return this.contextDep;
    }

    @objid ("0ebde5d9-683f-4d44-82f9-4e7547dc8011")
    private static class ViewPointObjectFactory implements ISmObjectFactory {
        @objid ("94ba3469-f965-47ac-a610-0dc194551fea")
        private ViewPointSmClass smClass;

        @objid ("054c5ed4-3a3d-4b9e-8c2a-1d734bbe3ce2")
        public ViewPointObjectFactory(ViewPointSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("aa499d38-c5e5-43f6-8019-3681c7d050f7")
        @Override
        public ISmObjectData createData() {
            return new ViewPointData(this.smClass);
        }

        @objid ("8aafef2c-361b-4236-94af-5dfe5968f8be")
        @Override
        public SmObjectImpl createImpl() {
            return new ViewPointImpl();
        }

    }

    @objid ("44f61492-7cd2-4ba7-a134-c9848371bfe5")
    public static class ChildSmDependency extends SmMultipleDependency {
        @objid ("bdd4fdd2-e112-456c-a15d-96318d744dd3")
        private SmDependency symetricDep;

        @objid ("645fe9e0-b4d0-4ea7-898b-0c3d7e09be52")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ViewPointData)data).mChild != null)? ((ViewPointData)data).mChild:SmMultipleDependency.EMPTY;
        }

        @objid ("12ea1a5b-c228-45e9-bfcb-229a0b46a111")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ViewPointData) data).mChild = values;

        }

        @objid ("8fb1b7f5-ecbf-4168-8aae-2e1c783cc398")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ViewPointSmClass)this.getTarget()).getParentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1ce8f7a9-83cf-4583-ba63-86609881cb8f")
    public static class ProjectSmDependency extends SmSingleDependency {
        @objid ("cc5d22a5-e14f-4d68-a96e-ae0220a4a311")
        private SmDependency symetricDep;

        @objid ("043f7e1a-490e-4634-9107-cf23207fca6a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ViewPointData) data).mProject;
        }

        @objid ("2067c076-cfcc-45e9-9a73-eab88cb7feca")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ViewPointData) data).mProject = value;
        }

        @objid ("e3e18cb4-3dba-4616-ac0b-68a8b7b299e4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ArchimateProjectSmClass)this.getTarget()).getViewPointsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6bcf2f9b-c3e6-4a81-b04b-c23ce6acb445")
    public static class ParentSmDependency extends SmSingleDependency {
        @objid ("d4b6e72a-9c03-4e85-9a30-5edfce169a12")
        private SmDependency symetricDep;

        @objid ("4f5d81e7-97f9-42db-8f92-c8843b801f7e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ViewPointData) data).mParent;
        }

        @objid ("83d1676f-f788-45bc-b690-3832daceda80")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ViewPointData) data).mParent = value;
        }

        @objid ("b34bae93-4b13-4469-8080-fd756f96ed2f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ViewPointSmClass)this.getTarget()).getChildDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6d44f78d-2448-4994-8e80-9cd6289037a5")
    public static class ContextSmDependency extends SmSingleDependency {
        @objid ("f4969485-9721-4ec2-a21a-6a439b4ecaa1")
        private SmDependency symetricDep;

        @objid ("79180548-078e-4fd1-b123-03400ad510f7")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ViewPointData) data).mContext;
        }

        @objid ("28d1ab67-5897-4711-bcf6-177bfe067d31")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ViewPointData) data).mContext = value;
        }

        @objid ("970acf80-e902-45ca-9150-231ca75d818c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ModelSmClass)this.getTarget()).getReferencedByDep();
            }
            return this.symetricDep;

        }

    }

}
