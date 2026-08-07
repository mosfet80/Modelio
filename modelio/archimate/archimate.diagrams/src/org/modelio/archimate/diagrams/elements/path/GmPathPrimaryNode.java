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
package org.modelio.archimate.diagrams.elements.path;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Path;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Path}.
 */
@objid ("159466ee-fb1f-4af0-b3d2-412c6fc1d746")
public class GmPathPrimaryNode extends GmArchiElementPrimaryNode<Path> {
    @objid ("5d658bc5-a72d-4303-b28a-084b32f34281")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("a5bec705-219b-4a65-bac0-02d58408f1d3")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Path is unmasked.
     * @param el the unmasked Path.
     * @param ref a reference to the unmasked Path.
     */
    @objid ("59709ff0-c919-4789-a895-3531fc4f6859")
    public GmPathPrimaryNode(IGmDiagram diagram, Path el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("9f108f81-42e3-48d1-9194-313856d00dd6")
    public GmPathPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("edbead79-b05b-42a6-8cb4-0a14c99bf915")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("2615821c-6f8c-4056-9a6b-7a5c511c9005")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmPath.");
        switch (readVersion) {
        case 0: {
            read_0(in);
            break;
        }
        default: {
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 0
            read_0(in);
            break;
        }
        }

    }

    @objid ("1adc6a86-c82b-4fb9-b75d-8ce0166ae792")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmPath.", MINOR_VERSION);

    }

    @objid ("998529c1-4f05-4407-87dd-b6810b49e32d")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
