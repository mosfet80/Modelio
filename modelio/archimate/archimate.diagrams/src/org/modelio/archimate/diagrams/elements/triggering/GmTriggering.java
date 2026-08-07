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
package org.modelio.archimate.diagrams.elements.triggering;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Triggering}.
 */
@objid ("20381f1e-5e71-46da-8bff-d4c5640795f9")
public class GmTriggering extends GmArchiRelationship<Triggering> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("18892329-e9f0-4b21-82c5-30f8e06cae88")
    private static final int MINOR_VERSION = 0;

    @objid ("252ba2b4-a97c-4c38-aa04-fd02261f2529")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("cc3d831b-1b92-47b2-97a7-bc6337c8503e")
    public static final GmTriggeringLinkStyleKeys styleKeyProvider = new GmTriggeringLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("a836500d-c052-4195-ac58-20be269b6b63")
    public GmTriggering(IGmDiagram diagram, Triggering elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("623b0e7d-eb43-44c0-8f2d-72344e7238ef")
    public GmTriggering() {
        // Empty
    }

    @objid ("6175ad13-e1a7-4f09-a72b-f3364851e24f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("5ab30b36-c4e1-4224-8650-8fd11223579f")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("4e3dcf13-3cfe-4da8-b2e5-10afc1fe2975")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("9b150e4c-9114-4b16-aa6d-d906f1ba422d")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTriggering.", MINOR_VERSION);

    }

    @objid ("78f2012d-5c84-4726-bf23-ba5d50e19680")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}
