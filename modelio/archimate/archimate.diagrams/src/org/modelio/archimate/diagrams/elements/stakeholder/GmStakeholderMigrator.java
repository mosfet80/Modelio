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
package org.modelio.archimate.diagrams.elements.stakeholder;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.stakeholder.v0._GmStakeholder;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmStakeholder}.
 */
@objid ("cabb581c-2711-427d-8464-e5cd8703cf6f")
public class GmStakeholderMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("e1b141a9-9fa1-49c7-b65d-415bb6b94370")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmStakeholder();
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
    @objid ("3f36f154-6129-4fc2-a4d2-190cac7b6997")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmStakeholder) instanceToMigrate);
        }
        return null;
    }

    @objid ("ed486e4b-3d81-4193-9c0f-c2fcee226b5e")
    private IPersistent migrateFromV0(final _GmStakeholder oldStakeholder) {
        GmStakeholder newStakeholder = new GmStakeholder(oldStakeholder);

        newStakeholder.setLayoutData(oldStakeholder.getLayoutData());

        newStakeholder.setRoleInComposition(oldStakeholder.getRoleInComposition());

        GmStakeholderPrimaryNode newPrimaryNode = (GmStakeholderPrimaryNode) newStakeholder.getMainNode();
        for (IGmLink link : oldStakeholder.getStartingLinks()) {
            oldStakeholder.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldStakeholder.getEndingLinks()) {
            oldStakeholder.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newStakeholder.getPersistedStyle().setCascadedStyle(oldStakeholder.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldStakeholder.getPersistedStyle().getLocalKeys()) {
            newStakeholder.getDisplayedStyle().setProperty(key, oldStakeholder.getDisplayedStyle().getProperty(key));
        }

        oldStakeholder.delete();
        return newStakeholder;
    }

}
