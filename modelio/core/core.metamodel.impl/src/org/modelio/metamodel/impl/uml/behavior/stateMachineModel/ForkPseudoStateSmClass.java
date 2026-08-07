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
import org.modelio.metamodel.uml.behavior.stateMachineModel.ForkPseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("51ce5a8b-d368-44e6-9660-4fa2d173b067")
public class ForkPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("e7475f5f-4b2e-48d6-81e1-788636012612")
    public ForkPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("7570d68a-3e39-409a-a801-0cfccbcdc14b")
    @Override
    public String getName() {
        return "ForkPseudoState";

    }

    @objid ("3c5d7565-10b8-42fb-beac-932c72c9c53c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("6333c5cb-14d3-4e5f-9b27-f79fae73de27")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ForkPseudoState.class;

    }

    @objid ("4769c265-9d1a-4155-8bd4-5792010332a0")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e01b74d3-94fb-45cc-b578-309a0e169c1d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8804e60e-dafe-4320-8c85-96de99550822")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new ForkPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("b8eec8d2-7d8f-4091-89a4-ebf89f675fc3")
    private static class ForkPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("738ef73b-2dae-4961-9135-a080172bb1cb")
        private ForkPseudoStateSmClass smClass;

        @objid ("a7169317-55a4-421a-81ab-01e1dc8ec9a2")
        public ForkPseudoStateObjectFactory(ForkPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("92fd302c-0739-4b7e-86eb-87a36ae97182")
        @Override
        public ISmObjectData createData() {
            return new ForkPseudoStateData(this.smClass);
        }

        @objid ("a72da784-d575-4127-8c15-3d2f412d59d1")
        @Override
        public SmObjectImpl createImpl() {
            return new ForkPseudoStateImpl();
        }

    }

}
