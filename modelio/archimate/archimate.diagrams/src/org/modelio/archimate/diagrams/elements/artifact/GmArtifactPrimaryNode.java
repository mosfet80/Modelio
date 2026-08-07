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
package org.modelio.archimate.diagrams.elements.artifact;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.artifact.v0._GmArtifact;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

@objid ("3994e10f-e61d-438c-a0db-7bf2af124780")
public class GmArtifactPrimaryNode extends GmArchiElementPrimaryNode<Artifact> {
    @objid ("98f81d5c-28f4-484e-abe3-d0d70ce089f7")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("8f05eb1d-19f1-4188-a771-d0224adb2d72")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Artifact is unmasked.
     * @param el the unmasked Artifact.
     * @param ref a reference to the unmasked Artifact.
     */
    @objid ("ecee04d3-ca68-42f8-ab76-ce54177852b6")
    public GmArtifactPrimaryNode(IGmDiagram diagram, Artifact el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("6a1c6823-d144-4722-bcaa-6a88c3c735b0")
    public GmArtifactPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("8ca80cc3-668a-411d-ae71-19fceddceca2")
    @Override
    public int getMajorVersion() {
        return GmArtifactPrimaryNode.MAJOR_VERSION;
    }

    @objid ("78f46398-2d66-459e-98a6-29d4cbab6e63")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmArtifactPrimaryNode.");
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

    @objid ("0800679c-8ae3-43f7-98da-06b53ac4ec01")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmArtifactPrimaryNode.", GmArtifactPrimaryNode.MINOR_VERSION);

    }

    @objid ("83dbd189-05ce-4fb2-a441-8100225a294b")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("b20ef1c5-5273-472d-81ac-1d846b2f2db2")
    GmArtifactPrimaryNode(final _GmArtifact oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("7771f14b-cf76-4c7e-92b6-c03016b7fec7")
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
