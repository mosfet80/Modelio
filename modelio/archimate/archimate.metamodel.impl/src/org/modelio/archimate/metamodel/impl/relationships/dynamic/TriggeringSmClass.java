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
package org.modelio.archimate.metamodel.impl.relationships.dynamic;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.dynamic.DynamicRelationship;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("dcce106b-ce7b-4834-ae11-cfb7747a5aae")
public class TriggeringSmClass extends DynamicRelationshipSmClass {
    @objid ("a90d01c9-3045-4677-967d-c8967647e748")
    public TriggeringSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("776861f9-397e-4170-a05f-0bbfe5f39ff0")
    @Override
    public String getName() {
        return "Triggering";

    }

    @objid ("9dd8b51c-36c9-40a7-88e4-223b7b04ee77")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("275e2614-864f-468e-932b-0159f43ae9b4")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Triggering.class;

    }

    @objid ("378879a4-cb85-4523-8fba-ce2c67ee8ea8")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("06c3f959-541b-4223-96af-5b390f4e5c54")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9cb38fb2-9f1b-46cc-ae36-64a2f4dda042")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(DynamicRelationship.MQNAME);
        this.registerFactory(new TriggeringObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("c9889b25-3465-4beb-a755-dabcfd7718c6")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("8574eee5-c560-470a-b42d-27d8424a2e78")
    private static class TriggeringObjectFactory implements ISmObjectFactory {
        @objid ("0860235c-329a-4436-896f-58cecddfd252")
        private TriggeringSmClass smClass;

        @objid ("1e599619-ccad-43db-900b-f26150ad50fd")
        public TriggeringObjectFactory(TriggeringSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("73ed7190-f6e6-4e63-aa8f-b3896341b069")
        @Override
        public ISmObjectData createData() {
            return new TriggeringData(this.smClass);
        }

        @objid ("c888b55e-b78e-4064-b5a4-805b4d0141d9")
        @Override
        public SmObjectImpl createImpl() {
            return new TriggeringImpl();
        }

    }

}
