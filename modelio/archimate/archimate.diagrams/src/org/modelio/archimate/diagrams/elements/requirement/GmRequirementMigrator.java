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
package org.modelio.archimate.diagrams.elements.requirement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.requirement.v0._GmRequirement;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmRequirement}.
 */
@objid ("df0a462f-089a-4a3f-aec7-2501c029ca1b")
public class GmRequirementMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("50cf66d2-128a-498f-8ee6-e49620c001d5")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmRequirement();
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
    @objid ("977b17a6-d027-44ac-984b-cad575aef131")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmRequirement) instanceToMigrate);
        }
        return null;
    }

    @objid ("a718088a-2553-465c-8c79-21b68db340e4")
    private IPersistent migrateFromV0(final _GmRequirement oldRequirement) {
        GmRequirement newRequirement = new GmRequirement(oldRequirement);

        newRequirement.setLayoutData(oldRequirement.getLayoutData());

        newRequirement.setRoleInComposition(oldRequirement.getRoleInComposition());

        GmRequirementPrimaryNode newPrimaryNode = (GmRequirementPrimaryNode) newRequirement.getMainNode();
        for (IGmLink link : oldRequirement.getStartingLinks()) {
            oldRequirement.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldRequirement.getEndingLinks()) {
            oldRequirement.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newRequirement.getPersistedStyle().setCascadedStyle(oldRequirement.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldRequirement.getPersistedStyle().getLocalKeys()) {
            newRequirement.getDisplayedStyle().setProperty(key, oldRequirement.getDisplayedStyle().getProperty(key));
        }

        oldRequirement.delete();
        return newRequirement;
    }

}
