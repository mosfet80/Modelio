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
import org.modelio.metamodel.uml.behavior.stateMachineModel.DeepHistoryPseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("e9c56d81-716f-45be-aff4-213f05dba235")
public class DeepHistoryPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("972af571-fa99-4071-908d-e9738bbc670d")
    public DeepHistoryPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8630b95a-fb23-45b3-8af4-a541ce5da91e")
    @Override
    public String getName() {
        return "DeepHistoryPseudoState";

    }

    @objid ("8c676dd4-656f-4e22-b611-0ed887ea64c9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c71f024e-f46a-41d3-92c0-d612d1b394b8")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DeepHistoryPseudoState.class;

    }

    @objid ("f726d11c-40b0-46d1-944e-290d1b12b87c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("4c0d8ddf-a0f8-4eee-90bc-c51cf2d7411e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7f3e11a1-f06d-4719-ae44-5351f2e7d165")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new DeepHistoryPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("da8f2c61-8306-4e23-b813-5fb03a2eca69")
    private static class DeepHistoryPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("9211f006-27ca-44b7-a435-26a11693087f")
        private DeepHistoryPseudoStateSmClass smClass;

        @objid ("94b69c66-6c12-43c1-8481-fea5369c4171")
        public DeepHistoryPseudoStateObjectFactory(DeepHistoryPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a72d4461-c275-4da2-a447-29e723d742ed")
        @Override
        public ISmObjectData createData() {
            return new DeepHistoryPseudoStateData(this.smClass);
        }

        @objid ("2dffd468-b1dd-4152-91b6-64ea5dc5ec9e")
        @Override
        public SmObjectImpl createImpl() {
            return new DeepHistoryPseudoStateImpl();
        }

    }

}
