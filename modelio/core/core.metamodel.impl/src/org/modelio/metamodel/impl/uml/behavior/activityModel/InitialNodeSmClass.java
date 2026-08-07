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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ControlNode;
import org.modelio.metamodel.uml.behavior.activityModel.InitialNode;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("094a69f0-ca69-4bf2-a30b-3e7a335c2488")
public class InitialNodeSmClass extends ControlNodeSmClass {
    @objid ("6d5fad67-25d7-421e-bb23-503d41ad72ce")
    public InitialNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("34f2b793-4b6b-4854-8dcc-110810eac792")
    @Override
    public String getName() {
        return "InitialNode";

    }

    @objid ("62d89d84-91a5-4126-b95a-eca729d1ad6b")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3782ed7e-c682-4cde-a2c9-04ded250de7d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InitialNode.class;

    }

    @objid ("2751fb46-caf4-4653-aa05-13c66ffce969")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("51e9d645-8e73-46bc-ae0b-69c0785272be")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("7b9d0dd5-4e02-40f2-b2dc-b11c184505be")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ControlNode.MQNAME);
        this.registerFactory(new InitialNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("7cd33510-8e9b-49a1-b1bb-7e1458304a18")
    private static class InitialNodeObjectFactory implements ISmObjectFactory {
        @objid ("4932622c-4e7f-4300-a405-7d463fa94674")
        private InitialNodeSmClass smClass;

        @objid ("e7562cec-5b91-4515-92c1-781c25539924")
        public InitialNodeObjectFactory(InitialNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5e270f53-20c4-41fe-9783-31337d628712")
        @Override
        public ISmObjectData createData() {
            return new InitialNodeData(this.smClass);
        }

        @objid ("eae6c6f2-c6b3-4a58-8084-ed6d2c406287")
        @Override
        public SmObjectImpl createImpl() {
            return new InitialNodeImpl();
        }

    }

}
