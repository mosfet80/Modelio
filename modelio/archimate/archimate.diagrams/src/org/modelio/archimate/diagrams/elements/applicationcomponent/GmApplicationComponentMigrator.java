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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationcomponent.v0._GmApplicationComponent;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmApplicationComponent}.
 */
@objid ("065ee645-7bab-427b-b9b1-309eea788d3a")
public class GmApplicationComponentMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("05567e9b-f057-41be-9bdb-61263712fa00")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmApplicationComponent();
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
    @objid ("92daa45c-48dd-42ca-b470-51ffb741c205")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmApplicationComponent) instanceToMigrate);
        }
        return null;
    }

    @objid ("c3f5e19d-957a-44c8-adc7-c07eb907e3f9")
    private IPersistent migrateFromV0(final _GmApplicationComponent oldApplicationComponent) {
        GmApplicationComponent newApplicationComponent = new GmApplicationComponent(oldApplicationComponent);

        newApplicationComponent.setLayoutData(oldApplicationComponent.getLayoutData());

        newApplicationComponent.setRoleInComposition(oldApplicationComponent.getRoleInComposition());

        GmApplicationComponentPrimaryNode newPrimaryNode = (GmApplicationComponentPrimaryNode) newApplicationComponent.getMainNode();
        for (IGmLink link : oldApplicationComponent.getStartingLinks()) {
            oldApplicationComponent.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldApplicationComponent.getEndingLinks()) {
            oldApplicationComponent.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newApplicationComponent.getPersistedStyle().setCascadedStyle(oldApplicationComponent.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldApplicationComponent.getPersistedStyle().getLocalKeys()) {
            newApplicationComponent.getDisplayedStyle().setProperty(key, oldApplicationComponent.getDisplayedStyle().getProperty(key));
        }

        oldApplicationComponent.delete();
        return newApplicationComponent;
    }

}
