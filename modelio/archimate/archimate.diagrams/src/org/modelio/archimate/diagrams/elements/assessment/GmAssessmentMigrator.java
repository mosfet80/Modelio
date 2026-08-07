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
package org.modelio.archimate.diagrams.elements.assessment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.assessment.v0._GmAssessment;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmAssessment}.
 */
@objid ("a28f3029-6d59-4b33-ab94-3d8842ce0221")
public class GmAssessmentMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("eaf71925-e975-4100-a5a5-aef2e74036cc")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmAssessment();
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
    @objid ("034ad266-58e5-4856-a2dd-ac046f49c335")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmAssessment) instanceToMigrate);
        }
        return null;
    }

    @objid ("6edf8e69-94c3-4210-abb9-37c983429240")
    private IPersistent migrateFromV0(final _GmAssessment oldAssessment) {
        GmAssessment newAssessment = new GmAssessment(oldAssessment);

        newAssessment.setLayoutData(oldAssessment.getLayoutData());

        newAssessment.setRoleInComposition(oldAssessment.getRoleInComposition());

        GmAssessmentPrimaryNode newPrimaryNode = (GmAssessmentPrimaryNode) newAssessment.getMainNode();
        for (IGmLink link : oldAssessment.getStartingLinks()) {
            oldAssessment.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldAssessment.getEndingLinks()) {
            oldAssessment.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newAssessment.getPersistedStyle().setCascadedStyle(oldAssessment.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldAssessment.getPersistedStyle().getLocalKeys()) {
            newAssessment.getDisplayedStyle().setProperty(key, oldAssessment.getDisplayedStyle().getProperty(key));
        }

        oldAssessment.delete();
        return newAssessment;
    }

}
