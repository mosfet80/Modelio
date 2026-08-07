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
package org.modelio.archimate.diagrams.elements.implementationevent;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.implementationevent.v0._GmImplementationEvent;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.ImplementationEvent;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link ImplementationEvent}.
 */
@objid ("4389fd4c-135c-480a-9ecb-0651a42fa44c")
public class GmImplementationEvent extends GmArchiElementPortContainer<ImplementationEvent> {
    @objid ("a9b6ee1d-1276-4b69-a033-d3bd6e5e2e43")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("88b7df4d-7979-4352-a5fa-3e0b6d33da4b")
    private static final int MINOR_VERSION = 0;

    @objid ("68a23d0a-5ab2-488f-89d6-02adf1d43bad")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmImplementationEventImageStyleKeys();

    @objid ("84ebc34d-36f8-4a71-8ddd-055af1e000e5")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmImplementationEventSimpleStyleKeys();

    @objid ("58198d5b-5ef8-43eb-80df-7467091cc1aa")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmImplementationEventStructuredStyleKeys();

    @objid ("2fd789f0-b5b6-4cdd-be7d-1d4b80bf7398")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmImplementationEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ImplementationEvent is unmasked.
     * @param el the unmasked ImplementationEvent.
     * @param ref a reference to the unmasked ImplementationEvent.
     */
    @objid ("0bf096fe-a3d7-4c2c-9116-9a800f6617c6")
    public GmImplementationEvent(IGmDiagram diagram, ImplementationEvent el, MRef ref) {
        super(diagram, el, ref);
        GmImplementationEventPrimaryNode mainNode = new GmImplementationEventPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("79f7336a-06d8-429a-8876-67cf6cf8150e")
    public GmImplementationEvent() {
        // Nothing specific to do.
    }

    @objid ("a439c136-1503-4829-bff5-326a8235bf67")
    @Override
    public int getMajorVersion() {
        return GmImplementationEvent.MAJOR_VERSION;
    }

    @objid ("741b3b6a-5755-426b-b6a1-df9ad6cff796")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmImplementationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmImplementationEvent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmImplementationEvent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmImplementationEvent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmImplementationEvent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("e852cfa2-ec05-4f07-bc01-aafc3a504ee1")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmImplementationEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmImplementationEvent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmImplementationEvent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmImplementationEvent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmImplementationEvent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("443079a6-82b2-4575-ab52-86997cad30cb")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmImplementationEvent.");
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

    @objid ("760913b8-d731-403e-b3a5-51ab2d004e45")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmImplementationEvent.", GmImplementationEvent.MINOR_VERSION);

    }

    @objid ("616f9020-44a5-457b-9c82-b151632ed2ac")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("fd4579cc-0bd7-4607-b964-06ba8153cad4")
    GmImplementationEvent(final _GmImplementationEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmImplementationEventPrimaryNode primary = new GmImplementationEventPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("2447f260-4026-4eaa-b34c-b6508f49a58c")
    @Override
    public List<GmNodeModel> getVisibleChildren() {
        List<GmNodeModel> ret = super.getVisibleChildren();

        GmNodeModel firstChild = getMainNode();
        if (firstChild != null && firstChild.getRepresentationMode() == RepresentationMode.SIMPLE) {
            // In simple mode, remove the floating label: a proper label is provider by the primary node
            ret.remove(getFirstChild(GmPortContainer.SATELLITE_ROLE));
        }
        return ret;
    }

}
