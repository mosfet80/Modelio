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
package org.modelio.archimate.diagrams.elements.orjunction;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.PositionConstants;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.diagram.elements.common.label.name.GmNameLabel;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialization of the {@link GmPortContainer} class for {@link OrJunction}.
 */
@objid ("384087fc-9b7b-4127-aec0-ef125f2f91ca")
public class GmOrJunction extends GmPortContainer {
    @objid ("524160c7-3db3-4d23-b8d8-37faec079cc3")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("30cadf61-71d7-4047-afd0-aa8d32bacec8")
    private static final int MINOR_VERSION = 0;

    @objid ("b11d5af5-60ac-4e09-b6f6-e56d71153816")
    private static final GmOrJunctionSimpleStyleKeys SIMPLE_KEYS = new GmOrJunctionSimpleStyleKeys();

    @objid ("4f823d55-ac4a-4c55-a5ec-0c23225963d3")
    private OrJunction element;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the timeEvent is unmasked.
     * @param el the unmasked timeEvent.
     * @param ref a reference to the unmasked timeEvent.
     */
    @objid ("9a8dce27-8f56-4350-b6a1-da3dea6ef50a")
    public GmOrJunction(IGmDiagram diagram, OrJunction el, MRef ref) {
        super(diagram, ref);

        GmOrJunctionPrimaryNode mainNode = new GmOrJunctionPrimaryNode(diagram, ref);
        mainNode.setRoleInComposition(MAIN_NODE_ROLE);
        this.addChild(mainNode);

        this.element = el;
        GmNameLabel label = new GmNameLabel(diagram, ref);
        label.setRoleInComposition(GmPortContainer.SATELLITE_ROLE);
        label.setLayoutData(Integer.valueOf(PositionConstants.SOUTH));
        this.addChild(label);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("e44ebf88-d789-4dd6-a563-78303174266a")
    public GmOrJunction() {
        // Nothing specific to do.
    }

    @objid ("0e665903-d62d-4a0c-bd6e-3e15d020cb0f")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return false;
    }

    @objid ("cdc0c036-4f41-4be4-b05c-5735968c372f")
    @Override
    public boolean canUnmask(MObject el) {
        return false;
    }

    @objid ("c58327a3-1275-45d2-8e31-92ed6e453181")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("fc2a0fd6-bb5c-425e-8efd-0d078dc6c407")
    @Override
    public MObject getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("e7703874-dc48-40af-bc1b-0ae0b0b556a7")
    @Override
    public MObject getRepresentedElement() {
        return this.element;
    }

    @objid ("4dddc753-76f8-440f-9b33-9ccfe9a45dde")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return SIMPLE_KEYS.getStyleKey(metakey);
    }

    @objid ("a99a6df2-613e-4c2c-b488-36534f5478ed")
    @Override
    public List<StyleKey> getStyleKeys() {
        return SIMPLE_KEYS.getStyleKeys();
    }

    @objid ("4785c3be-6441-4b02-9e36-40102e02c303")
    @Override
    public boolean isMainSatelliteLabel(GmNodeModel childNode) {
        String role = childNode.getRoleInComposition();
        return role.equals(SATELLITE_ROLE);
    }

    /**
     * Is this node a Port, which position is defined relatively to the Main Node's bounds.
     *
     * @param childNode the node to check.
     * @return <code>true</code> if the node is a Port.
     */
    @objid ("a048bc9e-1ecd-4338-af1c-dcc62c36e695")
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
    @objid ("ebb2b686-a434-4eac-92ab-f851181c6c67")
    @Override
    public boolean isSatellite(final GmNodeModel childNode) {
        return GmPortContainer.SATELLITE_ROLE.equals(childNode.getRoleInComposition());
    }

    @objid ("c8049451-f4c7-40e7-9f32-1e1dfd1bbece")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmOrJunction.");
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

    @objid ("2cf36475-7c5f-42dc-bf0b-598047116a0f")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmOrJunction.", MINOR_VERSION);

    }

    @objid ("3ee23070-98bd-4b75-b3d8-00cd9cea2670")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (OrJunction) resolveRef(getRepresentedRef());

    }

}
