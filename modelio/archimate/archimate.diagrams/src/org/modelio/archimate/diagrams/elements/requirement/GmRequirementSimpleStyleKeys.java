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
package org.modelio.archimate.diagrams.elements.requirement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmRequirement when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("aa3d2ad6-16e8-4b82-8902-5f50b28f0a9e")
public class GmRequirementSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("28720269-ce7d-4ed8-8877-bdc9a77a3e4b")
    static final StyleKey REPMODE = GmRequirementStructuredStyleKeys.REPMODE;

    @objid ("4124f8ec-1ada-427d-8948-92e4a71dccfb")
    static final StyleKey FILLCOLOR = GmRequirementStructuredStyleKeys.FILLCOLOR;

    @objid ("d3a3842e-a575-408a-93a0-bd34f2497f25")
    static final StyleKey FILLMODE = GmRequirementStructuredStyleKeys.FILLMODE;

    @objid ("dadf4d32-257b-42e2-b581-6243da3201dd")
    static final StyleKey LINECOLOR = GmRequirementStructuredStyleKeys.LINECOLOR;

    @objid ("814e0310-162b-4a5f-a9ff-5affa7aca6ca")
    static final StyleKey LINEWIDTH = GmRequirementStructuredStyleKeys.LINEWIDTH;

    @objid ("fabd7e87-ec62-40ae-a3df-3bfd3806702a")
    static final StyleKey FONT = GmRequirementStructuredStyleKeys.FONT;

    @objid ("3a0eb405-8942-4202-b7cb-f108b7c96366")
    static final StyleKey TEXTCOLOR = GmRequirementStructuredStyleKeys.TEXTCOLOR;

    @objid ("07b4d881-342d-443b-b5f8-d865df6e2191")
    static final StyleKey SHOWSTEREOTYPES = GmRequirementStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("6701e14a-cc0a-4bf7-a7e9-d91b7a958df7")
    static final StyleKey SHOWTAGS = GmRequirementStructuredStyleKeys.SHOWTAGS;

}
