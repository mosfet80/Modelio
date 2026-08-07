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
@objid ("533c2f44-efb8-4b2e-b2c0-3fda58ae7e6f")
public class GmMaterialImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a17196a9-6af3-49ea-8840-6be5b58d7f07")
    static final StyleKey REPMODE = GmMaterialStructuredStyleKeys.REPMODE;

    @objid ("4f94fde5-2a7b-41cc-9b57-35b9d5938aa8")
    static final StyleKey FONT = GmMaterialStructuredStyleKeys.FONT;

    @objid ("d46a137e-f482-4f0c-a7e2-3b1778d0d94e")
    static final StyleKey TEXTCOLOR = GmMaterialStructuredStyleKeys.TEXTCOLOR;

    @objid ("4be46a85-6c11-4125-9068-21e3aa6907c1")
    static final StyleKey SHOWSTEREOTYPES = GmMaterialStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c6e270ea-b206-4549-90c0-3d2f81a4da9f")
    static final StyleKey SHOWTAGS = GmMaterialStructuredStyleKeys.SHOWTAGS;

}
