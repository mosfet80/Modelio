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
package org.modelio.archimate.diagrams.elements.gap;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.gap.v0._GmGap;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link Gap}.
 */
@objid ("296ac905-0470-4913-844a-1bc65fe8956c")
public class GmGap extends GmArchiElementPortContainer<Gap> {
    @objid ("892355da-1d82-4c4d-aaf3-916c19e6bf2a")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("7f0d0fd9-0742-4b39-a618-c821e833ba51")
    private static final int MINOR_VERSION = 0;

    @objid ("f6ff0ea2-5c0e-496a-912b-9aa89f923f20")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmGapImageStyleKeys();

    @objid ("856f3613-016c-4bca-8fa2-32dcfd261883")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmGapSimpleStyleKeys();

    @objid ("b6020bcc-7622-42fd-9e34-2906036f8c22")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmGapStructuredStyleKeys();

    @objid ("83524b8b-520f-4c3c-aca3-3dc2a5d1528f")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmGapUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Gap is unmasked.
     * @param el the unmasked Gap.
     * @param ref a reference to the unmasked Gap.
     */
    @objid ("ce5b127b-866a-4901-86bb-16251fa45152")
    public GmGap(IGmDiagram diagram, Gap el, MRef ref) {
        super(diagram, el, ref);

        GmGapPrimaryNode mainNode = new GmGapPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("edde4a39-d3ad-41ea-a8c0-de5b446ae382")
    public GmGap() {
        // Nothing specific to do.
    }

    @objid ("88114490-22be-493d-8260-a8fa5d65c710")
    @Override
    public int getMajorVersion() {
        return GmGap.MAJOR_VERSION;
    }

    @objid ("2c91bb02-8ce1-4c49-b6ac-41ac5fe5c02d")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmGap.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmGap.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmGap.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmGap.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmGap.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("ff3af671-e8a2-417b-8b1f-ad5e6363ba4c")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmGap.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmGap.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmGap.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmGap.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmGap.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("15eab74f-ed2b-4218-8e6e-75808bf362a2")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmGap.");
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

    @objid ("86274396-827b-4f43-9bfe-c9fdb754cd00")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmGap.", GmGap.MINOR_VERSION);

    }

    @objid ("829c93e8-4df4-4d48-82b2-f9df3f0f1301")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("38d4a19e-b5cb-4b6c-92cc-54918bd069ae")
    GmGap(final _GmGap oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmGapPrimaryNode primary = new GmGapPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

}
