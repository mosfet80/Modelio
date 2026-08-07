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
package org.modelio.archimate.diagrams.elements.technologyinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInteraction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyInteraction}.
 */
@objid ("9aa7bd8c-6a8b-448f-a3dd-6796e0b674a4")
public class GmTechnologyInteractionPrimaryNode extends GmArchiElementPrimaryNode<TechnologyInteraction> {
    @objid ("74747597-04e2-4628-a5d8-4fb0f17d1dac")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("761a1b95-9407-4ef5-8c8b-a1adcd609b2f")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyInteraction is unmasked.
     * @param el the unmasked TechnologyInteraction.
     * @param ref a reference to the unmasked TechnologyInteraction.
     */
    @objid ("69decfa0-b703-4978-91d1-6a6082bcecf3")
    public GmTechnologyInteractionPrimaryNode(IGmDiagram diagram, TechnologyInteraction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("60a7d66f-a45c-45e4-9858-741db303d541")
    public GmTechnologyInteractionPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("ee853b24-bf59-4a44-aac3-c108cee8f25d")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("9810ea67-2d1a-4e8b-9cfe-18f054aed103")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyInteraction.");
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

    @objid ("9043ea39-e482-4538-80c3-0b6d1574e366")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyInteraction.", MINOR_VERSION);

    }

    @objid ("c3c1f397-4458-49cf-8af2-c407610ba9b7")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
