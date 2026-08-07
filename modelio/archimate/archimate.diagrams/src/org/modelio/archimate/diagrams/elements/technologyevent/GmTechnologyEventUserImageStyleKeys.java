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
package org.modelio.archimate.diagrams.elements.technologyevent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyEvent when its representation mode is RepresentationMode.IMAGE
 */
@objid ("7f351626-3040-4d14-8f9a-81ebf516bda7")
public class GmTechnologyEventUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("0d342fc7-5e54-4609-9349-b9f658e98eff")
    static final StyleKey REPMODE = GmTechnologyEventStructuredStyleKeys.REPMODE;

    @objid ("ad035d36-636f-4161-8b09-cb5bf2945018")
    static final StyleKey FONT = GmTechnologyEventStructuredStyleKeys.FONT;

    @objid ("6acde9f0-72a8-41a6-ae3f-ec1f5917a9f7")
    static final StyleKey TEXTCOLOR = GmTechnologyEventStructuredStyleKeys.TEXTCOLOR;

    @objid ("67a0f432-daf2-4cbf-86cf-9fa0b5044db6")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyEventStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("825eaa6b-5a0b-4a7d-9851-ff12ed24cffb")
    static final StyleKey SHOWTAGS = GmTechnologyEventStructuredStyleKeys.SHOWTAGS;

}
