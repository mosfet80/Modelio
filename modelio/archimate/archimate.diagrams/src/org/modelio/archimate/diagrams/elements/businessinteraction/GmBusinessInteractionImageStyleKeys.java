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
package org.modelio.archimate.diagrams.elements.businessinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessInteraction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("3626885f-58ce-4b50-8801-35b073431a6c")
public class GmBusinessInteractionImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("1434f347-e6d6-445f-8100-571165b787c1")
    static final StyleKey REPMODE = GmBusinessInteractionStructuredStyleKeys.REPMODE;

    @objid ("c0b7e1fb-0e8f-4117-a78f-69bcb6da34f7")
    static final StyleKey FONT = GmBusinessInteractionStructuredStyleKeys.FONT;

    @objid ("2a245fb7-5e6f-47a0-9f95-29bc0818a833")
    static final StyleKey TEXTCOLOR = GmBusinessInteractionStructuredStyleKeys.TEXTCOLOR;

    @objid ("15600e9d-998f-45e5-b91a-90c6ddc0d7dc")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessInteractionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("548e0a38-df36-4f4b-af10-840a38a190da")
    static final StyleKey SHOWTAGS = GmBusinessInteractionStructuredStyleKeys.SHOWTAGS;

}
