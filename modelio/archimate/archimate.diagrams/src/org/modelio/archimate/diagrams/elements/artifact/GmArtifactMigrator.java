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
package org.modelio.archimate.diagrams.elements.artifact;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.artifact.v0._GmArtifact;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmArtifact}.
 */
@objid ("876ca498-2c63-4299-b4d2-2ba7c7e20a4d")
public class GmArtifactMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("348c4a01-7d70-4719-acc5-145805307537")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmArtifact();
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
    @objid ("9159a950-ea60-437a-b903-e239caf628ef")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmArtifact) instanceToMigrate);
        }
        return null;
    }

    @objid ("281ff08c-fc4d-45fd-8030-819191454025")
    private IPersistent migrateFromV0(final _GmArtifact oldArtifact) {
        GmArtifact newArtifact = new GmArtifact(oldArtifact);

        newArtifact.setLayoutData(oldArtifact.getLayoutData());

        newArtifact.setRoleInComposition(oldArtifact.getRoleInComposition());

        GmArtifactPrimaryNode newPrimaryNode = (GmArtifactPrimaryNode) newArtifact.getMainNode();
        for (IGmLink link : oldArtifact.getStartingLinks()) {
            oldArtifact.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldArtifact.getEndingLinks()) {
            oldArtifact.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newArtifact.getPersistedStyle().setCascadedStyle(oldArtifact.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldArtifact.getPersistedStyle().getLocalKeys()) {
            newArtifact.getDisplayedStyle().setProperty(key, oldArtifact.getDisplayedStyle().getProperty(key));
        }

        oldArtifact.delete();
        return newArtifact;
    }

}
