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
package org.modelio.archimate.diagrams.elements.grouping;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.grouping.v0._GmGrouping;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Grouping}.
 */
@objid ("f4857a17-8d1e-408c-93f2-775f84ab91f4")
public class GmGroupingPrimaryNode extends GmArchiElementPrimaryNode<Grouping> {
    @objid ("92a3edf5-5f4c-435f-8744-29e1e61b44cb")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("ee76dacc-b578-41e4-888c-780aab21cb81")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Grouping is unmasked.
     * @param el the unmasked Grouping.
     * @param ref a reference to the unmasked Grouping.
     */
    @objid ("0d6faa6e-8f2a-4946-b442-88261c54d48c")
    public GmGroupingPrimaryNode(IGmDiagram diagram, Grouping el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("2fe9ff1d-999b-4586-9ba6-fa873aa50006")
    public GmGroupingPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("01df355d-30e4-41cb-af52-70b2f9de9676")
    @Override
    public int getMajorVersion() {
        return GmGroupingPrimaryNode.MAJOR_VERSION;
    }

    @objid ("714fe5d6-158d-41ce-9b34-149a300feeda")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGroupingPrimaryNode.");
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

    @objid ("2ad9abfa-9010-49df-afdf-14b1080a2126")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGroupingPrimaryNode.", GmGroupingPrimaryNode.MINOR_VERSION);

    }

    @objid ("3bacae06-2596-46e8-8dd7-4d64d4702c9d")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("62c86e79-3595-4d45-ae1b-497a6a26e3e6")
    GmGroupingPrimaryNode(final _GmGrouping oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("7c894d1a-ae2e-48af-9c5a-7b9ceb23f276")
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
