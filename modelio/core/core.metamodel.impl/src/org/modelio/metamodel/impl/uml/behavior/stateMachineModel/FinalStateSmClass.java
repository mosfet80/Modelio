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
import org.modelio.metamodel.uml.behavior.stateMachineModel.FinalState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("33cd240c-7179-433e-8497-c01cf1563bf1")
public class FinalStateSmClass extends StateSmClass {
    @objid ("f113e2f3-86c8-4c56-8df5-ccd3d40e42a6")
    public FinalStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("fcdbecf8-97c1-4e27-8b21-b85db0a3e7a0")
    @Override
    public String getName() {
        return "FinalState";

    }

    @objid ("a359a869-4f5c-4ef3-92e0-1c98f234b661")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("78afe608-aec2-4417-bf07-331f243ff0e0")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return FinalState.class;

    }

    @objid ("0fd303b1-c3da-40ff-9b0a-cf23e6a36f43")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f4d73422-f08f-4931-8ccb-0b50bafc9b57")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("49d7f8b5-4f17-4eb2-a456-13a4ddd54de4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(State.MQNAME);
        this.registerFactory(new FinalStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("437f4304-39aa-43ce-ba1b-70ef405e4e46")
    private static class FinalStateObjectFactory implements ISmObjectFactory {
        @objid ("137a8d58-2ac1-4686-93f3-b027cf149174")
        private FinalStateSmClass smClass;

        @objid ("14c742bd-d63a-45ca-b453-52ea52fe7b11")
        public FinalStateObjectFactory(FinalStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("21d0776d-db0e-4d21-9db6-08bd1c6b7bed")
        @Override
        public ISmObjectData createData() {
            return new FinalStateData(this.smClass);
        }

        @objid ("753c44bc-2dcc-4d10-8ec1-b1ef40a0748c")
        @Override
        public SmObjectImpl createImpl() {
            return new FinalStateImpl();
        }

    }

}
