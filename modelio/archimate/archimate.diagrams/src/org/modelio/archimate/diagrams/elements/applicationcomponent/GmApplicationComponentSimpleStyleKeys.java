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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationComponent when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("016186e1-864d-4e25-b20d-f439382fabd8")
public class GmApplicationComponentSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("3e11f48f-ce81-42b2-b1a3-76f752350e9d")
    static final StyleKey REPMODE = GmApplicationComponentStructuredStyleKeys.REPMODE;

    @objid ("4c82bc37-a930-46c3-af4f-9e68e9d2abd3")
    static final StyleKey FILLCOLOR = GmApplicationComponentStructuredStyleKeys.FILLCOLOR;

    @objid ("4d4924be-fe51-4a11-be86-8d6475ca86e3")
    static final StyleKey FILLMODE = GmApplicationComponentStructuredStyleKeys.FILLMODE;

    @objid ("5cde6056-5d24-4533-af50-2498b87853ed")
    static final StyleKey LINECOLOR = GmApplicationComponentStructuredStyleKeys.LINECOLOR;

    @objid ("86663a77-6d8a-4f20-b821-3e7fc952883c")
    static final StyleKey LINEWIDTH = GmApplicationComponentStructuredStyleKeys.LINEWIDTH;

    @objid ("ba7cc5df-64dd-47ed-9013-81123349bd5c")
    static final StyleKey FONT = GmApplicationComponentStructuredStyleKeys.FONT;

    @objid ("e6447496-ccc8-40a8-908a-6c424ad4cf71")
    static final StyleKey TEXTCOLOR = GmApplicationComponentStructuredStyleKeys.TEXTCOLOR;

    @objid ("5c995e7c-6e33-44e1-88a9-c005597235bd")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationComponentStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("dddc9f63-4b42-461d-a1ad-a0b2bd8143ac")
    static final StyleKey SHOWTAGS = GmApplicationComponentStructuredStyleKeys.SHOWTAGS;

}
