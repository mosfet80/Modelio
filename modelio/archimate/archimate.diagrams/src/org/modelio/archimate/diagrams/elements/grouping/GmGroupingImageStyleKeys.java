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
@objid ("71786b7d-4bf2-468d-8981-2ef45feeccd8")
public class GmGroupingImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("94cff8a9-2299-45c3-a207-e3c264e51639")
    static final StyleKey REPMODE = GmGroupingStructuredStyleKeys.REPMODE;

    @objid ("e0d0a9e7-ab0c-4567-9161-137b471369e6")
    static final StyleKey FONT = GmGroupingStructuredStyleKeys.FONT;

    @objid ("fc6ee45e-4c2b-4e94-bb9c-0f5281c9d5ee")
    static final StyleKey TEXTCOLOR = GmGroupingStructuredStyleKeys.TEXTCOLOR;

    @objid ("039469ae-5e26-47e9-a702-d6581aa20b64")
    static final StyleKey SHOWSTEREOTYPES = GmGroupingStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("23eb96d2-f858-49ed-a1bc-3a382bed7fd6")
    static final StyleKey SHOWTAGS = GmGroupingStructuredStyleKeys.SHOWTAGS;

}
