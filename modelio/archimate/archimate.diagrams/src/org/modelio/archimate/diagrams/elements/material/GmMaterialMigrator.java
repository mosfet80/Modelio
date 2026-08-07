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
package org.modelio.archimate.diagrams.elements.material;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.material.v0._GmMaterial;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmMaterial}.
 */
@objid ("38c92e85-c472-46bc-84a4-b7b8fc5ef38a")
public class GmMaterialMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("186001a9-25d9-412a-b69c-7966f8c5037f")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmMaterial();
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
    @objid ("2a996431-0589-450d-b4fe-c3257076a620")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmMaterial) instanceToMigrate);
        }
        return null;
    }

    @objid ("9e137ceb-e55e-4d2c-9ce7-0752aef48300")
    private IPersistent migrateFromV0(final _GmMaterial oldMaterial) {
        GmMaterial newMaterial = new GmMaterial(oldMaterial);

        newMaterial.setLayoutData(oldMaterial.getLayoutData());

        newMaterial.setRoleInComposition(oldMaterial.getRoleInComposition());

        GmMaterialPrimaryNode newPrimaryNode = (GmMaterialPrimaryNode) newMaterial.getMainNode();
        for (IGmLink link : oldMaterial.getStartingLinks()) {
            oldMaterial.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldMaterial.getEndingLinks()) {
            oldMaterial.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newMaterial.getPersistedStyle().setCascadedStyle(oldMaterial.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldMaterial.getPersistedStyle().getLocalKeys()) {
            newMaterial.getDisplayedStyle().setProperty(key, oldMaterial.getDisplayedStyle().getProperty(key));
        }

        oldMaterial.delete();
        return newMaterial;
    }

}
