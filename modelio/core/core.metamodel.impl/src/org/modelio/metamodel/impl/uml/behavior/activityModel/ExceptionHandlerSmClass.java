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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.GeneralClassSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.InputPin;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.GeneralClass;
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
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("e0fb04a1-c5b8-467d-8e26-5fa7d5ce5735")
public class ExceptionHandlerSmClass extends UmlModelElementSmClass {
    @objid ("88538a0e-69ee-46f6-abbf-04fea91ca9fe")
    private SmAttribute guardAtt;

    @objid ("7885852d-c10e-4d5f-9f6d-928a5b4b9276")
    private SmAttribute weightAtt;

    @objid ("f3127d18-cfe1-4838-8d18-3423fb602455")
    private SmDependency protectedNodeDep;

    @objid ("7d5dfb6f-5530-4ff6-97b1-529d1a607f5f")
    private SmDependency exceptionInputDep;

    @objid ("9cec8256-2131-4cf0-82aa-cf4c43cff0d8")
    private SmDependency exceptionTypeDep;

    @objid ("8d946111-3e3c-41d9-b059-cb2ade982cdd")
    public ExceptionHandlerSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("851f3a5a-91f1-49f2-98d2-2db702367668")
    @Override
    public String getName() {
        return "ExceptionHandler";

    }

    @objid ("c237026d-ece3-4753-95e0-5a10c588e315")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("ad0e0167-c5d7-41c5-b689-dc2ad3faa475")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExceptionHandler.class;

    }

    @objid ("3717c0ec-5ff0-4f1f-921f-5f4aa0197e3c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("ff822591-c920-4e5c-add7-36007dfeb8ff")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1c49cd83-1940-482d-aa35-3642f851e3f1")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ExceptionHandlerObjectFactory(this));


        // Initialize and register the SmAttribute
        this.guardAtt = new GuardSmAttribute();
        this.guardAtt.init("Guard", this, String.class );
        registerAttribute(this.guardAtt);

        this.weightAtt = new WeightSmAttribute();
        this.weightAtt.init("Weight", this, String.class );
        registerAttribute(this.weightAtt);


        // Initialize and register the SmDependency
        this.protectedNodeDep = new ProtectedNodeSmDependency();
        this.protectedNodeDep.init("ProtectedNode", this, metamodel.getMClass(ActivityAction.MQNAME), 1, 1 );
        registerDependency(this.protectedNodeDep);

        this.exceptionInputDep = new ExceptionInputSmDependency();
        this.exceptionInputDep.init("ExceptionInput", this, metamodel.getMClass(InputPin.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.exceptionInputDep);

        this.exceptionTypeDep = new ExceptionTypeSmDependency();
        this.exceptionTypeDep.init("ExceptionType", this, metamodel.getMClass(GeneralClass.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.exceptionTypeDep);

    }

    @objid ("ed10d26e-4ad6-4df8-abce-fcbe4132d20b")
    public SmAttribute getGuardAtt() {
        if (this.guardAtt == null) {
        	this.guardAtt = this.getAttributeDef("Guard");
        }
        return this.guardAtt;
    }

    @objid ("c0237dd7-d3d2-44b0-a8f2-544f40ad2b05")
    public SmAttribute getWeightAtt() {
        if (this.weightAtt == null) {
        	this.weightAtt = this.getAttributeDef("Weight");
        }
        return this.weightAtt;
    }

    @objid ("75ee7544-1b8f-4294-810c-738d5ffa1d82")
    public SmDependency getProtectedNodeDep() {
        if (this.protectedNodeDep == null) {
        	this.protectedNodeDep = this.getDependencyDef("ProtectedNode");
        }
        return this.protectedNodeDep;
    }

    @objid ("a13fa1e6-293c-4641-b520-b2088d442fb6")
    public SmDependency getExceptionInputDep() {
        if (this.exceptionInputDep == null) {
        	this.exceptionInputDep = this.getDependencyDef("ExceptionInput");
        }
        return this.exceptionInputDep;
    }

    @objid ("6c8c86e6-3acf-4731-b90a-acc25a93acd9")
    public SmDependency getExceptionTypeDep() {
        if (this.exceptionTypeDep == null) {
        	this.exceptionTypeDep = this.getDependencyDef("ExceptionType");
        }
        return this.exceptionTypeDep;
    }

    @objid ("4a92c4ec-79a0-4140-88bc-296e905e0402")
    private static class ExceptionHandlerObjectFactory implements ISmObjectFactory {
        @objid ("f5b3f9a4-1869-439d-bf6c-50ae13b9a741")
        private ExceptionHandlerSmClass smClass;

        @objid ("29b0c5c1-ff7a-45fa-9b32-8b269b7f9ae9")
        public ExceptionHandlerObjectFactory(ExceptionHandlerSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1a530530-1e08-49f3-b099-878ce92b5f2f")
        @Override
        public ISmObjectData createData() {
            return new ExceptionHandlerData(this.smClass);
        }

        @objid ("d37af873-0037-4a8b-910e-bc85dbb568cd")
        @Override
        public SmObjectImpl createImpl() {
            return new ExceptionHandlerImpl();
        }

    }

    @objid ("5d4d0056-6e7c-4c0a-9aa7-244fbf9b89c4")
    public static class GuardSmAttribute extends SmAttribute {
        @objid ("ae4df363-c646-4297-8312-abd3cf7a5036")
        public Object getValue(ISmObjectData data) {
            return ((ExceptionHandlerData) data).mGuard;
        }

        @objid ("ca4aa063-9632-43c0-9d70-2e448ee46192")
        public void setValue(ISmObjectData data, Object value) {
            ((ExceptionHandlerData) data).mGuard = value;
        }

    }

    @objid ("44327b46-5758-4abe-a625-32ec641fdf74")
    public static class WeightSmAttribute extends SmAttribute {
        @objid ("cb736de1-ce9f-47f8-a2b9-20f0e6e29f7c")
        public Object getValue(ISmObjectData data) {
            return ((ExceptionHandlerData) data).mWeight;
        }

        @objid ("0d54cab0-ee11-4061-baee-15cb2462d370")
        public void setValue(ISmObjectData data, Object value) {
            ((ExceptionHandlerData) data).mWeight = value;
        }

    }

    @objid ("306eff38-058d-4baf-9d60-fac4406bb9a6")
    public static class ProtectedNodeSmDependency extends SmSingleDependency {
        @objid ("31a94afb-14bb-4438-8b9e-8130fb2c65bf")
        private SmDependency symetricDep;

        @objid ("3065f862-a17d-4c54-a15e-2fc0c5597476")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExceptionHandlerData) data).mProtectedNode;
        }

        @objid ("edd9cac7-4b02-45d2-b30a-e577c154d29d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExceptionHandlerData) data).mProtectedNode = value;
        }

        @objid ("b6818f97-da8b-457c-a037-af761eb30271")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityActionSmClass)this.getTarget()).getHandlerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("eb0a49f6-d0c3-4854-881b-1260d0f22788")
    public static class ExceptionInputSmDependency extends SmSingleDependency {
        @objid ("96351c27-ff43-456f-a4ad-05e040e5406d")
        private SmDependency symetricDep;

        @objid ("3be15065-505b-4b36-af7b-d8427bead18f")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExceptionHandlerData) data).mExceptionInput;
        }

        @objid ("0300895e-2ada-4fde-8edd-737addb9f15a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExceptionHandlerData) data).mExceptionInput = value;
        }

        @objid ("c9d37a36-2f52-4ba8-a7c6-1d626b57ba24")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InputPinSmClass)this.getTarget()).getHandlerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("eae02582-2186-4719-8117-a5252ac1bbea")
    public static class ExceptionTypeSmDependency extends SmMultipleDependency {
        @objid ("3aab4338-b196-43c0-a9fd-e9150ee40d5c")
        private SmDependency symetricDep;

        @objid ("09d47cfc-7f20-4319-b870-7a7fe9f6eb37")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ExceptionHandlerData)data).mExceptionType != null)? ((ExceptionHandlerData)data).mExceptionType:SmMultipleDependency.EMPTY;
        }

        @objid ("89f28675-1b39-419a-b0f5-40266995ef7f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ExceptionHandlerData) data).mExceptionType = values;

        }

        @objid ("4a139ac6-b574-4944-9b20-938ad427ee89")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralClassSmClass)this.getTarget()).getExceptionInputDep();
            }
            return this.symetricDep;

        }

    }

}
