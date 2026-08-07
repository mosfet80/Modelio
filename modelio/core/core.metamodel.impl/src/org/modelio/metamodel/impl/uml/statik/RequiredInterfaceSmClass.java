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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.uml.statik.Port;
import org.modelio.metamodel.uml.statik.RequiredInterface;
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

@objid ("b4edbdaa-c246-435a-bcdc-03ed72b8aa7d")
public class RequiredInterfaceSmClass extends UmlModelElementSmClass {
    @objid ("da695906-bf45-42a1-bc0e-b88c55ec8edc")
    private SmDependency requiredElementDep;

    @objid ("20ab9957-2abd-4999-ad95-9212b44697b6")
    private SmDependency providerDep;

    @objid ("5190abd1-61ff-4437-8230-07ee9b53e496")
    private SmDependency requiringDep;

    @objid ("d4017810-b467-4fe9-801d-c332cec7d110")
    private SmDependency naryProviderDep;

    @objid ("c2c4b1f3-b043-4095-81f1-20942ad6db21")
    public RequiredInterfaceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5d71839a-f4c8-4f21-b879-015f819bfd64")
    @Override
    public String getName() {
        return "RequiredInterface";

    }

    @objid ("f5ea6ac5-ddfc-49e5-a783-2eca31581c1a")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3f9cef5c-feee-4677-b49c-27b6a564f293")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return RequiredInterface.class;

    }

    @objid ("ee157c03-8e52-47a2-b355-e46934fd7bdc")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ffc3ec64-4b34-4d08-a716-2b28b1dcb6a9")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("c6331ede-946a-439c-aeaf-b1d945c8c6c1")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new RequiredInterfaceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.requiredElementDep = new RequiredElementSmDependency();
        this.requiredElementDep.init("RequiredElement", this, metamodel.getMClass(Interface.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.requiredElementDep);

        this.providerDep = new ProviderSmDependency();
        this.providerDep.init("Provider", this, metamodel.getMClass(LinkEnd.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.providerDep);

        this.requiringDep = new RequiringSmDependency();
        this.requiringDep.init("Requiring", this, metamodel.getMClass(Port.MQNAME), 1, 1 );
        registerDependency(this.requiringDep);

        this.naryProviderDep = new NaryProviderSmDependency();
        this.naryProviderDep.init("NaryProvider", this, metamodel.getMClass(NaryLinkEnd.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.naryProviderDep);

    }

    @objid ("2c9e65a0-d061-41bf-940a-bf865379b74b")
    public SmDependency getRequiredElementDep() {
        if (this.requiredElementDep == null) {
        	this.requiredElementDep = this.getDependencyDef("RequiredElement");
        }
        return this.requiredElementDep;
    }

    @objid ("40e0f600-9079-4458-b741-3548234ab928")
    public SmDependency getProviderDep() {
        if (this.providerDep == null) {
        	this.providerDep = this.getDependencyDef("Provider");
        }
        return this.providerDep;
    }

    @objid ("d7fc1da7-cf70-45ca-a944-1627344bfedf")
    public SmDependency getRequiringDep() {
        if (this.requiringDep == null) {
        	this.requiringDep = this.getDependencyDef("Requiring");
        }
        return this.requiringDep;
    }

    @objid ("a621e80a-386d-4012-aa60-62bfda2c2866")
    public SmDependency getNaryProviderDep() {
        if (this.naryProviderDep == null) {
        	this.naryProviderDep = this.getDependencyDef("NaryProvider");
        }
        return this.naryProviderDep;
    }

    @objid ("baac4aa5-6dc3-40b3-ad18-fc5dfdf368c5")
    private static class RequiredInterfaceObjectFactory implements ISmObjectFactory {
        @objid ("12dd6117-bc2c-471f-8754-5e40303d1fbe")
        private RequiredInterfaceSmClass smClass;

        @objid ("a0dafab7-0518-421b-abd0-e77f2a68fd0a")
        public RequiredInterfaceObjectFactory(RequiredInterfaceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ea0085b5-ed7c-4f15-8545-d3d737c1624c")
        @Override
        public ISmObjectData createData() {
            return new RequiredInterfaceData(this.smClass);
        }

        @objid ("926a4096-bd27-47d7-b8a3-ecefff288ac0")
        @Override
        public SmObjectImpl createImpl() {
            return new RequiredInterfaceImpl();
        }

    }

    @objid ("9975d690-8f71-4e5b-934d-e26acf1f6df6")
    public static class RequiredElementSmDependency extends SmMultipleDependency {
        @objid ("858ea6d6-d9a8-437e-91cf-36950620943f")
        private SmDependency symetricDep;

        @objid ("fce75b12-1811-4a22-bab6-98ee655bb876")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((RequiredInterfaceData)data).mRequiredElement != null)? ((RequiredInterfaceData)data).mRequiredElement:SmMultipleDependency.EMPTY;
        }

        @objid ("c142749e-a402-47ac-af5a-e21d9a1c9c8f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((RequiredInterfaceData) data).mRequiredElement = values;

        }

        @objid ("1e116bd8-730e-4bf8-a31f-fa3da17b0015")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InterfaceSmClass)this.getTarget()).getRequiringDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("81d62d21-d90e-4828-a4ed-a276c1e38d3c")
    public static class ProviderSmDependency extends SmMultipleDependency {
        @objid ("81d06208-e2d2-434d-b659-e120b605d655")
        private SmDependency symetricDep;

        @objid ("9f7c0d9c-3648-4e4f-8a5d-20fd9e268e90")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((RequiredInterfaceData)data).mProvider != null)? ((RequiredInterfaceData)data).mProvider:SmMultipleDependency.EMPTY;
        }

        @objid ("6d026bea-fb44-4eef-a359-1630acb5a5c9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((RequiredInterfaceData) data).mProvider = values;

        }

        @objid ("8aace363-3055-4635-804c-a9c1dedab59e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getConsumerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a11c8d87-eaf6-407b-83dc-85e732647ded")
    public static class RequiringSmDependency extends SmSingleDependency {
        @objid ("03c9b092-f807-4584-94c4-b1beec336050")
        private SmDependency symetricDep;

        @objid ("f48dea5e-313a-4e4c-a84a-b50f51ed0517")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((RequiredInterfaceData) data).mRequiring;
        }

        @objid ("c49f5678-0231-4f9c-a125-3da4b549c6ee")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((RequiredInterfaceData) data).mRequiring = value;
        }

        @objid ("85ba4e7b-328e-4187-af16-5e6bfb65758b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((PortSmClass)this.getTarget()).getRequiredDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("32d2af6a-0178-46fa-b57a-f8c9cf8ee574")
    public static class NaryProviderSmDependency extends SmMultipleDependency {
        @objid ("a2ddab2a-bb14-475a-8b48-0c2be47a00ec")
        private SmDependency symetricDep;

        @objid ("14893cf9-8e2b-460a-8c22-7dafd0652ace")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((RequiredInterfaceData)data).mNaryProvider != null)? ((RequiredInterfaceData)data).mNaryProvider:SmMultipleDependency.EMPTY;
        }

        @objid ("f166dc28-a18b-4d79-ab5d-e623d640b6e7")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((RequiredInterfaceData) data).mNaryProvider = values;

        }

        @objid ("1dbc676d-34df-4ebc-a1d4-39801b30f087")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkEndSmClass)this.getTarget()).getConsumerDep();
            }
            return this.symetricDep;

        }

    }

}
