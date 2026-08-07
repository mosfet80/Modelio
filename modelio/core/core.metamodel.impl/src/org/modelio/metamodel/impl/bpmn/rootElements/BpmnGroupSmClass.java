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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnGroup;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("ad11c0e8-184a-4703-8339-53a0a144d6b5")
public class BpmnGroupSmClass extends BpmnArtifactSmClass {
    @objid ("5da71c39-020c-49b0-af6d-8f84bd694589")
    private SmAttribute categoryAtt;

    @objid ("d8282fe9-9e6b-4f6a-8901-12ae9f586b11")
    private SmDependency categorizedDep;

    @objid ("6a190778-4676-4eaf-bc4f-2400bb69bf03")
    public BpmnGroupSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("91b778e6-fd19-44ea-b433-3d67787e45d4")
    @Override
    public String getName() {
        return "BpmnGroup";

    }

    @objid ("3ea6864d-2dad-4580-aba1-ca2b7f0281ac")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0fafc974-3d22-434f-8640-a18585278c0e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnGroup.class;

    }

    @objid ("464de451-1741-4739-a7e4-718032b6465f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("c058040f-4794-41a5-b041-4ccb1c05d0ad")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ff39e6c8-3556-44c2-b7ae-8f2a0d828719")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnArtifact.MQNAME);
        this.registerFactory(new BpmnGroupObjectFactory(this));


        // Initialize and register the SmAttribute
        this.categoryAtt = new CategorySmAttribute();
        this.categoryAtt.init("Category", this, String.class );
        registerAttribute(this.categoryAtt);


        // Initialize and register the SmDependency
        this.categorizedDep = new CategorizedSmDependency();
        this.categorizedDep.init("Categorized", this, metamodel.getMClass(BpmnFlowElement.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.categorizedDep);

    }

    @objid ("783feb0a-1a73-431d-b265-dd1b9a8a0ea8")
    public SmAttribute getCategoryAtt() {
        if (this.categoryAtt == null) {
        	this.categoryAtt = this.getAttributeDef("Category");
        }
        return this.categoryAtt;
    }

    @objid ("7ee5036c-91d6-449b-a8e3-8e098bbb384d")
    public SmDependency getCategorizedDep() {
        if (this.categorizedDep == null) {
        	this.categorizedDep = this.getDependencyDef("Categorized");
        }
        return this.categorizedDep;
    }

    @objid ("b4307d32-976d-4505-88c1-76b6d3bc5350")
    private static class BpmnGroupObjectFactory implements ISmObjectFactory {
        @objid ("4797f78b-12d2-4ec2-ad86-8c213676cf6e")
        private BpmnGroupSmClass smClass;

        @objid ("b1e6b0a6-5080-487b-be04-859162d02e22")
        public BpmnGroupObjectFactory(BpmnGroupSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("6800df17-ef02-4c5e-86ba-b859f2167edd")
        @Override
        public ISmObjectData createData() {
            return new BpmnGroupData(this.smClass);
        }

        @objid ("b77db2af-0db7-48f1-a68a-a80d7a97474b")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnGroupImpl();
        }

    }

    @objid ("9476932b-2318-402f-9ca8-b55371864b89")
    public static class CategorySmAttribute extends SmAttribute {
        @objid ("746a9492-f238-4b3e-92ec-cd4ad860a2e6")
        public Object getValue(ISmObjectData data) {
            return ((BpmnGroupData) data).mCategory;
        }

        @objid ("c3f0fe00-c940-4c9f-9843-29205bbc5724")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnGroupData) data).mCategory = value;
        }

    }

    @objid ("8bc1f0db-dad9-4bf6-b381-34e5a0f1aac8")
    public static class CategorizedSmDependency extends SmMultipleDependency {
        @objid ("ddf6fac0-4208-4fdf-b47c-baa1075fabfd")
        private SmDependency symetricDep;

        @objid ("59914381-8b4f-469f-a4b3-9e496f83c039")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnGroupData)data).mCategorized != null)? ((BpmnGroupData)data).mCategorized:SmMultipleDependency.EMPTY;
        }

        @objid ("d379cee7-946b-4ffa-b07d-87a8d993fc3e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnGroupData) data).mCategorized = values;

        }

        @objid ("f4e30037-076e-4384-9e5d-776c65a6d4ef")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnFlowElementSmClass)this.getTarget()).getGroupsDep();
            }
            return this.symetricDep;

        }

    }

}
