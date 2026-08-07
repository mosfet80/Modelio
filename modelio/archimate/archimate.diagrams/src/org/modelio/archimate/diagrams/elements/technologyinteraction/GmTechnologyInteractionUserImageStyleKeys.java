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
@objid ("6a2f3bdf-53d6-4f58-a233-f15c634a33af")
public class GmTechnologyInteractionUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("7624f80d-6e13-43b3-bc78-a728773cfde9")
    static final StyleKey REPMODE = GmTechnologyInteractionStructuredStyleKeys.REPMODE;

    @objid ("df9a0e12-a5b4-40b3-9021-7f5145d1724a")
    static final StyleKey FONT = GmTechnologyInteractionStructuredStyleKeys.FONT;

    @objid ("0341ade2-7d4a-4585-a9f5-5cbc353a733f")
    static final StyleKey TEXTCOLOR = GmTechnologyInteractionStructuredStyleKeys.TEXTCOLOR;

    @objid ("061f6c36-b7a4-40c5-9ca0-e51e4de03a7a")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyInteractionStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("cd56fda8-6367-4801-aa63-36d8a7f2b0f1")
    static final StyleKey SHOWTAGS = GmTechnologyInteractionStructuredStyleKeys.SHOWTAGS;

}
