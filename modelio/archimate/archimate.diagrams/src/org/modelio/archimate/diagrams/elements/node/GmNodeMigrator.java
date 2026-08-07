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
package org.modelio.archimate.diagrams.elements.node;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.node.v0._GmNode;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmNode}.
 */
@objid ("c6c8ed71-586f-4db4-ac7e-8bdd26bbfc6a")
public class GmNodeMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("0be19a8e-162c-4d42-8f8a-0e9068fa73ab")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmNode();
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
    @objid ("70748d2d-b2c6-48ba-aaa9-d20fed836d4c")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmNode) instanceToMigrate);
        }
        return null;
    }

    @objid ("19cbe417-0eea-475d-8d6e-60d3b699e214")
    private IPersistent migrateFromV0(final _GmNode oldNode) {
        GmNode newNode = new GmNode(oldNode);

        newNode.setLayoutData(oldNode.getLayoutData());

        newNode.setRoleInComposition(oldNode.getRoleInComposition());

        GmNodePrimaryNode newPrimaryNode = (GmNodePrimaryNode) newNode.getMainNode();
        for (IGmLink link : oldNode.getStartingLinks()) {
            oldNode.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldNode.getEndingLinks()) {
            oldNode.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newNode.getPersistedStyle().setCascadedStyle(oldNode.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldNode.getPersistedStyle().getLocalKeys()) {
            newNode.getDisplayedStyle().setProperty(key, oldNode.getDisplayedStyle().getProperty(key));
        }

        oldNode.delete();
        return newNode;
    }

}
