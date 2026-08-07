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
package org.modelio.archimate.diagrams.elements.resource;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.resource.v0._GmResource;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmResource}.
 */
@objid ("4e3d5712-bab1-47c7-a64b-e17b7efb328c")
public class GmResourceMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("5c43efb8-deb3-49c0-a4c4-2d631193d40c")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmResource();
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
    @objid ("c8da0a8f-f1cf-436f-858a-539a7fef778d")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmResource) instanceToMigrate);
        }
        return null;
    }

    @objid ("42cc145a-be38-4181-978c-f8a6bd1469a1")
    private IPersistent migrateFromV0(final _GmResource oldResource) {
        GmResource newResource = new GmResource(oldResource);

        newResource.setLayoutData(oldResource.getLayoutData());

        newResource.setRoleInComposition(oldResource.getRoleInComposition());

        GmResourcePrimaryNode newPrimaryNode = (GmResourcePrimaryNode) newResource.getMainNode();
        for (IGmLink link : oldResource.getStartingLinks()) {
            oldResource.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldResource.getEndingLinks()) {
            oldResource.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newResource.getPersistedStyle().setCascadedStyle(oldResource.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldResource.getPersistedStyle().getLocalKeys()) {
            newResource.getDisplayedStyle().setProperty(key, oldResource.getDisplayedStyle().getProperty(key));
        }

        oldResource.delete();
        return newResource;
    }

}
