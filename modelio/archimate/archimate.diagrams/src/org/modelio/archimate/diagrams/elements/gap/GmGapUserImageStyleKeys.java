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
package org.modelio.archimate.diagrams.elements.gap;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmGap when its representation mode is RepresentationMode.IMAGE
 */
@objid ("e696c00b-86ba-4efa-b11f-7de7fcdc94e9")
public class GmGapUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("fe1852ca-86a4-42a2-aaa8-1c1e70d4def3")
    static final StyleKey REPMODE = GmGapStructuredStyleKeys.REPMODE;

    @objid ("3b0c39cd-b440-4413-bdd6-4e5c7712c629")
    static final StyleKey FONT = GmGapStructuredStyleKeys.FONT;

    @objid ("afe1c28b-9bfb-4ec3-86af-03e47700660e")
    static final StyleKey TEXTCOLOR = GmGapStructuredStyleKeys.TEXTCOLOR;

    @objid ("bb25a510-ce0a-46c3-bea4-3129dd8cd795")
    static final StyleKey SHOWSTEREOTYPES = GmGapStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7a457284-bd4c-491e-af68-65a2cc8f59bc")
    static final StyleKey SHOWTAGS = GmGapStructuredStyleKeys.SHOWTAGS;

}
