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
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("7c2c07e6-b241-4c59-aab8-908f4095c5cf")
public class AbstractPseudoStateSmClass extends StateVertexSmClass {
    @objid ("e3860048-7009-4222-8860-9b4f3d009cab")
    public AbstractPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("b1594065-2f1c-419d-b790-aed23acfdfcc")
    @Override
    public String getName() {
        return "AbstractPseudoState";

    }

    @objid ("eda6d16b-6788-474e-9a98-7553e6fb9b47")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("503f17f3-cfb0-4337-93f5-48dbe392e5c3")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return AbstractPseudoState.class;

    }

    @objid ("82038f2e-bf27-4f5a-a903-1896a35eb621")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a591c3cc-aca9-4898-83fe-8535185ae114")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("3931d9ee-7d31-4b02-b809-7274499814cb")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StateVertex.MQNAME);
        this.registerFactory(new AbstractPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("887b89db-d6e2-4a29-a813-3023f6e26c6c")
    private static class AbstractPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("c11ccd5d-093c-4866-ba4c-3cf109a496ee")
        private AbstractPseudoStateSmClass smClass;

        @objid ("1602bc7c-3389-49bb-99cb-1601ddf0c2c8")
        public AbstractPseudoStateObjectFactory(AbstractPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("8df7fca8-a980-48b7-83bf-d4f1de2a4cd5")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("3818b97f-2d3a-4506-80c8-bf0b4f3fd65f")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
