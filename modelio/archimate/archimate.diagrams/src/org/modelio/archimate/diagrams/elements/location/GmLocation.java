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
package org.modelio.archimate.diagrams.elements.location;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.location.v0._GmLocation;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
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
 * Specialized class for {@link Location}.
 */
@objid ("ef76f832-4add-4f80-a11c-51b83a61d89d")
public class GmLocation extends GmArchiElementPortContainer<Location> {
    @objid ("c535461c-d6c3-4415-8de3-724266bd30d8")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("2fbe6732-3a17-41c2-80cd-f917a419b6ad")
    private static final int MINOR_VERSION = 0;

    @objid ("4d7bd1ff-4052-4dc4-8444-691908949910")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmLocationImageStyleKeys();

    @objid ("aaf5ca7e-fa8d-443b-8726-6927d8b12c6d")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmLocationSimpleStyleKeys();

    @objid ("eb0ac376-939a-4220-a0a0-d2ab06dab69f")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmLocationStructuredStyleKeys();

    @objid ("28195a16-24b5-4309-9715-9ac2badde2b3")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmLocationUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Location is unmasked.
     * @param el the unmasked Location.
     * @param ref a reference to the unmasked Location.
     */
    @objid ("ea3ef784-03a4-4388-8be8-459598e5fa7e")
    public GmLocation(IGmDiagram diagram, Location el, MRef ref) {
        super(diagram, el, ref);

        GmLocationPrimaryNode mainNode = new GmLocationPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("ca44e000-74bd-4011-9942-719b2d033ecb")
    GmLocation(final _GmLocation oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmLocationPrimaryNode primary = new GmLocationPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("8825d69a-04f8-4385-81e6-1878d5207240")
    @Override
    public int getMajorVersion() {
        return GmLocation.MAJOR_VERSION;
    }

    @objid ("b51f3f09-f951-463f-9044-fa8af376cae0")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmLocation.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmLocation.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmLocation.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmLocation.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmLocation.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("89928ace-e325-4a46-8249-de9be80f6c89")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmLocation.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmLocation.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmLocation.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmLocation.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmLocation.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("23545f3e-4f92-476e-84a3-3ff429a356b9")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmLocation.");
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

    @objid ("634f2f27-fd59-4b11-ad41-69f6138994ed")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmLocation.", MINOR_VERSION);

    }

    @objid ("8a8ba674-6032-457f-b875-7dc7137e0739")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("afb86dba-28a6-487d-92fc-ad451a2c1c09")
    public GmLocation() {
        // Nothing specific to do.
    }

}
