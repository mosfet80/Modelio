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
package org.modelio.archimate.diagrams.elements.technologyfunction;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyfunction.v0._GmTechnologyFunction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyFunction}.
 */
@objid ("c9fe14ec-a9a3-4d54-80f0-49609fc89d47")
public class GmTechnologyFunctionPrimaryNode extends GmArchiElementPrimaryNode<TechnologyFunction> {
    @objid ("88568b87-7fe1-48df-9e58-c47b7d4f7ba3")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("16173b30-4094-4f64-9696-386879b9c957")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyFunction is unmasked.
     * @param el the unmasked TechnologyFunction.
     * @param ref a reference to the unmasked TechnologyFunction.
     */
    @objid ("ec3b15c0-506a-4040-85f8-57456fd9fa3b")
    public GmTechnologyFunctionPrimaryNode(IGmDiagram diagram, TechnologyFunction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("7e650f6e-4cbc-4aef-9276-454cd207df05")
    public GmTechnologyFunctionPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("9d260dd6-d338-4b8b-8b1d-1bc092b29365")
    @Override
    public int getMajorVersion() {
        return GmTechnologyFunctionPrimaryNode.MAJOR_VERSION;
    }

    @objid ("6bb60af6-047e-44f6-92e5-8cbc95cf7fc3")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyFunctionPrimaryNode.");
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

    @objid ("693060ea-60c5-462a-98a1-9d9af3183d1c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyFunctionPrimaryNode.", MINOR_VERSION);

    }

    @objid ("9ffa5ace-01b9-4bc1-98e1-4200fc09f09e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("f8aa8296-4d08-481f-ab9a-27f9dcd61a3c")
    GmTechnologyFunctionPrimaryNode(final _GmTechnologyFunction oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("06e18cdb-de76-4e53-8d2f-be57235b67a9")
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
