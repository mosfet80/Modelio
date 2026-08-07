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
package org.modelio.archimate.diagrams.elements.capability;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.capability.v0._GmCapability;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.strategy.behavior.Capability;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Capability}.
 */
@objid ("2cb5b646-f61c-455e-a125-31f16bdd89ef")
public class GmCapability extends GmArchiElementPortContainer<Capability> {
    @objid ("f7fac5ca-6a33-445a-be8e-a228f4fb924b")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("9b5ad742-ff2c-4e6c-9a2c-67bdf656a6fb")
    private static final int MINOR_VERSION = 0;

    @objid ("e3e79fb7-2b26-4b7a-841d-e4878fc04a94")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmCapabilityImageStyleKeys();

    @objid ("9ba9b21d-7ed0-41d8-8271-3cc8ce24cd95")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmCapabilitySimpleStyleKeys();

    @objid ("0e196846-b68f-466a-87a6-bc4dece81a12")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmCapabilityStructuredStyleKeys();

    @objid ("93313b01-b316-496b-8a08-dc7d35285e77")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmCapabilityUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Capability is unmasked.
     * @param el the unmasked Capability.
     * @param ref a reference to the unmasked Capability.
     */
    @objid ("fc2b2678-52b9-43b2-b949-fa7ac82a67f1")
    public GmCapability(IGmDiagram diagram, Capability el, MRef ref) {
        super(diagram, el, ref);

        GmCapabilityPrimaryNode mainNode = new GmCapabilityPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("09f730e5-a5ff-45f8-a5bf-91b264d171c4")
    public GmCapability() {
        // Nothing specific to do.
    }

    @objid ("5300409a-8dc5-409b-8454-b35d4f7d45a6")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("b3650c5d-fce4-4c6f-bc9a-022a1a594f39")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("8052c9b6-9f72-4d28-9738-3d9610c40613")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("ce7b66d7-b4b5-48b9-8244-021d331f1f62")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmCapability.");
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

    @objid ("96e01d30-15fd-4ed8-9d14-8a5a37eda272")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmCapability.", MINOR_VERSION);

    }

    @objid ("30426e3b-96ce-4afc-af6f-1d0cc8f203d1")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("251cf693-3519-4fcd-b6b6-9c5875ece1d5")
    GmCapability(final _GmCapability oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmCapabilityPrimaryNode primary = new GmCapabilityPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

}
