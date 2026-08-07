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
package org.modelio.archimate.metamodel.impl.core.generic.composite;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;
import org.modelio.archimate.metamodel.impl.core.ElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("d25054fa-0636-4032-b8d1-52c6b84334ea")
public class CompositeElementSmClass extends ElementSmClass {
    @objid ("b7f854c9-d43e-46e4-928e-fe81b26a464d")
    public CompositeElementSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("19827df5-ae42-4989-a90f-26ca809b6909")
    @Override
    public String getName() {
        return "CompositeElement";

    }

    @objid ("06992828-55eb-4136-a25c-3c9aed143ca0")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("a5aee68e-e69a-402c-8209-933f329e115a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CompositeElement.class;

    }

    @objid ("8631356e-e54c-4813-b580-00adc419d4d7")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("a8c26693-f59d-4dde-a953-cffda92a2075")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("31184639-9ca7-46f4-94d2-ed073cc14c3c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Element.MQNAME);
        this.registerFactory(new CompositeElementObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c2f20f71-c7a1-4c3c-85b1-de53dd231607")
    private static class CompositeElementObjectFactory implements ISmObjectFactory {
        @objid ("5c728465-3278-4d81-9274-5d82bfbc0dcc")
        private CompositeElementSmClass smClass;

        @objid ("351aa492-6145-436c-8b9e-f44cd3765f88")
        public CompositeElementObjectFactory(CompositeElementSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("ca6b2fa2-c225-418a-92a0-2617c42db039")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("c6579d2a-e3b5-48ad-b152-ce80e60b3b17")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
