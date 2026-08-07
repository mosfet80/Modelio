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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationcomponent.v0._GmApplicationComponent;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ApplicationComponent}.
 */
@objid ("2e006d64-7790-4473-8da6-56dc74e79342")
public class GmApplicationComponentPrimaryNode extends GmArchiElementPrimaryNode<ApplicationComponent> {
    @objid ("1f5ec85f-0b33-4ae6-a371-e22911cefbf4")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("3c4ebe40-80c0-4efb-a580-7529cfaaffd7")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationComponent is unmasked.
     * @param el the unmasked ApplicationComponent.
     * @param ref a reference to the unmasked ApplicationComponent.
     */
    @objid ("92f64a0d-d166-457e-88e5-f22a4d351c22")
    public GmApplicationComponentPrimaryNode(IGmDiagram diagram, ApplicationComponent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("dea17b8a-da5d-4101-8fca-2da73211770b")
    GmApplicationComponentPrimaryNode(final _GmApplicationComponent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("fcb60865-f09e-44f9-bd06-8fa889899092")
    public GmApplicationComponentPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("83f78801-d13b-4227-af96-46bae1a8f1ee")
    @Override
    public int getMajorVersion() {
        return GmApplicationComponentPrimaryNode.MAJOR_VERSION;
    }

    @objid ("f85dfdc1-876f-4dbc-80c0-cb620f6fe3aa")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationComponentPrimaryNode.");
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

    @objid ("ac747ff4-334b-45ce-9ae6-251c1fc4ff44")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationComponentPrimaryNode.", GmApplicationComponentPrimaryNode.MINOR_VERSION);

    }

    @objid ("72e437b5-33eb-410f-8e8f-a568e2ef4040")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("cd506b2a-2219-4bff-90fc-ee362b268da4")
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
