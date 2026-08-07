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
package org.modelio.archimate.metamodel.impl.layers.business.structure.passive;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessPassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.layers.business.BusinessPassiveStructureElement;
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("05db633a-0207-4652-a2a7-196e46de1b67")
public class BusinessObjectSmClass extends BusinessPassiveStructureElementSmClass {
    @objid ("a63bb58c-cf91-42f0-a201-9f76ba87385b")
    public BusinessObjectSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f31f57dc-5ff8-46ef-83eb-822a0c00ad23")
    @Override
    public String getName() {
        return "BusinessObject";

    }

    @objid ("7bf085ea-de7a-41ac-9ce5-f7eb9431a228")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("a187c05f-907b-4f45-ad84-57568498e959")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BusinessObject.class;

    }

    @objid ("a808b177-befc-479d-b55d-9600447ad97e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("aa866155-effa-4142-b9d1-8047bad56d1d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("59964b3c-9491-4f47-8f19-e818ea3529b7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BusinessPassiveStructureElement.MQNAME);
        this.registerFactory(new BusinessObjectObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("9aa6f1d3-0f60-4b10-b066-ee85e671bd8e")
    private static class BusinessObjectObjectFactory implements ISmObjectFactory {
        @objid ("a0558145-553d-4984-8364-106244238409")
        private BusinessObjectSmClass smClass;

        @objid ("22ec396f-962a-4ae3-9003-94d4e240560b")
        public BusinessObjectObjectFactory(BusinessObjectSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5b0e8b10-d1c7-48ec-8f69-6e743cfcc794")
        @Override
        public ISmObjectData createData() {
            return new BusinessObjectData(this.smClass);
        }

        @objid ("6c9c0f3b-232b-4ab2-9fb9-67afee0a70be")
        @Override
        public SmObjectImpl createImpl() {
            return new BusinessObjectImpl();
        }

    }

}
