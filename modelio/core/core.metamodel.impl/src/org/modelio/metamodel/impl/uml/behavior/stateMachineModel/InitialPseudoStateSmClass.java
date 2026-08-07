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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.stateMachineModel.AbstractPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.InitialPseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("644df315-fea1-40b6-95e5-cc683ce071c7")
public class InitialPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("126c727a-a222-4c50-b241-3f76ff63762e")
    public InitialPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("db98b723-3864-4f01-befa-07b28ab9ccc7")
    @Override
    public String getName() {
        return "InitialPseudoState";

    }

    @objid ("531df177-d43f-47ac-a730-9700fa6f7150")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e4fa43d4-210b-4631-b209-dfa4aec54674")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InitialPseudoState.class;

    }

    @objid ("85fd49eb-71a8-4978-b086-fe73246ec5de")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("846e0b13-99a0-4815-a47c-d31c8685af33")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("d17a5b1a-75fb-48a0-a968-633676cd94e6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new InitialPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("e05b04d4-15d5-4973-8dc5-671677246c65")
    private static class InitialPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("2cd8c839-7478-41f6-8bc4-f1a6c9e48627")
        private InitialPseudoStateSmClass smClass;

        @objid ("b8a2a36f-26b0-4d1b-8594-3f2e635455af")
        public InitialPseudoStateObjectFactory(InitialPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("cfb6a2b4-a2f2-44d4-a604-38c0a79bbbd5")
        @Override
        public ISmObjectData createData() {
            return new InitialPseudoStateData(this.smClass);
        }

        @objid ("eed84805-a84f-4995-a953-4d0503f22f70")
        @Override
        public SmObjectImpl createImpl() {
            return new InitialPseudoStateImpl();
        }

    }

}
