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
package org.modelio.archimate.diagrams.elements.applicationevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationevent.v0._GmApplicationEvent;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmApplicationEvent}.
 */
@objid ("0a5bcac2-a684-49a2-80c1-58a73b08ca43")
public class GmApplicationEventMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("fe3c13e9-b947-4b36-9771-fe92b738a2a3")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmApplicationEvent();
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
    @objid ("2470e807-dfba-4c4e-88c4-805f04021a20")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmApplicationEvent) instanceToMigrate);
        }
        return null;
    }

    @objid ("729b10a9-5447-4164-ac3d-3408c9969986")
    private IPersistent migrateFromV0(final _GmApplicationEvent oldApplicationEvent) {
        GmApplicationEvent newApplicationEvent = new GmApplicationEvent(oldApplicationEvent);

        newApplicationEvent.setLayoutData(oldApplicationEvent.getLayoutData());

        newApplicationEvent.setRoleInComposition(oldApplicationEvent.getRoleInComposition());

        GmApplicationEventPrimaryNode newPrimaryNode = (GmApplicationEventPrimaryNode) newApplicationEvent.getMainNode();
        for (IGmLink link : oldApplicationEvent.getStartingLinks()) {
            oldApplicationEvent.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldApplicationEvent.getEndingLinks()) {
            oldApplicationEvent.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newApplicationEvent.getPersistedStyle().setCascadedStyle(oldApplicationEvent.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldApplicationEvent.getPersistedStyle().getLocalKeys()) {
            newApplicationEvent.getDisplayedStyle().setProperty(key, oldApplicationEvent.getDisplayedStyle().getProperty(key));
        }

        oldApplicationEvent.delete();
        return newApplicationEvent;
    }

}
