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
package org.modelio.archimate.diagrams.elements.deliverable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.deliverable.v0._GmDeliverable;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmDeliverable}.
 */
@objid ("4a471e57-18bd-490e-9549-8b4a3cb3a87b")
public class GmDeliverableMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("9dfc3d48-5fe8-4e47-a2c7-f9ab7f8fab4f")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmDeliverable();
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
    @objid ("85ac4f8d-dd2f-4831-9b23-0a07726c59b0")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmDeliverable) instanceToMigrate);
        }
        return null;
    }

    @objid ("99a320e0-75b8-433d-8b82-5b263a81ae81")
    private IPersistent migrateFromV0(final _GmDeliverable oldDeliverable) {
        GmDeliverable newDeliverable = new GmDeliverable(oldDeliverable);

        newDeliverable.setLayoutData(oldDeliverable.getLayoutData());

        newDeliverable.setRoleInComposition(oldDeliverable.getRoleInComposition());

        GmDeliverablePrimaryNode newPrimaryNode = (GmDeliverablePrimaryNode) newDeliverable.getMainNode();
        for (IGmLink link : oldDeliverable.getStartingLinks()) {
            oldDeliverable.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldDeliverable.getEndingLinks()) {
            oldDeliverable.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newDeliverable.getPersistedStyle().setCascadedStyle(oldDeliverable.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldDeliverable.getPersistedStyle().getLocalKeys()) {
            newDeliverable.getDisplayedStyle().setProperty(key, oldDeliverable.getDisplayedStyle().getProperty(key));
        }

        oldDeliverable.delete();
        return newDeliverable;
    }

}
