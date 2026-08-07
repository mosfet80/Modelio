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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionOccurenceSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.TerminateSpecification;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("1015805d-ba8d-4d95-aaeb-7b62d62c50e9")
public class TerminateSpecificationSmClass extends ExecutionOccurenceSpecificationSmClass {
    @objid ("31dbbd45-1bc4-4c6e-b480-8302b71863ca")
    public TerminateSpecificationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("73d4ce29-1819-439c-ad06-65b8197fb93b")
    @Override
    public String getName() {
        return "TerminateSpecification";

    }

    @objid ("08f09096-df49-4289-a77e-685f56b4b964")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("6000026c-b339-40d5-974b-9f33d511f582")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TerminateSpecification.class;

    }

    @objid ("d8589c98-8e75-465d-b42a-5dc84bd8107b")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("18002420-7059-4c8b-835f-f31ad6d6bddb")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e498183d-9e50-4e9f-a299-5039c918b989")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ExecutionOccurenceSpecification.MQNAME);
        this.registerFactory(new TerminateSpecificationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("27ccbb0f-6986-4aef-8c5a-de837db64da7")
    private static class TerminateSpecificationObjectFactory implements ISmObjectFactory {
        @objid ("f84b3719-4813-4047-93f6-5c69b55e5001")
        private TerminateSpecificationSmClass smClass;

        @objid ("8426b0e3-0836-4520-9f82-a90aba7492dc")
        public TerminateSpecificationObjectFactory(TerminateSpecificationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("93efe125-9057-44f2-a482-bde075a35f58")
        @Override
        public ISmObjectData createData() {
            return new TerminateSpecificationData(this.smClass);
        }

        @objid ("6051e1e2-9faa-4d9a-96b3-f48bedbf3e3b")
        @Override
        public SmObjectImpl createImpl() {
            return new TerminateSpecificationImpl();
        }

    }

}
