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
package org.modelio.archimate.diagrams.elements.contract;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.contract.v0._GmContract;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Contract;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Contract}.
 */
@objid ("7bd52250-e6ff-4456-8872-3af419b47887")
public class GmContractPrimaryNode extends GmArchiElementPrimaryNode<Contract> {
    @objid ("6483e6a9-eb7e-4035-a151-9a4834105f83")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("a82858ca-b578-483b-8f94-8272255aef9b")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Contract is unmasked.
     * @param el the unmasked Contract.
     * @param ref a reference to the unmasked Contract.
     */
    @objid ("da5a4d61-7669-48ce-9bd0-c409a8ed61c2")
    public GmContractPrimaryNode(IGmDiagram diagram, Contract el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("579193f2-e2a7-4f3f-8993-fc1c24127c70")
    public GmContractPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("11bc7e71-8b3f-4ad8-9c9a-239b9108cf6a")
    @Override
    public int getMajorVersion() {
        return GmContractPrimaryNode.MAJOR_VERSION;
    }

    @objid ("26ceff1e-329c-4659-89fb-c50de4f2e7ac")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmContractPrimaryNode.");
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

    @objid ("7e8821bb-88ef-4f16-b557-a533156e6250")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmContractPrimaryNode.", GmContractPrimaryNode.MINOR_VERSION);

    }

    @objid ("50940583-967e-4e19-85ba-c945e5c0faf2")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("262a07f6-87a3-4209-9ede-d01d0633d6ea")
    GmContractPrimaryNode(final _GmContract oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("3ad6eea0-6765-4e96-a673-762775fa1720")
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
