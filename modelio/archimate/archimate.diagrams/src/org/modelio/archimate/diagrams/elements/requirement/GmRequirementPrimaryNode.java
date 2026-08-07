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
package org.modelio.archimate.diagrams.elements.requirement;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.requirement.v0._GmRequirement;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Requirement}.
 */
@objid ("668fa973-5942-4bb7-83f0-da0d468cb2f1")
public class GmRequirementPrimaryNode extends GmArchiElementPrimaryNode<Requirement> {
    @objid ("ad344e46-9f3a-4620-a8ac-24338b03bf63")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("e8114f3e-456b-4f33-b1d8-003a5d7fa665")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Requirement is unmasked.
     * @param el the unmasked Requirement.
     * @param ref a reference to the unmasked Requirement.
     */
    @objid ("bdc2a99c-af05-4ade-b0ec-13db0dbd9241")
    public GmRequirementPrimaryNode(IGmDiagram diagram, Requirement el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("4e818d81-979e-42cf-beed-7b6f9fa4409f")
    public GmRequirementPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("f6b3702e-a0e9-49c3-abde-afcef1ab925a")
    @Override
    public int getMajorVersion() {
        return GmRequirementPrimaryNode.MAJOR_VERSION;
    }

    @objid ("9eeb0c7a-3eb5-47bf-a97e-5af55e113bfb")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmRequirementPrimaryNode.");
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

    @objid ("e673c4fd-aaa7-46ae-b186-6df2c0335dba")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmRequirementPrimaryNode.", MINOR_VERSION);

    }

    @objid ("1de9bf4b-70e7-4e28-816f-ed3708dd53a5")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("d07bbdfe-07c0-41ce-b8b5-5972cb7875e7")
    GmRequirementPrimaryNode(final _GmRequirement oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("57f31b85-8e6f-4733-94ce-c883ef111a61")
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
