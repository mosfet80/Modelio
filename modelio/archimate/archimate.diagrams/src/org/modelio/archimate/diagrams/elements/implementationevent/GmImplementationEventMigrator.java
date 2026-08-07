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
package org.modelio.archimate.diagrams.elements.implementationevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.implementationevent.v0._GmImplementationEvent;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmImplementationEvent}.
 */
@objid ("adc60e9d-2bed-4879-a3c5-2be5c4a64b1e")
public class GmImplementationEventMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("35a52156-a1ae-4ca7-a4c0-f4fac61519b2")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmImplementationEvent();
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
    @objid ("4e1390da-ea13-4bb5-acbc-841139a97d20")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmImplementationEvent) instanceToMigrate);
        }
        return null;
    }

    @objid ("0c14f65b-4b86-4eb9-baf3-491d700c0342")
    private IPersistent migrateFromV0(final _GmImplementationEvent oldImplementationEvent) {
        GmImplementationEvent newImplementationEvent = new GmImplementationEvent(oldImplementationEvent);

        newImplementationEvent.setLayoutData(oldImplementationEvent.getLayoutData());

        newImplementationEvent.setRoleInComposition(oldImplementationEvent.getRoleInComposition());

        GmImplementationEventPrimaryNode newPrimaryNode = (GmImplementationEventPrimaryNode) newImplementationEvent.getMainNode();
        for (IGmLink link : oldImplementationEvent.getStartingLinks()) {
            oldImplementationEvent.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldImplementationEvent.getEndingLinks()) {
            oldImplementationEvent.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newImplementationEvent.getPersistedStyle().setCascadedStyle(oldImplementationEvent.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldImplementationEvent.getPersistedStyle().getLocalKeys()) {
            newImplementationEvent.getDisplayedStyle().setProperty(key, oldImplementationEvent.getDisplayedStyle().getProperty(key));
        }

        oldImplementationEvent.delete();
        return newImplementationEvent;
    }

}
