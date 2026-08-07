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
package org.modelio.archimate.metamodel.impl.layers.motivation;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;
import org.modelio.archimate.metamodel.impl.core.generic.motivation.MotivationElementSmClass;
import org.modelio.archimate.metamodel.layers.motivation.Value;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c77da07d-deb6-481a-a06c-025a4961cc8b")
public class ValueSmClass extends MotivationElementSmClass {
    @objid ("e3ddab5c-b0d2-4ff4-bd12-cdc095d16f0c")
    public ValueSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("374cec83-de28-4c58-97e8-c413a485f74c")
    @Override
    public String getName() {
        return "Value";

    }

    @objid ("92f487af-08ff-4beb-bf6b-0aa58e52c584")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("2f6fcc00-1d76-4931-9584-a49848477160")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Value.class;

    }

    @objid ("8300575e-099c-491c-a214-99cbd9db10e3")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("6346a6d0-e434-4665-a50d-95762a6cc912")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e38b08ae-cbd4-49fa-9e23-01efe8f4e21e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new ValueObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("a61b9dab-381a-4f7a-855f-710281413fc0")
    private static class ValueObjectFactory implements ISmObjectFactory {
        @objid ("62ba773c-eddc-4865-bbd6-f0f24c57868a")
        private ValueSmClass smClass;

        @objid ("becc2cee-b891-4960-8edb-22d2ab6227f5")
        public ValueObjectFactory(ValueSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a254b19d-4f89-4c2c-a53b-e2da74b3aad1")
        @Override
        public ISmObjectData createData() {
            return new ValueData(this.smClass);
        }

        @objid ("9223c610-1566-4fd3-9cf1-99df414fab07")
        @Override
        public SmObjectImpl createImpl() {
            return new ValueImpl();
        }

    }

}
