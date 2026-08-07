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
 * This class provides the StyleKey constants for a GmGoal when its representation mode is RepresentationMode.IMAGE
 */
@objid ("7f43568e-a4ab-4cbd-8534-eb27ccd55601")
public class GmGoalImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("534dfbc8-19cc-4462-9f40-1baa59ecec50")
    static final StyleKey REPMODE = GmGoalStructuredStyleKeys.REPMODE;

    @objid ("77a00963-a877-4547-a74c-8056c45ecbca")
    static final StyleKey FONT = GmGoalStructuredStyleKeys.FONT;

    @objid ("a44ca11f-f0ec-4b76-93b4-fffaba380e17")
    static final StyleKey TEXTCOLOR = GmGoalStructuredStyleKeys.TEXTCOLOR;

    @objid ("c9919392-20fb-4474-8c23-71696db47c32")
    static final StyleKey SHOWSTEREOTYPES = GmGoalStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("197f1d6c-c9cc-4a2b-9b8c-afc18da0f722")
    static final StyleKey SHOWTAGS = GmGoalStructuredStyleKeys.SHOWTAGS;

}
