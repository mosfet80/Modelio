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
package org.modelio.archimate.diagrams.elements.driver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.driver.v0._GmDriver;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmDriver}.
 */
@objid ("3bec8c58-bf95-4314-b5ba-821b7ae6d388")
public class GmDriverMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("ea891a80-a6d6-4120-ae37-036b0a48b2aa")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmDriver();
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
    @objid ("7d66337a-54e1-451e-b3fb-ce24c5ace5ec")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmDriver) instanceToMigrate);
        }
        return null;
    }

    @objid ("de866677-443c-442e-b05b-96f9032c0e22")
    private IPersistent migrateFromV0(final _GmDriver oldDriver) {
        GmDriver newDriver = new GmDriver(oldDriver);

        newDriver.setLayoutData(oldDriver.getLayoutData());

        newDriver.setRoleInComposition(oldDriver.getRoleInComposition());

        GmDriverPrimaryNode newPrimaryNode = (GmDriverPrimaryNode) newDriver.getMainNode();
        for (IGmLink link : oldDriver.getStartingLinks()) {
            oldDriver.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldDriver.getEndingLinks()) {
            oldDriver.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newDriver.getPersistedStyle().setCascadedStyle(oldDriver.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldDriver.getPersistedStyle().getLocalKeys()) {
            newDriver.getDisplayedStyle().setProperty(key, oldDriver.getDisplayedStyle().getProperty(key));
        }

        oldDriver.delete();
        return newDriver;
    }

}
