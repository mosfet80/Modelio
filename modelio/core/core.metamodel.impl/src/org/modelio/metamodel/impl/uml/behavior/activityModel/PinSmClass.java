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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.ParameterSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
import org.modelio.metamodel.uml.statik.Parameter;
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

@objid ("1ced2aab-2b41-4c35-8f1e-6ea38c33170d")
public class PinSmClass extends ObjectNodeSmClass {
    @objid ("af127527-3297-4170-a53e-94de81b1f676")
    private SmAttribute isControlAtt;

    @objid ("002f4080-1050-41fa-b3ba-e4e7b522ffc6")
    private SmAttribute isExpansionAtt;

    @objid ("54af6b4c-d82d-4b42-99cc-eaae49e5bcea")
    private SmDependency matchedDep;

    @objid ("7bc77f0c-1e47-4d48-84f1-d43c50f8779d")
    public PinSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("2aa370f6-9f50-4e2c-8bb2-8b2f117f69a7")
    @Override
    public String getName() {
        return "Pin";

    }

    @objid ("59f7e4d2-1ecb-48a3-b7e6-ae66a936ad6b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("56ed71f3-6140-430a-b73d-bb608a7d2af3")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Pin.class;

    }

    @objid ("6836b496-7b66-40ae-836b-8261f6986968")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("d2a8b163-30dd-47ab-b063-ba050f808602")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("16c03493-4688-4822-97dd-d7959c3970c0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ObjectNode.MQNAME);
        this.registerFactory(new PinObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isControlAtt = new IsControlSmAttribute();
        this.isControlAtt.init("IsControl", this, Boolean.class );
        registerAttribute(this.isControlAtt);

        this.isExpansionAtt = new IsExpansionSmAttribute();
        this.isExpansionAtt.init("IsExpansion", this, Boolean.class );
        registerAttribute(this.isExpansionAtt);


        // Initialize and register the SmDependency
        this.matchedDep = new MatchedSmDependency();
        this.matchedDep.init("Matched", this, metamodel.getMClass(Parameter.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.matchedDep);

    }

    @objid ("b66c130a-ca3e-4796-9817-aa7d00ade720")
    public SmAttribute getIsControlAtt() {
        if (this.isControlAtt == null) {
        	this.isControlAtt = this.getAttributeDef("IsControl");
        }
        return this.isControlAtt;
    }

    @objid ("0ed0fad8-c760-4287-b7f3-695acb67b208")
    public SmAttribute getIsExpansionAtt() {
        if (this.isExpansionAtt == null) {
        	this.isExpansionAtt = this.getAttributeDef("IsExpansion");
        }
        return this.isExpansionAtt;
    }

    @objid ("e408c3e3-5944-4212-ab0e-4fc3b10eef37")
    public SmDependency getMatchedDep() {
        if (this.matchedDep == null) {
        	this.matchedDep = this.getDependencyDef("Matched");
        }
        return this.matchedDep;
    }

    @objid ("b579b182-bccb-4582-9062-ae8d609f4047")
    private static class PinObjectFactory implements ISmObjectFactory {
        @objid ("77d9eab6-05a8-447b-a020-69b2319a2060")
        private PinSmClass smClass;

        @objid ("542708ae-12d6-48bb-933b-a47dbf6c677a")
        public PinObjectFactory(PinSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("909290e8-94f9-4f61-8d75-144484a25dde")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("5ca42f6c-bb6c-437f-b682-b51299656ef4")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("88375186-61ee-404c-9566-c6717d24e9e0")
    public static class IsControlSmAttribute extends SmAttribute {
        @objid ("45ca0518-43ca-4bb8-b156-85049ce5f91b")
        public Object getValue(ISmObjectData data) {
            return ((PinData) data).mIsControl;
        }

        @objid ("a3de187b-683d-4c3f-b40c-977feb69762a")
        public void setValue(ISmObjectData data, Object value) {
            ((PinData) data).mIsControl = value;
        }

    }

    @objid ("885548f0-1208-4f5f-bd95-081e2ec7e7e9")
    public static class IsExpansionSmAttribute extends SmAttribute {
        @objid ("a04420cb-cb51-46e3-9eec-a345fa31e200")
        public Object getValue(ISmObjectData data) {
            return ((PinData) data).mIsExpansion;
        }

        @objid ("e2077fff-d1fd-4953-8e83-a2a1e25a0321")
        public void setValue(ISmObjectData data, Object value) {
            ((PinData) data).mIsExpansion = value;
        }

    }

    @objid ("4432d800-6b35-48b5-8ae3-14221cfb60cb")
    public static class MatchedSmDependency extends SmSingleDependency {
        @objid ("66b20495-0024-4d73-add1-20be40aad350")
        private SmDependency symetricDep;

        @objid ("ca813066-2c5d-4994-8102-8b8b22e072fc")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((PinData) data).mMatched;
        }

        @objid ("5bdb2601-a420-4810-91cd-f0b43bf81060")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((PinData) data).mMatched = value;
        }

        @objid ("f51ff964-b735-4275-bd46-5ffdddd0b930")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ParameterSmClass)this.getTarget()).getMatchingDep();
            }
            return this.symetricDep;

        }

    }

}
