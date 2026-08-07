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
package org.modelio.archimate.diagrams.elements.representation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmRepresentation when its representation mode is RepresentationMode.IMAGE
 */
@objid ("126a09e9-bf98-4501-b9d4-f14908534304")
public class GmRepresentationImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("1e78d4c2-25f9-475a-bca9-1f8be76a1466")
    static final StyleKey REPMODE = GmRepresentationStructuredStyleKeys.REPMODE;

    @objid ("ac965e13-61ae-4859-97b0-5f0c4f595582")
    static final StyleKey FONT = GmRepresentationStructuredStyleKeys.FONT;

    @objid ("11554510-d94e-4990-8b3f-4f0fe32604a3")
    static final StyleKey TEXTCOLOR = GmRepresentationStructuredStyleKeys.TEXTCOLOR;

    @objid ("e216e3b7-36bc-4e1f-89b8-c6ffb5a4c63b")
    static final StyleKey SHOWSTEREOTYPES = GmRepresentationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("2c3ca7ff-4c5c-4184-9210-147b400e1c32")
    static final StyleKey SHOWTAGS = GmRepresentationStructuredStyleKeys.SHOWTAGS;

}
