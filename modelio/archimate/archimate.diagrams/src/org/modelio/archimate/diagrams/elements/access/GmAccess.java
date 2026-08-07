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
package org.modelio.archimate.diagrams.elements.access;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.AccessMode;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Access}.
 */
@objid ("2838f298-9f53-444d-85a9-052880229752")
public class GmAccess extends GmArchiRelationship<Access> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("fa2bf0e9-899a-4ead-948d-211a54e0fc07")
    private static final int MINOR_VERSION = 0;

    @objid ("34d108ab-0832-4bba-92e7-6712cabe620e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("38307ea3-e380-4c93-83f5-85f75354fb1e")
    public static final GmAccessLinkStyleKeys styleKeyProvider = new GmAccessLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("dfab1437-a8e8-4c51-91bf-ae58665daa37")
    public GmAccess(IGmDiagram diagram, Access elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("00f16484-50ae-4252-8dc6-1d39400d9b34")
    public GmAccess() {
        // Empty
    }

    @objid ("1cdb1cf6-25c2-4065-94a9-98da8b964fe3")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("4f55954d-eb42-4fa7-8190-5bca74f42714")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("ea421334-cd36-4fa2-8969-8b667257ff83")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("d3404912-886c-4cdd-b298-bd8093687c0b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmAccess.", MINOR_VERSION);

    }

    @objid ("d03ff6c7-4adb-45d3-b767-cd437eb48cfb")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    /**
     *
     * @return <code>true</code> if {@link Access#getMode()} is equals to {@link AccessMode#WRITE} or {@link AccessMode#READWRITE}.
     */
    @objid ("a0aef60c-6e2f-4d11-8c4e-bb11d9cab429")
    public boolean isToNavigable() {
        Access relatedElement = getRelatedElement();
        if (relatedElement != null) {
            switch (getRelatedElement().getMode()) {
            case READWRITE:
            case WRITE:
                return true;
            case READ:
            case UNDEFINED:
            default:
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     *
     * @return <code>true</code> if {@link Access#getMode()} is equals to {@link AccessMode#READ} or {@link AccessMode#READWRITE}.
     */
    @objid ("f156dde6-06aa-4d64-984d-4dafbbfe20e8")
    public boolean isFromNavigable() {
        Access relatedElement = getRelatedElement();
        if (relatedElement != null) {
            switch (relatedElement.getMode()) {
            case READWRITE:
            case READ:
                return true;
            case WRITE:
            case UNDEFINED:
            default:
                return false;
            }
        } else {
            return false;
        }

    }

    @objid ("a3354ef9-a16f-42a1-b64b-e8e1a6731f0f")
    @Override
    public void refreshFromObModel() {
        super.refreshFromObModel();

        // post change event
        firePropertyChange(PROPERTY_LAYOUTDATA, null, this);

    }

}
