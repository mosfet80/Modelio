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
package org.modelio.archimate.diagrams.elements.businessprocess;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessprocess.v0._GmBusinessProcess;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessProcess}.
 */
@objid ("fa3a4256-447d-47e2-89b2-d083608127c6")
public class GmBusinessProcessPrimaryNode extends GmArchiElementPrimaryNode<BusinessProcess> {
    @objid ("772f88bc-8c26-481c-b520-431dc1353a7f")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("a80182c0-ec1f-4bc3-b076-edf6420c8769")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessProcess is unmasked.
     * @param el the unmasked BusinessProcess.
     * @param ref a reference to the unmasked BusinessProcess.
     */
    @objid ("f809cfcd-8f73-44df-b5cb-9773c3da4c3d")
    public GmBusinessProcessPrimaryNode(IGmDiagram diagram, BusinessProcess el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("bcb86cb8-463d-43c2-9e42-027b3246b822")
    GmBusinessProcessPrimaryNode(final _GmBusinessProcess oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("d006c89c-16ca-4ff8-90d5-7a96faa08578")
    public GmBusinessProcessPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("83a886d0-d3f4-43c9-8fa4-e33f63997d97")
    @Override
    public int getMajorVersion() {
        return GmBusinessProcessPrimaryNode.MAJOR_VERSION;
    }

    @objid ("1f5638d4-165b-49b0-8e10-a34784111f4b")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessProcessPrimaryNode.");
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

    @objid ("21e7a6f1-d0ed-45c9-9a75-3ee65769b71f")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessProcessPrimaryNode.", GmBusinessProcessPrimaryNode.MINOR_VERSION);

    }

    @objid ("89f055ca-b7f6-4e92-b45e-6a7f6165069b")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("fbe61dc4-23f7-4885-bfba-dd9854844f47")
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
