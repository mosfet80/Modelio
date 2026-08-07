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
package org.modelio.archimate.diagrams.elements.node;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.node.v0._GmNode;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
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
 * Specialized class for {@link Node}.
 */
@objid ("c6880e06-af32-4f69-81a7-f97e2fed7dff")
public class GmNode extends GmArchiElementPortContainer<Node> {
    @objid ("90f2627c-3b81-4665-b591-6a2cf671b950")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("ce9d9a79-a1b4-45ed-bb48-f8a105bd6fe4")
    private static final int MINOR_VERSION = 0;

    @objid ("9482a709-5243-4be9-94c0-bb144126c415")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmNodeImageStyleKeys();

    @objid ("b7b2da08-29d4-4e32-b792-479ddc739bd2")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmNodeSimpleStyleKeys();

    @objid ("0062232d-5311-4184-817f-f49866bdde41")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmNodeStructuredStyleKeys();

    @objid ("63b12968-55f5-4020-bd2c-4292d4437e54")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmNodeUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Node is unmasked.
     * @param el the unmasked Node.
     * @param ref a reference to the unmasked Node.
     */
    @objid ("d64e65ee-ff43-4cc0-83b5-c2f57210ab6e")
    public GmNode(IGmDiagram diagram, Node el, MRef ref) {
        super(diagram, el, ref);

        GmNodePrimaryNode mainNode = new GmNodePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("166cbb18-3cb1-4d07-8b08-f82ab559b16e")
    GmNode(final _GmNode oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmNodePrimaryNode primary = new GmNodePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("c7a1760a-38b4-4ebd-bd65-734d086cdbe5")
    @Override
    public int getMajorVersion() {
        return GmNode.MAJOR_VERSION;
    }

    @objid ("df5b2504-fda1-4cfc-836d-cb48c72d201f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmNode.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmNode.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmNode.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmNode.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmNode.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("4856d822-ad66-48a3-9937-d6480f5e5c35")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmNode.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmNode.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmNode.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmNode.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmNode.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("949ba9da-c965-4acf-b264-dd0e65b1bbd3")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmNode.");
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

    @objid ("16e8b7ad-9c54-49b9-8fca-f76ffe02ecff")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmNode.", MINOR_VERSION);

    }

    @objid ("3656fc15-2018-421a-88f9-f196c821f49f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("b92d17fa-4ca4-427f-8c97-31bb82c6521e")
    public GmNode() {
        // Nothing specific to do.
    }

    @objid ("41d097d1-2a9b-45b3-91be-827948f3c7e8")
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
