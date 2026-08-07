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
package org.modelio.archimate.diagrams.elements.stakeholder;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.stakeholder.v0._GmStakeholder;
import org.modelio.archimate.metamodel.layers.motivation.Stakeholder;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Stakeholder}.
 */
@objid ("a68e7da9-70b8-41c0-8f92-b9dadc9b3d92")
public class GmStakeholderPrimaryNode extends GmArchiElementPrimaryNode<Stakeholder> {
    @objid ("f1d1492b-2475-486a-864c-92d296d3e17e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("d118b91d-8af9-4b19-a4a8-69b514762747")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Stakeholder is unmasked.
     * @param el the unmasked Stakeholder.
     * @param ref a reference to the unmasked Stakeholder.
     */
    @objid ("dc763251-298e-48e0-bb1e-5ca6a7e808e8")
    public GmStakeholderPrimaryNode(IGmDiagram diagram, Stakeholder el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("74d5b219-ee4c-4b0d-b4e8-21c13857ee88")
    public GmStakeholderPrimaryNode() {
        // Nothing specific to do.
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("3d5e7b2f-b5e8-4d66-90cd-474e70cb234d")
    GmStakeholderPrimaryNode(final _GmStakeholder oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("1b5f85fb-8216-4fe4-9401-12e3633ca6de")
    @Override
    public int getMajorVersion() {
        return GmStakeholderPrimaryNode.MAJOR_VERSION;
    }

    @objid ("7efd9e91-782b-48eb-a7be-aa08c2ba7dcb")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmStakeholderPrimaryNode.");
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

    @objid ("7419e33e-9f1c-44aa-8675-8604a9e78748")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmStakeholderPrimaryNode.", MINOR_VERSION);

    }

    @objid ("d6069224-b20f-4183-9e06-7d9c2fdd5a51")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("23668a65-3890-4493-b9b4-0b6f1dd9792b")
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
