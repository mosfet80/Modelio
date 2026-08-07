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
package org.modelio.archimate.diagrams.elements.technologyservice.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyServiceImageStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyServiceSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyServiceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyServiceUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyService}.
 */
@objid ("317cc18d-5757-4563-9f39-19b7902bfe9a")
public class _GmTechnologyService extends GmArchiElement<TechnologyService> {
    @objid ("80452e4b-8ed0-4fad-9a25-85a761029eb4")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("60287cd0-7819-4218-9529-73682082963d")
    private static final int MINOR_VERSION = 0;

    @objid ("cb7606ff-88f2-487e-8197-1b023296bd17")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyServiceImageStyleKeys();

    @objid ("2f3c6770-f8fa-47c8-a182-561cd0352335")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyServiceSimpleStyleKeys();

    @objid ("8c1c615f-dc4f-45b4-8b54-1b4b68b075f6")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyServiceStructuredStyleKeys();

    @objid ("fb7c22bc-f2b9-4037-9586-5da5e899eec8")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyServiceUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyService is unmasked.
     * @param el the unmasked TechnologyService.
     * @param ref a reference to the unmasked TechnologyService.
     */
    @objid ("d6723a77-d40b-4e0d-ada8-bea10ee4fa6a")
    public _GmTechnologyService(IGmDiagram diagram, TechnologyService el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a4ac6ffb-fa99-481d-a51c-e4692525312b")
    public _GmTechnologyService() {
        // Nothing specific to do.
    }

    @objid ("e560ff91-5ce9-4e6c-953c-73baebe48368")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("33f98633-947b-4f40-b515-eeb36528473d")
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

    @objid ("40949bdc-feba-4c52-b543-95b97d330ae5")
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

    @objid ("74f99e9b-fde5-4bef-b32e-2792985bdbcf")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyService.");
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

    @objid ("0e345ef6-f0b0-4b73-aeda-e10285d82f6a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyService.", MINOR_VERSION);

    }

    @objid ("c28ea86e-61df-4634-9888-d6f4f1851098")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
