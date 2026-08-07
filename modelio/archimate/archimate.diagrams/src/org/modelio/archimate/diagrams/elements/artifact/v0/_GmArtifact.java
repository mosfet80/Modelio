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
package org.modelio.archimate.diagrams.elements.artifact.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifactImageStyleKeys;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifactSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifactStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifactUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
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
 * Specialized class for {@link Artifact}.
 */
@objid ("14f5af72-12fe-4423-b666-c11efc11b05a")
public class _GmArtifact extends GmArchiElement<Artifact> {
    @objid ("9d9b391b-7299-49ac-b73d-7092d744785e")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("82f60936-8892-4ca9-8fc4-b86a9d9105c8")
    private static final int MINOR_VERSION = 0;

    @objid ("c509de53-db06-4c57-bc11-adfac3587d91")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmArtifactImageStyleKeys();

    @objid ("27727083-195b-4505-84ba-47d604e516cf")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmArtifactSimpleStyleKeys();

    @objid ("cc56fa0d-10e1-46e4-b28a-f78784992755")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmArtifactStructuredStyleKeys();

    @objid ("78b75902-030e-4796-8790-f21ca38bbfa4")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmArtifactUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Artifact is unmasked.
     * @param el the unmasked Artifact.
     * @param ref a reference to the unmasked Artifact.
     */
    @objid ("7938c5dc-331d-41bf-be4b-98e668af0d13")
    public _GmArtifact(IGmDiagram diagram, Artifact el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("001f54dc-e825-40f7-a7b0-a1c52fbfbbcd")
    public _GmArtifact() {
        // Nothing specific to do.
    }

    @objid ("703a44ad-ed79-4725-b506-3269c48371c8")
    @Override
    public int getMajorVersion() {
        return _GmArtifact.MAJOR_VERSION;
    }

    @objid ("57a33752-6ace-4c18-bab4-298c386e2a16")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmArtifact.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmArtifact.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmArtifact.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmArtifact.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmArtifact.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("5d9f0a0e-a6a0-4dff-b404-39bdb6553dd6")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmArtifact.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmArtifact.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmArtifact.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmArtifact.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmArtifact.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("92382bb1-0b25-4ab8-9f06-12d8d181286e")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmArtifact.");
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

    @objid ("27349d2c-beff-419b-8332-e24924a7bf9e")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmArtifact.", _GmArtifact.MINOR_VERSION);

    }

    @objid ("37dd9317-9fef-4933-9963-be0592df77ce")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
