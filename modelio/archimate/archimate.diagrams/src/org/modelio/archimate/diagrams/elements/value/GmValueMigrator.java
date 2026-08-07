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
package org.modelio.archimate.diagrams.elements.value;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.value.v0._GmValue;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmValue}.
 */
@objid ("0b0ce422-7b7b-4eb6-a490-eee400e1d84b")
public class GmValueMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("10fcf0be-b67e-42c9-9c82-a2fe407c8948")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmValue();
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
    @objid ("02ed5ffe-c7d5-4924-aa3b-0aaff54f8f44")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmValue) instanceToMigrate);
        }
        return null;
    }

    @objid ("aade2bdd-3261-4759-83fe-f0d8c4baeaed")
    private IPersistent migrateFromV0(final _GmValue oldValue) {
        GmValue newValue = new GmValue(oldValue);

        newValue.setLayoutData(oldValue.getLayoutData());

        newValue.setRoleInComposition(oldValue.getRoleInComposition());

        GmValuePrimaryNode newPrimaryNode = (GmValuePrimaryNode) newValue.getMainNode();
        for (IGmLink link : oldValue.getStartingLinks()) {
            oldValue.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldValue.getEndingLinks()) {
            oldValue.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newValue.getPersistedStyle().setCascadedStyle(oldValue.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldValue.getPersistedStyle().getLocalKeys()) {
            newValue.getDisplayedStyle().setProperty(key, oldValue.getDisplayedStyle().getProperty(key));
        }

        oldValue.delete();
        return newValue;
    }

}
