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
package org.modelio.archimate.metamodel.impl.layers.business.composite;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;
import org.modelio.archimate.metamodel.impl.core.generic.composite.CompositeElementSmClass;
import org.modelio.archimate.metamodel.layers.business.composite.Product;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("a4132053-3327-4c42-a004-8993c11d2d54")
public class ProductSmClass extends CompositeElementSmClass {
    @objid ("0d2ef308-1a18-4f9e-9bd6-7cd0b76b992f")
    public ProductSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("271e9c1f-a5f7-4c94-9645-5893c7b7d251")
    @Override
    public String getName() {
        return "Product";

    }

    @objid ("795d15c3-0b8a-44fc-9944-00e97ff7dd2e")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("ae7c6f47-2ec0-4f21-9ce0-625ffb50ea8a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Product.class;

    }

    @objid ("7349181d-0a32-4c2d-894a-b5ab8f2287a5")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("bd5f47e7-07d3-496a-9746-c03e6385d3e9")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("4afc4dbb-2cd5-4cff-8bab-706545163186")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(CompositeElement.MQNAME);
        this.registerFactory(new ProductObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("32695c69-f870-4b4e-87e1-3e23e290b5a5")
    private static class ProductObjectFactory implements ISmObjectFactory {
        @objid ("01084989-0345-49f7-8f35-67c5f9b9d67c")
        private ProductSmClass smClass;

        @objid ("132ba42c-bbe8-4fd1-971e-b4c32b6ea596")
        public ProductObjectFactory(ProductSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("55808867-a33f-4c5e-8877-e2fbcae55dc3")
        @Override
        public ISmObjectData createData() {
            return new ProductData(this.smClass);
        }

        @objid ("c5b76967-da78-412d-9f5d-199b3e6d568f")
        @Override
        public SmObjectImpl createImpl() {
            return new ProductImpl();
        }

    }

}
