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
package org.modelio.archimate.diagrams.elements.meaning;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.meaning.v0._GmMeaning;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmMeaning}.
 */
@objid ("bce59c90-0a7c-4d9a-a5ad-bee1edea6200")
public class GmMeaningMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("7b23e95c-fbfc-4a45-b24f-d82218d18a45")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmMeaning();
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
    @objid ("565d7601-6106-4048-9350-5aedeea5ba3a")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmMeaning) instanceToMigrate);
        }
        return null;
    }

    @objid ("e0d54943-6cf0-4c97-b0a6-6fd2a9b2464a")
    private IPersistent migrateFromV0(final _GmMeaning oldMeaning) {
        GmMeaning newMeaning = new GmMeaning(oldMeaning);

        newMeaning.setLayoutData(oldMeaning.getLayoutData());

        newMeaning.setRoleInComposition(oldMeaning.getRoleInComposition());

        GmMeaningPrimaryNode newPrimaryNode = (GmMeaningPrimaryNode) newMeaning.getMainNode();
        for (IGmLink link : oldMeaning.getStartingLinks()) {
            oldMeaning.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldMeaning.getEndingLinks()) {
            oldMeaning.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newMeaning.getPersistedStyle().setCascadedStyle(oldMeaning.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldMeaning.getPersistedStyle().getLocalKeys()) {
            newMeaning.getDisplayedStyle().setProperty(key, oldMeaning.getDisplayedStyle().getProperty(key));
        }

        oldMeaning.delete();
        return newMeaning;
    }

}
