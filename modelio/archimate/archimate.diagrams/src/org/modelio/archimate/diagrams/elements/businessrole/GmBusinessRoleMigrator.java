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
package org.modelio.archimate.diagrams.elements.businessrole;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessrole.v0._GmBusinessRole;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmBusinessRole}.
 */
@objid ("4675eaf9-ee65-4fd7-8a0f-147754b313a1")
public class GmBusinessRoleMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("d010f931-e960-496d-89e5-fd904dacfa44")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmBusinessRole();
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
    @objid ("2a4bd37c-057e-448b-8467-4fe9d9427468")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmBusinessRole) instanceToMigrate);
        }
        return null;
    }

    @objid ("79f3be00-aa2d-4aee-a36a-9874ca1890d5")
    private IPersistent migrateFromV0(final _GmBusinessRole oldBusinessRole) {
        GmBusinessRole newBusinessRole = new GmBusinessRole(oldBusinessRole);

        newBusinessRole.setLayoutData(oldBusinessRole.getLayoutData());

        newBusinessRole.setRoleInComposition(oldBusinessRole.getRoleInComposition());

        GmBusinessRolePrimaryNode newPrimaryNode = (GmBusinessRolePrimaryNode) newBusinessRole.getMainNode();
        for (IGmLink link : oldBusinessRole.getStartingLinks()) {
            oldBusinessRole.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldBusinessRole.getEndingLinks()) {
            oldBusinessRole.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newBusinessRole.getPersistedStyle().setCascadedStyle(oldBusinessRole.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldBusinessRole.getPersistedStyle().getLocalKeys()) {
            newBusinessRole.getDisplayedStyle().setProperty(key, oldBusinessRole.getDisplayedStyle().getProperty(key));
        }

        oldBusinessRole.delete();
        return newBusinessRole;
    }

}
