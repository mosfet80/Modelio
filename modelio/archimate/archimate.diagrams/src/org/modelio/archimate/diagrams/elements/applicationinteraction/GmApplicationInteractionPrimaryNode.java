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
package org.modelio.archimate.diagrams.elements.applicationinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationInteraction}.
 */
@objid ("fb5aaa6c-2a3a-48dd-9668-acd498ad9c89")
public class GmApplicationInteractionPrimaryNode extends GmArchiElementPrimaryNode<ApplicationInteraction> {
    @objid ("e1ed7c50-fe61-4942-a061-2ce4cb1009b3")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("16f117b3-40e4-493a-9c4c-1ea45ebfa5ba")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationInteraction is unmasked.
     * @param el the unmasked ApplicationInteraction.
     * @param ref a reference to the unmasked ApplicationInteraction.
     */
    @objid ("89caf541-4872-4729-880c-aa6e267521f7")
    public GmApplicationInteractionPrimaryNode(IGmDiagram diagram, ApplicationInteraction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("0109d254-9b4d-4ab7-a81e-26d71d485785")
    public GmApplicationInteractionPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("97678daf-ec66-4099-8509-13d1cc7e416d")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("e284eabb-5ac3-44f0-b9e7-1097ef89579a")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmApplicationInteraction.");
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

    @objid ("c06300bb-2b24-4aa1-ab8e-6185d1a8d834")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmApplicationInteraction.", MINOR_VERSION);

    }

    @objid ("d1d49cff-a0df-41b2-83a5-fb38789ca12c")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
