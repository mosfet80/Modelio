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
 * This class provides the StyleKey constants for a GmMeaning when its representation mode is {@link RepresentationMode#SIMPLE}
 */
@objid ("021ce6ac-5249-4490-8015-6ccf9ad4e8bd")
public class GmMeaningSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("491a2305-9c77-46b6-9f60-52ca4e46d531")
    static final StyleKey REPMODE = GmMeaningStructuredStyleKeys.REPMODE;

    @objid ("5541e372-32de-4307-8206-bbcdb58a8619")
    static final StyleKey FILLCOLOR = GmMeaningStructuredStyleKeys.FILLCOLOR;

    @objid ("7c48f7fc-de70-4a45-9663-ccc00ce1ed59")
    static final StyleKey FILLMODE = GmMeaningStructuredStyleKeys.FILLMODE;

    @objid ("81386ed3-9a24-4cbd-9320-c51eef082630")
    static final StyleKey LINECOLOR = GmMeaningStructuredStyleKeys.LINECOLOR;

    @objid ("601a7f23-e23c-4a95-b922-e115641ed4f5")
    static final StyleKey LINEWIDTH = GmMeaningStructuredStyleKeys.LINEWIDTH;

    @objid ("81c0acef-c882-4369-87a9-eb1f4bebbf2f")
    static final StyleKey FONT = GmMeaningStructuredStyleKeys.FONT;

    @objid ("c72c7d44-636b-4884-9675-f02eeb04ddb7")
    static final StyleKey TEXTCOLOR = GmMeaningStructuredStyleKeys.TEXTCOLOR;

    @objid ("00bb6e76-b9da-49d6-a79a-4a94ff512273")
    static final StyleKey SHOWSTEREOTYPES = GmMeaningStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7a72c26c-cb2d-4fab-a758-fe1e8b2be45d")
    static final StyleKey SHOWTAGS = GmMeaningStructuredStyleKeys.SHOWTAGS;

}
