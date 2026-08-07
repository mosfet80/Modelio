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
package org.modelio.archimate.diagrams.elements.workpackage;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.workpackage.v0._GmWorkPackage;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmWorkPackage}.
 */
@objid ("69c96b26-66a4-423d-a71f-0b383d9caeb2")
public class GmWorkPackageMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("2e407863-3cef-4522-8e8b-7f556b14590f")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmWorkPackage();
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
    @objid ("ee3f77ea-e3b4-4c51-8c06-9fee578e3baa")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmWorkPackage) instanceToMigrate);
        }
        return null;
    }

    @objid ("a2600d66-4266-4f54-ad9d-6e3b4c487f82")
    private IPersistent migrateFromV0(final _GmWorkPackage oldWorkPackage) {
        GmWorkPackage newWorkPackage = new GmWorkPackage(oldWorkPackage);

        newWorkPackage.setLayoutData(oldWorkPackage.getLayoutData());

        newWorkPackage.setRoleInComposition(oldWorkPackage.getRoleInComposition());

        GmWorkPackagePrimaryNode newPrimaryNode = (GmWorkPackagePrimaryNode) newWorkPackage.getMainNode();
        for (IGmLink link : oldWorkPackage.getStartingLinks()) {
            oldWorkPackage.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldWorkPackage.getEndingLinks()) {
            oldWorkPackage.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newWorkPackage.getPersistedStyle().setCascadedStyle(oldWorkPackage.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldWorkPackage.getPersistedStyle().getLocalKeys()) {
            newWorkPackage.getDisplayedStyle().setProperty(key, oldWorkPackage.getDisplayedStyle().getProperty(key));
        }

        oldWorkPackage.delete();
        return newWorkPackage;
    }

}
