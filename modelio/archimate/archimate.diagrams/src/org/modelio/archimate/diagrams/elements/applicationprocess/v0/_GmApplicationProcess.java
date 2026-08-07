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
package org.modelio.archimate.diagrams.elements.applicationprocess.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcessImageStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcessSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcessStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcessUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
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
 * Specialized class for {@link ApplicationProcess}.
 */
@objid ("d4133498-9cfa-4460-a2ad-cfca58546771")
public class _GmApplicationProcess extends GmArchiElement<ApplicationProcess> {
    @objid ("d0f1e5ca-6716-4d16-b1f4-68703cc04e5a")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("4d295ebd-45e6-4d8b-a2c3-5c03ef5d0ddb")
    private static final int MINOR_VERSION = 0;

    @objid ("ae7fb172-7248-4c7f-984e-574a0f15ab03")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmApplicationProcessImageStyleKeys();

    @objid ("afbe0f8a-fa8f-42a8-9e21-0ec9a6cd65e0")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmApplicationProcessSimpleStyleKeys();

    @objid ("da3eea56-4a9a-4425-b773-318bcc2e3f4d")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmApplicationProcessStructuredStyleKeys();

    @objid ("1ce3e472-27bf-4d14-bfc7-19e91f9e010a")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmApplicationProcessUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the ApplicationProcess is unmasked.
     * @param el the unmasked ApplicationProcess.
     * @param ref a reference to the unmasked ApplicationProcess.
     */
    @objid ("bfe97438-a55f-49aa-a965-5313906a591e")
    public _GmApplicationProcess(IGmDiagram diagram, ApplicationProcess el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("94a05a31-7b18-4132-9c75-f90c677431bb")
    public _GmApplicationProcess() {
        // Nothing specific to do.
    }

    @objid ("4bba287a-fdb4-4884-a11c-62003a934e40")
    @Override
    public int getMajorVersion() {
        return _GmApplicationProcess.MAJOR_VERSION;
    }

    @objid ("a6068b7f-b814-4ffc-8de5-438e697b0694")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmApplicationProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationProcess.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmApplicationProcess.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmApplicationProcess.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmApplicationProcess.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("d84e13aa-cc33-46f9-82cd-518fd187124b")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmApplicationProcess.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmApplicationProcess.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmApplicationProcess.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmApplicationProcess.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmApplicationProcess.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("c534ee72-f6d8-4218-8a8f-b965d8c026c5")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmApplicationProcess.");
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

    @objid ("cb93139b-cb3f-4207-8cf0-3093b4a77478")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmApplicationProcess.", _GmApplicationProcess.MINOR_VERSION);

    }

    @objid ("b9cfc192-73d3-47bd-9d81-ebf7277c6c3f")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
