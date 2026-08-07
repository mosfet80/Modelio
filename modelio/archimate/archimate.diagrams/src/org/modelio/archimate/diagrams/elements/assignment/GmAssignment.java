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
package org.modelio.archimate.diagrams.elements.assignment;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archilink.GmArchiRelationship;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Graphic model for {@link Assignment}.
 */
@objid ("42e6c832-8c34-48f5-ace9-6a7d6d81892d")
public class GmAssignment extends GmArchiRelationship<Assignment> {
    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("16154313-7b2a-45e4-8166-daf62c8cf7ea")
    private static final int MINOR_VERSION = 0;

    @objid ("24d4bb7b-2f48-4901-8405-142d7b0c5bee")
    private static final int MAJOR_VERSION = 0;

    /**
     * Style keys.
     */
    @objid ("977dac6b-3e6c-424e-9098-ea8a4c242922")
    public static final GmAssignmentLinkStyleKeys styleKeyProvider = new GmAssignmentLinkStyleKeys();

    /**
     * Initialize a graphic model.
     *
     * @param diagram The owning diagram.
     * @param elt The link element, may be <code>null</code>.
     * @param ref The link reference, may not be <code>null</code>.
     */
    @objid ("1b73867c-08c0-4f88-a443-78482679b41b")
    public GmAssignment(IGmDiagram diagram, Assignment elt, MRef ref) {
        super(diagram, elt, ref);
    }

    /**
     * For deserialization only.
     */
    @objid ("e74f8378-3f9b-472e-9acb-627dafd8baa3")
    public GmAssignment() {
        // Empty
    }

    @objid ("a5a9e0ec-7f7a-46a9-b2e4-73e04c356385")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return styleKeyProvider.getStyleKey(metakey);
    }

    @objid ("f6b29fb9-12b6-415c-a05b-31ff780b8d84")
    @Override
    public List<StyleKey> getStyleKeys() {
        return styleKeyProvider.getStyleKeys();
    }

    @objid ("28db3ad0-bbd0-468f-9997-4ff29b30eeee")
    @Override
    protected void readLink(IDiagramReader in) {
        super.readLink(in);
    }

    @objid ("7da7b2dd-29f7-48a5-86a7-f4c4f72981a7")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmAssignment.", MINOR_VERSION);

    }

    @objid ("bff3d212-2bb9-488e-a6ae-371de9f79194")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

}
