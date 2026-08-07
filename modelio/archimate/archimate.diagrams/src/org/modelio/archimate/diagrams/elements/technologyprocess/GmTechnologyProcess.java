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
package org.modelio.archimate.diagrams.elements.technologyprocess;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.technologyprocess.v0._GmTechnologyProcess;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyProcess;
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
 * Specialized class for {@link TechnologyProcess}.
 */
@objid ("9f73191e-211c-4a39-8a4d-a3246b20a645")
public class GmTechnologyProcess extends GmArchiElementPortContainer<TechnologyProcess> {
    @objid ("5d13db43-afd0-4fdf-a1d2-5c2352d45c69")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("a5ec0c00-6d28-4ffe-9840-27bebda72d51")
    private static final int MINOR_VERSION = 0;

    @objid ("26b3702c-8c3c-468e-9021-270d38f74ab0")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyProcessImageStyleKeys();

    @objid ("aae058ef-dbc1-4ea4-a1a0-0a776cdaf24d")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyProcessSimpleStyleKeys();

    @objid ("323fb0c3-ae77-4da1-a37f-c5fa06d5de1f")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyProcessStructuredStyleKeys();

    @objid ("440139dc-58e3-4ac3-87bb-c537d1b5131a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyProcessUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyProcess is unmasked.
     * @param el the unmasked TechnologyProcess.
     * @param ref a reference to the unmasked TechnologyProcess.
     */
    @objid ("9a6f144e-8e0f-4c8a-ae31-781fcb7bd6aa")
    public GmTechnologyProcess(IGmDiagram diagram, TechnologyProcess el, MRef ref) {
        super(diagram, el, ref);

        GmTechnologyProcessPrimaryNode mainNode = new GmTechnologyProcessPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("30db1777-6822-442e-8539-713c43e8d5c8")
    GmTechnologyProcess(final _GmTechnologyProcess oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmTechnologyProcessPrimaryNode primary = new GmTechnologyProcessPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("9c629749-edcf-47fe-85f4-1e81ef8ec115")
    @Override
    public int getMajorVersion() {
        return GmTechnologyProcess.MAJOR_VERSION;
    }

    @objid ("350696e9-dedb-47fa-b737-56e31330ac25")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmTechnologyProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyProcess.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmTechnologyProcess.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmTechnologyProcess.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmTechnologyProcess.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("94c2beaa-0170-4079-93c2-b3472e5bd63d")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmTechnologyProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyProcess.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmTechnologyProcess.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmTechnologyProcess.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmTechnologyProcess.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("41a75a98-c41e-4982-8ba4-c7f23bd1c504")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyProcess.");
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

    @objid ("afa76449-4763-4384-a4d2-6de99a3ddea7")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyProcess.", MINOR_VERSION);

    }

    @objid ("43b2de33-c1ff-4c1a-9bb8-3d5a53632c86")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("409a74de-2f8c-43a8-bc6c-610ed7d6a601")
    public GmTechnologyProcess() {
        // Nothing specific to do.
    }

    @objid ("4fc55e9b-e288-4431-9d48-6f23a60977de")
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
