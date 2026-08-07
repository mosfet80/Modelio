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
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.uml.statik.LinkEnd;
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

@objid ("9be2b5a2-c153-473d-878e-f3214b6f8407")
public class ConnectorEndSmClass extends LinkEndSmClass {
    @objid ("516f2feb-2c60-41cc-9570-d5be87d69b20")
    private SmDependency representationDep;

    @objid ("75f9f09c-177d-4c64-8de1-773851118fe6")
    private SmDependency representedFeatureDep;

    @objid ("d1ee8e07-5fc5-401d-aa59-5cdadf944696")
    public ConnectorEndSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("1a63dc5c-9cc5-4dff-b041-cdd2e62acdc1")
    @Override
    public String getName() {
        return "ConnectorEnd";

    }

    @objid ("5452d030-0271-428e-a69f-9477d87d5373")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("9ceecb6e-5771-40a8-82c2-14fced6aec89")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ConnectorEnd.class;

    }

    @objid ("90de466b-97cb-4d41-a0c5-b8fe99613c7e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7e7d3c1c-53e4-4c9a-a553-ba597add8037")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("5ccd72eb-9785-4724-964d-8c7ded86b3ce")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(LinkEnd.MQNAME);
        this.registerFactory(new ConnectorEndObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.representationDep = new RepresentationSmDependency();
        this.representationDep.init("Representation", this, metamodel.getMClass(Binding.MQNAME), 0, -1 );
        registerDependency(this.representationDep);

        this.representedFeatureDep = new RepresentedFeatureSmDependency();
        this.representedFeatureDep.init("RepresentedFeature", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedFeatureDep);

    }

    @objid ("c211060d-4d69-44c5-a659-af8640033af1")
    public SmDependency getRepresentationDep() {
        if (this.representationDep == null) {
        	this.representationDep = this.getDependencyDef("Representation");
        }
        return this.representationDep;
    }

    @objid ("97b41840-df80-440d-94e9-87f5af1ced09")
    public SmDependency getRepresentedFeatureDep() {
        if (this.representedFeatureDep == null) {
        	this.representedFeatureDep = this.getDependencyDef("RepresentedFeature");
        }
        return this.representedFeatureDep;
    }

    @objid ("27b7380d-fde0-4bf5-a66f-809c59c17ad5")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("5908bc43-89a0-4325-8a8e-75366d61fcba")
    private static class ConnectorEndObjectFactory implements ISmObjectFactory {
        @objid ("ca52c9d7-06c9-4d9b-ad57-6082c6d763da")
        private ConnectorEndSmClass smClass;

        @objid ("35b885e3-ab49-4f82-96bb-2d885a95e144")
        public ConnectorEndObjectFactory(ConnectorEndSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9c521bad-5a68-41b5-8471-8c0dd4ceb07d")
        @Override
        public ISmObjectData createData() {
            return new ConnectorEndData(this.smClass);
        }

        @objid ("0e64bd9f-672c-464e-b17e-604f056837b7")
        @Override
        public SmObjectImpl createImpl() {
            return new ConnectorEndImpl();
        }

    }

    @objid ("27f4f1ae-514f-40be-883e-af22c0685f12")
    public static class RepresentationSmDependency extends SmMultipleDependency {
        @objid ("f139e3b7-efa3-4606-8a50-acbaff6bf957")
        private SmDependency symetricDep;

        @objid ("0f272aad-d213-472f-b042-675715d2d77c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ConnectorEndData)data).mRepresentation != null)? ((ConnectorEndData)data).mRepresentation:SmMultipleDependency.EMPTY;
        }

        @objid ("c822b5be-b1d5-4198-9440-6964abdf534d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ConnectorEndData) data).mRepresentation = values;

        }

        @objid ("570d10db-176c-428a-bdc0-9c6ff0cceed6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindingSmClass)this.getTarget()).getConnectorEndRoleDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("55b2a698-e612-457a-a827-bfc7cf2972eb")
    public static class RepresentedFeatureSmDependency extends SmSingleDependency {
        @objid ("f460de68-ba4d-4c04-a740-e23629a64105")
        private SmDependency symetricDep;

        @objid ("ff752464-b9fd-4bb0-b930-dec9f3ca92f8")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ConnectorEndData) data).mRepresentedFeature;
        }

        @objid ("e9c59ff1-1ee6-44bf-94bd-626c4e34a9f2")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ConnectorEndData) data).mRepresentedFeature = value;
        }

        @objid ("a595c895-82b6-4930-815a-609616ed1141")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getRepresentingEndDep();
            }
            return this.symetricDep;

        }

    }

}
