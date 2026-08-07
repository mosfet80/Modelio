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
package org.modelio.archimate.diagrams.elements.technologyprocess;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyProcess when its representation mode is RepresentationMode.IMAGE
 */
@objid ("da0f053b-84b1-4ab1-9167-0a8d6b851651")
public class GmTechnologyProcessUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f11ea004-d204-4c29-afd8-3c1de4eb9e71")
    static final StyleKey REPMODE = GmTechnologyProcessStructuredStyleKeys.REPMODE;

    @objid ("07eaca0d-3888-4888-9fb0-ac01753eecc8")
    static final StyleKey FONT = GmTechnologyProcessStructuredStyleKeys.FONT;

    @objid ("22650986-567d-4127-b8d0-7093a055d39b")
    static final StyleKey TEXTCOLOR = GmTechnologyProcessStructuredStyleKeys.TEXTCOLOR;

    @objid ("fcb111b5-c540-4686-892f-11089f4f3b10")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyProcessStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("a095d7d5-0718-469b-9a52-a0d0b48c6ea0")
    static final StyleKey SHOWTAGS = GmTechnologyProcessStructuredStyleKeys.SHOWTAGS;

}
