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
package org.modelio.archimate.diagrams.elements.businessfunction;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessfunction.v0._GmBusinessFunction;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessFunction}.
 */
@objid ("828143b4-0383-4f8c-9155-0f2d5a5c122f")
public class GmBusinessFunctionPrimaryNode extends GmArchiElementPrimaryNode<BusinessFunction> {
    @objid ("848fe7a0-7ba8-420a-a1e9-5ed84ca8a6cf")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("7d4f18f9-3080-4f2e-b5c1-fbd3508d52e2")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessFunction is unmasked.
     * @param el the unmasked BusinessFunction.
     * @param ref a reference to the unmasked BusinessFunction.
     */
    @objid ("a7185c65-cde1-4f60-98ac-9d3262601b2e")
    public GmBusinessFunctionPrimaryNode(IGmDiagram diagram, BusinessFunction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("d213e43e-6c5e-40b2-9485-a86125640337")
    GmBusinessFunctionPrimaryNode(final _GmBusinessFunction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a34b57b7-a503-4ce2-8445-bb9a8db60bf3")
    public GmBusinessFunctionPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("76e84f4c-3042-40b4-9bb9-d81273013e2c")
    @Override
    public int getMajorVersion() {
        return GmBusinessFunctionPrimaryNode.MAJOR_VERSION;
    }

    @objid ("ef74d650-295b-46c7-aae3-0e4e55bf9c81")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessFunctionPrimaryNode.");
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

    @objid ("6fcefb32-8869-4ca4-b8cf-5f004446864c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessFunctionPrimaryNode.", GmBusinessFunctionPrimaryNode.MINOR_VERSION);

    }

    @objid ("a3d875fc-8040-41a9-816f-4771e70c0069")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("dae9194a-258c-434c-b93f-42ed5fd55186")
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
