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
package org.modelio.archimate.diagrams.elements.value;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.value.v0._GmValue;
import org.modelio.archimate.metamodel.layers.motivation.Value;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Value}.
 */
@objid ("5ce1b73c-486b-40ea-acc7-0fb31d31f26b")
public class GmValuePrimaryNode extends GmArchiElementPrimaryNode<Value> {
    @objid ("6adf2e2d-3eb8-4597-b31f-e93d2c56a8d1")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("7a3832d0-c27e-41cb-abde-6b8a4026cdb4")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Value is unmasked.
     * @param el the unmasked Value.
     * @param ref a reference to the unmasked Value.
     */
    @objid ("d60133f3-a6a8-45f8-a484-dfa213ec7a83")
    public GmValuePrimaryNode(IGmDiagram diagram, Value el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1a33fc09-ac41-4946-97aa-4efe2dde9fc8")
    public GmValuePrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("1f3a9000-311f-41f0-9652-fff8d2ca716c")
    @Override
    public int getMajorVersion() {
        return GmValuePrimaryNode.MAJOR_VERSION;
    }

    @objid ("3038a4d3-4365-41f3-b849-c2fbd626af96")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmValuePrimaryNode.");
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

    @objid ("d7c5e374-ce30-48e6-a400-416640a49817")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmValuePrimaryNode.", MINOR_VERSION);

    }

    @objid ("de390d0e-7276-45ea-b1ad-af5374d03b8e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("8153c140-11d8-4298-9a44-c1ac0647cc4f")
    GmValuePrimaryNode(final _GmValue oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("afdaf2a2-f017-4cdf-bb06-4febffe32b7a")
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
