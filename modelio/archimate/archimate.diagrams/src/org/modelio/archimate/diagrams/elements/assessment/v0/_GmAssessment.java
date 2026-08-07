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
package org.modelio.archimate.diagrams.elements.assessment.v0;

import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessmentImageStyleKeys;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessmentSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessmentStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessmentUserImageStyleKeys;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.layers.motivation.Assessment;
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
 * Specialized class for {@link Assessment}.
 */
@objid ("92c3c321-761a-4e1e-b906-5812af4620da")
public class _GmAssessment extends GmArchiElement<Assessment> {
    @objid ("c52bca2f-4ce9-46a3-8c3c-8c465971c4c7")
    private static final int MAJOR_VERSION = 0;

    /**
     * Current version of this Gm.
     */
    @objid ("05f212c9-fa3c-497e-abe6-021a08f5d007")
    private static final int MINOR_VERSION = 0;

    @objid ("da8aca28-9e64-482e-9860-6c582c484cf3")
    static final AbstractStyleKeyProvider IMAGE_KEYS = new GmAssessmentImageStyleKeys();

    @objid ("385e0f31-e065-4975-a82c-a2fed4fb74e6")
    static final AbstractStyleKeyProvider SIMPLE_KEYS = new GmAssessmentSimpleStyleKeys();

    @objid ("b5a59eea-66de-4c48-bbf2-e35b9a4b3817")
    static final AbstractStyleKeyProvider STRUCTURED_KEYS = new GmAssessmentStructuredStyleKeys();

    @objid ("c94d5999-99e3-4ffc-b982-6030c3293e56")
    static final AbstractStyleKeyProvider USERIMAGE_KEYS = new GmAssessmentUserImageStyleKeys();

    /**
     * Constructor.
     *
     * @param diagram the diagram in which the Assessment is unmasked.
     * @param el the unmasked Assessment.
     * @param ref a reference to the unmasked Assessment.
     */
    @objid ("c6aef0fc-da41-4983-8afe-a77787a9c088")
    public _GmAssessment(IGmDiagram diagram, Assessment el, MRef ref) {
        super(diagram, el, ref);
    }

    /**
     * Empty constructor needed for deserialisation.
     */
    @objid ("a1195211-bd19-4b49-8e54-2cf140ec7dc7")
    public _GmAssessment() {
        // Nothing specific to do.
    }

    @objid ("dcf663f0-5074-4bcb-89ad-c6b30dfc2100")
    @Override
    public int getMajorVersion() {
        return _GmAssessment.MAJOR_VERSION;
    }

    @objid ("d2a55f9b-d59c-4ff2-8e8b-a7aba0928bb3")
    @Override
    public StyleKey getStyleKey(MetaKey metakey) {
        StyleKey styleKey = _GmAssessment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmAssessment.IMAGE_KEYS.getStyleKey(metakey);
            case USER_IMAGE:
                return _GmAssessment.USERIMAGE_KEYS.getStyleKey(metakey);
            case SIMPLE:
                return _GmAssessment.SIMPLE_KEYS.getStyleKey(metakey);
            case STRUCTURED:
                return _GmAssessment.STRUCTURED_KEYS.getStyleKey(metakey);
            default:
                break;
            }
        }
        return null;
    }

    @objid ("528bc83e-933e-46ed-bda0-075119a5d164")
    @Override
    public List<StyleKey> getStyleKeys() {
        StyleKey styleKey = _GmAssessment.STRUCTURED_KEYS.getStyleKey(MetaKey.REPMODE);
        if (styleKey != null) {
            RepresentationMode mode = getDisplayedStyle().getProperty(styleKey);
            switch (mode) {
            case IMAGE:
                return _GmAssessment.IMAGE_KEYS.getStyleKeys();
            case USER_IMAGE:
                return _GmAssessment.USERIMAGE_KEYS.getStyleKeys();
            case SIMPLE:
                return _GmAssessment.SIMPLE_KEYS.getStyleKeys();
            case STRUCTURED:
                return _GmAssessment.STRUCTURED_KEYS.getStyleKeys();
            default:
                break;
            }
        }
        return Collections.emptyList();
    }

    @objid ("1f06d82d-8604-4bcd-956f-cc2a5149e28d")
    @Override
    public void read(IDiagramReader in) {
        // Read version, defaults to 0 if not found
        int readVersion = GmAbstractObject.readMinorVersion(in, "GmAssessment.");
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

    @objid ("4461ee11-2d98-4277-a5e1-28fb175adf4a")
    @Override
    public void write(IDiagramWriter out) {
        super.write(out);

        // Write version of this Gm if different of 0
        GmAbstractObject.writeMinorVersion(out, "GmAssessment.", _GmAssessment.MINOR_VERSION);

    }

    @objid ("c628be47-d809-47f2-b5d0-7ce39ba512dd")
    private void read_0(IDiagramReader in) {
        super.read(in);
    }

}
