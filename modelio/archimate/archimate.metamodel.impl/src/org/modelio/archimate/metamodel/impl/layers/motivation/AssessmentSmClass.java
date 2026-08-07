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
import org.modelio.archimate.metamodel.layers.motivation.Assessment;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("bbedeed1-9d68-4858-a6b6-b2200104c769")
public class AssessmentSmClass extends MotivationElementSmClass {
    @objid ("cc15d926-aa7b-4eec-a0cc-2bd1e067861f")
    public AssessmentSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0e18271b-818c-4c0b-bd5b-9aaf3f7bf026")
    @Override
    public String getName() {
        return "Assessment";

    }

    @objid ("eecb6ce1-209f-4dd6-bac5-350b28bd112b")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("42bb743c-7c51-47ed-82ad-25785d93c00b")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Assessment.class;

    }

    @objid ("ec9f1e9b-3fa3-419a-a755-14fa48e57f3e")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("29f3a42e-f25d-4d65-aa68-92308b6e00c0")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ee2982ce-29e3-4455-96c4-139323369035")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MotivationElement.MQNAME);
        this.registerFactory(new AssessmentObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("0f74c23c-f246-4d28-a0aa-48ec013ca0d9")
    private static class AssessmentObjectFactory implements ISmObjectFactory {
        @objid ("65fff9a5-2b6c-4340-aa7d-338051c24811")
        private AssessmentSmClass smClass;

        @objid ("ce4d150d-8e8c-4274-be24-c520ca140e88")
        public AssessmentObjectFactory(AssessmentSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("aec12ef3-8a13-4b4f-a9eb-ae833084195c")
        @Override
        public ISmObjectData createData() {
            return new AssessmentData(this.smClass);
        }

        @objid ("7bd50ddb-220d-4724-9a6b-daea5b736301")
        @Override
        public SmObjectImpl createImpl() {
            return new AssessmentImpl();
        }

    }

}
