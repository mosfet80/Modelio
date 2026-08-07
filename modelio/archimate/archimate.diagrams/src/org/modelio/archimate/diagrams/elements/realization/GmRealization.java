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
package org.modelio.archimate.diagrams.elements.realization;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Realization}.
 */
@objid ("2afeb62f-bb69-4a72-aaba-bccd403d0107")
public class GmRealization extends GmArchiRelationship<Realization> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("5ba4e8cf-5e68-4f41-a8be-8134f4ead609")
    private static final int MINOR_VERSION = 0;

    @objid ("e86f18dd-ce6a-4564-9cc8-448e8d673b3d")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("d1b90d3a-0602-4074-ac65-6e9daffdafb9")
    public static final GmRealizationLinkStyleKeys styleKeyProvider = new GmRealizationLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("a4271f0c-d290-474f-b0ff-858f6681a511")
    public GmRealization(IGmDiagram diagram, Realization elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("d214a3ad-d43b-4264-91e7-e5af35ad5340")
    public GmRealization() {
        // Empty
    }

    @objid ("50501854-6f31-4d5b-951d-e5f8f5a19617")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("b0e0b747-eb2d-4a29-b41d-5039f3802bdc")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("6f3b859f-20f4-436d-b5b7-937906d78444")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("8ecb9cda-3011-4cf1-8df0-e61c740de74b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmRealization.", MINOR_VERSION);

    }

    @objid ("25e1c2f5-e3df-4d9a-8df7-b6f71e5883cb")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}
