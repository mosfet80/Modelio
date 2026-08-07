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
package org.modelio.archimate.diagrams.elements.facility;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.facility.v0._GmFacility;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Facility;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
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
 * Specialized class for {@link Facility}.
 */
@objid ("554f6497-3128-4fd7-8198-8d124665f21e")
public class GmFacility extends GmArchiElementPortContainer<Facility> {
    @objid ("760d5cfc-f1f4-4fc4-a898-ec24344998bc")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("030828c3-5126-4fa7-a5a4-6715a0cea2b7")
    private static final int MINOR_VERSION = 0;

    @objid ("e9f63dda-8edd-44bf-8e98-eabb59d315eb")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmFacilityImageStyleKeys();

    @objid ("474c0f54-dcbe-4d14-93cb-f43d3daa00cb")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmFacilitySimpleStyleKeys();

    @objid ("d72150cd-392e-4a3f-b0dc-2780460bab8b")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmFacilityStructuredStyleKeys();

    @objid ("4a9cc1ac-7e01-4538-a04c-ca9672e4a8ed")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmFacilityUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Facility is unmasked.
     * @param el the unmasked Facility.
     * @param ref a reference to the unmasked Facility.
     */
    @objid ("b77287cc-312c-4427-a9ae-8e8d4a2fc280")
    public GmFacility(IGmDiagram diagram, Facility el, MRef ref) {
        super(diagram, el, ref);

        GmFacilityPrimaryNode mainNode = new GmFacilityPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("b7cea67a-e30f-4360-83d4-9c123b3abe6a")
    public GmFacility() {
        // Nothing specific to do.
    }

    @objid ("e1072fea-6f27-4ac7-80ed-56a4d16ddd7c")
    @Override
    public int getMajorVersion() {
        return GmFacility.MAJOR_VERSION;
    }

    @objid ("ca9c09f3-7f8b-4576-be2b-561ab8594c1f")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmFacility.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmFacility.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmFacility.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmFacility.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmFacility.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("a2d48cdf-3979-4ec4-843f-1abe2c95c88c")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmFacility.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmFacility.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmFacility.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmFacility.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmFacility.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("7f0720f5-2cf0-4064-8264-b50ed1c68dbb")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmFacility.");
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

    @objid ("9192d567-30ce-4139-b102-d7839435ea89")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmFacility.", GmFacility.MINOR_VERSION);

    }

    @objid ("3fe6a7a5-10e6-44ab-9440-d0cd647df069")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("b731f054-8722-46ed-8810-57a26a316bcc")
    GmFacility(final _GmFacility oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmFacilityPrimaryNode primary = new GmFacilityPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

}
