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
package org.modelio.archimate.diagrams.elements.applicationfunction.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunctionImageStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunctionSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunctionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunctionUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
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
 * Specialized class for {@link ApplicationFunction}.
 */
@objid ("7a3038a6-1145-4f3e-ac92-6d1500415c4a")
public class _GmApplicationFunction extends GmArchiElement<ApplicationFunction> {
    @objid ("fd24eb0c-1994-46b4-bd72-d62b12f5a364")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("245d478d-d27a-4bbd-8d01-37722abf09f3")
    private static final int MINOR_VERSION = 0;

    @objid ("3bf0dbda-60e8-45f2-8f38-cb67ba73d337")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationFunctionImageStyleKeys();

    @objid ("b82e8834-f91e-4202-8aec-fa45147eeea1")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationFunctionSimpleStyleKeys();

    @objid ("495f6a57-776b-4eae-b4f7-b1cf35b3c1be")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationFunctionStructuredStyleKeys();

    @objid ("f57228ff-6332-45a1-853f-1463b6b40491")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationFunctionUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationFunction is unmasked.
     * @param el the unmasked ApplicationFunction.
     * @param ref a reference to the unmasked ApplicationFunction.
     */
    @objid ("8626c84c-99c3-497b-91e7-5c56eed351c7")
    public _GmApplicationFunction(IGmDiagram diagram, ApplicationFunction el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("ec31c0ff-229d-4751-8fd0-33d0d1c0a25d")
    public _GmApplicationFunction() {
        // Nothing specific to do.
    }

    @objid ("e11de0c2-9d2f-4350-a108-2f9f09ceb2e2")
    @Override
    public int getMajorVersion() {
        return _GmApplicationFunction.MAJOR_VERSION;
    }

    @objid ("302c13eb-c737-4cb3-b1f1-d10107e8804c")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmApplicationFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationFunction.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmApplicationFunction.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmApplicationFunction.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmApplicationFunction.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("82c03a6f-b2dd-430b-852a-fa284fb03d64")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmApplicationFunction.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationFunction.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmApplicationFunction.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmApplicationFunction.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmApplicationFunction.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("682fceb5-4967-4997-a8d7-81d3f807e31d")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationFunction.");
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

    @objid ("726d95b4-556d-4437-bfa7-fb16f7df3247")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationFunction.", _GmApplicationFunction.MINOR_VERSION);

    }

    @objid ("6509b6cd-9ea2-4342-8c17-11b7031a4dc5")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
