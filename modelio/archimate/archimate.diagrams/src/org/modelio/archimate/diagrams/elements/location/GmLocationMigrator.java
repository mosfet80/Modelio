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
package org.modelio.archimate.diagrams.elements.location;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.location.v0._GmLocation;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmLocation}.
 */
@objid ("68547a30-fc80-4bd6-96ca-44ecb6550e82")
public class GmLocationMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("5a0b1dec-918d-41af-9db0-67f164b2eb4c")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmLocation();
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
    @objid ("4642ca0e-1e11-4117-ae75-c6a8cd87362c")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmLocation) instanceToMigrate);
        }
        return null;
    }

    @objid ("0f8c8ac5-ca7b-46dd-b2df-2e7d705f6065")
    private IPersistent migrateFromV0(final _GmLocation oldLocation) {
        GmLocation newLocation = new GmLocation(oldLocation);

        newLocation.setLayoutData(oldLocation.getLayoutData());

        newLocation.setRoleInComposition(oldLocation.getRoleInComposition());

        GmLocationPrimaryNode newPrimaryNode = (GmLocationPrimaryNode) newLocation.getMainNode();
        for (IGmLink link : oldLocation.getStartingLinks()) {
            oldLocation.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldLocation.getEndingLinks()) {
            oldLocation.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newLocation.getPersistedStyle().setCascadedStyle(oldLocation.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldLocation.getPersistedStyle().getLocalKeys()) {
            newLocation.getDisplayedStyle().setProperty(key, oldLocation.getDisplayedStyle().getProperty(key));
        }

        oldLocation.delete();
        return newLocation;
    }

}
