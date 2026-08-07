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
package org.modelio.archimate.diagrams.elements.representation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.representation.v0._GmRepresentation;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmRepresentation}.
 */
@objid ("bfb0f9da-a344-45dc-b48f-417adc5f67cf")
public class GmRepresentationMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("2de64a10-72c2-4ebf-a7e9-eb12ccfd514e")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmRepresentation();
        }
        default: {
            return null;
        }
        }

    }

    /**
     * Returns an instance of IPersistent with the most recent major version, using as much information from the given IPersistent as possible.
     *
     * @param instanceToMigrate an instance of a previous major version to be used as source of information.
     * @return an instance of IPersistent with the most recent major version based on the given instance.
     */
    @objid ("44a6b4b3-a6ef-49c7-acc8-9d203eaf9a83")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmRepresentation) instanceToMigrate);
        }
        return null;
    }

    @objid ("2bc6f059-6425-40d0-893e-0c628d6be85e")
    private IPersistent migrateFromV0(final _GmRepresentation oldRepresentation) {
        GmRepresentation newRepresentation = new GmRepresentation(oldRepresentation);

        newRepresentation.setLayoutData(oldRepresentation.getLayoutData());

        newRepresentation.setRoleInComposition(oldRepresentation.getRoleInComposition());

        GmRepresentationPrimaryNode newPrimaryNode = (GmRepresentationPrimaryNode) newRepresentation.getMainNode();
        for (IGmLink link : oldRepresentation.getStartingLinks()) {
            oldRepresentation.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldRepresentation.getEndingLinks()) {
            oldRepresentation.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newRepresentation.getPersistedStyle().setCascadedStyle(oldRepresentation.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldRepresentation.getPersistedStyle().getLocalKeys()) {
            newRepresentation.getDisplayedStyle().setProperty(key, oldRepresentation.getDisplayedStyle().getProperty(key));
        }

        oldRepresentation.delete();
        return newRepresentation;
    }

}
