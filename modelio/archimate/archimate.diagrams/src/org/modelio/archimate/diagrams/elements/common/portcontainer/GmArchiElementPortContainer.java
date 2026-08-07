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
package org.modelio.archimate.diagrams.elements.common.portcontainer;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.PositionConstants;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.diagram.elements.common.label.modelelement.GmDefaultModelElementLabel;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialization of the {@link GmPortContainer} class for an Archimate {@link Element}.
 *
 * @param <T> metaclass of the element represented by this Gm.
 */
@objid ("b198a6a7-1c8b-4921-891f-7f49e4de1ea5")
public abstract class GmArchiElementPortContainer<T extends Element> extends GmPortContainer {
    @objid ("dcfa5213-8704-4ce7-a8e4-b1a1f325125c")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("d9b35d52-0fac-4638-9c26-c051a3f5e690")
    private static final int MINOR_VERSION = 0;

    @objid ("5e274c24-215f-48c8-8cab-47c8d1a0c122")
    private T element;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the T is unmasked.
     * @param el the unmasked T.
     * @param ref a reference to the unmasked T.
     */
    @objid ("f2dfebbb-b26b-4664-ad8c-68372144f6ee")
    public GmArchiElementPortContainer(IGmDiagram diagram, T el, MRef ref) {
        super(diagram, ref);

        this.element = el;

        final GmDefaultModelElementLabel mainLabel = new GmDefaultModelElementLabel(diagram, ref);
        mainLabel.setRoleInComposition(GmPortContainer.SATELLITE_ROLE);
        mainLabel.setLayoutData(Integer.valueOf(PositionConstants.SOUTH));

        addChild(mainLabel);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("6ffd0005-b36d-44e3-b239-b3f5b2808b98")
    public GmArchiElementPortContainer() {
        // Nothing specific to do.
    }

    @objid ("a9b5bd2b-3cd3-4180-b48e-272ace6f2d5c")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return false;
    }

    @objid ("5511c111-9486-4956-975e-48e839643b22")
    @Override
    public boolean canUnmask(MObject el) {
        return false;
    }

    @objid ("901a694c-4723-45c9-9205-8ca7d3525444")
    @Override
    public int getMajorVersion() {
        return GmArchiElementPortContainer.MAJOR_VERSION;
    }

    @objid ("a0b1a0f2-2544-46dd-b9a7-37e6fce31b3e")
    @Override
    public MObject getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("5a41ff1b-a68d-440d-ad9b-386393b7389b")
    @Override
    public MObject getRepresentedElement() {
        return this.element;
    }

    @objid ("8526c5ce-a840-48cd-83b5-12c029e87dfa")
    @Override
    public boolean isMainSatelliteLabel(GmNodeModel childNode) {
        String role = childNode.getRoleInComposition();
        return role.equals(GmPortContainer.SATELLITE_ROLE);
    }

    /**
     * Is this node a Port, which position is defined relatively to the Main Node's bounds.
     *
     * @param childNode the node to check.
     * @return <code>true</code> if the node is a Port.
     */
    @objid ("79a7d200-fa2c-4085-a2f7-8b7e99f50bb3")
    @Override
    public boolean isPort(final GmNodeModel childNode) {
        return GmPortContainer.PORT_ROLE.equals(childNode.getRoleInComposition());
    }

    /**
     * Is this node a Satellite, which position is defined relatively to the Main Node's bounds.
     *
     * @param childNode the node to check.
     * @return <code>true</code> if the node is a Satellite.
     */
    @objid ("b95a8cdf-3a23-48f8-a464-d2a2d589f086")
    @Override
    public boolean isSatellite(final GmNodeModel childNode) {
        return GmPortContainer.SATELLITE_ROLE.equals(childNode.getRoleInComposition());
    }

    @objid ("2315c562-acc6-4d26-a8da-0d6ff221cc0e")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmArchiElementPortContainer.");
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

    @objid ("811d741a-d3bc-47ff-8d8f-f1cfb4b7a6be")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmArchiElementPortContainer.", GmArchiElementPortContainer.MINOR_VERSION);

    }

    @objid ("c44b92ed-b1ae-48e4-bcfe-8fb90eaea1ac")
    @SuppressWarnings ("unchecked")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (T) resolveRef(getRepresentedRef());

    }

    @objid ("79dc98d5-43c2-4405-8068-e129a29a5e01")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        // Returned result depends on current representation mode of the main node:
        GmNodeModel firstChild = getMainNode();
        if (firstChild != null && firstChild.getRepresentationMode() == RepresentationMode.STRUCTURED) {
            List<GmNodeModel> ret = new ArrayList<>(1);
            ret.add(firstChild);
            return ret;
        }
        return super.getVisibleChildren();
    }

}
