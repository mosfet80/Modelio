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
package org.modelio.archimate.diagrams.elements.product;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmProduct when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("28e6a324-0456-4bfb-a29e-c93adaf496a6")
public class GmProductSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("28b17a23-b9fa-4fbd-b800-26d2cf597103")
    static final StyleKey REPMODE = GmProductStructuredStyleKeys.REPMODE;

    @objid ("aad21adb-d8e0-456b-9a61-c62ea748df6c")
    static final StyleKey FILLCOLOR = GmProductStructuredStyleKeys.FILLCOLOR;

    @objid ("1e9a0228-0b8c-4dd4-855f-7128f375a275")
    static final StyleKey FILLMODE = GmProductStructuredStyleKeys.FILLMODE;

    @objid ("3761d060-f684-44de-933f-4331bff4e5b3")
    static final StyleKey LINECOLOR = GmProductStructuredStyleKeys.LINECOLOR;

    @objid ("5a7743e4-0a28-4c6e-b7ed-2d33ed958c3b")
    static final StyleKey LINEWIDTH = GmProductStructuredStyleKeys.LINEWIDTH;

    @objid ("1dffa5d9-a97d-4bd1-a349-fd3c874efbd0")
    static final StyleKey FONT = GmProductStructuredStyleKeys.FONT;

    @objid ("4193c467-82fe-49e1-9aff-79eb1ba78f35")
    static final StyleKey TEXTCOLOR = GmProductStructuredStyleKeys.TEXTCOLOR;

    @objid ("fb8c2d6b-9cf9-45a9-a113-8f477faffd4c")
    static final StyleKey SHOWSTEREOTYPES = GmProductStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("65fa7efe-61f4-4d35-b738-27e3de02d7a8")
    static final StyleKey SHOWTAGS = GmProductStructuredStyleKeys.SHOWTAGS;

}
