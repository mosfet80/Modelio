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
package org.modelio.archimate.exchange.v30.importer.factory.impl;

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

@objid ("1eebe43e-e89b-4fba-8cf2-347d9030ea9d")
public class DefaultRepresentationUtils {
    @objid ("310ed1c7-7559-4b41-83e0-940d73736495")
    private static final int STRUCTURED = 1;

    @objid ("d1f79724-48ad-4e59-a33d-e4ffb7dfb900")
    private static final int SIMPLE = 0;

    @objid ("86c89f18-31d1-435b-a963-42794052d219")
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
