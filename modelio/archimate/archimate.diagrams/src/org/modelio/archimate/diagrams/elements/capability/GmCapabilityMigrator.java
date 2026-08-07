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
package org.modelio.archimate.diagrams.elements.capability;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.capability.v0._GmCapability;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmCapability}.
 */
@objid ("5ea74df5-7686-48d1-9511-8f5c1ee5ab6e")
public class GmCapabilityMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("af40ae55-c42b-4f47-a00f-332ab97c6fe2")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmCapability();
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
    @objid ("d0ab276f-10f8-403d-972c-87e39a71f7b6")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmCapability) instanceToMigrate);
        }
        return null;
    }

    @objid ("1f515158-d795-4bae-b659-02a126bd97cc")
    private IPersistent migrateFromV0(final _GmCapability oldCapability) {
        GmCapability newCapability = new GmCapability(oldCapability);

        newCapability.setLayoutData(oldCapability.getLayoutData());

        newCapability.setRoleInComposition(oldCapability.getRoleInComposition());

        GmCapabilityPrimaryNode newPrimaryNode = (GmCapabilityPrimaryNode) newCapability.getMainNode();
        for (IGmLink link : oldCapability.getStartingLinks()) {
            oldCapability.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldCapability.getEndingLinks()) {
            oldCapability.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newCapability.getPersistedStyle().setCascadedStyle(oldCapability.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldCapability.getPersistedStyle().getLocalKeys()) {
            newCapability.getDisplayedStyle().setProperty(key, oldCapability.getDisplayedStyle().getProperty(key));
        }

        oldCapability.delete();
        return newCapability;
    }

}
