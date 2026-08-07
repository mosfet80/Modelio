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
package org.modelio.archimate.diagrams.elements.equipment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.equipment.v0._GmEquipment;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmEquipment}.
 */
@objid ("8a69495d-0c31-4627-bc27-4bd1b20ed7a8")
public class GmEquipmentMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("028eba20-5e80-4ef2-a779-eb4c965e9f8f")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmEquipment();
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
    @objid ("b2f8f7fd-fb86-4423-a537-6eb340cf9f08")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmEquipment) instanceToMigrate);
        }
        return null;
    }

    @objid ("cbae89e3-fdd1-45c4-a8e9-13e01a5eb035")
    private IPersistent migrateFromV0(final _GmEquipment oldEquipment) {
        GmEquipment newEquipment = new GmEquipment(oldEquipment);

        newEquipment.setLayoutData(oldEquipment.getLayoutData());

        newEquipment.setRoleInComposition(oldEquipment.getRoleInComposition());

        GmEquipmentPrimaryNode newPrimaryNode = (GmEquipmentPrimaryNode) newEquipment.getMainNode();
        for (IGmLink link : oldEquipment.getStartingLinks()) {
            oldEquipment.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldEquipment.getEndingLinks()) {
            oldEquipment.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newEquipment.getPersistedStyle().setCascadedStyle(oldEquipment.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldEquipment.getPersistedStyle().getLocalKeys()) {
            newEquipment.getDisplayedStyle().setProperty(key, oldEquipment.getDisplayedStyle().getProperty(key));
        }

        oldEquipment.delete();
        return newEquipment;
    }

}
