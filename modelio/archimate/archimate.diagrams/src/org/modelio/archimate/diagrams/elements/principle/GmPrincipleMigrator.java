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
package org.modelio.archimate.diagrams.elements.principle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.principle.v0._GmPrinciple;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmPrinciple}.
 */
@objid ("5ffbb286-f51e-4fe6-8ce9-0016c92d3ae3")
public class GmPrincipleMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("25493881-47c1-4878-a62c-7d34990f7203")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmPrinciple();
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
    @objid ("115517da-41ca-4ec3-a6ea-fe5703477081")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmPrinciple) instanceToMigrate);
        }
        return null;
    }

    @objid ("435e728c-9fd2-4bbc-9a19-dd0980f3a632")
    private IPersistent migrateFromV0(final _GmPrinciple oldPrinciple) {
        GmPrinciple newPrinciple = new GmPrinciple(oldPrinciple);

        newPrinciple.setLayoutData(oldPrinciple.getLayoutData());

        newPrinciple.setRoleInComposition(oldPrinciple.getRoleInComposition());

        GmPrinciplePrimaryNode newPrimaryNode = (GmPrinciplePrimaryNode) newPrinciple.getMainNode();
        for (IGmLink link : oldPrinciple.getStartingLinks()) {
            oldPrinciple.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldPrinciple.getEndingLinks()) {
            oldPrinciple.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newPrinciple.getPersistedStyle().setCascadedStyle(oldPrinciple.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldPrinciple.getPersistedStyle().getLocalKeys()) {
            newPrinciple.getDisplayedStyle().setProperty(key, oldPrinciple.getDisplayedStyle().getProperty(key));
        }

        oldPrinciple.delete();
        return newPrinciple;
    }

}
