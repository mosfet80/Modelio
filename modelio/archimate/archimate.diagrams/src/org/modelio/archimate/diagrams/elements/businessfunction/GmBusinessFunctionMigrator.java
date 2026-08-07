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
package org.modelio.archimate.diagrams.elements.businessfunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessfunction.v0._GmBusinessFunction;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmBusinessFunction}.
 */
@objid ("46f61ee9-208f-4bd0-974e-87fafc139010")
public class GmBusinessFunctionMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("32c82413-54eb-4c44-a8e3-8a7e550fe088")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmBusinessFunction();
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
    @objid ("45f860db-ecaa-4d86-9deb-a11166e17065")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmBusinessFunction) instanceToMigrate);
        }
        return null;
    }

    @objid ("4822ccc8-3c53-4f49-845e-39651ba932f4")
    private IPersistent migrateFromV0(final _GmBusinessFunction oldBusinessFunction) {
        GmBusinessFunction newBusinessFunction = new GmBusinessFunction(oldBusinessFunction);

        newBusinessFunction.setLayoutData(oldBusinessFunction.getLayoutData());

        newBusinessFunction.setRoleInComposition(oldBusinessFunction.getRoleInComposition());

        GmBusinessFunctionPrimaryNode newPrimaryNode = (GmBusinessFunctionPrimaryNode) newBusinessFunction.getMainNode();
        for (IGmLink link : oldBusinessFunction.getStartingLinks()) {
            oldBusinessFunction.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldBusinessFunction.getEndingLinks()) {
            oldBusinessFunction.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newBusinessFunction.getPersistedStyle().setCascadedStyle(oldBusinessFunction.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldBusinessFunction.getPersistedStyle().getLocalKeys()) {
            newBusinessFunction.getDisplayedStyle().setProperty(key, oldBusinessFunction.getDisplayedStyle().getProperty(key));
        }

        oldBusinessFunction.delete();
        return newBusinessFunction;
    }

}
