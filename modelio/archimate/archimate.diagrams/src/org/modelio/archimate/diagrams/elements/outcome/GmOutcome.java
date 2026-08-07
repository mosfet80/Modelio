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
package org.modelio.archimate.diagrams.elements.outcome;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.outcome.v0._GmOutcome;
import org.modelio.archimate.metamodel.layers.motivation.Outcome;
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
 * Specialized class for {@link Outcome}.
 */
@objid ("601d60cc-20fb-4922-8146-3d82a5e6cf66")
public class GmOutcome extends GmArchiElementPortContainer<Outcome> {
    @objid ("3149e9ee-2f67-4ed6-ab1e-402262b0266b")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("b4f9d80d-3c5e-48d1-8319-136adc9ad0a4")
    private static final int MINOR_VERSION = 0;

    @objid ("22bc4887-1bc1-47e4-9c54-ce544ebd7260")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmOutcomeImageStyleKeys();

    @objid ("e5923a83-4454-4e56-8aac-cd683fefeb44")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmOutcomeSimpleStyleKeys();

    @objid ("92af69d4-25d8-4d32-8486-6f3587c8297d")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmOutcomeStructuredStyleKeys();

    @objid ("3708d5fd-8f51-40e8-bcd9-aa08e966233e")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmOutcomeUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Outcome is unmasked.
     * @param el the unmasked Outcome.
     * @param ref a reference to the unmasked Outcome.
     */
    @objid ("7c32df0a-f452-4a9d-8260-5819f77224ba")
    public GmOutcome(IGmDiagram diagram, Outcome el, MRef ref) {
        super(diagram, el, ref);

        GmOutcomePrimaryNode mainNode = new GmOutcomePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("ce190fd6-2e08-47c9-98eb-e18075048ce7")
    GmOutcome(final _GmOutcome oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmOutcomePrimaryNode primary = new GmOutcomePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("677f7c23-1661-4a43-abe8-fcba1d0b8826")
    @Override
    public int getMajorVersion() {
        return GmOutcome.MAJOR_VERSION;
    }

    @objid ("293f8474-2e1a-447f-bc5f-ad8647926b5a")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmOutcome.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmOutcome.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmOutcome.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmOutcome.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmOutcome.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("a79c890d-2bfb-4b5f-a91d-4c15c642db92")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmOutcome.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmOutcome.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmOutcome.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmOutcome.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmOutcome.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("f3620902-e969-48ae-a183-251f1f1bd169")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmOutcome.");
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

    @objid ("3c281d4c-c2ce-4867-9ac2-2685d2caf0f1")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmOutcome.", MINOR_VERSION);

    }

    @objid ("79665656-0505-4074-a32b-8d65fb062299")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("6f0c8fa9-41b5-481c-90f6-291289ed3720")
    public GmOutcome() {
        // Nothing specific to do.
    }

}
