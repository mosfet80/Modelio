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
package org.modelio.archimate.diagrams.elements.valuestream;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ValueStream}.
 */
@objid ("29321133-102c-458d-9a8b-1188de8b784f")
public class GmValueStreamPrimaryNode extends GmArchiElementPrimaryNode<ValueStream> {
    @objid ("7b402709-a13e-4034-a887-24cbae89af05")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("8385c5ae-9cb9-4418-9be2-437ff38af7d9")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ValueStream is unmasked.
     * @param el the unmasked ValueStream.
     * @param ref a reference to the unmasked ValueStream.
     */
    @objid ("aac26672-779a-4df0-a04e-e5e26a56a001")
    public GmValueStreamPrimaryNode(IGmDiagram diagram, ValueStream el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("586ee9e0-2946-4811-9f1c-f0827652e583")
    public GmValueStreamPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("7d0320c4-84e8-4411-ae30-d9cf55e47c7c")
    @Override
    public int getMajorVersion() {
        return GmValueStreamPrimaryNode.MAJOR_VERSION;
    }

    @objid ("44dba68c-fc9e-41db-a4c9-fa473809ea5e")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmValueStreamPrimaryNode.");
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

    @objid ("8daef47e-5eea-4c63-b269-cbabf53f3343")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmValueStreamPrimaryNode.", GmValueStreamPrimaryNode.MINOR_VERSION);

    }

    @objid ("6cebfd30-bfe5-4afa-8ca7-3a1e5a4d6e48")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("1bff4f84-bbc1-4be2-a089-19a3acd2577f")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> visibleChildren = super.getVisibleChildren();
        if (getRepresentationMode() == RepresentationMode.SIMPLE) {
            // In simple mode, we do not want a floating label
            visibleChildren.add(this.header);
        }
        return visibleChildren;
    }

}
