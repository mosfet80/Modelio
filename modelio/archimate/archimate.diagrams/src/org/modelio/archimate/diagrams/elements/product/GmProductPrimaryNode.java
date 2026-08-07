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
package org.modelio.archimate.diagrams.elements.product;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.product.v0._GmProduct;
import org.modelio.archimate.metamodel.layers.business.composite.Product;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Product}.
 */
@objid ("5c906533-df75-4131-973e-cf9a0dc785a3")
public class GmProductPrimaryNode extends GmArchiElementPrimaryNode<Product> {
    @objid ("da51903e-e1cd-4d61-94b0-7f0a311e8b6e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("d1183ff4-8507-4233-b7c7-68d75f0b5fdc")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Product is unmasked.
     * @param el the unmasked Product.
     * @param ref a reference to the unmasked Product.
     */
    @objid ("238f405b-e202-4f1d-bed4-208dd37a0ab5")
    public GmProductPrimaryNode(IGmDiagram diagram, Product el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("d3b30746-a3d3-49ec-83c0-c7342741c784")
    public GmProductPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("d20df86b-ebee-4ad5-8c35-dcc99ad07aa3")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("77bf6e53-7506-4854-ba2a-4c10522bbde2")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmProductPrimaryNode.");
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

    @objid ("cbbebaa3-154c-4eef-9b4d-99773a58893f")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmProductPrimaryNode.", MINOR_VERSION);

    }

    @objid ("19dc8abf-49bc-442d-9cc2-9e66b7b26955")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("e2732149-f4de-40e0-b445-2e4bc95e1ee5")
    GmProductPrimaryNode(final _GmProduct oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("e2264768-5a43-43a7-a57c-4e285ef77954")
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
