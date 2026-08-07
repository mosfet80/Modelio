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
package org.modelio.archimate.diagrams.elements.grouping;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.grouping.v0._GmGrouping;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmGrouping}.
 */
@objid ("08afb08c-8675-426e-9a41-dd73a0810d58")
public class GmGroupingMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("9be2173d-1be0-4302-9ada-fa05806c3625")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmGrouping();
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
    @objid ("b866eb55-6f53-4a7c-82ba-3e49b100f6a4")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmGrouping) instanceToMigrate);
        }
        return null;
    }

    @objid ("69575c08-8470-4097-b33d-bcda8530525c")
    private IPersistent migrateFromV0(final _GmGrouping oldGrouping) {
        GmGrouping newGrouping = new GmGrouping(oldGrouping);

        newGrouping.setLayoutData(oldGrouping.getLayoutData());

        newGrouping.setRoleInComposition(oldGrouping.getRoleInComposition());

        GmGroupingPrimaryNode newPrimaryNode = (GmGroupingPrimaryNode) newGrouping.getMainNode();
        for (IGmLink link : oldGrouping.getStartingLinks()) {
            oldGrouping.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldGrouping.getEndingLinks()) {
            oldGrouping.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newGrouping.getPersistedStyle().setCascadedStyle(oldGrouping.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldGrouping.getPersistedStyle().getLocalKeys()) {
            newGrouping.getDisplayedStyle().setProperty(key, oldGrouping.getDisplayedStyle().getProperty(key));
        }

        oldGrouping.delete();
        return newGrouping;
    }

}
