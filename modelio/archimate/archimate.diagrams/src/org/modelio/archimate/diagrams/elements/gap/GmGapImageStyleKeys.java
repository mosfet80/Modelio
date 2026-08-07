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
@objid ("a145d4fe-fec1-4355-97bb-e581c55c4e30")
public class GmGapImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7a744c81-b5b5-4503-98ee-b66ba1ab089b")
    static final StyleKey REPMODE = GmGapStructuredStyleKeys.REPMODE;

    @objid ("2403009d-c715-468a-9c93-5bd1e7c676cf")
    static final StyleKey FONT = GmGapStructuredStyleKeys.FONT;

    @objid ("b53d0697-802c-4d05-b71b-5b55f1dcc7de")
    static final StyleKey TEXTCOLOR = GmGapStructuredStyleKeys.TEXTCOLOR;

    @objid ("d4cfb684-61e3-4bd8-b582-cd3ba7d350d4")
    static final StyleKey SHOWSTEREOTYPES = GmGapStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("05783793-dac1-43ce-ae09-cce36359bc4d")
    static final StyleKey SHOWTAGS = GmGapStructuredStyleKeys.SHOWTAGS;

}
