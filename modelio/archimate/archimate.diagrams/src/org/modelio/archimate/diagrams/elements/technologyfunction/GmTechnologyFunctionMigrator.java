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
package org.modelio.archimate.diagrams.elements.technologyfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.technologyfunction.v0._GmTechnologyFunction;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmTechnologyFunction}.
 */
@objid ("866469f3-3204-4ac7-953f-22d71a7c0259")
public class GmTechnologyFunctionMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("a5fef8e6-ece2-4173-8d35-f69927632728")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmTechnologyFunction();
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
    @objid ("1735ce23-8611-41c3-8e3f-e9d97f85f403")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmTechnologyFunction) instanceToMigrate);
        }
        return null;
    }

    @objid ("3de3a139-294d-4a98-8a41-e8c30ad410c8")
    private IPersistent migrateFromV0(final _GmTechnologyFunction oldTechnologyFunction) {
        GmTechnologyFunction newTechnologyFunction = new GmTechnologyFunction(oldTechnologyFunction);

        newTechnologyFunction.setLayoutData(oldTechnologyFunction.getLayoutData());

        newTechnologyFunction.setRoleInComposition(oldTechnologyFunction.getRoleInComposition());

        GmTechnologyFunctionPrimaryNode newPrimaryNode = (GmTechnologyFunctionPrimaryNode) newTechnologyFunction.getMainNode();
        for (IGmLink link : oldTechnologyFunction.getStartingLinks()) {
            oldTechnologyFunction.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldTechnologyFunction.getEndingLinks()) {
            oldTechnologyFunction.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newTechnologyFunction.getPersistedStyle().setCascadedStyle(oldTechnologyFunction.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldTechnologyFunction.getPersistedStyle().getLocalKeys()) {
            newTechnologyFunction.getDisplayedStyle().setProperty(key, oldTechnologyFunction.getDisplayedStyle().getProperty(key));
        }

        oldTechnologyFunction.delete();
        return newTechnologyFunction;
    }

}
