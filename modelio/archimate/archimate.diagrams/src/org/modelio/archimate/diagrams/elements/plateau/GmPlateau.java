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
package org.modelio.archimate.diagrams.elements.plateau;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.plateau.v0._GmPlateau;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau;
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
 * Specialized class for {@link Plateau}.
 */
@objid ("9d44aa90-2aac-42e6-abfa-17644bb4c8bc")
public class GmPlateau extends GmArchiElementPortContainer<Plateau> {
    @objid ("3281ce25-68db-4604-a55f-09f9751876d7")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("07f593e3-f6c0-4e39-9fd8-9863c267cf6b")
    private static final int MINOR_VERSION = 0;

    @objid ("8e2e82af-883a-4cbe-8e20-6bb34ef3e58b")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmPlateauImageStyleKeys();

    @objid ("8f8c0548-3ce8-4dbf-8e7f-c5a5ab93f29d")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmPlateauSimpleStyleKeys();

    @objid ("a5106fe2-c060-4574-b2df-e0208d4d2168")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmPlateauStructuredStyleKeys();

    @objid ("1c8233aa-5725-44c7-bf4d-dd71532b4705")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmPlateauUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Plateau is unmasked.
     * @param el the unmasked Plateau.
     * @param ref a reference to the unmasked Plateau.
     */
    @objid ("6be3407c-b0e4-4b6c-a910-27afbf490423")
    public GmPlateau(IGmDiagram diagram, Plateau el, MRef ref) {
        super(diagram, el, ref);

        GmPlateauPrimaryNode mainNode = new GmPlateauPrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("d864d69d-bd07-4713-a2c8-654b4e10b18a")
    GmPlateau(final _GmPlateau oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmPlateauPrimaryNode primary = new GmPlateauPrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("1910f42a-6b63-4599-a3df-f9eb620388fe")
    @Override
    public int getMajorVersion() {
        return GmPlateau.MAJOR_VERSION;
    }

    @objid ("ff00843d-01dc-4653-8044-849e205912f9")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmPlateau.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmPlateau.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmPlateau.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmPlateau.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmPlateau.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("6896bac1-5259-49d2-88c8-df8db64c60c4")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmPlateau.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmPlateau.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmPlateau.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmPlateau.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmPlateau.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("16998f15-e4ac-489b-8beb-93c9c35e0fe6")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmPlateau.");
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

    @objid ("bde39e3b-7a68-46f1-aaf0-1f443348e4bd")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmPlateau.", MINOR_VERSION);

    }

    @objid ("40c6432d-79f3-4f40-9f81-f89c3627ebba")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("49dc5fec-3d36-4ff8-bf29-452d9969030c")
    public GmPlateau() {
        // Nothing specific to do.
    }

}
