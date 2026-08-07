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
package org.modelio.archimate.diagrams.elements.product;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.product.v0._GmProduct;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * Migrator class for {@link GmProduct}.
 */
@objid ("de55cc03-d003-453e-8b9d-f5343a6f153f")
public class GmProductMigrator implements IPersistentMigrator {
    /**
     * Instantiate a version of the {@link IPersistent} as it was when its major version was the given parameter. The returned instance can then be used to read the serialisation string corresponding to the version without risk.
     *
     * @param majorVersionToInstantiate the major version of the instance requested.
     * @return an instance of IPersistent at the requested version.
     */
    @objid ("58a62744-7ec5-4c7b-8188-7f9f317f9a87")
    @Override
    public IPersistent createInstanceOfMajorVersion(final int majorVersionToInstantiate) {
        switch (majorVersionToInstantiate) {
        case 0: {
            return new _GmProduct();
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
    @objid ("400ffa27-d4da-4ebc-9ef2-628cd7e77aab")
    @Override
    public IPersistent migrate(final IPersistent instanceToMigrate) {
        if (instanceToMigrate.getMajorVersion() == 0) {
            return migrateFromV0((_GmProduct) instanceToMigrate);
        }
        return null;
    }

    @objid ("e14909a5-37a1-4322-be22-b360efee15b2")
    private IPersistent migrateFromV0(final _GmProduct oldProduct) {
        GmProduct newProduct = new GmProduct(oldProduct);

        newProduct.setLayoutData(oldProduct.getLayoutData());

        newProduct.setRoleInComposition(oldProduct.getRoleInComposition());

        GmProductPrimaryNode newPrimaryNode = (GmProductPrimaryNode) newProduct.getMainNode();
        for (IGmLink link : oldProduct.getStartingLinks()) {
            oldProduct.removeStartingLink(link);
            newPrimaryNode.addStartingLink(link);
        }
        for (IGmLink link : oldProduct.getEndingLinks()) {
            oldProduct.removeEndingLink(link);
            newPrimaryNode.addEndingLink(link);
        }

        newProduct.getPersistedStyle().setCascadedStyle(oldProduct.getPersistedStyle().getCascadedStyle());
        for (StyleKey key : oldProduct.getPersistedStyle().getLocalKeys()) {
            newProduct.getDisplayedStyle().setProperty(key, oldProduct.getDisplayedStyle().getProperty(key));
        }

        oldProduct.delete();
        return newProduct;
    }

}
