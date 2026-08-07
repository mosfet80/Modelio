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
package org.modelio.archimate.diagrams.elements.systemsoftware;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.systemsoftware.v0._GmSystemSoftware;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
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
 * Specialized class for {@link SystemSoftware}.
 */
@objid ("fc952bd0-c173-4565-b204-8bc3e262864f")
public class GmSystemSoftware extends GmArchiElementPortContainer<SystemSoftware> {
    @objid ("dee28c4a-f9b2-45db-910b-530c178f0e95")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("72919879-d9cd-479f-aac0-df01d4aa94d7")
    private static final int MINOR_VERSION = 0;

    @objid ("57e8dc54-5a1f-4cdf-a9ed-52a438be019b")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmSystemSoftwareImageStyleKeys();

    @objid ("32b28d6c-6b3d-45e7-9d87-f38ae63fdf79")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmSystemSoftwareSimpleStyleKeys();

    @objid ("c00afb0d-1f22-41fa-9bfa-9314b836ac66")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmSystemSoftwareStructuredStyleKeys();

    @objid ("16ca4099-1670-4fb8-b863-e98b24ec2e80")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmSystemSoftwareUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the SystemSoftware is unmasked.
     * @param el the unmasked SystemSoftware.
     * @param ref a reference to the unmasked SystemSoftware.
     */
    @objid ("0c450a53-8d1d-480f-9bb1-11abbbd6bf42")
    public GmSystemSoftware(IGmDiagram diagram, SystemSoftware el, MRef ref) {
        super(diagram, el, ref);

        GmSystemSoftwarePrimaryNode mainNode = new GmSystemSoftwarePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("9ebcf0cb-ab76-4c27-8978-99da6482f507")
    GmSystemSoftware(final _GmSystemSoftware oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmSystemSoftwarePrimaryNode primary = new GmSystemSoftwarePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("b61fa508-ae20-4803-a807-eeaf815053d3")
    @Override
    public int getMajorVersion() {
        return GmSystemSoftware.MAJOR_VERSION;
    }

    @objid ("8cc75bd2-c48b-41ec-a3a1-0f46f4c591e8")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmSystemSoftware.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmSystemSoftware.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmSystemSoftware.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmSystemSoftware.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmSystemSoftware.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("72846669-542f-4b71-b448-26e6322f438f")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmSystemSoftware.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmSystemSoftware.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmSystemSoftware.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmSystemSoftware.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmSystemSoftware.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("d35ed2ff-f208-4d3e-8073-b188951e8ace")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmSystemSoftware.");
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

    @objid ("1a996dcd-dc8b-4260-9b98-e450e39e905b")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmSystemSoftware.", MINOR_VERSION);

    }

    @objid ("726cff33-23da-4db6-acc3-8fdeae8038d0")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("9dfd2817-17f7-4fa4-8dc7-362880655932")
    public GmSystemSoftware() {
        // Nothing specific to do.
    }

}
