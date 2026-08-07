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
package org.modelio.archimate.diagrams.elements.gap;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.gap.v0._GmGap;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmGap}.
 */
@objid ("15d8826e-a647-4fc2-ac52-f94e6e589b64")
public class GmGapMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("ea2f74fc-6d12-455f-a348-8949b31222e6")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmGap();
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
    @objid ("d382111a-91d9-4cf9-a351-4755238c9f58")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmGap) instanceToMigrate);
        }
        return null;
    }

    @objid ("be94eb1a-aeb0-4c84-b067-87ab713eaf03")
    private IPersistent migrateFromV0(final _GmGap oldGap) {
        GmGap newGap = new GmGap(oldGap);

        newGap.setLayoutData(oldGap.getLayoutData());

        newGap.setRoleInComposition(oldGap.getRoleInComposition());

        GmGapPrimaryNode newPrimaryNode = (GmGapPrimaryNode) newGap.getMainNode();
        for (IGmLink link : oldGap.getStartingLinks()) {
            oldGap.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldGap.getEndingLinks()) {
            oldGap.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newGap.getPersistedStyle().setCascadedStyle(oldGap.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldGap.getPersistedStyle().getLocalKeys()) {
            newGap.getDisplayedStyle().setProperty(key, oldGap.getDisplayedStyle().getProperty(key));
        }

        oldGap.delete();
        return newGap;
    }

}
