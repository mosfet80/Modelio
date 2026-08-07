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
package org.modelio.archimate.diagrams.elements.facility;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.facility.v0._GmFacility;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmFacility}.
 */
@objid ("4586fc3e-cf6e-4c24-8aef-e9a4bfea725b")
public class GmFacilityMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("a8e98fd4-2d34-4453-8a84-d3505bef4c96")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmFacility();
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
    @objid ("9e6dc8cc-63eb-47c3-a78e-5ac030089279")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmFacility) instanceToMigrate);
        }
        return null;
    }

    @objid ("2f21c197-2184-40d5-b3fe-f46eb3ac379c")
    private IPersistent migrateFromV0(final _GmFacility oldFacility) {
        GmFacility newFacility = new GmFacility(oldFacility);

        newFacility.setLayoutData(oldFacility.getLayoutData());

        newFacility.setRoleInComposition(oldFacility.getRoleInComposition());

        GmFacilityPrimaryNode newPrimaryNode = (GmFacilityPrimaryNode) newFacility.getMainNode();
        for (IGmLink link : oldFacility.getStartingLinks()) {
            oldFacility.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldFacility.getEndingLinks()) {
            oldFacility.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newFacility.getPersistedStyle().setCascadedStyle(oldFacility.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldFacility.getPersistedStyle().getLocalKeys()) {
            newFacility.getDisplayedStyle().setProperty(key, oldFacility.getDisplayedStyle().getProperty(key));
        }

        oldFacility.delete();
        return newFacility;
    }

}
