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
package org.modelio.archimate.diagrams.elements.courseofaction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.courseofaction.v0._GmCourseOfAction;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmCourseOfAction}.
 */
@objid ("6c134a3d-11dd-4ced-8a80-25d44cec91a8")
public class GmCourseOfActionMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("2c7f288b-e486-46f8-a9d1-5bb1c652d710")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmCourseOfAction();
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
    @objid ("cca3b918-88da-4c84-87de-8abc4cb840cb")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmCourseOfAction) instanceToMigrate);
        }
        return null;
    }

    @objid ("ad340d4d-669a-46ba-ade8-95ddb7cc9051")
    private IPersistent migrateFromV0(final _GmCourseOfAction oldCourseOfAction) {
        GmCourseOfAction newCourseOfAction = new GmCourseOfAction(oldCourseOfAction);

        newCourseOfAction.setLayoutData(oldCourseOfAction.getLayoutData());

        newCourseOfAction.setRoleInComposition(oldCourseOfAction.getRoleInComposition());

        GmCourseOfActionPrimaryNode newPrimaryNode = (GmCourseOfActionPrimaryNode) newCourseOfAction.getMainNode();
        for (IGmLink link : oldCourseOfAction.getStartingLinks()) {
            oldCourseOfAction.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldCourseOfAction.getEndingLinks()) {
            oldCourseOfAction.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newCourseOfAction.getPersistedStyle().setCascadedStyle(oldCourseOfAction.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldCourseOfAction.getPersistedStyle().getLocalKeys()) {
            newCourseOfAction.getDisplayedStyle().setProperty(key, oldCourseOfAction.getDisplayedStyle().getProperty(key));
        }

        oldCourseOfAction.delete();
        return newCourseOfAction;
    }

}
