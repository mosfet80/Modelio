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
package org.modelio.archimate.diagrams.elements.businessfunction.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunctionImageStyleKeys;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunctionSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunctionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunctionUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction;
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
 * Specialized class for {@link BusinessFunction}.
 */
@objid ("36d2ffde-0429-4219-bdc4-f8ffc99197a7")
public class _GmBusinessFunction extends GmArchiElement<BusinessFunction> {
    @objid ("0571aaf3-2c52-4979-ba76-1c462dbdf5be")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("57561f50-1fef-4a52-ad91-e4f9e09576f6")
    private static final int MINOR_VERSION = 0;

    @objid ("aea9dbfc-1eab-4589-a4bc-4feb373bfe47")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmBusinessFunctionImageStyleKeys();

    @objid ("a62a2826-d1c9-49d9-aa59-d05d6c9b29d6")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmBusinessFunctionSimpleStyleKeys();

    @objid ("281fa603-86f9-43f4-ae19-55f3bf24e92a")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmBusinessFunctionStructuredStyleKeys();

    @objid ("b757c42a-ca95-4c75-b37d-93c7f2c08fb3")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmBusinessFunctionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the BusinessFunction is unmasked.
     * @param el the unmasked BusinessFunction.
     * @param ref a reference to the unmasked BusinessFunction.
     */
    @objid ("55d3b5ec-f10a-47a0-b176-01a48d9fe663")
    public _GmBusinessFunction(IGmDiagram diagram, BusinessFunction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("3d49feb9-4e3b-4dad-8b72-d828b338f690")
    public _GmBusinessFunction() {
        // Nothing specific to do.
    }

    @objid ("e5d24ef4-20eb-470a-901f-d8b7ae335e8c")
    @Override
    public int getMajorVersion() {
        return _GmBusinessFunction.MAJOR_VERSION;
    }

    @objid ("d0219334-0499-4707-a283-c73500d4c713")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmBusinessFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessFunction.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmBusinessFunction.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmBusinessFunction.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmBusinessFunction.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("29f85c90-06a3-42bd-9bc2-9775a22173fa")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmBusinessFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmBusinessFunction.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmBusinessFunction.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmBusinessFunction.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmBusinessFunction.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("2d21db4b-323c-430d-8e1b-2a409642ebbf")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmBusinessFunction.");
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

    @objid ("7708eb55-a2b9-4678-be6d-d4326ce93f7c")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmBusinessFunction.", _GmBusinessFunction.MINOR_VERSION);

    }

    @objid ("6d1ce335-3aee-43f8-9846-0fb4c6b3e34f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
