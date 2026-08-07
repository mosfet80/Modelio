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
package org.modelio.archimate.diagrams.elements.workpackage;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.workpackage.v0._GmWorkPackage;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage;
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
 * Specialized class for {@link WorkPackage}.
 */
@objid ("d057e101-47d3-49a1-8554-c2b1310595c4")
public class GmWorkPackage extends GmArchiElementPortContainer<WorkPackage> {
    @objid ("ad904f6f-d7f9-4d59-9bde-009c20bc703c")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("b89591e4-a4ca-460f-b367-a10dc513b6bd")
    private static final int MINOR_VERSION = 0;

    @objid ("2d1a73a3-9e4b-4b7b-97a6-a2eacb98bf88")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmWorkPackageImageStyleKeys();

    @objid ("87dd2aef-a222-41f5-9415-2dcf744553ae")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmWorkPackageSimpleStyleKeys();

    @objid ("9efa9b55-020b-4d93-bfaf-f6fc275d21fe")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmWorkPackageStructuredStyleKeys();

    @objid ("4485cefa-1e40-4ced-84a3-65b1ab57a996")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmWorkPackageUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the WorkPackage is unmasked.
     * @param el the unmasked WorkPackage.
     * @param ref a reference to the unmasked WorkPackage.
     */
    @objid ("46566268-7eab-4b25-a698-bdfed8e396d9")
    public GmWorkPackage(IGmDiagram diagram, WorkPackage el, MRef ref) {
        super(diagram, el, ref);

        GmWorkPackagePrimaryNode mainNode = new GmWorkPackagePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("23f2993a-0303-46b1-9221-ba109362d03f")
    GmWorkPackage(final _GmWorkPackage oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmWorkPackagePrimaryNode primary = new GmWorkPackagePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("f4c2a048-0d07-430a-898e-af4128887196")
    @Override
    public int getMajorVersion() {
        return GmWorkPackage.MAJOR_VERSION;
    }

    @objid ("58350b29-37f9-49f7-bc5e-51d6964e7608")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmWorkPackage.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmWorkPackage.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmWorkPackage.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmWorkPackage.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmWorkPackage.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("b9e2450b-8664-4a5b-b18f-5a2c4c3390bd")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmWorkPackage.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmWorkPackage.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmWorkPackage.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmWorkPackage.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmWorkPackage.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("4f9afed3-e179-45ba-adaf-e0413871913e")
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

    @objid ("69f60589-3a14-43bd-850f-0bbdbeee36a4")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmWorkPackage.", MINOR_VERSION);

    }

    @objid ("0f5a21a8-c360-460c-b3cc-34d597a4a360")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("7f710d11-2ab7-434d-85d1-113b074714ca")
    public GmWorkPackage() {
        // Nothing specific to do.
    }

}
