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
package org.modelio.archimate.diagrams.elements.businessobject;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessobject.v0._GmBusinessObject;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link BusinessObject}.
 */
@objid ("2e623e9c-f150-48d1-9285-0f25c4d17d9f")
public class GmBusinessObjectPrimaryNode extends GmArchiElementPrimaryNode<BusinessObject> {
    @objid ("fe9f2837-9b5d-4491-8889-9b3b2c1b4dba")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     * <p>
     * History:
     * <ul>
     * <li>0 : initial
     * <li>1 : same as zero, should have stayed to zero but can't rollback now 3.7 is released.
     * </ul>
     */
    @objid ("e5e283f1-c4be-4b58-b632-f2b813d449ed")
    private static final int MINOR_VERSION = 1;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessObject is unmasked.
     * @param el the unmasked BusinessObject.
     * @param ref a reference to the unmasked BusinessObject.
     */
    @objid ("2a9dc891-a100-404c-aea4-72e6c07eab15")
    public GmBusinessObjectPrimaryNode(IGmDiagram diagram, BusinessObject el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Migration constructor.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("566741b9-f34c-41b4-814c-3ccf235ba626")
    GmBusinessObjectPrimaryNode(final _GmBusinessObject oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRepresentedElement(), oldVersionGm.getRepresentedRef(), oldVersionGm.getHeader(), oldVersionGm.getBody());
        this.header.setShowMetaclassIcon(oldVersionGm.getHeader().isShowMetaclassIcon());

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("732568c6-57d2-4f48-8ebd-b3642939f977")
    public GmBusinessObjectPrimaryNode() {
        // Nothing specific to do.
    }

    @objid ("cd675509-4fda-4cb4-9ea7-0ba62031a1ad")
    @Override
    public int getMajorVersion() {
        return GmBusinessObjectPrimaryNode.MAJOR_VERSION;
    }

    @objid ("7e9651d5-f457-464e-8915-e8b5a6e03631")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessObjectPrimaryNode.");
        switch (readVersion) {
        case 0:
        case 1:
            // version was wrongly at 1 instead of 0.
            read_0(in);
            break;

        default:
            assert (false) : readVersion + " version number not covered!";
            // reading as last handled version: 0
            read_0(in);
            break;

        }

    }

    @objid ("5ecda803-d8aa-4583-b476-230bd3cac487")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessObjectPrimaryNode.", GmBusinessObjectPrimaryNode.MINOR_VERSION);

    }

    @objid ("a013fb6d-78b1-4483-8722-bf3221c5628a")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("d6484153-3984-4d97-9433-bc219247bec3")
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
