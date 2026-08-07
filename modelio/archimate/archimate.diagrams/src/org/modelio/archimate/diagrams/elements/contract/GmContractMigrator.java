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
package org.modelio.archimate.diagrams.elements.contract;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.contract.v0._GmContract;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmContract}.
 */
@objid ("abade80a-c443-43e2-b727-741611cc1fad")
public class GmContractMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("c7e54c09-7c67-4dfe-8d25-3ba42e801910")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmContract();
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
    @objid ("606ec962-a403-41e3-9d06-c04a98b18dfe")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmContract) instanceToMigrate);
        }
        return null;
    }

    @objid ("24fbe887-84a6-411a-ad7f-534c2f43b1a7")
    private IPersistent migrateFromV0(final _GmContract oldContract) {
        GmContract newContract = new GmContract(oldContract);

        newContract.setLayoutData(oldContract.getLayoutData());

        newContract.setRoleInComposition(oldContract.getRoleInComposition());

        GmContractPrimaryNode newPrimaryNode = (GmContractPrimaryNode) newContract.getMainNode();
        for (IGmLink link : oldContract.getStartingLinks()) {
            oldContract.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldContract.getEndingLinks()) {
            oldContract.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newContract.getPersistedStyle().setCascadedStyle(oldContract.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldContract.getPersistedStyle().getLocalKeys()) {
            newContract.getDisplayedStyle().setProperty(key, oldContract.getDisplayedStyle().getProperty(key));
        }

        oldContract.delete();
        return newContract;
    }

}
