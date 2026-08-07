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
package org.modelio.archimate.diagrams.elements.resource;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmResource when its representation mode is RepresentationMode.IMAGE
 */
@objid ("c1bc7ba8-6be1-4d39-ad8f-c8411f82a02b")
public class GmResourceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("08e9e6eb-03af-42aa-a401-bf4c58e7c05d")
    static final StyleKey REPMODE = GmResourceStructuredStyleKeys.REPMODE;

    @objid ("ba977f8a-9279-444c-9bf5-a150e60a0569")
    static final StyleKey FONT = GmResourceStructuredStyleKeys.FONT;

    @objid ("5f356f1d-ecc3-4ca2-9e3f-a2d11af62c79")
    static final StyleKey TEXTCOLOR = GmResourceStructuredStyleKeys.TEXTCOLOR;

    @objid ("8e78e9ae-ee74-44e6-a4b7-163b8de66849")
    static final StyleKey SHOWSTEREOTYPES = GmResourceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("aff75b7a-813d-430c-a77e-ed17d4ae874a")
    static final StyleKey SHOWTAGS = GmResourceStructuredStyleKeys.SHOWTAGS;

}
