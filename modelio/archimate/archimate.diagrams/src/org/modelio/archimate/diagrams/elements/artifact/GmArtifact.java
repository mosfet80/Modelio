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
package org.modelio.archimate.diagrams.elements.artifact;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.artifact.v0._GmArtifact;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
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
 * Specialized class for {@link Artifact}.
 */
@objid ("00a83cd8-95ab-4c12-8dca-23dce148e536")
public class GmArtifact extends GmArchiElementPortContainer<Artifact> {
    @objid ("ac01a7fc-9529-47b8-bce1-9fb21531ae86")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("d80c2e5b-3221-4fc2-b352-5debe9455088")
    private static final int MINOR_VERSION = 0;

    @objid ("0dab2f35-4a7d-40b6-bc85-d59e91f1dc79")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmArtifactImageStyleKeys();

    @objid ("89462cc1-c18d-4e60-b802-2550cd6815e9")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmArtifactSimpleStyleKeys();

    @objid ("7a28a435-f646-4284-8161-a1e1f16456e1")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmArtifactStructuredStyleKeys();

    @objid ("4cc7abb9-d71f-4ef3-9640-626df3f369a0")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmArtifactUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Artifact is unmasked.
     * @param el the unmasked Artifact.
     * @param ref a reference to the unmasked Artifact.
     */
    @objid ("e7b8396e-cc4d-4706-8753-60d5d62e2037")
    public GmArtifact(IGmDiagram diagram, Artifact el, MRef ref) {
        super(diagram, el, ref);

        GmArtifactPrimaryNode mainNode = new GmArtifactPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("f0ec11a7-2bc0-4cee-949f-05653c193d03")
    public GmArtifact() {
        // Nothing specific to do.
    }

    @objid ("b096bfc5-e1fe-44d2-86b1-ef8c59d00109")
    @Override
    public int getMajorVersion() {
        return GmArtifact.MAJOR_VERSION;
    }

    @objid ("6c7cb0f7-20b7-4f68-b68c-30a1e23ba334")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmArtifact.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmArtifact.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmArtifact.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmArtifact.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmArtifact.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("84deab37-9d91-4911-9eae-0de8ba5fdde2")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmArtifact.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmArtifact.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmArtifact.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmArtifact.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmArtifact.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("bfd9be69-8c6c-4dd8-884d-555a6273d225")
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

    @objid ("4dfe27f8-3841-4179-9742-5daec25d81af")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmArtifact.", GmArtifact.MINOR_VERSION);

    }

    @objid ("84a0e5e1-2013-4c77-af35-a53235e2f642")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("ae85ea91-0710-4e6b-9fbb-f2ede7b7ddab")
    GmArtifact(final _GmArtifact oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmArtifactPrimaryNode primary = new GmArtifactPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("bb3bdc67-c9da-4f82-8f81-4dcd41c5b4bc")
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
