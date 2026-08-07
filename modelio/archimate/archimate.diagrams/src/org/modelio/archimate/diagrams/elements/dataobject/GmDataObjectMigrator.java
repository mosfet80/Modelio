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
package org.modelio.archimate.diagrams.elements.dataobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.dataobject.v0._GmDataObject;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmDataObject}.
 */
@objid ("7369e943-3e72-4efb-bf13-df7f67c289a8")
public class GmDataObjectMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("27e07e39-d17b-4f3b-b178-3d3a3be1b3dc")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmDataObject();
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
    @objid ("92eecf81-7510-4920-b18b-67a30c619cfb")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmDataObject) instanceToMigrate);
        }
        return null;
    }

    @objid ("2fd33b11-f9b5-4e03-b92a-1f1781f3a63f")
    private IPersistent migrateFromV0(final _GmDataObject oldDataObject) {
        GmDataObject newDataObject = new GmDataObject(oldDataObject);

        newDataObject.setLayoutData(oldDataObject.getLayoutData());

        newDataObject.setRoleInComposition(oldDataObject.getRoleInComposition());

        GmDataObjectPrimaryNode newPrimaryNode = (GmDataObjectPrimaryNode) newDataObject.getMainNode();
        for (IGmLink link : oldDataObject.getStartingLinks()) {
            oldDataObject.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldDataObject.getEndingLinks()) {
            oldDataObject.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newDataObject.getPersistedStyle().setCascadedStyle(oldDataObject.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldDataObject.getPersistedStyle().getLocalKeys()) {
            newDataObject.getDisplayedStyle().setProperty(key, oldDataObject.getDisplayedStyle().getProperty(key));
        }

        oldDataObject.delete();
        return newDataObject;
    }

}
