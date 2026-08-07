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
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.AttributeLink;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("97a1dde2-c320-448c-8141-4c39d53500a2")
public class AttributeLinkSmClass extends UmlModelElementSmClass {
    @objid ("25f8762f-8601-4990-af6d-b6bdbf0c02e3")
    private SmAttribute valueAtt;

    @objid ("2f6aad94-50a6-4045-8ec6-0a171e464f87")
    private SmDependency attributedDep;

    @objid ("b9fcc60a-858b-4879-9abc-2c2a19831b8d")
    private SmDependency baseDep;

    @objid ("c834bd91-6147-4abc-b84a-7effdce94054")
    public AttributeLinkSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("496d16b1-27c3-4475-92ff-7eccac74ef4f")
    @Override
    public String getName() {
        return "AttributeLink";

    }

    @objid ("27f8a703-abcc-4a39-b64d-b127128aa757")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("fc15778b-153c-49aa-b74a-79c82cb4d17e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AttributeLink.class;

    }

    @objid ("8d38d3a7-8ab7-4d56-b40a-2b49750c3afa")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5bf03d44-7f2e-47ad-b747-e042e9965208")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("069d3212-dc30-4e4c-8ab0-658310d08782")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new AttributeLinkObjectFactory(this));


        // Initialize and register the SmAttribute
        this.valueAtt = new ValueSmAttribute();
        this.valueAtt.init("Value", this, String.class );
        registerAttribute(this.valueAtt);


        // Initialize and register the SmDependency
        this.attributedDep = new AttributedSmDependency();
        this.attributedDep.init("Attributed", this, metamodel.getMClass(Instance.MQNAME), 1, 1 );
        registerDependency(this.attributedDep);

        this.baseDep = new BaseSmDependency();
        this.baseDep.init("Base", this, metamodel.getMClass(Attribute.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.baseDep);

    }

    @objid ("8a0694fe-128d-407e-812a-454366d88b7e")
    public SmAttribute getValueAtt() {
        if (this.valueAtt == null) {
        	this.valueAtt = this.getAttributeDef("Value");
        }
        return this.valueAtt;
    }

    @objid ("1112e21d-a3ce-44dd-b21d-22617fdb8990")
    public SmDependency getAttributedDep() {
        if (this.attributedDep == null) {
        	this.attributedDep = this.getDependencyDef("Attributed");
        }
        return this.attributedDep;
    }

    @objid ("549b9c60-3892-49b6-89c0-e5f90111988d")
    public SmDependency getBaseDep() {
        if (this.baseDep == null) {
        	this.baseDep = this.getDependencyDef("Base");
        }
        return this.baseDep;
    }

    @objid ("b4604b57-819a-43b5-bb8f-7712129ab8ec")
    private static class AttributeLinkObjectFactory implements ISmObjectFactory {
        @objid ("384670f4-6335-4148-9167-8abc54b64e2e")
        private AttributeLinkSmClass smClass;

        @objid ("f6a58968-c3f2-481b-8971-be83fcc91a80")
        public AttributeLinkObjectFactory(AttributeLinkSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b521fae7-07ff-4b29-82d3-f2b794f4113a")
        @Override
        public ISmObjectData createData() {
            return new AttributeLinkData(this.smClass);
        }

        @objid ("77faaa07-3efc-4b34-85fe-a772860a86ff")
        @Override
        public SmObjectImpl createImpl() {
            return new AttributeLinkImpl();
        }

    }

    @objid ("1a3ad329-ab47-4649-88be-c3175441bfe8")
    public static class ValueSmAttribute extends SmAttribute {
        @objid ("a82f69c8-2d9c-4d87-a734-39837e69a2e3")
        public Object getValue(ISmObjectData data) {
            return ((AttributeLinkData) data).mValue;
        }

        @objid ("2fd8081e-cf01-4eb8-9f63-06c0f0c8e759")
        public void setValue(ISmObjectData data, Object value) {
            ((AttributeLinkData) data).mValue = value;
        }

    }

    @objid ("7ef7c526-f3fd-44c0-a249-311a5a35f630")
    public static class AttributedSmDependency extends SmSingleDependency {
        @objid ("a04ee26e-86b0-4fff-af32-4f16a181f620")
        private SmDependency symetricDep;

        @objid ("e00f40a8-a5a3-4905-a1cb-796ba6fc9189")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AttributeLinkData) data).mAttributed;
        }

        @objid ("446bf6ae-66a1-4178-9b01-202df8be52b8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AttributeLinkData) data).mAttributed = value;
        }

        @objid ("a12bb893-738d-4fe0-a835-709e9e1dfee9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getSlotDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8f44c6e0-81c9-4fdc-bc66-f181f6d626fd")
    public static class BaseSmDependency extends SmSingleDependency {
        @objid ("6de2182c-49d6-43b3-b949-42cecdb6c14f")
        private SmDependency symetricDep;

        @objid ("2ddffb65-56d8-498a-9197-182b8d82c1b0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((AttributeLinkData) data).mBase;
        }

        @objid ("f443ab58-4d8d-4b00-bf4b-7b70b0c233a3")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((AttributeLinkData) data).mBase = value;
        }

        @objid ("93ce7446-685c-4080-a6ca-39b10b1ab42a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AttributeSmClass)this.getTarget()).getOccurenceDep();
            }
            return this.symetricDep;

        }

    }

}
