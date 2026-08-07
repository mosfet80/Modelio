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
package org.modelio.archimate.diagrams.elements.principle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;
import org.modelio.diagram.styles.core.StyleKey.RepresentationMode;

/**
 * This class provides the StyleKey constants for a GmPrinciple when its representation mode is {@link RepresentationMode#SIMPLE}.
 */
@objid ("7c45a5fd-eff3-4f4d-ad8f-c1cf5b64e8f1")
public class GmPrincipleSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("11f4c487-fc3e-4e60-a805-e90846400cbf")
    static final StyleKey REPMODE = GmPrincipleStructuredStyleKeys.REPMODE;

    @objid ("ef211f16-ebf0-49dd-8c81-684668417166")
    static final StyleKey FILLCOLOR = GmPrincipleStructuredStyleKeys.FILLCOLOR;

    @objid ("d6a16235-2ad4-4092-9671-03893bcb0f43")
    static final StyleKey FILLMODE = GmPrincipleStructuredStyleKeys.FILLMODE;

    @objid ("14e5eb4b-6dbb-426e-9438-1b4ee95a9191")
    static final StyleKey LINECOLOR = GmPrincipleStructuredStyleKeys.LINECOLOR;

    @objid ("68b0bd77-1c5d-438a-8bb3-27586a036272")
    static final StyleKey LINEWIDTH = GmPrincipleStructuredStyleKeys.LINEWIDTH;

    @objid ("c2bd3679-bf72-499f-8d41-4de91372cdb8")
    static final StyleKey FONT = GmPrincipleStructuredStyleKeys.FONT;

    @objid ("b3d1cedb-789a-4793-b371-081246a3c7fa")
    static final StyleKey TEXTCOLOR = GmPrincipleStructuredStyleKeys.TEXTCOLOR;

    @objid ("889aba20-80c5-4498-9ff2-06fa6c151b8a")
    static final StyleKey SHOWSTEREOTYPES = GmPrincipleStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("124fc11b-5214-4ffc-a35d-f6c95927001b")
    static final StyleKey SHOWTAGS = GmPrincipleStructuredStyleKeys.SHOWTAGS;

}
