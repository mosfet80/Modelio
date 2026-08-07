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
package org.modelio.archimate.diagrams.elements.andjunction;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.PositionConstants;
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
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
 * Specialization of the {@link GmPortContainer} class for {@link AndJunction}.
 */
@objid ("4afbdb08-f12d-4d7b-ab0a-e0a0d8142e35")
public class GmAndJunction extends GmPortContainer {
    @objid ("15934762-be41-471f-8888-34498a6e6a95")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm. Defaults to 0.
     */
    @objid ("01fa7ef8-148e-4893-9c9e-6b8d600e3d93")
    private static final int MINOR_VERSION = 0;

    @objid ("a9b16877-398b-47f3-808f-afdb7ce6a3c2")
    private static final GmAndJunctionSimpleStyleKeys SIMPLE_KEYS = new GmAndJunctionSimpleStyleKeys();

    @objid ("819b880c-1449-484d-85c8-d77973e3f4f1")
    private AndJunction element;

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the timeEvent is unmasked.
     * @param el the unmasked timeEvent.
     * @param ref a reference to the unmasked timeEvent.
     */
    @objid ("f262a0fb-0ab7-4425-8277-b63aa6d518ab")
    public GmAndJunction(IGmDiagram diagram, AndJunction el, MRef ref) {
        super(diagram, ref);

        GmAndJunctionPrimaryNode mainNode = new GmAndJunctionPrimaryNode(diagram, ref);
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
    @objid ("64303be9-e4f1-411c-be76-e551c3ead66f")
    public GmAndJunction() {
        // Nothing specific to do.
    }

    @objid ("4266dcaf-3f4d-4d64-a7ff-79fb5d80dba2")
    @Override
    public boolean canCreate(Class<? extends MObject> type) {
        return false;
    }

    @objid ("36de96ec-c451-4a2c-9c12-7e5b739f47d1")
    @Override
    public boolean canUnmask(MObject el) {
        return false;
    }

    @objid ("3e551476-fe32-4444-a807-d9199a085aa8")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("91dbd5ad-59e6-4954-9306-295db42d9e8b")
    @Override
    public MObject getRelatedElement() {
        return getRepresentedElement();
    }

    @objid ("e255908b-d08f-4d0f-bcf1-241e5ae0d546")
    @Override
    public MObject getRepresentedElement() {
        return this.element;
    }

    @objid ("c547ac8b-6a68-4dad-a286-6a33b0dae716")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        return SIMPLE_KEYS.getStyleKey(metakey);
    }

    @objid ("e633e41d-5b49-4c01-8212-bcd3a4346a03")
    @Override
    public List<StyleKey> getStyleKeys() {
        return SIMPLE_KEYS.getStyleKeys();
    }

    @objid ("4dfa7028-e273-493f-a718-6e2bcb3f2359")
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
    @objid ("d6a72430-c5ce-4024-8960-8428ead194a2")
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
    @objid ("5bb6bbe5-29fe-44a4-a865-d95a8db97a4b")
    @Override
    public boolean isSatellite(final GmNodeModel childNode) {
        return GmPortContainer.SATELLITE_ROLE.equals(childNode.getRoleInComposition());
    }

    @objid ("6b9a053f-cab4-4c70-8ccf-13bb0d3c3dd3")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmAndJunction.");
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

    @objid ("cf0ce718-5e3d-4123-a4eb-cdb08224507b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmAndJunction.", MINOR_VERSION);

    }

    @objid ("e030eb22-cf0d-4f6d-9d54-465cccfcc256")
    private void read_0(IDiagramReader in) {
        super.read(in);
        this.element = (AndJunction) resolveRef(getRepresentedRef());

    }

}
