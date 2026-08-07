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
package org.modelio.archimate.diagrams.elements.outcome;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.outcome.v0._GmOutcome;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmOutcome}.
 */
@objid ("d5ec9960-1f69-4fcd-835b-2d508f60d245")
public class GmOutcomeMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("3005ca48-0247-43a5-bbd0-ee6eaa055eb8")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmOutcome();
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
    @objid ("d24fb8a0-b45f-4da7-ac26-aa1ed5d0df80")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmOutcome) instanceToMigrate);
        }
        return null;
    }

    @objid ("81603755-1597-4789-9e48-e0e56e81740e")
    private IPersistent migrateFromV0(final _GmOutcome oldOutcome) {
        GmOutcome newOutcome = new GmOutcome(oldOutcome);

        newOutcome.setLayoutData(oldOutcome.getLayoutData());

        newOutcome.setRoleInComposition(oldOutcome.getRoleInComposition());

        GmOutcomePrimaryNode newPrimaryNode = (GmOutcomePrimaryNode) newOutcome.getMainNode();
        for (IGmLink link : oldOutcome.getStartingLinks()) {
            oldOutcome.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldOutcome.getEndingLinks()) {
            oldOutcome.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newOutcome.getPersistedStyle().setCascadedStyle(oldOutcome.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldOutcome.getPersistedStyle().getLocalKeys()) {
            newOutcome.getDisplayedStyle().setProperty(key, oldOutcome.getDisplayedStyle().getProperty(key));
        }

        oldOutcome.delete();
        return newOutcome;
    }

}
