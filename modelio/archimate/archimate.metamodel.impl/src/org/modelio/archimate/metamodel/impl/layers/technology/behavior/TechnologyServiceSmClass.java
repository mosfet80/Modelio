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
package org.modelio.archimate.metamodel.impl.layers.technology.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("0ac40698-b3ce-492f-b700-29a413881160")
public class TechnologyServiceSmClass extends ExternalBehaviorElementSmClass {
    @objid ("4e25604b-8053-45f1-b704-f8eec84c326f")
    public TechnologyServiceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("df2bdc15-2ca0-41d9-86e5-9325201c683b")
    @Override
    public String getName() {
        return "TechnologyService";

    }

    @objid ("69a6da8e-dd61-4c5c-a920-ac7278d464ae")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("c7728b23-b5d5-4aec-8a39-fefcdce6a565")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyService.class;

    }

    @objid ("b06ad301-17d2-41c3-8a43-48f01cc3510f")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("1fdae67c-e436-46fa-aef5-226633fc17ba")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("1b7fadc7-0359-48c6-b71a-542e4d77fc67")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ExternalBehaviorElement.MQNAME);
        this.registerFactory(new TechnologyServiceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("15a932e1-56ab-4053-9758-1d30016ab50b")
    private static class TechnologyServiceObjectFactory implements ISmObjectFactory {
        @objid ("855041b9-1490-43c0-aedc-37cf1457c014")
        private TechnologyServiceSmClass smClass;

        @objid ("6abb5a36-1a94-4b0e-8744-748c0b6ad653")
        public TechnologyServiceObjectFactory(TechnologyServiceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b189adf6-14c1-4b3f-a9d8-a9aa8e24f491")
        @Override
        public ISmObjectData createData() {
            return new TechnologyServiceData(this.smClass);
        }

        @objid ("136010d4-7243-443d-b4cf-7aec06f4922c")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyServiceImpl();
        }

    }

}
