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
package org.modelio.archimate.diagrams.elements.workpackage.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackageImageStyleKeys;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackageSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackageStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackageUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link WorkPackage}.
 */
@objid ("b48c7cab-6626-44f9-8253-80016033cc83")
public class _GmWorkPackage extends GmArchiElement<WorkPackage> {
    @objid ("89e62343-8798-43ad-b3eb-ccc09070f8cc")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("4ec377b4-801a-4807-ab76-e5dff2c14cdc")
    private static final int MINOR_VERSION = 0;

    @objid ("3d664a23-4d2b-4ea6-8745-e5b3c321ebd7")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmWorkPackageImageStyleKeys();

    @objid ("eed3ed4a-b60a-4dff-8666-1b8ba14d905b")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmWorkPackageSimpleStyleKeys();

    @objid ("6126f615-a9fc-495a-b87b-019b5182b785")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmWorkPackageStructuredStyleKeys();

    @objid ("91eef065-7686-4735-b487-21e393c02c65")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmWorkPackageUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the WorkPackage is unmasked.
     * @param el the unmasked WorkPackage.
     * @param ref a reference to the unmasked WorkPackage.
     */
    @objid ("49461ace-5a58-41b2-afc2-3eaf7702f4f5")
    public _GmWorkPackage(IGmDiagram diagram, WorkPackage el, MRef ref) {
        super(diagram, el, ref);
        this.header.setShowMetaclassIcon(false);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("84dfa577-825c-4a96-a8ca-e08d5138a713")
    public _GmWorkPackage() {
        // Nothing specific to do.
    }

    @objid ("1bb9db93-4e7f-4a83-8cdf-49ac4193a947")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("9aa5aa04-c0fb-4842-b3ab-170eb7ce82e8")
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

    @objid ("dbb9dfa6-bb26-421f-85b1-272eb6f439a3")
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

    @objid ("ddbcebd2-098d-47fe-8015-f43c7e2409ae")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmWorkPackage.");
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

    @objid ("0f18a068-40f0-468b-91d2-ca164c6a32f7")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmWorkPackage.", MINOR_VERSION);

    }

    @objid ("6d931df1-61d1-4fac-8223-ed7ba0dc9132")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
