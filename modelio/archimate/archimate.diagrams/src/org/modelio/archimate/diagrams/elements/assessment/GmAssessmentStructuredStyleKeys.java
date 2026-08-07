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
package org.modelio.archimate.diagrams.elements.assessment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmAssessment when its representation mode is RepresentationMode.STRUCTURED
 */
@objid ("01b26e2e-cd55-4c10-8967-7476815295d5")
public class GmAssessmentStructuredStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3802e059-31d0-4fd1-9009-711b83502792")
    static final StyleKey REPMODE = createStyleKey("ASSESSMENT_REPMODE", MetaKey.REPMODE);

    @objid ("c6637878-df0e-4c08-beb3-b67ad3f1ed17")
    static final StyleKey FILLCOLOR = createStyleKey("ASSESSMENT_FILLCOLOR", MetaKey.FILLCOLOR);

    @objid ("531c7467-9dca-443c-b912-bccbec578998")
    static final StyleKey FILLMODE = createStyleKey("ASSESSMENT_FILLMODE", MetaKey.FILLMODE);

    @objid ("d734d089-c0ac-49a2-9fd9-d25f375beb73")
    static final StyleKey LINECOLOR = createStyleKey("ASSESSMENT_LINECOLOR", MetaKey.LINECOLOR);

    @objid ("3a062bc2-1c3b-4f1f-b9c0-5623acb0b68a")
    static final StyleKey LINEWIDTH = createStyleKey("ASSESSMENT_LINEWIDTH", MetaKey.LINEWIDTH);

    @objid ("a35c3980-abc0-49c1-b963-47f0c980fa0a")
    static final StyleKey FONT = createStyleKey("ASSESSMENT_FONT", MetaKey.FONT);

    @objid ("32fbfef3-35ca-4a0d-ae4b-bc9e7b86eeea")
    static final StyleKey TEXTCOLOR = createStyleKey("ASSESSMENT_TEXTCOLOR", MetaKey.TEXTCOLOR);

    @objid ("c8a783e5-87d3-4289-9262-442a0c76aba3")
    static final StyleKey SHOWSTEREOTYPES = createStyleKey("ASSESSMENT_SHOWSTEREOTYPES", MetaKey.SHOWSTEREOTYPES);

    @objid ("9ea3f789-101b-47a3-b99b-c2fe74d05f72")
    static final StyleKey SHOWTAGS = createStyleKey("ASSESSMENT_SHOWTAGS", MetaKey.SHOWTAGS);

}
