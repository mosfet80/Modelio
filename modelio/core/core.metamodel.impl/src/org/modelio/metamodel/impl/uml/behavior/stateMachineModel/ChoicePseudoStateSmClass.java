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
import org.modelio.metamodel.uml.behavior.stateMachineModel.ChoicePseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("f0a2a591-fb0e-43e8-b25c-f742e385444c")
public class ChoicePseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("e98ff890-2165-4a8e-b1c0-bc5a4e29d096")
    public ChoicePseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("651edc23-3481-4668-aab0-40c1c01f1c98")
    @Override
    public String getName() {
        return "ChoicePseudoState";

    }

    @objid ("98e7a0dd-50e7-417b-9cf8-307fb3a44626")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5602f37f-c8e0-49f8-be55-ecebaa5e61f7")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ChoicePseudoState.class;

    }

    @objid ("c71f3df2-97a1-47a3-ae1b-747ee5e98939")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("8b726a28-19a1-46cf-bef2-1a802b863cf5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("348a6f41-7ed7-4c3e-bfa3-44c9184a660c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new ChoicePseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("55cdc34f-c062-4bb0-aefa-f9872760093e")
    private static class ChoicePseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("f18c2908-deab-469c-99ab-176047b5b8c2")
        private ChoicePseudoStateSmClass smClass;

        @objid ("c54630e1-1e1c-46fb-a7cf-629a1ba387a0")
        public ChoicePseudoStateObjectFactory(ChoicePseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2e108e29-baac-4623-89ce-d6a4f75febc0")
        @Override
        public ISmObjectData createData() {
            return new ChoicePseudoStateData(this.smClass);
        }

        @objid ("34cd382b-fd42-415b-8ca9-d195fe584687")
        @Override
        public SmObjectImpl createImpl() {
            return new ChoicePseudoStateImpl();
        }

    }

}
