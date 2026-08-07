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
package org.modelio.archimate.diagrams.elements.meaning;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.meaning.v0._GmMeaning;
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
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
 * Specialized class for {@link Meaning}.
 */
@objid ("6951c2ff-e016-489e-bba1-587a8b993a70")
public class GmMeaning extends GmArchiElementPortContainer<Meaning> {
    @objid ("27ae182c-f93b-46e6-9056-9cc0cf0556ae")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("2790a51e-8866-49b5-bf94-bc7f31125ad1")
    private static final int MINOR_VERSION = 0;

    @objid ("e381610d-7628-4213-81c2-655fb2dfbf61")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmMeaningImageStyleKeys();

    @objid ("7a56c339-f1c6-495d-9d7b-5ef21295e021")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmMeaningSimpleStyleKeys();

    @objid ("59e9c060-65f4-4da6-a1bc-d00db51353ec")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmMeaningStructuredStyleKeys();

    @objid ("d520f06f-03f1-41c9-af49-7fa9f98d3384")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmMeaningUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Meaning is unmasked.
     * @param el the unmasked Meaning.
     * @param ref a reference to the unmasked Meaning.
     */
    @objid ("b484c12f-0a64-4c6f-8b66-f663c89b4a7f")
    public GmMeaning(IGmDiagram diagram, Meaning el, MRef ref) {
        super(diagram, el, ref);

        GmMeaningPrimaryNode mainNode = new GmMeaningPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("e877a149-c372-44fa-bc35-09e63f15ce50")
    GmMeaning(final _GmMeaning oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmMeaningPrimaryNode primary = new GmMeaningPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("547e7ceb-2f53-4c33-9e4b-f9bc377836c6")
    @Override
    public int getMajorVersion() {
        return GmMeaning.MAJOR_VERSION;
    }

    @objid ("34a8416c-873e-419f-8314-deb39641a8d2")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmMeaning.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmMeaning.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmMeaning.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmMeaning.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmMeaning.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("e64e98d3-e57a-4959-8970-db88063a90d8")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmMeaning.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmMeaning.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmMeaning.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmMeaning.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmMeaning.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("8a597f18-2365-41b4-b315-ed2817123a9a")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmMeaning.");
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

    @objid ("5d4ab388-1881-40a5-beb0-a64a5c907f15")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("815a226d-fd9a-40c5-a513-4419d4f5566c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmMeaning.", MINOR_VERSION);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("aed47193-addb-4f2f-8c19-cce7ae94d3de")
    public GmMeaning() {
        // Nothing specific to do.
    }

    @objid ("9935ec32-f4f2-45e5-b81c-6c42fc5092d1")
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
