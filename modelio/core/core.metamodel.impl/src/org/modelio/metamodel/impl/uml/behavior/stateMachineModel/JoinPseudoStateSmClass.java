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
import org.modelio.metamodel.uml.behavior.stateMachineModel.JoinPseudoState;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("ad158599-e4d5-48f9-8d7a-9611ad5776cb")
public class JoinPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("598301f1-eb07-4969-9dbf-4eee03ec0446")
    public JoinPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9e9cd73a-d792-44c5-a6e1-9429df8c38d2")
    @Override
    public String getName() {
        return "JoinPseudoState";

    }

    @objid ("87992a9c-7931-4142-adda-4fe31972f068")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c296b55b-2268-4697-871b-82d981b51f8e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return JoinPseudoState.class;

    }

    @objid ("31eb8dcf-2698-4e89-a728-8b6c4edcaccd")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("8e501092-4589-4e9f-9f25-56d3e9d41e70")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("23e354d1-d1fc-410b-bdf1-61d8e5a83ca7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new JoinPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c0d07e40-271c-4c2b-a530-c82550a1c64a")
    private static class JoinPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("e734441e-1263-48fd-a397-c2434e65810a")
        private JoinPseudoStateSmClass smClass;

        @objid ("8e4d755d-f178-4503-8346-ba7930dcf576")
        public JoinPseudoStateObjectFactory(JoinPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1e73842a-419f-4e33-931c-8bc16766bad2")
        @Override
        public ISmObjectData createData() {
            return new JoinPseudoStateData(this.smClass);
        }

        @objid ("bf53789e-ca27-4f94-b222-6cbbb3875877")
        @Override
        public SmObjectImpl createImpl() {
            return new JoinPseudoStateImpl();
        }

    }

}
