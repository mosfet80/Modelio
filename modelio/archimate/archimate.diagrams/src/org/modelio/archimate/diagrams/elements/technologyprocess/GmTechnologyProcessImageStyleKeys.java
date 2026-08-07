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
@objid ("a021a128-9e92-497a-9a58-d44669a364b0")
public class GmTechnologyProcessImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c39b8409-138b-473f-bab3-ea3108249133")
    static final StyleKey REPMODE = GmTechnologyProcessStructuredStyleKeys.REPMODE;

    @objid ("e00ecf22-fbc8-436b-99fa-b764414ce188")
    static final StyleKey FONT = GmTechnologyProcessStructuredStyleKeys.FONT;

    @objid ("d1f2c2df-decd-4ce8-8389-e401e7c304fa")
    static final StyleKey TEXTCOLOR = GmTechnologyProcessStructuredStyleKeys.TEXTCOLOR;

    @objid ("b639d7b1-efc1-4892-b193-9a2935c83126")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyProcessStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("23fa76e2-53b7-4cf8-8b15-ffa99a3d5e43")
    static final StyleKey SHOWTAGS = GmTechnologyProcessStructuredStyleKeys.SHOWTAGS;

}
