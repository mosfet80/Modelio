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
 * This class provides the StyleKey constants for a GmRequirement when its representation mode is RepresentationMode.IMAGE
 */
@objid ("1f21b0f2-d507-41e9-a1ed-c3343ac07cf2")
public class GmRequirementImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0bb322ed-8ff0-40da-80fa-06b4cd7a0582")
    static final StyleKey REPMODE = GmRequirementStructuredStyleKeys.REPMODE;

    @objid ("ef4e1a50-4bfa-4c16-8478-ebe6e0e83a3e")
    static final StyleKey FONT = GmRequirementStructuredStyleKeys.FONT;

    @objid ("bb9213d9-cbe7-402f-bd10-9d981e26139c")
    static final StyleKey TEXTCOLOR = GmRequirementStructuredStyleKeys.TEXTCOLOR;

    @objid ("114dd620-7590-4469-8216-d1764552a744")
    static final StyleKey SHOWSTEREOTYPES = GmRequirementStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("bb2d4bf7-0b04-495c-999a-df78c5838793")
    static final StyleKey SHOWTAGS = GmRequirementStructuredStyleKeys.SHOWTAGS;

}
