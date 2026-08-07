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
package org.modelio.archimate.diagrams.elements.technologyinteraction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyInteraction when its representation mode is RepresentationMode.IMAGE
 */
@objid ("ba409a05-5539-4d70-b5fa-954436325dbc")
public class GmTechnologyInteractionImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7d071a99-26cd-4b93-a6f9-dc21ac48e41d")
    static final StyleKey REPMODE = GmTechnologyInteractionStructuredStyleKeys.REPMODE;

    @objid ("a3842fd6-68e6-4c85-b93e-256d0d8311df")
    static final StyleKey FONT = GmTechnologyInteractionStructuredStyleKeys.FONT;

    @objid ("c4b76cca-b6d7-4815-af3d-3446f26cc93b")
    static final StyleKey TEXTCOLOR = GmTechnologyInteractionStructuredStyleKeys.TEXTCOLOR;

    @objid ("77d29bae-08f4-443a-a308-afbe327a0148")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyInteractionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("d33c2e88-f85e-43b0-919b-5f7f966be254")
    static final StyleKey SHOWTAGS = GmTechnologyInteractionStructuredStyleKeys.SHOWTAGS;

}
