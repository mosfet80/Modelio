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
package org.modelio.archimate.diagrams.elements.technologyprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.technologyprocess.v0._GmTechnologyProcess;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmTechnologyProcess}.
 */
@objid ("b437244a-99a4-4c55-9412-3e7f112cf432")
public class GmTechnologyProcessMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("ef417251-bd72-4f92-a7ae-fa5a673d6589")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmTechnologyProcess();
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
    @objid ("19dbe14c-fab0-4aa8-875d-55005cb96a50")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmTechnologyProcess) instanceToMigrate);
        }
        return null;
    }

    @objid ("3373e133-c010-476e-821a-2f0f46665f8c")
    private IPersistent migrateFromV0(final _GmTechnologyProcess oldTechnologyProcess) {
        GmTechnologyProcess newTechnologyProcess = new GmTechnologyProcess(oldTechnologyProcess);

        newTechnologyProcess.setLayoutData(oldTechnologyProcess.getLayoutData());

        newTechnologyProcess.setRoleInComposition(oldTechnologyProcess.getRoleInComposition());

        GmTechnologyProcessPrimaryNode newPrimaryNode = (GmTechnologyProcessPrimaryNode) newTechnologyProcess.getMainNode();
        for (IGmLink link : oldTechnologyProcess.getStartingLinks()) {
            oldTechnologyProcess.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldTechnologyProcess.getEndingLinks()) {
            oldTechnologyProcess.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newTechnologyProcess.getPersistedStyle().setCascadedStyle(oldTechnologyProcess.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldTechnologyProcess.getPersistedStyle().getLocalKeys()) {
            newTechnologyProcess.getDisplayedStyle().setProperty(key, oldTechnologyProcess.getDisplayedStyle().getProperty(key));
        }

        oldTechnologyProcess.delete();
        return newTechnologyProcess;
    }

}
