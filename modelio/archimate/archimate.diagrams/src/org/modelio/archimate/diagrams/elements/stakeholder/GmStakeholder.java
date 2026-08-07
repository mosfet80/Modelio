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
package org.modelio.archimate.diagrams.elements.stakeholder;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.stakeholder.v0._GmStakeholder;
import org.modelio.archimate.metamodel.layers.motivation.Stakeholder;
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
 * Specialized class for {@link Stakeholder}.
 */
@objid ("c3ca9a13-809a-4457-9c9a-1fcd6023dde1")
public class GmStakeholder extends GmArchiElementPortContainer<Stakeholder> {
    @objid ("0325a5d8-3384-4fbe-8ae9-a270f54b2f93")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("a60ebd87-6c5f-46ed-94bd-f93bbf274831")
    private static final int MINOR_VERSION = 0;

    @objid ("cfc6c7d2-f2f2-4d0d-81cb-561a240f7cbb")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmStakeholderImageStyleKeys();

    @objid ("e6a2ed5b-05bb-4e13-9832-b1a18ae57d72")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmStakeholderSimpleStyleKeys();

    @objid ("983b8873-aee4-4768-b71a-bcf56bfe7359")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmStakeholderStructuredStyleKeys();

    @objid ("716be8f7-6599-4a58-b87f-93087ea166ad")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmStakeholderUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Stakeholder is unmasked.
     * @param el the unmasked Stakeholder.
     * @param ref a reference to the unmasked Stakeholder.
     */
    @objid ("b84cb383-af3f-4213-a904-ab44f29be446")
    public GmStakeholder(IGmDiagram diagram, Stakeholder el, MRef ref) {
        super(diagram, el, ref);

        GmStakeholderPrimaryNode mainNode = new GmStakeholderPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("b192810c-00e3-4071-b051-36812c12e51b")
    GmStakeholder(final _GmStakeholder oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmStakeholderPrimaryNode primary = new GmStakeholderPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("82c54fae-1c28-456b-b13c-57150a45bbc6")
    public GmStakeholder() {
        // Nothing specific to do.
    }

    @objid ("ce0981a1-2e8b-4588-9906-18a3958b3fc9")
    @Override
    public int getMajorVersion() {
        return GmStakeholder.MAJOR_VERSION;
    }

    @objid ("e670724d-42b1-4dea-bf0f-e492533f92c6")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmStakeholder.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmStakeholder.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmStakeholder.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmStakeholder.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmStakeholder.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("97bc697e-b5b5-497f-96d6-44d048abc8a2")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmStakeholder.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmStakeholder.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmStakeholder.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmStakeholder.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmStakeholder.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("9d528143-42a9-4edd-9552-b81e1f508348")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmStakeholder.");
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

    @objid ("b9b486e2-9ae4-41e8-8510-4390918b8fe1")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmStakeholder.", MINOR_VERSION);

    }

    @objid ("84801a27-0557-4ae9-a8fd-20539ce5b450")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("a9e4a582-06b3-4981-952c-d328496ad6b1")
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
