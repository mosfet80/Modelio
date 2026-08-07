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
package org.modelio.archimate.diagrams.elements.technologycollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.style.ArchimateAbstractStyleKeyProvider;
import org.modelio.diagram.styles.core.StyleKey;

/**
 * This class provides the StyleKey constants for a GmTechnologyCollaboration when its representation mode is RepresentationMode.IMAGE
 */
@objid ("2e09d9a1-18c2-4398-871a-72aed4924711")
public class GmTechnologyCollaborationUserImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("4af32ab0-45d2-440a-8f5a-2326821cf846")
    static final StyleKey REPMODE = GmTechnologyCollaborationStructuredStyleKeys.REPMODE;

    @objid ("044968d3-a39d-4781-9216-34d77cacd5b8")
    static final StyleKey FONT = GmTechnologyCollaborationStructuredStyleKeys.FONT;

    @objid ("5f074e54-93eb-4780-8e41-ec6a2acd1c80")
    static final StyleKey TEXTCOLOR = GmTechnologyCollaborationStructuredStyleKeys.TEXTCOLOR;

    @objid ("59575e0a-20b8-4f74-932f-bc9269917890")
    static final StyleKey SHOWSTEREOTYPES = GmTechnologyCollaborationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("7f5df5ff-bb86-40c8-b60d-bf25bbc35e20")
    static final StyleKey SHOWTAGS = GmTechnologyCollaborationStructuredStyleKeys.SHOWTAGS;

}
