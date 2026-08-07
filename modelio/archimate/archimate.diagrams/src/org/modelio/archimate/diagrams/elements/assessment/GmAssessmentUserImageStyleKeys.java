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
@objid ("a72598c4-5949-41e0-89c5-b3daa689a1e6")
public class GmAssessmentUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("bc2c4f30-127e-4a4e-b221-0525ac39135d")
    static final StyleKey REPMODE = GmAssessmentStructuredStyleKeys.REPMODE;

    @objid ("1672fb33-7381-40ac-aea4-b1e770511e67")
    static final StyleKey FONT = GmAssessmentStructuredStyleKeys.FONT;

    @objid ("abff81bb-70b5-4745-a3bd-28f0cf82b7e5")
    static final StyleKey TEXTCOLOR = GmAssessmentStructuredStyleKeys.TEXTCOLOR;

    @objid ("30bd9ed8-a86e-4165-b0d2-4de8abd14316")
    static final StyleKey SHOWSTEREOTYPES = GmAssessmentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b0843d40-29a9-454e-9d04-50ac60a328a0")
    static final StyleKey SHOWTAGS = GmAssessmentStructuredStyleKeys.SHOWTAGS;

}
