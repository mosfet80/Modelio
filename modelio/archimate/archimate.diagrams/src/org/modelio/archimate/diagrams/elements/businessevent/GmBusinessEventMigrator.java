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
package org.modelio.archimate.diagrams.elements.businessevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessevent.v0._GmBusinessEvent;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmBusinessEvent}.
 */
@objid ("7138209d-9cdc-40eb-b9b7-28cc170cc77d")
public class GmBusinessEventMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("5a6a0cb0-2a8d-4b36-874c-ddfab3ebc33f")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmBusinessEvent();
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
    @objid ("5467f200-d838-4baf-b563-5c1e59371505")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmBusinessEvent) instanceToMigrate);
        }
        return null;
    }

    @objid ("350f7009-7db5-4e02-881f-fa28e72d5210")
    private IPersistent migrateFromV0(final _GmBusinessEvent oldBusinessEvent) {
        GmBusinessEvent newBusinessEvent = new GmBusinessEvent(oldBusinessEvent);

        newBusinessEvent.setLayoutData(oldBusinessEvent.getLayoutData());

        newBusinessEvent.setRoleInComposition(oldBusinessEvent.getRoleInComposition());

        GmBusinessEventPrimaryNode newPrimaryNode = (GmBusinessEventPrimaryNode) newBusinessEvent.getMainNode();
        for (IGmLink link : oldBusinessEvent.getStartingLinks()) {
            oldBusinessEvent.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldBusinessEvent.getEndingLinks()) {
            oldBusinessEvent.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newBusinessEvent.getPersistedStyle().setCascadedStyle(oldBusinessEvent.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldBusinessEvent.getPersistedStyle().getLocalKeys()) {
            newBusinessEvent.getDisplayedStyle().setProperty(key, oldBusinessEvent.getDisplayedStyle().getProperty(key));
        }

        oldBusinessEvent.delete();
        return newBusinessEvent;
    }

}
