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
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedDefinitions;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b5512d51-8f67-4612-b567-110a04692918")
public class BpmnSharedDefinitionsSmClass extends BehaviorSmClass {
    @objid ("982a836a-c422-4cde-b085-0b0fb3051472")
    private SmDependency rootElementDep;

    @objid ("220084b8-1439-48d1-9aa9-042c07977840")
    public BpmnSharedDefinitionsSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("fd8205d6-22ba-476a-9ee6-422bc7bcb9f7")
    @Override
    public String getName() {
        return "BpmnSharedDefinitions";

    }

    @objid ("ded90703-9c9e-4f6e-95c9-2bdcabc0c1f1")
    @Override
    public Version getVersion() {
        return new Version("2.2.0");
    }

    @objid ("bfd05691-f00c-4912-9413-8063d7bde05b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSharedDefinitions.class;

    }

    @objid ("6ce1b3e4-83c7-41f0-b6c4-d5da0bd705fd")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("c0c219ee-fc5e-4ed7-b4b6-eebb75438d6a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ae68ae4b-a1f4-48b5-9ea8-bbf7a2eb0d4b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new BpmnSharedDefinitionsObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.rootElementDep = new RootElementSmDependency();
        this.rootElementDep.init("RootElement", this, metamodel.getMClass(BpmnSharedElement.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.rootElementDep);

    }

    @objid ("dc8f6341-2095-420e-903e-c76d1eb86a13")
    public SmDependency getRootElementDep() {
        if (this.rootElementDep == null) {
        	this.rootElementDep = this.getDependencyDef("RootElement");
        }
        return this.rootElementDep;
    }

    @objid ("47c20f05-5cd3-4255-b166-459b3870d304")
    private static class BpmnSharedDefinitionsObjectFactory implements ISmObjectFactory {
        @objid ("fb30f21d-ba40-442d-ab0d-fb2be5917dd8")
        private BpmnSharedDefinitionsSmClass smClass;

        @objid ("61426a95-c040-4154-b4dc-0b785934de21")
        public BpmnSharedDefinitionsObjectFactory(BpmnSharedDefinitionsSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ac74fdae-393b-4100-a8f5-4f54281d98d8")
        @Override
        public ISmObjectData createData() {
            return new BpmnSharedDefinitionsData(this.smClass);
        }

        @objid ("11b20f3c-59e5-4af9-a084-90a1451c8055")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnSharedDefinitionsImpl();
        }

    }

    @objid ("c419eb44-e373-45ec-a16b-71105b674d3a")
    public static class RootElementSmDependency extends SmMultipleDependency {
        @objid ("0a8d8687-f175-40b6-9182-a4667fda5040")
        private SmDependency symetricDep;

        @objid ("5000899f-73be-44c6-a45d-ffe0a80d84a0")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnSharedDefinitionsData)data).mRootElement != null)? ((BpmnSharedDefinitionsData)data).mRootElement:SmMultipleDependency.EMPTY;
        }

        @objid ("e593a01e-e79d-4393-a184-940af6479af0")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnSharedDefinitionsData) data).mRootElement = values;

        }

        @objid ("bdc78d4c-4f87-441d-a229-063925322d23")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSharedElementSmClass)this.getTarget()).getOwnerDep();
            }
            return this.symetricDep;

        }

    }

}
