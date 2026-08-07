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
import org.modelio.metamodel.uml.behavior.stateMachineModel.JunctionPseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("4b1536d5-b513-4b9d-a47b-8fd194150113")
public class JunctionPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("1b9db011-d5ee-4408-8c2f-13bb815ebd69")
    public JunctionPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9d1c2e34-df73-49e2-86cf-5bde60672f4c")
    @Override
    public String getName() {
        return "JunctionPseudoState";

    }

    @objid ("3574c0cb-81ae-40cd-9948-e98b9964c1ea")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5dd5295d-1b1c-4ce4-88f0-5ae880b33b42")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return JunctionPseudoState.class;

    }

    @objid ("0e475a4a-8b54-4810-ae15-c066959dabf6")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("11bc071e-ea8a-4917-8462-7b1402c22e20")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("8f3bfe45-7b3b-416b-ba68-b54cf4a4e7a6")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new JunctionPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a46d59d5-77d7-496b-b76c-510283274503")
    private static class JunctionPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("b687d101-2e67-45db-bc0a-59dcd9035bc9")
        private JunctionPseudoStateSmClass smClass;

        @objid ("e9956944-38e5-4f0c-af8f-e0735a74eb81")
        public JunctionPseudoStateObjectFactory(JunctionPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b4852810-ee20-486c-b997-29370b0faa92")
        @Override
        public ISmObjectData createData() {
            return new JunctionPseudoStateData(this.smClass);
        }

        @objid ("b8801f16-b0d5-4f3e-8227-d83ad77a9ae3")
        @Override
        public SmObjectImpl createImpl() {
            return new JunctionPseudoStateImpl();
        }

    }

}
