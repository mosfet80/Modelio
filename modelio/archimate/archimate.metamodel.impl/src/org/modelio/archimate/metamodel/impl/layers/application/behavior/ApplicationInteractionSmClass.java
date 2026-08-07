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
package org.modelio.archimate.metamodel.impl.layers.application.behavior;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInternalBehaviorElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("b5b10959-8233-478e-95f4-7325fecc0822")
public class ApplicationInteractionSmClass extends ApplicationInternalBehaviorElementSmClass {
    @objid ("75820670-29d0-42fd-8859-e8a791aa8947")
    public ApplicationInteractionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("181aad49-354c-4f60-8183-f083ae65184c")
    @Override
    public String getName() {
        return "ApplicationInteraction";

    }

    @objid ("d5299ac9-b542-46ab-bd28-e2cb84860df3")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("a771ca94-0407-4e95-8db0-54b886f4da3e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ApplicationInteraction.class;

    }

    @objid ("ea341b4e-c43d-4eb7-af31-605b2bf0504c")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("8435872b-8dfa-4593-bf45-75b9fd61850f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6c52b935-6715-4e9a-be94-1d761c910d3c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ApplicationInternalBehaviorElement.MQNAME);
        this.registerFactory(new ApplicationInteractionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("6d223251-c0dd-4d6e-abb0-547b3db6b668")
    private static class ApplicationInteractionObjectFactory implements ISmObjectFactory {
        @objid ("de82469a-c3a4-4d83-8b78-595afab8df24")
        private ApplicationInteractionSmClass smClass;

        @objid ("2d6214a3-5f7f-4441-b3b9-e6ad7e2b972c")
        public ApplicationInteractionObjectFactory(ApplicationInteractionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("98730e76-47c5-4946-bc0f-c5054f83d706")
        @Override
        public ISmObjectData createData() {
            return new ApplicationInteractionData(this.smClass);
        }

        @objid ("4ec149f5-d6d1-4d06-8031-0f9fe7524b39")
        @Override
        public SmObjectImpl createImpl() {
            return new ApplicationInteractionImpl();
        }

    }

}
