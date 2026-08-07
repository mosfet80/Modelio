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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.events.BpmnCancelEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("91036f21-67af-4bbc-b98d-6a3bcdf755fc")
public class BpmnCancelEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("1b818f9a-4f57-45f2-8873-ec43534b4881")
    public BpmnCancelEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("42f63e1c-b4b2-4c9f-9bc1-5012095d0fcf")
    @Override
    public String getName() {
        return "BpmnCancelEventDefinition";

    }

    @objid ("278ab813-4457-4a6e-a76e-743800fa8424")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5666e9a9-ba5c-4945-a899-f1a9bc8ed359")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnCancelEventDefinition.class;

    }

    @objid ("eaf3ab6f-94db-4468-bd7e-1d8341226706")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1bbc5d82-8981-4e71-a405-5b33270437f0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a32bf74d-7b36-47ed-9a22-ab513f4991f5")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnCancelEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c1cb4099-8018-4ca7-90c3-d9c2e70d6bd1")
    private static class BpmnCancelEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("a52f62e2-bba9-41dd-9491-f0521a3701c0")
        private BpmnCancelEventDefinitionSmClass smClass;

        @objid ("5693bd68-520d-4b65-bb95-887dd316ea26")
        public BpmnCancelEventDefinitionObjectFactory(BpmnCancelEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("1e132788-5718-49a3-8427-12cb7e56cb8a")
        @Override
        public ISmObjectData createData() {
            return new BpmnCancelEventDefinitionData(this.smClass);
        }

        @objid ("98a52cc4-3bf0-47b8-a86d-471c107aecff")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnCancelEventDefinitionImpl();
        }

    }

}
