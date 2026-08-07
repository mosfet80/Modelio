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
package org.modelio.archimate.diagrams.elements.grouping;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmGrouping when its representation mode is RepresentationMode.IMAGE
 */
@objid ("a8ffa696-5ef2-4e79-82a9-9f2f74dcfc5f")
public class GmGroupingUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f6a626b8-3a01-475f-91af-a221724d4684")
    static final StyleKey REPMODE = GmGroupingStructuredStyleKeys.REPMODE;

    @objid ("ff79291e-c035-4582-938a-e4b4c233403c")
    static final StyleKey FONT = GmGroupingStructuredStyleKeys.FONT;

    @objid ("3e616a0a-613a-45e9-8763-a166c2bac226")
    static final StyleKey TEXTCOLOR = GmGroupingStructuredStyleKeys.TEXTCOLOR;

    @objid ("f3fda9a8-74e4-4567-b889-3f86e8771ffe")
    static final StyleKey SHOWSTEREOTYPES = GmGroupingStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("b084f5d8-3089-4a69-afb5-891a8cda233c")
    static final StyleKey SHOWTAGS = GmGroupingStructuredStyleKeys.SHOWTAGS;

}
