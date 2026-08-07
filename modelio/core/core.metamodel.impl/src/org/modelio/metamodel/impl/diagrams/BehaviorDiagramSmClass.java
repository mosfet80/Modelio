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
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.diagrams.BehaviorDiagram;
import org.modelio.metamodel.impl.diagrams.AbstractDiagramSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("3179c664-e485-47e8-aacc-ed2e277ea76b")
public class BehaviorDiagramSmClass extends AbstractDiagramSmClass {
    @objid ("ab1c7267-beb5-4420-92a2-1f9804e01cbb")
    public BehaviorDiagramSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8001cc55-611a-43aa-805a-fc8c12828ec2")
    @Override
    public String getName() {
        return "BehaviorDiagram";

    }

    @objid ("7d5ce948-5ca8-4d5f-8bab-8d9996f1f170")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f03fc428-48ae-40d6-a788-287c9b12ab6d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BehaviorDiagram.class;

    }

    @objid ("4d0795ea-41ea-42bd-b6e4-ce9b21fe8976")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("de2b4682-ff98-4a61-8e2b-fdea940edc20")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("9d627bb3-d805-4b7a-be78-59bc251b6d5e")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractDiagram.MQNAME);
        this.registerFactory(new BehaviorDiagramObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c2789e32-bd52-49cb-b045-c5095e7ca2eb")
    private static class BehaviorDiagramObjectFactory implements ISmObjectFactory {
        @objid ("295706e7-de24-4598-bcbc-4d6cb975eba4")
        private BehaviorDiagramSmClass smClass;

        @objid ("5ea1e946-231a-4888-b57a-89aff8eb72ae")
        public BehaviorDiagramObjectFactory(BehaviorDiagramSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("30268658-0f17-4eeb-9111-19ff46467192")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("ac27f0ad-d01b-4a90-9acd-100d7ddfe022")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

}
