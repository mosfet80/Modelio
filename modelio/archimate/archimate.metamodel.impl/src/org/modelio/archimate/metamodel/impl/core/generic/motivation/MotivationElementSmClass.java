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
package org.modelio.archimate.metamodel.impl.core.generic.motivation;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;
import org.modelio.archimate.metamodel.impl.core.ElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("678de1a4-e067-42c8-9075-747ac4c66a13")
public class MotivationElementSmClass extends ElementSmClass {
    @objid ("4a3ecd91-4567-47ee-aef0-623c659aeb2e")
    public MotivationElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("bd9cd2cc-967d-4e4a-87f9-7bde4ff23894")
    @Override
    public String getName() {
        return "MotivationElement";

    }

    @objid ("b455c52f-8406-4826-98f4-55b5dbb82408")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("0ea67504-7dca-4ac0-af7c-66e43e45016e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return MotivationElement.class;

    }

    @objid ("29688b1e-9b23-49ba-ba20-b6c1bbd458ab")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("768b86a0-ec58-4fae-b23a-08538ec64aab")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("f826b3b7-bb42-42ac-b8b6-93448c6af336")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Element.MQNAME);
        this.registerFactory(new MotivationElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("eed92795-9468-43d0-9d66-35e70a822f40")
    private static class MotivationElementObjectFactory implements ISmObjectFactory {
        @objid ("e224e161-3de5-4686-bd3a-dd69fc6b4f88")
        private MotivationElementSmClass smClass;

        @objid ("f8892425-2fcc-48d8-b5ea-d0ce9ccfc2e6")
        public MotivationElementObjectFactory(MotivationElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("57b13569-75dc-4685-806c-a10950bd924d")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("f0b3f339-f64c-43eb-a934-44b892ee3771")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
