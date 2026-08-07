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
package org.modelio.archimate.exchange.v31.importer.factory.impl;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;

@objid ("b877387b-bcde-42a9-aa59-b1c0c44e3d0e")
public class DefaultRepresentationUtils {
    @objid ("5078fad4-ea45-4efc-8987-35b5d0801bb4")
    private static final int STRUCTURED = 1;

    @objid ("bdf8abe8-150a-4502-8c40-9d88041fe952")
    private static final int SIMPLE = 0;

    @objid ("0bcac8d9-a997-4b93-b553-5c20b8d4ef4e")
    public static int getDefaultRepresentationModel(ArchimateAbstractElement element) {
        if (element instanceof ApplicationComponent ||
                element instanceof Artifact ||
                element instanceof Deliverable ||
                element instanceof BusinessObject ||
                element instanceof DataObject ||
                element instanceof Node ||
                element instanceof Device) {

            if (element instanceof SystemSoftware)
                return STRUCTURED;

            return SIMPLE;
        }
        return STRUCTURED;
    }

}
