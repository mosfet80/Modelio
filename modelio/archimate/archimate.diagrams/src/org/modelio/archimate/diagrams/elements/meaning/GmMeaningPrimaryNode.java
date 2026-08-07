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
package org.modelio.archimate.diagrams.elements.meaning;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.meaning.v0._GmMeaning;
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Meaning}.
 */
@objid ("b2479d36-6887-434e-b845-8cf13c8db3cf")
public class GmMeaningPrimaryNode extends GmArchiElementPrimaryNode<Meaning> {
    @objid ("b3f86d55-5be1-4076-b925-866442b801c6")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("7b950670-0fff-49b6-a6d9-53ee053daded")
    private static final int MINOR_VERSION = 0;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Meaning is unmasked.
     * @param el the unmasked Meaning.
     * @param ref a reference to the unmasked Meaning.
     */
    @objid ("6705229f-16ab-4fe9-b178-5eae32ea0f1e")
    public GmMeaningPrimaryNode(IGmDiagram diagram, Meaning el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("f08f9731-1ad8-4442-96c2-7778b27aac43")
    public GmMeaningPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("cac45743-a84f-4e4f-a6b5-b6fad55033a7")
    @Override
    public int getMajorVersion() {
        return GmMeaningPrimaryNode.MAJOR_VERSION;
    }

    @objid ("2a99ef57-1510-4a0e-9795-fa3ec1066d6d")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmMeaningPrimaryNode.");
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

    @objid ("5232850e-e1d9-4dc4-8b24-4d2570292d59")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("056e1828-c837-40d7-af9e-a6ec5e8174a4")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmMeaningPrimaryNode.", MINOR_VERSION);

    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("cd8eb3ed-49aa-40ef-a35f-194c623c87fa")
    GmMeaningPrimaryNode(final _GmMeaning oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    @objid ("fa75d359-2ba4-458b-8b06-f071f3703047")
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
