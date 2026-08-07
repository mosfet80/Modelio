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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.layers.physical.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.TechnologyActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.physical.structure.active.DistributionNetwork;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1801c9c9-08cc-4639-bd8e-3b8366a0596d")
public class DistributionNetworkSmClass extends TechnologyActiveStructureElementSmClass {
    @objid ("f85a8a13-cc78-4d3d-9ac9-656fb553b6dc")
    public DistributionNetworkSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0d7204bc-d531-4d46-a199-0bb119363657")
    @Override
    public String getName() {
        return "DistributionNetwork";

    }

    @objid ("785fe12d-39f6-42eb-8952-8d85dad6a67e")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("f6242666-a997-48ab-bf80-fa489df0f510")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DistributionNetwork.class;

    }

    @objid ("e39bf8fe-ff6f-4531-b94a-4d1021c1f2c7")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("d1a01611-f862-43b1-8633-68beed568bdd")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("b34facfb-d163-4546-a1f7-fddd7cb7ffcd")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyActiveStructureElement.MQNAME);
        this.registerFactory(new DistributionNetworkObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a11ff125-3241-4da7-a03d-a3d527141083")
    private static class DistributionNetworkObjectFactory implements ISmObjectFactory {
        @objid ("40270127-ff24-4845-9fc4-b6acbda4719a")
        private DistributionNetworkSmClass smClass;

        @objid ("275e4bd8-913a-48a5-86c2-9c6bf2f2814c")
        public DistributionNetworkObjectFactory(DistributionNetworkSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c60e8502-f37d-4501-929f-318f946fb759")
        @Override
        public ISmObjectData createData() {
            return new DistributionNetworkData(this.smClass);
        }

        @objid ("3ef96842-68e3-4cbe-9449-9cf912ca5b82")
        @Override
        public SmObjectImpl createImpl() {
            return new DistributionNetworkImpl();
        }

    }

}
