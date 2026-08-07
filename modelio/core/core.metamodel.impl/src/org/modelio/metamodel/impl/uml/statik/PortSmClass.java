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
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Port;
import org.modelio.metamodel.uml.statik.PortOrientation;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;
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

@objid ("61204c97-45b7-4c84-92f4-7c2cd83be544")
public class PortSmClass extends BindableInstanceSmClass {
    @objid ("ea026b13-9cd7-4cb5-9d2d-4fd4851ce292")
    private SmAttribute isBehaviorAtt;

    @objid ("fab948d9-889d-4e6f-9e14-b3686ade74c1")
    private SmAttribute isServiceAtt;

    @objid ("74408ba4-ca8f-4965-91a8-5f4cb43b629e")
    private SmAttribute isConjugatedAtt;

    @objid ("c4239657-00a7-45c5-9ef7-6566029de9f6")
    private SmAttribute directionAtt;

    @objid ("5a1ef51c-fc47-4973-bd0b-aa6763eebfe4")
    private SmDependency providedDep;

    @objid ("7b8ba9a5-3621-43ae-b7a3-124b58624a27")
    private SmDependency requiredDep;

    @objid ("8455d05e-fe74-4f0d-b917-4743a22f4eda")
    public PortSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8cb415ef-c3e1-4a70-82f7-1ce7f5e123bd")
    @Override
    public String getName() {
        return "Port";

    }

    @objid ("b8fc5259-7149-48a4-a684-5ab3e508269a")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("cf3e7e0b-7bdd-4fea-add2-added2eb3512")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Port.class;

    }

    @objid ("65ed4eba-e679-4b72-bd04-a9e27c0bcb1b")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("56dc44da-25ef-43a5-9c92-12247a9f5641")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("07c37ac2-e3c5-43d8-bb27-2f5cd290a1e6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BindableInstance.MQNAME);
        this.registerFactory(new PortObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isBehaviorAtt = new IsBehaviorSmAttribute();
        this.isBehaviorAtt.init("IsBehavior", this, Boolean.class );
        registerAttribute(this.isBehaviorAtt);

        this.isServiceAtt = new IsServiceSmAttribute();
        this.isServiceAtt.init("IsService", this, Boolean.class );
        registerAttribute(this.isServiceAtt);

        this.isConjugatedAtt = new IsConjugatedSmAttribute();
        this.isConjugatedAtt.init("IsConjugated", this, Boolean.class );
        registerAttribute(this.isConjugatedAtt);

        this.directionAtt = new DirectionSmAttribute();
        this.directionAtt.init("Direction", this, PortOrientation.class );
        registerAttribute(this.directionAtt);


        // Initialize and register the SmDependency
        this.providedDep = new ProvidedSmDependency();
        this.providedDep.init("Provided", this, metamodel.getMClass(ProvidedInterface.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.providedDep);

        this.requiredDep = new RequiredSmDependency();
        this.requiredDep.init("Required", this, metamodel.getMClass(RequiredInterface.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.requiredDep);

    }

    @objid ("ae30ea4a-d925-4054-b523-dfe65eebe833")
    public SmAttribute getIsBehaviorAtt() {
        if (this.isBehaviorAtt == null) {
        	this.isBehaviorAtt = this.getAttributeDef("IsBehavior");
        }
        return this.isBehaviorAtt;
    }

    @objid ("de616dbf-ab11-4b28-99fd-fadb10f477c7")
    public SmAttribute getIsServiceAtt() {
        if (this.isServiceAtt == null) {
        	this.isServiceAtt = this.getAttributeDef("IsService");
        }
        return this.isServiceAtt;
    }

    @objid ("e13da17f-becd-4846-a7bd-7b3af2708b85")
    public SmAttribute getIsConjugatedAtt() {
        if (this.isConjugatedAtt == null) {
        	this.isConjugatedAtt = this.getAttributeDef("IsConjugated");
        }
        return this.isConjugatedAtt;
    }

    @objid ("2ce6b734-e1dc-40d9-85d2-abe2ae5b2689")
    public SmAttribute getDirectionAtt() {
        if (this.directionAtt == null) {
        	this.directionAtt = this.getAttributeDef("Direction");
        }
        return this.directionAtt;
    }

    @objid ("c3c296aa-725e-4204-a674-a249e891b15f")
    public SmDependency getProvidedDep() {
        if (this.providedDep == null) {
        	this.providedDep = this.getDependencyDef("Provided");
        }
        return this.providedDep;
    }

    @objid ("94dd55cb-facb-4581-9adf-985fb3aaf5c0")
    public SmDependency getRequiredDep() {
        if (this.requiredDep == null) {
        	this.requiredDep = this.getDependencyDef("Required");
        }
        return this.requiredDep;
    }

    @objid ("bec8422c-2282-4449-a915-85e752750eec")
    private static class PortObjectFactory implements ISmObjectFactory {
        @objid ("2e3fac4d-a26f-4fea-b82b-a66e9a093e98")
        private PortSmClass smClass;

        @objid ("833f05da-1eba-4899-ac05-b77dbf6c71a1")
        public PortObjectFactory(PortSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9f568f9c-035c-4ab3-9518-54a77627c9be")
        @Override
        public ISmObjectData createData() {
            return new PortData(this.smClass);
        }

        @objid ("0d1690f3-70ca-48d0-9e57-1633f5a364bb")
        @Override
        public SmObjectImpl createImpl() {
            return new PortImpl();
        }

    }

    @objid ("b9e5af97-ff1d-49c2-bfef-69611e246c4a")
    public static class IsBehaviorSmAttribute extends SmAttribute {
        @objid ("7fe4c564-6bce-4239-bf64-8d1df4b2692c")
        public Object getValue(ISmObjectData data) {
            return ((PortData) data).mIsBehavior;
        }

        @objid ("31e0f34b-efa6-42bc-a873-21fe190238cd")
        public void setValue(ISmObjectData data, Object value) {
            ((PortData) data).mIsBehavior = value;
        }

    }

    @objid ("bce3df54-ac27-4a84-bffc-be44199e0bb7")
    public static class IsServiceSmAttribute extends SmAttribute {
        @objid ("724171e3-813c-4d08-a9b4-a7585fadb371")
        public Object getValue(ISmObjectData data) {
            return ((PortData) data).mIsService;
        }

        @objid ("af7a896f-4edb-4585-a621-b6edcc7857b7")
        public void setValue(ISmObjectData data, Object value) {
            ((PortData) data).mIsService = value;
        }

    }

    @objid ("2a3fc268-a0fa-4fe7-af57-5464ca4f9786")
    public static class IsConjugatedSmAttribute extends SmAttribute {
        @objid ("2a5dca89-9979-4924-a7b3-1e528eb175d9")
        public Object getValue(ISmObjectData data) {
            return ((PortData) data).mIsConjugated;
        }

        @objid ("4f106cf5-9a4e-44d9-9625-d7cd7ca93abf")
        public void setValue(ISmObjectData data, Object value) {
            ((PortData) data).mIsConjugated = value;
        }

    }

    @objid ("21bc0ae8-296c-4d70-9b0f-aef602a047ed")
    public static class DirectionSmAttribute extends SmAttribute {
        @objid ("9f969cb7-ce51-48d8-85cb-f5b0946a7634")
        public Object getValue(ISmObjectData data) {
            return ((PortData) data).mDirection;
        }

        @objid ("cb6d5a8b-721a-4b57-a907-59fc18d48eb4")
        public void setValue(ISmObjectData data, Object value) {
            ((PortData) data).mDirection = value;
        }

    }

    @objid ("46f7750c-0a13-45be-8466-b0977ada8060")
    public static class ProvidedSmDependency extends SmMultipleDependency {
        @objid ("85f121aa-762c-4f23-8d97-129c9cb3c746")
        private SmDependency symetricDep;

        @objid ("f5f0518a-7917-4425-bf47-fbc463fc6306")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((PortData)data).mProvided != null)? ((PortData)data).mProvided:SmMultipleDependency.EMPTY;
        }

        @objid ("13f6982e-6cea-4f0b-9614-fe21eae22f81")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((PortData) data).mProvided = values;

        }

        @objid ("008e185f-8f3a-4686-a440-b0d13cf2c1c8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ProvidedInterfaceSmClass)this.getTarget()).getProvidingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b6e30311-16d7-49e0-9d53-0ce5e854e341")
    public static class RequiredSmDependency extends SmMultipleDependency {
        @objid ("c814baa2-c615-458b-93fe-922e96c3cf08")
        private SmDependency symetricDep;

        @objid ("2f7c5708-7554-4468-b950-d5f63094730f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((PortData)data).mRequired != null)? ((PortData)data).mRequired:SmMultipleDependency.EMPTY;
        }

        @objid ("1f0ea330-1a7a-4b50-9a36-baf09c214b92")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((PortData) data).mRequired = values;

        }

        @objid ("d172c77f-5f07-41c1-a9f9-2ab444474043")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RequiredInterfaceSmClass)this.getTarget()).getRequiringDep();
            }
            return this.symetricDep;

        }

    }

}
