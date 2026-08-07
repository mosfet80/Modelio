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
package org.modelio.archimate.diagrams.elements.serving;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Serving}.
 */
@objid ("99544029-e5d2-4ef5-a1a1-17c7646c0a88")
public class GmServing extends GmArchiRelationship<Serving> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("150a7a13-85d6-415c-b593-030007558540")
    private static final int MINOR_VERSION = 0;

    @objid ("63b3b977-a693-4c8b-b629-fa2a357fcee8")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("44cd15e9-8dc7-4fac-82e2-27f80e337279")
    public static final GmServingLinkStyleKeys styleKeyProvider = new GmServingLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("0fd08ed0-01e2-4d3b-ad62-1c7da707ea9b")
    public GmServing(IGmDiagram diagram, Serving elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("d348cbee-028a-4023-be65-52cd1ed5b7ca")
    public GmServing() {
        // Empty
    }

    @objid ("8db87804-e9c0-47a7-839e-c159101ec1e4")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("4fc8d4d0-b672-4323-98f6-b13afa0a03e3")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("3f9069bc-24fe-49ef-86ee-501d251ad9a2")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("cbe7d742-0105-444e-b2f1-3661d53ba89a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmServing.", MINOR_VERSION);

    }

    @objid ("6e490294-e1c7-4182-b4cf-4c62dcb29c80")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}
