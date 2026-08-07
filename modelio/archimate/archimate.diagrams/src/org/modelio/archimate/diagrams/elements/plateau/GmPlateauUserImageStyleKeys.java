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
package org.modelio.archimate.diagrams.elements.plateau;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmPlateau when its representation mode is RepresentationMode.IMAGE
 */
@objid ("f67c659f-dcf2-4272-9cc2-16d1cb742341")
public class GmPlateauUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("974321e6-4060-4ceb-b373-fa915dd75088")
    static final StyleKey REPMODE = GmPlateauStructuredStyleKeys.REPMODE;

    @objid ("6d9f7cd5-8e43-4e1b-a31f-e2b5e748f274")
    static final StyleKey FONT = GmPlateauStructuredStyleKeys.FONT;

    @objid ("7652f2e8-af4c-4cfa-8558-286343ea604b")
    static final StyleKey TEXTCOLOR = GmPlateauStructuredStyleKeys.TEXTCOLOR;

    @objid ("a5bcf884-fdfd-4aa5-a15f-f4d74aeed63c")
    static final StyleKey SHOWSTEREOTYPES = GmPlateauStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("c298a47f-d3c0-4ddd-8936-4ba5991e207f")
    static final StyleKey SHOWTAGS = GmPlateauStructuredStyleKeys.SHOWTAGS;

}
