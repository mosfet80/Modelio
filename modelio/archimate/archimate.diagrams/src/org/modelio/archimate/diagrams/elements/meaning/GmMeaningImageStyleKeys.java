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
package org.modelio.archimate.diagrams.elements.meaning;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

/**
 * This class provides the StyleKey constants for a GmMeaning when its representation mode is {@link RepresentationMode#IMAGE}.
 */
@objid ("f91c6e95-41c3-4fae-861a-c3e425978bc0")
public class GmMeaningImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("6b58f9ef-c11f-4176-8f60-7ae6f49cfdc2")
    static final StyleKey REPMODE = GmMeaningStructuredStyleKeys.REPMODE;

    @objid ("3fe93a3b-f0cd-4694-b551-223e154d454d")
    static final StyleKey FONT = GmMeaningStructuredStyleKeys.FONT;

    @objid ("92343bfe-edc2-4c29-ac08-1521f68404cc")
    static final StyleKey TEXTCOLOR = GmMeaningStructuredStyleKeys.TEXTCOLOR;

    @objid ("48d6c7f3-63b5-467b-97dc-afb9bff6ea6a")
    static final StyleKey SHOWSTEREOTYPES = GmMeaningStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("edc4f0cb-fc42-481b-879c-22eaffa29f78")
    static final StyleKey SHOWTAGS = GmMeaningStructuredStyleKeys.SHOWTAGS;

}
