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
package org.modelio.archimate.metamodel.impl.layers.technology.structure.active;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyCollaboration;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInternalActiveStructureElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("002932a7-c824-44b2-94f2-9ec7b31b0357")
public class TechnologyCollaborationSmClass extends TechnologyInternalActiveStructureElementSmClass {
    @objid ("2ff61abe-392c-449c-a917-f46ae1d3a128")
    public TechnologyCollaborationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("2c8e6889-2351-42e5-a5de-493a1e180811")
    @Override
    public String getName() {
        return "TechnologyCollaboration";

    }

    @objid ("d1bfe92f-f6af-43e5-90bd-a40081be81ec")
    @Override
    public Version getVersion() {
        return new Version("0.0.0");
    }

    @objid ("19a738b8-cfa1-4cb7-b6ca-cee6ac0ed77d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return TechnologyCollaboration.class;

    }

    @objid ("6525d8d5-46d2-45f0-989e-13a2381e6a1a")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("c8ec7f4e-debc-440c-879e-f1ccb845c0eb")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("67cee9fc-aebe-4352-a2ca-b7827489e886")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(TechnologyInternalActiveStructureElement.MQNAME);
        this.registerFactory(new TechnologyCollaborationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency

    }

    @objid ("db874f9b-d140-4505-a71e-be53184fadf8")
    private static class TechnologyCollaborationObjectFactory implements ISmObjectFactory {
        @objid ("144ad3d8-abe3-4764-a320-bac70667e75a")
        private TechnologyCollaborationSmClass smClass;

        @objid ("01fa8c74-59bd-4254-b20e-8dc4b08a05fc")
        public TechnologyCollaborationObjectFactory(TechnologyCollaborationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("529d5d2f-0f49-4eff-b4ce-a87ecca01f7f")
        @Override
        public ISmObjectData createData() {
            return new TechnologyCollaborationData(this.smClass);
        }

        @objid ("8d7b9c2c-2984-449c-be96-59a4f8c3ec18")
        @Override
        public SmObjectImpl createImpl() {
            return new TechnologyCollaborationImpl();
        }

    }

}
