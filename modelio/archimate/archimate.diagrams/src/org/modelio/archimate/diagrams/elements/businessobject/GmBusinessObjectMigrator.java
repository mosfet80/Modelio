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
package org.modelio.archimate.diagrams.elements.businessobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessobject.v0._GmBusinessObject;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmBusinessObject}.
 */
@objid ("e70bf05b-34f0-40b9-b7d9-d86a68dc025d")
public class GmBusinessObjectMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("1b9cabd6-dba9-47a4-ab13-2ded3c985e06")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmBusinessObject();
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
    @objid ("0babaee3-740b-4d68-8550-56ff0cb32a7c")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmBusinessObject) instanceToMigrate);
        }
        return null;
    }

    @objid ("56e674bb-aaec-417a-ad5e-dddb76737010")
    private IPersistent migrateFromV0(final _GmBusinessObject oldBusinessObject) {
        GmBusinessObject newBusinessObject = new GmBusinessObject(oldBusinessObject);

        newBusinessObject.setLayoutData(oldBusinessObject.getLayoutData());

        newBusinessObject.setRoleInComposition(oldBusinessObject.getRoleInComposition());

        GmBusinessObjectPrimaryNode newPrimaryNode = (GmBusinessObjectPrimaryNode) newBusinessObject.getMainNode();
        for (IGmLink link : oldBusinessObject.getStartingLinks()) {
            oldBusinessObject.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldBusinessObject.getEndingLinks()) {
            oldBusinessObject.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newBusinessObject.getPersistedStyle().setCascadedStyle(oldBusinessObject.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldBusinessObject.getPersistedStyle().getLocalKeys()) {
            newBusinessObject.getDisplayedStyle().setProperty(key, oldBusinessObject.getDisplayedStyle().getProperty(key));
        }

        oldBusinessObject.delete();
        return newBusinessObject;
    }

}
