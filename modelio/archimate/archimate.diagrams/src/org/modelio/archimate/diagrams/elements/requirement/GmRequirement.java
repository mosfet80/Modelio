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
package org.modelio.archimate.diagrams.elements.requirement;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.requirement.v0._GmRequirement;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
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
 * Specialized class for {@link Requirement}.
 */
@objid ("59303e60-4ff4-4f50-86d6-cfd9081e2cc6")
public class GmRequirement extends GmArchiElementPortContainer<Requirement> {
    @objid ("8904bb01-4716-4d05-acb7-0e7be67bad21")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("ccc586c0-368e-4ab0-9c68-cfb83aa32c02")
    private static final int MINOR_VERSION = 0;

    @objid ("25671e07-b65b-41c4-a686-947c25b6e768")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmRequirementImageStyleKeys();

    @objid ("76baa29c-3ec2-4775-9a5d-3d5e492b22fe")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmRequirementSimpleStyleKeys();

    @objid ("7a5254ff-6799-4898-af38-d998071248ec")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmRequirementStructuredStyleKeys();

    @objid ("08c88304-5b7c-4359-83d3-1f1ed70e1d09")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmRequirementUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Requirement is unmasked.
     * @param el the unmasked Requirement.
     * @param ref a reference to the unmasked Requirement.
     */
    @objid ("754340fa-d287-4721-9e3e-f1625e7a7a2a")
    public GmRequirement(IGmDiagram diagram, Requirement el, MRef ref) {
        super(diagram, el, ref);

        GmRequirementPrimaryNode mainNode = new GmRequirementPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("5e54ab74-2dc7-4e72-a518-f9844b632dc2")
    GmRequirement(final _GmRequirement oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmRequirementPrimaryNode primary = new GmRequirementPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("182744ca-dbbd-4657-994e-099fdc2ce835")
    @Override
    public int getMajorVersion() {
        return GmRequirement.MAJOR_VERSION;
    }

    @objid ("62cb3bc6-2ae7-4bf9-8fe3-f300e5754de6")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmRequirement.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmRequirement.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmRequirement.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmRequirement.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmRequirement.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("c2c189f7-07d1-4b82-9200-a993f0ce9733")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmRequirement.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmRequirement.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmRequirement.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmRequirement.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmRequirement.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("2a66a2f8-ccd1-4d1f-9f46-9eba786e8234")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmRequirement.");
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

    @objid ("daadb842-8ad2-4a9e-83f3-22aeba8071b9")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmRequirement.", MINOR_VERSION);

    }

    @objid ("bffc93eb-eab9-4b29-9a5d-29d245a22642")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a8eccd73-e877-4b7b-a698-8cc5057bb9ab")
    public GmRequirement() {
        // Nothing specific to do.
    }

    @objid ("aab0072f-acf9-4966-be1b-e6c8ff706b63")
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
