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
package org.modelio.archimate.diagrams.elements.node;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmNode when its representation mode is RepresentationMode.IMAGE
 */
@objid ("68018147-0742-4a25-997b-eb42f1674026")
public class GmNodeUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a4591c94-a269-4022-872e-aaa2e311c777")
    static final StyleKey REPMODE = GmNodeStructuredStyleKeys.REPMODE;

    @objid ("82d71494-5b54-473e-8469-a40f89f59989")
    static final StyleKey FONT = GmNodeStructuredStyleKeys.FONT;

    @objid ("6a27bc70-fcc0-4b86-b50d-f064b03a2e4b")
    static final StyleKey TEXTCOLOR = GmNodeStructuredStyleKeys.TEXTCOLOR;

    @objid ("1c7fb34d-38a8-45ee-9023-835558470986")
    static final StyleKey SHOWSTEREOTYPES = GmNodeStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7fe14784-5e35-4ebe-a456-6598d6a9f45b")
    static final StyleKey SHOWTAGS = GmNodeStructuredStyleKeys.SHOWTAGS;

}
