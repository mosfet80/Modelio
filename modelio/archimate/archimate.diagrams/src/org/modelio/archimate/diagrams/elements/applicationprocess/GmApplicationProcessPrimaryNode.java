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
package org.modelio.archimate.diagrams.elements.applicationprocess;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationprocess.v0._GmApplicationProcess;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationProcess}.
 */
@objid ("a2821d27-47df-406a-a5b1-feb6aff07417")
public class GmApplicationProcessPrimaryNode extends GmArchiElementPrimaryNode<ApplicationProcess> {
    @objid ("81fc3376-086e-4469-8d6e-649cbfba01b4")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("96493939-94bd-464c-b14b-1cd87656a2f1")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationProcess is unmasked.
     * @param el the unmasked ApplicationProcess.
     * @param ref a reference to the unmasked ApplicationProcess.
     */
    @objid ("9355ff57-987b-4677-938b-eeca8a5fbebc")
    public GmApplicationProcessPrimaryNode(IGmDiagram diagram, ApplicationProcess el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("588dde37-f8f0-43bd-86fd-89787ea046ac")
    GmApplicationProcessPrimaryNode(final _GmApplicationProcess oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3d241c48-6aa3-4b69-b5e6-9c850dbc7321")
    public GmApplicationProcessPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("9115946f-38f4-4802-b0a5-1e5ac6cb0646")
    @Override
    public int getMajorVersion() {
        return GmApplicationProcessPrimaryNode.MAJOR_VERSION;
    }

    @objid ("6e646c3b-0c45-443a-8455-410688e363d6")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationProcessPrimaryNode.");
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

    @objid ("f4207347-48a2-4497-90fe-1426b70c8d57")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationProcessPrimaryNode.", GmApplicationProcessPrimaryNode.MINOR_VERSION);

    }

    @objid ("fce2af48-878b-46d4-acf6-bc62b59ff55d")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("885ac3a1-6d7c-4a4b-a9f3-0fec39edb4a5")
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
