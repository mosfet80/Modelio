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
@objid ("b269c32e-9840-4917-9fbb-bd7ae76e2900")
public class GmBusinessCollaborationImageStyleKeys extends ArchimateAbstractStyleKeyProvider {
    @objid ("c2c09374-cdaa-4d5c-9a77-432d1708f4aa")
    static final StyleKey REPMODE = GmBusinessCollaborationStructuredStyleKeys.REPMODE;

    @objid ("0c2d7bd5-da7d-40a7-be49-2edd986a57aa")
    static final StyleKey FONT = GmBusinessCollaborationStructuredStyleKeys.FONT;

    @objid ("ab0169e8-7aed-4cdd-bcdc-423111b0e27d")
    static final StyleKey TEXTCOLOR = GmBusinessCollaborationStructuredStyleKeys.TEXTCOLOR;

    @objid ("cf53622a-6d8f-46bb-96a6-fcb07d70e408")
    static final StyleKey SHOWSTEREOTYPES = GmBusinessCollaborationStructuredStyleKeys.SHOWSTEREOTYPES;

    @objid ("fc819c63-16a4-4076-8b45-bb8902a0f4c8")
    static final StyleKey SHOWTAGS = GmBusinessCollaborationStructuredStyleKeys.SHOWTAGS;

}
