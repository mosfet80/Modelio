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
package org.modelio.metamodel.impl.diagrams;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.diagrams.BehaviorDiagram;
import org.modelio.metamodel.diagrams.StateMachineDiagram;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("05f971dc-3b59-4a75-b579-a10e410a0d7e")
public class StateMachineDiagramSmClass extends BehaviorDiagramSmClass {
    @objid ("75f64395-e2b5-472b-b247-bbd2d6b1dab7")
    public StateMachineDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("32422085-444f-4e6b-b7bb-ff40f66b92c9")
    @Override
    public String getName() {
        return "StateMachineDiagram";

    }

    @objid ("77633bd2-37e0-4097-af9d-ae00c26a83f6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("280c91f2-9d0f-4fcd-9580-5c78485a9f67")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StateMachineDiagram.class;

    }

    @objid ("9c938ef7-6eb5-4937-a539-bda6d52efeca")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("ef4dcd65-6041-4db0-8dc2-89219623fccd")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7653cffe-46b6-4442-bf4c-d18ea1fa7395")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BehaviorDiagram.MQNAME);
        this.registerFactory(new StateMachineDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("1fac7ed7-da96-4b14-80a1-35e56d04cbf7")
    private static class StateMachineDiagramObjectFactory implements ISmObjectFactory {
        @objid ("1b3807cd-c169-4a91-abd2-6a316c0aa38c")
        private StateMachineDiagramSmClass smClass;

        @objid ("d6c287e5-03e1-4d3c-a7c2-a4810797eeca")
        public StateMachineDiagramObjectFactory(StateMachineDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3e161484-45bf-4bbd-93ec-371960ee4bd0")
        @Override
        public ISmObjectData createData() {
            return new StateMachineDiagramData(this.smClass);
        }

        @objid ("a5525959-4d96-4acc-a6b0-56d2c2300984")
        @Override
        public SmObjectImpl createImpl() {
            return new StateMachineDiagramImpl();
        }

    }

}
