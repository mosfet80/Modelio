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
 * This class provides the StyleKey constants for a GmAssessment when its representation mode is RepresentationMode.IMAGE
 */
@objid ("c30117ad-e1a5-4282-af81-dfc2081247af")
public class GmAssessmentImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e13f74c0-8c20-4357-ba49-957a0f7b832a")
    static final StyleKey REPMODE = GmAssessmentStructuredStyleKeys.REPMODE;

    @objid ("176e5b06-f668-4c8e-aed7-838cab6f8065")
    static final StyleKey FONT = GmAssessmentStructuredStyleKeys.FONT;

    @objid ("4a8980a5-b75e-4fa7-a1f4-abb208fc0eb3")
    static final StyleKey TEXTCOLOR = GmAssessmentStructuredStyleKeys.TEXTCOLOR;

    @objid ("f1212e59-de68-4cc6-9ccc-e0bdb8920878")
    static final StyleKey SHOWSTEREOTYPES = GmAssessmentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("6578fdcb-010c-4a17-a166-7fa117307e61")
    static final StyleKey SHOWTAGS = GmAssessmentStructuredStyleKeys.SHOWTAGS;

}
