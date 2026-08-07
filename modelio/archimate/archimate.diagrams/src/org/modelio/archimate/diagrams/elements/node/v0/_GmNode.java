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
package org.modelio.archimate.diagrams.elements.node.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.node.GmNodeImageStyleKeys;
import org.modelio.archimate.diagrams.elements.node.GmNodeSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.node.GmNodeStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.node.GmNodeUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.diagram.elements.core.model.IGmDiagram;
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
@objid ("fc7f5a2e-d20d-4b73-8cca-e10dc397e574")
public class _GmNode extends GmArchiElement<Node> {
    @objid ("d09dc22d-0fee-4f79-a18c-b01d3f845b1b")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("35aec6c4-0388-4af8-9ed4-c9f7e2fc7744")
    private static final int MINOR_VERSION = 0;

    @objid ("4fbf2eb1-0bb8-485d-a662-ef93fd9c05ea")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmNodeImageStyleKeys();

    @objid ("b533f2e4-1377-4407-a166-17a2b8ef597a")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmNodeSimpleStyleKeys();

    @objid ("cc3d06f9-dd55-498d-87c1-b61c44fbfa3a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmNodeStructuredStyleKeys();

    @objid ("b5059471-5772-455a-9c7d-6207fb6d4eb4")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmNodeUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Node is unmasked.
     * @param el the unmasked Node.
     * @param ref a reference to the unmasked Node.
     */
    @objid ("9f579a3c-7dc5-4f9f-adad-c1064ddc4d4c")
    public _GmNode(IGmDiagram diagram, Node el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3701939b-702a-4bce-b911-244eeff1e192")
    public _GmNode() {
        // Nothing specific to do.
    }

    @objid ("225537a8-6b3d-439b-9057-f6928ac5b54b")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("8b6b4ad6-71ce-4d13-a08d-61c18a5a154f")
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

    @objid ("cb235c6f-838e-4848-976f-e54e831b8ac1")
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

    @objid ("8cc633bf-f03d-4686-ac76-61b9f3972564")
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

    @objid ("fef8e875-4517-461b-ab59-804f8d30e1b1")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmNode.", MINOR_VERSION);

    }

    @objid ("12721135-ea3f-4be2-a0ec-b828a692d4d5")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
