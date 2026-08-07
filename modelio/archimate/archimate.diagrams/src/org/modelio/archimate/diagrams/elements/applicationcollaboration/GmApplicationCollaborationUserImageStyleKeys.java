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
package org.modelio.archimate.diagrams.elements.applicationcollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmApplicationCollaboration when its representation mode is RepresentationMode.IMAGE
 */
@objid ("ccb77a00-387a-4d19-a9c0-4aa908ee45f0")
public class GmApplicationCollaborationUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("f0d70549-8d9e-4d68-814a-94f29489717d")
    static final StyleKey REPMODE = GmApplicationCollaborationStructuredStyleKeys.REPMODE;

    @objid ("3e609718-8c18-4538-8e6a-1e20b6af6e1e")
    static final StyleKey FONT = GmApplicationCollaborationStructuredStyleKeys.FONT;

    @objid ("378b54e0-2287-4327-a6d0-0c6c79cffe89")
    static final StyleKey TEXTCOLOR = GmApplicationCollaborationStructuredStyleKeys.TEXTCOLOR;

    @objid ("bd894dde-9b74-4723-8973-b34c5ce11c62")
    static final StyleKey SHOWSTEREOTYPES = GmApplicationCollaborationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("69334489-9e12-49e8-b3e8-28e02ff1cf25")
    static final StyleKey SHOWTAGS = GmApplicationCollaborationStructuredStyleKeys.SHOWTAGS;

}
