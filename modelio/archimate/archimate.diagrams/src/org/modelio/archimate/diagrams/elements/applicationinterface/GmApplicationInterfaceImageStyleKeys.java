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
package org.modelio.archimate.diagrams.elements.applicationinterface;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationInterface when its representation mode is RepresentationMode.IMAGE
 */
@objid ("843667fc-f420-4458-a664-a20f41c4c17b")
public class GmApplicationInterfaceImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("e8b5131c-a597-4dec-9c86-8c3555c8972a")
    static final StyleKey REPMODE = GmApplicationInterfaceStructuredStyleKeys.REPMODE;

    @objid ("7f1c5332-89d6-4bec-9a07-3865578c750d")
    static final StyleKey FONT = GmApplicationInterfaceStructuredStyleKeys.FONT;

    @objid ("32b9f32d-c8cb-411e-b68a-92fa0af50382")
    static final StyleKey TEXTCOLOR = GmApplicationInterfaceStructuredStyleKeys.TEXTCOLOR;

    @objid ("829f722d-4f4e-4afe-97d1-e7483591576c")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationInterfaceStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("a74e1fc9-88bc-4368-a670-16e456c91786")
    static final StyleKey SHOWTAGS = GmApplicationInterfaceStructuredStyleKeys.SHOWTAGS;

}
