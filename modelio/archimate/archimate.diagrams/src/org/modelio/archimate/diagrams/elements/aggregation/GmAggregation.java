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
package org.modelio.archimate.diagrams.elements.aggregation;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Aggregation}.
 */
@objid ("0d195ce8-ca44-403f-9a6c-28372ebecbb3")
public class GmAggregation extends GmArchiRelationship<Aggregation> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("1e5d10a2-4d11-4023-8043-995689301118")
    private static final int MINOR_VERSION = 0;

    @objid ("e4a650e3-c887-433b-9111-ca06601b4803")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("f82d1cac-0e74-4221-a928-506b72104877")
    public static final GmAggregationLinkStyleKeys styleKeyProvider = new GmAggregationLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("3e8b03cc-eb30-40ab-a421-9aeee6389c8d")
    public GmAggregation(IGmDiagram diagram, Aggregation elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("dee92515-30bb-48c5-96e4-69ac1a5f8044")
    public GmAggregation() {
        // Empty
    }

    @objid ("4d37130f-45df-4e97-9ed5-b91ba24a6824")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("0de88142-196e-4556-93d4-bbbae310abfa")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("ac044510-b5eb-4d02-8e0f-7bd3d5b1c53d")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("25ad0842-6a82-413e-b916-89fc1c744290")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmAggregation.", MINOR_VERSION);

    }

    @objid ("b53147ba-931c-47b8-a5fd-4a5c2c5bb718")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}
