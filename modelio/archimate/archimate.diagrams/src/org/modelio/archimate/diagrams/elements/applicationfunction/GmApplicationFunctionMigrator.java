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
package org.modelio.archimate.diagrams.elements.applicationfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationfunction.v0._GmApplicationFunction;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmApplicationFunction}.
 */
@objid ("ccc69b22-36a8-4e8b-9000-0d0da604516d")
public class GmApplicationFunctionMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("6b84e663-9823-453f-a06a-e956beeb65e1")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmApplicationFunction();
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
    @objid ("96e582df-4638-46c9-985d-1ed0f4772594")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmApplicationFunction) instanceToMigrate);
        }
        return null;
    }

    @objid ("607743f3-f892-434a-9fdb-21044e82b25b")
    private IPersistent migrateFromV0(final _GmApplicationFunction oldApplicationFunction) {
        GmApplicationFunction newApplicationFunction = new GmApplicationFunction(oldApplicationFunction);

        newApplicationFunction.setLayoutData(oldApplicationFunction.getLayoutData());

        newApplicationFunction.setRoleInComposition(oldApplicationFunction.getRoleInComposition());

        GmApplicationFunctionPrimaryNode newPrimaryNode = (GmApplicationFunctionPrimaryNode) newApplicationFunction.getMainNode();
        for (IGmLink link : oldApplicationFunction.getStartingLinks()) {
            oldApplicationFunction.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldApplicationFunction.getEndingLinks()) {
            oldApplicationFunction.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newApplicationFunction.getPersistedStyle().setCascadedStyle(oldApplicationFunction.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldApplicationFunction.getPersistedStyle().getLocalKeys()) {
            newApplicationFunction.getDisplayedStyle().setProperty(key, oldApplicationFunction.getDisplayedStyle().getProperty(key));
        }

        oldApplicationFunction.delete();
        return newApplicationFunction;
    }

}
