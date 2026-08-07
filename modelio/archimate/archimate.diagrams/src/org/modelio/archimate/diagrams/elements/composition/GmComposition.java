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
package org.modelio.archimate.diagrams.elements.composition;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Composition}.
 */
@objid ("4e8c5f4f-b8d2-4adb-98f9-a79df5d3c3c4")
public class GmComposition extends GmArchiRelationship<Composition> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("defbb564-5c97-480e-8388-a0ba2bd7f4e1")
    private static final int MINOR_VERSION = 0;

    @objid ("084000cf-f327-4955-9169-be73df5f16c4")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("4a280af2-d4ef-45c6-acb1-e69ca845e6eb")
    public static final GmCompositionLinkStyleKeys styleKeyProvider = new GmCompositionLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("b4f0290e-8202-426e-a2a8-5a4a86eae4a1")
    public GmComposition(IGmDiagram diagram, Composition elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("7f92dc3d-c4a6-45c7-a992-65c466f465c6")
    public GmComposition() {
        // Empty
    }

    @objid ("f2f13e22-d1c0-4359-96ac-843b08b90eb9")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("e247e52c-2cb6-4f77-babb-b06d8f416b83")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("2d4ad616-41d0-486b-93e2-920dab71f22a")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("3c87d5bd-ce30-41de-803b-c8996965dbe9")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmComposition.", MINOR_VERSION);

    }

    @objid ("ef5380b7-eb9b-463b-a371-840dd591c2e4")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}
