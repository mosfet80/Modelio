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
package org.modelio.archimate.diagrams.elements.device;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.device.v0._GmDevice;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmDevice}.
 */
@objid ("d195c3bf-9647-4fd9-a6fe-faacae90b51c")
public class GmDeviceMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("355e8552-5f5b-41e9-aee2-5993b886ef0a")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmDevice();
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
    @objid ("7c9ced95-0fc3-40dc-8067-5206371116ba")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmDevice) instanceToMigrate);
        }
        return null;
    }

    @objid ("cc2b26de-eba3-46cc-b59e-e51cae839b00")
    private IPersistent migrateFromV0(final _GmDevice oldDevice) {
        GmDevice newDevice = new GmDevice(oldDevice);

        newDevice.setLayoutData(oldDevice.getLayoutData());

        newDevice.setRoleInComposition(oldDevice.getRoleInComposition());

        GmDevicePrimaryNode newPrimaryNode = (GmDevicePrimaryNode) newDevice.getMainNode();
        for (IGmLink link : oldDevice.getStartingLinks()) {
            oldDevice.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldDevice.getEndingLinks()) {
            oldDevice.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newDevice.getPersistedStyle().setCascadedStyle(oldDevice.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldDevice.getPersistedStyle().getLocalKeys()) {
            newDevice.getDisplayedStyle().setProperty(key, oldDevice.getDisplayedStyle().getProperty(key));
        }

        oldDevice.delete();
        return newDevice;
    }

}
