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
import org.modelio.metamodel.uml.statik.Generalization;
import org.modelio.metamodel.uml.statik.NameSpace;
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

@objid ("0eb120f2-b0a8-4ed0-846c-641a3466a664")
public class GeneralizationSmClass extends UmlModelElementSmClass {
    @objid ("65d7ca5c-9a6d-4a2f-ad50-a6ff1b45c053")
    private SmAttribute discriminatorAtt;

    @objid ("4aea07a9-6069-4db0-b739-aecbce639b6f")
    private SmDependency superTypeDep;

    @objid ("ea115e9d-03de-4003-8bfd-9ac7c852b2d5")
    private SmDependency subTypeDep;

    @objid ("e3ae4088-e64a-4fff-8c6e-837ea398b72a")
    public GeneralizationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a20428ea-81a1-4c46-93cb-711ec9679f9c")
    @Override
    public String getName() {
        return "Generalization";

    }

    @objid ("147e3a26-e159-492f-875d-1ed160720401")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("52c575f2-0263-4dd2-a037-47bc13841672")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Generalization.class;

    }

    @objid ("5fbd7a6d-651a-432d-87e0-e702395a9a96")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5e0389ab-6241-4db2-93ca-de6d77e172a4")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("655eb12a-a8ca-4b92-9991-bccff16f8530")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new GeneralizationObjectFactory(this));


        // Initialize and register the SmAttribute
        this.discriminatorAtt = new DiscriminatorSmAttribute();
        this.discriminatorAtt.init("Discriminator", this, String.class );
        registerAttribute(this.discriminatorAtt);


        // Initialize and register the SmDependency
        this.superTypeDep = new SuperTypeSmDependency();
        this.superTypeDep.init("SuperType", this, metamodel.getMClass(NameSpace.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.superTypeDep);

        this.subTypeDep = new SubTypeSmDependency();
        this.subTypeDep.init("SubType", this, metamodel.getMClass(NameSpace.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.subTypeDep);

    }

    @objid ("8cf4e72e-2002-4982-b20b-02d744cb7774")
    public SmAttribute getDiscriminatorAtt() {
        if (this.discriminatorAtt == null) {
        	this.discriminatorAtt = this.getAttributeDef("Discriminator");
        }
        return this.discriminatorAtt;
    }

    @objid ("d491294a-4d89-427d-877d-199baf134e77")
    public SmDependency getSuperTypeDep() {
        if (this.superTypeDep == null) {
        	this.superTypeDep = this.getDependencyDef("SuperType");
        }
        return this.superTypeDep;
    }

    @objid ("e10cb01e-72dd-4c45-873d-7c3d73c88e5e")
    public SmDependency getSubTypeDep() {
        if (this.subTypeDep == null) {
        	this.subTypeDep = this.getDependencyDef("SubType");
        }
        return this.subTypeDep;
    }

    @objid ("ea2aa351-484c-4f0a-9a49-23b55a341e07")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("f072cfcf-fdaf-4308-a83c-5f3d23019895")
    private static class GeneralizationObjectFactory implements ISmObjectFactory {
        @objid ("9f749a0e-77aa-4434-8e32-c1700b309676")
        private GeneralizationSmClass smClass;

        @objid ("40ae5e77-2450-45d2-b7b9-5ecbb5b5c244")
        public GeneralizationObjectFactory(GeneralizationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("62890549-f348-42c4-9021-99755c06ef99")
        @Override
        public ISmObjectData createData() {
            return new GeneralizationData(this.smClass);
        }

        @objid ("6b8f9051-f3a8-4815-b17e-fe27e82e160c")
        @Override
        public SmObjectImpl createImpl() {
            return new GeneralizationImpl();
        }

    }

    @objid ("64096e22-9e9c-47ce-bd55-813ca8922491")
    public static class DiscriminatorSmAttribute extends SmAttribute {
        @objid ("9d182ec5-af2a-4221-bcb5-6bb8385c3094")
        public Object getValue(ISmObjectData data) {
            return ((GeneralizationData) data).mDiscriminator;
        }

        @objid ("a2815a81-e287-4fb0-8060-8a6060690071")
        public void setValue(ISmObjectData data, Object value) {
            ((GeneralizationData) data).mDiscriminator = value;
        }

    }

    @objid ("365dbbb0-cd49-40d7-80d2-4d958b361ef6")
    public static class SuperTypeSmDependency extends SmSingleDependency {
        @objid ("baf1b710-1a0d-4a2f-aa1f-bed98408c9be")
        private SmDependency symetricDep;

        @objid ("06498503-cd2d-4691-8b6b-1251716d9ce5")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GeneralizationData) data).mSuperType;
        }

        @objid ("43dc0ba7-5190-490c-954c-c84b0469f2be")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GeneralizationData) data).mSuperType = value;
        }

        @objid ("5f46f417-1894-485b-97bd-699d297578f8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getSpecializationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d78dcb3f-9dee-4889-b2ec-744bfdfdaa2a")
    public static class SubTypeSmDependency extends SmSingleDependency {
        @objid ("3bf1d1c9-b01b-4d5c-a611-36187733727f")
        private SmDependency symetricDep;

        @objid ("3c515021-5a2f-44ae-9d16-6557eb2d3341")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GeneralizationData) data).mSubType;
        }

        @objid ("259eef88-5d2e-49df-bb51-2f25bf4a1d8b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GeneralizationData) data).mSubType = value;
        }

        @objid ("9699c57d-d726-4488-9087-1d910eee0fe0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getParentDep();
            }
            return this.symetricDep;

        }

    }

}
