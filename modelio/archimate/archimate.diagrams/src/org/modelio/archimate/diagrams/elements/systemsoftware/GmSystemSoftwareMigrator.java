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
package org.modelio.archimate.diagrams.elements.systemsoftware;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.systemsoftware.v0._GmSystemSoftware;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmSystemSoftware}.
 */
@objid ("e24a7528-1ffc-4106-81f6-2f1e93e33297")
public class GmSystemSoftwareMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("0f4ef4c0-ed6f-4ed8-bd1e-afa82b96c56a")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmSystemSoftware();
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
    @objid ("4f3266b8-c1b5-4229-bae1-0b0af1024e6d")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmSystemSoftware) instanceToMigrate);
        }
        return null;
    }

    @objid ("075abecb-b770-4395-8884-6c610aedbbfd")
    private IPersistent migrateFromV0(final _GmSystemSoftware oldSystemSoftware) {
        GmSystemSoftware newSystemSoftware = new GmSystemSoftware(oldSystemSoftware);

        newSystemSoftware.setLayoutData(oldSystemSoftware.getLayoutData());

        newSystemSoftware.setRoleInComposition(oldSystemSoftware.getRoleInComposition());

        GmSystemSoftwarePrimaryNode newPrimaryNode = (GmSystemSoftwarePrimaryNode) newSystemSoftware.getMainNode();
        for (IGmLink link : oldSystemSoftware.getStartingLinks()) {
            oldSystemSoftware.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldSystemSoftware.getEndingLinks()) {
            oldSystemSoftware.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newSystemSoftware.getPersistedStyle().setCascadedStyle(oldSystemSoftware.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldSystemSoftware.getPersistedStyle().getLocalKeys()) {
            newSystemSoftware.getDisplayedStyle().setProperty(key, oldSystemSoftware.getDisplayedStyle().getProperty(key));
        }

        oldSystemSoftware.delete();
        return newSystemSoftware;
    }

}
