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
package org.modelio.archimate.diagrams.elements.technologyprocess.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcessImageStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcessSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcessStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcessUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyProcess;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyProcess}.
 */
@objid ("7a81e514-be17-488b-a9a5-a4311aa44a40")
public class _GmTechnologyProcess extends GmArchiElement<TechnologyProcess> {
    @objid ("fe7d49fa-a92e-41dc-9b12-0026ddfd9c44")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("6292fa6a-2288-4efd-b9a2-c3015b8ddaf1")
    private static final int MINOR_VERSION = 0;

    @objid ("bc2bf894-e0ec-4833-8b83-4c9c86cd4a2b")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyProcessImageStyleKeys();

    @objid ("40989025-2e23-47ce-8ccb-3f706b94a090")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyProcessSimpleStyleKeys();

    @objid ("b9f10288-f48f-4d92-8866-0d716ea13be3")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyProcessStructuredStyleKeys();

    @objid ("36d85b25-b2e4-496a-970c-f815b1e1fc0a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyProcessUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyProcess is unmasked.
     * @param el the unmasked TechnologyProcess.
     * @param ref a reference to the unmasked TechnologyProcess.
     */
    @objid ("dc6f9ac1-2b0e-4d35-9939-fc263da6b637")
    public _GmTechnologyProcess(IGmDiagram diagram, TechnologyProcess el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("14686bc9-fa62-4252-8ef3-f944499fc799")
    public _GmTechnologyProcess() {
        // Nothing specific to do.
    }

    @objid ("2e5ac8ce-3d37-421a-b6cb-f4e3f8ff0648")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("51ef9a1a-8168-49f2-ad88-f96f44736aa4")
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

    @objid ("bfdd16f4-444f-4bae-b9d4-262639217c67")
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

    @objid ("ef35e45a-7abf-4125-a155-26d01d237fe0")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyProcess.");
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

    @objid ("ae7e07d0-6fb0-43c7-847a-605002384840")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyProcess.", MINOR_VERSION);

    }

    @objid ("14aa19b9-dcfe-4d0a-a128-2ec2e3ef96c4")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
