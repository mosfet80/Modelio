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
@objid ("74e9cb7c-bdd8-4464-8a58-14c0caa1b656")
public class GmGoalUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f55fd9d6-d065-44de-a13d-05a858406df3")
    static final StyleKey REPMODE = GmGoalStructuredStyleKeys.REPMODE;

    @objid ("b5438fc4-2902-4475-98f9-a7bba43b5e5c")
    static final StyleKey FONT = GmGoalStructuredStyleKeys.FONT;

    @objid ("82dec9b9-4cb8-401c-983c-c7d2431254c0")
    static final StyleKey TEXTCOLOR = GmGoalStructuredStyleKeys.TEXTCOLOR;

    @objid ("440e8ae7-c0c1-4f94-9d5c-507f8443037b")
    static final StyleKey SHOWSTEREOTYPES = GmGoalStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("68025a8e-c356-4415-bbf8-6778538638d7")
    static final StyleKey SHOWTAGS = GmGoalStructuredStyleKeys.SHOWTAGS;

}
