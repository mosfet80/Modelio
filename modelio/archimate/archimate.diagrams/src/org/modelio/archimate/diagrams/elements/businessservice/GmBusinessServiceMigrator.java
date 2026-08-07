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
package org.modelio.archimate.diagrams.elements.businessservice;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessservice.v0._GmBusinessService;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmBusinessService}.
 */
@objid ("a9329c0b-ebbe-49fd-bc18-000e1a87f736")
public class GmBusinessServiceMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("4fc22d0e-78ac-4d6d-ba7f-566f2fa81277")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmBusinessService();
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
    @objid ("562bb109-2058-4aaa-a360-ecefa4e86f3d")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmBusinessService) instanceToMigrate);
        }
        return null;
    }

    @objid ("aa0e44d2-a84e-4470-953c-07f64a8d822c")
    private IPersistent migrateFromV0(final _GmBusinessService oldBusinessService) {
        GmBusinessService newBusinessService = new GmBusinessService(oldBusinessService);

        newBusinessService.setLayoutData(oldBusinessService.getLayoutData());

        newBusinessService.setRoleInComposition(oldBusinessService.getRoleInComposition());

        GmBusinessServicePrimaryNode newPrimaryNode = (GmBusinessServicePrimaryNode) newBusinessService.getMainNode();
        for (IGmLink link : oldBusinessService.getStartingLinks()) {
            oldBusinessService.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldBusinessService.getEndingLinks()) {
            oldBusinessService.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newBusinessService.getPersistedStyle().setCascadedStyle(oldBusinessService.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldBusinessService.getPersistedStyle().getLocalKeys()) {
            newBusinessService.getDisplayedStyle().setProperty(key, oldBusinessService.getDisplayedStyle().getProperty(key));
        }

        oldBusinessService.delete();
        return newBusinessService;
    }

}
