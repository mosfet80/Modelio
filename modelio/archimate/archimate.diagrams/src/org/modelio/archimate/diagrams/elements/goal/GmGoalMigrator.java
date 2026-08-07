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
package org.modelio.archimate.diagrams.elements.goal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.goal.v0._GmGoal;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmGoal}.
 */
@objid ("184d76cc-fd8f-4e6f-a212-321aeb015f3d")
public class GmGoalMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("ac9ed6c2-0f85-4b6a-9328-38a2359d1c0e")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmGoal();
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
    @objid ("a9692ded-6635-40e7-9206-408d23ddcb4a")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmGoal) instanceToMigrate);
        }
        return null;
    }

    @objid ("303e4630-5538-4c96-8258-6de093a8bc69")
    private IPersistent migrateFromV0(final _GmGoal oldGoal) {
        GmGoal newGoal = new GmGoal(oldGoal);

        newGoal.setLayoutData(oldGoal.getLayoutData());

        newGoal.setRoleInComposition(oldGoal.getRoleInComposition());

        GmGoalPrimaryNode newPrimaryNode = (GmGoalPrimaryNode) newGoal.getMainNode();
        for (IGmLink link : oldGoal.getStartingLinks()) {
            oldGoal.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldGoal.getEndingLinks()) {
            oldGoal.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newGoal.getPersistedStyle().setCascadedStyle(oldGoal.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldGoal.getPersistedStyle().getLocalKeys()) {
            newGoal.getDisplayedStyle().setProperty(key, oldGoal.getDisplayedStyle().getProperty(key));
        }

        oldGoal.delete();
        return newGoal;
    }

}
