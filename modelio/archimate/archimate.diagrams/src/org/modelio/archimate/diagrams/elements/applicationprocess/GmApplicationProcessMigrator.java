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
package org.modelio.archimate.diagrams.elements.applicationprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationprocess.v0._GmApplicationProcess;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmApplicationProcess}.
 */
@objid ("42a967d8-57c3-46e7-a89a-660f8720bddb")
public class GmApplicationProcessMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("f790ddc6-fa12-45c0-893e-2cd6b1ae0735")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmApplicationProcess();
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
    @objid ("426beeef-ba15-4a83-8831-860b92cc4b2d")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmApplicationProcess) instanceToMigrate);
        }
        return null;
    }

    @objid ("76d9424b-30b6-4dd1-9521-e10438b47a11")
    private IPersistent migrateFromV0(final _GmApplicationProcess oldApplicationComponent) {
        GmApplicationProcess newApplicationComponent = new GmApplicationProcess(oldApplicationComponent);

        newApplicationComponent.setLayoutData(oldApplicationComponent.getLayoutData());

        newApplicationComponent.setRoleInComposition(oldApplicationComponent.getRoleInComposition());

        GmApplicationProcessPrimaryNode newPrimaryNode = (GmApplicationProcessPrimaryNode) newApplicationComponent.getMainNode();
        for (IGmLink link : oldApplicationComponent.getStartingLinks()) {
            oldApplicationComponent.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldApplicationComponent.getEndingLinks()) {
            oldApplicationComponent.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newApplicationComponent.getPersistedStyle().setCascadedStyle(oldApplicationComponent.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldApplicationComponent.getPersistedStyle().getLocalKeys()) {
            newApplicationComponent.getDisplayedStyle().setProperty(key, oldApplicationComponent.getDisplayedStyle().getProperty(key));
        }

        oldApplicationComponent.delete();
        return newApplicationComponent;
    }

}
