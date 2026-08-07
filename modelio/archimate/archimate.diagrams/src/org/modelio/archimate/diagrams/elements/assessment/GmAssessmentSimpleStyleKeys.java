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
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmAssessment when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("c0ed07e9-d386-4735-93d8-c79770c471ea")
public class GmAssessmentSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0cc6eec7-e69d-4f65-9a45-5c3616cbfdad")
    static final StyleKey REPMODE = GmAssessmentStructuredStyleKeys.REPMODE;

    @objid ("9d20e1fe-7798-47e6-8904-9f1a465cabc9")
    static final StyleKey FILLCOLOR = GmAssessmentStructuredStyleKeys.FILLCOLOR;

    @objid ("0e9b0f20-295f-4c64-b8ad-7033aba373b1")
    static final StyleKey FILLMODE = GmAssessmentStructuredStyleKeys.FILLMODE;

    @objid ("3eecae38-6703-4b21-a296-6758728f6fba")
    static final StyleKey LINECOLOR = GmAssessmentStructuredStyleKeys.LINECOLOR;

    @objid ("78583aa7-9073-4653-b649-920304852977")
    static final StyleKey LINEWIDTH = GmAssessmentStructuredStyleKeys.LINEWIDTH;

    @objid ("a634a312-da08-4d2e-9df7-2526f3a5b6f0")
    static final StyleKey FONT = GmAssessmentStructuredStyleKeys.FONT;

    @objid ("b1fca8a8-6664-42ba-939b-7fb35b621736")
    static final StyleKey TEXTCOLOR = GmAssessmentStructuredStyleKeys.TEXTCOLOR;

    @objid ("59539191-868f-4748-8817-f250556b24a4")
    static final StyleKey SHOWSTEREOTYPES = GmAssessmentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("2527dfd5-05c6-4035-a077-64b75969517a")
    static final StyleKey SHOWTAGS = GmAssessmentStructuredStyleKeys.SHOWTAGS;

}
