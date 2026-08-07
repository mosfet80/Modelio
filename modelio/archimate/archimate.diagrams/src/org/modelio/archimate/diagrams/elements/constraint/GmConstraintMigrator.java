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
package org.modelio.archimate.diagrams.elements.constraint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.constraint.v0._GmConstraint;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmConstraint}.
 */
@objid ("fdaa7425-bbc5-47da-ba64-755996c31061")
public class GmConstraintMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("047504ac-ffec-4159-b314-e2a0798ae5f4")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmConstraint();
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
    @objid ("67010ca9-ccc3-4425-93a0-d91f82f3e0b9")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmConstraint) instanceToMigrate);
        }
        return null;
    }

    @objid ("74764d04-c785-42a0-b164-20ac194d31ca")
    private IPersistent migrateFromV0(final _GmConstraint oldConstraint) {
        GmConstraint newConstraint = new GmConstraint(oldConstraint);

        newConstraint.setLayoutData(oldConstraint.getLayoutData());

        newConstraint.setRoleInComposition(oldConstraint.getRoleInComposition());

        GmConstraintPrimaryNode newPrimaryNode = (GmConstraintPrimaryNode) newConstraint.getMainNode();
        for (IGmLink link : oldConstraint.getStartingLinks()) {
            oldConstraint.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldConstraint.getEndingLinks()) {
            oldConstraint.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newConstraint.getPersistedStyle().setCascadedStyle(oldConstraint.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldConstraint.getPersistedStyle().getLocalKeys()) {
            newConstraint.getDisplayedStyle().setProperty(key, oldConstraint.getDisplayedStyle().getProperty(key));
        }

        oldConstraint.delete();
        return newConstraint;
    }

}
