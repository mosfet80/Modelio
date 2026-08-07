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
package org.modelio.archimate.diagrams.elements.businessprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessprocess.v0._GmBusinessProcess;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmBusinessProcess}.
 */
@objid ("8937af7d-bb95-4de6-81d1-fbc281c230ea")
public class GmBusinessProcessMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("4929615d-5528-4778-837d-a6020a9d6f93")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmBusinessProcess();
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
    @objid ("19f4df73-a1d2-49e6-bb71-97937d09c8b6")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmBusinessProcess) instanceToMigrate);
        }
        return null;
    }

    @objid ("540c4aa2-bcc5-42da-a626-83c419225842")
    private IPersistent migrateFromV0(final _GmBusinessProcess oldBusinessProcess) {
        GmBusinessProcess newBusinessProcess = new GmBusinessProcess(oldBusinessProcess);

        newBusinessProcess.setLayoutData(oldBusinessProcess.getLayoutData());

        newBusinessProcess.setRoleInComposition(oldBusinessProcess.getRoleInComposition());

        GmBusinessProcessPrimaryNode newPrimaryNode = (GmBusinessProcessPrimaryNode) newBusinessProcess.getMainNode();
        for (IGmLink link : oldBusinessProcess.getStartingLinks()) {
            oldBusinessProcess.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldBusinessProcess.getEndingLinks()) {
            oldBusinessProcess.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newBusinessProcess.getPersistedStyle().setCascadedStyle(oldBusinessProcess.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldBusinessProcess.getPersistedStyle().getLocalKeys()) {
            newBusinessProcess.getDisplayedStyle().setProperty(key, oldBusinessProcess.getDisplayedStyle().getProperty(key));
        }

        oldBusinessProcess.delete();
        return newBusinessProcess;
    }

}
