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
package org.modelio.archimate.diagrams.elements.technologyservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.technologyservice.v0._GmTechnologyService;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmTechnologyService}.
 */
@objid ("db1e8978-6794-46c1-9b00-a32f7fcb302c")
public class GmTechnologyServiceMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("3175d7c5-ce00-4cd3-9ce5-6458fe1e6b3d")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmTechnologyService();
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
    @objid ("f11bb4b3-d6c8-4893-9c07-b6972f6ebcb7")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmTechnologyService) instanceToMigrate);
        }
        return null;
    }

    @objid ("7f2fc23d-5ad2-49a2-a24b-45efbf4d753f")
    private IPersistent migrateFromV0(final _GmTechnologyService oldTechnologyService) {
        GmTechnologyService newTechnologyService = new GmTechnologyService(oldTechnologyService);

        newTechnologyService.setLayoutData(oldTechnologyService.getLayoutData());

        newTechnologyService.setRoleInComposition(oldTechnologyService.getRoleInComposition());

        GmTechnologyServicePrimaryNode newPrimaryNode = (GmTechnologyServicePrimaryNode) newTechnologyService.getMainNode();
        for (IGmLink link : oldTechnologyService.getStartingLinks()) {
            oldTechnologyService.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldTechnologyService.getEndingLinks()) {
            oldTechnologyService.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newTechnologyService.getPersistedStyle().setCascadedStyle(oldTechnologyService.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldTechnologyService.getPersistedStyle().getLocalKeys()) {
            newTechnologyService.getDisplayedStyle().setProperty(key, oldTechnologyService.getDisplayedStyle().getProperty(key));
        }

        oldTechnologyService.delete();
        return newTechnologyService;
    }

}
