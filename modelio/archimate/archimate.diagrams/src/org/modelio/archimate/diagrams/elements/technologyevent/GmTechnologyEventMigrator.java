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
package org.modelio.archimate.diagrams.elements.technologyevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.technologyevent.v0._GmTechnologyEvent;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmTechnologyEvent}.
 */
@objid ("e122b687-53dc-4af4-8e9a-53fa4858eb3f")
public class GmTechnologyEventMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("fa7faf69-edd8-4274-b184-95b464f4589b")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmTechnologyEvent();
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
    @objid ("d9c22820-1227-4635-a06a-d02ea22c8900")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmTechnologyEvent) instanceToMigrate);
        }
        return null;
    }

    @objid ("7812fa94-b0c8-46da-b9c3-748583ef9f07")
    private IPersistent migrateFromV0(final _GmTechnologyEvent oldTechnologyEvent) {
        GmTechnologyEvent newTechnologyEvent = new GmTechnologyEvent(oldTechnologyEvent);

        newTechnologyEvent.setLayoutData(oldTechnologyEvent.getLayoutData());

        newTechnologyEvent.setRoleInComposition(oldTechnologyEvent.getRoleInComposition());

        GmTechnologyEventPrimaryNode newPrimaryNode = (GmTechnologyEventPrimaryNode) newTechnologyEvent.getMainNode();
        for (IGmLink link : oldTechnologyEvent.getStartingLinks()) {
            oldTechnologyEvent.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldTechnologyEvent.getEndingLinks()) {
            oldTechnologyEvent.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newTechnologyEvent.getPersistedStyle().setCascadedStyle(oldTechnologyEvent.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldTechnologyEvent.getPersistedStyle().getLocalKeys()) {
            newTechnologyEvent.getDisplayedStyle().setProperty(key, oldTechnologyEvent.getDisplayedStyle().getProperty(key));
        }

        oldTechnologyEvent.delete();
        return newTechnologyEvent;
    }

}
