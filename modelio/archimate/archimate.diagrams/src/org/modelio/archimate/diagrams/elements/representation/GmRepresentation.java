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
package org.modelio.archimate.diagrams.elements.representation;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.representation.v0._GmRepresentation;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Representation;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
 * Specialized class for {@link Representation}.
 */
@objid ("a5ed4b19-c0ce-4943-9e84-319955366131")
public class GmRepresentation extends GmArchiElementPortContainer<Representation> {
    @objid ("8c1bb22a-e3a4-4a8c-a29f-9038b7b0d737")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("f9f7cd26-bcff-4e89-b1a8-2dab97ccbb20")
    private static final int MINOR_VERSION = 0;

    @objid ("cf711e37-7fe1-499f-8d81-fd778dd70353")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmRepresentationImageStyleKeys();

    @objid ("4f254e2b-91d5-48a1-a16a-ae1e4839ae7e")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmRepresentationSimpleStyleKeys();

    @objid ("44f43df5-cb53-4ca5-b535-da603e8d8d8f")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmRepresentationStructuredStyleKeys();

    @objid ("d16b1867-c482-404b-9daf-ea94e8f2cc98")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmRepresentationUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Representation is unmasked.
     * @param el the unmasked Representation.
     * @param ref a reference to the unmasked Representation.
     */
    @objid ("048f3421-262c-4ed1-855e-7ddf39fa9dd9")
    public GmRepresentation(IGmDiagram diagram, Representation el, MRef ref) {
        super(diagram, el, ref);

        GmRepresentationPrimaryNode mainNode = new GmRepresentationPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("05534635-59ec-4059-9b4a-b99bc51d25dc")
    GmRepresentation(final _GmRepresentation oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmRepresentationPrimaryNode primary = new GmRepresentationPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("b23a53ed-7a7e-4bbf-9162-4f1a66d36f50")
    @Override
    public int getMajorVersion() {
        return GmRepresentation.MAJOR_VERSION;
    }

    @objid ("eda82b5d-17fc-4886-af50-7d06ef790f95")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmRepresentation.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmRepresentation.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmRepresentation.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmRepresentation.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmRepresentation.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("930c2758-8601-4efb-aaaf-bb26a3d54a55")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmRepresentation.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmRepresentation.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmRepresentation.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmRepresentation.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmRepresentation.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("629bc92a-d4ac-4e76-8de0-e425bedb9637")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmRepresentation.");
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

    @objid ("8219a31a-ade5-43f0-88ed-ddcb921f251e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmRepresentation.", MINOR_VERSION);

    }

    @objid ("a55d4041-0f8a-43e0-bcb5-87da863139a4")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1ca00979-814b-4242-bb85-f866be8f01a7")
    public GmRepresentation() {
        // Nothing specific to do.
    }

    @objid ("7f15bb80-3cfe-4885-9270-bd8fe5f41185")
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
