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
package org.modelio.archimate.diagrams.elements.goal;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmGoal when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("655a78a1-f4b2-42d6-b06a-036c66479fac")
public class GmGoalSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("27394bdb-c53f-45ce-b661-4194fb1b3678")
    static final StyleKey REPMODE = GmGoalStructuredStyleKeys.REPMODE;

    @objid ("92a62267-0621-4db0-9696-105427bfbd59")
    static final StyleKey FILLCOLOR = GmGoalStructuredStyleKeys.FILLCOLOR;

    @objid ("b6605b8f-6813-45cf-98ff-fc13334dd344")
    static final StyleKey FILLMODE = GmGoalStructuredStyleKeys.FILLMODE;

    @objid ("972c7d8e-effa-49e1-ac19-b147fe06e3f7")
    static final StyleKey LINECOLOR = GmGoalStructuredStyleKeys.LINECOLOR;

    @objid ("63b06975-fe24-4c82-9321-e632e262ba05")
    static final StyleKey LINEWIDTH = GmGoalStructuredStyleKeys.LINEWIDTH;

    @objid ("9b464c01-c6d4-4fc1-ae0d-136f9f6631b1")
    static final StyleKey FONT = GmGoalStructuredStyleKeys.FONT;

    @objid ("b38d7988-c691-48f0-bb84-76974edc428a")
    static final StyleKey TEXTCOLOR = GmGoalStructuredStyleKeys.TEXTCOLOR;

    @objid ("ec0c6b2a-8156-4dc1-bbbd-4d60c1de7cd8")
    static final StyleKey SHOWSTEREOTYPES = GmGoalStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("d4646a13-29ea-4564-a917-60a266168be5")
    static final StyleKey SHOWTAGS = GmGoalStructuredStyleKeys.SHOWTAGS;

}
