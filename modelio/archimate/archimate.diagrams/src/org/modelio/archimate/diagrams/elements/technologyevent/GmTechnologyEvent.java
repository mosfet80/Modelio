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
package org.modelio.archimate.diagrams.elements.technologyevent;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.technologyevent.v0._GmTechnologyEvent;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyEvent;
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
 * Specialized class for {@link TechnologyEvent}.
 */
@objid ("31e33d99-73a2-4e77-9808-eb0759824a60")
public class GmTechnologyEvent extends GmArchiElementPortContainer<TechnologyEvent> {
    @objid ("1e7cc71d-903e-4f2e-9d05-58bb384357ce")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("d9d01341-7996-4ba2-8036-431d48a7202b")
    private static final int MINOR_VERSION = 0;

    @objid ("e4922c53-f43f-4782-b864-1b49e1bc1531")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyEventImageStyleKeys();

    @objid ("d4e9e413-4b8c-418d-97e8-6ec2754e4ee5")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyEventSimpleStyleKeys();

    @objid ("008309bc-1a32-4409-8993-823227962034")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyEventStructuredStyleKeys();

    @objid ("1d3d6720-dcbf-44eb-a019-117e191f6c07")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyEvent is unmasked.
     * @param el the unmasked TechnologyEvent.
     * @param ref a reference to the unmasked TechnologyEvent.
     */
    @objid ("a6585248-8a4b-477e-a837-5dd237c5dc3d")
    public GmTechnologyEvent(IGmDiagram diagram, TechnologyEvent el, MRef ref) {
        super(diagram, el, ref);

        GmTechnologyEventPrimaryNode mainNode = new GmTechnologyEventPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("c6dc5464-1fa8-495f-8df1-d2b862e785db")
    GmTechnologyEvent(final _GmTechnologyEvent oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmTechnologyEventPrimaryNode primary = new GmTechnologyEventPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("64f4bbc2-138f-4747-b796-e7337ff5db6e")
    @Override
    public int getMajorVersion() {
        return GmTechnologyEvent.MAJOR_VERSION;
    }

    @objid ("8530a367-395b-4e0c-8eed-010c0ba5bbfe")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmTechnologyEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyEvent.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmTechnologyEvent.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmTechnologyEvent.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmTechnologyEvent.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("d5a53af1-cf06-4642-a2ca-e916749e6d7d")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmTechnologyEvent.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmTechnologyEvent.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmTechnologyEvent.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmTechnologyEvent.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmTechnologyEvent.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("f72f0eaa-0c9d-4b0a-9c12-7c77b224c5c1")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyEvent.");
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

    @objid ("4af659d2-3be6-4b49-a0d9-a98b69a733d0")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyEvent.", MINOR_VERSION);

    }

    @objid ("b74a390f-7ba1-4d78-a98b-4a9d2754ee3c")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("7decee3d-e8b5-47ff-96ce-d3efc35205fb")
    public GmTechnologyEvent() {
        // Nothing specific to do.
    }

    @objid ("4919b7f9-56e2-4dd4-8d99-f9c022e50b72")
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
