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
package org.modelio.archimate.diagrams.elements.plateau;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.plateau.v0._GmPlateau;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmPlateau}.
 */
@objid ("701806d8-b2db-46bb-b522-c57f3a268442")
public class GmPlateauMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("5f10c980-13db-4184-8f19-7c1fb8237031")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmPlateau();
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
    @objid ("4a20168b-a08d-4785-8d85-6a757d779651")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmPlateau) instanceToMigrate);
        }
        return null;
    }

    @objid ("7fc43380-cffa-4934-88a5-845a66ae8c08")
    private IPersistent migrateFromV0(final _GmPlateau oldPlateau) {
        GmPlateau newPlateau = new GmPlateau(oldPlateau);

        newPlateau.setLayoutData(oldPlateau.getLayoutData());

        newPlateau.setRoleInComposition(oldPlateau.getRoleInComposition());

        GmPlateauPrimaryNode newPrimaryNode = (GmPlateauPrimaryNode) newPlateau.getMainNode();
        for (IGmLink link : oldPlateau.getStartingLinks()) {
            oldPlateau.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldPlateau.getEndingLinks()) {
            oldPlateau.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newPlateau.getPersistedStyle().setCascadedStyle(oldPlateau.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldPlateau.getPersistedStyle().getLocalKeys()) {
            newPlateau.getDisplayedStyle().setProperty(key, oldPlateau.getDisplayedStyle().getProperty(key));
        }

        oldPlateau.delete();
        return newPlateau;
    }

}
