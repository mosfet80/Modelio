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
 * This class provides the StyleKey constants for a GmRepresentation when its representation mode is RepresentationMode.SIMPLE
 */
@objid ("c09867ef-4a93-4f8a-a883-fa0a01fecb7d")
public class GmRepresentationSimpleStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("a44c93da-cd97-4422-924f-f47198bebf6b")
    static final StyleKey REPMODE = GmRepresentationStructuredStyleKeys.REPMODE;

    @objid ("0120d8ab-9829-4a21-a8bb-37847783a491")
    static final StyleKey FILLCOLOR = GmRepresentationStructuredStyleKeys.FILLCOLOR;

    @objid ("d1fc1533-7d30-48d4-b09d-5f14681a1b4d")
    static final StyleKey FILLMODE = GmRepresentationStructuredStyleKeys.FILLMODE;

    @objid ("824a6b79-b764-421a-a896-cc779c6cfc43")
    static final StyleKey LINECOLOR = GmRepresentationStructuredStyleKeys.LINECOLOR;

    @objid ("27d04729-0a4d-4084-8d5b-068d1c80af2f")
    static final StyleKey LINEWIDTH = GmRepresentationStructuredStyleKeys.LINEWIDTH;

    @objid ("8f5703e2-31d7-42a7-a96f-1117368fea14")
    static final StyleKey FONT = GmRepresentationStructuredStyleKeys.FONT;

    @objid ("1d5ba623-8163-4861-a7cc-5126acfa8f18")
    static final StyleKey TEXTCOLOR = GmRepresentationStructuredStyleKeys.TEXTCOLOR;

    @objid ("27628e66-7e8f-484e-98ba-9c66854e8b6c")
    static final StyleKey SHOWSTEREOTYPES = GmRepresentationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("92fa7551-d035-42be-9aac-3677e9bc191d")
    static final StyleKey SHOWTAGS = GmRepresentationStructuredStyleKeys.SHOWTAGS;

}
