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
package org.modelio.archimate.diagrams.elements.applicationfunction;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationfunction.v0._GmApplicationFunction;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationFunction}.
 */
@objid ("6389915d-4fd3-4a4b-aaaa-47f35e10fdea")
public class GmApplicationFunctionPrimaryNode extends GmArchiElementPrimaryNode<ApplicationFunction> {
    @objid ("4ce05fdb-f78b-4d99-b80e-ba33bf5a1d5e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("d7c6e670-a1d3-4da6-8087-970585a679d0")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationFunction is unmasked.
     * @param el the unmasked ApplicationFunction.
     * @param ref a reference to the unmasked ApplicationFunction.
     */
    @objid ("5b5b8bd7-93fe-4c04-a5ad-7318669446dc")
    public GmApplicationFunctionPrimaryNode(IGmDiagram diagram, ApplicationFunction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("ed6ab615-5004-49ad-bc88-c3dcdeca3f56")
    GmApplicationFunctionPrimaryNode(final _GmApplicationFunction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("4063f608-bbe7-4fa2-ae51-afe5589de491")
    public GmApplicationFunctionPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("5291e9b9-9891-4b44-ad8f-7f16fd7bd673")
    @Override
    public int getMajorVersion() {
        return GmApplicationFunctionPrimaryNode.MAJOR_VERSION;
    }

    @objid ("001fb7de-1488-4761-8499-443fc97c1472")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationFunctionPrimaryNode.");
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

    @objid ("d8578ed3-2532-4048-80c6-c9da1372e3c8")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationFunctionPrimaryNode.", GmApplicationFunctionPrimaryNode.MINOR_VERSION);

    }

    @objid ("4681c052-876f-44c2-865e-98609ac7c356")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("b23a9b9a-c613-47ee-82cc-9b2546feef55")
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
