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
package org.modelio.archimate.diagrams.elements.technologyprocess;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyprocess.v0._GmTechnologyProcess;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyProcess;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyProcess}.
 */
@objid ("9533a3b4-b5ee-472c-a42c-187ec0174690")
public class GmTechnologyProcessPrimaryNode extends GmArchiElementPrimaryNode<TechnologyProcess> {
    @objid ("fc4cad29-d477-45d2-a791-a3aab737687f")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("ac898a40-e759-4552-8f07-7f74dd9bb90d")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyProcess is unmasked.
     * @param el the unmasked TechnologyProcess.
     * @param ref a reference to the unmasked TechnologyProcess.
     */
    @objid ("935a6377-2b93-4ca7-935d-f0e51dccc41a")
    public GmTechnologyProcessPrimaryNode(IGmDiagram diagram, TechnologyProcess el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("92bf8241-2336-4234-91b7-ca007ee0dc4b")
    public GmTechnologyProcessPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("61d9f150-5331-4caa-a7bd-78efc0116fa9")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("7876bf99-eaf6-44bf-a395-45eeec0b4c8f")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyProcessPrimaryNode.");
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

    @objid ("71293045-f57b-4d87-9af3-bad728ed3723")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyProcessPrimaryNode.", MINOR_VERSION);

    }

    @objid ("b3670dcd-1015-4ced-879b-5b61596fe924")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("061d1b67-753b-4316-b3ce-ec4474e01782")
    GmTechnologyProcessPrimaryNode(final _GmTechnologyProcess oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("0ee80eca-1107-48ad-a0c2-cab624f94940")
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
