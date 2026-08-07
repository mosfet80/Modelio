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
import org.modelio.metamodel.uml.behavior.stateMachineModel.TerminatePseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1427429a-2d1c-400a-81f2-36a8036426ab")
public class TerminatePseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("352484c0-5520-481c-97ad-ed7219e3c2a1")
    public TerminatePseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f62bb782-390e-4b8b-bd04-9b0055565b4f")
    @Override
    public String getName() {
        return "TerminatePseudoState";

    }

    @objid ("20e4e5b5-3ab0-4102-8590-99e4b91b54b9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("db69f32a-1aa6-495b-80c9-0f28700b352a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TerminatePseudoState.class;

    }

    @objid ("9dada6a5-4a0e-4ba8-a198-974a4ebb756d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("42d89bdb-3d57-46fc-8ee1-66ff2ddd0503")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("b98878a7-7e9d-4064-b873-66c604f5c78e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new TerminatePseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("19122cb5-e5fd-4992-acb1-79f91ccc2390")
    private static class TerminatePseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("d333c3f4-12c6-4188-8339-c3c7d2f7644c")
        private TerminatePseudoStateSmClass smClass;

        @objid ("3ba08426-6b50-4376-bc0a-2307997956a5")
        public TerminatePseudoStateObjectFactory(TerminatePseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("015f0409-ac59-4a91-bf26-93828065d92e")
        @Override
        public ISmObjectData createData() {
            return new TerminatePseudoStateData(this.smClass);
        }

        @objid ("6827bd56-7f9a-48c7-925a-e5e8f32ad88c")
        @Override
        public SmObjectImpl createImpl() {
            return new TerminatePseudoStateImpl();
        }

    }

}
