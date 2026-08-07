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
package org.modelio.archimate.diagrams.elements.technologyfunction.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunctionImageStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunctionSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunctionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunctionUserImageStyleKeys;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.persistence.IDiagramReader;
import org.modelio.diagram.persistence.IDiagramWriter;
import org.modelio.diagram.styles.core.AbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Specialized class for {@link TechnologyFunction}.
 */
@objid ("13aeb386-669c-4533-810a-45f19bf09caa")
public class _GmTechnologyFunction extends GmArchiElement<TechnologyFunction> {
    @objid ("d56354b9-5b5c-4570-8603-8a6164ed1fab")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("c93c8956-3a5f-45db-b467-d53d2ddcd3c1")
    private static final int MINOR_VERSION = 0;

    @objid ("de0e5545-fddb-430a-8b79-8132d11a42ac")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmTechnologyFunctionImageStyleKeys();

    @objid ("5ae6bf99-61ba-4289-9933-a2ff2872c1fc")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmTechnologyFunctionSimpleStyleKeys();

    @objid ("265fdb8a-7458-4c96-852b-49af618e8876")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmTechnologyFunctionStructuredStyleKeys();

    @objid ("0a680d14-265e-4d37-8cde-acaf301dd6ca")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmTechnologyFunctionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the TechnologyFunction is unmasked.
     * @param el the unmasked TechnologyFunction.
     * @param ref a reference to the unmasked TechnologyFunction.
     */
    @objid ("f59b0eb6-002a-4cf6-b44d-1af73c786d08")
    public _GmTechnologyFunction(IGmDiagram diagram, TechnologyFunction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("1f01067a-2b20-4ce8-8a04-03ba2ccca609")
    public _GmTechnologyFunction() {
        // Nothing specific to do.
    }

    @objid ("294516b6-326e-4fde-a11e-b4abbcce2342")
    @Override
    public int getMajorVersion() {
        return MAJOR_VERSION;
    }

    @objid ("e156c2d8-3da5-4718-a7b8-d8243537af00")
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

    @objid ("7bc67e33-e27b-4fec-a8f1-1e10a95b99ca")
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

    @objid ("be4ec02f-8731-4518-95d1-985e4fc796aa")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = readMinorVersion(in, "GmTechnologyFunction.");
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

    @objid ("28ded21a-b68e-4778-bf19-05535da0a938")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        writeMinorVersion(out, "GmTechnologyFunction.", MINOR_VERSION);

    }

    @objid ("fa28f1c8-0625-486c-a77b-709b493b28a8")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
