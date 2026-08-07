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
package org.modelio.archimate.diagrams.elements.technologyevent.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEventImageStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEventSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEventUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyEvent;
import org.modelio.diagram.elements.core.model.IGmDiagram;
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
@objid ("be65f66c-70ef-434c-99fe-1d082c64cc61")
public class _GmTechnologyEvent extends GmArchiElement<TechnologyEvent> {
    @objid ("1207b629-2809-4af8-8e78-b0d3a4decfa0")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("dd2a9886-9996-40c2-b296-f596d1a023cb")
    private static final int MINOR_VERSION = 0;

    @objid ("45fb9c65-7be5-4ead-976f-f72ac064d0af")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyEventImageStyleKeys();

    @objid ("9ad1a45e-6bc9-4de8-a21e-0bc372a5cb27")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyEventSimpleStyleKeys();

    @objid ("5ee6853e-d9f1-4e6b-8d57-102513442800")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyEventStructuredStyleKeys();

    @objid ("f9f68221-d1de-463b-8f1b-da9d22e80ce0")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyEventUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyEvent is unmasked.
     * @param el the unmasked TechnologyEvent.
     * @param ref a reference to the unmasked TechnologyEvent.
     */
    @objid ("d3c16d85-ca64-49fe-af5b-3465dbd7babb")
    public _GmTechnologyEvent(IGmDiagram diagram, TechnologyEvent el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("c08cf440-d84c-4cb5-a33f-d15bcac90ce2")
    public _GmTechnologyEvent() {
        // Nothing specific to do.
    }

    @objid ("9070d9d8-7f6e-4380-b337-205b290d34be")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("9207611f-ea31-44f5-a52a-24852e544461")
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

    @objid ("20b9b342-dd3c-493e-9852-f3884ec13f66")
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

    @objid ("93212ca2-074c-4505-a2b7-f45e79d7a975")
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

    @objid ("6ae887bf-4214-46fd-92f9-379df5a7a3aa")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyEvent.", MINOR_VERSION);

    }

    @objid ("bb9c73e5-f822-479b-bd6b-13b2ede0ce1e")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
