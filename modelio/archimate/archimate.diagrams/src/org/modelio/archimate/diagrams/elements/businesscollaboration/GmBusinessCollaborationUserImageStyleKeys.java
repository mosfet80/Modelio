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
package org.modelio.archimate.diagrams.elements.businesscollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmBusinessCollaboration when its representation mode is RepresentationMode.IMAGE
 */
@objid ("1c204125-36bf-416c-9db6-a5682d1a6925")
public class GmBusinessCollaborationUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("64aea8e9-ded8-464a-acbb-c671fbd1ce38")
    static final StyleKey REPMODE = GmBusinessCollaborationStructuredStyleKeys.REPMODE;

    @objid ("b142e7c9-74dd-4100-ae51-cec7dabe9206")
    static final StyleKey FONT = GmBusinessCollaborationStructuredStyleKeys.FONT;

    @objid ("d821a5d0-58af-4709-a071-06d7693baf76")
    static final StyleKey TEXTCOLOR = GmBusinessCollaborationStructuredStyleKeys.TEXTCOLOR;

    @objid ("835ff880-b520-495c-9f2d-f008edf191c1")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessCollaborationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("23892f54-cce9-4d10-afd6-d021e75b4d0f")
    static final StyleKey SHOWTAGS = GmBusinessCollaborationStructuredStyleKeys.SHOWTAGS;

}
