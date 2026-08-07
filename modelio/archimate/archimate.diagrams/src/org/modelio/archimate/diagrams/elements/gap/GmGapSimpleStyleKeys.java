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
 * This class provides the StyleKey constants for a GmGap when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("77127e1f-d669-47a4-b445-aa744d4f1543")
public class GmGapSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("ebe641f8-4f01-44d6-9ee9-064f04c6fafb")
    static final StyleKey REPMODE = GmGapStructuredStyleKeys.REPMODE;

    @objid ("e8662fd4-afb4-4216-a301-1e51a2ce7c86")
    static final StyleKey FILLCOLOR = GmGapStructuredStyleKeys.FILLCOLOR;

    @objid ("8d0779ab-9300-4047-bd49-69cbff72b3ce")
    static final StyleKey FILLMODE = GmGapStructuredStyleKeys.FILLMODE;

    @objid ("bf6e47fe-ffb3-4ee0-8ba1-39c30b931393")
    static final StyleKey LINECOLOR = GmGapStructuredStyleKeys.LINECOLOR;

    @objid ("f767c94d-85a4-4637-bdb5-81ae147dfb3a")
    static final StyleKey LINEWIDTH = GmGapStructuredStyleKeys.LINEWIDTH;

    @objid ("2fa905d6-72e8-48c5-95f1-477972554482")
    static final StyleKey FONT = GmGapStructuredStyleKeys.FONT;

    @objid ("2e512479-122b-4fd6-a919-3fb93f739b55")
    static final StyleKey TEXTCOLOR = GmGapStructuredStyleKeys.TEXTCOLOR;

    @objid ("3fbfaca7-efdf-43f4-baec-7506c5fcba8c")
    static final StyleKey SHOWSTEREOTYPES = GmGapStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("378a3830-10f5-413b-9fb4-ea312dbdbc61")
    static final StyleKey SHOWTAGS = GmGapStructuredStyleKeys.SHOWTAGS;

}
