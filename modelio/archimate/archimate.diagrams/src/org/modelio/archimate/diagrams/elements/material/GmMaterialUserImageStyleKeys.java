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
package org.modelio.archimate.diagrams.elements.material;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmMaterial when its representation mode is RepresentationMode.IMAGE
 */
@objid ("0e8c7c30-ab27-4e98-85b9-8623099ba562")
public class GmMaterialUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("d26c8f25-090f-4abb-87b7-650e1d1c11c5")
    static final StyleKey REPMODE = GmMaterialStructuredStyleKeys.REPMODE;

    @objid ("947c9df5-d965-4174-80bb-80601f5b2c67")
    static final StyleKey FONT = GmMaterialStructuredStyleKeys.FONT;

    @objid ("a10f8df8-2bd6-44e5-a513-730a184ca002")
    static final StyleKey TEXTCOLOR = GmMaterialStructuredStyleKeys.TEXTCOLOR;

    @objid ("3f04bf0e-9520-405a-8ac7-2288e06ec539")
    static final StyleKey SHOWSTEREOTYPES = GmMaterialStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("acaad7a1-6190-4da4-a321-bb7380f18381")
    static final StyleKey SHOWTAGS = GmMaterialStructuredStyleKeys.SHOWTAGS;

}
