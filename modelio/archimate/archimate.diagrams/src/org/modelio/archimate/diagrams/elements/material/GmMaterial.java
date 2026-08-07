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
package org.modelio.archimate.diagrams.elements.material;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.material.v0._GmMaterial;
import org.modelio.archimate.metamodel.layers.physical.structure.passive.Material;
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
 * Specialized class for {@link Material}.
 */
@objid ("4d66e5a8-7006-45e1-b66c-aa642addbdc8")
public class GmMaterial extends GmArchiElementPortContainer<Material> {
    @objid ("301ce477-e60c-44e4-acf0-6ae961c6c4e6")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("ed02538e-34bf-48e8-b2f1-78805bc62de4")
    private static final int MINOR_VERSION = 0;

    @objid ("55d4fbf1-ceaa-46f9-a210-2c32d9f1d59a")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmMaterialImageStyleKeys();

    @objid ("394defba-5dfa-449b-9059-c295cb8956d3")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmMaterialSimpleStyleKeys();

    @objid ("86f380f1-de02-4e22-9e4a-26f223d77a65")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmMaterialStructuredStyleKeys();

    @objid ("67fdd5d8-ae4c-413d-8f4c-3406fee1945d")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmMaterialUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Material is unmasked.
     * @param el the unmasked Material.
     * @param ref a reference to the unmasked Material.
     */
    @objid ("2d6c0e16-fc40-44ef-b3d2-0996b958701b")
    public GmMaterial(IGmDiagram diagram, Material el, MRef ref) {
        super(diagram, el, ref);

        GmMaterialPrimaryNode mainNode = new GmMaterialPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("ef33b65a-95da-4afb-a28d-e5abf1b8f867")
    GmMaterial(final _GmMaterial oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmMaterialPrimaryNode primary = new GmMaterialPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("153f226c-5e92-44fe-90e3-76690cc1e229")
    @Override
    public int getMajorVersion() {
        return GmMaterial.MAJOR_VERSION;
    }

    @objid ("15820f63-7ae5-4b9a-b0cc-b8ba162c2a11")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmMaterial.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmMaterial.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmMaterial.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmMaterial.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmMaterial.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("bb1a1adb-1dd1-4f76-9961-23c065fb5c57")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmMaterial.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmMaterial.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmMaterial.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmMaterial.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmMaterial.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("7b39d86f-a3dd-44c6-b369-09bc4f316252")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmMaterial.");
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

    @objid ("60c30c20-814f-4383-8b20-f4273aa0d7a8")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmMaterial.", MINOR_VERSION);

    }

    @objid ("3dc3b301-2450-4cdc-833f-28b0e7bd93f0")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("855daa19-a0a2-47a1-a8b2-f9f033b33923")
    public GmMaterial() {
        // Nothing specific to do.
    }

}
