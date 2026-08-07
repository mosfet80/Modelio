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
package org.modelio.archimate.metamodel.impl.layers.technology.structure.passive;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.TechnologyObject;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("12ad0abb-760a-45ca-b0c3-4f7cdfad2f61")
public class ArtifactSmClass extends TechnologyObjectSmClass {
    @objid ("94ed6e4d-974d-4c01-a529-1444810b14bc")
    public ArtifactSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("a443adc9-f1a9-4cec-83a0-a5fce542c3ad")
    @Override
    public String getName() {
        return "Artifact";

    }

    @objid ("90bf77a2-6baf-415a-8512-fc4765cd4eb3")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("36e9b5c5-5a3b-4380-80c3-479656b92f18")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Artifact.class;

    }

    @objid ("6f67cb28-242c-4acf-9918-28f454b0a8d1")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("15a3636e-f838-4148-bada-010befd9cc17")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("4a4bc26d-d9d4-4766-aa65-27d5a9756a7a")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyObject.MQNAME);
        this.registerFactory(new ArtifactObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("61bca241-5e5a-4d18-bcaf-7f1fb7b16ef6")
    private static class ArtifactObjectFactory implements ISmObjectFactory {
        @objid ("0f3c0d37-8513-4e0a-9eaf-d898f2b3b611")
        private ArtifactSmClass smClass;

        @objid ("13e178e1-3c50-4803-b223-9e3299a11b08")
        public ArtifactObjectFactory(ArtifactSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e1c4deec-f3f9-4fc5-92e6-a4b6ce4e65fa")
        @Override
        public ISmObjectData createData() {
            return new ArtifactData(this.smClass);
        }

        @objid ("b1ab39fa-9b68-4a5c-9c4e-3619af4c6692")
        @Override
        public SmObjectImpl createImpl() {
            return new ArtifactImpl();
        }

    }

}
