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
package org.modelio.archimate.diagrams.elements.principle;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPortContainer;
import org.modelio.archimate.diagrams.elements.principle.v0._GmPrinciple;
import org.modelio.archimate.metamodel.layers.motivation.Principle;
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
 * Specialized class for {@link Principle}.
 */
@objid ("38082a59-0933-47c3-9636-3c245c51e876")
public class GmPrinciple extends GmArchiElementPortContainer<Principle> {
    @objid ("b620e974-2302-481b-a858-94729dae25b5")
    private static final int MAJOR_VERSION = 1;

    /**
     * Current version of this Gm.
     */
    @objid ("9331c536-c901-4ec9-a859-896d5cb14ea1")
    private static final int MINOR_VERSION = 0;

    @objid ("b86b8dc0-fd5b-4ce4-a23d-4d72ce2fca56")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmPrincipleImageStyleKeys();

    @objid ("99a9f429-075b-41e1-b579-ef8405370862")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmPrincipleSimpleStyleKeys();

    @objid ("c11690d3-5b29-4546-b2ef-f7a36775a062")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmPrincipleStructuredStyleKeys();

    @objid ("aec52e0e-6c6a-4afe-848c-b56197c3394b")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmPrincipleUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Principle is unmasked.
     * @param el the unmasked Principle.
     * @param ref a reference to the unmasked Principle.
     */
    @objid ("35dea3f1-0c3e-48f5-9bee-1929283ce570")
    public GmPrinciple(IGmDiagram diagram, Principle el, MRef ref) {
        super(diagram, el, ref);

        GmPrinciplePrimaryNode mainNode = new GmPrinciplePrimaryNode(diagram, el, ref);
        mainNode.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(mainNode);

    }

    /**
     * Migration constructor from major version 0, should only be called by migrator.
     *
     * @param oldVersionGm the instance to migrate from.
     */
    @objid ("fedd83c8-00e3-462f-a2c2-1d20ce64aedf")
    GmPrinciple(final _GmPrinciple oldVersionGm) {
        super(oldVersionGm.getDiagram(), oldVersionGm.getRelatedElement(), oldVersionGm.getRepresentedRef());

        GmPrinciplePrimaryNode primary = new GmPrinciplePrimaryNode(oldVersionGm);
        primary.setRoleInComposition(GmPortContainer.MAIN_NODE_ROLE);
        addChild(primary);

    }

    @objid ("90979160-6bf6-404e-be36-b1cd2f7d59bf")
    @Override
    public int getMajorVersion() {
        return GmPrinciple.MAJOR_VERSION;
    }

    @objid ("1d8b93b7-9172-43d6-8511-4171820caa43")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = GmPrinciple.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmPrinciple.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return GmPrinciple.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return GmPrinciple.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return GmPrinciple.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("6ebb29e0-b4f3-4b98-9780-30cffc405422")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = GmPrinciple.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return GmPrinciple.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return GmPrinciple.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return GmPrinciple.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return GmPrinciple.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("879327fa-2a6c-4ee3-90c6-00248a59110e")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmPrinciple.");
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

    @objid ("510d0664-7940-473c-b014-ee3b02968acd")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

    @objid ("ba42a13e-5c6d-4c95-a3b5-f9f243822270")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmPrinciple.", MINOR_VERSION);

    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("475addcc-f0f7-4e0e-b4ee-29f2cdd64c80")
    public GmPrinciple() {
        // Nothing specific to do.
    }

}
