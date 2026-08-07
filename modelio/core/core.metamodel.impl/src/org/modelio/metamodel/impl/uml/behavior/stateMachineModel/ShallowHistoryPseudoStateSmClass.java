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
import org.modelio.metamodel.uml.behavior.stateMachineModel.ShallowHistoryPseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("754f8010-1042-4044-860e-56a58ad680d5")
public class ShallowHistoryPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("1d20fb5f-c7ae-4461-9736-6ebf32778901")
    public ShallowHistoryPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a4f738a6-4cd6-44ba-8b14-72eb132ed637")
    @Override
    public String getName() {
        return "ShallowHistoryPseudoState";

    }

    @objid ("15a995f7-3939-4f0e-ab76-3e54e3f70862")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("6a0fbb4a-11f4-4dfb-b917-7c22ebaec578")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ShallowHistoryPseudoState.class;

    }

    @objid ("bd72cff0-ddf1-43fa-a225-945a03157db9")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("6eaa0d38-c17d-4e36-9fd2-a645717823b7")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("49362384-3dc6-4964-912d-5ce9e5701736")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new ShallowHistoryPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("959ff871-02ad-49b9-af01-c55a292186c0")
    private static class ShallowHistoryPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("ca6e689e-bc57-4ce6-bfe4-ec3baced759d")
        private ShallowHistoryPseudoStateSmClass smClass;

        @objid ("47614eba-62af-4172-aca5-8cfdefebb4fe")
        public ShallowHistoryPseudoStateObjectFactory(ShallowHistoryPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("52d87e88-f781-4869-a2c8-4ff2e557a9ea")
        @Override
        public ISmObjectData createData() {
            return new ShallowHistoryPseudoStateData(this.smClass);
        }

        @objid ("944b7b0d-842a-4f60-8edb-fa2110da5f31")
        @Override
        public SmObjectImpl createImpl() {
            return new ShallowHistoryPseudoStateImpl();
        }

    }

}
